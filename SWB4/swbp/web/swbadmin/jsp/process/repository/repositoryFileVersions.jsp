<%-- 
    Document   : repositoryFileVersions
    Created on : 12/09/2013, 08:54:35 PM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.process.model.RepositoryFile"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
List<VersionInfo> files = (List<VersionInfo>) request.getAttribute("versionList");
RepositoryElement rf = (RepositoryElement) request.getAttribute("element");
int luser = (Integer) request.getAttribute("luser");
WebSite site = paramRequest.getWebPage().getWebSite();
User user = paramRequest.getUser();
SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy - hh:mm");

if (!user.isSigned()) {
    if (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT) {
        %>
        <div class="alert alert-block alert-danger fade in">
            <h4><span class="fa fa-ban"></span> <%=paramRequest.getLocaleString("msgNoAccessTitle")%></h4>
            <p><%=paramRequest.getLocaleString("msgNoAccess")%></p>
            <p>
                <a class="btn btn-default" href="/login/<%=site.getId()%>/<%=paramRequest.getWebPage().getId()%>"><%=paramRequest.getLocaleString("btnLogin")%></a>
            </p>
        </div>
        <%
    }
} else {
    %>
    <div class="row no-margin swbp-button-ribbon text-right">
        <a href="<%=paramRequest.getRenderUrl().setMode(SWBParamRequest.Mode_VIEW)%>" class="btn btn-swbp-action"><%=paramRequest.getLocaleString("btnBack")%></a>
    </div>
    <hr/>
    <div class="panel panel-default swbp-panel-head">
        <div class="panel-heading text-center"><%=paramRequest.getLocaleString("msgVerHistoryTitle")%> - <%= rf.getTitle() %></div>
    </div>
    <%
    if (!files.isEmpty()) {
        Iterator<VersionInfo> it = files.iterator();
        if (it.hasNext()) {
            %>
            <div class="table-responsive">
                    
                    <%
                    while (it.hasNext()) {
                        VersionInfo vi = it.next();
                        //String modifier = "--";
                        //if (vi.getCreator() != null && vi.getCreator().getFullName().length() > 0) modifier = vi.getCreator().getFullName();

                        SWBResourceURL propsUrl = paramRequest.getRenderUrl().setCallMethod(SWBParamRequest.Call_DIRECT);
                        propsUrl.setMode(ProcessFileRepository.MODE_PROPS);
                        propsUrl.setParameter("fid", rf.getId());
                        propsUrl.setParameter("type", (rf instanceof RepositoryURL)?"url":"file");
                        propsUrl.setParameter("verNum", String.valueOf(vi.getVersionNumber()));
                        %>
                        <div class="swbp-list-element">
                            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-12 swbp-list-title">
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 swbp-list-number">
                                   <%=vi.getVersionValue()%> 
                                </div>
                                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 swbp-list-text">
                                   
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-3 col-sm-offset-0 col-xs-10 col-xs-offset-2 swbp-list-date">
                                    <%=format.format(vi.getCreated())%>
                                </div>
                            </div> 
                            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 swbp-list-action">    
             
                                <a href="<%=propsUrl%>" title="<%=paramRequest.getLocaleString("msgInfo")%>" class="btn btn-default col-xs-6 fa fa-info-circle" data-toggle="modal" data-target="#modalDialog"></a>
                                <%
                                if (luser > 0) {
                                    SWBResourceURL urlDownload = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
                                    urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                                    urlDownload.setParameter("fid", rf.getId());
                                    urlDownload.setParameter("verNum", "" + vi.getVersionNumber());
                                    %>
                                    <a href="<%=rf instanceof RepositoryFile?urlDownload:vi.getVersionFile()%>" title="<%=rf instanceof RepositoryFile?paramRequest.getLocaleString("msgDownload"):paramRequest.getLocaleString("msgGoLink")%>" class="btn btn-default col-xs-6 fa <%=rf instanceof RepositoryFile?"fa-download":"fa-external-link"%>"></a>
                                <%}
                                %>
                      
                        </div>
                        <%
                    }
                    %>
            </div>
            <%
        }
    }
}
%>