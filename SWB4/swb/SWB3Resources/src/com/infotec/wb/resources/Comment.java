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
 * Comment.java
 *
 * Created on 14 de octubre de 2002, 11:02 AM
 */

package com.infotec.wb.resources;


import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.io.PrintWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.util.FileUpload;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBResourceURLImp;
import org.semanticwb.portal.admin.admresources.util.WBAdmResourceUtils;
import org.semanticwb.portal.api.SWBResourceException;


/** 
 * Se encarga de desplegar y administrar comentarios de los usuarios finales
 * bajo ciertos criterios(configuraci&oacute;n del recurso).
 *
 * In charge to unfold and to administer commentaries of the end users under 
 * certain criteria (resource configuration).
 *
 * @author : Vanessa Arredondo N��ez
 * @version 1.0
 */
public class Comment extends GenericResource {
    
    
    private static Logger log = SWBUtils.getLogger(Comment.class);
    javax.xml.transform.Templates tpl; 
    String name = getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
    String webWorkPath = "/work";
    String path = SWBPlatform.getContextPath() + "/swbadmin/xsl/" + name + "/";

    /** Creates a new instance of Ventana */    
    public Comment() {
    }
    
    /**
     * @param base
     */       
    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            webWorkPath = SWBPortal.getWebWorkPath() + base.getWorkPath();
        } catch (Exception e) {
            log.error("Error while setting resource base: " + base.getId() + "-" + base.getTitle(), e);
        }
        if (!"".equals(base.getAttribute("template", "").trim())) {
            try {
                //tpl = com.infotec.appfw.util.AFUtils.getInstance().loadTemplateXSLT(WBUtils.getInstance().getFileFromWorkPath(base.getResourceWorkPath() +"/"+ base.getAttribute("template").trim()));  
                tpl = SWBUtils.XML.loadTemplateXSLT(SWBPortal.getAdminFileStream(base.getWorkPath() + "/" + base.getAttribute("template").trim()));
                path = webWorkPath + "/";
            } catch (Exception e) {
                log.error("Error while loading resource template: " + base.getId(), e);
            }
        }
        if (tpl == null) {
            try {
                tpl = SWBUtils.XML.loadTemplateXSLT(SWBPortal.getAdminFileStream("/swbadmin/xsl/" + name + "/" + name + ".xslt"));
            } catch (Exception e) {
                log.error("Error while loading default resource template: " + base.getId(), e);
            }
        }
    }

    /**
     * @param request
     * @param response
     * @param reqParams
     * @return <b>Document</b>
     * @throws AFException
     * @throws IOException
     */
    public Document getDom(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest reqParams)
            throws SWBResourceException, IOException {
        
        String action = null != request.getParameter("com_act") && !"".equals(request.getParameter("com_act").trim()) ? request.getParameter("com_act").trim() : "com_step2";
        Resource base = getResourceBase();
        try {        
            Document dom = SWBUtils.XML.getNewDocument();
            if ("com_step3".equals(action)) {
                dom = getDomEmail(request, response, reqParams); // Envia correo
            } else {
                // Nueva ventana con formulario
                User user = reqParams.getUser();
                SWBResourceURLImp url = new SWBResourceURLImp(request, base, reqParams.getWebPage(), SWBResourceURL.UrlType_RENDER);
                url.setResourceBase(base);
                url.setMode(SWBResourceURLImp.Mode_VIEW);
                url.setWindowState(SWBResourceURLImp.WinState_MAXIMIZED);
                url.setParameter("com_act", "com_step3");
                url.setTopic(reqParams.getWebPage());
                url.setCallMethod(reqParams.Call_DIRECT);

                Element root = dom.createElement("form");
                root.setAttribute("path", path);
                root.setAttribute("accion", url.toString());
                dom.appendChild(root);   

                Element emn = null;
                if (!"".equals(base.getAttribute("comentario", "").trim())) {
                    emn = dom.createElement("fselect");
                    emn.setAttribute("tag", reqParams.getLocaleString("msgViewTypeComment"));
                    emn.setAttribute("inname", "selTipo");

                    if (base.getDom() != null) {
                        NodeList node = base.getDom().getElementsByTagName("comentario");
                        String comentario = "";
                        for (int i = 0; i < node.getLength(); i++) {
                            comentario = node.item(i).getChildNodes().item(0).getNodeValue().trim();
                            if (!"".equals(comentario)) {
                                Element child = dom.createElement("foption");
                                child.setAttribute("invalue", comentario);
                                emn.appendChild(child);
                            }
                        }
                    }
                    root.appendChild(emn);
                }

                emn = dom.createElement("ftext");
                emn.setAttribute("tag", reqParams.getLocaleString("msgName"));
                emn.setAttribute("inname", "txtFromName");
                /*if (user.isLoged()) TODO: ver. 4  */ {
                    String strFromName = "1".equals(base.getAttribute("firstname", "0").trim()) && (null != user.getFirstName() && !"".equals(user.getFirstName().trim())) ? user.getFirstName().trim() : "";
                    strFromName += "1".equals(base.getAttribute("lastname", "0").trim()) && (null != user.getLastName() && !"".equals(user.getLastName().trim())) ? " " + user.getLastName().trim() : "";
                    strFromName += "1".equals(base.getAttribute("middlename", "0").trim()) && (null != user.getSecondLastName() && !"".equals(user.getSecondLastName().trim())) ? " " + user.getSecondLastName().trim() : "";
                    emn.setAttribute("invalue", strFromName);
                }
                root.appendChild(emn);

                emn = dom.createElement("ftext");
                emn.setAttribute("tag", reqParams.getLocaleString("msgViewEmail"));
                emn.setAttribute("inname", "txtFromEmail");
                //if (user.isLoged())   TODO: ver. 4
                {
                    String strFromEmail = null != user.getEmail() && !"".equals(user.getEmail().trim()) ? user.getEmail().trim() : "";
                    emn.setAttribute("invalue", strFromEmail);                    
                }
                root.appendChild(emn);

                emn = dom.createElement("ftext");
                emn.setAttribute("tag", reqParams.getLocaleString("msgPhone"));
                emn.setAttribute("inname", "txtPhone");
                root.appendChild(emn);

                emn = dom.createElement("ftext");
                emn.setAttribute("tag", reqParams.getLocaleString("msgFax"));
                emn.setAttribute("inname", "txtFax");
                root.appendChild(emn);

                emn = dom.createElement("ftextarea");
                emn.setAttribute("tag", reqParams.getLocaleString("msgMessage"));
                emn.setAttribute("inname", "tarMsg");
                root.appendChild(emn);

                emn = dom.createElement("fsubmit");
                if (!"".equals(base.getAttribute("imgenviar", "").trim())) {
                    emn.setAttribute("img", "1");
                    emn.setAttribute("src", webWorkPath + "/" + base.getAttribute("imgenviar").trim());
                    if (!"".equals(base.getAttribute("altenviar", "").trim()))
                        emn.setAttribute("alt", base.getAttribute("altenviar").trim());
                    else emn.setAttribute("alt", reqParams.getLocaleString("msgViewSubmitAlt"));
                } 
                else 
                {
                    emn.setAttribute("img", "0");
                    if (!"".equals(base.getAttribute("btnenviar", "").trim()))
                        emn.setAttribute("tag", base.getAttribute("btnenviar").trim());
                    else emn.setAttribute("tag", reqParams.getLocaleString("msgViewSubmitButton"));
                }
                root.appendChild(emn);

                emn = dom.createElement("freset");
                if (!"".equals(base.getAttribute("imglimpiar", "").trim()))
                {
                    emn.setAttribute("img", "1");
                    emn.setAttribute("src", webWorkPath +"/"+ base.getAttribute("imglimpiar").trim());
                    if (!"".equals(base.getAttribute("altlimpiar", "").trim()))
                        emn.setAttribute("alt", base.getAttribute("altlimpiar").trim());
                    else emn.setAttribute("alt", reqParams.getLocaleString("msgViewResetAlt"));
                }
                else 
                {
                    emn.setAttribute("img", "0");
                    if (!"".equals(base.getAttribute("btnlimpiar", "").trim()))
                        emn.setAttribute("tag", base.getAttribute("btnlimpiar").trim());
                    else emn.setAttribute("tag", reqParams.getLocaleString("msgViewResetButton"));
                }
                root.appendChild(emn);
            }
            return dom;
        } catch (Exception e) {
            log.error("Error while generating the comments form in resource " + base.getResourceType().getResourceClassName() + " with identifier " + base.getId() + " - " + base.getTitle(), e);
        }
        return null;
    }

    /**
     * @param request
     * @param response
     * @param reqParams
     * @return <b>Document</b>
     * @throws AFException
     * @throws IOException
     */    
    public Document getDomEmail(HttpServletRequest request, 
            HttpServletResponse response, SWBParamRequest reqParams)
            throws SWBResourceException, IOException {
        
        Resource base = getResourceBase();
        try {
            String strFromName = null != request.getParameter("txtFromName") && !"".equals(request.getParameter("txtFromName").trim()) ? request.getParameter("txtFromName").trim() : null;
            String strFromEmail = null != request.getParameter("txtFromEmail") && !"".equals(request.getParameter("txtFromEmail").trim()) ? request.getParameter("txtFromEmail").trim() : null;
            String strTarMsg = null != request.getParameter("tarMsg") && !"".equals(request.getParameter("tarMsg").trim()) ? request.getParameter("tarMsg").trim() : null;
            
            if (strFromName != null && strFromEmail != null && strTarMsg != null) {
                Document  dom = SWBUtils.XML.getNewDocument();
                String strSubject = reqParams.getLocaleString("emlSubject");
                String commentType = null != request.getParameter("selTipo") && !"".equals(request.getParameter("selTipo").trim()) ? request.getParameter("selTipo").trim() : strSubject;
                if (!"".equals(base.getAttribute("subject", "").trim()))
                    strSubject = base.getAttribute("subject").trim();
                else if(commentType != null ) strSubject = commentType + "...";
                
                WebPage topic = reqParams.getWebPage();
                String lang = reqParams.getUser().getLanguage();
                Element emn = dom.createElement("form");
                emn.setAttribute("path", "http://" + request.getServerName() + (request.getServerPort() != 80 ? ":" + request.getServerPort() : "") + path);
                emn.setAttribute("email", "1");
                dom.appendChild(emn);
                addElem(dom, emn, "site", topic.getWebSiteId());
                addElem(dom, emn, "topic", topic.getTitle(lang));
                addElem(dom, emn, "fromname", strFromName);
                addElem(dom, emn, "fromemail", strFromEmail);
                addElem(dom, emn, "subject", strSubject);
                addElem(dom, emn, "message", strTarMsg);
                
                String value = "";
                String area = "";
                String responsable = "";
                String toemail = "";
                if (commentType != null ) {
                    addElem(dom, emn, "commenttype", commentType);
                    Document dom2 = base.getDom();
                    NodeList node = dom2.getElementsByTagName("comentario");
                    for (int i = 0; i < node.getLength(); i++) {
                        area = "";
                        responsable = "";
                        toemail = "";
                        value = node.item(i).getFirstChild().getNodeValue().trim();
                        if(value.equals(commentType)) {
                            NodeList child = node.item(i).getChildNodes();
                            for (int j = 0; j < child.getLength(); j++) {
                                if (child.item(j) != null) {
                                    if ("area".equals(child.item(j).getNodeName())) {
                                        area = child.item(j).getFirstChild().getNodeValue().trim();
                                        continue;
                                    } else if ("responsable".equals(child.item(j).getNodeName())) {
                                        responsable = child.item(j).getFirstChild().getNodeValue().trim();
                                        continue;
                                    } else if ("email".equals(child.item(j).getNodeName())) {
                                        toemail = child.item(j).getFirstChild().getNodeValue().trim();
                                        continue;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (!"".equals(area)) {
                        addElem(dom, emn, "area", area);
                    }
                    if (!"".equals(responsable)) {
                        addElem(dom, emn, "responsable", responsable);
                    }
                    if (!"".equals(toemail)) {
                        addElem(dom, emn, "toemail", toemail);
                    }
                }
                if ("".equals(toemail)) {
                    addElem(dom, emn, "area", base.getAttribute("area","").trim());
                    addElem(dom, emn, "responsable", base.getAttribute("responsable","").trim());
                    addElem(dom, emn, "toemail", base.getAttribute("email","").trim());
                }

                String strHeadermsg = "<br> \n";
                strHeadermsg += "<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2> \n";
                strHeadermsg += "----------------------------------------------------------------------<br> \n";
                strHeadermsg += reqParams.getLocaleString("emlSite") +" <b>"+ topic.getWebSiteId() + "." + topic.getTitle(lang) + "</b> \n";
                strHeadermsg += "<br>" + reqParams.getLocaleString("emlCommentType") + " <b> \n";
                if (commentType != null ) strHeadermsg += commentType;
                else strHeadermsg += reqParams.getLocaleString("emlHeaderMessage1");
                strHeadermsg += "</b><br> \n";
                strHeadermsg += "----------------------------------------------------------------------<br> \n";
                if (!"".equals(base.getAttribute("headermsg", "").trim())) {
                    addElem(dom, emn, "headermsg", base.getAttribute("headermsg").trim());
                    strHeadermsg += "<br>" + base.getAttribute("headermsg").trim() + "<br><br> \n";
                }
                strHeadermsg += "<br> \n";
                strHeadermsg += "<table border=0> \n";
                strHeadermsg += "<tr><td colspan=2><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1> \n";
                strHeadermsg += base.getAttribute("responsable", "").trim();
                strHeadermsg += "<br>" + base.getAttribute("area", "").trim();
                strHeadermsg += "<br><br></font></td></tr> \n";
                strHeadermsg += "<tr><td><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1> \n";
                strHeadermsg += reqParams.getLocaleString("emlName") + "</font></b></td><td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1> \n";
                strHeadermsg += strFromName + "</font></td></tr> \n";
                strHeadermsg += "<tr><td><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1>" + reqParams.getLocaleString("emlEmail") + "</font></b></td> \n";
                strHeadermsg += "<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1>" + strFromEmail + "</font></td></tr> \n";
                if (request.getParameter("txtPhone") != null && !"".equals(request.getParameter("txtPhone").trim())) {
                    addElem(dom, emn, "phone", request.getParameter("txtPhone").trim());
                    strHeadermsg += "<tr><td><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1>" + reqParams.getLocaleString("emlPhone") + "</font></b></td> \n";
                    strHeadermsg += "<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1>" + request.getParameter("txtPhone").trim() + "</font></td></tr> \n";
                }
                if (request.getParameter("txtFax") != null && !"".equals(request.getParameter("txtFax").trim())) {
                    addElem(dom, emn, "fax", request.getParameter("txtFax").trim());
                    strHeadermsg += "<tr><td><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1>" + reqParams.getLocaleString("emlFax") + "</font></b></td> \n";
                    strHeadermsg += "<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1>" + request.getParameter("txtFax").trim() + "</font></td></tr> \n";
                }
                strTarMsg = "<tr><td colspan=2><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=-1> \n";
                strTarMsg += "<br><br>" + reqParams.getLocaleString("emlHeaderMessage2") + " <br><br>" + request.getParameter("tarMsg").trim() +" \n";
                strTarMsg += "</font></td></tr> \n";

                String strFootermsg = "</table> \n";
                if (!"".equals(base.getAttribute("footermsg", "").trim())) {
                    addElem(dom, emn, "footermsg", base.getAttribute("footermsg").trim());
                    strFootermsg += "<br><br><br>"+ base.getAttribute("footermsg").trim();
                }
                strFootermsg += "<br><br><br> \n";
                addElem(dom, emn, "emailbody", strHeadermsg + strTarMsg + strFootermsg);
                return dom;
            }
            else throw new SWBResourceException("Error Missing Data. The following data fields are required: " +
                "\n\t sender's name: " + strFromName +
                "\n\t email account of the sender: " + strFromEmail +
                "\n\t email message: " + strTarMsg + "\n in getDomEmail()");
        } catch (Exception e) {
            log.error("Error while generating email message in resource " + base.getResourceType().getResourceClassName() + " with identifier " + base.getId() + " - " + base.getTitle(), e);
        }
        return null;
    }         

    /**
     * @param request
     * @param response
     * @param reqParams
     * @throws AFException
     * @throws IOException
     */    
    @Override
    public void doXML(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException {
        try {
            org.w3c.dom.Document dom = getDom(request, response, paramsRequest);
            if (dom != null) response.getWriter().println(SWBUtils.XML.domToXml(dom));
        } catch (Exception e) {
            log.error(e);
        }
    }    
    
    /**
     * @param request
     * @param response
     * @param reqParams
     * @throws AFException
     * @throws IOException
     */    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest reqParams) throws IOException {
        StringBuffer ret = new StringBuffer(400);
        Resource base = getResourceBase();
        String action = null != request.getParameter("com_act") && !"".equals(request.getParameter("com_act").trim()) ? request.getParameter("com_act").trim() : "com_step1";
        
        if("com_step1".equals(action)) {
            // Objeto (imagen/botón) para invocar la nueva ventana con formulario
            String onclick = "";
            try {
                onclick = "menubar=" + base.getAttribute("menubar", "no").trim();
                onclick += ",toolbar=" + base.getAttribute("toolbar", "no").trim();
                onclick += ",status=" + base.getAttribute("status", "no").trim();
                onclick += ",location=" + base.getAttribute("location", "no").trim();
                onclick += ",directories=" + base.getAttribute("directories", "no").trim();
                onclick += ",scrollbars=" + base.getAttribute("scrollbars", "no").trim();
                onclick += ",resizable=" + base.getAttribute("resizable", "no").trim();
                onclick += ",width=" + base.getAttribute("width", "450").trim();
                onclick += ",height=" + base.getAttribute("height", "330").trim();
                onclick += ",top=" + base.getAttribute("top", "10").trim();
                onclick += ",left=" + base.getAttribute("left", "10").trim();                

                SWBResourceURLImp url = new SWBResourceURLImp(request, base, reqParams.getWebPage(), SWBResourceURL.UrlType_RENDER);
                url.setResourceBase(base);
                url.setMode(SWBResourceURLImp.Mode_VIEW);
                url.setWindowState(SWBResourceURLImp.WinState_MAXIMIZED);
                url.setParameter("com_act","com_step2");
                url.setTopic(reqParams.getWebPage());
                url.setCallMethod(reqParams.Call_DIRECT);
                onclick="javascript:window.open('" + url.toString() +"','_newcom','" + onclick + "'); return true;";

                if (!"".equals(base.getAttribute("img", "").trim()))
                {
                    ret.append("\n<a href=\"#\"><img onClick=\""+ onclick +"\" src=\"");
                    ret.append(webWorkPath +"/"+ base.getAttribute("img").trim() +"\"");
                    ret.append(" alt=\"" + base.getAttribute("alt","").trim().replaceAll("\"","&#34;") + "\"");
                    ret.append(" border=0></a>");
                } 
                else if (!"".equals(base.getAttribute("btntexto", "").trim()))
                {
                    ret.append("\n<form name=frmComentario>");
                    ret.append("\n<input type=button name=btnComentario onClick=\""+ onclick +"\" value=");
                    ret.append("\"" + base.getAttribute("btntexto").trim().replaceAll("\"","&#34;") + "\"");
                    if (!"".equals(base.getAttribute("blnstyle", "").trim())) ret.append(" style=\"" + base.getAttribute("blnstyle").trim().replaceAll("\"","&#34;") + "\"");
                    ret.append("\n></form>");
                }
                else
                {
                    ret.append("\n<a href=\"#\" onClick=\""+ onclick +"\"");
                    if (!"".equals(base.getAttribute("blnstyle", "").trim())) ret.append(" style=\"" + base.getAttribute("blnstyle").trim().replaceAll("\"","&#34;") + "\"");
                    ret.append(">");
                    if (!"".equals(base.getAttribute("lnktexto", "").trim())) ret.append(base.getAttribute("lnktexto").trim());
                    else ret.append(reqParams.getLocaleString("msgComments"));
                    ret.append("</a>");
                }
            } catch (Exception e) {
                log.error("Error while showing form caller in resource " + base.getResourceType().getResourceClassName() + " with identifier " + base.getId() + " - " + base.getTitle(), e);
            }
        } else {
            try {
                Document dom = getDom(request, response, reqParams);
                if (dom != null) {
                    //System.out.println(AFUtils.getInstance().DomtoXml(dom));
                    ret.append(SWBUtils.XML.transformDom(tpl, dom));
                    if ("com_step3".equals(action)) {
                        
                        String from = dom.getElementsByTagName("fromemail").item(0).getFirstChild().getNodeValue();
                        String to = dom.getElementsByTagName("toemail").item(0).getFirstChild().getNodeValue();
                        String subject = dom.getElementsByTagName("subject").item(0).getFirstChild().getNodeValue();
                        InternetAddress address1 = new InternetAddress();
                        address1.setAddress(to);
                        ArrayList<InternetAddress> aAddress = new ArrayList<InternetAddress>();
                        aAddress.add(address1);
                        
                        if ((from != null && to != null && subject != null) && SWBUtils.EMAIL.sendMail(from, from, aAddress, null, null, subject, "HTML", ret.toString(), null, null, null) != null) {
                            ret.append("\n<script>");
                            ret.append("\nalert('" + reqParams.getLocaleString("msgSendEmail") + "');");
                            ret.append("\nwindow.close();");
                            ret.append("\n</script>");
                        } else {
                            ret.append("\n<script>");
                            ret.append("\nalert('" + reqParams.getLocaleString("msgSenderRequired") + "');");
                            ret.append("\nhistory.go(-1);");
                            ret.append("\n</script>");
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        
        PrintWriter out = response.getWriter();
        out.print(ret.toString());
        
    }

    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws AFException
     * @throws IOException
     */    
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException {
        
        StringBuffer ret = new StringBuffer(400);
        Resource base = getResourceBase();
        String msg = paramsRequest.getLocaleString("msgUndefinedOperation");
        String action = null != request.getParameter("act") && !"".equals(request.getParameter("act").trim()) ? request.getParameter("act").trim() : paramsRequest.getAction();
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        
        if (action.equals("add") || action.equals("edit"))  ret.append(getForm(request, paramsRequest));
        else if (action.equals("update")) {
            FileUpload fup = new FileUpload();
            try {
                fup.getFiles(request, response);
                String applet = null;                
                String value = null != fup.getFileName("template") && !"".equals(fup.getFileName("template").trim()) ? fup.getFileName("template").trim() : null;
                if(value != null) {
                    String file = admResUtils.getFileName(base, value);
                    if (file != null && !file.trim().equals("")) {
                        if (!admResUtils.isFileType(file, "xsl|xslt"))
                            msg = paramsRequest.getLocaleString("msgErrFileType") +" <i>xsl, xslt</i>: " + file;
                        else
                        {
                            applet = admResUtils.uploadFileParsed(base, fup, "template", request.getSession().getId());
                            if (applet != null && !applet.trim().equals("")) base.setAttribute("template", file);
                            else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                        }
                    }
                    else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                }
                value = null != fup.getValue("noimg") && !"".equals(fup.getValue("noimg").trim()) ? fup.getValue("noimg").trim() : "0";
                if ("1".equals(value) && !"".equals(base.getAttribute("img", "").trim())) {
                    SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/" + base.getAttribute("img").trim());
                    base.removeAttribute("img");
                } else {
                    value = null != fup.getFileName("img") && !"".equals(fup.getFileName("img").trim()) ? fup.getFileName("img").trim() : null;
                    if (value != null) {
                        String file = admResUtils.getFileName(base, value);
                        if (file != null && !file.trim().equals(""))
                        {
                            if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif"))
                                msg = paramsRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif</i>: " + file;
                            else
                            {
                                if (admResUtils.uploadFile(base, fup, "img"))
                                    base.setAttribute("img", file);
                                else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                            }
                        }
                        else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                    } 
                } 

                value = null != fup.getValue("noimgenviar") && !"".equals(fup.getValue("noimgenviar").trim()) ? fup.getValue("noimgenviar").trim() : "0";
                if ("1".equals(value) && !"".equals(base.getAttribute("imgenviar", "").trim())) {
                    SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/" + base.getAttribute("imgenviar").trim());
                    base.removeAttribute("imgenviar");
                } else {
                    value = null != fup.getFileName("imgenviar") && !"".equals(fup.getFileName("imgenviar").trim()) ? fup.getFileName("imgenviar").trim() : null;
                    if (value != null) {
                        String file = admResUtils.getFileName(base, value);
                        if (file != null && !file.trim().equals(""))
                        {
                            if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif"))
                                msg = paramsRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif</i>: " + file;
                            else
                            {
                                if (admResUtils.uploadFile(base, fup, "imgenviar"))
                                    base.setAttribute("imgenviar", file);
                                else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                            }
                        }
                        else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                    } 
                } 

                value = null != fup.getValue("noimglimpiar") && !"".equals(fup.getValue("noimglimpiar").trim()) ? fup.getValue("noimglimpiar").trim() : "0";
                if ("1".equals(value) && !"".equals(base.getAttribute("imglimpiar", "").trim())) {
                    SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/" + base.getAttribute("imglimpiar").trim());
                    base.removeAttribute("imglimpiar");                        
                } else {
                    value = null != fup.getFileName("imglimpiar") && !"".equals(fup.getFileName("imglimpiar").trim()) ? fup.getFileName("imglimpiar").trim() : null;
                    if (value != null) {
                        String file = admResUtils.getFileName(base, value);
                        if (file != null && !file.trim().equals(""))
                        {
                            if (!admResUtils.isFileType(file, "bmp|jpg|jpeg|gif"))
                                msg = paramsRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif</i>: " + file;
                            else
                            {
                                if (admResUtils.uploadFile(base, fup, "imglimpiar"))
                                    base.setAttribute("imglimpiar", file);
                                else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                            }
                        }
                        else msg = paramsRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                    } 
                } 
                setAttribute(base, fup, "alt");
                setAttribute(base, fup, "btntexto");
                setAttribute(base, fup, "lnktexto");
                setAttribute(base, fup, "blnstyle");
                setAttribute(base, fup, "altenviar");
                setAttribute(base, fup, "btnenviar");
                setAttribute(base, fup, "altlimpiar");
                setAttribute(base, fup, "btnlimpiar");
                setAttribute(base, fup, "firstname", "1");
                setAttribute(base, fup, "lastname", "1");
                setAttribute(base, fup, "middlename", "1");
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

                base.updateAttributesToDB();
                Document dom=base.getDom();
                if(dom!=null) removeAllNodes(dom, Node.ELEMENT_NODE, "comentario");
                else
                {
                    dom = SWBUtils.XML.getNewDocument();
                    Element root = dom.createElement("resource");
                    dom.appendChild(root);
                }

                value = null != fup.getValue("comentarios") && !"".equals(fup.getValue("comentarios").trim()) ? fup.getValue("comentarios").trim() : null;
                String type = null != fup.getValue("type") && !"".equals(fup.getValue("type").trim()) ? fup.getValue("type").trim() : "";
                String actype = null != fup.getValue("actype") && !"".equals(fup.getValue("actype").trim()) ? fup.getValue("actype").trim() : "edit";
                if(value!=null)
                {
                    java.util.StringTokenizer stk = new java.util.StringTokenizer(value, "|");
                    for (int i=1; stk.hasMoreTokens(); i++)
                    {
                        if("remove".equals(actype) && type.equals(String.valueOf(i))) { stk.nextToken(); continue; }
                        Element comment = dom.createElement("comentario");
                        java.util.StringTokenizer stk2 = new java.util.StringTokenizer(stk.nextToken(), ";");
                        for (int j=0; stk2.hasMoreTokens(); j++)
                        {
                            value = stk2.nextToken();
                            String att="comentario";
                            if(j==1) att="area";
                            else if(j==2) att="responsable";
                            else if(j==3) att="email";

                            if("edit".equals(actype) && type.equals(String.valueOf(i)))
                                value = null != fup.getValue(att) && !"".equals(fup.getValue(att).trim()) ? fup.getValue(att).trim() : "";

                            if(j < 1) comment.appendChild(dom.createTextNode(value));
                            else
                            {
                                Element data = dom.createElement(att);
                                data.appendChild(dom.createTextNode(value));
                                comment.appendChild(data);
                            }
                        }
                        dom.getFirstChild().appendChild(comment);
                    }
                }
                base.setXml(SWBUtils.XML.domToXml(dom));
                //base.getRecResource().update(paramsRequest.getUser().getId(), "Resource with identifier "+base.getId()+" was updated successfully ");
                msg=paramsRequest.getLocaleString("msgOkUpdateResource") +" "+ base.getId();
                if (applet!=null && !"".equals(applet.trim())) ret.append(applet);
                else {
                    ret.append(
                        "<script language=\"JavaScript\">\n"+
                        "   location='"+paramsRequest.getRenderUrl().setAction("edit").toString()+"';\n"+
                        "</script>\n");
                }
            } catch (Exception e) {
                log.error(e);
                msg = paramsRequest.getLocaleString("msgErrUpdateResource") + " " + base.getId();
            }
            ret.append(
                "<script language=\"JavaScript\">\n"+
                "   alert('"+msg+"');\n"+
                "</script>\n");             
        } else if (action.equals("remove")) {
            msg = admResUtils.removeResource(base);  
            ret.append(
                "<script language=\"JavaScript\">\n"+
                "   alert('" + msg + "');\n"+
                "</script>\n");             
        }
        response.getWriter().print(ret.toString());
    }

    /**
     * @param base
     * @param fup
     * @param att
     */  
    protected void setAttribute(Resource base, FileUpload fup, String att) {
        try {
            if(null != fup.getValue(att) && !"".equals(fup.getValue(att).trim())) base.setAttribute(att, fup.getValue(att).trim());
            else base.removeAttribute(att);        
        } catch (Exception e) {
            log.error("Error while setting resource attribute: " + att + ", " + base.getId() + "-" + base.getTitle(), e);
        }
    }
    
    /**
     * @param base
     * @param fup
     * @param att
     * @param value
     */  
    protected void setAttribute(Resource base, FileUpload fup, String att, String value) {
        try {
            if(null != fup.getValue(att) && value.equals(fup.getValue(att).trim())) base.setAttribute(att, fup.getValue(att).trim());
            else base.removeAttribute(att);        
        } catch (Exception e) {
            log.error("Error while setting resource attribute: " + att + ", " + base.getId() + "-" + base.getTitle(), e);
        }
    }    
    
    /**
     * @param dom
     * @param nodeType
     * @param name
     */       
    protected void removeAllNodes(Document dom, short nodeType, String name) {
        NodeList list = dom.getElementsByTagName(name);
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == nodeType) {
                node.getParentNode().removeChild(node);
                if(node.hasChildNodes()) removeAllNodes(dom, nodeType, name);
            }
        }
    }

    
    /**
     * @param request
     * @param paramsRequest
     * @return <b>String</b>
     */       
    private String getForm(HttpServletRequest request, 
                           SWBParamRequest paramsRequest) {
        
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        StringBuffer ret = new StringBuffer("");
        Resource base = getResourceBase();
        try {
            SWBResourceURL url = paramsRequest.getRenderUrl().setAction("update");  
            ret.append("<form name=\"frmResource\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url.toString()+"\"> \n");            
            ret.append("<div class=box>");
            ret.append("<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\">");
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<font style=\"color: #428AD4; text-decoration: none; font-family: Verdana; font-size: 12px; font-weight: normal;\">");
            ret.append(paramsRequest.getLocaleString("msgStep1") +"</font>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgTemplate")+" (xsl, xslt):</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"file\" name=\"template\" size=\"40\" onChange=\"isFileType(this, 'xsl|xslt');\" />");
            //if (!"".equals(base.getAttribute("template", "").trim()))
            if (path.indexOf(webWorkPath) !=-1) ret.append("<p>"+paramsRequest.getLocaleString("msgCurrentTemplate") + " <a href=\""+ path + base.getAttribute("template").trim() +"\">" + base.getAttribute("template").trim() + "</a></p>");
            else ret.append("<p>"+paramsRequest.getLocaleString("msgByDefault") + " <a href=\""+ path + name + ".xslt\">"+name+".xslt</a></p>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgImage")+" (bmp, gif, jpg, jpeg):</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"file\" name=\"img\" size=\"40\" onClick=\"this.form.btntexto.value=''; this.form.lnktexto.value=''\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if (!"".equals(base.getAttribute("img", "").trim())) ret.append("<p>" + admResUtils.displayImage(base, base.getAttribute("img").trim(), "img") +"<input type=checkbox name=noimg value=1>" + paramsRequest.getLocaleString("msgCutImage") + " <i>" + base.getAttribute("img").trim() + "</i></p>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgAlt")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=alt ");
            if (!"".equals(base.getAttribute("alt", "").trim()))  ret.append(" value=\"" + base.getAttribute("alt").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgButton")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=btntexto ");
            if (!"".equals(base.getAttribute("btntexto", "").trim()))  ret.append(" value=\"" + base.getAttribute("btntexto").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgLink")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=lnktexto ");
            if (!"".equals(base.getAttribute("lnktexto", "").trim()))  ret.append(" value=\"" + base.getAttribute("lnktexto").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgStyle")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=blnstyle ");
            if (!"".equals(base.getAttribute("blnstyle", "").trim()))  ret.append(" value=\"" + base.getAttribute("blnstyle").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgFirstName")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"checkbox\" name=\"firstname\" value=\"1\"");
            if ("1".equals(base.getAttribute("firstname", "0")))  ret.append(" checked");
            ret.append("></td> \n");
            ret.append("</tr> \n");  
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgLastName")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"checkbox\" name=\"lastname\" value=\"1\"");
            if ("1".equals(base.getAttribute("lastname", "0")))  ret.append(" checked");
            ret.append("></td> \n");
            ret.append("</tr> \n");  
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgMiddleName")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"checkbox\" name=\"middlename\" value=\"1\"");
            if ("1".equals(base.getAttribute("middlename", "0")))  ret.append(" checked");
            ret.append("></td> \n");
            ret.append("</tr> \n");             
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgSubmitImage")+" (bmp, gif, jpg, jpeg):</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"file\" name=\"imgenviar\" size=\"40\" onClick=\"this.form.btnenviar.value='';\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if (!"".equals(base.getAttribute("imgenviar", "").trim())) ret.append("<p>" + admResUtils.displayImage(base, base.getAttribute("imgenviar").trim(), "imgenviar") +"<input type=checkbox name=noimgenviar value=1>" + paramsRequest.getLocaleString("msgCutImage") + " <i>" + base.getAttribute("imgenviar").trim() + "</i></p>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgSubmitAlt")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=altenviar ");
            if (!"".equals(base.getAttribute("altenviar", "").trim()))  ret.append(" value=\"" + base.getAttribute("altenviar").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgSubmitButton")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=btnenviar ");
            if (!"".equals(base.getAttribute("btnenviar", "").trim()))  ret.append(" value=\"" + base.getAttribute("btnenviar").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgResetImage")+" (bmp, gif, jpg, jpeg):</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=\"file\" name=\"imglimpiar\" size=\"40\" onClick=\"this.form.btnlimpiar.value='';\" onChange=\"isFileType(this, 'bmp|jpg|jpeg|gif');\"/>");
            if (!"".equals(base.getAttribute("imglimpiar", "").trim())) ret.append("<p>" + admResUtils.displayImage(base, base.getAttribute("imglimpiar").trim(), "imglimpiar") +"<input type=checkbox name=noimglimpiar value=1>" + paramsRequest.getLocaleString("msgCutImage") + " <i>" + base.getAttribute("imglimpiar").trim() + "</i></p>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgResetAlt")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=altlimpiar ");
            if (!"".equals(base.getAttribute("altlimpiar", "").trim()))  ret.append(" value=\"" + base.getAttribute("altlimpiar").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgResetButton")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=btnlimpiar ");
            if (!"".equals(base.getAttribute("btnlimpiar", "").trim()))  ret.append(" value=\"" + base.getAttribute("btnlimpiar").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");            
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<br><br><font style=\"color: #428AD4; text-decoration: none; font-family: Verdana; font-size: 12px; font-weight: normal;\">");
            ret.append(paramsRequest.getLocaleString("msgStep2")+"</font>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append(admResUtils.loadWindowConfiguration(base, paramsRequest));
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<br><br><font style=\"color: #428AD4; text-decoration: none; font-family: Verdana; font-size: 12px; font-weight: normal;\">");
            ret.append(paramsRequest.getLocaleString("msgStep3")+"</font>");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgSubjectTag")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<input type=text size=50 name=subject ");
            if (!"".equals(base.getAttribute("subject", "").trim()))  ret.append(" value=\"" + base.getAttribute("subject").trim().replaceAll("\"","&#34;") + "\"");
            ret.append("></td> \n");
            ret.append("</tr> \n");
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgMessageHeader")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<textarea name=headermsg rows=5 cols=50 wrap=virtual>");
            if (!"".equals(base.getAttribute("headermsg", "").trim()))  ret.append(base.getAttribute("headermsg").trim().replaceAll("\"","&#34;"));
            ret.append("</textarea></td> \n");
            ret.append("</tr> \n");               
            ret.append("<tr> \n");
            ret.append("<td class=\"datos\">"+paramsRequest.getLocaleString("msgMessageFooter")+"</td> \n");
            ret.append("<td class=\"valores\">");
            ret.append("<textarea name=footermsg rows=5 cols=50 wrap=virtual>");
            if (!"".equals(base.getAttribute("footermsg", "").trim()))  ret.append(base.getAttribute("footermsg").trim().replaceAll("\"","&#34;"));
            ret.append("</textarea></td> \n");
            ret.append("</tr> \n");          
            ret.append("<tr> \n");
            ret.append("<td colspan=2>");
            ret.append("<table cellspacing=0 cellpadding=0 border=0 width=\"100%\"> \n");
            ret.append("<tr class=tabla> \n");
            ret.append("<td></td> \n");
            ret.append("<td>* "+paramsRequest.getLocaleString("msgTypeComment")+"&nbsp;&nbsp;</td> \n");
            ret.append("<td>"+paramsRequest.getLocaleString("msgArea")+"&nbsp;&nbsp;</td> \n");
            ret.append("<td>"+paramsRequest.getLocaleString("msgResponsable")+"&nbsp;&nbsp;</td> \n");
            ret.append("<td>"+paramsRequest.getLocaleString("msgEmail")+"</td> \n");
            ret.append("</tr> \n");

            String comentarios="", area="", responsable="", email="";
            int i=0;
            Iterator it=getTypesComment(base.getDom()).iterator();
            while(it.hasNext())
            {
                TypeComment tc= (TypeComment)it.next();
                i++;
                String bgcolor="#FFFFFF";
                if(i%2==0) bgcolor="#EFEDEC";
                ret.append("<tr class=valores bgcolor="+bgcolor+"> \n");
                ret.append("<td> \n");
                ret.append("<a onClick=\"javascript:if(confirm('"+paramsRequest.getLocaleString("msgConfirmRemove") +"')) { document.frmResource.type.value="+String.valueOf(i)+";  document.frmResource.actype.value='remove'; document.frmResource.submit(); } else return false;\">");
                ret.append("<img src=\"" + SWBPlatform.getContextPath() + "wbadmin/images/eliminar.gif\" border=0 alt=\""+paramsRequest.getLocaleString("msgRemoveTypeComment")+"\">");
                ret.append("</a>&nbsp; \n");                
                ret.append("<a onClick=\"javascript:document.frmResource.type.value="+String.valueOf(i)+"; document.frmResource.actype.value='edit'; jsLoad(document.frmResource, '"+ tc.getComentario() +"', '"+ tc.getArea() +"', '"+ tc.getResponsable() +"', '"+ tc.getEmail()+ "');\">");
                ret.append("<img src=\"" + SWBPlatform.getContextPath() + "wbadmin/images/i_contenido.gif\" border=0 alt=\""+paramsRequest.getLocaleString("msgEditTypeComment")+"\">");
                ret.append("</a></td> \n"); 
                ret.append("<td>"+tc.getComentario()+"</td> \n");
                ret.append("<td>"+tc.getArea()+"</td> \n");
                ret.append("<td>"+tc.getResponsable()+"</td> \n");
                ret.append("<td>"+tc.getEmail()+"</td> \n");
                ret.append("</tr> \n");
                if(i == 1)
                {
                    area=tc.getArea();
                    responsable=tc.getResponsable();
                    email=tc.getEmail();
                }
                if(i > 1) comentarios+="|";
                comentarios+=tc.getComentario()+";"+tc.getArea()+";"+tc.getResponsable()+";"+tc.getEmail();
            }
            ret.append("<tr class=valores> \n");
            ret.append("<td></td>");
            ret.append("<td valign=top><input type=text size=10 name=comentario></td> \n");
            ret.append("<td valign=top><input type=text size=20 name=area></td> \n");
            ret.append("<td valign=top><input type=text size=20 name=responsable></td> \n");
            ret.append("<td valign=top align=right><input type=text size=20 name=email><p> \n");
            ret.append("<input type=button name=btnType value=\""+ paramsRequest.getLocaleString("msgAdd") +"\" onClick=\"if(jsValidaType(this.form, '"+area+"', '"+responsable+"', '"+email+"')) document.frmResource.submit(); else return false;\" class=boton> \n");
            ret.append("<input type=hidden name=type value=0> \n");
            ret.append("<input type=hidden name=actype value=add> \n");
            ret.append("<input type=hidden name=comentarios value=\""+comentarios+"\"> \n");
            ret.append("</td></tr> \n");
            ret.append("</table> \n");
            ret.append("</td> \n");
            ret.append("</tr> \n");
            
            ret.append("<tr> \n");
            ret.append("\n<td colspan=2 align=right>");
            ret.append("<br><hr size=1 noshade> \n");
            ret.append("\n<input type=submit name=btnSave value=" + paramsRequest.getLocaleString("btnSubmit") + " onClick=\"if(jsValida(this.form, "+i+", '"+area+"', '"+responsable+"', '"+email+"')) return true; else return false;\" class=boton>&nbsp;");
            ret.append("<input type=reset name=btnReset value=" + paramsRequest.getLocaleString("btnReset") + " class=boton>");
            ret.append("\n</td>");
            ret.append("\n</tr>");          
            ret.append("<tr> \n");
            ret.append("\n<td colspan=2><br><font style=\"color: #428AD4; font-family: Verdana; font-size: 10px;\">");
            ret.append("\n* "+paramsRequest.getLocaleString("msgRequiredData"));
            ret.append("\n</font></td>");
            ret.append("\n</tr>");          
            ret.append("</table> \n");
            ret.append("</div>");
            ret.append("</form> \n");
            ret.append(getScript(request, paramsRequest));
        } catch (Exception e) {
            log.error(e);
        }
        return ret.toString();
    }
        
    /**
     * @param dom
     * @return <b>ArrayList</b>
     */     
    private ArrayList getTypesComment(Document dom)
    {
        ArrayList<TypeComment> list=new ArrayList<TypeComment>();
        if(dom!=null)
        {
            TypeComment tc=new TypeComment();
            String comentario="", area="", responsable="", email="";
            
            NodeList node = dom.getElementsByTagName("comentario");
            for (int i = 0; i < node.getLength(); i++)
            {
                area=""; responsable=""; email="";
                comentario = node.item(i).getFirstChild().getNodeValue().trim();
                if(!"".equals(comentario)) 
                {
                    NodeList child = node.item(i).getChildNodes();
                    for (int j = 0; j < child.getLength(); j++)
                    {
                        if(child.item(j)!=null)
                        {
                            if("area".equals(child.item(j).getNodeName())) area = child.item(j).getFirstChild().getNodeValue().trim();
                            else if("responsable".equals(child.item(j).getNodeName())) responsable = child.item(j).getFirstChild().getNodeValue().trim();
                            else if("email".equals(child.item(j).getNodeName())) email = child.item(j).getFirstChild().getNodeValue().trim();
                        }
                    }
                    if("".equals(email))
                    {
                        child = dom.getFirstChild().getChildNodes();
                        for (int j = 0; j < child.getLength(); j++)
                        {
                            if(child.item(j)!=null)
                            {
                                if("area".equals(child.item(j).getNodeName())) area = child.item(j).getFirstChild().getNodeValue().trim();
                                else if("responsable".equals(child.item(j).getNodeName())) responsable = child.item(j).getFirstChild().getNodeValue().trim();
                                else if("email".equals(child.item(j).getNodeName())) email = child.item(j).getFirstChild().getNodeValue().trim();
                            }
                        }
                    }                        
                    tc=new TypeComment(comentario, area, responsable, email);
                    list.add(tc);
                }
            }
        }        
        return list;
    }
    
    /**
     * @param request
     * @param paramsRequest
     * @return <b>String</b>
     */  
    private String getScript(HttpServletRequest request,
            SWBParamRequest paramsRequest) {
        
        StringBuffer ret = new StringBuffer("");
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        
        try {
            ret.append("\n<script>");
            ret.append("\nfunction jsValida(pForm, count, area, responsable, email)");
            ret.append("\n{");
            ret.append("\n   trim(pForm.comentario);");
            ret.append("\n   trim(pForm.area);");
            ret.append("\n   trim(pForm.responsable);");
            ret.append("\n   trim(pForm.email);");  
            ret.append("\n   if(count < 1)");
            ret.append("\n   {");
            ret.append("\n      if(pForm.comentario.value=='')");
            ret.append("\n      {");
            ret.append("\n         alert('" + paramsRequest.getLocaleString("msgCommentRequired") + "');");
            ret.append("\n         pForm.comentario.focus();");
            ret.append("\n         return false;");
            ret.append("\n      }");
            ret.append("\n      if(pForm.area.value=='')");
            ret.append("\n      {");
            ret.append("\n         alert('" + paramsRequest.getLocaleString("msgAreaRequired") + "');");
            ret.append("\n         pForm.area.focus();");
            ret.append("\n         return false;");
            ret.append("\n      }");
            ret.append("\n      if(pForm.responsable.value=='')");
            ret.append("\n      {");
            ret.append("\n         alert('" + paramsRequest.getLocaleString("msgManagerRequired") + "');");
            ret.append("\n         pForm.responsable.focus();");
            ret.append("\n         return false;");
            ret.append("\n      }");
            ret.append("\n      if(pForm.email.value=='')");
            ret.append("\n      {");
            ret.append("\n         alert('" + paramsRequest.getLocaleString("msgEmailRequired") + "');");
            ret.append("\n         pForm.email.focus();");
            ret.append("\n         return false;");
            ret.append("\n      }");            
            ret.append("\n   }");
            ret.append("\n   else");
            ret.append("\n   {");
            ret.append("\n      if(pForm.comentario.value!='')");
            ret.append("\n      {");            
            ret.append("\n          if(pForm.area.value=='') pForm.area.value=area;");
            ret.append("\n          if(pForm.responsable.value=='') pForm.responsable.value=responsable;");
            ret.append("\n          if(pForm.email.value=='') pForm.email.value=email;");
            ret.append("\n      }");
            ret.append("\n   }");            
            ret.append("\n   if(!isFileType(pForm.template, 'xsl|xslt')) return false;");
            ret.append("\n   if(!isFileType(pForm.img, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if(!isFileType(pForm.imgenviar, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if(!isFileType(pForm.imglimpiar, 'bmp|jpg|jpeg|gif')) return false;");
            ret.append("\n   if(!isNumber(pForm.width)) return false;");
            ret.append("\n   if(!isNumber(pForm.height)) return false;");
            ret.append("\n   if(!isNumber(pForm.top)) return false;");
            ret.append("\n   if(!isNumber(pForm.left)) return false;");
            ret.append("\n   replaceChars(pForm.headermsg);");
            ret.append("\n   replaceChars(pForm.footermsg);");
            ret.append("\n   if(pForm.actype.value=='add' && pForm.comentario.value!='')");
            ret.append("\n   {");
            ret.append("\n      trim(pForm.comentarios);");
            ret.append("\n      if(pForm.comentarios.value!='') pForm.comentarios.value+='|'");
            ret.append("\n      pForm.comentarios.value+=pForm.comentario.value+';'+pForm.area.value+';'+pForm.responsable.value+';'+pForm.email.value;");
            ret.append("\n   }");            
            ret.append("\n   return true;");
            ret.append("\n}");
            ret.append("\nfunction jsLoad(pForm, comentario, area, responsable, email)");
            ret.append("\n{");
            ret.append("\n   pForm.btnType.value='"+paramsRequest.getLocaleString("msgUpdate")+"';");
            ret.append("\n   pForm.comentario.value=comentario;");
            ret.append("\n   pForm.area.value=area;");
            ret.append("\n   pForm.responsable.value=responsable;");
            ret.append("\n   pForm.email.value=email;");
            ret.append("\n}");
            ret.append("\nfunction jsValidaType(pForm, area, responsable, email)");
            ret.append("\n{");            
            ret.append("\n   trim(pForm.comentario);");
            ret.append("\n   if(pForm.comentario.value=='')");
            ret.append("\n   {");
            ret.append("\n       alert('" + paramsRequest.getLocaleString("msgCommentRequired") + "');");
            ret.append("\n       pForm.comentario.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   trim(pForm.area);");
            ret.append("\n   trim(pForm.responsable);");
            ret.append("\n   trim(pForm.email);");
            ret.append("\n   if(pForm.area.value=='') pForm.area.value=area;");
            ret.append("\n   if(pForm.responsable.value=='') pForm.responsable.value=responsable;");
            ret.append("\n   if(pForm.email.value=='') pForm.email.value=email;");
            ret.append("\n   trim(pForm.area);");
            ret.append("\n   if(pForm.area.value=='')");
            ret.append("\n   {");
            ret.append("\n       alert('" + paramsRequest.getLocaleString("msgAreaRequired") + "');");
            ret.append("\n       pForm.area.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   trim(pForm.responsable);");
            ret.append("\n   if(pForm.responsable.value=='')");
            ret.append("\n   {");
            ret.append("\n       alert('" + paramsRequest.getLocaleString("msgManagerRequired") + "');");
            ret.append("\n       pForm.responsable.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   trim(pForm.email);");            
            ret.append("\n   if(pForm.email.value=='')");
            ret.append("\n   {");
            ret.append("\n       alert('" + paramsRequest.getLocaleString("msgEmailRequired") + "');");
            ret.append("\n       pForm.email.focus();");
            ret.append("\n       return false;");
            ret.append("\n   }");
            ret.append("\n   else if(!isEmail(pForm.email)) return false;");
            ret.append("\n   if(pForm.actype.value=='add')");
            ret.append("\n   {");
            ret.append("\n      trim(pForm.comentarios);");
            ret.append("\n      if(pForm.comentarios.value!='') pForm.comentarios.value+='|'");
            ret.append("\n      pForm.comentarios.value+=pForm.comentario.value+';'+pForm.area.value+';'+pForm.responsable.value+';'+pForm.email.value;");
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
            ret.append(admResUtils.loadTrim());
            ret.append("\n</script>");  
        } catch (Exception e) {
            log.error(e);
        }
        return ret.toString();
    }

    /**
     * @param doc
     * @param parent
     * @param elemName
     * @param elemValue
     */      
    private void addElem(org.w3c.dom.Document doc, org.w3c.dom.Element parent, String elemName, String elemValue) {
        org.w3c.dom.Element elem = doc.createElement(elemName);
        elem.appendChild(doc.createTextNode(elemValue));
        parent.appendChild(elem);
    }
}


/** 
 * Objeto: Tipos de comentario en memoria.
 *
 * Object: Comment types in memory.
 *
 * @author : Vanessa Arredondo N��ez
 * @version 1.0
 */
class TypeComment {
    
    
    private String comentario;
    private String area;
    private String responsable;
    private String email;

    /** 
     * Creates a new instance of TypeComment 
     */        
    public TypeComment() {
    }
    
    /**
     * Creates a new instance of TypeComment
     *
     * @param comentario
     * @param area
     * @param responsable
     * @param email
     */
    public TypeComment(String comentario, String area, String responsable, String email) {
        this.comentario = comentario;
        this.area = area;
        this.responsable = responsable;
        this.email = email;
    }

    /** 
     * Getter for property comentario.
     * @return <b>String</b> Value of property comentario.
     */
    public String getComentario() {
        return this.comentario;
    }
    
    /** 
     * Setter for property comentario.
     * @param comentario New value of property comentario.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    /**
     * Getter for property area.
     * @return <b>String</b> Value of property area.
     */
    public String getArea() {
        return this.area;
    }
    
    /** 
     * Setter for property area.
     * @param area New value of property area.
     */
    public void setArea(String area) {
        this.area = area;
    }
    
    /** 
     * Getter for property responsable.
     * @return <b>String</b> Value of property responsable.
     */
    public String getResponsable() {
        return this.responsable;
    }
    
    /** 
     * Setter for property responsable.
     * @param responsable New value of property responsable.
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    /** 
     * Getter for property email.
     * @return <b>String</b> Value of property email.
     */
    public String getEmail() {
        return this.email;
    }
    
    /** 
     * Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
