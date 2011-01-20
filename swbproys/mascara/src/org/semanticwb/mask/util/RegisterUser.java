package org.semanticwb.mask.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.Subject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author serch
 */
public class RegisterUser extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(RegisterUser.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        
        String groovyFile = "newChild.jsp";
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

            StringBuilder msg = new StringBuilder();
            if(securCodeCreated!=null && !securCodeCreated.equalsIgnoreCase(securCodeSent))
                msg.append(response.getLocaleString("msgErrSecureCodeRequired"));
            if( request.getParameter("firstName")==null || "".equals(request.getParameter("firstName")) ) {
                msg.append(response.getLocaleString("msgErrFirstNameRequired"));
            }
            if( request.getParameter("lastName")==null || "".equals(request.getParameter("lastName")) ) {
                msg.append(response.getLocaleString("msgErrLastNameRequired"));
            }
            if( !SWBUtils.EMAIL.isValidEmailAddress(request.getParameter("email")) ) {
                msg.append(response.getLocaleString("msgErrInvalidEmail"));
            }
            if( login==null || "".equals(login) ) {
                msg.append(response.getLocaleString("msgErrLoginRequired"));
            }
            if( pwd==null || cpwd==null || "".equals(pwd) || "".equals(cpwd) || (pwd!=null && !pwd.equals(cpwd)) ) {
                msg.append(response.getLocaleString("msgErrPasswordRequired"));
            }
            if(user.isSigned()) {
                msg.append(response.getLocaleString("msgErrUserAlreadySigned"));
            }
            if(ur.getUserByLogin(login)!=null) {
                msg.append(response.getLocaleString("msgErrUserAlreadyExists"));
            }
            
            if( securCodeCreated!=null && securCodeCreated.equalsIgnoreCase(securCodeSent) && !user.isSigned() && ur.getUserByLogin(login)==null && msg.length()==0) {
                request.getSession(true).removeAttribute("cdlog");
//                response.setRenderParameter("msg", "ok");
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
                newUser.setPhoto(SWBUtils.XML.replaceXMLChars(request.getParameter("photo")));
                newUser.setPassword(pwd);
                try {
                    newUser.checkCredential(pwd.toCharArray());
                }catch(Exception ne) {
                    ne.printStackTrace(System.out);
                }
                user = newUser;
                
                boolean isTeacher = false;
                try {
                    Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#_ExtendedAttributes").listProperties();
                    while(list.hasNext()) {
                        SemanticProperty sp = list.next();
                        if(request.getParameter(sp.getName())==null) {
                            newUser.removeExtendedAttribute(sp);
                        }else {
                            if(sp.getName().equalsIgnoreCase("teacherKey"))
                                isTeacher = true;
                            
                            if(sp.isString())
                                user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
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
                    response.setRenderParameter("msg", nex.getMessage());
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
                    response.setRenderParameter("msg", e.getMessage());
                }
            }else {
                response.setRenderParameter("login", login);
                response.setRenderParameter("passwd", pwd);
                response.setRenderParameter("cpasswd", cpwd);
                response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                response.setRenderParameter("email", SWBUtils.XML.replaceXMLChars(request.getParameter("email")));

                response.setRenderParameter("photo", SWBUtils.XML.replaceXMLChars(request.getParameter("photo")));
                response.setRenderParameter("userSchoolName", SWBUtils.XML.replaceXMLChars(request.getParameter("userSchoolName")));
                response.setRenderParameter("userSchoolDegree", SWBUtils.XML.replaceXMLChars(request.getParameter("userSchoolDegree")));
                response.setRenderParameter("userSchoolGroup", SWBUtils.XML.replaceXMLChars(request.getParameter("userSchoolGroup")));
                
                response.setRenderParameter("msg", msg.toString());
                response.setMode(response.Mode_VIEW);
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
    public void doHelp(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.getWriter().println("<p class=\"\"><p class=\"\">"+paramRequest.getLocaleString("msgOkRegister")+"</p></div>");
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
