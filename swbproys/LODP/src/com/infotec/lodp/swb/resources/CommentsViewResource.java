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
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author rene.jara
 */
public class CommentsViewResource extends GenericResource {

    public static final Logger log = SWBUtils.getLogger(CommentsViewResource.class);
    /** Accion personalizada para comentar    */
    public static final String Action_COMMENT="com";
    /** Accion personalizada para marcar un comentario inapropiado    */
    public static final String Action_INAPPROPRIATE="inp";
    /** Accion personalizada para editar la administraciono     */
    public static final String Action_ADMEDIT="aed";
    /** Accion personalizada todo OK     */
    public static final String Action_OK="ok";
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        super.processRequest(request, response, paramRequest);
    }

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
            strComment=request.getParameter("comment");
            if (name != null && !name.equals("")
                    && email != null && !name.equals("")
                    && strComment != null && !strComment.equals("")) {
                comment = Comment.ClassMgr.createComment(wsite);                
                comment.setCommUserName(name);
                comment.setCommUserEmail(email);
                comment.setComment(strComment);
                comment.setApproved(false);
                comment.setReviewed(false);
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
                if(!lii.contains(suri)){
                    lii.add(suri);
                    canRank=true;
                }
            }
            if(cid!=null&&!cid.equals("")&&canRank){
                Comment comment=Comment.ClassMgr.getComment(cid,wsite);
                comment.setInappropriate(comment.getInappropriate()+1);
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
        }else if(Action_ADMEDIT.equals(action)) {
            int nInappropriate=0;
            int nCommentsPage=0;
            try{
                nInappropriate=Integer.parseInt(request.getParameter("inappropriate"));
                if(nInappropriate<1){
                    nInappropriate=1;
                }
            }catch(NumberFormatException ignored){
                nInappropriate=1;
            }
            try{
                nCommentsPage=Integer.parseInt(request.getParameter("commentspage"));
                if(nCommentsPage<1){
                    nCommentsPage=1;
                }
            }catch(NumberFormatException ignored){
                nCommentsPage=1;
            }
            base.setAttribute("inappropriate", nInappropriate+"");
            base.setAttribute("num_comments_p_page", nCommentsPage+"");
            try {
                base.updateAttributesToDB();
                response.setAction(Action_OK);
            } catch (Exception e) {
                log.error("Error Action_ADMEDIT "+base.getClass(), e);
            }
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
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramRequest.getUser();

        String noMsg = "";

        String action = paramRequest.getAction();
        if(Action_OK.equals(action)) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('"+paramRequest.getLocaleString("msgActResource")+" "+base.getId()+"');");
            out.println("</script>");
        }
        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();

        SWBResourceURL urlAction = paramRequest.getActionUrl();
        urlAction.setAction(Action_ADMEDIT);

        out.println("<div class=\"swbform\">");
        out.println("<form id=adm_edit_\""+base.getId()+"\" name=\"ilta_"+base.getId()+"\" action=\""+urlAction+"\" method=\"post\" >");
        out.println("<fieldset><legend>"+paramRequest.getLocaleString("lblData")+"</legend>");
        out.println("<ul class=\"swbform-ul\">");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"inappropriate\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblAdmInappropriate")+"</label>");
        out.println("   <Input type=\"text\" name=\"inappropriate\" id=\"inappropriate\"  value=\""+base.getAttribute("inappropriate",noMsg)+"\"/>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"commentspage\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblAdmNumRec")+"</label>");
        out.println("   <Input type=\"text\" name=\"commentspage\" id=\"commentspage\"  value=\""+base.getAttribute("num_comments_p_page",noMsg)+"\"/>");
        out.println("</li>");
        out.println("</fieldset>");
        out.println("<fieldset>");
        out.println("<button id=\"botonEnviar\" dojoType=\"dijit.form.Button\"  onClick=\"setCookie();\" type=\"submit\">"+paramRequest.getLocaleString("lblSubmit")+"</button>");
        out.println("<button id=\"botonReset\" dojoType=\"dijit.form.Button\" type=\"reset\" >"+paramRequest.getLocaleString("lblReset")+"</button>");
        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");
    }
    static public ArrayList<Comment> listComments(Iterator<Comment> itco,int nInappropriate){
        ArrayList ret=new ArrayList();
        while (itco.hasNext()) {
            Comment co = itco.next();
            if(co.getInappropriate()<nInappropriate||co.isApproved()){
                ret.add(co);
            }
        }
        return ret;
    }

}
