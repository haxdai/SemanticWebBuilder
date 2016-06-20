<%-- 
    Document   : logView
    Created on : 13/12/2013, 04:24:31 PM
    Author     : carlos.alvarez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
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
        String path = "";
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
        
        if (tr instanceof Referable) {
            RepositoryElement re = ((Referable)tr).getRefRepository();
            if (null != re) {
                ArrayList<String> elePAth = re.getElementRepositoryPath(true, null);
                Collections.reverse(elePAth);

                Iterator<String> its = elePAth.iterator();
                while (its.hasNext()) {
                    String v = its.next();
                    path += v;
                    if (its.hasNext()) path+= " > ";
                }
            }
        }
        %>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h5 class="modal-title"><%= title %></h5>
                </div>
                <form class="form-horizontal swbp-form">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><%=paramRequest.getLocaleString("lblCreator")%></label>
                            <div class="col-sm-8"><p class="form-control-static"><%= creator %></p></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><%=paramRequest.getLocaleString("lblCreated")%></label>
                            <div class="col-sm-8"><p class="form-control-static"><%= created %></p></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><%=paramRequest.getLocaleString("lblModifier")%></label>
                            <div class="col-sm-8"><p class="form-control-static"><%= modifiedby %></p></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><%=paramRequest.getLocaleString("lblModified")%></label>
                            <div class="col-sm-8"><p class="form-control-static"><%= modified %></p></div>
                        </div>
                        <%
                        if (!path.isEmpty()) {
                            %>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><%=paramRequest.getLocaleString("lblRepoPath")%></label>
                                <div class="col-sm-8"><p class="form-control-static"><%= path %></p></div>
                            </div>
                            <%
                        }
                        %>
                    </div>
                </form>
            </div>
        </div>
        <%
    }
%>