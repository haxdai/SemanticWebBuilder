<%--   
    Document   : view Recurso ReporteInvestigacionDocencia
    Created on : 10/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Publicacion"%>
<%@page import="com.infotec.cvi.swb.Docencia"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
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
    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (action == null) {
        action = "";
    }
System.out.println("action: "+action); 
    StringBuffer ret = new StringBuffer();

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
                if (UtilsCVI.isCVIDone(cv)) 
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
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
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

                if (UtilsCVI.isCVIDone(cv)) 
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
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
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
        String wptitle = "Cursos de Postgrado Impartidos";
        String step = "1";
        if (request.getParameter("step") != null) {
            step = request.getParameter("step");
        }
        if ("1".equals(step)) {

            SWBResourceURL urlstep2 = paramRequest.getRenderUrl();
%>
<script type="text/javascript">
    function revisa(forma){          
        var texto = forma.numero.value;
        texto = texto.replace(' ','');
        if(forma.curso.checked){
            if(texto.length == 0){
                alert('Debes de poner el Número de cursos de posgrado impartidos.');
                forma.numero.focus();
                return false;
            } else if(isNaN(texto)){
                alert('Debes de poner números únicamente.');
                forma.numero.focus();
                return false;
            } else if(eval(texto)==0){
                alert('Debes de poner números mayores a cero.');
                forma.numero.focus();
                return false;
            }
        }
        return true;
    }
</script>
<div><h2><%=wptitle%></h2>
    <form method="post" action="<%=urlstep2%>" method="post">
        <input type="hidden" name="act" value="<%=action%>"/>
        <input type="hidden" name="step" value="2"/>
        <input type="checkbox" id="curso" name="curso" value="1" checked onclick="if(!this.checked){this.form.numero.disabled='disabled';;}else{this.form.numero.disabled='';}"/>
        <label for="numero">Número de cursos de posgrado impartidos: </label><input type="text" id="numero" name="numero" />
        <button type="submit" onclick="return revisa(this.form);">Buscar</button>
    </form>
</div>
<%
} else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC 

    String curso = request.getParameter("curso");
    String strNumero = request.getParameter("numero");
    if(strNumero==null) strNumero="0";
    int inumero = 0;
    try{
        inumero = Integer.parseInt(strNumero);
    }catch(Exception e){
        inumero = 0;
    }    
    if(curso==null) curso="0";
        
    Docencia doce = null;
    HashMap<String,CV> hm = new HashMap<String, CV>();
    long acum = 0;
    Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
    while (itcv.hasNext()) {
        CV cv = itcv.next();
        acum = 0;
        if (UtilsCVI.isCVIDone(cv)) {
            if (cv.listDocencias().hasNext()) {
                Iterator<Docencia> itga = cv.listDocencias();
                while (itga.hasNext()) {
                    doce = itga.next();
                    if(doce.getNivelDocencia()!=null){
                        String txtTitle = doce.getNivelDocencia().getTitle()!=null?doce.getNivelDocencia().getTitle():"";
                        if("Posgrado".equals(txtTitle)){ //&&curso.equals("1")
                            acum++;
                        }
                    } else if(curso.equals("0")){acum++;} 
                }
                if("1".equals(curso)){ // que han impartido cursos de posgrado
                    if(inumero<=acum){ // numero de cursos de posgrado impartidos
                        hm.put(cv.getId(), cv);
                    }
                } else { // que no han impartido cursos de posgrado
                    if(0==acum){ // ningun curso de posgrado impartido
                        hm.put(cv.getId(), cv);
                    }
                }
            }
        }
    }
    acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
    if (acum == 0) {
%>         
<p>No se encontraron registros</p>
<%  } else {

        String criteria = "";
        if("1".equals(curso)) criteria = "que hayan impartido por lo menos "+inumero+" curso(s).";
               else criteria = "que no hayan impartido cursos de posgrado.";
%>
<div><h2><%=wptitle%></h2>
    <table>
        <thead>
            <tr>
                <th colspan="3">Cursos de posgrado Impartidos - <%=criteria%></th>
            </tr>
        </thead>
        <tbody>
            <%
                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                    urldetail.setParameter("step", "3");
                    urldetail.setParameter("act", action);
                    urldetail.setParameter("curso", curso);
                    urldetail.setParameter("numero", ""+inumero);
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
        
<%

            if (!export.equals("excel")) {
                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                    urlExport.setMode(MODE_EXPORT);
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
                    if (request.getParameter("step") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"step\" value=\""+request.getParameter("step")+"\">");
                    }
                    if (request.getParameter("act") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"act\" value=\""+request.getParameter("act")+"\">");
                    }
                    if (request.getParameter("curso") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"curso\" value=\""+curso+"\">");
                    }
                    if (request.getParameter("numero") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"numero\" value=\""+inumero+"\">");
                    }
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\">");
                    ret.append("\n\r<button type=\"submit\" >Guardar Excel</button>"); //onclick=\"window.location='" + urlExport.toString() + "';return false;\"
                    ret.append("\n\r</form>");
                }
    out.println(ret.toString());

    // termina step 2
} else { // step 3 detalle reporte
    String curso = request.getParameter("curso");
    String strNumero = request.getParameter("numero");
    if(strNumero==null) strNumero="0";
    int inumero = 0;
    try{
        inumero = Integer.parseInt(strNumero);
    }catch(Exception e){
        inumero = 0;
    }    
    if(curso==null) curso="0";
        
    Docencia doce = null;
    HashMap<String,CV> hm = new HashMap<String, CV>();
    long acum = 0;
    Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
    while (itcv.hasNext()) {
        CV cv = itcv.next();
        acum = 0;
        if (UtilsCVI.isCVIDone(cv)) {
            if (cv.listDocencias().hasNext()) {
                Iterator<Docencia> itga = cv.listDocencias();
                while (itga.hasNext()) {
                    doce = itga.next();
                    if(doce.getNivelDocencia()!=null){
                        String txtTitle = doce.getNivelDocencia().getTitle()!=null?doce.getNivelDocencia().getTitle():"";
                        if("Posgrado".equals(txtTitle)&&curso.equals("1")){
                            acum++;
                        }
                    } else if(curso.equals("0")){acum++;} 
                }
                if("1".equals(curso)){ // que han impartido cursos de posgrado
                    if(inumero<=acum){ // numero de cursos de posgrado impartidos
                        hm.put(cv.getId(), cv);
                    }
                } else { // que no han impartido cursos de posgrado
                    hm.put(cv.getId(), cv);
                }
            }
        }
    }
    acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
    if (!hm.isEmpty()) {
        String txttype = "Cursos de posgrado Impartidos.";
        String criteria = "";
        if("1".equals(curso)) criteria = "que hayan impartido por lo menos "+inumero+" curso(s).";
               else criteria = "que no hayan impartido cursos de posgrado.";
        
        out.println(listReport(hm, txttype, criteria, paramRequest, request));
%>

<%
        }
    if (!export.equals("excel")) {
                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                    urlExport.setMode(MODE_EXPORT);
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
                    if (request.getParameter("step") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"step\" value=\""+request.getParameter("step")+"\">");
                    }
                    if (request.getParameter("act") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"act\" value=\""+request.getParameter("act")+"\">");
                    }
                    if (request.getParameter("curso") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"curso\" value=\""+curso+"\">");
                    }
                    if (request.getParameter("numero") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"numero\" value=\""+inumero+"\">");
                    }
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\">");
                    ret.append("\n\r<button type=\"submit\" >Guardar Excel</button>"); //onclick=\"window.location='" + urlExport.toString() + "';return false;\"
                    ret.append("\n\r</form>");
                }
    out.println(ret.toString());
    } //step 3 
} else if ("publicacion".equals(action)) {
    String wptitle = "Publicaciones";
    String step = "1";
        if (request.getParameter("step") != null) {
            step = request.getParameter("step");
        }
        if ("1".equals(step)) {

            SWBResourceURL urlstep2 = paramRequest.getRenderUrl();
%>
<script type="text/javascript">
    function revisaPub(forma){          
        var texto = forma.num.value;
        texto = texto.replace(' ','');
        if(forma.publi.checked){
            if(texto.length == 0){
                alert('Debes de poner el Número de cursos de publicaciones.');
                forma.num.focus();
                return false;
            } else if(isNaN(texto)){
                alert('Debes de poner números únicamente.');
                forma.num.focus();
                return false;
            } else if(eval(texto)==0){
                alert('Debes de poner números mayores a cero.');
                forma.num.focus();
                return false;
            }
        }
        return true;
    }
</script>
<div><h2><%=wptitle%></h2>
    <form method="post" action="<%=urlstep2%>" >
        <input type="hidden" name="act" value="<%=action%>"/>
        <input type="hidden" name="step" value="2"/>
        <input type="checkbox" id="publi" name="curso" value="1" checked onclick="if(!this.checked){this.form.num.disabled='disabled';}else{this.form.num.disabled='';}"/>
        <label for="num">Número de publicaciones: </label><input type="text" id="num" name="numero" />
        <button type="submit" onclick="return revisaPub(this.form);">Buscar</button>
    </form>
</div>
<%
} else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC 

    String curso = request.getParameter("curso");
    String strNumero = request.getParameter("numero");
    if(strNumero==null) strNumero="0";
    int inumero = 0;
    try{
        inumero = Integer.parseInt(strNumero);
    }catch(Exception e){
        inumero = 0;
    }    
    if(curso==null) curso="0";
        
    Publicacion doce = null;
    HashMap<String,CV> hm = new HashMap<String, CV>();
    long acum = 0;
    Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
    while (itcv.hasNext()) {
        CV cv = itcv.next();
        acum = 0;
        if (UtilsCVI.isCVIDone(cv)) {
            if (cv.listDocencias().hasNext()) {
                Iterator<Publicacion> itga = cv.listPublicacions();
                while (itga.hasNext()) {
                    doce = itga.next();
                    acum++; 
                }
                if("1".equals(curso)){ // que han hecho publicaciones
                    if(inumero<=acum){ // numero de publicaciones realizadas
                        hm.put(cv.getId(), cv);
                    }
                } else { // que no han hecho publicaciones
                    if(0==acum){ // ninguna publicacion
                        hm.put(cv.getId(), cv);
                    }
                }
            }
        }
    }
    acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
    if (acum == 0) {
%>         
<p>No se encontraron registros</p>
<%  } else {

        String criteria = "";
        if("1".equals(curso)) criteria = "que hayan realizado por lo menos "+inumero+" publicación(es).";
               else criteria = "que no hayan realizado ninguna publicación.";
%>
<div><h2><%=wptitle%></h2>
    <table>
        <thead>
            <tr>
                <th colspan="3">Publicaciones - <%=criteria%></th>
            </tr>
        </thead>
        <tbody>
            <%
                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                    urldetail.setParameter("step", "3");
                    urldetail.setParameter("act", action);
                    urldetail.setParameter("curso", curso);
                    urldetail.setParameter("numero", ""+inumero);
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
        
<%

            if (!export.equals("excel")) {
                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                    urlExport.setMode(MODE_EXPORT);
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
                    if (request.getParameter("step") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"step\" value=\""+request.getParameter("step")+"\">");
                    }
                    if (request.getParameter("act") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"act\" value=\""+request.getParameter("act")+"\">");
                    }
                    if (request.getParameter("curso") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"curso\" value=\""+curso+"\">");
                    }
                    if (request.getParameter("numero") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"numero\" value=\""+inumero+"\">");
                    }
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\">");
                    ret.append("\n\r<button type=\"submit\" >Guardar Excel</button>"); //onclick=\"window.location='" + urlExport.toString() + "';return false;\"
                    ret.append("\n\r</form>");
                }
    out.println(ret.toString());

    // termina step 2
} else { // step 3 detalle reporte
    String curso = request.getParameter("curso");
    String strNumero = request.getParameter("numero");
    if(strNumero==null) strNumero="0";
    int inumero = 0;
    try{
        inumero = Integer.parseInt(strNumero);
    }catch(Exception e){
        inumero = 0;
    }    
    if(curso==null) curso="0";
        
    Publicacion doce = null;
    HashMap<String,CV> hm = new HashMap<String, CV>();
    long acum = 0;
    Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
    while (itcv.hasNext()) {
        CV cv = itcv.next();
        acum = 0;
        if (UtilsCVI.isCVIDone(cv)) {
            if (cv.listDocencias().hasNext()) {
                Iterator<Publicacion> itga = cv.listPublicacions();
                while (itga.hasNext()) {
                    doce = itga.next();
                    acum++; 
                }
                if("1".equals(curso)){ // que han hecho publicaciones
                    if(inumero<=acum){ // numero de publicaciones realizadas
                        hm.put(cv.getId(), cv);
                    }
                } else { // que no han hecho publicaciones
                    if(0==acum){ // ninguna publicacion
                        hm.put(cv.getId(), cv);
                    }
                }
            }
        }
    }
    acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
    if (!hm.isEmpty()) {
        String txttype = "Publicaciones";
        String criteria = "";
        if("1".equals(curso)) criteria = "que hayan realizado por lo menos "+inumero+" publicación(es).";
               else criteria = "que no hayan realizado ninguna publicación.";
        
        out.println(listReport(hm, txttype, criteria, paramRequest, request));
%>

<%
        }
    if (!export.equals("excel")) {
                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                    urlExport.setMode(MODE_EXPORT);
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\" method=\"post\">");
                    ret.append("\n\r<input type=\"hidden\" name=\"export\" value=\"excel\">");
                    if (request.getParameter("step") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"step\" value=\""+request.getParameter("step")+"\">");
                    }
                    if (request.getParameter("act") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"act\" value=\""+request.getParameter("act")+"\">");
                    }
                    if (request.getParameter("curso") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"curso\" value=\""+curso+"\">");
                    }
                    if (request.getParameter("numero") != null) {
                        ret.append("\n\r<input type=\"hidden\" name=\"numero\" value=\""+inumero+"\">");
                    }
                    ret.append("\n\r<form action=\""+urlExport.toString()+"\">");
                    ret.append("\n\r<button type=\"submit\" >Guardar Excel</button>"); //onclick=\"window.location='" + urlExport.toString() + "';return false;\"
                    ret.append("\n\r</form>");
                }
    out.println(ret.toString());
    } //step 3 
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

    

%>