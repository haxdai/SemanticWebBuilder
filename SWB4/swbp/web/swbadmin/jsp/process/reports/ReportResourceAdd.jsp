<%-- 
    Document   : ReportResourceAdd
    Created on : 11/03/2013, 05:23:28 PM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.process.resources.reports.Report"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page contentType="text/html"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String lang = "";
    if (paramRequest.getUser() != null) {
        lang = paramRequest.getUser().getLanguage();
    }
    User user = paramRequest.getUser();
    SWBResourceURL urlAction = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD);
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title"><%= paramRequest.getLocaleString("add") %></h5>
        </div>
        <form id="addReportForm" action="<%=urlAction%>" method="post" class="form-horizontal swbp-form">
            <div class="modal-body">
                <div class="form-group">
                    <label for="" class="col-sm-3 control-label"><%= paramRequest.getLocaleString("title") %> *</label>
                    <div class="col-sm-8">
                        <input type="text" name="title" id="title" class="form-control" required >
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="col-sm-3 control-label"><%=paramRequest.getLocaleString("process")%> *</label>
                    <div class="col-sm-8">
                        <select class="form-control" name="processName">
                            <%
                            Iterator<Process> processes = SWBComparator.sortByDisplayName(Process.ClassMgr.listProcesses(paramRequest.getWebPage().getWebSite()), lang);
                            while (processes.hasNext()) {
                                Process p = processes.next();
                                if (p.isValid() && user.haveAccess(p)) {
                                    %><option value="<%= p.getURI() %>"><%= p.getTitle() %></option><%
                                }
                            }
                            %>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="col-sm-3 control-label"><%= paramRequest.getLocaleString("pagingSize") %></label>
                    <div class="col-sm-8">
                        <input type="text" name="pagingSize" class="form-control" />
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" type="submit">
                    <span class="fa fa-save fa-fw"></span><span class="hidden-xs"><%= paramRequest.getLocaleString("save") %></span>
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
        var isTitleValid = function(element) {
            if (element.required) {
                return !element.validity.valueMissing;
            } else {
                return element.value && element.value !== "";
            }
        };
        
        var isSelectValid = function(element) {
            if (element.required) {
                return !element.validity.valueMissing;
            } else {
                return element.value && element.value !== "";
            }
        };
        
        var theForm = document.getElementById("addReportForm");
        if (theForm) {
            theForm['processName'].addEventListener("change", function(evt) {
                if (isSelectValid(evt.target)) {
                    $(evt.target).closest(".form-group").removeClass("has-error");
                } else {
                    $(evt.target).closest(".form-group").addClass("has-error");
                }
            });
            
            theForm['title'].addEventListener("change", function(evt) {
                if (isTitleValid(evt.target)) {
                    $(evt.target).closest(".form-group").removeClass("has-error");
                } else {
                    $(evt.target).closest(".form-group").addClass("has-error");
                }
            });
            
            theForm.addEventListener('submit', function(evt) {
                var valid = isTitleValid(theForm['title']) && isSelectValid(theForm['processName']);                           
                if (valid) {
                    $.ajax({
                        url: $(theForm).attr('action'),
                        cache: false,
                        data: $(theForm).serialize(),
                        type: 'POST',
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        success: function(data) {
                            if (data.status && data.status === "ok") {
                                var loc = '<%= paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setMode(SWBResourceURL.Mode_EDIT) %>?idReport='+data.idReport;
                                window.location = loc;
                            }
                        }
                    });
                }
                evt.preventDefault();
                return false;
            });
        }
    })();
</script>