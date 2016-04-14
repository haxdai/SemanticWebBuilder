<%@page import="org.semanticwb.process.resources.SWBAProcessInstanceList"%>
<%@page import="org.semanticwb.portal.api.SWBResourceException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.model.SubProcessInstance"%>
<%@page import="org.semanticwb.process.model.Task"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.model.ProcessInstance"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.process.model.base.ProcessInstanceBase"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    public String printActivityInstance(FlowNodeInstance ai, SWBParamRequest paramRequest, int espacios) throws SWBResourceException {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        StringBuilder sbf = new StringBuilder();
        sbf.append("<tr>");
        String space = "";
        if(espacios>0)
        {
            for(int i=0;i<(espacios-1);i++)
            {
                space += "==";
            }
            space += "=>";
        }

        sbf.append("<td>" + ai.getId()+"</td>");
        sbf.append("<td>"+space+"<b>" + ai.getFlowNodeType().getTitle() + "</b>"+"</td>");
        sbf.append("<td>"+ ai.getFlowNodeType().getClass().getSimpleName()+"</td>");
        sbf.append("<td>");
        if(ai.getCreator()!=null)
        {
            sbf.append("<a href=\"\" onclick=\"addNewTab('"+ai.getCreator().getURI()+"',null,'"+ai.getCreator().getLogin()+"'); return false;\">"+ai.getCreator().getFullName()+"</a>");
        }
        sbf.append("</td>");
        sbf.append("<td>");
        if(ai.getCreated()!=null)
        {
            sbf.append(format.format(ai.getCreated()));
        }
        sbf.append("<td>");
        if(ai.getAssignedto()!=null)
        {
            sbf.append("<a href=\"\" onclick=\"addNewTab('"+ai.getAssignedto().getURI()+"',null,'"+ai.getAssignedto().getLogin()+"'); return false;\">"+ai.getAssignedto().getFullName()+"</a>");
        }
        sbf.append("</td>");
        sbf.append("<td>");
        if(ai.getAssigned()!=null)
        {
            sbf.append(format.format(ai.getAssigned()));
        }
        sbf.append("</td>");
        sbf.append("<td>");
        if(ai.getEndedby()!=null)
        {
            sbf.append("<a href=\"\" onclick=\"addNewTab('"+ai.getEndedby().getURI()+"',null,'"+ai.getEndedby().getLogin()+"'); return false;\">"+ai.getEndedby().getFullName()+"</a>");
        }
        sbf.append("</td>");
        sbf.append("<td>");
        if(ai.getEnded()!=null)
        {
            sbf.append(format.format(ai.getEnded()));
        }
        sbf.append("</td>");
        sbf.append("<td>");
        if(ai.getAction()!=null)
        {
            sbf.append(ai.getAction());
        }
        sbf.append("</td>");
        sbf.append("<td><b>");
        switch(ai.getStatus())
        {
            case FlowNodeInstance.STATUS_ABORTED:
                sbf.append(paramRequest.getLocaleString("stAborted"));
                break;
            case FlowNodeInstance.STATUS_CLOSED:
                sbf.append(paramRequest.getLocaleString("stClosed"));
                break;
            case FlowNodeInstance.STATUS_INIT:
                sbf.append(paramRequest.getLocaleString("stStarted"));
                break;
            case FlowNodeInstance.STATUS_OPEN:
                sbf.append(paramRequest.getLocaleString("stOpen"));
                break;
            case FlowNodeInstance.STATUS_PROCESSING:
                sbf.append(paramRequest.getLocaleString("stProcessing"));
                break;
            case FlowNodeInstance.STATUS_STOPED:
                sbf.append(paramRequest.getLocaleString("stStopped"));
                break;
        }
        sbf.append("</b></td>");

        sbf.append("<td>");
        if(ai.getFlowNodeType() instanceof Task && (ai.getStatus()==FlowNodeInstance.STATUS_PROCESSING || ai.getStatus()==FlowNodeInstance.STATUS_OPEN))
        {
            // Validación por status de FlowNodeInstance en relacion a las acciones posibles a realizar
            SWBResourceURL urlprocess = paramRequest.getActionUrl().setAction(SWBAProcessInstanceList.ACT_PROCESSTASK);
            urlprocess.setParameter("act","accept");
            urlprocess.setParameter("iid",ai.getId());
            urlprocess.setParameter("suri",ai.getProcessInstance().getProcessType().getURI());
            urlprocess.setParameter("suripi", ai.getProcessInstance().getId());

            SWBResourceURL urlreject = paramRequest.getActionUrl().setAction(SWBAProcessInstanceList.ACT_PROCESSTASK);
            urlreject.setParameter("act","reject");
            urlreject.setParameter("iid",ai.getId());
            urlreject.setParameter("suri",ai.getProcessInstance().getProcessType().getURI());
            urlreject.setParameter("suripi", ai.getProcessInstance().getId());

            sbf.append(" <a href=\"#\" onclick=\"submitUrl('" + urlprocess + "',this); return false;\">"+paramRequest.getLocaleString("accept")+"</a> <a href=\"#\" onclick=\"submitUrl('"+ urlreject + "',this); return false;\">"+paramRequest.getLocaleString("reject")+"</a></li>");
        }
        sbf.append("</td>");
        sbf.append("</tr>");
        if (ai instanceof SubProcessInstance) {
            espacios++;
            SubProcessInstance pi = (SubProcessInstance) ai;
            Iterator<FlowNodeInstance> acit = SWBComparator.sortByCreated(pi.listFlowNodeInstances());
            if (acit.hasNext()) {
                while (acit.hasNext()) {
                    FlowNodeInstance actinst = acit.next();
                    sbf.append(printActivityInstance(actinst, paramRequest, espacios));
                }
            }
        }
        return sbf.toString();
    }
%>
<%
GenericObject go = (GenericObject)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
if (null != go) {
    Process p = (Process)go;
    ProcessInstance instance = ProcessInstance.ClassMgr.getProcessInstance(request.getParameter("suripi"), p.getProcessSite());
    if (null != instance) {
        %>
        <div class="swbform">
            <fieldset><legend><%= paramRequest.getLocaleString("procInstDetail") + " " + instance.getId() %></legend>
                <%
                Iterator<FlowNodeInstance> acts = SWBComparator.sortByCreated(instance.listFlowNodeInstances());
                if (acts.hasNext()) {
                    %>
                    <table style="width:100%;">
                        <thead>
                            <tr>
                                <th><%= paramRequest.getLocaleString("id") %></th>
                                <th><%= paramRequest.getLocaleString("activity") %></th>
                                <th><%= paramRequest.getLocaleString("class") %></th>
                                <th><%= paramRequest.getLocaleString("creator") %></th>
                                <th><%= paramRequest.getLocaleString("started") %></th>
                                <th><%= paramRequest.getLocaleString("assigned") %></th>
                                <th><%= paramRequest.getLocaleString("assignedDate") %></th>
                                <th><%= paramRequest.getLocaleString("endedby") %></th>
                                <th><%= paramRequest.getLocaleString("ended") %></th>
                                <th><%= paramRequest.getLocaleString("action") %></th>
                                <th><%= paramRequest.getLocaleString("estatus") %></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            while (acts.hasNext()) {
                                FlowNodeInstance fni = acts.next();
                                out.println(printActivityInstance(fni, paramRequest, 0));
                            }
                            %>
                        </tbody>
                    </table>
                    <%
                }
                %>
            </fieldset>
            <fieldset>
                <%
                SWBResourceURL back = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
                back.setParameter("suri", request.getParameter("suri"));
                %>
                <button dojoType="dijit.form.Button" onclick="submitUrl('<%= back %>',this.domNode); return false;"><%= paramRequest.getLocaleString("btnBack") %></button>
            </fieldset>
        </div>
        <%
    }
}
%>