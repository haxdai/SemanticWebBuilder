package org.semanticwb.mask;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author carlos.ramos
 */
public class ProspectManager  extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(FriendManager.class);
    public static final String Action_ACCEPTINVITATION = "agree";
    public static final String Action_REJECTINVITATION = "reject";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        final String path = "/work/models/"+modelId+"/jsp/";

        PrintWriter out =  response.getWriter();

        request.setAttribute("paramRequest", paramRequest);
        RequestDispatcher dis;

        out.println("<div class=\"area_registro\">");
        dis = request.getRequestDispatcher(path+"perfil/myFriendRequests.jsp");
        try {
            dis.include(request, response);
        } catch (Exception e) {
            System.out.println("myFriendRequests\n"+e);
            log.error(e);
        }

//        dis = request.getRequestDispatcher(path+"perfil/myFriends.jsp");
//        try {
//            dis.include(request, response);
//        } catch (Exception e) {
//            System.out.println("myFriends\n"+e);
//            log.error(e);
//        }

//        dis = request.getRequestDispatcher(path+"perfil/myInvitations.jsp");
//        try {
//            dis.include(request, response);
//        } catch (Exception e) {
//            System.out.println("myInvitations\n"+e);
//            log.error(e);
//        }

        dis = request.getRequestDispatcher(path+"perfil/findFriends.jsp");
        try {
            dis.include(request, response);
        } catch (Exception e) {
            System.out.println("findFriends\n"+e);
            log.error(e);
        }
        out.println("</div>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebPage wp = response.getWebPage();
        WebSite model = wp.getWebSite();
        User owner = response.getUser();

        String action = response.getAction();
        // agregar prospecto o solicitud
        if(response.Action_ADD.equals(action)) {
            User requested = null;
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requested = (User)semObj.createGenericInstance();
                if (requested!=null && !Friendship.areFriends(owner, requested, model) && !FriendshipProspect.findFriendProspectedByRequester(owner, requested, model)) {
                    FriendshipProspect.createFriendshipProspect(owner, requested, model);
                }
            }
        }
        // eliminar prospecto o solicitud
        else if(response.Action_REMOVE.equals(action)) {
            User requested = null;
            System.out.println("user="+request.getParameter("user"));
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requested = (User)semObj.createGenericInstance();
                System.out.println("requested="+requested);
                //if(requested!=null && requested.getURI()!=null && owner!=null && owner.getURI()!=null && !owner.getURI().equals(requested.getURI()) && !Friendship.areFriends(owner, requested, model) && FriendshipProspect.findFriendProspectedByRequester(owner, requested, model)) {
                System.out.println("son amigos="+Friendship.areFriends(requested, owner, model));
                System.out.println("es prospecto="+FriendshipProspect.findFriendProspectedByRequester(owner, requested, model));
                //if(requested!=null && !Friendship.areFriends(owner, requested, model) && FriendshipProspect.findFriendProspectedByRequester(owner, requested, model)) {
                    FriendshipProspect.removeFriendshipProspectByRequester(owner, requested, model);
                    System.out.println("se borro el prospecto");
                //}
            }
        }else if(Action_ACCEPTINVITATION.equals(action)) {
            System.out.println("aceptar invitacion");
            System.out.println("amistoso="+request.getParameter("user"));
            User requester = null;
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requester = (User)semObj.createGenericInstance();
                if (requester!=null && !Friendship.areFriends(owner, requester, model) && FriendshipProspect.findFriendProspectedByRequester(requester, owner, model)) {
                    Friendship friendship = Friendship.ClassMgr.createFriendship(model);
                    friendship.addFriend(requester);
                    friendship.addFriend(owner);
                    FriendshipProspect.removeFriendshipProspectByRequester(requester, owner, model);
                }
            }
        }else if(Action_REJECTINVITATION.equals(action)) {
            System.out.println("rechazar invitacion");
            System.out.println("amistoso="+request.getParameter("user"));
            User requester = null;
            if( request.getParameter("user")!=null && !request.getParameter("user").equals(owner.getURI()) ) {
                SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("user"));
                requester = (User)semObj.createGenericInstance();
                if(requester!=null && !Friendship.areFriends(owner, requester, model) && FriendshipProspect.findFriendProspectedByRequester(requester, owner, model)) {
                    FriendshipProspect.removeFriendshipProspectByRequester(requester, owner, model);
                }
            }
        }
    }
}
