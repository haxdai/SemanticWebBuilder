<%-- 
    Document   : logView
    Created on : 13/12/2013, 04:24:31 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.Template"%>
<%@page import="java.util.Locale"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.base.DescriptiveableBase"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");

    //String uridt = request.getParameter("uridt") != null ? request.getParameter("uridt").toString() : "";
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    TemplateContainer tc = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    SWBResourceURL admVersion = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_EDIT_VERSION_TEMPLATE).setParameter("uritc", uritc);
    SWBResourceURL editVersion = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_EDIT_VERSION_TEMPLATE).setParameter("uritc", uritc);
    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_DEFINE_VERSION_TEMPLATE).setParameter("uritc", uritc);
    SWBResourceURL urlActionRemove = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_REMOVE_VERSION_TEMPLATE).setParameter("uritc", uritc);
    String lang = "es";
    User user = paramRequest.getUser();
    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
    Locale loc = new Locale(lang);
    DateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss", loc);
    String action = request.getParameter("action") != null ? request.getParameter("action") : "";
    if (tc != null) {
%>
<script type="text/javascript">
    $(document).ready(function() {
    <%if (!action.equals("")) {    %>
        if (location.hash.slice(1) !== '') {
            $('#litc' + location.hash.slice(1)).trigger('click');
        }
    <% }%>

        $('.modal a[rel="tooltip"]')
                .tooltip({placement: 'bottom'})
                .data('tooltip');
    });
</script>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><i class="fa fa-check-square-o"></i> Versiones de: <%= tc.getTitle() != null ? tc.getTitle() : ""%></h4>
        </div>
        <div class="modal-body">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Título</th>
                            <th>Descripción</th>
                            <th>Creación</th>
                            <th>Creador</th>
                            <th style="width: 155px;">Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="tbVersions"> 
                        <%
                            if (tc != null) {
                                int i = 0;
                                Iterator<DocumentTemplate> it = tc.listTemplates();
                                while (it.hasNext()) {
                                    it.next();
                                    i++;
                                    if (i > 1) {
                                        break;
                                    }
                                }
                                it = SWBComparator.sortByCreated(tc.listTemplates(), true);
                                while (it.hasNext()) {
                                    DocumentTemplate dt = it.next();
                                    String title = dt.getTitle() != null ? dt.getTitle() : "";
                                    String desc = dt.getDescription() != null ? dt.getDescription() : "";
                                    String creator = dt.getCreator() != null ? dt.getCreator().getFullName() : "";
                                    String created = dt.getCreated() != null ? sdf.format(dt.getCreated()) : "";
                                    boolean actual = tc.getActualTemplate().getURI().equals(dt.getURI());
                        %>
                        <tr class="<% if (actual) {%>success<% }%>" id="trdvt<%= dt.getId()%>">
                            <td><%=title%></td>
                            <td><%= desc%></td>
                            <td><%= created%></td>
                            <td><%= creator%></td>
                            <td class="text-right">
                                <% if (!actual) {%>
                                <a 
                                    onclick="if (!confirm('Definir como versión actual?'))
                                                return false;
                                            submitUrl('<%= urlAction.setParameter("uridt", dt.getURI())%>', 'modalDialog');"
                                        class="btn btn-default btn-sm" rel="tooltip" data-original-title="Hacer versión actual" title="Definir como versión actual"><span class="fa fa-check-square-o"></span></a>
                                    <% }%>
                                     
                                <a 
                                    onclick="showModal('<%= editVersion.setParameter("uridt", dt.getURI())%>', '<%= dt.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                                    class="btn btn-default btn-sm" rel="tooltip" data-original-title="Editar" title="Editar"><span class="fa fa-pencil"></span></a>
                                    <a rel="tooltip" data-original-title="Nueva versión" title="Nueva versión"
                                   onclick="showModal('<%= admVersion.setParameter("uridtp", dt.getURI())%>', '<%= dt.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                                   class="btn btn-default btn-sm"><span class="fa fa-plus"></span></a>
                                    <%if (i > 1) {%>
                                <a 
                                    onclick="if (!confirm('Eliminar versión?'))
                                                return false;
                                            submitUrl('<%= urlActionRemove.setParameter("uridt", dt.getURI())%>', 'modalDialog');"
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
<%
    }
%>