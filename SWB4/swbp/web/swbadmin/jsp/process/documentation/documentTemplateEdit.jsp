<%-- 
    Document   : documentTemplateEdit
    Created on : 2/10/2014, 01:24:09 PM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    User user = paramRequest.getUser();
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    String iconClass = uritc.equals("") ? "fa fa-plus fa-fw" : "fa fa-edit fa-fw";// Ícono del panel editar nuevo o existente
    TemplateContainer templateCont = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    DocumentTemplate docTemplate = (templateCont != null ? templateCont.getActualTemplate() : null);//Plantilla actual - Instancia a editar

    String actionlabel = docTemplate == null ? paramRequest.getLocaleString("btnAddTemplate") : (paramRequest.getLocaleString("btnEditTemplate") + " " + (templateCont != null ? templateCont.getTitle() : ""));
    SWBResourceURL action = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
    SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);

    String act = request.getParameter("action") != null ? request.getParameter("action") : "";
    String lang = paramRequest.getUser() == null ? "es" : user.getLanguage();

    SWBResourceURL urlrds = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_REMOVE_DOCUMENT_SECTION).setParameter("uritc", uritc);
    SWBResourceURL urleds = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_EDIT_DOCUMENT_SECTION).setParameter("uritc", uritc);
    SWBResourceURL viewLog = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_VIEW_LOG).setParameter("uritc", uritc);
    SWBResourceURL viewVersion = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_VIEW_VERSION).setParameter("uritc", uritc);
    SWBResourceURL urlDuplicate = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_DUPLICATE_TEMPLATE);
    List<Process> processes = (List<Process>) request.getAttribute(SWPDocumentTemplateResource.LIST_PROCESSES);
%>
<script src="<%= "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/js/documenter.js"%>"></script>
<script src="<%= "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/js/jquery.bootstrap-duallistbox.min.js"%>"></script>
<script type="text/javascript">
    <% 
    if (!act.equals("") && !act.equals(SWBResourceURL.Action_REMOVE)) {
        %>
        showAlert('guardaCambios');
        <%
        if (act.equals(SWBResourceURL.Action_ADD) || act.endsWith(SWPDocumentTemplateResource.ACTION_DUPLICATE_TEMPLATE)) {
            %>
            appendTemplate('lgTemplates', '<%= templateCont.getId()%>', '<%= url.setParameter("uritc", uritc)%>', '<%= templateCont.getTitle()%>');
            window.location.hash = '#' + <%= templateCont.getId()%>;
            <%
        } else {
            %>
            updateTitleTemplate('<%= templateCont.getTitle()%>', '<%= templateCont.getId()%>');
            <%
        }
    }
    %>
</script>
<div class="panel panel-default swbp-panel">
    <div class="panel-heading swbp-panel-title">
        <div class="panel-title">
            <h1 class="panel-title">
                <span class="<%= iconClass %>"></span><strong><%= actionlabel %></strong>
            </h1>
            <%
            if (null != docTemplate) { // Si es edición, mostrar acciones de Template
                %>
                <div class="pull-right">                
                    <a class="btn btn-sm btn-success fa fa-plus" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnAddSection")%>" title="<%=paramRequest.getLocaleString("btnAddSection")%>"
                       onclick="showModal('<%= url.setMode(SWPDocumentTemplateResource.MODE_EDIT_DOCUMENT_SECTION).setParameter("uritc", templateCont.getURI())%>', '<%=paramRequest.getLocaleString("btnAddSection")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                    </a>
                    <a id="acdte<%= templateCont.getId()%>"
                       class="btn btn-sm btn-success fa fa-sort-numeric-desc" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnVersion")%>" title="<%=paramRequest.getLocaleString("btnVersion")%>"
                       onclick="showModal('<%= viewVersion.setParameter("uritc", docTemplate.getTemplateContainer().getURI())%>', '<%= docTemplate.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                    </a>

                    <a class="btn btn-sm btn-success fa fa-copy" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnCloneTemplate")%>" title="<%=paramRequest.getLocaleString("btnCloneTemplate")%>"
                       onclick="showModal('<%= urlDuplicate.setParameter("uritc", docTemplate.getTemplateContainer().getURI()) %>', '<%= docTemplate.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                    </a>

                    <a class="btn btn-sm btn-success fa fa-info-circle" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnInfo")%>" title="<%=paramRequest.getLocaleString("btnInfo")%>"
                       onclick="showModal('<%= viewLog.setParameter("uritc", templateCont.getURI())%>', '<%= templateCont.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                    </a>
                    <a class="btn btn-sm btn-success fa fa-trash-o" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnDelete")%>" title="<%=paramRequest.getLocaleString("btnDelete")%>"
                       onclick="if (!confirm('<%=paramRequest.getLocaleString("msgDeletePrompt")%> <%= templateCont.getTitle()%>?'))
                                   return false;
                               documenterPost('<%= action.setAction(SWBResourceURL.Action_REMOVE).setParameter("uritc", templateCont.getURI())%>', 'container', 'litc<%= templateCont.getId()%>');">
                    </a>
                </div>
                <%
            }
            %>
        </div>
    </div>
    <form method="post" id="formTemplate" action="<%= action.setAction(docTemplate == null ? SWBResourceURL.Action_ADD : SWBResourceURL.Action_EDIT)%>" class="form-horizontal" role="form">
        <div class="panel-body">
            <div class="form-group" id="divtitletc">
                <label class="col-lg-3 control-label"><%=paramRequest.getLocaleString("lblPropTitle")%>:</label>
                <div class="col-lg-8">
                    <input type="text" name="titletc" id="titletc" required errorMsg="Ingresar el título" value="<%= templateCont == null ? "" : templateCont.getTitle()%>" class="form-control"/>
                    <span class="help-block" id="sphtitletc"></span>
                </div>
            </div>
            <div class="form-group" id="divtitleTemplate">
                <label class="col-lg-3 control-label"><%=paramRequest.getLocaleString("lblVersion")%>:</label>
                <div class="col-lg-8">
                    <label class="label label-success"><%= docTemplate == null ? "" : docTemplate.getTitle()%></label>
                    <span class="help-block" id="sphtitleTemplate"></span>
                </div>
            </div>
            <div class="form-group" id="divprocesess">
                <label class="col-lg-3 control-label"><%=paramRequest.getLocaleString("lblPropScope")%>:</label>
                <div class="col-lg-8">
                    <%
                    if (null == processes || processes.isEmpty()) { //Si no hay procesos 
                        %>
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <strong>Aviso!</strong> No hay procesos para asociar a la plantilla
                        </div>
                        <%
                    } else { // Mostrar los procesos 
                        %>
                        <select multiple="multiple" size="5" name="procesess" class="demo2">
                        <%
                        for (Process process : processes) {
                            String titleProcess = process.getTitle();
                            String uriProcess = process.getURI();
                            %>    
                            <option value="<%= uriProcess%>" <% if (templateCont != null && templateCont.hasProcess(process)) { %> selected="true" <% }%>> <%= titleProcess%></option>
                            <%
                        }
                        %>
                        </select>
                        <script type="text/javascript">
                            var demo2 = $('.demo2').bootstrapDualListbox({
                                nonSelectedListLabel: 'Por asignar',
                                selectedListLabel: 'Asignados',
                                infoTextEmpty: 'No hay procesos',
                                filterTextClear: 'Mostrar todos',
                                preserveSelectionOnMove: 'moved',
                                infoTextFiltered: '{0} de {1}',
                                infoText: 'Total {0}',
                                moveSelectedLabel: 'Agregar seleccionado',
                                moveAllLabel: 'Agregar todos',
                                removeSelectedLabel: 'Quitar seleccionado',
                                removeAllLabel: 'Quitar todos',
                                filterPlaceHolder: 'Filtrar',
                                moveOnSelect: false
                            });
                        </script>
                        <%
                    }
                    %>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">
                    <%=paramRequest.getLocaleString("lblSections")%>
                </label>
            </div> 
            <hr/>
            <%
            if (docTemplate != null) {
                Iterator<DocumentSection> itds = SWBComparator.sortSortableObject(docTemplate.listDocumentSections());
                if (itds.hasNext()) {
                    %>
                    <div class="table-responsive">
                        <table class="table table-hover swbp-table">
                            <thead>
                                <tr>
                                    <th><%=paramRequest.getLocaleString("lblSecActive")%></th>
                                    <th><%=paramRequest.getLocaleString("lblSecTitle")%></th>
                                    <th><%=paramRequest.getLocaleString("lblSecType")%></th>
                                    <th style="width: 100px;"><%=paramRequest.getLocaleString("lblSecOrder")%></th>
                                    <th><%=paramRequest.getLocaleString("lblActions")%></th>
                                </tr>
                            </thead>
                            <tbody id="tbSections">
                            <%
                            while (itds.hasNext()) {
                                DocumentSection docSection = itds.next();
                                String titleds = docSection.getTitle();
                                String typeds = docSection.getSectionType().getDisplayName(lang);
                                String urids = docSection.getURI();
                                %>
                                <tr id="trds<%= docSection.getId()%>">
                                    <td class="swbp-icon-center">
                                        <input <%if (docSection.isActive()) {%>checked="true"<%}%> name="<%= urids%>" id="<%= urids%>" type="checkbox">
                                    </td>
                                    <td><%= titleds%></td>
                                    <td><%= typeds%></td>
                                    <td class="swbp-icon-center"><input type="number" value="<%= docSection.getIndex()%>" name="ind<%= docSection.getURI()%>" class="form-control"/></td>
                                    <td class="swbp-actions">
                                        <a class="btn btn-sm btn-default" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnEdit")%>" title="<%=paramRequest.getLocaleString("btnEdit")%>" 
                                           onclick="showModal('<%=urleds.setParameter("urids", urids)%>', '<%=docSection.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                                            <span class=" fa fa-pencil"></span>
                                        </a>
                                        <a class="btn btn-sm btn-default"rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnDelete")%>" title="<%=paramRequest.getLocaleString("btnDelete")%>" 
                                           onclick="if (!confirm('<%=paramRequest.getLocaleString("msgDeletePrompt")%>: <%=titleds%>?'))
                                                       return false;
                                                   deleteDocumentSection('<%= urlrds.setParameter("urids", docSection.getURI())%>', 'trds<%= docSection.getId()%>');
                                                   return false;">
                                            <span class="fa fa-trash-o"></span>
                                        </a>
                                        <a class="btn btn-sm btn-default" rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("btnInfo")%>" title="<%=paramRequest.getLocaleString("btnInfo")%>" 
                                           onclick="showModal('<%= viewLog.setParameter("uritc", docSection.getURI())%>', '<%=docSection.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                                            <span class="fa fa-info-circle"></span>
                                        </a>
                                    </td>
                                </tr>
                            <%
                            }
                            %>
                            </tbody>
                        </table>
                    </div>
                    <%
                } else {
                    %>
                    <div class="form-group">
                        <div class="col-lg-8 col-lg-offset-3">
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <strong>Aviso!</strong> <%= paramRequest.getLocaleString("msgNoSections")%>
                            </div>
                        </div>
                    </div>
                    <%
                }
            }
            %>
            <div class="form-group" id="guardaCambios"></div>
        </div>
        <div class="panel-footer">
            <div class="row text-center">
                <button type="button" class="btn btn-success" onclick="clearElement('container');">
                    <span class="fa fa-mail-reply fa-fw"></span>
                    <%= paramRequest.getLocaleString("btnCancel")%>
                </button>
                <button type="submit" onclick="submitForm('formTemplate', 'guardaCambios','');
                        return false;" id="savetemp" class="btn btn-success">
                    <span class="fa fa-save fa-fw"></span>
                    <%= paramRequest.getLocaleString("btnSave")%>
                </button>
            </div>
            <input type="hidden" id="uridt" name="uritc" value="<%= uritc%>"/>
        </div>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $('#titletc').focus();
        $('.panel a[rel="tooltip"]')
                .tooltip({placement: 'bottom'})
                .data('tooltip');
    });
</script>