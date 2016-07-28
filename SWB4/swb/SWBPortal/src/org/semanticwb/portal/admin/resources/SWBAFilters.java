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
import org.semanticwb.model.SWBModel;
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
    private Logger log = SWBUtils.getLogger(SWBAFilters.class);
    static final String [] actions = {"add", "edit", "delete"};

    /**
     * Creates a new instance of WBAFilters.
     */
    public SWBAFilters() {}

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if (SWBResourceURL.Action_REMOVE.equals(action)) {
            UserRepository map = SWBContext.getAdminRepository();
            AdminFilter filter = AdminFilter.ClassMgr.getAdminFilter(request.getParameter("id"), map);
            if (null != filter) filter.remove();
            
            if (null != request.getParameter("suri")) {
                response.setRenderParameter("suri", request.getParameter("suri"));
            }
        } else if ("updateFilter".equals(action)) {
            BufferedReader reader = request.getReader();
            String line = null;
            StringBuilder body = new StringBuilder();
            while((line = reader.readLine()) != null) {
                body.append(line);
            }
            reader.close();
            //System.out.println(body.toString());
            try {
                JSONObject payload = new JSONObject(body.toString());
                //System.out.println(payload.toString(2));
            } catch (JSONException jsex) {
                log.error("Error getting response body");
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

        if (null != id && !id.isEmpty()) ret.put("id", id);
        if (null != name && !name.isEmpty()) ret.put("name", name);
        if (null != reload && !reload.isEmpty()) ret.put("reload", reload);
        if (null != parent && !parent.isEmpty()) ret.put("parent", parent);
        return ret;
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Filtros sobre sitios del recurso.
     * <p>
     * Gets the JSON data for the Site Filters tab.
     * @param user Usuario que solicita los datos, sobre el cual se validará acceso.
     */
    private JSONArray getServerJSON(User user) throws JSONException {
        JSONObject server = null;
        JSONArray ret = new JSONArray();
        String lang = "es";
        if (null != user && null != user.getLanguage()) lang = user.getLanguage();
        
        //Add server node
        server = new JSONObject("{\"name\":\"Server\", \"id\":\"Server\",\"access\":2, \"reload\":\"getServer\"}");
        ret.put(server);

        //Add websites
        Iterator<WebSite> sites = SWBComparator.sortSemanticObjects(SWBContext.listWebSites());
        while (sites.hasNext()) {
            WebSite site = sites.next();
            if (site.getId().equals(SWBContext.getAdminWebSite().getId()) || site.getId().equals(SWBContext.getGlobalWebSite().getId())) continue;//Ignore admin website
            
            if (!site.isDeleted()) {
                JSONObject siteobj = createNodeObject(site.getURI(), site.getDisplayTitle(lang), "getSemanticObject."+site.getURI(), "Server");
                siteobj.put("path","server|"+site.getURI());
                ret.put(siteobj);

                Iterator<SemanticObject> hierarchicalnodes = SWBComparator.sortSemanticObjects(site.getSemanticObject().getSemanticClass().listHerarquicalNodes());
                while (hierarchicalnodes.hasNext()) {
                    SemanticObject node = hierarchicalnodes.next();
                    JSONObject nodeobj = createNodeObject(node.getURI(), node.getDisplayName(lang), "getSemanticObject."+node.getURI(), site.getURI());
                    nodeobj.put("path", "server|"+site.getURI()+"|"+node.getURI());
                    ret.put(nodeobj);
                }

                Iterator<SWBModel> submodels = SWBComparator.sortSemanticObjects(site.listSubModels());
                while (submodels.hasNext()) {
                    SWBModel submodel = submodels.next();
                    if (null != submodel && submodel.getSemanticObject().instanceOf(UserRepository.sclass)) {
                        JSONObject submodelobj = createNodeObject(submodel.getURI(), submodel.getSemanticObject().getDisplayName(lang), "getSemanticObject."+submodel.getURI(), site.getURI());
                        submodelobj.put("path", siteobj.get("path")+"|"+submodel.getURI());
                        ret.put(submodelobj);
                    }
                }
                
                WebPage page = site.getHomePage();
                if (null != page) {
                    JSONObject nodeobj = new JSONObject();//createNodeObject(page.getURI(), site.getTitle(lang), "getSemanticObject."+page.getURI(), site.getURI());
                    nodeobj.put("id", page.getURI());
                    nodeobj.put("name", page.getDisplayName(lang));
                    nodeobj.put("parent", site.getURI());
                    nodeobj.put("path", siteobj.get("path")+"|"+page.getURI());
                    nodeobj.put("reload", "getTopic." + page.getWebSiteId()+"."+page.getId());
                    nodeobj.put("topicmap", site.getURI());
                    ret.put(nodeobj);

                    JSONArray pages = getWebPageChilds(nodeobj, user, false);
                    for (int i = 0; i < pages.length(); i++) {
                        ret.put(pages.getJSONObject(i));
                    }
                }
            }
        }

        return ret;
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Documentos del Servidor del recurso. Los datos provienen de la lista de carpetas de la ruta de la aplicación.
     * <p>
     * Gets the JSON data for the Server Documents tab.
     * @param ret Arreglo de objetos JSON con el resultado del recorrido por las carpetas.
     * @param root Directorio que será la raíz del recorrido.
     */
    private void getDirectoriesJSON(JSONArray ret, File root) throws JSONException {
        if (null != root && root.exists()) {
            if (root.isDirectory()) {
                String appPath = SWBUtils.getApplicationPath();

                String rootPath = appPath;
                if (rootPath.endsWith("/")) rootPath = rootPath.substring(0, rootPath.length() - 1);
                if (rootPath.equals(root.getAbsolutePath())) { //App root folder
                    rootPath = rootPath.substring(rootPath.lastIndexOf("/")+1, rootPath.length());
                    JSONObject obj = createNodeObject(rootPath, rootPath, null, null);
                    ret.put(obj);
                } else {
                    rootPath = root.getAbsolutePath().substring(appPath.length());
                }
                
                if (rootPath.contains("//")) rootPath = rootPath.replace("//", "/");
                if (rootPath.contains("\\")) rootPath = rootPath.replace('\\', '/');
                rootPath = rootPath.replace("/",".");
                
                File [] childs = root.listFiles();
                for (File f : childs) {
                    if (f.isDirectory()) {
                        String path = f.getAbsolutePath().substring(appPath.length());
                        path = path.replace("//", "/");
                        path = path.replace('\\', '/');
                        path = path.replace("/",".");
                        
                        JSONObject obj = createNodeObject(path, f.getName(), null, rootPath);
                        if (path.startsWith(".") && path.length() > 1) path = path.substring(1, path.length());
                        obj.put("path", path.replace(".", "|"));
                        ret.put(obj);
                        
                        getDirectoriesJSON(ret, f);
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
     * @return Arreglo de objetos JSON con los hijos de la página Web abstraída en el objeto JSON.
     * @throws JSONException 
     */
    private JSONArray getWebPageChilds(JSONObject root, User user, boolean activeChilds) throws JSONException {
        String lang = "es";
        JSONArray ret = new JSONArray();
        SemanticObject obj = SemanticObject.createSemanticObject(root.getString("id"));
        if (null != user && null != user.getLanguage()) lang = user.getLanguage();
        
        if (obj.instanceOf(WebPage.sclass)) {
            WebPage _root = (WebPage) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(root.getString("id"));
            boolean add = null != root && user.haveAccess(_root) && (activeChilds && _root.isActive()) || !activeChilds;

            if (add) { //TODO: Revisar, en esta condición pasan los eliminados
                if ("WBAd_mnu_PopUp".equals(_root.getId())) {
                    String rootPath = _root.getParent().getURI()+"|"+_root.getURI();
                    Iterator<SemanticClass> it = SWBComparator.sortSemanticObjects(FilterableClass.swb_FilterableClass.listSubClasses(true));
                    while (it.hasNext()) {
                        SemanticClass scls = (SemanticClass) it.next();
                        JSONObject cobj = new JSONObject();
                        cobj.put("id", scls.getClassId());
                        cobj.put("name", scls.getDisplayName(lang));
                        cobj.put("reload", "getTopic.SC|" + scls.getClassId());
                        cobj.put("topicmap", _root.getWebSiteId());
                        cobj.put("parent", _root.getURI());
                        cobj.put("path", rootPath + "|" + scls.getClassId());
                        ret.put(cobj);

                        for (String act : actions) {
                            cobj = new JSONObject();
                            cobj.put("id", scls.getClassId()+";"+act);
                            cobj.put("name", getLocaleString(act, lang));
                            cobj.put("reload", "getTopic.SCA|" + scls.getClassId()+"|"+act);
                            cobj.put("topicmap", _root.getWebSiteId());
                            cobj.put("parent", scls.getClassId());
                            cobj.put("path", rootPath + "|" + scls.getClassId() + "|" + scls.getClassId()+";"+act);
                            ret.put(cobj);
                        }

                        if (scls.isSubClass(Activeable.swb_Activeable)) {
                            cobj = new JSONObject();
                            cobj.put("id", scls.getClassId()+";active");
                            cobj.put("name", getLocaleString("active", lang)+"/"+getLocaleString("unactive", lang));
                            cobj.put("reload", "getTopic.SCA|" + scls.getClassId()+"|active");
                            cobj.put("topicmap", _root.getWebSiteId());
                            cobj.put("parent", scls.getClassId());
                            cobj.put("path", rootPath + "|" + scls.getClassId() + "|" + scls.getClassId()+";active");
                            ret.put(cobj);
                        }
                    }
                } else {
                    Iterator<WebPage> childs = _root.listChilds();
                    while (childs.hasNext()) {
                        //Add child node
                        WebPage child = childs.next();
                        add = user.haveAccess(child) && !child.isDeleted() && !child.isHidden() && (activeChilds && child.isActive()) || !activeChilds;
                        
                        if (add) {
                            JSONObject cobj = new JSONObject();
                            cobj.put("id", child.getURI());
                            cobj.put("name", child.getDisplayName(lang));
                            cobj.put("parent", _root.getURI());
                            cobj.put("reload", "getTopic." + child.getWebSiteId()+"."+child.getId());
                            cobj.put("topicmap", _root.getWebSiteId());

                            String path = root.optString("path");
                            if (null != path && !path.isEmpty()) {
                                path = path + "|" + child.getURI();
                            } else {
                                path = child.getURI();
                            }
                            cobj.put("path", path);
                            ret.put(cobj);

                            //Add childs recursively
                            JSONArray recChilds = getWebPageChilds(cobj, user, activeChilds);
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
     * Obtiene el JSON correspondiente a la pestaña Configuración de Menus del recurso. Los datos provienen de los menus y submenus definidos en los objetos en el sitio de administración.
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
            JSONObject root = new JSONObject();
            root.put("id", _root.getURI());
            root.put("name", "Menus");
            root.put("path", _root.getURI());
            root.put("reload", "getTopic." + _root.getWebSiteId()+"."+_root.getId());
            root.put("topicmap", map.getURI());
            ret.put(root);
            
            JSONArray childs = getWebPageChilds(root, user, true);
            for (int i = 0; i < childs.length(); i++) {
                ret.put(childs.get(i));
            }
        }
        
        return ret;
    }
    
    /**
     * Obtiene el JSON correspondiente a la pestaña Configuración de Vista del recurso. Los datos provienen de los comportamientos asociados a los objetos en el sitio de administración.
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
            JSONObject root = new JSONObject();
            root.put("id", _root.getURI());
            root.put("name", "Comportamientos");
            root.put("path", _root.getURI());
            root.put("topicmap", map.getURI());
            ret.put(root);
            
            JSONArray childs = getWebPageChilds(root, user, true);
            for (int i = 0; i < childs.length(); i++) {
                ret.put(childs.get(i));
            }
        }
        
        return ret;
    }
    
    /**
     * Obtiene un arreglo de objetos JSON con los hijos de un nodo XML. Cada hijo contiene los atributos correspondientes, de acuerdo al XML.
     * <p>
     * Transforms an XML tree into a list of JSONObjects.
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
            String path = enode.getAttribute("path");
            String reload = enode.getAttribute("reload");
            String tmap = enode.getAttribute("topicmap");
            
            if ("dir".equals(nodeName)) idObj = path.replace("/",".");

            JSONObject e = createNodeObject(idObj, null, reload, null);
            if (!path.isEmpty()) e.put("path", path);
            if (!tmap.isEmpty()) e.put("topicmap", tmap);
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
            System.out.println("-----dom filter------");
            System.out.println(SWBUtils.XML.domToXml(dom));
            
            NodeList nodes = dom.getElementsByTagName("sites");
            if (null != nodes && nodes.getLength() > 0) {
                JSONArray sites = getNodeElements("node", (Element) nodes.item(0));
                ret.put("sites", sites);
            }

            nodes = dom.getElementsByTagName("menus");
            if (null != nodes && nodes.getLength() > 0) {
                JSONArray menus = getNodeElements("node", (Element) nodes.item(0));
                ret.put("menus", menus);
            }

            nodes = dom.getElementsByTagName("dirs");
            if (null != nodes && nodes.getLength() > 0) {
                JSONArray dirs = getNodeElements("dir", (Element) nodes.item(0));
                ret.put("dirs", dirs);
            }

            nodes = dom.getElementsByTagName("elements");
            if (null != nodes && nodes.getLength() > 0) {                
                Element root = (Element) nodes.item(0);
                JSONArray elements = getNodeElements("node", root);
                ret.put("elements", elements);
            }
        }
        
        return ret;
    }
    
    /**
     * Compara una tabla de objetos JSON con un arreglo para marcar como seleccionados aquellos que existan en la tabla y en la lista.
     * <p>
     * Compares a map of objects against an object list to set the selected attribute on matches.
     * @param treeData Tabla de objetos de referencia
     * @param elements Lista de objetos a buscar
     * @throws JSONException 
     */
    private JSONArray matchElements(HashMap<String, JSONObject> treeData, JSONArray elements, boolean tryAsWebPage) throws JSONException {
        JSONArray paths = new JSONArray();
        for (int i = 0; i < elements.length(); i++) {
            JSONObject item = elements.getJSONObject(i);
            String id = item.getString("id");
            
            //TODO: Se tiene que hacer esto porque el XML actualmente almacena ID en lugar de URI
            if (tryAsWebPage) {
                WebPage wp = (WebPage) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(id);
                if (null != wp) id = wp.getId();
            }
            
            if (treeData.containsKey(id)) {
                item.put("selected", true);
                System.out.println("Pushing "+id+" to path");
                paths.put(item.optString("path"));
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
        JSONArray paths = ret.getJSONArray("paths");
        
        HashMap<String, JSONObject> objTable = new HashMap<>();
        JSONArray src = filterData.getJSONArray("menus");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString("id"), item);
        }

        paths.put(matchElements(objTable, ret.getJSONArray("menus"), true));
        
        objTable = new HashMap<>();
        src = filterData.getJSONArray("sites");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString("id"), item);
        }
        
        paths.put(matchElements(objTable, ret.getJSONArray("sites"), false));
        
        objTable = new HashMap<>();
        src = filterData.getJSONArray("elements");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString("id"), item);
        }
        
        paths.put(matchElements(objTable, ret.getJSONArray("elements"), true));
        
        objTable = new HashMap<>();
        src = filterData.getJSONArray("dirs");
        for (int i = 0; i < src.length(); i++) {
            JSONObject item = src.getJSONObject(i);
            objTable.put(item.getString("id"), item);
        }
        
        paths.put(matchElements(objTable, ret.getJSONArray("dirs"), false));
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
                    _ret.put("elements", getViewsJSON(paramRequest.getUser()));
                    
                    //Put menus
                    _ret.put("menus", getMenusJSON(paramRequest.getUser()));
                    
                    //Put directories
                    JSONArray dt = new JSONArray();
                    getDirectoriesJSON(dt, new File(SWBUtils.getApplicationPath()));
                    _ret.put("dirs", dt);
                    
                    //Put sites
                    _ret.put("sites", getServerJSON(paramRequest.getUser()));
                    
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
     * Transforma los datos del árbol de filtro de administración a formato XML para su almacenamiento en el objeto.
     * @param treeData JSON con la selección de nodos en el árbol de la vista.
     * @return Cadena XML que representa la configuración del árbol a escribir en el objeto del filtro.
     */
    private String getXMLTreeData(JSONObject treeData) {
        StringBuilder ret = new StringBuilder();
        
        return ret.toString();
    }
}
