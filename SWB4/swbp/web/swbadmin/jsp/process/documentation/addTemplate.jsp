<%-- 
    Document   : addTemplate
    Created on : 20-ene-2016, 15:35:21
    Author     : hasdai
--%>

<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    SWBResourceURL act = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD);
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title">Agregar plantilla</h5>
        </div>
        <form class="form-horizontal swbp-form" action="<%= act %>" id="formNTP">
            <div class="modal-body">
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="">T�tulo: *</label>
                    <div class="col-sm-8">
                        <input name="titletc" id="title" type="text" required class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button id="saveFormVersion" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" type="submit">
                    <span class="fa fa-save fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnSave")%></span>
                </button>
                <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                    <span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs">Cancelar</span>
                </button>
            </div>
        </form>
    </div>
</div>
<script>
    (function() {
        var theForm = document.getElementById('formNTP');
        if (!theForm) return;

        var isTitleValid = function(element) {
            if (element.required) {
                return !element.validity.valueMissing;
            } else {
                return element.value && element.value !== "";
            }
        };

        theForm['titletc'].addEventListener("change", function(evt) {
            if (isTitleValid(evt.target)) {
                $(evt.target).closest(".form-group").removeClass("has-error");
            } else {
                $(evt.target).closest(".form-group").addClass("has-error");
            }
        });

        theForm.addEventListener('submit', function(evt) {
            var valid = isTitleValid(theForm['titletc']);                           
            if (valid) {
                $.ajax({
                    url: $(theForm).attr('action'),
                    cache: false,
                    data: $(theForm).serialize(),
                    type: 'POST',
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success: function(data) {
                        if (data.status === "ok") {
                            var loc = '<%= paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setMode(SWBResourceURL.Mode_EDIT) %>?uritc='+encodeURIComponent(data.uritc);
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