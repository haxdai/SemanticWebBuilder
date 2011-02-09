/**  
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
**/ 
 
/*
 * Recommend.java
 *
 * Created on 14 de octubre de 2002, 11:02 AM
 */
package org.semanticwb.pymtur.microsites;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBResourceURLImp;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.platform.SemanticObject;


// TODO: Auto-generated Javadoc
/**
 * Despliega y administra recomendaciones de usuarios
 * finales bajo ciertos criterios (configuraci&oacute;n del recurso).
 *
 * Object that is in charge to unfold and to administer recommendations of end 
 * users under certain criteria (resource configuration).
 *
 * @author : Vanessa Arredondo N&uacute;&ntilde;ez
 * @version 1.0
 */
public class Recommend extends GenericAdmResource {


    /**
     * objeto encargado de crear mensajes en los archivos log de SemanticWebBuilder (SWB).
     * <p>object that creates messages in SWB's log file.</p>
     */
    private static Logger log = SWBUtils.getLogger(Recommend.class);

    /**
     * la plantilla XSLT para generar la vista de los resultados de la consulta
     * de base de datos. <p>the XSLT template that generates the database query
     * results' view.</p>
     */
    javax.xml.transform.Templates tpl;

    /**
     * el nombre de la carpeta de trabajo general. <p>the name for the general work directory</p>
     */
    String webWorkPath = "/work";

    /**
     * el nombre de la clase de este recurso. <p>this resource's class name</p>
     */
    String name = getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);

    /**
     * la ruta parcial del directorio en que se encuentra la plantilla XSLT por defecto
     * <p>the partial path for the directory in which the default XSLT template is stored.</p>
     */
    String path = SWBPlatform.getContextPath() + "/swbadmin/xsl/";


    /** 
     * Creates a new instance of Recommend.
     */
    public Recommend() {
    }

    /**
     * Asocia la informaci&oacute;n indicada por el usuario en la vista de
     * administraci&oacute;n a la clase de este recurso manteni&eacute;ndola en memoria.
     * <p>Associates the data indicated by the user in the administration
     * view to this resource's class keeping it in memory.</p>
     * @param base    un {@code resource} con la informaci&oacute;n seleccionada en
     *                la vista de administraci&oacute;n de este recurso
     *                <p>a resource with the information selected in this
     *                resource's administration view</p>
     */
    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            webWorkPath = (String) SWBPortal.getWebWorkPath() + base.getWorkPath();
        } catch (Exception e) {
            log.error("Error while setting resource base: " + base.getId() + "-" + base.getTitle(), e);
        }
        if (!"".equals(base.getAttribute("template", "").trim())) {
            try {
                tpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath(base.getWorkPath() + "/" + base.getAttribute("template").trim()));
                path = webWorkPath + "/";
            } catch (Exception e) {
                log.error("Error while loading resource template: " + base.getId(), e);
            }
        }
        if (tpl == null) {
            try {
                tpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getAdminFileStream("/swbadmin/xsl/" + name + "/" + name + ".xslt"));
            } catch (Exception e) {
                log.error("Error while loading default resource template: " + base.getId(), e);
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {
        if (paramRequest.getMode().equalsIgnoreCase("sendEmail")) {
            doSendEmail(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Genera un {@code document} con la estructura de informaci&oacute;n definida
     * para la vista de administraci&oacute;n. <p>Generates a {@code document}
     * with the data structure defined for the administration view.</p>
     * 
     * @param request la petici&oacute;n HTTP generada por el usuario. <p>the user's HTTP request</p>
     * @param response la respuesta hacia el usuario.<p>the response to the user</p>
     * @param paramRequest el objeto generado por SWB y asociado a la petici&oacute;n
     * del usuario.<p>the object generated by SWB and asociated to the user's request</p>
     * @return el DOM generado con la informaci&oacute;n a mostrar the
     * @throws SWBResourceException si no existe el archivo de mensajes del idioma utilizado.
     * <p>if there is no file message of the corresponding language.</p>
     * @throws IOException si la llamada al m&eacute;todo {@code getDomEmail} la propaga.
     * <p>if it is propagated by the call to method {@code getDomEmail}.</p>
     * {@code document} generated with the information to show.</p>
     */
    public Document getDom(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String action = (null != request.getParameter("rec_act") && !"".equals(request.getParameter("rec_act").trim()))
                ? request.getParameter("rec_act").trim()
                : "rec_step2";
        Resource base = getResourceBase();
        try {
            Document dom = SWBUtils.XML.getNewDocument();
            if ("rec_step3".equals(action)) {
                dom = getDomEmail(request, response, paramRequest); // Envia correo
            } else { // Nueva ventana con formulario
                User user = paramRequest.getUser();
                SWBResourceURLImp url = new SWBResourceURLImp(request, base,
                        paramRequest.getWebPage(), SWBResourceURL.UrlType_RENDER);
                url.setResourceBase(base);
                url.setMode(SWBResourceURLImp.Mode_VIEW);
                url.setWindowState(SWBResourceURLImp.WinState_MAXIMIZED);
                url.setParameter("rec_act", "rec_step3");
                url.setTopic(paramRequest.getWebPage());
                url.setCallMethod(paramRequest.Call_DIRECT);

                Element el = dom.createElement("form");
                el.setAttribute("path",
                        SWBPlatform.getContextPath() + "/swbadmin/css/");
                el.setAttribute("accion", url.toString());
                el.setAttribute("from", paramRequest.getLocaleString("msgFrom"));
                el.setAttribute("to", paramRequest.getLocaleString("msgTo"));

                el.setAttribute("styleClass",
                        base.getAttribute("styleClass", "").equals("")
                        ? "<div>"
                        : "<div class=\"" + base.getAttribute("styleClass", "") + "\">");
                el.setAttribute("styleClassClose", "</div>");

                dom.appendChild(el);

                el = dom.createElement("msgRecommend");
                el.appendChild(dom.createTextNode(paramRequest.getLocaleString(
                        "msgRecommend")));
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("labelSender");
                el.appendChild(dom.createTextNode(paramRequest.getLocaleString(
                        "msgSender")));
                dom.getChildNodes().item(0).appendChild(el);
                el = dom.createElement("ftextsender");
                el.setAttribute("tag", paramRequest.getLocaleString("msgSender"));
                el.setAttribute("inname", "txtFromName");
                if (user.isSigned()) {
                    String strFromName = (null != user.getFirstName() && !"".equals(user.getFirstName().trim()))
                            ? user.getFirstName().trim()
                            : "";
                    strFromName += (null != user.getLastName() && !"".equals(user.getLastName().trim()))
                            ? " " + user.getLastName().trim()
                            : "";
                    strFromName += (null != user.getSecondLastName() && !"".equals(user.getSecondLastName().trim()))
                            ? " " + user.getSecondLastName().trim()
                            : "";
                    el.setAttribute("invalue", strFromName);
                }
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("ftextsender");
                el.setAttribute("tag",
                        paramRequest.getLocaleString("msgSenderEmail"));
                el.setAttribute("inname", "txtFromEmail");
                if (user.isSigned()) {
                    String strFromEmail = (null != user.getEmail() && !"".equals(user.getEmail().trim()))
                            ? user.getEmail().trim()
                            : "";
                    el.setAttribute("invalue", strFromEmail);
                }
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("labelReceiver");
                el.appendChild(dom.createTextNode(paramRequest.getLocaleString(
                        "msgReceiver")));
                dom.getChildNodes().item(0).appendChild(el);
                el = dom.createElement("ftextreceiver");
                el.setAttribute("tag",
                        paramRequest.getLocaleString("msgReceiver"));
                el.setAttribute("inname", "txtToName");
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("ftextreceiver");
                el.setAttribute("tag",
                        paramRequest.getLocaleString("msgReceiverEmail"));
                el.setAttribute("inname", "txtToEmail");
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("ftextarea");
                el.setAttribute("tag", paramRequest.getLocaleString("msgMessage"));
                el.setAttribute("inname", "tarMsg");
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("fsubmit");
                if (!"".equals(base.getAttribute("imgenviar", "").trim())) {
                    el.setAttribute("img", "1");
                    el.setAttribute("src", webWorkPath + "/" + base.getAttribute("imgenviar").trim());
                    if (!"".equals(base.getAttribute("altenviar", "").trim())) {
                        el.setAttribute("alt",
                                base.getAttribute("altenviar").trim());
                    } else {
                        el.setAttribute("alt",
                                paramRequest.getLocaleString("msgRecommend"));
                    }
                } else {
                    el.setAttribute("img", "0");
                    if (!"".equals(base.getAttribute("btnenviar", "").trim())) {
                        el.setAttribute("tag",
                                base.getAttribute("btnenviar").trim());
                    } else {
                        el.setAttribute("tag",
                                paramRequest.getLocaleString("btnSubmit"));
                    }
                }
                dom.getChildNodes().item(0).appendChild(el);

                el = dom.createElement("freset");
                if (!"".equals(base.getAttribute("imglimpiar", "").trim())) {
                    el.setAttribute("img", "1");
                    el.setAttribute("src", webWorkPath + "/" + base.getAttribute("imglimpiar").trim());
                    if (!"".equals(base.getAttribute("altlimpiar", "").trim())) {
                        el.setAttribute("alt",
                                base.getAttribute("altlimpiar").trim());
                    } else {
                        el.setAttribute("alt",
                                paramRequest.getLocaleString("btnReset"));
                    }
                } else {
                    el.setAttribute("img", "0");
                    if (!"".equals(base.getAttribute("btnlimpiar", "").trim())) {
                        el.setAttribute("tag",
                                base.getAttribute("btnlimpiar").trim());
                    } else {
                        el.setAttribute("tag",
                                paramRequest.getLocaleString("btnReset"));
                    }
                }
                dom.getChildNodes().item(0).appendChild(el);
            }
            return dom;
        } catch (SWBResourceException swbe) {
            throw swbe;
        } catch (Exception e) {
            log.error("Error while generating DOM in resource " + base.getResourceType().getResourceClassName() + " with identifier " + base.getId() + " - " + base.getTitle(), e);
        }
        return null;
    }


    /**
     * Genera un {@code document} con la informaci&oacute;n que se mostrar&aacute;
     * en el correo a enviar. <p>Generates a {@code document} with the data the
     * sending e-mail is going to show.</p>
     * 
     * @param request la petici&oacute;n HTTP generada por el usuario. <p>the user's HTTP request</p>
     * @param response la respuesta hacia el usuario.<p>the response to the user</p>
     * @param paramRequest el objeto generado por SWB y asociado a la petici&oacute;n
     * del usuario.<p>the object generated by SWB and asociated to the user's request</p>
     * @return el {@code document} generado con la informaci&oacute;n a mostrar
     * en el correo the {@code document} generated with the data the
     * sending e-mail is going to show.
     * @throws SWBResourceException si no existe el archivo de mensajes del idioma utilizado.
     * <p>if there is no file message of the corresponding language.</p>
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Document getDomEmail(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        Resource base = getResourceBase();
        try {
            String strFromEmail = (null != request.getParameter("txtFromEmail") && !"".equals(request.getParameter("txtFromEmail").trim()))
                    ? request.getParameter("txtFromEmail").trim()
                    : null;
            String strToEmail = (null != request.getParameter("txtToEmail") && !"".equals(request.getParameter("txtToEmail").trim()))
                    ? request.getParameter("txtToEmail").trim()
                    : null;

            if (strFromEmail != null && strToEmail != null) {
                Document dom = SWBUtils.XML.getNewDocument();
                String strFromName = (null != request.getParameter("txtFromName") && !"".equals(request.getParameter("txtFromName").trim()))
                        ? request.getParameter("txtFromName").trim()
                        : null;
                String strToName = (null != request.getParameter("txtToName") && !"".equals(request.getParameter("txtToName").trim()))
                        ? request.getParameter("txtToName").trim()
                        : null;
                String strTarMsg = (null != request.getParameter("tarMsg") && !"".equals(request.getParameter("tarMsg").trim()))
                        ? request.getParameter("tarMsg").trim()
                        : null;
                String strSubject = (!"".equals(base.getAttribute("subject",
                        "").trim())
                        ? base.getAttribute("subject").trim()
                        : paramRequest.getLocaleString("msgSubject"));
                String strUrl = "http://" + request.getServerName() + (request.getServerPort() != 80
                        ? ":" + request.getServerPort()
                        : "");
                WebPage topic = paramRequest.getWebPage();
                String lang = paramRequest.getUser().getLanguage();

                Element emn = dom.createElement("form");
                emn.setAttribute("path", "http://" + request.getServerName() + (request.getServerPort() != 80
                        ? ":" + request.getServerPort()
                        : "") + SWBPlatform.getContextPath() + "/swbadmin/css/");
                emn.setAttribute("email", "1");

                emn.setAttribute("styleClass",
                        base.getAttribute("styleClass", "").equals("")
                        ? "<div>"
                        : "<div class=\"" + base.getAttribute("styleClass", "") + "\">");
                emn.setAttribute("styleClassClose", "</div>");

                dom.appendChild(emn);

                addElem(dom, emn, "msgRecommend",
                        paramRequest.getLocaleString("msgRecommend"));
                addElem(dom, emn, "msgToMessage",
                        paramRequest.getLocaleString("msgToMessage") + ' ');
                addElem(dom, emn, "msgFromMessage",
                        paramRequest.getLocaleString("msgFromMessage") + ' ');
                addElem(dom, emn, "msgBodyMessage",
                        ' ' + paramRequest.getLocaleString("msgBodyMessage") + ' ');
                addElem(dom, emn, "msgFooterMessage",
                        paramRequest.getLocaleString("msgFooterMessage"));

                addElem(dom, emn, "site", topic.getWebSiteId());
                addElem(dom, emn, "siteurl", strUrl);
                addElem(dom, emn, "topic",
                        topic.getTitle(lang) != null
                        ? topic.getTitle(lang) : "Sin título");
                addElem(dom, emn, "topicurl", strUrl + topic.getUrl());

                if (strFromName != null) {
                    addElem(dom, emn, "fromname", strFromName);
                }
                addElem(dom, emn, "fromemail", strFromEmail);
                if (strToName != null) {
                    addElem(dom, emn, "toname", strToName);
                }
                addElem(dom, emn, "toemail", strToEmail);
                addElem(dom, emn, "subject", strSubject);
                if (strTarMsg != null) {
                    addElem(dom, emn, "message", strTarMsg);
                }

                String strHeadermsg = "<br> \n";
                strHeadermsg += "----------------------------------------------------------------------<br> \n";
                strHeadermsg += paramRequest.getLocaleString("msgHeaderMessage") + "<br> \n";
                strHeadermsg += "----------------------------------------------------------------------<br> \n";
                if (!"".equals(base.getAttribute("headermsg", "").trim())) {
                    addElem(dom, emn, "headermsg", base.getAttribute("headermsg").trim());
                    strHeadermsg += "<br>" + base.getAttribute("headermsg").trim() + "<br><br> \n";
                }
                strHeadermsg += "<br> \n";
                strHeadermsg += " " + paramRequest.getLocaleString("msgToMessage") + " ";
                strHeadermsg += null != strToName ? "<I>" + strToName + "</I>" : "";
                strHeadermsg += ",<br><br> \n";
                strHeadermsg += " " + paramRequest.getLocaleString("msgFromMessage") + " ";
                strHeadermsg += null != strFromName ? "<I>" + strFromName + "</I>" : "";
                strHeadermsg += " " + paramRequest.getLocaleString("msgBodyMessage") + "<br> \n";
                strHeadermsg += " <a href=\"" + strUrl + topic.getUrl() + "\">";
                strHeadermsg += topic.getTitle(lang) != null
                        ? topic.getTitle(lang) : "Sin título";
                strHeadermsg += "</a> \n";
                if (strTarMsg != null) {
                    strHeadermsg += "<br><br> \n";
                }
                String strFootermsg = "";
                if (!"".equals(base.getAttribute("footermsg", "").trim())) {
                    addElem(dom, emn, "footermsg",
                            base.getAttribute("footermsg").trim());
                    strFootermsg += "<br><br><br>" + base.getAttribute("footermsg").trim() + " \n";
                }
                strFootermsg += "<br><br> \n";
                strFootermsg += "----------------------------------------------------------------------<br> \n";
                strFootermsg += " " + paramRequest.getLocaleString("msgFooterMessage") + "<br> \n";
                strFootermsg += " <a href=\"" + strUrl + "\">" + topic.getWebSiteId() + "</a> \n";
                strFootermsg += "<br><br> \n";
                addElem(dom, emn, "emailbody",
                        strHeadermsg + strTarMsg + strFootermsg);
                return dom;
            } else {
                throw new SWBResourceException(
                        "Error Missing Data. The following data fields are required: "
                        + "\n\t email account of the sender: " + strFromEmail
                        + "\n\t email account of the receiver: " + strToEmail);
            }
        } catch (SWBResourceException swbe) {
            throw swbe;
        } catch (Exception e) {
            log.error("Error while generating email message in resource "
                    + base.getResourceType().getResourceClassName()
                    + " with identifier " + base.getId() + " - "
                    + base.getTitle(), e);
        }
        return null;
    }

    /**
     * Muestra la liga o la pantalla de captura de recomendaciones en base al valor
     * del par&aacute;metro <code>rec_act</code> en el <code>request</code> del usuario.
     * <p>Shows the recommendations' capture link or screen depending on the
     * <code>rec_act</code> parameter's value through the user's request.</p>
     * @param request la petici&oacute;n HTTP generada por el usuario. <p>the user's HTTP request</p>
     * @param response la respuesta hacia el usuario.<p>the response to the user</p>
     * @param paramRequest el objeto generado por SWB y asociado a la petici&oacute;n
     *        del usuario.<p>the object gnerated by SWB and asociated to the user's request</p>
     * @throws IOException al obtener el <code>Writer</code> del <code>response</code> correspondiente.
     *         when getting the corresponding <code>response</code>'s <code>Writer</code>.
     * @throws SWBResourceException si no existe el archivo de mensajes del idioma utilizado.
     *         <p>if there is no file message of the corresponding language.</p>
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        StringBuffer ret = new StringBuffer(200);
        Resource base = getResourceBase();
        String action = (null != request.getParameter("rec_act") && !"".equals(request.getParameter("rec_act").trim()))
                ? request.getParameter("rec_act").trim()
                : "rec_step1";
        if ("rec_step1".equals(action)) {
            //Determina si la ventana de captura de datos será modal o no
            boolean modal = Integer.parseInt(base.getAttribute("modal")) == 1 ? true : false;
            // Objeto (imagen/botón) para invocar la nueva ventana con formulario
            String onclick = "";
            String modalCode = null;
            SWBResourceURLImp url = new SWBResourceURLImp(request, base,
                    paramRequest.getWebPage(), SWBResourceURLImp.UrlType_RENDER);
            if (!modal) {
                if ("1".equals(base.getAttribute("menubar", "0").trim())) {
                    onclick = "menubar=yes";
                } else {
                    onclick = "menubar=no";
                }
                if ("1".equals(base.getAttribute("toolbar", "0").trim())) {
                    onclick += ",toolbar=yes";
                } else {
                    onclick += ",toolbar=no";
                }
                if ("1".equals(base.getAttribute("status", "0").trim())) {
                    onclick += ",status=yes";
                } else {
                    onclick += ",status=no";
                }
                if ("1".equals(base.getAttribute("location", "0").trim())) {
                    onclick += ",location=yes";
                } else {
                    onclick += ",location=no";
                }
                if ("1".equals(base.getAttribute("directories", "0").trim())) {
                    onclick += ",directories=yes";
                } else {
                    onclick += ",directories=no";
                }
                if ("1".equals(base.getAttribute("scrollbars", "0").trim())) {
                    onclick += ",scrollbars=yes";
                } else {
                    onclick += ",scrollbars=no";
                }
                if ("1".equals(base.getAttribute("resizable", "0").trim())) {
                    onclick += ",resizable=yes";
                } else {
                    onclick += ",resizable=no";
                }
                onclick += ",width=" + base.getAttribute("width", "450").trim();
                onclick += ",height=" + base.getAttribute("height", "400").trim();
                onclick += ",top=" + base.getAttribute("top", "10").trim();
                onclick += ",left=" + base.getAttribute("left", "10").trim();

                url.setResourceBase(base);
                url.setMode(SWBResourceURLImp.Mode_VIEW);
                url.setWindowState(SWBResourceURLImp.WinState_MAXIMIZED);
                url.setParameter("rec_act", "rec_step2");
                url.setTopic(paramRequest.getWebPage());
                url.setCallMethod(paramRequest.Call_DIRECT);
                onclick = "javascript:window.open('" + url.toString()
                        + "','_newrec','" + onclick + "'); return false;";
            } else {  //Si el recurso presenta una ventana MODAL
                Document dom = getDom(request, response, paramRequest);
                modalCode = getModalWindowCode(base, request, paramRequest);
                onclick = "javascript:displayRecomWindow('recommend" + base.getId()
                        + "','" + base.getAttribute("backgroundcolor", "#000000").trim()
                        + "', " + base.getAttribute("opacity", "80").trim() + ");void(0);";
            }
            synchronized (ret) {
                if (modal) {
                    ret.append(modalCode);
                }
                if (!"".equals(base.getAttribute("img", "").trim())) {
                    ret.append("\n<a href=\"" + onclick + "\"><img onClick=\""
                            + onclick + "\" src=\"");
                    ret.append(webWorkPath + "/" + base.getAttribute("img").trim() + "\"");
                    if (!"".equals(base.getAttribute("alt", "").trim())) {
                        ret.append(" alt=\""
                                + base.getAttribute("alt").trim().replaceAll("\"",
                                "&#34;") + "\"");
                    }
                    ret.append(" border=\"0\" /></a>");
                } else if (!"".equals(base.getAttribute("btntexto", "").trim())) {
                    ret.append("\n<form name=frmRecomendar>");
                    ret.append("\n<input type=button name=btnRecomendar onClick=\""
                            + onclick + "\" value=");
                    ret.append("\"" + base.getAttribute("btntexto").trim().replaceAll("\"", "&#34;") + "\"");
                    if (!"".equals(base.getAttribute("blnstyle", "").trim())) {
                        ret.append(" style=\"" 
                                + base.getAttribute("blnstyle").trim().replaceAll("\"", "&#34;")
                                + "\"");
                    }
                    ret.append("\n/></form>");
                } else {
                    ret.append("\n<a href=\"" + onclick + "\" onClick=\"" + onclick + "\"");
                    if (!"".equals(base.getAttribute("blnstyle", "").trim())) {
                        ret.append(" style=\"" + base.getAttribute("blnstyle").trim().replaceAll(
                                "\"", "&#34;") + "\"");
                    }
                    ret.append(">");
                    if (!"".equals(base.getAttribute("lnktexto", "").trim())) {
                        ret.append(base.getAttribute("lnktexto").trim());
                    } else {
                        ret.append(paramRequest.getLocaleString("msgRecommend"));
                    }
                    ret.append("</a>");
                }
            }
        } else {
            try {
                Document dom = getDom(request, response, paramRequest);
                String generateLog = base.getAttribute("generatelog", "");
                if (dom != null) {
                    ret.append(SWBUtils.XML.transformDom(tpl, dom));
                    if ("rec_step3".equals(action)) {
                        String from = dom.getElementsByTagName("fromemail").item(0).getFirstChild().getNodeValue();
                        String to = dom.getElementsByTagName("toemail").item(0).getFirstChild().getNodeValue();
                        String subject = dom.getElementsByTagName("subject").item(0).getFirstChild().getNodeValue();
                        boolean mailSent = false;
                        String strUrl = "=\"http://" + request.getServerName()
                                + (request.getServerPort() != 80
                                ? ":" + request.getServerPort()
                                : "") + path;
                        ret = new StringBuffer(SWBUtils.TEXT.replaceAll(
                                ret.toString(), "=\"" + path, strUrl));

                        InternetAddress address1 = new InternetAddress();
                        address1.setAddress(to);
                        ArrayList<InternetAddress> aAddress =
                                new ArrayList<InternetAddress>();
                        aAddress.add(address1);

                        if ((from != null && to != null
                                && subject != null) && SWBUtils.EMAIL.sendMail(from, from, aAddress,
                                null, null, subject, "html", ret.toString(),
                                null, null, null) != null) {
                            ret.append("\n<script type=\"text/javascript\">\n<!--");
                            ret.append("\nalert('" + paramRequest.getLocaleString("msgSendEmail") + "');");
                            ret.append("\nwindow.close();");
                            ret.append("\n-->\n</script>");
                            mailSent = true;
                        } else {
                            ret.append("\n<script type=\"text/javascript\">\n<!--");
                            ret.append("\nalert('" + paramRequest.getLocaleString("msgEmailRequired") + "');");
                            ret.append("\nhistory.go(-1);");
                            ret.append("\n-->\n</script>");
                        }
                        if (mailSent && generateLog.length() > 0) {
                            try {
                                feedRecommendLog(dom, paramRequest.getUser());
                            } catch (Exception e) {
                                log.error(e);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        PrintWriter out = response.getWriter();
        out.println(ret.toString());
    }

    /**
     * Agrega un elemento a un DOM, como hijo del elemento indicado, con el nombre
     * y valor especificados.
     * <p>Adds an element to a DOM, as child of the specified element with the
     * name and the value received.
     * @param doc el documento a modificar <p>the <code>document</code> to modify.</p>
     * @param parent el elemento padre del elemento a agregar, contenido en el
     *        documento <p>the new <code>element</code>'s parent <code>element</code>.</p>
     * @param elemName la cadena con el nombre del nuevo elemento <p>the string with the new <code>element</code>'s name.
     * @param elemValue el valor del nuevo elemento <p>new <code>element</code>'s value.</p>
     */
    private void addElem(Document doc, Element parent, String elemName,
            String elemValue) {

        Element elem = doc.createElement(elemName);
        elem.appendChild(doc.createTextNode(elemValue));
        parent.appendChild(elem);
    }

    /**
     * Agrega la informaci&oacute;n enviada por correo al archivo log de este
     * recurso. <p>Adds the data sent by e-mailto this resource's log file.</p>
     * 
     * @param dom <code>document</code> que contiene los datos enviados por correo.
     * <p>the {@code document} which contains the data sent by e-mail.</p>
     * @param user el <code>user</code> que ejecuta la acci&oacute;n de env&iacute;o
     * de recomendaci&oacute;n <p>the {@code user} which executes the
     * action of sending the recommendation</p>
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void feedRecommendLog(Document dom, User user) throws IOException {

        Resource base = getResourceBase();
        String logPath = SWBPortal.getWorkPath() + base.getWorkPath() + "/Recommend.log";
        StringBuilder toLog = new StringBuilder(500);
        Date now = new Date();
        NodeList nl = null;

        toLog.append(SWBUtils.TEXT.iso8601DateFormat(now));
        if (user != null && user.isSigned()) {
            toLog.append("\n    User:");
            toLog.append((null != user.getFirstName() && !"".equals(user.getFirstName().trim()))
                    ? user.getFirstName().trim()
                    : "");
            toLog.append((null != user.getLastName() && !"".equals(user.getLastName().trim()))
                    ? user.getLastName().trim()
                    : "");
            toLog.append((null != user.getSecondLastName() && !"".equals(user.getSecondLastName().trim()))
                    ? user.getSecondLastName().trim()
                    : "");
        }
        nl = dom.getElementsByTagName("site");
        toLog.append("\n    Site:" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : ""));
        nl = dom.getElementsByTagName("topic");
        toLog.append("\n    Topic:" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : ""));
        nl = dom.getElementsByTagName("topicurl");
        toLog.append("<" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : "") + ">");
        nl = dom.getElementsByTagName("fromname");
        toLog.append("\n    From:" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : ""));
        nl = dom.getElementsByTagName("fromemail");
        if (nl != null && nl.getLength() > 0) {
            toLog.append("<" + nl.item(0).getFirstChild().getNodeValue() + ">");
        }
        nl = dom.getElementsByTagName("toname");
        toLog.append("\n    To:" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : ""));
        nl = dom.getElementsByTagName("toemail");
        toLog.append("<" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : "") + ">");
        nl = dom.getElementsByTagName("subject");
        toLog.append("\n    Subject:" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : ""));
        nl = dom.getElementsByTagName("message");
        toLog.append("\n    Message:" + (nl != null && nl.getLength() > 0
                ? nl.item(0).getFirstChild().getNodeValue() : ""));
        toLog.append("\n");

        File file = new File(SWBPortal.getWorkPath() + base.getWorkPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        SWBUtils.IO.log2File(logPath, toLog.toString());
    }


    public void doSendEmail(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws java.io.IOException {
        
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String from = request.getParameter("txtFromEmail");
        String fromName = request.getParameter("txtFromName");
        String to = request.getParameter("txtToEmail");
        String toName = request.getParameter("txtToName");
        String message = request.getParameter("tarMsg");
        InternetAddress address1 = new InternetAddress();
        StringBuilder mailBody = new StringBuilder(300);
        String responseMsg = null;
        String uri = request.getParameter("spuri");
        ServiceProvider sprovider = null;
        Resource base = getResourceBase();
        String mailSubject = base.getAttribute("subject", "Envío de recomendación");
        boolean mailSent = false;

        SemanticObject semObject = SemanticObject.createSemanticObject(uri);
        sprovider = (ServiceProvider) semObject.createGenericInstance();

        try {
        address1.setAddress(to);
        ArrayList<InternetAddress> aAddress = new ArrayList<InternetAddress>();
        aAddress.add(address1);

        mailBody.append("<html>");
        mailBody.append("<head>");

        //Se agrega el archivo de estilos de acuerdo al usado por la página de la empresa
        if (sprovider.getVariantPaqTemplate() != null &&
                !sprovider.getVariantPaqTemplate().getVarianStyle().equalsIgnoreCase("")) {

            String linkTag = sprovider.getVariantPaqTemplate().getVarianStyle();
            if (linkTag.indexOf("http:") == -1) {
                if (linkTag.indexOf("href=\"") != -1) {
                    mailBody.append(linkTag.replaceAll("href=\"", "href=\"http://"
                            + request.getServerName() + (request.getServerPort() != 80
                                                        ? ":" + request.getServerPort()
                                                        : "") + SWBPlatform.getContextPath()));
                } else {
                    mailBody.append(linkTag.replaceAll("href='", "href='http://"
                            + request.getServerName() + (request.getServerPort() != 80
                                                        ? ":" + request.getServerPort()
                                                        : "") + SWBPlatform.getContextPath()));
                }
            } else {
                mailBody.append(linkTag);
            }
        } else {
            String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/"
                    + paramRequest.getWebPage().getWebSiteId();
            mailBody.append("<link href=\"http://" + request.getServerName() + (request.getServerPort() != 80
                        ? ":" + request.getServerPort()
                        : "") + siteWorkDir + "/css/premier/calidos/images/premium.css\" rel=\"stylesheet\" type=\"text/css\" />");
        }
        String headermsg = base.getAttribute("headermsg", "");
        if (headermsg.equalsIgnoreCase("")) {
            headermsg = paramRequest.getLocaleString("msgHeaderMessage");
        }

        mailBody.append("</head>");
        mailBody.append("<body>");
        mailBody.append("<div id=\"recommend\">");
        mailBody.append("    <h3>" + paramRequest.getLocaleString("msgHeaderMessage")+"</h3>");
        mailBody.append("    <p>");
        mailBody.append(paramRequest.getLocaleString("msgToMessage"));
        mailBody.append("&nbsp;"+(toName != null ? toName : to) + ". ");
        mailBody.append("      " + paramRequest.getLocaleString("msgFromMessage"));
        mailBody.append("      <span id=\"txtMsgFrom\">" + (fromName != null ? fromName : from) + "</span>");
        mailBody.append("    </p>");
        mailBody.append("    <div id=\"destinatario\">");
        mailBody.append("      <p>");
        mailBody.append("      " + paramRequest.getLocaleString("msgBodyMessage"));
        String strUrl = "http://" + request.getServerName() + (request.getServerPort() != 80
                        ? ":" + request.getServerPort()
                        : "");
        mailBody.append("        <a href=\"" + strUrl + sprovider.getMicroSitePymeInv().getRealUrl() + "\">");
        mailBody.append("        " + paramRequest.getLocaleString("msgLinkTextInMail") + "</a>,");
        mailBody.append("        de la empresa " + sprovider.getTitle());
        mailBody.append("      </p>");
        if (message != null) {
            mailBody.append("      <p id=\"additionalMsg\">");
            mailBody.append("        " + message);
            mailBody.append("      </p>");
        }
        if (!base.getAttribute("footermsg", "").equalsIgnoreCase("")) {
            mailBody.append("      <p id=\"footerMsg\">");
            mailBody.append("        " + base.getAttribute("footermsg", ""));
            mailBody.append("      </p>");
        }
        mailBody.append("    </div>");
        mailBody.append("</body>");
        mailBody.append("</html>");

        if ((sprovider != null && from != null && to != null
                && mailSubject != null) && SWBUtils.EMAIL.sendMail(from, fromName, aAddress,
                null, null, mailSubject, "html", mailBody.toString(),
                null, null, null) != null) {
            mailSent = true;
        }
        if (mailSent) {
            responseMsg = paramRequest.getLocaleString("msgSendEmail");
        } else {
            responseMsg = paramRequest.getLocaleString("msgNoSendEmail");
        }
        } catch (NullPointerException npe) {
            if (sprovider == null) {
                try {
                    responseMsg = paramRequest.getLocaleString("msgNoSendEmail");
                    log.error("Recommend: ServiceProvider is null!!! for WebPage:" + paramRequest.getWebPage(), npe);
                } catch (SWBResourceException swbre) {
                    responseMsg = "";
                    log.error("Recommend: Al extraer una propiedad, luego de un error.", swbre);
                }
            } else {
                try {
                    responseMsg = paramRequest.getLocaleString("msgNoSendEmail");
                    log.error("Recommend: An object is null!!!", npe);
                } catch (SWBResourceException swbre) {
                    responseMsg = "";
                    log.error("Recommend: Al extraer una propiedad, luego de un error.", swbre);
                }
            }
        } catch (Exception e) {
            try {
                responseMsg = paramRequest.getLocaleString("msgNoSendEmail");
                log.error("Recommend: Al recomendar una página", e);
            } catch (SWBResourceException swbre) {
                responseMsg = "";
                log.error("Recommend: Al extraer una propiedad, luego de un error.", swbre);
            }
        }

        PrintWriter out = response.getWriter();
        out.print(responseMsg);
        out.flush();
        out.close();
    }

    private String getModalWindowCode(Resource base, HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException {
        ServiceProvider sprovider = null;
        

        try {
            WebPage wp = paramRequest.getWebPage();
            WebPage community = null;
            if(request.getParameter("uri") == null) { //Se ve el recurso desde un micrositio
                if( wp instanceof MicroSitePyme ) {
                    community = wp;
                }else {
                    community = wp.getParent();
                }
                MicroSitePyme ms = (MicroSitePyme) community;
                sprovider = ms.getServiceProvider();
            }else {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri")); //Se ve el recurso desde una ficha
                sprovider = (ServiceProvider) semObject.createGenericInstance();
            }
        }catch(ClassCastException cce) {
        }
        
        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(url.Call_DIRECT).setMode("sendEmail");
        StringBuilder buffer = new StringBuilder(400);
        StringBuilder formBuffer = new StringBuilder(200);
        buffer.append("<script type=\"text/javascript\">\n<!--\n");
        buffer.append("    var recomDivId = 'recommend" + base.getId() + "';\n");
        buffer.append("    function sendRecomForm(forma) {\n");
        buffer.append("        var ready = true;\n");
        buffer.append("        var emailPatt = new RegExp(\"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$\");\n");
        buffer.append("        if ((forma.txtFromEmail.value == \"\" || !emailPatt.test(forma.txtFromEmail.value))");
        buffer.append("            || (forma.txtToEmail.value == \"\" || !emailPatt.test(forma.txtToEmail.value))) {\n");
        buffer.append("            ready = false;\n");
        buffer.append("            alert(\"" + paramRequest.getLocaleString("msgEmailRequired") + "\");\n");
        buffer.append("        }\n");
        buffer.append("        var xhrArgs = {\n");
        buffer.append("            form: forma,\n");
        buffer.append("            handleAs: \"text\",\n");
        buffer.append("            load: function(data) {\n");
        buffer.append("                alert(data);\n");
        buffer.append("                removeRecomCoverDiv(recomDivId);\n");
//        buffer.append("            },\n");
//        buffer.append("            error: function(error) {\n");
//        buffer.append("                alert(\"Lo sentimos ha ocurrido un error al enviar la recomendación, por favor intenta de nuevo.\");\n");
        buffer.append("            }\n");
        buffer.append("        };\n");
        buffer.append("        if (ready) {\n");
        buffer.append("            var deferred = dojo.xhrPost(xhrArgs);\n");
        buffer.append("            return true;\n");
        buffer.append("        } else {\n");
        buffer.append("            return false;\n");
        buffer.append("        }\n");
        buffer.append("    }\n");

        buffer.append("  function createRecomCoverDiv(divId, bgcolor, opacity) {\n");
        buffer.append("    var layer=document.createElement('div');\n");
        buffer.append("    layer.id=divId;\n");
        buffer.append("    layer.style.width='100%';\n");
        buffer.append("    layer.style.height='100%';\n");
        buffer.append("    layer.style.backgroundColor=bgcolor;\n");
        buffer.append("    layer.style.position='fixed';\n");
        buffer.append("    layer.style.top=0;\n");
        buffer.append("    layer.style.left=0;\n");
        buffer.append("    layer.style.zIndex=1000;\n");
        buffer.append("    layer.style.filter='alpha(opacity='+opacity+')';\n");
        buffer.append("    layer.style.opacity=opacity/100;\n");
        buffer.append("    document.body.appendChild(layer);\n");
        buffer.append("    return layer;\n");
        buffer.append("  }\n");
        buffer.append("  function removeRecomCoverDiv(divId) {\n");
        buffer.append("    var layer=document.getElementById(divId);\n");
        buffer.append("    var superlayer=document.getElementById('s_'+divId);\n");
        buffer.append("    if(layer && superlayer) {\n");
        buffer.append("        document.body.removeChild(superlayer);\n");
        buffer.append("        document.body.removeChild(layer);\n");
        buffer.append("    }\n");
        buffer.append("  }\n");
        buffer.append("  function displayRecomWindow(divId, bgcolor, opacity) {\n");
        buffer.append("    if (document.getElementById(divId) != undefined) {\n");
        buffer.append("        return;\n");
        buffer.append("    }\n");
        buffer.append("    var newDiv = createRecomCoverDiv(divId, bgcolor, opacity);\n");
        buffer.append("    var recomContainer=document.createElement('div');\n");
        buffer.append("    var s = new String('');\n");
        buffer.append("    s = s.concat('");

        User user = paramRequest.getUser();
        String strFromName = null;
        String strFromEmail = null;
        if (user.isSigned()) {
            strFromName = (null != user.getFirstName() && !"".equals(user.getFirstName().trim()))
                    ? user.getFirstName().trim()
                    : "";
            strFromName += (null != user.getLastName() && !"".equals(user.getLastName().trim()))
                    ? " " + user.getLastName().trim()
                    : "";
            strFromName += (null != user.getSecondLastName() && !"".equals(user.getSecondLastName().trim()))
                    ? " " + user.getSecondLastName().trim()
                    : "";
            strFromEmail = user.getEmail();
        } else {
            strFromName = "";
            strFromEmail = "";
        }

        formBuffer.append("<div id=\"recommend\">");
        formBuffer.append("  <form class=\"form\" method=\"post\" action=\"" + url + "\" id=\"frmContact\">");
        formBuffer.append("    <input type=\"hidden\" value=\"" + sprovider.getURI() + "\" name=\"spuri\">");
        formBuffer.append("    <h3>" + paramRequest.getLocaleString("msgRecommend") + "</h3>");
        formBuffer.append("    <p>");
        formBuffer.append("      <label for=\"txtFromName\">" + paramRequest.getLocaleString("msgSender") + "</label>");
        formBuffer.append("      <input value=\"" + strFromName + "\" size=\"50\" id=\"txtFromName\" name=\"txtFromName\">");
        formBuffer.append("    </p>");
        formBuffer.append("    <p>");
        formBuffer.append("      <label for=\"txtFromEmail\">" + paramRequest.getLocaleString("msgSenderEmail") + "</label>");
        formBuffer.append("      <input value=\"" + strFromEmail + "\" size=\"50\" id=\"txtFromEmail\" name=\"txtFromEmail\">");
        formBuffer.append("    </p>");
        formBuffer.append("    <p>");
        formBuffer.append("      <label for=\"txtToName\">" + paramRequest.getLocaleString("msgReceiver") + "</label>");
        formBuffer.append("      <input value=\"\" size=\"50\" id=\"txtToName\" name=\"txtToName\">");
        formBuffer.append("    </p>");
        formBuffer.append("    <p>");
        formBuffer.append("      <label for=\"txtToEmail\">" + paramRequest.getLocaleString("msgReceiverEmail") + "</label>");
        formBuffer.append("      <input value=\"\" size=\"50\" id=\"txtToEmail\" name=\"txtToEmail\">");
        formBuffer.append("    </p>");
        formBuffer.append("    <p>");
        formBuffer.append("      <label for=\"tarMsg\">" + paramRequest.getLocaleString("msgMessage") + "</label>");
        formBuffer.append("      <textarea rows=\"5\" cols=\"40\" id=\"tarMsg\" name=\"tarMsg\"></textarea>");
        formBuffer.append("    </p>");
        formBuffer.append("    <p id=\"cmdrecommend\">");
        formBuffer.append("      <label for=\"recommendEnviar\">" + paramRequest.getLocaleString("btnSubmit") + "</label>");
        formBuffer.append("      <input type=\"button\" value=\"" + paramRequest.getLocaleString("btnSubmit") + "\" onclick=\"sendRecomForm(this.form);\" id=\"recommendEnviar\" name=\"submit\">");
        formBuffer.append("      <label for=\"recommendRestablecer\">" + paramRequest.getLocaleString("btnReset") + "</label>");
        formBuffer.append("      <input type=\"button\" value=\"" + paramRequest.getLocaleString("btnReset") + "\" id=\"recommendRestablecer\" name=\"reset\" onclick=\"removeRecomCoverDiv(recomDivId);\">");
        formBuffer.append("    </p>");
        formBuffer.append("  </form>");
        formBuffer.append("</div>");

        if (formBuffer.indexOf("'") != -1) {
            buffer.append(formBuffer.toString().replaceAll("'", "\\\\'"));
        } else {
            buffer.append(formBuffer.toString());
        }
        
        buffer.append("');\n");
        buffer.append("    recomContainer.innerHTML = s;\n");
        buffer.append("    var cwidth=650;\n");
        buffer.append("    var cheight=350;\n");
        buffer.append("    recomContainer.id='s_'+divId;\n");
        buffer.append("    recomContainer.style.zIndex=1001;\n");
        buffer.append("    recomContainer.style.position='absolute';\n");
        buffer.append("    recomContainer.style.top='50%';\n");
        buffer.append("    recomContainer.style.left='50%';\n");
        buffer.append("    recomContainer.style.marginLeft=-cwidth/2+'px';\n");
        buffer.append("    recomContainer.style.marginTop=-cheight/2+'px';\n");
        buffer.append("    recomContainer.style.width=cwidth+'px';\n");
        buffer.append("    recomContainer.style.height=cheight+'px';\n");
        buffer.append("    document.body.appendChild(recomContainer);\n");
//        buffer.append("    newDiv.appendChild(recomContainer);\n");
        buffer.append("  }\n");
        buffer.append("-->\n</script>\n");
        return buffer.toString();
    }
}
