<%-- 
    Document   : logView
    Created on : 13/12/2013, 04:24:31 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.model.DocumentSection"%>
<%@page import="org.semanticwb.process.documentation.resources.utils.SWPUtils"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.documentation.resources.SWPDocumentTemplateResource"%>
<%@page import="org.semanticwb.process.documentation.model.DocumentTemplate"%>
<%@page import="org.semanticwb.process.documentation.model.TemplateContainer"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.Template"%>
<%@page import="java.util.Locale"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.model.Descriptiveable"%>
<%@page import="org.semanticwb.model.base.DescriptiveableBase"%>
<%@page import="org.semanticwb.model.Traceable"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");

    String uritc = request.getParameter("uritc") != null ? request.getParameter("uritc").toString() : "";
    TemplateContainer tc = (TemplateContainer) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(uritc);
    SWBResourceURL admVersion = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_EDIT_VERSION_TEMPLATE).setParameter("uritc", uritc);
    SWBResourceURL editVersion = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWPDocumentTemplateResource.MODE_EDIT_VERSION_TEMPLATE).setParameter("uritc", uritc);
    SWBResourceURL urlAction = paramRequest.getActionUrl().setAction(SWPDocumentTemplateResource.ACTION_DEFINE_VERSION_TEMPLATE).setParameter("uritc", uritc);
    SWBResourceURL urlActionRemove = paramRequest.getActionUrl().setAction(SWPDocumentTemplateResource.ACTION_REMOVE_VERSION_TEMPLATE).setParameter("uritc", uritc);
    String lang = "es";
    User user = paramRequest.getUser();
    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
    Locale loc = new Locale(lang);
    DateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss", loc);
    if (tc != null) {
        %>
        <div class="row swbp-pad">
            <div class="col-lg-3 col-lg-offset-6 col-md-3 col-md-offset-6 col-sm-4 col-sm-offset-4 col-xs-12 swbp-raised-button">
                <a href="<%= paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT).setParameter("uritc", tc.getURI()) %>" class="btn btn-block swbp-btn-block" >Volver a la plantilla</a>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 swbp-raised-button">
                <a href="<%= admVersion.setParameter("uritc", tc.getURI())%>" class="btn btn-block swbp-btn-block" data-toggle="modal" data-target="#modalDialog">Agregar versión</a>
            </div>
        </div>
        <hr>
        <div class="panel panel-default swbp-panel-head">
            <div class="panel-heading text-center">Versiones de plantilla</div>
        </div>
        <%
        Iterator<DocumentTemplate> it = tc.listTemplates();
        if (null == tc || !it.hasNext()) {

        } else {
            int i = 0;

            while (it.hasNext()) {
                it.next();
                i++;
                if (i > 1) {
                    break;
                }
            }
            it = SWBComparator.sortByCreated(tc.listTemplates(), false);
            while (it.hasNext()) {
                DocumentTemplate dt = it.next();
                boolean actual = tc.getActualTemplate().getURI().equals(dt.getURI());
                %>
                <div class="swbp-list-element">
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 swbp-list-title">
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 swbp-list-number"><%= dt.getVersionValue() %></div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-10 swbp-list-text"><%= dt.getVersionComment() !=null ? dt.getVersionComment() : "" %></div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-sm-offset-0 col-xs-10 col-xs-offset-2 swbp-list-date"><%= SWPUtils.DateFormatter.format(dt.getCreated()) %></div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 swbp-list-action">
                        <a href="<%= paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT).setParameter("uridt",dt.getURI()).setParameter("uritc", tc.getURI()) %>" class="btn btn-default col-xs-3 fa fa-pencil"></a>
                        <%
                        if (!actual) {
                            %><a href="<%= urlAction.setParameter("uridt", dt.getURI())%>" class="btn btn-default col-xs-3 fa fa-retweet" onclick="if (!confirm('¿Desea hacer versión <%= dt.getVersionValue() %> la versión actual?')) return false;"></a><%
                        } else {
                            %><a href="#" class="btn btn-default col-xs-3 fa fa-check-square-o disabled active"></a><%
                        }
                        %>
                        <a href="<%= admVersion.setParameter("uridt", dt.getURI())%>" class="btn btn-default col-xs-3 fa fa-info-circle" data-toggle="modal" data-target="#modalDialog"></a>
                        <a href="<%= !actual ? urlActionRemove.setParameter("uridt", dt.getURI()) : "#" %>" class="btn btn-default col-xs-3 fa fa-trash-o <%= actual ? "disabled" : "" %>" <% if (!actual) {%>onclick="if (!confirm('¿Seguro desea eliminar versión <%= dt.getVersionValue() %>?')) return false;" <%}%>></a>
                    </div>
                </div> 
                <%
            }
        }
    }
%>