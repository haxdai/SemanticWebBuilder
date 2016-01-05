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
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><i class="fa fa-check-square-o"></i> <%= paramRequest.getLocaleString("lblSaveVersion")%></h4>
        </div>
        <form id="saveVersion" class="form-horizontal" role="form" method="post" action="<%= urlAction%>">
            <div class="modal-body">
                <div class="form-group" id="divtitle">
                    <label class="col-sm-2 control-label"><%= title%></label>
                    <div class="col-sm-10">
                        <input name="title" id="title" class="form-control" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><%= description%></label>
                    <div class="col-sm-10">
                        <input type="text" name="description" class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer text-right">
                <input type="hidden" name="uridi" value="<%= uridi%>">
                <input type="hidden" name="idp" value="<%= idp%>">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    <span class="fa fa-mail-reply fa-fw"></span>
                    <%= paramRequest.getLocaleString("btnCancel")%>    
                </button>
                <button type="submit" onclick="saveSE('saveVersion', 'linotification','modalDialog');
                        return false;" class="btn btn-default"><span class="fa fa-save fa-fw"></span> <%=paramRequest.getLocaleString("btnSave")%></button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        setTimeout(function() {
            $('form').find('input,textarea,select').filter(':visible:first').focus();
        }, 500);
    });
</script>