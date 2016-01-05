<%-- 
    Document   : editDescription
    Created on : 7/05/2014, 04:47:44 PM
    Author     : carlos.alvarez
--%>

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
    SWBResourceURL urlEditor = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_EDIT_DESCRIPTION).setParameter("urise", urise);
    urlEditor.setParameter("uridsi", uridsi);
    urlEditor.setParameter("idp", idp);
    WebPage wpage = paramRequest.getWebPage();
    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
    SWBResourceURL urlUpload = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_UPLOAD_PICTURE).setParameter("urise", java.net.URLEncoder.encode(urise, "UTF-8"));

%>
<div class="modal-dialog">
    <div class="modal-content swbp-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><span class="fa fa-pencil"></span><%=paramRequest.getLocaleString("btnEdit")%></h4>
        </div>
        <div class="modal-body">
            <form method="post" class="form-inline">
                <div class="form-row">
                    <textarea>
                        <%= sei.getDescription() != null ? sei.getDescription() : ""%>
                    </textarea>
                </div>
                    <input type="hidden" id="urise" name="urise" value="<%=urise%>">
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    tinymce.init({
        selector: 'textarea',
        language: '<%=paramRequest.getUser().getLanguage()%>',
        toolbar: "save | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image table | undo redo code | forecolor backcolor emoticons ",
        menubar: false,
        save_enablewhendirty: true,
        force_br_newlines: true,
        paste_data_images: true,
        force_p_newlines: true,
        height: 500,
        plugins: [
            " fullpage save advlist table contextmenu link image textcolor code paste"
        ],
        save_onsavecallback: function(ed) {
            saveText('<%= urlEditor%>', ed.getContent(), '<%= urise%>', '', 'dsitab<%= dsi != null ? dsi.getId() : ""%>');
        },
        file_browser_callback: function(field_name, url, type, win) {
            tinymce.activeEditor.windowManager.open({
                title: "Cargar archivo",
                url: "/work/models/<%= wpage.getWebSiteId()%>/jsp/documentation/uploader.jsp?modelid=<%= wpage.getWebSiteId()%>&urlact=<%=urlUpload%>",
            }, {
                oninsert: function(url) {
                    var id = tinymce.activeEditor.id;
                    id = id.substr((id.lastIndexOf(":") + 1), id.length);
                    win.document.getElementById(field_name).value = url;
                    setTimeout(function() {
                        tinymce.activeEditor.windowManager.close();
                    }, 500);
                }
            });
        }
    });
    // Prevent bootstrap dialog from blocking focusin
    $(document).on('focusin', function(e) {
        if ($(e.target).closest(".mce-window").length) {
            e.stopImmediatePropagation();
        }
    });


    $('#open').click(function() {
        $("#dialog").dialog({
            width: 800,
            modal: true
        });
    });
</script>