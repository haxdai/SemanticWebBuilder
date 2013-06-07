/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infotec.lodp.swb.resources;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author rene.jara
 */
public class DatasetViewResource extends GenericResource{

    public static final Logger log = SWBUtils.getLogger(DatasetViewResource.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        int call=paramRequest.getCallMethod();
        String path;
 //       if(call==paramRequest.Call_STRATEGY){
 //           path = basePath + "strategy.jsp";
 //       }else{
            path = basePath + "view.jsp";
 //       }
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
