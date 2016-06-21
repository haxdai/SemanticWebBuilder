<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.model.RepositoryFile"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");

    String urise = request.getParameter("urise") != null ? request.getParameter("urise").toString() : "";
    String fileSe = request.getParameter("fileSe") != null ? request.getParameter("fileSe").toString() : "";
    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi").toString() : "";
    String title = request.getParameter("title") != null ? request.getParameter("title").toString() : "";
    String _rid = request.getParameter("_rid") != null ? request.getParameter("_rid").toString() : "";
    String idp = request.getParameter("idp") != null ? request.getParameter("idp").toString() : "";
    String wp = request.getParameter("wp") != null ? request.getParameter("wp").toString() : "";
    //String link = request.getParameter("link") != null ? request.getParameter("link").toString() : "";
    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE).setParameter("uridsi", uridsi).setParameter("urise", urise);
    
    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
   %>
<div class="modal-dialog">
    <div class="modal-content" id="modalContent">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title">Eliminar <%= null!= dsi ? dsi.getSecTypeDefinition().getTitle() : "" %></h5>
        </div>
        <form method="POST" id="formRemove" class="form-horizontal swbp-form" action="<%=urlAction%>">
            <div class="modal-body">
                <p><%=paramRequest.getLocaleString("msgDeletePrompt") + "  " + title + "?"%></p>
                <div class="checkbox-inline">
                    <label><input type="checkbox" name="optionRemove" />Eliminar archivo asociado</label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <span class="fa fa-trash-o fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnRemove")%></span>
                </button>
                <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                    <span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnCancel")%></span>
                </button>
            </div>
            <input type="hidden" name="_rid" value="<%=_rid%>">
            <input type="hidden" name="idp" value="<%=idp%>">
            <input type="hidden" name="wp" value="<%=wp%>">
            <input type="hidden" name="fileSe" value="<%=fileSe%>">
        </form>
    </div>
</div>

<!--<iframe style="display:none;" name="UploadFrameR" id="UploadFrameR"></iframe>-->
<script>
    (function() {
        var theForm = document.getElementById('formRemove');
        if (!theForm) return;

        theForm.addEventListener('submit', function(evt) {
           
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
            
            evt.preventDefault();
            return false;
        });
    })();
</script>