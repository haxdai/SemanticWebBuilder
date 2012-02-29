<%-- 
Document   : viewCV
Created on : 21/02/2012, 06:18:56 PM
Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.Publicacion"%>
<%@page import="com.infotec.cvi.swb.Docencia"%>
<%@page import="com.infotec.cvi.swb.Investigacion"%>
<%@page import="com.infotec.cvi.swb.Competencia"%>
<%@page import="com.infotec.cvi.swb.Distincion"%>
<%@page import="com.infotec.cvi.swb.AreaTalento"%>
<%@page import="com.infotec.cvi.swb.ExperienciaLaboral"%>
<%@page import="com.infotec.cvi.swb.Idioma"%>
<%@page import="com.infotec.cvi.swb.CursoTIC"%>
<%@page import="com.infotec.cvi.swb.Diplomado"%>
<%@page import="com.infotec.eworkplace.swb.Telefono"%>
<%@page import="com.infotec.cvi.swb.EstudioSuperior"%>
<%@page import="com.infotec.cvi.swb.GradoAcademico"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.infotec.cvi.swb.Candidato,
        com.infotec.eworkplace.swb.Persona"%>
<%@page import="org.semanticwb.SWBPortal
        ,org.semanticwb.model.User
        ,org.semanticwb.model.WebSite
        ,org.semanticwb.model.WebPage" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
//String repositoryId = paramRequest.getWebPage().getWebSite().getUserRepository().getId();
            WebSite ws = paramRequest.getWebPage().getWebSite();
            User user = paramRequest.getUser();
            Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
            Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
            CV cv = CV.ClassMgr.getCV(user.getId(), ws);
            Academia academia = null;
            if (cv != null) {
                academia = cv.getAcademia();
            }
            String fullName = "";
            String curp = "";
            String birthday = "";
            String gender = "";
            String state = "";
            String nationality = "";
            String fm2 = "";
            String sLabor = "";
            String availability = "";
            String email = "";
            String facebook = "";
            String skype = "";
            String msn = "";
            String linkedin = "";
            String twitter = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (user.getFullName() != null) {
                fullName = user.getFullName();
            }
            if (user.getEmail() != null) {
                email = user.getEmail();
            }
            if (persona != null) {
                if (persona.getCurp() != null) {
                    curp = persona.getCurp();
                }
                if (persona.isGenero() == true) {
                    gender = "Femenino";
                } else {
                    gender = "Masculino";
                }
                if (persona.getNacimiento() != null) {
                    birthday = sdf.format(persona.getNacimiento());
                }
                if (persona.getNacionalidad() != null) {
                    nationality = persona.getNacionalidad().getTitle();
                }
                if (persona.getFM2() != null) {
                    fm2 = persona.getFM2();
                }
                if (persona.getFacebook() != null) {
                    facebook = persona.getFacebook();
                }
                if (persona.getSkype() != null) {
                    skype = persona.getSkype();
                }
                if (persona.getMsn() != null) {
                    msn = persona.getMsn();
                }
                if (persona.getLinkedin() != null) {
                    linkedin = persona.getLinkedin();
                }
                if (persona.getTwitter() != null) {
                    twitter = persona.getTwitter();
                }
            }
            if (candidato != null) {
                switch (candidato.getSituacionLaboral()) {
                    case 1:
                        sLabor = "Empleado";
                        break;
                    case 2:
                        sLabor = "Desempleado";
                        break;
                    case 3:
                        sLabor = "Estudiante";
                        break;
                    case 4:
                        sLabor = "Jubilado";
                        break;
                }
                availability = "" + candidato.getDisponibilidad();
                if (candidato.getDisponibilidad() == 1) {
                    availability += " día";
                } else {
                    availability += " dias";
                }
            }
%>
<div id="icv-print-content">
    <h1>Curriculum Vitae Infotec</h1>
    <!--div id="icv-foto"><img src="x" /></div-->
    <h2><%=fullName%></h2>
    <ul>
        <li><%=curp%></li>
        <li><%=birthday%>, <%=state%>, <%=nationality%>, <%=gender%></li>
        <li><%=sLabor%>, <%=availability%> habiles disponibles</li>
    </ul>
    <div class="icv-print-contacto">
        <h3>Medio de Contacto</h3>
        <ul>
            <%
                        if (persona != null) {
                            Iterator<Telefono> itt = persona.listTelefonos();
                            while (itt.hasNext()) {
                                Telefono te = itt.next();
                                String lada = te.getLada() > 0 ? "(" + te.getLada() + ")" : "";
                                String numero = te.getNumero() > 0 ? "" + te.getNumero() : "";
                                String exten = te.getExtension() > 0 ? "Ext:" + te.getExtension() : "";
                                String tipo = te.getTipo() != null ? te.getTipo() : "";
            %>
            <li class="icv-cel"><strong><%=tipo%>:</strong><%=lada%> <%=numero%> <%=exten%></li>
            <%
                            }
                        }
            %>
            <%
                        if (!email.equals("")) {
            %>
            <li class="icv-mail"><strong>Correo:</strong><a href="mail"><%=email%></a></li>
            <%
                        }
                        if (!facebook.equals("")) {
            %>
            <li class="icv-fb"><strong>Facebook:</strong><a href="#"><%=facebook%></a></li>
            <%
                        }
                        if (!twitter.equals("")) {
            %>
            <li class="icv-tw"><strong>Twitter:</strong><a href="#"><%=twitter%></a></li>
            <%
                        }
                        if (!skype.equals("")) {
            %>
            <li class="icv-sky"><strong>Skype:</strong><a href="#"><%=skype%></a></li>
            <%
                        }
                        if (!linkedin.equals("")) {
            %>
            <li class="icv-in"><strong>Linkedin:</strong><a href="#"><%=linkedin%></a></li>
            <%
                        }
            %>
        </ul>
    </div>
    <div class="icv-clearer">&nbsp;</div>
    <div class="icv-print-formacion">
        <h3>Formación Académica</h3>
        <ul>
            <%
                        if (academia != null) {
                            Iterator<GradoAcademico> itga = academia.listGradoAcademicos();
                            if (itga != null) {
            %>
            <li>
                <h4>Grados Académicos</h4>
                <ul>
                    <%
                        while (itga.hasNext()) {
                            GradoAcademico ga = itga.next();
                            String grado = ga.getGrado().getTitle();
                            String carrera = ga.getCarrera().getTitle();
                            String institucion = ga.getNombreInstitucion();
                            String situacion = ga.getSituacionAcademica().getTitle();
                            String periodo = "" + ga.getPeriodoYears();
                            if (ga.getPeriodoYears() == 1) {
                                periodo += " año";
                            } else {
                                periodo += " años";
                            }
                    %>
                    <li><strong><%=grado%></strong>, <%=carrera%>, <%=institucion%>, <%=situacion%> (<%=periodo%>)</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                }

                Iterator<EstudioSuperior> ites = academia.listEstudioSuperiors();
                if (ites != null) {
            %>
            <li>
                <h4>Estudios Superiores</h4>
                <ul>
                    <%
                        while (ites.hasNext()) {
                            EstudioSuperior es = ites.next();
                            String avance = es.getGradoAvance().getTitle();
                            String estudio = es.getEstudiosSuperiores().getTitle();
                            String periodo = "" + es.getPeriodoYears();
                            if (es.getPeriodoYears() == 1) {
                                periodo += " año";
                            } else {
                                periodo += " años";
                            }
                    %>
                    <li><strong><%=estudio%></strong>,	<%=periodo%>, <%=avance%> </li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                            }
                        }
                        if (cv != null) {
                            Iterator<Diplomado> itdi = cv.listDiplomados();
                            if (itdi != null) {
            %>
            <li>
                <h4>Dilomados, cursos y certificaciones</h4>
                <ul>
                    <%
                        while (itdi.hasNext()) {
                            Diplomado di = itdi.next();
                            String nombre = di.getTitle();
                            String institucion = di.getNombreInstitucion();
                            String inicio = sdf.format(di.getInicio());
                            String fin = sdf.format(di.getFin());
                            String documento = di.getDocumentoObtenido();
                    %>
                    <li><strong><%=nombre%></strong>, <%=institucion%><br />
                        De <%=inicio%> a <%=fin%> (<%=documento%>)</li>
                        <%
                            }
                        %>
                </ul>
            </li>
            <%
                }
                Iterator<CursoTIC> itct = cv.listCursosTICs();
                if (itct != null) {
            %>
            <li>
                <h4>Especialización en TIC</h4>
                <ul>
                    <%
                        while (itct.hasNext()) {
                            CursoTIC ct = itct.next();
                            String nombre = ct.getTitle();
                            String institucion = ct.getNombreInstitucion();
                            String inicio = sdf.format(ct.getInicio());
                            String fin = sdf.format(ct.getFin());
                            String documento = ct.getDocumentoObtenido();
                    %>
                    <li><strong><%=nombre%></strong>, <%=institucion%><br />
                        De <%=inicio%> a <%=fin%> (<%=documento%>)</li>
                        <%
                            }
                        %>
                </ul>
            </li>
            <%
                }
                Iterator<Idioma> itid = cv.listIdiomas();
                if (itid != null) {
            %>
            <li>
                <h4>Idiomas</h4>
                <ul>
                    <%
                        while (itid.hasNext()) {
                            Idioma id = itid.next();
                            String idioma = id.getIdiomas().getTitle();
                            String conver = id.getConversacion().getTitle();
                            String lectura = id.getLectura().getTitle();
                            String escritura = id.getEscritura().getTitle();
                    %>
                    <li><strong><%=idioma%>:</strong> Conversación <%=conver%>%, lectura <%=lectura%>%, escritura <%=escritura%>%</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                            }
                        }
            %>
        </ul>
    </div>
    <div class="icv-print-experiencia">
        <h3>Experiencia</h3>
        <ul>
            <%
                        if (cv != null) {
                            Iterator<ExperienciaLaboral> itel = cv.listExperienciaLaborals();
                            if (itel != null) {
            %>
            <li>
                <h4>Experiencia laboral</h4>
                <ul>
                    <%
                        while (itel.hasNext()) {
                            ExperienciaLaboral el = itel.next();
                            String empresa = el.getEmpresa();
                            String inicio = sdf.format(el.getFechaIni());
                            String fin = sdf.format(el.getFechaFin());
                            String cargo = el.getCargo();
                            String jefe = el.getJefe();
                            Telefono te = el.getTelefono();
                            String lada = te.getLada() > 0 ? "(" + te.getLada() + ")" : "";
                            String numero = te.getNumero() > 0 ? "" + te.getNumero() : "";
                            String exten = te.getExtension() > 0 ? "Ext:" + te.getExtension() : "";
                    %>
                    <li><strong><%=empresa%></strong> <br />
                        <%=inicio%> / <%=fin%>, <%=cargo%>,	(<%=lada%>) <%=numero%> <%=exten%><br />
                        Jefe inmediato: <%=jefe%></li>
                        <%
                            }
                        %>
                </ul>
            </li>
            <%
                }
                Iterator<AreaTalento> itat = cv.listAreaTalentos();
                if (itat != null) {
            %>
            <li>
                <h4>Areas de talento o expertise</h4>
                <ul>
                    <%
                        while (itat.hasNext()) {
                            AreaTalento at = itat.next();
                            String talento = at.getAreaTalento();
                            String destreza = at.getAreaDestrezaTI();
                            String tiempo = "";
                            if (at.getYearExperienceTalento() > 0) {
                                if (at.getYearExperienceTalento() == 1) {
                                    tiempo += at.getYearExperienceTalento() + " año";
                                } else {
                                    tiempo += at.getYearExperienceTalento() + " años";
                                }
                            }
                            String tiempoti = "";
                            if (at.getYearExpirienceTI() > 0) {
                                if (at.getYearExpirienceTI() == 1) {
                                    tiempoti += at.getYearExpirienceTI() + " año";
                                } else {
                                    tiempoti += at.getYearExpirienceTI() + " años";
                                }
                            }
                    %>
                    <li><strong><%=talento%><%=destreza%></strong> (<%=tiempo%><%=tiempoti%>)</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                }
                Iterator<Distincion> itdi = cv.listDistincions();
                if (itdi != null) {
            %>
            <li>
                <h4>Distinciones y reconocimientos</h4>
                <ul>
                    <%
                        while (itdi.hasNext()) {
                            Distincion di = itdi.next();
                            String titulo = di.getTitle();
                            String otorga = di.getOtorgante();
                            String fecha = sdf.format(di.getFechaDistincion());
                    %>
                    <li><strong><%=titulo%></strong>, <%=otorga%> (<%=fecha%>)</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                            }
                        }
            %>
        </ul>
    </div>
    <div class="icv-print-competencias">
        <h3>Competencias</h3>
        <ul>
            <%
                        if (cv != null) {
                            Iterator<Competencia> itco = cv.listCompetencias();
                            if (itco != null) {
            %>
            <li>
                <h4>Auto evaluación de competencias</h4>
                <ul>
                    <%
                        while (itco.hasNext()) {
                            Competencia co = itco.next();
                            String competencia = co.getTitle();
                    %>
                    <li><strong><%=competencia%></strong><!--, Nivel	Avanzado (5 años)--></li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                }
            %>
            <!--li>
            <h4>Competencias por perfiles de TI</h4>
            <ul>
            <li><strong>Certificación en la competencia</strong>, Nivel	Avanzado (5 años)</li>
            <li><strong>Certificación en la competencia</strong>, Nivel	Avanzado (5 años)</li>
            <li><strong>Certificación en la competencia</strong>, Nivel	Avanzado (5 años)</li>
            </ul>
            </li-->
            <%
                        }
            %>
        </ul>
    </div>
    <div class="icv-print-investigacion">
        <h3>Investigación y docencia</h3>
        <ul>
            <%
                        if (cv != null) {
                            Iterator<Investigacion> itin = cv.listInvestigacions();
                            if (itin != null) {
            %>
            <li>
                <h4>Investigación</h4>
                <ul>
                    <%
                        while (itin.hasNext()) {
                            Investigacion in = itin.next();
                            String empresa = in.getNombreEmpresa();
                            String area = in.getAreaInvestigacion();
                            String tiempo = "";
                            if (in.getFechaTermino() > 0) {
                                if (in.getFechaTermino() == 1) {
                                    tiempo += " año";
                                } else {
                                    tiempo += " años";
                                }
                            }
                            String numero = in.getNumTelefono() > 0 ? "" + in.getNumTelefono() : "";
                            String cargo = "";
                            if (in.getNombrePuesto() != null) {
                                cargo = in.getNombrePuesto();
                            }
                            String jefe = "";
                            if (in.getNombreJefePuesto() != null) {
                                jefe = in.getNombreJefePuesto();
                            }
                            String sni = "";
                            if (in.getSniConacyt() != null) {
                                sni = in.getSniConacyt().getTitle();
                            }
                    %>
                    <li><strong><%=empresa%>, 	<%=area%></strong> <br />
                        <%=tiempo%>, <%=cargo%>, <%=numero%><br />
                        Jefe inmediato: <%=jefe%><br />
                        <%=sni%></li>
                        <%
                            }
                        %>
                    <!--li><strong>Empresa, 	Área de investicación</strong> <br />
                    2012-01-03, Coordinador Ejecutivo,	(52) 5624 2800<br />
                    Jefe inmediato: Nombre Apellido Apellido,	Sub-gerente de Administración y Finanzas<br />
                    SNI Conacyt: Registro en el Sistema nacional de investigadores</li-->
                </ul>
            </li>
            <%
                }
                Iterator<Docencia> itdo = cv.listDocencias();
                if (itdo != null) {
            %>
            <li>
                <h4>Docencia</h4>
                <ul>
                    <%
                        while (itdo.hasNext()) {
                            Docencia doc = itdo.next();
                            String asigna = doc.getAsignatura();
                            String institu = doc.getInstitucion();
                            String nivel = "";
                            if (doc.getNivelDocencia() != null) {
                                nivel = doc.getNivelDocencia().getTitle();
                            }
                    %>
                    <li><strong><%=asigna%></strong>, <%=institu%>, <%=nivel%></li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                }
                Iterator<Publicacion> itpu = cv.listPublicacions();
                if (itpu != null) {
            %>
            <li>
                <h4>Publicaciones</h4>
                <ul>
                    <%
                        while (itpu.hasNext()) {
                            Publicacion pu = itpu.next();
                            String titulo = pu.getTitle();
                            String medio = pu.getPublicado();
                            String fecha = "" + pu.getFechapublicado();
                    %>
                    <li><strong><%=titulo%></strong>, <%=medio%> (<%=fecha%>)</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                            }
                        }
            %>
        </ul>
    </div>
</div>