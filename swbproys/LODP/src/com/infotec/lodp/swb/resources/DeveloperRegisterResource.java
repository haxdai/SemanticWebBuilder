/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Developer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SFBase64;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBResourceURLImp;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author rene.jara
 */
public class DeveloperRegisterResource extends GenericAdmResource {
    public static final Logger log = SWBUtils.getLogger(DeveloperRegisterResource.class);
    /** Clave para el cifrador del URL que se envia por correo  */
    private static String PassPhrase="f:,+#u4w=EkJoR[";
    /** Accion personalizada para editar la administraciono     */
    public static final String Action_ADMEDIT="aed";
    /** Accion personalizada todo OK     */
    public static final String Action_OK="ok";
    /** Accion personalizada para activar un usuario     */
    public static final String Action_ACTIVATE="act";
    /** Modo personalizado para ejecutar doThanks   */
    public static final String Mode_THANKS="tnk";
    /** Modo personalizado para ejecutar doFinal          */
    public static final String Mode_FINAL="fnl";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if(Mode_THANKS.equals(mode))
            doThanks(request,response,paramRequest);
        else if(Mode_FINAL.equals(mode))
            doFinal(request,response,paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebPage wpage = response.getWebPage();
        WebSite wsite = wpage.getWebSite();
        Resource base = getResourceBase();
        User usr = response.getUser();
        UserRepository ur = wsite.getUserRepository();

        if(response.Action_ADD.equals(action)) {
//                response.setCallMethod(response.Call_CONTENT);
                String login = SWBUtils.XML.replaceXMLChars(request.getParameter("user"));
                String email = SWBUtils.XML.replaceXMLChars(request.getParameter("email"));
                String pwd = request.getParameter("passwd");
                String securCodeSent = request.getParameter("cmnt_seccode");
                String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
                StringBuilder msg = new StringBuilder();
                if( request.getParameter("firstName").isEmpty() ) {
                    msg.append(response.getLocaleString("msgErrFirstNameRequired")).append(",");
                }
                if( request.getParameter("lastName").isEmpty() ) {
                    msg.append(response.getLocaleString("msgErrLastNameRequired")).append(",");
                }
                if( !SWBUtils.EMAIL.isValidEmailAddress(email) ) {
                    msg.append(response.getLocaleString("msgErrInvalidEmail")).append(",");
                }
                if( pwd==null || pwd.isEmpty()) {
                    msg.append(response.getLocaleString("msgErrPasswordRequired")).append(",");
                }else if(login.equals(pwd)){
                    msg.append(response.getLocaleString("msgErrPasswordEquals")).append(",");
                }
                if(securCodeCreated!=null && !securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                    msg.append(response.getLocaleString("msgErrSecureCodeRequired")).append(",");
                }
                if(ur.getUserByLogin(login)!=null){
                    msg.append(response.getLocaleString("lblLoginDupl")).append(",");
                }
                if(ur.getUserByEmail(email)!=null){
                    msg.append(response.getLocaleString("lblEmailDupl")).append(",");
                }
                if( securCodeCreated==null || !securCodeCreated.equalsIgnoreCase(securCodeSent)){
                    msg.append(response.getLocaleString("lblCaptchaFault")).append(",");
                }
                if(msg.length()==0 ) {
                    request.getSession(true).removeAttribute("cdlog");
                    try {
                        User swbUser = ur.createUser();
//                        Developer  dev=(Developer)swbUser;
//                        User dev=swbUser;
                        Developer dev=Developer.ClassMgr.createDeveloper(ur);

                        String strCode = SFBase64.encodeBytes(SWBUtils.CryptoWrapper.PBEAES128Cipher(PassPhrase, dev.getId().getBytes()));
                        dev.setActive(false);
                        dev.setLogin(login);
//                        Subject subject = SWBPortal.getUserMgr().getSubject(request, wsite.getId());
//                        subject.getPrincipals().clear();
//                        subject.getPrincipals().add(newUser);
                        dev.setPassword(pwd);
                        dev.setLanguage(usr.getLanguage());
                        dev.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                        dev.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                        dev.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                        dev.setEmail(email);

                        String servidor = request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80)? (":" + request.getServerPort()) : "");

                        SWBResourceURLImp urlAcc = new SWBResourceURLImp(request, base, wpage, SWBResourceURL.UrlType_ACTION);
                        urlAcc.setAction(Action_ACTIVATE).setParameter("id", strCode);
                        String link = servidor+urlAcc.toString();
                        String sitename = wsite.getDisplayTitle(usr.getLanguage());
                        String emailMsg = base.getAttribute("instructions");
//emailMsg+="{link}  {firstname}  {fullname}  {user.login}  {user.email}";
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{link}", link);
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{firstname}", dev.getFirstName());
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{fullname}", dev.getFullName());
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.login}", dev.getLogin());
                        emailMsg = SWBUtils.TEXT.replaceAll(emailMsg, "{user.email}", dev.getEmail());
                        ArrayList aTo = new ArrayList();
                        InternetAddress address = new InternetAddress();
                        address.setAddress(email);
                        aTo.add(address);
                        /*SWBUtils.EMAIL.sendBGEmail(SWBPortal.getEnv("af/adminEmail","lodp@infotec.com.mx"),"",aTo,
                        null,null, sitename+" - "+response.getLocaleString("msgSubject"),"html", emailMsg,
                        null,null,null);*/
                        log.event(emailMsg);
/*
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
*/
//                        persona.setAceptacionTerminos(emailMsg);
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
                    response.setRenderParameter("user", login);
                    response.setRenderParameter("msg", msg.toString());
                    response.setMode(response.Mode_VIEW);
                }
         }else if(Action_ACTIVATE.equals(action)) {

            String code= request.getParameter("id");
            try {
                String decCode = new String(SWBUtils.CryptoWrapper.PBEAES128Decipher(PassPhrase, SFBase64.decode(code)));
//                User usrAct = ur.getUser(decCode);
                Developer usrAct=Developer.ClassMgr.getDeveloper(decCode,ur);
                usrAct.setActive(true);
                response.setMode(Mode_FINAL);
            }catch(Exception ne) {
//                ne.printStackTrace(System.out);
                log.error(ne);
                response.setRenderParameter("msg",response.getLocaleString("msgErrAct"));
            }
        }else if(Action_ADMEDIT.equals(action)) {
            base.setAttribute("instructions", request.getParameter("instructions")); 
            base.setAttribute("page_activation", request.getParameter("page_activation")); 
            base.setAttribute("page_login", request.getParameter("page_login"));
            try {
                base.updateAttributesToDB();
                response.setAction(Action_OK);
            } catch (Exception e) {
                log.error("Error Action_ADMEDIT"+ base.getClass(), e);
            }
        }

    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    public void doThanks(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "thanks.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    public void doFinal(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "final.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        //User user = paramRequest.getUser();

        String noMsg = "";

        String action = paramRequest.getAction();
        if(Action_OK.equals(action)) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('"+paramRequest.getLocaleString("msgActResource")+" "+base.getId()+"');");
            //out.println("   location='"+paramRequest.getRenderUrl().setAction(paramRequest.Action_EDIT).toString()+"';");
            out.println("</script>");
        }
        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();

        SWBResourceURL urlAction = paramRequest.getActionUrl();
        urlAction.setAction(Action_ADMEDIT);

        out.println("<div class=\"swbform\">");
        out.println("<form id=adm_edit_\""+base.getId()+"\" name=\"ilta_"+base.getId()+"\" action=\""+urlAction+"\" method=\"post\" >");
        out.println("<fieldset><legend>"+paramRequest.getLocaleString("lblData")+"</legend>");
        out.println("<ul class=\"swbform-ul\">");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"instructions\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblInsEmailActivate")+"</label>");
        out.println("   <textarea name=\"instructions\" id=\"instructions\" cols=\"25\" rows=\"5\">"+base.getAttribute("instructions",noMsg)+"</textarea>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{firstname}  "+paramRequest.getLocaleString("lblFirstName")+" </font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{fullname} "+paramRequest.getLocaleString("lblFullName")+"</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{user.login} "+paramRequest.getLocaleString("lblLogin")+"</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{user.email} "+paramRequest.getLocaleString("lblEmail")+"</font>");
        out.println("</li>");
        out.println("<li>");
        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{link} "+paramRequest.getLocaleString("lblLink")+"</font>");
        out.println("</li>");
//        out.println("<li>");
//        out.println("<font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">{date} "+paramRequest.getLocaleString("lblDate")+"</font>");
//        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"page_activation\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblInsToActivate")+"</label>");
        out.println("   <textarea name=\"page_activation\" id=\"page_activation\" cols=\"25\" rows=\"5\">"+base.getAttribute("page_activation",noMsg)+"</textarea>");
        out.println("</li>");
        out.println("<li class=\"swbform-li\">");
        out.println("   <label for=\"page_login\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblInsToLogin")+"</label>");
        out.println("   <textarea name=\"page_login\" id=\"page_login\" cols=\"25\" rows=\"5\">"+base.getAttribute("page_login",noMsg)+"</textarea>");
        out.println("</li>");
        out.println("</ul>");
        out.println("</fieldset>");
        out.println("<fieldset>");
        out.println("<button id=\"botonEnviar\" dojoType=\"dijit.form.Button\"  onClick=\"setCookie();\" type=\"submit\">"+paramRequest.getLocaleString("lblSubmit")+"</button>");
        out.println("<button id=\"botonReset\" dojoType=\"dijit.form.Button\" type=\"reset\" >"+paramRequest.getLocaleString("lblReset")+"</button>");
        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");
    }

}
