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
//String varAsunto = "asuntoPsicometrico";
//String varCorreo = "correoPsicometrico";
String varCondicion = "bEncontraronPostulantes";
String varArchivoSolicitud = "archivoSolicitud";

//Verificar par�metro para recuperar instancia de tarea
String suri = request.getParameter("suri");
if (suri == null) {
    out.println("Par�metro no definido...");
    return;
}

//Recuperar instancia de tarea
FlowNodeInstance foi = (FlowNodeInstance) ont.getGenericObject(suri);

 //Validar redirecci�n
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

//Revisar asignaci�n a usuario
User asigned = foi.getAssignedto();
if(asigned == null) {
    foi.setAssigned(new Date());
    foi.setAssignedto(user);
} else if(!asigned.equals(user)) {
    out.println("Tarea asignada previamente a otro usuario...");
    return;
}

//Obtenci�n de objetos de datos
SolicitudRecurso sr = null;
SeguimientoSolicitudRecurso ssr = null;
org.semanticwb.process.schema.Boolean condicion = null;
org.semanticwb.process.schema.File archivoSol = null;
//org.semanticwb.process.schema.String asunto = null;
//org.semanticwb.process.schema.String correo = null;
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
    /*if (ref.getItemAware().getName().equals(varAsunto)) {
        asunto = (org.semanticwb.process.schema.String)obj;
    }
    if (ref.getItemAware().getName().equals(varCorreo)) {
        correo = (org.semanticwb.process.schema.String)obj;
    }*/
    if (ref.getItemAware().getName().equals(varCondicion)) {
        condicion = (org.semanticwb.process.schema.Boolean)obj;
    }
    if (ref.getItemAware().getName().equals(varArchivoSolicitud)) {
        archivoSol = (org.semanticwb.process.schema.File)obj;
    }
}

//Manejo de peticiones directas
if (paramRequest.getCallMethod() == SWBParamRequest.Call_DIRECT) {
    String act = paramRequest.getAction();
    String ret = "";
    
    if (act.equals("DO_BATTERY")) {
        SWBResourceURL actUrl = paramRequest.getActionUrl().setAction("SET_BATTERY");
        User candidato = site.getUserRepository().getUser(request.getParameter("po"));
        
        if (candidato != null) {
            SeguimientoCandidato sc = SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(candidato, site).next();//(SeguimientoCandidato)ont.getGenericObject(request.getParameter("sc"));
            %>
            <%=SWBForms.DOJO_REQUIRED%>
            <div id="processForm">
                <form id="<%=foi.getId()%>/formEntrevista" dojoType="dijit.form.Form" class="swbform" action="<%=actUrl%>" method="post">
                    <input type="hidden" name="suri" value="<%=suri%>"/>
                    <input type="hidden" name="po" value="<%=candidato.getId()%>"/>
                    <fieldset>
                        <table>
                            <tr>
                                <td width="200px" align="right"><label for="title">Nombre del postulante</label></td>
                                <td>
                                    <%=candidato.getFullName()%>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Crreo electr&oacute;nico</label>
                                <td>
                                    <%=candidato.getEmail()%>
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Usuario de acceso para examen *</label>
                                <td>
                                    <input type="text" name="batUsr" required="true" dojoType="dijit.form.ValidationTextBox" value="<%=sc.getUsuarioBateria()!= null?sc.getUsuarioBateria():""%>" />
                                </td>
                            </tr>
                            <tr>
                                <td width="200px" align="right"><label for="title">Password de acceso a examen *</label>
                                <td>
                                    <input type="password" name="batPass" required="true" dojoType="dijit.form.ValidationTextBox" value="<%=sc.getPassBateria()!= null?sc.getPassBateria():""%>" />
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

    //Creaci�n e inicializaci�n del formulario de procesos
    SWBProcessFormMgr mgr = new SWBProcessFormMgr(foi);
    mgr.setAction(paramRequest.getActionUrl().setAction("process").toString());
    mgr.clearProperties();
    
    mgr.addProperty(org.semanticwb.process.schema.Boolean.swps_booleanValue, varCondicion, SWBFormMgr.MODE_EDIT);

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
            var url = "<%=modDate%>" + "&po=" + postId + "&val=" + val + "&sr=" + "<%=sr.getId()%>";
            window.location = url;
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
                                            <th>Aprob&oacute; entrevista</th>
                                            <th>Fecha de env&iacute;o de correo</th>
                                            <!--th>Acciones</th-->
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        while (pos.hasNext()) {
                                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
                                            
                                            String _date = "Por realizar"; //SeguimientoCandidato.ClassMgr.listSeguimientoCandidatoByCandidato(po, site)
                                            Date fsc = sc.getFechaEnvioCorreoPsicometrico();
                                            if (po.getFullName() != null) nombre = po.getFullName();
                                            if (fsc != null) _date = sdf.format(fsc);
                                            
                                            SWBResourceURL urlPos = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT);
                                            urlPos.setAction("UPDATE_DATE");
                                            urlPos.setParameter("suri", suri);
                                            urlPos.setParameter("po", po.getId());
                                            urlPos.setParameter("sr", sr.getId());
                                            %>
                                            <tr>
                                                <td><%=nombre%></td>
                                                <td><%=sc.isApruebaEntrevistaTelefonica()?"SI":"NO"%></td>
                                                <%
                                                if (sc.isApruebaEntrevistaTelefonica()) {
                                                    %>
                                                    <!--td><a href="#" onclick="showFormDialog('<%=urlPos%>');">Configurar correo</a></td-->
                                                    <td><input id="recDate<%=po.getId()%>" type="text" value ="<%=_date%>" dojoType="dijit.form.DateTextBox" name="<%=SeguimientoCandidato.intranet_fechaEnvioCorreoPsicometrico.getPropId()%>" onChange="updDate('<%=po.getId()%>',getDateValue(dijit.byId('recDate<%=po.getId()%>')));"></td>
                                                    <%
                                                } else {
                                                    %>
                                                    <td>&nbsp;</td>
                                                    <%
                                                }
                                                %>
                                            </tr>
                                            <%
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
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, org.semanticwb.process.schema.Boolean.swps_booleanValue, varCondicion, SWBFormMgr.MODE_VIEW)%></label>
                        <td>
                        <%=fmgr.renderElement(request, varCondicion, org.semanticwb.process.schema.Boolean.swps_booleanValue, SWBFormMgr.MODE_EDIT)%>
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
    <div id="addDialog_<%=foi.getId()%>" dojoType="dijit.Dialog" title="Configurar bater�a" href="#">
    </div>
<%
}
%>