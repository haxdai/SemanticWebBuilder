<%-- 
    Document   : editSectionTemplateBehavior
    Created on : 20/11/2013, 01:13:04 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.model.FormElement"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.process.model.RepositoryFile"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="java.util.Collections"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElementRef"%>
<%@page import="org.semanticwb.process.documentation.model.Model"%>
<%@page import="org.semanticwb.process.documentation.model.base.ModelBase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentationInstance"%>
<%@page import="org.semanticwb.process.model.ProcessElement"%>
<%@page import="org.semanticwb.process.model.GraphicalElement"%>
<%@page import="org.semanticwb.process.documentation.model.Activity"%>
<%@page import="org.semanticwb.process.documentation.model.Definition"%>
<%@page import="org.semanticwb.process.documentation.model.Reference"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.process.documentation.model.Format"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.process.documentation.model.FreeText"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.DisplayProperty"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%--@page contentType="multipart/form-data" pageEncoding="UTF-8"--%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentationResource.PARAM_REQUEST);
    WebSite model = paramRequest.getWebPage().getWebSite();
    String lang = paramRequest.getUser().getLanguage();

    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi").toString() : "";
    String urise = request.getParameter("urise") != null ? request.getParameter("urise").toString() : "";
    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
    SectionElement se = (SectionElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(urise);
    String related = request.getParameter("related") != null ? request.getParameter("related") : "";
    //System.out.println("the se edit : " + se);

    String iconClass = urise.equals("") ? "fa fa-plus" : "fa fa-edit";
    String action = (urise.equals("") ? "Agregar" : "Editar") + " " + (dsi != null && dsi.getSecTypeDefinition() != null && dsi.getSecTypeDefinition().getTitle() != null ? dsi.getSecTypeDefinition().getTitle() : "");

    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_ADD_INSTANTIABLE);
    SWBResourceURL urlRelated = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_RELATED).setParameter("uridsi", uridsi);
    String idrep = "";
    boolean read = request.getParameter("read") != null;

%>
<div class="modal-dialog">
    <div class="modal-content swbp-content" id="modalContent">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"><span class="<%= iconClass%>"></span> <%= action%></h4>
        </div>
        <%
            SemanticClass scls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(dsi.getSecTypeDefinition().getSectionType().getURI());
            SWBFormMgr mgr = new SWBFormMgr(scls, model.getSemanticObject(), SWBFormMgr.MODE_CREATE);
            if (se != null) {
                mgr = new SWBFormMgr(se.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
                urlAction.setAction(SWPDocumentationResource.ACTION_EDIT_INSTANTIABLE);
            }
        %>
        <form class="form-horizontal" method="POST" id="formSE" action="<%= urlAction%>" enctype="multipart/form-data" acceptcharset="UTF-8">
            <div class="modal-body">
                <% //if (se == null) {%>
                <!--div class="form-group">
                    <div class="col-lg-7 col-lg-offset-4 text-right">
                        <a class="btn btn-sm btn-success" 
                           rel="tooltip" data-original-title="Asociar" title="Aso"
                           onclick="showModal('<'%=urlRelated%>', 'Relacionar', 'Cargando...', 'No se pudó cargar', 'modalDialog2')"><i class="fa fa-link"></i>
                        </a>
                    </div>
                </div-->
                <%// }
                    String[] propst = dsi.getSecTypeDefinition().getVisibleProperties().split("\\|");
                    out.print(mgr.getFormHiddens());
                    for (String props : propst) {
                        String titleprop = props.substring(0, props.indexOf(";"));
                        String idprop = props.substring(props.indexOf(";") + 1, props.length());
                        SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(idprop);
                        /*
                         SemanticObject semObj = se.getSemanticObject();
                         Iterator<SemanticProperty> itsp = se.getSemanticObject().getSemanticClass().listProperties();
                         while (itsp.hasNext()) {
                         SemanticProperty spt = itsp.next();
                         if (!spt.isObjectProperty() && semObj.getProperty(spt) != null) {
                         System.out.println("prop : " + spt.getName() + "\tvalue : " + semObj.getProperty(spt));
                         }
                         }
                         */
                        boolean required = sp != null && sp.isRequired();
                        if (!sp.getPropId().equals(Referable.swpdoc_file.getPropId())) { // Input y TextArea
%>
                <div class="form-group" id="div<%=sp.getName()%>">
                    <label for="" class="col-lg-4 control-label"><%=titleprop%> <%if (required) {%>*<%}%></label>
                    <div class="col-lg-7">
                        <%
                            String mode = SWBFormMgr.MODE_CREATE;
                            if (read) {
                                mode = SWBFormMgr.MODE_VIEW;
                            }
                            String inputfm = mgr.renderElement(request, sp, mode);
                            if (!read) {
                                inputfm = inputfm.replaceFirst(">", " id=\"" + sp.getName() + "\" " + (required ? "required" : "") + " class=\"form-control\">");
                                inputfm = inputfm.replace("name=\"" + sp.getName() + "\"", "name=\"" + idprop + "\"");
                                //System.out.println("uno: \n" + inputfm);
                                inputfm = inputfm.replace(inputfm.substring(inputfm.indexOf("style"), (inputfm.indexOf("px;\"") + 4)), "");
                                //System.out.println("dos :\n" + inputfm);
                            }
                            out.println(inputfm);
                        %>
                    </div>
                </div>
                <%
                } else { //Es un archivo
                    RepositoryDirectory rd = null;
                    Referable ref = null;
                    idrep = sp.getName();
                    if (se == null) {//Archivo nuevo
%>
                <div class="form-group">
                    <label class="col-lg-4 control-label"><%=paramRequest.getLocaleString("msgFileType")%> *</label>
                    <div class="col-lg-6">
                        <div class="radio-inline">
                            <label>
                                <input type="radio" id="fileToggleRadio" onclick="toggleShow('divf<%=sp.getName()%>', 'ffile', true);
                                        toggleShow('divl<%=sp.getName()%>', 'lfile', false);" checked name="hftype" value="file"> <%=paramRequest.getLocaleString("msgFile")%>
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" id="urlToggleRadio" onclick="toggleShow('divl<%=sp.getName()%>', 'lfile', true);
                                        toggleShow('divf<%=sp.getName()%>', 'ffile', false);"name="hftype" value="url"> <%=paramRequest.getLocaleString("lblLink")%>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group" id="divf<%= sp.getName()%>">
                    <label for="" class="col-lg-4 control-label"><%= titleprop%> *</label>
                    <div class="col-lg-7">
                        <div class="input-group">
                            <span class="input-group-btn">
                                <span class="btn btn-default btn-file">
                                    <%=paramRequest.getLocaleString("lblSelect")%> <input type="file" id="ffile" name="ffile" required="true" class="form-control">
                                </span>
                            </span>
                            <input type="text" class="form-control" disabled="true"/>
                        </div>
                    </div>
                </div>
                                    <div id="divl<%= sp.getName()%>" style="display:none" class="form-group">
                    <label for="" class="col-lg-4 control-label"><%=paramRequest.getLocaleString("lblLink")%> *</label>
                    <div class="col-lg-6">
                        <div class="input-group">
                            <span class="input-group-addon">http://</span>
                            <input type="text" name="lfile" id="lfile" class="form-control" />
                            </span>
                        </div>
                    </div>
                </div> 
                <% } else { // Es edición 
                    List<VersionInfo> listvi = null;
                    VersionInfo vi = null;
                %>
                <div class="form-group" id="div<%=sp.getName()%>">
                    <label for="" class="col-lg-4 control-label"><%= titleprop%></label>
                    <%
                        if (se instanceof Referable) {
                            ref = (Referable) se;
                            rd = ref.getRefRepository().getRepositoryDirectory();
                        }
                        String titleref = ref.getRefRepository().getTitle() != null ? ref.getRefRepository().getTitle() : "";
                        String idfile = ref.getRefRepository().getId();
                        RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                        //VersionInfo vi = re.getLastVersion();
                        vi = ref.getVersion() != null ? ref.getVersion() : re.getLastVersion();
                        //String versionfile = ref.getRefRepository().getLastVersion().getVersionNumber() + "";
                        SWBResourceURL urlDownload = new SWBResourceURLImp(request, rd.getResource(), rd, SWBResourceModes.UrlType_RENDER);
                        urlDownload.setMode(ProcessFileRepository.MODE_GETFILE).setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("fid", idfile);
                        urlDownload.setParameter("verNum", vi.getVersionNumber() + "");
                        
                        listvi = re.listVersions();
                    %>
                    <input type="hidden" name="urire" value="<%= re.getURI()%>">
                    <div class="col-lg-7 input-group">
                        <%
                            if (re instanceof org.semanticwb.process.model.RepositoryFile) {%>
                        <a href="<%= urlDownload%>" class="btn btn-default"><%= titleref%> <i class="fa fa-download"></i></a>
                            <% } else if (re instanceof RepositoryURL) {%>
                        <a href="<%= vi.getVersionFile()%>" target="_blank" class="btn btn-default"><%= titleref%> <i class="fa fa-external-link"></i></a>  
                            <%}%>
                    </div>
                </div>
                <div id="divversionref" class="form-group">
                    <label for="" class="col-lg-4 control-label"><%= paramRequest.getLocaleString("lblVersionAct")%> *</label>
                    <div class="col-lg-7">
                        <%if (read) {
                                out.print(vi.getVersionNumber());
                            } else {%>
                        <select name="versionref" id="versionref" class="form-control" required="true">
                            <% for (VersionInfo vit : listvi) {%>
                            <option value="<%= vit.getURI()%>" <%if (vi != null && vi.equals(vit)) {%> selected="true"<%}%>><%= vit.getVersionNumber()%></option>
                            <%}%>
                        </select>
                        <% }%>
                    </div>
                </div>


                <% }
                    SemanticProperty semPropData = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(DocumentSection.swpdoc_configData.getPropId());
                    String configData = "";
                    if (semPropData != null) {
                        configData = semPropData.getLabel(lang);
                    }
                    WebPage webpage = (WebPage) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(dsi.getSecTypeDefinition().getConfigData());
                    List<RepositoryDirectory> list = SWPDocumentationResource.listRepositoryDerectoryByParent(webpage, true);
                %>
                <div id="div<%= semPropData.getName()%>" class="form-group">
                    <label for="" class="col-lg-4 control-label"><%= configData%> *</label>
                    <div class="col-lg-7">
                        <%if (read) {
                                out.print(rd.getTitle());
                            } else {%>
                        <select name="<%= semPropData.getPropId()%>" id="<%= semPropData.getName()%>" class="form-control" required="true">
                            <option value=""><%="-- " + configData + " --"%></option>
                            <option <%if (rd != null && rd.equals(webpage)) {%> selected="true"<%}%> value="<%= webpage.getURI()%>"><%= webpage.getTitle()%></option>
                            <% for (RepositoryDirectory rep : list) {%>
                            <option value="<%= rep.getURI()%>" <%if (rd != null && rd.equals(rep)) {%> selected="true"<%}%>><%= rep.getTitle()%></option>
                            <%}%>
                        </select>
                        <% }%>
                    </div>
                </div>
                <%
                        }
                    }%>
            </div>
            <div class="modal-footer">

                <input type="hidden" name="props" value="<%= dsi.getSecTypeDefinition().getVisibleProperties()%>">
                <% if (read) {%>
                <input type="hidden" name="read" value="<%= read%>">
                <% }%>
                <input type="hidden" name="uridsi" value="<%= uridsi%>">
                <input type="hidden" name="urise" value="<%= urise%>">
                <%if(!related.equals("view")){%>
                <a class="btn btn-default fa fa-mail-reply" data-dismiss="modal"> <%=paramRequest.getLocaleString("btnCancel")%></a>
                <button type="submit" onclick="saveSE('formSE', 'dsitab<%= dsi.getId()%>', 'modalDialog', true);
                        return  false;" class="btn btn-default fa fa-save"> <%=paramRequest.getLocaleString("btnSave")%></button>
                <% }%>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">

       
    
    $(document).ready(function() {
        $('.btn-file :file').on('change', function() {
            var file = this.files[0];
            var input = $(this).parents('.input-group').find(':text');
            if (input.length) {
                input.val(file.name);
            }
        });

        $("form input, textarea").addClass("form-control");
        setTimeout(function() {
            $('form').find('input,textarea,select').filter(':visible:first').focus();
        }, 500);
    <% if (scls.isSubClass(Referable.swpdoc_Referable, false)) {%>
        toggleShow('divl<%=idrep%>', 'lfile', false);
        $('lfile').removeAttr("required");
    <%}%>

        $('.modal a[rel="tooltip"]')
                .tooltip({placement: 'bottom'})
                .data('tooltip');
    });
</script>