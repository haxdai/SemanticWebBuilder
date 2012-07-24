<%--  
    Document   : detail
    Created on : 17/05/2012, 01:34:20 PM
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Sector"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="com.infotec.cvi.swb.Habilidad"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.infotec.cvi.swb.Competencia"%>
<%@page import="com.infotec.cvi.swb.Avance"%>
<%@page import="com.infotec.cvi.swb.Carrera"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />


<%
    String action = request.getParameter("act");
    if (null == action) {
        action = "";
    }

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;
    String MODE_DETAIL = "detail";

    Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");

    String solID = request.getParameter("id");
    SolicitudRecurso solrec = null;
    if (solID != null) {
        solrec = SolicitudRecurso.ClassMgr.getSolicitudRecurso(solID, wsite);
    }
    
    

    String MODE_EXPORT = "export";

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));

    boolean isDetail = true;
    if (action.equals("buscar")) {
        isDetail = false;
    }
    
    System.out.println("(DETAIL) action: "+action);
%>

<script type="text/javascript">
    // scan page for widgets and instantiate them
    dojo.require("dojo.parser");
    dojo.require("dijit._Calendar");
    dojo.require("dijit.ProgressBar");

    // editor:
    dojo.require("dijit.Editor");

    // various Form elemetns
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.CheckBox");
    dojo.require("dijit.form.Textarea");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dijit.form.TextBox");
    dojo.require("dijit.form.DateTextBox");
    dojo.require("dijit.form.TimeTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberSpinner");
    dojo.require("dijit.form.Slider");
    dojo.require("dojox.form.BusyButton");
    dojo.require("dojox.form.TimeSpinner");
</script>
<%
    SWBResourceURL urlact = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
%>
<div id="processForm">
    <form dojoType="dijit.form.Form"  action="<%=urlact%>/_mod/view" method="post" id="fbusca" >
        <input type="hidden" name="suri" value="<%=solrec != null ? solrec.getURI() : ""%>"/>
        
        <input type="hidden" name="action" value="findcandidato"/>
        <input type="hidden" name="act" value="findcandidato"/>
        <input type="hidden" name="step" value="1"/>
        <fieldset>
            <table>
                <%
                    // aplica a detalle unicamente
                    if (isDetail && solrec != null) {
                        String solDate = solrec.getFechaSolicitud() != null ? sdf.format(solrec.getFechaSolicitud()) : "---";
                %>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.fechaSolicitud">Fecha de solicitud &nbsp;</label></label>
                    </td>
                    <td>
                        <span name="solicitudRecurso.fechaSolicitud"><%=solDate%></span>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.solicitanteRecurso">Nombre solicitante <em>*</em></label></label>
                    </td>
                    <td>
                        <%
                            out.println(solrec.getSolicitanteRecurso() != null ? solrec.getSolicitanteRecurso().getFullName() : "---");
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.motivoContratacion">Motivo de contratación <em>*</em></label></label>
                    </td>
                    <td>
                        <%
                            out.println(solrec.getMotivoContratacion() != null ? solrec.getMotivoContratacion() : "---");
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.contratacion">Tipo de contratación &nbsp;</label></label>
                    </td>
                    <td>
                        <%
                            String tipoContratacion = solrec.getContratacion();
                            String nomContratacion = "---";
                            if ("1".equals(tipoContratacion)) {
                                nomContratacion = "Nómina";
                            } else if ("2".equals(tipoContratacion)) {
                                nomContratacion = "Eventual";
                            } else if ("3".equals(tipoContratacion)) {
                                nomContratacion = "Honorarios";
                            }
                            out.println(nomContratacion);
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.proyectoAsignado">Proyecto asignado &nbsp;</label></label>
                    </td>
                    <td>
                        <%
                            out.println(solrec != null && solrec.getProyectoAsignado() != null ? solrec.getProyectoAsignado().getNombreProyecto() : "---");
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.nombreVacante">Nombre de la vacante &nbsp;</label></label>
                    </td>
                    <td>
                        <%
                            out.println(solrec != null && solrec.getNombreVacante() != null ? solrec.getNombreVacante() : "---");
                        %>
                    </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.funcionPrincipal">Función principal <em>*</em></label></label>
                    </td>
                    <td>
                        <%
                            if (solrec != null) {
                                String mainFunction = solrec != null && solrec.getFuncionPrincipal() != null ? solrec.getFuncionPrincipal() : "";
                                out.println("<input type=\"hidden\" name=\"solicitudRecurso.funcionPrincipal\" value=\"" + mainFunction + "\" />" + mainFunction);
                            } else {
                        %>
                        <textarea name="solicitudRecurso.funcionPrincipal" dojoType_="dijit.Editor" style="width:300px;height:50px;" ></textarea>
                        <%                            }
                        %>
                    </td>
                </tr>
                <%
                    if (isDetail && solrec != null) {
                %>
                <tr>
                    <td width="200px" align="right">
                        <label for="title"><label for="solicitudRecurso.personalDirecto">N° de personas a cargo directas (perfil solicitado)  <em>*</em></label></label>
                    </td>
                    <td>
                        <%
                            out.println(solrec.getPersonalDirecto());
                        %>
                    </td>
                </tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.personalIndirecto">N° de personas a cargo indirectas (perfil solicitado) <em>*</em></label></label></td>
                    <td>
                        <%
                            out.println(solrec.getPersonalIndirecto());
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.numVacantes">Vacantes solicitadas <em>*</em></label></label></td>
                    <td>
                        <%
                            out.println(solrec.getNumVacantes());
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.salarioMin">Remuneración propuesta rango mínimo <em>*</em></label></label></td>
                    <td>
                        <%
                            out.println("$" + solrec.getSalarioMin());
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.salarioMax">Remuneración propuesta rango máximo <em>*</em></label></label></td>
                    <td>
                        <%
                            out.println("$" + solrec.getSalarioMax());
                        %>
                    </td></tr>
                    <%
                        }
                    %>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.especialidad">Carrera o Especialidad <em>*</em></label></label></td>
                    <td>
                        <%
                            if (solrec != null) {
                                Carrera tcarrera = solrec.getEspecialidad();
                                out.println("<input type=\"hidden\" name=\"solicitudRecurso.especialidad\" value=\"" + (tcarrera!=null?tcarrera.getURI():"") + "\" />" + (tcarrera!=null?tcarrera.getTitle():"---"));
                            } else {
                        %>
                        <select name="solicitudRecurso.especialidad" dojoType="dijit.form.FilteringSelect" autoComplete="true" invalidMessage="Carrera o Especialidad es requerido." value="" required="true" displayedvalue="" >
                            <option value=""></option>
                            <%
                                Iterator<Carrera> itcarr = Carrera.ClassMgr.listCarreras(wsite);
                                while (itcarr.hasNext()) {
                                    Carrera tcarr = itcarr.next();
                                    out.println("<option value=\"" + tcarr.getURI() + "\" >" + tcarr.getTitle() + "</option>");
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.avance">Grado de avance requerido <em>*</em></label></label></td>
                    <td>
                        <%
                            String avance = "";
                            if (solrec != null) {
                                try{
                                    avance = solrec.getAvance();
                                } catch(Exception e){}
                                out.println("<input type=\"hidden\" name=\"solicitudRecurso.avance\" value=\"" + avance + "\" />" + avance + "%");
                            } else {
                        %>
                        <select name="solicitudRecurso.avance" dojoType="dijit.form.FilteringSelect" autoComplete="true" invalidMessage="Grado de avance requerido es requerido." value="" required="true" displayedvalue="" >
                            <option value=""></option>
                            <%
                                Iterator<Avance> itava = Avance.ClassMgr.listAvances(wsite);
                                while (itava.hasNext()) {
                                    Avance tava = itava.next();
                                    out.println("<option value=\"" + tava.getURI() + "\" >" + tava.getTitle() + "%</option>");
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.hasExpertise">Áreas de Talento o Expertise <em>*</em></label></label></td>
                    <td>
                        <%
                            Iterator<Habilidad> ithab = null;
                            if (solrec != null ) {
                                ithab = solrec.listExpertises();
                                while (ithab.hasNext()) {
                                    Habilidad thab = ithab.next();
                                    out.print("<input type=\"hidden\" name=\"solicitudRecurso.hasExpertise\" value=\"" + thab.getURI() + "\" />" + thab.getTitle());
                                    if (ithab.hasNext()) {
                                        out.print(", ");
                                    }
                                }
                            } else {
                        %>
                        <select name="solicitudRecurso.hasExpertise" multiple="true" style="width:300px;" >
                            <%
                                ithab = Habilidad.ClassMgr.listHabilidads(wsite);
                                while (ithab.hasNext()) {
                                    Habilidad thab = ithab.next();
                                    out.println("<option value=\"" + thab.getURI() + "\" >" + thab.getTitle() + "</option>");
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.hasSectorExpertise">Sector de experiencia <em>*</em></label></label></td>
                    <td>
                        <%
                            if (solrec != null) {
                                Iterator<Sector> itsec = solrec.listSectorExpertises(); 
                                if(!itsec.hasNext()){ 
                                    out.print("<input type=\"hidden\" name=\"solicitudRecurso.hasSectorExpertise\" value=\"\" />");
                                } else {
                                    while (itsec.hasNext()) {
                                        Sector secexp = itsec.next();
                                        out.print("<input type=\"hidden\" name=\"solicitudRecurso.hasSectorExpertise\" value=\"" + secexp.getURI() + "\" />" + secexp.getTitle());
                                        if (itsec.hasNext()) {
                                            out.print(", ");
                                        }
                                    }
                                }
                            } else {
                        %>
                        <select name="solicitudRecurso.hasSectorExpertise" multiple="true" style="width:300px;" >
                            <%
                                Iterator<Sector> itsec = Sector.ClassMgr.listSectors(wsite);
                                while (itsec.hasNext()) {
                                    Sector sector = itsec.next();
                                    out.println("<option value=\"" + sector.getURI() + "\" >" + sector.getTitle() + "</option>");
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.conocimientoTecnico">Conocimientos técnicos &nbsp;</label></label></td>
                    <td>
                        <%
                            if (solrec != null) {
                                String ctecnico = solrec.getConocimientoTecnico();
                                if (null == ctecnico) {
                                    ctecnico = "";
                                }
                                out.println("<input type=\"hidden\" name=\"solicitudRecurso.conocimientoTecnico\" value=\"" + ctecnico + "\">" + (!ctecnico.equals("") ? ctecnico : "---"));
                            } else {
                        %>
                        <textarea name="solicitudRecurso.conocimientoTecnico" dojoType_="dijit.Editor" style="width:300px;height:50px;" ></textarea>
                        <%                            }
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.certificaciones">Certificaciones &nbsp;</label></label></td>
                    <td>
                        <%
                            if (solrec != null) {
                                String certified = solrec.getCertificaciones();
                                if (null == certified) {
                                    certified = "";
                                }
                                out.println("<input type=\"hidden\" name=\"solicitudRecurso.certificaciones\" value=\"" + certified + "\">" + (!certified.equals("") ? certified : "---"));
                            } else {
                        %>
                        <textarea name="solicitudRecurso.certificaciones" dojoType_="dijit.Editor" style="width:300px;height:50px;" ></textarea>
                        <%                            }
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.hasCompetenciaReq">Competencias requeridas <em>*</em></label></label></td>
                    <td>
                        <%
                            Iterator<Competencia> itcomp = null;
                            if (solrec != null ) {
                                itcomp = solrec.listCompetenciaReqs();
                                while (itcomp.hasNext()) {
                                    Competencia tcomp = itcomp.next();
                                    out.print("<input type=\"hidden\" name=\"solicitudRecurso.hasCompetenciaReq\" value=\"" + tcomp.getURI() + "\" />" + tcomp.getTitle());
                                    if (itcomp.hasNext()) {
                                        out.print(", ");
                                    }
                                }
                            } else {
                        %>
                        <select name="solicitudRecurso.hasCompetenciaReq" multiple="true" style="width:300px;" >
                            <%
                                itcomp = Competencia.ClassMgr.listCompetencias(wsite);
                                while (itcomp.hasNext()) {
                                    Competencia tcomp = itcomp.next();
                                    out.println("<option value=\"" + tcomp.getURI() + "\" >" + tcomp.getTitle() + "</option>");
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </td></tr>
                    <%
                        if (isDetail && solrec != null) {
                    %>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.entrevistador">Realizará entrevista técnica &nbsp;</label></label></td>
                    <td>
                        <%
                            out.println(solrec != null && solrec.getEntrevistador() != null && solrec.getEntrevistador().getFullName() != null ? solrec.getEntrevistador().getFullName() : "---");
                        %>
                    </td></tr>
                <tr><td width="200px" align="right"><label for="title"><label for="solicitudRecurso.autorizaSolicitante">Autoriza área solicitante <em>*</em></label></label></td>
                    <td>
                        <%
                            out.println(solrec != null && solrec.isAutorizaSolicitante() ? "Sí" : "No");
                        %>                        
                    </td></tr>
                    <%
                        }
                    %>
                <tr><td colspan="2" align="center"> 
                        <button type="submit" >Buscar Candidato</button>
                        <%
                            SWBResourceURL urlback = paramRequest.getRenderUrl();
                            urlback.setMode(SWBResourceURL.Mode_VIEW);
                        %>
                        <button onclick="window.location='<%=urlback.toString()%>'; return false;">Regresar</button>
                    </td></tr>
            </table>
        </fieldset>



    </form>
</div>
