<%-- 
    Document   : newVersion
    Created on : 10/11/2014, 04:08:26 PM
    Author     : carlos.alvarez
--%>

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
    String uridt = request.getParameter("uridt") != null ? request.getParameter("uridt").toString() : "";
    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    DocumentTemplate dt = (DocumentTemplate) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uridt);
    TemplateContainer tc = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    boolean isEdit = null != dt;
    SWBResourceURL newVersion = paramRequest.getActionUrl().setAction(SWPDocumentTemplateResource.ACTION_ADD_VERSION_TEMPLATE);
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title"><%= null == dt ? "Agregar " : "Propiedades de " %>versión</h5>
        </div>
        <%
        if (null == tc) {
            %>
            <div class="modal-body">
                <p>No se ha podido recuperar la plantilla</p>
            </div>
            <%
        } else {
            DocumentTemplate lastVersion = tc.getLastTemplate();
            if (isEdit) lastVersion = dt;
            if (null != lastVersion) {
                String vComments = isEdit ? lastVersion.getVersionComment() : "";
                if (null == vComments) vComments = "";
                %>
                <form class="form-horizontal swbp-form" action="<%= isEdit ? "#" : newVersion%>" id="formNV">
                    <div class="modal-body">
                        <%
                        if (isEdit) {
                            %>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label">Creador de la versión</label>
                                <div class="col-sm-7">
                                    <p class="form-control-static"><%= dt.getCreator()!=null? dt.getCreator().getFullName() : "" %></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label">Fecha de creación</label>
                                <div class="col-sm-7">
                                    <p class="form-control-static"><%= SWPUtils.DateFormatter.format(dt.getCreated()) %></p>
                                </div>
                            </div>
                            <%
                        } else {
                            %>
                            <input type="hidden" name="uritc" value="<%= tc.getURI() %>"/>
                            <div class="form-group">
                                <label for="" class="col-sm-4 control-label">Versión base *</label>
                                <div class="col-sm-7">
                                    <select name="uridtp" class="form-control" required>
                                        <option value="">Seleccione versión base</option>
                                        <%
                                        Iterator<DocumentTemplate> it = SWBComparator.sortByCreated(tc.listTemplates(), false);
                                        while (it.hasNext()) {
                                            DocumentTemplate _dt = it.next();
                                            %><option value="<%= _dt.getURI() %>"><%= _dt.getVersionValue() %></option><%
                                        }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <%
                        }
                        %>
                        <div class="form-group">
                            <label for="" class="col-sm-4 control-label">Comentarios de la versión</label>
                            <div class="col-sm-7">
                                <%
                                if (isEdit) {
                                    %><p class="form-control-static"><%= vComments %></p><%
                                } else {
                                    %>
                                    <textarea name="description" class="form-control"><%= vComments %></textarea>
                                    <%
                                }
                                %>
                            </div>
                        </div>
                    </div>
                    <%
                    if (!isEdit) {
                        %>
                        <div class="modal-footer">
                            <button id="saveFormVersion" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" type="submit">
                                <span class="fa fa-save fa-fw"></span><span class="hidden-xs"><%=paramRequest.getLocaleString("btnSave")%></span>
                            </button>
                            <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                                <span class="fa fa-arrow-left fa-fw"></span><span class="hidden-xs">Cancelar</span>
                            </button>
                        </div>
                        <script>
                            (function() {
                                var theForm = document.getElementById('formNV');
                                if (!theForm) return;
                                
                                var isSelectValid = function(element) {
                                    if (element.required) {
                                        return !element.validity.valueMissing;
                                    } else {
                                        return element.value && element.value !== "";
                                    }
                                };
                                
                                theForm['uridtp'].addEventListener("change", function(evt) {
                                    if (isSelectValid(evt.target)) {
                                        $(evt.target).closest(".form-group").removeClass("has-error");
                                    } else {
                                        $(evt.target).closest(".form-group").addClass("has-error");
                                    }
                                });
                                
                                theForm.addEventListener('submit', function(evt) {
                                    var valid = isSelectValid(theForm['uridtp']);                           
                                    if (valid) {
                                        $.ajax({
                                            url: $(theForm).attr('action'),
                                            cache: false,
                                            data: $(theForm).serialize(),
                                            type: 'POST',
                                            contentType: "application/x-www-form-urlencoded; charset=utf-8",
                                            success: function(data) {
                                                if (data.status === "ok") {
                                                    window.location.reload(true);
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
                </form>
                <%
            }
        }%>
    </div>
</div>