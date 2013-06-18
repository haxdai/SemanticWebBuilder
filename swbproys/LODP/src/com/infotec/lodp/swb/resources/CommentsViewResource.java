/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Comment;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.Developer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author rene.jara
 */
public class CommentsViewResource extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(CommentsViewResource.class);
    /** Accion personalizada para comentar    */
    public static final String Action_COMMENT="com";
    /** Accion personalizada para marcar un comentario inapropiado    */
    public static final String Action_INAPPROPRIATE="inp";

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebPage wpage = response.getWebPage();
        WebSite wsite = wpage.getWebSite();
        Resource base = getResourceBase();
        User usr = response.getUser();
        UserRepository ur = wsite.getUserRepository();
        String suri =request.getParameter("suri");
        String url =wpage.getUrl();
        String npag =request.getParameter("npag");
        int nInappropriate=0;
        try{
            nInappropriate=Integer.parseInt(base.getAttribute("inappropriate", "1"));
            if(nInappropriate<1){
                nInappropriate=1;
            }
        }catch(NumberFormatException ignored){
            nInappropriate=1;
        }
        if (Action_COMMENT.equals(action)) {
            String name = null;
            String email = null;
            String strComment = null;
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = null;
            Comment comment = null;
            gobj = usr.getSemanticObject().getGenericInstance();
            if (gobj instanceof Developer) {
                Developer developer = (Developer) gobj;
                name = developer.getFullName();
                email = developer.getEmail();
            } else {
                name = request.getParameter("name");
                email = request.getParameter("email");
            }
            strComment=SWBUtils.XML.replaceXMLChars(request.getParameter("comment"));
            String securCodeSent = request.getParameter("cmnt_seccode");
            String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
            if (name != null && !name.equals("")
                    && email != null && !name.equals("")
                    && strComment != null && !strComment.equals("")
                    && securCodeCreated!=null && securCodeSent!=null && securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                comment = Comment.ClassMgr.createComment(wsite);                
                comment.setCommUserName(name);
                comment.setCommUserEmail(email);
                comment.setComment(strComment);
                comment.setApproved(true);
                comment.setReviewed(false);
                comment.setInappropriate(0);
                if (hasDirtyWords(strComment)){
                    comment.setApproved(false);
                }
            }
            if (suri != null && !suri.equals("") && comment!= null) {
                gobj = ont.getGenericObject(SemanticObject.shortToFullURI(suri));
                if (gobj != null && gobj instanceof Application) {
                    Application ap = (Application) gobj;
                    ap.addComment(comment);
                } else if (gobj != null && gobj instanceof Dataset) {
                    Dataset ds = (Dataset) gobj;
                    ds.addComment(comment);
                } 
            }
            url+="?act=detail";
            if(suri!=null&&!suri.equals("")){
                url+="&suri="+suri;
            }
            if(npag!=null&&!npag.equals("")){
                url+="&npag="+npag;
            }
            response.sendRedirect(url);
        }else if(Action_INAPPROPRIATE.equals(action)) {
            String cid=request.getParameter("cid");
            boolean canRank=false;
            List lii=(List)request.getSession().getAttribute("io");
            if(lii==null){
                lii =new ArrayList();
                lii.add(cid);
                canRank=true;
            }else{
                if(!lii.contains(cid)){
                    lii.add(cid);
                    canRank=true;
                }
            }
            if(cid!=null&&!cid.equals("")&&canRank){
                Comment comment=Comment.ClassMgr.getComment(cid,wsite);
                comment.setInappropriate(comment.getInappropriate()+1);
System.out.println("****");
System.out.println(comment.getInappropriate());
System.out.println(nInappropriate);
System.out.println(comment.isReviewed());
                if(comment.getInappropriate()>=nInappropriate&&!comment.isReviewed()){
System.out.println(":s");
                    comment.setApproved(false);
                }
            }
            request.getSession().setAttribute("io", lii);
            url+="?act=detail";
            if(suri!=null&&!suri.equals("")){
                url+="&suri="+suri;
            }
            if(npag!=null&&!npag.equals("")){
                url+="&npag="+npag;
            }
            response.sendRedirect(url);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    static public ArrayList<Comment> listComments(Iterator<Comment> itco){
        ArrayList ret=new ArrayList();
        while (itco.hasNext()) {
            Comment co = itco.next();
            if(co.isApproved()){
                ret.add(co);
            }
        }
        return ret;
    }
    public boolean hasDirtyWords(String str){
        boolean ret=false;
        Resource base = getResourceBase();
        String tdw=base.getAttribute("dirtywords","");
        tdw=tdw.toLowerCase().replaceAll("[^a-zA-Z\u00C0-\u00FF]",",");
        List<String> ldw=Arrays.asList(tdw.split(","));
        String tstr=str.toLowerCase().replaceAll("[^a-zA-Z\u00C0-\u00FF]",",");
        List<String> lstr=Arrays.asList(tstr.split(","));
        for(int i =0; i<ldw.size()&&!ret;i++){
            if(!ldw.get(i).equals("")){
                for(int j=0;j<lstr.size()&&!ret;j++){
                    if(lstr.get(j).equals(ldw.get(i))){
                        ret=true;
                    }
                }
            }
        }        
        return ret;
    }
}