/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.amsde.resources;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.servlet.internal.UploadFormElement;

/**
 *
 * @author martha.jimenez
 */
public class AmsdeRegisterUser extends GenericResource {

    private static Logger log = SWBUtils.getLogger(AmsdeRegisterUser.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String wsiteID = paramRequest.getWebPage().getWebSiteId();
        String path = "/work/models/"+wsiteID+"/jsp/userRegistry/listUsers.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if("add".equals(paramRequest.getMode())) {
            doAdd(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }


    public void doAdd(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = "/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/userRegistry/newUser.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        UserRepository ur = response.getWebPage().getWebSite().getUserRepository();
        User user = response.getUser();
        String login = SWBUtils.XML.replaceXMLChars(request.getParameter("login"));
        String pwd = request.getParameter("passwd");
        if ("create".equals(response.getAction()) && (null != login) && (!"".equals(login.trim()))) { // && (!user.isSigned()) && (null == ur.getUserByLogin(login))
                request.getSession(true).removeAttribute("cdlog");
                User newUser = ur.createUser();
                newUser.setLogin(login.trim());
                newUser.setRequireConfirm(true);
                newUser.setLanguage(user.getLanguage());
                newUser.setIp(user.getIp());
                newUser.setDevice(user.getDevice());
                newUser.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                newUser.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                newUser.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                newUser.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("usrEmail")));
                newUser.setPassword(pwd);
                newUser.setActive(request.getParameter("active") == null ? false : true);
                setUserExtendedAttributes(request, newUser);
                response.sendRedirect(response.getWebPage().getRealUrl());
                return;
        } else if ("edit".equals(response.getAction()) && request.getParameter("uri") != null) { 
            String uri = URLDecoder.decode(request.getParameter("uri"));
            SemanticObject sem = SemanticObject.createSemanticObject(uri);
            User user1 = (User) sem.createGenericInstance();
            user1.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrFirstName")));
            user1.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrLastName")));
            user1.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrSecondLastName")));
            user1.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("usrEmail")));
            user1.setActive(request.getParameter("active") == null ? false : true);
            if(user1.getExtendedAttribute("http://www.semanticwebbuilder.org/swb4/AMSDE#photoUser") != null ) {
                String basepath = SWBPortal.getWorkPath() + user1.getSemanticObject().getWorkPath() + "/";
                String tmpPhoto = user1.getExtendedAttribute("http://www.semanticwebbuilder.org/swb4/AMSDE#photoUser").toString();
                File file = new File(basepath + tmpPhoto);
                file.delete();
            }
            setUserExtendedAttributes(request, user1);
            response.sendRedirect(response.getWebPage().getRealUrl());
            return;
        }
    }

    private void setUserExtendedAttributes(HttpServletRequest request, User user) {
        try {
            Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/AMSDE#attributeExtendsUser").listProperties();
            while (list.hasNext()) {
                SemanticProperty sp = list.next();
                if (null == request.getParameter(sp.getName())) {
                    user.removeExtendedAttribute(sp);
                } else {
                    String [] values = request.getParameterValues(sp.getName());
                    if (values.length > 1) {
                        String value = "";
                        for (int i = 0; i < values.length; i++) {
                            value += values[i];
                            if (i < values.length -1) {
                                value += "|";
                            }
                        }
                        user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(value));
                        user.getSemanticObject().setProperty(sp, SWBUtils.XML.replaceXMLChars(value));
                    } else if (sp.isString()) {
                        if(sp.getName().equals("photoUser")) {
                            processFiles(request, user.getSemanticObject(), sp);
                        } else {
                            user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
                            user.getSemanticObject().setProperty(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
                        }
                    } else if (sp.isInt()) {
                        try {
                            Integer val = Integer.valueOf(request.getParameter(sp.getName()));
                            user.setExtendedAttribute(sp, val);
                        } catch (Exception ne) {
                        }
                    } else if (sp.isDouble()) {
                        try {
                            Double val = Double.valueOf(request.getParameter(sp.getName()));
                            user.setExtendedAttribute(sp, val);
                        } catch (Exception ne) {
                        }
                    } else if (sp.isDate()) {
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
    }

    private void processFiles(HttpServletRequest request, SemanticObject sobj, SemanticProperty sp) { //WebSite website
        String basepath = SWBPortal.getWorkPath() + sobj.getWorkPath() + "/";
        if (request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED) != null) {
            Iterator itfilesUploaded = ((List) request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED)).iterator();

            while (itfilesUploaded.hasNext()) {
                FileItem item = (FileItem) itfilesUploaded.next();
                if (!item.isFormField()) { //Es un campo de tipo file
                    int fileSize = ((Long) item.getSize()).intValue();
                    String value = item.getName();
                    if (value != null && value.trim().length() > 0) {
                        value = value.replace("\\", "/");
                        int pos = value.lastIndexOf("/");
                        if (pos > -1) {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(basepath);
                        if (!fichero.exists()) {
                            fichero.mkdirs();
                        }
                        fichero = new File(basepath + value);

                        String ext = "";
                        pos = -1;
                        pos = value.indexOf(".");
                        if (pos > -1) {
                            ext = value.substring(pos + 1);
                        }
                        User us = (User) sobj.createGenericInstance();
                        if (item.getFieldName().equals("photoUser")) {
                            try {
                                us.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(value));
                                us.getSemanticObject().setProperty(sp, SWBUtils.XML.replaceXMLChars(value));
                            } catch(Exception e) {
                            }

                            try {
                                item.write(fichero);
                                //ImageResizer.shrinkTo(fichero, 120, 97, fichero, ext);
                                //ImageResizer.resize(fichero, 336, 224, true, fichero, ext);
                                //ImageResizer.shrinkTo(fichero, 281, 187, fichero, ext);
                                //ImageResizer.shrinkTo(fichero, 90, 67, fichero, ext);
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        }
                    }
                }
            }
            request.getSession().setAttribute(UploadFormElement.FILES_UPLOADED, null);
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = "/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/userRegistry/userEditForm.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }

    }

}
