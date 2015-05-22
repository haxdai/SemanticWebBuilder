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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBClass;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.process.model.FlowNodeInstance;
import org.semanticwb.process.model.ItemAwareReference;
import org.semanticwb.process.model.ProcessInstance;
import org.semanticwb.process.model.ProcessSite;
import org.semanticwb.process.model.SWBProcessMgr;
import org.semanticwb.process.model.SubProcessInstance;
import org.semanticwb.process.model.Task;
import org.semanticwb.process.model.Process;

/**
 *
 * @author juan.fernandez
 */
public class SWBAProcessInstanceList extends GenericResource {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY - HH:mm:ss");
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String id = request.getParameter("suri"); // del process
        String page = request.getParameter("page");
        Process process = null;

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject gobj = ont.getGenericObject(id);

        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }

        if (gobj instanceof Process) {
            process = (Process) gobj;
        } else {
            return;
        }

        ProcessSite site = process.getProcessSite();
        if (null != process) {
            if ("".equals(action)) {
                SWBResourceURL urlact = paramRequest.getActionUrl();
                urlact.setParameter("suri", id);

                SWBResourceURL urlnpi = paramRequest.getActionUrl();
                urlnpi.setParameter("suri", id);
                urlnpi.setParameter("act", "cpi");

                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println("<legend>");
                out.println(paramRequest.getLocaleString("listTitle"));
                out.println("</legend>");
                //out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlnpi + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btnNewProcessInst") + "</button>"); //

                out.println("<table width=\"100%\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>");
                out.println("&nbsp;");
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("id"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("title"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("estatus"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("creator"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("assigned"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("started"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("ended"));
                out.println("</th>");
                out.println("<th>");
                out.println(paramRequest.getLocaleString("docs"));
                out.println("</th>");
                out.println("</tr>");
                out.println("</thead>");

                out.println("<tbody>");
                //TODO:Configurar Listar en Proceso o Todas
                Iterator<ProcessInstance> pit = SWBComparator.sortByCreated(process.listProcessInstances(),false);
                while (pit.hasNext()) {
                    ProcessInstance pi = pit.next();

                    SWBResourceURL urlrem = paramRequest.getActionUrl();
                    urlrem.setParameter("suri", id);
                    urlrem.setParameter("suripi", pi.getId());
                    urlrem.setParameter("act", "rpi");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<a href=\"#\" title=\"" + paramRequest.getLocaleString("remove") + "\" onclick=\"if(confirm('" + paramRequest.getLocaleString("confirm_remove") + " " + SWBUtils.TEXT.scape4Script(pi.getSemanticObject().getDisplayName(user.getLanguage())) + "?')){ submitUrl('" + urlrem + "',this); } else { return false;}\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("remove") + "\"></a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(pi.getId());
                    out.println("</td>");
                    out.println("<td>");

                    //liga para ver el detalle de esta instancia del proceso.
                    SWBResourceURL urlpd = paramRequest.getRenderUrl();
                    urlpd.setParameter("suri", id);
                    urlpd.setParameter("suripi", pi.getURI());
                    urlpd.setParameter("act", "pidetail");

                    out.println("<a href=\"#\" title=\"" + paramRequest.getLocaleString("procInstDetail") + "\" onclick=\"submitUrl('" + urlpd + "',this); return false;\">" + pi.getProcessType().getTitle() + "</a>");
                    //out.println(pi.getProcessType().getTitle());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(getStatusName(pi.getStatus(), paramRequest));
                    out.println("</td>");
                    User usrtmp = pi.getCreator();
                    out.println("<td>");
                    out.println(usrtmp==null?"---":usrtmp.getFullName());
                    out.println("</td>");
                    out.println("<td>");
                    usrtmp = pi.getAssignedto();
                    out.println((usrtmp!=null?usrtmp.getFullName():paramRequest.getLocaleString("notAssigned")));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(sdf.format(pi.getCreated()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(pi.getEnded()!=null?sdf.format(pi.getEnded()):"---");
                    out.println("</td>");

                    //liga para ver artefactos asociados a esta instancia de proceso.
                    SWBResourceURL urlart = paramRequest.getRenderUrl();
                    urlart.setParameter("suri", id);
                    urlart.setParameter("suripi", pi.getId());
                    urlart.setParameter("act", "artifacts");

                    out.println("<td>");
                    out.println("<a href=\"#\" title=\"" + paramRequest.getLocaleString("showartifacts") + "\" onclick=\"submitUrl('" + urlart + "',this); return false;\">" + paramRequest.getLocaleString("msgview") + "</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }


                out.println("</tbody>");
                out.println("<tfoot>");
//                out.println("<tr>");
//                out.println("<td colspan=\"5\">");
//                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlnpi + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btnNewProcessInst") + "</button>"); //
//                out.println("</td>");
//                out.println("</tr>");
//                out.println("</tfoot>");
                out.println("</table>");
                out.println("</fieldset>");
                out.println("<fieldset>");
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlnpi + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btnNewProcessInst") + "</button>"); //
                out.println("</fieldset>");
                out.println("</div>");
            } else if ("artifacts".equals(action)) {
                String pinsturi = request.getParameter("suripi");
                ProcessInstance pi = ProcessInstance.ClassMgr.getProcessInstance(pinsturi, site);

                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println("<legend>");
                out.println(paramRequest.getLocaleString("docs"));
                out.println("</legend>");

                out.println("<ul>");
                Iterator<ItemAwareReference> objit = pi.listAllItemAwareReferences();
                while (objit.hasNext()) {
                    ItemAwareReference item=objit.next();
                    SWBClass obj = item.getProcessObject();
                    if(obj!=null)
                    {
                        //TODO: Verificar nombre del ItemAware
                        out.println("<li>" + item.getItemAware().getDisplayTitle(user.getLanguage()) + "=");
                        out.println("<a href=\"#\"  onclick=\"addNewTab('" + obj.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.cropText(SWBUtils.TEXT.scape4Script(obj.getSemanticObject().getDisplayName()),25) + "');return false;\">" + obj.getSemanticObject().getDisplayName() + "</a>");
                        out.println("</li>");
                    }else
                    {
                        out.println("<li>" + item.getItemAware().getDisplayTitle(user.getLanguage()));
                        out.println("</li>");
                    }
                }
                out.println("</ul>");
                out.println("</fieldset>");
                out.println("<fieldset>");
                SWBResourceURL urlbck = paramRequest.getRenderUrl();
                urlbck.setParameter("suri", id);
                urlbck.setParameter("act", "");
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlbck + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btnBack") + "</button>"); //
                out.println("</fieldset>");
                out.println("</div>");
            } else if ("pidetail".equals(action)) {
                String pinsturi = request.getParameter("suripi");
                GenericObject pigobj = ont.getGenericObject(pinsturi);
                ProcessInstance pi = null;

                if(pigobj instanceof ProcessInstance)
                {
                    pi = (ProcessInstance) pigobj;
                }
                if(null==pi)
                {
                    pi = ProcessInstance.ClassMgr.getProcessInstance(pinsturi, site);
                }

                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println("<legend>");
                out.println(paramRequest.getLocaleString("procInstDetail"));
                out.println("</legend>");

                out.println("<table width=\"100%\">");

                out.println("<tr>");
                out.print("<th>"+paramRequest.getLocaleString("id")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("activity")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("class")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("creator")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("started")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("assigned")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("assignedDate")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("endedby")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("ended")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("action")+"</th>");
                out.print("<th>"+paramRequest.getLocaleString("estatus")+"</th>");
                out.print("<th>&nbsp;</th>");
                out.println("</tr>");

                //pi.getSemanticObject().printStatements();
                
                Iterator<FlowNodeInstance> actit = SWBComparator.sortByCreated(pi.listFlowNodeInstances());
                while (actit.hasNext()) {
                    FlowNodeInstance obj = actit.next();
                    printActivityInstance(obj, out, paramRequest,0);
                }
                out.println("</table>");
                out.println("</fieldset>");
                out.println("<fieldset>");
                SWBResourceURL urlbck = paramRequest.getRenderUrl();
                urlbck.setParameter("suri", id);
                urlbck.setParameter("act", "");
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlbck + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btnBack") + "</button>"); //
                out.println("</fieldset>");
                out.println("</div>");
            }
        }
    }

    public String getStatusName(int status, SWBParamRequest paramRequest) throws SWBResourceException
    {
        String ret = "--";
        if(status==ProcessInstance.STATUS_INIT)
        {
            ret=paramRequest.getLocaleString("stStarted");
        }
        else if(status==ProcessInstance.STATUS_ABORTED)
        {
            ret=paramRequest.getLocaleString("stAborted");
        }
        else if(status==ProcessInstance.STATUS_CLOSED)
        {
            ret=paramRequest.getLocaleString("stClosed");
        }
        else if(status==ProcessInstance.STATUS_OPEN)
        {
            ret=paramRequest.getLocaleString("stOpen");
        }
        else if(status==ProcessInstance.STATUS_PROCESSING)
        {
            ret=paramRequest.getLocaleString("stProcessing");
        }
        else if(status==ProcessInstance.STATUS_STOPED)
        {
            ret=paramRequest.getLocaleString("stStopped");
        }

        return ret;
    }


    public void printActivityInstance(FlowNodeInstance ai, PrintWriter out, SWBParamRequest paramRequest,int espacios) throws IOException, SWBResourceException {
        out.println("<tr>");
        String space = "";
        if(espacios>0)
        {
            for(int i=0;i<(espacios-1);i++)
            {
                space += "==";
            }
            space += "=>";
        }

        out.print("<td>" + ai.getId()+"</td>");
        out.print("<td>"+space+"<b>" + ai.getFlowNodeType().getTitle() + "</b>"+"</td>");
        out.print("<td>"+ ai.getFlowNodeType().getClass().getSimpleName()+"</td>");
        out.print("<td>");
        if(ai.getCreator()!=null)
        {
            out.print("<a href=\"\" onclick=\"addNewTab('"+ai.getCreator().getURI()+"',null,'"+ai.getCreator().getLogin()+"'); return false;\">"+ai.getCreator().getFullName()+"</a>");
        }
        out.print("</td>");
        out.print("<td>");
        if(ai.getCreated()!=null)
        {
            out.print(sdf.format(ai.getCreated()));
        }
        out.print("<td>");
        if(ai.getAssignedto()!=null)
        {
            out.print("<a href=\"\" onclick=\"addNewTab('"+ai.getAssignedto().getURI()+"',null,'"+ai.getAssignedto().getLogin()+"'); return false;\">"+ai.getAssignedto().getFullName()+"</a>");
        }
        out.print("</td>");
        out.print("<td>");
        if(ai.getAssigned()!=null)
        {
            out.print(sdf.format(ai.getAssigned()));
        }
        out.print("</td>");
        out.print("<td>");
        if(ai.getEndedby()!=null)
        {
            out.print("<a href=\"\" onclick=\"addNewTab('"+ai.getEndedby().getURI()+"',null,'"+ai.getEndedby().getLogin()+"'); return false;\">"+ai.getEndedby().getFullName()+"</a>");
        }
        out.print("</td>");
        out.print("<td>");
        if(ai.getEnded()!=null)
        {
            out.print(sdf.format(ai.getEnded()));
        }
        out.print("</td>");
        out.print("<td>");
        if(ai.getAction()!=null)
        {
            out.print(ai.getAction());
        }
        out.print("</td>");
        out.print("<td><b>");
        switch(ai.getStatus())
        {
            case FlowNodeInstance.STATUS_ABORTED:
                out.print(paramRequest.getLocaleString("stAborted"));
                break;
            case FlowNodeInstance.STATUS_CLOSED:
                out.print(paramRequest.getLocaleString("stClosed"));
                break;
            case FlowNodeInstance.STATUS_INIT:
                out.print(paramRequest.getLocaleString("stStarted"));
                break;
            case FlowNodeInstance.STATUS_OPEN:
                out.print(paramRequest.getLocaleString("stOpen"));
                break;
            case FlowNodeInstance.STATUS_PROCESSING:
                out.print(paramRequest.getLocaleString("stProcessing"));
                break;
            case FlowNodeInstance.STATUS_STOPED:
                out.print(paramRequest.getLocaleString("stStopped"));
                break;
        }
        out.println("</b></td>");

        out.println("<td>");
        if(ai.getFlowNodeType() instanceof Task && (ai.getStatus()==FlowNodeInstance.STATUS_PROCESSING || ai.getStatus()==FlowNodeInstance.STATUS_OPEN))
        {
            // Validación por status de FlowNodeInstance en relacion a las acciones posibles a realizar
            SWBResourceURL urlaccept = paramRequest.getActionUrl();
            urlaccept.setParameter("act","accept");
            urlaccept.setParameter("id",ai.getId());
            urlaccept.setParameter("user", paramRequest.getUser().getLogin());
            urlaccept.setParameter("suri",ai.getProcessInstance().getProcessType().getURI());
            urlaccept.setParameter("suripi", ai.getProcessInstance().getURI());
            urlaccept.setParameter("ract", "pidetail");

            SWBResourceURL urlreject = paramRequest.getActionUrl();
            urlreject.setParameter("act","reject");
            urlreject.setParameter("id",ai.getId());
            urlreject.setParameter("user", paramRequest.getUser().getLogin());
            urlreject.setParameter("suri",ai.getProcessInstance().getProcessType().getURI());
            urlreject.setParameter("suripi", ai.getProcessInstance().getURI());
            urlreject.setParameter("ract", "pidetail");

            out.println(" <a href=\"#\" onclick=\"submitUrl('" + urlaccept + "',this); return false;\">"+paramRequest.getLocaleString("accept")+"</a> <a href=\"#\" onclick=\"submitUrl('"+ urlreject + "',this); return false;\">"+paramRequest.getLocaleString("reject")+"</a></li>");
        }
        out.println("</td>");
        out.println("</tr>");
        if (ai instanceof SubProcessInstance) {
            espacios++;
            SubProcessInstance pi = (SubProcessInstance) ai;
            Iterator<FlowNodeInstance> acit = SWBComparator.sortByCreated(pi.listFlowNodeInstances());
            if (acit.hasNext()) {
                while (acit.hasNext()) {
                    FlowNodeInstance actinst = acit.next();
                    printActivityInstance(actinst, out, paramRequest,espacios);
                }
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        User user = response.getUser();
        String id = request.getParameter("suri");
        String act = request.getParameter("act");
        String ract = request.getParameter("ract");
        org.semanticwb.process.model.Process process = null;
        ProcessSite site = null;

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject gobj = ont.getGenericObject(id);

        if (act == null) {
            act = "";
        }

        if (gobj instanceof org.semanticwb.process.model.Process) {
            process = (org.semanticwb.process.model.Process) gobj;
        } else {
            return;
        }

        site = process.getProcessSite();
        if (act.equals("rpi")) {

            String pinst = request.getParameter("suripi");
            ProcessInstance inst = ProcessInstance.ClassMgr.getProcessInstance(pinst, site);
            inst.remove();
        }
        if (act.equals("cpi")) {

            process = (org.semanticwb.process.model.Process) SemanticObject.createSemanticObject(id).createGenericInstance();
            SWBProcessMgr.createProcessInstance(process, user);
        }
        if (act.equals("accept") || act.equals("reject")) {

            String piid = request.getParameter("id");
            FlowNodeInstance inst = FlowNodeInstance.ClassMgr.getFlowNodeInstance(piid, site);
            inst.close(user, act);
        }

        if (id != null) {
            response.setRenderParameter("suri", id);
        }
        if (ract != null) {
            response.setRenderParameter("act", ract); //suripi
        }
        if (request.getParameter("suripi") != null) {
            response.setRenderParameter("suripi", request.getParameter("suripi"));
        }
    }
}
