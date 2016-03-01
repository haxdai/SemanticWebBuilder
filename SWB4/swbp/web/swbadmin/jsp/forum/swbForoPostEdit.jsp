<%-- 
    Document   : swbForoPostEdit
    Created on : 20/01/2014, 11:32:34 AM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.resources.sem.forum.Post"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String threadUri = request.getParameter("threadUri") != null ? request.getParameter("threadUri") : "";
    String postUri = request.getParameter("postUri") != null ? request.getParameter("postUri") : "";
    org.semanticwb.portal.resources.sem.forum.Post post = (org.semanticwb.portal.resources.sem.forum.Post) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(postUri);
    SWBResourceURL urlAction = paramRequest.getActionUrl().setAction("editPost");
    urlAction.setParameter("threadUri", threadUri);
    urlAction.setParameter("postUri", postUri);
    SWBFormMgr forMgr = new SWBFormMgr(post.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
    WebSite model = paramRequest.getWebPage().getWebSite();
    String mode = SWBFormMgr.MODE_EDIT;
    Boolean isCaptcha = request.getAttribute("isCaptcha") != null ? Boolean.parseBoolean(request.getAttribute("isCaptcha").toString()) : false;

    String action = request.getAttribute("lblAction") != null ? request.getAttribute("lblAction").toString() : "";
    String lblAction = paramRequest.getLocaleString("edit");
    if (!action.equals("")) {
        lblAction = paramRequest.getLocaleString("comment") + " " + paramRequest.getLocaleString("msg");
        forMgr = new SWBFormMgr(Post.frm_Post, model.getSemanticObject(), SWBFormMgr.MODE_CREATE);
        urlAction.setAction("replyPost");
    }
    String flag = request.getParameter("flag") != null ? request.getParameter("flag").toString() : "";

    if (!flag.equals("")) {
        %>
        <div class="alert alert-warning alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Aviso!</strong> <%=paramRequest.getLocaleString(flag)%>.
        </div>
        <%
    }%>
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <h4 class="modal-title"><%= lblAction %></h4>
        </div>
        <form class="form-horizontal" id="formSavePost" method="post" action="<%= urlAction %>">
            <%out.print(forMgr.getFormHiddens());%>
            <div class="modal-body">
                <div class="form-group" id="div<%=Post.frm_pstBody.getName()%>">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for="<%= Post.frm_pstBody.getName() %>" ><%=SWBUtils.TEXT.parseHTML(forMgr.renderLabel(request, Post.frm_pstBody, mode))%></label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                        <%
                        String inputTitle = forMgr.renderElement(request, org.semanticwb.portal.resources.sem.forum.Post.frm_pstBody, mode);
                        inputTitle = inputTitle.replaceFirst(">", " required class=\"form-control swbp-form-control\" rows=\"8\" id=\"" + org.semanticwb.portal.resources.sem.forum.Post.frm_pstBody.getName() + "\">");
                        inputTitle = inputTitle.replace(inputTitle.substring(inputTitle.indexOf("style"), (inputTitle.indexOf("px;\"") + 4)), "");
                        out.println(inputTitle);
                        %>
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
                        </div>
                        <div class="col-lg-4 sol-md-4 col-sm-6 col-xs-12 hidden-padding">
                            <input type="text" name="cmnt_seccode" class="form-control" required/>
                        </div>
                    </div>
                    <%
                }%>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" id="btnSavePost">
                    <span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("send")%>
                </button>
                <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" onclick="window.location='<%=paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).setAction("viewPost").setParameter("threadUri", threadUri)%>'"> 
                    <span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("cancel")%>
                </button>
            </div>
        </form>
    <script>
        document.getElementById("pstBody").focus();
        $('#btnSavePost').click(function() {
            console.log('on validate ');
            var $inputs = $('#formSavePost :input');
            var cont = 0;
            $inputs.each(function() {
                if (this.required) {
                    var diverror = $('#div' + this.name);
                    if ($(this).val().length === 0) {
                        diverror.addClass('has-error');
                        cont++;
                    } else {
                        diverror.removeClass('has-error');
                    }
                }
            });
            if (cont === 0) {
                var forma = document.getElementById('formSavePost');
                forma.submit();
            }
            return false;
        });
    </script>
    </div>