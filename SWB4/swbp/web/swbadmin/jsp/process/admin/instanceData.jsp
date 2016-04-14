<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.SWBClass"%>
<%@page import="org.semanticwb.process.model.ItemAwareReference"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.model.ProcessInstance"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.process.model.base.ProcessInstanceBase"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
User user = paramRequest.getUser();
GenericObject go = (GenericObject)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
if (null != go) {
    Process p = (Process)go;
    ProcessInstance instance = ProcessInstance.ClassMgr.getProcessInstance(request.getParameter("suripi"), p.getProcessSite());
    if (null != instance) {
        %>
        <div class="swbform">
            <fieldset><legend><%= paramRequest.getLocaleString("docs") + " de la instancia " + instance.getId() %></legend>
                <%
                Iterator<ItemAwareReference> refs = instance.listAllItemAwareReferences();
                if (refs.hasNext()) {
                    %>
                    <ul>
                        <%
                        while (refs.hasNext()) {
                            ItemAwareReference ref = refs.next();
                            SWBClass obj = ref.getProcessObject();
                            if (null != obj) {
                                %>
                                <li>
                                    <%= ref.getItemAware().getDisplayTitle(user.getLanguage()) + "=" %><a href="#" onclick="addNewTab('<%= obj.getURI() %>','<%= SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" %>', '<%= SWBUtils.TEXT.cropText(SWBUtils.TEXT.scape4Script(obj.getSemanticObject().getDisplayName()),25) %>'); return false;"><%= obj.getSemanticObject().getDisplayName() %></a>
                                </li>
                                <%
                            } else {
                                %>
                                <li>
                                    <%= ref.getItemAware().getDisplayTitle(user.getLanguage()) %>
                                </li>
                                <%
                            }
                        }
                        %>
                    </ul>
                    <%
                } else {
                    %>
                    <p>No existen artefactos relacionados con el proceso</p>
                    <%
                }
                %>
            </fieldset>
            <fieldset>
                <%
                SWBResourceURL back = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
                back.setParameter("suri", request.getParameter("suri"));
                %>
                <button dojoType="dijit.form.Button" onclick="submitUrl('<%= back %>',this.domNode); return false;"><%= paramRequest.getLocaleString("btnBack") %></button>
            </fieldset>
        </div>
        <%
    }
}
%>