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
    String templatesUrl = webpage.getUrl(lang);
    String captureUrl = webpage.getUrl(lang);
    
    if (paramRequest == null) {
        %>
        <div class="alert alert-block alert-danger fade in">
            <h4><span class="fa fa-ban"></span> Ha ocurrido un error</h4>
        </div>
        <%
        return;
    }

    if (base.getAttribute("templatePage") != null) {
        WebPage twp = webpage.getWebSite().getWebPage(base.getAttribute("templatePage"));
        if (twp != null) {
            templatesUrl = twp.getUrl(lang);
        }
    }
    if (base.getAttribute("contentPage") != null) {
        WebPage twp = webpage.getWebSite().getWebPage(base.getAttribute("contentPage"));
        if (twp != null) {
            captureUrl = twp.getUrl(lang);
        }
    }
        
    boolean isDocumenter = user.hasRole(docRole) || user.hasRole(adminRole);
    if (isDocumenter) {
        %>
        <div class="row text-right">
            <ul class="list-unstyled list-inline ">
                <li>
                    <a href="<%= templatesUrl%>?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= idpg %>" class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblAdminTemplates")%>" title="<%=paramRequest.getLocaleString("lblAdminTemplates")%>">
                        <span class="fa fa-list-alt fa-fw"></span>
                    </a>
                </li>
            </ul>
        </div>
        <%
    }
    %>
    <ol class="breadcrumb swbp-breadcrumb">
        <li>
            <span class="swbp-breadcrumb-title"><a href="?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>="><span class="fa fa-home fa-lg"></span></a></span>
        </li>
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
        %>
        <div class="table-responsive">
            <table class="table table-hover swbp-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th style="width: 200px;"><%=paramRequest.getLocaleString("lblActions")%></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    for (Descriptiveable desc : list) {
                        String title = desc.getTitle();
                        String idp = desc.getId();
                        String clas = desc instanceof Process ? "Proceso" : "Grupo de procesos";
                        %>
                        <tr>
                            <td>
                                <%
                                if (clas.equals("Proceso")) {
                                    %>
                                    <a href="<%= urlDoc.setParameter("idp", idp).setParameter(SWPUserDocumentationResource.PARAM_PROCESSGROUP, idpg)%>" ><span class="fa fa-cogs fa-2x fa-fw"></span><%= title %></a>
                                    <%
                                } else {
                                    %>
                                    <a href="?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= desc.getSemanticObject().getId()%> "><span class="fa fa-folder-open fa-2x fa-fw"></span><%= title %></a>
                                    <%
                                }
                                %>
                            </td>
                            <td>
                                <%
                                if (isDocumenter && clas.equals("Proceso")) {
                                    Process p = (Process)desc;
                                    %>
                                    <a href="<%= captureUrl %>?idp=<%= p.getId() %>&_rid=<%=paramRequest.getResourceBase().getId()%>&wp=<%=paramRequest.getWebPage().getId()%>&<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%=idpg%>&p=<%= pag %>" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblDocument")%>" title="<%=paramRequest.getLocaleString("lblDocument")%>" class="btn btn-default fa fa-pencil"></a>
                                    <%
                                }
                                %>
                            </td>
                        </tr>
                        <%
                    }
                    %>
                </tbody>
            </table>
        </div>
        <%
    } else {
        %>
        <div class="alert alert-block alert-warning fade in">
            <%=(group1 != null && group1.getTitle() != null ? (group1.getTitle() + ", " ) : "") + paramRequest.getLocaleString("lblNoResult")%>
        </div>
        <%
    }
%>