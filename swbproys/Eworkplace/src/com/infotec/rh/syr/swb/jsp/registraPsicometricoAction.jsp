<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.rh.syr.swb.SeguimientoCandidato"%>
<%@page import="org.semanticwb.model.User"%>
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
    if (suri == null) {
        return;
    }
    FlowNodeInstance foi = (FlowNodeInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
    
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
} else if ("SET_PSICO".equals(aresponse.getAction())) {
    User candidato = aresponse.getWebPage().getWebSite().getUserRepository().getUser(request.getParameter("po"));
    if (candidato != null) {
        SolicitudRecurso sr = SolicitudRecurso.ClassMgr.getSolicitudRecurso(request.getParameter("sr"), aresponse.getWebPage().getWebSite());
        
        SeguimientoCandidato sc = null;
        Iterator<SeguimientoCandidato> it_seg = SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(candidato, aresponse.getWebPage().getWebSite());
        while (it_seg.hasNext()) {
            SeguimientoCandidato seg = it_seg.next();
            if (seg.getSolicitudCandidato().equals(sr)) {
                sc = seg;
                break;
            }
        }
        
        if (request.getParameter("donePsico") != null) {
            sc.setRealizoPsicometrico(true);
        } else {
            sc.setRealizoPsicometrico(false);
        }
        
        if (request.getParameter("viable") != null) {
            sc.setViablePsicometrico(true);
        } else {
            sc.setViablePsicometrico(false);
        }
        
        if (request.getParameter("apego") != null) {
            try {
                Float ap = Float.parseFloat(request.getParameter("apego"));
                sc.setPorcentajePsicometrico(ap);
            } catch (Exception e) {
                sc.setPorcentajePsicometrico(0f);
                e.printStackTrace();
            }
        }
    }
    aresponse.setRenderParameter("suri", suri);
    aresponse.setMode(aresponse.Mode_VIEW);
    request.getSession(true).setAttribute("msg", "reload");
}
%>