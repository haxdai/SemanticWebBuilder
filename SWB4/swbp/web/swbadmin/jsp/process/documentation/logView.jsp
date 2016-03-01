<%-- 
    Document   : logView
    Created on : 13/12/2013, 04:24:31 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    SemanticObject semObj = SemanticObject.createSemanticObject(uritc);
    String title = "";

    if (semObj != null) {
        Traceable tr = null;
        Descriptiveable des = (Descriptiveable) semObj.createGenericInstance();
        title = des.getTitle() != null ? des.getTitle() : "--";
        if (semObj.instanceOf(Traceable.swb_Traceable)) {
            tr = (Traceable) semObj.createGenericInstance();
        }
        String creator = "--";
        String created = "--";
        String modified = "--";
        String modifiedby = "--";
        if (tr.getCreator() != null) {
            creator = tr.getCreator().getFullName();
        }
        if (tr.getCreated() != null) {
            created = SWPUtils.DateFormatter.format(tr.getCreated());
        }
        if (tr.getModifiedBy() != null) {
            modifiedby = tr.getModifiedBy().getFullName();
        }
        if (tr.getUpdated() != null) {
            modified = SWPUtils.DateFormatter.format(tr.getUpdated());
        }
%>
<div class="modal-dialog">
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><%= title %></h4>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" role="form">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                        <%=paramRequest.getLocaleString("lblCreator")%>   
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                        <%= creator %>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                        <%=paramRequest.getLocaleString("lblCreated")%>   
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                        <%= created %>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                        <%=paramRequest.getLocaleString("lblModifier")%>   
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                        <%= modifiedby %>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                        <%=paramRequest.getLocaleString("lblModified")%>   
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                        <%= modified %>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%
    }
%>