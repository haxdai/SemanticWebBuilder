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
                            <button onclick="javascript:history.back(1);" >Regresar</button>
                            <button type="submit" onclick="return revisa(this.form)">Buscar</button>  
                        </form>
                    </div>
                    <%
                    } else if (step.equals("2")) { //step 2, hace la busqueda del texto en Investigaciones - Area de Investigación 

                        String txtbuscar = request.getParameter("search");
                        if (txtbuscar != null) {
                            txtbuscar = txtbuscar.trim().toLowerCase();
                            txtbuscar = UtilsCVI.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                        }
                        String txtbuscar2 = request.getParameter("search2");
                        if (txtbuscar2 != null) {
                            txtbuscar2 = txtbuscar2.trim().toLowerCase();
                            txtbuscar2 = UtilsCVI.replaceSpecialCharacters(txtbuscar2, Boolean.FALSE);
                        }
                        String[] arrcomp = request.getParameterValues("competencia");
                        String compsearch = "";

                        int maxcomp = arrcomp.length;

                        for (int i = 0; i < arrcomp.length; i++) {
                            compsearch = compsearch + "|" + arrcomp[i] + "|";
                        }

                        out.println("competencias: " + arrcomp.length + " [" + compsearch + "], area: " + txtbuscar + ", diplomado: " + txtbuscar2);

                        HashMap<String, CV> hm = new HashMap<String, CV>();
                        HashMap<String, CV> hmtodos = new HashMap<String, CV>();
                        HashMap<String, CV> hmarea = new HashMap<String, CV>();
                        HashMap<String, CV> hmdiplo = new HashMap<String, CV>();
                        HashMap<String, CV> hmctic = new HashMap<String, CV>();

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
                                        hm.put(cv.getId(), cv);
                                    }
                                }

                                if (cv.listInvestigacions().hasNext() && txtbuscar != null) {
                                    Iterator<Investigacion> itga = cv.listInvestigacions();
                                    while (itga.hasNext()) {
                                        inves = itga.next();
                                        String txt = inves.getAreaInvestigacion() != null ? inves.getAreaInvestigacion() : "";
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) { //
                                            hmarea.put(cv.getId(), cv);
                                        }
                                    }
                                }

                                if (cv.listDiplomados().hasNext() && txtbuscar2 != null) {
                                    Iterator<Diplomado> itga = cv.listDiplomados();
                                    while (itga.hasNext()) {
                                        diplo = itga.next();
                                        String txt = diplo.getDocumentoObtenido() != null ? diplo.getDocumentoObtenido() : "";
                                        txt = txt + (diplo.getTitle() != null ? diplo.getTitle() : "");
                                        txt = txt + (diplo.getDescription() != null ? diplo.getDescription() : "");
                                        txt = txt + (diplo.getNombreInstitucion() != null ? diplo.getNombreInstitucion() : "");
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        //System.out.println("Diplomado txt: "+txt+" "+txt.indexOf(txtbuscar));
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hmdiplo.put(cv.getId(), cv);
                                        }
                                    }
                                }
                                if (cv.listCursosTICs().hasNext() && txtbuscar2 != null) {
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
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hmctic.put(cv.getId(), cv);
                                        }
                                    }
                                }

                                //t56if(hm.get(cv.getId())!=null)
                            }
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (acum == 0) {
                    %>         
                    <p>No se encontraron registros</p>
                    <button type="button" onclick="javascript:history.back(1);">Regresar</button>
                    <%  } else {

                    %>

                    <table>
                        <caption>Experiencia TIC - Área de Investigación</caption>
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
                        %>


                        <button type="button" onclick="javascript:history.back(1);">Regresar</button>
                        <button type="submit" >Guardar Excel</button> 
                    </form>
                    <%
                            }
                            // termina step 2
                        }
                    } else { // step 3 detalle reporte
                        String txtbuscar = request.getParameter("search");
                        //System.out.println("Step 2, "+txtbuscar);
                        txtbuscar = txtbuscar.trim().toLowerCase();
                        txtbuscar = UtilsCVI.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                        HashMap<String, CV> hm = new HashMap<String, CV>();
                        HashMap<String, String> hmorder = new HashMap<String, String>();

                        Investigacion diplo = null;
                        long acum = 0;
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {
                            CV cv = itcv.next();
                            if (UtilsCVI.isCVIDone(cv)) {
                                if (cv.listInvestigacions().hasNext()) {
                                    Iterator<Investigacion> itga = cv.listInvestigacions();
                                    while (itga.hasNext()) {
                                        diplo = itga.next();
                                        String txt = diplo.getAreaInvestigacion() != null ? diplo.getAreaInvestigacion() : "";
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hm.put(cv.getId(), cv);
                                            hmorder.put(cv.getPropietario().getFullName(), cv.getId());
                                        }
                                    }
                                }
                            }
                        }
                        if (!hm.isEmpty()) {
                            String txttype = "Competencias";

                            out.println(listReport(hm, hmorder, txttype, request.getParameter("search"), paramRequest, request));

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
                        %>


                        <button type="button" onclick="javascript:history.back(1);">Regresar</button>
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