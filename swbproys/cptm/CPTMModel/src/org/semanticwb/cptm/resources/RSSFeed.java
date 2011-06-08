/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

/**
 *
 * @author miguel.ortiz
 */

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.servlet.RequestDispatcher;

public class RSSFeed extends GenericAdmResource {

    private static Logger logger = SWBUtils.getLogger(RSSFeed.class);

    public static Logger getLogger() {
        return RSSFeed.logger;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        response.setContentType("text/xml");
        String jspPath = SWBPortal.getWebWorkPath() + "/models/"
                + paramsRequest.getWebPage().getWebSiteId()
                + "/jsp/RSSView.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jspPath);

        try {
            request.setAttribute("paramsRequest", paramsRequest);
            request.setAttribute("rssFeed", this);
            rd.include(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
        
    }

    public Element addAttribute(Element ele, String name, String value) {

        Document doc = ele.getOwnerDocument();
        Element n = doc.createElement(name);

        ele.appendChild(n);
        n.appendChild(doc.createTextNode(value));

        return n;
    }
 }
