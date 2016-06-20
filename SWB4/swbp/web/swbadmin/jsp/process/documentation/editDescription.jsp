<%-- 
    Document   : editDescription
    Created on : 7/05/2014, 04:47:44 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.process.documentation.model.Activity"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    String urise = request.getParameter("urise") != null ? request.getParameter("urise") : "";
    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi") : "";
    String idp = request.getParameter("idp") != null ? request.getParameter("idp") : "";
    SectionElement sei = (SectionElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(urise);
    SWBResourceURL urlEditor = paramRequest.getActionUrl().setAction(SWPDocumentationResource.ACTION_EDIT_TEXT).setParameter("urise", urise);
    urlEditor.setParameter("uridsi", uridsi);
    urlEditor.setParameter("idp", idp);
    WebPage wpage = paramRequest.getWebPage();
    //DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
    SWBResourceURL urlUpload = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_UPLOAD_PICTURE).setParameter("urise", java.net.URLEncoder.encode(urise, "UTF-8"));
    final String fullHostname = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() != 80? ":" + request.getServerPort():"");
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title"><%=paramRequest.getLocaleString("btnEdit")%></h5>
        </div>
        <div class="modal-body">
            <form method="post">    
                <textarea name="description" id="description_<%= sei.getId() %>"><%= sei.getDescription() != null ? sei.getDescription() : ""%></textarea>
                <input type="hidden" id="urise" name="urise" value="<%=urise%>">
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $('#modalDialog').on('hidden.bs.modal', function() {
            var cache = tinymce.get("description_<%= sei.getId() %>");
            cache && cache.remove();
        });
        
        tinymce.init({
            selector: '#description_<%= sei.getId() %>',
            entity_encoding : "raw",
            save_enablewhendirty: false,
            language: '<%=paramRequest.getUser().getLanguage()%>',
            toolbar: "save | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image table | undo redo code | forecolor backcolor emoticons ",
            menubar: false,
            force_br_newlines: true,
            paste_data_images: true,
            force_p_newlines: true,
            relative_urls : false,
            remove_script_host : false,
            document_base_url : '<%= fullHostname %>',
            height: 500,
            plugins: [
                " fullpage save advlist table contextmenu link image textcolor code paste"
            ],
            save_onsavecallback: function(ed) {
                var content = ed.getContent();
                $.ajax({
                    url: '<%= urlEditor %>',
                    cache: false,
                    data: {data: content},
                    type: 'POST',
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success: function(dt) {
                        if (dt && dt.status === "ok") {
                            ed.notificationManager.open({
                                text: 'Se ha guardado el contenido.'
                            });
                            $("#modalDialog").hide();
                            var edt = tinymce.get("description_<%= sei.getId() %>");
                            edt && edt.remove();
                            window.location.reload();
                        }
                    }
                });
            },
            file_browser_callback: function(field_name, url, type, win) {
                tinymce.activeEditor.windowManager.open({
                    title: "Cargar archivo",
                    url: "/swbadmin/jsp/process/documentation/uploader.jsp?modelid=<%= wpage.getWebSiteId()%>&urlact=<%= urlUpload%>",
                    width: 600
                }, {
                    oninsert: function(url) {
                        win.document.getElementById(field_name).value = url;
                            setTimeout(function() {
                                top.tinymce.activeEditor.windowManager.close();
                            }, 500);
                        }
                });
            }
        });
    });
    // Prevent bootstrap dialog from blocking focusin
    $(document).on('focusin', function(e) {
        if ($(e.target).closest(".mce-window").length) {
            e.stopImmediatePropagation();
        }
    });


    /*$('#open').click(function() {
        $("#dialog").dialog({
            width: 800,
            modal: true
        });
    });*/
</script>