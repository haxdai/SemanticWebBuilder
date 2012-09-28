/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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
 * @author juan.fernandez
 */
public class AutoComplete extends GenericResource {
    public static final Logger log = SWBUtils.getLogger(MyShelf.class);
    public static final SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yy hh:mm");
    public static final String Mode_AJAX = "ajax";

    

    public static final NumberFormat numf = NumberFormat.getNumberInstance();

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";

        String path = basePath + "complete.jsp";

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
    
    public void doAjax(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        RequestDispatcher dis = request.getRequestDispatcher(basePath + "ajax.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (Mode_AJAX.equals(mode)) {
            doAjax(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
}
