<%-- 
    Document   : versions
    Created on : 24/04/2014, 09:00:53 AM
    Author     : carlos.alvarez
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPUserDocumentationResource"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.Documentation"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.model.WebSite"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String idp = request.getParameter("idp") != null ? request.getParameter("idp") : "";
    WebSite site = paramRequest.getWebPage().getWebSite();
    Process process = Process.ClassMgr.getProcess(idp, site);
    SWBResourceURL urlRemove = paramRequest.getActionUrl().setAction(SWPDocumentationResource.ACTION_REMOVE_VERSION).setParameter("idp", idp);
    SWBResourceURL urlActive = paramRequest.getActionUrl().setAction(SWPDocumentationResource.ACTION_ACTIVE_VERSION).setParameter("idp", idp);
    
    if (null != process) {
        %>
        <div class="row no-margin swbp-button-ribbon text-right">
            <a href="<%=paramRequest.getWebPage().getUrl()%>?idp=<%= idp%>&wp=<%= request.getParameter("wp")%>&pg=<%= request.getParameter("pg")%>&_rid=<%= request.getParameter("_rid")%>" class="btn btn-swbp-action" title="<%=paramRequest.getLocaleString("lblBack")%>">Regresar</a>
        </div>
        <hr>
        <div class="panel panel-default swbp-panel-head">
            <div class="panel-heading text-center"><%= process.getTitle() != null ? process.getTitle() : ""%></div>
        </div>
        <%
        List<Documentation> versions = SWBUtils.Collections.copyIterator(SWBComparator.sortByCreated(Documentation.ClassMgr.listDocumentationByProcess(process), true));
        //TO REMOVE IN FUTURE VERSIONS---
        Iterator<Documentation> it = versions.iterator();
        boolean hasVersionNumbers = false;
        while (it.hasNext()) {
            Documentation documentation = it.next();
            if (documentation.isActualVersion() && null != documentation.getVersionValue()) {
                hasVersionNumbers = true;
                break;
            }
        }
        
        if (!hasVersionNumbers) {
            String vvalue = "";
            for (Documentation doc : versions) {
                doc.setVersionValue(Documentation.getNextVersionValue(vvalue));
                vvalue = doc.getVersionValue();
            }
        }
        //TO REMOVE IN FUTURE VERSIONS---
        it = versions.iterator();
        if (it.hasNext()) {
            SWBResourceURL urlTrace = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_TRACEABLE);
            while (it.hasNext()) {
                Documentation documentation = it.next();
                String desc = documentation.getVersionComment() == null? "" : documentation.getVersionComment();
                String created = documentation.getCreated() != null ? SWBUtils.TEXT.iso8601DateFormat(documentation.getCreated()) : "";
                boolean actual = documentation.isActualVersion();
                %>
                <div class="swbp-list-element">
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-list-title">
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 swbp-list-number"><%= documentation.getVersionValue()%></div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-10 swbp-list-text"><%= desc %></div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-sm-offset-0 col-xs-10 col-xs-offset-2 swbp-list-date"><%= created %></div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-list-action">
                        <%
                        if (!actual) {
                            %><a href="<%= urlActive.setParameter("uridoc", documentation.getURI()).setParameter("wp", request.getParameter("wp")).setParameter("_rid", request.getParameter("_rid")) %>" class="btn btn-default col-xs-4 fa fa-retweet" onclick="if (!confirm('¿Desea hacer versión <%= documentation.getVersionValue() %> la versión actual?')) return false;"></a><%
                        } else {
                            %><a href="#" class="btn btn-default col-xs-4 fa fa-check-square-o active"></a><%
                        }
                        %>
                        <a href="<%= urlTrace.setParameter("uritc", documentation.getURI())%>" class="col-xs-4 btn btn-default fa fa-info-circle" role="button" data-toggle="modal" data-target="#modalDialog"></a>
                        <a href="<%= !actual ? urlRemove.setParameter("uridoc", documentation.getURI()).setParameter("wp", request.getParameter("wp")).setParameter("_rid", request.getParameter("_rid")) : "#" %>" <%if (!actual) {%> onclick="if (!confirm('Eliminar versión?')) return false;" <%}%>
                            class="col-xs-4 btn btn-default fa fa-trash-o <%= actual ? "disabled" : "" %>">
                        </a>
                    </div>
                </div>
                <%
            }
        } else {
            %>
            <div class="alert alert-block alert-warning">
                No se han publicado versiones.
            </div>
            <%
        }
    }
%>