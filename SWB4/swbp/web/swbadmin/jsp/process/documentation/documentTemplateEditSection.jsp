<%-- 
    Document   : editSectionDialog
    Created on : 19/11/2013, 01:28:47 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.process.documentation.model.FreeText"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.documentation.model.ElementReference"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="row swbp-pad">
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 swbp-raised-button pull-right">
                <a href="<%= viewUrl %>" class="btn btn-block swbp-btn-block" >Volver a la plantilla</a>
            </div>
        </div>
        <hr>
        <div class="panel panel-default swbp-panel-head hidden-margin">
            <div class="panel-heading text-center"><%= documentSection.getTitle() %></div>
            <form method="post" id="formesd" name="formesd" action="<%=urlSave%>">
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
                        if (sectionType.isSubClass(Referable.swpdoc_Referable, false)) {
                                WebPage repo = paramRequest.getWebPage().getWebSite().getWebPage("Repository");
                                RepositoryDirectory currentDir = (RepositoryDirectory) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(documentSection.getConfigData());
                                String options = getRepoOptions((RepositoryDirectory)repo, currentDir, "-");
                                %>
                                <div class="form-group">
                                    <label><%=paramRequest.getLocaleString("lblRepository")%>*</label>
                                    <select required id="configData" class="form-control" name="configData">
                                        <option value="">Seleccione directorio</option>
                                        <% out.print(options); %>
                                    </select>
                                </div>
                                <%
                        }
                        %>
                        <div class="form-group">
                            <label>
                                <h5>Propiedades</h5>
                            </label>
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
                        <%
                    }
                    %>
                </div>
                <div class="panel-footer swbp-mup">
                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-6 swbp-panel-button pull-right">
                        <button id="savedtes" class="btn btn-block" type="submit">
                            <span class="fa fa-save fa-fw"></span> <%=paramRequest.getLocaleString("btnSave")%>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <%
    }
%>