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

    mgr.addProperty(SolicitudRecurso.intranet_proyectoAsignado, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_funcionPrincipal, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_contratacion, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_capituloSuficiencia, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_partidaSuficiencia, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_sueldoBruto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_fechaInicioContrato, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_fechaFinContrato, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_periodoContrato, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_montoTotal, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_centroDeCosto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_especialidadRecurso, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SeguimientoSolicitudRecurso.intranet_notaConsultaPresupuesto, varSeguimiento, SWBFormMgr.MODE_EDIT);
    
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
}
%>