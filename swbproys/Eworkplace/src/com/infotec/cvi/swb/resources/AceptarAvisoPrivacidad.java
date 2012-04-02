/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.eworkplace.swb.Persona;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;

/**
 * Recurso de estrategia que muestra una ventana para que el usuario acepte los 
 * terminos de privacidad configurados y asigne un rol o grupo dado al aceptarlos
 *
 * @author rene.jara
 */
public class AceptarAvisoPrivacidad extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(UserRegister.class);
    /** Accion personalizada de la administracion cuando se guarda informacion     */
    public static final String Action_OK = "ok";

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        String mode = response.getMode();
        int method = response.getCallMethod();
        Resource base = getResourceBase();
        User user = response.getUser();
        if (response.Action_ADD.equals(action)) {
            WebSite ws = getResourceBase().getWebSite();
            Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
            String activeRoleGroup = getResourceBase().getAttribute("activeRoleGroup");
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj;
            gobj = ont.getGenericObject(activeRoleGroup);
            if (gobj != null) {
                if (gobj instanceof UserGroup) {
                    UserGroup ugrp = (UserGroup) gobj;
                    if (!user.hasUserGroup(ugrp)) {
                        user.addUserGroup(ugrp);
                    }
                } else if (gobj instanceof Role) {
                    Role urole = (Role) gobj;
                    if (!user.hasRole(urole)) {
                        user.addRole(urole);
                    }
                }
            }

            String emailMsg = base.getAttribute("emailAgreeMsg");
            if(emailMsg!=null&&!emailMsg.equals("")){
                ArrayList aTo = new ArrayList();
                javax.mail.internet.InternetAddress address = new javax.mail.internet.InternetAddress();
                address.setAddress(user.getEmail());
                aTo.add(address);
                ArrayList aBcc = new ArrayList();
                if (base.getAttribute("emailBcc") != null && !base.getAttribute("emailBcc").equals("")) {
                    address = new javax.mail.internet.InternetAddress();
                    address.setAddress(base.getAttribute("emailBcc"));
                    aBcc.add(address);
                }else{
                    aBcc=null;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{firstname}", user.getFirstName());
                emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{fullname}", user.getFullName());
                emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.login}", user.getLogin());
                emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.email}", user.getEmail());
                emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{agreement}", base.getAttribute("agreement"));
                emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{date}", sdf.format(new Date()));
                if (aBcc==null){
                    SWBUtils.EMAIL.sendMail(user.getEmail(),response.getLocaleString("lblSubject"), emailMsg);
                }else{
                    SWBUtils.EMAIL.sendMail(SWBPortal.getEnv("af/adminEmail"), "", aTo, null, aBcc, response.getLocaleString("lblSubject"), "text/html", emailMsg, null, null, null);
                }
            }
            persona.setAceptacionTerminos(emailMsg);
        } else if (response.Mode_ADMIN.equals(mode) && response.Action_EDIT.equals(action)) {
            String activeRoleGroup = request.getParameter("activeRoleGroup");
            String emailAgreeMsg = request.getParameter("emailAgreeMsg");
            String emailBcc = request.getParameter("emailBcc");
            String agreement = request.getParameter("agreement");
            if (activeRoleGroup != null) {
                base.setAttribute("activeRoleGroup", activeRoleGroup);
            }
            if (emailAgreeMsg != null) {
                base.setAttribute("emailAgreeMsg", emailAgreeMsg);
            }
            if (emailBcc != null) {
                base.setAttribute("emailBcc", emailBcc);
            }
            if (agreement != null) {
                base.setAttribute("agreement", agreement);
            }
            response.setAction(Action_OK);
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error("Error al guardar atributos del " + this.getClass().getSimpleName(), e);
            }
        }

    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        User user = paramsRequest.getUser();
        boolean show = true;
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String activeRoleGroup = getResourceBase().getAttribute("activeRoleGroup");
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject gobj;
        gobj = ont.getGenericObject(activeRoleGroup);
        if (gobj != null) {
            if (gobj instanceof UserGroup) {
                UserGroup ugrp = (UserGroup) gobj;
                show = !user.hasUserGroup(ugrp);
            } else if (gobj instanceof Role) {
                Role urole = (Role) gobj;
                show = !user.hasRole(urole);
            }
        }
        if (show) {
            RequestDispatcher dis = request.getRequestDispatcher(basePath + "/splash.jsp");
            try {
                request.setAttribute("paramRequest", paramsRequest);
                dis.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramsRequest.getUser();

        String resourceUpdatedMessage = paramsRequest.getLocaleString("msgRecursoActualizado");
        String legend = paramsRequest.getLocaleString("lblData");
        String userGroupMessage = paramsRequest.getLocaleString("lblRoleGroup");
        String listMessage = paramsRequest.getLocaleString("lblListMessage");
        String saveButtonText = paramsRequest.getLocaleString("lblGuardar");
        String resetButtonText = paramsRequest.getLocaleString("lblReset");

        String action = paramsRequest.getAction();
        if (Action_OK.equals(action)) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('" + resourceUpdatedMessage + " " + base.getId() + "');");
            out.println("   location='" + paramsRequest.getRenderUrl().setAction(paramsRequest.Action_EDIT).toString() + "';");
            out.println("</script>");
        }
        WebPage wp = paramsRequest.getWebPage();
        WebSite ws = wp.getWebSite();

        String str_role = base.getAttribute("activeRoleGroup", "0");

        SWBResourceURL urlAction = paramsRequest.getActionUrl();
        urlAction.setAction(paramsRequest.Action_EDIT);

        out.println("<div class=\"swbform\">");
        out.println("<form id=aap_\"" + base.getId() + "\" name=\"aap_" + base.getId() + "\" action=\"" + urlAction + "\" method=\"post\" >");
        out.println("<fieldset><legend>" + legend + "</legend>");

        String strTemp = "<option value=\"-1\">" + "No se encontaron roles" + "</option>";
        Iterator<Role> iRoles = ws.getUserRepository().listRoles();
        StringBuilder strRules = new StringBuilder();
        String selected = "";
        if (str_role.equals("0")) {
            selected = " selected=\"selected\"";
        }
        strRules.append("\n<option value=\"0\" ");
        strRules.append(selected);
        strRules.append(">");
        strRules.append(listMessage);
        strRules.append("</option>");
        strRules.append("\n<optgroup label=\"Roles\">");
        while (iRoles.hasNext()) {
            Role oRole = iRoles.next();
            selected = "";
            if (str_role.trim().equals(oRole.getURI())) {
                selected = " selected=\"selected\"";
            }
            strRules.append("\n<option value=\"");
            strRules.append(oRole.getURI());
            strRules.append("\"");
            strRules.append(selected);
            strRules.append(">");
            strRules.append(oRole.getDisplayTitle(user.getLanguage()));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        strRules.append("\n<optgroup label=\"User Groups\">");
        Iterator<UserGroup> iugroups = ws.getUserRepository().listUserGroups();
        while (iugroups.hasNext()) {
            UserGroup oUG = iugroups.next();
            selected = "";
            if (str_role.trim().equals(oUG.getURI())) {
                selected = " selected=\"selected\"";
            }
            strRules.append("\n<option value=\"");
            strRules.append(oUG.getURI());
            strRules.append("\"");
            strRules.append(selected);
            strRules.append(">");
            strRules.append(oUG.getDisplayTitle(user.getLanguage()));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        if (strRules.toString().length() > 0) {
            strTemp = strRules.toString();
        }
        out.println("<ul class=\"swbform-ul\">");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"activeRoleGroup\" class=\"swbform-label\">" + userGroupMessage + "</label>");
        out.print("     <select id=\"activeRoleGroup\" name=\"activeRoleGroup\">" + strTemp + "</select>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"emailBcc\" class=\"swbform-label\">" + paramsRequest.getLocaleString("lblEmailBcc") + "</label>");
        out.println("   <input type=\"text\" name=\"emailBcc\" id=\"emailBcc\" value=\"" + base.getAttribute("emailBcc", "") + "\" />");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"emailAgreeMsg\" class=\"swbform-label\">" + paramsRequest.getLocaleString("lblEmailAgreeMsg") + "</label>");
        out.println("   <textarea name=\"emailAgreeMsg\" id=\"emailAgreeMsg\" cols=\"25\" rows=\"5\">" + base.getAttribute("emailAgreeMsg", "") + "</textarea>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"agreement\" class=\"swbform-label\">" + paramsRequest.getLocaleString("lblAgreement") + "</label>");
        out.println("   <textarea name=\"agreement\" id=\"agreement\" cols=\"25\" rows=\"5\">" + base.getAttribute("agreement", "") + "</textarea>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{firstname} Nombre de la persona </font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{fullname} Nombre completo de la persona</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{user.login} Nombre de usuario</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{user.email} Correo de la persona</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{agreement} Texto de aviso de privacidad</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{date} Fecha de envio del mensaje</font>");
        out.println("</li>");
        out.println("</ul>");
        out.println("</fieldset>");
        out.println("<fieldset>");
        out.println("<button id=\"botonEnviar\" dojoType=\"dijit.form.Button\"  onClick=\"setCookie();\" type=\"submit\">" + saveButtonText + "</button>");
        out.println("<button id=\"botonReset\" dojoType=\"dijit.form.Button\" type=\"reset\" >" + resetButtonText + "</button>");
        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");
    }
}
