<%-- 
    Document   : saveVersion
    Created on : 22/04/2014, 04:26:33 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.Documentation"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String uridi = request.getParameter("uridi") != null ? request.getParameter("uridi") : "";
    String idp = request.getParameter("idp") != null ? request.getParameter("idp") : "";
    SWBFormMgr forMgr = new SWBFormMgr(Documentation.sclass, paramRequest.getWebPage().getWebSite().getSemanticObject(), SWBFormMgr.MODE_CREATE);
    String title = forMgr.renderLabel(request, Documentation.swb_title, SWBFormMgr.MODE_CREATE);
    String description = forMgr.renderLabel(request, Documentation.swb_description, SWBFormMgr.MODE_CREATE);
    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_SAVE_VERSION).setParameter("uridi", uridi);
%>
<div class="modal-dialog">
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><i class="fa fa-check-square-o"></i> <%= paramRequest.getLocaleString("lblSaveVersion")%></h4>
        </div>
        <form id="saveVersion" class="form-horizontal" role="form" method="post" action="<%= urlAction%>">
            <input type="hidden" name="uridi" value="<%= uridi%>">
            <input type="hidden" name="idp" value="<%= idp%>">
            <div class="modal-body">
                <div class="form-group">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for="">Comentarios de la versión *</label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                        <input type="text" name="description" class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6"><span class="fa fa-save fa-fw"></span> <%=paramRequest.getLocaleString("btnSave")%></button>
                <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                    <span class="fa fa-arrow-left fa-fw"></span>
                    <%= paramRequest.getLocaleString("btnCancel")%>    
                </button>
            </div>
        </form>
    </div>
</div>
<script>
    ($(document).ready(function(){
        $("#saveVersion").on("submit", function(evt){
            var theForm = evt.target;
            $.ajax({
                url: $(theForm).attr('action'),
                cache: false,
                data: $(theForm).serialize(),
                type: 'POST',
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function(data) {
                    if (data && data.status === "ok") {
                        window.location.reload();
                    }
                }
            });
            evt.preventDefault();
        });
    })
    )();
</script>