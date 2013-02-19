<%--   
    Document   : view Recurso ReporteCompetencias
    Created on : 16/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Diplomado"%>
<%@page import="com.infotec.cvi.swb.CursoTIC"%>
<%@page import="com.infotec.cvi.swb.Competencia"%>
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
        <div id="icv-data"><div><span>
                    <%
                        if (action.equals("")) {

                            SWBResourceURL urlact = paramRequest.getRenderUrl();
                    %>
                    <ul>
                        <li><a href="<%=urlact%>?act=competencias">Competencias con Áreas de Investigación o con Diplomados, Cursos, Certificaciones y Cursos TIC</a></li>
                    </ul>
                    <%
                    } else if ("competencias".equals(action)) {
                        String wptitle = "Competencias";
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
                            if(texto.length==0&&forma.conArea.checked){
                                alert('Debes de poner el Área de Investigación a buscar');
                                return false;
                            }
                            texto = forma.search2.value;
                            texto = texto.replace(' ','');
                            if(texto.length==0&&forma.conCurso.checked){
                                alert('Debes de poner el Diplomado, Curso, Certificación o Curso TIC a buscar');
                                return false;
                            }
                            
                            var sel = 0;
                            for(i=0; i<forma.elements.length; i++)
                            {
                                if(forma.elements[i].type=="checkbox"&&forma.elements[i].name=="competencia"&&forma.elements[i].checked)
                                {
                                    sel++;
                                }
                            }
                            
                            if(sel==0){
                                alert("Debes de seleccionar por lo menos una competencia.");
                                return false;
                            } else if(sel>5) {
                                alert("Debes de seleccionar un máximo de 5 competencias.\n\rTienes seleccionadas "+sel+" competencias.");
                                return false;
                            } 
                                                       
                            
                            return true;
                        }
                    </script>
                    <div id="icv-rep-busca1"><h3><%=wptitle%></h3>
                        <form method="post" action="<%=urlstep2%>">
                            <input type="hidden" name="act" value="<%=action%>"/>
                            <input type="hidden" name="step" value="2"/>
                            <div id="icv-listacompetencias">
                                <ul>
                                    <%
                                        int numcomp = 0;
                                        Iterator<Competencia> itcom = Competencia.ClassMgr.listCompetencias(wsite);
                                        while (itcom.hasNext()) {
                                            Competencia comp = itcom.next();
                                    %>                                
                                    <li>
                                        <input type="checkbox" name="competencia" value="<%=comp.getId()%>" id="comp<%=comp.getId()%>"/><label for="comp<%=comp.getId()%>"><%=comp.getTitle()%></label>
                                    </li>                              

                                    <%
                                        }

                                    %>
                                </ul>
                            </div>
                            <div class="clear">&nbsp;</div>
                            <input type="checkbox" name="conArea" value="1" checked onclick="if(!this.checked){this.form.search.disabled='disabled';;}else{this.form.search.disabled='';}"/><label for="search">&nbsp;&nbsp;Poner el Área de Investigación: </label><input type="text" id="search" name="search" /><br/>
                            <input type="checkbox" name="conCurso" value="1" checked onclick="if(!this.checked){this.form.search2.disabled='disabled';;}else{this.form.search2.disabled='';}"/><label for="search2">&nbsp;&nbsp;Poner el Diplomado, Curso o Curso TIC: </label><input type="text" id="search2" name="search2" />
                            <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
                            <button type="submit" onclick="return revisa(this.form)">Buscar</button>  
                        </form>
                    </div>
                    <%
                    } else if (step.equals("2")) { //step 2, hace la busqueda del texto en Investigaciones - Area de Investigación 

                        boolean conArea = Boolean.FALSE;
                        boolean conCurso = Boolean.FALSE;
                        boolean okArea = Boolean.FALSE;
                        boolean okCurso = Boolean.FALSE;

                        String txtbuscar = request.getParameter("search");
                        if (txtbuscar != null) {
                            txtbuscar = txtbuscar.trim().toLowerCase();
                            txtbuscar = UtilsCVI.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                            conArea = Boolean.TRUE;
                        }
                        String txtbuscar2 = request.getParameter("search2");
                        if (txtbuscar2 != null) {
                            txtbuscar2 = txtbuscar2.trim().toLowerCase();
                            txtbuscar2 = UtilsCVI.replaceSpecialCharacters(txtbuscar2, Boolean.FALSE);
                            conCurso = Boolean.TRUE;
                        }
                        String[] arrcomp = request.getParameterValues("competencia");
                        String compsearch = "";
                        String paramCompetencia = "";
                        String compNames = "";

                        int maxcomp = arrcomp.length;

                        for (int i = 0; i < arrcomp.length; i++) {
                            compsearch = compsearch + "|" + arrcomp[i] + "|";
                            paramCompetencia = paramCompetencia + arrcomp[i];
                            Competencia competencia = Competencia.ClassMgr.getCompetencia(arrcomp[i], wsite);
                            if(competencia!=null) compNames = compNames + " "+competencia.getTitle(); 
                            if ((i + 1) < arrcomp.length) {
                                paramCompetencia = paramCompetencia + ",";
                                compNames = compNames + ",";
                            }
                        }

                        //out.println("competencias: " + arrcomp.length + " [" + compsearch + "], " + paramCompetencia + ", area: " + txtbuscar + ", diplomado: " + txtbuscar2);

                        HashMap<String, CV> hm = new HashMap<String, CV>();

                        Competencia compet = null;

                        Investigacion inves = null;
                        Diplomado diplo = null;
                        CursoTIC ctic = null;
                        long acum = 0;
                        int numcompencontradas = 0;
                        String scompid = "";
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {
                            CV cv = itcv.next();
                            User usercv = cv.getPropietario();
                            if (UtilsCVI.isCVIDone(cv) && usercv != null) {
                                if (cv.listCompetencias().hasNext()) {
                                    numcompencontradas = 0;
                                    Iterator<Competencia> itcomp = cv.listCompetencias();
                                    while (itcomp.hasNext()) {
                                        compet = itcomp.next();
                                        scompid = "|" + compet.getId() + "|";
                                        if (compsearch.indexOf(scompid) > -1) {
                                            numcompencontradas++;
                                        }

                                    }
                                    if (numcompencontradas == maxcomp) {  // se revisa que estén todas las competencias en el cv

                                        boolean aplica = cv.isSinInvestigacion();
                                        if (cv.listInvestigacions().hasNext() && conArea && !aplica) {
                                            Iterator<Investigacion> itga = cv.listInvestigacions();
                                            while (itga.hasNext()) {
                                                inves = itga.next();
                                                String txt = inves.getAreaInvestigacion() != null ? inves.getAreaInvestigacion() : "";
                                                txt = txt.trim().toLowerCase();
                                                txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                                if (txt.indexOf(txtbuscar) > -1) { //
                                                    okArea = Boolean.TRUE;
                                                }
                                            }
                                        }

                                        
                                        if (conCurso ) {
                                            aplica = cv.isSinDiplomado();
                                            if (cv.listDiplomados().hasNext() && !aplica) {
                                                Iterator<Diplomado> itga = cv.listDiplomados();
                                                while (itga.hasNext()) {
                                                    diplo = itga.next();
                                                    String txt = diplo.getDocumentoObtenido() != null ? diplo.getDocumentoObtenido() : "";
                                                    txt = txt + (diplo.getTitle() != null ? diplo.getTitle() : "");
                                                    txt = txt + (diplo.getDescription() != null ? diplo.getDescription() : "");
                                                    txt = txt + (diplo.getNombreInstitucion() != null ? diplo.getNombreInstitucion() : "");
                                                    txt = txt.trim().toLowerCase();
                                                    txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                                    if (txt.indexOf(txtbuscar2) > -1) {
                                                        okCurso = Boolean.TRUE;
                                                    }
                                                }
                                            }

                                            aplica = cv.isSinCurso();
                                            if (cv.listCursosTICs().hasNext() && !okCurso && !aplica) {
                                                Iterator<CursoTIC> ites = cv.listCursosTICs();
                                                while (ites.hasNext()) {
                                                    ctic = ites.next();
                                                    String txt = ctic.getDocumentoObtenido() != null ? ctic.getDocumentoObtenido() : "";
                                                    txt = txt + (ctic.getTitle() != null ? ctic.getTitle() : "");
                                                    txt = txt + (ctic.getDescription() != null ? ctic.getDescription() : "");
                                                    txt = txt + (ctic.getNombreInstitucion() != null ? ctic.getNombreInstitucion() : "");
                                                    txt = txt.trim().toLowerCase();
                                                    txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                                    if (txt.indexOf(txtbuscar2) > -1) {
                                                        okCurso = Boolean.TRUE;
                                                    }
                                                }
                                            }
                                        }

                                        if (conArea && okArea && !conCurso && !okCurso) {
                                            hm.put(cv.getId(), cv);
                                        } else if (!conArea && !okArea && conCurso && okCurso) {
                                            hm.put(cv.getId(), cv);
                                        } else if (conArea && okArea && conCurso && okCurso) {
                                            hm.put(cv.getId(), cv);
                                        } else if (!conArea && !okArea && !conCurso && !okCurso) {
                                            hm.put(cv.getId(), cv);
                                        }
                                        okArea = Boolean.FALSE;
                                        okCurso = Boolean.FALSE;
                                    }
                                }
                            }
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (acum == 0) {
                    %>         
                    <p>No se encontraron registros</p>
                    <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                    <%  } else {

                    %>

                    <table>
                        <caption>Competencias (<%=compNames%>) con/sin Área de Investigación y con/sin Diplomados, Cursos, Certificaciones y Cursos TIC</caption>
                        <tbody>
                            <%
                                if (acum == 0) {
                                    out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                                } else {

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "3");
                                    urldetail.setParameter("act", action);
                                    urldetail.setParameter("search", txtbuscar);
                                    urldetail.setParameter("search2", txtbuscar2);
                                    if (paramCompetencia.length() > 0) {
                                        urldetail.setParameter("competencia", paramCompetencia);
                                    }

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
                                <%                                        }
                                %>
                            </tr>
                        </tbody>
                        <%
                            }
                        %>                 
                    </table>

                    <%
                        if (!export.equals("excel")) {
                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlExport.setMode(MODE_EXPORT);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">
                        <input type="hidden" name="export" value="excel">
                        <%
                            if (request.getParameter("step") != null) {
                        %>
                        <input type="hidden" name="step" value="<%=request.getParameter("step")%>" />
                        <%
                            }
                            if (request.getParameter("act") != null) {
                        %>
                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>" />
                        <%
                            }
                            if (request.getParameter("search") != null) {
                        %>
                        <input type="hidden" name="search" value="<%=txtbuscar%>" />
                        <%
                            }
                            if (request.getParameter("search2") != null) {
                        %>
                        <input type="hidden" name="search2" value="<%=txtbuscar2%>" />
                        <%
                            }

                            if (request.getParameter("competencia") != null && paramCompetencia.length() > 0) {
                                for (int i = 0; i < arrcomp.length; i++) {
                        %>
                        <input type="hidden" name="competencia" value="<%=arrcomp[i]%>" />
                        <%
                                }
                            }
                        %>


                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                        <button type="submit" >Guardar Excel</button> 
                    </form>
                    <%
                            }
                            // termina step 2
                        }
                    } else { // step 3 detalle reporte
                        boolean conArea = Boolean.FALSE;
                        boolean conCurso = Boolean.FALSE;
                        boolean okArea = Boolean.FALSE;
                        boolean okCurso = Boolean.FALSE;

                        String txttype = "Competencias";
                        String criteria = "";
                        String txtbuscar = request.getParameter("search");
                        if (txtbuscar != null) {
                            txtbuscar = txtbuscar.trim().toLowerCase();
                            txtbuscar = UtilsCVI.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                            conArea = Boolean.TRUE;
                        }
                        String txtbuscar2 = request.getParameter("search2");
                        if (txtbuscar2 != null) {
                            txtbuscar2 = txtbuscar2.trim().toLowerCase();
                            txtbuscar2 = UtilsCVI.replaceSpecialCharacters(txtbuscar2, Boolean.FALSE);
                            conCurso = Boolean.TRUE;
                        }

                        String strCompetencia = request.getParameter("competencia");
                        
                        
                        String[] arrcomp = strCompetencia.split(",");
                        String compsearch = "";
                        String paramCompetencia = "";

                        String compNames = "";

                        int maxcomp = arrcomp.length;

                        for (int i = 0; i < arrcomp.length; i++) {
                            compsearch = compsearch + "|" + arrcomp[i] + "|";
                            paramCompetencia = paramCompetencia + arrcomp[i];
                            Competencia competencia = Competencia.ClassMgr.getCompetencia(arrcomp[i], wsite);
                            if(competencia!=null) compNames = compNames + " "+competencia.getTitle(); 
                            if ((i + 1) < arrcomp.length) {
                                paramCompetencia = paramCompetencia + ",";
                                compNames = compNames + ",";
                            }
                        }

                        txttype = txttype +"("+compNames +")";
                        
                        //out.println("Step #3....competencias: " + arrcomp.length + " [" + compsearch + "], " + paramCompetencia + ", area: " + txtbuscar + ", diplomado: " + txtbuscar2);

                        HashMap<String, CV> hm = new HashMap<String, CV>();
                        HashMap<String, String> hmorder = new HashMap<String, String>();

                        Competencia compet = null;

                        Investigacion inves = null;
                        Diplomado diplo = null;
                        CursoTIC ctic = null;
                        long acum = 0;
                        int numcompencontradas = 0;
                        String scompid = "";
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {

                            CV cv = itcv.next();
                            User usercv = cv.getPropietario();
                            //out.println("<br/>" + cv.getId());
                            if (UtilsCVI.isCVIDone(cv) && usercv != null) {
                                String usercvname = usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin();
                                if (cv.listCompetencias().hasNext()) {
                                    numcompencontradas = 0;
                                    Iterator<Competencia> itcomp = cv.listCompetencias();
                                    while (itcomp.hasNext()) {
                                        compet = itcomp.next();
                                        scompid = "|" + compet.getId() + "|";
                                        if (compsearch.indexOf(scompid) > -1) {
                                            numcompencontradas++;
                                        }
                                    }
                                    if (numcompencontradas == maxcomp) {  // se revisa que estén todas las competencias en el cv

                                        if (cv.listInvestigacions().hasNext() && conArea && !cv.isSinInvestigacion()) {
                                            Iterator<Investigacion> itga = cv.listInvestigacions();
                                            while (itga.hasNext()) {
                                                inves = itga.next();
                                                String txt = inves.getAreaInvestigacion() != null ? inves.getAreaInvestigacion() : "";
                                                txt = txt.trim().toLowerCase();
                                                txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                                if (txt.indexOf(txtbuscar) > -1) { //
                                                    okArea = Boolean.TRUE;
                                                }
                                            }
                                        }

                                        if (conCurso) {
                                            if (cv.listDiplomados().hasNext()&& !cv.isSinDiplomado()) {
                                                Iterator<Diplomado> itga = cv.listDiplomados();
                                                while (itga.hasNext()) {
                                                    diplo = itga.next();
                                                    String txt = diplo.getDocumentoObtenido() != null ? diplo.getDocumentoObtenido() : "";
                                                    txt = txt + (diplo.getTitle() != null ? diplo.getTitle() : "");
                                                    txt = txt + (diplo.getDescription() != null ? diplo.getDescription() : "");
                                                    txt = txt + (diplo.getNombreInstitucion() != null ? diplo.getNombreInstitucion() : "");
                                                    txt = txt.trim().toLowerCase();
                                                    txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                                    if (txt.indexOf(txtbuscar2) > -1) {
                                                        okCurso = Boolean.TRUE;
                                                    }
                                                }
                                            }

                                            if (cv.listCursosTICs().hasNext() && !okCurso && !cv.isSinCurso()) {
                                                Iterator<CursoTIC> ites = cv.listCursosTICs();
                                                while (ites.hasNext()) {
                                                    ctic = ites.next();
                                                    String txt = ctic.getDocumentoObtenido() != null ? ctic.getDocumentoObtenido() : "";
                                                    txt = txt + (ctic.getTitle() != null ? ctic.getTitle() : "");
                                                    txt = txt + (ctic.getDescription() != null ? ctic.getDescription() : "");
                                                    txt = txt + (ctic.getNombreInstitucion() != null ? ctic.getNombreInstitucion() : "");
                                                    txt = txt.trim().toLowerCase();
                                                    txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                                    //System.out.println("TIC txt: "+txt+" "+txt.indexOf(txtbuscar));
                                                    if (txt.indexOf(txtbuscar2) > -1) {
                                                        okCurso = Boolean.TRUE;
                                                        break;
                                                    }
                                                }
                                            }
                                        }

                                        if (conArea && okArea && !conCurso && !okCurso) {
                                            hm.put(cv.getId(), cv);
                                            hmorder.put(usercvname, cv.getId());
                                            txttype = txttype + " con Área de Investigación";
                                            criteria = " Área de investigación igual a " + txtbuscar;
                                        } else if (!conArea && !okArea && conCurso && okCurso) {
                                            hm.put(cv.getId(), cv);
                                            hmorder.put(usercvname, cv.getId());
                                            txttype = txttype + " con Diplomado, curso, certificación o Curso TIC";
                                            criteria = " Diplomado, curso, certificación o Curso TIC igual a " + txtbuscar2;
                                        } else if (conArea && okArea && conCurso && okCurso) {
                                            hm.put(cv.getId(), cv);
                                            hmorder.put(usercvname, cv.getId());
                                            txttype = txttype + " con Área de Investigación y con Diplomado, curso, certificación o Curso TIC";
                                            criteria = " Área de investigación igual a " + txtbuscar + " y Diplomado, curso, certificación o Curso TIC igual a " + txtbuscar2;
                                        } else if (!conArea && !okArea && !conCurso && !okCurso) {
                                            hm.put(cv.getId(), cv);
                                            hmorder.put(usercvname, cv.getId());
                                            criteria = " las competencias ";
                                        }
                                        okArea = Boolean.FALSE;
                                        okCurso = Boolean.FALSE;
                                    }
                                }
                            }
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (!hm.isEmpty()) {

                            out.println(listReport(hm, hmorder, txttype, criteria, paramRequest, request));

                            if (!export.equals("excel")) {
                                SWBResourceURL urlExport = paramRequest.getRenderUrl();
                                urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                                urlExport.setMode(MODE_EXPORT);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">
                        <input type="hidden" name="export" value="excel">
                        <%
                            if (request.getParameter("step") != null) {
                        %>
                        <input type="hidden" name="step" value="<%=request.getParameter("step")%>" />
                        <%
                            }
                            if (request.getParameter("act") != null) {
                        %>
                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>" />
                        <%
                            }
                            if (request.getParameter("search") != null) {
                        %>
                        <input type="hidden" name="search" value="<%=txtbuscar%>" />
                        <%
                            }
                            if (request.getParameter("search2") != null) {
                        %>
                        <input type="hidden" name="search2" value="<%=txtbuscar2%>" />
                        <%
                            }
                            if (request.getParameter("competencia") != null && paramCompetencia.length() > 0) {
                        %>
                        <input type="hidden" name="competencia" value="<%=paramCompetencia%>" />
                        <%
                            }
                        %>


                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                        <button type="submit" >Guardar Excel</button> 
                    </form>
                    <%
                                }
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
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        String export = request.getParameter("export");
        if (null == export) {
            export = "";
        }
        ret.append("<script type=\"text/javascript\">");
        ret.append(" function newWin(url){");
        ret.append("    window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');");
        ret.append("}");
        ret.append("</script>");
        ret.append(" <table>");
        ret.append("   <caption>");
        ret.append(txttype);
        ret.append(" - que contengan: ");
        ret.append(criteria);
        ret.append("    </caption>");
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
            WebPage wpage = wsite.getWebPage("ver_CV");
            ret.append("                 <tr>");
            ret.append("                     <td>");
            ret.append(usrcv.getFullName());
            ret.append("                     </td><td>");
            if (!export.equals("excel")) {
                ret.append("<a href=\"#\" ");
                ret.append("onclick=\"javascript:newWin('");
                ret.append(wpage.getUrl() + "?id=" + usrcv.getId());
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