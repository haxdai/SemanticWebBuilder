/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CP;
import com.infotec.cvi.swb.Candidato;
import com.infotec.cvi.swb.Colonia;
import com.infotec.cvi.swb.EntidadFederativa;
import com.infotec.cvi.swb.Municipio;
import com.infotec.eworkplace.swb.Domicilio;
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
 *
 * @author rene.jara
 */
public class UserPersonalData extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(UserPersonalData.class);

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
//System.out.println("processAction");
        final String action = response.getAction();
//TODO  si se planea usarlo para que alguin mas vea  y cambie los datos ajustar aqui tal ves enviando el id usario encriptado
        User user = response.getUser();
        WebPage wp = response.getWebPage();
        WebSite ws = wp.getWebSite();
        UserRepository ur = ws.getUserRepository();
        Resource base = getResourceBase();
//System.out.println("action:" + action);
        if(response.Action_ADD.equals(action) && user.isSigned()) {
            try {
               /* if (request.getParameter("usrPassword") != null && !"{MD5}tq5RXfs6DGIXD6dlHUgeQA==".equalsIgnoreCase(request.getParameter("usrPassword"))) {
                    user.setPassword(request.getParameter("usrPassword"));
                }*/
                boolean complete=true;
                String curp=request.getParameter("curp");
                String firstName=request.getParameter("firstName");
                String lastName=request.getParameter("lastName");
                String secondLastName=request.getParameter("secondLastName");
                String gender=request.getParameter("gender");
                Date birthday=null;
                String strBirthday=request.getParameter("birthday");
                if(strBirthday!=null && !strBirthday.equals("")) {
                    try{
                        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                        birthday=sdf.parse(strBirthday);
                     }catch(ParseException ignoredException){
                     }
                }
                EntidadFederativa state=null;
                String strState=request.getParameter("state");
                if(strState!=null && !strState.equals("")){
                    state=EntidadFederativa.ClassMgr.getEntidadFederativa(strState, ws);
                }
                Country nationality=null;
                String strNationality=request.getParameter("nationality");
                if(strNationality!=null && !strNationality.equals("")){
                    nationality =Country.ClassMgr.getCountry(strNationality, ws);
                }
                String fm2=request.getParameter("fm2");
                String email = request.getParameter("email");
                //String phoneUser = request.getParameter("phoneUser");
                String sLabor = request.getParameter("sLabor");
                String availability = request.getParameter("availability");

                String addrStreet=request.getParameter("addrStreet");
                String addrNumI=request.getParameter("addrNumI");
                String addrNumE=request.getParameter("addrNumE");
                CP addrZip=null;
                String strAddrZip=request.getParameter("addrZip");
                if(strAddrZip!=null && !strAddrZip.equals("")){
                    addrZip =CP.ClassMgr.getCP(strAddrZip, ws);
                }
                Colonia addrCol=null;
                String strAddrCol=request.getParameter("addrCol");
                if(strAddrCol!=null && !strAddrCol.equals("")){
                    addrCol =Colonia.ClassMgr.getColonia(strAddrCol, ws);
                }
                Municipio addrMun=null;
                String strAddrMun=request.getParameter("addrMun");
                if(strAddrMun!=null && !strAddrMun.equals("")){
                    addrMun =Municipio.ClassMgr.getMunicipio(strAddrMun, ws);
                }
                EntidadFederativa addrState=null;
                String strAddrState=request.getParameter("addrState");
                if(strAddrState!=null && !strAddrState.equals("")){
                    addrState =EntidadFederativa.ClassMgr.getEntidadFederativa(strAddrState, ws);
                }
                Country addrCountry=null;
                String strAddrCountry=request.getParameter("addrCountry");
                if(strAddrCountry!=null && !strAddrCountry.equals("")){
                    addrCountry =Country.ClassMgr.getCountry(strAddrCountry, ws);
                }

                String facebook = request.getParameter("facebook");
                String skype = request.getParameter("skype");
                String msn = request.getParameter("msn");
                String linkedin = request.getParameter("linkedin");
                String twitter = request.getParameter("twitter");

//System.out.println(firstName.matches("[a-zA-Z\u00C0-\u00FF' ]+"));
                if (firstName!=null&&!firstName.equals("")&&firstName.matches("[a-zA-Z\u00C0-\u00FF' ]+")){
                    user.setFirstName(SWBUtils.XML.replaceXMLChars(firstName));
                }else{
                    complete=false;
                }
                if (lastName!=null&&!lastName.equals("")&&lastName.matches("[a-zA-Z\u00C0-\u00FF' ]+")){
                    user.setLastName(SWBUtils.XML.replaceXMLChars(lastName));
                }else{
                    complete=false;
                }
                if (secondLastName!=null&&!secondLastName.equals("")&&secondLastName.matches("[a-zA-Z\u00C0-\u00FF' ]+")){
                    user.setSecondLastName(SWBUtils.XML.replaceXMLChars(secondLastName));
                }else{
                    complete=false;
                }

                Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
                if (persona == null) {
                    persona = Persona.ClassMgr.createPersona(user.getId(), ws);
                    persona.setOwner(user);
                }else if(persona.getOwner()==null){
                    persona.setOwner(user);
                }

                if (curp!=null&&!curp.equals("")&&curp.matches("[a-zA-Z]{4}\\d{6}[a-zA-Z]{6}\\d{2}")){
                    persona.setCurp(curp);
                }else{
                    complete=false;
                }

                if (gender.equals("f")){
                    persona.setGenero(true);
                }else if(gender.equals("m")){
                    persona.setGenero(false);
                }else{
                    complete=false;
                }

                if (birthday!=null){
                    persona.setNacimiento(birthday);
                }else{
                    complete=false;
                }

                persona.setLugarNacimiento(null);

                if (nationality!=null){
                    persona.setNacionalidad(nationality);
                }else{
                    complete=false;
                }
//                if (fm2!=null&&!fm2.equals("")&&fm2.matches("\\d+")){
//                    persona.setFM2(fm2);
//                }else{
//                    complete=false;
//                }

                Domicilio domicilio=persona.getDomicilio();
                if(domicilio==null){
                    domicilio = Domicilio.ClassMgr.createDomicilio(ws);
                    persona.setDomicilio(domicilio);
                }
                if (addrStreet!=null){
                    domicilio.setCalle(addrStreet);
                }else{
                    complete=false;
                }
                if (addrNumE!=null){
                    domicilio.setNumExterior(addrNumE);
                }else{
                    complete=false;
                }
                if (addrNumI!=null){
                    domicilio.setNumInterior(addrNumI);
                }else{
                    complete=false;
                }
                if (addrZip!=null){
                    domicilio.setCp(addrZip);
                }else{
                    complete=false;
                }
                if (addrCol!=null){
                    domicilio.setColonia(addrCol);
                }else{
                    complete=false;
                }
                if (addrMun!=null){
                    domicilio.setMunicipio(addrMun);
                }else{
                    complete=false;
                }
                if (addrState!=null){
                    domicilio.setEntidad(addrState);
                }else{
                    complete=false;
                }
                if (addrCountry!=null){
                    domicilio.setPais(addrCountry);
                }else{
                    complete=false;
                }

                Enumeration<String> params=request.getParameterNames();
                while(params.hasMoreElements()){
                    String param=params.nextElement();
                    if (param.startsWith("phoneNum")){
                        String phoneId=param.substring(8);
                        int phoneNum=0;
                        int phoneLada=0;
                        int phoneExt=0;
                        String phoneType=request.getParameter("phoneType"+phoneId);
                        try{
                            phoneNum=Integer.parseInt(request.getParameter("phoneNum"+phoneId));
                            try{
                                phoneLada=Integer.parseInt(request.getParameter("phoneLada"+phoneId));
                            }catch(NumberFormatException ignoredException){
                            }
                            phoneExt=Integer.parseInt(request.getParameter("phoneExt"+phoneId));
                        }catch(NumberFormatException ignoredException){
                        }

//System.out.println("phoneId:"+phoneId);
//System.out.println("phonenum"+request.getParameter("phoneNum"+phoneId));
                        if(phoneId.startsWith("_")&&phoneNum>0){
                            Telefono telefono=Telefono.ClassMgr.createTelefono(ws);
                            telefono.setLada(phoneLada);
                            telefono.setNumero(phoneNum);
                            telefono.setExtension(phoneExt);
                            telefono.setTipo(phoneType);
                            persona.addTelefono(telefono);
                        }else if(!phoneId.startsWith("_")){
                            Iterator<Telefono>  itt=persona.listTelefonos();
                            while(itt.hasNext()){
                                Telefono telefono=itt.next();
//System.out.println("telefonoId:"+telefono.getId());
//System.out.println("phonenum:"+phoneNum);
//System.out.println("phoneId:"+phoneId);
                                if(telefono.getId().equals(phoneId)){
                                    if(phoneNum>0){
//System.out.println("actualizar:");
                                        telefono.setLada(phoneLada);
                                        telefono.setNumero(phoneNum);
                                        telefono.setExtension(phoneExt);
                                        telefono.setTipo(phoneType);
                                    }else{
//System.out.println("borrar:"+phoneId);
                                        persona.removeTelefono(telefono);
                                    }
                                }
                            }
                        }
                    }
                }


                //sLabor = request.getParameter("sLabor");
                 //avalibility = request.getParameter("avalibility");

                if (facebook!=null&&!facebook.equals("")&&facebook.matches(".+")){
                    persona.setFacebook(facebook);
                }else{
                    //complete=false;
                }
                if (skype!=null&&!skype.equals("")&&skype.matches(".+")){
                    persona.setSkype(skype);
                }else{
                    //complete=false;
                }
                if (msn!=null&&!msn.equals("")&&msn.matches(".+")){
                    persona.setMsn(msn);
                }else{
                    //complete=false;
                }
                if (linkedin!=null&&!linkedin.equals("")&&linkedin.matches(".+")){
                    persona.setLinkedin(linkedin);
                }else{
                    //complete=false;
                }
                if (twitter!=null&&!twitter.equals("")&&twitter.matches(".+")){
                    persona.setTwitter(twitter);
                }else{
                    //complete=false;
                }
                Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
                if (candidato == null) {
                    candidato = Candidato.ClassMgr.createCandidato(user.getId(), ws);
                }
                try{
                    candidato.setSituacionLaboral(Integer.parseInt(sLabor));
                }catch(NumberFormatException ignoredException){
                    complete=false;
                }
                try{
                    candidato.setDisponibilidad(Integer.parseInt(availability));
                }catch(NumberFormatException ignoredException){
                    complete=false;
                }
complete = true;
                if(complete) {
                    setCandidate(user);
                }

            } catch (Exception ex) {
                log.error(ex);
            }
        }else if(SWBResourceURL.Action_EDIT.equals(action)) {
            String editaccess = request.getParameter("editar");
            if(editaccess!=null) {
                base.setAttribute("editRole", editaccess);
            }
            response.setAction(response.Action_ADD);
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error(e);
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
        //String wsid = paramsRequest.getWebPage().getWebSiteId();
        /*
        String msg = request.getParameter("msg");
        String model = paramRequest.getWebPage().getWebSiteId();

        if(msg!=null) {
        out.println("<div class=\"\"><p class=\"\">"+msg+"</p></div>");
        }
         */

        //if(!user.isSigned()) {
/*        Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
        if (persona == null) {
            persona = Persona.ClassMgr.createPersona(user.getId(), ws);
            persona.setOwner(user);
        }else if(persona.getOwner()==null){
            persona.setOwner(user);
        }
        Persona capersona = Persona.ClassMgr.getPersona(user.getId(), ws);
        if(){}
*/        RequestDispatcher dis = request.getRequestDispatcher(basePath+"userData.jsp");
        try {
            request.setAttribute("paramRequest", paramsRequest);
//            request.setAttribute("persona", persona);
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
        final String userGroupMessage = paramRequest.getLocaleString("lblRollGroup");
        final String listMessage = paramRequest.getLocaleString("lblListMessage");
        final String saveButtonText = paramRequest.getLocaleString("lblGuardar");
        final String resetButtonText = paramRequest.getLocaleString("lblReset");
        final String noMsg = paramRequest.getLocaleString("msgNoMsg");

        final String action = paramRequest.getAction();
        if(paramRequest.Action_ADD.equals(action)) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('"+resourceUpdatedMessage+" "+base.getId()+"');");
            out.println("   location='"+paramRequest.getRenderUrl().setAction(paramRequest.Action_EDIT).toString()+"';");
            out.println("</script>");
        }
        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();

        String str_role = base.getAttribute("editRole", "0");

        SWBResourceURL urlAction = paramRequest.getActionUrl();
        urlAction.setAction(paramRequest.Action_EDIT);

        out.println("<div class=\"swbform\">");
        out.println("<form id=ilta_\""+base.getId()+"\" name=\"ilta_"+base.getId()+"\" action=\""+urlAction+"\" method=\"post\" >");
        out.println("<fieldset><legend>"+ legend+ "</legend>");

        String strTemp = "<option value=\"-1\">" + "No se encontaron roles" + "</option>";
        Iterator<Role> iRoles = wsite.getUserRepository().listRoles();
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
            if(str_role.trim().equals(oRole.getURI())) {
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
        Iterator<UserGroup> iugroups = wsite.getUserRepository().listUserGroups();
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
        if(strRules.toString().length() > 0) {
            strTemp = strRules.toString();
        }
        out.println("<ul class=\"swbform-ul\">");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"editar\" class=\"swbform-label\">"+userGroupMessage+"</label>");
        out.print("     <select id=\"editar\" name=\"editar\">"+strTemp+"</select>");
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
    
    private void setCandidate(final User user) throws Exception {
        final String grantPrivilegesId = getResourceBase().getAttribute("editRole");
        if( user!=null && user.isSigned() ) {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj;
            gobj = ont.getGenericObject(grantPrivilegesId);
            if( gobj!=null ) {
                if(gobj instanceof UserGroup) {
                    UserGroup ugrp = (UserGroup) gobj;
                    user.addUserGroup(ugrp);
                }else if(gobj instanceof Role) {
                    Role urole = (Role) gobj;
                    user.addRole(urole);
                }
            }
        }
    }
}
