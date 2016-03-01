<%-- 
    Document   : actualizaTab
    Created on : 29/11/2014, 07:32:48 PM
    Author     : carlos.alvarez
--%>
<%@page import="org.semanticwb.process.documentation.model.DocumentationInstance"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.process.documentation.model.Activity"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentationResource.PARAM_REQUEST);
    User user = paramRequest.getUser();
    String lang = user != null && user.getLanguage() != null ? user.getLanguage() : "es";
    String pg = request.getParameter("pg") != null ? request.getParameter("pg") : "";
    String pag = request.getParameter("p") != null ? request.getParameter("p") : "";
    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi") : "";
    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
    if (dsi != null)  {
        SWBResourceURL urlDialog = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("uridsi", uridsi);
        SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE).setParameter("uridsi", uridsi);
        String uriset = request.getParameter("urise") != null ? request.getParameter("urise") : "";
        SectionElement sen = (SectionElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uriset);
        if (sen instanceof ElementReference) {
            ElementReference er = (ElementReference) sen;
            uriset = er.getElementRef().getURI();
        }
        //SectionElement seuoa = (SectionElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uriset);
        SemanticClass cls = dsi.getSecTypeDefinition() != null && dsi.getSecTypeDefinition().getSectionType() != null ? dsi.getSecTypeDefinition().getSectionType().transformToSemanticClass() : null;

        Iterator<SectionElement> itse = SWBComparator.sortSortableObject(dsi.listDocuSectionElementInstances());
        if (cls != null && cls.isSubClass(Instantiable.swpdoc_Instantiable, false)) { //BusinesRole, BusinessRule, Definition, Format, Indicator, Objetive, Policy, Reference y Risk  %>
<div class="text-right">
    <ul class="list-unstyled list-inline">
        <li>
            <a class="btn btn-default swbp-btn-action" rel="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnAddElement")%>" 
               onclick="showModal('<%= urlDialog.setMode(SWPDocumentationResource.MODE_EDIT_INSTANTIABLE)%>', '<%=paramRequest.getLocaleString("btnAddElement")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                <span class="fa fa-plus fa-fw"></span>
            </a>
        </li>
    </ul>
</div>
<%
    String[] propst = dsi.getSecTypeDefinition().getVisibleProperties().trim().split("\\|");
    if (!dsi.getSecTypeDefinition().getVisibleProperties().trim().equals("") && propst.length > 0) {
        List<String> listtitle = new ArrayList<>();
        List<String> listid = new ArrayList<>();
        for (String propt : propst) {
            listtitle.add(propt.substring(0, propt.indexOf(";")));
            listid.add(propt.substring(propt.indexOf(";") + 1, propt.length()));
        }
%>
<div class="table-responsive">
    <table class="table table-hover swbp-table">
        <thead>
            <tr>
                <% for (String title : listtitle) {%><th><%= title%></th><% }%>
                <th class="swbp-actions text-right"><%=paramRequest.getLocaleString("lblActions")%></th>
            </tr>
        </thead>
        <tbody>
            <%
                RepositoryDirectory rd = null;
                Referable ref = null;
                while (itse.hasNext()) {
                    SectionElement se = itse.next();
                    String urised = se.getURI();
                    boolean isReference = false;
                    if (se instanceof ElementReference) {
                        ElementReference er = (ElementReference) se;
                        se = (SectionElement) er.getElementRef();
                        isReference = true;
                    }
                    if (se instanceof Referable) {
                        ref = (Referable) se;
                        rd = ref.getRefRepository().getRepositoryDirectory();
                    }
                    String urise = se.getURI();
            %><tr <% if (urise.equals(uriset)) { %> class="success"<% }%>><%
                SWBFormMgr mgr = new SWBFormMgr(se.getSemanticObject(), null, SWBFormMgr.MODE_VIEW);
                for (String idprop : listid) {
                    SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(idprop);
                    out.print("<td>");
                    if (sp.getPropId().equals(Referable.swpdoc_file.getPropId())) {//Propiedad tipo archivo
                        String titleref = ref.getRefRepository().getTitle();
                        String idfile = ref.getRefRepository().getId();
                        String versionfile = ref.getRefRepository().getLastVersion().getVersionNumber() + "";
                        SWBResourceURL urlDownload = new SWBResourceURLImp(request, rd.getResource(), rd, SWBResourceModes.UrlType_RENDER);
                        urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                        urlDownload.setCallMethod(SWBResourceURL.Call_DIRECT);
                        urlDownload.setParameter("fid", idfile);
                        urlDownload.setParameter("verNum", versionfile);
                        RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                        VersionInfo vi = re.getLastVersion();
                        if (re instanceof org.semanticwb.process.model.RepositoryFile) {
                %>

        <a href="<%= urlDownload%>"><%= titleref%> <i class="fa fa-download"></i></a>
        <% } else if (re instanceof RepositoryURL) {
            %>
        <a href="<%=vi.getVersionFile()%>" target="_blank"><%= titleref%> <i class="fa fa-external-link"></i></a>    
            <% }
                    } else {//Propiedades de texto
                        out.print(mgr.renderElement(request, sp, SWBFormMgr.MODE_VIEW));
                    }
                    out.print("</td>");
                }%>
        <td style="width: 130px;" class="text-right">
            <%
                if (!isReference) {
            %>
            <a class="btn btn-sm btn-default" title="<%=paramRequest.getLocaleString("btnEdit")%>"
               onclick="showModal('<%= urlDialog.setMode(SWPDocumentationResource.MODE_EDIT_INSTANTIABLE).setParameter("urise", urise)%>', '<%=paramRequest.getLocaleString("btnEdit")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
               rel="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnEdit")%>"
               >
                <span class="fa fa-pencil"></span>
            </a> 
            <%} else if (se.getDocumentSectionInst() != null
                    && se.getDocumentSectionInst().getDocumentationInstance() != null
                    && se.getDocumentSectionInst().getDocumentationInstance().getProcessRef() != null) {
                String captureUrl = paramRequest.getWebPage().getUrl(lang);
                org.semanticwb.process.model.Process pr = se.getDocumentSectionInst().getDocumentationInstance().getProcessRef();
            %>
            <a class="btn btn-sm btn-default" href="<%= captureUrl + "?idp=" + pr.getEncodedURI() + "&pg=" + pg + "&p=" + pag + "#" + se.getDocumentSectionInst().getId()%>" target="_blank"
               rel="tooltip" data-placement="bottom" data-original-title="<%= pr.getTitle()%>"
               >
                <span class="fa fa-gears"></span>
            </a>
            <% }%>
            <a class="btn btn-sm btn-default" title="<%= paramRequest.getLocaleString("btnRemove")%>"
               onclick="if (!confirm('<%= paramRequest.getLocaleString("msgDeletePrompt") + " "%>?'))
                           return false;
                       deleteDocumentSection('<%= urlAction.setParameter("urise", urise)%>', 'trse<%= se.getId()%>');
                       return false;"
               data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnRemove")%>"                                                       
               >
                <span class="fa fa-trash-o"></span>
            </a>
            <a class="btn btn-sm btn-default" title="<%=paramRequest.getLocaleString("btnInfo")%>"
               onclick="showModal('<%= urlDialog.setMode(SWPDocumentationResource.MODE_TRACEABLE).setParameter("uridt", se.getURI())%>', '<%=se.getTitle()%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>');"
               rel="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnInfo")%>"
               >
                <span class="fa fa-info-circle"></span>
            </a>
        </td>
        </tr><% }%>
        </tbody>
    </table>
</div>
<% }
} else if (cls.getClassId().equals(Activity.sclass.getClassId())) {
    String idp = request.getParameter("idp") != null ? request.getParameter("idp").toString() : "";
    urlDialog.setParameter("idp", idp);
    org.semanticwb.process.model.Process p = org.semanticwb.process.model.Process.ClassMgr.getProcess(idp, paramRequest.getWebPage().getWebSite());//(org.semanticwb.process.model.Process) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(urip);
    TemplateContainer tc = dsi.getSecTypeDefinition().getParentTemplate().getTemplateContainer();
    DocumentationInstance.updateActivityFromProcess(p, tc, dsi);
    itse = SWBComparator.sortSortableObject(dsi.listDocuSectionElementInstances());
%>
<div class="table-responsive">
    <table class="table table-hover swbp-table">
        <thead>
            <tr>
                <th><%= paramRequest.getLocaleString("lblTitle")%></th>
                <th><%= paramRequest.getLocaleString("lblDescription")%></th>
                <th style="width: 50px;"><%= paramRequest.getLocaleString("lblRelated")%></th>
            </tr>
        </thead>
        <tbody>
            <%
                while (itse.hasNext()) {
                    SectionElement se = itse.next();
                    String titlese = se.getTitle() != null ? se.getTitle() : "";
                    String descse = se.getDescription() != null ? se.getDescription() : "";
                    String urise = se.getURI();
                    Activity act = (Activity) se.getSemanticObject().createGenericInstance();
                    String fill = act.getFill() != null ? ("color: #" + act.getFill()) : "";
                    SWBResourceURL urlRelated = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_RELATED_ACTIVITY).setParameter("idp", idp).setParameter("uridsi", uridsi);
                    SWBResourceURL urlFill = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_UPDATE_FILL);%>
            <tr>
                <td><%= titlese%></td>
                <td>
                    <%= descse%>

                    <a class="btn btn-sm btn-default" title="<%=paramRequest.getLocaleString("btnEdit")%>"
                       onclick="showModal('<%= urlDialog.setMode(SWPDocumentationResource.MODE_EDIT_DESCRIPTION).setParameter("urise", urise)%>', '<%=paramRequest.getLocaleString("btnEdit")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                       data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnEdit")%>"
                       >
                        <span class="fa fa-pencil"></span>
                    </a> 
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
                            <span class="fa <% if (fill.equals("")) {%>fa-ban<% } else {%>fa-square<%}%>" id="btnColorFill<%=act.getId()%>"  style="<%if (!fill.equals("")) {
                                    out.print(fill);
                                }%>"></span>
                            <%= paramRequest.getLocaleString("btnColorFill")%> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <ul class="list-inline">
                                <li>
                                    <a onclick="updateColorFill('defaultFill', '<%=act.getId()%>', '<%=act.getURI()%>', '<%= urlFill%>');" style="cursor: pointer;">
                                        <span class="fa fa-ban" id="defaultFill"></span></a></li>
                                <li>
                                    <a onclick="updateColorFill('428bca', '<%=act.getId()%>', '<%=act.getURI()%>', '<%= urlFill%>');" style="cursor: pointer;">
                                        <span class="fa fa-square" id="428bca" style="color: #428bca;"></span></a></li>
                                <li>
                                    <a onclick="updateColorFill('5cb85c', '<%=act.getId()%>', '<%=act.getURI()%>', '<%= urlFill%>');" style="cursor: pointer;">
                                        <span class="fa fa-square" id="5cb85c" style="color: #5cb85c;"></span></a></li>
                                <li>
                                    <a onclick="updateColorFill('5bc0de', '<%=act.getId()%>', '<%=act.getURI()%>', '<%= urlFill%>');" style="cursor: pointer;">
                                        <span class="fa fa-square"  id="5bc0de" style="color: #5bc0de;"></span></a></li>
                                <li>
                                    <a onclick="updateColorFill('f0ad4e', '<%=act.getId()%>', '<%=act.getURI()%>', '<%= urlFill%>');" style="cursor: pointer;">
                                        <span class="fa fa-square" id="f0ad4e" style="color: #f0ad4e;"></span></a></li>
                                <li>
                                    <a onclick="updateColorFill('d9534f', '<%=act.getId()%>', '<%=act.getURI()%>', '<%= urlFill%>');" style="cursor: pointer;">
                                        <span class="fa fa-square" id="d9534f" style="color: #d9534f;"></span></a></li>
                            </ul>
                        </ul>
                    </div>
                </td>
                <td>
                    <a class="btn btn-sm btn-default" title="<%=paramRequest.getLocaleString("lblRelated")%>"
                       onclick="showModal('<%= urlRelated.setParameter("urise", se.getURI())%>', '<%=paramRequest.getLocaleString("btnEdit")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                       rel="tooltip" data-original-title="<%=paramRequest.getLocaleString("lblRelated")%>"
                       >
                        <span class="fa fa-link"></span>
                    </a>
                </td>
            </tr>
            <%
                }%>
        </tbody>
    </table>
</div>
<%}
    }
%>
<script src="<%= SWBPlatform.getContextPath() %>/swbadmin/jsp/process/documentation/js/documenter.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('.panel a[rel="tooltip"]')
                .tooltip({placement: 'bottom'})
                .data('tooltip');
    });
</script>
