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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.wb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author jorge.jimenez
 */
public class WBMenuMap extends GenericAdmResource 
{

    private static Logger log = SWBUtils.getLogger(WBMenuMap.class);
    javax.xml.transform.Templates tpl;
    String webWorkPath = "/work";
    String path = SWBPlatform.getContextPath() + "/swbadmin/xsl/WBMenuMap/";
    private int ancho = 10;
    private int nsup = 0;
    private int ninf = 0;
    private int nini = 0;
    private boolean bro = true;
    private boolean bro4ch = false;

    /**
     * Asigna la información de la base de datos al recurso.
     *
     * @param     base  La información del recurso en memoria.
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
                tpl = SWBUtils.XML.loadTemplateXSLT(SWBPortal.getFileFromWorkPath(base.getWorkPath() + "/" + base.getAttribute("template").trim()));
                path = webWorkPath + "/";
            } catch (Exception e) {
                log.error("Error while loading resource template: " + base.getId(), e);
            }
        }
        if (tpl == null) {
            try {
                tpl = SWBUtils.XML.loadTemplateXSLT(SWBPortal.getAdminFileStream("/swbadmin/xsl/WBMenuMap/WBMenuMap.xslt"));
            } catch (Exception e) {
                log.error("Error while loading default resource template: " + base.getId(), e);
            }
        }

        try {
            bro = Boolean.parseBoolean(base.getAttribute("bro", "true"));
            bro4ch = Boolean.parseBoolean(base.getAttribute("bro4ch", "false"));
            nsup = Integer.parseInt(base.getAttribute("nsup", "-1"));
            ninf = Integer.parseInt(base.getAttribute("ninf", "-1"));
            nini = Integer.parseInt(base.getAttribute("nini", "0"));
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * Obtiene el resultado final del recurso en formato dom
     * @param request
     * @param response
     * @param reqParams
     * @throws AFException
     * @throws IOException
     */
    public Document getDom(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = paramRequest.getResourceBase();
        User user = paramRequest.getUser();
        WebPage basetp = paramRequest.getWebPage().getWebSite().getHomePage();
        WebPage topic = paramRequest.getWebPage();

        String basetopic = base.getAttribute("basetopic", "_home");
        try {
            if (!"_home".equals(basetopic)) {
                basetp = paramRequest.getWebPage().getWebSite().getWebPage(basetopic);
            }
        } catch (Exception e) {
            log.error("Error. Tópico no encontrado: " + basetopic + ". WBMenuNivel.getDom()", e);
            basetp = paramRequest.getWebPage().getWebSite().getHomePage();
        }
        try {
            org.semanticwb.model.Language lang = topic.getWebSite().getLanguage(user.getLanguage());

            Document dom = SWBUtils.XML.getNewDocument();
            Element el = dom.createElement("menu");
            el.setAttribute("path", path);
            dom.appendChild(el);

            int max = getLimits(basetp, topic, 1, user);
            //System.out.println("max:"+max);

            getChilds(dom, el, basetp, topic, lang, 1, 1, user, max);

            return dom;
        } catch (Exception e) {
            log.error("Error while generating DOM in resource " + base.getResourceType().getResourceClassName() + " with identifier " + base.getId() + " - " + base.getTitle(), e);
        }
        return null;
    }
 
    
    public int getLimits(WebPage aux, WebPage topic, int level, User user) {
        int max = level;
        Iterator<WebPage> it = aux.listChilds();
        while (it.hasNext()) {
            WebPage tp = it.next();
            if (tp.isActive() && (tp.isVisible() || tp == topic || tp.isParentof(topic))) {
                //if(user.haveAccess(tp))
                {
                    if (tp.isParentof(topic) || tp == topic) {
                        return getLimits(tp, topic, level + 1, user);
                    } else {
                        max = level + 1;
                    }
                }
            }
        }
        return max;
    }

    public boolean getChilds(Document dom, Element nodo, WebPage aux, WebPage topic, org.semanticwb.model.Language lang, int level, int rlevel, User user, int max) {
        boolean childs = false;
        Iterator<WebPage> itwp = aux.listChilds(lang.getId(), null, null, null, null);
        while (itwp.hasNext()) {
            WebPage wbtp = itwp.next();
            if (wbtp.isActive() && (wbtp.isVisible() || wbtp == topic || wbtp.isParentof(topic))) {
                //if(user.haveAccess(tp))
                {
                    childs = true;

                    Element ele = dom.createElement("node");
                    ele.setAttribute("id", wbtp.getUrl());
                    ele.setAttribute("name", wbtp.getDisplayTitle(lang.getId()));
                    ele.setAttribute("path", wbtp.getUrl());
                    ele.setAttribute("realLevel", "" + rlevel);
                    ele.setAttribute("level", "" + level);
                    ele.setAttribute("inPath", "" + wbtp.isParentof(topic));
                    if (wbtp == topic) {
                        ele.setAttribute("current", "true");
                    } else {
                        ele.setAttribute("current", "false");
                    }

                    int auxl = 0;
                    if (((nsup < 0 || rlevel <= nsup) || (ninf < 0 || rlevel >= (max - ninf)))) {
                        if (!(topic == wbtp && wbtp.getParent() != aux)) {
                            if (nini <= rlevel) {
                                nodo.appendChild(ele);
                                auxl = 1;
                            //System.out.println("node:"+tp.getId()+":"+level+":"+rlevel);
                            } else {
                                ele = nodo;
                            }
                        }
                    } else {
                        ele = nodo;
                    }
                    if (wbtp.isParentof(topic) || wbtp == topic) {
                        ele.setAttribute("open", "true");
                        if (getChilds(dom, ele, wbtp, topic, lang, level + auxl, rlevel + 1, user, max)) {
                            ele.setAttribute("childs", "true");
                        } else {
                            ele.setAttribute("childs", "false");
                        }
                    } else {
                        try {
                            if (bro4ch) {
                                //System.out.println("tp:"+tp.getId()+" topic:"+topic.getId()+":"+level+":"+rlevel+" max:"+max+" bro4ch");
                                if (!bro && (rlevel + 1) < max && (!wbtp.isChildof(topic) || (wbtp.getParent() != aux && (wbtp.getParent() == topic || wbtp.getParent() == topic)))) {
                                    nodo.removeChild(ele);
                                }
                            } else {
                                //System.out.println("tp:"+tp.getId()+" topic:"+topic.getId()+":"+level+":"+rlevel+" max:"+max+" bro:"+bro);
                                if (!bro && (!wbtp.isChildof(topic) || (wbtp.getParent() != aux && (wbtp.getParent() == topic || wbtp.getParent() == topic)))) {
                                    nodo.removeChild(ele);
                                }
                            }
                        } catch (Exception noe) {
                        }
                        ele.setAttribute("open", "false");
                        if (haveChilds(aux, user)) {
                            ele.setAttribute("childs", "true");
                        } else {
                            ele.setAttribute("childs", "false");
                        }
                    }
                }
            }
        }
        //System.out.println("****************** out"+level+":"+aux.getId()+" ***********************");
        return childs;
    }

    public boolean haveChilds(WebPage aux, User user) {
        Iterator<WebPage> it = aux.listChilds();
        while (it.hasNext()) {
            WebPage tp = it.next();
            //if(user.haveAccess(tp))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene el resultado final del recurso en formato xml
     * @param request
     * @param response
     * @param reqParams
     * @throws AFException
     * @throws IOException
     */
    @Override
    public void doXML(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            Document dom = getDom(request, response, paramRequest);
            if (dom != null) {
                response.getWriter().println(SWBUtils.XML.domToXml(dom));
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        try {
            Document dom = getDom(request, response, paramRequest);
            if (dom != null) {
                response.getWriter().print(SWBUtils.XML.transformDom(tpl, dom));
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
    
 }
