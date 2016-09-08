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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.w3c.dom.*;

import javax.servlet.http.*;
import javax.servlet.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.*;

import org.semanticwb.model.*;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.*;

/** Recurso para la administración de WebBuilder que permite seleccionar las páginas Web
 *  en los cuales se mostrará el recurso seleccionado.
 *
 * Admin resource that enables to select the Web pages on which the selected resource will be displayed.
 * @author Juan Fernández
 * @author Javier Solís
 * @author Hasdai Pacheco {ebenezer.sanchez@infotec.mx}
 */
public class SWBAFilterResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(SWBAFilterResource.class);
    
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
    
    /**
     * Crea un objeto JSON con las propiedades proporcionadas.
     * <p>
     * Creates a JSON object with the given properties.
     * @param id ID del objeto
     * @param name Nombre del objeto
     * @param negative Atributo negative "true" / "false"
     * @param childs Atributo childs "true" / "false"
     * @return Objeto JSON con las propiedades existentes.
     * @throws JSONException 
     */
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
    
    /**
     * Obtiene un objeto JSON con la estructura de páginas de un sitio.
     * @param root Raíz para el recorrido en el árbol de páginas.
     * @param parentuid ID del padre del nodo actual.
     * @param pages JSONArray donde se guardarán los resultados del recorrido.
     * @param lang Idioma del usuario
     * @throws JSONException 
     */
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
    
    /**
     * Concila la información contenida en la configuración del filtro con la del despliegue en la vista de árbol.
     * <p>
     * Reconciles filter and tree data for the resource view.
     * @param filter ResourceFilter
     * @param pages Lista de páginas Web para el despliegue en el árbol
     * @return Objeto JSON con información del filtro conciliada.
     * @throws JSONException 
     */
    private JSONObject getMergedFilter(ResourceFilter filter, JSONArray pages) throws JSONException {
        JSONObject filterData = getJSONFilter(filter);
        HashMap<String, JSONObject> objTable = new HashMap<>();
        JSONArray src = filterData.optJSONArray("topics");
        JSONArray paths = new JSONArray();
        
        if (null != pages) {
            if (null != src) {
                for (int i = 0; i < src.length(); i++) {
                    JSONObject item = src.getJSONObject(i);
                    objTable.put(item.getString("id"), item);
                }
            }
            
            for (int i = 0; i < pages.length(); i++) {
                JSONObject item = pages.getJSONObject(i);
                String key = item.getString("id");
                if (objTable.containsKey(key)) {
                    JSONObject obj = objTable.get(key);
                    item.put("selected", true);
                    item.put("childs", obj.optBoolean("childs", false));
                    paths.put(item.getString("uuid"));
                }
            }
            
            //Put modelId in filter object if not present (empty filter)
            if (null == filterData.optString("id", null)) filterData.put("id", filter.getWebSite().getId());
            
            //Put paths
            filterData.put("paths", paths);
            
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
    
    /**
     * Método para invocaciones a servicios del recurso.
     * <p>
     * Method for resource services invocation.
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException 
     */
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
                } catch (JSONException jsex) {
                    log.error("Error al generar JSON del componente", jsex);
                }
            }
            ret = _ret.toString();
        }
        out.print(ret);
    }
    
    /**
     * Obtiene un arreglo de objetos JSON con los hijos de un nodo XML. 
     * Cada hijo contiene los atributos correspondientes, de acuerdo al XML.
     * Un ejemplo de la estructura del JSON es como sigue:
     * <p>
     * {
     *   uuid: "7fa05029-252e-4b44-9dff-b4901920c984", //Usado como identificador para el árbol, útil sólo para la UI
     *   id: "demo", //Identificador del objeto asociado
     *   name: "demo", //Nombre del nodo, útil sólo para la UI
     *   parent: "cc554cdc-7c7f-48c6-92d1-a85c1861f613", //UID del nodo padre, útil sólo para la UI
     *   selected: true //Indica si el nodo aparece en la configuración del filtro y debe ser activado en el UI
     *   enabled: true //Indica si el nodo estará habilitado en la UI
     *   childs: true //Indica si los hijos del nodo estarán habilidados
     *   negative: true //Para el filtro indica si la configuración se aplica a los elementos no seleccionados en el UI
     * }
     * <p>
     * Transforms an XML tree into a list of JSONObjects.
     * Sample JSON structure is as follows:
     * <p>
     * {
     *   uuid: "7fa05029-252e-4b44-9dff-b4901920c984", //Unique IDfor the UI Tree
     *   id: "demo", //Related object ID, used for validations
     *   name: "demo", //Node name for the UI Tree
     *   parent: "cc554cdc-7c7f-48c6-92d1-a85c1861f613", //Parent node UID for UI Tree
     *   selected: true //Whether the filter is in configuration and must be checked at start
     *   enabled: true //Whether the node is enabled in UI
     *   childs: true //Whether node childs must be selected or disabled in UI
     *   negative: true //For a filter it sets the rule to non-selected nodes
     * 
     * }
     * <p>
     * @param nodeName Nombre del tag de los nodos hijos.
     * @param root Elemento raíz a partir del cual obtener los hijos.
     * @return Arreglo con objetos JSON para cada hijo llamado "nodeName" del nodo "root".
     * @throws JSONException 
     */
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
    
    
    /**
     * Obtiene la configuración del filtro en formato JSON para su conciliación con los datos para el árbol.
     * <p>
     * Gets filter configuration for data reconciliation.
     * @param rf Filtro de administración.
     * @return Objeto JSON con la configuración del filtro.
     */
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

                        ret = createNodeObject(id, null, negative, null);
                        ret.put("topics", getNodeElements("topic", root));
                    }
                }
            }
        }
        return ret;
    }
    
    /**
     * Inicializa la información del filtro en el recurso, si éste no existe, es creado
     * @param res Recurso al que se asociará el filtro
     */
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
     * Transforma los datos del árbol de filtro de recurso a formato XML para su almacenamiento en el objeto.
     * @param treeData JSON con la selección de nodos en el árbol de la vista.
     * @return Cadena XML que representa la configuración del árbol a escribir en el objeto del filtro.
     */
    private String getXMLFilterData(JSONObject treeData) throws JSONException {
        Document ret = SWBUtils.XML.xmlToDom("<resource><filter></filter></resource>");
        
        //Get root node
        Element root = (Element) ret.getElementsByTagName("filter").item(0);
        String tmId = treeData.optString("siteId", null);
        JSONArray nodes = treeData.optJSONArray("topics");
        
        if (null != tmId && !tmId.isEmpty() && null != nodes) {
            Element tm = ret.createElement("topicmap");
            tm.setAttribute("id", tmId);
            tm.setAttribute("negative", treeData.optBoolean("negative", false) == true ? "true" : "false");
            
            //Add filtered pages
            if (null != nodes) {
                for (int i = 0; i < nodes.length(); i++) {
                    JSONObject node = nodes.getJSONObject(i);
                    boolean hasChilds = node.optBoolean("childs", false);
                    String id = node.optString("id", null);
                    
                    if (null != id && !id.isEmpty()) {
                        Element ele = ret.createElement("topic");
                        ele.setAttribute("id", id);
                        ele.setAttribute("childs", hasChilds ? "true" : "false");
                        tm.appendChild(ele);
                    }
                }
            }
            
            root.appendChild(tm);
        }
        
        return SWBUtils.XML.domToXml(ret);
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
        String action = response.getAction();
        
        if ("updateFilter".equals(action)) { //Update filter
            //Se recibe el JSON con los nodos seleccionados en la vista.
            BufferedReader reader = request.getReader();
            String line = null;
            StringBuilder body = new StringBuilder();
            while((line = reader.readLine()) != null) {
                body.append(line);
            }
            reader.close();
            
            //Se transforma el JSON de la petición a XML y se guarda en el objeto del filtro
            String res = null;
            try {
                JSONObject payload = new JSONObject(body.toString());
                WebSite site = WebSite.ClassMgr.getWebSite(payload.optString("siteId"));
                if (null != site) {
                    ResourceFilter filter = ResourceFilter.ClassMgr.getResourceFilter(payload.optString("id"), site);
                    if (null != filter) {
                        res = getXMLFilterData(payload);
                        filter.setXml(res);
                    }
                }
            } catch (JSONException jsex) {
                log.error("Error getting response body", jsex);
            }

            if (null != request.getParameter("suri")) {
                response.setRenderParameter("suri", request.getParameter("suri"));
            }
        } else {
            super.processAction(request, response);
        }
    }
}
