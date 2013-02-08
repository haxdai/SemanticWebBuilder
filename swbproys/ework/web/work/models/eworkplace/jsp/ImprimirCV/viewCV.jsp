<%-- 
Document   : viewCV
Created on : 21/02/2012, 06:18:56 PM
Author     : rene.jara
--%><%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="com.infotec.eworkplace.swb.SWProfile"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="com.infotec.cvi.swb.Publicacion"%>
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
        ,org.semanticwb.model.WebPage
        ,org.semanticwb.portal.api.SWBResourceURL" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="static com.infotec.cvi.swb.resources.reports.ImprimirCV.Mode_PDF" %>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            User user=null;
            boolean showMenu=true;
            String userId=request.getParameter("id");
            if (userId!=null&&!userId.equals("")){
                UserRepository ur = ws.getUserRepository();
                user = ur.getUser(userId);
                showMenu=false;
            }
            if (user==null){
                user = paramRequest.getUser();
            }
            Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
            Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
            CV cv = CV.ClassMgr.getCV(user.getId(), ws);
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), ws);

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
                if (persona.getEstadoNacimiento() != null) {
                    state = persona.getEstadoNacimiento().getTitle();
                }
                if (persona.isGenero() == true) {
                    gender = "Femenino";
                } else {
                    gender = "Masculino";
                }
                if (persona.getNacimiento() != null) {
                    birthday = persona.getNacimiento()!=null?sdf.format(persona.getNacimiento()):"";
                }
                if (persona.getNacionalidad() != null) {
                    nationality = persona.getNacionalidad().getTitle();
                }
                if(persona.getNacionalidad() != null&&
                        persona.getNacionalidad().getId().equals("mx")&&
                        persona.isFM2()){
                    fm2=" (FM2 vigente)";
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
            if(showMenu){
%>
<%@include file="../menucvi.jsp" %>
<%
            }
%>
<div id="icv-print-content">
    <h1>Curriculum Vitae Infotec</h1>
    <%
                String pimg = "";
                if (profile != null) {
                    if (user.getPhoto() != null) {
                        pimg = SWBPortal.getWebWorkPath() + profile.getWorkPath() + "/" + user.getPhoto();
    %>
    <div id="icv-foto"><img src="<%=pimg%>" alt="<%=user.getLogin()%>" style="width:100px;height:130px"/></div>
        <%
                        }
                    }
        %>
    <h2><%=fullName%></h2>
    <ul>
        <li><%=curp%></li>
        <li><%=birthday.equals("") ? "" : birthday + ", "%>
            <%=state.equals("") ? "" : state + ", "%>
            <%=nationality%>
            <%=fm2%>
            <%=nationality.equals("") ? "" : ", "%>
            <%=gender%></li>
        <li><%=sLabor.equals("") ? "" : sLabor + ", "%>
            <%=availability.equals("") ? "" : "Disponibilidad en: " + availability%></li>
    </ul>
    <div class="icv-print-contacto">
        <%
                    if (persona != null || !email.equals("")) {
        %>
        <h3>Medio de Contacto</h3>
        <%            }
        %>
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
                                String classTipo="";
                                if (tipo.equals("Fijo")){
                                    classTipo="icv-telcasa";
                                }else if (tipo.equals("Movil")){
                                    classTipo="icv-cel";
                                }else if (tipo.equals("Trabajo")){
                                    classTipo="icv-telofic";
                                }else if (tipo.equals("Recados")){
                                    classTipo="icv-telreca";
                                }
            %>
            <li class="<%=classTipo%>"><!--strong><%=tipo%>:</strong--><%=lada%> <%=numero%> <%=exten%></li>
            <%
                            }
                        }
            %>
            <%
                        if (email != null && !email.equals("")) {
            %>
            <li class="icv-mail"><strong>Correo:</strong><a href="mail"><%=email%></a></li>
            <%
                        }
                        if (persona != null) {
                            Iterator<String> item = persona.listPEmails();
                            if (item != null) {
                                while (item.hasNext()) {
                                    String pEmail = item.next();
            %>
            <li class="icv-mail"><strong>Correo:</strong><a href="mail"><%=pEmail%></a></li>
            <%
                                }
                            }
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
                            if (itga != null && SWBUtils.Collections.sizeOf(itga) > 0) {
                                itga = academia.listGradoAcademicos();
            %>
            <li>
                <h4>Grados Académicos</h4>
                <ul>
                    <%
                        while (itga.hasNext()) {
                            GradoAcademico ga = itga.next();
                            String grado = ga.getGrado().getTitle();
                            String carrera = "";
                            if (ga.getCarrera() != null) {
                                carrera = ga.getCarrera().getTitle();
                            }
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
                if (ites != null && SWBUtils.Collections.sizeOf(ites) > 0) {
                    ites = academia.listEstudioSuperiors();
            %>
            <li>
                <h4>Estudios Superiores</h4>
                <ul>
                    <%
                        while (ites.hasNext()) {
                            EstudioSuperior es = ites.next();
                            String avance = es.getGradoAvance().getTitle();
                            //String estudio = es.getEstudiosSuperiores().getTitle();
                            String tipo="";
                            String estudio="";
                            String periodo = "" + es.getPeriodoYears();
                            if (es.getPeriodoYears() == 1) {
                                periodo += " año";
                            } else {
                                periodo += " años";
                            }
                            //es.getId().endsWith("_otro")&&es.getEstudiosSuperiores().getTitle().equals("otro");
                            if(es.getEstudiosSuperiores()!=null){
                                if(es.getEstudiosSuperiores().getAreaEstudio()!=null&&
                                        es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv()!=null&&
                                        es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv()!=null){
                                    tipo=es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv().getTitle();
                                }
                                if(es.getEstudiosSuperiores().getId().endsWith("_otro")&&es.getEstudiosSuperiores().getTitle().equals("Otro")){
                                    estudio = "Otro / "+es.getOtroEstudio();
                                } else{
                                    estudio = es.getEstudiosSuperiores().getTitle();
                                }
                            }


                    %>
                    <li><strong><%=tipo%> - <%=estudio%></strong>, <%=periodo%>, <%=avance%>% </li>
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
                            if (itdi != null && SWBUtils.Collections.sizeOf(itdi) > 0) {
                                itdi = cv.listDiplomados();
            %>
            <li>
                <h4>Diplomados, cursos y certificaciones</h4>
                <ul>
                    <%
                        while (itdi.hasNext()) {
                            Diplomado di = itdi.next();
                            String nombre = di.getTitle();
                            String institucion = di.getNombreInstitucion();
                            String inicio = ""+di.getInicio();
                            String fin = ""+di.getFin();
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
                if (itct != null && SWBUtils.Collections.sizeOf(itct) > 0) {
                    itct = cv.listCursosTICs();
            %>
            <li>
                <h4>Especialización en TIC</h4>
                <ul>
                    <%
                        while (itct.hasNext()) {
                            CursoTIC ct = itct.next();
                            String nombre = ct.getTitle();
                            String institucion = ct.getNombreInstitucion();
                            String inicio = ""+ct.getInicio();
                            String fin = ""+ct.getFin();
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
                if (itid != null && SWBUtils.Collections.sizeOf(itid) > 0) {
                    itid = cv.listIdiomas();
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
    <%
                if (cv != null) {
                    Iterator<Distincion> itdi = cv.listDistincions();
                    Iterator<AreaTalento> itat = cv.listAreaTalentos();
                    Iterator<ExperienciaLaboral> itel = cv.listExperienciaLaborals();
                    if (SWBUtils.Collections.sizeOf(itel) > 0 || SWBUtils.Collections.sizeOf(itat) > 0 || SWBUtils.Collections.sizeOf(itdi) > 0) {
    %>
    <div class="icv-print-experiencia">
        <h3>Experiencia</h3>
        <ul>
            <%
                itel = cv.listExperienciaLaborals();
                if (itel != null && SWBUtils.Collections.sizeOf(itel) > 0) {
                    itel = cv.listExperienciaLaborals();
            %>
            <li>
                <h4>Experiencia laboral</h4>
                <ul>
                    <%
                        while (itel.hasNext()) {
                            ExperienciaLaboral el = itel.next();
                            String empresa = el.getEmpresa();
                            String inicio = sdf.format(el.getFechaIni());
                            String fin = el.getFechaFin()!=null?sdf.format(el.getFechaFin()):"";
                            String cargo = el.getCargo();
                            String jefe = el.getJefe();
                            Telefono te = el.getTelefono();
                            
                            String lada = te!=null&&te.getLada() > 0 ? "(" + te.getLada() + ")" : "";
                            String numero = te!=null&&te.getNumero() > 0 ? "" + te.getNumero() : "";
                            String exten = te!=null&&te.getExtension() > 0 ? "Ext:" + te.getExtension() : "";
                            String sector= el.getSector().getTitle();
                            String funciones=el.getFuncionesPrincipales();
                                               %>
                    <li><strong><%=empresa%> (<%=sector%>)</strong> <br />
                        <%=inicio%> / <%=fin%>, <%=cargo%>,	(<%=lada%>) <%=numero%> <%=exten%><br />
                        Jefe inmediato: <%=jefe%> (<%=funciones%>)</li>
                        <%
                            }
                        %>
                </ul>
            </li>
            <%
                }
                itat = cv.listAreaTalentos();
                if (itat != null && SWBUtils.Collections.sizeOf(itat) > 0) {
                    itat = cv.listAreaTalentos();
            %>
            <li>
                <h4>Areas de talento o expertise</h4>
                <ul>
                    <%
                        while (itat.hasNext()) {
                            AreaTalento at = itat.next();
                            String area = at.getTipoAreaTalento().getTitle();
                            String habilidad = at.getHabilidad().getTitle();
                            String tiempo = "";
                            String otro = at.getOtraHabilidad();
                            if (at.getYearExperienceTalento() > 0) {
                                if (at.getYearExperienceTalento() == 1) {
                                    tiempo += at.getYearExperienceTalento() + " año";
                                } else {
                                    tiempo += at.getYearExperienceTalento() + " años";
                                }
                            }
                    %>
                    <li><strong><%=area%>:</strong> <%=habilidad%> <%=otro.equals("") ? "" : ", " + otro%>(<%=tiempo%>)</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                }
                itdi = cv.listDistincions();
                if (itdi != null && SWBUtils.Collections.sizeOf(itdi) > 0) {
                    itdi = cv.listDistincions();
            %>
            <li>
                <h4>Distinciones y reconocimientos</h4>
                <ul>
                    <%
                        while (itdi.hasNext()) {
                            Distincion di = itdi.next();
                            String titulo = di.getTitle();
                            String otorga = di.getOtorgante();
                            String fecha =  di.getFechaDistincion()!=null?sdf.format(di.getFechaDistincion()):"";
                    %>
                    <li><strong><%=titulo%></strong>, <%=otorga%> (<%=fecha%>)</li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <%
                }
            %>
        </ul>
    </div>
    <%
                    }
                }
    %>
    <%
                if (cv != null) {
                    Iterator<Competencia> itco = cv.listCompetencias();
                    if (itco != null && SWBUtils.Collections.sizeOf(itco) > 0) {
                        itco = cv.listCompetencias();
    %>
    <div class="icv-print-competencias">
        <h3>Competencias</h3>
        <ul>
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
        </ul>
    </div>
    <%
                    }
                }
    %>
    <%
                if (cv != null) {
                    Iterator<Investigacion> itin = cv.listInvestigacions();
                    Iterator<Docencia> itdo = cv.listDocencias();
                    Iterator<Publicacion> itpu = cv.listPublicacions();
                    if (SWBUtils.Collections.sizeOf(itin) > 0 || SWBUtils.Collections.sizeOf(itdo) > 0 || SWBUtils.Collections.sizeOf(itpu) > 0) {
    %>
    <div class="icv-print-investigacion">
        <h3>Investigación y docencia</h3>
        <ul>
            <%
                itin = cv.listInvestigacions();
                if (itin != null && SWBUtils.Collections.sizeOf(itin) > 0) {
                    itin = cv.listInvestigacions();
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
                                sni = in.getSniConacyt();
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
                itdo = cv.listDocencias();
                if (itdo != null && SWBUtils.Collections.sizeOf(itdo) > 0) {
                    itdo = cv.listDocencias();
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
                itpu = cv.listPublicacions();
                if (itpu != null && SWBUtils.Collections.sizeOf(itpu) > 0) {
                    itpu = cv.listPublicacions();
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
            %>
        </ul>
    </div>
    <%
                    }
                }
                if(showMenu){
    %>
    <p><a href="<%=(paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(Mode_PDF))%>" title="ver en pdf" target="_blank">ver en pdf</a></p>
    <p><a href="<%=(paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWBResourceURL.Mode_XML))%>" title="ver en xml" target="_blank">ver en xml</a></p>
    <%
                }
    %>
</div>