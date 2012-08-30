<%@page import="com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso"%>
<%@page import="com.infotec.rh.syr.swb.PartidaPresupuesto"%>
<%@page import="com.infotec.rh.syr.swb.CapituloPresupuesto"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="com.infotec.eworkplace.swb.Proyecto"%>
<%@page import="org.semanticwb.portal.SWBForms"%>
<%@page import="org.semanticwb.model.SWBClass"%>
<%@page import="org.semanticwb.process.model.ItemAwareReference"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
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

    //Verificar parámetro para recuperar instancia de tarea
    String suri = request.getParameter("suri");
    if (suri == null) {
        out.println("Parámetro no definido...");
        return;
    }

    //Recuperar instancia de tarea
    FlowNodeInstance foi = (FlowNodeInstance) ont.getGenericObject(suri);

    //Revisar asignación a usuario
    User asigned = foi.getAssignedto();
    if(asigned == null) {
        foi.setAssigned(new Date());
        foi.setAssignedto(user);
    } else if(!asigned.equals(user)) {
        out.println("Tarea asignada previamente a otro usuario...");
        return;
    }

    //Creación e inicialización del formulario de procesos
    SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
    mgr.setAction(paramRequest.getActionUrl().setAction("process").toString());
    mgr.clearProperties();

    //Obtención de objetos de datos
    SolicitudRecurso sr = null;
    SeguimientoSolicitudRecurso ssr = null;
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
    }
    
    SWBResourceURL urlact = paramRequest.getActionUrl();
    urlact.setAction("process");

    //Agregar propiedades particulares al ProcesformMgr
    mgr.addProperty(SeguimientoSolicitudRecurso.intranet_autorizaDirector, varSeguimiento, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SeguimientoSolicitudRecurso.intranet_notaValidaDirector, varSeguimiento, SWBFormMgr.MODE_EDIT);
    
    SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
    %>
    <%=SWBForms.DOJO_REQUIRED%>
    <div id="processForm">
    <form id="<%=foi.getId()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post">
        <input type="hidden" name="suri" value="<%=suri%>"/>
        <input type="hidden" name="smode" value="edit"/>
        <fieldset>
            <table>
                <tr>
                    <td width="200px" align="right"><label for="title">Fecha de solicitud</label>
                    <td>
                        <span><%=foi.getCreated()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">Nombre del solicitante</label>
                    <td>
                        <span><%=foi.getProcessInstance().getCreator().getFullName()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_folio, varSolicitud, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                       <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_folio, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">&Aacute;rea de adscripci&oacute;n</label>
                    <td>
                        <span><%=foi.getProcessInstance().getCreator().getUserGroup().getTitle()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">Jefe inmediato</label>
                    <td>
                        <span>Jefe inmediato</span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_contratacion, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_contratacion, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_motivoContratacion, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_motivoContratacion, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr><td colspan="2"><b>Datos de la asignaci&oacute;n</b></td></tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_proyectoAsignado , varSolicitud, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_proyectoAsignado, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, Proyecto.intranet_areaDelProyecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <span><%=sr.getProyectoAsignado().getAreaDelProyecto()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, Proyecto.intranet_especialidadDelProyecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <span><%=sr.getProyectoAsignado().getEspecialidadDelProyecto()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_capituloSuficiencia, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_capituloSuficiencia, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_partidaSuficiencia, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_partidaSuficiencia, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, Proyecto.intranet_especialidadDelProyecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <span><%=sr.getProyectoAsignado().getUbicacionProyecto()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, Proyecto.intranet_telefonoContacto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <span><%=sr.getProyectoAsignado().getTelefonoContacto()%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, Proyecto.intranet_emailContacto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <span><%=sr.getProyectoAsignado().getEmailContacto()%></span>
                    </td>
                </tr>
                <tr><td colspan="2"><b>Datos del perfil solicitado</b></td></tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_funcionPrincipal, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_funcionPrincipal, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_personalDirecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_personalDirecto, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_personalIndirecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_personalIndirecto, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_salarioMin, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_salarioMin, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_salarioMax, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_salarioMax, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_gradoAcademico, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_gradoAcademico, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_especialidad, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_especialidad, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_avance, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_avance, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_expertise, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_expertise, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_habilidadTalento, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_habilidadTalento, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_aniosExpertise, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_aniosExpertise, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_conocimientoTecnico, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_conocimientoTecnico, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_certificaciones, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_certificaciones, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_hasCompetenciaReq, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_hasCompetenciaReq, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_notaSolicitud, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_notaSolicitud, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_usuarioAutoriza, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_usuarioAutoriza, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SeguimientoSolicitudRecurso.intranet_autorizaDirector, varSeguimiento, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSeguimiento, SeguimientoSolicitudRecurso.intranet_autorizaDirector, SWBFormMgr.MODE_EDIT)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SeguimientoSolicitudRecurso.intranet_notaValidaDirector, varSeguimiento, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSeguimiento, SeguimientoSolicitudRecurso.intranet_notaValidaDirector, SWBFormMgr.MODE_EDIT)%>
                    </td>
                </tr>
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