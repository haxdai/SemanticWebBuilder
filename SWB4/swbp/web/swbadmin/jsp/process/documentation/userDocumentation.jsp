<%-- 
    Document   : userDocumentation
    Created on : 9/12/2013, 10:30:59 AM
    Author     : carlos.alvarez
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPUserDocumentationResource"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.process.model.ProcessGroup"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! 
    ArrayList<ProcessGroup> getNavPath (WebSite site, ProcessGroup current) {
        ArrayList<ProcessGroup> ret = new ArrayList<>();
        if (current != null) {
            ProcessGroup pivot = current;
            while (pivot != null) {
                ret.add(pivot);
                pivot = pivot.getParentGroup();
            }
        }
        return ret;
    }
%>
<%
    SWBParamRequest paramRequest = request.getAttribute(SWPUserDocumentationResource.PARAM_REQUEST) != null ? (SWBParamRequest) request.getAttribute(SWPUserDocumentationResource.PARAM_REQUEST) : null;
    WebSite model = paramRequest.getWebPage().getWebSite();
    User user = paramRequest.getUser();
    String lang = user.getLanguage();
    WebPage webpage = paramRequest.getWebPage();
    Role docRole = webpage.getWebSite().getUserRepository().getRole(paramRequest.getResourceBase().getAttribute("docRole"));//TODO: Hacer cnfigurable el rol
    Role adminRole = webpage.getWebSite().getUserRepository().getRole("admin");//TODO: Hacer cnfigurable el rol
    Resource base = paramRequest.getResourceBase();
    List<Descriptiveable> list = request.getAttribute(SWPUserDocumentationResource.LIST_PROCESSES) != null ? (List<Descriptiveable>) request.getAttribute(SWPUserDocumentationResource.LIST_PROCESSES) : null;
    
    String idpg = request.getParameter(SWPUserDocumentationResource.PARAM_PROCESSGROUP) != null ? request.getParameter(SWPUserDocumentationResource.PARAM_PROCESSGROUP) : null;
    ProcessGroup group1 = (ProcessGroup) ProcessGroup.ClassMgr.getProcessGroup(idpg, model);
    
    SWBResourceURL urlDoc = paramRequest.getRenderUrl().setMode(SWPUserDocumentationResource.MODE_VIEW_DOCUMENTATION);
    String pag = request.getParameter("p") != null ? request.getParameter("p") : "";
    WebPage templatesPage = webpage.getWebSite().getWebPage(base.getAttribute("templatePage"));
    WebPage contentsPage = webpage.getWebSite().getWebPage(base.getAttribute("contentPage"));
    if (null == templatesPage) templatesPage = webpage;
    if (null == contentsPage) contentsPage = webpage;
        
    boolean isDocumenter = user.hasRole(docRole) || user.hasRole(adminRole);
%>
<div class="row swbp-pad">
    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12 swbp-breadcrumbs">
        <div class="breadCrumbHolder module">
            <div id="breadCrumb2" class="breadCrumb module">
                <ol id="breadcrumbs-1a">
                    <li><a class="fa fa-file-text first" href="?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>="> </a></li>
                    <%
                    ArrayList<ProcessGroup> nPath = getNavPath(model, group1);
                    Collections.reverse(nPath);
                    for (ProcessGroup _pg : nPath) {
                        String cssClass = "";
                        if (_pg.getURI().equals(idpg) || nPath.size() == 1) {
                            cssClass = "active";
                        }
                        %>
                        <li class="<%= cssClass %>"><a href="?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= _pg.getId() %>"><%= _pg.getTitle() %></a></li>
                        <%
                    }
                    %>
                </ol>
            </div>
        </div>
    </div>
    <%
    if (isDocumenter) {
        %>
        <div class="col-lg-3 col-lg-offset-0 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
            <a href="<%= templatesPage.getUrl() %>?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= idpg %>" class="btn btn-block swbp-btn-block" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblAdminTemplates")%>" title="<%=paramRequest.getLocaleString("lblAdminTemplates")%>">
                <%=paramRequest.getLocaleString("lblAdminTemplates")%>
            </a>
        </div>
        <%
    }%>
</div>
<hr>
<%
if (!list.isEmpty()) {
    //Sort by language, then by type
    Collections.sort(list, new SWBComparator(lang));
    Collections.sort(list, new Comparator<Descriptiveable>() {
        @Override
        public int compare(Descriptiveable o1, Descriptiveable o2) {
            return o2.getSemanticObject().getSemanticClass().getClassCodeName().compareTo(o1.getSemanticObject().getSemanticClass().getClassCodeName());
        }
    });
    for (Descriptiveable desc : list) {
        String title = desc.getTitle();
        String idp = desc.getId();
        String clas = desc instanceof Process ? "Proceso" : "Grupo de procesos";
        %>
        <div class="swbp-list-element">
            <%
            if (clas.equals("Proceso")) {
                %>
                <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12 swbp-list-title">
                    <div class="col-lg-2 col-md-2 col-sm-1 col-xs-2 fa fa-cog swbp-list-icon swbp-align-icon"></div>
                    <div class="col-lg-10  col-md-10 col-sm-11 col-xs-10 swbp-list-text swbp-align-text"><%= title %></div>
                </div>
                <div class="col-lg-5 col-md-5 col-sm-3 col-xs-12 swbp-list-action">
                    <a class="btn btn-default col-lg-4 col-md-4 col-sm-4 col-xs-4" href="<%= urlDoc.setParameter("idp", idp).setParameter(SWPUserDocumentationResource.PARAM_PROCESSGROUP, idpg)%>"  role="button">
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-eye"></div>
                        <div class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-list-action-text">Ver</div>
                    </a>
                    <%
                    if (isDocumenter) { 
                        Process p = (Process)desc;
                        %> 
                        <a class="btn btn-default col-lg-4 col-md-4 col-sm-4 col-xs-4" role="button" href="<%= contentsPage.getUrl() %>?idp=<%= p.getId() %>&_rid=<%=paramRequest.getResourceBase().getId()%>&wp=<%=paramRequest.getWebPage().getId()%>&<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%=idpg%>&p=<%= pag %>">
                        <%
                    } else{
                        %>
                        <a class="btn btn-default col-lg-4 col-md-4 col-sm-4 col-xs-4" role="button" href="#" disabled="disabled">
                        <%
                    }
                    %>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-pencil"></div>
                        <div class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-list-action-text">Editar</div>
                    </a>
                    <a class="btn btn-default col-lg-4 col-md-4 col-sm-4 col-xs-4" href="#" role="button">
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-trash-o"></div>
                        <div class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-list-action-text">Eliminar</div>
                    </a>
                </div>
                <%
            } else {
                %>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 swbp-list-title swbp-title-xs">
                    <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 fa fa-folder-open swbp-list-icon"></div>
                    <div class="col-lg-11  col-md-11 col-sm-11 col-xs-10 swbp-list-text">
                        <a href="?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= desc.getSemanticObject().getId()%> "><%= title %></a>
                    </div>
                </div>
                <%
            }
            %>
        </div>
        <%
    }
}
%>