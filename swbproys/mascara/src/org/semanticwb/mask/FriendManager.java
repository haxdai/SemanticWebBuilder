/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.mask;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.Friendship;
import org.semanticwb.portal.community.FriendshipProspect;

/**
 *
 * @author carlos.ramos
 */
public class FriendManager extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(FriendManager.class);
    public static final String Action_ADDPROSPECT = "addProspect";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        
        request.setAttribute("paramRequest", paramRequest);
        RequestDispatcher dis;
        dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/perfil/myInvitations.jsp");
        try {
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }

        dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/perfil/findFriends.jsp");
        try {
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        User owner = response.getUser();

        String action = response.getAction();
        if(response.Action_ADD.equals(action)) {
            User requester = null;
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requester = (User)semObj.createGenericInstance();
                if (requester!=null && requester.getURI()!=null && owner!=null && owner.getURI()!=null && !owner.getURI().equals(requester.getURI()) && !Friendship.areFriends(owner, requester, model) && FriendshipProspect.findFriendProspectedByRequester(requester, owner, model)) {
                    Friendship friendship = Friendship.ClassMgr.createFriendship(model);
                    friendship.addFriend(requester);
                    friendship.addFriend(owner);
                    FriendshipProspect.removeFriendshipProspectByRequester(requester, owner, model);
                }
            }
        }else if(response.Action_REMOVE.equals(action)) {
            User requester = null;
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requester = (User)semObj.createGenericInstance();
                if (requester!=null && requester.getURI()!=null && owner!=null && owner.getURI()!=null && !owner.getURI().equals(requester.getURI()) && !Friendship.areFriends(owner, requester, model) && FriendshipProspect.findFriendProspectedByRequester(requester, owner, model)) {
                    FriendshipProspect.removeFriendshipProspectByRequester(requester, owner, model);
                }
            }
        }else if(Action_ADDPROSPECT.equals(action)) {
            User requested = null;
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requested = (User)semObj.createGenericInstance();
                if (requested!=null && requested.getURI()!=null && owner!=null && owner.getURI()!=null && !owner.getURI().equals(requested.getURI()) && !Friendship.areFriends(owner, requested, model) && !FriendshipProspect.findFriendProspectedByRequester(owner, requested, model)) {
                    FriendshipProspect.createFriendshipProspect(owner, requested, model);
                }
            }
        }
    }
}
