<%--   
    Document   : view Recurso ReporteCompetencias
    Created on : 16/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Competencia"%>
<%@page import="com.infotec.cvi.swb.Investigacion"%>
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
                        <li><a href="<%=urlact%>?act=competencias">Competencias</a></li>
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
                            if(texto.length==0){
                                alert('Debes de poner el Área de Investigación a buscar');
                                return false;
                            }
                            return true;
                        }
                    </script>
                    <div id="icv-rep-busca1"><h3><%=wptitle%></h3>
                        <form method="post" action="<%=urlstep2%>">
                            <input type="hidden" name="act" value="<%=action%>"/>
                            <input type="hidden" name="step" value="2"/>
                            <%
                            Iterator<Competencia> itcom = Competencia.ClassMgr.listCompetencias(wsite);
                            while(itcom.hasNext()){
                                Competencia comp = itcom.next();
                                
                            }                                    

                            %>
                            
                            <input type="checkbox" name="conArea" value="1" checked onclick="if(!this.checked){this.form.search.disabled='disabled';;}else{this.form.search.disabled='';}"/><label for="search">Poner el Área de Investigación: </label><input type="text" id="search" name="search" />
                            <input type="checkbox" name="conCurso" value="1" checked onclick="if(!this.checked){this.form.search.disabled='disabled';;}else{this.form.search.disabled='';}"/><label for="search">Poner el Diplomado, Curso o Curso TIC: </label><input type="text" id="search2" name="search2" />
                            <button onclick="javascript:history.back(1);" >Regresar</button>
                            <button type="submit" onclick="return revisa(this.form)">Buscar</button>  
                        </form>
                    </div>
                    <%
                    } else if (step.equals("2")) { //step 2, hace la busqueda del texto en Investigaciones - Area de Investigación

                        String txtbuscar = request.getParameter("search");
                        //System.out.println("Step 2, "+txtbuscar);
                        txtbuscar = txtbuscar.trim().toLowerCase();
                        txtbuscar = SWBUtils.TEXT.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                        HashMap<String, CV> hm = new HashMap<String, CV>();
                        HashMap<String, CV> hmtic = new HashMap<String, CV>();

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
                                        txt = SWBUtils.TEXT.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) {
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
                            txtbuscar = SWBUtils.TEXT.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
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
                                            txt = SWBUtils.TEXT.replaceSpecialCharacters(txt, Boolean.FALSE);
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
                                            ret.append(wpage.getUrl()+"?id="+usrcv.getId());
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