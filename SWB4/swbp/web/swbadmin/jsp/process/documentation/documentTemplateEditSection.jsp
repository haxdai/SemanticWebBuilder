<%-- 
    Document   : editSectionDialog
    Created on : 19/11/2013, 01:28:47 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.process.documentation.model.FreeText"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    String uriTemplateCont = request.getParameter("uritc") != null ? request.getParameter("uritc") : "";
    String uriDocSection = request.getParameter("urids") != null ? request.getParameter("urids") : "";
    TemplateContainer templateCont = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uriTemplateCont);
    if (templateCont != null) {
        DocumentTemplate docTemplate = templateCont.getActualTemplate();
        String iconClass = "fa fa-plus fa-fw";
        String lang = "es";
        User user = paramRequest.getUser();
        if (user != null && user.getLanguage() != null) {
            lang = user.getLanguage();
        }

        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
        SWBResourceURL urlSave = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_ADD_DOCUMENT_SECTION);
        String viewlabel = paramRequest.getLocaleString("btnAddSection");
        String title = "";
        String uriCls = "";
        String typeDocSection = "";

        DocumentSection documentSection = (DocumentSection) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uriDocSection);
        if (documentSection != null) {
            iconClass = "fa fa-edit fa-fw";
            title = documentSection.getTitle();
            typeDocSection = documentSection.getSectionType().getDisplayName(lang);
            viewlabel = paramRequest.getLocaleString("btnEdit") + " " + title;
            urlSave = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_EDIT_DOCUMENT_SECTION);
            uriCls = documentSection.getSectionType().getURI();
        }
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        url.setParameter("urids", uriDocSection);
        String required = "required";
        //SWBResourceURL urleds = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_EDIT_DOCUMENT_SECTION).setParameter("uritc", uritc);
        //SWBResourceURL urlrds = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_REMOVE_DOCUMENT_SECTION).setParameter("uritc", uritc);
%>
<script type="text/javascript">
    <% if (!action.equals("")) {%>

    $('#modalDialog').modal('hide');
    $('#litc' + location.hash.slice(1)).trigger('click');
    <% }%></script>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><li class="<%=iconClass%>"></li><%=viewlabel%></h4>
        </div>
        <form method="post" id="formesd" name="formesd" action="<%=urlSave%>" class="form-horizontal">
            <div class="modal-body">
                <div class="form-group" id="divtitleSection">
                    <label class="col-lg-3 control-label" for=""><%=paramRequest.getLocaleString("lblTitle")%><%=documentSection == null ? " *" : ""%>:</label>
                    <div class="col-lg-9">
                        <input <%=required%> type="text" class="form-control" id="titleSection" name="titleSection"  value="<%=title%>">
                    </div>
                </div>
                <div class="form-group" id="divdstype">
                    <label for="" class="col-lg-3 control-label"><%=paramRequest.getLocaleString("lblSecType")%><%=documentSection == null ? " *" : ""%>:</label>
                    <div class="col-lg-9">
                        <%
                            if (documentSection != null && documentSection.getSectionType() != null) {
                        %>
                        <input type="text" name="dstype" class="form-control" disabled value="<%=documentSection.getSectionType().transformToSemanticClass().getDisplayName(lang)%>"/>
                        <%           } else {
                        %>
                        <select  <%=required%> name="dstype" id="dstype" class="form-control" onchange="changeLoad(this.options[this.selectedIndex].value);">
                            <option value=""><%=paramRequest.getLocaleString("lblNoneOption")%></option>  
                            <%
                                Iterator<SemanticClass> itSemCls = SWBComparator.sortByDisplayName(SectionElement.sclass.listSubClasses(), lang);
                                while (itSemCls.hasNext()) {
                                    SemanticClass semanticCls = itSemCls.next();
                                    boolean add = true;
                                    if (!semanticCls.isSubClass(Instantiable.swpdoc_Instantiable, false)
                                            && !semanticCls.getClassId().equals(FreeText.sclass.getClassId())) {
                                        Iterator<DocumentSection> itdst = docTemplate.listDocumentSections();
                                        while (itdst.hasNext()) {
                                            DocumentSection doset = itdst.next();
        
                                            if (semanticCls.getURI().equals(doset.getSectionType().getURI()) 
                                                || semanticCls.getName().equals("ElementReference")) {
                                                add = false;
                                                break;
                                            }
                                        }
                                    }
                                    String nameSemCls = semanticCls.getDisplayName(lang);
                                    String uriSemCls = semanticCls.getEncodedURI();
                                    
                                    if (add) {
                            %>
                            <option value="<%=uriSemCls%>"><%=nameSemCls%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div id="containersp">
                </div>
            </div>
            <div class="modal-footer text-center">
                <a class="btn btn-default" data-dismiss="modal"><span class="fa fa-mail-reply fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></a>
                <button type="submit" onclick="submitFormSection('formesd', 'guardaCambios', 'modalDialog', '');
                        return false;" class="btn btn-success" id="savedtes"><span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("btnSave")%></button>
            </div>
            <input type="hidden" name="uritc" value="<%= uriTemplateCont%>"/>
            <input type="hidden" name="urids" value="<%= uriDocSection%>"/>
        </form>
    </div>
</div>
<%
    if (documentSection != null) {
%>
<script>
    postHtmlDoc('<%=url.setMode(SWPDocumentTemplateResource.MODE_PROPERTIES).setParameter("classuri", uriCls)%>', 'containersp');</script> 
    <%
        }
    %>
<script type="text/javascript">
    function changeLoad(clsURI) {
        var url = "<%=url.setMode(SWPDocumentTemplateResource.MODE_PROPERTIES)%>";
        if (clsURI && clsURI !== null) {
            url += "&classuri=" + clsURI;
        }
        postHtmlDoc(url, 'containersp');
    }
    $(document).ready(function() {
        $('#modalDialog').on('shown.bs.modal', function() {
            $('#titleSection').focus();
        });
    });
</script>
<% }%>
