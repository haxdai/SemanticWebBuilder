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
package org.semanticwb.process.resources.taskinbox;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.process.model.FlowNodeInstance;
import org.semanticwb.process.model.Process;
import org.semanticwb.process.model.ProcessInstance;
import org.semanticwb.process.model.ProcessSite;
import org.semanticwb.process.model.SWBProcessMgr;
import org.semanticwb.process.model.UserTask;

/***
 * Recurso Bandeja de Tareas de Usuario.
 * @author Hasdai Pacheco {ebenezer.sanchez@infotec.com.mx}
 */
public class UserTaskInboxResource extends org.semanticwb.process.resources.taskinbox.base.UserTaskInboxResourceBase 
{
    private static Logger log = SWBUtils.getLogger(UserTaskInboxResource.class);
    public static final int SORT_DATE = 1;
    public static final int SORT_NAME = 2;
    public static final int STATUS_ALL = -1;
    public static final String COL_IDPROCESS = "idProcessInstance";
    public static final String COL_ASSIGNEDTO = "asignedUser";
    public static final String COL_IDTASK = "idTaskInstance";
    public static final String COL_NAMEPROCESS = "nameProcess";
    public static final String COL_NAMETASK = "nameTask";
    public static final String COL_TASKSUBJECT = "taskSubject";
    public static final String COL_STARTTASK = "startTask";
    public static final String COL_ENDTASK = "endTask";
    public static final String COL_STARTPROCESS = "startProcess";
    public static final String COL_ENDPROCESS = "endProcess";
    public static final String COL_CREATORPROCESS = "creatorProcess";
    public static final String COL_CREATORTASK = "creatorTask";
    public static final String COL_ACTIONS = "actions";
    public static final String COL_STATUSPROCESS = "statusProcess";
    public static final String COL_STATUSTASK = "statusTask";
    public static final String COL_FLAGTASK = "flagTask";
    public static final String ATT_COLS = "cols";
    public static final String ATT_SHOWPERFORMANCE = "showPerformance";
    public static final String ATT_GRAPHSENGINE = "graphsEngine";
    public static final String ATT_INSTANCEGRAPH = "instanceGraph";
    public static final String ATT_RESPONSEGRAPH = "responseGraph";
    public static final String ATT_STATUSGRAPH = "statusGraph";
    public static final String ATT_PARTGRAPH = "partGraph";
    public static final String ACT_UPDATE = "update";
    public static final String ACT_CREATE = "create";
    public static final String ACT_ADDCOL = "addCol";
    public static final String ACT_DELCOL = "delCol";
    public static final String ACT_CONFIG = "config";
    public static final String ACT_SWAP = "swap";
    public static final String ACT_SETGRAPHS = "setGraphs";
    public static final String ACT_CLAIM = "claim";
    public static final String PARAM_INDEX = "idx";
    public static final String PARAM_DIR = "dir";
    public static final String PARAM_COL = "selectedCol";
    public static final String PARAM_PID = "pid";
    public static final String MODE_FWD = "forward";
    public static final String MODE_STATISTICS = "statistics";
    public static final String MODE_GETDATA = "getData";
    public static final String MODE_CREATEPI = "createPi";
    public static final String MODE_PROCESSDETAIL = "processDetail";
    public static final String MODE_RESPONSE = "response";
    private HashMap<String, String> colNames;
    
    private Comparator taskNameComparator = new Comparator() {
        String lang = "es";
        public void Comparator (String lng) {
            lang = lng;
        }

        @Override
        public int compare(Object t, Object t1) {
            return ((FlowNodeInstance)t).getFlowNodeType().getDisplayTitle(lang).compareTo(((FlowNodeInstance)t1).getFlowNodeType().getDisplayTitle(lang));
        }
    };
    private Comparator taskNameComparatorDesc = new Comparator() {
        String lang = "es";
        public void Comparator (String lng) {
            lang = lng;
        }

        @Override
        public int compare(Object t, Object t1) {
            return ((FlowNodeInstance)t1).getFlowNodeType().getDisplayTitle(lang).compareTo(((FlowNodeInstance)t).getFlowNodeType().getDisplayTitle(lang));
        }
    };
    /*private Comparator taskPriorityComparator = new Comparator() {
        String lang = "es";
        
        public int compare(Object t, Object t1) {
            int it1 = ((FlowNodeInstance)t).getFlowNodeType().ge
            int it2 = ((ProcessInstance)t1).getPriority();
            int ret = 0;

            if (it1 > it2) ret = 1;
            if (it1 < it2) ret = -1;
            return ret;
        }
    };*/
    
    private void initColNames() {
        colNames = new HashMap<String, String>();
        colNames.put(COL_IDPROCESS, "ID de instancia de proceso");
        colNames.put(COL_IDTASK, "ID de instancia de tarea");
        colNames.put(COL_TASKSUBJECT, "Asunto de la instancia de tarea");
        colNames.put(COL_NAMEPROCESS, "Nombre de instancia de proceso");
        colNames.put(COL_NAMETASK, "Nombre de instancia de tarea");
        colNames.put(COL_STARTTASK, "Fecha de inicio de tarea");
        colNames.put(COL_FLAGTASK, "Semáforo de la tarea");
        colNames.put(COL_STARTPROCESS, "Fecha de inicio de proceso");
        colNames.put(COL_ENDTASK, "Fecha de fin de tarea");
        colNames.put(COL_ENDPROCESS, "Fecha de fin de proceso");
        colNames.put(COL_CREATORPROCESS, "Creador de proceso");
        colNames.put(COL_CREATORTASK, "Creador de tarea");
        colNames.put(COL_STATUSPROCESS, "Estatus de proceso");
        colNames.put(COL_STATUSTASK, "Estatus de tarea");
        colNames.put(COL_ACTIONS, "Acciones");
        colNames.put(COL_ASSIGNEDTO, "Usuario asignado");
    }

    public UserTaskInboxResource()
    {
        initColNames();
    }
    
    /**
     * Establece la configuración inicial de la bandeja de tareas.
     */
    private void initTaskInbox() {
        Resource base = getResourceBase(); 
        boolean update = false;
        
        //Establecer las columnas por defecto
        if (base.getAttribute(ATT_COLS+"1", "").equals("")) {
            base.setAttribute(ATT_COLS+"1", COL_IDPROCESS+"|Caso");
            base.setAttribute(ATT_COLS+"2", COL_NAMEPROCESS+"|Proceso");
            base.setAttribute(ATT_COLS+"3", COL_NAMETASK+"|Tarea");
            base.setAttribute(ATT_COLS+"4", COL_STARTTASK+"|Iniciada");
            base.setAttribute(ATT_COLS+"5", COL_ENDTASK+"|Cerrada");
            base.setAttribute(ATT_COLS+"6", COL_ACTIONS+"|Acciones");
            update = true;
        }
        
        if (base.getAttribute(ATT_SHOWPERFORMANCE) == null) {
            base.setAttribute(ATT_SHOWPERFORMANCE, "yes");
        }
        
        //Establecer el motor de graficado
        if (base.getAttribute(ATT_GRAPHSENGINE) == null) {
            base.setAttribute(ATT_GRAPHSENGINE, "google");
            update = true;
        }
        
        //Establecer las gráficas por defecto
        if (base.getAttribute(ATT_INSTANCEGRAPH) == null) {
            base.setAttribute(ATT_INSTANCEGRAPH, "use");
            update = true;
        }
        if (base.getAttribute(ATT_RESPONSEGRAPH) == null) {
            base.setAttribute(ATT_RESPONSEGRAPH, "use");
            update = true;
        }
        if (base.getAttribute(ATT_STATUSGRAPH) == null) {
            base.setAttribute(ATT_STATUSGRAPH, "use");
            update = true;
        }
        if (base.getAttribute(ATT_PARTGRAPH) == null) {
            base.setAttribute(ATT_PARTGRAPH, "use");
            update = true;
        }
        
        if (update) {
            try {
                base.updateAttributesToDB();
            } catch (Exception ex) {
                log.error("UserTaskInboxResource - initTaskInbox", ex);
            }
        }
    }

   /**
   * Construye una nueva instancia de un UserTaskInboxResource dado un SemanticObject
   * @param base El SemanticObject con las propiedades para el UserTaskInboxResource
   */
    public UserTaskInboxResource(org.semanticwb.platform.SemanticObject base) {
        super(base);
        initColNames();
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (MODE_FWD.equals(mode)) {
            doForward(request, response, paramRequest);
        } else if (MODE_CREATEPI.equals(mode)) {
            doCreateProcessInstance(request, response, paramRequest);
        } else if (MODE_PROCESSDETAIL.equals(mode)) {
            doDetail(request, response, paramRequest);
        } else if (MODE_RESPONSE.equals(mode)) {
            doResponse(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String act = response.getAction();
        Resource base = getResourceBase();
        
        if (ACT_CLAIM.equals(act)) {
            String suri = request.getParameter("suri");
            if (null != suri && !suri.isEmpty() && response.getUser().isSigned() && isAdminUser(response.getUser())) {
                FlowNodeInstance fni = (FlowNodeInstance)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
                if (null != fni) {
                    fni.setAssignedto(response.getUser());
                    UserTask task = (UserTask)fni.getFlowNodeType();
                    response.sendRedirect(task.getTaskWebPage().getUrl()+"?suri="+fni.getEncodedURI());
                    return;
                }
            }
        } else if (ACT_SETGRAPHS.equals(act)) {
            String engine = request.getParameter(ATT_GRAPHSENGINE);
            String instances = request.getParameter(ATT_INSTANCEGRAPH);
            String resp = request.getParameter(ATT_RESPONSEGRAPH);
            String status = request.getParameter(ATT_STATUSGRAPH);
            String participation = request.getParameter(ATT_PARTGRAPH);
            String show = request.getParameter(ATT_SHOWPERFORMANCE);
            
            if (show != null) {
                base.setAttribute(ATT_SHOWPERFORMANCE, "yes");
            } else {
                base.setAttribute(ATT_SHOWPERFORMANCE, "n");
            }
            
            if (engine != null && !base.getAttribute(ATT_GRAPHSENGINE,"").equals(engine)) {
                base.setAttribute(ATT_GRAPHSENGINE, engine);
            }
            
            if (instances != null) {
                base.setAttribute(ATT_INSTANCEGRAPH, "use");
            } else {
                base.setAttribute(ATT_INSTANCEGRAPH, "n");
            }
            
            if (resp != null) {
                base.setAttribute(ATT_RESPONSEGRAPH, "use");
            } else {
                base.setAttribute(ATT_RESPONSEGRAPH, "n");
            }
            
            if (status != null) {
                base.setAttribute(ATT_STATUSGRAPH, "use");
            } else {
                base.setAttribute(ATT_STATUSGRAPH, "n");
            }
            
            if (participation != null) {
                base.setAttribute(ATT_PARTGRAPH, "use");
            } else {
                base.setAttribute(ATT_PARTGRAPH, "n");
            }
            
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error("Error al configurar gráficas....", e);
            }
        } else if (ACT_UPDATE.equals(act)) {
            SWBFormMgr mgr = new SWBFormMgr(getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
            try {
                mgr.processForm(request);
            } catch(FormValidateException e) {
                log.error(e);
            }
        } else if (ACT_SWAP.equals(act)) {
            String dir = request.getParameter(PARAM_DIR);
            String idx = request.getParameter(PARAM_INDEX);
            
            if (idx != null && idx.trim().length() > 0 && dir != null) {
                int pos = 0;
                int newPos = 0;
                boolean valid = false;
                
                String temp = base.getAttribute(ATT_COLS+idx);
                if (temp != null) {
                    try {
                        pos = Integer.parseInt(idx);
                    } catch (Exception e) {}

                    if (dir.equals("down")) {
                        newPos = pos + 1;
                        if (pos > 0 && newPos > 0 && pos < newPos) {
                            valid = true;
                        }
                    } else if (dir.equals("up")) {
                        newPos = pos - 1;
                        if (pos > 0 && newPos > 0 && pos > newPos) {
                            valid = true;
                        }
                    }
                    
                    String tmp2 = base.getAttribute(ATT_COLS + newPos);
                    if (tmp2 != null && valid) {
                        base.setAttribute(ATT_COLS + pos, tmp2);
                        base.setAttribute(ATT_COLS + newPos, temp);
                    }
                    
                    try {
                        base.updateAttributesToDB();
                    } catch (Exception e) {
                        log.error("Error al reordenar propiedad....", e);
                    }
                }
            }
        } else if (ACT_ADDCOL.equals(act)) {
            String col = request.getParameter(PARAM_COL);
            if (col != null && colNames.containsKey(col)) {
                int i = 1;
                while(!base.getAttribute(ATT_COLS+i, "").equals("")) {
                    i++;
                }
                base.setAttribute(ATT_COLS+i, col+"|"+colNames.get(col));
            }
            
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error("UserTaskInboxResource - Error al agregar columna", e);
            }
        } else if (ACT_DELCOL.equals(act)) {
            int idx = -1;
            
            try {
                idx = Integer.parseInt(request.getParameter(PARAM_INDEX));
            } catch (NumberFormatException ex) {
                idx = -1;
            }
            
            if (idx != -1) {
                int i = 1;
                ArrayList<String> conf = new ArrayList<String>();
                while(!base.getAttribute(ATT_COLS+i, "").equals("")) {
                    String val = base.getAttribute(ATT_COLS+i);

                    if (i != idx) {
                        conf.add(val);
                    }
                    base.removeAttribute(ATT_COLS+i);
                    i++;
                }

                i = 1;
                Iterator<String> it = conf.iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    base.setAttribute(ATT_COLS+i, key);
                    i++;
                }

                try {
                    base.updateAttributesToDB();
                } catch (Exception e) {
                    log.error("UserTaskInboxResource - Error al eliminar columna", e);
                }
            }
        } else if (ACT_CONFIG.equals(act)) {
            int i = 1;
            ArrayList<String> conf = new ArrayList<String>();
            
            while(!base.getAttribute(ATT_COLS+i, "").equals("")) {
                String val = base.getAttribute(ATT_COLS+i);
                String lbl = request.getParameter("lbl_"+i);
                String []cfg = val.split("\\|");
                
                if (lbl != null && lbl.trim().length() > 0 && !lbl.equals(cfg[1])) {
                    conf.add(cfg[0]+"|"+lbl.replaceAll("\\|", ""));
                } else {
                    conf.add(val);
                }
                base.removeAttribute(ATT_COLS+i);
                i++;
            }
            
            i = 1;
            Iterator<String> it = conf.iterator();
            while (it.hasNext()) {
                String key = it.next();
                base.setAttribute(ATT_COLS+i, key);
                i++;
            }
            
            try {
                base.updateAttributesToDB();
            } catch (Exception e) {
                log.error("UserTaskInboxResource - Error al actualizar etiqueta", e);
            }
        } else if (ACT_CREATE.equals(act)) {
            User user = response.getUser();
            Process process = Process.ClassMgr.getProcess(request.getParameter(PARAM_PID), response.getWebPage().getWebSite());
            ProcessInstance inst = null;
            
            if (process != null)  {
                inst = SWBProcessMgr.createSynchProcessInstance(process, user);
                List<FlowNodeInstance> arr = SWBProcessMgr.getActiveUserTaskInstances(inst,response.getUser());
                
                if (!arr.isEmpty()) {
                    response.setRenderParameter("redirectUrl", arr.get(0).getUserTaskUrl());
                } else {
                    response.setRenderParameter("redirectUrl", getUserTaskInboxUrl());
                }

                if (null != inst) {
                    response.setRenderParameter("processInstance", inst.getId());
                    request.getSession().setAttribute("processInstance", inst.getId());
                    response.setRenderParameter("status", "ok");
                }
            }
            response.setMode(MODE_RESPONSE);
        } else if (MODE_FWD.equals(act)) {
            String suri = request.getParameter("suri");
            String sowner = request.getParameter("owner");
            
            SemanticObject sobj = SemanticObject.createSemanticObject(suri);
            User owner = response.getWebPage().getWebSite().getUserRepository().getUser(sowner);
            if (sobj != null) {
                FlowNodeInstance fni = (FlowNodeInstance)sobj.createGenericInstance();
                if (fni != null) {
                    if (owner != null) {
                        fni.setAssignedto(owner);
                    } else {
                        fni.removeAssignedto();
                    }
                 
                    if (null != fni.getFlowNodeType()) {
                        response.sendRedirect(getUserTaskInboxUrl());
                    }
                }
            }
        } else {
            super.processAction(request, response);
        }
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        initTaskInbox();
        String jsp = "/swbadmin/jsp/process/taskInbox/userTaskInbox.jsp";
        if (getViewJSP() != null && !getViewJSP().trim().equals("")) {
            jsp = getViewJSP();
        }

        try {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("instances", getUserTaskInstances(request, paramRequest));
            request.setAttribute("statusWp", getDisplayMapWp());
            request.setAttribute("itemsPerPage", getItemsPerPage());
            request.setAttribute("showPWpLink", isShowProcessWPLink());
            request.setAttribute("allowForward", isAllowForward());
            request.setAttribute("base", getResourceBase());
            request.setAttribute("me", this);
            rd.include(request, response);
        } catch (Exception e) {
            log.error("Error including jsp in view mode", e);
        }
    }
    
    /**
     * Obtiene una cadena con la configuración de las gráficas para el recurso.
     * @return Cadena con las propiedades de configuración activas, separadas por |.
     */
    private String getGraphsConfig() {
        StringBuilder ret = new StringBuilder();
        Resource base = getResourceBase();
        
        if (base.getAttribute(ATT_SHOWPERFORMANCE, "--").equals("yes")) ret.append(ATT_SHOWPERFORMANCE).append("|");
        if (base.getAttribute(ATT_INSTANCEGRAPH, "--").equals("use")) ret.append(ATT_INSTANCEGRAPH).append("|");
        if (base.getAttribute(ATT_PARTGRAPH, "--").equals("use")) ret.append(ATT_PARTGRAPH).append("|");
        if (base.getAttribute(ATT_RESPONSEGRAPH, "--").equals("use")) ret.append(ATT_RESPONSEGRAPH).append("|");
        if (base.getAttribute(ATT_STATUSGRAPH, "--").equals("use")) ret.append(ATT_STATUSGRAPH).append("|");
        if (!base.getAttribute(ATT_GRAPHSENGINE, "--").equals("--")) ret.append(ATT_GRAPHSENGINE).append("|");
        
        return ret.toString();
    }
    
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        Resource base = getResourceBase();
        initTaskInbox();
        
        HashMap<String, String> availableCols = new HashMap<String, String>();
        availableCols.putAll(colNames);
        
        //Formulario de datos generales de la bandeja
        SWBFormMgr mgr = new SWBFormMgr(getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
        mgr.addButton(SWBFormButton.newSaveButton());
        mgr.setType(SWBFormMgr.TYPE_DOJO);
        
        sb.append("<form id=").append(mgr.getFormName()).append(" dojoType=\"dijit.form.Form\" class=\"swbform\" action=\"").append(paramRequest.getActionUrl().setAction(ACT_UPDATE).toString()).append("\" method=\"post\" onSubmit=\"submitForm('").append(mgr.getFormName()).append("');return false;\">");
        sb.append(SWBFormMgr.DOJO_REQUIRED);
        sb.append(mgr.getFormHiddens());
        sb.append("  <fieldset>");
        sb.append("    <table>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">").append(paramRequest.getLocaleString("admLblID")).append("&nbsp;").append("</td>");
        sb.append("        <td>").append(getId()).append("</td>");
        sb.append("      </tr>");
        sb.append("    </table>");
        sb.append("  </fieldset>");
        sb.append("  <fieldset><legend>").append(paramRequest.getLocaleString("admLblGeneral")).append("</legend>");
        sb.append("    <table>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_viewJSP, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_viewJSP, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_itemsPerPage, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_itemsPerPage, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_displayMapWp, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_displayMapWp, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_filterByGroup, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_filterByGroup, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_showProcessWPLink, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_showProcessWPLink, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_allowForward, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_allowForward, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">");
        sb.append(mgr.renderLabel(request, utinbox_adminRole, SWBFormMgr.MODE_VIEW));
        sb.append("        </td>");
        sb.append("        <td>");
        sb.append(mgr.renderElement(request, utinbox_adminRole, SWBFormMgr.MODE_EDIT));
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("    </table>");
        sb.append("    <button type=\"submit\" dojoType=\"dijit.form.Button\">").append(paramRequest.getLocaleString("admLblSave")).append("</button>");
        sb.append("  </fieldset>");
        sb.append("</form>");
        
        //Formulario para agregar columnas disponibles
        SWBResourceURL addColUrl = paramRequest.getActionUrl().setAction(ACT_ADDCOL);
        sb.append("<form id=\"").append(getId()).append("/addColsForm\" class=\"swbform\" action=\"").append(addColUrl).append("\" dojoType=\"dijit.form.Form\" method=\"post\" onSubmit=\"submitForm('").append(getId()).append("/addColsForm'); return false;\">");
        sb.append("  <fieldset>");
        int i = 1;
        HashMap<String, String> selectedCols = new HashMap<String, String>();
        if (!base.getAttribute(ATT_COLS+i, "").equals("")) {
            while(!base.getAttribute(ATT_COLS+i, "").equals("")) {
                String [] conf = base.getAttribute(ATT_COLS+i).split("\\|");
                if (conf.length == 2) {
                    selectedCols.put(conf[0], conf[1]);
                    if (availableCols.containsKey(conf[0])) {
                        availableCols.remove(conf[0]);
                    }
                }
                i++;
            }
        }
        if (!availableCols.isEmpty()) {
            sb.append("    <select dojoType=\"dijit.form.FilteringSelect\" name=\"selectedCol\">");
            Iterator<String> keys = availableCols.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                sb.append("      <option value=\"").append(key).append("\">").append(availableCols.get(key)).append("</option>");
            }
            sb.append("    </select>");
            sb.append("    <button type=\"submit\" dojoType=\"dijit.form.Button\">").append(paramRequest.getLocaleString("admLblAddCol")).append("</button><br/>");
        }
        sb.append("  </fieldset>");
        sb.append("</form>");
        
        //Tabla de columnas
        i = 1;
        if (!"".equals(base.getAttribute(ATT_COLS+i, ""))) {
            SWBResourceURL editUrl = paramRequest.getActionUrl().setAction(ACT_CONFIG);
            sb.append("<form class=\"swbform\" id=\"").append(getId()).append("/table\" method=\"post\" action=\"").append(editUrl).append("\" dojoType=\"dijit.form.Form\" onSubmit=\"submitForm('").append(getId()).append("/table'); return false;\">");
            sb.append("<div class=\"swbform\">");
            sb.append("  <fieldset><legend>").append(paramRequest.getLocaleString("admLblDisplay")).append("</legend>");
            sb.append("    <table>");
            sb.append("      <tr>");
            sb.append("        <th>").append(paramRequest.getLocaleString("admLblSort")).append("</th>");
            sb.append("        <th>").append(paramRequest.getLocaleString("admLblColData")).append("</th>");
            sb.append("        <th>").append(paramRequest.getLocaleString("admLblColTitle")).append("</th>");
            sb.append("      </tr>");

            while(!base.getAttribute(ATT_COLS+i, "").equals("")) {
                String val = base.getAttribute(ATT_COLS+i);
                String cfg [] = val.split("\\|");
                sb.append("      <tr>");
                sb.append("        <td align=\"center\">");
                
                SWBResourceURL swapUrl = paramRequest.getActionUrl().setAction(ACT_SWAP).setParameter(PARAM_INDEX, String.valueOf(i));
                SWBResourceURL delUrl = paramRequest.getActionUrl().setAction(ACT_DELCOL).setParameter(PARAM_INDEX, String.valueOf(i));
                if (i != 1) {
                    swapUrl.setParameter(PARAM_DIR, "up");
                    sb.append("          <a href=\"#\" onclick=\"submitUrl('").append(swapUrl).append("', this);\" title=\"").append(paramRequest.getLocaleString("admLblUp")).append("\"><img src=\"").append(SWBPlatform.getContextPath()).append("/swbadmin/images/up.jpg\" /></a>");
                }
                if (!base.getAttribute(ATT_COLS+(i+1), "").equals("")) {
                    swapUrl.setParameter(PARAM_DIR, "down");
                    sb.append("          <a href=\"#\" onclick=\"submitUrl('").append(swapUrl).append("', this);\" title=\"").append(paramRequest.getLocaleString("admLblDown")).append("\"><img src=\"").append(SWBPlatform.getContextPath()).append("/swbadmin/images/down.jpg\" /></a>");
                }
                sb.append("        </td>");
                sb.append("        <td>").append(colNames.get(cfg[0])).append("</td>");
                sb.append("        <td>");
                //sb.append("          <input onkeyup=\"console.log(event); if (event.keyCode==13) {console.log(event); alert(event)}; return false;\" type=\"text\" dojoType=\"dijit.form.TextBox\" id=\"lbl_").append(i).append("\" name=\"lbl_").append(i).append("\" value=\"").append(cfg[1]).append("\" />");
                sb.append("          <input type=\"text\" dojoType=\"dijit.form.TextBox\" id=\"lbl_").append(i).append("\" name=\"lbl_").append(i).append("\" value=\"").append(cfg[1]).append("\" />");
                sb.append("          <a href=\"#\" title=\"").append(paramRequest.getLocaleString("admLblDel")).append("\" onclick=\"submitUrl('").append(delUrl).append("',this);\"><img src=\"").append(SWBPlatform.getContextPath()).append("/swbadmin/images/delete.gif\"/></a>");
                sb.append("        </td>");
                sb.append("      </tr>");
                i++;
            }
            sb.append("    </table>");
        }
        sb.append("    <button type=\"submit\" dojoType=\"dijit.form.Button\">").append(paramRequest.getLocaleString("admLblUpdCols")).append("</button>");
        sb.append("  </fieldset>");
        sb.append("</form>");
        
        //Configuración de detalle
        SWBResourceURL setGraphUrl = paramRequest.getActionUrl().setAction(ACT_SETGRAPHS);
        String disableControls = "disabled ";
        if (base.getAttribute(ATT_SHOWPERFORMANCE,"").equals("yes")) {
            disableControls = "";
        }
        sb.append("<form class=\"swbform\" id=\"").append(getId()).append("/detail\" method=\"post\" action=\"").append(setGraphUrl).append("\" dojoType=\"dijit.form.Form\" onSubmit=\"submitForm('").append(getId()).append("/detail'); return false;\">");
        sb.append("<div class=\"swbform\">");
        sb.append("  <fieldset><legend>").append(paramRequest.getLocaleString("admLblDetail")).append("</legend>");
        sb.append("    <table>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">").append("").append(paramRequest.getLocaleString("admLblShowPerformance")).append(":&nbsp;").append("</td>");
        sb.append("        <td>");
        sb.append("          <input dojoType=\"dijit.form.CheckBox\" ").append(base.getAttribute(ATT_SHOWPERFORMANCE,"").equals("yes")?"checked":"").append(" type=\"checkbox\" name=\"").append(ATT_SHOWPERFORMANCE).append("\" />");
        sb.append("        <td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">").append("").append(paramRequest.getLocaleString("admLblEngine")).append(":&nbsp;").append("</td>");
        sb.append("        <td>");
        sb.append("          <input dojoType=\"dijit.form.RadioButton\" ").append(disableControls).append(base.getAttribute(ATT_GRAPHSENGINE,"").equals("google")?"checked":"").append(" type=\"radio\" name=\"").append(ATT_GRAPHSENGINE).append("\" value=\"google\" id=\"radioGoogle\"/><label for=\"radioGoogle\">Google Graphs</label><br>");
        sb.append("          <input dojoType=\"dijit.form.RadioButton\" ").append(disableControls).append(base.getAttribute(ATT_GRAPHSENGINE,"").equals("d3")?"checked":"").append(" type=\"radio\" name=\"").append(ATT_GRAPHSENGINE).append("\" value=\"d3\" id=\"radioD3\"/><label for=\"radioD3\">D3</label>");
        sb.append("        <td>");
        sb.append("      </tr>");
        sb.append("      <tr>");
        sb.append("        <td width=\"200px\" align=\"right\">").append("").append(paramRequest.getLocaleString("admLblVisible")).append(":&nbsp;").append("</td>");
        sb.append("        <td>");
        sb.append("          <input dojoType=\"dijit.form.CheckBox\" type=\"checkbox\" ").append(disableControls).append(base.getAttribute(ATT_INSTANCEGRAPH,"").equals("use")?"checked":"").append(" name=\"").append(ATT_INSTANCEGRAPH).append("\"/>").append(paramRequest.getLocaleString("admLblGInstances")).append("<br>");
        sb.append("          <input dojoType=\"dijit.form.CheckBox\" type=\"checkbox\" ").append(disableControls).append(base.getAttribute(ATT_RESPONSEGRAPH,"").equals("use")?"checked":"").append(" name=\"").append(ATT_RESPONSEGRAPH).append("\"/>").append(paramRequest.getLocaleString("admLblGResponsetime")).append("<br>");
        sb.append("          <input dojoType=\"dijit.form.CheckBox\" type=\"checkbox\" ").append(disableControls).append(base.getAttribute(ATT_STATUSGRAPH,"").equals("use")?"checked":"").append(" name=\"").append(ATT_STATUSGRAPH).append("\"/>").append(paramRequest.getLocaleString("admLblGStatus")).append("<br>");
        sb.append("          <input dojoType=\"dijit.form.CheckBox\" type=\"checkbox\" ").append(disableControls).append(base.getAttribute(ATT_PARTGRAPH,"").equals("use")?"checked":"").append(" name=\"").append(ATT_PARTGRAPH).append("\"/>").append(paramRequest.getLocaleString("admLblGPart")).append("<br>");
        sb.append("        </td>");
        sb.append("      </tr>");
        sb.append("    </table>");
        sb.append("    <button type=\"submit\" dojoType=\"dijit.form.Button\">").append(paramRequest.getLocaleString("admLblSave")).append("</button>");
        sb.append("  </fieldset>");
        sb.append("</div>");
        sb.append("</form>");
        
        out.println(sb.toString());
    }
    
    public void doCreateProcessInstance(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String jsp = "/swbadmin/jsp/process/taskInbox/userTaskInboxNewCase.jsp";

        try {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            log.error("Error including jsp in new case", e);
        }
    }
    
    public void doDetail(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = "/swbadmin/jsp/process/taskInbox/userTaskInboxDetail.jsp";

        try {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            request.setAttribute("paramRequest", paramRequest);
            if (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT) {
                request.setAttribute("instances", getProcessInstances(request, paramRequest));
                request.setAttribute("statusWp", getDisplayMapWp());
                request.setAttribute("itemsPerPage", getItemsPerPage());
                request.setAttribute("base", getResourceBase());
                request.setAttribute("graphConfig", getGraphsConfig());
            }
            rd.include(request, response);
        } catch (Exception e) {
            log.error("Error including jsp in detail mode", e);
        }
    }
    
    public void doForward(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String jsp = "/swbadmin/jsp/process/taskInbox/userTaskInboxFwd.jsp";

        try {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("isAdmin", isAdminUser(paramRequest.getUser()));
            rd.include(request, response);
        } catch (Exception e) {
            log.error("Error including jsp in forward mode", e);
        }
    }
    
    public void doResponse(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Map params = request.getParameterMap();
        Iterator<String> keys = params.keySet().iterator();
        
        out.print("{");
        while(keys.hasNext()) {
            String key = keys.next();
            String val = request.getParameter(key);
            out.print("\""+key+"\":\""+val+"\"");
            if (keys.hasNext()) out.print(",");
        }
        out.print("}");
    }
    
    /**
     * Obtiene las estadísticas de los procesos y devuelve una lista de las instancias, ordenadas y filtradas.
     * @param request
     * @param paramRequest
     * @return
     * @throws SWBResourceException 
     */
    public ArrayList<ProcessInstance> getProcessInstances(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException {
        ArrayList<ProcessInstance> unpaged = new ArrayList<ProcessInstance>();
        ArrayList<ProcessInstance> instances = new ArrayList<ProcessInstance>();
        String suri = request.getParameter("suri");
        Process p = (Process)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
        HashMap<User, Integer> participantCount = new HashMap<User, Integer>();
        
        if (p != null) {
            int page = 1;
            int processing = 0;
            int aborted = 0;
            int closed = 0;
            int delayed = 0;
            int ontime = 0;
            long maxTime = -3;
            long minTime = Long.MAX_VALUE;
            long sumTime = 0;
            int itemsPerPage = getItemsPerPage();
            
            Iterator<ProcessInstance> it = SWBComparator.sortByCreated(p.listProcessInstances(), false);
            while (it.hasNext()) {
                ProcessInstance pi = it.next();
                
                //Conteo de instancias
                if (pi.getStatus() == ProcessInstance.STATUS_PROCESSING) {
//                    if (pi.getCreator() != null) {
//                        if (participantCount.get(pi.getCreator()) == null) {
//                            participantCount.put(pi.getCreator(), new Integer(1));
//                        } else {
//                            participantCount.put(pi.getCreator(), participantCount.get(pi.getCreator())+1);
//                        }
//                    }
//                    if (pi.getAssignedto()!= null) {
//                        if (participantCount.get(pi.getAssignedto()) == null) {
//                            participantCount.put(pi.getAssignedto(), new Integer(1));
//                        } else {
//                            participantCount.put(pi.getAssignedto(), participantCount.get(pi.getAssignedto())+1);
//                        }
//                    }
                    boolean isDelayed = false;
                    //Verifica retraso
                    Iterator<FlowNodeInstance> itfni = pi.listAllFlowNodeInstance();
                    while (itfni.hasNext() && !isDelayed) {
                        FlowNodeInstance fni = itfni.next();
                        if (fni.getFlowNodeType() instanceof UserTask) {
                            if (fni.getStatus() == FlowNodeInstance.STATUS_PROCESSING) {
//                                if (fni.getCreator() != null) {
//                                    if (participantCount.get(fni.getCreator()) == null) {
//                                        participantCount.put(fni.getCreator(), new Integer(1));
//                                    } else {
//                                        participantCount.put(fni.getCreator(), participantCount.get(fni.getCreator())+1);
//                                    }
//                                }
//                                if (fni.getAssignedto()!= null) {
//                                    if (participantCount.get(fni.getAssignedto()) == null) {
//                                        participantCount.put(fni.getAssignedto(), new Integer(1));
//                                    } else {
//                                        participantCount.put(fni.getAssignedto(), participantCount.get(fni.getAssignedto())+1);
//                                    }
//                                }
                                
                                UserTask ut = (UserTask) fni.getFlowNodeType();
                                int delay = ut.getNotificationTime();

                                if (delay > 0) {
                                    long today = System.currentTimeMillis();
                                    long cr = fni.getCreated().getTime();
                                    if (today - cr > (1000*60*delay)) {
                                        isDelayed = true;
                                    }
                                }
                            }
                            
                            if (fni.getStatus() == FlowNodeInstance.STATUS_CLOSED) {
                                if (fni.getEndedby() != null) {
                                    if (participantCount.get(fni.getEndedby()) == null) {
                                        participantCount.put(fni.getEndedby(), new Integer(1));
                                    } else {
                                        participantCount.put(fni.getEndedby(), participantCount.get(fni.getEndedby())+1);
                                    }
                                }
                            }
                        }
                    }
                    
                    if (isDelayed) {
                        delayed++;
                    } else {
                        ontime++;
                    }
                    processing++;
                }
                if (pi.getStatus() == ProcessInstance.STATUS_ABORTED) aborted++;
                if (pi.getStatus() == ProcessInstance.STATUS_CLOSED) {
                    if (pi.getEndedby() != null) {
                        if (participantCount.get(pi.getEndedby()) == null) {
                            participantCount.put(pi.getEndedby(), new Integer(1));
                        } else {
                            participantCount.put(pi.getEndedby(), participantCount.get(pi.getEndedby())+1);
                        }
                    }
                    
                    //Cálculo de tiempos de respuesta generales
                    long resTime = pi.getEnded().getTime() - pi.getCreated().getTime();
                    if (resTime > maxTime) {
                        maxTime = resTime;
                    }
                    
                    if(resTime < minTime) {
                        minTime = resTime;
                    }
                    sumTime += resTime;
                    closed++;
                }
                unpaged.add(pi);
            }
            
            JSONObject data = new JSONObject();
            JSONArray instanceInfo = new JSONArray();
            JSONArray statusInfo = new JSONArray();
            JSONArray responseInfo = new JSONArray();
            
            if (processing > 0 || aborted > 0 || closed > 0) {
                JSONArray dt = new JSONArray();
                if (processing > 0) dt.put(paramRequest.getLocaleString("lblProcessing")).put(processing);
                if (aborted > 0) dt.put(paramRequest.getLocaleString("lblAborted")).put(aborted);
                if (closed > 0) dt.put(paramRequest.getLocaleString("lblClosed")).put(closed);
                instanceInfo.put(dt);
                //request.setAttribute("processing", processing);
                //request.setAttribute("aborted", aborted);
                //request.setAttribute("closed", closed);
                try {
                    data.put("instanceData", instanceInfo);
                } catch (JSONException ex) {}
            }
            
            if (delayed > 0 || ontime > 0) {
                if (delayed > 0) {
                    JSONArray dt = new JSONArray();
                    dt.put(paramRequest.getLocaleString("lblDelayed")).put(delayed);
                    statusInfo.put(dt);
                }
                if (ontime > 0) {
                    JSONArray dt = new JSONArray();
                    dt.put(paramRequest.getLocaleString("lblOntime")).put(ontime);
                    statusInfo.put(dt);
                }
                //request.setAttribute("delayed", delayed);
                //request.setAttribute("ontime", ontime);
                try {
                    data.put("statusData", statusInfo);
                } catch (JSONException ex) {}
            }
            
            if (closed > 0) {
                JSONArray dt = new JSONArray();
                dt.put(paramRequest.getLocaleString("lblMin")).put(TimeUnit.MILLISECONDS.toMinutes(minTime));
                dt.put(paramRequest.getLocaleString("lblMax")).put(TimeUnit.MILLISECONDS.toMinutes(maxTime));
                dt.put(paramRequest.getLocaleString("lblAvg")).put(TimeUnit.MILLISECONDS.toMinutes(sumTime/closed));
                responseInfo.put(dt);
                
                try {
                    data.put("responseData", responseInfo);
                } catch (JSONException ex) {}
                /*request.setAttribute("minTime", TimeUnit.MILLISECONDS.toMinutes(minTime));
                request.setAttribute("maxTime", TimeUnit.MILLISECONDS.toMinutes(maxTime));
                request.setAttribute("avgTime", TimeUnit.MILLISECONDS.toMinutes(sumTime/closed));*/
            }/* else {
                request.setAttribute("minTime", 0L);
                request.setAttribute("maxTime", 0L);
                request.setAttribute("avgTime", 0L);
            }*/
        
            //Realizar paginado de instancias
            int maxPages = 1;
            if (request.getParameter("p") != null && !request.getParameter("p").trim().equals("")) {
                page = Integer.valueOf(request.getParameter("p"));
                if (page < 0) page = 1;
            }

            if (itemsPerPage < 5) itemsPerPage = 5;

            if (unpaged.size() >= itemsPerPage) {
                maxPages = (int)Math.ceil((double)unpaged.size() / itemsPerPage);
            }
            if (page > maxPages) page = maxPages;

            int sIndex = (page - 1) * itemsPerPage;
            if (unpaged.size() > itemsPerPage && sIndex > unpaged.size() - 1) {
                sIndex = unpaged.size() - itemsPerPage;
            }

            int eIndex = sIndex + itemsPerPage;
            if (eIndex >= unpaged.size()) eIndex = unpaged.size();

            request.setAttribute("maxPages", maxPages);
            
            for (int i = sIndex; i < eIndex; i++) {
                ProcessInstance instance = unpaged.get(i);
                instances.add(instance);
            }
            
            Iterator<User> uit = participantCount.keySet().iterator();
            if (uit.hasNext()) {
                int max = 0;
                User theUser = null;
                
                try {
                    JSONObject processInfo = new JSONObject();
                    processInfo.put("name", p.getTitle());
                    processInfo.put("size", 10);
                    processInfo.put("type", "process");

                    JSONArray users = new JSONArray();
                    while (uit.hasNext()) {
                        User key = uit.next();
                        int value = participantCount.get(key);
                        if (value > max) {
                            max = value;
                            theUser = key;
                        }
                        
                        JSONObject jsonUser = new JSONObject();
                        jsonUser.put("name", key.getFullName()==null?"Anónimo":key.getFullName());
                        jsonUser.put("size", (10 + (value / 70)));
                        jsonUser.put("participa", value);
                        users.put(jsonUser);
                    }
                    processInfo.put("max", max);
                    processInfo.put("children", users);
                    processInfo.put("theUser", theUser.getFullName()==null?"Anónimo":theUser.getFullName());
                    
                    data.put("partData", processInfo);
                    //request.setAttribute("participation", processInfo.toString());
                } catch (JSONException ex) {
                    log.error("UserTaskInboxResource - Error al generar JSON", ex);
                }
            }
            request.setAttribute("processStats", data.toString());
        }
        return instances;
    }

    /***
     * Obtiene las instancias de las tareas de usuario en el sitio de procesos
     * ordenadas y filtradas de acuerdo a los criterios especificados.
     * @param request Objeto HttpServletRequest
     * @param paramRequest Objeto SWBParamRequest
     * @return Lista de instancias de tareas de usuario filtradas y ordenadas.
     */
    private ArrayList<FlowNodeInstance> getUserTaskInstances(HttpServletRequest request, SWBParamRequest paramRequest) {
        ArrayList<FlowNodeInstance> unpaged = new ArrayList<FlowNodeInstance>();
        WebSite site = paramRequest.getWebPage().getWebSite();
        User user = paramRequest.getUser();
        String sortType = request.getParameter("sort");
        int itemsPerPage = getItemsPerPage();
        int statusFilter = FlowNodeInstance.STATUS_PROCESSING;
        boolean onlyAssigned = false;
        Process p = null;
        int page = 1;

        if (request.getParameter("sf") != null && !request.getParameter("sf").trim().equals("")) {
            statusFilter = Integer.valueOf(request.getParameter("sf"));
        }
        
        if (request.getParameter("asFilter") != null && request.getParameter("asFilter").equals("true")) {
            onlyAssigned = true;
        }

        if (request.getParameter("pf") != null && !request.getParameter("pf").trim().equals("")) {
            p = Process.ClassMgr.getProcess(request.getParameter("pf"), site);
        }
        
        //Obtener todas las tareas de usuario por el estatus solicitado
        ArrayList<FlowNodeInstance> userTaskInstances = SWBProcessMgr.getUserTaskInstancesWithStatus((ProcessSite)site, statusFilter, p);
        
        //Iniciar el filtrado
        if (userTaskInstances != null) {
            Iterator<FlowNodeInstance> fnInstances = userTaskInstances.iterator();
            while (fnInstances.hasNext()) {
                FlowNodeInstance flowNodeInstance = fnInstances.next();
                if (validUserTaskInstance(flowNodeInstance, user, statusFilter)) {
                    if (onlyAssigned) {
                        if (flowNodeInstance.getAssignedto() == null) {
                            unpaged.add(flowNodeInstance);
                        }
                    } else {
                        unpaged.add(flowNodeInstance);
                    }
                }
            }
        }

        //Realizar Ordenamiento de instancias
        if (sortType == null || sortType.trim().equals("")) {
            sortType = "1";
        } else {
            sortType = sortType.trim();
        }
        
        if (sortType.equals("1")) {
            unpaged = (ArrayList<FlowNodeInstance>)SWBUtils.Collections.copyIterator(SWBComparator.sortByCreated(unpaged.iterator(), false));
        } else if (sortType.equals("2")) {
            unpaged = (ArrayList<FlowNodeInstance>)SWBUtils.Collections.copyIterator(SWBComparator.sortByCreated(unpaged.iterator(), true));
        } else if (sortType.equals("3")) {
            Collections.sort(unpaged, taskNameComparator);
        } else if (sortType.equals("4")) {
            Collections.sort(unpaged, taskNameComparatorDesc);
        }
        
        //Realizar paginado de instancias
        int maxPages = 1;
        if (request.getParameter("p") != null && !request.getParameter("p").trim().equals("")) {
            page = Integer.valueOf(request.getParameter("p"));
            if (page < 0) page = 1;
        }

        if (itemsPerPage < 5) itemsPerPage = 5;
        
        if (unpaged.size() >= itemsPerPage) {
            maxPages = (int)Math.ceil((double)unpaged.size() / itemsPerPage);
        }
        if (page > maxPages) page = maxPages;

        int sIndex = (page - 1) * itemsPerPage;
        if (unpaged.size() > itemsPerPage && sIndex > unpaged.size() - 1) {
            sIndex = unpaged.size() - itemsPerPage;
        }

        int eIndex = sIndex + itemsPerPage;
        if (eIndex >= unpaged.size()) eIndex = unpaged.size();

        request.setAttribute("maxPages", maxPages);
        ArrayList<FlowNodeInstance> instances = new ArrayList<FlowNodeInstance>();
        for (int i = sIndex; i < eIndex; i++) {
            FlowNodeInstance instance = unpaged.get(i);
            instances.add(instance);
        }
        return instances;
    }
    
    private boolean validUserTaskInstance(FlowNodeInstance fni, User user, int statusFilter) {
        boolean hasGroup = false;
        boolean hasStatus = false;
        
        Process pType = fni.getProcessInstance().getProcessType();
        
        if (!pType.isValid()) {
            return false;
        }
        
        //TODO: Revisar que va a pasar con los procesos creados en automático.
        if (fni.getProcessInstance().getCreator() == null) {
            return false;
        }
        
        if (isAdminUser(user)) return true;
        boolean canAccess = fni.haveAccess(user);
        
        if (canAccess) {
            //Verificar filtrado por grupo
            if (isFilterByGroup()) {
                UserGroup iug = fni.getProcessInstance().getOwnerUserGroup();
                UserGroup uug = user.getUserGroup();

                if (iug != null && uug != null) { //Si la instancia y el usuario tienen grupo
                    if (user.hasUserGroup(iug)) { //Si el usuario tiene el grupo de la instancia
                        hasGroup = true;
                    }
                } else if (iug == null && uug == null) { //Si el proceso y el usuario no tienen grupo
                    hasGroup = true;
                }
            } else {
                hasGroup = true;
            }

            //Verificar filtrado por estatus
            if (statusFilter > 0 && fni.getStatus() == statusFilter) {
                hasStatus = true;
            }
        }
        return canAccess && (hasGroup && hasStatus);
    }
    
    /**
     * Obtiene la URL de la página Web asociada a la Bandeja de tareas del sitio.
     * @return URL de la bandeja de tareas o URL del proceso en su defecto.
     */
    public String getUserTaskInboxUrl() {
        String url = getResourceBase().getWebSite().getHomePage().getUrl();
        ResourceType rtype = ResourceType.ClassMgr.getResourceType("ProcessTaskInbox", getResourceBase().getWebSite());

        if (rtype != null) {
            Resource res = rtype.getResource();
            if(res != null) {
                Resourceable resable = res.getResourceable();
                if(resable instanceof WebPage) {
                    url = ((WebPage)resable).getUrl();
                }
            }
        }
        return url;
    }
    
    private boolean isAdminUser(User user) {
        if (user == null) return false;
        Role admRole = this.getAdminRole();
        return admRole != null && user.hasRole(admRole);
    }
}