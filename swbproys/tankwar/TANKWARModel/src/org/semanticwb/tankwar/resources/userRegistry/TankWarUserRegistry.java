/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.tankwar.resources.userRegistry;

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
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;


/**
 *
 * @author jorge.jimenez
 */
public class TankWarUserRegistry extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(TankWarUserRegistry.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String act = request.getParameter("act");
        User user=paramRequest.getUser();

        if (act == null) {
            act = "add";
            if (paramRequest.getUser().isSigned()) {
                act = "edit";
            }
        }

        String path = "/swbadmin/jsp/microsite/RegisterUser/linkNewUser.groovy";
        String msg = request.getParameter("msg");
        if (msg != null && msg.equals("ok")) { //Cuando el registro es en dos pasos
            path = "/swbadmin/jsp/microsite/RegisterUser/messages.jsp";
        }
        else {
            if (msg != null && msg.equals("regfail")) {
                out.println("<pre>" +
                        "<b><font color=\"red\">Error al capturar los caracteres de la imagen de seguridad." +
                        "</b></font></pre>");
            }else if (msg != null && msg.equals("editok")) {
                String editSucc=paramRequest.getResourceBase().getAttribute("editSucc");
                if(editSucc!=null && editSucc.trim().length()>0){
                    String siteName = paramRequest.getWebPage().getWebSite().getDisplayTitle(user.getLanguage());
                    editSucc = replaceTags(editSucc, request, paramRequest, user, siteName, null);
                }
                out.println(editSucc);
            }
            String wsiteID=paramRequest.getWebPage().getWebSiteId();
            if (act.equals("add")) {
                path = "/work/models/"+wsiteID+"/jsp/userRegistry/newUser.jsp";
            } else if (act.equals("edit")) {
                path = "/work/models/"+wsiteID+"/jsp/userRegistry/userEditForm.jsp";
            } else if (act.equals("detail")) {
                path = "/swbadmin/jsp/microsite/RegisterUser/userDetail.groovy";
            }
        }
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
        Resource base = response.getResourceBase();
        UserRepository ur = response.getWebPage().getWebSite().getUserRepository();
        User user = response.getUser();
        String login = SWBUtils.XML.replaceXMLChars(request.getParameter("login"));
        String pwd = request.getParameter("passwd");
        boolean isTwoSteps = false;
        if (base.getAttribute("twosteps") != null && base.getAttribute("twosteps").equals("1")) {
            isTwoSteps = true;
        }
        if ("create".equals(response.getAction()) && (null != login) && (!"".equals(login.trim())) && (!user.isSigned()) && (null == ur.getUserByLogin(login))) {
            String securCodeSent = request.getParameter("cmnt_seccode");
            String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
            if (securCodeCreated != null && securCodeCreated.equalsIgnoreCase(securCodeSent)) {
                request.getSession(true).removeAttribute("cdlog");
                User newUser = ur.createUser();
                newUser.setLogin(login.trim());

                if (!isTwoSteps) {
                    Subject subject = SWBPortal.getUserMgr().getSubject(request, response.getWebPage().getWebSiteId());
                    subject.getPrincipals().clear();
                    subject.getPrincipals().add(newUser);
                    newUser.setActive(true);
                } else {
                    newUser.setActive(false);
                    newUser.setRequireConfirm(true);
                }
                newUser.setLanguage(user.getLanguage());
                newUser.setIp(user.getIp());
                newUser.setDevice(user.getDevice());
                newUser.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                newUser.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                newUser.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                newUser.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("email")));
                newUser.setPassword(pwd);
                setUserExtendedAttributes(request, newUser);

                try {
                    newUser.checkCredential(pwd.toCharArray());
                } catch (Exception ne) {
                    ne.getStackTrace();
                }
                if (!isTwoSteps) {
                    user = newUser;
                    response.sendRedirect(response.getWebPage().getRealUrl());
                    //response.sendRedirect(response.getWebPage().getWebSite().getWebPage("Registro_Exitoso").getUrl());
                }
                //comentar para 2 pasos
                if (isTwoSteps) {
                    //EnvÃ­o de correo
                    WebSite website = response.getWebPage().getWebSite();
                    String siteName = website.getDisplayTitle(response.getUser().getLanguage());
                    String server = "http://" + request.getServerName() + ":" + request.getServerPort();
                    String page2Confirm = server + website.getWebPage("confirmRegistry").getUrl() + "?login=" + newUser.getLogin();

                    String staticText = replaceTags(base.getAttribute("emailMsg"), request, (SWBParamRequest)response, newUser, siteName, page2Confirm);
                    response.setRenderParameter("msg", "ok");
                    response.setMode(response.Mode_VIEW);
                    response.setCallMethod(response.Call_CONTENT);
                    SWBUtils.EMAIL.sendBGEmail(newUser.getEmail(), "Contacto del Sitio - ConfirmaciÃ³n de registro", staticText);
                }
                return;
            } else {
                response.setRenderParameter("login", login);
                response.setRenderParameter("pwd", pwd);
                response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                response.setRenderParameter("email", SWBUtils.XML.replaceXMLChars(request.getParameter("email")));
                response.setRenderParameter("msg", "regfail");
                response.setMode(response.Mode_VIEW);
                response.setCallMethod(response.Call_CONTENT);
            }
        }
        if ("edit".equals(response.getAction()) && user.isSigned()) {
            user.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrFirstName")));
            user.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrLastName")));
            user.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrSecondLastName")));
            user.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("usrEmail")));

            setUserExtendedAttributes(request, user);

            response.setRenderParameter("msg", "editok");
            response.setMode(response.Mode_VIEW);
            response.setCallMethod(response.Call_CONTENT);
            return;
        }
        if ("upload".equals(response.getAction()) && user.isSigned()) {
            final Percentage per = new Percentage();
            try {
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                HashMap<String, String> params = new HashMap<String, String>();
                // Create a factory for disk-based file items
                File tmpwrk = new File(SWBPortal.getWorkPath() + "/tmp");
                if (!tmpwrk.exists()) {
                    tmpwrk.mkdirs();
                }
                FileItemFactory factory = new DiskFileItemFactory(1 * 1024 * 1024, tmpwrk);
                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                //Create a progress listener
                ProgressListener progressListener = new ProgressListener() {

                    private long kBytes = -1;

                    public void update(long pBytesRead, long pContentLength, int pItems) {
                        long mBytes = pBytesRead / 10000;
                        if (kBytes == mBytes) {
                            return;
                        }
                        kBytes = mBytes;
                        int percent = (int) (pBytesRead * 100 / pContentLength);
                        per.setPercentage(percent);
                    }
                };
                upload.setProgressListener(progressListener);
                // Parse the request
                List items = upload.parseRequest(request); /* FileItem */
                FileItem currentFile = null;
                // Process the uploaded items
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString();
                        params.put(name, value);
                    } else {
                        currentFile = item;
//                        String fieldName = item.getFieldName();
//                        String fileName = item.getName();
//                        String contentType = item.getContentType();
//                        boolean isInMemory = item.isInMemory();
//                        long sizeInBytes = item.getSize();
//                        File uploadedFile = new File();
//                        item.write(uploadedFile);
                    }
                }
                request.getSession(true).setAttribute(currentFile.getFieldName(), per);

                String path = SWBPortal.getWorkPath() + user.getWorkPath();
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String name = user.getLogin() + currentFile.getName().substring(currentFile.getName().lastIndexOf("."));
                String photoName = path + "/" + name;
                currentFile.write(new File(photoName));
                path = user.getWorkPath();
                //SWBPlatform.getWebWorkPath() +
                user.setPhoto(path + "/" + name);
                per.setPercentage(100);
                File f = new File(photoName);

                /*                BufferedImage bi = ImageIO.read(f);
                int calcHeight = (150 * bi.getHeight() / bi.getWidth());
                ImageIO.write(createResizedCopy(bi, 150, calcHeight), name.substring(name.lastIndexOf(".")+1), f);*/

                ImageResizer.resizeCrop(f, 150, f, name.substring(name.lastIndexOf(".") + 1).toLowerCase());


            } catch (Exception ex) {
                log.error(ex);
            }
        }
    }

    private void setUserExtendedAttributes(HttpServletRequest request, User user) {
        try {
            Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankWarExtendedAttributes").listProperties();
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
                        user.setExtendedAttribute(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
                        user.getSemanticObject().setProperty(sp, SWBUtils.XML.replaceXMLChars(request.getParameter(sp.getName())));
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

     private BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledBI.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
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
        Percentage pers = (Percentage) request.getSession(true).getAttribute(request.getParameter("sid"));
        PrintWriter out = response.getWriter();
        if (null != pers) {
            out.println(pers.getPercentage());
        } else {
            out.println(0);
        }
    }

    private class Percentage {

        int per = 0;

        public void setPercentage(int per) {
            this.per = per;
        }

        public int getPercentage() {
            return per;
        }
    }

    public String replaceTags(String str, HttpServletRequest request, SWBParamRequest paramRequest, User newUser, String siteName, String page2Confirm) {
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