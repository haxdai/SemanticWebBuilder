<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.process.model.ProcessInstance"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.process.resources.SWBAProcessInstanceList"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
Iterator<ProcessInstance> instances = (Iterator<ProcessInstance>) request.getAttribute(SWBAProcessInstanceList.ATT_INSTANCES);
boolean hasInstances = null != instances && instances.hasNext();
SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
%>
<div class="swbform">
    <fieldset>
        <legend>Instancias del proceso</legend>
        <%
        if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite())) {
            if (hasInstances) {
                %>
                <table style="width:100%">
                    <thead>
                        <tr>
                            <th><%= paramRequest.getLocaleString("id") %></th>
                            <th><%= paramRequest.getLocaleString("title") %></th>
                            <th><%= paramRequest.getLocaleString("estatus") %></th>
                            <th><%= paramRequest.getLocaleString("creator") %></th>
                            <th><%= paramRequest.getLocaleString("assigned") %></th>
                            <th><%= paramRequest.getLocaleString("started") %></th>
                            <th><%= paramRequest.getLocaleString("ended") %></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        SWBResourceURL urlact = paramRequest.getActionUrl().setAction(SWBAProcessInstanceList.ACT_REMOVEPI);
                        urlact.setParameter("suri", request.getParameter("suri"));

                        SWBResourceURL urlDetail = paramRequest.getRenderUrl();
                        urlDetail.setParameter("suri", request.getParameter("suri"));

                        while(instances.hasNext()) {
                            ProcessInstance instance = instances.next();
                            urlact.setParameter("suripi", instance.getId());
                            urlDetail.setParameter("suripi", instance.getId());
                            urlDetail.setMode(SWBAProcessInstanceList.MOD_DETAIL);
                            %>
                            <tr>
                                <td><%= instance.getId() %></td>
                                <td><a href="#" onclick="submitUrl('<%= urlDetail %>', this); return false;"><%= instance.getProcessType().getTitle() %></a></td>
                                <td><%= SWBAProcessInstanceList.getStatusName(instance.getStatus(), paramRequest) %></td>
                                <td><%= instance.getCreator() != null ? instance.getCreator().getFullName() : "--" %></td>
                                <td><%= instance.getAssignedto()!= null ? instance.getAssignedto().getFullName() : paramRequest.getLocaleString("notAssigned") %></td>
                                <td><%= format.format(instance.getCreated()) %></td>
                                <td><%= instance.getEnded() != null ? format.format(instance.getEnded()) : "--" %></td>
                                <%
                                urlDetail.setMode(SWBAProcessInstanceList.MOD_DATA);
                                %>
                                <td style="width:60px;">
                                    <a href="#" title="<%= paramRequest.getLocaleString("remove") %>" onclick="if(confirm('<%= paramRequest.getLocaleString("confirm_remove") + " " + SWBUtils.TEXT.scape4Script(instance.getSemanticObject().getDisplayName(paramRequest.getUser().getLanguage())) + "?"%>')){ submitUrl('<%= urlact %>',this); } else { return false;}"><img src="<%= SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif" %>" border="0" alt="<%= paramRequest.getLocaleString("remove") %>" /></a>
                                    <a href="#" title="<%= paramRequest.getLocaleString("docs") %>"onclick="submitUrl('<%= urlDetail %>',this); return false;"><img src="<%= SWBPlatform.getContextPath() + "/swbadmin/images/Repository/folder.gif" %>" /></a>
                                </td>
                            </tr>
                            <%
                        }
                        %>
                    </tbody>
                </table>
                <%
            }
        }
        %>
    </fieldset>
    <fieldset>
        <%
        SWBResourceURL actUrl = paramRequest.getActionUrl().setAction(SWBAProcessInstanceList.ACT_CREATEPI);
        actUrl.setParameter("suri", request.getParameter("suri"));
        %>
        <button dojoType="dijit.form.Button" onclick="submitUrl('<%= actUrl %>',this.domNode); return false;"><%= paramRequest.getLocaleString("btnNewProcessInst") %></button>
        <%
        if (hasInstances) {
            actUrl.setAction(SWBAProcessInstanceList.ACT_REMOVEALLPI);
            %>
            <button dojoType="dijit.form.Button" onclick="if (confirm('<%= paramRequest.getLocaleString("confirm_removeall") %>')) { submitUrl('<%= actUrl %>',this.domNode); } else { return false };"><%= paramRequest.getLocaleString("btnRemoveAllIns") %></button>
            <%
        }
        %>
    </fieldset>
</div>