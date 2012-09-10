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
    if (ref.getItemAware().getName().equals(varArchivoSolicitud)) {
        archivoSol = (org.semanticwb.process.schema.File)obj;
    }
}

//Creación e inicialización del formulario de procesos
SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
mgr.setAction(paramRequest.getActionUrl().setAction("process").toString());
mgr.clearProperties();

SWBResourceURL urlact = paramRequest.getActionUrl();
urlact.setAction("process");

SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
SimpleDateFormat sdfDojo = new SimpleDateFormat("yyyy-MM-dd");
String now = sdfDojo.format(new Date(System.currentTimeMillis()));
    %>
    <script>
        dojo.require("dijit.Dialog");
        dojo.require("dijit.form.TimeTextBox");
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
        
        function getTimeValue(element) {
            var ret = dijit.byId(element).value;
            return dojo.date.locale.format(ret, {datePattern:"HH:mm", selector:"time"});
        }
        
        function updTime(postId, val) {
            <%
            SWBResourceURL modDate = paramRequest.getActionUrl().setAction("UPDATE_TIME").setParameter("suri", foi.getURI());
            %>
            var url = "<%=modDate%>" + "&po=" + postId + "&val=" + val + "&sr=" + "<%=sr.getId()%>";
            window.location = url;
        }
        
        function validaForma(forma) {
            if (forma.validate()) {
                return true;
            } else {
                alert('Algunos de los datos no son válidos. Verifique la información proporcionada.');
                return false;
            }
        }
        
        function updDate(postId, val) {
            <%
            modDate = paramRequest.getActionUrl().setAction("UPDATE_DATE").setParameter("suri", foi.getURI());
            %>
            var url = "<%=modDate%>" + "&po=" + postId + "&val=" + val + "&sr=" + "<%=sr.getId()%>";
            window.location = url;
        }
    </script>
    <%=SWBForms.DOJO_REQUIRED%>
    <div id="processForm">
        <form id="<%=foi.getId()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post" onSubmit="return validaForma(this);">
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
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        while (pos.hasNext()) {
                                            User po = pos.next();
                                            String nombre = "Sin nombre";
                                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                            SimpleDateFormat tdf = new SimpleDateFormat("'T'HH:mm:ss");
                                            SeguimientoCandidato sc = null;
                                            Iterator<SeguimientoCandidato> it_seg = SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(po, site);
                                            while (it_seg.hasNext()) {
                                                SeguimientoCandidato seg = it_seg.next();
                                                if (seg.getSolicitudCandidato()!= null && seg.getSolicitudCandidato().equals(sr)) {
                                                    sc = seg;
                                                    break;
                                                }
                                            }
                                            
                                            Date fsc = sc.getFechaTecnica();
                                            String _date = "Por realizar";
                                            String _time = "";
                                            if (fsc != null) _date = sdf.format(fsc);
                                            if (fsc != null) _time = tdf.format(fsc);
                                            
                                            if (po.getFullName() != null) nombre = po.getFullName();
                                            
                                            SWBResourceURL urlPos = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT);
                                            urlPos.setAction("DO_COMP");
                                            urlPos.setParameter("suri", suri);
                                            urlPos.setParameter("po", po.getId());
                                            
                                            if (sc.isApruebaEntrevistaTelefonica() && sc.isRealizoPsicometrico() && sc.isApruebaCompetencias() && sc.isPasaEntrevistaTecnica()) {
                                                %>
                                                <tr>
                                                    <td><%=nombre%></td>
                                                    <td>
                                                        <input id="recDate<%=po.getId()%>" type="text" value ="<%=_date%>" dojoType="dijit.form.DateTextBox" name="<%=SeguimientoCandidato.intranet_fechaCompetencias.getPropId()%>" onChange="updDate('<%=po.getId()%>',getDateValue(dijit.byId('recDate<%=po.getId()%>')));" constraints="{min:'<%=now%>'}">
                                                        <input id="recTime<%=po.getId()%>" type="text" value ="<%=_time%>" dojoType="dijit.form.TimeTextBox" onChange="updTime('<%=po.getId()%>',getTimeValue(dijit.byId('recTime<%=po.getId()%>')));"/>
                                                    </td>
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
