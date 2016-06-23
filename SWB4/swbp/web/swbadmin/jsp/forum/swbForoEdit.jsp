<%-- 
    Document   : swbForoEdit
    Created on : 17/01/2014, 11:40:06 AM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.util.CaptchaUtil"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Thread"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String threadUri = request.getParameter("threadUri") != null ? request.getParameter("threadUri") : "";
    Thread thread = (Thread) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(threadUri);
    WebSite model = paramRequest.getWebPage().getWebSite();
    SWBResourceURL urlAction = paramRequest.getActionUrl().setAction("addThread");
    SWBResourceURL backUrl = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
    SWBFormMgr forMgr = new SWBFormMgr(Thread.frm_Thread, model.getSemanticObject(), SWBFormMgr.MODE_CREATE);
    Boolean isCaptcha = request.getAttribute("isCaptcha") != null ? Boolean.parseBoolean(request.getAttribute("isCaptcha").toString()) : false;
    String mode = SWBFormMgr.MODE_CREATE;
    String lblAction = paramRequest.getLocaleString("newthread");

    if (thread != null) {
        forMgr = new SWBFormMgr(thread.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
        mode = SWBFormMgr.MODE_EDIT;
        urlAction.setAction("editThread");
        urlAction.setParameter("threadUri", thread.getURI());
        lblAction = paramRequest.getLocaleString("edit") + " " + paramRequest.getLocaleString("thread");
        backUrl.setAction("viewPost");
        backUrl.setParameter("threadUri", threadUri);
    }
    String flag = request.getParameter("flag") != null ? request.getParameter("flag").toString() : "";
%>
<%if (!flag.equals("")) {%>
    <div class="alert alert-warning alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>Aviso!</strong> <%=paramRequest.getLocaleString(flag)%>.
    </div>
<%}%>
<div class="panel panel-default swbp-panel-head no-margin">
    <div class="panel-heading text-center"><%= lblAction %></div>
    <form class="form-horizontal swbp-form" id="formSaveThread" method="post" action="<%=urlAction%>">
        <%out.print(forMgr.getFormHiddens());%>
        <div class="panel-body swbp-panel-body-card">
            <div class="form-group" id="div<%= Thread.swb_title.getName() %>">
                <label for="<%= Thread.swb_title %>" class="col-sm-3 control-label"><%=SWBUtils.TEXT.parseHTML(forMgr.renderLabel(request, Thread.swb_title, mode))%></label>
                <div class="col-sm-8">
                    <%
                    String inputTitle = forMgr.renderElement(request, Thread.swb_title, mode);
                    inputTitle = inputTitle.replaceFirst(">", " required class=\"form-control\" id=\"" + Thread.swb_title.getName() + "\">");
                    inputTitle = inputTitle.replace(inputTitle.substring(inputTitle.indexOf("style"), (inputTitle.indexOf("px;\"") + 4)), "");
                    out.println(inputTitle);
                    %>
                    <span id="<%= Thread.swb_title.getName() %>_error" class="help-block error"></span>
                </div>
            </div>
            <div class="form-group" id="div<%= Thread.frm_thBody.getName() %>">
                <label for="<%= Thread.frm_thBody.getName() %>" class="col-sm-3 control-label"><%=SWBUtils.TEXT.parseHTML(forMgr.renderLabel(request, Thread.frm_thBody, mode))%></label>
                <div class="col-sm-8">
                    <%
                    String inputMessage = forMgr.renderElement(request, Thread.frm_thBody, mode);
                    inputMessage = inputMessage.replaceFirst(">", " required class=\"form-control swbp-form-control\">");
                    inputMessage = inputMessage.replace(inputMessage.substring(inputMessage.indexOf("style"), (inputMessage.indexOf("px;\"") + 4)), "");
                    out.println(inputMessage);
                    %>
                    <span id="<%= Thread.frm_thBody.getName() %>_error" class="help-block error"></span>
                </div>
            </div>
            <%
            if (isCaptcha) {
                %>
                <div class="form-group">
                    <label for="" class="col-sm-3 control-label"><%="Captcha *:"%></label>
                    <div class="col-sm-8">
                        <img src="<%= SWBPlatform.getContextPath() + "/swbadmin/jsp/securecode.jsp" %>" id="imgseccode" width="155" height="65"/>
                        <input type="text" name="cmnt_seccode" class="form-control" required/>
                    </div>
                </div>
                <%
            }%>
        </div>
        <div class="panel-footer text-right">
            <button type="submit" class="btn btn-default" id="btnSaveThread">
                <span class="fa fa-save fa-fw"></span><span class="hidden-xs">Guardar</span>
            </button>
            <button type="button" class="btn btn-default" onclick="window.location='<%=backUrl%>';"> 
                <span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("cancel")%></span>
            </button>
        </div>
    </form>
</div>
