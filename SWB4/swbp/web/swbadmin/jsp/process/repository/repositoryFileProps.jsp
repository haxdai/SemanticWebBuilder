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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><%=paramRequest.getLocaleString("msgDocProperties")%></h4>
        </div>
        <div class="modal-body">
            <%
                if (re == null) {
            %><%                    } else {
            %>
            <form class="form-horizontal" role="form">
                <div class="row">
                 <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                     <%=paramRequest.getLocaleString("msgTitle")%>   
                 </div>
                 <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                     <%=((Descriptiveable) re).getDisplayTitle(lang)%>
                 </div>
                 <%if (re instanceof RepositoryElement) {%>
                  <%
                        SWBResourceURL urlDownload = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
                        urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                        urlDownload.setParameter("fid", re.getId());
                        urlDownload.setParameter("verNum", "" + vi.getVersionNumber());
                        String val = "";
                        if (ver != null) {
                            val = ver.getVersionFile();
                        } else if (vi != null) {
                            val = vi.getVersionFile();
                        }
                    %>
                 <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                     <%=re instanceof RepositoryFile ? paramRequest.getLocaleString("msgFile") : paramRequest.getLocaleString("lblLink")%>
                 </div>
                 <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                    <%=val%>   
                 </div>                
                 <%}%>
            
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                    <%=paramRequest.getLocaleString("msgDescription")%>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                    <%=((Descriptiveable) re).getDisplayDescription(lang) != null ? ((Descriptiveable) re).getDisplayDescription(lang) : ""%>&nbsp;
                </div>
             
     
                <%if (re instanceof RepositoryElement) {
                        String comment = (vi != null ? vi.getVersionComment() : "");
                        if (comment == null) {
                            comment = "";
                        }
                %>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                    <%=paramRequest.getLocaleString("msgComments")%>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                    <%=comment%>&nbsp;
                </div>
                <%}%>
                
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                    <%=paramRequest.getLocaleString("msgVersionUser")%>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                    <%=((Traceable) re).getCreator() == null ? "" : ((Traceable) re).getCreator().getFullName()%>
                </div>
                
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-modal-property">
                    <%=paramRequest.getLocaleString("msgLastDateModification")%>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-modal-value">
                    <%=((Traceable) re).getCreated() == null ? "" : format.format(((Traceable) re).getCreated())%>
                </div>
            </div>
            </form>
            <%
                }
            %>
        </div>
       
    </div>
</div>
<%
    }
%>