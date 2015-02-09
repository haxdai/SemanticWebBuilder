/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources.mobile.snets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.Stream;

/**
 *
 * @author jorge.jimenez
 */
public class SocialNetGeneralData extends GenericResource {

    private static Logger log = SWBUtils.getLogger(SocialNetGeneralData.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/mobilev/socialnet/generalData.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(myPath);
        if (dis != null) {
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception ex) {
                log.error(ex);
            }
        }

    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        if(request.getParameter("socialNetUri")!=null)
        {
            try
            {
                SemanticObject semObj=SemanticObject.getSemanticObject(request.getParameter("socialNetUri"));
                SocialNetwork socialNet=(SocialNetwork)semObj.getGenericInstance();
                if(response.getAction().equals(SWBResourceURL.Action_EDIT))
                {
                    if(request.getParameter("active")!=null)
                    {
                        if(request.getParameter("active").equals("1")) socialNet.setActive(true);
                        else if(request.getParameter("active").equals("0")) socialNet.setActive(false);
                    }
                }
                response.sendRedirect(SWBContext.getAdminWebSite().getWebPage("m_SocialNets").getUrl()+"?semObj="+socialNet.getEncodedURI()); 
            }catch(Exception e)
            {
                log.error(e);
            }
            //response.setRenderParameter("streamUri", request.getParameter("streamUri"));
        }
    }
}