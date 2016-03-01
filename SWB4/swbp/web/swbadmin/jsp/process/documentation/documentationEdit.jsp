<%-- 
    Document   : editSectionTemplateBehavior
    Created on : 20/11/2013, 01:13:04 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.process.model.RepositoryURL"%>
<%@page import="org.semanticwb.portal.api.SWBResourceModes"%>
<%@page import="org.semanticwb.process.resources.ProcessFileRepository"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.process.model.RepositoryElement"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSectionInstance"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentationResource"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentationResource.PARAM_REQUEST);
    WebSite model = paramRequest.getWebPage().getWebSite();
    String lang = paramRequest.getUser().getLanguage();

    String uridsi = request.getParameter("uridsi") != null ? request.getParameter("uridsi").toString() : "";
    String urise = request.getParameter("urise") != null ? request.getParameter("urise").toString() : "";
    DocumentSectionInstance dsi = (DocumentSectionInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridsi);
    SectionElement se = (SectionElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(urise);
    String related = request.getParameter("related") != null ? request.getParameter("related") : "";

    String action = (urise.equals("") ? "Agregar" : "Editar") + " " + (dsi != null && dsi.getSecTypeDefinition() != null && dsi.getSecTypeDefinition().getTitle() != null ? dsi.getSecTypeDefinition().getTitle() : "");

    SWBResourceURL urlAction = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentationResource.ACTION_ADD_INSTANTIABLE);
    boolean read = request.getParameter("read") != null;
    
    SemanticClass scls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(dsi.getSecTypeDefinition().getSectionType().getURI());
    SWBFormMgr mgr = new SWBFormMgr(scls, model.getSemanticObject(), SWBFormMgr.MODE_CREATE);
    if (se != null) {
        mgr = new SWBFormMgr(se.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
        urlAction.setAction(SWPDocumentationResource.ACTION_EDIT_INSTANTIABLE);
    }
%>
    <div class="modal-dialog">
        <div class="modal-content swbp-modal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><%= action%></h4>
            </div>
            <form class="form-horizontal" method="POST" id="formSE" action="<%= urlAction %>" enctype="multipart/form-data">
                <%out.print(mgr.getFormHiddens());%>
                <div class="modal-body">
                <%
                String[] propst = dsi.getSecTypeDefinition().getVisibleProperties().split("\\|");
                for (String props : propst) {
                    if (null != props && !props.isEmpty()) {
                        String titleprop = props.substring(0, props.indexOf(";"));
                        String idprop = props.substring(props.indexOf(";") + 1, props.length());
                        SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(idprop);
                        boolean required = sp != null && sp.isRequired();
                        
                        if (!sp.getPropId().equals(Referable.swpdoc_file.getPropId())) {// Input y TextArea
                            %>
                            <div class="form-group" id="div<%=sp.getName()%>">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                    <label for=""><%=titleprop%> <%if (required) {%>*<%}%></label>
                                </div>
                                <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
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
                            
                            if (se == null) {//Archivo nuevo
                                %>
                                <div class="form-group">
                                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                        <label><%=paramRequest.getLocaleString("msgFileType")%></label>
                                    </div>
                                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                            <input class="css-checkbox" type="radio" id="fileToggleRadio" checked name="hftype" value="file">
                                            <label class="css-label" for="fileToggleRadio"><span><%=paramRequest.getLocaleString("msgFile")%></span></label>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                            <input class="css-checkbox" type="radio" id="urlToggleRadio" name="hftype" value="url"> 
                                            <label class="css-label" for="urlToggleRadio"><%=paramRequest.getLocaleString("lblLink")%></label>
                                        </div>
                                    </div>
                                </div>
                                <div id="fileSelect" class="form-group">
                                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                        <label for=""><%= titleprop%> *</label>
                                    </div>
                                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                        <input type="file" id="ffile" name="ffile" required="true" class="form-control" />
                                    </div>
                                </div>
                                <div id="linkSelect" class="row form-group">
                                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                        <label for=""><%=paramRequest.getLocaleString("lblLink")%> *</label>
                                    </div>
                                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                        <input type="text" name="lfile" id="lfile" class="form-control" placeholder="http://"/>
                                    </div>
                                </div>
                                <%
                            } else { // Es edici�n 
                                List<VersionInfo> listvi = null;
                                VersionInfo vi = null;
                                %>
                                <div class="form-group">
                                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                        <label for=""><%= titleprop%></label>
                                    </div>
                                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                        <%
                                        if (se instanceof Referable) {
                                            ref = (Referable) se;
                                            rd = ref.getRefRepository().getRepositoryDirectory();
                                        }
                                        String titleref = ref.getRefRepository().getTitle() != null ? ref.getRefRepository().getTitle() : "--";
                                        String idfile = ref.getRefRepository().getId();
                                        RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                                        vi = ref.getVersion() != null ? ref.getVersion() : re.getLastVersion();
                                        SWBResourceURL urlDownload = new SWBResourceURLImp(request, rd.getResource(), rd, SWBResourceModes.UrlType_RENDER);
                                        urlDownload.setMode(ProcessFileRepository.MODE_GETFILE).setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("fid", idfile);
                                        urlDownload.setParameter("verNum", vi.getVersionNumber() + "");

                                        listvi = re.listVersions();

                                        if (re instanceof org.semanticwb.process.model.RepositoryFile) {
                                            %><a href="<%= urlDownload%>"><%= titleref%></a><%
                                        } else if (re instanceof RepositoryURL) {
                                            %><a href="<%= vi.getVersionFile()%>" target="_blank"><%= titleref%></a><%
                                        }
                                        %>
                                    </div>
                                </div>
                                <input type="hidden" name="urire" value="<%= re.getURI()%>">
                                <div class="form-group">
                                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                        <label for=""><%= paramRequest.getLocaleString("lblVersionAct")%> *</label>
                                    </div>
                                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                        <%
                                        if (read) {
                                            out.print(vi.getVersionNumber());
                                        } else {
                                            %>
                                            <select name="versionref" id="versionref" class="form-control" required="true">
                                                <% for (VersionInfo vit : listvi) {%>
                                                <option value="<%= vit.getURI()%>" <%if (vi != null && vi.equals(vit)) {%> selected="true"<%}%>><%= vit.getVersionValue()%></option>
                                                <%}%>
                                            </select>
                                            <%
                                        }
                                        %>
                                    </div>
                                </div>
                                <%
                            }
                SemanticProperty semPropData = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(DocumentSection.swpdoc_configData.getPropId());
                String configData = "";
                if (semPropData != null) {
                    configData = semPropData.getLabel(lang);
                }
//TODO: change repository list method
                WebPage webpage = (WebPage) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(dsi.getSecTypeDefinition().getConfigData());
                List<RepositoryDirectory> list = SWPDocumentationResource.listRepositoryDerectoryByParent(webpage, true);
                %>
                <div class="form-group">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                        <label for=""><%= configData%> *</label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                        <%if (read) {
                                out.print(rd.getTitle());
                            } else {%>
                        <select name="<%= semPropData.getName()%>" id="<%= semPropData.getName()%>" class="form-control" required>
                            <option value=" ">Seleccione repositorio</option>
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
                <%if (!related.equals("view")) {%>
                <button type="submit" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6"><span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("btnSave")%></button>
                <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></button>
                    <% } else {
                    %><button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></button><%
                        }%>
            </div>
        </form>
    </div>
</div>
<iframe style="display:none;" name="fUploadFrame" id="fUploadFrame"></iframe>
<script>
    (function () {
        var isFile = true;
        var isFileType = function(pFile) {
          return true;  
        };

        /*var isFileType = function(pFile) {
            if (pFile && pFile.length && pFile.lastIndexOf(".") === -1) return false;
            var exts = '< validFiles %>'.split("|"), valid = false, fext;

            fext = pFile && pFile.length && pFile.slice(pFile.lastIndexOf("."), pFile.length);
            if (pFile && pFile.length > 0) {
                exts.forEach(function(e) {
                   if (fext.toLowerCase() === e) valid = true;
                });
            }
            return valid;
        };*/

        $(document).ready(function() {
            var theForm = document.getElementById('formSE');
            var theType = document.getElementById('hftype');
            if (theType) isFile = ("url" !== theType.value);

            var isElementValid = function(element) {
                if (element.required) {
                    return !element.validity.valueMissing;
                } else {
                    return element.value && element.value !== "";
                }
            };

            var isFileValid = function(element) {
                return (element.value && element.value.length > 0 && isFileType(element.value));
            };
            
            //Add event handlers
            for (var es = theForm.elements, v = 0; v < theForm.elements.length; v++) {
                if (es[v].required) {
                    if (es[v].tagName === "INPUT" || es[v].tagName === "TEXTAREA" || es[v].tagName === "SELECT") {
                        if (es[v].tagName === "SELECT") {
                            es[v].addEventListener("change", function(evt) {
                                if (isElementValid(evt.target)) {
                                    $(evt.target).closest(".form-group").removeClass("has-error");
                                } else {
                                    $(evt.target).closest(".form-group").addClass("has-error");
                                }
                            });
                        } else {
                            if (es[v].type && es[v].type !== "file") {
                                es[v].addEventListener("keyup", function(evt) {
                                    if (isElementValid(evt.target)) {
                                        $(evt.target).closest(".form-group").removeClass("has-error");
                                    } else {
                                        $(evt.target).closest(".form-group").addClass("has-error");
                                    } 
                                });
                            } else {
                                es[v].addEventListener("change", function(evt) {
                                    if (isFileValid(evt.target)) {
                                        $(evt.target).closest(".form-group").removeClass("has-error");
                                    } else {
                                        $(evt.target).closest(".form-group").addClass("has-error");
                                    }
                                });
                            } 
                        }
                    }
                }
            }

            if (null !== theForm) {
                $(theForm).on("submit", function(evt) {
                    var isValid = true;
                    var elements = theForm.elements;
                    for (var i = 0; i < elements.length; i++) {
                        if (elements[i].required && !isElementValid(elements[i])) {
                            isValid = false;
                            $(elements[i]).closest(".form-group").addClass("has-error");
                        } else {
                            $(elements[i]).closest(".form-group").removeClass("has-error");
                        }
                    }
                    
                    if (isValid) {
                        if (isFile) {
                            $("#fUploadFrame").on("load", function() {
                                var data = JSON.parse($("#fUploadFrame").contents().text());
                                if (data && data.status === "ok") {
                                    window.top.location.reload();
                                }
                            });

                            //submit form files
                            theForm.target = "fUploadFrame";
                            theForm.submit();
                        } else {
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
                        }
                    }
                    evt.preventDefault();
                    return false;
                });
            }

            $("#fileToggleRadio").on("click", function(evt) {
                $("#fileSelect").show();
                $("#linkSelect").hide();
                $("#lfile").removeProp("required");
                $("#ffile").attr("required", true);
                isFile = true;
            });

            $("#urlToggleRadio").on("click", function(evt) {
                $("#fileSelect").hide();
                $("#linkSelect").show();
                $("#lfile").attr("required", true);
                $("#ffile").removeProp("required");
                isFile = false;
            });

            $("#fileSelect").show();
            $("#linkSelect").hide();
            isFile && $("#ffile").attr("required", true);
            !isFile && $("#lfile").removeProp("required");
        });
    })();
</script>