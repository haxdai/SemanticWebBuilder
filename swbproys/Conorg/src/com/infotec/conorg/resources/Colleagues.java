/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.infotec.conorg.Colleague;
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
public class Colleagues extends GenericAdmResource {

    private Logger log = SWBUtils.getLogger(Colleagues.class);

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        int callMethod= paramRequest.getCallMethod();
        if (callMethod==SWBActionResponse.Call_STRATEGY){
            String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
            String path = basePath + "view.jsp";
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
        }else{
            doEdit(request, response, paramRequest);
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "edit.jsp";
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
        String action = response.getAction();
        User user = response.getUser();
        WebSite wsite = response.getWebPage().getWebSite();
        String idCo = request.getParameter("idco");
        if (idCo != null && !idCo.equals("")) {
            Colleague colleague = Colleague.ClassMgr.getColleague(user.getId(), wsite);
            User usrCo = wsite.getUserRepository().getUser(idCo);
            if (response.Action_ADD.equals(action)) {
                if (usrCo != null) {
                    colleague.addColleagues(usrCo);
                }
            } else if (response.Action_REMOVE.equals(action)) {
                if (usrCo != null) {
                    colleague.removeColleagues(usrCo);
                }
            }
        }
    }
}
