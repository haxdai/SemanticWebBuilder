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
<div class="modal-content swbp-modal">
    <div class="modal-header">
        <h4 class="modal-title"><%= lblAction %></h4>
    </div>
    <form novalidate class="form-horizontal" id="formSaveThread" method="post" action="<%=urlAction%>">
        <%out.print(forMgr.getFormHiddens());%>
        <div class="modal-body">
            <div class="form-group" id="div<%= Thread.swb_title.getName() %>">
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                    <label for="<%= Thread.swb_title %>"><%=SWBUtils.TEXT.parseHTML(forMgr.renderLabel(request, Thread.swb_title, mode))%></label>
                </div>
                <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
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
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                    <label for="<%= Thread.frm_thBody.getName() %>" ><%=SWBUtils.TEXT.parseHTML(forMgr.renderLabel(request, Thread.frm_thBody, mode))%></label>
                </div>
                <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                    <%
                    String inputMessage = forMgr.renderElement(request, Thread.frm_thBody, mode);
                    inputMessage = inputMessage.replaceFirst(">", " required class=\"form-control swbp-form-control\" rows=\"6\">");
                    inputMessage = inputMessage.replace(inputMessage.substring(inputMessage.indexOf("style"), (inputMessage.indexOf("px;\"") + 4)), "");
                    out.println(inputMessage);
                    %>
                    <span id="<%= Thread.frm_thBody.getName() %>_error" class="help-block error"></span>
                </div>
            </div>
            <%
            if (isCaptcha) {
                %>
                <div class="row hidden-margin">
                    <div class="col-lg-8 col-md-8 col-sm-12 swbp-captcha">
                        <div class="col-lg-5 col-md-7 col-sm-6 col-xs-12 hidden-padding" id="cmnt_seccode">
                            <label for=""><%="Captcha *:"%></label>
                            <img src="<%= SWBPlatform.getContextPath() + "/swbadmin/jsp/securecode.jsp" %>" id="imgseccode" width="155" height="65"/>
                        </div>
                        <div class="col-lg-4 sol-md-4 col-sm-6 col-xs-12 hidden-padding">
                            <input type="text" name="cmnt_seccode" class="form-control" required/>
                        </div>
                    </div>
                </div>
                <%
            }%>
        </div>
        <div class="modal-footer">
            <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" id="btnSaveThread">
                <span class="fa fa-save fa-fw"></span>Guardar
            </button>
            <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" onclick="window.location='<%=backUrl%>';"> 
                <span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("cancel")%>
            </button>
        </div>
    </form>
</div>
