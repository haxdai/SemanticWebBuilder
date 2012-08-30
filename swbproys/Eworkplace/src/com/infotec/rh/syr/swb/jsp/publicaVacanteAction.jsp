<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="com.infotec.rh.syr.swb.PublicacionVacante"%>
<%@page import="com.infotec.cvi.swb.base.PublicacionBase"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="org.semanticwb.process.model.Instance"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso"%>
<%@page import="org.semanticwb.process.model.SWBProcessFormMgr"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.portal.api.SWBActionResponse"%>
<%
SWBActionResponse aresponse = (SWBActionResponse) request.getAttribute("actionResponse");
String suri = request.getParameter("suri");
String varSolicitud = "solicitudRecurso";
String varSeguimiento = "seguimientoSR";

if ("process".equals(aresponse.getAction())) {
    FlowNodeInstance foi = (FlowNodeInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
    if (suri == null) {
        return;
    }
    SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
    mgr.clearProperties();
    
    aresponse.setRenderParameter("suri", suri);
    try {
        mgr.processForm(request);
        if (request.getParameter("accept") != null) {
            foi.close(aresponse.getUser(), Instance.ACTION_ACCEPT);                    
        } else if (request.getParameter("reject") != null) {
            foi.close(aresponse.getUser(), Instance.ACTION_REJECT);
        }
        request.getSession(true).setAttribute("msg", "redirect");
        response.sendRedirect(foi.getUserTaskInboxUrl());
        return;
    } catch (Exception e) {
        aresponse.setRenderParameter("err", "invalidForm");
    }
} else if ("ADD_PUB".equals(aresponse.getAction())) {
    SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
    String ssrUri = request.getParameter("ssr");
    SeguimientoSolicitudRecurso ssr = (SeguimientoSolicitudRecurso) ont.getGenericObject(ssrUri);
    SWBFormMgr mgr = new SWBFormMgr(PublicacionVacante.sclass, aresponse.getWebPage().getWebSite().getSemanticObject(), null);
    try {
        SemanticObject sobj = mgr.processForm(request);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        PublicacionVacante pv = (PublicacionVacante) sobj.createGenericInstance();
        pv.setArchivoPublicacion(request.getParameter(PublicacionVacante.intranet_archivoPublicacion.getName()));
        pv.setFolioPublicacion(request.getParameter(PublicacionVacante.intranet_folioPublicacion.getName()));
        pv.setFechaPublicacion(df.parse(request.getParameter(PublicacionVacante.intranet_fechaPublicacion.getName())));
        ssr.addPublicacionVacante(pv);
        request.getSession(true).setAttribute("msg", "reload");
    } catch (Exception e) {
        e.printStackTrace();
    }
    aresponse.setRenderParameter("suri", suri);
    aresponse.setMode(aresponse.Mode_VIEW);
}
%>