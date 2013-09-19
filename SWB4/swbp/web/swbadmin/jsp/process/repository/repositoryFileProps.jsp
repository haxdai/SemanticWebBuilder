<%-- 
    Document   : repositoryFileProps
    Created on : 3/09/2013, 11:41:28 AM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>

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
RepositoryElement re = null;

if (fid != null && type != null) {
    if ("file".equals(type)) {
        re = RepositoryFile.ClassMgr.getRepositoryFile(fid, site);
    } else {
        re = RepositoryURL.ClassMgr.getRepositoryURL(fid, site);
    }
}

String verNumber = request.getParameter("verNum");
int intVer = 1;
if (verNumber != null) {
    intVer = Integer.parseInt(verNumber);
}
VersionInfo ver = null;
VersionInfo vl = re.getLastVersion();
if (null != vl) {
    ver = vl;
    while (ver.getPreviousVersion() != null) {
        if (ver.getVersionNumber() == intVer) {
            break;
        }
        ver = ver.getPreviousVersion();
    }
}

if (!user.isSigned()) {
    if (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT) {
        %>
        <div class="alert alert-block alert-danger fade in">
            <h4><i class="icon-ban-circle"></i> <%=paramRequest.getLocaleString("msgNoAccessTitle")%></h4>
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
                <h4><%=paramRequest.getLocaleString("msgDocProperties")%></h4>
            </div>
            <div class="modal-body">
                <%
                if (re == null) {
                    %><%
                } else {
                    VersionInfo vi = re.getLastVersion();
                %>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                      <label class="col-lg-5 control-label"><%=paramRequest.getLocaleString("msgTitle")%></label>
                      <div class="col-lg-7">
                        <input class="form-control" type="text" disabled value="<%=re.getDisplayTitle(lang)%>"/>
                      </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-5 control-label"><%=re instanceof RepositoryFile?paramRequest.getLocaleString("msgFile"):paramRequest.getLocaleString("lblLink")%></label>
                        <div class="col-lg-7">
                        <%
                        String val = "--";
                        if (ver != null) {
                            val = ver.getVersionFile();
                        } else if (vi != null) {
                            val = vi.getVersionFile();
                        }
                        %>
                        <input class="form-control" type="text" disabled value="<%=val%>" />
                        </div>
                    </div>
                    <div class="form-group">
                      <label class="col-lg-5 control-label"><%=paramRequest.getLocaleString("msgDescription")%></label>
                      <div class="col-lg-7">
                          <textarea class="form-control" disabled><%=re.getDisplayTitle(lang)!= null?re.getDisplayDescription(lang):"--"%></textarea>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-lg-5 control-label"><%=paramRequest.getLocaleString("msgComments")%></label>
                      <div class="col-lg-7">
                        <textarea class="form-control" disabled><%=vi!=null?vi.getVersionComment():"--"%></textarea>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-lg-5 control-label"><%=paramRequest.getLocaleString("msgVersionUser")%></label>
                      <div class="col-lg-7">
                          <input class="form-control" type="text" disabled value="<%=re.getCreator()==null?"--":re.getCreator().getFullName()%>"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-lg-5 control-label"><%=paramRequest.getLocaleString("msgLastDateModification")%></label>
                      <div class="col-lg-7">
                        <input class="form-control" type="text" disabled value="<%=re.getCreated()==null?"--":format.format(re.getCreated())%>"/>
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