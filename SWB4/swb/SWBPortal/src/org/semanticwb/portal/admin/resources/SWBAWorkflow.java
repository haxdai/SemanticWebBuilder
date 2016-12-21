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
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.PFlow;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.admin.resources.workflow.proxy.WorkflowResponse;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;

// TODO: Auto-generated Javadoc
/**
 * Recurso para la administraci�n de WebBuilder que permite la administraci�n de
 * los flujos de trabajo.
 *
 * WebBuilder administration resource that allows the work flow administration.
 *
 * @author Victor Lorenzana
 */
public class SWBAWorkflow extends GenericResource {
    /** The log. */
    private Logger log = SWBUtils.getLogger(SWBAWorkflow.class);

    /**
     * Creates a new instance of WBAWorkflow.
     */
    public SWBAWorkflow() {}

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

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String act = response.getAction();
        if ("updateWorkflow".equals(act)) {
            //Se recibe el JSON con los nodos seleccionados en la vista.
            BufferedReader reader = request.getReader();
            String line = null;
            StringBuilder body = new StringBuilder();
            while((line = reader.readLine()) != null) {
                body.append(line);
            }
            reader.close();
            
            String res = null;
            try {
                JSONObject payload = new JSONObject(body.toString());
                GenericObject gobj = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
                
                if (null != gobj && gobj instanceof PFlow) {
                    PFlow flow = (PFlow)gobj;
                    res = getXMLWorkflowData(flow, payload);
                    //Set PFlow XML data
                    flow.setXml(res);
                }
            } catch (JSONException jsex) {
                log.error("Error getting response body", jsex);
            } catch (SWBException swbex) {
                log.error("Error getting response body", swbex);
            }
            
            if (null != request.getParameter("suri")) {
                response.setRenderParameter("suri", request.getParameter("suri"));
            }
        } else {
            super.processAction(request, response);
        }
    }
    

    public String getXMLWorkflowData(PFlow flow, JSONObject payload) throws JSONException, SWBException {
        Document old = SWBUtils.XML.copyDom(flow.getDom());
        Element oldFlows = (Element) old.getElementsByTagName("workflows").item(0);
        
        Element root = old.createElement("workflow");
        root.setAttribute("id", flow.getURI());
        root.setAttribute("name", payload.optString("name"));
        double verNum = Double.parseDouble(payload.optString("version", "1.0"));
        root.setAttribute("version", String.valueOf(verNum + 1));
        
        Element desc = old.createElement("description");
        desc.setTextContent("_");
        
        root.appendChild(desc);
        
        //Add activities
        JSONArray arr =  payload.optJSONArray("activities");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject item = arr.getJSONObject(i);
            String name = item.optString("name");
            String type = item.optString("type");
            String description = item.optString("description");
            
            //Ignore start and end activities because SWBDocumentsToAuthorize expects XML activities in this order
            if ((!name.isEmpty() && !description.isEmpty()) && !"AuthorActivity".equals(type) && !"EndActivity".equals(type)) {
                Element act = old.createElement("activity");
                act.setAttribute("type", item.optString("type"));
                act.setAttribute("name", item.optString("name"));
                
                Element descr = old.createElement("description");
                descr.setTextContent(description);
                act.setAttribute("days", item.optString("days"));
                act.setAttribute("hours", item.optString("hours"));
                act.appendChild(descr);

                
                //Get roles
                JSONArray actRoles = item.optJSONArray("roles");
                if (null != actRoles && actRoles.length() > 0) {
                    for (int j = 0; j < actRoles.length(); j++) {
                        JSONObject uitem = actRoles.getJSONObject(j);
                        String uid = uitem.optString("id");
                        String uname = uitem.optString("name");
                        String repo = uitem.optString("repository");
                        if (repo.isEmpty()) repo = SWBContext.getAdminRepository().getId();
                        
                        if (!uid.isEmpty() && !uname.isEmpty()) {
                            Element role = old.createElement("role");
                            role.setAttribute("id", uid);
                            role.setAttribute("name", uname);    
                            role.setAttribute("repository", repo);
                            act.appendChild(role);
                        }
                    }
                }
                
                //Get users
                JSONArray actUsers = item.optJSONArray("users");
                if (null != actUsers && actUsers.length() > 0) {
                    for (int j = 0; j < actUsers.length(); j++) {
                        JSONObject uitem = actUsers.getJSONObject(j);
                        String uid = uitem.optString("id");
                        String uname = uitem.optString("name");
                        if (!uid.isEmpty() && !uname.isEmpty()) {
                            Element usr = old.createElement("user");
                            usr.setAttribute("id", uid);
                            usr.setAttribute("name", uname);
                            act.appendChild(usr);
                        }
                    }
                }
                
                root.appendChild(act);
            }
        }
        
        //Add start and end activities
        Element startAct = old.createElement("activity");
        startAct.setAttribute("name", "Generador de contenido");
        startAct.setAttribute("type", "AuthorActivity");
        root.appendChild(startAct);

        Element endAct = old.createElement("activity");
        endAct.setAttribute("name", "Terminar flujo");
        endAct.setAttribute("type", "EndActivity");
        root.appendChild(endAct);
        
        
        //Add links
        arr =  payload.optJSONArray("links");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject link = arr.getJSONObject(i);
            boolean publish = link.optBoolean("publish");
            String type = link.optString("type");
            String from = link.optString("from");
            String to = link.optString("to");
            
            if (!type.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                if (!type.equals("startLink")) {
                    String authorized = "authorized".equals(type) ? "true" : "false";
                    Element elink = old.createElement("link");
                    elink.setAttribute("authorized", authorized);
                    elink.setAttribute("from", from);
                    elink.setAttribute("publish", String.valueOf(publish));
                    elink.setAttribute("to", to);
                    elink.setAttribute("type", type);
                    
                    Element mailService = old.createElement("service");
                    mailService.setTextContent("mail");
                    elink.appendChild(mailService);
                    
                    if (to.equals("Generador de contenido")) {
                        Element service = old.createElement("service");
                        service.setTextContent("true".equals(authorized) ? "authorize" : "noauthorize");
                        elink.appendChild(service);
                    } else if (to.equals("Terminar flujo")) {
                        Element service = old.createElement("service");
                        if (publish) {
                            service.setTextContent("publish");
                            elink.appendChild(service);
                        }
                        
                        service = old.createElement("service");
                        service.setTextContent("true".equals(authorized) ? "authorize" : "noauthorize");
                        elink.appendChild(service);
                    } else if (!"true".equals(authorized)) {
                        Element service = old.createElement("service");
                        service.setTextContent("noauthorize");
                    }
                    
                    root.appendChild(elink);
                }
            }
        }
        
        //Add resource types
        arr =  payload.optJSONArray("resourceTypes");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject item = arr.getJSONObject(i);
            Element rt = old.createElement("resourceType");
            rt.setAttribute("id", item.optString("id"));
            rt.setAttribute("name", item.optString("name"));
            rt.setAttribute("topicmap", item.optString("topicmap"));
            root.appendChild(rt);
        }
        
        oldFlows.insertBefore(root, oldFlows.getFirstChild()); //This is because PFlowManager expects first child to be the last version
        return SWBUtils.XML.domToXml(old);
    };
    
    /**
 * Gets the workflow.
 * 
 * @param res the res
 * @param tm the tm
 * @param src the src
 * @return the workflow
 */
    public void getWorkflow(Element res, String tm, Document src)
    {
        if (src.getElementsByTagName("id").getLength() > 0)
        {
            Element eid = (Element) src.getElementsByTagName("id").item(0);
            Text etext = (Text) eid.getFirstChild();
            String id = etext.getNodeValue();
            PFlow pflow = (PFlow) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(id);
            try
            {
                String xml = pflow.getXml();

                Document doc = SWBUtils.XML.xmlToDom(xml);

                Element ele = (Element) doc.getElementsByTagName("workflow").item(0);

                ele.setAttribute("name", pflow.getTitle());
                Element desc = doc.createElement("description");
                desc.appendChild(doc.createTextNode(pflow.getDescription() != null ? pflow.getDescription() : "_"));

                ele.replaceChild(desc, ele.getChildNodes().item(0));

                Node eworkflow = res.getOwnerDocument().importNode(ele, true);
                res.appendChild(eworkflow);
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
                addElement("err", e.getMessage(), res);
            }
        }
        else
        {
            addElement("err", java.util.ResourceBundle.getBundle("org/semanticwb/portal/admin/resources/SWBAWorkflow").getString("err1"), res);
        }
    }

    /**
     * Gets the catalog users.
     * 
     * @param res the res
     * @param tm the tm
     * @return the catalog users
     */
    public void getCatalogUsers(Element res, String tm)
    {
        Vector<User> users = new Vector<User>();        
        WebSite map = SWBContext.getAdminWebSite();
        //WebSite map = SWBContext.getWebSite(tm);
        Iterator<User> it = map.getUserRepository().listUsers();
        while (it.hasNext())
        {
            User user = it.next();
            if (map.getUserRepository().getId().equals(user.getUserRepository().getId()))
            {
                try
                {
                    //TODO: user.havePermission
                    //if(user.havePermission(SWBContext.getAdminWebSite().getWebPage("WBAd_per_Administrator")))
                    {
                        users.add(user);
                    }
                }
                catch (Exception ue)
                {
                    ue.printStackTrace(System.out);
                    log.error(ue);
                }
            }
        }

        Collections.sort(users, new OrdenaUsuarios());
        Iterator itUsers = users.iterator();
        while (itUsers.hasNext())
        {
            User user = (User) itUsers.next();
            try
            {
                Element erole = addNode("user", "" + user.getId(), user.getName(), res);
            }
            catch (Exception ue)
            {
                ue.printStackTrace(System.out);
                log.error(ue);
            }
        }

    }

    /**
     *
     * @param res
     * @param src
     * @param user
     * @param tm
     * @param paramRequest
     * @param request
     */
    public void update(Element res, Document src, User user, String tm, SWBParamRequest paramRequest, HttpServletRequest request)
    {
        try
        {
            Element wf = (Element) src.getElementsByTagName("workflow").item(0);
            String id = wf.getAttribute("id");
//            if(id==null || id.trim().equals(""))
//            {
//                add(res,wf,user,tm,paramRequest,request);
//            }
//            else
            {
                String idpflow = wf.getAttribute("id");
//                PFlowSrv sPFlowSrv=new PFlowSrv();
                try
                {
                    WorkflowResponse wresp = updatePflow(tm, src, user.getId());
                    addElement("workflowid", idpflow, res);
                    addElement("version", String.valueOf(wresp.getVersion()), res);
                }
                catch (Exception e)
                {
                    log.error(e);
                    e.printStackTrace(System.out);
                    addElement("err", java.util.ResourceBundle.getBundle("org/semanticwb/portal/admin/resources/SWBAWorkflow").getString("msg1"), res);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
            e.printStackTrace(System.out);
            addElement("err", java.util.ResourceBundle.getBundle("org/semanticwb/portal/admin/resources/SWBAWorkflow").getString("msg1") + " error: " + e.getMessage(), res);
        }

    }

    /**
     * Gets the document.
     * 
     * @param user the user
     * @param src the src
     * @param cmd the cmd
     * @param paramRequest the param request
     * @param request the request
     * @return the document
     * @return
     */
    public Document getDocument(User user, Document src, String cmd, SWBParamRequest paramRequest, HttpServletRequest request)
    {
        Document dom = null;
        try
        {
            String tm = null;
            if (src.getElementsByTagName("tm").getLength() > 0)
            {
                Node etm = src.getElementsByTagName("tm").item(0);
                Text etext = (Text) etm.getFirstChild();
                tm = etext.getNodeValue();
            }

            dom = SWBUtils.XML.getNewDocument();
            Element res = dom.createElement("res");
            dom.appendChild(res);

            if (cmd.equals("getcatUsers"))
            {
                getCatalogUsers(res, tm);
            }
            else if (cmd.equals("getWorkflow"))
            {


                getWorkflow(res, tm, src);
            }
            else if (cmd.equals("update"))
            {
                update(res, src, user, tm, paramRequest, request);
            }
        }
        catch (Exception e)
        {
            log.error(e);
            return getError(3);
        }
        return dom;
    }

    /**
     * Adds the node.
     * 
     * @param node the node
     * @param id the id
     * @param name the name
     * @param parent the parent
     * @return the element
     * @return
     */
    private Element addNode(String node, String id, String name, Element parent)
    {
        Element ret = addElement(node, null, parent);
        if (id != null)
        {
            ret.setAttribute("id", id);
        }
        if (name != null)
        {
            ret.setAttribute("name", name);
        }
        return ret;
    }

    /**
     * Adds the element.
     * 
     * @param name the name
     * @param value the value
     * @param parent the parent
     * @return the element
     * @return
     */
    private Element addElement(String name, String value, Element parent)
    {
        Document doc = parent.getOwnerDocument();
        Element ele = doc.createElement(name);
        if (value != null)
        {
            ele.appendChild(doc.createTextNode(value));
        }
        parent.appendChild(ele);
        return ele;
    }

    /**
     * Gets the error.
     * 
     * @param id the id
     * @return the error
     * @return
     */
    private Document getError(int id)
    {
        Document dom = null;
        try
        {
            dom = SWBUtils.XML.getNewDocument();
            Element res = dom.createElement("res");
            dom.appendChild(res);
            Element err = dom.createElement("err");
            res.appendChild(err);
            addElement("id", "" + id, err);
            if (id == 0)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_loginfail") + "...", err);
            }
            else if (id == 1)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_nouser") + "...", err);
            }
            else if (id == 2)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noservice") + "...", err);
            }
            else if (id == 3)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_serviceprocessfail") + "...", err);
            }
            else if (id == 4)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_parametersprocessfail") + "...", err);
            }
            else if (id == 5)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noTopicmap") + "...", err);
            }
            else if (id == 6)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noTopic") + "...", err);
            }
            else if (id == 7)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_usernopermiss") + "...", err);
            }
            else if (id == 8)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_TopicAlreadyexist") + "...", err);
            }
            else if (id == 9)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_byImplement") + "...", err);
            }
            else if (id == 10)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_TopicMapAlreadyExist") + "...", err);
            }
            else if (id == 11)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_FileNotFound") + "...", err);
            }
            else if (id == 12)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_noversions") + "...", err);
            }
            else if (id == 13)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_xmlinconsistencyversion") + "...", err);
            }
            else if (id == 14)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_noResourcesinMemory") + "...", err);
            }
            else if (id == 15)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_noTemplatesinMemory") + "...", err);
            }
            else if (id == 16)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_TemplatenotRemovedfromFileSystem") + "...", err);
            }
            else if (id == 17)
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getError_adminUsernotCreated") + "...", err);
            }
            else
            {
                addElement("message", SWBUtils.TEXT.getLocaleString("locale_Gateway", "usrmsg_Gateway_getService_errornotfound") + "...", err);
            }
        }
        catch (Exception e)
        {
            log.error(SWBUtils.TEXT.getLocaleString("locale_Gateway", "error_Gateway_getService_documentError") + "...", e);
        }
        return dom;
    }

    /**
     * Do gateway.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doGateway(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String ret = "";
        String action = paramRequest.getAction();
        
        if ("getWorkflow".equals(action)) {
            JSONObject _ret = new JSONObject();
            SemanticObject obj = SWBPlatform.getSemanticMgr().getOntology().getSemanticObject(request.getParameter("suri"));
            if (null != obj && obj.instanceOf(PFlow.sclass)) {
                PFlow flow = (PFlow)obj.createGenericInstance();
                try {
                    _ret = getWorkFlowData(flow, paramRequest.getUser());
                    //System.out.println(_ret.toString(2));
                } catch (JSONException jsex) {
                    log.error("Error al generar JSON del componente", jsex);
                }
            }
            ret = _ret.toString();
        }
        out.print(ret);
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        String jsp = "/swbadmin/jsp/SWBAWorkflow/view.jsp";
        GenericObject gobj = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));

        if (null != gobj && gobj instanceof PFlow) {
            initializePFlow((PFlow)gobj);
            
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            try {
                request.setAttribute("paramRequest", paramRequest);
                rd.include(request, response);
            } catch (ServletException sex) {
                log.error("SWBAWorkflow - Error including view", sex);
            }
        }
    }
    
    private JSONObject createNodeObject(String id, String name, String description) throws JSONException {
        JSONObject ret = new JSONObject();
        
        ret.put("uuid", UUID.randomUUID().toString());
        if (null != id && !id.isEmpty()) ret.put("id", id);
        if (null != name && !name.isEmpty()) ret.put("name", name);
        if (null != description && !description.isEmpty()) ret.put("description", description);
        return ret;
    }
    
    JSONArray getNodeElements(String nodeName, Element root) throws JSONException {
        JSONArray ret = new JSONArray();
        NodeList nodes = root.getElementsByTagName(nodeName);
        for (int i = 0; i < nodes.getLength(); i++) {
            Element enode = (Element) nodes.item(i);
            String idObj = enode.getAttribute("id");
            String topicmap = enode.getAttribute("topicmap");
            String name = enode.getAttribute("name");
            String type = enode.getAttribute("type");
            
            JSONObject e = createNodeObject(idObj, name, null);
            
            //Link properties
            if ("link".equals(nodeName)) {
                String from = enode.getAttribute("from");
                String to = enode.getAttribute("to");
                String publish = enode.getAttribute("publish");
                
                if (null != from && !from.isEmpty()) e.put("from", from);
                if (null != to && !to.isEmpty()) e.put("to", to);
                if (null != publish && !publish.isEmpty()) e.put("publish", Boolean.valueOf(publish));
                
                //Get Users and roles notifications
                JSONArray uArray = new JSONArray();
                JSONArray rArray = new JSONArray();
                NodeList childNodes = enode.getElementsByTagName("notification");
                if (childNodes.getLength() > 0) {
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Element el = (Element)childNodes.item(j);
                        String notificationTo = el.getAttribute("to");
                        String notificationType = el.getAttribute("type");
                        if (!notificationTo.isEmpty() && !notificationType.isEmpty()) {
                            if ("user".equals(notificationType)) {
                                uArray.put(notificationTo);
                            } else if ("role".equals(notificationType)) {
                                rArray.put(notificationTo);
                            }
                        }
                    }
                    e.put("users", uArray);
                    e.put("roles", rArray);
                }
            } else if ("activity".equals(nodeName)) {
                //Activity properties
                if ("Activity".equals(type)) {
                    String days = enode.getAttribute("days");
                    String hours = enode.getAttribute("hours");

                    if (null != days && !days.isEmpty()) e.put("days", days);
                    if (null != hours && !hours.isEmpty()) e.put("hours", hours);
                }
                
                //Get description
                NodeList childNodes = enode.getElementsByTagName("description");
                if (childNodes.getLength() > 0) {
                    String description = childNodes.item(0).getTextContent();
                    if (null != description && !description.isEmpty()) e.put("description", description);
                }
                
                //Get Users
                JSONArray uArray = new JSONArray();
                childNodes = enode.getElementsByTagName("user");
                if (childNodes.getLength() > 0) {
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Element el = (Element)childNodes.item(j);
                        String id = el.getAttribute("id");
                        String nm = el.getAttribute("name");//TODO: Name must come from model
                        if (!id.isEmpty() && !name.isEmpty()) {
                            JSONObject usr = new JSONObject();
                            usr.put("id", id);
                            usr.put("name", nm);
                            uArray.put(usr);
                        }
                    }
                    e.put("users", uArray);
                }
                
                //Get Roles
                JSONArray rArray = new JSONArray();
                childNodes = enode.getElementsByTagName("role");
                if (childNodes.getLength() > 0) {
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Element el = (Element)childNodes.item(j);
                        String id = el.getAttribute("id");
                        String nm = el.getAttribute("name");//TODO: Name must come from model
                        String urep = el.getAttribute("repository");
                        if (!id.isEmpty() && !name.isEmpty()) {
                            JSONObject role = new JSONObject();
                            role.put("id", id);
                            role.put("name", nm);
                            role.put("repository", urep);
                            rArray.put(role);
                        }
                    }
                    e.put("roles", rArray);
                }   
            }
            
            if (null != topicmap && !topicmap.isEmpty()) e.put("topicmap", topicmap);
            if (null != type && !type.isEmpty()) e.put("type", type);
            
            ret.put(e);
        }
        
        return ret;
    }
    
    public JSONArray getResourceTypeCat(JSONArray filterRTypes, WebSite map, User user) throws JSONException {
        JSONArray ret = new JSONArray();
        HashMap<String, JSONObject> filterTypes = new HashMap<>();
        String lang = "es";
        if (null != user && null != user.getLanguage()) lang = user.getLanguage();
        
        //Hash of filter configured types
        if (null != filterRTypes) {
            for (int i = 0; i < filterRTypes.length(); i++) {
                JSONObject obj = filterRTypes.getJSONObject(i);
                String id = obj.optString("id", null);
                if (!filterTypes.containsKey(id)) {
                    filterTypes.put(id, obj);
                }
            }
        }
        
        //Check all resourceTypes
        Iterator<ResourceType> elements = map.listResourceTypes();
        while (elements.hasNext()) {
            ResourceType obj = elements.next();
            if (obj.getResourceMode() == ResourceType.MODE_CONTENT || obj.getResourceMode() == ResourceType.MODE_SYSTEM) {
                JSONObject _obj = null;
                if (filterTypes.containsKey(obj.getId())) {
                    _obj = filterTypes.get(obj.getId());
                    _obj.put("selected", true);
                } else {
                    _obj = createNodeObject(obj.getId(), obj.getDisplayTitle(lang), obj.getDescription() != null ? obj.getDescription() : "_");
                    _obj.put("topicmap", obj.getWebSite().getId());
                    _obj.put("selected", false);
                }
                
                if (null != _obj) ret.put(_obj);
            }
        }
        
        return ret;
    }
    
    /**
     * Obtiene la configuración en XML del flujo y la transforma en un objeto JSON.
     * @param flow Flujo de publicación
     * @return Objeto JSON con los datos del flujo.
     */
    private JSONObject getWorkFlowData(PFlow flow, User user) throws JSONException {
        JSONObject ret = null;
        Document doc = SWBUtils.XML.xmlToDom(flow.getXml());
        
        if (null != doc) {
            Element root = null;
            double verNum = 0;
            NodeList wfs = doc.getElementsByTagName("workflows");
            if (wfs.getLength() > 0) {
                NodeList wfNodes = doc.getElementsByTagName("workflow");
                for (int i = 0; i < wfNodes.getLength(); i++) {
                    Element ele = (Element) wfNodes.item(i);
                    String verString = ele.getAttribute("version");
                    if (Double.parseDouble(verString) > verNum) {
                        verNum = Double.parseDouble(verString);
                        root = ele;
                    }
                }
            }

            if (null != root) {
                String id = root.getAttribute("id");
                String name = root.getAttribute("name");
                String version = String.valueOf(verNum);
                String description = "_";
                NodeList descNode = root.getElementsByTagName("description");
                if (descNode.getLength() > 0) {
                    description = descNode.item(0).getTextContent();
                }

                ret = createNodeObject(id, name, description);
                ret.put("version", version);

                //Obtener lista conciliada de resourceTypes del flujo
                JSONArray rtypes = getResourceTypeCat(getNodeElements("resourceType", root), flow.getWebSite(), user);
                ret.put("resourceTypes", rtypes);

                //Obtener lista de actividades del flujo
                JSONArray activities = getNodeElements("activity", root);
                if (activities.length() == 0) {
                    //Agregar actividades por defecto
                    JSONObject startAct = createNodeObject(null, "Generador de contenido", "");
                    startAct.put("type", "AuthorActivity");

                    JSONObject endAct = createNodeObject(null, "Terminar flujo", "");
                    endAct.put("type", "EndActivity");

                    activities.put(startAct);
                    activities.put(endAct);
                }
                ret.put("activities", activities);

                //Obtener lista de secuencias del flujo
                JSONArray links = getNodeElements("link", root);
                ret.put("links", links);
            }
        }
        return ret;
    }
    
    /**
     * Obtiene la información para la configuración de un flujo de publicación.
     * @param flow Flujo de publicación
     * @return Objeto JSON con la información del flujo, sus actividades y recursos asociados.
     * @throws JSONException 
     */
    private JSONObject getWorkflowJSON(PFlow flow) throws JSONException {
        JSONObject ret = new JSONObject();
        JSONArray rtypes = new JSONArray();
        String tm = flow.getWebSite().getId();
        
        HashSet<String> resources = new HashSet<String>();
        WebSite map = SWBContext.getWebSite(tm);
        Iterator<ResourceType> elements = map.listResourceTypes();//TODO: Checar qué pasa con sitios eliminados
        while (elements.hasNext()) {
            ResourceType obj = elements.next();
            if (obj.getResourceMode() == ResourceType.MODE_CONTENT || obj.getResourceMode() == ResourceType.MODE_SYSTEM) {
                String id = obj.getId();
                String description = obj.getDescription();//= "_";
                if (null == description || description.isEmpty()) description = "_";

                if (!resources.contains(id)) {
                    resources.add(obj.getId());
                    
                    JSONObject ele = createNodeObject(obj.getId(), obj.getTitle(), description);
                    rtypes.put(ele);
                }
            }
        }
        
        ret.put("resourceTypes", rtypes);
        return ret;
    }
    
    /**
     * Inicializa la configuración de un flujo de publicación
     * @param flow Flujo de publicación
     */
    private void initializePFlow(PFlow flow) {
        String sflow = flow.getXml();
        if (flow != null && (sflow == null || (sflow != null && sflow.isEmpty()))) {
            Document newdoc = SWBUtils.XML.getNewDocument();
            Element wfs = newdoc.createElement("workflows");
            Element wf = newdoc.createElement("workflow");
            wf.setAttribute("id", flow.getURI());
            wf.setAttribute("name", flow.getTitle());
            wf.setAttribute("version", "1.0");
            wfs.appendChild(wf);
            Element edes = newdoc.createElement("description");
            edes.appendChild(newdoc.createTextNode(flow.getDescription() != null ? flow.getDescription() : "_"));
            wf.appendChild(edes);
            newdoc.appendChild(wfs);
            String xmlpflow = SWBUtils.XML.domToXml(newdoc);
            flow.setXml(xmlpflow);
        }
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#doView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.portal.api.SWBParamRequest)
     */
    /*@Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String id = request.getParameter("suri");
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject go = ont.getGenericObject(id);
        PFlow pfgo = (PFlow) go;
//        System.out.println("pf xml: " + pfgo.getXml());
        if (pfgo != null && (pfgo.getXml() == null || (pfgo.getXml() != null && pfgo.getXml().trim().length() == 0)))
        {
//            System.out.println("pf xml es NULL");
            Document newdoc = SWBUtils.XML.getNewDocument();
            Element wfs = newdoc.createElement("workflows");
            Element wf = newdoc.createElement("workflow");
            wf.setAttribute("id", id);
            wf.setAttribute("name", pfgo.getTitle());
            wf.setAttribute("version", "1.0");
            wfs.appendChild(wf);
            Element edes = newdoc.createElement("description");
            edes.appendChild(newdoc.createTextNode(pfgo.getDescription() != null ? pfgo.getDescription() : "_"));
            wf.appendChild(edes);
            newdoc.appendChild(wfs);
            String xmlpflow = SWBUtils.XML.domToXml(newdoc);
//            System.out.println("XML: " + xmlpflow);
            pfgo.setXml(xmlpflow);

        }

//        System.out.println("XML AFTER: " + pfgo.getXml());

        String tm = pfgo.getWebSite().getId();
        try
        {
            User user = paramRequest.getUser();
            PrintWriter out = response.getWriter();
            String act = "edit";
            if (request.getParameter("act") != null)
            {
                act = request.getParameter("act");
            }
            else if (act.equals("edit") && id != null && user != null && tm != null)
            {

//                System.out.println("Con OBJECT");
//
//                out.println("<OBJECT id=\"apptree\" name=\"editrole\" classid=\"clsid:CAFEEFAC-0014-0002-0000-ABCDEFFEDCBA\" ");
//                out.println("width=\"100%\" height=\"350\" >");
//                //out.println("codebase=\"http://java.sun.com/products/plugin/autodl/jinstall-1_4_2-windows-i586.cab#Version=1,4,2,0\"> ");
//                out.println("<PARAM name=\"java_code\" value=\"applets.workflowadmin.EditWorkflow.class\">");
//                out.println("<PARAM name=\"java_codebase\" value=\"" + SWBPlatform.getContextPath() + "\">");
//                out.println("<PARAM name=\"java_archive\" value=\"swbadmin/lib/SWBAplWorkFlowAdmin.jar, swbadmin/lib/SWBAplCommons.jar\">");
//
                SWBResourceURL url = paramRequest.getRenderUrl();
                url.setMode("gateway");
                url.setCallMethod(SWBResourceURL.Call_DIRECT);
//                out.println("<PARAM NAME =\"idworkflow\" VALUE=\"" + id + "\">");
//                out.println("<PARAM NAME =\"cgipath\" VALUE=\"" + url + "\">");
//                out.println("<PARAM NAME =\"locale\" VALUE=\"" + user.getLanguage() + "\">");
//                out.println("<PARAM NAME =\"tm\" VALUE=\"" + tm + "\">");
//                out.println("    No Java 2 SDK, Standard Edition v 1.5.0 support for APPLET!!");
//                out.println("</OBJECT>");

//                System.out.println("Con APPLET");

                out.println("<div class=\"applet\">");
                out.println("<applet id=\"apptree\" name=\"editrole\" code=\"applets.workflowadmin.EditWorkflow.class\" codebase=\"" + SWBPlatform.getContextPath() + "/\" archive=\"swbadmin/lib/SWBAplWorkFlowAdmin.jar, swbadmin/lib/SWBAplCommons.jar\" width=\"100%\" height=\"350\">");
                out.println("<param name =\"idworkflow\" value=\"" + id + "\">");
                out.println("<param name =\"jsess\" value=\""+request.getSession().getId()+"\">");
                out.println("<param name =\"cgipath\" value=\"" + url + "\">");
                out.println("<param name =\"locale\" value=\"" + user.getLanguage() + "\">");
                out.println("<param name =\"tm\" value=\"" + tm + "\">");
                out.println("</applet>");
                out.println("</div>");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
            log.error(e);
            return;
        }
    }*/

    /**
     * The Class OrdenaUsuarios.
     */
    private class OrdenaUsuarios implements Comparator
    {

        /**
         * Compare.
         * 
         * @param o1 the o1
         * @param o2 the o2
         * @return the int
         * @return
         */
        public int compare(Object o1, Object o2)
        {
            if (o1 instanceof User && o2 instanceof User)
            {
                User u1 = (User) o1;
                User u2 = (User) o2;
                return u1.getName().trim().toLowerCase().compareTo(u2.getName().trim().toLowerCase());
            }
            return 0;
        }
    }

    /**
     * The Class OrdenaRole.
     */
    private class OrdenaRole implements Comparator
    {

        /**
         * Compare.
         * 
         * @param o1 the o1
         * @param o2 the o2
         * @return the int
         * @return
         */
        public int compare(Object o1, Object o2)
        {
            if (o1 instanceof Role && o2 instanceof Role)
            {
                Role u1 = (Role) o1;
                Role u2 = (Role) o2;
                return u1.getTitle().trim().toLowerCase().compareTo(u2.getTitle().trim().toLowerCase());
            }
            return 0;
        }
    }

    /**
     * Update pflow.
     * 
     * @param tm the tm
     * @param xml the xml
     * @param userid the userid
     * @return the workflow response
     * @throws SWBResourceException the sWB resource exception
     * @throws Exception the exception
     * @return
     */
    public WorkflowResponse updatePflow(String tm, Document xml, String userid) throws SWBResourceException, Exception
    {
        //regreso inicial WorkflowResponse
        if (xml.getElementsByTagName("workflow").getLength() > 0)
        {
            Element wf = (Element) xml.getElementsByTagName("workflow").item(0);
            String idpflow = wf.getAttribute("id");
            wf.setAttribute("id", idpflow + "_" + tm);
            String name = wf.getAttribute("name");
            String description = "";
            if (wf.getElementsByTagName("description").getLength() > 0)
            {
                Element edesc = (Element) wf.getElementsByTagName("description").item(0);
                Text etext = (Text) edesc.getFirstChild();
                description = etext.getNodeValue();
            }
            //User user = SWBContext.getWebSite(tm).getUserRepository().getUser(userid);
            PFlow pflow = (PFlow) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(idpflow);
            //pflow.setCreator(user);
//            pflow.setUpdated(new Timestamp(System.currentTimeMillis()));
//            pflow.setDescription(description);
//            pflow.setTitle(name);

            try
            {
                Document docworkflows = SWBUtils.XML.xmlToDom(pflow.getXml());
                if (docworkflows.getElementsByTagName("workflows").getLength() > 0)
                {
                    Element workflows = (Element) docworkflows.getElementsByTagName("workflows").item(0);
                    Element nodewf = (Element) docworkflows.importNode(wf, true);
                    nodewf = (Element) workflows.insertBefore(nodewf, docworkflows.getElementsByTagName("workflow").item(0));
                    if (nodewf.getAttribute("version") != null && !nodewf.getAttribute("version").equals(""))
                    {
                        String sversion = nodewf.getAttribute("version");
                        int iversion = (int) Double.parseDouble(sversion);
                        iversion++;
                        nodewf.setAttribute("version", iversion + ".0");
                    }
                    try
                    {
                        Document doc = SWBUtils.XML.getNewDocument();
                        doc.appendChild(doc.importNode(nodewf, true));

                        //TODO: WBProxyWorkflow.PublisFlow(doc)
                        //WorkflowResponse wresp=WBProxyWorkflow.PublisFlow(doc);
                        WorkflowResponse wresp = new WorkflowResponse("1", 1);
                        Document docenc = SWBUtils.XML.xmlToDom(pflow.getXml());
                        NodeList nlWorkflows = docenc.getElementsByTagName("workflow");
                        int l = nlWorkflows.getLength();
                        switch (l)
                        {
                            case 0:
                            default:
                                Element oldworkflow = (Element) nlWorkflows.item(0);
                                int version = (int) Double.parseDouble(oldworkflow.getAttribute("version"));
                                version++;
                                nodewf.setAttribute("version", version + ".0");
                        }
                        pflow.setXml(SWBUtils.XML.domToXml(docworkflows));
                        return wresp;
                    }
                    catch (Exception e)
                    {
                        log.error(e);
                        e.printStackTrace(System.out);
                        throw e;
                    }
                }
                else
                {
                    throw new SWBResourceException("The xml has not a workflows element (updatePflow)");
                }
            }
            catch (Exception e)
            {
                log.error(e);
                throw e;
            }
        }
        else
        {
            throw new SWBResourceException("The xml has not a workflow element (updatePflow)");
        }

    }
}
