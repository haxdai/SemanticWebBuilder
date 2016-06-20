<%-- 
    Document   : editSectionTemplateBehavior
    Created on : 20/11/2013, 01:13:04 PM
    Author     : carlos.alvarez
--%>

<%@page import="java.util.Iterator"%>
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
<%!
    String getRepoOptions(RepositoryDirectory root, RepositoryDirectory actual, String indentChar) {
        StringBuilder ret = new StringBuilder();
        String idt = indentChar;
        if (null == idt) idt= " ";
        
        if (null != root) {
            ret.append("<option value=\"").append(root.getURI()).append("\"").append((null != actual && root.getURI().equals(actual.getURI()))?" selected":"").append(">").append(idt).append(root.getTitle()).append("</option>");
        }
        Iterator<WebPage> childs = root.listChilds();
        while(childs.hasNext()) {
            WebPage child = childs.next();
            if (child instanceof RepositoryDirectory && child.isValid()) {
                ret.append(getRepoOptions((RepositoryDirectory)child, actual, idt+idt));
            }
        }

        return ret.toString();
    }
%>
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
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h5 class="modal-title"><%= action%></h5>
            </div>
            <form class="form-horizontal swbp-form" method="POST" id="formSE" action="<%= urlAction %>" enctype="multipart/form-data">
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
                                String mode = SWBFormMgr.MODE_CREATE;
                                if (read) {
                                    mode = SWBFormMgr.MODE_VIEW;
                                    %>
                                    <label class="col-sm-4 control-label"><%= sp.getName() %></label>
                                    <div class="col-sm-7"><%= mgr.renderElement(request, sp, mode) %></div>
                                    <%
                                } else {
                                    %>
                                    <div class="form-group" id="div<%= sp.getName() %>">
                                        <label for="" class="col-sm-4 control-label"><%=titleprop%> <%if (required) {%>*<%}%></label>
                                        <div class="col-sm-7">
                                            <%
                                            String inputfm = mgr.renderElement(request, sp, mode);
                                            inputfm = inputfm.replaceFirst(">", " id=\"" + sp.getName() + "\" " + (required ? "required" : "") + " class=\"form-control\">");
                                            inputfm = inputfm.replace("name=\"" + sp.getName() + "\"", "name=\"" + idprop + "\"");
                                            if (inputfm.indexOf("style") > -1) {
                                                inputfm = inputfm.replace(inputfm.substring(inputfm.indexOf("style"), (inputfm.indexOf("px;\"") + 4)), "");
                                            }
                                            out.println(inputfm);
                                            %>
                                        </div>
                                    </div>
                                    <%
                                }
                            } else { //Es un archivo
                                RepositoryDirectory rd = null;
                                Referable ref = null;

                                if (se == null) {//Archivo nuevo
                                    %>
                                    <div class="form-group">
                                        <label for="" class="col-sm-4 control-label"><%=paramRequest.getLocaleString("msgFileType")%></label>
                                        <div class="col-sm-7">
                                            <label class="checkbox-inline">
                                                <input type="radio" id="fileToggleRadio" checked name="hftype" value="file"/> <%=paramRequest.getLocaleString("msgFile")%>
                                            </label>
                                            <label class="checkbox-inline">
                                                <input type="radio" id="urlToggleRadio" name="hftype" value="url"/> <%=paramRequest.getLocaleString("lblLink")%>
                                            </label>
                                        </div>
                                    </div>
                                    <div id="fileSelect" class="form-group">
                                        <label class="col-sm-4 control-label"><%= titleprop%> *</label>
                                        <div class="col-sm-7">
                                            <input type="file" id="ffile" name="ffile" required="true" class="form-control" />
                                        </div>
                                    </div>
                                    <div id="linkSelect" class="row form-group">
                                        <label for="" class="col-sm-4 control-label"><%=paramRequest.getLocaleString("lblLink")%> *</label>
                                        <div class="col-sm-7">
                                            <input type="url" name="lfile" id="lfile" class="form-control" placeholder="http://"/>
                                        </div>
                                    </div>
                                    <%
                                } else { // Es edición 
                                    List<VersionInfo> listvi = null;
                                    VersionInfo vi = null;

                                    if (se instanceof Referable) {
                                        ref = (Referable) se;
                                        if (null != ref.getRefRepository()) {
                                            rd = ref.getRefRepository().getRepositoryDirectory();
                                            String titleref = ref.getRefRepository().getTitle() != null ? ref.getRefRepository().getTitle() : "--";
                                            String idfile = ref.getRefRepository().getId();
                                            RepositoryElement re = (RepositoryElement) ref.getRefRepository();
                                            vi = ref.getRefRepository().getActualVersion();
                                            SWBResourceURL urlDownload = new SWBResourceURLImp(request, rd.getResource(), rd, SWBResourceModes.UrlType_RENDER);
                                            urlDownload.setMode(ProcessFileRepository.MODE_GETFILE).setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("fid", idfile);
                                            urlDownload.setParameter("verNum", vi.getVersionNumber() + "");

                                            listvi = re.listVersions();
                                            %>
                                            <div class="form-group">
                                                <label for="" class="col-sm-4 control-label"><%= titleprop%></label>
                                                <div class="col-sm-7">
                                                    <%
                                                    if (re instanceof org.semanticwb.process.model.RepositoryFile) {
                                                        %><p class="form-control-static"><a href="<%= urlDownload%>"><%= titleref%></a></p><%
                                                    } else if (re instanceof RepositoryURL) {
                                                        %><p class="form-control-static"><a href="<%= vi.getVersionFile()%>" target="_blank"><%= titleref%></a></p><%
                                                    }
                                                    %>
                                                </div>
                                            </div>
                                            <input type="hidden" name="urire" value="<%= re.getURI()%>">
                                            <div class="form-group">
                                                <label for="" class="col-sm-4 control-label"><%= paramRequest.getLocaleString("lblVersionAct")%> *</label>
                                                <div class="col-sm-7">
                                                    <%
                                                    if (null != se) {
                                                        %>
                                                        <p class="form-control-static"><%=vi.getVersionValue()%></p>
                                                        <%
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
                                        }
                                    }
                                    SemanticProperty semPropData = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticPropertyById(DocumentSection.swpdoc_configData.getPropId());
                                    String configData = "";
                                    if (semPropData != null) configData = semPropData.getLabel(lang);

                                    WebPage webpage = (WebPage) model.getWebPage("Repository");
                                    if (null == se) {
                                        %>
                                        <div class="form-group">
                                            <label for="" class="col-sm-4 control-label"><%= configData %> *</label>
                                            <div class="col-sm-7">
                                                <select name="<%= semPropData.getName()%>" id="<%= semPropData.getName()%>" class="form-control" required>
                                                    <%=getRepoOptions((RepositoryDirectory)webpage, null, "-") %>
                                                </select>
                                            </div>
                                        </div>
                                        <%
                                } else if (null != rd) {
                                    %><input type="hidden" name="<%= semPropData.getName()%>" value="<%=rd.getURI() %>"/><%
                                }
                            }
                        }
                    }
                    %>
                </div>
                <div class="modal-footer">
                <input type="hidden" name="props" value="<%= dsi.getSecTypeDefinition().getVisibleProperties()%>">
                <% if (read) {%>
                <input type="hidden" name="read" value="<%= read%>">
                <% }%>
                <input type="hidden" name="uridsi" value="<%= uridsi%>">
                <input type="hidden" name="urise" value="<%= urise%>">
                <%if (!related.equals("view")) {%>
                <button type="submit" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <span class="fa fa-save fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnSave")%></span>
                </button>
                <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                    <span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnCancel")%></span>
                </button>
                    <% } else {
                    %><button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                        <span class="fa fa-save fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnCancel")%></span>
                    </button><%
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