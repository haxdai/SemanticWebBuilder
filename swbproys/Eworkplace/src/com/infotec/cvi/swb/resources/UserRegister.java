package com.infotec.cvi.swb.resources;

import com.infotec.eworkplace.swb.Persona;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.mail.internet.InternetAddress;
import javax.security.auth.Subject;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;
import org.semanticwb.base.util.SFBase64;
import org.semanticwb.platform.SemanticOntology;

/**
 * Recurso de contenido que permite a un usuario registrrse en el sitio, envia
 * un ccrreo para validar la cuenta de correo, activa la cuenta y asignar un rol dado
 *
 * @author rene.jara
 */
public class UserRegister extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(UserRegister.class);
    /** Clave para el cifrador del URL que se envia por correo  */
    private static String PassPhrase="f:,+#u4w=EkJ0R[";
    /** Accion personalizada para activar un usuario     */
    public static final String Action_ACTIVATE="act";
    /** Modo personalizado para ejecutar doThanks   */
    public static final String Mode_THANKS="tnk";
    /** Modo personalizado para ejecutar doFinal          */
    public static final String Mode_FINAL="fnl";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if(Mode_THANKS.equals(mode))
            doThanks(request,response,paramRequest);
        else if(Mode_FINAL.equals(mode))
            doFinal(request,response,paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final String action = response.getAction();
        Resource base = getResourceBase();
        User user = response.getUser();
        
        if(response.Action_ADD.equals(action)) {
            WebPage wp = response.getWebPage();
            WebSite wsite = base.getWebSite();
            UserRepository ur = wsite.getUserRepository();       
                response.setCallMethod(response.Call_CONTENT);
                String login = SWBUtils.XML.replaceXMLChars(request.getParameter("login"));
                String email = SWBUtils.XML.replaceXMLChars(request.getParameter("email"));
                Date birthday=new Date();
                String pwd = request.getParameter("passwd");
                String cpwd = request.getParameter("cpasswd");
                String securCodeSent = request.getParameter("cmnt_seccode");
                String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
                StringBuilder msg = new StringBuilder();
                if( request.getParameter("firstName").isEmpty() ) {
                    msg.append(response.getLocaleString("msgErrFirstNameRequired")).append(",");
                }
                if( request.getParameter("lastName").isEmpty() ) {
                    msg.append(response.getLocaleString("msgErrLastNameRequired")).append(",");
                }
                if( request.getParameter("birthday").isEmpty() ) {
                    msg.append(response.getLocaleString("msgErrBirthdayRequired")).append(",");
                }else {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        birthday = sdf.parse(request.getParameter("birthday"));
                     }catch(ParseException ex){
                         msg.append(response.getLocaleString("lblBirthdayFault")).append(",");
                     }
                }
                if( !SWBUtils.EMAIL.isValidEmailAddress(email) ) {
                    msg.append(response.getLocaleString("msgErrInvalidEmail")).append(",");
                }
                if( pwd==null || cpwd==null || pwd.isEmpty() || cpwd.isEmpty() || !pwd.equals(cpwd) || login.equals(pwd) ) {
                    msg.append(response.getLocaleString("msgErrPasswordRequired")).append(",");
                }
//                if(ur.getUserByLogin(login)!=null || ur.getUserByEmail(email)!=null) {
//                    msg.append(response.getLocaleString("msgErrUserAlreadyExists")).append(",");
//                }
                if(securCodeCreated!=null && !securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                    msg.append(response.getLocaleString("msgErrSecureCodeRequired")).append(",");
                }
                if( securCodeCreated!=null && securCodeCreated.equalsIgnoreCase(securCodeSent) && msg.length()==0 ) {
                    request.getSession(true).removeAttribute("cdlog");
                    try {
                        User newUser = ur.createUser();
                        String strCode = SFBase64.encodeBytes(SWBUtils.CryptoWrapper.PBEAES128Cipher(PassPhrase, newUser.getId().getBytes()));
                        newUser.setActive(false);
                        newUser.setLogin(login);
                        Subject subject = SWBPortal.getUserMgr().getSubject(request, wsite.getId());
                        subject.getPrincipals().clear();
                        subject.getPrincipals().add(newUser);
                        newUser.setPassword(pwd);
                        newUser.setLanguage(user.getLanguage());
                        //newUser.setIp(user.getIp());
                        //newUser.setDevice(user.getDevice());
                        newUser.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                        newUser.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                        newUser.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                        newUser.setEmail(email);

                        Persona persona = Persona.ClassMgr.createPersona(newUser.getId(), wsite);
                        persona.setOwner(newUser);
                        persona.setNacimiento(birthday);

                        final String servidor = request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");
                        
                        final SWBResourceURLImp urlAcc = new SWBResourceURLImp(request, base, wp, SWBResourceURL.UrlType_ACTION);
                        urlAcc.setAction(Action_ACTIVATE).setParameter("id", strCode);
                        final String link = servidor+urlAcc.toString();
                        String sitename = wsite.getDisplayTitle(user.getLanguage());
                        String emailMsg = base.getAttribute("instructions");
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{link}", link);
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{firstname}", newUser.getFirstName());
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{fullname}", newUser.getFullName());
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.login}", newUser.getLogin());
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.email}", newUser.getEmail());
//                        *SWBUtils.EMAIL.sendMail(email, sitename+" - "+response.getLocaleString("msgSubject"), emailMsg);
                        ArrayList aTo = new ArrayList();
                        InternetAddress address = new InternetAddress();
                        address.setAddress(email);
                        aTo.add(address);
                        SWBUtils.EMAIL.sendMail(SWBPortal.getEnv("af/adminEmail","recursoshumanos@infotec.com.mx"),"",aTo,
                        null,null, sitename+" - "+response.getLocaleString("msgSubject"),"html", emailMsg,
                        null,null,null);                               
                        
                        emailMsg = base.getAttribute("emailAgreeMsg");
                        if(emailMsg!=null&&!emailMsg.equals("")){
                            if (base.getAttribute("emailBcc") != null &&
                                    !base.getAttribute("emailBcc").equals("")&&
                                    SWBUtils.EMAIL.isValidEmailAddress(base.getAttribute("emailBcc"))) {
                                address = new InternetAddress();
                                address.setAddress(base.getAttribute("emailBcc"));
                                aTo.add(address);
                            }
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{firstname}", newUser.getFirstName());
                            emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{fullname}", newUser.getFullName());
                            emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.login}", newUser.getLogin());
                            emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.email}", newUser.getEmail());
                            emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{agreement}", base.getAttribute("agreement"));
                            emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{date}", sdf.format(new Date()));
                            SWBUtils.EMAIL.sendMail(SWBPortal.getEnv("af/adminEmail","recursoshumanos@infotec.com.mx"),"",aTo,
                            null,null, response.getLocaleString("lblSubject"),"html", emailMsg,
                            null,null,null);
                        }else{
                            emailMsg=base.getAttribute("agreement");
                        }
                        persona.setAceptacionTerminos(emailMsg);
                        response.setMode(Mode_THANKS);
                    }catch(Exception ne) {
                        ne.printStackTrace(System.out);
                        log.error(ne);
                    }
                }else {
                    response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                    response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                    response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                    response.setRenderParameter("email", email);
                    response.setRenderParameter("birthday", request.getParameter("birthday"));
                    response.setRenderParameter("msg", msg.toString());
                    response.setMode(response.Mode_VIEW);
                }
        }else if(SWBResourceURL.Action_EDIT.equals(action)) {
            String editaccess = request.getParameter("editar");
            String emailAgreeMsg = request.getParameter("emailAgreeMsg");
            String emailBcc = request.getParameter("emailBcc");
            String agreement = request.getParameter("agreement");
            if(editaccess!=null) {
                base.setAttribute("editRole", editaccess);
            }
            base.setAttribute("instructions", request.getParameter("instructions"));
            base.setAttribute("gratefulness", request.getParameter("gratefulness"));
            base.setAttribute("congratulations", request.getParameter("congratulations"));
            if (emailAgreeMsg != null) {
                base.setAttribute("emailAgreeMsg", emailAgreeMsg);
            }
            if (emailBcc != null) {
                base.setAttribute("emailBcc", emailBcc);
            }
            if (agreement != null) {
                base.setAttribute("agreement", agreement);
            }
            response.setAction(response.Action_ADD);
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error("Error al guardar atributos del UserRegister. ", e);
            }
        }else if(Action_ACTIVATE.equals(action)) {
            WebSite wsite = base.getWebSite();
            UserRepository ur = wsite.getUserRepository();  
            
            final String code= request.getParameter("id");
            try {
                String decCode = new String(SWBUtils.CryptoWrapper.PBEAES128Decipher(PassPhrase, SFBase64.decode(code)));
                User usrAct = ur.getUser(decCode);
                setAspirante(usrAct);
                //user = usrAct;
                usrAct.setActive(true);
                response.setMode(Mode_FINAL);
            }catch(Exception ne) {
                ne.printStackTrace(System.out);
                log.error(ne);
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        final String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        
        String msg = request.getParameter("msg");
        if(msg!=null) {
            out.println("<div class=\"\"><p class=\"\">"+msg+"</p></div>");
        }

        User user = paramRequest.getUser();
        if(!user.isSigned()) {
            RequestDispatcher dis = request.getRequestDispatcher(basePath+"/newUser.jsp");
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            }catch (Exception e) {
                log.error(e);
            }
        }else {
            doThanks(request, response, paramRequest);
        }
    }

    /**
     * Modo que muestra un mensaje de agradecimiento por registrarse
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void doThanks(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        
        User user = paramRequest.getUser();
        String msg = getResourceBase().getAttribute("gratefulness");
        msg = SWBUtils.TEXT.replaceAll(msg, "{firstname}", user.getFirstName());
        msg = SWBUtils.TEXT.replaceAll(msg, "{fullname}", user.getFullName());
        msg = SWBUtils.TEXT.replaceAll(msg, "{user.login}", user.getLogin());
        msg = SWBUtils.TEXT.replaceAll(msg, "{user.email}", user.getEmail());
        
        RequestDispatcher dis = request.getRequestDispatcher(basePath+"thanksUser.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("msg", msg);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * Modo que muestra un mensaje el agradecimiento al validar el correo y finalizar el registro
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void doFinal(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        
        User user = paramRequest.getUser();
        String msg = getResourceBase().getAttribute("congratulations");
        msg = SWBUtils.TEXT.replaceAll(msg, "{firstname}", user.getFirstName());
        msg = SWBUtils.TEXT.replaceAll(msg, "{fullname}", user.getFullName());
        msg = SWBUtils.TEXT.replaceAll(msg, "{user.login}", user.getLogin());
        msg = SWBUtils.TEXT.replaceAll(msg, "{user.email}", user.getEmail());

        String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+getResourceBase().getWebSite().getId()+"/Identificacion"+"/_lang/"+user.getLanguage();
        RequestDispatcher dis = request.getRequestDispatcher(basePath+"finalUser.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("url", url);
            request.setAttribute("msg", msg);
            dis.include(request, response);
        }catch (Exception e) {
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
        final String userGroupMessage = paramRequest.getLocaleString("lblRoleGroup");
        final String listMessage = paramRequest.getLocaleString("lblListMessage");
        final String saveButtonText = paramRequest.getLocaleString("lblGuardar");
        final String resetButtonText = paramRequest.getLocaleString("lblReset");
        final String noMsg = paramRequest.getLocaleString("msgNoMsg");

        String action = paramRequest.getAction();
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
        
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"instructions\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblInsToActivate")+"</label>");
        out.println("   <textarea name=\"instructions\" id=\"instructions\" cols=\"25\" rows=\"5\">"+base.getAttribute("instructions",noMsg)+"</textarea>");
        out.println("</li>");
        
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"gratefulness\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblGratefulness")+"</label>");
        out.println("   <textarea name=\"gratefulness\" id=\"gratefulness\" cols=\"25\" rows=\"5\">"+base.getAttribute("gratefulness",noMsg)+"</textarea>");
        out.println("</li>");
        
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"congratulations\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblCongratulations")+"</label>");
        out.println("   <textarea name=\"congratulations\" id=\"congratulations\" cols=\"25\" rows=\"5\">"+base.getAttribute("congratulations",noMsg)+"</textarea>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"emailBcc\" class=\"swbform-label\">" + paramRequest.getLocaleString("lblEmailBcc") + "</label>");
        out.println("   <input type=\"text\" name=\"emailBcc\" id=\"emailBcc\" value=\"" + base.getAttribute("emailBcc", "") + "\" />");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"emailAgreeMsg\" class=\"swbform-label\">" + paramRequest.getLocaleString("lblEmailAgreeMsg") + "</label>");
        out.println("   <textarea name=\"emailAgreeMsg\" id=\"emailAgreeMsg\" cols=\"25\" rows=\"5\">" + base.getAttribute("emailAgreeMsg", "") + "</textarea>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"agreement\" class=\"swbform-label\">" + paramRequest.getLocaleString("lblAgreement") + "</label>");
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
    /**
     * Agrega un rol o grupo guardado en la configuracion del recurso a un usuario dado
     *
     * @param user Usuario al que se le va agregar el rol o grupo
     * @throws Exception Exception occurred
     */
    private void setAspirante(final User user) throws Exception {
        final String grantPrivilegesId = getResourceBase().getAttribute("editRole");
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

