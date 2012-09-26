/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.resources;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.internet.InternetAddress;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Resource base = getResourceBase();
        WebSite wsite = response.getWebPage().getWebSite();
        String action = response.getAction();
        String msg = null;
        if (null == action) {
            action = "";
        }

        User user = response.getUser();
        String email_admin = base.getAttribute("email_admin", "juan.fernandez@infotec.com.mx");

        if (null != user && (SWBResourceURL.Action_ADD.equals(action) || SWBResourceURL.Action_EDIT.equals(action))) {
            String temaTitle = request.getParameter("nomTema");
            String temaDescr = request.getParameter("descripTema");
            String temaID = request.getParameter("id");
            try {
                //envia correo electrónico al administrador la propuesta del nuevo tema
                InternetAddress emailAdmin = new InternetAddress();
                emailAdmin.setAddress(email_admin);
                
                String dataEmail = "<h2>Propuesta nuevo tema - "+wsite.getTitle()+"</h2>"
                        + "<table><tr><td><h3>Título del Tema:</h3></td><td><h3>" + temaTitle + "</h3></td></tr>"
                        + "<tr><td><h3>Descripción:</h3></td><td><h3>" + temaDescr + "</h3></td></tr>"
                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
                        + "<tr><td colspan=\"2\" align=\"center\"><h3>Datos Solicitante:</h3></td></tr>"
                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
                        + "<tr><td>Nombre:</td><td>" + user.getFullName() + "</td></tr>"
                        + "<tr><td>Correo electrónico:</td><td><a href=\"mailto:" + user.getEmail() + "\">" + user.getEmail() + "</a></td></tr>"
                        + "<tr><td>Fecha Solicitud:</td><td>" + sdf.format(new Date(System.currentTimeMillis())) + "</td></tr>"
                        + "<tr><td colspan=\"2\">&nbsp;</td></tr></table>";

                ArrayList<InternetAddress> arr = new ArrayList();
                arr.add(emailAdmin);
                String userEmail = user.getEmail();
                String userName = user.getFullName();
                String asunto = "Propuesta de nuevo tema.";
                String tipo = "text/html";
                String login = SWBPlatform.getEnv("swb/smtpUser");
                String pass = SWBPlatform.getEnv("swb/smtpPassword");
                
                SWBUtils.EMAIL.sendBGEmail(userEmail, userName, arr, null, null, asunto, tipo, dataEmail,login ,pass , null); 
                msg="Tú solicitud ha sido enviada con éxito al administrador.";
            } catch (Exception e) {
                log.error("Error al enviar la propuesta de nuevo tema por correo electrónico.", e);
                msg = "Error al enviar la propuesta de nuevo tema por correo electrónico.";
            }

            if(null!=msg) response.setRenderParameter("alertmsg", msg);
 

//            com.infotec.conorg.Topic topic = null;
//
//
//
//            if (null != temaTitle) {
//
//                if (null != temaID) {
//                    topic = com.infotec.conorg.Topic.ClassMgr.getTopic(temaID, wsite);
//                } else {
//                    topic = com.infotec.conorg.Topic.ClassMgr.createTopic(wsite);
//                }
//
//                topic.setTitle(temaTitle);
//                topic.setDescription(temaDescr);
//
//            }
        }


    }
}
