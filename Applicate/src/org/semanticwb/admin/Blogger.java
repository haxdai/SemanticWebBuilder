package org.semanticwb.admin;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.applicate.BloggerProfile;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriela.rosales
 */
public class Blogger extends GenericResource {

    private static Logger log = SWBUtils.getLogger(Blogger.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        super.doView(request, response, paramRequest);
    }

    
    
    @Override
    public void doAdmin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        //String jspResponse = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/twitterTabs1.jsp";
        //String jspResponse1 = SWBPlatform.getContextPath() + "/swbadmin/jsp/Applicate/blogger.jsp";
        //C:\SWB4\swb\web\swbadmin\jsp\Applicate
        String path = "/swbadmin/jsp/Applicate/blogger.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if (action.equals("saveBlogger")) {

            String name = request.getParameter("nombre") == null ? "" : request.getParameter("nombre");
            String apePat = request.getParameter("apePat") == null ? "" : request.getParameter("apePat");
            String apeMat = request.getParameter("apeMat") == null ? "" : request.getParameter("apeMat");
            String descripcion = request.getParameter("descripcion") == null ? "" : request.getParameter("descripcion");
            String twitter = request.getParameter("twitter") == null ? "" : request.getParameter("twitter");
            String facebook = request.getParameter("facebook") == null ? "" : request.getParameter("facebook");
            String linkedin = request.getParameter("linkedin") == null ? "" : request.getParameter("linkedin");
            String email = request.getParameter("email") == null ? "" : request.getParameter("email");
            String puesto = request.getParameter("puesto") == null ? "" : request.getParameter("puesto");
            String[] enumParams = request.getParameterValues("areaExpertise");
         

            UserRepository usrep = SWBContext.getDefaultRepository();
            User user = usrep.createUser();
            user.setFirstName(name);
            user.setLastName(apePat);
            user.setSecondLastName(apeMat);
            user.setActive(true);
            user.setRequestChangePassword(true);
            user.setEmail(email);
           Role role = Role.ClassMgr.getRole("Blogger", usrep);       
           if(role!= null){
           user.addRole(role);
           }
            
         
            SWBModel model= response.getWebPage().getWebSite();

            WebSite modeli= response.getWebPage().getWebSite();

             BloggerProfile bloggerProfile = BloggerProfile.ClassMgr.createBloggerProfile(modeli);

            bloggerProfile.setUserBlogger(user);
            bloggerProfile.setBloggerDescription(descripcion);
            bloggerProfile.setLinkTwitter(twitter);
            bloggerProfile.setLinkFacebook(facebook);
            bloggerProfile.setLinkLinkedin(linkedin);
            bloggerProfile.setPuesto(puesto);
           

               for (int i = 0; i < enumParams.length; i++) {
                String area = enumParams[i];
                bloggerProfile.addAreasExpertiseBlogger(area);
            }        

            response.setRenderParameter("statusMsg", "Guardado");

        }
    }


}
