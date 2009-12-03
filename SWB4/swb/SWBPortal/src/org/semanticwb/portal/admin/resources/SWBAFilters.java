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
 * SWBAFilters.java
 *
 * Created on 23 de noviembre de 2004, 12:49 PM
 */
package org.semanticwb.portal.admin.resources;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.*;
import java.util.*;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;

import org.semanticwb.model.AdminFilter;
import org.semanticwb.model.Filterable;
import org.semanticwb.model.FilterableClass;
import org.semanticwb.model.FilterableNode;
import org.semanticwb.model.HerarquicalNode;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SWBObjectFilter;
import org.semanticwb.platform.SemanticClass;

import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.admin.resources.wbtree.SWBTreeExt;
import org.semanticwb.portal.api.SWBResourceURL;

/** Recurso de administraci�n de WebBuilder que permite agregar filtros, editarlos,
 * actualizarlos o eliminarlos seg�n sea el caso.
 *
 * Resource of administration of WebBuilder that allows to add filters, to publish
 * them, to update them or to eliminate them according to is the case.
 * @author Victor Lorenzana
 */
public class SWBAFilters extends SWBATree {

    private Logger log = SWBUtils.getLogger(SWBAFilters.class);
    static final String[] pathValids = {"getSemanticObject","getGlobal", "getTemplates", "getServer", "getResources", "getResourceTypes", "getSysResources", "getTopic", "getTemplateGroup", "getUserRep", "getRules", "getPFlows", "getLanguages", "getDevices", "getMDTables", "getDnss", "getTopicMap", "getUserReps", "getCamps", "getCamp", "getCntResources","getSemanticClass"};
    static final String[] namevalids = {"node", "config", "icons", "icon", "res", "events", "willExpand", "Template"};
    private HashMap hmclass = null;
    private Document jsondom = null;

    /** Creates a new instance of WBAFilters */
    public SWBAFilters() {
    }

    public String getLocaleString(String key, String lang)
    {
        String ret="";
        if(lang==null)
        {
            ret=SWBUtils.TEXT.getLocaleString("locale_swb_admin", key);
        }else
        {
            ret=SWBUtils.TEXT.getLocaleString("locale_swb_admin", key, new Locale(lang));
        }
        //System.out.println(key+" "+lang+" "+ret);
        return ret;
    }

    /**
     * @param request
     * @param response
     * @param paramRequest
     * @throws IOException
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        //System.out.println("processRequest");
        if (paramRequest.getMode().equals("gateway")) {
            doGateway(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public Document getDocument(User user, Document src, String act)
    {
        //System.out.println("getDocument");
        Document dom = null;
        try {
            dom = SWBUtils.XML.getNewDocument();
            Element res = dom.createElement("res");
            dom.appendChild(res);

            String cmd = null;
            String id = null;
            int ind = act.indexOf('.');
            if (ind > 0) {
                cmd = act.substring(0, ind);
                id = act.substring(ind + 1);
            //System.out.println("getDocument........."+cmd+":"+id);
            } else {
                cmd = act;
            }

            if (cmd.equals("getServer")) {
                addServer(user, res);
            } else if (cmd.equals("getGlobal")) {
                addGlobal(user, res, PARCIAL_ACCESS);
            } else if (cmd.equals("getTopicMap")) {
                WebSite tm = SWBContext.getWebSite(id);
                addTopicMap(user, tm, res, PARCIAL_ACCESS);
            } else if (cmd.equals("getTopic")) {
                String tmid = id.substring(0, id.indexOf('.'));
                String tpid = id.substring(id.indexOf('.') + 1);
                WebPage tp = SWBContext.getWebSite(tmid).getWebPage(tpid);
                addTopic(user, tp, res);
            } else if (cmd.equals("getSemanticObject")) 
            {
                if(id.startsWith("HN|"))
                {
                    StringTokenizer st=new StringTokenizer(id,"|");
                    String aux=st.nextToken();
                    String ouri=st.nextToken();
                    String nuri=st.nextToken();
                    //System.out.println("aux:"+aux+" ouri:"+ouri+" nuri:"+nuri);
                    if(ouri!=null && nuri!=null)
                    {
                        SemanticObject obj=SemanticObject.createSemanticObject(ouri);
                        SemanticObject nobj=SemanticObject.createSemanticObject(nuri);
                        //System.out.println("obj:"+obj+" node:"+nobj);
                        HerarquicalNode node=new HerarquicalNode(nobj);
                        addHerarquicalNode(user,node,obj,res,true);
                    }
                }else
                {
                    SemanticObject sobj = SemanticObject.createSemanticObject(id);
                    addSemanticObject(user, sobj, res, true);
                }
            } else if (cmd.equals("getSemanticClass")) 
            {
                SemanticClass scls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClassById(id);
                //System.out.println("Command getSemanticClass:"+scls);
                addSemanticClass(user, scls, res, true);
            } else
            {
                boolean ret = false;
                Iterator itex = ext.iterator();
                while (itex.hasNext()) {
                    SWBTreeExt e = (SWBTreeExt) itex.next();
                    ret = e.executeCommand(user, res, cmd, id);
                    if (ret) {
                        break;
                    }
                }
                if (!ret) {
                    return getError(2);
                }
            }
        } catch (Exception e) {
            log.error(e);
            return getError(3);
        }
        //RevisaNodo(dom.getFirstChild());
        return dom;
    }

    /**
     * @param map
     * @param etopic
     * @param root
     * @param user
     */
    public void getMenus(WebSite map, Element etopic, WebPage root, User user)
    {
        //System.out.println("getMenus...");

        if("WBAd_mnu_PopUp".equals(root.getId()))
        {
            //System.out.println("Se encontró sub-menus........");
            //loadSemClass(user);
            getSubMenus(map, etopic, root, user);

        }
        else
        {
            Iterator<WebPage> childs = root.listChilds(); //getSortChild();

            while (childs.hasNext()) {
                WebPage topic = childs.next();
                //System.out.println("getMenus..."+topic.getDisplayName());
                if (user.haveAccess(topic)) {
                    Element etp = addNode("topic", topic.getId(), topic.getDisplayName(user.getLanguage()), etopic);
                    etp.setAttribute("topicmap", map.getId());


                    //TODO: AdmFilterMgr.getInstance().haveAccess2Menu4Filter(user, topic);

                    boolean canModify = true; //AdmFilterMgr.getInstance().haveAccess2Menu4Filter(user, topic);
                    etp.setAttribute("canModify", String.valueOf(canModify));
                    etp.setAttribute("reload", "getTopic." + map.getId() + "." + topic.getId());
                    etp.setAttribute("icon", "hijov");

                    getMenus(map, etp, topic, user);
                }
            }
        }
    }

    /**
     * @param cmd
     * @param src
     * @param user
     * @param request
     * @param response
     * @return
     */
    public Document getMenus(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {
        //System.out.println("getMenus2");

        WebSite map = SWBContext.getAdminWebSite();
        Document docres = null;
        try {
            docres = SWBUtils.XML.getNewDocument();
            Element res = docres.createElement("res");
            docres.appendChild(res);
            WebPage topic = map.getWebPage("WBAd_Menus");
            if (user.haveAccess(topic)) {
                Element etopic = addNode("topic", topic.getId(), topic.getDisplayName(user.getLanguage()), res);
                etopic.setAttribute("topicmap", map.getId());

                //TODO: AdmFilterMgr.getInstance().haveAccess2Menu4Filter(user, topic);

                boolean canModify = true; //AdmFilterMgr.getInstance().haveAccess2Menu4Filter(user, topic);
                etopic.setAttribute("canModify", String.valueOf(canModify));
                etopic.setAttribute("reload", "getTopic." + map.getId() + "." + topic.getId());
                etopic.setAttribute("icon", "hijov");

                getMenus(map, etopic, topic, user);

            }
        } catch (Exception e) {
            //e.printStackTrace(System.out);
            log.error(e);
        }
        return docres;
    }

    /**
     * @param map
     * @param etopic
     * @param root
     * @param user
     */
    public void getSubMenus(WebSite map, Element etopic, WebPage root, User user)
    {
        //System.out.println("getSubMenu");

        String lang = user.getLanguage();
//        Iterator<String> its = hmclass.keySet().iterator();
//        //System.out.println("Lista de clases...."+hmclass.keySet().size());
//        while (its.hasNext()) {
//            String sclass = its.next();
////            if(!sclass.equals("WebSite")&&!sclass.equals("WebPage"))
////            {
//            SemanticClass sc = (SemanticClass) hmclass.get(sclass);
//
//
//        }


        Iterator<SemanticClass> it=FilterableClass.swb_FilterableClass.listSubClasses(true);
        while(it.hasNext())
        {
            SemanticClass cls2 = (SemanticClass)it.next();
            {
                addSemanticClass(user, cls2, etopic, true);
                //out.println(cls2.getDisplayName("es")+"<br/>");
            }
        }
    }

    /**
     * @param cmd
     * @param src
     * @param user
     * @param request
     * @param response
     * @return
     */
    public Document getElements(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {

        WebSite map = SWBContext.getAdminWebSite();
        Document docres = null;
        try {
            docres = SWBUtils.XML.getNewDocument();
            Element res = docres.createElement("res");
            docres.appendChild(res);
            WebPage topic = map.getWebPage("ObjectBehavior");
            if (user.haveAccess(topic)) {
                Element etopic = this.addNode("topic", topic.getId(), topic.getDisplayName(user.getLanguage()), res);
                etopic.setAttribute("topicmap", map.getId());
                etopic.setAttribute("reload", "getTopicMap." + map.getId());
                etopic.setAttribute("access", "2"); // todo:
                boolean canModify = true; //AdmFilterMgr.getInstance().haveAccess2System4Filter(user, topic);
                etopic.setAttribute("canModify", String.valueOf(canModify));
                etopic.setAttribute("reload", "getTopic." + map.getId() + "." + topic.getId());
                etopic.setAttribute("icon", "folder");
                getMenus(map, etopic, topic, user); // carga la lista de comportamientos definidos en el sitio de administración
            }
        } catch (Exception e) {
            log.error(e);
        }
        return docres;
    }

    /**
     * @param user
     * @param src
     * @return
     */
    @Override
    public Document initTree(User user, Document src)
    {
        //System.out.println("initTree");
        Document doc = initTree(user, src, false);
        //RevisaNodo(doc.getFirstChild());
        return doc;
    }

    @Override
    public Document initTree(User user, Document src, boolean isFilter)
    {
        //System.out.println("initTree2");
        Document dom = null;
        try {
            dom = SWBUtils.XML.getNewDocument();
            Element res = dom.createElement("res");
            dom.appendChild(res);
            //config
            Element config = addNode("config", "config", "Config", res);

            Element icons = addNode("icons", "icons", "Icons", config);

            Element icon = addNode("icon", "sitev", "Site", icons);
            icon.setAttribute("path", "images/icon-sitioa.gif");
            icon = addNode("icon", "siter", "Site", icons);
            icon.setAttribute("path", "images/icon-sitior.gif");
            icon = addNode("icon", "hijor", "Topic", icons);
            icon.setAttribute("path", "images/icon-pagwebr.gif");
            icon = addNode("icon", "hijov", "Topic", icons);
            icon.setAttribute("path", "images/icon-pagweba.gif"); //icon-foldera.gif
            //icon.setAttribute("path","images/icon-foldera.gif");
            icon = addNode("icon", "homer", "Topic", icons);
            icon.setAttribute("path", "images/i_home_rojo.gif");
            icon = addNode("icon", "homev", "Topic", icons);
            icon.setAttribute("path", "images/i_home_verde.gif");
            icon = addNode("icon", "virtual", "Topic", icons);
            icon.setAttribute("path", "images/ico_virtual.gif");

            icon = addNode("icon", "folder", "Folder", icons);
            icon.setAttribute("path", "images/icon-foldera.gif");
            icon = addNode("icon", "root", "Root", icons);
            icon.setAttribute("path", "images/icon-foldera.gif");
            icon = addNode("icon", "menu", "Menu", icons);
            icon.setAttribute("path", "images/icon-pagweba.gif");//
            icon = addNode("icon", "global", "Global", icons);
            icon.setAttribute("path", "images/icon-servera.gif");
            ///////
            icon = addNode("icon", "devices", "Devices", icons);
            icon.setAttribute("path", "images/f_dispositivos.gif");
            icon = addNode("icon", "device", "Device", icons);
            icon.setAttribute("path", "images/i_dispositivo.gif");
            icon = addNode("icon", "dnss", "DNS", icons);
            icon.setAttribute("path", "images/f_dns.gif");
            icon = addNode("icon", "dns", "DNS", icons);
            icon.setAttribute("path", "images/i_dns.gif");
            icon = addNode("icon", "resources", "Resources", icons);
            icon.setAttribute("path", "images/f_estrategias.gif");
            icon = addNode("icon", "resourcetype", "ResourceType", icons);
            icon.setAttribute("path", "images/f_resourcetype.gif");
            icon = addNode("icon", "sysresources", "SysResources", icons);
            icon.setAttribute("path", "images/f_sistema.gif");
            icon = addNode("icon", "resourcer", "Resource", icons);
            icon.setAttribute("path", "images/i_recurso_rojo.gif");
            icon = addNode("icon", "resourcev", "Resource", icons);
            icon.setAttribute("path", "images/i_recurso_verde.gif");

            ////////////////////

            icon = addNode("icon", "flows", "Flows", icons);
            icon.setAttribute("path", "images/f_flujos.gif");
            icon = addNode("icon", "flow", "Flow", icons);
            icon.setAttribute("path", "images/i_flujo.gif");

            /////////////////

            icon = addNode("icon", "languages", "Languages", icons);
            icon.setAttribute("path", "images/f_idioma.gif");
            icon = addNode("icon", "language", "Language", icons);
            icon.setAttribute("path", "images/i_idioma.gif");
            icon = addNode("icon", "metadatas", "Metadatas", icons);
            icon.setAttribute("path", "images/f_metadatos.gif");
            icon = addNode("icon", "metadata", "Metadata", icons);
            icon.setAttribute("path", "images/i_metadata.gif");
            icon = addNode("icon", "camps", "Camps", icons);
            icon.setAttribute("path", "images/f_camp.gif");
            icon = addNode("icon", "campv", "Camp", icons);
            icon.setAttribute("path", "images/i_camp.gif");
            icon = addNode("icon", "campr", "Camp", icons);
            icon.setAttribute("path", "images/i_camp_r.gif");
            icon = addNode("icon", "templates", "Templates", icons);
            icon.setAttribute("path", "images/f_plantillas.gif");
            icon = addNode("icon", "templater", "Template", icons);
            icon.setAttribute("path", "images/i_plantilla_rojo.gif");
            icon = addNode("icon", "templatev", "Template", icons);
            icon.setAttribute("path", "images/i_plantilla_verde.gif");
            icon = addNode("icon", "rules", "Rules", icons);
            icon.setAttribute("path", "images/f_reglas.gif");
            icon = addNode("icon", "rule", "Rule", icons);
            icon.setAttribute("path", "images/i_regla.gif");
            icon = addNode("icon", "userreps", "UserReps", icons);
            icon.setAttribute("path", "images/f_usuarios.gif");
            icon = addNode("icon", "userrep", "UserRep", icons);
            icon.setAttribute("path", "images/i_repositoriousuarios.gif");
            icon = addNode("icon", "role", "Role", icons);
            icon.setAttribute("path", "images/i_rol.gif");

            ///////////////////////////

            //menus
            icon = addNode("icon", "trans", "Transparent", icons);
            icon.setAttribute("path", "images/trans.gif");

            //////////////////

            icon = addNode("icon", "refresh", "Refresh", icons);
            icon.setAttribute("path", "images/refresh.gif");
            icon = addNode("icon", "edit", "Edit", icons);
            icon.setAttribute("path", "images/edit.gif");
            icon = addNode("icon", "remove", "Remove", icons);
            icon.setAttribute("path", "images/remove.gif");
            icon = addNode("icon", "add", "Add", icons);
            icon.setAttribute("path", "images/add.gif");
            icon = addNode("icon", "active", "Active", icons);
            icon.setAttribute("path", "images/active.gif");
            icon = addNode("icon", "unactive", "Unactive", icons);
            icon.setAttribute("path", "images/unactive.gif");
            icon = addNode("icon", "trash", "Trash", icons);
            icon.setAttribute("path", "images/papelera.gif");
            icon = addNode("icon", "catalog", "Catalog", icons);
            icon.setAttribute("path", "images/catalogo.gif");//icon-pagweba.gif


            Iterator it = ext.iterator();
            while (it.hasNext()) {
                SWBTreeExt e = (SWBTreeExt) it.next();
                e.initTree(user, res, isFilter);
            }

            addServer(user, res, isFilter);

        } catch (Exception e) {
            log.error(e);
            return getError(3);
        }

        //System.out.println("dom: " + SWBUtils.XML.domToXml(dom, true));
        return dom;
    }

    /**
     * @param user
     * @param src
     * @return
     */
    @Override
    public Document initTreeFilter(User user, Document src)
    {
        //System.out.println("initTreeFilter");
        Document doc = initTree(user, src);
        //RevisaNodo(doc.getFirstChild());
        return doc;
    }

    /**
     * @param e
     * @return
     */
    public boolean isNameValid(Element e)
    {

        for (int i = 0; i < namevalids.length; i++) {
            if (e.getNodeName().equals(namevalids[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param ele
     */
    public void RevisaNodo(Node ele) {
        Vector vnodes = new Vector();
        NodeList nodes = ele.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            vnodes.add(nodes.item(i));
        }
        for (int i = 0; i < vnodes.size(); i++) {
            if (vnodes.elementAt(i) instanceof Element) {
                Element e = (Element) vnodes.elementAt(i);
                if (!isNameValid(e) || !isValid(e.getAttribute("reload"))) {
                    ele.removeChild((Node) vnodes.elementAt(i));
                } else {
                    RevisaNodo(e);
                }
            } else {
                RevisaNodo((Node) vnodes.elementAt(i));
            }
        }
    }

    /**
     * @param path
     * @return
     */
    public boolean isValid(String path) {
        if (path == null) {

            return true;
        }
        StringTokenizer st = new StringTokenizer(path, ".");
        if (st.countTokens() > 0) {
            String pathinit = st.nextToken();
            for (int i = 0; i < pathValids.length; i++) {
                if (pathinit.equals(pathValids[i])) {
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    @Override
    public void doGateway(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        //System.out.println("doGateway");
        PrintWriter out = response.getWriter();
        ServletInputStream in = request.getInputStream();
        Document dom = SWBUtils.XML.xmlToDom(in);
        if (!dom.getFirstChild().getNodeName().equals("req")) {
            response.sendError(404, request.getRequestURI());
            return;
        }
        String cmd = null;
        if (dom.getElementsByTagName("cmd").getLength() > 0) {
            cmd = dom.getElementsByTagName("cmd").item(0).getFirstChild().getNodeValue();
        }

        if (cmd == null) {
            response.sendError(404, request.getRequestURI());
            return;
        }
        String ret = "";

        //System.out.println("doGateWay: "+cmd);
        try {
            Document res = null;
            if (cmd.equals("update")) {
                res = updateFilter(cmd, dom, paramRequest.getUser(), request, response);
            } else if (cmd.equals("getElements")) {
                res = getElements(cmd, dom, paramRequest.getUser(), request, response);
            } else if (cmd.equals("getMenus")) {
                res = getMenus(cmd, dom, paramRequest.getUser(), request, response);
            } else if (cmd.equals("getFilter")) {
                res = getFilter(cmd, dom, paramRequest.getUser(), request, response);
            } else {
                res = getService(cmd, dom, paramRequest.getUser(), request, response);
            }
            if (res == null) {
                ret = SWBUtils.XML.domToXml(getError(3));
            } else {
                ret = SWBUtils.XML.domToXml(res, true);
            }

        } catch (Exception e) {
            log.error(e);
        }

        //System.out.print("XML(" + cmd + "):" + ret);

        out.print(new String(ret.getBytes()));

    }

    @Override
    public Document getService(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {
        //System.out.println("getService");
        if (cmd.equals("initTree")) {
            return initTree(user, src);
        } else if (cmd.equals("initTreeFilter")) {
            return initTreeFilter(user, src);
        } else if (cmd.startsWith("getPath.")) {
            return getPath(user, src, cmd.substring("getPath.".length()));
        } else {
            return getDocument(user, src, cmd);
        }
    }

    /**
     * @param cmd
     * @param src
     * @param user
     * @param request
     * @param response
     * @return
     */
    public Document add(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {
        //SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        Document doc = null;
        try {
            doc = SWBUtils.XML.getNewDocument();
            Element res = doc.createElement("res");
            doc.appendChild(res);
            if (src.getElementsByTagName("filter").getLength() > 0) {
                Element efilter = (Element) src.getElementsByTagName("filter").item(0);
                String description = "";
                if (efilter.getElementsByTagName("description").getLength() > 0) {
                    Element edescription = (Element) efilter.getElementsByTagName("description").item(0);
                    org.w3c.dom.Text etext = (org.w3c.dom.Text) edescription.getFirstChild();
                    description = etext.getNodeValue();
                }
                String name = efilter.getAttribute("name");
                UserRepository aws = SWBContext.getAdminRepository();
                AdminFilter filter = AdminFilter.ClassMgr.createAdminFilter(aws);
                filter.setTitle(name);
                filter.setDescription(description);

                Document xmlfilter = SWBUtils.XML.getNewDocument();
                Element newnode = (Element) xmlfilter.importNode(efilter, true);
                xmlfilter.appendChild(newnode);
                filter.setXml(SWBUtils.XML.domToXml(xmlfilter));
                try {
                    //filter.create();
                    newnode.setAttribute("id", String.valueOf(filter.getId()));
                    filter.setXml(SWBUtils.XML.domToXml(xmlfilter));
                    //filter.update();
                    addElement("filter", String.valueOf(filter.getId()), res);
                    return doc;
                } catch (Exception afe) {
                    //afe.printStackTrace(System.out);
                    addElement("err", afe.getMessage(), res);
                    log.error(afe);
                }
            } else {
                addElement("err", "The element filter was not found", res);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return doc;
    }

    /**
     * @param cmd
     * @param src
     * @param user
     * @param request
     * @param response
     * @return
     */
    public Document update(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response) {
        UserRepository aws = SWBContext.getAdminRepository();
        Document doc = null;
        try {
            doc = SWBUtils.XML.getNewDocument();
            Element res = doc.createElement("res");
            doc.appendChild(res);
            if (src.getElementsByTagName("filter").getLength() > 0) {
                Element efilter = (Element) src.getElementsByTagName("filter").item(0);
                String description = "";
                if (efilter.getElementsByTagName("description").getLength() > 0) {
                    Element edescription = (Element) efilter.getElementsByTagName("description").item(0);
                    org.w3c.dom.Text etext = (org.w3c.dom.Text) edescription.getFirstChild();
                    description = etext.getNodeValue();
                }
                String name = efilter.getAttribute("name");
                //AdminFilter filter=AdminFilter.getAdminFilter(efilter.getAttribute("id"),efilter.getAttribute("topicmap"));
                AdminFilter filter = AdminFilter.ClassMgr.getAdminFilter(efilter.getAttribute("id"), aws);
                filter.setTitle(name);
                filter.setDescription(description);
                //filter.setTopicMapId(efilter.getAttribute("topicmap"));
                Document xmlfilter = SWBUtils.XML.getNewDocument();

                Element newnode = (Element) xmlfilter.importNode(efilter, true);
                xmlfilter.appendChild(newnode);

                System.out.println("XML Applet: "+SWBUtils.XML.domToXml(xmlfilter,true));

                filter.setXml(SWBUtils.XML.domToXml(xmlfilter));
                try {
                    newnode.setAttribute("id", String.valueOf(filter.getId()));
                    filter.setXml(SWBUtils.XML.domToXml(xmlfilter));
//                    filter.update();
                    addElement("filter", String.valueOf(filter.getId()), res);
                } catch (Exception afe) {
                    //afe.printStackTrace(System.out);
                    addElement("err", afe.getMessage(), res);
                    log.error(afe);
                }
            } else {
                addElement("err", "The element filter was not found", res);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return doc;
    }

    /**
     * @param cmd
     * @param src
     * @param user
     * @param request
     * @param response
     * @return
     */
    public Document getFilter(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {
        //System.out.println("getFilter");
        UserRepository map = SWBContext.getAdminRepository();
        Document docres = null;
        try {
            docres = SWBUtils.XML.getNewDocument();
            Element res = docres.createElement("res");
            docres.appendChild(res);
            if (src.getElementsByTagName("id").getLength() > 0) {
                Element eid = (Element) src.getElementsByTagName("id").item(0);
                org.w3c.dom.Text etext = (org.w3c.dom.Text) eid.getFirstChild();
                String id = etext.getNodeValue();
                AdminFilter filter = AdminFilter.ClassMgr.getAdminFilter(id, map);

                Document exmlfilter = SWBUtils.XML.xmlToDom(filter.getXml());

                //System.out.println("Filter XML:"+SWBUtils.XML.domToXml(exmlfilter,true));


                Node node = docres.importNode(exmlfilter.getFirstChild(), true);
                res.appendChild(node);
                NodeList nodes = docres.getElementsByTagName("node");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Element enode = (Element) nodes.item(i);
                    String topicid = enode.getAttribute("id");
                    String path = topicid;
                    String topicmap = enode.getAttribute("topicmap");
                    WebSite topicMap = SWBContext.getWebSite(topicmap);
                    if (topicMap != null) {
                        WebPage topic = topicMap.getWebPage(topicid);
                        if (topic != null) {
                            while (topic.getParent() != null) {
                                path = topic.getParent().getId() + "|" + path;
                                topic = topic.getParent();
                            }
                        }
                    }
                    enode.setAttribute("path", path);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return docres;
    }

    /** Add or update the filter resource configuration
     * @param cmd, text command action to do
     * @param src, source document that hold the resource configuration
     * @param user, a session User
     * @param request, parameters, input data
     * @param response, an anwer to the user request
     * @return return an updated dom document
     */
    public Document updateFilter(String cmd, Document src, User user, HttpServletRequest request, HttpServletResponse response)
    {
        if (src.getElementsByTagName("filter").getLength() > 0) {
            Element efilter = (Element) src.getElementsByTagName("filter").item(0);
            if (efilter.getAttribute("id") == null || efilter.getAttribute("id").equals("")) {
                return add(cmd, src, user, request, response);
            } else {
                return update(cmd, src, user, request, response);
            }
        }
        return null;
    }

    /** User View of the SWBAFilters Resource; it shows a resource filter configuration,
     * configure in wich webpage it shows, in the Semantic WebBuilder application
     * @param request, parameters, input data
     * @param response, an answer to the user request
     * @param paramsRequest, a list of objects (Action, user, WebPage, ...)
     * @throws SWBResourceException, a Resource Exc
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        //System.out.println("doView");

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        UserRepository map = SWBContext.getAdminRepository();
        User user = paramRequest.getUser();
        PrintWriter out = response.getWriter();
        
        out.println("<script type=\"text/javascript\">");
        out.println("  dojo.require(\"dijit.layout.SplitContainer\");");
        out.println("  dojo.require(\"dijit.layout.ContentPane\");");
        out.println("</script>");



        String act = "view";
        if (request.getParameter("act") != null) {
            act = request.getParameter("act");
        }
        if (act.equals("remove") && request.getParameter("id") != null) {
            //  TODO:
            // Borrar filtros aplicados a los usuarios
            //WebSite mapadmin=SWBContext.getAdminWebSite();
//            UserRepository repository=mapadmin.getUserRepository();
//            Iterator<User> users=repository.listUsers();
//            while(users.hasNext())
//            {
//                User recuser=users.next();
//
//            }
            String id = request.getParameter("id");
            AdminFilter filter = AdminFilter.ClassMgr.getAdminFilter(id, map);
            filter.remove();
            act = "view";
        } else if (act.equals("add")) {

            SWBResourceURL url = paramRequest.getRenderUrl();
            url.setMode("gateway");
            url.setCallMethod(url.Call_DIRECT);
            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            out.println("<div class=\"applet\">");
            out.println("<APPLET id=\"editfilter\" name=\"editfilter\" code=\"applets.filters.EditFilter.class\" codebase=\""+SWBPlatform.getContextPath()+"/\" ARCHIVE=\"swbadmin/lib/SWBAplEditFilters.jar, swbadmin/lib/SWBAplCommons.jar\" WIDTH=\"100%\" HEIGHT=\"450\">");
            out.println("<PARAM NAME =\"cgipath\" VALUE=\""+url+"\">");
            out.println("<PARAM NAME =\"locale\" VALUE=\""+user.getLanguage()+"\">");
            out.println("<PARAM NAME =\"tm\" VALUE=\""+map.getId()+"\">");
            url=paramRequest.getRenderUrl();
            url.setMode(url.Mode_VIEW);
            out.println("<PARAM NAME =\"location\" VALUE=\""+url+"\">");
            out.println("</APPLET>");
            out.println("</div>");

//            out.println("<div dojoType=\"dijit.layout.SplitContainer\" orientation=\"horizontal\" sizerWidth=\"7\" activeSizing=\"false\" style=\"border: 1px solid #bfbfbf; float: left; width: 600px; height: 400px;\">"); //
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"20\" sizeShare=\"20\">");
//            out.println("   <div dojoType=\"dijit.layout.AccordionPane\" title=\"Sitios\" selected=\"true\">");
//            out.println("             <include src=\""+SWBPlatform.getContextPath()+"/swbadmin/jsp/treeWidget.jsp?id=mtree\"/>");
//            out.println("   </div>");
//            out.println("</div>");
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"50\" sizeShare=\"50\">");
//            //out.println("without active resizing, a smaller sizer, different starting sizes and minimum sizes");
//
//            out.println("<div dojoType=\"dijit.layout.SplitContainer\" orientation=\"vertical\" sizerWidth=\"7\" activeSizing=\"true\" style=\"border: 1px solid #bfbfbf; float: left; \">"); // width: 400px; margin-right: 30px; height: 300px;
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"10\" sizeShare=\"50\">");
//            out.println("<p>SubMenús</p>");
//            out.println("<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" name=\"act\" id=\"act\" value=\"foo\">");
//            out.println("<label for=\"act\">Activar</label><br/>");
//            out.println("<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" name=\"add\" id=\"add\" value=\"foo\">");
//            out.println("<label for=\"add\">Agregar plantilla</label><br/>");
//            out.println("<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" name=\"del\" id=\"del\" value=\"foo\">");
//            out.println("<label for=\"del\">Eliminar Plantilla</label><br/>");
//            out.println("<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" name=\"c3\" id=\"c3\" value=\"foo\">");
//            out.println("<label for=\"c3\">Editar plantilla</label><br/>");
//            out.println("</div>");
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"20\" sizeShare=\"50\" style=\"background-color: yellow; border: 3px solid purple;\">");
//            out.println("<p>Comportamientos (TABS)</p>");
//            out.println("<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" name=\"cb1\" id=\"cb1\" value=\"foo\">");
//            out.println("<label for=\"cb1\">Informacion</label><br/>");
//            out.println("<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" name=\"cb2\" id=\"cb2\" value=\"foo\">");
//            out.println("<label for=\"cb2\">Editar plantilla</label><br/>");
//            out.println("</div>");
////            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"10\" sizeShare=\"50\">");
////            out.println("    with active resizing");
////            out.println("</div>");
//            out.println("</div>");
//
//
//
//
//            out.println("</div>");
//            out.println("</div>");


            out.println("</fieldset>");
            out.println("<fieldset>");
            SWBResourceURL urlb = paramRequest.getRenderUrl();
            urlb.setParameter("act", "view");
            out.println("<input type=\"button\" name=\"bckButton\" onclick=\"submitUrl('" + urlb + "',this); return false;\" value=\"" + paramRequest.getLocaleString("btnCancel") + "\">");
            out.println("</fieldset>");
            out.println("</div>");
            out.println("\r\n<script>\r\n");
            out.println("\r\nfunction doView(){\r\n");
            url = paramRequest.getRenderUrl();
            url.setMode(url.Mode_VIEW);
            out.println("location='" + url + "';\r\n");
            out.println("\r\n}\r\n");
            out.println("</script>\r\n");
        } else if (act.equals("edit") && request.getParameter("id") != null) {
            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            out.println("<div class=\"applet\">");
            out.println("<APPLET id=\"editfilter\" name=\"editfilter\" code=\"applets.filters.EditFilter.class\" codebase=\"" + SWBPlatform.getContextPath() + "/\" ARCHIVE=\"swbadmin/lib/SWBAplEditFilters.jar, swbadmin/lib/SWBAplCommons.jar\" WIDTH=\"100%\" HEIGHT=\"450\">");
            SWBResourceURL url = paramRequest.getRenderUrl();
            url.setMode("gateway");
            url.setCallMethod(url.Call_DIRECT);
            out.println("<PARAM NAME =\"idfilter\" VALUE=\"" + request.getParameter("id") + "\">");
            out.println("<PARAM NAME =\"cgipath\" VALUE=\"" + url + "\">");
            out.println("<PARAM NAME =\"locale\" VALUE=\"" + user.getLanguage() + "\">");
            out.println("<PARAM NAME =\"tm\" VALUE=\"" + map.getId() + "\">");
            url = paramRequest.getRenderUrl();
            url.setMode(url.Mode_VIEW);
            out.println("<PARAM NAME =\"location\" VALUE=\"" + url + "\">");
            out.println("</APPLET>");
            out.println("</div>");
//            out.println("<div dojoType=\"dijit.layout.SplitContainer\" orientation=\"horizontal\" sizerWidth=\"7\" activeSizing=\"false\" style=\"border: 1px solid #bfbfbf; float: left; width: 400px; height: 300px;\">");
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"20\" sizeShare=\"20\">");
//            out.println("Aquí va el arbol");
//            out.println("</div>");
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"50\" sizeShare=\"50\">");
//            //out.println("without active resizing, a smaller sizer, different starting sizes and minimum sizes");
//
//            out.println("<div dojoType=\"dijit.layout.SplitContainer\" orientation=\"vertical\" sizerWidth=\"7\" activeSizing=\"true\" style=\"border: 1px solid #bfbfbf; float: left; margin-right: 30px;  width: 400px; height: 300px;\">");
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"10\" sizeShare=\"50\">");
//            out.println("SubMenús");
//            out.println("</div>");
//            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"20\" sizeShare=\"50\" style=\"background-color: yellow; border: 3px solid purple;\">");
//            out.println("Comportamientos (TABS)");
//            out.println("</div>");
////            out.println("<div dojoType=\"dijit.layout.ContentPane\" sizeMin=\"10\" sizeShare=\"50\">");
////            out.println("    with active resizing");
////            out.println("</div>");
//            out.println("</div>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            SWBResourceURL urlb = paramRequest.getRenderUrl();
            urlb.setParameter("act", "view");
            out.println("<input type=\"button\" name=\"bckButton\" onclick=\"submitUrl('" + urlb + "',this); return false;\" value=\"" + paramRequest.getLocaleString("btnCancel") + "\">");
            out.println("</fieldset>");
            out.println("</div>");
            out.println("\r\n<script>\r\n");
            out.println("\r\nfunction doView(){\r\n");
            url = paramRequest.getRenderUrl();
            url.setMode(url.Mode_VIEW);
            out.println("location='" + url + "';\r\n");
            out.println("\r\n}\r\n");
            out.println("</script>\r\n");
        }
        if (act.equals("view")) {
            SWBResourceURL url = paramRequest.getRenderUrl();
            url.setMode(url.Mode_VIEW);
            //url.setCallMethod(url.Call_DIRECT);   
            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            out.println("<table width=\"100%\" cellpadding=\"10\" cellspacing=\"0\">");
            out.println("<tr>");

            out.println("<th colspan=\"2\" align=\"center\">");
            out.println(paramRequest.getLocaleString("msgAction"));
            out.println("</th>");

            out.println("<th>");
            out.println(paramRequest.getLocaleString("msgIdentifier"));
            out.println("</th>");

            out.println("<th >");
            out.println(paramRequest.getLocaleString("msgFilter"));
            out.println("</th>");

            out.println("<th >");
            out.println(paramRequest.getLocaleString("msgDescription"));
            out.println("</th>");

            out.println("</tr>");

//            String rowColor="";
//            boolean cambiaColor = true;

            Iterator<AdminFilter> filters = AdminFilter.ClassMgr.listAdminFilters(map);
            while (filters.hasNext()) {
                AdminFilter filter = filters.next();

                out.println("<tr >");     //bgcolor=\""+rowColor+"\"

                out.println("<td  colspan=\"2\" align=\"center\">");

                SWBResourceURL urlRemove = paramRequest.getRenderUrl();
                urlRemove.setParameter("act", "remove");
                urlRemove.setParameter("id", filter.getId());
                out.println("<a href=\"#\" onclick=\"if(confirm('" + paramRequest.getLocaleString("msgAlertShureRemoveFilter") + "?') ) submitUrl('" + urlRemove.toString() + "',this);return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" title=\"" + paramRequest.getLocaleString("msgLinkRemove") + "\"></a>&nbsp;");

                SWBResourceURL urlEdit = paramRequest.getRenderUrl();
                urlEdit.setParameter("act", "edit");
                urlEdit.setParameter("id", filter.getId());
                out.println("<a href=\"#\" onclick=\"submitUrl('" + urlEdit.toString() + "',this); return false;\" ><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/editar_1.gif\" border=\"0\" title=\"" + paramRequest.getLocaleString("msgLinkEdit") + "\"></a>");

                out.println("</td>");

                out.println("<td >");
                out.println(filter.getId());
                out.println("</td>");

                out.println("<td >");
                out.println(filter.getDisplayTitle(user.getLanguage()));
                out.println("</td>");

                out.println("<td >");
                out.println(filter.getDescription());
                out.println("</td>");

                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            Resource base = getResourceBase();
            out.println("<form id=\"" + base.getId() + "/addAdminFilter\" action=\"" + url + "\">");
            out.println("<button dojoType=\"dijit.form.Button\" name=\"op\" onclick=\"submitForm('" + getResourceBase().getId() + "/addAdminFilter'); return false;\">" + paramRequest.getLocaleString("msgBtnAdd") + "</button>");
            //out.println("<input type=\"submit\" name=\"op\" value=\""+paramRequest.getLocaleString("msgBtnAdd")+"\">");
            out.println("<input type=\"hidden\" name=\"act\" value=\"add\">");
            out.println("</form>");
            out.println("</fieldset>");
            out.println("</div>");
        }
    }


    /**
     * Get true if a Semantic objects have Herarquical Nodes
     * @param obj, semantic object to eval
     * @return boolean, true if semantic object have Herarquical nodes or False.
     */
    public boolean hasHerarquicalNodes(SemanticObject obj)
    {
        //System.out.println("hasHerarquicalNodes");
        boolean ret = false;
        Iterator<SemanticObject> it = obj.getSemanticClass().listHerarquicalNodes();
        if (it.hasNext()) {
            ret = true;
        }
        return ret;
    }


    /**
     *  Add server to dom document
     * @param user, used to eval access to each element tree
     * @param res, element of the tree
     * @param isFilter, to eval if have filter or not
     */
    @Override
    protected void addServer(User user, Element res, boolean isFilter)
    {
        //System.out.println("addServer");
        int access = 2; //AdmFilterMgr.getInstance().haveAccess2Server(user);
        hmclass = new HashMap();
        //tree nodes
        Element root = addNode("node", "server", "Server", res); //Servr por tma.getWebPage("WBAd_sys_Server").getDisplayName(user.getLanguage())
        root.setAttribute("reload", "getServer");
        root.setAttribute("icon", "global");
        root.setAttribute("access", "" + access);

        //addGlobal(user, root, access, isFilter);

        // Carga objetos relacionados
        //loadSemClass(user);

        //WebSites
        Iterator<WebSite> it = sortIterator(SWBContext.listWebSites());
        while (it.hasNext())
        {
            //topicmap
            WebSite tm = it.next();
            if (!tm.isDeleted()) 
            {
                addSemanticObject(user, tm.getSemanticObject(), root, false);
                //addTopicMap(user, tm, root, access, false, isFilter);
            }
        }

//        Iterator itex = ext.iterator();
//        while (itex.hasNext()) {
//            SWBTreeExt e = (SWBTreeExt) itex.next();
//            e.addServer(user, root, isFilter);
//        }
    }



    public void addHerarquicalNodes(User user, SemanticObject obj, Element ele)
    {
        Iterator<SemanticObject> it=SWBComparator.sortSortableObject(obj.getSemanticClass().listHerarquicalNodes());
        while(it.hasNext())
        {
            HerarquicalNode node=new HerarquicalNode(it.next());
            addHerarquicalNode(user,node,obj,ele,false);
        }
    }

    public void addHerarquicalNode(User user, HerarquicalNode node, SemanticObject obj, Element ele, boolean addChilds)
    {
        addChilds=true;
        SemanticClass cls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(node.getHClass().getURI());
        String pf=node.getPropertyFilter();

        Element jobj = addNode("node", node.getURI(), node.getDisplayTitle(user.getLanguage()), ele);
        jobj.setAttribute("reload", "getSemanticObject." + "HN|"+obj.getURI()+"|"+node.getURI());
        jobj.setAttribute("icon", node.getIconClass());
        //jobj.setAttribute("icon", "homev");

        if(cls.isSubClass(FilterableNode.swb_FilterableNode))
        {
            Iterator<SemanticObject> it=SWBObjectFilter.filter(SWBComparator.sortSermanticObjects(user.getLanguage(), obj.getModel().listInstancesOfClass(cls)),pf);
            if(addChilds)
            {
                while(it.hasNext())
                {
                    SemanticObject so=it.next();
                    addSemanticObject(user,so,jobj,false);
                }
            }
        }
    }


     /**
     *  Add web site to dom document
     * @param user, used to eval access to each element tree
     * @param tm,
     * @param root, first element of the tree
     * @param access, level of the user access
     * @param loadChild, for load root childs element
     * @param isFilter, to eval if have filter or not
     */
    protected void addSemanticObject(User user, SemanticObject obj, Element node, boolean addChilds)
    //public void addSemanticObject(JSONArray arr, SemanticObject obj, boolean addChilds, boolean addDummy, String lang) throws JSONException
    {
        addChilds=true;                             //siempre agrega hijos
        //System.out.println("addSemanticObject");
        Element events = null;
        Element event = null;
        SemanticObject aux=null;

        boolean hasChilds=false;
        SemanticClass cls=obj.getSemanticClass();

        //Active
        boolean active=false;
        SemanticProperty activeprop=cls.getProperty("active");
        if(activeprop!=null)
        {
            active=obj.getBooleanProperty(activeprop);
        }

        String icon=SWBContext.UTILS.getIconClass(obj);

        Element jobj = addNode("node", obj.getURI(), obj.getDisplayName(user.getLanguage()), node);
        jobj.setAttribute("reload", "getSemanticObject." + obj.getURI());
        jobj.setAttribute("icon", icon);
        //jobj.setAttribute("icon", "homev");


        hasChilds=hasHerarquicalNodes(obj);
        if(addChilds || !hasChilds)
        {
            addHerarquicalNodes(user, obj, jobj);

            Iterator<SemanticObject> it=obj.listHerarquicalChilds();
            if(addChilds)
            {
                Iterator<SemanticObject> it2=SWBComparator.sortSermanticObjects(user.getLanguage(),it);
                while(it2.hasNext())
                {
                    SemanticObject ch=it2.next();
                    if(ch.instanceOf(FilterableNode.swb_FilterableNode))
                        addSemanticObject(user,ch,jobj,false);
                }
            }else
            {
                while(it.hasNext())
                {
                    SemanticObject ch=it.next();
                    if(ch.instanceOf(FilterableNode.swb_FilterableNode))
                    {
                        hasChilds=true;
                        aux=ch;
                        break;
                    }
                }
            }
        }
        if(hasChilds && !addChilds)
        {
            if(aux!=null)
            {
                Element child = addNode("node", aux.getId(), aux.getDisplayName(user.getLanguage()), jobj);
                child.setAttribute("icon", "menu");
            }

            events = addNode("events", "events", "Events", jobj);
            event = addNode("willExpand", "willExpand", "WillExpand", events);
            event.setAttribute("action", "reload");
        }
    }


     /**
     *  Add web site to dom document
     * @param user, used to eval access to each element tree
     * @param tm,
     * @param root, first element of the tree
     * @param access, level of the user access
     * @param loadChild, for load root childs element
     * @param isFilter, to eval if have filter or not
     */
    protected void addSemanticClass(User user, SemanticClass sc, Element node, boolean addChilds)
    //public void addSemanticObject(JSONArray arr, SemanticObject obj, boolean addChilds, boolean addDummy, String lang) throws JSONException
    {
        //System.out.println("addSemanticClass:"+sc+" "+node);
        String lang=user.getLanguage();

        Element classele = addNode("topic", sc.getClassId(), sc.getDisplayName(user.getLanguage()), node);
        classele.setAttribute("reload", "getTopic.SC|" + sc.getClassId());
        classele.setAttribute("icon", "sitev");
        classele.setAttribute("topicmap", "SWBAdmin");

        Element etp = this.addNode("topic", sc.getClassId() + ";"+"add", getLocaleString("add", lang), classele);
        etp.setAttribute("reload", "getTopic.SCA|" + sc.getClassId() + "|" + "add");
        etp.setAttribute("topicmap", "SWBAdmin");
        //etp.setAttribute("icon", "menu");

        etp = this.addNode("topic", sc.getClassId() + ";"+"edit", getLocaleString("edit", lang), classele);
        etp.setAttribute("reload", "getTopic.SCA|" + sc.getClassId() + "|" + "edit");
        etp.setAttribute("topicmap", "SWBAdmin");
        //etp.setAttribute("icon", "menu");

        etp = this.addNode("topic", sc.getClassId() + ";"+"delete", getLocaleString("delete", lang), classele);
        etp.setAttribute("reload", "getTopic.SCA|" + sc.getClassId() + "|" + "delete");
        etp.setAttribute("topicmap", "SWBAdmin");
        //etp.setAttribute("icon", "menu");

        if(sc.isSubClass(org.semanticwb.model.Activeable.swb_Activeable ))
        {
            Element etp4 = this.addNode("topic", sc.getClassId() + ";"+"active", getLocaleString("active",lang)+"/"+getLocaleString("unactive",lang), classele);
            etp4.setAttribute("reload", "getTopic.SCA|" + sc.getClassId() + "|" + "active");
            etp4.setAttribute("topicmap", "SWBAdmin");
            //etp4.setAttribute("icon", "menu");
        }
    }


     /**
     *  Add web site to dom document
     * @param user, used to eval access to each element tree
     * @param tm,
     * @param root, first element of the tree
     * @param access, level of the user access
     * @param loadChild, for load root childs element
     * @param isFilter, to eval if have filter or not
     */
    @Override
    protected void addTopicMap(User user, WebSite tm, Element root, int access, boolean loadChild, boolean isFilter)
    {
        //System.out.println("addTopicMap");
//        if (access != FULL_ACCESS) {
//            access = 2; //AdmFilterMgr.getInstance().haveAccess2TopicMap(user, tm.getId());
//            if (access == NO_ACCESS) {
//                return;
//            }
//        }

        Element topicmap = addNode("node", tm.getId(), tm.getDisplayTitle(user.getLanguage()), root);
        topicmap.setAttribute("reload", "getTopicMap." + tm.getId());
        topicmap.setAttribute("access", "" + access);
        if (tm.isActive()) {
            topicmap.setAttribute("icon", "sitev");
        } else {
            topicmap.setAttribute("icon", "siter");
        }

        Iterator<String> its = hmclass.keySet().iterator();
        while (its.hasNext()) {
            String sclass = its.next();
            if (!sclass.equals("WebSite") && !sclass.equals("WebPage")) {
                SemanticClass sc = (SemanticClass) hmclass.get(sclass);

                Element classele = this.addNode("node", sc.getClassId(), sc.getName(), topicmap);
                classele.setAttribute("topicmap", tm.getId());
                classele.setAttribute("reload", "getTopic." + tm.getId() + "." + sc.getClassId());
                classele.setAttribute("access", "" + access);
                boolean canModify = true; //AdmFilterMgr.getInstance().haveAccess2System4Filter(user, topic);
                classele.setAttribute("canModify", String.valueOf(canModify));
                classele.setAttribute("icon", "hijov");

                Iterator<SemanticObject> itso = tm.getSemanticObject().getModel().listInstancesOfClass(sc);
                while (itso.hasNext()) {
                    SemanticObject so = itso.next();
                    Element ele = addNode("node", so.getId(), so.getDisplayName(user.getLanguage()), classele);
                    ele.setAttribute("topicmap", sc.getClassId());
                    ele.setAttribute("reload", "getTopic." + tm.getId() + "." + sc.getClassId() + "." + so.getId());
                    ele.setAttribute("access", "" + access);
                    canModify = true; //AdmFilterMgr.getInstance().haveAccess2System4Filter(user, topic);
                    ele.setAttribute("canModify", String.valueOf(canModify));
                    ele.setAttribute("icon", "hijov");

                //System.out.println("---"+so.getDisplayName(user.getLanguage()));
                }
            }
        }
        if(loadChild)
        {
            Iterator itex = ext.iterator();
            while (itex.hasNext()) {
                SWBTreeExt e = (SWBTreeExt) itex.next();
                e.addTopicMap(user, topicmap, tm, access, isFilter);
            }

            // Para cargar Home y sus WebPages
            if (!tm.getId().equals(SWBContext.WEBSITE_GLOBAL)) {
                WebPage tp = tm.getHomePage();
                try {
                    addTopic(user, tp, topicmap);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    /**
     *  Add web pages to dom document
     * @param user, used to eval access to each element tree
     * @param res, element of the tree
     */
    @Override
    protected void addTopic(User user, WebPage tp, Element res)
    {
        //System.out.println("addTopic");
        //WebSite tma=SWBContext.getAdminWebSite();
        Element events = null;
        Element event = null;

        Element topic = addNode("node", tp.getId(), tp.getDisplayName(user.getLanguage()), res);
        topic.setAttribute("reload", "getTopic." + tp.getWebSiteId() + "." + tp.getId());
        if (tp.isActive()) {
            if (tp == tp.getWebSite().getHomePage()) {
                topic.setAttribute("icon", "homev");
            } else {
                topic.setAttribute("icon", "hijov");
            }
        } else {
            if (tp == tp.getWebSite().getHomePage()) {
                topic.setAttribute("icon", "homer");
            } else {
                topic.setAttribute("icon", "hijor");
            }
        }

        //child
        Iterator it = tp.listChilds(user.getLanguage(), true, false, false, false); //getSortChild(false);
        while (it.hasNext()) {
            WebPage tp2 = (WebPage) it.next();
            Element child = addNode("node", tp2.getId(), tp2.getDisplayName(user.getLanguage()), topic);
            child.setAttribute("reload", "getTopic." + tp2.getWebSiteId() + "." + tp2.getId());

            //revisar; se agregó para ver lo de los iconos
            child.setAttribute("access", "2");
            child.setAttribute("canModify", "true");
            ///
            if (!tp2.getParent().getId().equals(tp.getId())) //virtual
            {
                child.setAttribute("icon", "virtual");
                child.setAttribute("alt", "Virtual Section");
            } else {
                if (tp2.isActive()) {
                    child.setAttribute("icon", "hijov");
                } else {
                    child.setAttribute("icon", "hijor");
                }

                //have child
                Iterator it2 = tp2.listChilds(user.getLanguage(), true, false, false, false); //getSortChild(false);
                if (it2.hasNext()) {
                    WebPage tp3 = (WebPage) it2.next();
                    Element child2 = addNode("node", tp3.getId(), tp3.getDisplayName(user.getLanguage()), child);
                    child2.setAttribute("icon", "menu");
                    //TODO: Se puso para ver si se mostraban los iconos
                    child2.setAttribute("access", "2");
                    child2.setAttribute("canModify", "true");
                    child.appendChild(child2);
                } else {
                    child.setAttribute("action", "showurl=" + tp2.getUrl());
                //child.setAttribute("target","work");
                }
                //events
                events = addNode("events", "events", "Events", child);
                event = addNode("willExpand", "willExpand", "WillExpand", events);
                event.setAttribute("action", "reload");
            }

        }
    }
}
