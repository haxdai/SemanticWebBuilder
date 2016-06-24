<%-- 
    Document   : ReportResourceExport
    Created on : 4/09/2013, 12:53:03 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.resources.reports.Report"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
Report report = Report.ClassMgr.getReport(request.getAttribute("idReport").toString(), paramRequest.getWebPage().getWebSite());
SWBResourceURL urlReport = paramRequest.getRenderUrl().setMode("generate").setCallMethod(SWBParamRequest.Call_DIRECT);
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title"><%= paramRequest.getLocaleString("report") %></h5>
        </div>
        <form id="downloadForm" method="post" action="<%= urlReport %>" class="form-horizontal swbp-form">
            <input type="hidden" id="idReport" name="idReport" value="<%=report.getId()%>"/>
            <div class="modal-body">
                <div class="form-group">
                    <label for="pid" class="col-sm-4">Formato de descarga</label>
                    <div class="col-sm-7">
                        <select class="form-control" name="extension" required>
                            <option value="xls" selected>Excel</option>
                            <option value="pdf">PDF</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" type="submit">
                    <span class="fa fa-download fa-fw"></span><span class="hidden-xs">Descargar</span>
                </button>
                <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                    <span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs">Cancelar</span>
                </button>
            </div>
        </form>
    </div>
</div>
<script>
    (function(){
        $(document).ready(function(){
            $("#downloadForm").on("submit", function() {
                $('#modalDialog').modal('toggle');
            });
        });
    })();
</script>
