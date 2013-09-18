/*
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 */
package org.semanticwb.process.resources;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.VersionInfo;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.process.model.RepositoryDirectory;
import org.semanticwb.process.model.RepositoryElement;
import org.semanticwb.process.model.RepositoryFile;
import org.semanticwb.process.model.RepositoryURL;

/**
 *
 * @author juan.fernandez
 */
public class ProcessFileRepository extends GenericResource {

    private Logger log = SWBUtils.getLogger(ProcessFileRepository.class);
    public static final String MODE_GETFILE = "getFile";
    public static final String MODE_PROPS = "props";
    public static final String MODE_ADDFILE = "addFile";
    public static final String MODE_HISTORY = "versionHistory";
    public static final String ACT_NEWFILE = "newfile";
    public static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    public static final String LVL_VIEW = "prop_view";
    public static final String LVL_MODIFY = "prop_modify";
    public static final String LVL_ADMIN = "prop_admin";
    public static final String VALID_FILES = "prop_valid_files";
    public static final String ATT_LEVELUSER = "levelUser";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (MODE_GETFILE.equals(mode)) {
            doGetFile(request, response, paramRequest);
        } else if (MODE_PROPS.equals(mode)) {
            doFileProps(request, response, paramRequest);
        } else if (MODE_HISTORY.equals(mode)) {
            doHistory(request, response, paramRequest);
        } else if (MODE_ADDFILE.equals(mode)) {
            doAddFile(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doFileProps(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = "/swbadmin/jsp/process/repository/repositoryFileProps.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception ex) {
            log.error("Error including props.jsp", ex);
        }
    }
    
    public void doAddFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = "/swbadmin/jsp/process/repository/repositoryAddFile.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try {
            request.setAttribute(VALID_FILES, getResourceBase().getAttribute(VALID_FILES, ""));
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception ex) {
            log.error("Error including add.jsp", ex);
        }
    }
    
    public void doHistory(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = "/swbadmin/jsp/process/repository/repositoryFileVersions.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        
        String fid = request.getParameter("fid");
        String type = request.getParameter("type");
        RepositoryElement re = null;
        
        if (fid != null && fid.length() > 0) {
            if (type != null) {
                if ("url".equals(type)) {
                    re = RepositoryURL.ClassMgr.getRepositoryURL(fid, paramRequest.getWebPage().getWebSite());
                } else if ("file".equals(type)) {
                    re = RepositoryFile.ClassMgr.getRepositoryFile(fid, paramRequest.getWebPage().getWebSite());
                }
            }
        }
        
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("luser", getLevelUser(paramRequest.getUser()));
            request.setAttribute("versionList", getFileVersions(re));
            request.setAttribute("element", re);
            rd.include(request, response);
        } catch (Exception ex) {
            log.error("Error including versions.jsp", ex);
        }
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        //response.setContentType("text/html; charset=ISO-8859-1");
        //response.setHeader("Cache-Control", "no-cache");
        //response.setHeader("Pragma", "no-cache");
        String jsp = "/swbadmin/jsp/process/repository/repositoryView.jsp";
        
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("files", listFiles(request, paramRequest));
            request.setAttribute("luser", getLevelUser(paramRequest.getUser()));
            rd.include(request, response);
        } catch (Exception ex) {
            log.error("Error including view.jsp", ex);
        }
    }

    public void doGetFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        User user = paramRequest.getUser();
        String fid = request.getParameter("fid");
        String verNumber = request.getParameter("verNum");
        int intVer = 1;
        if (verNumber != null) {
            intVer = Integer.parseInt(verNumber);
        }
        RepositoryFile repoFile = RepositoryFile.ClassMgr.getRepositoryFile(fid, paramRequest.getWebPage().getWebSite());
        VersionInfo ver = null;
        VersionInfo vl = repoFile.getLastVersion();
        if (null != vl) {
            ver = vl;
            while (ver.getPreviousVersion() != null) { //
                if (ver.getVersionNumber() == intVer) {
                    break;
                }
                ver = ver.getPreviousVersion();
            }
        }

        if (ver != null) {
            try {
                response.setContentType(DEFAULT_MIME_TYPE);
                response.setHeader("Content-Disposition", "attachment; filename=\"" + ver.getVersionFile() + "\";");

                OutputStream out = response.getOutputStream();
                SWBUtils.IO.copyStream(new FileInputStream(SWBPortal.getWorkPath() + repoFile.getWorkPath() + "/" + verNumber + "/" + ver.getVersionFile()), out);
            } catch (Exception e) {
                log.error("Error al obtener el archivo del Repositorio de documentos.", e);
            }
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String id = getResourceBase().getId();

        PrintWriter out = response.getWriter();
        String accion = paramRequest.getAction();
        if (accion == null) {
            accion = "";
        }

        WebSite wsite = getResourceBase().getWebSite(); //wpage.getWebSite();

        out.println("<div class=\"swbform\">");

        if (accion.equals("edit")) {

            SWBResourceURL urlA = paramRequest.getActionUrl();
            urlA.setAction("admin_update");

            out.println("<form id=\"" + id + "_myform_repfile\"  name=\"" + id + "_myform_repfile\" action=\"" + urlA.toString() + "\" method=\"post\" >"); //onsubmit=\"submitForm('" + id + "_myform_repfile');return false;\"

            out.println("<fieldset>");
            out.println("<legend>");
            out.println(paramRequest.getLocaleString("msgFileRepositoryRes"));
            out.println("</legend>");


            out.println("<table width=\"100%\" border=\"0\" >");

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            String validFiles = getResourceBase().getAttribute(VALID_FILES, "");


            out.println("<tr><td colspan=\"2\"><B>" + paramRequest.getLocaleString("msgRolesDefinitionLevel") + "</B></td></tr>");
            out.println("<tr><td align=\"right\" width=150>" + paramRequest.getLocaleString("msgView") + ":</td>");
            out.println("<td><select name=\"ver\">" + getSelectOptions("ver", wsite, paramRequest) + "</select></td></tr>");
            out.println("<tr><td align=\"right\" width=150>" + paramRequest.getLocaleString("msgModify") + ":</td>");
            out.println("<td><select name=\"modificar\">" + getSelectOptions("modificar", wsite, paramRequest) + "</select></td></tr>");
            out.println("<tr><td align=\"right\"  width=150>" + paramRequest.getLocaleString("msgAdministrate") + ":</td>");
            out.println("<td><select name=\"administrar\">" + getSelectOptions("administrar", wsite, paramRequest) + "</select></td></tr>");

            out.println("<tr><td align=\"right\"  width=150>" + paramRequest.getLocaleString("msgValidFiles") + ":</td>");
            out.println("<td><input type=\"text\" name=\"validfiles\"  value=\"" + validFiles + "\"></td></tr>");


            out.println("</table>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" id=\"" + id + "btn\" name=\"btn\" >" + paramRequest.getLocaleString("msgBTNAccept"));
            out.println("</button>");
            out.println("</fieldset>");

            out.println("<fieldset>");
            out.println("<br> * " + paramRequest.getLocaleString("msgNote") + ": " + paramRequest.getLocaleString("msgRolesDependent"));

            out.println("</fieldset>");
            out.println("</form>");
        }

        out.println("</div>");
    }

    /**
     * Construye las opciones de selección para los niveles de administración del componente.
     * @param type Tipo de permiso cuyos valores pueden ser: "ver", "modificar", "administrar".
     * @param wsite Sitio Web del componente a administrar.
     * @param paramRequest SWBParamRequest.
     * @return Cadena con los valores del selector de niveles de administración del componente.
     */
    public String getSelectOptions(String type, WebSite wsite, SWBParamRequest paramRequest) {
        String strTemp = "";
        try {

            Resource base = getResourceBase();
            User user = paramRequest.getUser();

            String selectedItem = "";
            if (type.equals("ver")) {
                selectedItem = base.getAttribute(LVL_VIEW, "0");
            } else if (type.equals("modificar")) {
                selectedItem = base.getAttribute(LVL_MODIFY, "0");

            } else if (type.equals("administrar")) {
                selectedItem = base.getAttribute(LVL_ADMIN, "0");
            }

            strTemp = "<option value=\"-1\">" + paramRequest.getLocaleString("msgNoRolesAvailable") + "</option>";

            Iterator<Role> iRoles = wsite.getUserRepository().listRoles(); //DBRole.getInstance().getRoles(topicmap.getDbdata().getRepository());
            StringBuilder strRules = new StringBuilder("");
            strRules.append("\n<option value=\"0\">").append(paramRequest.getLocaleString("msgSelNone")).append("</option>");
            strRules.append("\n<optgroup label=\"Roles\">");
            while (iRoles.hasNext()) {
                Role oRole = iRoles.next();
                strRules.append("\n<option value=\"").append(oRole.getURI()).append("\" ").append(selectedItem.equals(oRole.getURI()) ? "selected" : "").append(">").append(oRole.getDisplayTitle(user.getLanguage())).append("</option>");
            }
            strRules.append("\n</optgroup>");

            strRules.append("\n<optgroup label=\"User Groups\">");
            Iterator<UserGroup> iugroups = wsite.getUserRepository().listUserGroups();
            while (iugroups.hasNext()) {
                UserGroup oUG = iugroups.next();
                strRules.append("\n<option value=\"").append(oUG.getURI()).append("\" ").append(selectedItem.equals(oUG.getURI()) ? "selected" : "").append(">").append(oUG.getDisplayTitle(user.getLanguage())).append("</option>");
            }
            strRules.append("\n</optgroup>");
            if (strRules.toString().length() > 0) {
                strTemp = strRules.toString();
            }

        } catch (Exception e) {
        }
        return strTemp;
    }

    /**
     * Obtiene el nivel de permisos del usuario.
     * @param user Usuario.
     * @return Entero que representa el nivel de permisos del usuario.
     */
    public int getLevelUser(User user) {
        int level = 0;

        if (null == user) {
            return level;
        }

        Resource base = getResourceBase();

        String uriView = base.getAttribute(LVL_VIEW, "0");
        String uriModify = base.getAttribute(LVL_MODIFY, "0");
        String uriAdmin = base.getAttribute(LVL_ADMIN, "0");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject gobj = null;
        try {
            gobj = ont.getGenericObject(uriAdmin);
        } catch (Exception e) {
            //log.error("Errror getLevelUser()",e);
        }

        UserGroup ugrp = null;
        Role urole = null;

        if (!uriAdmin.equals("0")) {
            if (gobj != null) {
                if (gobj instanceof UserGroup) {
                    ugrp = (UserGroup) gobj;
                    if (user.hasUserGroup(ugrp)) {
                        level = 3;
                    }
                } else if (gobj instanceof Role) {
                    urole = (Role) gobj;
                    if (user.hasRole(urole)) {
                        level = 3;
                    }
                }
            } else {
                level = 3;
            }
        } else {
            level = 3;
        }

        if (level == 0) {
            if (!uriModify.equals("0")) {
                gobj = ont.getGenericObject(uriModify);
                if (gobj != null) {
                    if (gobj instanceof UserGroup) {
                        ugrp = (UserGroup) gobj;
                        if (user.hasUserGroup(ugrp)) {
                            level = 2;
                        }
                    } else if (gobj instanceof Role) {
                        urole = (Role) gobj;
                        if (user.hasRole(urole)) {
                            level = 2;
                        }
                    }
                } else {
                    level = 2;
                }
            } else {
                level = 2;
            }
        }

        if (level == 0) {
            if (!uriView.equals("0")) {
                gobj = ont.getGenericObject(uriView);
                if (gobj != null) {
                    if (gobj instanceof UserGroup) {
                        ugrp = (UserGroup) gobj;
                        if (user.hasUserGroup(ugrp)) {
                            level = 1;
                        }
                    } else if (gobj instanceof Role) {
                        urole = (Role) gobj;
                        if (user.hasRole(urole)) {
                            level = 1;
                        }
                    }
                } else {
                    level = 1;
                }
            } else {
                level = 1;
            }
        }

        return level;
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if (action == null) {
            action = "";
        }

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        if (ACT_NEWFILE.equals(action)) {
            org.semanticwb.portal.util.FileUpload fup = new org.semanticwb.portal.util.FileUpload();
            fup.getFiles(request, null);
            String fname = fup.getFileName("ffile");
            String ftitle = fup.getValue("ftitle");
            String fdescription = fup.getValue("fdescription");
            String fcomment = fup.getValue("fcomment");
            String hftype = fup.getValue("hftype");
            String extfile = fup.getValue("extfile");

            String fid = fup.getValue("fid");
            String newVersion = fup.getValue("newVersion");
            String repoEleStat = fup.getValue("itemAwStatus");
            
            GenericObject go = null;
            RepositoryDirectory repoDir = (RepositoryDirectory) response.getWebPage();
            if (hftype != null && hftype.equals("file")) {
                byte[] bcont = fup.getFileData("ffile");

                RepositoryFile repoFile = null;
                boolean incremento = Boolean.FALSE;
                if (fid != null) {
                    go = ont.getGenericObject(fid);
                    repoFile = (RepositoryFile) go; //RepositoryFile.ClassMgr.getRepositoryFile(fid, repoDir.getProcessSite());
                    if (newVersion != null && newVersion.equals("nextInt")) {
                        incremento = Boolean.TRUE;
                    }
                } else {
                    repoFile = RepositoryFile.ClassMgr.createRepositoryFile(repoDir.getProcessSite());
                    repoFile.setRepositoryDirectory(repoDir);
                }
                repoFile.setTitle(ftitle);
                repoFile.setDescription(fdescription);

                User usr = response.getUser();

                repoFile.setOwnerUserGroup(usr.getUserGroup());

                //System.out.println("fname: "+fname);
                if (fname.indexOf("\\") != -1) {
                    fname = fname.substring(fname.lastIndexOf("\\") + 1);
                } else if (fname.indexOf("/") != -1) {
                    fname = fname.substring(fname.lastIndexOf("/") + 1);
                }
                //System.out.println("fname: "+fname);
                repoFile.storeFile(fname, new ByteArrayInputStream(bcont), fcomment, incremento, repoEleStat);
                
            } else {
                RepositoryURL repoUrl = null;
                boolean incremento = Boolean.FALSE;
                if (fid != null) {
                    go = ont.getGenericObject(fid);
                    repoUrl = (RepositoryURL) go;
                    if (newVersion != null && newVersion.equals("nextInt")) {
                        incremento = Boolean.TRUE;
                    }
                } else {
                    repoUrl = RepositoryURL.ClassMgr.createRepositoryURL(repoDir.getProcessSite());
                    repoUrl.setRepositoryDirectory(repoDir);
                }
                repoUrl.setTitle(ftitle);
                repoUrl.setDescription(fdescription);

                User usr = response.getUser();

                repoUrl.setOwnerUserGroup(usr.getUserGroup());
                repoUrl.storeFile(extfile.startsWith("http://")?extfile:"http://"+extfile, fcomment, incremento, repoEleStat);
            }
            response.setMode(SWBParamRequest.Mode_VIEW);
        } else if ("removefile".equals(action)) {
            String fid = request.getParameter("fid");

            SemanticObject so = ont.getSemanticObject(fid);
            so.remove();

        } else if ("admin_update".equals(action)) {
            String viewrole = request.getParameter("ver");
            String modifyrole = request.getParameter("modificar");
            String adminrole = request.getParameter("administrar");
            String validfiles = request.getParameter("validfiles");

            try {
                getResourceBase().setAttribute(LVL_VIEW, viewrole);
                getResourceBase().setAttribute(LVL_MODIFY, modifyrole);
                getResourceBase().setAttribute(LVL_ADMIN, adminrole);
                getResourceBase().setAttribute(VALID_FILES, validfiles);
                getResourceBase().updateAttributesToDB();

            } catch (Exception e) {
                log.error("Error al guardar configuración de niveles de usuario de ProcessFileRepository", e);
            }
            response.setMode(SWBActionResponse.Mode_ADMIN);
            response.setAction("edit");
        }
    }

    /**
     * Obtiene el tipo de archivo de acuerdo a su extensión.
     * @param filename Nombre del archivo.
     * @return Cadena con el tipo de archivo.
     */
    public static String getFileType(String filename) {
        String file = "Document";
        String type = filename.toLowerCase();
        if (type.indexOf(".bmp") != -1) {
            file = "Image";
        } else if (type.indexOf(".pdf") != -1) {
            file = "Adobe Acrobat";
        } else if (type.indexOf(".xls") != -1 || type.indexOf(".xlsx") != -1) {
            file = "Microsoft Excel";
        } else if (type.indexOf(".html") != -1 || type.indexOf(".htm") != -1) {
            file = "HTML file";
        } else if (type.indexOf("jpg") != -1 || type.indexOf("jpeg") != -1) {
            file = "Image";
        } else if (type.indexOf(".ppt") != -1 || type.indexOf(".pptx") != -1) {
            file = "Microsoft Power Point";
        } else if (type.indexOf(".vsd") != -1) {
            file = "Microsoft Visio";
        } else if (type.indexOf(".mpp") != -1) {
            file = "Microsoft Project";
        } else if (type.indexOf(".mmap") != -1) {
            file = "Mind Manager";
        } else if (type.indexOf(".exe") != -1) {
            file = "Application";
        } else if (type.indexOf(".txt") != -1) {
            file = "Text file";
        } else if (type.indexOf(".properties") != -1) {
            file = "Properties file";
        } else if (type.indexOf(".doc") != -1 || type.indexOf(".docx") != -1) {
            file = "Microsoft Word";
        } else if (type.indexOf(".xml") != -1) {
            file = "XML file";
        } else if (type.indexOf(".gif") != -1 || type.indexOf(".png") != -1) {
            file = "Image";
        } else if (type.indexOf(".avi") != -1) {
            file = "Media file";
        } else if (type.indexOf(".mp3") != -1) {
            file = "Audio file";
        } else if (type.indexOf(".wav") != -1) {
            file = "Audio file";
        } else if (type.indexOf(".xsl") != -1) {
            file = "XSLT file";
        } else {
            file = "URL file";
        }
        return file;
    }

    /**
     * Obtiene la ruta al archivo de ícono para un archivo con base en su extensión.
     * @param fileName Nombre del archivo.
     * @return Cadena con la ruta al icono del archivo.
     */
    public static String getFileIcon(String fileName) {
        String path = SWBPlatform.getContextPath()+"/swbadmin/jsp/process/repository/css/images/";
        String ret = "";
        String type = fileName.toLowerCase();
        if (type.indexOf(".bmp") != -1) {
            ret = path+"bmp.png";
        } else if (type.indexOf(".pdf") != -1) {
            ret = path+"pdf.png";
        } else if (type.indexOf(".png") != -1) {
            ret = path+"png.png";
        } else if (type.indexOf(".xls") != -1 || type.indexOf(".xlsx") != -1) {
            ret = path+"xlsx_win.png";
        } else if (type.indexOf(".html") != -1 || type.indexOf(".htm") != -1) {
            ret = path+"css.png";
        } else if (type.indexOf("jpg") != -1 || type.indexOf("jpeg") != -1) {
            ret = path+"jpeg.png";
        } else if (type.indexOf(".ppt") != -1 || type.indexOf(".pptx") != -1) {
            ret = path+"pptx_win.png";
        } else if (type.indexOf(".exe") != -1) {
            ret = path+"ini.png";
        } else if (type.indexOf(".txt") != -1 || type.indexOf(".properties") != -1) {
            ret = path+"text.png";
        } else if (type.indexOf(".doc") != -1 || type.indexOf(".docx") != -1) {
            ret = path+"docx_win.png";
        } else if (type.indexOf(".xml") != -1 || type.indexOf(".xsl") != -1) {
            ret = SWBPlatform.getContextPath()+"/swbadmin/images/repositoryfile/ico_xml.gif";
        } else if (type.indexOf(".mmap") != -1) {
            ret = SWBPlatform.getContextPath()+"/swbadmin/images/repositoryfile/ico_mindmanager.GIF";
        } else if (type.indexOf(".gif") != -1) {
            ret = path+"gif.png";
        } else if (type.indexOf(".avi") != -1) {
            ret = path+"avi.png";
        } else if (type.indexOf(".mp3") != -1) {
            ret = path+"mp3.png";
        } else if (type.indexOf(".wav") != -1) {
            ret = "wav.png";
        } else {
            ret = path+"unknown.png";
        }
        return ret;
    }
    
    /**
     * Obtiene la lista de archivos del repositorio.
     * @param request The request.
     * @param paramRequest The SWBParamRequest.
     * @return Lista con los archivos del repositorio.
     */
    private List<RepositoryElement> listFiles(HttpServletRequest request, SWBParamRequest paramRequest) {
        List<RepositoryElement> ret = new ArrayList<RepositoryElement>();
        HashMap<String, RepositoryElement> hmNodes = new HashMap<String, RepositoryElement>();
        User user = paramRequest.getUser();
        String lang = "es";
        
        RepositoryDirectory repoDir = null;
        if (paramRequest.getWebPage() instanceof RepositoryDirectory) {
            repoDir = (RepositoryDirectory) paramRequest.getWebPage();
        }
        
        if (repoDir != null) {
            if (user != null && user.getLanguage() != null) {
                lang = user.getLanguage();
            }

            String usrgpo_filter = request.getParameter("usrgpo_filter");
            String orderBy = request.getParameter("sort");
            if (null == orderBy || orderBy.equals("")) {
                orderBy = "title";
            }

            //SORTING
            Iterator<RepositoryFile> itrf = repoDir.listRepositoryElements();
            while (itrf.hasNext()) {
                RepositoryElement repoFile = itrf.next();
                VersionInfo version = repoFile.getActualVersion();
                String skey = repoFile.getId();

                boolean showFile = Boolean.FALSE;
                if (repoFile.getOwnerUserGroup() != null) {
                    UserGroup ugpo = repoFile.getOwnerUserGroup();
                    String ugid = null;
                    if (ugpo != null) {
                        ugid = ugpo.getId();
                    }
                    if (null != ugid && ugid.equals(usrgpo_filter) || usrgpo_filter == null || usrgpo_filter.equals("")) {
                        showFile = Boolean.TRUE;
                    }
                } else if (usrgpo_filter == null || usrgpo_filter.equals("")) {
                    showFile = Boolean.TRUE;
                }

                if (!showFile || version == null) continue;

                if (orderBy.equals("title")) {
                    skey = repoFile.getDisplayTitle(lang) + " - " + repoFile.getId();
                } else if (orderBy.equals("date")) {
                    skey = version.getCreated().getTime() + " - " + repoFile.getDisplayTitle(lang) + " - " + repoFile.getId();
                } else if (orderBy.equals("type")) {
                    String file = version.getVersionFile();
                    String type = getFileType(file);
                    skey = type + "-" + repoFile.getDisplayTitle(lang) + " - " + repoFile.getId();
                } else if (orderBy.equals("usr")) {
                    User usrc = version.getCreator();
                    skey = " - " + repoFile.getDisplayTitle(lang) + " - " + repoFile.getId();
                    if (usrc != null) {
                        skey = usrc.getFullName() + skey;
                    }
                } else if (orderBy.equals("gpousr")) {
                    if (repoFile.getOwnerUserGroup() == null) {
                        skey = " - " + " " + " - " + repoFile.getId();
                    } else {
                        skey = " - " + repoFile.getOwnerUserGroup().getDisplayTitle(lang) + " - " + repoFile.getId();
                    }

                } else if (orderBy.equals("status")) {
                    if (repoFile.getStatus() == null) {
                        skey = " - " + " " + " - " + repoFile.getId();
                    } else {
                        skey = " - " + repoFile.getStatus().getDisplayTitle(lang) + " - " + repoFile.getId();
                    }
                }
                hmNodes.put(skey, repoFile);
            }

            ArrayList<String> list = new ArrayList<String>(hmNodes.keySet());
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
            Iterator<String> keys = list.iterator();
            
            while (keys.hasNext()) {
                String key = keys.next();
                ret.add((RepositoryElement)hmNodes.get(key));
            }
        }
        return ret;
    }
    
    /**
     * Obtiene la lista de versiones de un elemento del repositorio.
     * @param el Elemento del repositorio del cual se obtendrán las versiones.
     * @return Lista de versiones del elemento del repositorio.
     */
    private List<VersionInfo> getFileVersions(RepositoryElement el) {
        ArrayList<VersionInfo> ret = new ArrayList<VersionInfo>();
        
        if (el != null) {
            VersionInfo vi = el.getLastVersion();
            VersionInfo ver = null;

            if (null != vi) {
                ver = vi;
                while (ver.getPreviousVersion() != null) {
                    ver = ver.getPreviousVersion();
                }
            }

            if (ver != null) {
                ret.add(ver);
                while (ver != null) {
                    ver = ver.getNextVersion();
                    if (ver != null) {
                        ret.add(ver);
                    }
                }
            }
        }
        return ret;
    }
}
