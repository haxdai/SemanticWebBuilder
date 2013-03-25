<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="com.infotec.cvi.swb.AreaTalento"%>
<%@page import="com.infotec.cvi.swb.EstudioSuperior"%>
<%@page import="com.infotec.cvi.swb.GradoAcademico"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.infotec.cvi.swb.Competencia"%>
<%@page import="com.infotec.cvi.swb.TipoTalento"%>
<%@page import="com.infotec.cvi.swb.Avance"%>
<%@page import="com.infotec.cvi.swb.Carrera"%>
<%@page import="com.infotec.cvi.swb.Grado"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.portal.SWBForms"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.model.SWBProcessFormMgr"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.model.SWBClass"%>
<%@page import="org.semanticwb.process.model.ItemAwareReference"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
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

//Validar redirección
if (null != request.getSession(true).getAttribute("msg")) {
    String message = (String) request.getSession(true).getAttribute("msg");
    if (message.equals("redirect")) {
        sr.setMontoTotal(sr.getSueldoBruto()*sr.getPeriodoContrato());
        sr.setSalarioMax(sr.getSueldoBruto());
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

SWBResourceURL urlact = paramRequest.getActionUrl();
urlact.setAction("process");

String _grado = request.getParameter("grado");
String _carrera = request.getParameter("carrera");
String _avance = request.getParameter("avance");
String _talento = request.getParameter("talento");

if (_grado == null) _grado = "";
if (_carrera == null) _carrera = "";
if (_avance == null) _avance = "";
if (_talento == null) _talento = "";

SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
%>
<%=SWBForms.DOJO_REQUIRED%>
<div id="processForm">
    <form action="#" method="get">
        <input type="hidden" name="suri" value="<%=suri%>"/>
        <fieldset>
            <table>
                <tr>
                    <td colspan="2"><b>Datos generales</b></td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_folio, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_folio, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_funcionPrincipal, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
                    <td>
                        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_funcionPrincipal, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, org.semanticwb.process.schema.File.swp_repositoryFileRef, varArchivoSolicitud, SWBFormMgr.MODE_VIEW)%></label>
                    <td>
                    <%=fmgr.renderElement(request, varArchivoSolicitud, org.semanticwb.process.schema.File.swp_repositoryFileRef, SWBFormMgr.MODE_VIEW)%>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><b>Criterios de b&uacute;squeda</b></td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">Grado acad&eacute;mico</label></td>
                    <td>
                        <select name="grado" dojoType="dijit.form.FilteringSelect" autoComplete="true">
                            <option <%=_grado.equals(" ")?"selected":""%> value=" ">Cualquiera</option>
                            <%
                            Iterator<Grado> grados = Grado.ClassMgr.listGrados(site);
                            while (grados.hasNext()) {
                                Grado grado = grados.next();
                                %><option <%=_grado.equals(grado.getURI())?"selected":""%> value="<%=grado.getURI()%>"><%=grado.getTitle()%></option><%
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">Carrera o especialidad</label></td>
                    <td>
                        <select name="carrera" dojoType="dijit.form.FilteringSelect" autoComplete="true">
                            <option <%=_carrera.equals(" ")?"selected":""%> value=" ">Cualquiera</option>
                            <%
                            Iterator<Carrera> carreras = Carrera.ClassMgr.listCarreras(site);
                            while (carreras.hasNext()) {
                                Carrera carrera = carreras.next();
                                %><option <%=_carrera.equals(carrera.getURI())?"selected":""%> value="<%=carrera.getURI()%>"><%=carrera.getTitle()%></option><%
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">Grado de avance acad&eacute;mico</label></td>
                    <td>
                        <select name="avance" dojoType="dijit.form.FilteringSelect" autoComplete="true">
                            <option <%=_avance.equals(" ")?"selected":""%> value=" ">Cualquiera</option>
                            <%
                            Iterator<Avance> avances = Avance.ClassMgr.listAvances(site);
                            while (avances.hasNext()) {
                                Avance avance = avances.next();
                                %><option <%=_avance.equals(avance.getURI())?"selected":""%> value="<%=avance.getURI()%>"><%=avance.getTitle()%></option><%
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">&Aacute;rea de talento</label></td>
                    <td>
                        <select name="talento" dojoType="dijit.form.FilteringSelect" autoComplete="true">
                            <option <%=_talento.equals(" ")?"selected":""%> value=" ">Cualquiera</option>
                            <%
                            Iterator<TipoTalento> talentos = TipoTalento.ClassMgr.listTipoTalentos(site);
                            while (talentos.hasNext()) {
                                TipoTalento talento = talentos.next();
                                %><option <%=_talento.equals(talento.getURI())?"selected":""%> value="<%=talento.getURI()%>"><%=talento.getTitle()%></option><%
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right"><label for="title">Competencias requeridas</label></td>
                    <td>
                        <select multiple name="competencias">
                            <%
                            Iterator<Competencia> competencias = Competencia.ClassMgr.listCompetencias(site);
                            while (competencias.hasNext()) {
                                Competencia competencia = competencias.next();
                                %><option value="<%=competencia.getId()%>"><%=competencia.getTitle()%></option><%
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span align="right">
                            <button dojoType="dijit.form.Button" type="submit">Buscar aspirantes</button>
                        </span>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
    <form id="<%=foi.getId()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post">
        <input type="hidden" name="suri" value="<%=suri%>"/>
        <input type="hidden" name="sr" value="<%=sr.getURI()%>"/>
        <input type="hidden" name="smode" value="edit"/>
        <fieldset>
            <table>
                <tr>
                    <td colspan="2"><b>Selecci&oacute;n de aspirantes</b></td>
                </tr>
                <tr>
                    <%
                    if (_grado == null) _grado = " ";
                    if (_carrera == null) _carrera = " ";
                    if (_avance == null) _avance = " ";
                    if (_talento == null) _talento = " ";

                    Grado grado = (Grado) ont.getGenericObject(_grado);
                    Carrera carrera = (Carrera) ont.getGenericObject(_carrera);
                    Avance avance = (Avance) ont.getGenericObject(_avance);
                    TipoTalento talento = (TipoTalento) ont.getGenericObject(_talento);

                    WebSite extranet = WebSite.ClassMgr.getWebSite("extranet");
                    Iterator<CV> cvis = CV.ClassMgr.listCVs(extranet);
                    ArrayList<User> aspirantes = new ArrayList<User>();
                    UserGroup goAspirante = extranet.getUserRepository().getUserGroup("Candidato");
                    String[] selected = request.getParameterValues("competencias");

                    /*System.out.println("Criterios de búsqueda:");
                    System.out.println("  Grado: '"+_grado+"'");
                    System.out.println("  Carrera: '"+_carrera+"'");
                    System.out.println("  Avance: '"+_avance+"'");
                    System.out.println("  Talento: '"+_talento+"'");
                    System.out.println("  Competencias: '"+(selected != null?selected.toString():"null")+"'");*/

                    while (cvis != null && cvis.hasNext()) {
                        CV cvi = cvis.next();
                        boolean hasGrado = false,
                            hasCarrera = false,
                            hasAvance = false,
                            hasTalento = false,
                            hasCompetencias = false;

                        if (cvi.getPropietario() != null && cvi.getPropietario().hasUserGroup(goAspirante)) {
                            Iterator<Competencia> comps = cvi.listCompetencias();
                            String compcvi = "";
                            while (comps.hasNext()) {
                                Competencia comp = comps.next();
                                compcvi += comp.getId();
                                if (comps.hasNext()) compcvi += "|";
                            }

                            //System.out.println("Grados académicos");
                            Iterator<GradoAcademico> itGrados = cvi.getAcademia().listGradoAcademicos();
                            while (itGrados != null && itGrados.hasNext()) {
                                GradoAcademico ga = itGrados.next();
                                //System.out.println("  Grado:"+ga.getGrado().getTitle()+", carrera:"+ga.getCarrera().getTitle());
                                if (_grado.equals(" ") || (grado != null && ga.getGrado() != null && ga.getGrado().equals(grado))) hasGrado = true;
                                if (_carrera.equals(" ") || (carrera != null && ga.getCarrera() != null && ga.getCarrera().equals(carrera))) hasCarrera = true;
                            }

                            //System.out.println("Estudios superiores");
                            Iterator<EstudioSuperior> estudios = cvi.getAcademia().listEstudioSuperiors();
                            while (estudios.hasNext()) {
                                EstudioSuperior estudio = estudios.next();
                                //System.out.println("  Estudio:"+estudio.getEstudiosSuperiores().getTitle()+", avance:"+estudio.getGradoAvance().getTitle());
                                if (_avance.equals(" ") || (avance != null && estudio.getGradoAvance().equals(avance))) hasAvance = true;
                            }

                            Iterator<AreaTalento> itTalentos = cvi.listAreaTalentos();
                            if (!itTalentos.hasNext()) {
                                hasTalento = true;
                            } else {
                                while (itTalentos.hasNext()) {
                                    AreaTalento area = itTalentos.next();
                                    if (_talento.equals(" ") || (talento != null && area.getTipoAreaTalento().equals(talento))) hasTalento = true;
                                }
                            }

                            if (selected == null) {
                                hasCompetencias = true;
                            } else {
                                for (int i = 0; i < selected.length; i++) {
                                    if (compcvi.indexOf(selected[i]) > -1) hasCompetencias = true;
                                }
                            }

                            if (hasGrado && hasCarrera && hasAvance && hasTalento && hasCompetencias) {
                                aspirantes.add(cvi.getPropietario());
                            }
                        }
                    }

                    if (!aspirantes.isEmpty()) {
                        Iterator<User> itAspirantes = aspirantes.iterator();
                        String verCVURL = site.getWebPage("Ver_Curriculum").getUrl();
                        %>
                        <table>
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Correo electr&oacute;nico</th>
                                    <th>Seleccionado</th>
                                    <th>CVI</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                while(itAspirantes.hasNext()) {
                                    User _as = itAspirantes.next();
                                    %>
                                    <tr>
                                        <td><%=_as.getFullName()%></td>
                                        <td><%=_as.getEmail()%></td>
                                        <td><input type="checkbox" dojoType="dijit.form.CheckBox" name="selUsers" value="<%=_as.getId()%>"/></td>
                                        <td><a target="_blank" href="<%=verCVURL%>?id=<%=_as.getId()%>">CVI <%=_as.getFullName()%></a></td>
                                    </tr>
                                    <%
                                }
                                %>
                            </tbody>
                        </table>
                        <%
                    } else {
                        %><td><span>No hay aspirantes</span></td><%
                    }
                    %>
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