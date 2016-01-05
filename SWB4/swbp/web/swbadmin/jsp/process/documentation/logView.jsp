<%-- 
    Document   : logView
    Created on : 13/12/2013, 04:24:31 PM
    Author     : carlos.alvarez
--%>

<%@page import="java.util.Locale"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.base.DescriptiveableBase"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    SemanticObject semObj = SemanticObject.createSemanticObject(uritc);
    String title = "";
    String lang = "es";
    User user = paramRequest.getUser();
    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
    Locale loc = new Locale(lang);

    DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy-hh:mm:ss", loc);

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
            created = sdf.format(tr.getCreated());
        }
        if (tr.getModifiedBy() != null) {
            modifiedby = tr.getModifiedBy().getFullName();
        }
        if (tr.getUpdated() != null) {
            modified = sdf.format(tr.getUpdated());
        }
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><i class="fa fa-check-square-o"></i> <%= title%></h4>
        </div>
        <div class="modal-body">
            <ul class="list-group">
                <li class="list-group-item"><span class="fa fa-user fa-fw"></span><strong><%=paramRequest.getLocaleString("lblCreator")%>:</strong> <%= creator%></li>
                <li class="list-group-item"><span class="fa fa-calendar fa-fw"></span><strong><%=paramRequest.getLocaleString("lblCreated")%>:</strong> <%= created%></li>
            </ul>

            <ul class="list-group">
                <li class="list-group-item"><span class="fa fa-user fa-fw"></span><strong><%=paramRequest.getLocaleString("lblModifier")%>:</strong> <%= modifiedby%></li>
                <li class="list-group-item"><span class="fa fa-calendar fa-fw"></span><strong><%=paramRequest.getLocaleString("lblModified")%>:</strong> <%= modified%></li>
            </ul>
        </div>
        <div class="modal-footer text-right">
            <button type="button" class="btn btn-default" data-dismiss="modal"><%=paramRequest.getLocaleString("btnClose")%></button>
        </div>
    </div>
</div>
<%
    }
%>