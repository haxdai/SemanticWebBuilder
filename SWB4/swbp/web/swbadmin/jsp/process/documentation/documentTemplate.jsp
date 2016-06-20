<%-- 
    Document   : documentTemplate
    Created on : 30/09/2014, 09:32:20 AM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.process.documentation.resources.SWPUserDocumentationResource"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    SWBResourceURL url = paramRequest.getRenderUrl();//.setCallMethod(SWBResourceURL.Call_DIRECT);
    WebSite model = paramRequest.getWebPage().getWebSite();
    User user = paramRequest.getUser();
    String lang = user != null && user.getLanguage() != null ? user.getLanguage() : "es";
    String idpg = request.getParameter(SWPUserDocumentationResource.PARAM_PROCESSGROUP);
    if (null == idpg) idpg = "";

    if (user != null && !user.isSigned() && paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT) {
        %>
        <div class="alert alert-block alert-danger fade in">
            <h4><span class="fa fa-ban"></span> <%=paramRequest.getLocaleString("msgNoAccessTitle")%></h4>
            <p><%=paramRequest.getLocaleString("msgNoAccess")%></p>
            <p><a class="btn btn-default" href="/login/<%=model.getId()%>/<%=paramRequest.getWebPage().getId()%>"><%=paramRequest.getLocaleString("btnLogin")%></a></p>
        </div>
        <%
    } else {
        List<TemplateContainer> templates = (List<TemplateContainer>) request.getAttribute(SWPDocumentTemplateResource.LIST_TEMPLATES_CONTAINER);
        if (null != templates) templates = SWBUtils.Collections.copyIterator(SWBComparator.sortByCreated(templates.iterator(), false));
        SWBResourceURL createURL = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
        createURL.setMode(SWPDocumentTemplateResource.MODE_ADD_TEMPLATE);
        %>
        <div class="row no-margin swbp-button-ribbon text-right">
            <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= idpg %>" class="btn btn-swbp-action" title="<%=paramRequest.getLocaleString("lblBack")%>">
                <%=paramRequest.getLocaleString("lblBack")%>
            </a>
            <a href="<%= createURL %>" class="btn btn-swbp-action" title="<%=paramRequest.getLocaleString("lblBack")%>" data-toggle="modal" data-target="#modalDialog">
                <%=paramRequest.getLocaleString("btnAddTemplate")%>
            </a>
        </div>
        <hr>
        <%            
        if (templates != null && !templates.isEmpty()) {
            %>
            <div class="panel panel-default swbp-panel-head">
                <div class="panel-heading text-center">Plantillas</div>
            </div>    
            <%
            for (TemplateContainer tc : templates) {
                DocumentTemplate actualTemplate = tc.getActualTemplate();
                
                if (null == tc.getLastTemplate().getVersionValue()) { //TODO: TO REMOVE METHOD CALL IN FUTURE VERSIONS
                    SWPUtils.setVersionNumbers(tc.getLastTemplate());
                }
                SWBResourceURL viewLog = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_VIEW_LOG).setParameter("uritc", tc.getURI());
                SWBResourceURL action = paramRequest.getActionUrl();
                SWBResourceURL urlDuplicate = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_DUPLICATE_TEMPLATE);
                String title = tc.getTitle();
                
                //check for current template version
                if (null != actualTemplate) { //Each template container must have at least one document template
                    %>
                    <div class="swbp-list-item">
                        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-list-title">
                            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 fa fa-list-alt swbp-list-icon"></div>
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-10 swbp-list-text"><%= title %></div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-list-action">
                            <a href="<%= url.setMode(SWBResourceURL.Mode_EDIT).setParameter("uridt", actualTemplate.getURI()) %>" class="btn btn-default col-xs-3 fa fa-pencil" role="button"></a>
                            <a href="<%= viewLog.setParameter("uritc", tc.getURI()) %>" class="btn btn-default col-xs-3 fa fa-info-circle" role="button" data-toggle="modal" data-target="#modalDialog"></a>
                            <a href="<%= urlDuplicate.setParameter("uritc", tc.getURI()) %>" class="btn btn-default col-xs-3 fa fa-copy" role="button" data-toggle="modal" data-target="#modalDialog"></a>
                            <a href="<%= action.setAction(SWBResourceURL.Action_REMOVE).setParameter("uritc", tc.getURI())%>" onclick="if (!confirm('<%=paramRequest.getLocaleString("msgDeletePrompt")%> <%= tc.getTitle()%>')) { return false; };" class="btn btn-default col-xs-3 fa fa-trash-o" role="button"></a>
                        </div>
                    </div>
                    <%
                }
            }
            %>
            <jsp:include page="/swbadmin/jsp/process/commons/pagination.jsp" flush="true" />
            <% 
        } else {
            %>
            <div class="alert alert-block alert-warning">
                <p>No hay plantillas disponibles</p>
            </div>
            <%
        }
    }
%>