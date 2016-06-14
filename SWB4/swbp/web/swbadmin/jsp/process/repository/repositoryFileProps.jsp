<%-- 
    Document   : repositoryFileProps
    Created on : 3/09/2013, 11:41:28 AM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>

<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.process.model.RepositoryFile"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    User user = paramRequest.getUser();
    WebSite site = paramRequest.getWebPage().getWebSite();
    SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy - hh:mm");
    String lang = "es";

    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }

    String fid = request.getParameter("fid");
    String type = request.getParameter("type");
    GenericObject re = null;

    if (fid != null && type != null) {
        if ("file".equals(type)) {
            re = RepositoryFile.ClassMgr.getRepositoryFile(fid, site);
        } else if ("url".equals(type)) {
            re = RepositoryURL.ClassMgr.getRepositoryURL(fid, site);
        } else {
            re = RepositoryDirectory.ClassMgr.getRepositoryDirectory(fid, site);
        }
    }

    String verNumber = request.getParameter("verNum");
    int intVer = 1;
    if (verNumber != null) {
        intVer = Integer.parseInt(verNumber);
    }

    VersionInfo ver = null;
    VersionInfo vi = null;
    if (re instanceof RepositoryElement) {
        VersionInfo vl = ((RepositoryElement) re).getLastVersion();
        if (null != vl) {
            ver = vl;
            while (ver.getPreviousVersion() != null) {
                if (ver.getVersionNumber() == intVer) {
                    break;
                }
                ver = ver.getPreviousVersion();
            }
        }

        vi = ((RepositoryElement) re).getLastVersion();
    }

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
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h5 class="modal-title"><%=paramRequest.getLocaleString("msgDocProperties")%></h5>
                </div>
                <form class="form-horizontal swbp-form">
                    <div class="modal-body">
                        <%
                        if (null != re) {
                            String creator = "";
                            String title = ((Descriptiveable) re).getDisplayTitle(lang) != null ? ((Descriptiveable) re).getDisplayTitle(lang) : "";
                            String description = ((Descriptiveable) re).getDisplayDescription(lang) != null ? ((Descriptiveable) re).getDisplayDescription(lang) : "";
                            String fileName = "";
                            String vComments = "";
                            String updated = "";
                            SWBResourceURL urlDownload = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
                            
                            if (re instanceof RepositoryElement) {
                                urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                                urlDownload.setParameter("fid", re.getId());
                                urlDownload.setParameter("verNum", "" + vi.getVersionNumber());

                                if (ver != null) {
                                    fileName = ver.getVersionFile();
                                    creator = ver.getCreator() != null ? ver.getCreator().getFullName() : ((Traceable)re).getCreator().getFullName();
                                    vComments = ver.getVersionComment() != null ? ver.getVersionComment() : "";
                                    updated = ver.getCreated() == null ? "" : format.format(ver.getCreated());
                                } else if (vi != null) {
                                    fileName = vi.getVersionFile();
                                    creator = vi.getCreator() != null ? vi.getCreator().getFullName() : ((Traceable)re).getCreator().getFullName();
                                    vComments = vi.getVersionComment() != null ? vi.getVersionComment() : "";
                                    updated = vi.getCreated() == null ? "" : format.format(vi.getCreated());
                                }
                            }
                            %>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label"><%= paramRequest.getLocaleString("msgTitle") %></label>
                                <div class="col-sm-8"><p class="form-control-static"><%= title %></p></div>
                            </div>
                            <%
                            if (re instanceof RepositoryElement) {
                                %>
                                <div class="form-group">
                                    <label for="" class="col-sm-4 control-label"><%= re instanceof RepositoryFile ? paramRequest.getLocaleString("msgFile") : paramRequest.getLocaleString("lblLink")%></label>
                                    <div class="col-sm-8"><p class="form-control-static"><%= fileName %></p></div>
                                </div>
                                <%
                            }
                            %>
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><%= paramRequest.getLocaleString("msgDescription") %></label>
                                <div class="col-sm-8"><p class="form-control-static"><%= description %>&nbsp;</p></div>
                            </div>
                            <%
                            if (re instanceof RepositoryElement && !(re instanceof RepositoryDirectory)) {
                                %>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label"><%= paramRequest.getLocaleString("msgComments") %></label>
                                    <div class="col-sm-8"><p class="form-control-static"><%= vComments %>&nbsp;</p></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label"><%= paramRequest.getLocaleString("msgVersionUser") %></label>
                                    <div class="col-sm-8"><p class="form-control-static"><%= creator %></p></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label"><%= paramRequest.getLocaleString("msgLastDateModification") %></label>
                                    <div class="col-sm-8"><p class="form-control-static"><%= updated %></p></div>
                                </div>
                                <%
                            }
                        }
                        %>
                    </div>
                </form>
            </div>
        </div>
        <%
    }
%>