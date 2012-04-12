<%--   
    Document   : view Recurso ReporteInvestigacionDocencia
    Created on : 10/04/2012
    Author     : juan.fernandez
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.infotec.cvi.swb.Idioma"%>
<%@page import="com.infotec.cvi.swb.Escritura"%>
<%@page import="com.infotec.cvi.swb.Lectura"%>
<%@page import="com.infotec.cvi.swb.Conversacion"%>
<%@page import="org.semanticwb.model.Language"%>
<%@page import="com.infotec.cvi.swb.CursoTIC"%>
<%@page import="com.infotec.cvi.swb.Diplomado"%>
<%@page import="com.infotec.cvi.swb.Investigacion"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<%@page import="org.semanticwb.model.WebPage"%>
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
    String MODE_EXPORT = "export";

    String export = request.getParameter("export");
    if (null == export) {
        export = "";
    }
    if (export.equals("excel")) {
        response.setHeader("Content-Disposition", "inline; filename=\"reportInvestigacionDocencia" + System.currentTimeMillis() + ".xls\";");
        response.setContentType("application/vnd.ms-excel");
    }
    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (action == null) {
        action = "";
    }

    StringBuffer ret = new StringBuffer();

    if (request.getParameter("alertmsg") != null) {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br>", "\\n\\r");

        ret.append("\n\r<script type=\"text/javascript\">");
        ret.append("\n\r    alert('" + strMsg + "');");
        ret.append("\n\r</script>");

    }

    ret.append("\n\r<div >");
    ret.append("\n\r<div id=\"icv\">");
    ret.append("\n\r    <div id=\"icv-data\">");

    if (action.equals("")) {

        SWBResourceURL urlact = paramRequest.getRenderUrl();

        ret.append("\n\r        <ul>");
        ret.append("\n\r            <li><a href=\"" + urlact + "?act=sni\">SNI Conacyt</a></li>");
        ret.append("\n\r            <li><a href=\"" + urlact + "?act=curso\">Cursos de Posgrado Impartidos</a></li>");
        ret.append("\n\r            <li><a href=\"" + urlact + "?act=publicacion\">Publicaciones</a></li>");
        ret.append("\n\r        </ul>");

        out.println(ret.toString());
    } else if ("sni".equals(action)) {
        String wptitle = "SNI Conacyt";

        String step = "1";
        if (request.getParameter("step") != null) {
            step = request.getParameter("step");
        }
        if ("1".equals(step)) {

            HashMap<String, CV> hm = new HashMap<String, CV>(); // cvs encontrados
            HashMap<String, CV> hmno = new HashMap<String, CV>();
            Investigacion inves = null;
            long acum = 0, acumno = 0;
            Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
            while (itcv.hasNext()) {
                CV cv = itcv.next();
                String strSinInves = cv.getProperty(CV.intranet_sinInvestigacion.getName());
                if (strSinInves != null && strSinInves.equals("true")) {
                    hmno.put(cv.getId(), cv);
                    continue;
                }

                //if (UtilsCVI.isCVIDone(cv)) 
                {
                    if (cv.listInvestigacions().hasNext()) {
                        Iterator<Investigacion> itga = cv.listInvestigacions();
                        while (itga.hasNext()) {
                            inves = itga.next();
                            if (inves.getSniConacyt() != null && inves.getSniConacyt().trim().length() > 0) {
                                hm.put(cv.getId(), cv);
                            } else {
                                hmno.put(cv.getId(), cv);
                            }
                        }
                    }
                }
            }
            acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
            acumno = SWBUtils.Collections.sizeOf(hmno.keySet().iterator());

            if (acum == 0 && acumno == 0) {

                ret.append("\n\r       <p>No se encontraron registros.....</p> ");
            } else {


                ret.append("\n\r       <div><h2>" + wptitle + "</h2><span>");
                ret.append("\n\r               <table>");
                ret.append("\n\r                   <thead>");
                ret.append("\n\r                       <tr>");
                ret.append("\n\r                           <th colspan=\"3\">Investigación</th>");
                ret.append("\n\r                       </tr>");
                ret.append("\n\r                       <tr>");
                ret.append("\n\r                           <th>SNI Conacyt</th>");
                ret.append("\n\r                           <th>Encontrados</th>");
                ret.append("\n\r                           <th>Detalle</th>");
                ret.append("\n\r                       </tr>");
                ret.append("\n\r                   </thead>");
                ret.append("\n\r                   <tbody>");


                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                urldetail.setParameter("step", "2");
                urldetail.setParameter("act", "sni");
                urldetail.setParameter("reptype", "con");

                SWBResourceURL urldetail2 = paramRequest.getRenderUrl();
                urldetail2.setParameter("step", "2");
                urldetail2.setParameter("act", "sni");
                urldetail2.setParameter("reptype", "sin");



                ret.append("\n\r                      <tr>");
                ret.append("\n\r                          <td>Con SNI</td>");
                ret.append("\n\r                          <td>" + acum + "</td>");
                
                
                ret.append("\n\r                          <td><a href=\"" + urldetail + "\">ver</a></td>");
                
                ret.append("\n\r                      </tr>");
                ret.append("\n\r                      <tr>");
                ret.append("\n\r                          <td>Sin SNI</td>");
                ret.append("\n\r                          <td>" + acumno + "</td>");

                if (acumno == 0) {

                    ret.append("\n\r                          <td>&nbsp;</td>");

                } else {


                    ret.append("\n\r                         <td><a href=\"" + urldetail2 + "\">ver</a></td>");


                }


                ret.append("\n\r                     </tr>");

                ret.append("\n\r                 </tbody>");
                ret.append("\n\r             </table></span>");
                ret.append("\n\r     </div>");


                if (!export.equals("excel")) {
                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                    urlExport.setMode(MODE_EXPORT);
                    String reporte = ret.toString();
                    reporte = SWBUtils.TEXT.encodeBase64(reporte);
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"reporte\" value=\""+reporte+"\">");
                    if (request.getParameter("step") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"step\" value=\""+request.getParameter("step")+"\">");
                    }
                    if (request.getParameter("act") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"act\" value=\""+request.getParameter("act")+"\">");
                    }
                    if (request.getParameter("reptype") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"reptype\" value=\""+request.getParameter("reptype")+"\">");
                    }
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\">");
                    ret.append("\n\r<button type=\"submit\" >Guardar Excel</button>"); //onclick=\"window.location='" + urlExport.toString() + "';return false;\"
                    ret.append("\n\r</form>");
                }


            }
            out.println(ret.toString());
        } else { //step 2

            HashMap<String, CV> hm = new HashMap<String, CV>(); // cvs encontrados
            HashMap<String, CV> hmno = new HashMap<String, CV>();
            Investigacion inves = null;
            long acum = 0, acumno = 0;
            Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
            while (itcv.hasNext()) {
                CV cv = itcv.next();
                String strSinInves = cv.getProperty(CV.intranet_sinInvestigacion.getName());
                if (strSinInves != null && strSinInves.equals("true")) {
                    hmno.put(cv.getId(), cv);
                    continue;
                }

                //if (UtilsCVI.isCVIDone(cv)) 
                {
                    if (cv.listInvestigacions().hasNext()) {
                        Iterator<Investigacion> itga = cv.listInvestigacions();
                        while (itga.hasNext()) {
                            inves = itga.next();
                            if (inves.getSniConacyt() != null && inves.getSniConacyt().trim().length() > 0) {
                                hm.put(cv.getId(), cv);
                            } else {
                                hmno.put(cv.getId(), cv);
                            }
                        }
                    }
                }
            }
            acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
            String reptype = request.getParameter("reptype");
            String reporte = "";
            if (reptype.equals("con")) {
                reporte = listReport(hm, "SNI Conacyt", "con SNI", paramRequest, request);
            } else {
                reporte = listReport(hm, "SNI Conacyt", "sin SNI", paramRequest, request);
            }

            ret.append(reporte);

            if (!export.equals("excel")) {
                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                    urlExport.setMode(MODE_EXPORT);
                    reporte = ret.toString();
                    reporte = SWBUtils.TEXT.encodeBase64(reporte);
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"reporte\" value=\""+reporte+"\">");
                    if (request.getParameter("step") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"step\" value=\""+request.getParameter("step")+"\">");
                    }
                    if (request.getParameter("act") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"act\" value=\""+request.getParameter("act")+"\">");
                    }
                    if (request.getParameter("reptype") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"reptype\" value=\""+request.getParameter("reptype")+"\">");
                    }
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\">");
                    ret.append("\n\r<button type=\"submit\" >Guardar Excel</button>"); //onclick=\"window.location='" + urlExport.toString() + "';return false;\"
                    ret.append("\n\r</form>");
                }
            out.println(ret.toString());
        }
        
    } else if ("curso".equals(action)) {
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

        out.println(listReport(hm, txttype, request.getParameter("search"), paramRequest, request));
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
        out.println(listReport(hm, "idioma(" + wsite.getLanguage(idioma).getTitle() + ")", conversacion + "%," + lectura + "%," + escritura + "%", paramRequest, request));
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
            Resource resource = wsite.getResource("997");
            WebPage wpage = wsite.getWebPage("ver_CV");
            SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
            urldet.setParameter("id", usrcv.getId());
            urldet.setCallMethod(SWBResourceURL.Call_CONTENT);
            ret.append("                 <tr>");
            ret.append("                     <td>");
            ret.append(usrcv.getFullName());
            ret.append("                     </td><td><a href=\"#\" ");
            ret.append("onclick=\"javascript:newWin('");
            ret.append(urldet.toString());
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