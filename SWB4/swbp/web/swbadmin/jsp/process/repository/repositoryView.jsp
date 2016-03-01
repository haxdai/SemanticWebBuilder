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
    SWBResourceURL addFolderUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ProcessFileRepository.MODE_ADDFOLDER);
%>
<div class="row swbp-pad">
  
    <%
    if (path != null) {%>
    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 swbp-breadcrumbs">
        <div class="breadCrumbHolder module">
            <div id="breadCrumb2" class="breadCrumb module">
<ol id="breadcrumbs-1a">
    <li class="fa fa-archive first"></li>
    <%
        if (path.indexOf("|") != -1) {
            String[] pathelems = path.split("\\|");
            for (int i = 0; i < pathelems.length; i++) {
                WebPage wp = site.getWebPage(pathelems[i]);

                if (wp.equals(paramRequest.getWebPage())) {
    %>
    <li class="active"><%=wp.getDisplayTitle(lang)%></li>
        <%
        } else {
        %>
    <li><a href="<%=wp.getUrl(lang)%>"><%=wp.getDisplayTitle(lang)%></a></li>
        <%
                }
            }
        } else {
            WebPage wp = site.getWebPage(path);
        %>
    <li><a href="<%=wp.getUrl(lang)%>"><%=wp.getDisplayTitle(lang)%></a></li>
        <%
            }
        %>
</ol>
        </div>
        </div>
<%
    }%>
    </div>
    
<div class="col-lg-3 col-lg-offset-0 col-md-3 col-md-offset-0 col-sm-4 col-sm-offset-4 col-xs-12 swbp-raised-button">
                    <a href="<%=addUrl%>" class="btn btn-block swbp-btn-block" data-toggle="modal" data-target="#modalDialog">
                        agregar archivo
                    </a>   
                </div>
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 swbp-raised-button">
                    <a href="<%=addFolderUrl%>" class="btn btn-block swbp-btn-block" data-toggle="modal" data-target="#modalDialog">
                        agregar directorio
                    </a>   
                </div>
</div>
                        
<hr>


    <%

    if (!files.isEmpty()) {
        SWBResourceURL urlOrder = paramRequest.getRenderUrl();

        Iterator<GenericObject> it = files.iterator();
        if (it.hasNext()) {
%>


            <%
                while (it.hasNext()) {
                    GenericObject go = it.next();

                    String urlIcon = SWBPlatform.getContextPath() + "/swbadmin/jsp/process/repository/css/images/url.png";
                    String title = ((Descriptiveable) go).getDisplayTitle(lang);
                    String type = paramRequest.getLocaleString("lblFileTypeFolder");
                    String _type = "directory";
                    String modifier = "--";
                    String version = "--";
                    String lastUpdated = "--";
                    String status = "--";
                    String ownerGroup = "--";

                    if (go instanceof RepositoryElement) {
                        RepositoryElement re = (RepositoryElement) go;

                        VersionInfo vi = re.getLastVersion();
                        if (vi != null) {
                            type = ProcessFileRepository.getFileType(vi.getVersionFile(), lang);
                            
                        }
                        _type = (go instanceof RepositoryURL) ? "url" : "file";
                        if (vi != null && vi.getModifiedBy() != null && vi.getModifiedBy().getFullName().length() > 0) {
                            modifier = vi.getModifiedBy().getFullName();
                        }
                        if (vi != null && !(re instanceof RepositoryURL)) {
                            urlIcon = ProcessFileRepository.getFileIcon(vi.getVersionFile());
                        }

                        version = (vi != null) ? vi.getVersionValue() : "--";
                        if (vi != null && vi.getUpdated() != null) {
                            lastUpdated = format.format(vi.getUpdated());
                        }

                        if (re.getStatus() != null) {
                            status = re.getStatus().getDisplayTitle(lang);
                        }

                        if (re.getOwnerUserGroup() != null) {
                            ownerGroup = re.getOwnerUserGroup().getDisplayTitle(lang);
                        }
                    } else if (go instanceof RepositoryDirectory) {
                        Traceable tr = (Traceable) go;
                        if (tr.getModifiedBy() != null) {
                            modifier = tr.getModifiedBy().getFullName();
                        }
                        urlIcon = SWBPlatform.getContextPath() + "/swbadmin/jsp/process/repository/css/images/folder.png";
                        if (tr.getUpdated() != null) {
                            lastUpdated = format.format(tr.getUpdated());
                        }
                    }

                    SWBResourceURL propsUrl = paramRequest.getRenderUrl().setCallMethod(SWBParamRequest.Call_DIRECT);
                    propsUrl.setMode(ProcessFileRepository.MODE_PROPS);
                    propsUrl.setParameter("fid", go.getId());
                    propsUrl.setParameter("type", _type);

                    SWBResourceURL editUrl = paramRequest.getRenderUrl().setCallMethod(SWBParamRequest.Call_DIRECT);
                    editUrl.setMode(ProcessFileRepository.MODE_EDITFOLDER);
                    editUrl.setParameter("fid", go.getId());
                    editUrl.setParameter("type", _type);
                    
            %>
            <div class="swbp-list-element">
                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 swbp-list-title">
                     <%if (type.equals(paramRequest.getLocaleString("lblFileTypeFolder"))) {%>
                     <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 fa fa-folder-open swbp-list-icon"></div>
                    <%}else if (_type.equals("url")) {%>
                     <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 fa fa-link swbp-list-icon"></div>
                    <%}else{%> 
                    <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 fa fa-file-text swbp-list-icon"></div>
                        <%}%>
         
                    <%
                        if (go instanceof RepositoryElement) {
                            RepositoryElement re = (RepositoryElement) go;
                            VersionInfo vi = re.getLastVersion();
                            if (vi != null) {
                                if (luser > 0) {
                                    SWBResourceURL urlDownload = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
                                    urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                                    urlDownload.setParameter("fid", go.getId());
                                    urlDownload.setParameter("verNum", "" + vi.getVersionNumber());
                    %>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 swbp-list-text">
                    <a <%=re instanceof RepositoryURL ? "target=\"_blank\"" : ""%> href="<%=re instanceof RepositoryFile ? urlDownload : vi.getVersionFile()%>"><%=title%></a>
                    </div>
                    <%
                            }
                        }
                    } else if (go instanceof RepositoryDirectory) {
                    %>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-10 swbp-list-text">
                    <a href="<%=((RepositoryDirectory) go).getUrl()%>" title="<%=paramRequest.getLocaleString("msgOpenFolder")%>"><%=title%></a>
                    </div>
                    <%
                        }%>
                
                <div class="col-lg-3 col-md-3 col-sm-3 col-sm-offset-0 col-xs-10 col-xs-offset-2 swbp-list-date">
                <%=lastUpdated%>
                </div>
                </div>
                
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 swbp-list-action">
                    <a href="<%=propsUrl%>" title="<%=paramRequest.getLocaleString("msgInfo")%>" class="btn btn-default <%if (type.equals(paramRequest.getLocaleString("lblFileTypeFolder"))) {%> col-xs-4 <%}else{%>col-xs-3<%}%> fa fa-info-circle" data-toggle="modal" data-target="#modalDialog"></a>
                        <%if (type.equals(paramRequest.getLocaleString("lblFileTypeFolder"))) {%>
                    <a href="<%=editUrl%>" title="<%=paramRequest.getLocaleString("msgInfo")%>" class="btn btn-default col-xs-4 fa fa-pencil" data-toggle="modal" data-target="#modalDialog"></a>
                        <%}%>
                        <%if (luser == 3 || (((Traceable) go).getCreator() != null && ((Traceable) go).getCreator().equals(user) && luser > 1)) {
                                boolean canDelete = true;
                                if (go instanceof RepositoryDirectory) {
                                    RepositoryDirectory rdir = (RepositoryDirectory) go;
                                    if (rdir.listRepositoryElements().hasNext()) {
                                        canDelete = false;
                                    }

                                    if (rdir.listChilds().hasNext()) {
                                        canDelete = false;
                                    }
                                }

                                if (canDelete) {
                                    SWBResourceURL urlremove = paramRequest.getActionUrl();
                                    urlremove.setAction("removefile");
                                    urlremove.setParameter("act", "remove");
                                    urlremove.setParameter("fid", go.getURI());
                        %>
                    <a href="<%=urlremove%>" onclick="if (!confirm('<%=paramRequest.getLocaleString("msgAlertConfirmRemoveFile") + " " + title + "?"%>'))
                                return false;" title="<%=paramRequest.getLocaleString("msgAltDelete")%>" class="btn btn-default <%if (type.equals(paramRequest.getLocaleString("lblFileTypeFolder"))) {%> col-xs-4 <%}else{%>col-xs-3<%}%> fa fa-trash-o"></a>
                        <%
                            }
                            else{%>
                            <a href="#" disabled="true" class="btn btn-default <%if (type.equals(paramRequest.getLocaleString("lblFileTypeFolder"))) {%> col-xs-4 <%}else{%>col-xs-3<%}%> fa fa-trash-o"></a>
                                <%}
                            if (go instanceof RepositoryElement) {
                                addUrl.setParameter("fid", go.getId());
                                addUrl.setParameter("type", _type);
                        %>
                    <a href="<%=addUrl%>" title="<%=paramRequest.getLocaleString("msgAddVersion")%>" class="btn btn-default col-xs-3" data-toggle="modal" data-target="#modalDialog"><span class="fa fa-cloud-upload"></span></a>
                        <%
                                }
                            }

                            if (go instanceof RepositoryElement) {
                                RepositoryElement re = (RepositoryElement) go;
                                VersionInfo vi = re.getLastVersion();
                                if (vi != null) {
                                    if (vi.getPreviousVersion() != null) {
                                        SWBResourceURL historyUrl = paramRequest.getRenderUrl().setMode(ProcessFileRepository.MODE_HISTORY);
                                        historyUrl.setParameter("fid", go.getId());
                                        historyUrl.setParameter("type", (re instanceof RepositoryURL ? "url" : "file"));
                        %>
                    <a href="<%=historyUrl%>" title="<%=paramRequest.getLocaleString("msgViewVersionHistory")%>" class="btn btn-default col-xs-3 fa fa-sort-numeric-asc"></a>
                        <%
                                    }
                                    else{%>
                                    <a href="#" disabled="true" class="btn btn-default col-xs-3 fa fa-sort-numeric-asc"></a>
                                    <%}
                                }
                            }
                        %>
                </div>
            </div>
            <%
                }
            %>
            


<%
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
    }
} else {
%>
<div class="alert alert-block alert-warning">
    <p><%=paramRequest.getLocaleString("msgNoFiles")%></p>
</div>
<%
        }
    }
%>