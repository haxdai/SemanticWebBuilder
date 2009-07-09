/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * CommentSwf.java
 *
 * Created on 14 de octubre de 2002, 11:02 AM
 */

package org.semanticwb.portal.resources;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.admin.admresources.util.WBAdmResourceUtils;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBResourceURLImp;
import org.semanticwb.portal.util.FileUpload;


/**
 * Despliega los elementos indicados en la administracion de este recurso a fin 
 * de que los usuarios finales puedan enviar comentarios a una cuenta de 
 * correo en espec&iacute;fico a través de una interfaz hecha con archivos de 
 * tipo Flash.
 *
 * Displays the interface configured in this resource's administration mode, so 
 * that the end users send their comments to a specific e-mail account through a
 * Flash type interface.
 *
 * @author : Vanessa Arredondo Núñez
 * @version 1.0
 * @see org.semanticwb.portal.resources.Comment
 */

public class CommentSwf extends Comment {
    
    
    private static Logger log = SWBUtils.getLogger(Comment.class);
    
    /**
     * Creates a new instance of ComentSwf
     */
    public CommentSwf() {
    }

    /**
     * Obtiene los datos de la configuraci&oacute;n del recurso, sin tomar en
     * cuenta aquellos para el env&iacute;o del correo y genera un objeto
     * <b>Document</b> con ellos.
     * @param request
     * @param response
     * @param reqParams
     * @return <b>Document</b>
     * @throws AFException
     * @throws IOException
     */       
    @Override
    public Document getDom(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest reqParams)
            throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        String action = (null != request.getParameter("com_act") 
                         && !"".equals(request.getParameter("com_act").trim())
                         ? request.getParameter("com_act").trim()
                         : "com_step2");
        
        try {
            String lang = reqParams.getUser().getLanguage();
            WebPage topic = reqParams.getTopic();
            Document  dom = SWBUtils.XML.getNewDocument();
            
            if ("com_step3".equals(action)) {
                dom = getDomEmail(request, response, reqParams); // Envia correo
            } else {
                // Nueva ventana con formulario
                User user = reqParams.getUser();
                SWBResourceURLImp url = new SWBResourceURLImp(request, base,
                        reqParams.getTopic(), SWBResourceURL.UrlType_RENDER);
                url.setResourceBase(base);
                url.setMode(SWBResourceURLImp.Mode_VIEW);
                url.setWindowState(SWBResourceURLImp.WinState_MAXIMIZED);
                url.setParameter("com_act", "com_step3");
                url.setTopic(topic);
                url.setCallMethod(reqParams.Call_DIRECT);
                
                Element root = dom.createElement("form");
                root.setAttribute("path", path);
                root.setAttribute("accion", url.toString());
                root.setAttribute("styleClass",
                        base.getAttribute("styleClass", "").equals("")
                        ? ""
                        : " class=\"" + base.getAttribute("styleClass", "") + "\"");
                root.setAttribute("styleClassClose", "</div>");
                if (!"".equals(base.getAttribute("swf", "").trim())) {
                    String strSwfvar = "accion=" + url.toString();
                    root.setAttribute("swf", webWorkPath + "/" 
                            + base.getAttribute("swf").trim());
                    
                    NodeList ndlSwfvar = base.getDom().getElementsByTagName(
                                                       "swfvar");
                    for (int i = 0; i < ndlSwfvar.getLength(); i++) {
                        strSwfvar += "&" + ndlSwfvar.item(i).getChildNodes(
                                ).item(0).getNodeValue();
                    }
                    //if (user.isLoged())  // TODO ver. 4
                    {
                        strSwfvar += "&txtFromName=";
                        strSwfvar += ("1".equals(base.getAttribute("firstname", "0").trim())
                                && (null != user.getFirstName()
                                && !"".equals(user.getFirstName().trim()))
                                ? user.getFirstName().trim()
                                : "");
                        strSwfvar += ("1".equals(base.getAttribute("lastname", "0").trim())
                                && (null != user.getLastName()
                                && !"".equals(user.getLastName().trim()))
                                ? " " + user.getLastName().trim()
                                : "");
                        strSwfvar += ("1".equals(base.getAttribute("middlename", "0").trim())
                                && (null != user.getSecondLastName()
                                && !"".equals(user.getSecondLastName().trim()))
                                ? " " + user.getSecondLastName().trim()
                                : "");
                        strSwfvar += "&txtFromEmail=";
                        strSwfvar += (null != user.getEmail()
                                && !"".equals(user.getEmail().trim())
                                ? " " + user.getEmail().trim()
                                : "");
                    }
                    strSwfvar += "&txtTopic=" + topic.getTitle(lang);
                    strSwfvar += "&txtTopicDesc=" + topic.getDescription(lang);
                    root.setAttribute("swfvars", strSwfvar);
                }
                dom.appendChild(root); 
             }
             return dom;
        } catch (Exception e) {
            log.error("Error while generating the comments form in resource "
                    + base.getResourceType().getResourceClassName()
                    + " with identifier " + base.getId() + " - "
                    + base.getTitle(), e);
        }
        return null;
    }
    
 
    /**
     * Muestra la vista para los datos de administraci&oacute;n de este recurso
     * y realiza las operaciones de almacenamiento de informaci&oacute;n necesarias.
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    @Override
    public void doAdmin(HttpServletRequest request, 
            HttpServletResponse response, SWBParamRequest paramsRequest) 
            throws SWBResourceException, IOException {
        
        StringBuffer ret = new StringBuffer("");
        Resource base = getResourceBase();
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        String msg = paramsRequest.getLocaleString("msgUndefinedOperation");
        String action = (null != request.getParameter("act")
                         && !"".equals(request.getParameter("act").trim())
                         ? request.getParameter("act").trim()
                         : paramsRequest.getAction());
        
        if (action.equals("add") || action.equals("edit")) {
            ret.append(getForm(request, paramsRequest));
        } else if(action.equals("update")) {
            FileUpload fup = new FileUpload();
            
            try {
                fup.getFiles(request, response);
                String applet = null;                
                String value = (null != fup.getFileName("template")
                        && !"".equals(fup.getFileName("template").trim())
                        ? fup.getFileName("template").trim()
                        : null);
                if (value != null || !"".equals(base.getAttribute(
                        "template", "").trim())) {
                    if (value != null) {
                        String file = admResUtils.getFileName(base, value);
                        if (file != null && !file.trim().equals("")) {
                            if (!admResUtils.isFileType(file, "xsl|xslt")) {
                                msg = paramsRequest.getLocaleString("msgErrFileType")
                                        + " <i>xsl, xslt</i>: " + file;
                            } else {
                                applet = admResUtils.uploadFileParsed(base, fup,
                                        "template", request.getSession().getId());
                                if (applet != null && !applet.trim().equals("")) {    
                                    base.setAttribute("template", file);
                                    path = webWorkPath + "/";
                                } else {
                                    msg = paramsRequest.getLocaleString("msgErrUploadFile")
                                            + " <i>" + value + "</i>.";
                                }
                            }
                        } else {
                            msg = paramsRequest.getLocaleString("msgErrUploadFile")
                                    + " <i>" + value + "</i>.";
                        }
                    }
                }
                value = (null != fup.getValue("noimg")
                         && !"".equals(fup.getValue("noimg").trim())
                         ? fup.getValue("noimg").trim()
                         : "0");
                if ("1".equals(value)
                        && !"".equals(base.getAttribute("img", "").trim())) {
                    SWBUtils.IO.removeDirectory(SWBPlatform.getWorkPath()
                                                + base.getWorkPath() + "/"
                                                + base.getAttribute("img").trim());
                    base.removeAttribute("img");                        
                } else {
                    value = (null != fup.getFileName("img")
                             && !"".equals(fup.getFileName("img").trim())
                             ? fup.getFileName("img").trim()
                             : null);
                    if (value != null) {
                        String file = admResUtils.getFileName(base, value);
                        if (file != null && !file.trim().equals("")) {
                            if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif")) {
                                msg = paramsRequest.getLocaleString("msgErrFileType")
                                        + " <i>bmp, jpg, jpeg, gif</i>: " + file;
                            } else {
                                if (admResUtils.uploadFile(base, fup, "img")) {
                                    base.setAttribute("img", file);
                                } else {
                                    msg = paramsRequest.getLocaleString("msgErrUploadFile")
                                            + " <i>" + value + "</i>.";
                                }
                            }
                        } else {
                            msg = paramsRequest.getLocaleString("msgErrUploadFile")
                                    + " <i>" + value + "</i>.";
                        }
                    }
                }

                value = (null != fup.getFileName("swf")
                         && !"".equals(fup.getFileName("swf").trim())
                         ? fup.getFileName("swf").trim()
                         : null);
                if (value != null) {
                    String file = admResUtils.getFileName(base, value);
                    if (file != null && !file.trim().equals("")) {
                        if (!admResUtils.isFileType(file, "swf|emf|wmf")) {
                            msg = paramsRequest.getLocaleString("msgErrFileType")
                                    + " <i>swf, emf, wmf</i>: " + file;
                        } else {
                            if (admResUtils.uploadFile(base, fup, "swf")) {
                                base.setAttribute("swf", file);
                            } else {
                                msg = paramsRequest.getLocaleString("msgErrUploadFile")
                                        + " <i>" + value + "</i>.";
                            }
                        }
                    } else {
                        msg = paramsRequest.getLocaleString("msgErrUploadFile")
                                + " <i>" + value + "</i>.";
                    }
                }

                if (null != fup.getValue("area")
                        && !"".equals(fup.getValue("area").trim())) {
                    base.setAttribute("area", fup.getValue("area").trim());
                }
                if (null != fup.getValue("responsable")
                        && !"".equals(fup.getValue("responsable").trim())) {
                    base.setAttribute("responsable",
                                      fup.getValue("responsable").trim());
                }
                if (null != fup.getValue("email")
                        && !"".equals(fup.getValue("email").trim())) {
                    base.setAttribute("email", fup.getValue("email").trim());
                }                    
                setAttribute(base, fup, "alt");
                setAttribute(base, fup, "btntexto");
                setAttribute(base, fup, "lnktexto");
                setAttribute(base, fup, "blnstyle");
                setAttribute(base, fup, "firstname", "1");
                setAttribute(base, fup, "lastname", "1");
                setAttribute(base, fup, "middlename", "1");
                setAttribute(base, fup, "styleClass");
                setAttribute(base, fup, "menubar", "yes");
                setAttribute(base, fup, "toolbar", "yes");
                setAttribute(base, fup, "status", "yes");
                setAttribute(base, fup, "location", "yes");
                setAttribute(base, fup, "directories", "yes");
                setAttribute(base, fup, "scrollbars", "yes");
                setAttribute(base, fup, "resizable", "yes");
                setAttribute(base, fup, "width");
                setAttribute(base, fup, "height");
                setAttribute(base, fup, "top");
                setAttribute(base, fup, "left");
                setAttribute(base, fup, "subject");
                setAttribute(base, fup, "headermsg");
                setAttribute(base, fup, "footermsg");
                setAttribute(base, fup, "generatelog");

                base.updateAttributesToDB();
                Document dom = base.getDom();
                if (dom != null) {
                    removeAllNodes(dom, Node.ELEMENT_NODE, "swfvar");
                } else {
                    dom = SWBUtils.XML.getNewDocument();
                    Element root = dom.createElement("resource");
                    dom.appendChild(root);
                }
                value = (null != fup.getValue("swfvar")
                         && !"".equals(fup.getValue("swfvar").trim())
                         ? fup.getValue("swfvar").trim()
                         : null);
                if (value != null) {
                    StringTokenizer stk = new StringTokenizer(value, "|");
                    while (stk.hasMoreTokens()) {
                        value = stk.nextToken();
                        Element emn = dom.createElement("swfvar");
                        emn.appendChild(dom.createTextNode(value));
                        dom.getFirstChild().appendChild(emn);
                    }
                }
                base.setXml(SWBUtils.XML.domToXml(dom));
                msg = paramsRequest.getLocaleString("msgOkUpdateResource")
                        + " " + base.getId();
                if (applet != null && !"".equals(applet.trim())) {
                    ret.append(applet);
                } else {
                    ret.append("<script language=\"JavaScript\">\n"
                        + "   location='"
                        + paramsRequest.getRenderUrl().setAction("edit").toString()
                        + "';\n"
                        + "</script>\n");
                }
            } catch (Exception e) {
                log.error(e);
                msg = paramsRequest.getLocaleString("msgErrUpdateResource") 
                        + " " + base.getId();
            }
            ret.append("<script language=\"JavaScript\">\n"
                    + "   alert('" + msg + "');\n"
                    + "</script>\n");
        } else if (action.equals("remove")) {
            msg = admResUtils.removeResource(base);
            ret.append("<script language=\"JavaScript\">\n"
                    + "   alert('" + msg + "');\n"
                    + "</script>\n");
        }
        response.getWriter().print(ret.toString());
    }
    
    /**
     * Arma una cadena que contiene el c&oacute;digo HTML para mostrar la forma de los 
     * datos presentados por la pantalla de administraci&oacute;n del recurso.
     * @param request objeto de la petici&oacute;n de HTTP
     * @param paramsRequest objeto con las relaciones necesarias para la 
     * interacci&oacute;n con mas objetos de WebBuilder.
     * @return <b>String</b>
     */
    private String getForm(HttpServletRequest request,
            SWBParamRequest paramsRequest) {
        
        StringBuffer ret = new StringBuffer("");
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        Resource base = getResourceBase();
        
        try {
            SWBResourceURL url = paramsRequest.getRenderUrl().setAction("update");
            ret.append("<div class=\"swbform\">");
            ret.append("<form name=\"frmResource\" method=\"post\" enctype=\"multipart/form-data\" action=\""
                    + url.toString() + "\"> \n");
            ret.append("<fieldset>");
            ret.append("<legend>"+paramsRequest.getLocaleString("msgStep1")+"</legend>");
            ret.append("<table>");
/*            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append(paramsRequest.getLocaleString("msgStep1"));
            ret.append("</td> \n");
            ret.append("</tr> \n");*/
            ret.append("<tr> \n");
            ret.append("<td align=\"right\" valign=\"top\">"
                    + paramsRequest.getLocaleString("msgTemplate")
                    + " (xsl, xslt):</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"file\" name=\"template\" onChange=\"isFileType(this, 'xsl|xslt');\" />");
            //if (!"".equals(base.getAttribute("template", "").trim()))
            if (path.indexOf(webWorkPath) !=-1) {
                ret.append("<p>"
                        + paramsRequest.getLocaleString("msgCurrentTemplate")
                        + " <a href=\""+ path
                        + base.getAttribute("template").trim()
                        + "\">" + base.getAttribute("template").trim()
                        + "</a></p>");
            } else {
                ret.append("<p>" + paramsRequest.getLocaleString("msgByDefault")
                        + " <a href=\"" + path + name + ".xslt\">" + name 
                        + ".xslt</a></p>");
            }
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgImage")
                    + " (bmp, gif, jpg, jpeg):</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"file\" name=\"img\" onClick=\"this.form.btntexto.value=''; this.form.lnktexto.value=''\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if (!"".equals(base.getAttribute("img", "").trim())) {
                ret.append("<p>"
                        + admResUtils.displayImage(base,
                                      base.getAttribute("img").trim(), "img")
                                      + "<input type=checkbox name=noimg value=1>"
                                      + paramsRequest.getLocaleString("msgCutImage")
                                      + " <i>" + base.getAttribute("img").trim()
                                      + "</i></p>");
            }
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgAlt") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=alt ");
            if (!"".equals(base.getAttribute("alt", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("alt").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgButton") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=btntexto ");
            if (!"".equals(base.getAttribute("btntexto", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("btntexto").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgLink")
                    + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=lnktexto ");
            if (!"".equals(base.getAttribute("lnktexto", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("lnktexto").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgStyle") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=blnstyle ");
            if (!"".equals(base.getAttribute("blnstyle", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("blnstyle").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">* "
                    + paramsRequest.getLocaleString("msgFlash")
                    + " (swf, emf, wmf):</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"file\" name=\"swf\" onChange=\"isFileType(this, 'swf|emf|wmf');\"/>");
            if (!"".equals(base.getAttribute("swf", "").trim())) {
                ret.append("<p>" + paramsRequest.getLocaleString("msgCurrentSwf")
                        + " <i>" + base.getAttribute("swf").trim() + "</i></p>");
            }
            ret.append("</td> \n");
            ret.append("</tr> \n");
            
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgGenerateLog")
                    + " :</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"checkbox\" name=\"generatelog\" value=\"1\"");
            if ("1".equals(base.getAttribute("generatelog", "0"))) {
                ret.append(" checked");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgSwfConfiguration")
                    + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=txtSwfvar><input type=hidden name=swfvar ");
            if (!"".equals(base.getAttribute("swfvar", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("swfvar").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append(">");
            ret.append("\n<input type=button name=btnAdd  value="
                    + paramsRequest.getLocaleString("btnAdd")
                    + " onClick=\"addOption(this.form.selSwfvar, this.form.txtSwfvar)\" class=boton>");
            ret.append("\n<input type=button name=btnEdit value="
                    + paramsRequest.getLocaleString("btnEdit")
                    + " onClick=\"updateOption(this.form.selSwfvar, this.form.txtSwfvar)\" class=boton>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td>&nbsp;</td> \n");
            ret.append("<td>");
            ret.append("\n<select name=\"selSwfvar\" size=5 multiple onChange=\"editOption(this.form.selSwfvar, this.form.txtSwfvar)\">");
            String swfvar = "";
            Document dom = base.getDom();
            if (dom != null) {
                NodeList node = dom.getElementsByTagName("swfvar");
                if (node.getLength() > 0) {
                    for (int i = 0; i < node.getLength(); i++) {
                        swfvar = node.item(i).getChildNodes().item(
                                0).getNodeValue().trim();
                        if (!"".equals(swfvar.trim())) {
                            ret.append("\n<option value=\""
                                    + swfvar.trim().replaceAll("\"", "&#34;")
                                    + "\">" + swfvar.trim() + "</option>");
                        }
                    }
                }                  
            }
            ret.append("\n</select>");
            ret.append("\n<input type=button name=btnDel value="
                    + paramsRequest.getLocaleString("btnRemove")
                    + " onClick=\"deleteOption(this.form.selSwfvar, this.form.txtSwfvar)\">");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgFirstName")
                    + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"checkbox\" name=\"firstname\" value=\"1\"");
            if ("1".equals(base.getAttribute("firstname", "0"))) {
                ret.append(" checked");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");  
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgLastName") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"checkbox\" name=\"lastname\" value=\"1\"");
            if ("1".equals(base.getAttribute("lastname", "0"))) {
                ret.append(" checked");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");  
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgMiddleName")
                    + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"checkbox\" name=\"middlename\" value=\"1\"");
            if ("1".equals(base.getAttribute("middlename", "0"))) {
                ret.append(" checked");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");             
            ret.append("<tr> \n");

            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgStyleClass") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=\"text\" name=\"styleClass\" value=\""
                    + base.getAttribute("styleClass", "") + "\">");
            ret.append("</td> \n");
            ret.append("</tr> \n");

            ret.append("</table> \n");
            ret.append("</fieldset><br />");
            ret.append("<fieldset>");
            ret.append("<legend>"+paramsRequest.getLocaleString("msgStep2")+"</legend>");
            ret.append("<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"7\">");
            ret.append("<tr><td width=\"35%\"></td><td width=\"65%\"></td>");

/*            ret.append("<td colspan=2>");
            ret.append("<br><br>");
            ret.append(paramsRequest.getLocaleString("msgStep2") + "</font>");
            ret.append("</td> \n");
            ret.append("</tr> \n");*/
            ret.append(admResUtils.loadWindowConfiguration(base, paramsRequest));

            ret.append("</table> \n");
            ret.append("</fieldset><br />");
            ret.append("<fieldset>");
            ret.append("<legend>"+paramsRequest.getLocaleString("msgStep3")+"</legend>");
            ret.append("<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"7\">");
            ret.append("<tr><td width=\"35%\"></td><td width=\"65%\"></td>");
/*            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<br><br>");
            ret.append(paramsRequest.getLocaleString("msgStep3"));
            ret.append("</td> \n");
            ret.append("</tr> \n");*/
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">* "
                    + paramsRequest.getLocaleString("msgArea") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=area ");
            if (!"".equals(base.getAttribute("area", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("area").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">* "
                    + paramsRequest.getLocaleString("msgResponsable") + "</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text name=responsable ");
            if (!"".equals(base.getAttribute("responsable", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("responsable").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n"); 
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">* "
                    + paramsRequest.getLocaleString("msgEmail") + "</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text name=email ");
            if (!"".equals(base.getAttribute("email", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("email").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n"); 
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgSubjectTag") + "</td> \n");
            ret.append("<td>");
            ret.append("<input type=text name=subject ");
            if (!"".equals(base.getAttribute("subject", "").trim())) {
                ret.append(" value=\""
                        + base.getAttribute("subject").trim().replaceAll("\"", "&#34;")
                        + "\"");
            }
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgMessageHeader")
                    + "</td> \n");
            ret.append("<td>");
            ret.append("<textarea name=headermsg>");
            if (!"".equals(base.getAttribute("headermsg", "").trim())) {
                ret.append(base.getAttribute("headermsg").trim().replaceAll("\"", "&#34;"));
            }
            ret.append("</textarea></td> \n");
            ret.append("</tr> \n");               
            ret.append("<tr> \n");
            ret.append("<td align=\"right\">"
                    + paramsRequest.getLocaleString("msgMessageFooter") + "</td> \n");
            ret.append("<td>");
            ret.append("<textarea name=footermsg>");
            if (!"".equals(base.getAttribute("footermsg", "").trim())) {
                ret.append(base.getAttribute("footermsg").trim().replaceAll("\"", "&#34;"));
            }
            ret.append("</textarea></td> \n");
            ret.append("</tr> \n");
            ret.append("</table> \n");
            ret.append("</fieldset>\n");
            ret.append("<fieldset>\n");
            ret.append("\n<input type=submit name=btnSave value="
                    + paramsRequest.getLocaleString("btnSubmit")
                    + " onClick=\"if(jsValida(this.form)) return true; else return false;\">&nbsp;");
            ret.append("<input type=reset name=btnReset value="
                    + paramsRequest.getLocaleString("btnReset") + ">");
            ret.append("</fieldset>\n");
            ret.append("\n<br>* " + paramsRequest.getLocaleString("msgRequiredData"));
            ret.append("</form> \n");
            ret.append("</div> \n");
            ret.append(getScript(request, paramsRequest));
        } catch (Exception e) {
            log.error(e);
        }
        return ret.toString();
    }

    /**
     * Crea un objeto String que contiene el c&oacute;digo de JavaScript necesario para
     * validar los datos capturados en la forma presentada.
     * @param request
     * @param paramsRequest
     * @return <b>String</b> contiene el c&oacute;digo de JavaScript
     */       
    private String getScript(HttpServletRequest request,
            SWBParamRequest paramsRequest) {
        
        StringBuffer ret = new StringBuffer("");
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        
        try {
            ret.append("\n<script>");
            ret.append("\nfunction jsValida(pForm) {");
            //ret.append("\n");
            /*
            if ("".equals(getResourceBase().getAttribute("template","").trim()))
            {
                ret.append("\n   if(pForm.template.value==null || pForm.template.value=='' || pForm.template.value==' ')");
                ret.append("\n   {");
                ret.append("\n       alert('" + paramsRequest.getLocaleString("msgTemplateRequired") + "');");
                ret.append("\n       pForm.template.focus();");
                ret.append("\n       return false;");
                ret.append("\n   }");
            }
            */
            if ("".equals(getResourceBase().getAttribute("swf","").trim())) {
                ret.append("\n   if (pForm.swf.value==null || pForm.swf.value=='' || pForm.swf.value==' ') {");
                ret.append("\n       alert('"
                        + paramsRequest.getLocaleString("msgFlashRequired")
                        + "');");
                ret.append("\n       pForm.swf.focus();");
                ret.append("\n       return false;");
                ret.append("\n   }");
            }            
            ret.append("\n   if (!isFileType(pForm.template, 'xsl|xslt')) return false;");
            ret.append("\n   if (!isFileType(pForm.img, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if (!isFileType(pForm.swf, 'swf|emf|wmf')) return false;");
            ret.append("\n   if (!isNumber(pForm.width)) return false;");
            ret.append("\n   if (!isNumber(pForm.height)) return false;");
            ret.append("\n   if (!isNumber(pForm.top)) return false;");
            ret.append("\n   if (!isNumber(pForm.left)) return false;");
            ret.append("\n   if (pForm.area.value==null || pForm.area.value=='' || pForm.area.value==' ') {");
            //ret.append("\n   ");
            ret.append("\n       alert('"
                    + paramsRequest.getLocaleString("msgAreaRequired") + "');");
            ret.append("\n       pForm.area.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   if (pForm.responsable.value==null || pForm.responsable.value=='' || pForm.responsable.value==' ') {");
            //ret.append("\n   ");
            ret.append("\n       alert('"
                    + paramsRequest.getLocaleString("msgManagerRequired") + "');");
            ret.append("\n       pForm.responsable.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   if (pForm.email.value==null || pForm.email.value=='' || pForm.email.value==' ') {");
            //ret.append("\n   ");
            ret.append("\n       alert('"
                    + paramsRequest.getLocaleString("msgEmailRequired") + "');");
            ret.append("\n       pForm.email.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   else if(!isEmail(pForm.email)) return false;");            
            ret.append("\n   replaceChars(pForm.headermsg);");
            ret.append("\n   replaceChars(pForm.footermsg);");
            ret.append("\n   pForm.swfvar.value='';");
            ret.append("\n   for (var i=0; i<pForm.selSwfvar.length; i++) {");
            //ret.append("\n   ");
            ret.append("\n       if (i>0) pForm.swfvar.value+=\"|\";");
            ret.append("\n       pForm.swfvar.value+=pForm.selSwfvar.options[i].value;");
            ret.append("\n   }");
            ret.append("\n   return true;");
            ret.append("\n}");
            ret.append(admResUtils.loadIsEmail());
            ret.append(admResUtils.loadAddOption());
            ret.append(admResUtils.loadEditOption());
            ret.append(admResUtils.loadUpdateOption());
            ret.append(admResUtils.loadDeleteOption());
            ret.append(admResUtils.loadDuplicateOption());
            ret.append(admResUtils.loadIsFileType());
            ret.append(admResUtils.loadReplaceChars());
            ret.append(admResUtils.loadIsNumber());
            ret.append("\n</script>");  
        } catch (Exception e) {
            log.error(e);
        }
        return ret.toString();
    }
}