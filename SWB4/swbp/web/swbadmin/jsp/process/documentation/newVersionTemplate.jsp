<%-- 
    Document   : newVersion
    Created on : 10/11/2014, 04:08:26 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    User user = paramRequest.getUser();
    String uridtp = request.getParameter("uridtp") != null ? request.getParameter("uridtp").toString() : "";
    String uridt = request.getParameter("uridt") != null ? request.getParameter("uridt").toString() : "";//Para edición
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    //String uridtn = request.getParameter("uridtn") != null ? request.getParameter("uridtn").toString() : "";
    DocumentTemplate dtp = (DocumentTemplate) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridtp);
    DocumentTemplate dt = (DocumentTemplate) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridt);//Edición
    TemplateContainer tc = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    SWBResourceURL newVersion = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_ADD_VERSION_TEMPLATE);
    String lang = paramRequest.getUser() == null ? "es" : user.getLanguage();
    String lblTitle = "";
    String titleIns = "";
    String descriptionIns = "";
    boolean checked = false;

    if (dtp != null) {
        lblTitle = "Nueva versión de " + (dtp != null ? dtp.getTitle() : "");
        titleIns = dtp.getTitle() != null ? dtp.getTitle() : "";
        descriptionIns = dtp.getDescription() != null ? dtp.getDescription() : "";
    }
    if (dt != null) {
        newVersion.setAction(SWPDocumentTemplateResource.ACTION_EDIT_VERSION_TEMPLATE);
        lblTitle = "Editar " + dt.getTitle();
        titleIns = dt.getTitle() != null ? dt.getTitle() : "";
        descriptionIns = dt.getDescription() != null ? dt.getDescription() : "";
        if (tc.getActualTemplate().getURI().equals(dt.getURI())) {
            checked = true;
        }
    }
    SWBFormMgr forMgr = new SWBFormMgr(DocumentTemplate.sclass, paramRequest.getWebPage().getWebSite().getSemanticObject(), SWBFormMgr.MODE_CREATE);
    String title = forMgr.renderLabel(request, DocumentTemplate.swb_title, SWBFormMgr.MODE_CREATE);
    String description = forMgr.renderLabel(request, DocumentTemplate.swb_description, SWBFormMgr.MODE_CREATE);

    String action = request.getParameter("action") != null ? request.getParameter("action") : "";
    //Si hubó una acción, cerrar el cuadro de diálogo y crear el HTML
    if (!action.equals("")) {
%>
<script type="text/javascript">
    $('#modalDialog').modal('hide');
    $('#acdte<%= tc.getId()%>').trigger('click');
    $('#litc' + location.hash.slice(1)).trigger('click');
</script>
<% }%>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><i class="fa fa-check-square-o"></i> <%=  lblTitle%></h4>
        </div>
        <form class="form-horizontal" action="<%= newVersion%>" id="formNV">
            <div class="modal-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label"><%= title%></label>
                    <div class="col-sm-10">
                        <input required type="text" name="title" id="titlee" class="form-control" value="<%= titleIns%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><%= description%></label>
                    <div class="col-sm-10">
                        <input type="text" name="description" class="form-control" value="<%= descriptionIns%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><%= "Versión actual"%></label>
                    <div class="col-sm-10">
                        <input type="checkbox" name="actual" class="form-control" <% if (checked) {%>checked="true"<%}%>>
                    </div>
                </div>
                <%
                    Iterator<DocumentSection> itds = null;
                    if (dtp != null) {
                        itds = SWBComparator.sortSortableObject(dtp.listDocumentSections());
                    } else if (dt != null) {
                        itds = SWBComparator.sortSortableObject(dt.listDocumentSections());
                    }
                    if (itds != null && itds.hasNext()) {
                %>
                <div class="table-responsive">
                    <table class="table table-hover swbp-table">
                        <thead>
                            <tr>
                                <% if (dtp != null) {%>
                                <th><%=paramRequest.getLocaleString("btnAddSection")%></th>
                                    <% }%>
                                <th><%=paramRequest.getLocaleString("lblSecTitle")%></th>
                                <th><%=paramRequest.getLocaleString("lblSecType")%></th>
                            </tr>
                        </thead>
                        <tbody id="tbSections">
                            <%
                                while (itds.hasNext()) {
                                    DocumentSection ds = itds.next();
                                    String titleds = ds.getTitle();
                                    String typeds = ds.getSectionType().getDisplayName(lang);
                                    String urids = ds.getURI();
                            %>
                            <tr id="trds<%= ds.getId()%>">
                                <% if (dtp != null) {%>
                                <td class="swbp-icon-center">
                                    <input checked="true" name="<%= urids%>" id="<%= urids%>" type="checkbox">
                                </td>
                                <% }%>
                                <td><%= titleds%></td>
                                <td><%= typeds%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <% } else {%>
                <div class="form-group">
                    <div class="col-lg-8 col-lg-offset-3">
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <strong>Aviso!</strong> <%= paramRequest.getLocaleString("msgNoSections")%>
                        </div>
                    </div>
                </div>
                <% }
                %>


            </div>
            <div class="modal-footer text-right">
                <input type="hidden" name="uridt" value="<%= uridt%>">
                <input type="hidden" name="uridtp" value="<%= uridtp%>">
                <input type="hidden" name="uritc" value="<%= uritc%>">
                <input type="hidden" id="data" name="data" value="">
                <button type="button" class="btn btn-default" data-dismiss="modal"><%=paramRequest.getLocaleString("btnClose")%></button>
                <button id="saveFormVersion" class="btn btn-default" type="submit"
                        onclick="submitFormSection('formNV', 'guardaVersion', 'modalDialog', 'saveFormVersion');
                                return false;">
                    <span class="fa fa-save fa-fw"></span> <%=paramRequest.getLocaleString("btnSave")%></button>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#modalDialog').on('shown.bs.modal', function() {
            $('#titlee').focus();
        });
    });
</script>