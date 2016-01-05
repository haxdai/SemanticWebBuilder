<%-- 
    Document   : showNewVersion
    Created on : 15/12/2014, 06:33:00 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPUserDocumentationResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = request.getAttribute(SWPDocumentationResource.PARAM_REQUEST) != null ? (SWBParamRequest) request.getAttribute(SWPDocumentationResource.PARAM_REQUEST) : null;
    String uridoc = request.getParameter("uridoc") != null ? request.getParameter("uridoc") : "";
    String uridi = request.getParameter("uridi") != null ? request.getParameter("uridi") : "";
    String idp = request.getParameter("idp") != null ? request.getParameter("idp") : "";

    SWBResourceURL urlDoc = paramRequest.getRenderUrl().setMode(SWPUserDocumentationResource.MODE_VIEW_DOCUMENTATION);
%>
<a href="<%= urlDoc.setParameter("idp", idp)%>" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblDocumentation")%>" title="<%=paramRequest.getLocaleString("lblDocumentation")%>" class="btn btn-default fa fa-eye"></a>