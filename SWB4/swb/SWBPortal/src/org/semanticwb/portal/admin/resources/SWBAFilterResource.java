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
package org.semanticwb.portal.admin.resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Vector;

import org.w3c.dom.*;

import javax.servlet.http.*;
import javax.servlet.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.*;

import org.semanticwb.model.*;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;

// TODO: Auto-generated Javadoc
/** Recurso para la administarci�n de WebBuilder que permite seleccionar los t�picos
 * en los cuales se mostrar� el recurso seleccionado.
 *
 * WebBuilder administration resource that allows select the topics to show the
 * selected resource.
 */
public class SWBAFilterResource extends SWBATree {

    /** The log. */
    private Logger log = SWBUtils.getLogger(SWBAFilterResource.class);
    /** The Constant pathValids. */
    static final String[] pathValids = {"getServer", "getTopic", "getTopicMap"};
    /** The Constant namevalids. */
    static final String[] namevalids = {"node", "config", "icons", "icon", "res", "events", "willExpand"};

    /**
     * Process request.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if (paramRequest.getMode().equals("gateway")) {
            doGateway(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    private JSONObject createNodeObject(String id, String name, String negative, String childs) throws JSONException {
        JSONObject ret = new JSONObject();
        boolean bNegative = false, bChilds = false;
        
        ret.put("uuid", UUID.randomUUID().toString());
        ret.put("enabled", true);
        if (null != id && !id.isEmpty()) ret.put("id", id);
        if (null != name && !name.isEmpty()) ret.put("name", name);
        if (null != negative && !negative.isEmpty()) {
            bNegative = negative.equalsIgnoreCase("true");
            ret.put("negative", bNegative);
        }
        
        if (null != childs && !childs.isEmpty()) {
            bChilds = childs.equalsIgnoreCase("true");
            ret.put("childs", bChilds);
        }

        return ret;
    }
    
    private void getWebPagesJSON(WebPage root, String parentuid, JSONArray pages, String lang) throws JSONException {
        if (null != root && null != pages) {
            JSONObject pg = createNodeObject(root.getId(), root.getDisplayTitle(lang), null, null);
            pg.put("cssIcon", "swbIconWebPage");
            if (null != parentuid && !parentuid.isEmpty()) {
                pg.put("parent", parentuid);
            }
            pages.put(pg);
            
            Iterator<WebPage> childs = SWBComparator.sortSortableObjectSet(root.listChilds()).iterator();
            while (childs.hasNext()) {
                WebPage child = childs.next();
                getWebPagesJSON(child, pg.getString("uuid"), pages, lang);
            }
        }
    }
    
    private JSONObject getMergedFilter(ResourceFilter filter, JSONArray pages) throws JSONException {
        JSONObject filterData = getJSONFilter(filter);
        //JSONObject paths = new JSONObject();
        
        HashMap<String, JSONObject> objTable = new HashMap<>();
        JSONArray src = filterData.getJSONArray("topics");
        
        if (null != src && null != pages) {
            for (int i = 0; i < src.length(); i++) {
                JSONObject item = src.getJSONObject(i);
                objTable.put(item.getString("id"), item);
            }
            
            for (int i = 0; i < pages.length(); i++) {
                JSONObject item = pages.getJSONObject(i);
                String key = item.getString("id");
                if (objTable.containsKey(key)) {
                    JSONObject obj = objTable.get(key);
                    item.put("selected", true);
                    item.put("childs", obj.optBoolean("childs", false));
                    //paths.put(item.getString("uuid"));
                }
            }
            
            //Put server and site nodes
            JSONObject server = createNodeObject("Server", "Server", null, null);
            server.put("cssIcon", "swbIconServer");
            
            JSONObject site = createNodeObject(filter.getWebSite().getId(), filter.getWebSite().getTitle(), null, null);
            site.put("cssIcon", "swbIconWebSite");
            site.put("parent", server.getString("uuid"));
            
            JSONObject home = pages.getJSONObject(0);
            home.put("cssIcon", "swbIconHomePage");
            home.put("parent", site.getString("uuid"));

            pages.put(site);
            pages.put(server);
            
            filterData.put("topics", pages);
            filterData.put("sitesRoot", server.getString("uuid"));
        }
        
        return filterData;
    }
    
    public void doGateway(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String ret = "";
        String action = paramRequest.getAction();
        String lang = "es";
        if (null != paramRequest.getUser() && null != paramRequest.getUser().getLanguage()) lang = paramRequest.getUser().getLanguage();
        
        if ("getFilter".equals(action)) {
            JSONObject _ret = new JSONObject();
            Resource res = (Resource) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
            if (null != res && null != res.getResourceFilter()) {
                ResourceFilter rf = res.getResourceFilter();
                
                try {
                    JSONArray pages = new JSONArray();
                    getWebPagesJSON(res.getWebSite().getHomePage(), null, pages, lang);
                    _ret = getMergedFilter(rf, pages);
                    System.out.println(_ret.toString(2));
                } catch (JSONException jsex) {
                    log.error("Error al generar JSON del componente", jsex);
                }
            }
            ret = _ret.toString();
        }
        out.print(ret);
    }
    
    JSONArray getNodeElements(String nodeName, Element root) throws JSONException {
        JSONArray ret = new JSONArray();
        NodeList nodes = root.getElementsByTagName(nodeName);
        
        for (int i = 0; i < nodes.getLength(); i++) {
            Element enode = (Element) nodes.item(i);
            String idObj = enode.getAttribute("id");
            String negative = enode.getAttribute("negative");
            String childs = enode.getAttribute("childs");

            JSONObject e = createNodeObject(idObj, null, negative, childs);
            ret.put(e);
        }
        
        return ret;
    }
    
    private JSONObject getJSONFilter(ResourceFilter rf) throws JSONException {
        JSONObject ret = new JSONObject();
        String xml = rf.getXml();
        
        if (null != xml && !xml.isEmpty()) {
            Document dom = SWBUtils.XML.xmlToDom(xml);
            if (dom.getElementsByTagName("resource").getLength() > 0) {
                Element root = (Element) dom.getElementsByTagName("resource").item(0);
                
                if (root.getElementsByTagName("filter").getLength() > 0) {
                    root = (Element) dom.getElementsByTagName("filter").item(0);
                    
                    if (root.getElementsByTagName("topicmap").getLength() > 0) {
                        root = (Element) dom.getElementsByTagName("topicmap").item(0);
                        String id = root.getAttribute("id");
                        String negative = root.getAttribute("negative");

                        ret = createNodeObject(id, negative, null, null);
                        ret.put("topics", getNodeElements("topic", root));
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Adds the.
     * 
     * @param cmd the cmd
     * @param src the src
     * @param user the user
     * @param request the request
     * @param response the response
     * @return the document
     * @return
     */
    public Document add(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response) {
        Document doc = null;
        try {
            doc = SWBUtils.XML.getNewDocument();
            Element res = doc.createElement("res");
            doc.appendChild(res);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            log.error(e);
        }
        return doc;
    }

    /**
     * Update filter.
     * 
     * @param cmd the cmd
     * @param src the src
     * @param user the user
     * @param request the request
     * @param response the response
     * @return the document
     * @return
     */
    public Document updateFilter(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response) {

        if (src.getElementsByTagName("filter").getLength() > 0) {
            String id = src.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
            String tm = src.getElementsByTagName("tm").item(0).getFirstChild().getNodeValue();
            Resource recres = null;
            WebSite map = SWBContext.getWebSite(tm);
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = ont.getGenericObject(id);

            if (gobj instanceof Resource) {
                recres = (Resource) gobj;
                map = recres.getWebSite();
            } else {
                return null;
            }


            log.debug("updateFilter...id:" + id + ", tm:" + tm);
            String xml = "<resource><filter/></resource>";
            ResourceFilter pfil = recres.getResourceFilter();
            if (pfil != null) {
                xml = pfil.getXml();
            }

            try {
                Document docxmlConf = null;
                Element eResource = null;
                if (xml == null || xml.equals("")) {
                    docxmlConf = SWBUtils.XML.getNewDocument();
                    eResource = docxmlConf.createElement("resource");
                    docxmlConf.appendChild(eResource);
                } else {

                    //System.out.println("XML antes de actualizar:\n"+xml);

                    if(xml.indexOf("<resource>")==-1)
                    {
                        int intIniIdx = xml.indexOf("<filter>");
                        int intEndIdx = xml.lastIndexOf("</filter>");
                        if (intIniIdx != -1 && intEndIdx != -1) {
                            xml = xml.substring(intIniIdx,intEndIdx+9);
                            xml = "<resource>"+xml+"</resource>";
                            //System.out.println("XML:"+xml);
                        }
                    }

                    docxmlConf = SWBUtils.XML.xmlToDom(xml);
                    if (docxmlConf.getElementsByTagName("resource").getLength() > 0) {
                        eResource = (Element) docxmlConf.getElementsByTagName("resource").item(0);
                    } else {
                        eResource = docxmlConf.createElement("resource");
                        docxmlConf.appendChild(eResource);
                    }
                }
                NodeList filters = eResource.getElementsByTagName("filter");
                for (int i = 0; i < filters.getLength(); i++) {
                    Element filter = (Element) filters.item(i);
                    filter.getParentNode().removeChild(filter);
                }
                filters = src.getElementsByTagName("filter");
                for (int i = 0; i < filters.getLength(); i++) {
                    Element filter = (Element) filters.item(i);
                    filter = (Element) docxmlConf.importNode(filter, true);
                    eResource.appendChild(filter);
                }

                log.debug(SWBUtils.XML.domToXml(docxmlConf));

                pfil = recres.getResourceFilter();
                if (null != recres && null != pfil) {
                    pfil.setXml(SWBUtils.XML.domToXml(docxmlConf));
                }
                Document docresp = SWBUtils.XML.getNewDocument();
                Element filterresp = docresp.createElement("filter");
                org.w3c.dom.Text t = docresp.createTextNode(id);
                filterresp.appendChild(t);
                docresp.appendChild(filterresp);
                return docresp;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                log.error(e);
            }
        }
        return null;
    }
    
    private void initializeResourceFilter(Resource res) {
        ResourceFilter rf = res.getResourceFilter();
        String strXml = null;
        
        //Create resourcefilter if not already created
        if (null == rf) {
            rf = res.getWebSite().createResourceFilter();
            res.setResourceFilter(rf);
        }
        
        strXml = rf.getXml();
        if (null == strXml || (strXml != null && strXml.isEmpty())) {
            rf.setXml("<resource><filter/></resource>");
        }
    }

    /**
     * Do view.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String jsp = "/swbadmin/jsp/SWBAResourceFilter/edit.jsp";
        
        //Initialize resourceFilter data
        SemanticObject obj = SWBPlatform.getSemanticMgr().getOntology().getSemanticObject(request.getParameter("suri"));
        if (null != obj && obj.instanceOf(Resource.sclass)) {
            initializeResourceFilter((Resource)obj.createGenericInstance());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException sex) {
            log.error("SWBAFilters - Error including view", sex);
        }
    }

    /**
     * Process action.
     * 
     * @param request the request
     * @param response the response
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        //String strWBAction=request.getParameter("act");
        //System.out.println("Llego aqui");
        String tm = request.getParameter("tm");
        String[] strTopics = request.getParameterValues("tps");
        Document dom = null;
        Element elmRes = null;
        String id = "0";
        if (request.getParameter("id") != null) {
            id = request.getParameter("id");
        }
        Resource recRes = SWBContext.getWebSite(tm).getResource(id);
        ResourceFilter pfil = recRes.getResourceFilter();
        String strXml = null;
        if (null != pfil) {
            strXml = pfil.getXml();
        }
        // Se genera el XML
        if (strXml == null || strXml != null && strXml.equals("")) {
            try {

                dom = SWBUtils.XML.getNewDocument();
                elmRes = dom.createElement("resource");
                dom.appendChild(elmRes);
                Element filter = dom.createElement("filter");
                elmRes.appendChild(filter);
                String strTm = null;
                String strTp = null;
                if (strTopics != null) {
                    for (int counter = 0; counter < strTopics.length; counter++) {
                        StringTokenizer st = new StringTokenizer(strTopics[counter], "|");
                        while (st.hasMoreTokens()) {
                            strTm = st.nextToken();
                            strTp = st.nextToken();
                        }
                        dom = setElement(dom, strTm, strTp, "add");
                    }
                }
                pfil.setXml(SWBUtils.XML.domToXml(dom));
                response.setRenderParameter("confirm", "added");
            } catch (Exception e) {
                log.error("Error while updating resource with id:" + id + "- SWBAFilterResource:processAction", e);
            }
        } else {
            try {
                int intIniIdx = strXml.indexOf("<filter>");
                int intEndIdx = strXml.lastIndexOf("</filter>");
                if (intIniIdx != -1 && intEndIdx != -1) {
                    strXml = strXml.substring(intIniIdx,intEndIdx + 9);
                }
                dom = SWBUtils.XML.xmlToDom(strXml);
                elmRes = (Element) dom.getFirstChild();
                String strTm = null;
                String strTp = null;
                if (strTopics != null) {
                    for (int counter = 0; counter < strTopics.length; counter++) {
                        StringTokenizer st = new StringTokenizer(strTopics[counter], "|");
                        while (st.hasMoreTokens()) {
                            strTm = st.nextToken();
                            strTp = st.nextToken();
                        }
                        dom = setElement(dom, strTm, strTp, "update");
                    }
                }
                pfil = recRes.getWebSite().createResourceFilter();
                pfil.setXml(SWBUtils.XML.domToXml(dom));
                recRes.setResourceFilter(pfil);
                response.setRenderParameter("confirm", "added");
            } catch (Exception e) {
                log.error("Error while updating resource with id:" + id + "- SWBAFilterResource:processAction", e);
            }
        }
        response.setRenderParameter("id", id);
        response.setRenderParameter("suri", id);
        response.setRenderParameter("tm", tm);
        //System.out.println("Lo guardo");
    }

    /**
     * Sets the element.
     * 
     * @param dom the dom
     * @param tm the tm
     * @param tp the tp
     * @param action the action
     * @return the document
     */
    private Document setElement(Document dom, String tm, String tp, String action) {
        Element res = null;
        Element eTm = null;
        Element eTp = null;
        if (action != null && action.equals("add")) {
            NodeList nodelist = dom.getFirstChild().getChildNodes();
            for (int i = 0; i < nodelist.getLength(); i++) {
                if (nodelist.item(i).getNodeName().equals("filter")) {
                    res = (Element) nodelist.item(i);
                    eTm = dom.createElement("topicmap");
                    eTm.setAttribute("id", tm);
                    res.appendChild(eTm);
                    eTp = dom.createElement("topic");
                    eTp.setAttribute("id", tp);
                    eTp.setAttribute("childs", "true");
                    eTm.appendChild(eTp);
                }
            }
        } else if (action != null && action.equals("update")) {
            res = (Element) dom.getFirstChild();
            Element filter = dom.createElement("filter");
            res.appendChild(filter);
            eTm = dom.createElement("topicmap");
            eTm.setAttribute("id", tm);
            filter.appendChild(eTm);
            eTp = dom.createElement("topic");
            eTp.setAttribute("id", tp);
            eTp.setAttribute("childs", "true");
            eTm.appendChild(eTp);
        }
        return dom;
    }      
}
