/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author jorge.jimenez
 */
public class MyBusiness extends GenericResource{


    private static Logger log = SWBUtils.getLogger(MyBusiness.class);


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId();
        RequestDispatcher dis = request.getRequestDispatcher(siteWorkDir
                + "/jsp/pymestur/myBusiness.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            if (paramRequest.getCallMethod() == paramRequest.Call_CONTENT) {
                request.setAttribute("showAll", "1");
            } else {
                request.setAttribute("showAll", "0");
            }
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }
}
