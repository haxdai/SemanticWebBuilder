/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import static com.infotec.lodp.swb.resources.CommentsViewResource.log;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author Sabino
 */
public class ChartResource extends GenericAdmResource {
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, 
        SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() 
                    + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        request.setAttribute("paramRequest", paramRequest);
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
}
