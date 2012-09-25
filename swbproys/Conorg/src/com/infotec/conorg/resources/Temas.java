/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SWBMail;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;

/**
 *
 * @author rene.jara
 */
public class Temas extends GenericAdmResource {

    private Logger log = SWBUtils.getLogger(Temas.class);

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        int callMethod = paramRequest.getCallMethod();
        String path;
        if (callMethod == SWBActionResponse.Call_STRATEGY) {
            path = basePath + "strategy.jsp";
        } else {
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

        Resource base = getResourceBase();
        WebSite wsite = response.getWebPage().getWebSite();
        String action = response.getAction();
        if (null == action) {
            action = "";
        }

        User user = response.getUser();
        String email_admin = base.getAttribute("email_admin","juan.fernandez@infotec.com.mx");
        
        if (null!=user&&(SWBResourceURL.Action_ADD.equals(action) || SWBResourceURL.Action_EDIT.equals(action))) {
            String temaTitle = request.getParameter("nomTema");
            String temaDescr = request.getParameter("descripTema");
            String temaID = request.getParameter("id");
            
            //envia correo electrónico al administrador la propuesta del nuevo tema
            SWBMail mail = new SWBMail();
            InternetAddress emailAdmin=new InternetAddress();
            emailAdmin.setAddress(email_admin);
            mail.addAddress(emailAdmin);
            mail.setFromEmail(user.getEmail());
            mail.setFromName(user.getFullName());
            mail.setSubject("Propuesta de nuevo tema.");
            mail.setData(temaID);
            String dataEmail = "";
                    
                    SWBUtils.EMAIL.sendMail(null);
            
            
            com.infotec.conorg.Topic topic = null;

            
            
            if (null != temaTitle) {

                if (null != temaID) {
                    topic = com.infotec.conorg.Topic.ClassMgr.getTopic(temaID, wsite);
                } else {
                    topic = com.infotec.conorg.Topic.ClassMgr.createTopic(wsite);
                }

                topic.setTitle(temaTitle);
                topic.setDescription(temaDescr);
                
            }
        }


    }
}
