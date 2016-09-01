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
import java.util.ArrayList;
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

/** Recurso para la administarción de WebBuilder que permite seleccionar las páginas Web
 * en las cuales se mostrará el recurso seleccionado.
 *<p>
 * Admin resource to enable the selection of Web pages on which the resource should be displayed.
 * @author Juan Fernández
 * @author Javier Solís
 * @author Hasdai Pacheco {ebenezer.sanchez@infotec.mx}
 */
public class SWBAUserFilter extends GenericAdmResource {
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
     * Obtiene un objeto JSON con la estructura de páginas de los sitios disponibles para el filtro de usuario.
     * @param user Usuario
     * @param pages JSONArray donde se guardarán los resultados del recorrido
     * @throws JSONException
     */
    private void getWebPagesJSON(User user, JSONArray pages) throws JSONException {
        if (null == user || null == pages) return;
        UserRepository urep = user.getUserRepository();
        String lang = user.getLanguage();
        if (null == lang) lang = "es";
        
        boolean addAll = true;
        Iterator<WebSite> sites = SWBContext.listWebSites();
        while (sites.hasNext() && addAll) {
            WebSite next = sites.next();
            if (urep.getURI().equals(next.getUserRepository().getURI())) {
                addAll = false;
            }
        }
        
        sites = addAll ? SWBContext.listWebSites() : SWBContext.listWebSites(false);
        JSONObject server = createNodeObject("Server", "Server", null, null);
        server.put("cssIcon", "swbIconServer");
        pages.put(server);
        
        while (sites.hasNext()) {
            WebSite site = sites.next();
            if (addAll || (!addAll && urep.getURI().equals(site.getUserRepository().getURI()))) {
                if (!SWBContext.getGlobalWebSite().getURI().equals(site.getURI())) {
                    JSONObject obj = createNodeObject(site.getId(), site.getDisplayTitle(lang), null, null);

                    obj.put("cssIcon", site.isActive() ? "swbIconWebSite" : "swbIconWebSiteU");
                    obj.put("parent", server.getString("uuid"));
                    obj.put("type", "website");
                    pages.put(obj);

                    getWebPagesJSON(site.getHomePage(), obj.getString("uuid"), pages, lang, true);
                }
            }
        }
    }
    
    /**
     * Obtiene un objeto JSON con la estructura de páginas de los sitios disponibles para el repositorio proporcionado.
     * @param urep Repositorio de usuarios para obtener la información.
     * @param pages JSONArray donde se guardarán los resultados del recorrido
     * @param lang Idioma para recuperar la información.
     * @throws JSONException
     */
    private void getWebPagesJSON(UserRepository urep, JSONArray pages, String lang) throws JSONException {        
        boolean addAll = true;
        Iterator<WebSite> sites = SWBContext.listWebSites();
        while (sites.hasNext() && addAll) {
            WebSite next = sites.next();
            if (urep.getURI().equals(next.getUserRepository().getURI())) {
                addAll = false;
            }
        }
        
        sites = addAll ? SWBContext.listWebSites() : SWBContext.listWebSites(false);
        JSONObject server = createNodeObject("Server", "Server", null, null);
        server.put("cssIcon", "swbIconServer");
        pages.put(server);
        
        while (sites.hasNext()) {
            WebSite site = sites.next();
            if (addAll || (!addAll && urep.getURI().equals(site.getUserRepository().getURI()))) {
                if (!SWBContext.getGlobalWebSite().getURI().equals(site.getURI())) {
                    JSONObject obj = createNodeObject(site.getId(), site.getDisplayTitle(lang), null, null);

                    obj.put("cssIcon", site.isActive() ? "swbIconWebSite" : "swbIconWebSiteU");
                    obj.put("parent", server.getString("uuid"));
                    obj.put("type", "website");
                    pages.put(obj);

                    getWebPagesJSON(site.getHomePage(), obj.getString("uuid"), pages, lang, true);
                }
            }
        }
    }
    
    /**
     * Obtiene un objeto JSON con la estructura de páginas de un sitio.
     * @param root Raíz para el recorrido en el árbol de páginas
     * @param parentuid ID del padre del nodo actual
     * @param pages JSONArray donde se guardarán los resultados del recorrido
     * @param lang Idioma del usuario
     * @param isHome Indica si la raíz es la página principal del sitio
     * @throws JSONException 
     */
    private void getWebPagesJSON(WebPage root, String parentuid, JSONArray pages, String lang, boolean isHome) throws JSONException {
        if (null != root && null != pages) {
            JSONObject pg = createNodeObject(root.getId(), root.getDisplayTitle(lang), null, null);
            pg.put("cssIcon", isHome ? root.isActive() ? "swbIconHomePage" : "swbIconHomePageU" : root.isActive() ? "swbIconWebPage" : "swbIconWebPageU");
            pg.put("topicmap", root.getWebSiteId());
            if (null != parentuid && !parentuid.isEmpty()) {
                pg.put("parent", parentuid);
            }
            pages.put(pg);
            
            Iterator<WebPage> childs = SWBComparator.sortSortableObjectSet(root.listChilds()).iterator();
            while (childs.hasNext()) {
                WebPage child = childs.next();
                getWebPagesJSON(child, pg.getString("uuid"), pages, lang, false);
            }
        }
    }
    
    /**
     * Concila la información contenida en la configuración del filtro de usuario con la del despliegue en la vista de árbol.
     * <p>
     * Reconciles filter and tree data for the resource view.
     * @param user Usuario
     * @param pages Lista de páginas Web para el despliegue en el árbol
     * @return Objeto JSON con información del filtro conciliada
     * @throws JSONException 
     */
    private JSONObject getMergedFilter(User user, JSONArray pages) throws JSONException {
        HashMap<String, JSONObject> objTable = new HashMap<>();
        JSONArray paths = new JSONArray();
        JSONObject filterData = new JSONObject();
        
        if (null != user) {
            UserFilter filter = user.getUserFilter();
            filterData = getJSONFilter(filter);
            JSONArray src = filterData.optJSONArray("topics");
            
            if (null != src) {
                for (int i = 0; i < src.length(); i++) {
                    JSONObject item = src.getJSONObject(i);
                    String id = item.getString("id");
                    String tmap = item.optString("topicmap", "");
                    objTable.put(tmap+"|"+id, item);
                }
            }
        }
        
        if (null != pages) {
            for (int i = 0; i < pages.length(); i++) {
                JSONObject item = pages.getJSONObject(i);
                String key = item.getString("id");
                String map = item.optString("topicmap", "");
                if (objTable.containsKey(map+"|"+key)) {
                    JSONObject obj = objTable.get(map+"|"+key);
                    item.put("selected", true);
                    item.put("childs", obj.optBoolean("childs", false));
                    paths.put(item.getString("uuid"));
                }
            }
                        
            //Put paths
            filterData.put("paths", paths);
            filterData.put("topics", pages);
            filterData.put("sitesRoot", pages.getJSONObject(0).getString("uuid"));
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
        String ret = "{}";
        String action = paramRequest.getAction();
        String lang = "es";
        if (null != paramRequest.getUser() && null != paramRequest.getUser().getLanguage()) lang = paramRequest.getUser().getLanguage();
        
        if ("getFilter".equals(action)) {
            JSONObject _ret = new JSONObject();
            GenericObject gobj = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
            if (null != gobj) {
                JSONArray pages = new JSONArray();
                if (gobj instanceof User && null != ((User)gobj).getUserFilter()) {
                    try {
                        getWebPagesJSON((User)gobj, pages);
                        _ret = getMergedFilter((User)gobj, pages);
                    } catch (JSONException jsex) {
                        log.error("Error al generar JSON del componente", jsex);
                    }
                } else if (gobj instanceof UserRepository) {
                    try {

                        getWebPagesJSON((UserRepository)gobj, pages, lang);
                        _ret = getMergedFilter(null, pages);
                    } catch (JSONException jsex) {
                        log.error("Error al generar JSON del componente", jsex);
                    }
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
     * Gets filter configuration for data conciliation.
     * @param rf Filtro de usuario.
     * @return Objeto JSON con la configuración del filtro.
     */
    private JSONObject getJSONFilter(UserFilter rf) throws JSONException {
        JSONObject ret = new JSONObject();
        String xml = rf.getXml();
        if (null != xml && !xml.isEmpty()) {
            Document dom = SWBUtils.XML.xmlToDom(xml);
            if (dom.getElementsByTagName("resource").getLength() > 0) {
                Element root = (Element) dom.getElementsByTagName("resource").item(0);
                
                if (root.getElementsByTagName("filter").getLength() > 0) {
                    root = (Element) dom.getElementsByTagName("filter").item(0);
                    
                    NodeList tmaps = root.getElementsByTagName("topicmap");
                    if (null != tmaps && tmaps.getLength() > 0) {
                        JSONArray topics = new JSONArray();
                        ret.put("topics", topics);
                        
                        //Process topicmaps
                        for (int i = 0; i < tmaps.getLength(); i++) {
                            root = (Element) tmaps.item(i);
                            String id = root.getAttribute("id");
                            
                            if (i == 0) {
                                String negative = root.getAttribute("negative");
                                if (!negative.isEmpty()) ret.put("negative", negative.equalsIgnoreCase("true"));
                            }
                            
                            //Add topics
                            JSONArray childs = getNodeElements("topic", root); 
                            for (int j = 0; j < childs.length(); j++) {
                                JSONObject topic = childs.getJSONObject(j);
                                topic.put("topicmap", id);
                                topics.put(topic);
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
    
    /**
     * Inicializa la información del filtro en el usuario, si éste no existe, es creado
     * @param usr Usuario al que se asociará el filtro
     */
    private void initializeUserFilter(User usr) {
        UserFilter rf = usr.getUserFilter();
        String strXml = null;
        
        //Create userfilter if not already created
        if (null == rf) {
            rf = UserFilter.ClassMgr.createUserFilter(usr.getUserRepository());
            usr.setUserFilter(rf);
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
        String action = paramRequest.getAction();
        boolean isMultiple = Boolean.valueOf(getResourceBase().getAttribute("multiple", "false"));
        String jsp = "/swbadmin/jsp/SWBAResourceFilter/edit.jsp";
        
        if (isMultiple) {
            jsp = "editFilter".equals(action) ? "/swbadmin/jsp/SWBAResourceFilter/edit.jsp" : "/swbadmin/jsp/SWBAResourceFilter/searchUser.jsp";
        }
        
        //Initialize userFilter data
        SemanticObject obj = SWBPlatform.getSemanticMgr().getOntology().getSemanticObject(request.getParameter("suri"));
        if (null != obj && obj.instanceOf(User.sclass)) {
            initializeUserFilter((User)obj.createGenericInstance());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException sex) {
            log.error("SWBAUserFilters - Error including view", sex);
        }
    }
    
    /**
     * Transforma los datos del árbol de filtro de usuario a formato XML para su almacenamiento en el objeto.
     * @param treeData JSON con la selección de nodos en el árbol de la vista.
     * @return Cadena XML que representa la configuración del árbol a escribir en el objeto del filtro.
     */
    private String getXMLFilterData(JSONObject treeData) throws JSONException {
        Document ret = SWBUtils.XML.xmlToDom("<resource><filter></filter></resource>");
        String negative = treeData.optString("negative", "false");
                
        //Get root node
        Element root = (Element) ret.getElementsByTagName("filter").item(0);
        HashMap<String, Element> tmaps = new HashMap<>();
        
        //Add filtered pages
        JSONArray nodes = treeData.optJSONArray("topics");
        if (null != nodes) {
            //get all nodes
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                String tmap = node.optString("topicmap", null);
                
                if (null != tmap) { //All webpage nodes must contain topicmap key and value
                    Element topicmap = tmaps.get(tmap);
                    
                    if (null == topicmap) { //Create topicmap element if not already created
                        topicmap = ret.createElement("topicmap");
                        topicmap.setAttribute("id", tmap);
                        topicmap.setAttribute("negative", negative);
                        root.appendChild(topicmap);

                        //Add topicmap to hash table
                        tmaps.put(tmap, topicmap);
                    }

                    //Create topic element
                    Element topic = ret.createElement("topic");
                    topic.setAttribute("id", node.getString("id"));
                    
                    boolean hasChilds = node.optBoolean("childs", false);
                    topic.setAttribute("childs", hasChilds ? "true" : "false");
                    topicmap.appendChild(topic);
                    
                    root.appendChild(topicmap);
                }
            }
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
                GenericObject gobj = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
                res = getXMLFilterData(payload);
                
                if (null != gobj) {
                    if (gobj instanceof User && null != ((User)gobj).getUserFilter()) { //Specific User filter assignment
                        UserFilter uf = ((User)gobj).getUserFilter();
                        uf.setXml(res);
                    } else if (gobj instanceof UserRepository && Boolean.valueOf(getResourceBase().getAttribute("multiple", "false"))) { //Multiple userilfer assignment
                        UserRepository urep = (UserRepository) gobj;
                        String userIds = request.getParameter("ids");
                        if (null != userIds && !userIds.isEmpty()) {
                            ArrayList<User> users = new ArrayList<>();
                            if (userIds.contains("|")) {
                                String []ids = userIds.split("\\|");
                                for (String id : ids) {
                                    User user = urep.getUser(id);
                                    if (null != user) users.add(user);
                                }
                            } else {
                                User user = urep.getUser(userIds);
                                if (null != user) users.add(user);
                            }
                            
                            for (User user: users) {
                                initializeUserFilter(user);
                                UserFilter uf = user.getUserFilter();
                                uf.setXml(res);
                            }
                        }
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