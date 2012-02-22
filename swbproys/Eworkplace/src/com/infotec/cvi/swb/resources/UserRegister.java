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

public class UserRegister extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(UserRegister.class);
    private static String PassPhrase="f:,+#u4w=EkJ0R[";
    public static final String Action_ACTIVATE="act";
    public static final String Mode_THANKS="tnk";
    public static final String Mode_FINAL="fnl";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
//System.out.println("processRequest");
        if(paramRequest.getMode().equals(Mode_THANKS))
            doThanks(request,response,paramRequest);
        else if(paramRequest.getMode().equals(Mode_FINAL))
            doFinal(request,response,paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
//System.out.println("processAction");
        String action = response.getAction();
        User user = response.getUser();
        WebPage wp=response.getWebPage();
        WebSite ws = wp.getWebSite();
        UserRepository ur = ws.getUserRepository();        
        Resource base = getResourceBase();
//System.out.println("action:"+action);
        if(response.Action_ADD.equals(action)) {
            try{
                response.setCallMethod(response.Call_CONTENT);

    //            WebSite wsite = response.getWebPage().getWebSite();
    //            UserRepository ur = wsite.getUserRepository();

                String email = SWBUtils.XML.replaceXMLChars(request.getParameter("email"));
                Date birthday=new Date();
                String pwd = request.getParameter("passwd");
                String cpwd = request.getParameter("cpasswd");
                String securCodeSent = request.getParameter("cmnt_seccode");
                String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
// TORG agregar validacion por expresiones regulares
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
//TORG se va a validar dos correos
                if( pwd==null || cpwd==null || pwd.isEmpty() || cpwd.isEmpty() || !pwd.equals(cpwd) ) {
                    msg.append(response.getLocaleString("msgErrPasswordRequired")).append(",");
                }
/*                if(user.isSigned()) {
                    msg.append(response.getLocaleString("msgErrUserAlreadySigned")).append(",");
                }*/
                if(ur.getUserByLogin(email)!=null) {
                    msg.append(response.getLocaleString("msgErrUserAlreadyExists")).append(",");
                }
                if(securCodeCreated!=null && !securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                    msg.append(response.getLocaleString("msgErrSecureCodeRequired")).append(",");
                }
// TORG validar teminos y condiciones
    //System.out.println("msg:"+msg);
                if( securCodeCreated!=null && securCodeCreated.equalsIgnoreCase(securCodeSent) && ur.getUserByLogin(email)==null && msg.length()==0) {
    //System.out.println("a");
                    request.getSession(true).removeAttribute("cdlog");

                    User newUser = ur.createUser();
                    newUser.setLogin(email);
    //                Subject subject = SWBPortal.getUserMgr().getSubject(request, response.getWebPage().getWebSiteId());
    //                subject.getPrincipals().clear();
    //                subject.getPrincipals().add(newUser);
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

                    //user = newUser;
                    Persona persona = Persona.ClassMgr.createPersona(newUser.getId(), ws);
                        persona.setOwner(newUser);
                        persona.setNacimiento(birthday);


    /*
                    try {
                        Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://portal.medicasur.com.mx#_ExtendedAttributes").listProperties();
                        while(list.hasNext()) {
                            SemanticProperty sp = list.next();
                            if(request.getParameter(sp.getName())==null) {
                                newUser.removeExtendedAttribute(sp);
                            }else {
                                if(sp.isString()) {
                                    user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
                                }
                            }
                        }
                    }catch(SWBException nex) {
                        log.error(nex);
                        response.setRenderParameter("msg", nex.getMessage());
                    }

     */
                    String servidor = request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");
                    SWBResourceURLImp urlAcc = new SWBResourceURLImp(request, base, wp, SWBResourceURL.UrlType_ACTION);
                    urlAcc.setAction(Action_ACTIVATE);
                    String strCode=SFBase64.encodeBytes(SWBUtils.CryptoWrapper.PBEAES128Cipher(PassPhrase,newUser.getId().getBytes()));
                    urlAcc.setParameter("id",strCode);
//                    urlAcc.setExtURIParams("/rg/"+user.getId());

                    String sitename = ws.getDisplayTitle(response.getUser().getLanguage());
                    String emailMsg = base.getAttribute("emailMsg","No Message");
                    emailMsg+="\n"+servidor+urlAcc.toString();

// TORG Cambiar  destinatario de correos y mensaje de correo
                    SWBUtils.EMAIL.sendMail("gsixtos@infotec.com.mx", sitename+" - "+response.getLocaleString("msgSubject"), emailMsg);
    //                response.setMode(response.Mode_HELP);
                    response.setMode(Mode_THANKS);
                }else {
    //System.out.println("a");
                    //response.setRenderParameter("passwd", pwd);
                    //response.setRenderParameter("cpasswd", cpwd);
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
        }
        else if(response.getAction().equals(Action_ACTIVATE)) {
            String code= request.getParameter("id");
//System.out.println("id"+id);
            try{

//System.out.println("pre:"+SFBase64.decode(id));
                String decCode=new String(SWBUtils.CryptoWrapper.PBEAES128Decipher(PassPhrase, SFBase64.decode(code)));
//System.out.println("decpwd:"+decpwd);
                User us=ur.getUser(decCode);
                us.setActive(true);
//System.out.println("user:"+us.getLogin());
                response.setMode(Mode_FINAL);
            }catch(Exception ne) {
                 log.error(ne);
            }

            
        }/*
        else if("edit".equals(response.getAction()) && user.isSigned()) {
            if (request.getParameter("usrPassword")!=null && !"{MD5}tq5RXfs6DGIXD6dlHUgeQA==".equalsIgnoreCase(request.getParameter("usrPassword")))
            {
                user.setPassword(request.getParameter("usrPassword"));
            }
            user.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrFirstName")));
            user.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrLastName")));
            user.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrSecondLastName")));
            user.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("usrEmail")));
            try {
                Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#_ExtendedAttributes").listProperties();
                while (list.hasNext()) {
                    SemanticProperty sp = list.next();
                    if (null == request.getParameter(sp.getName())) {
                        user.removeExtendedAttribute(sp);
                    } else {
                        if (sp.isString()) {
                            user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
                        }
                        if (sp.isInt()) {
                            try {
                                Integer val = Integer.valueOf(request.getParameter(sp.getName()));
                                user.setExtendedAttribute(sp, val);
                            } catch (Exception ne) {
                            }
                        }
                        if (sp.isDouble()) {
                            try {
                                Double val = Double.valueOf(request.getParameter(sp.getName()));
                                user.setExtendedAttribute(sp, val);
                            } catch (Exception ne) {
                            }
                        }
                        if (sp.isDate()) {
                            try {
                                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                               Date val = sf.parse(request.getParameter(sp.getName()));
                                user.setExtendedAttribute(sp, val);
                            } catch (Exception ne) {
                                log.error(ne);
                            }
                        }

                    }
                }
            }catch (SWBException nex) {
                log.error(nex);
            }
        }
        else if("upload".equals(response.getAction()) && user.isSigned()) {
        }
        */

    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String msg = request.getParameter("msg");


        if(msg!=null) {
            out.println("<div class=\"\"><p class=\"\">"+msg+"</p></div>");
        }

        User user = paramRequest.getUser();
        //if(!user.isSigned()) {
            RequestDispatcher dis = request.getRequestDispatcher(basePath+"/newUser.jsp");
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            }catch (Exception e) {
                log.error(e);
            }
        /*}else {
            RequestDispatcher dis = request.getRequestDispatcher("/work/models/"+model+"/jsp/messages.jsp");
            request.setAttribute("msg","ok");
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            }catch (Exception e) {
                log.error(e);
            }
        }*/
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
        String url=servidor+"/swb/cvi/datos_personales/";
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
        //SWBResourceURL url = paramRequest.getActionUrl();
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
            //strRules.append("\n<option value=\"" + oRole.getURI() + "\" " + selected + ">" + oRole.getDisplayTitle(user.getLanguage()) + "</option>");
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

    /*public String replaceTags(String str, HttpServletRequest request, SWBActionResponse paramRequest, User newUser, String siteName, String page2Confirm) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }

        str = str.trim();
        //TODO: codificar cualquier atributo o texto

        Iterator it = SWBUtils.TEXT.findInterStr(str, "{request.getParameter(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{request.getParameter(\"" + s + "\")}", request.getParameter(replaceTags(s, request, paramRequest, newUser, siteName, page2Confirm)));
        }

        it = SWBUtils.TEXT.findInterStr(str, "{session.getAttribute(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{session.getAttribute(\"" + s + "\")}", (String) request.getSession().getAttribute(replaceTags(s, request, paramRequest, newUser, siteName, page2Confirm)));
        }

        it = SWBUtils.TEXT.findInterStr(str, "{getEnv(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{getEnv(\"" + s + "\")}", SWBPlatform.getEnv(replaceTags(s, request, paramRequest, newUser, siteName, page2Confirm)));
        }

        str = SWBUtils.TEXT.replaceAll(str, "{user.login}", paramRequest.getUser().getLogin());
        str = SWBUtils.TEXT.replaceAll(str, "{user.email}", paramRequest.getUser().getEmail());
        str = SWBUtils.TEXT.replaceAll(str, "{user.language}", paramRequest.getUser().getLanguage());
        str = SWBUtils.TEXT.replaceAll(str, "{webpath}", SWBPortal.getContextPath());
        str = SWBUtils.TEXT.replaceAll(str, "{distpath}", SWBPortal.getDistributorPath());
        str = SWBUtils.TEXT.replaceAll(str, "{webworkpath}", SWBPortal.getWebWorkPath());
        str = SWBUtils.TEXT.replaceAll(str, "{workpath}", SWBPortal.getWorkPath());
        str = SWBUtils.TEXT.replaceAll(str, "{websiteid}", paramRequest.getWebPage().getWebSiteId());
        str = SWBUtils.TEXT.replaceAll(str, "{user}", newUser.getFullName());
        str = SWBUtils.TEXT.replaceAll(str, "{siteName}", siteName);
        str = SWBUtils.TEXT.replaceAll(str, "{page2Confirm}", page2Confirm);
        if (str.indexOf("{templatepath}") > -1) {
            //TODO:pasar template por paramrequest
            TemplateImp template = (TemplateImp) SWBPortal.getTemplateMgr().getTemplate(paramRequest.getUser(), paramRequest.getWebPage());
            str = SWBUtils.TEXT.replaceAll(str, "{templatepath}", template.getActualPath());
        }
        return str;
         
    }*/
}
