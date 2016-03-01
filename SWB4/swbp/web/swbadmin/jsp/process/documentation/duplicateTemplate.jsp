<%-- 
    Document   : duplicateTemplate
    Created on : 9/12/2014, 05:26:29 PM
    Author     : carlos.alvarez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    TemplateContainer tc = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    SWBResourceURL urlSave = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_DUPLICATE_TEMPLATE).setParameter("uritc", uritc);
%>
<div class="modal-dialog">
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Duplicar plantilla</h4>
        </div>
        <form action="<%= urlSave %>" method="post" id="formdte" class="form-horizontal" role="form">
            <div class="modal-body">
                <div class="form-group" id="divtitletcd">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for="">Título *:</label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                        <input name="titletcd" id="titletcd" required value="<%= tc == null ? "" : tc.getTitle()%>" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for="">Versión *:</label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                        <select name="versiontemp" class="form-control" required>
                            <option>Seleccione una versión</option>
                            <%
                            if (null != tc) {
                                Iterator<DocumentTemplate> it = SWBComparator.sortByCreated(tc.listTemplates(), false);
                                while (it.hasNext()) {
                                    DocumentTemplate dt = it.next();
                                    %>
                                    <option value="<%= dt.getURI() %>"><%= dt.getVersionValue() %></option>
                                    <%
                                }
                            }
                            %>
                        </select>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" id="savedtes"><span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("btnSave")%></button>
                <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></button>
            </div>
        </form>
    </div>
</div>
<script>
    (function() {
        var theForm = document.getElementById('formdte');
        if (!theForm) return;

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

        theForm['versiontemp'].addEventListener("change", function(evt) {
            if (isSelectValid(evt.target)) {
                $(evt.target).closest(".form-group").removeClass("has-error");
            } else {
                $(evt.target).closest(".form-group").addClass("has-error");
            }
        });

        theForm['titletcd'].addEventListener("keyup", function(evt) {
            if (isTitleValid(evt.target)) {
                $(evt.target).closest(".form-group").removeClass("has-error");
            } else {
                $(evt.target).closest(".form-group").addClass("has-error");
            }
        });

        theForm.addEventListener('submit', function(evt) {
            var valid = isTitleValid(theForm['titletcd']) && isSelectValid(theForm['versiontemp']);                      
            if (valid) {
                $.ajax({
                    url: $(theForm).attr('action'),
                    cache: false,
                    data: $(theForm).serialize(),
                    type: 'POST',
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success: function(data) {
                        if (data.status === "ok") {
                            var loc = '<%= paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setMode(SWBResourceURL.Mode_VIEW) %>';
                            window.location = loc;
                        }
                    }
                });
            }
            evt.preventDefault();
            return false;
        });
    })();
</script>