<%-- 
    Document   : relateActivity
    Created on : 9/12/2014, 10:37:32 AM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElementRef"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.semanticwb.process.documentation.model.Activity"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentationInstance"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentationResource.PARAM_REQUEST);

    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi").toString() : "";
    String urise = request.getParameter("urise") != null ? request.getParameter("urise").toString() : "";

    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
    Activity a = (Activity) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(urise);

    Iterator<DocumentSectionInstance> itdsi = null;
    DocumentationInstance di = null;
    Map map = new HashMap();
    if (dsi != null) {
        di = dsi.getDocumentationInstance();
        itdsi = SWBComparator.sortSortableObject(di.listDocumentSectionInstances());
        if (a != null) {
            Iterator<SectionElementRef> itser = a.listSectionElementRefs();
            while (itser.hasNext()) {
                SectionElementRef ser = itser.next();
                map.put(ser.getSectionElement(), ser);
                //System.out.println("the ser : " + ser + "\tya contiene : " + ser.getSectionElement());
            }
        }
    }
    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_RELATED_ACTIVITY);
    SWBResourceURL urlEdit = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("read", "true");
%>
<div class="modal-dialog">
    <div class="modal-content swbp-content" id="modalContent">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><span class="fa fa-link"></span> <%= paramRequest.getLocaleString("lblRelated")%></h4>
        </div>
        <form method="post" action="<%= urlAction%>" id="formra">
            <div class="modal-body">
                <%
                    if (itdsi.hasNext()) {%>
                <div class="table-responsive">
                    <table class="table table-hover swbp-table">
                        <thead>
                            <tr>
                                <th><%=paramRequest.getLocaleString("lblSection")%></th>
                                <th><%=paramRequest.getLocaleString("lblInstance")%></th>
                                <th style="width: 50px;"><%=paramRequest.getLocaleString("lblAdd")%>&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% while (itdsi.hasNext()) {
                                    DocumentSectionInstance dsin = itdsi.next();
                                    SemanticClass cls = dsin.getSecTypeDefinition() != null && dsin.getSecTypeDefinition().getSectionType() != null ? dsin.getSecTypeDefinition().getSectionType().transformToSemanticClass() : null;
                                    if (cls.isSubClass(Instantiable.swpdoc_Instantiable, false)
                                            && dsin.listDocuSectionElementInstances().hasNext()) {
                                        Iterator<SectionElement> itse = null;
                            %>
                            <tr>
                                <td style="vertical-align: middle;">
                                    <%= dsin.getSecTypeDefinition().getTitle()%> 
                                </td>
                                <td colspan="2" >
                                    <ul class="list-group">
                                        <%
                                            itse = dsin.listDocuSectionElementInstances();
                                            while (itse.hasNext()) {
                                                SectionElement sen = itse.next();
                                                SectionElement seo = (SectionElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(sen.getURI());
                                                String[] propst = dsin.getSecTypeDefinition().getVisibleProperties().trim().split("\\|");
                                                String idprop = propst[0].substring(propst[0].indexOf(";") + 1, propst[0].length());
                                                SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(idprop);
                                                String value = "";
                                                if (sen instanceof ElementReference) {
                                                    ElementReference er = (ElementReference) sen;
                                                    sen = (SectionElement) er.getElementRef();
                                                }
                                                if (sp.getPropId().equals(Referable.swpdoc_file.getPropId())) {
                                                    Referable ref = (Referable) sen;
                                                    RepositoryDirectory rd = ref.getRefRepository().getRepositoryDirectory();
                                                    SWBResourceURL urlDownload = new SWBResourceURLImp(request, rd.getResource(), rd, SWBResourceModes.UrlType_RENDER);
                                                    urlDownload.setMode(ProcessFileRepository.MODE_GETFILE).setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("fid", ref.getRefRepository().getId()).setParameter("verNum", ref.getRefRepository().getLastVersion().getVersionNumber() + "");
                                                    RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                                                    VersionInfo vi = re.getLastVersion();
                                                    if (re instanceof org.semanticwb.process.model.RepositoryFile) {
                                                        value = "<a href=\"" + urlDownload + "\">" + ref.getRefRepository().getTitle() + " <i class=\"fa fa-download\"></i></a> ";
                                                    } else if (re instanceof RepositoryURL) {
                                                        value = "<a href=\"" + vi.getVersionFile() + "\" target=\"_blank\">" + ref.getRefRepository().getTitle() + " <i class=\"fa fa-external-link\"></i></a>";
                                                    }
                                                } else {
                                                    value = sen.getSemanticObject().getProperty(sp);
                                                }
                                        %>
                                        <li class="list-group-item">
                                            <div class="row">
                                                <div class="col-lg-10">
                                                    <%= value%>
                                                </div>
                                                <div class="col-lg-1 text-center">

                                                    <a  class="btn btn-default btn-xs"
                                                        rel="tooltip" title="<%=paramRequest.getLocaleString("lblView")%>" data-original-title="<%=paramRequest.getLocaleString("lblView")%>"
                                                        onclick="showModal('<%= urlEdit.setMode(SWPDocumentationResource.MODE_EDIT_INSTANTIABLE).setParameter("urise", sen.getURI()).setParameter("uridsi", dsin.getURI()).setParameter("related", "view") %>', '<%=paramRequest.getLocaleString("btnEdit")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                                                        ><span class="fa fa-eye"></span></a>
                                                </div>
                                                <div class="col-lg-1 text-center">
                                                    <input type="checkbox" <% if (map.containsKey(seo)) { %> checked="true"<% }%> name="<%= seo.getURI()%>">
                                                </div>
                                            </div>

                                        </li>
                                        <% } %>
                                    </ul>
                                </td>
                            </tr>
                            <%}
                                }%>
                        </tbody>
                    </table>
                </div>
                <% } else {%>
                <div class="alert alert-block alert-warning fade in"><%=paramRequest.getLocaleString("msgNoItems")%></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal"><%=paramRequest.getLocaleString("btnClose")%></button>
                </div>  
                <%}
                %>
            </div>
            <div class="modal-footer">
                <input type="hidden" name="uridsi" value="<%= uridsi%>">
                <input type="hidden" name="urise" value="<%= urise%>">
                <a class="btn btn-default fa fa-mail-reply" data-dismiss="modal"> <%=paramRequest.getLocaleString("btnCancel")%></a>
                <button type="submit" onclick="saveSE('formra', '', 'modalDialog', true);
                        return  false;" class="btn btn-default fa fa-save"> <%=paramRequest.getLocaleString("btnSave")%></button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $('.modal a[rel="tooltip"]')
                .tooltip({placement: 'bottom'})
                .data('tooltip');
    });
</script>