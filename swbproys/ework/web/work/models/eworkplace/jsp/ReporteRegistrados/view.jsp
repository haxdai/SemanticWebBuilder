<%--   
    Document   : view Recurso ReporteRegistrados
    Created on : 17/04/2012
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

    StringBuffer ret = new StringBuffer();
%>
<div >
    <div id="icv">
        <div id="icv-data"><div><span>
                    <%
                        if (action.equals("")) {

                            SWBResourceURL urlact = paramRequest.getRenderUrl();
                    %>
                    <ul>
                        <li><a href="<%=urlact%>?act=register">CVIs Registrados por rango de fecha</a></li>
                    </ul>
                    <%

                    } else if ("register".equals(action)) {
                                String wptitle = "CVI Registrados";
                                String step = "1";
                                if (request.getParameter("step") != null) {
                                    step = request.getParameter("step");
                                }
                                if ("1".equals(step)) {

                                    SWBResourceURL urlstep2 = paramRequest.getRenderUrl();
                            %>
                            <script type="text/javascript">
                                
                                dojo.require("dijit.layout.ContentPane");
                                dojo.require("dijit.form.Form");
                                dojo.require("dijit.form.ValidationTextBox");
                                dojo.require("dijit.form.Button");
                                dojo.require("dijit.form.FilteringSelect");
                                dojo.require('dijit.form.Textarea');
                                dojo.require('dijit.form.DateTextBox');
                                
                                function enviar() {
        var objd=dijit.byId('form1repcvi');
        if(objd.validate())
        {
            return true;
        }else {
            alert("Datos incompletos o incorrectos");
        }
        return false;
    }
    
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
                            <div id="icv-rep-busca1">
                                <h3><%=wptitle%></h3>
                            <form id="form1repcvi" dojoType="dijit.form.Form" method="post" action="<%=urlstep2%>" method="post">
                                <input type="hidden" name="act" value="<%=action%>"/>
                                <input type="hidden" name="step" value="2"/>
                                <label><em>*</em>Fecha inicial</label><input type="text" name="fstart" value="" dojoType="dijit.form.DateTextBox" required="true" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true" proptMessage="Ingresa la Fecha inicial"/>
                                <label>Fecha final</label><input type="text" name="fend" value="" dojoType="dijit.form.DateTextBox" required="false" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true" proptMessage="Ingresa la Fecha final"/>                                  
                                    <button onclick="javascript:history.back(1);">Regresar</button>
                                    <button type="submit" onclick="return enviar();">Buscar</button>
                            </form>
                            </div>
                            <%
                            } else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC 

                                String curso = request.getParameter("curso");
                                String strfstart = request.getParameter("fstart");
                                String strfend = request.getParameter("fend");
                                String strNumero = null; 
                                if (strNumero == null) {
                                    strNumero = "0";
                                }
                                int inumero = 0;
                                try {
                                    inumero = Integer.parseInt(strNumero);
                                } catch (Exception e) {
                                    inumero = 0;
                                }
                                if (curso == null) {
                                    curso = "0";
                                }

                                Docencia doce = null;
                                HashMap<String, CV> hm = new HashMap<String, CV>();

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
                                                if (doce.getNivelDocencia() != null) {
                                                    String txtTitle = doce.getNivelDocencia().getTitle() != null ? doce.getNivelDocencia().getTitle() : "";
                                                    if ("Posgrado".equals(txtTitle)) { //&&curso.equals("1")
                                                        acum++;
                                                    }
                                                } else if (curso.equals("0")) {
                                                    acum++;
                                                }
                                            }
                                            if ("1".equals(curso)) { // que han impartido cursos de posgrado
                                                if (inumero <= acum) { // numero de cursos de posgrado impartidos
                                                    hm.put(cv.getId(), cv);
                                                }
                                            } else { // que no han impartido cursos de posgrado
                                                if (0 == acum) { // ningun curso de posgrado impartido
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
                            <button onclick="javascript:history.back(1);">Regresar</button>
                            <%  } else {

                                String criteria = "";
                                if ("1".equals(curso)) {
                                    criteria = "que hayan impartido por lo menos " + inumero + " curso(s).";
                                } else {
                                    criteria = "que no hayan impartido cursos de posgrado.";
                                }
                            %>

                            <table>
                                <caption><%=wptitle%> - <%=criteria%></caption>

                                <tbody>
                                    <%
                                        SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                        urldetail.setParameter("step", "3");
                                        urldetail.setParameter("act", action);
                                        urldetail.setParameter("curso", curso);
                                        urldetail.setParameter("numero", "" + inumero);
                                    %>
                                    <tr>
                                        <td>Encontrados</td><td><%=acum%></td>
                                        <%
                                            if (!export.equals("excel")) {
                                        %>   
                                        <td><a href="<%=urldetail%>">ver</a></td>
                                        <%
                                        } else {
                                        %>
                                        <td>&nbsp;</td>
                                        <%                 }
                                        %>
                                    </tr>
                                </tbody>
                                <%

                                    }
                                %>
                            </table>

                            <%

                                if (!export.equals("excel") && acum > 0) {
                                    SWBResourceURL urlExport = paramRequest.getRenderUrl();
                                    urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                                    urlExport.setMode(MODE_EXPORT);
                            %>
                            <form action="<%=urlExport.toString()%>" method="post">
                                <input type="hidden" name="export" value="excel">
                                <%
                                    if (request.getParameter("step") != null) {
                                %>
                                <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                                <%
                                    }
                                    if (request.getParameter("act") != null) {
                                %>
                                <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                                <%
                                    }
                                    if (request.getParameter("curso") != null) {
                                %>
                                <input type="hidden" name="curso" value="<%=curso%>">
                                <%
                                    }
                                    if (request.getParameter("numero") != null) {
                                %>
                                <input type="hidden" name="numero" value="<%=inumero%>">
                                <%
                                    }
                                %>
                                <form action="<%=urlExport.toString()%>">
                                    <button onclick="javascript:history.back(1);">Regresar</button>
                                    <button type="submit" >Guardar Excel</button>
                                </form>
                                <%
                                    }

                                    // termina step 2
                                } else { // step 3 detalle reporte
                                    String curso = request.getParameter("curso");
                                    String strNumero = request.getParameter("numero");
                                    if (strNumero == null) {
                                        strNumero = "0";
                                    }
                                    int inumero = 0;
                                    try {
                                        inumero = Integer.parseInt(strNumero);
                                    } catch (Exception e) {
                                        inumero = 0;
                                    }
                                    if (curso == null) {
                                        curso = "0";
                                    }

                                    Docencia doce = null;
                                    HashMap<String, CV> hm = new HashMap<String, CV>();
                                    HashMap<String, String> hmorder = new HashMap<String, String>();
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
                                                    if (doce.getNivelDocencia() != null) {
                                                        String txtTitle = doce.getNivelDocencia().getTitle() != null ? doce.getNivelDocencia().getTitle() : "";
                                                        if ("Posgrado".equals(txtTitle) && curso.equals("1")) {
                                                            acum++;
                                                        }
                                                    } else if (curso.equals("0")) {
                                                        acum++;
                                                    }
                                                }
                                                if ("1".equals(curso)) { // que han impartido cursos de posgrado
                                                    if (inumero <= acum) { // numero de cursos de posgrado impartidos
                                                        hm.put(cv.getId(), cv);
                                                        hmorder.put(cv.getPropietario().getFullName(), cv.getId());
                                                    }
                                                } else { // que no han impartido cursos de posgrado
                                                    hm.put(cv.getId(), cv);
                                                    hmorder.put(cv.getPropietario().getFullName(), cv.getId());
                                                }
                                            }
                                        }
                                    }
                                    acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                                    if (!hm.isEmpty()) {
                                        String txttype = "Cursos de posgrado Impartidos.";
                                        String criteria = "";
                                        if ("1".equals(curso)) {
                                            criteria = "que hayan impartido por lo menos " + inumero + " curso(s).";
                                        } else {
                                            criteria = "que no hayan impartido cursos de posgrado.";
                                        }

                                        out.println(listReport(hm, hmorder, txttype, criteria, paramRequest, request));
                                %>

                                <%
                                    }
                                    if (!export.equals("excel") && acum > 0) {
                                        SWBResourceURL urlExport = paramRequest.getRenderUrl();
                                        urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                                        urlExport.setMode(MODE_EXPORT);
                                %>
                                <form action="<%=urlExport.toString()%>" method="post">
                                    <input type="hidden" name="export" value="excel">
                                    <%
                                        if (request.getParameter("step") != null) {
                                    %>
                                    <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                                    <%
                                        }
                                        if (request.getParameter("act") != null) {
                                    %>
                                    <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                                    <%
                                        }
                                        if (request.getParameter("curso") != null) {
                                    %>
                                    <input type="hidden" name="curso" value="<%=curso%>">
                                    <%
                                        }
                                        if (request.getParameter("numero") != null) {
                                    %>
                                    <input type="hidden" name="numero" value="<%=inumero%>">
                                    <%
                                        }
                                    %>
                                    <form action="<%=urlExport.toString()%>">
                                        <button onclick="javascript:history.back(1);">Regresar</button>
                                        <button type="submit" >Guardar Excel</button>
                                    </form>
                                    <%


                                            }
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
                                                    alert('Debes de poner el Número de publicaciones.');
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

                                    <div id="icv-rep-busca1">
                                        <h3><%=wptitle%></h3>
                                    <form method="post" action="<%=urlstep2%>" >
                                        <input type="hidden" name="act" value="<%=action%>"/>
                                        <input type="hidden" name="step" value="2"/>
                                            <input type="checkbox" id="publi" name="curso" value="1" checked onclick="if(!this.checked){this.form.num.disabled='disabled';}else{this.form.num.disabled='';}"/>
                                            <label for="num">Número de publicaciones: </label><input type="text" id="num" name="numero" />
                                            <button onclick="javascript:history.back(1);">Regresar</button>
                                            <button type="submit" onclick="return revisaPub(this.form);">Buscar</button>
                                            
                                    </div>

                                    <%
                                    } else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC 

                                        String curso = request.getParameter("curso");
                                        String strNumero = request.getParameter("numero");
                                        if (strNumero == null) {
                                            strNumero = "0";
                                        }
                                        int inumero = 0;
                                        try {
                                            inumero = Integer.parseInt(strNumero);
                                        } catch (Exception e) {
                                            inumero = 0;
                                        }
                                        if (curso == null) {
                                            curso = "0";
                                        }

                                        Publicacion doce = null;
                                        HashMap<String, CV> hm = new HashMap<String, CV>();
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
                                                    if ("1".equals(curso)) { // que han hecho publicaciones
                                                        if (inumero <= acum) { // numero de publicaciones realizadas
                                                            hm.put(cv.getId(), cv);
                                                        }
                                                    } else { // que no han hecho publicaciones
                                                        if (0 == acum) { // ninguna publicacion
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
                                    <button onclick="javascript:history.back(1);">Regresar</button>
                                    <%  } else {

                                        String criteria = "";
                                        if ("1".equals(curso)) {
                                            criteria = "que hayan realizado por lo menos " + inumero + " publicación(es).";
                                        } else {
                                            criteria = "que no hayan realizado ninguna publicación.";
                                        }
                                    %>
                                    
                                        <table>
                                            <caption><%=wptitle%> - <%=criteria%></caption>
                                            <tbody>
                                                <%
                                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                                    urldetail.setParameter("step", "3");
                                                    urldetail.setParameter("act", action);
                                                    urldetail.setParameter("curso", curso);
                                                    urldetail.setParameter("numero", "" + inumero);
                                                %>
                                                <tr>
                                                    <td>Encontrados</td><td><%=acum%></td>
                                                    <%
                                                        if (!export.equals("excel")) {
                                                    %>    

                                                    <td><a href="<%=urldetail%>">ver</a></td>
                                                    <%
                                                    } else {
                                                    %>
                                                    <td>&nbsp;</td>
                                                    <%                }
                                                    %>
                                                </tr>
                                            </tbody>
                                            <%

                                                }
                                            %>
                                        </table>
                                    

                                    <%

                                        if (!export.equals("excel") && acum > 0) {
                                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                                            urlExport.setMode(MODE_EXPORT);
                                    %>
                                    <form action="<%=urlExport.toString()%>" method="post">
                                        <input type="hidden" name="export" value="excel">
                                        <%
                                            if (request.getParameter("step") != null) {
                                        %>
                                        <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                                        <%
                                            }
                                            if (request.getParameter("act") != null) {
                                        %>
                                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                                        <%
                                            }
                                            if (request.getParameter("curso") != null) {
                                        %>
                                        <input type="hidden" name="curso" value="<%=curso%>">
                                        <%
                                            }
                                            if (request.getParameter("numero") != null) {
                                        %>
                                        <input type="hidden" name="numero" value="<%=inumero%>">
                                        <%
                                            }
                                        %>
                                        <form action="<%=urlExport.toString()%>">
                                            <button onclick="javascript:history.back(1);">Regresar</button>
                                            <button type="submit" >Guardar Excel</button>
                                        </form>
                                        <%
                                            }

                                            // termina step 2
                                        } else { // step 3 detalle reporte
                                            String curso = request.getParameter("curso");
                                            String strNumero = request.getParameter("numero");
                                            if (strNumero == null) {
                                                strNumero = "0";
                                            }
                                            int inumero = 0;
                                            try {
                                                inumero = Integer.parseInt(strNumero);
                                            } catch (Exception e) {
                                                inumero = 0;
                                            }
                                            if (curso == null) {
                                                curso = "0";
                                            }

                                            Publicacion doce = null;
                                            HashMap<String, CV> hm = new HashMap<String, CV>();
                                            HashMap<String, String> hmorder = new HashMap<String, String>();
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
                                                        if ("1".equals(curso)) { // que han hecho publicaciones
                                                            if (inumero <= acum) { // numero de publicaciones realizadas
                                                                hm.put(cv.getId(), cv);
                                                                hmorder.put(cv.getPropietario().getFullName(), cv.getId());
                                                            }
                                                        } else { // que no han hecho publicaciones
                                                            if (0 == acum) { // ninguna publicacion
                                                                hm.put(cv.getId(), cv);
                                                                hmorder.put(cv.getPropietario().getFullName(), cv.getId());
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                                            if (!hm.isEmpty()) {
                                                String txttype = "Publicaciones";
                                                String criteria = "";
                                                if ("1".equals(curso)) {
                                                    criteria = "que hayan realizado por lo menos " + inumero + " publicación(es).";
                                                } else {
                                                    criteria = "que no hayan realizado ninguna publicación.";
                                                }

                                                out.println(listReport(hm, hmorder, txttype, criteria, paramRequest, request));
                                            }
                                            if (!export.equals("excel") && acum > 0) {
                                                SWBResourceURL urlExport = paramRequest.getRenderUrl();
                                                urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                                                urlExport.setMode(MODE_EXPORT);
                                        %>
                                        <form action="<%=urlExport.toString()%>" method="post">
                                            <input type="hidden" name="export" value="excel">
                                            <%
                                                if (request.getParameter("step") != null) {
                                            %>
                                            <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                                            <%
                                                }
                                                if (request.getParameter("act") != null) {
                                            %>
                                            <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                                            <%
                                                }
                                                if (request.getParameter("curso") != null) {
                                            %>
                                            <input type="hidden" name="curso" value="<%=curso%>">
                                            <%
                                                }
                                                if (request.getParameter("numero") != null) {
                                            %>
                                            <input type="hidden" name="numero" value="<%=inumero%>">
                                            <%
                                                }
                                            %>
                                            <form action="<%=urlExport.toString()%>">
                                                <button onclick="javascript:history.back(1);">Regresar</button>
                                                <button type="submit" >Guardar Excel</button>
                                            </form>
                                            <%
                                                    }

                                                } //step 3 
                                            }
                                            %>  
                                            </span></div>
                                            </div><!-- icv-data -->  
                                            </div>
                                            </div>

                                            <%!
                                                public String listReport(HashMap<String, CV> hm, HashMap<String, String> hmorder, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
                                                    StringBuilder ret = new StringBuilder();
                                                    String export = request.getParameter("export");
                                                    if (null == export) {
                                                        export = "";
                                                    }
                                                    WebSite wsite = paramRequest.getWebPage().getWebSite();
                                                    ret.append("<script type=\"text/javascript\">");
                                                    ret.append(" function newWin(url){");
                                                    ret.append("    window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');");
                                                    ret.append("}");
                                                    ret.append("</script>");

                                                    ret.append("        <table>");
                                                    ret.append("        <caption>");
                                                    ret.append(txttype);
                                                    ret.append(" que contengan: ");
                                                    ret.append(criteria);
                                                    ret.append("        </caption>");
                                                    ret.append("            <thead>");
                                                    ret.append("                <tr>");
                                                    ret.append("                    <th>Usuario</th><th>Detalle</th>");
                                                    ret.append("                </tr>");
                                                    ret.append("            </thead>");
                                                    ret.append("            <tbody>");

                                                    ArrayList<String> list = new ArrayList(hmorder.keySet());
                                                    Collections.sort(list);

                                                    Iterator<String> itstr = list.iterator();
                                                    while (itstr.hasNext()) {
                                                        String key = itstr.next();
                                                        String keyorder = hmorder.get(key);

                                                        User usrcv = wsite.getUserRepository().getUser(keyorder);
                                                        Resource resource = wsite.getResource("997");
                                                        WebPage wpage = wsite.getWebPage("ver_CV");
                                                        SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
                                                        urldet.setParameter("id", usrcv.getId());
                                                        urldet.setCallMethod(SWBResourceURL.Call_CONTENT);
                                                        ret.append("                 <tr>");
                                                        ret.append("                     <td>");
                                                        ret.append(usrcv.getFullName());
                                                        ret.append("                     </td>");
                                                        ret.append("<td>");
                                                        if (!export.equals("excel")) {
                                                            ret.append("<a href=\"#\" ");
                                                            ret.append("onclick=\"javascript:newWin('");
                                                            ret.append(urldet.toString());
                                                            ret.append("');return false;\" target=\"_blank\">ver</a>");
                                                        } else {
                                                            ret.append("&nbsp;");
                                                        }
                                                        ret.append("                   </td>");
                                                        ret.append("                  </tr>");
                                                    }
                                                    ret.append("               </tbody>");
                                                    ret.append("          </table>");

                                                    return ret.toString();
                                                }

                                            %>