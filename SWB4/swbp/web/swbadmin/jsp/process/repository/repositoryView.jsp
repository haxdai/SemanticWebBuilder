<%-- 
    Document   : repositoryView
    Created on : 10/09/2013, 10:18:34 AM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>

<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequestImp"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
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
    List<GenericObject> files = (List<GenericObject>) request.getAttribute("files");
    String path = (String) request.getAttribute("path");
    int luser = (Integer) request.getAttribute("luser");
    WebSite site = paramRequest.getWebPage().getWebSite();
    User user = paramRequest.getUser();
    String lang = "es";

    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
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
        SWBResourceURL addUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ProcessFileRepository.MODE_ADDFILE);
        if (luser > 1) {
            %>
            <div class="row no-margin swbp-button-ribbon text-right">
                <a href="<%=addUrl%>" class="btn btn-swbp-action" data-toggle="modal" data-target="#modalDialog">Agregar archivo</a>
                <a href="<%=addUrl.setMode(ProcessFileRepository.MODE_ADDFOLDER) %>" class="btn btn-swbp-action" data-toggle="modal" data-target="#modalDialog">Agregar directorio</a>
            </div>
            <hr>
            <%
        } else {
            %><br/><%
        }
        if (path != null) {
            %>
            <ol class="breadcrumb swbp-breadcrumb">
                <li><span class="fa fa-archive"></span></li>
                <%
                if (path.indexOf("|") != -1) {
                    String[] pathelems = path.split("\\|");
                    for (int i = 0; i < pathelems.length; i++) {
                        WebPage wp = site.getWebPage(pathelems[i]);
                        boolean active = false;
                        if (wp.equals(paramRequest.getWebPage())) {
                            active = true;
                        }
                        %>
                        <li <%= active ? "class=\"active\"" : "" %>><a href="<%=wp.getUrl(lang)%>"><%=wp.getDisplayTitle(lang)%></a></li>
                        <%
                    }
                } else {
                    WebPage wp = site.getWebPage(path);
                    %>
                    <li><a href="<%=wp.getUrl(lang)%>"><%=wp.getDisplayTitle(lang)%></a></li>
                    <%
                }
                %>
            </ol>
            <%
        }
        
        if (null != files && !files.isEmpty()) {
            Iterator<GenericObject> it = files.iterator();
            while (it.hasNext()) {
                GenericObject go = it.next();
                
                SWBResourceURL actUrl = paramRequest.getRenderUrl().setCallMethod(SWBParamRequest.Call_DIRECT);
                String fileUrl = "";
                String title = ((Descriptiveable) go).getDisplayTitle(lang);
                String type = "directory";
                String lastUpdated = "--";
                VersionInfo vi = null;

                if (go instanceof RepositoryElement) {
                    type = go instanceof RepositoryURL ? "url" : "file";
                    
                    vi = ((RepositoryElement) go).getLastVersion();
                    if (vi != null && vi.getUpdated() != null) {
                        lastUpdated = format.format(vi.getUpdated());
                    }

                    actUrl.setParameter("verNum", "" + vi.getVersionNumber());
                    actUrl.setMode(ProcessFileRepository.MODE_GETFILE);
                }

                actUrl.setParameter("fid", go.getId());
                actUrl.setParameter("type", type);

                if (go instanceof RepositoryDirectory) {
                    Traceable tr = (Traceable) go;
                    if (tr.getUpdated() != null) {
                        lastUpdated = format.format(tr.getUpdated());
                    }
                }
                fileUrl = actUrl.toString();

                String itemClass = "fa fa-file-text";
                String colsActions = "";
                if (type.equals("directory")) {
                    itemClass = "fa fa-folder-open";
                    fileUrl = ((RepositoryDirectory) go).getUrl();
                    if (luser == 3) {//admin
                        colsActions = "col-xs-4";
                    }
                    if (luser == 2) {//edit
                        colsActions = "col-xs-6";
                    }
                    if (luser == 1) {//view
                        colsActions = "col-xs-12";
                    }
                } else {
                    if (luser == 3) {//admin
                        colsActions = "col-xs-3";
                    }
                    if (luser == 2) {//edit
                        colsActions = "col-xs-4";
                    }
                    if (luser == 1) {//view
                        colsActions = "col-xs-6";
                    }
                }
                if (type.equals("url")) {
                    itemClass = "fa fa-link";
                    fileUrl = null != vi ? vi.getVersionFile() : "";
                }

                %>
                <div class="swbp-list-element">
                    <%
                    actUrl.setMode(ProcessFileRepository.MODE_PROPS);
                    %>
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 swbp-list-title">
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 <%= itemClass %> swbp-list-icon"></div>
                        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 swbp-list-text"><a href="<%= fileUrl %>"><%= title %></a></div>
                        <div class="col-lg-3 col-md-3 col-sm-3 col-sm-offset-0 col-xs-10 col-xs-offset-2 swbp-list-date">
                            <%=lastUpdated%>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 swbp-list-action">
                        <a href="<%=actUrl%>" title="<%=paramRequest.getLocaleString("msgInfo")%>" class="btn btn-default <%= colsActions %> fa fa-info-circle" data-toggle="modal" data-target="#modalDialog"></a>
                        <%
                        if (null != vi) {
                            SWBResourceURL historyUrl = paramRequest.getRenderUrl().setMode(ProcessFileRepository.MODE_HISTORY);
                            historyUrl.setParameter("fid", go.getId());
                            historyUrl.setParameter("type", type);
                            %>
                            <a href="<%= null != vi.getPreviousVersion()? historyUrl : "#" %>" <%= null != vi.getPreviousVersion() ? "" : "disabled" %> title="<%=paramRequest.getLocaleString("msgViewVersionHistory")%>" class="btn btn-default <%= colsActions %> fa fa-sort-numeric-asc"></a>
                            <%
                            addUrl.setParameter("fid", go.getId());
                            addUrl.setParameter("type", type);
                            if (luser > 1) {
                                %>
                                <a href="<%= addUrl.setMode(ProcessFileRepository.MODE_ADDFILE) %>" title="<%=paramRequest.getLocaleString("msgAddVersion")%>" class="btn btn-default <%= colsActions %> fa fa-cloud-upload" data-toggle="modal" data-target="#modalDialog"></a>
                                <%
                            }
                        }
                        if (type.equals("directory")) {
                            if (luser > 1) {
                                %>
                                <a href="<%= actUrl.setMode(ProcessFileRepository.MODE_EDITFOLDER) %>" title="<%=paramRequest.getLocaleString("msgInfo")%>" class="btn btn-default <%= colsActions %> fa fa-pencil" data-toggle="modal" data-target="#modalDialog"></a>
                                <%
                            }
                        }
                        if (luser > 2) {
                            boolean canDelete = true;
                            if (go instanceof RepositoryDirectory) {
                                RepositoryDirectory rdir = (RepositoryDirectory) go;
                                if (rdir.listRepositoryElements().hasNext() || rdir.listChilds().hasNext()) {
                                    canDelete = false;
                                }
                            }

                            SWBResourceURL urlremove = paramRequest.getActionUrl();
                            urlremove.setAction("removefile");
                            urlremove.setParameter("act", "remove");
                            urlremove.setParameter("fid", go.getURI());
                            %>
                            <a href="<%= canDelete ? urlremove : "#" %>" <%= canDelete ? "" : "disabled" %> onclick="if (!confirm('<%=paramRequest.getLocaleString("msgAlertConfirmRemoveFile") + " " + title + "?"%>'))
                            return false;" title="<%=paramRequest.getLocaleString("msgAltDelete")%>" class="btn btn-default <%= colsActions %> fa fa-trash-o"></a>
                            <%
                        }
                        %>
                    </div>
                </div>
                <%
            }
            String sort = request.getParameter("sort");
            if (sort != null && sort.length() > 0) {
                sort = "sort|" + sort;
            } else {
                sort = "";
            }
            %>
            <jsp:include page="/swbadmin/jsp/process/commons/pagination.jsp" flush="true">
                <jsp:param name="navUrlParams" value="<%=sort%>"/>
                <jsp:param name="showPageOfPage" value="true"/>
            </jsp:include>
            <%
        } else {
            %>
            <div class="alert alert-block alert-warning">
                <p><%=paramRequest.getLocaleString("msgNoFiles")%></p>
            </div>
            <%
        }
    }
%>