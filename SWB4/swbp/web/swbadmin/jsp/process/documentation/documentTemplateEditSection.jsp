<%-- 
    Document   : editSectionDialog
    Created on : 19/11/2013, 01:28:47 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
    String uriDocSection = request.getParameter("urids") != null ? request.getParameter("urids") : "";
    SWBResourceURL urlSave = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWPDocumentTemplateResource.ACTION_ADD_DOCUMENT_SECTION);
    String title = "";
    String lang = "es";
    if (paramRequest.getUser() != null && paramRequest.getUser().getLanguage() != null) lang = paramRequest.getUser().getLanguage();

    DocumentSection documentSection = (DocumentSection) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uriDocSection);
    if (documentSection != null) {
        SWBResourceURL viewUrl = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT);
        viewUrl.setParameter("uridt", documentSection.getParentTemplate().getURI());
        
        SemanticClass sectionType = documentSection.getSectionType().transformToSemanticClass();
        title = documentSection.getTitle();
        urlSave = paramRequest.getActionUrl().setAction(SWPDocumentTemplateResource.ACTION_EDIT_DOCUMENT_SECTION);
        String visibleProps = documentSection.getVisibleProperties();
        if (null == visibleProps) visibleProps = "";
        %>
        <div class="row no-margin swbp-button-ribbon text-right">
            <a href="<%= viewUrl %>" class="btn btn-swbp-action">Volver a la plantilla</a>
        </div>
        <hr>
        <div class="panel panel-default swbp-panel-head">
            <div class="panel-heading text-center"><%= documentSection.getTitle() %></div>
            <form method="post" id="formesd" name="formesd" action="<%= urlSave %>" class="form-horizontal swbp-form">
                <input type="hidden" name="urids" value="<%= uriDocSection %>"/>
                <div class="panel-body swbp-panel-body-card">
                    <div class="form-group" id="divtitletc">
                        <label><h5><%=paramRequest.getLocaleString("lblTitle")%>*:</h5></label>
                        <input type="text" name="titleSection" id="titleSection" required value="<%= title %>" class="form-control"/>
                    </div>
                    <%
                    if (sectionType.isSubClass(Instantiable.swpdoc_Instantiable, false)) {
                        Map map = new HashMap();
                        if (!visibleProps.isEmpty()) {
                            String[] values = documentSection.getVisibleProperties().split("\\|");
                            for (int i = 0; i < values.length; i++) {
                                String value = values[i];
                                String ptitle = value.substring(0, value.indexOf(";"));
                                String propId = value.substring((value.indexOf(";") + 1), value.length());
                                map.put(propId, ptitle);
                            }
                        }
                        %>
                        <div class="form-group">
                            <label><h5>Propiedades</h5></label>
                            <div class="table-responsive-vertical shadow-z-1 swbp-table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th><%=paramRequest.getLocaleString("lblSecActive")%></th>
                                            <th><%=paramRequest.getLocaleString("lblProperty")%></th>
                                            <th><%=paramRequest.getLocaleString("lblLabel")%></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        SWBFormMgr mgr = new SWBFormMgr(sectionType, paramRequest.getWebPage().getWebSite().getSemanticObject(), SWBFormMgr.MODE_EDIT);
                                        mgr.clearProperties();
                                        Iterator<SemanticProperty> properties = sectionType.listProperties();
                                        while (properties.hasNext()) {
                                            SemanticProperty prop = properties.next();
                                            if (prop.getDisplayProperty() != null) mgr.addProperty(prop);
                                        }

                                        properties = mgr.getProperties().iterator();
                                        if (properties.hasNext()) {
                                            while (properties.hasNext()) {
                                                SemanticProperty prop = properties.next();
                                                String titleSemProp = prop.getDisplayName(lang);
                                                String idSemProp = prop.getPropId();
                                                String label = titleSemProp;
                                                if (map.containsKey(idSemProp)) {
                                                    label = map.get(idSemProp).toString();
                                                }
                                                %>
                                                <tr>
                                                    <td data-title="<%=paramRequest.getLocaleString("lblSecActive")%>" class="text-center">
                                                        <input <%=(visibleProps.contains(idSemProp))?"checked":""%> name="<%=idSemProp%>" id="<%=idSemProp%>" type="checkbox" class="css-checkbox">
                                                        <label class="css-label" for="<%= idSemProp%>"></label>
                                                    </td>
                                                    <td data-title="<%=paramRequest.getLocaleString("lblProperty")%>"><%=titleSemProp%></td>
                                                    <td data-title="<%=paramRequest.getLocaleString("lblLabel")%>">
                                                        <input type="text" name="label<%=idSemProp%>" value="<%=label%>" class="form-control">
                                                    </td>
                                                </tr>
                                                <%
                                            }
                                        }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <%
                    }
                    %>
                </div>
                <div class="panel-footer text-right">
                        <button id="savedtes" class="btn btn-default" type="submit">
                            <span class="fa fa-save fa-fw"></span> <%=paramRequest.getLocaleString("btnSave")%>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <%
    }
%>