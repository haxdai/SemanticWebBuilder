<%@page import="mx.com.infotec.intranet.login.Services"%>
<%@page import="com.infotec.cvi.swb.Habilidad"%>
<%@page import="com.infotec.cvi.swb.TipoTalento"%>
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

<%!
private String getAdscriptionAreaName(int adscriptionNumber, WebSite model) {
    String ret = String.valueOf(adscriptionNumber);
    boolean found = false;
    
    Iterator<CentroCosto> areas = CentroCosto.ClassMgr.listCentroCostos(model);
    while(areas.hasNext() && !found) {
        CentroCosto area = areas.next();
        if (area.getNumeroArea().trim().equals(ret)) {
            ret = area.getTitle();
            found = true;
        }
    }
    return ret;
}
%>

<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
User user = paramRequest.getUser();
WebSite site = paramRequest.getWebPage().getWebSite();
SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
String varSolicitud = "solicitudRecurso";
String varSeguimiento = "seguimientoSR";

//Manejo de peticiones directas
if (paramRequest.getCallMethod() == SWBParamRequest.Call_DIRECT) {
    String act = paramRequest.getAction();
    String ret = "No disponible";
    
    if (act.equals("GETHABS")) {
        response.setContentType("charset=UTF-8");
        //response.setContentType("text/x-json; charset=UTF-8");
        String capUri = request.getParameter("cUri");
        
        TipoTalento cap = (TipoTalento) ont.getGenericObject(capUri);
        if (cap != null) {
            ret = "{identifier:'uri', label:'name', items:[";
            Iterator<Habilidad> habs = Habilidad.ClassMgr.listHabilidadByTipoTalento(cap);
            while (habs.hasNext()) {
                Habilidad hab = habs.next();
                ret = ret + "{name:'" + hab.getTitle() + "', uri:'" + hab.getURI() + "'}";
                
                if (habs.hasNext()) ret = ret + ",";
            }
            ret = ret + "]}";
        }
    }
    out.print(ret);
    out.flush();
    return;
} else {
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
    mgr.addProperty(SolicitudRecurso.intranet_funcionPrincipal, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_motivoContratacion, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_personalDirecto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_personalIndirecto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_salarioMin, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_gradoAcademico, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_avance, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_especialidad, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_expertise, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_sectorExpertise, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_entrevistador, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_habilidadTalento, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_aniosExpertise, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_conocimientoTecnico, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_certificaciones, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_hasCompetenciaReq, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_notaSolicitud, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_centroDeCosto, varSolicitud, SWBFormMgr.MODE_EDIT);
    mgr.addProperty(SolicitudRecurso.intranet_especialidadRecurso, varSolicitud, SWBFormMgr.MODE_EDIT);
    
    SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
    Services services = new Services();
    String jefe = "No dsponible";
    if (services.getUserInformation(user.getLogin()) != null) {
        if (services.getUserInformation(user.getLogin()).getJefeInmediato() != null) {
            jefe = services.getUserInformation(user.getLogin()).getJefeInmediato();
        }
    }
    %>
    <%=SWBForms.DOJO_REQUIRED%>
    <div id="processForm">
        <form id="<%=foi.getId()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post" onSubmit="return validaForma(this);">
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
                            <span><%=getAdscriptionAreaName(services.getAreaAdscripcion(foi.getProcessInstance().getCreator().getLogin()), site)%></span>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title">Jefe inmediato</label>
                        <td>
                            <span><%=jefe%></span>
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
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_motivoContratacion, SWBFormMgr.MODE_EDIT)%>
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
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_centroDeCosto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_centroDeCosto, SWBFormMgr.MODE_VIEW)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_especialidadRecurso, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_especialidadRecurso, SWBFormMgr.MODE_VIEW)%>
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
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, Proyecto.intranet_ubicacionProyecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
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
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_funcionPrincipal, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_personalDirecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_personalDirecto, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_personalIndirecto, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_personalIndirecto, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_salarioMin, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <input type="text" value="<%=sr.getSalarioMin()%>" dojoType="dijit.form.ValidationTextBox" onBlur="validaMinimo();" id="salarioMin_<%=foi.getId()%>" name="<%=varSolicitud+"."+SolicitudRecurso.intranet_salarioMin.getName()%>" required="true" style="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_salarioMax, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <input type="text" disabled="disabled" value="<%=sr.getSalarioMax()%>" dojoType="dijit.form.ValidationTextBox" id="salarioMax_<%=foi.getId()%>" style="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_gradoAcademico, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_gradoAcademico, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_especialidad, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_especialidad, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_avance, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_avance, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_sectorExpertise, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_sectorExpertise, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_expertise, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <select id="talento_<%=foi.getId()%>" onChange="updateHabilidades(dijit.byId('talento_<%=foi.getId()%>').attr('value'))" name="<%=varSolicitud + "." + SolicitudRecurso.intranet_expertise.getName()%>" dojoType="dijit.form.FilteringSelect" autoComplete="true" invalidMessage="Talento es requerido." required="true">
                                <%
                                Iterator<TipoTalento> talentos = TipoTalento.ClassMgr.listTipoTalentos(site);
                                while (talentos.hasNext()) {
                                    TipoTalento talento = talentos.next();
                                    %><option value="<%=talento.getURI()%>" <%=sr.getExpertise().equals(talento)?"selected":""%>><%=talento.getTitle()%></option><%
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_habilidadTalento, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <select id="habilidad_<%=foi.getId()%>" name="<%=varSolicitud+"."+SolicitudRecurso.intranet_habilidadTalento.getName()%>" dojoType="dijit.form.FilteringSelect" autoComplete="true" invalidMessage="Habilidad es requerido." required="true" >
                                <%
                                Iterator<Habilidad> habs = Habilidad.ClassMgr.listHabilidads(site);
                                while (habs.hasNext()) {
                                    Habilidad hab = habs.next();
                                    %><option value="<%=hab.getURI()%>" <%=sr.getHabilidadTalento().equals(hab)?"selected":""%>><%=hab.getTitle()%></option><%
                                }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_aniosExpertise, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_aniosExpertise, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_conocimientoTecnico, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_conocimientoTecnico, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_certificaciones, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_certificaciones, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_hasCompetenciaReq, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_hasCompetenciaReq, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_notaSolicitud, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_notaSolicitud, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_entrevistador, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_entrevistador, SWBFormMgr.MODE_EDIT)%>
                        </td>
                    </tr>
                    <tr>
                        <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_usuarioAutoriza, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                        <td>
                            <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_usuarioAutoriza, SWBFormMgr.MODE_VIEW)%>
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
    <script type="text/javascript">
        dojo.require("dojo.data.ItemFileReadStore");

        function updateSelectAjax(elementId, callUrl, callParamName, callParamValue) {
            var urlToCall = callUrl+callParamName+encodeURIComponent(callParamValue);
            setSelectStoreAjax(elementId, urlToCall);
        }

        function fcomplete (items, request) {
            var Lvalue = request.store.getValue(items[0], 'uri');
            var el = dijit.byId('habilidad_<%=foi.getId()%>'); 
            el.attr('value', Lvalue);
            el.setDisabled(false);
        }

        function setSelectStoreAjax (elementId, callUrl) {
            var store = new dojo.data.ItemFileReadStore({url: callUrl, clearOnClose: true});
            var ele = dijit.byId(elementId);

            ele.store = store;

            store.fetch({onComplete: fcomplete});
            ele.startup();
        }
        
        function validaForma(forma) {
            if (validaMinimo() && forma.validate()) {
                return true;
            } else {
                alert('Algunos de los datos no son válidos. Verifique la información proporcionada.');
                return false;
            }
        }

        function validaMinimo() {
            var min = dojo.byId('salarioMin_<%=foi.getId()%>').value;
            var max = <%=sr.getSalarioMax()%>;
            if (min == "" || min== "undefined") min = 0;

            if (min < 0 || min >= max) dojo.byId('salarioMin_<%=foi.getId()%>').value = 0;
            if (min <= 0) {
                return false;
            } else {
                return true;
            }
        }

        function updateHabilidades(cUri) {
            <%
            SWBResourceURL caUrl = paramRequest.getRenderUrl().setCallMethod(SWBParamRequest.Call_DIRECT).setAction("GETHABS");
            %>
            //console.log(dijit.byId('partida_<%=foi.getId()%>'));
            updateSelectAjax('habilidad_<%=foi.getId()%>', '<%=caUrl%>', '?cUri=', cUri);
        }
    </script>
<%
}
%>