/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.infotec.conorg.WorkSpace;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;

/**
 *
 * @author rene.jara
 */
public class WorkSpaces extends GenericAdmResource {
    private Logger log = SWBUtils.getLogger(WorkSpaces.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        int callMethod= paramRequest.getCallMethod();
        String path; 
        if (callMethod==SWBActionResponse.Call_STRATEGY){
            path = basePath + "strategy.jsp";
        }else{
            path = basePath + "view.jsp";
        }
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

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String wsid=request.getParameter("wsid");
        if(wsid!=null&&!wsid.equals("")){
            response.setRenderParameter("wsid", wsid);
        }
    }
}
