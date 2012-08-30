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

    mgr.addProperty(SolicitudRecurso.intranet_motivoContratacion, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_personalDirecto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_personalIndirecto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_salarioMin, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_salarioMax, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_gradoAcademico, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_avance, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_especialidad, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_expertise, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_habilidadTalento, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_aniosExpertise, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_sectorExpertise, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_entrevistador, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_conocimientoTecnico, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_certificaciones, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_hasCompetenciaReq, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_notaSolicitud, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_usuarioAutoriza, varSolicitud, SWBFormMgr.MODE_EDIT);
    
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