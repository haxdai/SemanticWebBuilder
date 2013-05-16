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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

/**
 *
 * @author rene.jara
 */
public class CommentsViewResource extends GenericResource {

    public static final Logger log = SWBUtils.getLogger(CommentsViewResource.class);

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
        String suri = null;
        if (response.Action_ADD.equals(action)) {
            String name = null;
            String email = null;
            String strComment = null;
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = null;
            Comment comment = null;
            gobj = usr.getSemanticObject().getGenericInstance();
            if (gobj instanceof Developer) {
                Developer de = (Developer) gobj;
                name = de.getFullName();
                email = de.getEmail();
            } else {
                name = request.getParameter("name");
                email = request.getParameter("email");
            }
            strComment=request.getParameter("comment");
            suri=request.getParameter("suri");
            if (name != null && !name.equals("")
                    && email != null && !name.equals("")
                    && strComment != null && !strComment.equals("")) {
                comment = Comment.ClassMgr.createComment(wsite);                
                comment.setCommUserName(name);
                comment.setCommUserEmail(email);
                comment.setComment(strComment);
            }
            if (suri != null && !suri.equals("") && comment!= null) {
                gobj = ont.getGenericObject(suri);
                if (gobj != null && gobj instanceof Application) {
                    Application ap = (Application) gobj;
                    ap.addComment(comment);
                } else if (gobj != null && gobj instanceof Dataset) {
                    Dataset ds = (Dataset) gobj;
                    ds.addComment(comment);
                } 
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
}
