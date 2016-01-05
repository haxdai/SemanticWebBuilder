<%-- 
    Document   : versions
    Created on : 24/04/2014, 09:00:53 AM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.Documentation"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String uridi = request.getParameter("uridi") != null ? request.getParameter("uridi") : "";
    String idp = request.getParameter("idp") != null ? request.getParameter("idp") : "";
    WebSite site = paramRequest.getWebPage().getWebSite();
    Process process = Process.ClassMgr.getProcess(idp, site);
    String lang = "es";
    Locale loc = new Locale(lang);
    DateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss", loc);
    SWBResourceURL urlRemove = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_REMOVE_VERSION).setParameter("idp", idp);
    //urlRemove.setParameter("suri", process.getURI());
    String remove = request.getParameter("remove") != null ? request.getParameter("remove") : "";

%>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><i class="fa fa-check-square-o"></i> Versiones de: <%= process.getTitle() != null ? process.getTitle() : ""%></h4>
        </div>
        <div class="modal-body">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Título</th>
                            <th>Descripción</th>
                            <th>Creación</th>
                            <th style="width: 155px;">Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="tbVersions"> 
                        <%
                            if (process != null) {
                                int i = 0;
                                Iterator<Documentation> it = SWBComparator.sortByCreated(Documentation.ClassMgr.listDocumentationByProcess(process), true);
                                while (it.hasNext()) {
                                    Documentation documentation = it.next();
                                    String title = documentation.getTitle() != null ? documentation.getTitle() : "";
                                    String desc = documentation.getDescription() != null ? documentation.getDescription() : "";
                                    String created = documentation.getCreated() != null ? sdf.format(documentation.getCreated()) : "";
                        %>
                        <tr>
                            <td><%=title%></td>
                            <td><%= desc%></td>
                            <td><%= created%></td>
                            <td class="text-left">
                               
                                    <%if(!documentation.isActualVersion()) {%>
                                <a 
                                    onclick="if (!confirm('Eliminar versión?'))
                                                return false;
                                            submitUrl('<%= urlRemove.setParameter("uridoc", documentation.getURI())%>', 'modalDialog');"
                                        class="btn btn-default btn-sm" rel="tooltip" data-original-title="Eliminar" title="Eliminar"><span class="fa fa-trash-o"></span></a>
                                    <%}%>
                            </td>
                        </tr>   
                        <% }
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="form-group" id="guardaVersion">
            </div>
            <br>
        </div>
        <div class="modal-footer text-right">
            <button type="button" class="btn btn-default" data-dismiss="modal"><%=paramRequest.getLocaleString("btnClose")%></button>
        </div>
    </div>
</div>
