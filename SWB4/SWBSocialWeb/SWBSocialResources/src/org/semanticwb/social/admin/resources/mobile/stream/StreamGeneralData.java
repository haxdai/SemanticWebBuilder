/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources.mobile.stream;

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
import org.semanticwb.social.Stream;

/**
 *
 * @author jorge.jimenez
 */
public class StreamGeneralData extends GenericResource {

    private static Logger log = SWBUtils.getLogger(StreamGeneralData.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/mobilev/stream/generalData.jsp";
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
        System.out.println("En StreamGeneralData-0:"+request.getParameter("streamUri")+",action:"+response.getAction()+",active:"+request.getParameter("active"));
        if(request.getParameter("streamUri")!=null)
        {
            System.out.println("En StreamGeneralData-1:"+request.getParameter("streamUri"));
            try
            {
                SemanticObject semObj=SemanticObject.getSemanticObject(request.getParameter("streamUri"));
                Stream stream=(Stream)semObj.getGenericInstance();
                if(response.getAction().equals(SWBResourceURL.Action_EDIT))
                {
                    System.out.println("En StreamGeneralData-2");
                    if(request.getParameter("active")!=null)
                    {
                        System.out.println("En StreamGeneralData-3:"+request.getParameter("active"));
                        if(request.getParameter("active").equals("1")) stream.setActive(true);
                        else if(request.getParameter("active").equals("0")) stream.setActive(false);
                    }
                }
                response.sendRedirect(SWBContext.getAdminWebSite().getWebPage("m_Streams").getUrl()+"?semObj="+stream.getEncodedURI()); 
            }catch(Exception e)
            {
                log.error(e);
            }
            //response.setRenderParameter("streamUri", request.getParameter("streamUri"));
        }
    }
}