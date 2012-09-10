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
String varPregunta = "bSeEncontroGanador";
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

//Manejo de peticiones directas
if (paramRequest.getCallMethod() == SWBParamRequest.Call_DIRECT) {
    String act = paramRequest.getAction();
    String ret = "";
    
    if (act.equals("DO_OBS")) {
        User candidato = site.getUserRepository().getUser(request.getParameter("po"));
        
        if (candidato != null) {
            SeguimientoCandidato sc = null;
            Iterator<SeguimientoCandidato> it_seg = SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(candidato, site);
            while (it_seg.hasNext()) {
                SeguimientoCandidato seg = it_seg.next();
                if (seg.getSolicitudCandidato() != null && seg.getSolicitudCandidato().equals(sr)) {
                    sc = seg;
                    break;
                }
            }
            Persona persona = Persona.ClassMgr.getPersona(candidato.getId(), site);
            
            String telefonos = "";
            Iterator<Telefono> itt = persona.listTelefonos();
            while(itt.hasNext()) {
                Telefono tel = itt.next();
                telefonos += tel.getLada() + tel.getNumero();
                if (tel.getExtension() != 0) telefonos += " ext. "+tel.getExtension();
                if (itt.hasNext()) telefonos += ", ";
            }
            
            String verCVURL = site.getWebPage("Ver_Curriculum").getUrl();
            %>
            <%=SWBForms.DOJO_REQUIRED%>
            <div id="processForm">
                <form id="<%=foi.getId()%>/formEntrevista" dojoType="dijit.form.Form" class="swbform" action="" method="post">
                    <fieldset>
                        <table>
                            <tr>
                                <td width="200px" align="right"><label for="title">Nombre</label></td>
                                <td>
                                    <%=candidato.getFullName()%>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Tel&eacute;fonos</label>
                                <td>
                                    <%=telefonos%>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Curriculum de INFOTEC</label>
                                <td>
                                    <a target="_blank" href="<%=verCVURL%>?id=<%=candidato.getId()%>">CVI <%=candidato.getFullName()%></a>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Observaciones entrevista telef&oacute;nica</label>
                                <td>
                                    <textarea name="nota"><%=sc.getObservacionesEntrevistaTelefonica()!= null?sc.getObservacionesEntrevistaTelefonica():""%></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Observaciones entrevista por competencias</label>
                                <td>
                                    <textarea name="nota"><%=sc.getNotasCompetencia()!= null?sc.getNotasCompetencia():""%></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Notas sobre experiencia</label>
                                <td>
                                    <textarea name="nota"><%=sc.getNotaExperienciaCompetencias()!= null?sc.getNotaExperienciaCompetencias():""%></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Notas sobre entrevista t&eacute;cnica</label>
                                <td>
                                    <textarea name="nota"><%=sc.getObservacionesTecnica()!= null?sc.getObservacionesTecnica():""%></textarea>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset>
                        <span align="center">
                        <button dojoType="dijit.form.Button" onclick="hideDialog('addDialog_<%=foi.getId()%>');">Regresar</button>
                        </span>
                    </fieldset>
                </form>
            </div>
            <%
        }
    }
    out.print(ret);
    out.flush();
    return;
} else {
    //Creación e inicialización del formulario de procesos
    SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
    mgr.setAction(paramRequest.getActionUrl().setAction("process").toString());
    mgr.clearProperties();
    
    mgr.addProperty(SeguimientoSolicitudRecurso.intranet_concluyeSeleccionTecnica, varSeguimiento, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(org.semanticwb.process.schema.Boolean.swps_booleanValue, varPregunta, SWBFormMgr.MODE_EDIT);

    SWBResourceURL urlact = paramRequest.getActionUrl();
    urlact.setAction("process");

    SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
    %>
    <script>
        dojo.require("dijit.Dialog");
        function showFormDialog(url) {            
            var dialog = dijit.byId('addDialog_<%=foi.getId()%>');
            dialog.attr('href', url);
            dialog.show();
        }
        
        function hideDialog(id) {
            var dialog = dijit.byId(id);
            dialog.hide();
        }
    </script>
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
                                            <th>Prueba psicom&eacute;trica</th>
                                            <th>Entrevista por competencias</th>
                                            <th>Entrevista t&eacute;cnica</th>
                                            <th>Candidato seleccionado</th>
                                            <th></th>
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

                                            if (sc.isApruebaEntrevistaTelefonica() && sc.isRealizoPsicometrico() && sc.isApruebaCompetencias() && sc.isApruebaTecnica()) {
                                                SWBResourceURL urlPos = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT);
                                                urlPos.setAction("DO_OBS");
                                                urlPos.setParameter("suri", suri);
                                                urlPos.setParameter("po", po.getId());
                                                %>
                                                <tr>
                                                    <td><%=nombre%></td>
                                                    <td><span><%=sc.getPorcentajePsicometrico()%>%</span></td>
                                                    <td><span><%=sc.getPorcentajeCompetencias()%>%</span></td>
                                                    <td><span><%=sc.getPorcentajeTecnica()%>%</span></td>
                                                    <td><input type="radio" dojoType="dijit.form.RadioButton" <%=sc.isCandidatoGanador()?"checked":""%> name="selUsers" value="<%=po.getId()%>"/></td>
                                                    <td><a href="#" onclick="showFormDialog('<%=urlPos%>');">Observaciones</a></td>
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
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SeguimientoSolicitudRecurso.intranet_concluyeSeleccionTecnica, varSeguimiento, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSeguimiento, SeguimientoSolicitudRecurso.intranet_concluyeSeleccionTecnica, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, org.semanticwb.process.schema.Boolean.swps_booleanValue, varPregunta, SWBFormMgr.MODE_VIEW)%></label>
                        <td>
                        <%=fmgr.renderElement(request, varPregunta, org.semanticwb.process.schema.Boolean.swps_booleanValue, SWBFormMgr.MODE_EDIT)%>
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
    <div id="addDialog_<%=foi.getId()%>" dojoType="dijit.Dialog" title="Observaciones a candidato" href="#">
    </div>
<%
}
%>
