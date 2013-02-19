<%--   
    Document   : view Recurso ReporteRegistrados
    Created on : 17/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.infotec.cvi.swb.Publicacion"%>
<%@page import="com.infotec.cvi.swb.Docencia"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.infotec.cvi.swb.Investigacion"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.util.StringTokenizer"%>
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

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));

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
                         
                        dojo.require("dojo.parser");
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

                    </script>
                    <div id="icv-rep-busca1">
                        <h3><%=wptitle%></h3>
                        <form id="form1repcvi" dojoType="dijit.form.Form" method="post" action="<%=urlstep2%>" >
                            <input type="hidden" name="act" value="<%=action%>"/>
                            <input type="hidden" name="step" value="2"/>
                            <div class="icv-div-grupo">
                                <p class="icv-3col">
                                    <label>Fecha inicial</label><input type="text" name="fromDate" id="fromDate" value="" dojoType="dijit.form.DateTextBox" required="false" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true" promptMessage="Ingresa la Fecha inicial" onchange="dijit.byId('toDate').constraints.min = arguments[0];"/>
                                </p>
                                <p class="icv-3col">
                                    <label>Fecha final</label><input type="text" name="toDate" id="toDate" value="" dojoType="dijit.form.DateTextBox" required="false" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true" promptMessage="Ingresa la Fecha final" onchange="dijit.byId('fromDate').constraints.max = arguments[0];"/>
                                </p>
                                <div class="clearer">&nbsp;</div>
                            </div>
                            <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                            <button type="submit" >Buscar</button>
                        </form>
                    </div>


                    <%
                    } else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC 

                        String fromDate = request.getParameter("fromDate");
                        String toDate = request.getParameter("toDate");

                        //System.out.println("fromDate >>>" + fromDate + "<<< toDate >>>" + toDate + "<<<");

                        boolean conservar = false;

                        HashMap<String, CV> hm = new HashMap<String, CV>();

                        long acum = 0;
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {
                            CV cv = itcv.next();
                            acum = 0;
                            long time_cv = cv.getCreated().getTime();

                            if (!fromDate.equals("") && !toDate.equals("")) {
                                long iniDate = getTimeDate(fromDate, 0, 0, 0);
                                long endDate = getTimeDate(toDate, 23, 59, 59);
                                if (time_cv >= iniDate && time_cv <= endDate) {
                                    conservar = true;
                                } else {
                                    continue;
                                }
                            } else if (!fromDate.equals("") && toDate.equals("")) {
                                long iniDate = getTimeDate(fromDate, 0, 0, 0);
                                if (time_cv >= iniDate) {
                                    conservar = true;
                                } else {
                                    continue;
                                }
                            } else if (fromDate.equals("") && !toDate.equals("")) {
                                long endDate = getTimeDate(toDate, 23, 59, 59);
                                if (time_cv <= endDate) {
                                    conservar = true;
                                } else {
                                    continue;
                                }
                            } else {
                                conservar = true;
                            }

                            if (conservar) { // si cumple con rango de fechas
                                if (cv.getPropietario() != null) {
                                    hm.put(cv.getId(), cv);
                                }
                            }
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (acum == 0) {
                    %>         
                    <p>No se encontraron registros</p>
                    <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>'">Regresar</button>
                    <%  } else {

                        String criteria = "CVI registrados en la base de datos.";
                        if (!fromDate.equals("") && !toDate.equals("")) {
                            criteria = "CVI registrados a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0))) + " al " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
                        } else if (toDate.equals("") && !fromDate.equals("")) {
                            criteria = "CVI registrados a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0)));
                        } else if (!toDate.equals("") && fromDate.equals("")) {
                            criteria = "CVI Registrados hasta el " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
                        }
                    %>

                    <table>
                        <caption><%=wptitle%> - <%=criteria%></caption>

                        <tbody>
                            <%
                                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                urldetail.setParameter("step", "3");
                                urldetail.setParameter("act", action);
                                urldetail.setParameter("fromDate", fromDate);
                                urldetail.setParameter("toDate", toDate);
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
                            if (request.getParameter("fromDate") != null) {
                        %>
                        <input type="hidden" name="fromDate" value="<%=fromDate%>">
                        <%
                            }
                            if (request.getParameter("toDate") != null) {
                        %>
                        <input type="hidden" name="toDate" value="<%=toDate%>">
                        <%
                            }
                        %>
                        <form action="<%=urlExport.toString()%>">
                            <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>'">Regresar</button>
                            <button type="submit" >Guardar Excel</button>
                        </form>
                        <%
                            }

                            // termina step 2
                        } else { // step 3 detalle reporte
                            String fromDate = request.getParameter("fromDate");
                            String toDate = request.getParameter("toDate");

                            boolean conservar = false;

                            HashMap<String, CV> hm = new HashMap<String, CV>();
                            HashMap<String, String> hmorder = new HashMap<String, String>();

                            long acum = 0;
                            Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                            while (itcv.hasNext()) {
                                CV cv = itcv.next();
                                acum = 0;
                                long time_cv = cv.getCreated().getTime();

                                if (!fromDate.equals("") && !toDate.equals("")) {
                                    long iniDate = getTimeDate(fromDate, 0, 0, 0);
                                    long endDate = getTimeDate(toDate, 23, 59, 59);
                                    if (time_cv >= iniDate && time_cv <= endDate) {
                                        conservar = true;
                                    } else {
                                        continue;
                                    }
                                } else if (!fromDate.equals("") && toDate.equals("")) {
                                    long iniDate = getTimeDate(fromDate, 0, 0, 0);
                                    if (time_cv >= iniDate) {
                                        conservar = true;
                                    } else {
                                        continue;
                                    }
                                } else if (fromDate.equals("") && !toDate.equals("")) {
                                    long endDate = getTimeDate(toDate, 23, 59, 59);
                                    if (time_cv <= endDate) {
                                        conservar = true;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    conservar = true;
                                }

                                if (conservar) { // si cumple con rango de fechas
                                    if (cv.getPropietario() != null) {
                                        hm.put(cv.getId(), cv);
                                        String usrname = cv.getPropietario().getFullName() != null ? cv.getPropietario().getFullName() : cv.getPropietario().getLogin();
                                        hmorder.put(usrname, cv.getId());
                                    }
                                }
                            }
                            acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                            if (!hm.isEmpty()) {
                                String txttype = "Reporte de CVI Registrados.";
                                String criteria = "CVI registrados en la base de datos.";
                                if (!fromDate.equals("") && !toDate.equals("")) {
                                    criteria = "CVI registrados a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0))) + " al " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
                                } else if (toDate.equals("") && !fromDate.equals("")) {
                                    criteria = "CVI registrados a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0)));
                                } else if (!toDate.equals("") && fromDate.equals("")) {
                                    criteria = "CVI Registrados hasta el " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
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
                                if (request.getParameter("fromDate") != null) {
                            %>
                            <input type="hidden" name="fromDate" value="<%=fromDate%>">
                            <%
                                }
                                if (request.getParameter("toDate") != null) {
                            %>
                            <input type="hidden" name="toDate" value="<%=toDate%>">
                            <%
                                }
                            %>
                            <form action="<%=urlExport.toString()%>">
                                <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>'">Regresar</button>
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
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm", new Locale("es"));
                                    DecimalFormat df = new DecimalFormat("###.##");
                                    DecimalFormat df2 = new DecimalFormat("###");
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
                                    ret.append("                    <th>Usuario</th><th>Avance</th><th>Creado</th><th>Modificado</th><th>Detalle</th>");
                                    ret.append("                </tr>");
                                    ret.append("            </thead>");
                                    ret.append("            <tbody>");

                                    ArrayList<String> list = new ArrayList(hmorder.keySet());
                                    Collections.sort(list);

                                    float total =0; 
                                    float completos = 0; 
                                    
                                    Iterator<String> itstr = list.iterator();
                                    while (itstr.hasNext()) {
                                        String key = itstr.next();
                                        String keyorder = hmorder.get(key);

                                        CV cv = hm.get(keyorder);
                                        User usrcv = cv.getPropietario();
                                        WebPage wpage = wsite.getWebPage("ver_CV");
                                        ret.append("                 <tr>");
                                        ret.append("                     <td>");
                                        String usrname = usrcv.getFullName() != null ? usrcv.getFullName() : usrcv.getLogin();
                                        ret.append(usrname);
                                        ret.append("                     </td>");
                                        ret.append("                     <td>");
                                        ret.append(getCVIProgress(cv));
                                        ret.append("                     </td>");
                                        ret.append("                     <td>");
                                        ret.append(sdf.format(cv.getCreated()));
                                        ret.append("                     </td>");
                                        ret.append("                     <td>");
                                        ret.append(sdf.format(cv.getUpdated()));
                                        ret.append("                     </td>");
                                        ret.append("<td>");
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
                                        total++;
                                        if(UtilsCVI.isCVIDone(cv)) completos++;
                                    }
                                    ret.append("<tr>");
                                    ret.append("<th colspan=\"5\">CVI completados: ");
                                    ret.append(df2.format(completos));
                                    ret.append(" de ");
                                    ret.append(df2.format(total));
                                    ret.append(" registrados, equivalente al ");
                                    ret.append(df.format(100*(completos/total))+"% completados.");
                                    ret.append("</th>");
                                    
                                    ret.append("</tr>");
                                    ret.append("               </tbody>");
                                    
                                    ret.append("          </table>");

                                    return ret.toString();
                                }

                                private long getTimeDate(String date, int hr, int min, int seg) {
                                    Calendar cal1 = Calendar.getInstance();
                                    String y = "";
                                    String m = "";
                                    String d = "";

                                    StringTokenizer st = new StringTokenizer(date, "-");
                                    if (st.hasMoreTokens()) {
                                        y = st.nextToken();
                                        if (st.hasMoreTokens()) {
                                            m = st.nextToken();
                                        }
                                        if (st.hasMoreTokens()) {
                                            d = st.nextToken();
                                        }
                                        cal1.set(Integer.parseInt(y), Integer.parseInt(m) - 1, Integer.parseInt(d), hr, min, seg);
                                    }

                                    return cal1.getTimeInMillis();
                                }

                                private String getCVIProgress(CV cv){
        
        Academia aca = cv.getAcademia();
        DecimalFormat df = new DecimalFormat("###");
        
        float progress = 0;
        boolean doneSchooling = aca!=null&&(aca.listGradoAcademicos().hasNext()&&(aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext())&&(cv.isSinDiplomado() || cv.listDiplomados().hasNext())&&(cv.isSinCurso() || cv.listCursosTICs().hasNext())&&(cv.isSinIdioma() || cv.listIdiomas().hasNext()));
        if(doneSchooling)
            progress+=0.25;
        boolean doneExperience = (cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext())&&cv.listAreaTalentos().hasNext()&&(cv.isSinDistincion() || cv.listDistincions().hasNext());
        if(doneExperience)
            progress+=0.25;
        boolean doneCompetencies = cv.listCompetencias().hasNext();
        if(doneCompetencies)
            progress+=0.25;
        boolean doneResearchAndTeaching = (cv.isSinInvestigacion() || cv.listInvestigacions().hasNext())&&(cv.isSinDocencia() || cv.listDocencias().hasNext())&&(cv.isSinPublicacion() || cv.listPublicacions().hasNext());
        if(doneResearchAndTeaching)
            progress+=0.25;
        
        
        
        return df.format(100*progress)+"%";
    }
                                
                            %>