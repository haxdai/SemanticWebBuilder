<%-- 
    Document   : addDocumentation
    Created on : 5/12/2013, 05:36:08 PM
    Author     : carlos.alvarez
--%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPUserDocumentationResource"%>
<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.portal.api.SWBResource"%>
<%@page import="org.semanticwb.process.model.GraphicalElement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.process.documentation.model.Model"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.process.documentation.model.Activity"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.process.documentation.model.Definition"%>
<%@page import="org.semanticwb.process.documentation.model.Reference"%>
<%@page import="org.semanticwb.process.documentation.model.Format"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.process.documentation.model.FreeText"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentationInstance"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.process.model.ProcessSite"%>
<%@page import="org.semanticwb.process.model.ProcessElement"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentationResource.PARAM_REQUEST);
    User user = paramRequest.getUser();
    Resource base = paramRequest.getResourceBase();
    boolean showWord = null != base.getAttribute("allowWord") && "true".equalsIgnoreCase(base.getAttribute("allowWord"));
    WebSite site = paramRequest.getWebPage().getWebSite();
    String idp = request.getParameter("idp") != null ? request.getParameter("idp").toString() : "";
    String lang = user != null && user.getLanguage() != null ? user.getLanguage() : "es";
    Process p = Process.ClassMgr.getProcess(idp, site);
    String idpg = request.getParameter("pg") != null ? request.getParameter("pg") : "";
    String pag = request.getParameter("p") != null ? request.getParameter("p") : "";
    SWBResourceURL urlText = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_EDIT_TEXT);    
    String wp = request.getParameter("wp");
    WebPage wpage = WebPage.ClassMgr.getWebPage(wp, site);
    if (null == wpage) wpage = paramRequest.getWebPage();
    SWBResourceURL urlUpload = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_UPLOAD_PICTURE);
    boolean hasFreeTextElements = false;
    %>
    <div class="row navbar-fixed-top" id="linotification"></div>
    <%
    Iterator<TemplateContainer> itTemplateCont = TemplateContainer.ClassMgr.listTemplateContainerByProcess(p);
    if (p != null) {
        if (itTemplateCont == null || !itTemplateCont.hasNext())  {
            %>
            <div class="row swbp-pad">
                <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
                    <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= idpg %>" class="btn btn-block swbp-btn-block" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblBack")%>" title="<%=paramRequest.getLocaleString("lblBack")%>">
                        <%=paramRequest.getLocaleString("lblBack")%>
                    </a>
                </div>
            </div>
            <hr>
            <div class="alert alert-block alert-warning fade in">
                <%=paramRequest.getLocaleString("msgNoTemplate")%>
            </div>
            <%
        } else {
            %>
            <script src="<%= SWBPlatform.getContextPath() %>/swbadmin/jsp/process/documentation/js/bootstrap-colorpicker.min.js"></script>
            <script src="<%= SWBPlatform.getContextPath() %>/swbadmin/jsp/process/documentation/js/documenter.js"></script>
            <%
            //Traer datos
            TemplateContainer templateCont = itTemplateCont.next();
            DocumentationInstance di = DocumentationInstance.getDocumentationInstanceByProcess(p, templateCont);
            Iterator<DocumentSectionInstance> itdsi = SWBComparator.sortSortableObject(di.listDocumentSectionInstances());//Regerar código para ordenamiento
            SWBResourceURL urlVersion = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_VERSION).setParameter("uridi", di.getURI());
            SWBResourceURL urlAdminVersion = paramRequest.getRenderUrl().setMode(SWPDocumentationResource.MODE_ADMIN_VERSION);
            urlAdminVersion.setParameter("idp", idp);

            //String urlView = wpage.getRealUrl();
            String _rid = request.getParameter("_rid");
            Resource resource = Resource.ClassMgr.getResource(_rid, site);
            SWBResourceURL urlView = new SWBResourceURLImp(request, resource, wpage, SWBResourceModes.UrlType_RENDER);
            urlView.setMode(SWPUserDocumentationResource.MODE_VIEW_DOCUMENTATION);
            urlView.setParameter("idp", idp);

            String templatesUrl = wpage.getUrl(lang);
            if (resource.getAttribute("templatePage") != null) {
                WebPage twp = wpage.getWebSite().getWebPage(resource.getAttribute("templatePage"));
                if (twp != null) {
                    templatesUrl = twp.getUrl(lang);
                }
            }
            SWBResourceURL urlZip = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_DOWNLOAD);
            urlZip.setParameter("idp", idp);
            urlZip.setParameter("urip", p.getURI());
            urlZip.setParameter("uridi", di.getURI());
            %>
            <div class="row swbp-pad">
                <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
                    <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>?<%= SWPUserDocumentationResource.PARAM_PROCESSGROUP %>=<%= idpg %>" class="btn btn-block swbp-btn-block" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblBack")%>" title="<%=paramRequest.getLocaleString("lblBack")%>">
                        <%=paramRequest.getLocaleString("lblBack")%>
                    </a>
                </div>
            </div>
            <hr>
            <div class="row text-right">
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <ul class="list-unstyled list-inline">
                                    <li>
                                        <a href="<%= templatesUrl%>" class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblAdminTemplates")%>" title="<%=paramRequest.getLocaleString("lblAdminTemplates")%>">
                                            <span class="fa fa-list-alt fa-fw"></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<%= urlView%>" class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblDocumentation")%>" title="<%=paramRequest.getLocaleString("lblDocumentation")%>">
                                            <span class="fa fa-eye"></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a onclick="downloadVersion('<%= SWPDocumentationResource.FORMAT_HTML%>')"
                                            class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblVersionDownloadH")%>" title="<%=paramRequest.getLocaleString("lblVersionDownloadH")%>">
                                            <span class="fa fa-file-text"></span>
                                        </a>
                                    </li>
                                    <%
                                    if (showWord) {
                                        %>
                                        <li>
                                            <a onclick="downloadVersion('<%= SWPDocumentationResource.FORMAT_WORD%>')"
                                                class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblVersionDownloadW")%>" title="<%=paramRequest.getLocaleString("lblVersionDownloadW")%>">
                                                <span class="fa fa-file-word-o"></span>
                                            </a>
                                        </li>
                                        <%
                                    }
                                    %>
                                    <li>
                                        <a 
                                            onclick="showModal('<%= urlVersion.setParameter("idp", idp)%>', '<%=paramRequest.getLocaleString("btnAddElement")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                                            class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblVersion")%>" title="<%=paramRequest.getLocaleString("lblVersion")%>">
                                            <span class="fa fa-cloud-upload"></span>
                                        </a>
                                    </li>
                                    <li>
                                       <a href="<%=urlAdminVersion%>" 
                                          data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblAdminVersion")%>" title="<%=paramRequest.getLocaleString("lblAdminVersion")%>" 
                                          class="btn btn-default swbp-btn-action">
                                          <span class="fa fa-sort-numeric-desc"></span>
                                       </a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="panel panel-default swbp-panel">
                <div class="panel-heading">
                    <div class="panel-title swbp-panel-title">
                        <strong><%= p.getTitle()%></strong>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 swbp-navbar-left">
                        <ul class="nav nav-pills nav-stacked" id="tabcontainerdsi">
                            <%
                            while (itdsi.hasNext()) {
                                DocumentSectionInstance docSectionInstance = itdsi.next();
                                if (docSectionInstance.getSecTypeDefinition().isActive()) {
                                    String idDocSectionInstance = docSectionInstance.getId();
                                    %>
                                    <li title="<%= docSectionInstance.getSecTypeDefinition().getTitle()%>">
                                        <a href="#dsitab<%= idDocSectionInstance %>" data-toggle="tab" onclick="updateBookmark('<%= idDocSectionInstance %>')"> <%= docSectionInstance.getSecTypeDefinition().getTitle() %></a>
                                    </li>
                                    <%
                                }
                            }
                            %>
                        </ul>
                        <script type="text/javascript">
                            function updateBookmark(idDocSectionInstance) {
                                window.location.hash = idDocSectionInstance;
                            }
                        </script>
                    </div>
                    <div class="tab-content col-lg-10 col-md-10 col-sm-10 col-xs-10">
                        <%
                        //Contenido
                        itdsi = SWBComparator.sortSortableObject(di.listDocumentSectionInstances());//Regerar código para ordenamiento
                        while (itdsi.hasNext()) {
                            DocumentSectionInstance docSectionInstance = itdsi.next();
                            String uriDocSectionInstance = docSectionInstance.getURI();
                            String idDocSectionInstance = docSectionInstance.getId();
                            SWBResourceURL urlEdit = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("idp", idp);
                            SWBResourceURL urlTrace = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_TRACEABLE);
                            SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE).setParameter("uridsi", uriDocSectionInstance);
                            SemanticClass cls = docSectionInstance.getSecTypeDefinition() != null && docSectionInstance.getSecTypeDefinition().getSectionType() != null ? docSectionInstance.getSecTypeDefinition().getSectionType().transformToSemanticClass() : null;
                            Iterator<SectionElement> itse = SWBComparator.sortSortableObject(docSectionInstance.listDocuSectionElementInstances());
                            %>
                            <div class="tab-pane" id="dsitab<%= idDocSectionInstance%>">
                                <%
                                if (cls != null && cls.isSubClass(Instantiable.swpdoc_Instantiable, false)) { //BusinesRole, BusinessRule, Definition, Format, Indicator, Objetive, Policy, Reference y Risk  
                                    %>
                                    <div class="text-right">
                                        <ul class="list-unstyled list-inline">
                                            <li>
                                                <a class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnAddElement")%>" 
                                                   onclick="showModal('<%= urlEdit.setMode(SWPDocumentationResource.MODE_EDIT_INSTANTIABLE).setParameter("uridsi", uriDocSectionInstance)%>', '<%=paramRequest.getLocaleString("btnAddElement")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');">
                                                    <span class="fa fa-plus fa-fw"></span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                    <%
                                    String[] propst = docSectionInstance.getSecTypeDefinition().getVisibleProperties().trim().split("\\|");

                                    if (!docSectionInstance.getSecTypeDefinition().getVisibleProperties().trim().equals("") && propst.length > 0) {
                                        List<String> listtitle = new ArrayList<>();
                                        List<String> listid = new ArrayList<>();
                                        for (String propt : propst) {
                                            listtitle.add(propt.substring(0, propt.indexOf(";")));
                                            listid.add(propt.substring(propt.indexOf(";") + 1, propt.length()));
                                        }
                                        if (!itse.hasNext()) {
                                            %><%=paramRequest.getLocaleString("lblNoData")%><%
                                        } else {
                                            %>
                                            <div class="table-responsive">
                                                <table class="table table-hover swbp-table">
                                                    <thead>
                                                        <tr>
                                                            <%
                                                            for (String title : listtitle) {
                                                                %><th><%= title %></th><%
                                                            }
                                                            %>
                                                            <th class="swbp-actions"><%=paramRequest.getLocaleString("lblActions")%></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                        RepositoryDirectory repositoryDirec = null;
                                                        Referable ref = null;
                                                        while (itse.hasNext()) {
                                                            SectionElement se = itse.next();
                                                            String uriSectionElement = se.getURI();
                                                            boolean isReference = false;
                                                            if (se instanceof ElementReference) {
                                                                ElementReference er = (ElementReference) se;
                                                                if (er.getElementRef() == null) {
                                                                    docSectionInstance.removeDocuSectionElementInstance(er);
                                                                    er.remove();
                                                                    continue;
                                                                }
                                                                se = (SectionElement) er.getElementRef();
                                                                er.setIndex(se.getIndex());
                                                                isReference = true;
                                                            }
                                                            if (se instanceof Referable) {
                                                                ref = (Referable) se;
                                                                if(ref.getRefRepository() != null){
                                                                    repositoryDirec = ref.getRefRepository().getRepositoryDirectory();
                                                                }
                                                            }
                                                            %>
                                                            <tr id="trse<%= se.getId()%>">
                                                                <%
                                                                SWBFormMgr mgr = new SWBFormMgr(se.getSemanticObject(), null, SWBFormMgr.MODE_VIEW);
                                                                for (String idprop : listid) {
                                                                    SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(idprop);
                                                                    %><td><%
                                                                        if (sp.getPropId().equals(Referable.swpdoc_file.getPropId())) {//Propiedad tipo archivo
                                                                            if(ref.getRefRepository() != null){
                                                                                String titleref = ref.getRefRepository().getTitle() != null ? ref.getRefRepository().getTitle() : "";
                                                                                String idfile = ref.getRefRepository().getId();
                                                                                SWBResourceURL urlDownload = new SWBResourceURLImp(request, repositoryDirec.getResource(), repositoryDirec, SWBResourceModes.UrlType_RENDER);
                                                                                urlDownload.setMode(ProcessFileRepository.MODE_GETFILE);
                                                                                urlDownload.setCallMethod(SWBResourceURL.Call_DIRECT);
                                                                                urlDownload.setParameter("fid", idfile);
                                                                                RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                                                                                VersionInfo vi = ref.getVersion() != null ? ref.getVersion() : re.getLastVersion();
                                                                                urlDownload.setParameter("verNum", vi.getVersionNumber() + "");
                                                                                if (re instanceof org.semanticwb.process.model.RepositoryFile) {
                                                                                    %>
                                                                                    <a href="<%= urlDownload%>"><%= titleref%> <i class="fa fa-download"></i></a>
                                                                                    <%
                                                                                } else if (re instanceof RepositoryURL) {
                                                                                    %>
                                                                                    <a href="<%= vi.getVersionFile()%>" target="_blank"><%= titleref%> <i class="fa fa-external-link"></i></a>    
                                                                                    <%
                                                                                }
                                                                            }
                                                                        } else { //Propiedades de texto
                                                                            out.print(mgr.renderElement(request, sp, SWBFormMgr.MODE_VIEW));
                                                                        }
                                                                    %></td><%
                                                                }
                                                                %>
                                                                <td style="width: 130px;" class="text-right">
                                                                    <%
                                                                    if (!isReference) {
                                                                        %>
                                                                        <a class="btn btn-sm btn-default" title="<%=paramRequest.getLocaleString("btnEdit")%>"
                                                                           onclick="showModal('<%= urlEdit.setMode(SWPDocumentationResource.MODE_EDIT_INSTANTIABLE).setParameter("urise", uriSectionElement)%>', '<%=paramRequest.getLocaleString("btnEdit")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                                                                           data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnEdit")%>"
                                                                           >
                                                                            <span class="fa fa-pencil"></span>
                                                                        </a> 
                                                                        <%
                                                                    } else if (se.getDocumentSectionInst() != null
                                                                        && se.getDocumentSectionInst().getDocumentationInstance() != null
                                                                        && se.getDocumentSectionInst().getDocumentationInstance().getProcessRef() != null) {
                                                                        String captureUrl = paramRequest.getWebPage().getUrl(lang);
                                                                        Process pr = se.getDocumentSectionInst().getDocumentationInstance().getProcessRef();
                                                                        %>
                                                                        <a class="btn btn-sm btn-default" href="<%= captureUrl + "?idp=" + pr.getId() + "&pg=" + idpg + "&p=" + pag + "#" + se.getDocumentSectionInst().getId()%>" target="_blank"
                                                                           data-toggle="tooltip" data-placement="bottom" data-original-title="<%= pr.getTitle()%>"
                                                                           >
                                                                            <span class="fa fa-gears"></span>
                                                                        </a>
                                                                        <%
                                                                    }
                                                                    %>
                                                                    <a class="btn btn-sm btn-default" title="<%= paramRequest.getLocaleString("btnRemove")%>"
                                                                       onclick="if (!confirm('<%= paramRequest.getLocaleString("msgDeletePrompt") + " "%>?'))
                                                                                   return false;
                                                                               deleteDocumentSection('<%= urlAction.setParameter("urise", uriSectionElement)%>', 'trse<%= se.getId()%>');
                                                                               return false;"
                                                                       data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("btnRemove")%>"                                                       
                                                                       >
                                                                        <span class="fa fa-trash-o"></span>
                                                                    </a>
                                                                    <a class="btn btn-sm btn-default" title="<%= paramRequest.getLocaleString("btnInfo")%>"
                                                                       onclick="showModal('<%= urlTrace.setParameter("uritc", se.getURI())%>', '<%= se.getTitle()%>', '<%= paramRequest.getLocaleString("msgLoadingElement")%>', '<%= paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
                                                                       data-toggle="tooltip" data-placement="bottom" data-original-title="<%= paramRequest.getLocaleString("btnInfo")%>"
                                                                       >
                                                                        <span class="fa fa-info-circle"></span>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                            <%
                                                        }
                                                        %>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <%
                                        }
                                    } else { //No hay propiedades visibles %>
                                        <div class="alert alert-block alert-warning fade in">
                                            <%=paramRequest.getLocaleString("msgNoSecInfo")%>
                                        </div>
                                        <%
                                    }
                                } else if (cls.equals(FreeText.sclass)) { //FreeText
                                    FreeText ft = (FreeText) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(docSectionInstance.getDocuSectionElementInstance().getURI()); 
                                    hasFreeTextElements = true;
                                    %>
                                    <form method="post" class="form-inline">
                                        <div class="form-row">
                                            <textarea class="freetext" id="<%= ft.getURI()%>" name="<%= docSectionInstance.getURI()%>">
                                                <%out.println(ft.getText());%>
                                            </textarea>
                                        </div>
                                    </form>
                                    <%
                                } else if (cls.equals(Model.sclass)) { //Model 
                                    %>
                                    <h3 class="text-center">Modelo de solo lectura</h3>
                                    <div id="content_modeler"></div>
                                    <script type="text/javascript" src="/swbadmin/jsp/process/modeler/toolkit.js"></script>
                                    <script type="text/javascript" src="/swbadmin/jsp/process/modeler/modeler.js"></script>
                                    <link href="<%=SWBPortal.getContextPath()%>/swbadmin/jsp/process/modeler/images/modelerFrame.css" rel="stylesheet" type="text/css">
                                    <%String svgPath=SWBPortal.getContextPath()+"/swbadmin/jsp/process/modeler/modelerSVG.jsp";%>
                                    <jsp:include page="<%= svgPath %>" flush="true"/>
                                    <script type="text/javascript">
                                        Modeler.init('modeler', {mode: 'view', disableKeyEvents:true, layerNavigation: false}, callbackHandler);
                                        var zoomFactor = 1.1;
                                        var panRate = 50;
                                        //var panRateLR = 50;
                                        function callbackHandler() {
                                            var strJSON = <%= p.getData()%>;
                                            Modeler.loadProcess(strJSON);

                                            Modeler._svgSize = getDiagramSize();
                                            fitToScreen();
                                            var element = $('#modelerContainer').detach();
                                            $('#content_modeler').append(element);
                                            var viewBox = document.getElementById("modeler").getAttribute('viewBox');
                                            console.log(viewBox);
                                            var vi = $('#viewBox');
                                            console.log(vi);
                                            setTimeout(function() {
                                                $('#viewBox').val(viewBox);
                                                fitToScreen();
                                            }, 1000);
                                        }
                                        function zoomin() {
                                            var viewBox = document.getElementById("modeler").getAttribute('viewBox');
                                            var viewBoxValues = viewBox.split(' ');

                                            viewBoxValues[2] = parseFloat(viewBoxValues[2]);
                                            viewBoxValues[3] = parseFloat(viewBoxValues[3]);

                                            viewBoxValues[2] /= zoomFactor;
                                            viewBoxValues[3] /= zoomFactor;

                                            document.getElementById("modeler").setAttribute('viewBox', viewBoxValues.join(' '));

                                        }

                                        function zoomout() {
                                            var viewBox = document.getElementById("modeler").getAttribute('viewBox');
                                            var viewBoxValues = viewBox.split(' ');

                                            viewBoxValues[2] = parseFloat(viewBoxValues[2]);
                                            viewBoxValues[3] = parseFloat(viewBoxValues[3]);

                                            viewBoxValues[2] *= zoomFactor;
                                            viewBoxValues[3] *= zoomFactor;

                                            document.getElementById("modeler").setAttribute('viewBox', viewBoxValues.join(' '));
                                        }

                                        function resetZoom() {
                                            var el = document.getElementById("modeler");
                                            el.setAttribute('viewBox', '0 0 ' + $("#modeler").parent().width() + ' ' + $("#modeler").parent().height());
                                            el.setAttribute('width', '1024');
                                            el.setAttribute('height', '768');
                                        }

                                        function handlePanning(code) {
                                            var viewBox = document.getElementById("modeler").getAttribute('viewBox');
                                            var viewBoxValues = viewBox.split(' ');
                                            viewBoxValues[0] = parseFloat(viewBoxValues[0]);
                                            viewBoxValues[1] = parseFloat(viewBoxValues[1]);

                                            switch (code) {
                                                case 'left':
                                                    viewBoxValues[0] += panRate;
                                                    break;
                                                case 'right':
                                                    viewBoxValues[0] -= panRate;
                                                    break;
                                                case 'up':
                                                    viewBoxValues[1] += panRate;
                                                    break;
                                                case 'down':
                                                    viewBoxValues[1] -= panRate;
                                                    break;
                                            }
                                            document.getElementById("modeler").setAttribute('viewBox', viewBoxValues.join(' '));
                                        }

                                        function getDiagramSize() {
                                            var cw = 0;
                                            var ch = 0;
                                            var fx = null;
                                            var fy = null;
                                            for (var i = 0; i < ToolKit.contents.length; i++) {
                                                var obj = ToolKit.contents[i];
                                                if (obj.typeOf && (obj.typeOf("GraphicalElement") || obj.typeOf("Pool"))) {
                                                    //console.log(obj.id+" - "+obj.elementType);
                                                    if (obj.layer === ToolKit.layer) {
                                                        var lastX = obj.getX() + obj.getWidth() / 2;
                                                        var lastY = obj.getY() + obj.getHeight() / 2;

                                                        if (lastX > cw) {
                                                            cw = lastX;
                                                            fx = obj;
                                                        }

                                                        if (lastY > ch) {
                                                            ch = lastY;
                                                            fy = obj;
                                                        }
                                                    }
                                                }
                                            }
                                            if (fx && fy) {
                                                cw = fx.getX()+fx.getWidth()/2;
                                                ch = fy.getY()+fy.getHeight()/2;
                                            } else {
                                                cw = 1200;
                                                ch = 900;
                                            }

                                            var ret = {w: cw, h: ch};
                                            return ret;
                                        }

                                        function fitToScreen() {
                                            resetZoom();
                                            var ws = $("#modeler").parent().width();
                                            var hs = $("#modeler").parent().height();
                                            var wi = Modeler._svgSize.w;
                                            var hi = Modeler._svgSize.h;

                                            if (wi > ws || hi > hs) {
                                                var el = document.getElementById("modeler");
                                                el.setAttribute('viewBox', '0 0 ' + wi + ' ' + hi);
                                                el.setAttribute('width', ws);
                                                el.setAttribute('height', hs);
                                            }
                                        }
                                        function downloadVersion(format) {
                                            var size = getDiagramSize();
                                            var form = document.getElementById("svgform");
                                            var svg = document.getElementsByTagName("svg")[0];
                                            var svg_xml = (new XMLSerializer).serializeToString(svg);
                                            form['data'].value = svg_xml;
                                            form['format'].value = format;
                                            form['width'].value = size.w;
                                            form['height'].value = size.h;
                                            form.submit();
                                        }
                                    </script>
                                    <form id="svgform" accept-charset="utf-8" method="post" action="<%= urlZip%>">
                                        <input type="hidden" id="format" name="format" value="">
                                        <input type="hidden" name="idp" value="<%= idp%>">
                                        <input type="hidden" name="p" value="<%= p%>">
                                        <input type="hidden" name="width" value="">
                                        <input type="hidden" name="height" value="">
                                        <input type="hidden" id="data" name="data" value="">
                                        <input type="hidden" id="viewBox" name="viewBox" value="">
                                        <input type="hidden" id="taskSelected" name="taskSelected">
                                    </form>
                                    <%
                                } else if (cls.equals(Activity.sclass)) {
                                    hasFreeTextElements = true;
                                    DocumentationInstance.updateActivityFromProcess(p, templateCont, docSectionInstance);
                                    itse = SWBComparator.sortSortableObject(docSectionInstance.listDocuSectionElementInstances());
                                    %>
                                    <div class="table-responsive">
                                        <table class="table table-hover swbp-table">
                                            <thead>
                                                <tr>
                                                    <th style="width: 250px;"><%=paramRequest.getLocaleString("lblTitle")%></th>
                                                    <th><%=paramRequest.getLocaleString("lblDescription")%></th>
                                                    <th style="width: 50px;"><%=paramRequest.getLocaleString("lblRelated")%></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                urlEdit.setParameter("uridsi", docSectionInstance.getURI());
                                                while (itse.hasNext()) {
                                                    SectionElement se = itse.next();
                                                    String titleSectionElement = se.getTitle() != null ? se.getTitle() : "";
                                                    //String descse = se.getDescription() != null ? se.getDescription() : "";
                                                    String uriSectionElement = se.getURI();
                                                    SWBResourceURL urlRelated = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentationResource.MODE_RELATED_ACTIVITY).setParameter("idp", idp).setParameter("uridsi", uriDocSectionInstance);
                                                    Activity act = (Activity) se.getSemanticObject().createGenericInstance();
                                                    String fill = act.getFill() != null ? ("color: #" + act.getFill()) : "";
                                                    SWBResourceURL urlFill = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_UPDATE_FILL);
                                                    String text = act.getDescription() != null ? act.getDescription() : "";
                                                    %>
                                                    <tr>
                                                        <td><%= titleSectionElement%></td>
                                                        <td>
                                                            <%= text%>
                                                            <a class="btn btn-sm btn-default" title="<%=paramRequest.getLocaleString("btnEdit")%>"
                                                               onclick="showModal('<%= urlEdit.setMode(SWPDocumentationResource.MODE_EDIT_DESCRIPTION).setParameter("urise", uriSectionElement).setParameter("d", new Date().getTime() + "")%>', '<%=paramRequest.getLocaleString("btnEdit")%>', '<%=paramRequest.getLocaleString("msgLoadingElement")%>', '<%=paramRequest.getLocaleString("msgLoadError")%>', 'modalDialog');"
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
                                                               data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblRelated")%>"
                                                               >
                                                                <span class="fa fa-link"></span>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                    <%
                                                }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <%
                                }
                                %>
                            </div>
                            <%
                        }
                        %>
                    </div>
                </div>
            </div>
            <script>
                $(document).ready(function() {
                    var hash = window.location.hash.slice(1);
                    if (hash !== '' && $('#dsitab' + hash.length)) {
                        $('#tabcontainerdsi a[href="#dsitab' + hash + '"]').tab('show');
                    } else {
                        $('#tabcontainerdsi a:first').tab('show');
                    }
                    $(window).on('hashchange', function() {
                        var _hash = window.location.hash.slice(1);
                        if (_hash !== '' && $('#dsitab' + _hash.length)) {
                            $('#tabcontainerdsi a[href="#dsitab' + _hash + '"]').tab('show');
                        } else {
                            $('#tabcontainerdsi a:first').tab('show');
                        }
                    });
                });
            </script>
            <%
        }
    }
    if (hasFreeTextElements) {
        %>
        <script type="text/javascript" src="/swbadmin/jsp/process/utils/tinymce/tinymce.min.js"></script>
        <script>
            tinymce.init({
                selector: 'textarea.freetext',
                entity_encoding : "raw",
                save_enablewhendirty: false,
                language: '<%=paramRequest.getUser().getLanguage()%>',
                toolbar: "save | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image table | undo redo code | forecolor backcolor emoticons ",
                menubar: false,
                force_br_newlines: true,
                paste_data_images: true,
                force_p_newlines: true,
                relative_urls: false,
                remove_script_host: false,
                height: 500,
                plugins: [
                    " fullpage save advlist table contextmenu link image textcolor code paste"
                ],
                save_onsavecallback: function(ed) {
                    saveText('<%= urlText%>', ed.getContent(), ed.id, 'linotification', '');
                },
                file_browser_callback: function(field_name, url, type, win) {
                    tinymce.activeEditor.windowManager.open({
                        title: "Cargar archivo",
                        url: "<%= SWBPortal.getContextPath() %>/swbadmin/jsp/process/documentation/uploader.jsp?modelid=<%= wpage.getWebSiteId()%>&urlact=<%= urlUpload%>",
                        width: 600
                    }, {
                        oninsert: function(url, closeDialog) {
                            win.document.getElementById(field_name).value = url;
                            if (closeDialog) {
                                setTimeout(function() {
                                    tinymce.activeEditor.windowManager.close();
                                }, 500);
                            }
                        }
                    });
                }
            });
        </script>
        <%
    }
%>