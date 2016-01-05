<%-- 
    Document   : documentTemplate
    Created on : 30/09/2014, 09:32:20 AM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPUserDocumentationResource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
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
        %>
        <div class="row text-right">
            <ul class="list-unstyled list-inline ">
                <li>
                    <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= idpg %>" class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblBack")%>" title="<%=paramRequest.getLocaleString("lblBack")%>">
                        <span class="fa fa-reply fa-fw"></span><%=paramRequest.getLocaleString("lblBack")%>
                    </a>
                </li>
            </ul>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                <div class="panel panel-default swbp-panel">
                    <div class="panel-heading">
                        <div class="panel-title swbp-panel-title">
                            <h1 class="panel-title">
                                <span class="fa fa-list-alt fa-fw"></span><strong><%=paramRequest.getLocaleString("lblResourceTitle")%></strong>
                                <a href="#" onclick="postHtmlDoc('<%=url.setMode(SWBResourceURL.Mode_EDIT)%>', 'container');
                                    return false;" data-toggle="tooltip" data-placement="bottom" title="<%=paramRequest.getLocaleString("btnAddTemplate")%>" data-original-title="<%=paramRequest.getLocaleString("btnAddTemplate")%>"><span class="btn btn-sm btn-success pull-right fa fa-plus"></span></a>
                            </h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <%
                        if (templates != null && !templates.isEmpty()) { 
                            %>
                            <ul class="list-unstyled">
                            <%
                            for (TemplateContainer tc : templates) {
                                String title = tc.getTitle();
                                String idtc = tc.getId();
                                %>
                                <li><a id="litc<%= idtc%>" href="#<%= idtc%>" class="template-anchor" onclick="postHtmlDoc('<%=url.setMode(SWBResourceURL.Mode_EDIT).setParameter("uritc", tc.getURI())%>', 'container');return false;"><i class="fa fa-file fa-fw"></i> <%= title%></a></li>
                                <%
                            }
                            %>
                            </ul>
                            <jsp:include page="/swbadmin/jsp/process/commons/pagination.jsp" flush="true" />
                            <% 
                        } 
                        %>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12" id="container"></div>
        </div>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.template-anchor').on('click', function(){
                    $('.template-anchor').removeClass('active');
                    $(this).addClass('active');
                });
            });
        </script>
        <script src="<%=SWBPortal.getWebWorkPath()%>/models/<%=model.getId()%>/js/documenter.js"></script>
        <%  
    }
%>