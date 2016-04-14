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
package org.semanticwb.process.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.process.model.FlowNodeInstance;
import org.semanticwb.process.model.ProcessInstance;
import org.semanticwb.process.model.SWBProcessMgr;
import org.semanticwb.process.model.Process;

/**
 * Componente de adminisración para gestionar las instancias de un proceso.
 * @author juan.fernandez
 */
public class SWBAProcessInstanceList extends GenericResource {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY - HH:mm:ss");
    public static final String ATT_INSTANCES = "at_instances";
    public static final String ACT_REMOVEPI = "a_removepi";
    public static final String ACT_CREATEPI = "a_createpi";
    public static final String ACT_PROCESSTASK = "a_processtask";
    public static final String ACT_REMOVEALLPI = "a_removeallpi";
    public static final String MOD_DETAIL = "m_detail";
    public static final String MOD_DATA = "m_data";
    private static final Logger log = SWBUtils.getLogger(SWBAProcessInstanceList.class);
    
    public void doDetail(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = SWBPlatform.getContextPath()+"/swbadmin/jsp/process/admin/instanceDetail.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
       
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (IOException | ServletException sex) {
            log.error("Error al obtener la vista de detalle del recurso", sex);
        }
    }
    
    public void doDataView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = SWBPlatform.getContextPath()+"/swbadmin/jsp/process/admin/instanceData.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
       
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (IOException | ServletException sex) {
            log.error("Error al obtener la vista de datos del recurso", sex);
        }
    }
    
    public void doGetInstances(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        GenericObject go = (GenericObject) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
        if (null != go && go instanceof Process) {
            Process p = (Process) go;
            JSONArray instances = new JSONArray();
            Iterator<ProcessInstance> it = SWBComparator.sortByCreated(p.listProcessInstances(), false);
            while (it.hasNext()) {
                ProcessInstance inst = it.next();
                JSONObject obj = new JSONObject();
                try {
                    obj.put("id", inst.getId());
                    obj.put("title", inst.getProcessType().getTitle());
                    obj.put("status", getStatusName(inst.getStatus(), paramRequest));
                    if (null != inst.getCreator()) obj.put("creator", inst.getCreator().getURI());
                    if (null != inst.getAssignedto()) obj.put("assigned", inst.getAssignedto().getURI());
                    obj.put("started", sdf.format(inst.getCreated()));
                    if (null != inst.getEnded()) obj.put("ended", sdf.format(inst.getEnded()));
                    instances.put(obj);
                } catch (JSONException jse) {
                    log.error("Ha ocurrido un problema al generar el JSON de las instancias", jse);
                }
            }
            out.println(instances.toString());
        }
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String jsp = SWBPlatform.getContextPath()+"/swbadmin/jsp/process/admin/instanceView.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        GenericObject go = (GenericObject)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
        
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try {
            request.setAttribute("paramRequest", paramRequest);
            if (null != go && go instanceof Process) {
                Process p = (Process)go;
                request.setAttribute(ATT_INSTANCES, SWBComparator.sortByCreated(p.listProcessInstances(), false));
            }
            rd.include(request, response);
        } catch (IOException | ServletException sex) {
            log.error("Error al obtener la vista del recurso", sex);
        }
    }

    public static String getStatusName(int status, SWBParamRequest paramRequest) throws SWBResourceException {
        if(status==ProcessInstance.STATUS_INIT) return paramRequest.getLocaleString("stStarted");
        if(status==ProcessInstance.STATUS_ABORTED) return paramRequest.getLocaleString("stAborted");
        if(status==ProcessInstance.STATUS_CLOSED) return paramRequest.getLocaleString("stClosed");
        if(status==ProcessInstance.STATUS_OPEN) return paramRequest.getLocaleString("stOpen");
        if(status==ProcessInstance.STATUS_PROCESSING) return paramRequest.getLocaleString("stProcessing");
        if(status==ProcessInstance.STATUS_STOPED) return paramRequest.getLocaleString("stStopped");
        return "--";
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        User user = response.getUser();
        String act = response.getAction();
        Process p = (Process) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
        
        if (ACT_REMOVEALLPI.equals(act)) {
            if (null != p) {
                Iterator<ProcessInstance> instances = p.listProcessInstances();
                while (instances.hasNext()) {
                    ProcessInstance instance = instances.next();
                    instance.remove();
                }
            }
        } else if (ACT_REMOVEPI.equals(act)) {
            if (null != p) {
                ProcessInstance inst = ProcessInstance.ClassMgr.getProcessInstance(request.getParameter("suripi"), p.getProcessSite());
                if (null != inst) {
                    String removeArtifacts = request.getParameter("removeArtifacts");
                    if (null != removeArtifacts) {
                        //TODO: Remove associated data objects
                    }
                    inst.remove();
                }
            }
        } else if (ACT_CREATEPI.equals(act)) {
            if (null != p) {
                SWBProcessMgr.createProcessInstance(p, user);
            }
        } else if (ACT_PROCESSTASK.equals(act)) {
            System.out.println("Procesando Tarea");
            if (null != p) {
                FlowNodeInstance inst = FlowNodeInstance.ClassMgr.getFlowNodeInstance(request.getParameter("iid"), p.getProcessSite());
                System.out.println("Task: "+inst);
                if (null != inst) {
                    String action = request.getParameter("act");
                    inst.close(user, action);
                }
            }
            response.setRenderParameter("suripi", request.getParameter("suripi"));
        }
        response.setRenderParameter("suri", request.getParameter("suri"));
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (MOD_DETAIL.equals(mode)) {
            doDetail(request, response, paramRequest);
        } else if (MOD_DATA.equals(mode)) {
            doDataView(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

}
