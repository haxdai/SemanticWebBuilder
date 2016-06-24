<%-- 
    Document   : ReportResourceEdit
    Created on : 11/03/2013, 05:23:28 PM
    Author     : carlos.alvarez
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.process.resources.reports.ColumnReport"%>
<%@page import="org.semanticwb.process.resources.reports.Report"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.model.ItemAware"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<!--%@page contentType="text/html"%-->
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    SWBResourceURL urlAction = paramRequest.getActionUrl();
    Report obj = Report.ClassMgr.getReport(request.getParameter("idReport"), paramRequest.getWebPage().getWebSite());
    Integer total = 0;
    SWBFormMgr tipo = new SWBFormMgr(obj.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
    String lang = "";
    if (paramRequest.getUser() != null) {
        lang = paramRequest.getUser().getLanguage();
    }
    tipo.setType(SWBFormMgr.TYPE_DOJO);
    tipo.setLang(lang);
    Integer contador = 0;
    String objeto = "";
    SWBResourceURL urlDialog = paramRequest.getRenderUrl().setMode("dialog").setCallMethod(SWBResourceURL.Call_DIRECT);
    urlDialog.setParameter("idReport", obj.getId());
    urlDialog.setParameter("action", "export");
    
    Report report = Report.ClassMgr.getReport(request.getParameter("idReport"), paramRequest.getWebPage().getWebSite());
    User user = paramRequest.getUser();
    
    ArrayList<String> conf = new ArrayList<>();

    Iterator<ColumnReport> cols = obj.listColumnReports();//ColumnReport.ClassMgr.listColumnReportByReportName(obj);
    while (cols.hasNext()) {
        ColumnReport col = cols.next();
        conf.add(col.getNameProperty());
    }

    if (null != report) {
        %>
        <script src="<%= SWBPlatform.getContextPath()%>/swbadmin/jsp/process/documentation/js/jquery.bootstrap-duallistbox.min.js"></script>
        <div class="row no-margin swbp-button-ribbon text-right">
            <a href="<%= paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW) %>" class="btn btn-swbp-action">Regresar</a>
        </div>
        <hr/>
        <div class="panel panel-default swbp-panel-head no-margin">
            <div class="panel-heading text-center"><%= obj.getTitle() %></div>
        </div>
        <form action="<%= urlAction.setAction(SWBResourceURL.Action_EDIT) %>" methid="post" class="form-horizontal swbp-form">
            <input type="hidden" name="idReport" value="<%= report.getId() %>" />
            <div class="panel-body swbp-panel-body-card">
                <div class="form-group">
                    <label for=""><h5><%= paramRequest.getLocaleString("title") %> *</h5></label>
                    <input type="text" name="title" id="title" class="form-control" value="<%= obj.getTitle() %>" required >
                </div>
                <div class="row form-group">
                    <label for=""><h5><%=paramRequest.getLocaleString("process")%> *</h5></label>
                    <select class="form-control" name="processName">
                        <%
                        Iterator<Process> processes = SWBComparator.sortByDisplayName(Process.ClassMgr.listProcesses(paramRequest.getWebPage().getWebSite()), lang);
                        while (processes.hasNext()) {
                            Process p = processes.next();
                            if (p.isValid() && user.haveAccess(p)) {
                                %><option value="<%= p.getURI() %>" <% if (obj.getProcessName().getURI().equals(p.getURI())) { %> selected <% } %>><%= p.getTitle() %></option><%
                            }
                        }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for=""><h5><%= paramRequest.getLocaleString("pagingSize") %></h5></label>
                    <input type="text" name="pagingSize" class="form-control" placeholder="<%=paramRequest.getLocaleString("pagingSize")%>" value="<%= obj.getPagingSize() %>"/>
                </div>
                <div class="form-group">
                    <label><h5>Columnas</h5></label>
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <select multiple="multiple" size="5" name="property" id="propSelect">
                                <%
                                Iterator<ItemAware> dataObjs = obj.getProcessName().listRelatedItemAware().iterator();
                                while (dataObjs.hasNext()) {
                                    ItemAware iaw = dataObjs.next();
                                    if (iaw.getItemSemanticClass() != null) {
                                        Iterator<SemanticProperty> sp = iaw.getItemSemanticClass().listProperties();
                                        while (sp.hasNext()) {
                                            SemanticProperty spr = sp.next();
                                            if (!spr.getPropId().equals("swb:valid")) {
                                                %>
                                                <option value="<%= iaw.getURI() + "|" + spr.getPropId() %>" <% if (conf.contains(iaw.getURI() + "|" + spr.getPropId())) { %> selected="true" <% }%>> <%= iaw.getDisplayTitle(lang) + "." + spr.getName() %></option>
                                                <%
                                            }
                                        }
                                    }
                                }
                                %>
                            </select>
                        </div>
                        <script type="text/javascript">
                            var demo2 = $('#propSelect').bootstrapDualListbox({
                                nonSelectedListLabel: 'Disponibles',
                                selectedListLabel: 'Asignadas',
                                infoTextEmpty: 'No hay columnas',
                                filterTextClear: 'Borrar filtro',
                                preserveSelectionOnMove: 'moved',
                                infoTextFiltered: '{0} de {1}',
                                infoText: '',
                                moveSelectedLabel: 'Agregar seleccionadas',
                                moveAllLabel: 'Agregar todas',
                                removeSelectedLabel: 'Quitar seleccionadas',
                                removeAllLabel: 'Quitar todas',
                                filterPlaceHolder: 'Filtrar',
                                moveOnSelect: false
                            });
                        </script>
                    </div>
                </div>
            </div>
            <div class="panel-footer text-right">
                <button type="submit" class="btn btn-default"><span class="fa fa-save fa-fw"></span>Guardar</button>
            </div>
        </form>
        <%
        if (!conf.isEmpty()) {
            %>
            <div class="panel panel-default swbp-panel-head no-margin">
                <div class="panel-heading text-center">Configuración de columnas</div>
                <form method="post" action="<%=urlAction.setAction("updateColumn")%>" class="form-horizontal swbp-form">
                    <input type="hidden" name="idReport" value="<%= obj.getId() %>"/>
                    <div class="panel-body swbp-panel-body-card">
                        <div class="table-responsive-vertical shadow-z-1 swbp-table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Visible</th>
                                        <th>Propiedad</th>
                                        <th>Etiqueta</th>
                                        <th>Ordenamiento</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    cols = SWBComparator.sortSortableObject(obj.listColumnReports());
                                    while (cols.hasNext()) {
                                        ColumnReport col = cols.next();
                                        SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(col.getNameProperty().substring(col.getNameProperty().indexOf("|") + 1));
                                        SemanticObject semObj = SemanticObject.createSemanticObject(col.getNameProperty().substring(0, col.getNameProperty().indexOf("|")));
                                        ItemAware iaw = null;

                                        if (null != semObj) {
                                            iaw = (ItemAware) semObj.createGenericInstance();
                                        }

                                        if (null != iaw) {
                                            %>
                                            <tr>
                                                <td data-title="Visible" class="text-center">
                                                    <input type="checkbox" class="css-checkbox" name="visible_<%= col.getURI() %>" id="visible_<%= col.getURI() %>" <%= col.isColumnVisible() ? "checked" : "" %>/>
                                                    <label class="css-label" for="visible_<%= col.getURI() %>"></label>
                                                </td>
                                                <td data-title="Propiedad">
                                                    <%= iaw.getTitle() + "." + sp.getName() %>
                                                </td>
                                                <td data-title="Etiqueta">
                                                    <input class="form-control" placeholder="<%=paramRequest.getLocaleString("title")%>" type="text" name="title_<%=col.getURI()%>" value="<%=col.getTitleColumn() == null ? sp.getDisplayName(lang) : col.getTitleColumn()%>" />
                                                </td>
                                                <td data-title="Ordenamiento">
                                                    <input class="form-control" type="number" name="index_<%=col.getURI()%>" value="<%=col.getIndex()%>" />
                                                </td>
                                            </tr>
                                            <%
                                        }
                                    }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="panel-footer text-right">
                        <button type="submit" class="btn btn-default">Actualizar columnas</button>
                    </div>
                </form>
            </div>
            <%
        }
    }
%>