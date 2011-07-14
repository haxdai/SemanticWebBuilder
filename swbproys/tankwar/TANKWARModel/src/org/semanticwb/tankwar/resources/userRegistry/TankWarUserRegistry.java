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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.servlet.internal.UploadFormElement;


/**
 *
 * @author jorge.jimenez
 */
public class TankWarUserRegistry extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(TankWarUserRegistry.class);

    private static final int PHOTO_MAX_SIZE = 50000;

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

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
                out.println("<div id=\"errores\"><pre>" +
                        "<b><font color=\"red\">Error al capturar los caracteres de la imagen de seguridad." +
                        "</b></font></pre></div>");
            } else if (msg != null && msg.equals("dataNotValid")) {
                out.println("<div id=\"errores\"><pre>" +
                        "<b><font color=\"red\">Los datos proporcionados no son v&aacute;lidos y no se almacenaron, favor de verificarlos." +
                        "</b></font></pre></div>");
            } else if (msg != null && msg.equals("editok")) {
                String editSucc = paramRequest.getResourceBase().getAttribute("editSucc");
                if(editSucc != null && editSucc.trim().length()>0){
                    String siteName = paramRequest.getWebPage().getWebSite().getDisplayTitle(user.getLanguage());
                    editSucc = replaceTags(editSucc, request, paramRequest, user, siteName, null);
                }
                out.println(editSucc);
            }
            String wsiteID = paramRequest.getWebPage().getWebSiteId();
            if (act.equals("add")) {
                path = "/work/models/" + wsiteID + "/jsp/userRegistry/newUser.jsp";
            } else if (act.equals("edit")) {
                path = "/work/models/" + wsiteID + "/jsp/userRegistry/userEditForm.jsp";
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
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException {

        Resource base = response.getResourceBase();
        UserRepository ur = response.getWebPage().getWebSite().getUserRepository();
        User user = response.getUser();
        String login = SWBUtils.XML.replaceXMLChars(request.getParameter("login"));
        String pwd = request.getParameter("passwd");
        boolean isTwoSteps = false;
        boolean isDataValid = isDataValid(request, response.getAction());
        if (base.getAttribute("twosteps") != null && base.getAttribute("twosteps").equals("1")) {
            isTwoSteps = true;
        }
        if ("create".equals(response.getAction()) && (null != login) &&
                !"".equals(login.trim()) && !user.isSigned() &&
                null == ur.getUserByLogin(login)) {

            String securCodeSent = request.getParameter("cmnt_seccode");
            String securCodeCreated = (String) request.getSession(true).getAttribute("cdlog");
            if (securCodeCreated != null && securCodeCreated.equalsIgnoreCase(securCodeSent) &&
                    isDataValid) {
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
                String usrPhoto = request.getParameter("photoUser");
                if (usrPhoto != null) {
                    //newUser.setPhoto(usrPhoto);
                    processFiles(request, base.getWebSite(), newUser.getSemanticObject());
                }

                setUserExtendedAttributes(request, newUser);

                try {
                    newUser.checkCredential(pwd.toCharArray());
                } catch (Exception ne) {
                    ne.getStackTrace();
                }
                if (!isTwoSteps) {
                    user = newUser;
                    //Redirecciona a la pantalla de configuracion del tanque
                    WebPage wpTank = WebPage.ClassMgr.getWebPage("Configuracion_del_Tanque",
                            base.getWebSite());
                    response.sendRedirect(wpTank.getUrl(user.getLanguage()) + "?action=createTank");
                    //response.sendRedirect(response.getWebPage().getRealUrl());
                    //response.sendRedirect(response.getWebPage().getWebSite().getWebPage("Registro_Exitoso").getUrl());
                }
                //comentar para 2 pasos
                if (isTwoSteps) {
                    //Envío de correo
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
                response.setRenderParameter("tankUserSex", SWBUtils.XML.replaceXMLChars(request.getParameter("tankUserSex")));
                response.setRenderParameter("email", SWBUtils.XML.replaceXMLChars(request.getParameter("email")));
                response.setRenderParameter("userCareer", SWBUtils.XML.replaceXMLChars(request.getParameter("userCareer")));
                response.setRenderParameter("userMainActivity", SWBUtils.XML.replaceXMLChars(request.getParameter("userMainActivity")));
                response.setRenderParameter("userSchoolEnterprise", SWBUtils.XML.replaceXMLChars(request.getParameter("userSchoolEnterprise")));
                response.setRenderParameter("userTelephoneType", SWBUtils.XML.replaceXMLChars(request.getParameter("userTelephoneType")));
                if (isDataValid) {
                    response.setRenderParameter("msg", "regfail");
                } else {
                    response.setRenderParameter("msg", "dataNotValid");
                }
                response.setMode(response.Mode_VIEW);
                response.setCallMethod(response.Call_CONTENT);
            }
        }
        if ("edit".equals(response.getAction()) && user.isSigned()) {
            if (isDataValid) {
                user.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrFirstName")));
                user.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrLastName")));
                user.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("usrSecondLastName")));
                user.setEmail(SWBUtils.XML.replaceXMLChars(request.getParameter("usrEmail")));

                String usrPhoto = request.getParameter("photoUser");
                if (usrPhoto != null) {
                    processFiles(request, base.getWebSite(), user.getSemanticObject());
                }
                setUserExtendedAttributes(request, user);

                response.setRenderParameter("msg", "editok");
                response.setMode(response.Mode_VIEW);
                response.setCallMethod(response.Call_CONTENT);
                return;
            } else {
                response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                response.setRenderParameter("tankUserSex", SWBUtils.XML.replaceXMLChars(request.getParameter("tankUserSex")));
                response.setRenderParameter("email", SWBUtils.XML.replaceXMLChars(request.getParameter("email")));
                response.setRenderParameter("userCareer", SWBUtils.XML.replaceXMLChars(request.getParameter("userCareer")));
                response.setRenderParameter("userMainActivity", SWBUtils.XML.replaceXMLChars(request.getParameter("userMainActivity")));
                response.setRenderParameter("userSchoolEnterprise", SWBUtils.XML.replaceXMLChars(request.getParameter("userSchoolEnterprise")));
                response.setRenderParameter("userTelephoneType", SWBUtils.XML.replaceXMLChars(request.getParameter("userTelephoneType")));
                if (isDataValid) {
                    response.setRenderParameter("msg", "dataNotValid");
                }
                response.setMode(response.Mode_VIEW);
                response.setCallMethod(response.Call_CONTENT);
            }
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

    private void processFiles(HttpServletRequest request, WebSite website,
            SemanticObject sobj) {

        String basepath = SWBPortal.getWorkPath() + sobj.getWorkPath() + "/";
        if (request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED) != null) {
            Iterator itfilesUploaded = ((List) request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED)).iterator();
            while (itfilesUploaded.hasNext()) {
                FileItem item = (FileItem) itfilesUploaded.next();
                if (!item.isFormField()) { //Es un campo de tipo file

                    int fileSize = ((Long) item.getSize()).intValue();
                    String value = item.getName();
                    String ext = "";
                    String validFileExtensions = "jpg|jpeg|gif|png";
                    int pos = -1;

                    if (value != null && value.trim().length() > 0) {
                        pos = value.lastIndexOf(".");
                        if (pos > -1) {
                            ext = value.substring(pos + 1).toLowerCase();
                        }

                    }

                    if (value != null && value.trim().length() > 0 &&
                            fileSize <= TankWarUserRegistry.PHOTO_MAX_SIZE &&
                            validFileExtensions.contains(ext)) {
                        value = value.replace("\\", "/");
                        pos = value.lastIndexOf("/");
                        if (pos > -1) {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(basepath);
                        if (!fichero.exists()) {
                            fichero.mkdirs();
                        }
                        fichero = new File(basepath + value);

                        User usrObj = (User) sobj.createGenericInstance();
                        if (item.getFieldName().equals("photoUser")) {
                            String tmpPhoto = usrObj.getPhoto();
                            usrObj.setPhoto(value);
                            File file = new File(basepath + tmpPhoto);
                            file.delete();

                            try {
                                item.write(fichero);
                                //ImageResizer.shrinkTo(fichero, 281, 187, fichero, ext);
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        }
                    } else if (fileSize > TankWarUserRegistry.PHOTO_MAX_SIZE ||
                            !validFileExtensions.contains(ext)) {
                        //Si el archivo pesa mas de lo permitido, se elimina de file system
                        value = value.replace("\\", "/");
                        pos = value.lastIndexOf("/");
                        if (pos > -1) {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(basepath + value);
                        if (fichero.exists()) {
                            fichero.delete();
                        }
                    }
                }
            }
            request.getSession().setAttribute(UploadFormElement.FILES_UPLOADED, null);
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

    public String replaceTags(String str, HttpServletRequest request,
            SWBParamRequest paramRequest, User newUser, String siteName,
            String page2Confirm) {

        if (str == null || str.trim().length() == 0) {
            return "";
        }

        str = str.trim();
        //TODO: codificar cualquier atributo o texto

        Iterator it = SWBUtils.TEXT.findInterStr(str, "{request.getParameter(\"",
                                                 "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str,
                    "{request.getParameter(\"" + s + "\")}",
                    request.getParameter(replaceTags(s, request, paramRequest,
                                         newUser, siteName, page2Confirm)));
        }

        it = SWBUtils.TEXT.findInterStr(str, "{session.getAttribute(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str,
                    "{session.getAttribute(\"" + s + "\")}",
                    (String) request.getSession().getAttribute(replaceTags(s,
                                  request, paramRequest, newUser, siteName, page2Confirm)));
        }

        it = SWBUtils.TEXT.findInterStr(str, "{getEnv(\"", "\")}");
        while (it.hasNext()) {
            String s = (String) it.next();
            str = SWBUtils.TEXT.replaceAll(str, "{getEnv(\"" + s + "\")}",
                    SWBPlatform.getEnv(replaceTags(s, request, paramRequest, newUser, siteName, page2Confirm)));
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

    /**
     * Realiza validaciones sobre los datos recibidos en la petici&oacute;n HTTP
     * para determinar si en su conjunto son v&aacute;lidos.
     * @param request petici&oacute;n HTTP que contiene los datos a evaluar
     * @param action indica la operaci&oacute;n que se desea realizar con los datos
     * @return un valor boleano que indica si los datos son v&aacute;lidos
     * ({@literal true) o no ({@literal false}).
     */
    private boolean isDataValid(HttpServletRequest request, String action) {

        boolean dataValid = true;
        String parameter = null;

        if (action.equalsIgnoreCase("create")) {
            //Estos parametros solo se usan para la creacion:
            parameter = request.getParameter(User.swb_usrLogin.getName());
            if (dataValid && parameter != null && parameter.trim().length() > 0) {
                dataValid = validateRegExp(parameter, "^[\\w-_\\.áéíóúÁÉÍÓÚñÑ]{4,30}$");
            }
//            System.out.println("parametro: " + User.swb_usrLogin.getName() + ", validacion: " + dataValid);
            parameter = request.getParameter(User.swb_usrPassword.getName());
            if (dataValid && parameter != null && parameter.trim().length() > 0) {
                dataValid = validateRegExp(parameter, "^[a-zA-Z0-9\\.\\-_]{6,30}$");
            }
//            System.out.println("parametro: " + User.swb_usrPassword.getName() + ", validacion: " + dataValid);
            parameter = request.getParameter(User.swb_usrPassword.getName() + "c");
            if (dataValid && parameter != null && parameter.trim().length() > 0) {
                dataValid = validateRegExp(parameter, "^[a-zA-Z0-9\\.\\-_]{6,30}$");
            }
//            System.out.println("parametro: " + User.swb_usrPassword.getName() + "c, validacion: " + dataValid);
        }
        //Los siguientes se validan siempre (en creacion y edicion)
        parameter = request.getParameter(User.swb_usrFirstName.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = validateRegExp(parameter, "^[a-zA-ZñÑáéíóú\\.\\s]{1,40}$");
        }
//        System.out.println("parametro: " + User.swb_usrFirstName.getName() + ", validacion: " + dataValid);
        parameter = request.getParameter(User.swb_usrLastName.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = validateRegExp(parameter, "^[a-zA-ZñÑáéíóú\\.\\s]{1,40}$");
        }
//        System.out.println("parametro: " + User.swb_usrLastName.getName() + ", validacion: " + dataValid);
        parameter = request.getParameter(User.swb_usrSecondLastName.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = validateRegExp(parameter, "^[a-zA-ZñÑáéíóú\\.\\s]*$");
        }
//        System.out.println("parametro: " + User.swb_usrSecondLastName.getName() + ", validacion: " + dataValid);
        parameter = request.getParameter(User.swb_usrEmail.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = validateRegExp(parameter, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
        }
//        System.out.println("parametro: " + User.swb_usrEmail.getName() + ", validacion: " + dataValid);
        parameter = request.getParameter("tankUserSex");
        if (dataValid && parameter != null && (parameter.trim().equals("") ||
                parameter.trim().equalsIgnoreCase("female") ||
                parameter.trim().equalsIgnoreCase("male"))) {
            dataValid = true;
        }
//        System.out.println("parametro: tankUserSex, validacion: " + dataValid);
        parameter = request.getParameter("userCareer");
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = validateRegExp(parameter, "^[a-zA-ZñÑáéíóúüÁÉÍÓÚÜ\\.\\s]{1,60}$");
        }
//        System.out.println("parametro: userCareer, validacion: " + dataValid);
        parameter = request.getParameter("userMainActivity");
        if (dataValid && parameter != null && (parameter.trim().equals("") ||
                parameter.trim().equalsIgnoreCase("study") ||
                parameter.trim().equalsIgnoreCase("work"))) {
            dataValid = true;
        }
//        System.out.println("parametro: userMainActivity, validacion: " + dataValid);
        parameter = request.getParameter("userSchoolEnterprise");
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = validateRegExp(parameter, "^[a-zA-Z0-9ñÑáéíóúüÁÉÍÓÚÜ\\.\\s]{1,60}$");
        }
//        System.out.println("parametro: userSchoolEnterprise, validacion: " + dataValid);


        return dataValid;
    }

    /**
     * Eval&uacute;a el contenido de una cadena de texto contra una expresi&oacute;n
     * regular dada, para conocer el resultado de esa evaluaci&oacute;n.
     * @param textSource la cadena de texto a evaluar
     * @param regExp la expresi&oacute; regular que evaluar&aacute; el texto recibido
     * @return un valor boleano que representa el resultado de la evaluaci&oacute;n
     *         del texto contra la expresi&oacute; regular indicados.
     */
    private boolean validateRegExp(String textSource, String regExp) {

        Pattern p = Pattern.compile(regExp);//regular expression
        Matcher m = p.matcher(textSource); // the text source
        return m.find();
    }
    
}