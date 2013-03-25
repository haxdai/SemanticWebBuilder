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
String varPregunta = "bConcluyeCECompetencias";
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
    
    if (act.equals("DO_COMP")) {
        response.setContentType("text/html; charset=UTF-8");
        SWBResourceURL actUrl = paramRequest.getActionUrl().setAction("SET_COMP");
        User candidato = site.getUserRepository().getUser(request.getParameter("po"));
        SeguimientoCandidato sc = null;
        
        if (candidato != null) {
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
                <form id="<%=foi.getId()%>/formEntrevista" dojoType="dijit.form.Form" class="swbform" action="<%=actUrl%>" method="post">
                    <input type="hidden" name="suri" value="<%=suri%>"/>
                    <input type="hidden" name="po" value="<%=candidato.getId()%>"/>
                    <input type="hidden" name="sr" value="<%=sr.getId()%>"/>
                    <fieldset>
                        <table>
                            <tr>
                                <td width="200px" align="right"><label for="title">Nombre</label></td>
                                <td>
                                    <%=candidato.getFullName()==null?"":candidato.getFullName()%>
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
                                <td width="200px" align="right"><label for="title">El candidato aprueba la entrevista</label>
                                <td>
                                    <input type="radio" value="true" <%=sc.isApruebaCompetencias()?"checked":""%> name="aprueba"/><label>Si</label>
                                    <input type="radio" value="false" <%=sc.isApruebaCompetencias()?"":"checked"%> name="aprueba"/><label>No</label>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Calificaci&oacute;n(%)</label>
                                <td>
                                    <input type="text" name="apego" isValid="return validaPorcentaje(this.value)" regexp="\d{1,3}(\.\d{1,2})?" required="true" dojoType="dijit.form.ValidationTextBox" value="<%=sc.getPorcentajeCompetencias()%>" />
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Notas generales</label>
                                <td>
                                    <textarea name="nota"><%=sc.getNotasCompetencia()!= null?sc.getNotasCompetencia():""%></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Notas sobre experiencia</label>
                                <td>
                                    <textarea name="notaExp"><%=sc.getNotaExperienciaCompetencias()!= null?sc.getNotaExperienciaCompetencias():""%></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Notas sobre conocimientos t&eacute;cnicos</label>
                                <td>
                                    <textarea name="notaTec"><%=sc.getNotasTecnicoCompetencias()!= null?sc.getNotasTecnicoCompetencias():""%></textarea>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset>
                        <span align="center">
                        <button dojoType="dijit.form.Button" type="submit">Guardar</button>
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
        
        function doAction(url) {
            window.location = url;
        }
        
        function getDateValue(element) {
            var ret = dijit.byId(element).value;
            return dojo.date.locale.format(ret, {datePattern:"yyyy-MM-dd", selector:"date"});
        }
        
        function updDate(postId, val) {
            <%
            SWBResourceURL modDate = paramRequest.getActionUrl().setAction("UPDATE_DATE").setParameter("suri", foi.getURI());
            %>
            var url = "<%=modDate%>" + "&po=" + postId + "&val=" + val;
            window.location = url;
        }
        function validaPorcentaje(val) {
            //return true;
          var temp = val;
          //if (val.indexOf("%")!=-1) {
          //    temp = val.replace("%","");
              //console.log(temp+"::");
          //}
          if(temp <= 100) {
            return true;
          }
          
          return false;
        }
    </script>
    <%=SWBForms.DOJO_REQUIRED%>
    <div id="processForm">
        <form id="<%=foi.getId()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post">
            <input type="hidden" name="suri" value="<%=suri%>"/>
            <input type="hidden" name="smode" value="edit"/>
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
                                            <th>Fecha / hora de entrevista</th>
                                            <th>Aprob&oacute; entrevista</th>
                                            <th>Porcentaje de apego</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        while (pos.hasNext()) {
                                            User po = pos.next();
                                            String nombre = "Sin nombre";
                                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                            SeguimientoCandidato sc = null;
                                            Iterator<SeguimientoCandidato> it_seg = SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(po, site);
                                            while (it_seg.hasNext()) {
                                                SeguimientoCandidato seg = it_seg.next();
                                                if (seg.getSolicitudCandidato() != null && seg.getSolicitudCandidato().equals(sr)) {
                                                    sc = seg;
                                                    break;
                                                }
                                            }
                                            
                                            Date fsc = sc.getFechaCompetencias();
                                            String _date = "Por realizar";
                                            if (fsc != null) _date = sdf.format(fsc);
                                            
                                            if (po.getFullName() != null) nombre = po.getFullName();
                                            
                                            SWBResourceURL urlPos = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT);
                                            urlPos.setAction("DO_COMP");
                                            urlPos.setParameter("suri", suri);
                                            urlPos.setParameter("po", po.getId());
                                            
                                            if (sc.isApruebaEntrevistaTelefonica() && sc.isRealizoPsicometrico()) {
                                                %>
                                                <tr>
                                                    <td><%=nombre%></td>
                                                    <td><span><%=_date%></span></td>
                                                    <td><span><%=sc.isApruebaCompetencias()?"SI":"NO"%></span></td>
                                                    <td><span><%=sc.getPorcentajeCompetencias()%>%</span></td>
                                                    <td><a href="#" onclick="showFormDialog('<%=urlPos%>');">Realizar entrevista</a></td>
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
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, org.semanticwb.process.schema.Boolean.swps_booleanValue, varPregunta, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <input type="radio" value="true" <%=pregunta.isValue()?"checked":""%> name="<%=varPregunta+"."+org.semanticwb.process.schema.Boolean.swps_booleanValue.getName()%>"/><label>Si</label>
                            <input type="radio" value="false" <%=pregunta.isValue()?"":"checked"%> name="<%=varPregunta+"."+org.semanticwb.process.schema.Boolean.swps_booleanValue.getName()%>"/><label>No</label>
                        </td>
                        <!--fmgr.renderElement(request, varPregunta, org.semanticwb.process.schema.Boolean.swps_booleanValue, SWBFormMgr.MODE_EDIT)-->
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
    <div id="addDialog_<%=foi.getId()%>" dojoType="dijit.Dialog" title="Realizar entrevista" href="#">
    </div>
<%
}
%>