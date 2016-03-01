<%-- 
    Document   : repositoryAddFolder.jsp
    Created on : 3/09/2013, 11:41:28 AM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
WebSite site = paramRequest.getWebPage().getWebSite();
User user = paramRequest.getUser();

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
    SWBResourceURL createURL = paramRequest.getActionUrl().setAction(ProcessFileRepository.ACT_NEWFOLDER);
    %>
    <div class="modal-dialog">
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <h4 class="modal-title"><%=paramRequest.getLocaleString("msgCreateDirectory")%></h4>
        </div>
        <form id="folderAddForm" class="form-horizontal" role="form" action="<%=createURL%>" method="post">
            <div class="modal-body">
                <div class="form-group">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%=paramRequest.getLocaleString("msgTitle")%> *</label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                        <input id="ftitle" type="text" name="ftitle" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%=paramRequest.getLocaleString("msgID")%> *</label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                        <input id="fid" type="text" name="fid" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%=paramRequest.getLocaleString("msgDescription")%></label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                        <textarea name="fdescription" id="fdescription" class="form-control swbp-form-control"></textarea>
                    </div>
                </div>
            </div>
                <div class="modal-footer">
                    <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6"><span class="fa fa-plus fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("msgAdd")%></span></button>
                    <button type="button" data-dismiss="modal" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6"><span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("msgBTNCancel")%></span></button>                  
                </div>
            </form>
        </div>
    </div>
    <%
}
%>
<script type="text/javascript">
    (function() {
        $(document).ready(function() {
            $('#ftitle').on('keyup', function() {
                var idField = $('#fid');
                var val = replaceChars4Id($(this).val());
                idField.val(val);

                if (!canCreateSemanticObject('<%=site.getSemanticModel().getName()%>','<%=RepositoryDirectory.sclass.getClassId()%>', val)) {
                    idField.parents('.form-group').addClass("has-error");
                } else {
                    idField.parents('.form-group').removeClass("has-error");
                }
            });

            $('#fid').on('keyup blur', function() {
                var val = $(this).val();
                if (canCreateSemanticObject('<%=site.getSemanticModel().getName()%>','<%=RepositoryDirectory.sclass.getClassId()%>', val) === false) {
                    $(this).parents('.form-group').addClass("has-error");
                } else {
                    $(this).parents('.form-group').removeClass("has-error");
                }
            });

            var theForm = document.getElementById("folderAddForm");
            theForm.addEventListener('submit', function(evt) {
                var idFieldVal = $('#fid').val();
                var titleField = $('#ftitle').val();
                var isValid = canCreateSemanticObject('<%=site.getSemanticModel().getName()%>','<%=RepositoryDirectory.sclass.getClassId()%>', idFieldVal);

                if (isValid) {
                    if (titleField === null || titleField.length === 0) isValid = false;
                }

                if (isValid) {
                    $.ajax({
                        url: $(theForm).attr('action'),
                        cache: false,
                        data: $(theForm).serialize(),
                        type: 'POST',
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
        });
    })();
</script>