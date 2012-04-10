<%--   
    Document   : view Recurso ReporteEscolaridad
    Created on : 02/04/2012
    Author     : juan.fernandez
--%>

<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="com.infotec.cvi.swb.Escritura"%>
<%@page import="com.infotec.cvi.swb.Lectura"%>
<%@page import="com.infotec.cvi.swb.Conversacion"%>
<%@page import="org.semanticwb.model.Language"%>
<%@page import="com.infotec.cvi.swb.Idioma"%>
<%@page import="com.infotec.cvi.swb.Diplomado"%>
<%@page import="com.infotec.cvi.swb.CursoTIC"%>
<%@page import="com.infotec.cvi.swb.DisciplinaEstudio"%>
<%@page import="com.infotec.cvi.swb.AreaEstudio"%>
<%@page import="com.infotec.cvi.swb.Estudios"%>
<%@page import="com.infotec.cvi.swb.Avance"%>
<%@page import="com.infotec.cvi.swb.TipoEstudio"%>
<%@page import="com.infotec.cvi.swb.EstudioSuperior"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<%@page import="com.infotec.cvi.swb.SituacionAcademica"%>
<%@page import="com.infotec.cvi.swb.Carrera"%>
<%@page import="com.infotec.cvi.swb.Grado"%>
<%@page import="com.infotec.cvi.swb.base.GradoBase"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.GradoAcademico"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.util.Set"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;

    Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = request.getParameter("act");

    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (action == null) {
        action = "";
    }


    if (request.getParameter("alertmsg") != null) {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>');
</script>
<%
    }
%>
<div >  
    <div id="icv">
        <!-- %@include file="../menucvi.jsp" % -->

        <div id="icv-data">
            <%
                if (action.equals("")) {

                    SWBResourceURL urlact = paramRequest.getRenderUrl();
            %>
            <ul>
                <li><a href="<%=urlact%>?act=grado">Grado Académico y Estudios Superiores</a></li>
                <li><a href="<%=urlact%>?act=tic">Diplomados, cursos y certificaciones, Cursos especiaizados en TICs</a></li>
                <li><a href="<%=urlact%>?act=idioma">Idiomas</a></li>
            </ul>
            <%
            } else if ("grado".equals(action)) {
                String wptitle = "Grado Académico y Estudios Superiores";

                String step = "1";
                if (request.getParameter("step") != null) {
                    step = request.getParameter("step");
                }
                if ("1".equals(step)) {
                    HashMap<String, Integer> hm = new HashMap<String, Integer>(); // grado|situacion
                    HashMap<String, Integer> hmes = new HashMap<String, Integer>(); // tipoestudio|situacion
                    Academia aca = null;
                    GradoAcademico ga = null;
                    EstudioSuperior est = null;
                    Integer acum = null;
                    Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                    while (itcv.hasNext()) {
                        CV cv = itcv.next();
                        if (UtilsCVI.isCVIDone(cv)) {
                            aca = cv.getAcademia();
                            if (null != aca) {
                                if (aca.listGradoAcademicos().hasNext()) {
                                    Iterator<GradoAcademico> itga = aca.listGradoAcademicos();
                                    while (itga.hasNext()) {
                                        ga = itga.next();
                                        String key = ga.getGrado().getId() + "|" + ga.getSituacionAcademica().getId();
                                        if (hm.get(key) != null) {
                                            acum = hm.get(key);
                                            int num = acum.intValue() + 1;
                                            acum = new Integer(num);
                                            hm.put(key, acum);
                                        } else {
                                            hm.put(key, new Integer(1));
                                        }
                                    }
                                }
                                if (aca.listEstudioSuperiors().hasNext()) {
                                    Iterator<EstudioSuperior> ites = aca.listEstudioSuperiors();
                                    while (ites.hasNext()) {
                                        est = ites.next();
                                        if (est.getEstudiosSuperiores() == null) {
                                            continue;
                                        }
                                        Estudios estudio = est.getEstudiosSuperiores();
                                        if (estudio.getAreaEstudio() == null) {
                                            continue;
                                        }
                                        AreaEstudio aestudio = estudio.getAreaEstudio();
                                        if (aestudio.getDisciplinaInv() == null) {
                                            continue;
                                        }
                                        DisciplinaEstudio disc = aestudio.getDisciplinaInv();
                                        if (disc.getTipoEstudioInv() == null) {
                                            continue;
                                        }
                                        TipoEstudio testudio = disc.getTipoEstudioInv();
                                        String idtipo = testudio.getId();
                                        String key = idtipo + "|" + est.getGradoAvance().getId();
                                        if (hmes.get(key) != null) {
                                            acum = hmes.get(key);
                                            int num = acum.intValue() + 1;
                                            acum = new Integer(num);
                                            hmes.put(key, acum);
                                        } else {
                                            hmes.put(key, new Integer(1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (hm != null && hm.isEmpty() && hmes != null && hmes.isEmpty()) {
            %>         
            <p>No se encontraron registros</p>
            <%} else {

            %>
            <div><h2><%=wptitle%></h2><span>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="3">Grado Académico</th>
                            </tr>
                            <%
                                if (hm.isEmpty()) {
                                    out.println("<tr><th colspan=\"3\">No se encontraron registros</th></tr></thead>");
                                } else {

                            %>
                            <tr>
                                <th>Grado Académico</th>
                                <th>Situación Académica</th>
                                <th>Encontrados</th>
                                <th>Detalle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%

                                Iterator<String> itres = hm.keySet().iterator();
                                while (itres.hasNext()) {
                                    String key = itres.next();
                                    StringTokenizer stoken = new StringTokenizer(key, "|");
                                    String idgrado = stoken.nextToken();
                                    String idsitaca = stoken.nextToken();
                                    Grado gra = Grado.ClassMgr.getGrado(idgrado, wsite);

                                    SituacionAcademica sitaca = SituacionAcademica.ClassMgr.getSituacionAcademica(idsitaca, wsite);
                                    Integer intres = hm.get(key);

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "2");
                                    urldetail.setParameter("act", "grado");
                                    urldetail.setParameter("reptype", "grado");
                                    urldetail.setParameter("id1", idgrado);
                                    urldetail.setParameter("id2", idsitaca);

                            %>
                            <tr>
                                <td><%=gra.getTitle() != null ? gra.getTitle() : "---"%></td>
                                <td><%=sitaca.getTitle() != null ? sitaca.getTitle() : "---"%></td>
                                <td><%=intres != null ? intres.intValue() : "---"%></td>
                                <td><a href="<%=urldetail%>">ver</a></td>
                            </tr>
                            <%              }

                                }
                            %>                 
                        </tbody>
                        <%
                            // }              
%>
                    </table></span>
            </div>
            <div><span>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="3">Estudios Superiores</th>
                            </tr>
                            <%
                                if (hmes.isEmpty()) {
                                    out.println("<tr><th colspan=\"3\">No se encontraron registros</th></tr></thead>");
                                } else {

                            %>
                            <tr>
                                <th>Tipo Estudio</th>
                                <th>% avance</th>
                                <th>Encontrados</th>
                                <th>Detalle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%

                                Iterator<String> itres = hmes.keySet().iterator();
                                while (itres.hasNext()) {
                                    String key = itres.next();
                                    StringTokenizer stoken = new StringTokenizer(key, "|");
                                    String idtipo = stoken.nextToken();
                                    String idgrado = stoken.nextToken();
                                    TipoEstudio tipo = TipoEstudio.ClassMgr.getTipoEstudio(idtipo, wsite);

                                    Avance avance = Avance.ClassMgr.getAvance(idgrado, wsite);
                                    Integer intres = hmes.get(key);

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "2");
                                    urldetail.setParameter("act", "grado");
                                    urldetail.setParameter("reptype", "superior");
                                    urldetail.setParameter("id1", idtipo);
                                    urldetail.setParameter("id2", idgrado);
                            %>
                            <tr>
                                <td><%=tipo.getTitle() != null ? tipo.getTitle() : "---"%></td>
                                <td><%=avance.getTitle() != null ? avance.getTitle() : "---"%></td>
                                <td><%=intres != null ? intres.intValue() : "---"%></td>
                                <td><a href="<%=urldetail%>">ver</a></td>
                            </tr>
                            <%              }

                                }
                            %>                 
                        </tbody>
                        <%
                            }
                        %>
                    </table></span>
            </div>
            <%
                } else { //step 2

                    String id1 = request.getParameter("id1");
                    String id2 = request.getParameter("id2");
                    String reptype = request.getParameter("reptype");
                    String txttype = "", criteria = "";
                    HashMap<String, CV> hm = new HashMap<String, CV>(); // grado|situacion

                    Academia aca = null;
                    GradoAcademico ga = null;
                    EstudioSuperior est = null;
                    Integer acum = null;
                    Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                    while (itcv.hasNext()) {
                        CV cv = itcv.next();
                        if (UtilsCVI.isCVIDone(cv)) {
                            aca = cv.getAcademia();
                            if (null != aca) {
                                if (aca.listGradoAcademicos().hasNext() && reptype.equals("grado")) {
                                    txttype = "Grado Académico";
                                    Iterator<GradoAcademico> itga = aca.listGradoAcademicos();
                                    while (itga.hasNext()) {
                                        ga = itga.next();
                                        String key = ga.getGrado().getId() + "|" + ga.getSituacionAcademica().getId();
                                        String ids = id1 + "|" + id2;
                                        if (key.equals(ids)) {
                                            criteria = ga.getGrado().getTitle() + " - " + ga.getSituacionAcademica().getTitle();
                                            hm.put(cv.getId(), cv);
                                        }
                                    }
                                }
                                if (aca.listEstudioSuperiors().hasNext() && reptype.equals("superior")) {
                                    txttype = "Estudios Superiores";
                                    Iterator<EstudioSuperior> ites = aca.listEstudioSuperiors();
                                    while (ites.hasNext()) {
                                        est = ites.next();
                                        if (est.getEstudiosSuperiores() == null) {
                                            continue;
                                        }
                                        Estudios estudio = est.getEstudiosSuperiores();
                                        if (estudio.getAreaEstudio() == null) {
                                            continue;
                                        }
                                        AreaEstudio aestudio = estudio.getAreaEstudio();
                                        if (aestudio.getDisciplinaInv() == null) {
                                            continue;
                                        }
                                        DisciplinaEstudio disc = aestudio.getDisciplinaInv();
                                        if (disc.getTipoEstudioInv() == null) {
                                            continue;
                                        }
                                        TipoEstudio testudio = disc.getTipoEstudioInv();
                                        String idtipo = testudio.getId();
                                        String key = idtipo + "|" + est.getGradoAvance().getId();
                                        String ids = id1 + "|" + id2;
                                        if (key.equals(ids)) {
                                            criteria = testudio.getTitle() + " - " + est.getGradoAvance().getTitle();
                                            hm.put(cv.getId(), cv);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    out.println(listReport(hm, txttype, criteria, paramRequest,request));
                }
            } else if ("tic".equals(action)) {
                String wptitle = "Diplomados, cursos y certificaciones, Cursos Especializados TICs";
                String step = "1";
                if (request.getParameter("step") != null) {
                    step = request.getParameter("step");
                }
                if ("1".equals(step)) {

                    SWBResourceURL urlstep2 = paramRequest.getRenderUrl();
            %>
            <script type="text/javascript">
                function revisa(forma){
                    
                    var texto = forma.search.value;
                    texto = texto.replace(' ','');
                    if(texto.length==0){
                        alert('Debes de poner el Diplomado, Curso, Certificación´o Curso Especializado en TIC a buscar');
                        return false;
                    }
                    return true;
                }
            </script>
            <div><h2><%=wptitle%></h2>
                <form method="post" action="<%=urlstep2%>">
                    <input type="hidden" name="act" value="<%=action%>"/>
                    <input type="hidden" name="step" value="2"/>
                    <label for="search">Poner el nombre del Curso, Diplomado, Certificación ó Curso TIC: </label><input type="text" id="search" name="search" />
                    <button type="submit" onclick="return revisa(this.form)">Buscar</button>
                </form>
            </div>
            <%
            } else if (step.equals("2")) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC

                String txtbuscar = request.getParameter("search");
                //System.out.println("Step 2, "+txtbuscar);
                txtbuscar = txtbuscar.trim().toLowerCase();
                txtbuscar = SWBUtils.TEXT.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);

                Diplomado diplo = null;
                CursoTIC ctic = null;
                int acum = 0;
                int acumtic = 0;
                Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                while (itcv.hasNext()) {
                    CV cv = itcv.next();
                    if (UtilsCVI.isCVIDone(cv)) {
                        if (cv.listDiplomados().hasNext()) {
                            Iterator<Diplomado> itga = cv.listDiplomados();
                            while (itga.hasNext()) {
                                diplo = itga.next();
                                String txt = diplo.getDocumentoObtenido() != null ? diplo.getDocumentoObtenido() : "";
                                txt = txt + (diplo.getTitle() != null ? diplo.getTitle() : "");
                                txt = txt + (diplo.getDescription() != null ? diplo.getDescription() : "");
                                txt = txt + (diplo.getNombreInstitucion() != null ? diplo.getNombreInstitucion() : "");
                                txt = txt.trim().toLowerCase();
                                txt = SWBUtils.TEXT.replaceSpecialCharacters(txt, Boolean.FALSE);
                                //System.out.println("Diplomado txt: "+txt+" "+txt.indexOf(txtbuscar));
                                if (txt.indexOf(txtbuscar) > -1) {
                                    acum++;
                                }
                            }
                        }
                        if (cv.listCursosTICs().hasNext()) {
                            Iterator<CursoTIC> ites = cv.listCursosTICs();
                            while (ites.hasNext()) {
                                ctic = ites.next();
                                String txt = ctic.getDocumentoObtenido() != null ? ctic.getDocumentoObtenido() : "";
                                txt = txt + (ctic.getTitle() != null ? ctic.getTitle() : "");
                                txt = txt + (ctic.getDescription() != null ? ctic.getDescription() : "");
                                txt = txt + (ctic.getNombreInstitucion() != null ? ctic.getNombreInstitucion() : "");
                                txt = txt.trim().toLowerCase();
                                txt = SWBUtils.TEXT.replaceSpecialCharacters(txt, Boolean.FALSE);
                                //System.out.println("TIC txt: "+txt+" "+txt.indexOf(txtbuscar));
                                if (txt.indexOf(txtbuscar) > -1) {
                                    acumtic++;
                                }
                            }
                        }
                    }

                }
                //System.out.println("diplos: "+acum+", TICs: "+acumtic);
                if (acum == 0 && acumtic == 0) {
            %>         
            <p>No se encontraron registros</p>
            <%  } else {

            %>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th colspan="3">Diplomados, cursos y Certificaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (acum == 0) {
                                out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                            } else {

                                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                urldetail.setParameter("step", "3");
                                urldetail.setParameter("act", action);
                                urldetail.setParameter("search", txtbuscar);
                                urldetail.setParameter("type", "diplomado");

                        %>
                        <tr>
                            <td>Encontrados</td><td><%=acum%></td><td><a href="<%=urldetail%>">ver</a></td>
                        </tr>
                    </tbody>
                    <%
                        }
                    %>                 
                </table>
            </div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th colspan="3">Cursos Especializados en TICs</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (acumtic == 0) {
                                out.println("<tr><th colspan=\"3\">No se encontraron registros</th></tr>");
                            } else {


                                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                urldetail.setParameter("step", "3");
                                urldetail.setParameter("act", action);
                                urldetail.setParameter("search", txtbuscar);
                                urldetail.setParameter("type", "tic");

                        %>
                        <tr>
                            <td>Encontrados</td><td><%=acumtic%></td><td><a href="<%=urldetail%>">ver</a></td>
                        </tr>
                        <%
                            }
                        %>                 
                    </tbody>
                    <%
                        }
                    %>
                </table>
            </div>
            <%
                // termina step 2
            } else { // step 3 detalle reporte
                String txtbuscar = request.getParameter("search");
                String reptype = request.getParameter("type");
                //System.out.println("Step 2, "+txtbuscar);
                txtbuscar = txtbuscar.trim().toLowerCase();
                txtbuscar = SWBUtils.TEXT.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);

                HashMap<String, CV> hm = new HashMap<String, CV>();
                Diplomado diplo = null;
                CursoTIC ctic = null;
                int acum = 0;
                int acumtic = 0;
                Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                while (itcv.hasNext()) {
                    CV cv = itcv.next();
                    if (UtilsCVI.isCVIDone(cv)) {
                        if (cv.listDiplomados().hasNext() && reptype.equals("diplomado")) {
                            Iterator<Diplomado> itga = cv.listDiplomados();
                            while (itga.hasNext()) {
                                diplo = itga.next();
                                String txt = diplo.getDocumentoObtenido() != null ? diplo.getDocumentoObtenido() : "";
                                txt = txt + (diplo.getTitle() != null ? diplo.getTitle() : "");
                                txt = txt + (diplo.getDescription() != null ? diplo.getDescription() : "");
                                txt = txt + (diplo.getNombreInstitucion() != null ? diplo.getNombreInstitucion() : "");
                                txt = txt.trim().toLowerCase();
                                txt = SWBUtils.TEXT.replaceSpecialCharacters(txt, Boolean.FALSE);
                                //System.out.println("Diplomado txt: "+txt+" "+txt.indexOf(txtbuscar));
                                if (txt.indexOf(txtbuscar) > -1) {
                                    hm.put(cv.getId(), cv);
                                }
                            }
                        }
                        if (cv.listCursosTICs().hasNext() && reptype.equals("tic")) {
                            Iterator<CursoTIC> ites = cv.listCursosTICs();
                            while (ites.hasNext()) {
                                ctic = ites.next();
                                String txt = ctic.getDocumentoObtenido() != null ? ctic.getDocumentoObtenido() : "";
                                txt = txt + (ctic.getTitle() != null ? ctic.getTitle() : "");
                                txt = txt + (ctic.getDescription() != null ? ctic.getDescription() : "");
                                txt = txt + (ctic.getNombreInstitucion() != null ? ctic.getNombreInstitucion() : "");
                                txt = txt.trim().toLowerCase();
                                txt = SWBUtils.TEXT.replaceSpecialCharacters(txt, Boolean.FALSE);
                                //System.out.println("TIC txt: "+txt+" "+txt.indexOf(txtbuscar));
                                if (txt.indexOf(txtbuscar) > -1) {
                                    hm.put(cv.getId(), cv);
                                }
                            }
                        }
                    }

                }
                if (!hm.isEmpty()) {
                    String txttype = "Diplomados, cursos y certificaciones.";
                    if (reptype.equals("tic")) {
                        txttype = "Cursos Especializados en TICs";
                    }

                    out.println(listReport(hm, txttype, request.getParameter("search"), paramRequest,request));
            %>

            <%
                    }
                } //step 3 
            } else if ("idioma".equals(action)) {
                String wptitle = "Idiomas";
                String step = "1";
                if (request.getParameter("step") != null) {
                    step = request.getParameter("step");
                }
                if ("1".equals(step)) {

                    SWBResourceURL urlstep2 = paramRequest.getRenderUrl();
            %>
            <script type="text/javascript">
                function revisa(forma){
                    
                    var texto = forma.idioma.value;
                    if(texto=="-1"){
                        alert('Debes de seleccionar un idioma.');
                        forma.idioma.focus();
                        return false;
                    }
                    texto = forma.conversacion.value;
                    if(texto=="-1"){
                        alert('Debes de seleccionar % conversacion.');
                        forma.conversacion.focus();
                        return false;
                    }
                    texto = forma.lectura.value;
                    if(texto=="-1"){
                        alert('Debes de seleccionar % lectura.');
                        forma.lectura.focus();
                        return false;
                    }
                    texto = forma.escritura.value;
                    if(texto=="-1"){
                        alert('Debes de seleccionar % escritura.');
                        forma.escritura.focus();
                        return false;
                    }
                    return true;
                }
            </script>
            <div><h2><%=wptitle%></h2>
                <form method="post" action="<%=urlstep2%>">
                    <input type="hidden" name="act" value="<%=action%>"/>
                    <input type="hidden" name="step" value="2"/>
                    <table>
                        <thead>
                            <tr><th>Idioma</th><th>% conversación</th><th>% lectura</th><th>% escritura</th></tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <select name="idioma"><option value="-1" selected></option>
                                        <%
                                            Iterator<Language> itidioma = wsite.listLanguages();
                                            while (itidioma.hasNext()) {
                                                Language idi = itidioma.next();
                                                String txtidioma = idi.getTitle();
                                        %>
                                        <option value="<%=idi.getId()%>"><%=txtidioma%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                                <td>
                                    <select name="conversacion"><option value="-1" selected></option>
                                        <%
                                            Iterator<Conversacion> itconv = Conversacion.ClassMgr.listConversacions(wsite);
                                            while (itconv.hasNext()) {
                                                Conversacion conv = itconv.next();
                                                String txtconv = conv.getTitle();
                                        %>
                                        <option value="<%=txtconv%>"><%=txtconv%></option>
                                        <%
                                            }
                                        %>
                                    </select>    
                                </td>
                                <td>
                                    <select name="lectura"><option value="-1" selected></option>
                                        <%
                                            Iterator<Lectura> itlec = Lectura.ClassMgr.listLecturas(wsite);
                                            while (itlec.hasNext()) {
                                                Lectura lec = itlec.next();
                                                String txtlec = lec.getTitle();
                                        %>
                                        <option value="<%=txtlec%>"><%=txtlec%></option>
                                        <%
                                            }
                                        %>
                                    </select>  
                                </td>
                                <td>
                                    <select name="escritura"><option value="-1" selected></option>
                                        <%
                                            Iterator<Escritura> itesc = Escritura.ClassMgr.listEscrituras(wsite);
                                            while (itesc.hasNext()) {
                                                Escritura esc = itesc.next();
                                                String txtesc = esc.getTitle();
                                        %>
                                        <option value="<%=txtesc%>"><%=txtesc%></option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <button type="submit" onclick="return revisa(this.form)" >Buscar</button> 
                </form>
            </div>
            <%
            } else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC

                String idioma = request.getParameter("idioma");
                String conversacion = request.getParameter("conversacion");
                String lectura = request.getParameter("lectura");
                String escritura = request.getParameter("escritura");
                int pconv = 0, plec = 0, pesc = 0;
                try {
                    pconv = Integer.parseInt(conversacion);
                } catch (Exception e) {
                    pconv = 0;
                }
                try {
                    plec = Integer.parseInt(lectura);
                } catch (Exception e) {
                    plec = 0;
                }
                try {
                    pesc = Integer.parseInt(escritura);
                } catch (Exception e) {
                    pesc = 0;
                }

                
                
                HashMap<String, CV> hm = searchIdioma(paramRequest, idioma, conversacion, lectura, escritura);

                long acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                //System.out.println("CV idioma: "+acum);
                if (acum == 0) {
            %>         
            <p>No se encontraron registros</p>
            <%  } else {

            %>
            <div><p>
                <table>
                    <thead>
                        <tr>
                            <th colspan="3">Idioma(<%=wsite.getLanguage(idioma).getTitle()%>,<%=pconv%>%,<%=plec%>%,<%=pesc%>%)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (acum == 0) {
                                out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                            } else {

                                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                urldetail.setParameter("step", "3");
                                urldetail.setParameter("act", action);
                                urldetail.setParameter("idioma", idioma);
                                urldetail.setParameter("conversacion", conversacion);
                                urldetail.setParameter("lectura", lectura);
                                urldetail.setParameter("escritura", escritura);
                                
                                long acum2 = SWBUtils.Collections.sizeOf(hm.keySet().iterator());

                        %>
                        <tr>
                            <td>Encontrados</td><td><%=acum%></td><td><a href="<%=urldetail%>">ver</a></td>
                        </tr>
                    </tbody>
                    <%
                        }
                    %>                 
                </table>
                </p></div>

            <%
                    }
                } else { // termina step 2, step 3 detalle
                    String idioma = request.getParameter("idioma");
                    String conversacion = request.getParameter("conversacion");
                    String lectura = request.getParameter("lectura");
                    String escritura = request.getParameter("escritura");

                    HashMap<String, CV> hm = new HashMap<String, CV>(); // diplomado

                    hm = searchIdioma(paramRequest, idioma, conversacion, lectura, escritura);
                    out.println(listReport(hm, "idioma(" + wsite.getLanguage(idioma).getTitle() + ")", conversacion + "%," + lectura + "%," + escritura + "%", paramRequest,request));
                }
            }
            %>         
        </div><!-- icv-data -->  
    </div>
</div>

<%!
    public String listReport(HashMap<String, CV> hm, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
        StringBuilder ret = new StringBuilder();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        ret.append("<script type=\"text/javascript\">");
        ret.append(" function newWin(url){");
        ret.append("    window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');");
        ret.append("    ");
        ret.append("");
        ret.append("");
        ret.append("}");
        ret.append("</script>");
        ret.append("<div><h2>");
        ret.append(txttype);
        ret.append("     </h2>");
        ret.append("     <h3> que contengan: ");
        ret.append(criteria);
        ret.append("     </h3>");
        ret.append("        <table>");
        ret.append("            <thead>");
        ret.append("                <tr>");
        ret.append("                    <th>Usuario</th><th>Detalle</th>");
        ret.append("                </tr>");
        ret.append("            </thead>");
        ret.append("            <tbody>");
        Iterator<String> itstr = hm.keySet().iterator();
        while (itstr.hasNext()) {
            String key = itstr.next();

            User usrcv = wsite.getUserRepository().getUser(key);
            Resource resource = wsite.getResource("890");
            WebPage wpage = wsite.getWebPage("ver_CV");
            SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
            //urldet.setParameter("act", "detailcv");
            urldet.setParameter("id", usrcv.getId());
            urldet.setCallMethod(SWBResourceURL.Call_CONTENT); 
            ret.append("                 <tr>");
            ret.append("                     <td>");
            ret.append(usrcv.getFullName());
            ret.append("                     </td><td><a href=\"#\" ");
            ret.append("onclick=\"javascript:newWin('");
            ret.append(urldet);
            ret.append("');return false;\" target=\"_blank\">ver</a>");
            ret.append("                   </td>");
            ret.append("                  </tr>");

        }

        ret.append("               </tbody>");
        ret.append("          </table>");
        ret.append("</div>");
        return ret.toString();
    }
    
    public HashMap<String, CV> searchIdioma(SWBParamRequest paramRequest, String idioma, String conversacion, String lectura, String escritura) {
        HashMap<String, CV> hm = new HashMap<String, CV>();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        int pconv = 0, plec = 0, pesc = 0;
        try {
            pconv = Integer.parseInt(conversacion);
        } catch (Exception e) {
            pconv = 0;
        }
        try {
            plec = Integer.parseInt(lectura);
        } catch (Exception e) {
            plec = 0;
        }
        try {
            pesc = Integer.parseInt(escritura);
        } catch (Exception e) {
            pesc = 0;
        }

        Idioma idi = null;
        Conversacion oconv = null;
        Escritura oesc = null;
        Lectura olec = null;
        int iconv = 0, iesc = 0, ilec = 0;
        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
        while (itcv.hasNext()) {
            CV cv = itcv.next();
            if (UtilsCVI.isCVIDone(cv)) {
                if (cv.listIdiomas().hasNext()) {
                    Iterator<Idioma> itga = cv.listIdiomas();
                    while (itga.hasNext()) {
                        idi = itga.next();
                        oconv = idi.getConversacion();
                        oesc = idi.getEscritura();
                        olec = idi.getLectura();

                        try {
                            iconv = Integer.parseInt(oconv.getTitle());
                        } catch (Exception e) {
                            iconv = -1;
                        }
                        try {
                            iesc = Integer.parseInt(oesc.getTitle());
                        } catch (Exception e) {
                            iesc = -1;
                        }
                        try {
                            ilec = Integer.parseInt(olec.getTitle());
                        } catch (Exception e) {
                            ilec = -1;
                        }
                        if (iconv == -1 || iesc == -1 || ilec == -1) {
                            continue;
                        }
                        if (idioma.equals(idi.getIdiomas().getId()) && iconv >= pconv && ilec >= plec && iesc >= pesc) {
                            hm.put(cv.getId(), cv);
                        }
                    }
                }

            }

        }
        return hm;
    }

%>