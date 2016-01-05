<%-- 
    Document   : relatedItem
    Created on : 1/12/2014, 01:34:51 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    WebSite model = paramRequest.getWebPage().getWebSite();
    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi").toString() : "";
    String idp = request.getParameter("idp") != null ? request.getParameter("idp").toString() : "";
    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);

    DocumentTemplate dt = dsi.getSecTypeDefinition() != null ? dsi.getSecTypeDefinition().getParentTemplate() : null;
    SemanticClass scls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(dsi.getSecTypeDefinition().getSectionType().getURI());
    List<SectionElement> list = SectionElement.listSectionElementByTemplate(dt, model, scls, dsi);
    List<String> listtitle = new ArrayList<String>();
    List<String> listid = new ArrayList<String>();
    String[] propst = dsi.getSecTypeDefinition().getVisibleProperties().split("\\|");
    for (String propt : propst) {
        listtitle.add(propt.substring(0, propt.indexOf(";")));
        listid.add(propt.substring(propt.indexOf(";") + 1, propt.length()));
    }
    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_ADD_RELATE).setParameter("uridsi", uridsi);
%>
<div class="modal-dialog">
    <div class="modal-content swbp-content" id="modalContent">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><span class=""></span> <%= paramRequest.getLocaleString("lblRelated")%> <%= (dsi != null && dsi.getSecTypeDefinition() != null && dsi.getSecTypeDefinition().getTitle() != null ? dsi.getSecTypeDefinition().getTitle() : "")%></h4>
        </div>
        <% if (list.size() > 0) {%>
        <form action="<%= urlAction%>" method="POST" id="formRelated">
            <div class="modal-body">
                <div class="table-responsive">
                    <table class="table table-hover swbp-table">
                        <thead>
                            <tr>
                                <th class="swbp-actions"><%=paramRequest.getLocaleString("lblAdd")%></th>
                                <% for (String title : listtitle) {%><th><%= title%></th><% }%>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                RepositoryDirectory rd = null;
                                Referable ref = null;
                                for (SectionElement see : list) {
                                    if (see instanceof ElementReference) {
                                        ElementReference er = (ElementReference) see;
                                        see = (SectionElement) er.getElementRef();
                                    }
                                    if (see instanceof Referable) {
                                        ref = (Referable) see;
                                        rd = ref.getRefRepository().getRepositoryDirectory();
                                    }
                            %><tr>
                                <td>
                                    <input name="related" type="radio" id="related" class="form-control"required="true" value="<%= see.getURI()%>"></td>
                                    <%
                                        SWBFormMgr mgre = new SWBFormMgr(see.getSemanticObject(), null, SWBFormMgr.MODE_VIEW);
                                        for (String idprop : listid) {
                                            SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(idprop);
                                            out.print("<td>");
                                            if (sp.getPropId().equals(Referable.swpdoc_file.getPropId())) {//Propiedad tipo archivo
                                                String titleref = ref.getRefRepository().getTitle() != null ? ref.getRefRepository().getTitle() : "";
                                                String idfile = ref.getRefRepository().getId();
                                                String versionfile = ref.getRefRepository().getLastVersion().getVersionNumber() + "";
                                                SWBResourceURL urlDownload = new SWBResourceURLImp(request, rd.getResource(), rd, SWBResourceModes.UrlType_RENDER);
                                                urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                                                urlDownload.setCallMethod(SWBResourceURL.Call_DIRECT);
                                                urlDownload.setParameter("fid", idfile);
                                                urlDownload.setParameter("verNum", versionfile);
                                                RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                                                VersionInfo vi = re.getLastVersion();
                                                if (re instanceof org.semanticwb.process.model.RepositoryFile) {%>
                        <a href="<%= urlDownload%>"><%= titleref%> <i class="fa fa-download"></i></a>
                            <% } else if (re instanceof RepositoryURL) {%>
                        <a href="<%= vi.getVersionFile()%>" target="_blank"><%= titleref%> <i class="fa fa-external-link"></i></a>    
                            <% }
                                    } else {//Propiedades de texto
                                        out.print(mgre.renderElement(request, sp, SWBFormMgr.MODE_VIEW));
                                    }
                                    out.print("</td>");
                                }%>
                        </tr><%
                            }%>
                        </tbody>
                    </table>
                </div>
                <div id="divrelated">
                </div>
            </div>
            <div class="modal-footer">
                <input type="hidden" name="idp" value="<%= idp%>">
                <a class="btn btn-default fa fa-mail-reply" data-dismiss="modal"> <%= paramRequest.getLocaleString("btnCancel")%></a>
                <button type="submit" onclick="saveRelated('formRelated', 'dsitab<%= dsi.getId()%>', 'modalDialog2', 'Error', 'Seleccione una opción');
                        return  false;" class="btn btn-default fa fa-save"> <%= paramRequest.getLocaleString("btnSave")%></button>
            </div>
        </form>
        <%} else {%>
        <div class="modal-body">
            <div class="alert alert-block alert-warning fade in">
                <%= paramRequest.getLocaleString("msgNoItems")%>
            </div>
        </div>
        <div class="modal-footer">
            <a class="btn btn-default fa fa-mail-reply" data-dismiss="modal"> <%= paramRequest.getLocaleString("btnCancel")%></a>
        </div>
        <% }%>
    </div>
</div>