<%-- 
    Document   : duplicateTemplate
    Created on : 9/12/2014, 05:26:29 PM
    Author     : carlos.alvarez
--%>

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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    TemplateContainer tc = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    SWBResourceURL urlSave = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_DUPLICATE_TEMPLATE).setParameter("uritc", uritc);
    String lang = "es";
    User user = paramRequest.getUser();
    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
    Locale loc = new Locale(lang);
    DateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss", loc);
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><li class="fa fa-copy"></li> Duplicar Template</h4>
        </div>
        <form action="<%= urlSave%>" method="post" id="formdte" class="form-horizontal" role="form">
            <div class="modal-body">
                <div class="form-group" id="divtitletcd">
                    <label class="col-lg-3 control-label"><%= paramRequest.getLocaleString("lblPropTitle")%>:</label>
                    <div class="col-lg-8">
                        <input name="titletcd" id="titletcd" required="true" value="<%= tc == null ? "" : tc.getTitle()%>" class="form-control"/>
                        <span class="help-block" id="sphtitletc"></span>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> </th>
                                <th>Título</th>
                                <th>Descripción</th>
                                <th>Creación</th>
                                <th>Creador</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <%
                                if (tc != null) {
                                    Iterator<DocumentTemplate> it = SWBComparator.sortByCreated(tc.listTemplates(), true);
                                    while (it.hasNext()) {
                                        DocumentTemplate dt = it.next();
                                        String title = dt.getTitle() != null ? dt.getTitle() : "";
                                        String desc = dt.getDescription() != null ? dt.getDescription() : "";
                                        String creator = dt.getCreator() != null ? dt.getCreator().getFullName() : "";
                                        String created = dt.getCreated() != null ? sdf.format(dt.getCreated()) : "";
                                        boolean actual = tc.getActualTemplate().getURI().equals(dt.getURI());
                            %>
                            <tr class="<% if (actual) {%>success<% }%>" id="trdvt<%= dt.getId()%>">
                                <td class="text-right">
                                    <input type="radio" value="<%= dt.getURI() %>" name="versiontemp" <%if (tc.getActualTemplate().equals(dt)) { %> checked="true" <%} %>>
                                </td>
                                <td><%= title%></td>
                                <td><%= desc%></td>
                                <td><%= created%></td>
                                <td><%= creator%></td>
                                
                            </tr>   
                            <% }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <a class="btn btn-default" data-dismiss="modal"><span class="fa fa-mail-reply fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></a>
                <button type="submit" onclick="submitForm('formdte', 'guardaCambios', 'modalDialog');
                        return false;" class="btn btn-success" id="savedtes"><span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("btnSave")%></button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        setTimeout(function() {
            //$('form').find('input,textarea,select').filter(':visible:first').focus();
            $('#titletcd').focus();
        }, 500);
        /*
        $('#modalDialog').on('shown.bs.modal', function() {
            $('#titletcd').focus();
        });*/
    });
</script>