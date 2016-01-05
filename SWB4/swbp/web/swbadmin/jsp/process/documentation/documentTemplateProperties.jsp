<%-- 
    Document   : viewPeoperties
    Created on : 25/11/2013, 01:46:50 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.process.documentation.model.Instantiable"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.process.documentation.model.Referable"%>
<%@page import="org.semanticwb.process.model.ProcessSite"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.process.documentation.model.Reference"%>
<%@page import="org.semanticwb.process.documentation.model.Definition"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.process.documentation.model.Format"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.process.documentation.model.SectionElement"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.process.model.RepositoryDirectory"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPDocumentTemplateResource.PARAM_REQUEST);
WebSite model = paramRequest.getWebPage().getWebSite();
String lang = "es";
User user = paramRequest.getUser();
if (user != null && user.getLanguage() != null) lang = user.getLanguage();
if (model != null) {
    String uriDocSection = request.getParameter("urids") != null ? request.getParameter("urids") : "";
    DocumentSection docSection = (DocumentSection) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uriDocSection);
    String classUri = request.getParameter("classuri") != null ? request.getParameter("classuri") : "";
    SemanticClass semanticCls = (SemanticClass) SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(classUri);
    if (semanticCls != null && semanticCls.isSubClass(Instantiable.swpdoc_Instantiable, false)) {
        SWBFormMgr forMgr = new SWBFormMgr(semanticCls, model.getSemanticObject(), SWBFormMgr.MODE_EDIT);
        forMgr.clearProperties();
        Iterator<SemanticProperty> itSemProp = semanticCls.listProperties();
        while (itSemProp.hasNext()) {
            SemanticProperty semProperty = itSemProp.next();
            if (semProperty.getDisplayProperty() != null) {
                forMgr.addProperty(semProperty);
            }
        }
        if (semanticCls.isSubClass(Referable.swpdoc_Referable, false)) {
            %>
            <div class="form-group" id="divconfigdata">
                <label for="" class="col-lg-3 control-label"><%=paramRequest.getLocaleString("lblRepository")%><%=docSection==null?" *":""%>:</label>
                <div class="col-lg-9">
                    <%if (docSection != null && docSection.getConfigData() != null){
                        RepositoryDirectory rd = (RepositoryDirectory) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(docSection.getConfigData());
                        if (rd != null) {
                            %>
                            <input type="text" name="configdata" class="form-control" disabled value="<%=rd.getTitle()%>"/>
                            <%
                        }
                    } else {
                        %>
                        <select required="true" id="configdata" class="form-control" name="configdata">
                            <option value=""><%=paramRequest.getLocaleString("lblNoneOption")%></option>
                            <%
                            String titlewp = "";
                            String uriwp = "";
                            ArrayList<RepositoryDirectory> list = new ArrayList<>();
                            Iterator<RepositoryDirectory> itListRep = RepositoryDirectory.ClassMgr.listRepositoryDirectories(model);
                            while (itListRep.hasNext()) {
                                RepositoryDirectory rd = itListRep.next();
                                if(rd.getParent().getTitle().equals("Repository")){
                                list.add(rd);
                                }
                            }
                            for(RepositoryDirectory rdListParent: list){
                                titlewp = rdListParent.getTitle();
                                uriwp = rdListParent.getURI();
                            %>
                                <option value="<%=uriwp%>"><%=titlewp%></option>
                            <%
                            Iterator<WebPage> itChilds = rdListParent.listChilds();
                            while(itChilds.hasNext()){
                                WebPage rdch = itChilds.next();
                                titlewp = rdch.getTitle();
                                uriwp = rdch.getURI();

                                if(rdch instanceof RepositoryDirectory){
                                     %>
                                <option value="<%=uriwp%>"> --<%=titlewp%></option>
                            <%
                                }                     
                            }


                            }

                           %>
                            
                        </select>
                        <%
                    }
                    %>
                </div>
            </div>
            <%
        }
        itSemProp = forMgr.getProperties().iterator();
        if (itSemProp.hasNext()) {
            %>
            <h4><span class="fa fa-check-square-o fa-fw"></span><%=paramRequest.getLocaleString("btnInfo") + " " + paramRequest.getLocaleString("pagDelim") + " " + semanticCls.getDisplayName(lang)%></h4>
            <hr>
            <div class="table-responsive">
                <table class="table table-hover swbp-table">
                    <thead>
                        <tr>
                            <th><%=paramRequest.getLocaleString("lblProperty")%></th>
                            <th><%=paramRequest.getLocaleString("lblLabel")%></th>
                            <th><%=paramRequest.getLocaleString("lblSecActive")%></th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    Map map = new HashMap();
                    if (docSection != null && docSection.getVisibleProperties().length() > 0) {
                        String[] values = docSection.getVisibleProperties().split("\\|");
                        for (int i = 0; i < values.length; i++) {
                            String value = values[i];
                            String title = value.substring(0, value.indexOf(";"));
                            String propId = value.substring((value.indexOf(";") + 1), value.length());
                            map.put(propId, title);
                        }
                    }
            
                    while (itSemProp.hasNext()) {
                        SemanticProperty semProp = itSemProp.next();
                        String titleSemProp = semProp.getDisplayName(lang);
                        String idSemProp = semProp.getPropId();
                        String label = titleSemProp;
                        if (docSection != null && map.containsKey(idSemProp)) {
                            label = map.get(idSemProp).toString();
                        }
                        %>
                        <tr>
                            <td><%=titleSemProp%></td>
                            <td>
                                <input type="text" name="label<%=idSemProp%>" value="<%=label%>" class="form-control">
                            </td>
                            <td class="swbp-icon-center">
                                <input class="form-control" type="checkbox" name="<%=idSemProp%>" <%=(docSection != null && docSection.getVisibleProperties().contains(idSemProp))?"checked":""%>>
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
    }
}
%>