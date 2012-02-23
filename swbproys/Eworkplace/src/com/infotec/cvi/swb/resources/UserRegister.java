package com.infotec.cvi.swb.resources;

import com.infotec.eworkplace.swb.Persona;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;
import org.semanticwb.base.util.SFBase64;
import org.semanticwb.platform.SemanticOntology;

/**
 *
 * @author rene.jara
 */
public class UserRegister extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(UserRegister.class);
    private static String PassPhrase="f:,+#u4w=EkJ0R[";
    public static final String Action_ACTIVATE="act";
    public static final String Mode_THANKS="tnk";
    public static final String Mode_FINAL="fnl";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals(Mode_THANKS))
            doThanks(request,response,paramRequest);
        else if(paramRequest.getMode().equals(Mode_FINAL))
            doFinal(request,response,paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final String action = response.getAction();
        User user = response.getUser();
        WebPage wp=response.getWebPage();
        WebSite ws = wp.getWebSite();
        UserRepository ur = ws.getUserRepository();        
        Resource base = getResourceBase();
        if(response.Action_ADD.equals(action)) {
            try{
                response.setCallMethod(response.Call_CONTENT);
                String email = SWBUtils.XML.replaceXMLChars(request.getParameter("email"));
                Date birthday=new Date();
                String pwd = request.getParameter("passwd");
                String cpwd = request.getParameter("cpasswd");
                String securCodeSent = request.getParameter("cmnt_seccode");
                String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
                StringBuilder msg = new StringBuilder();
                if( request.getParameter("firstName")==null || "".equals(request.getParameter("firstName")) ) {
                    msg.append(response.getLocaleString("msgErrFirstNameRequired")).append(",");
                }
                if( request.getParameter("lastName")==null || "".equals(request.getParameter("lastName")) ) {
                    msg.append(response.getLocaleString("msgErrLastNameRequired")).append(",");
                }
                if( request.getParameter("birthday")==null || "".equals(request.getParameter("birthday")) ) {
                    msg.append(response.getLocaleString("msgErrBirthdayRequired")).append(",");
                }else{
                try{
                        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

                        birthday=sdf.parse(request.getParameter("birthday"));
                         }catch(ParseException ex){
                             msg.append(response.getLocaleString("lblBirthdayFault")).append(",");
                         }
                }
                if( !SWBUtils.EMAIL.isValidEmailAddress(email) ) {
                    msg.append(response.getLocaleString("msgErrInvalidEmail")).append(",");
                }
                if( pwd==null || cpwd==null || pwd.isEmpty() || cpwd.isEmpty() || !pwd.equals(cpwd) ) {
                    msg.append(response.getLocaleString("msgErrPasswordRequired")).append(",");
                }
                if(ur.getUserByLogin(email)!=null) {
                    msg.append(response.getLocaleString("msgErrUserAlreadyExists")).append(",");
                }
                if(securCodeCreated!=null && !securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                    msg.append(response.getLocaleString("msgErrSecureCodeRequired")).append(",");
                }
                if( securCodeCreated!=null && securCodeCreated.equalsIgnoreCase(securCodeSent) && ur.getUserByLogin(email)==null && msg.length()==0) {
                    request.getSession(true).removeAttribute("cdlog");
                    User newUser = ur.createUser();
                    newUser.setLogin(email);
                    newUser.setActive(false);
                    newUser.setLanguage(user.getLanguage());
                    newUser.setIp(user.getIp());
                    newUser.setDevice(user.getDevice());
                    newUser.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                    newUser.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                    newUser.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                    newUser.setEmail(email);
                    newUser.setPassword(pwd);
                    newUser.checkCredential(pwd.toCharArray());
                    
                    Persona persona = Persona.ClassMgr.createPersona(newUser.getId(), ws);
                    persona.setOwner(newUser);
                    persona.setNacimiento(birthday);

                    String servidor = request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");
                    SWBResourceURLImp urlAcc = new SWBResourceURLImp(request, base, wp, SWBResourceURL.UrlType_ACTION);
                    urlAcc.setAction(Action_ACTIVATE);
                    String strCode=SFBase64.encodeBytes(SWBUtils.CryptoWrapper.PBEAES128Cipher(PassPhrase,newUser.getId().getBytes()));
                    urlAcc.setParameter("id",strCode);

                    String sitename = ws.getDisplayTitle(response.getUser().getLanguage());
                    String emailMsg = base.getAttribute("emailMsg","No Message");
                    emailMsg+="\n"+servidor+urlAcc.toString();
                    
                    SWBUtils.EMAIL.sendMail("gsixtos@infotec.com.mx", sitename+" - "+response.getLocaleString("msgSubject"), emailMsg);
                    response.setMode(Mode_THANKS);
                }else {
                    response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                    response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                    response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                    response.setRenderParameter("email", email);
                    response.setRenderParameter("birthday", request.getParameter("birthday"));
                    response.setRenderParameter("msg", msg.toString());
                    response.setMode(response.Mode_VIEW);
                }
            }catch(Exception ne) {
                 log.error(ne);
            }
        }else if(Action_ACTIVATE.equals(action)) {
            String code= request.getParameter("id");
            try{
                String decCode = new String(SWBUtils.CryptoWrapper.PBEAES128Decipher(PassPhrase, SFBase64.decode(code)));
                User usrAct = ur.getUser(decCode);
                setCandidate(usrAct);
                user = usrAct;
                user.setActive(true);
                response.setMode(Mode_FINAL);
            }catch(Exception ne) {
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
//            RequestDispatcher dis = request.getRequestDispatcher("/work/models/"+model+"/jsp/messages.jsp");
//            request.setAttribute("msg","ok");
//            try {
//                request.setAttribute("paramRequest", paramRequest);
//                dis.include(request, response);
//            }catch (Exception e) {
//                log.error(e);
//            }
        }
    }

    public void doThanks(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        User user = paramRequest.getUser();
        RequestDispatcher dis = request.getRequestDispatcher(basePath+"thanksUser.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
        }
    }

    public void doFinal(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        User user = paramRequest.getUser();
        String servidor = request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");
        String url=servidor+"/swb/eworkplace/datos_personales/";
        RequestDispatcher dis = request.getRequestDispatcher(basePath+"finalUser.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("url", url);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void doHelp(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramRequest.getUser();

        String resourceUpdatedMessage = paramRequest.getLocaleString("usrmsg_Admin_msgRecursoActualizado");
        String legend = paramRequest.getLocaleString("usrmsg_Admin_Data");
        String userGroupMessage = paramRequest.getLocaleString("usrmsg_Admin_RollGroup");
        String listMessage = paramRequest.getLocaleString("usrmsg_Admin_ListMessage");
        String saveButtonText = paramRequest.getLocaleString("usrmsg_Admin_btnGuardar");
        String resetButtonText = paramRequest.getLocaleString("usrmsg_Admin_btnReset");

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
