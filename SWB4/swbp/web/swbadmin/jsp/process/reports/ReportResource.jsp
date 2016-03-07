<%-- 
    Document   : ReportResource
    Created on : 11/03/2013, 05:23:28 PM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.SWBServiceMgr"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.resources.reports.FileReport"%>
<%@page import="org.semanticwb.process.resources.reports.Report"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
    //SWBResourceURL urlViewReport = paramRequest.getRenderUrl();
    //boolean isSaveOnSystem = Boolean.parseBoolean(request.getAttribute("isSaveOnSystem").toString());
    SWBResourceURL urlAction = paramRequest.getActionUrl();
    //Integer pageElements = Integer.parseInt(request.getAttribute("pageElements").toString());
    //Integer modeExport = Integer.parseInt(request.getAttribute("modeExport").toString());
    Iterator<Report> report = Report.ClassMgr.listReports(paramRequest.getWebPage().getWebSite());
    SWBResourceURL urlDialog = paramRequest.getRenderUrl().setMode("dialog").setCallMethod(SWBResourceURL.Call_DIRECT);
    //WebPage wpage = paramRequest.getWebPage();
    //SWBResourceURL URSUrl = paramRequest.getRenderUrl().setMode("URSReport").setCallMethod(SWBResourceURL.Call_DIRECT);
    //SWBResourceURL TRSUrl = paramRequest.getRenderUrl().setMode("TRSReport").setCallMethod(SWBResourceURL.Call_DIRECT);
    %>
    <div class="row swb-pad">
        <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
            <a class="btn btn-block swbp-btn-block" href="<%=url.setMode("add")%>" data-toggle="modal" data-target="#modalDialog"><%=paramRequest.getLocaleString("add")%></a>
        </div>
    </div>
    <hr/>
    <%
    url.setCallMethod(SWBResourceURL.Call_CONTENT);
    if (report.hasNext()) {
        while (report.hasNext()) {
            Report rp = (Report) report.next();
            if (rp.isValid()) {
                urlDialog = paramRequest.getRenderUrl().setMode("dialog").setCallMethod(SWBResourceURL.Call_DIRECT);
                urlDialog.setParameter("idReport", rp.getId());
                urlDialog.setParameter("action", "export");
                %>
                <div class="swbp-list-element">
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 swbp-list-title">
                        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 swbp-list-text"><%= rp.getTitle() %></div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 swbp-list-action">
                        <a href="<%=urlDialog%>" class="btn btn-default col-xs-4 fa fa-download" data-toggle="modal" data-target="#modalDialog"></a>
                        <a href="<%=url.setMode(SWBResourceURL.Mode_EDIT).setParameter("idReport", rp.getId())%>" class="btn btn-default col-xs-4 fa fa-wrench"></a>
                        <a href="<%=urlAction.setAction(SWBResourceURL.Action_REMOVE).setParameter("idReport", rp.getURI())%>" class="btn btn-default col-xs-4 fa fa-trash-o" onclick="if (!confirm('<%=paramRequest.getLocaleString("remove") + " " + paramRequest.getLocaleString("report")%>?'))return false;"></a>
                    </div>
                </div>
                <%
            }
        }
    } else {
        %>
        <div class="alert alert-block alert-warning fade in">
            <p><%=paramRequest.getLocaleString("msgNoReports")%></p>
        </div>
        <%
    }
%>