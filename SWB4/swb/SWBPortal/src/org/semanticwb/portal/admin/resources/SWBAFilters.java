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

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Activeable;

import org.semanticwb.model.AdminFilter;
import org.semanticwb.model.FilterableClass;
import org.semanticwb.model.FilterableNode;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.HerarquicalNode;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SWBObjectFilter;
import org.semanticwb.platform.SemanticClass;

import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 * Recurso de administración de SemanticWebBuilder que permite agregar filtros,
 * editarlos, actualizarlos o eliminarlos según sea el caso.
 *<p>
 * SemanticWebBuilder resource for the administration of user filters.
 *
 * @author Victor Lorenzana
 * @author Hasdai Pacheco {ebenezer.sanchez@infotec.mx}
 * @since 4.0.0
 */
public class SWBAFilters extends GenericResource {
    /**
     * The log.
     */
    private final Logger log = SWBUtils.getLogger(SWBAFilters.class);
    static final String [] actions = {AdminFilter.ACTION_ADD, AdminFilter.ACTION_EDIT, AdminFilter.ACTION_DELETE};

    /**
     * Creates a new instance of WBAFilters.
     */
    public SWBAFilters() {}

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        AdminFilter af = AdminFilter.ClassMgr.getAdminFilter(request.getParameter("id"), SWBContext.getAdminRepository());
        
        if (SWBResourceURL.Action_REMOVE.equals(action)) { //Delete filter
            if (null != af) {
                request.getSession().setAttribute("removedId", af.getURI());
                af.remove();
            }
            if (null != request.getParameter("suri")) {
                response.setRenderParameter("suri", request.getParameter("suri"));
            }
        } else if ("updateFilter".equals(action)) { //Update filter
            if (null != af) {
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
                    res = getXMLFilterData(payload);
                } catch (JSONException jsex) {
                    log.error("Error getting response body", jsex);
                }

                if (null != res) af.setXml(res);
                if (null != request.getParameter("suri")) {
                    response.setRenderParameter("suri", request.getParameter("suri"));
                }
            }
        } else {
            super.processAction(request, response);
        }
    }
    
    /**
     * Obtiene una cadena de internacionalización del bundle del recurso.
     *<p>
     * Gets a locale string from the resource bundle.
     * @param key the key
     * @param lang the lang
     * @return the locale string
     */
    public String getLocaleString(String key, String lang) {
        if (null == lang|| lang.isEmpty()) return SWBUtils.TEXT.getLocaleString("locale_swb_admin", key);
        return SWBUtils.TEXT.getLocaleString("locale_swb_admin", key, new Locale(lang));
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equals("gateway"))
        {
            doGateway(request, response, paramRequest);
        } else 
        {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    /**
     * Crea un objeto JSON con las propiedades proporcionadas.
     * <p>
     * Creates a JSON object with the given properties.
     * @param id ID del objeto
     * @param name Nombre del objeto
     * @param reload Atributo reload del objeto
     * @param parent Padre del objeto en el árbol
     * @return Objeto JSON con las propiedades especificadas.
     * @throws JSONException 
     */
    private JSONObject createNodeObject(String id, String name, String reload, String parent) throws JSONException {
        JSONObject ret = new JSONObject();
        
        ret.put(TreenodeFields.UID, UUID.randomUUID().toString());
        ret.put(TreenodeFields.ENABLED, true);
        if (null != id && !id.isEmpty()) ret.put(TreenodeFields.ID, id);
        if (null != name && !name.isEmpty()) ret.put(TreenodeFields.NAME, name);
        if (null != reload && !reload.isEmpty()) ret.put(TreenodeFields.RELOAD, reload);
        if (null != parent && !parent.isEmpty()) ret.put(TreenodeFields.PARENT, parent);
        return ret;
    }
    
    /**
     * Agrega un nodo semántico a los datos del árbol
     * @param ret ArrayList con los resultados
     * @param obj Objeto a agregar
     * @param user Usuario
     * @param root Objeto raíz para mantener jerarquía
     * @param addChilds No se usa, se sobreeescribe en el método
     * @throws JSONException 
     */
    protected void addSemanticObject(ArrayList<JSONObject> ret, SemanticObject obj, User user, JSONObject root, boolean addChilds) throws JSONException {
        addChilds = true;
        boolean hasChilds = false;
        JSONObject jobj = createNodeObject(obj.getURI(), obj.getDisplayName(user.getLanguage()), "getSemanticObject."+obj.getURI(), root.getString(TreenodeFields.UID));
        jobj.put(TreenodeFields.PATH, root.get(TreenodeFields.PATH)+"|"+obj.getURI());
        ret.add(jobj);

        hasChilds = obj.getSemanticClass().listHerarquicalNodes().hasNext();
        if (addChilds || !hasChilds) {
            addHierarchicalNodes(ret, obj, user, jobj);

            if (addChilds) {
                Iterator<SemanticObject> it = SWBComparator.sortSemanticObjects(user.getLanguage(), obj.listHerarquicalChilds());
                while (it.hasNext()) {
                    SemanticObject ch = it.next();
                    if (ch.instanceOf(FilterableNode.swb_FilterableNode)) {
                        addSemanticObject(ret, ch, user, jobj, false);
                    }
                }
            }
        }
    }
    
    /**
     * Agrega un nodo jerárquico a los datos del árbol.
     * @param ret ArrayList con los resultados
     * @param node Nodo jerárquico
     * @param obj Objeto semántico de referencia del modelo (WebSite)
     * @param user Usuario
     * @param root Objeto raíz para mantener la jerarquía
     * @throws JSONException 
     */
    private void addHerarquicalNode(ArrayList<JSONObject> ret, HerarquicalNode node, SemanticObject obj, User user, JSONObject root) throws JSONException {
        SemanticClass cls = null;
        String pf = node.getPropertyFilter();
        if (node.getHClass() != null) cls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(node.getHClass().getURI());
        
        JSONObject hnode = createNodeObject(node.getURI(), node.getDisplayTitle(user.getLanguage()), "getSemanticObject.HN|" + obj.getURI() + "|" + node.getURI(), root.getString(TreenodeFields.UID));
        hnode.put(TreenodeFields.PATH, root.get(TreenodeFields.PATH)+"|"+node.getURI());
        ret.add(hnode);

        //Si tiene clase, debe tener instancias abajo
        if (cls != null && cls.isSubClass(FilterableNode.swb_FilterableNode)) {
            Iterator<SemanticObject> it = SWBObjectFilter.filter(SWBComparator.sortSemanticObjects(user.getLanguage(), obj.getModel().listInstancesOfClass(cls)), pf);
            while (it.hasNext()) {
                SemanticObject so = it.next();
                addSemanticObject(ret, so, user, hnode, false);
            }
        }

        //Si no tiene clase es un nodo intermedio
        if (cls == null) {
            Iterator<HerarquicalNode> it = node.listHerarquicalNodes();
            while (it.hasNext()) {
                HerarquicalNode node2 = it.next();
                addHerarquicalNode(ret, node2, obj, user, hnode);
            }
        }
    }
    
    /**
     * Agrega los nodos jerárquicos de un sitio Web.
     * @param ret ArrayList con los resultados
     * @param obj SemanticObject del sitio Web
     * @param user Usuario
     * @param root Objeto raíz para mantener jerarquía
     * @throws JSONException 
     */
    private void addHierarchicalNodes(ArrayList<JSONObject> ret, SemanticObject obj, User user, JSONObject root) throws JSONException {
        Iterator<SemanticObject> it = SWBComparator.sortSortableObject(obj.getSemanticClass().listHerarquicalNodes());
        while (it.hasNext()) {
            HerarquicalNode node = new HerarquicalNode(it.next());
            addHerarquicalNode(ret, node, obj, user, root);
        }
    }
    
    /**
     * Agrega un objeto semántico a los datos del árbol para configuración del filtro.
     * @param ret ArrayList con los datos resultantes
     * @param obj SemanticObject
     * @param user Usuario
     * @param root Nodo raíz para mantener la jerarquía
     * @throws JSONException 
     */
    private void addSemanticObjectFilter(ArrayList<JSONObject> ret, SemanticObject obj, User user, JSONObject root) throws JSONException {
        JSONObject node = createNodeObject(obj.getURI(), obj.getDisplayName(user.getLanguage()), "getSemanticObject."+obj.getURI(), root.getString(TreenodeFields.UID));
        node.put(TreenodeFields.PATH,root.get(TreenodeFields.PATH)+"|"+obj.getURI());
        ret.add(node);
        if (obj.getSemanticClass().listHerarquicalNodes().hasNext()) {
            addHierarchicalNodes(ret, obj, user, node);
        }
        
        if (obj.instanceOf(WebSite.sclass)) {
            //Agrega todos los nodos hijos
            Iterator<SemanticObject> it = SWBComparator.sortSemanticObjects(user.getLanguage(), obj.listHerarquicalChilds());
            while (it.hasNext()) {
                SemanticObject ch = it.next();
                if (ch.instanceOf(FilterableNode.swb_FilterableNode)) {
                    addSemanticObjectFilter(ret, ch, user, node);
                }
            }
        }
        
        if (obj.instanceOf(WebPage.sclass)) {
            //Agregar webpages
            JSONArray pages = getWebPageChilds(node, user, false, true);
            for (int i = 0; i < pages.length(); i++) {
                ret.add(pages.getJSONObject(i));
            }
        }
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Filtros sobre sitios del recurso.
     * <p>
     * Gets the JSON data for the Site Filters tab.
     * @param user Usuario que solicita los datos, sobre el cual se validará acceso.
     */
    private JSONArray getServerJSON(User user) throws JSONException {
        //Si crees en Dios, pide que se apiade de quien tenga que mantener este método y los métodos que llama
        JSONArray ret = new JSONArray();
        
        //Add server node
        JSONObject server = createNodeObject("server", "Server", "getServer", null);
        server.put(TreenodeFields.ACCESS, 2);
        server.put(TreenodeFields.PATH, "server");
        ret.put(server);

        //Add websites
        ArrayList<JSONObject> elements = new ArrayList<>();
        Iterator<WebSite> it = SWBComparator.sortSortableObject(SWBContext.listWebSites());
        while (it.hasNext()) {
            WebSite site = it.next();
            if (!site.isDeleted()) {
                addSemanticObjectFilter(elements, site.getSemanticObject(), user, server);
            }
        }

        //Add user repositories
        Iterator<UserRepository> it2 = SWBContext.listUserRepositories();
        while (it2.hasNext()) {
            UserRepository urep = it2.next();
            if (urep.getParentWebSite() == null) {
                addSemanticObjectFilter(elements, urep.getSemanticObject(), user, server);
            }
        }
        
        for (JSONObject o : elements) {
            ret.put(o);
        }

        return ret;
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Documentos del Servidor del recurso.
     * Los datos provienen de la lista de carpetas de la ruta de la aplicación.
     * <p>
     * Gets the JSON data for the Server Documents tab.
     * @param ret Arreglo de objetos JSON con el resultado del recorrido por las carpetas.
     * @param root Directorio que será la raíz del recorrido.
     * @param parentUID UUID del directorio padre para conservar jerarquía en el árbol de la vista.
     */
    private void getDirectoriesJSON(JSONArray ret, File root, String parentUID) throws JSONException {
        if (null != root && root.exists()) { //Verifica que el archivo existe
            if (root.isDirectory()) { //Sólo se listan directorios
                String appPath = SWBUtils.getApplicationPath(); //App path. i.e. /Users/xxx/apache-tomcat/webapps/ROOT
                String rootPath = appPath;
                //Normalize path separator (Windows problem)
                String dirPath = SWBUtils.IO.normalizePath(root.getAbsolutePath());
                
                if (rootPath.endsWith("/")) rootPath = rootPath.substring(0, rootPath.length() - 1); //Trim trailing slash
                if (appPath.endsWith("/")) appPath = appPath.substring(0, appPath.length() - 1); //Trim trailing slash
                if (rootPath.equals(dirPath)) { //App root folder
                    rootPath = rootPath.substring(rootPath.lastIndexOf("/")+1, rootPath.length()); //App folder name
                    JSONObject obj = createNodeObject("/", rootPath, null, null);
                    obj.put(TreenodeFields.PATH, "/");
                    ret.put(obj);
                    parentUID = obj.getString(TreenodeFields.UID);
                }

                File [] childs = root.listFiles();
                for (File f : childs) {
                    if (f.isDirectory()) {
                        String path = SWBUtils.IO.normalizePath(f.getAbsolutePath()).substring(appPath.length()); //Remove part of app path

                        JSONObject obj = createNodeObject(path, f.getName(), null, parentUID);
                        obj.put(TreenodeFields.PATH, path);
                        ret.put(obj);
                        
                        getDirectoriesJSON(ret, f, obj.getString(TreenodeFields.UID));
                    }
                }
            }
        }
    }
    
    /**
     * Obtiene la lista de hijos de una Página Web, abstraida en un objeto JSON.
     * <p>
     * Gets the descendant list from a WebPage object represented as JSON object.
     * @param root objeto JSON con los datos de una página Web.
     * @param user Usuario para hacer validaciones de acceso.
     * @param activeChilds Indica si se deberán incluir sólo los hijos activos.
     * @param useURIs Indica si se deben usar uris en reload y topicmap
     * @return Arreglo de objetos JSON con los hijos de la página Web abstraída en el objeto JSON.
     * @throws JSONException 
     */
    private JSONArray getWebPageChilds(JSONObject root, User user, boolean activeChilds, boolean useURIs) throws JSONException {
        String lang = "es";
        JSONArray ret = new JSONArray();
        SemanticObject obj = SemanticObject.createSemanticObject(root.getString(TreenodeFields.ID));
        if (null != user && null != user.getLanguage()) lang = user.getLanguage();
        
        if (null != obj && obj.instanceOf(WebPage.sclass)) {
            WebPage _root = (WebPage) obj.createGenericInstance();
            boolean add = null != root && user.haveAccess(_root) && (activeChilds && _root.isActive()) || !activeChilds;

            if (add) { //TODO: Revisar, en esta condición pasan los eliminados
                if ("WBAd_mnu_PopUp".equals(_root.getId())) {
                    String rootPath = _root.getParent().getURI()+"|"+_root.getURI();
                    Iterator<SemanticClass> it = SWBComparator.sortSemanticObjects(FilterableClass.swb_FilterableClass.listSubClasses(true));
                    while (it.hasNext()) {
                        SemanticClass scls = (SemanticClass) it.next();
                        JSONObject cobj = createNodeObject(scls.getClassId(), scls.getDisplayName(lang), "getTopic.SC|" + scls.getClassId(), root.getString(TreenodeFields.UID));
                        cobj.put(TreenodeFields.TOPICMAP, _root.getWebSiteId());
                        cobj.put(TreenodeFields.PATH, rootPath + "|" + scls.getClassId());
                        ret.put(cobj);

                        for (String act : actions) {
                            JSONObject actobj = createNodeObject(scls.getClassId()+";"+act, getLocaleString(act, lang), "getTopic.SCA|" + scls.getClassId()+"|"+act, cobj.getString(TreenodeFields.UID));
                            actobj.put(TreenodeFields.TOPICMAP, _root.getWebSiteId());
                            actobj.put(TreenodeFields.PATH, rootPath + "|" + scls.getClassId() + "|" + scls.getClassId()+";"+act);
                            ret.put(actobj);
                        }

                        if (scls.isSubClass(Activeable.swb_Activeable)) {
                            JSONObject actobj = createNodeObject(scls.getClassId()+";"+AdminFilter.ACTION_ACTIVE, getLocaleString("active", lang)+"/"+getLocaleString("unactive", lang), "getTopic.SCA|" + scls.getClassId()+"|"+AdminFilter.ACTION_ACTIVE, cobj.getString(TreenodeFields.UID));
                            actobj.put(TreenodeFields.TOPICMAP, _root.getWebSiteId());
                            actobj.put(TreenodeFields.PATH, rootPath + "|" + scls.getClassId() + "|" + scls.getClassId()+";"+AdminFilter.ACTION_ACTIVE);
                            ret.put(actobj);
                        }
                    }
                } else {
                    Iterator<WebPage> childs = _root.listChilds();
                    while (childs.hasNext()) {
                        //Add child node
                        WebPage child = childs.next();
                        add = user.haveAccess(child) && !child.isDeleted() && !child.isHidden() && (activeChilds && child.isActive()) || !activeChilds;
                        
                        if (add) {
                            String reload = "getTopic." + child.getWebSiteId()+"."+child.getId();
                            String tmap = _root.getWebSiteId();
                            if (useURIs) { //Esto es necesario porque no hay consistencia entre si se almacenan URIs o IDs
                                reload = "getSemanticObject."+child.getURI();
                                tmap = _root.getURI();
                            }
                            
                            JSONObject cobj = createNodeObject(child.getURI(), child.getDisplayName(lang), reload, root.getString(TreenodeFields.UID));
                            cobj.put(TreenodeFields.TOPICMAP, tmap);

                            String path = root.optString(TreenodeFields.PATH);
                            if (null != path && !path.isEmpty()) {
                                path = path + "|" + child.getURI();
                            } else {
                                path = child.getURI();
                            }
                            cobj.put(TreenodeFields.PATH, path);
                            ret.put(cobj);

                            //Add childs recursively
                            JSONArray recChilds = getWebPageChilds(cobj, user, activeChilds, useURIs);
                            for (int i = 0; i < recChilds.length(); i++) {
                                ret.put(recChilds.get(i));
                            }
                        }
                    }
                }
            }
        }
        
        return ret;
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Configuración de Menus del recurso. 
     * Los datos provienen de los menus y submenus definidos en los objetos en el sitio de administración.
     * <p>
     * Gets the JSON data for the Menus tab.
     * @param user Usuario que solicita los datos, sobre el cual se validará acceso.
     */
    private JSONArray getMenusJSON(User user) throws JSONException {
        JSONArray ret = new JSONArray();
        WebSite map = SWBContext.getAdminWebSite();
        WebPage _root = map.getWebPage("WBAd_Menus");

        if (null != _root && user.haveAccess(_root) && _root.isActive()) {
            //Add root object
            JSONObject root = createNodeObject(_root.getURI(), "Menus", "getTopic." + _root.getWebSiteId()+"."+_root.getId(), null);
            root.put(TreenodeFields.PATH, _root.getURI());
            root.put(TreenodeFields.TOPICMAP, map.getURI());
            ret.put(root);
            
            JSONArray childs = getWebPageChilds(root, user, true, false);
            for (int i = 0; i < childs.length(); i++) {
                ret.put(childs.get(i));
            }
        }
        
        return ret;
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Configuración de Vista del recurso.
     * Los datos provienen de los comportamientos asociados a los objetos en el sitio de administración.
     * <p>
     * Gets the JSON data for the Behaviours tab.
     * @param user Usuario que solicita los datos, sobre el cual se validará acceso.
     */
    private JSONArray getViewsJSON(User user) throws JSONException {
        JSONArray ret = new JSONArray();
        WebSite map = SWBContext.getAdminWebSite();
        WebPage _root = map.getWebPage("ObjectBehavior");
        
        if (null != _root && user.haveAccess(_root) && _root.isActive()) {
            //Add root object
            JSONObject root = createNodeObject(_root.getURI(), "Comportamientos", "getTopic." + _root.getWebSiteId()+"."+_root.getId(), null);
            root.put(TreenodeFields.PATH, _root.getURI());
            root.put(TreenodeFields.TOPICMAP, map.getURI());
            ret.put(root);
            
            JSONArray childs = getWebPageChilds(root, user, true, false);
            for (int i = 0; i < childs.length(); i++) {
                ret.put(childs.get(i));
            }
        }
        
        return ret;
    }
    
    /**
     * Obtiene un arreglo de objetos JSON con los hijos de un nodo XML. 
     * Cada hijo contiene los atributos correspondientes, de acuerdo al XML.
     * La estructura del JSON es como sigue:
     * <p>
     * {
     *   uuid: "7fa05029-252e-4b44-9dff-b4901920c984", //Usado como identificador para el árbol, útil sólo para la UI
     *   id: "/swbadmin/js", //Identificador del objeto asociado o ruta del archivo asociado. Se utiliza para validaciones
     *   name: "js", //Nombre del nodo, útil sólo para la UI
     *   path: "/swbadmin/js", //Ruta jerárquica del objeto en el árbol (es única). Utilizada para validaciones y transformada para almacenar el filtro
     *   parent: "cc554cdc-7c7f-48c6-92d1-a85c1861f613", //UID del nodo padre, útil sólo para la UI
     *   selected: true //Indica si el nodo aparece en la configuración del filtro y debe ser activado en el UI
     * }
     * <p>
     * Transforms an XML tree into a list of JSONObjects.
     * JSON structure is as follows:
     * <p>
     * {
     *   uuid: "7fa05029-252e-4b44-9dff-b4901920c984", //Unique IDfor the UI Tree
     *   id: "/swbadmin/js", //Related object ID, used for validations
     *   name: "js", //Node name for the UI Tree
     *   path: "/swbadmin/js", //Tree path for the object (unique). Used for validations and processed for data storage in Filter
     *   parent: "cc554cdc-7c7f-48c6-92d1-a85c1861f613", //Parent node UID for UI Tree
     *   selected: true //Whether the filter is in configuration and must be checked at start
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
            String idObj = enode.getAttribute(TreenodeFields.ID);
            String path = enode.getAttribute(TreenodeFields.PATH);
            String reload = enode.getAttribute(TreenodeFields.RELOAD);
            String tmap = enode.getAttribute(TreenodeFields.TOPICMAP);
            
            if ("dir".equals(nodeName)) idObj = path.replace("/",".");

            JSONObject e = createNodeObject(idObj, null, reload, null);
            if (!path.isEmpty()) e.put(TreenodeFields.PATH, path);
            if (!tmap.isEmpty()) e.put(TreenodeFields.TOPICMAP, tmap);
            ret.put(e);
        }
        
        return ret;
    }
    
    /**
     * Obtiene la configuración del filtro en formato JSON para su conciliación con los datos para el árbol.
     * <p>
     * Gets filter configuration for data reconciliation.
     * @param filter Filtro de administración.
     * @return Objeto JSON con la configuración del filtro.
     */
    private JSONObject getJSONFilter(AdminFilter filter) throws JSONException {
        JSONObject ret = new JSONObject();
        
        if (null != filter)  {
            Document dom = filter.getDom();
            JSONArray sites = new JSONArray();
            JSONArray menus = new JSONArray();
            JSONArray dirs = new JSONArray();
            JSONArray elements = new JSONArray();
            
            NodeList nodes = dom.getElementsByTagName("sites");
            if (null != nodes && nodes.getLength() > 0) {
                sites = getNodeElements("node", (Element) nodes.item(0));
            }

            nodes = dom.getElementsByTagName("menus");
            if (null != nodes && nodes.getLength() > 0) {
                menus = getNodeElements("node", (Element) nodes.item(0));
            }

            nodes = dom.getElementsByTagName("dirs");
            if (null != nodes && nodes.getLength() > 0) {
                dirs = getNodeElements("dir", (Element) nodes.item(0));
            }

            nodes = dom.getElementsByTagName("elements");
            if (null != nodes && nodes.getLength() > 0) {                
                Element root = (Element) nodes.item(0);
                elements = getNodeElements("node", root);
            }
            ret.put("sites", sites);
            ret.put("menus", menus);
            ret.put("dirs", dirs);
            ret.put("elements", elements);
        }
        
        return ret;
    }
    
    /**
     * Compara una tabla de objetos JSON con un arreglo para marcar como seleccionados aquellos que existan en la tabla y en la lista.
     * <p>
     * Compares a map of objects against an object list to set the selected attribute on matches.
     * @param treeData Tabla de objetos de referencia
     * @param elements Lista de objetos a buscar
     * @param idProperty Propiedad a usar como ID en la comparación
     * @param tryAsWebPage Indica si debe intentarse recuperar como WebPage
     * @throws JSONException 
     */
    private JSONArray matchElements(HashMap<String, JSONObject> treeData, JSONArray elements, String idProperty, boolean tryAsWebPage) throws JSONException {
        JSONArray paths = new JSONArray();
        for (int i = 0; i < elements.length(); i++) {
            JSONObject item = elements.getJSONObject(i);
            String id = item.getString(idProperty);
            //TODO: Se tiene que hacer esto porque el XML actualmente almacena ID en lugar de URI
            if (tryAsWebPage) {
                WebPage wp = (WebPage) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(id);
                if (null != wp) id = wp.getId();
            }
            
            if (treeData.containsKey(id)) {
                JSONObject obj = treeData.get(id);
                if (obj.optString(TreenodeFields.RELOAD, "").equals(item.optString(TreenodeFields.RELOAD, ""))) { //Pueden repetirse los IDs, reload los diferencia
                    item.put("selected", true);
                    paths.put(item.getString(TreenodeFields.UID));
                }
            }
        }
        return paths;
    }
    
    /**
     * Concila la información contenida en la configuración del filtro con la del despliegue en la vista de árbol.
     * <p>
     * Reconciles filter and tree data for the resource view.
     * @param filter Filtro de administración para obtener la configuración almacenada en el objeto.
     * @param treeData Datos obtenidos para mostrar en el árbol en el recurso.
     * @throws JSONException 
     */
    private void getMergedFilter(AdminFilter filter, JSONObject treeData) throws JSONException {
        JSONObject ret = treeData;
        JSONObject filterData = getJSONFilter(filter);
        JSONObject paths = new JSONObject();
        
        HashMap<String, JSONObject> objTable = new HashMap<>();
        JSONArray src = filterData.getJSONArray("menus");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString(TreenodeFields.ID), item);
        }

        paths.put("menus", matchElements(objTable, ret.getJSONArray("menus"), TreenodeFields.ID, true));
        
        objTable = new HashMap<>();
        src = filterData.getJSONArray("sites");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString(TreenodeFields.PATH), item);
        }
        
        paths.put("sites",matchElements(objTable, ret.getJSONArray("sites"), TreenodeFields.PATH, false));
        
        objTable = new HashMap<>();
        src = filterData.getJSONArray("elements");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString(TreenodeFields.ID), item);
        }
        
        paths.put("elements", matchElements(objTable, ret.getJSONArray("elements"), TreenodeFields.ID, true));
        
        objTable = new HashMap<>();
        src = filterData.getJSONArray("dirs");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString(TreenodeFields.PATH), item);
        }
        
        paths.put("dirs", matchElements(objTable, ret.getJSONArray("dirs"), TreenodeFields.PATH, false));
        treeData.put("paths", paths);
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
        
        if ("getFilter".equals(action)) {
            JSONObject _ret = new JSONObject();
            SemanticObject obj = SWBPlatform.getSemanticMgr().getOntology().getSemanticObject(request.getParameter("suri"));
            if (null != obj && obj.instanceOf(AdminFilter.sclass)) {
                AdminFilter af = (AdminFilter)obj.createGenericInstance();
                try {
                    _ret.put("filterId", af.getURI());
                    _ret.put("paths", new JSONArray());
                    
                    //Put elements
                    JSONArray nodes = getViewsJSON(paramRequest.getUser());
                    _ret.put("elements", nodes);
                    if (nodes.length() > 0) {
                        _ret.put("elementsRoot", nodes.getJSONObject(0).getString(TreenodeFields.UID));
                    }
                    
                    //Put menus
                    nodes = getMenusJSON(paramRequest.getUser());
                    _ret.put("menus", nodes);
                    if (nodes.length() > 0) {
                        _ret.put("menusRoot", nodes.getJSONObject(0).getString(TreenodeFields.UID));
                    }
                    
                    //Put directories
                    nodes = new JSONArray();
                    getDirectoriesJSON(nodes, new File(SWBUtils.getApplicationPath()), null);
                    _ret.put("dirs", nodes);
                    if (nodes.length() > 0) {
                        _ret.put("dirsRoot", nodes.getJSONObject(0).getString(TreenodeFields.UID));
                    }
                    
                    //Put sites
                    nodes = getServerJSON(paramRequest.getUser());
                    _ret.put("sites", nodes);
                    if (nodes.length() > 0) {
                        _ret.put("sitesRoot", nodes.getJSONObject(0).getString(TreenodeFields.UID));
                    }
                    
                    getMergedFilter(af, _ret);
                } catch (JSONException jsex) {
                    log.error("Error al generar JSON del componente", jsex);
                }
            }
            ret = _ret.toString();
        }
        out.print(ret);
    }

    /**
     * User View of the SWBAFilters Resource; it shows a resource filter
     * configuration, configure in wich webpage it shows, in the Semantic
     * WebBuilder application.
     *
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException, a Resource Exc
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //TODO: Para eficientar, almacenar en memoria los objetos que no cambian desde que se inicia el servidor, siempre y cuando adminShow=false (menus, comportamientos)
        String jsp = "/swbadmin/jsp/SWBAFilters/view.jsp";
        GenericObject gobj = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
        if (null != gobj && gobj instanceof AdminFilter) {
            jsp = "/swbadmin/jsp/SWBAFilters/edit.jsp";
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
     * Llena un nodo del DOM con las propiedades del elemento en el filtro.
     * @param element Nodo a llenar
     * @param obj Objeto JSON con las propiedades del elemento.
     * @param changeURIS Indica si las URIs en ID y PATH deberán cambiarse por IDs. Esto se debe a que el filtro utiliza IDs en lugar de URIS.
     * @throws JSONException 
     */
    private void populateDOMNode(Element element, JSONObject obj, boolean changeURIS) throws JSONException {
        String id =  obj.optString(TreenodeFields.ID, null);
        String reload =  obj.optString(TreenodeFields.RELOAD, null);
        String path =  obj.optString(TreenodeFields.PATH, null);
        String topicmap =  obj.optString(TreenodeFields.TOPICMAP, null);
        SemanticObject aux = null;
        
        if (changeURIS && !"dir".equals(element.getNodeName())) {
            aux = SemanticObject.createSemanticObject(id);
            if (null != aux) {
                id = aux.getId();
            }

            if (null != path && !path.isEmpty()) {
                if (path.contains("|")) {
                    String ancestors [] = path.split("\\|");
                    for (int j = 0; j < ancestors.length; j++) {
                        aux = SemanticObject.createSemanticObject(ancestors[j]);
                        if (null != aux) {
                            ancestors[j] = aux.getId();
                        }
                    }
                    path = String.join("|", Arrays.asList(ancestors));
                } else {
                    aux = SemanticObject.createSemanticObject(path);
                    path = aux.getId();
                }
            }
        }
        
        if ("dir".equals(element.getNodeName())) path = id.replace(".", "/");

        if (null != id && !"dir".equals(element.getNodeName())) element.setAttribute(TreenodeFields.ID, id);
        if (null != reload) element.setAttribute(TreenodeFields.RELOAD, reload);
        if (null != path) element.setAttribute(TreenodeFields.PATH, path);
        if (null != topicmap) element.setAttribute(TreenodeFields.TOPICMAP, topicmap);
    }
    
    /**
     * Transforma los datos del árbol de filtro de administración a formato XML para su almacenamiento en el objeto.
     * @param treeData JSON con la selección de nodos en el árbol de la vista.
     * @return Cadena XML que representa la configuración del árbol a escribir en el objeto del filtro.
     */
    private String getXMLFilterData(JSONObject treeData) throws JSONException {
        Document ret = SWBUtils.XML.getNewDocument();
        Element root = ret.createElement("filter");
        
        //Obtener comportamientos. Siempre son WebPages
        Element eleNode = ret.createElement("elements");
        JSONArray nodes = treeData.optJSONArray("elements");
        if (null != nodes) {
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                Element ele = ret.createElement("node");
                populateDOMNode(ele, node, true);
                eleNode.appendChild(ele);
            }
        }
        root.appendChild(eleNode);
        
        //Obtener sitios
        Element siteNode = ret.createElement("sites");
        nodes = treeData.optJSONArray("sites");
        if (null != nodes) {
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                Element ele = ret.createElement("node");
                populateDOMNode(ele, node, false);
                siteNode.appendChild(ele);
            }
        }
        root.appendChild(siteNode);
        
        //Obtener menus
        Element menuNode = ret.createElement("menus");
        nodes = treeData.optJSONArray("menus");
        if (null != nodes) {
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                Element ele = ret.createElement("node");
                populateDOMNode(ele, node, true);
                menuNode.appendChild(ele);
            }
        }
        root.appendChild(menuNode);

        //Obtener directorios
        Element dirNode = ret.createElement("dirs");
        nodes = treeData.optJSONArray("dirs");
        if (null != nodes) {
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                Element ele = ret.createElement("dir");
                populateDOMNode(ele, node, false);
                dirNode.appendChild(ele);
            }
        }
        root.appendChild(dirNode);
        
        ret.appendChild(root);
        return SWBUtils.XML.domToXml(ret);
    }
    
    /**
     * Clase estática con los campos usados en el procesamiento de los filtros.
     */
    public static class TreenodeFields {
        //Usado para identificar los nodos en el árbol de la vista
        public static String UID = "uuid";
        //ID del objeto asociado en el modelo para la vista
        public static String ID = "id";
        //ID del padre del nodo en el árbol de vista
        public static String PARENT = "parent";
        //Ruta del nodo, para fines de almacenar el filtro
        public static String PATH = "path";
        //Atributo reload, para fines de almacenar el filtro
        public static String RELOAD = "reload";
        //Nombre del nodo en la vista del árbol
        public static String NAME = "name";
        //Indica si el nodo debe estar seleccionado al inicializar la vista
        public static String SELECTED = "selected";
        //Atributo access, para fines de almacenar el filtro
        public static String ACCESS = "access";
        //Atributo topicmap, para fines de almacenar el filtro
        public static String TOPICMAP = "topicmap";
        //Atributo enabled, para validaciones en el UI
        public static String ENABLED = "enabled";
    }
}
