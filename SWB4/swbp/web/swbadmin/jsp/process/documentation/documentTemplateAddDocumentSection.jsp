<%-- 
    Document   : addTemplate
    Created on : 20-ene-2016, 15:35:21
    Author     : hasdai
--%>

<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.process.documentation.model.Activity"%>
<%@page import="org.semanticwb.process.documentation.model.Model"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    SWBResourceURL act = paramRequest.getActionUrl().setAction(SWPDocumentTemplateResource.ACTION_ADD_DOCUMENT_SECTION);
    String uridt = request.getParameter("uridt") != null ? request.getParameter("uridt") : "";
    DocumentTemplate docTemplate = (DocumentTemplate) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridt);
    
    String lang = "es";
    User user = paramRequest.getUser();
    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
%>
<div class="modal-dialog">
    <div class="modal-content swbp-modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Agregar sección</h4>
        </div>
        <%
        if (null == docTemplate) {
            %>
            <div class="modal-body">
                error
            </div>
            <%
        } else {
            boolean hasModel = false;
            boolean hasActivity = false;

            Iterator<DocumentSection> sections = docTemplate.listDocumentSections();
            while (sections.hasNext()) {
                DocumentSection section = sections.next();
                SemanticClass sectionType = section.getSectionType().transformToSemanticClass();
                if (sectionType.getURI().equals(Model.sclass.getURI())) hasModel = true;
                if (sectionType.getURI().equals(Activity.sclass.getURI())) hasActivity = true;
            }
            %>
            <form class="form-horizontal" action="<%= act %>" id="formNDS">
                <input type="hidden" name="uridt" value="<%= docTemplate.getURI() %>"/>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                            <label for="">Título: *</label>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                            <input name="titleSection" id="titltitleSectione" type="text" required class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                            <label for="" class="col-lg-3 control-label"><%=paramRequest.getLocaleString("lblSecType")%>*:</label>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                            <select  required name="dstype" id="dstype" class="form-control">
                                <option value="">Seleccione un tipo</option>
                                <%
                                Iterator<SemanticClass> itSemCls = SWBComparator.sortByDisplayName(SectionElement.sclass.listSubClasses(), lang);
                                while (itSemCls.hasNext()) {
                                    SemanticClass semanticCls = itSemCls.next();
                                    boolean add = true;
                                    if (semanticCls.getURI().equals(Model.sclass.getURI()) && hasModel) {
                                        add = false;
                                    }
                                    if (semanticCls.getURI().equals(Activity.sclass.getURI()) && hasActivity) {
                                        add = false;
                                    }
                                    if (semanticCls.getURI().equals(ElementReference.sclass.getURI())) {
                                        add = false;
                                    }
                                    if (add) {
                                        %><option value="<%=semanticCls.getURI()%>"><%=semanticCls.getDisplayName(lang) %></option><%
                                    }
                                }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="saveFormVersion" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" type="submit">
                    <span class="fa fa-save fa-fw"></span> <%=paramRequest.getLocaleString("btnSave")%></button>
                    <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span>Cancelar</button>
                </div>
            </form>
            <script>
                (function() {
                    var theForm = document.getElementById('formNDS');
                    if (!theForm) return;

                    var isTitleValid = function(element) {
                        if (element.required) {
                            return !element.validity.valueMissing;
                        } else {
                            return element.value && element.value !== "";
                        }
                    };

                    var isSelectValid = function(element) {
                        if (element.required) {
                            return !element.validity.valueMissing;
                        } else {
                            return element.value && element.value !== "";
                        }
                    };

                    theForm['dstype'].addEventListener("change", function(evt) {
                        if (isSelectValid(evt.target)) {
                            $(evt.target).closest(".form-group").removeClass("has-error");
                        } else {
                            $(evt.target).closest(".form-group").addClass("has-error");
                        }
                    });

                    theForm['titleSection'].addEventListener("change", function(evt) {
                        if (isTitleValid(evt.target)) {
                            $(evt.target).closest(".form-group").removeClass("has-error");
                        } else {
                            $(evt.target).closest(".form-group").addClass("has-error");
                        }
                    });

                    theForm.addEventListener('submit', function(evt) {
                        var valid = isTitleValid(theForm['titleSection']) && isSelectValid(theForm['dstype']);                      
                        if (valid) {
                            console.log("valid");
                            $.ajax({
                                url: $(theForm).attr('action'),
                                cache: false,
                                data: $(theForm).serialize(),
                                type: 'POST',
                                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                                success: function(data) {
                                    if (data.status === "ok") {
                                        var loc = '<%= paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setMode(SWPDocumentTemplateResource.MODE_EDIT_DOCUMENT_SECTION) %>?urids='+encodeURIComponent(data.urids);
                                        window.location = loc;
                                    }
                                }
                            });
                        }
                        evt.preventDefault();
                        return false;
                    });
                })();
            </script>
            <%
        }
        %>
    </div>
</div>