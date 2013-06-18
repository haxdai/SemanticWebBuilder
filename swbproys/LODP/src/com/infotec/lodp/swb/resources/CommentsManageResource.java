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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBModel;
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
public class CommentsManageResource extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(CommentsManageResource.class);
    /** Accion personalizada para marcar un comentario validado    */
    public static final String Action_APPROVE="apv";
    /** Accion personalizada para marcar un comentario validado    */
    public static final String Action_REVIEWED="rvw";
    /** Accion personalizada todo OK     */
    public static final String Action_OK="ok";

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebPage wpage = response.getWebPage();
        WebSite wsite = wpage.getWebSite();
        Resource base = getResourceBase();
        UserRepository ur = wsite.getUserRepository();
        if(Action_APPROVE.equals(action)) {
            String cid=request.getParameter("cid");
            if(cid!=null&&!cid.equals("")){
                Comment comment=Comment.ClassMgr.getComment(cid,wsite);
                comment.setApproved(true);
                comment.setReviewed(true);
            }
        }else if (Action_REVIEWED.equals(action)) {
            String cid=request.getParameter("cid");
            if(cid!=null&&!cid.equals("")){
                Comment comment=Comment.ClassMgr.getComment(cid,wsite);
                comment.setApproved(false);
                comment.setReviewed(true);
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
    static public ArrayList<Comment> listComments(Iterator<Comment> itco){
        ArrayList ret=new ArrayList();
        while (itco.hasNext()) {
            Comment co = itco.next();
            if(!co.isApproved()&&!co.isReviewed()){
                ret.add(co);
            }
        }
        return ret;
    }
    static public ArrayList<Comment> listCommentsByDatasetApplication(SWBModel wsite){
        Iterator<Dataset> itds=Dataset.ClassMgr.listDatasets(wsite);
        Iterator<Application> itap=Application.ClassMgr.listApplications(wsite);
        ArrayList<Comment> ret=new ArrayList<Comment>();
        while(itds.hasNext()){
            Dataset ds=itds.next();
            Iterator<Comment> itco=ds.listComments();
            while(itco.hasNext()){
                Comment co =itco.next();
                if(!co.isApproved()&&!co.isReviewed()){
                    ret.add(co);
                }
            }
        }
        while(itap.hasNext()){
            Application ap=itap.next();
            Iterator<Comment> itco=ap.listComments();
            while(itco.hasNext()){
                Comment co =itco.next();
                if(!co.isApproved()&&!co.isReviewed()){
                    ret.add(co);
                }
            }
        }
        return ret;
    }
}
