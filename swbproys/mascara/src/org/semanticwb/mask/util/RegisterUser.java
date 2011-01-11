package org.semanticwb.mask.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.Subject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author serch
 */
public class RegisterUser extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(RegisterUser.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        
        String groovyFile = "newChild.groovy";
        if(paramRequest.getWebPage().getId().equalsIgnoreCase("Registro_profesor")) {
            groovyFile = "newUser.groovy";
        }

        String msg = request.getParameter("msg");
        String model = paramRequest.getWebPage().getWebSiteId();
        
        if(msg!=null) {
            out.println("<div class=\"\"><p class=\"\">"+msg+"</p></div>");
        }

        RequestDispatcher dis = request.getRequestDispatcher("/work/models/"+model+"/jsp/util/"+groovyFile);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        User user = response.getUser();
        
        if(response.Action_ADD.equals(action)) {
            response.setCallMethod(response.Call_CONTENT);
            response.setMode(response.Mode_HELP);

            UserRepository ur = response.getWebPage().getWebSite().getUserRepository();
            String login = SWBUtils.XML.replaceXMLChars(request.getParameter("login"));
            String pwd = request.getParameter("passwd");
            String cpwd = request.getParameter("cpasswd");
            String securCodeSent = request.getParameter("cmnt_seccode");
            String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
            
            if(securCodeCreated!=null && !securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                response.setRenderParameter("msg", response.getLocaleString(""));
                return;
            }
            if( login==null || "".equals(login) ) {
                response.setRenderParameter("msg", response.getLocaleString(""));
                return;
            }
            if( pwd==null || cpwd==null || "".equals(pwd) || "".equals(cpwd) || (pwd!=null && !pwd.equals(cpwd)) ) {
                response.setRenderParameter("msg", response.getLocaleString(""));
                return;
            }
            if(user.isSigned()) {
                response.setRenderParameter("msg", response.getLocaleString(""));
                return;
            }
            if(ur.getUserByLogin(login)!=null) {
                response.setRenderParameter("msg", response.getLocaleString(""));
                return;
            }


            if( securCodeCreated!=null && securCodeCreated.equalsIgnoreCase(securCodeSent) && login!=null && !login.equals("") && !user.isSigned() && ur.getUserByLogin(login)==null) {
                request.getSession(true).removeAttribute("cdlog");

                response.setRenderParameter("msg", "ok");
                
                User newUser = ur.createUser();
                newUser.setLogin(login.trim());
                Subject subject = SWBPortal.getUserMgr().getSubject(request, response.getWebPage().getWebSiteId());
                subject.getPrincipals().clear();
                subject.getPrincipals().add(newUser);
                newUser.setActive(true);
                newUser.setLanguage(user.getLanguage());
                newUser.setIp(user.getIp());
                newUser.setDevice(user.getDevice());
                newUser.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                newUser.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                newUser.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                newUser.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("email")));
                newUser.setPassword(pwd);
                try {
                    newUser.checkCredential(pwd.toCharArray());
                }catch(Exception ne) {
                    ne.printStackTrace(System.out);
                }
                boolean isTeacher = false;
                try {
                    Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#_ExtendedAttributes").listProperties();
                    while(list.hasNext()) {
                        SemanticProperty sp = list.next();

                        if(sp.getName().equalsIgnoreCase("teacherKey")) {
                            isTeacher = true;
                        }

                        if(request.getParameter(sp.getName())==null) {
                            user.removeExtendedAttribute(sp);
                        }else {
                            if(sp.isString()) {
                                user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
                            }
                            else if(sp.isDate()) {
                                try {
                                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                                    Date val = sf.parse(request.getParameter(sp.getName()));
                                    user.setExtendedAttribute(sp, val);
                                }catch(Exception ne) {
                                    ne.printStackTrace();
                                }
                            }

                        }
                    }
                    response.setRenderParameter("msg", "ok");
                }catch(SWBException nex) {
                    log.error(nex);
                    nex.printStackTrace(System.out);
                    response.setRenderParameter("msg", "regfail");
                }
                try {
                    Role role = null;
                    if(isTeacher) {
                        if(ur.hasRole("Profesor")) {
                            role = ur.getRole("Profesor");
                        }
                    }else {
                        if(ur.hasRole("Alumno")) {
                            role = ur.getRole("Alumno");
                        }
                    }
                    user.addRole(role);
                }catch(Exception e) {
                    log.error(e);
                    e.printStackTrace(System.out);
                    response.setRenderParameter("msg", "regfail");
                }
            }else {
                if(login==null)
                    response.setRenderParameter("msgWrnLogin", "El nombre de usuario es requerido");
                else
                    response.setRenderParameter("login", login);
                if(login==null)
                    response.setRenderParameter("msgWrnPsw", "La contrase&ntilde;a es requerida");
                else
                    response.setRenderParameter("pwd", pwd);
                if(ur.getUserByLogin(login)!=null)
                    response.setRenderParameter("msgWrn", "El usuario ya existe");
                response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                response.setRenderParameter("email", SWBUtils.XML.replaceXMLChars(request.getParameter("email")));
                
                response.setRenderParameter("msg", "regfail");
                response.setMode(response.Mode_VIEW);
                response.setCallMethod(response.Call_CONTENT);
            }
        }
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
                                ne.printStackTrace();
                            }
                        }

                    }
                }
            } catch (SWBException nex) {
                log.error(nex);
            }


//            response.sendRedirect(response.getWebPage().getWebSite().getWebPage("perfil").getRealUrl());
//            response.sendRedirect(response.getWebPage().getRealUrl()+"?act=detail");
//            return;
        }
        else if("upload".equals(response.getAction()) && user.isSigned()) {
        }
    }
    
    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setMode(SWBResourceURL.Mode_VIEW).setParameter("act", "edit");
        StringBuffer ret = new StringBuffer();
        ret.append("<script type=\"text/javascript\">\ndijit.byId('swbDialog').hide();\n");
        ret.append("location.href='" + url + "';\n");
        ret.append("</script>");
        response.getWriter().write(ret.toString());
    }

    @Override
    public void doHelp(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
    }

    public String replaceTags(String str, HttpServletRequest request, SWBActionResponse paramRequest, User newUser, String siteName, String page2Confirm) {
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
    }
}
