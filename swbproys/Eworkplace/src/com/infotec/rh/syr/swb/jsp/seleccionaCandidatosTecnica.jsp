<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.infotec.eworkplace.swb.Telefono"%>
<%@page import="com.infotec.eworkplace.swb.Persona"%>
<%@page import="com.infotec.rh.syr.swb.SeguimientoCandidato"%>
<%@page import="org.semanticwb.process.model.UserTask"%>
<%@page import="com.infotec.rh.syr.swb.Postulante"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="com.infotec.rh.syr.swb.PublicacionVacante"%>
<%@page import="com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso"%>
<%@page import="com.infotec.rh.syr.swb.PartidaPresupuesto"%>
<%@page import="com.infotec.rh.syr.swb.CapituloPresupuesto"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="com.infotec.eworkplace.swb.Proyecto"%>
<%@page import="org.semanticwb.portal.SWBForms"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.SWBClass"%>
<%@page import="org.semanticwb.model.FormElement"%>
<%@page import="org.semanticwb.process.model.ItemAwareReference"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.process.model.SWBProcessFormMgr"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
User user = paramRequest.getUser();
WebSite site = paramRequest.getWebPage().getWebSite();
SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
String varSolicitud = "solicitudRecurso";
String varSeguimiento = "seguimientoSR";
String varPregunta = "bEncontroCandidatoCompetencias";
String varArchivoSolicitud = "archivoSolicitud";

//Verificar parámetro para recuperar instancia de tarea
String suri = request.getParameter("suri");
if (suri == null) {
    out.println("Parámetro no definido...");
    return;
}

//Recuperar instancia de tarea
FlowNodeInstance foi = (FlowNodeInstance) ont.getGenericObject(suri);

 //Validar redirección
if (null != request.getSession(true).getAttribute("msg")) {
    String message = (String) request.getSession(true).getAttribute("msg");
    if (message.equals("redirect")) {
        request.getSession(true).removeAttribute("msg");
        response.sendRedirect(foi.getUserTaskInboxUrl());
        return;
    } else if (message.equals("reload")) {
        request.getSession(true).removeAttribute("msg");
        UserTask ut = (UserTask) foi.getFlowNodeType();
        response.sendRedirect(ut.getTaskWebPage().getUrl()+"?suri="+foi.getEncodedURI());
        return;
    }
}

//Revisar asignación a usuario
User asigned = foi.getAssignedto();
if(asigned == null) {
    foi.setAssigned(new Date());
    foi.setAssignedto(user);
} else if(!asigned.equals(user)) {
    out.println("Tarea asignada previamente a otro usuario...");
    return;
}

//Obtención de objetos de datos
SolicitudRecurso sr = null;
SeguimientoSolicitudRecurso ssr = null;
org.semanticwb.process.schema.Boolean pregunta = null;
org.semanticwb.process.schema.File archivoSol = null;
Iterator<ItemAwareReference> it = foi.listHeraquicalItemAwareReference().iterator();
while (it.hasNext()) {
    ItemAwareReference ref = it.next();
    SWBClass obj = ref.getProcessObject();
    if (ref.getItemAware().getName().equals(varSolicitud)) {
        sr = (SolicitudRecurso)obj;
    }
    if (ref.getItemAware().getName().equals(varSeguimiento)) {
        ssr = (SeguimientoSolicitudRecurso)obj;
    }
    if (ref.getItemAware().getName().equals(varPregunta)) {
        pregunta = (org.semanticwb.process.schema.Boolean)obj;
    }
    if (ref.getItemAware().getName().equals(varArchivoSolicitud)) {
        archivoSol = (org.semanticwb.process.schema.File)obj;
    }
}

//Creación e inicialización del formulario de procesos
SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
mgr.setAction(paramRequest.getActionUrl().setAction("process").toString());
mgr.clearProperties();

mgr.addProperty(SeguimientoSolicitudRecurso.intranet_concluyeSeleccionCompetencias, varSeguimiento, SWBFormMgr.MODE_EDIT);
mgr.addProperty(org.semanticwb.process.schema.Boolean.swps_booleanValue, varPregunta, SWBFormMgr.MODE_EDIT);

SWBResourceURL urlact = paramRequest.getActionUrl();
urlact.setAction("process");

SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
%>
<%=SWBForms.DOJO_REQUIRED%>
<div id="processForm">
    <form id="<%=foi.getId()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post">
        <input type="hidden" name="suri" value="<%=suri%>"/>
        <input type="hidden" name="smode" value="edit"/>
        <input type="hidden" name="sr" value="<%=sr.getId()%>"/>
        <fieldset>
            <table>
                <tr><td colspan="2"><b>Datos de Generales</b></td></tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_funcionPrincipal, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_funcionPrincipal, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_folio, varSolicitud, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                    <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_folio, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, org.semanticwb.process.schema.File.swp_repositoryFileRef, varArchivoSolicitud, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                    <%=fmgr.renderElement(request, varArchivoSolicitud, org.semanticwb.process.schema.File.swp_repositoryFileRef, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr><td colspan="2"><b>Candidatos</b></td></tr>
                <tr>
                    <td colspan="2">
                        <%
                        Iterator<User> pos = sr.listCandidatos();
                        if (pos.hasNext()) {
                            %>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Nombre del candidato</th>
                                        <th>Calificaci&oacute;n en psicométrico</th>
                                        <th>Calificaci&oacute;n competencias</th>
                                        <th>Continua entrevista t&eacute;cnica</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    while (pos.hasNext()) {
                                        User po = pos.next();
                                        String nombre = "Sin nombre";

                                        SeguimientoCandidato sc = null;
                                        Iterator<SeguimientoCandidato> it_seg = SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(po, site);
                                        while (it_seg.hasNext()) {
                                            SeguimientoCandidato seg = it_seg.next();
                                            if (seg.getSolicitudCandidato() != null && seg.getSolicitudCandidato().equals(sr)) {
                                                sc = seg;
                                                break;
                                            }
                                        }
                                        if (po.getFullName() != null) nombre = po.getFullName();

                                        if (sc.isApruebaEntrevistaTelefonica() && sc.isRealizoPsicometrico() && sc.isApruebaCompetencias()) {
                                            %>
                                            <tr>
                                                <td><%=nombre%></td>
                                                <td><span><%=sc.getPorcentajePsicometrico()%>%</span></td>
                                                <td><span><%=sc.getPorcentajeCompetencias()%>%</span></td>
                                                <td><input type="checkbox" dojoType="dijit.form.CheckBox" <%=sc.isPasaEntrevistaTecnica()?"checked":""%> name="selUsers" value="<%=po.getId()%>"/></td>
                                            </tr>
                                            <%
                                        }
                                    }
                                    %>
                                </tbody>
                            </table>
                            <%
                        } else {
                            %><span>No hay postulantes</span><br><%
                        }
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, org.semanticwb.process.schema.Boolean.swps_booleanValue, varPregunta, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                        <%
                        SemanticObject sofe = ont.getSemanticObject("http://www.semanticwebbuilder.org/swb4/xforms/ontology#BooleanElement_1");
                        if (null != sofe) {
                            FormElement frme = (FormElement) sofe.createGenericInstance();
                            %><%=fmgr.renderElement(request, varPregunta, org.semanticwb.process.schema.Boolean.swps_booleanValue, frme, SWBFormMgr.MODE_EDIT)%><%
                        } else {
                            %><%=fmgr.renderElement(request, varPregunta, org.semanticwb.process.schema.Boolean.swps_booleanValue, SWBFormMgr.MODE_EDIT)%><%
                        }
                        %>
                    </td>
                    <!--td>
                    <%=fmgr.renderElement(request, varPregunta, org.semanticwb.process.schema.Boolean.swps_booleanValue, SWBFormMgr.MODE_EDIT)%>
                    </td-->
                </tr>
                <!--tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SeguimientoSolicitudRecurso.intranet_concluyeSeleccionCompetencias, varSeguimiento, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                    <%=fmgr.renderElement(request, varSeguimiento, SeguimientoSolicitudRecurso.intranet_concluyeSeleccionCompetencias, SWBFormMgr.MODE_EDIT)%>
                    </td>
                </tr-->
            </table>
        </fieldset>
        <fieldset>
            <span align="center">
            <button dojoType="dijit.form.Button" type="submit">Guardar</button>
            <button dojoType="dijit.form.Button" name="accept" type="submit">Concluir Tarea</button>
            <button dojoType="dijit.form.Button" name="reject" type="submit">Rechazar Tarea</button>
            <button dojoType="dijit.form.Button" onclick="window.location='<%=foi.getUserTaskInboxUrl()%>?suri=<%=suri%>'">Regresar</button>
            </span>
        </fieldset>
    </form>
</div>
