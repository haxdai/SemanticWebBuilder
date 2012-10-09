<%@page import="com.infotec.rh.syr.swb.Postulante"%>
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
} else if ("ADD_POS".equals(aresponse.getAction())) {
    SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
    String ssrUri = request.getParameter("sr");
    SolicitudRecurso sr = (SolicitudRecurso) ont.getGenericObject(ssrUri);
    SWBFormMgr mgr = new SWBFormMgr(Postulante.sclass, aresponse.getWebPage().getWebSite().getSemanticObject(), null);
    try {
        SemanticObject sobj = mgr.processForm(request);
        Postulante pos = (Postulante) sobj.createGenericInstance();
        pos.setNombrePostulante(request.getParameter(Postulante.intranet_nombrePostulante.getName()));
        pos.setEmailPostulante(request.getParameter(Postulante.intranet_emailPostulante.getName()));
        
        String flag1 = request.getParameter(Postulante.intranet_cumplePerfil.getName());
        String flag2 = request.getParameter(Postulante.intranet_inhabilitadoSFP.getName());
        if (flag1 != null && (flag1.trim().equals("true") || flag1.trim().equals(""))) {
            pos.setCumplePerfil(true);
        }
        if (flag2 != null && (flag2.trim().equals("true") || flag2.trim().equals(""))) {
            pos.setInhabilitadoSFP(true);
        }
        sr.addPostulante(pos);
        request.getSession(true).setAttribute("msg", "reload");
    } catch (Exception e) {
        e.printStackTrace();
    }
    aresponse.setRenderParameter("suri", suri);
    aresponse.setMode(aresponse.Mode_VIEW);
}
%>