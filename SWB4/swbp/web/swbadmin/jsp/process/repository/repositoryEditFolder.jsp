<%-- 
    Document   : repositoryEditFolder
    Created on : 1/06/2015, 05:41:28 PM
    Author     : Ana Laura Garcia <ana.garcias@infotec.mx>
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
    SWBResourceURL actionURL = paramRequest.getActionUrl().setAction(ProcessFileRepository.ACT_EDITFOLDER);   
    User user = paramRequest.getUser();
    WebSite site = paramRequest.getWebPage().getWebSite();
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
                <h5 class="modal-title"><%=paramRequest.getLocaleString("msgAltRenDirectory")%></h5>
            </div>
            <%
            if (null != re) {
                %>
                <form method="post" id="formEditRepository" action="<%=actionURL%>" class="form-horizontal swbp-form">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><%= Descriptiveable.swb_title.getDisplayName(lang) %></label>
                            <div class="col-sm-8">
                                <input required type="text" name="titleRep" id="titleRep" errorMsg="Ingresar el título" value="<%=((Descriptiveable) re).getDisplayTitle(lang)%>" class="form-control"/>
                            </div>
                            <div id="container"></div>     
                        </div>
                        <input type="hidden" id="fid" name="fid" value="<%=fid%>">
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" id="savedtes"><span class="fa fa-save fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("msgBTNSave")%></span></button>
                        <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs">Cancelar</span>
                        </button>
                    </div>
                </form>
                <%
            }
            %>
        </div>
    </div>
    <script>
        (function() {
            var theForm = document.getElementById('formEditRepository');
            if (!theForm) return;

            var isTitleValid = function(element) {
                if (element.required) {
                    return !element.validity.valueMissing;
                } else {
                    return element.value && element.value !== "";
                }
            };

            theForm['titleRep'].addEventListener("keyup", function(evt) {
                if (isTitleValid(evt.target)) {
                    $(evt.target).closest(".form-group").removeClass("has-error");
                } else {
                    $(evt.target).closest(".form-group").addClass("has-error");
                }
            });

            theForm.addEventListener('submit', function(evt) {
                var valid = isTitleValid(theForm['titleRep']);
                if (valid) {
                    $.ajax({
                        url: $(theForm).attr('action'),
                        cache: false,
                        data: $(theForm).serialize(),
                        type: 'POST',
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        success: function(data) {
                            if (data.status === "ok") {
                                window.location.reload();
                            }
                        }
                    });
                }
                evt.preventDefault();
                return false;
            });
        })();
    </script>
<%
    }
%>