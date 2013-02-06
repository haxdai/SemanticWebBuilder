/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CP;
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Candidato;
import com.infotec.cvi.swb.Colonia;
import com.infotec.cvi.swb.EntidadFederativa;
import com.infotec.cvi.swb.Municipio;
import com.infotec.cvi.swb.base.CVBase;
import com.infotec.eworkplace.swb.Domicilio;
import com.infotec.eworkplace.swb.Familia;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.Telefono;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;

/**
 * Recurso de contenido que muestra la informacion de identificacion del un usuario 
 * y asigna un rol grupo dado al completar la informacion requerida
 * @author rene.jara
 */
public class UserPersonalData extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(UserPersonalData.class);
    /** Modo personalizado para enviar datos por ajax     */
    public static final String Mode_AJAX = "ajax";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if (Mode_AJAX.equals(mode)) {
            doAjax(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final String action = response.getAction();
//TODO  si se planea usarlo para que alguin mas vea  y cambie los datos ajustar aqui tal ves enviando el id usario encriptado
        User user = response.getUser();
        WebPage wp = response.getWebPage();
        WebSite ws = wp.getWebSite();
        UserRepository ur = ws.getUserRepository();
        Resource base = getResourceBase();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (response.Action_ADD.equals(action) && user.isSigned()) {
            try {
                boolean complete = true;
                String curp = request.getParameter("curp");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String secondLastName = request.getParameter("secondLastName");
                String gender = request.getParameter("gender");
                Date birthday = null;
                String strBirthday = request.getParameter("birthday");
                if (strBirthday != null && !strBirthday.equals("")) {
                    try {                        
                        birthday = sdf.parse(strBirthday);
                    } catch (ParseException ignoredException) {
                    }
                }
                EntidadFederativa state = null;
                String strState = request.getParameter("state");
                if (strState != null && !strState.equals("")) {
                    state = EntidadFederativa.ClassMgr.getEntidadFederativa(strState, ws);
                }
                Country nationality = null;
                String strNationality = request.getParameter("nationality");
                if (strNationality != null && !strNationality.equals("")) {
                    nationality = Country.ClassMgr.getCountry(strNationality, ws);
                }
                String fm2 = request.getParameter("fm2");
                String email = request.getParameter("email");
                String sLabor = request.getParameter("sLabor");
                String availability = request.getParameter("availability");

                String marital=request.getParameter("marital");;
                String hasChild=request.getParameter("hasChild");;

                String addrStreet = request.getParameter("addrStreet");
                String addrNumI = request.getParameter("addrNumI");
                String addrNumE = request.getParameter("addrNumE");
                CP addrZip = null;
                String strAddrZip = request.getParameter("addrZip");
                if (strAddrZip != null && !strAddrZip.equals("")) {
                    addrZip = CP.ClassMgr.getCP(strAddrZip, ws);
                }
                Colonia addrCol = null;
                String strAddrCol = request.getParameter("addrCol");
                if (strAddrCol != null && !strAddrCol.equals("")) {
                    addrCol = Colonia.ClassMgr.getColonia(strAddrCol, ws);
                }
                Municipio addrMun = null;
                String strAddrMun = request.getParameter("addrMun");
                if (strAddrMun != null && !strAddrMun.equals("")) {
                    addrMun = Municipio.ClassMgr.getMunicipio(strAddrMun, ws);
                }
                EntidadFederativa addrState = null;
                String strAddrState = request.getParameter("addrState");
                if (strAddrState != null && !strAddrState.equals("")) {
                    addrState = EntidadFederativa.ClassMgr.getEntidadFederativa(strAddrState, ws);
                }
                Country addrCountry = null;
                String strAddrCountry = request.getParameter("addrCountry");
                if (strAddrCountry != null && !strAddrCountry.equals("")) {
                    addrCountry = Country.ClassMgr.getCountry(strAddrCountry, ws);
                }

                String facebook = request.getParameter("facebook");
                String skype = request.getParameter("skype");
                String msn = request.getParameter("msn");
                String linkedin = request.getParameter("linkedin");
                String twitter = request.getParameter("twitter");

                if (firstName != null && !firstName.equals("") && firstName.matches("[a-zA-Z\u00C0-\u00FF' ]+")) {
                    user.setFirstName(SWBUtils.XML.replaceXMLChars(firstName));
                } else {
                    complete = false;
                }
                if (lastName != null && !lastName.equals("") && lastName.matches("[a-zA-Z\u00C0-\u00FF' ]+")) {
                    user.setLastName(SWBUtils.XML.replaceXMLChars(lastName));
                } else {
                    complete = false;
                }
                if (secondLastName != null && !secondLastName.equals("") && secondLastName.matches("[a-zA-Z\u00C0-\u00FF' ]+")) {
                    user.setSecondLastName(SWBUtils.XML.replaceXMLChars(secondLastName));
                } else {
//                    complete = false;
                }

                if (email != null && !email.equals("") && SWBUtils.EMAIL.isValidEmailAddress(email)) {
                    user.setEmail(email);
                } else {
//                    complete = false;
                }

                Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
                if (persona == null) {
                    persona = Persona.ClassMgr.createPersona(user.getId(), ws);
                    persona.setOwner(user);
                } else if (persona.getOwner() == null) {
                    persona.setOwner(user);
                }

                CV cv = CV.ClassMgr.getCV(user.getId(), ws);
                if (cv == null) {
                    cv = CV.ClassMgr.createCV(user.getId(), ws);
                    cv.setPropietario(user);
                    cv.setPersona(persona);
                } else {
                    if (cv.getPersona() == null ) {
                        cv.setPersona(persona);
                    }
                    if (cv.getPropietario() == null) {
                        cv.setPropietario(user);
                    }
                }

                if (curp != null && !curp.equals("") && curp.matches("[a-zA-Z]{4}\\d{6}[a-zA-Z]{6}\\d{2}")) {
                    persona.setCurp(curp);
                } else {
                    complete = false;
                }

                if (gender.equals("f")) {
                    persona.setGenero(true);
                } else if (gender.equals("m")) {
                    persona.setGenero(false);
                } else {
                    complete = false;
                }
                if (birthday != null) {
                    persona.setNacimiento(birthday);
                } else {
                    complete = false;
                }
                if (state != null) {
                    persona.setEstadoNacimiento(state);
                } else {
                    complete = false;
                }
                if (nationality != null) {
                    persona.setNacionalidad(nationality);
                } else {
                    complete = false;
                }
                if (fm2 != null && fm2.equals("true")) {
                    persona.setFM2(true);
                } else {
                    persona.setFM2(false);
                }
                if (marital.equals("y")) {
                    persona.setCasado(true);
                } else if (marital.equals("n")) {
                    persona.setCasado(false);
                } else {
                    complete = false;
                }
                if (hasChild.equals("y")) {
                    persona.setHijos(true);
                } else if (hasChild.equals("n")) {
                    persona.setHijos(false);
                    Iterator<Familia> itf = persona.listFamilias();
                    while (itf.hasNext()) {
                        Familia familia = itf.next();
                        if (familia.getParentesco().equals("son")) {
                            persona.removeFamilia(familia);
                            familia.remove();
                        }
                    }
                } else {
                    complete = false;
                }
                Domicilio domicilio = persona.getDomicilio();
                if (domicilio == null) {
                    domicilio = Domicilio.ClassMgr.createDomicilio(ws);
                    persona.setDomicilio(domicilio);
                }
                if (addrStreet != null && !addrStreet.equals("")) {
                    domicilio.setCalle(addrStreet);
                } else {
                    complete = false;
                }
                if (addrNumE != null && !addrNumE.equals("")) {
                    domicilio.setNumExterior(addrNumE);
                } else {
                    complete = false;
                }
                if (addrNumI != null) {
                    domicilio.setNumInterior(addrNumI);
                } else {
//                    complete=false;
                }
                if (addrZip != null) {
                    domicilio.setCp(addrZip);
                } else {
                    complete = false;
                }
                if (addrCol != null) {
                    domicilio.setColonia(addrCol);
                } else {
                    complete = false;
                }
                if (addrMun != null) {
                    domicilio.setMunicipio(addrMun);
                } else {
                    complete = false;
                }
                if (addrState != null) {
                    domicilio.setEntidad(addrState);
                } else {
                    complete = false;
                }
                if (addrCountry != null) {
                    domicilio.setPais(addrCountry);
                } else {
                    complete = false;
                }
                Iterator<String> item = persona.listPEmails();
                while (item.hasNext()) {
                    String pEmail = item.next();
                    persona.removePEmail(pEmail);
                }
                Enumeration<String> params = request.getParameterNames();
                int phoneCount = 0;
                while (params.hasMoreElements()) {
                    String param = params.nextElement();
                     if (param.startsWith("phoneNum")) {
                        String phoneId = param.substring(8);
                        int phoneNum = 0;
                        int phoneLada = 0;
                        int phoneExt = 0;
                        String phoneType = request.getParameter("phoneType" + phoneId);
                        try {
                            phoneNum = Integer.parseInt(request.getParameter("phoneNum" + phoneId));
                            try {
                                phoneLada = Integer.parseInt(request.getParameter("phoneLada" + phoneId));
                            } catch (NumberFormatException ignoredException) {
                            }
                            phoneExt = Integer.parseInt(request.getParameter("phoneExt" + phoneId));
                        } catch (NumberFormatException ignoredException) {
                        }
                        if (phoneId.startsWith("_") && phoneNum > 0) {
                            Telefono telefono = Telefono.ClassMgr.createTelefono(ws);
                            telefono.setLada(phoneLada);
                            telefono.setNumero(phoneNum);
                            telefono.setExtension(phoneExt);
                            telefono.setTipo(phoneType);
                            persona.addTelefono(telefono);
                        } else if (!phoneId.startsWith("_")) {
                            Iterator<Telefono> itt = persona.listTelefonos();
                            while (itt.hasNext()) {
                                Telefono telefono = itt.next();
                                if (telefono.getId().equals(phoneId)) {
                                    if (phoneNum > 0) {
                                        telefono.setLada(phoneLada);
                                        telefono.setNumero(phoneNum);
                                        telefono.setExtension(phoneExt);
                                        telefono.setTipo(phoneType);
                                    } else {
                                        persona.removeTelefono(telefono);
                                    }
                                }
                            }
                        }
                    } else if (param.startsWith("childName")&&persona.isHijos()) {
                        String childId = param.substring(9);
                        String childName = request.getParameter("childName" + childId).trim();
                        String strChildBirth = request.getParameter("childBirth" + childId);
                        Date childBirth = null;
                        if (strChildBirth != null && !strChildBirth.equals("")) {
                            try {
                                childBirth = sdf.parse(strChildBirth);
                                } catch (ParseException ignoredException) {
                            }
                        }
                        if (childId.startsWith("_") && !childName.equals("")) {
                            Familia familia = Familia.ClassMgr.createFamilia(ws);
                            familia.setNombre(childName);
                            familia.setNacimiento(childBirth);
                            familia.setParentesco("son");
                            persona.addFamilia(familia);
                        } else if (!childId.startsWith("_")) {
                            Iterator<Familia> itf = persona.listFamilias();
                            while (itf.hasNext()) {
                                Familia familia = itf.next();
                                if (familia.getId().equals(childId)) {
                                    if (!childName.equals("")) {
                                        familia.setNombre(childName);
                                        familia.setNacimiento(childBirth);
                                        familia.setParentesco("son");
                                    } else {
                                        persona.removeFamilia(familia);
                                        familia.remove();
                                    }
                                }
                            }
                        }
                    } else if (param.startsWith("pEmail")) {
                        String pEmail = request.getParameter(param);
                        if (pEmail != null && !pEmail.equals("")) {
                            persona.addPEmail(pEmail);
                        }
                    }
                }
                if (facebook != null) {
                    persona.setFacebook(facebook);
                } else {
                    //complete=false;
                }
                if (skype != null) {
                    persona.setSkype(skype);
                } else {
                    //complete=false;
                }
                if (msn != null) {
                    persona.setMsn(msn);
                } else {
                    //complete=false;
                }
                if (linkedin != null) {
                    persona.setLinkedin(linkedin);
                } else {
                    //complete=false;
                }
                if (twitter != null) {
                    persona.setTwitter(twitter);
                } else {
                    //complete=false;
                }
                Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
                if (candidato == null) {
                    candidato = Candidato.ClassMgr.createCandidato(user.getId(), ws);
                }
                try {
                    candidato.setSituacionLaboral(Integer.parseInt(sLabor));
                } catch (NumberFormatException ignoredException) {
                    complete = false;
                }
                try {
                    candidato.setDisponibilidad(Integer.parseInt(availability));
                } catch (NumberFormatException ignoredException) {
                    complete = false;
                }
                if (complete) {
                    setCandidate(user);
                }

            } catch (Exception ex) {
                log.error(ex);
            }
        } else if (SWBResourceURL.Action_EDIT.equals(action)) {
            String editRole = request.getParameter("editRole");
            String completeRole = request.getParameter("completeRole");
            if (editRole != null) {
                base.setAttribute("editRole", editRole);
            }
            if (completeRole != null) {
                base.setAttribute("completeRole", completeRole);
            }
            response.setAction(response.Action_ADD);
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error(e);
            }
        }
        if (response.getMode().equals(Mode_AJAX)) {
            Enumeration eval = request.getParameterNames();
            while (eval.hasMoreElements()) {
                String param = (String) eval.nextElement();
                String value = request.getParameter(param);
                response.setRenderParameter(param, value);
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";

        User user = paramsRequest.getUser();
        Resource base = getResourceBase();
        WebSite ws = base.getWebSite();
        RequestDispatcher dis = request.getRequestDispatcher(basePath + "userData.jsp");
        try {
            request.setAttribute("paramRequest", paramsRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }

    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramRequest.getUser();

        final String resourceUpdatedMessage = paramRequest.getLocaleString("msgRecursoActualizado");
        final String legend = paramRequest.getLocaleString("lblData");
        final String completeRoleGroupMessage = paramRequest.getLocaleString("lblCompleteRoleGroup");
        final String editRoleGroupMessage = paramRequest.getLocaleString("lblEditRoleGroup");
        final String listMessage = paramRequest.getLocaleString("lblListMessage");
        final String saveButtonText = paramRequest.getLocaleString("lblGuardar");
        final String resetButtonText = paramRequest.getLocaleString("lblReset");
        final String noMsg = paramRequest.getLocaleString("msgNoMsg");

        final String action = paramRequest.getAction();
        if (paramRequest.Action_ADD.equals(action)) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('" + resourceUpdatedMessage + " " + base.getId() + "');");
            out.println("   location='" + paramRequest.getRenderUrl().setAction(paramRequest.Action_EDIT).toString() + "';");
            out.println("</script>");
        }
        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();

        String strEditRoleGroup = base.getAttribute("editRole", "0");
        String strCompleteRoleGroup = base.getAttribute("completeRole", "0");

        SWBResourceURL urlAction = paramRequest.getActionUrl();
        urlAction.setAction(paramRequest.Action_EDIT);

        out.println("<div class=\"swbform\">");
        out.println("<form id=ilta_\"" + base.getId() + "\" name=\"ilta_" + base.getId() + "\" action=\"" + urlAction + "\" method=\"post\" >");
        out.println("<fieldset><legend>" + legend + "</legend>");

        String strTempEdit = "<option value=\"-1\">" + "No se encontaron roles" + "</option>";
        Iterator<Role> iRoles = wsite.getUserRepository().listRoles();
        StringBuilder strRules = new StringBuilder();
        String selectedEdit = "";
        if (strEditRoleGroup.equals("0")) {
            selectedEdit = " selected=\"selected\"";
        }
        strRules.append("\n<option value=\"0\" ");
        strRules.append(selectedEdit);
        strRules.append(">");
        strRules.append(listMessage);
        strRules.append("</option>");
        strRules.append("\n<optgroup label=\"Roles\">");
        while (iRoles.hasNext()) {
            Role oRole = iRoles.next();
            selectedEdit = "";
            if (strEditRoleGroup.trim().equals(oRole.getURI())) {
                selectedEdit = " selected=\"selected\"";
            }
            strRules.append("\n<option value=\"");
            strRules.append(oRole.getURI());
            strRules.append("\"");
            strRules.append(selectedEdit);
            strRules.append(">");
            strRules.append(oRole.getDisplayTitle(user.getLanguage()));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        strRules.append("\n<optgroup label=\"User Groups\">");
        Iterator<UserGroup> iugroups = wsite.getUserRepository().listUserGroups();
        while (iugroups.hasNext()) {
            UserGroup oUG = iugroups.next();
            selectedEdit = "";
            if (strEditRoleGroup.trim().equals(oUG.getURI())) {
                selectedEdit = " selected=\"selected\"";
            }
            strRules.append("\n<option value=\"");
            strRules.append(oUG.getURI());
            strRules.append("\"");
            strRules.append(selectedEdit);
            strRules.append(">");
            strRules.append(oUG.getDisplayTitle(user.getLanguage()));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        if (strRules.toString().length() > 0) {
            strTempEdit = strRules.toString();
        }
        String strTempComplete = "<option value=\"-1\">" + "No se encontaron roles" + "</option>";
        iRoles = wsite.getUserRepository().listRoles();
        strRules = new StringBuilder();
        String selectedComplete = "";
        if (strCompleteRoleGroup.equals("0")) {
            selectedComplete = " selected=\"selected\"";
        }
        strRules.append("\n<option value=\"0\" ");
        strRules.append(selectedComplete);
        strRules.append(">");
        strRules.append(listMessage);
        strRules.append("</option>");
        strRules.append("\n<optgroup label=\"Roles\">");
        while (iRoles.hasNext()) {
            Role oRole = iRoles.next();
            selectedComplete = "";
            if (strCompleteRoleGroup.trim().equals(oRole.getURI())) {
                selectedComplete = " selected=\"selected\"";
            }
            strRules.append("\n<option value=\"");
            strRules.append(oRole.getURI());
            strRules.append("\"");
            strRules.append(selectedComplete);
            strRules.append(">");
            strRules.append(oRole.getDisplayTitle(user.getLanguage()));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        strRules.append("\n<optgroup label=\"User Groups\">");
        iugroups = wsite.getUserRepository().listUserGroups();
        while (iugroups.hasNext()) {
            UserGroup oUG = iugroups.next();
            selectedComplete = "";
            if (strCompleteRoleGroup.trim().equals(oUG.getURI())) {
                selectedComplete = " selected=\"selected\"";
            }
            strRules.append("\n<option value=\"");
            strRules.append(oUG.getURI());
            strRules.append("\"");
            strRules.append(selectedComplete);
            strRules.append(">");
            strRules.append(oUG.getDisplayTitle(user.getLanguage()));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        if (strRules.toString().length() > 0) {
            strTempComplete = strRules.toString();
        }
        out.println("<ul class=\"swbform-ul\">");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"editar\" class=\"swbform-label\">" + editRoleGroupMessage + "</label>");
        out.print("     <select id=\"editar\" name=\"editRole\">" + strTempEdit + "</select>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"completeRole\" class=\"swbform-label\">" + completeRoleGroupMessage + "</label>");
        out.print("     <select id=\"completeRole\" name=\"completeRole\">" + strTempComplete + "</select>");
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

    /**
     *  Modo que procesa las peticiones de las consultas ajax de la forma para CP
     *
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doAjax(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        RequestDispatcher dis = request.getRequestDispatcher(basePath + "ajaxData.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * Agrega un rol o grupo guardado en la configuracion del recurso a un usuario dado
     *
     * @param user Usuario al que se le va agregar el rol o grupo
     * @throws Exception Exception occurred
     */
    private void setCandidate(final User user) throws Exception {
        final String editPrivilegesId = getResourceBase().getAttribute("editRole");
        final String completePrivilegesId = getResourceBase().getAttribute("completeRole");
        if (user != null && user.isSigned()) {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject eobj, cobj;
            eobj = ont.getGenericObject(editPrivilegesId);
            cobj = ont.getGenericObject(completePrivilegesId);
            if ((editPrivilegesId.equals("0") || (hasRoleGroup(user, eobj))) && !hasRoleGroup(user, cobj)) {
                if (cobj != null) {
                    if (cobj instanceof UserGroup) {
                        UserGroup ugrp = (UserGroup) cobj;
                        if (!user.hasUserGroup(ugrp)) {
                            user.addUserGroup(ugrp);
                        }
                    } else if (cobj instanceof Role) {
                        Role urole = (Role) cobj;
                        if (!user.hasRole(urole)) {
                            user.addRole(urole);
                        }
                    }
                }
                if (eobj != null) {
                    if (eobj instanceof UserGroup) {
                        UserGroup ugrp = (UserGroup) eobj;
                        user.removeUserGroup(ugrp);
                    } else if (eobj instanceof Role) {
                        Role urole = (Role) eobj;
                        user.removeRole(urole);
                    }
                }
            }
        }
    }

    /**
     * Devuelve true cuando un usuario dado tiene un rol o grupo asignado
     *
     * @param user Usuario al que se le va agregar el rol o grupo
     * @param roleGroupObj Rol o grupo que se desea buscar
     * @throws Exception Exception occurred
     */
    private boolean hasRoleGroup(final User user, GenericObject roleGroupObj) throws Exception {
        boolean has = false;
        if (user != null) {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            if (roleGroupObj != null) {
                if (roleGroupObj instanceof UserGroup) {
                    UserGroup ugrp = (UserGroup) roleGroupObj;
                    if (user.hasUserGroup(ugrp)) {
                        has = true;
                    }
                } else if (roleGroupObj instanceof Role) {
                    Role urole = (Role) roleGroupObj;
                    if (user.hasRole(urole)) {
                        has = true;
                    }
                }
            }
        }
        return has;
    }
}
