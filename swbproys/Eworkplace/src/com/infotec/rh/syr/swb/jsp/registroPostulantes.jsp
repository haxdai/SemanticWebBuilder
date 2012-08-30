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

//Manejo de peticiones directas
if (paramRequest.getCallMethod() == SWBParamRequest.Call_DIRECT) {
    String act = paramRequest.getAction();
    String ret = "";
    
    if (act.equals("ADD_POS")) {
        response.setContentType("text/html; charset=UTF-8");
        SWBFormMgr pubMgr = new SWBFormMgr(Postulante.sclass, site.getSemanticObject(), null);    
    
        pubMgr.setType(SWBFormMgr.TYPE_DOJO);
        pubMgr.setFilterRequired(false);
        pubMgr.setSubmitByAjax(false);
        SWBResourceURL actUrl = paramRequest.getActionUrl().setAction("ADD_POS");
        pubMgr.setAction(actUrl.toString());
        pubMgr.addButton(SWBFormButton.newSaveButton());
        pubMgr.addHiddenParameter("suri", request.getParameter("suri"));
        pubMgr.addHiddenParameter("sr", request.getParameter("sr"));
        String backButton = "<button dojoType=\"dijit.form.Button\" onclick=\"hideDialog('addDialog_" + foi.getId() + "');\">Regresar</button>";
        pubMgr.addButton(backButton);
        
        pubMgr.clearProperties();
        pubMgr.addProperty(Postulante.intranet_nombrePostulante);
        pubMgr.addProperty(Postulante.intranet_emailPostulante);
        pubMgr.addProperty(Postulante.intranet_fuenteInformacion);
        pubMgr.addProperty(Postulante.intranet_folioFuente);
        pubMgr.addProperty(Postulante.intranet_cumplePerfil);
        pubMgr.addProperty(Postulante.intranet_inhabilitadoSFP);
    %>
    <div id="processForm">
        <%=pubMgr.renderForm(request)%>
    </div>
    <%
    }
    out.print(ret);
    out.flush();
    return;
} else {
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
    %>
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
                    <tr><td colspan="2"><b>Postulantes</b></td></tr>
                    <tr>
                        <td colspan="2">
                            <%
                            Iterator<Postulante> pos = sr.listPostulantes();
                            if (pos.hasNext()) {
                                %>
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Nombre del postulante</th>
                                            <th>Correo</th>
                                            <th>Cumple CV</th>
                                            <th>Inhabilitado ante SFP</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        while (pos.hasNext()) {
                                            Postulante po = pos.next();
                                            String nombre = "Sin nombre";
                                            String correo = "Sin correo";
                                            
                                            if (po.getNombrePostulante() != null) nombre = po.getNombrePostulante();
                                            if (po.getEmailPostulante() != null) correo = po.getEmailPostulante();
                                            
                                            %>
                                            <tr>
                                                <td><%=nombre%></td>
                                                <td><%=correo%></td>
                                                <td><%=po.isCumplePerfil()?"Si":"No"%></td>
                                                <td><%=po.isInhabilitadoSFP()?"Si":"No"%></td>
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
                            SWBResourceURL urlPos = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT);
                            urlPos.setAction("ADD_POS");
                            urlPos.setParameter("suri", suri);
                            urlPos.setParameter("sr", sr.getURI());
                            %>
                            <a href="#" onclick="showFormDialog('<%=urlPos%>');">Agregar postulante</a>
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
    <div id="addDialog_<%=foi.getId()%>" dojoType="dijit.Dialog" title="Agregar postulante" href="#">
    </div>
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
    </script>
<%
}
%>