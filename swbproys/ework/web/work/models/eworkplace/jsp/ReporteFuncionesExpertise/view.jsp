<%--   
    Document   : view Recurso ReporteFuncionesExpertise
    Created on : 18/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.AreaTalento"%>
<%@page import="com.infotec.cvi.swb.resources.AreasTalentoResource"%>
<%@page import="com.infotec.cvi.swb.ExperienciaLaboral"%>
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
                        <li><a href="<%=urlact%>?act=expertise">Expertise - Funciones Principales</a></li>
                    </ul>
                    <%
                    } else if ("expertise".equals(action)) {
                        String wptitle = "Expertise, Expertise TI, Habilidades, Indistria y Funciones Principales";
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
                                alert('Debes de poner el texto a buscar');
                                return false;
                            }
                            return true;
                        }
                    </script>
                    <div id="icv-rep-busca1"><h3><%=wptitle%></h3>
                        <form method="post" action="<%=urlstep2%>">
                            <input type="hidden" name="act" value="<%=action%>"/>
                            <input type="hidden" name="step" value="2"/>
                            <label for="search">Poner el texto referente a la Habilida y/o funcion principal a buscar: </label><input type="text" id="search" name="search" />
                            <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
                            <button type="submit" onclick="return revisa(this.form)">Buscar</button>  
                        </form>
                    </div>
                    <%
                    } else if (step.equals("2")) { //step 2, hace la busqueda del texto en Investigaciones - Area de Investigación

                        String txtbuscar = request.getParameter("search");
                        txtbuscar = txtbuscar.trim().toLowerCase();
                        txtbuscar = UtilsCVI.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                        HashMap<String, CV> hm = new HashMap<String, CV>();
                        HashMap<String, CV> hmhab = new HashMap<String, CV>();
                        HashMap<String, CV> hmdos = new HashMap<String, CV>();

                        ExperienciaLaboral explab = null;
                        AreaTalento atalento = null;
                        long acum = 0;
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {
                            CV cv = itcv.next();
                            User usrcv = cv.getPropietario();
                            if (UtilsCVI.isCVIDone(cv) && usrcv != null) {
                                if (cv.listExperienciaLaborals().hasNext()&&!cv.isSinExperiencia()) {
                                    Iterator<ExperienciaLaboral> itga = cv.listExperienciaLaborals();
                                    while (itga.hasNext()) {
                                        explab = itga.next();
                                        String txt = explab.getFuncionesPrincipales() != null ? explab.getFuncionesPrincipales() : "";
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hm.put(cv.getId(), cv);
                                        }
                                    }
                                }
                                if (cv.listAreaTalentos().hasNext()) {
                                    Iterator<AreaTalento> itga = cv.listAreaTalentos();
                                    while (itga.hasNext()) {
                                        atalento = itga.next();
                                        String txt = atalento.getHabilidad() != null ? atalento.getHabilidad().getTitle() : "";
                                        txt = txt + (atalento.getOtraHabilidad() != null ? atalento.getOtraHabilidad() : "");
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hmhab.put(cv.getId(), cv);
                                        }
                                    }
                                }
                                if (hm.get(cv.getId()) != null && hmhab.get(cv.getId()) != null) {
                                    hmdos.put(cv.getId(), cv);
                                }
                            }

                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (hm.isEmpty() && hmhab.isEmpty() && hmdos.isEmpty()) {
                    %>         
                    <p>No se encontraron registros</p>
                    <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                    <%  } else {

                    %>

                    <table>
                        <caption>Expertise, Expertise TI, Habilidad, Industria</caption>
                        <tbody>
                            <%
                                if (hmhab.isEmpty()) {
                                    out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                                } else {

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "3");
                                    urldetail.setParameter("act", action);
                                    urldetail.setParameter("search", txtbuscar);
                                    urldetail.setParameter("type", "habilidad");

                            %>
                            <tr>
                                <td>Encontrados</td><td><%=SWBUtils.Collections.sizeOf(hmhab.keySet().iterator())%></td>
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

                    <table>
                        <caption>Funciones Principales</caption>
                        <tbody>
                            <%
                                if (hm.isEmpty()) {
                                    out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                                } else {

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "3");
                                    urldetail.setParameter("act", action);
                                    urldetail.setParameter("search", txtbuscar);
                                    urldetail.setParameter("type", "funcion");

                            %>
                            <tr>
                                <td>Encontrados</td><td><%=SWBUtils.Collections.sizeOf(hm.keySet().iterator())%></td>
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
                    <table>
                        <caption>Expertise, Expertise TI, Habilidad, Industria y Funciones Principales</caption>
                        <tbody>
                            <%
                                if (hmdos.isEmpty()) {
                                    out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                                } else {

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "3");
                                    urldetail.setParameter("act", action);
                                    urldetail.setParameter("search", txtbuscar);
                                    urldetail.setParameter("type", "ambos");

                            %>
                            <tr>
                                <td>Encontrados</td><td><%=SWBUtils.Collections.sizeOf(hmdos.keySet().iterator())%></td>
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

                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                        <button type="submit" >Guardar Excel</button> 
                    </form>
                    <%
                            }
                            // termina step 2
                        }
                    } else { // step 3 detalle reporte
                        String reptype = request.getParameter("type");
                        String txtbuscar = request.getParameter("search");
                        txtbuscar = txtbuscar.trim().toLowerCase();
                        txtbuscar = UtilsCVI.replaceSpecialCharacters(txtbuscar, Boolean.FALSE);
                        HashMap<String, CV> hm = new HashMap<String, CV>();
                        HashMap<String, CV> hmhab = new HashMap<String, CV>();
                        HashMap<String, String> hmyears = new HashMap<String, String>();
                        HashMap<String, CV> hmdos = new HashMap<String, CV>();
                        HashMap<String, String> hmorder = new HashMap<String, String>();

                        ExperienciaLaboral explab = null;
                        AreaTalento atalento = null;
                        long acum = 0;
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {
                            CV cv = itcv.next();
                            User usrcv = cv.getPropietario();
                            if (UtilsCVI.isCVIDone(cv) && usrcv != null) {
                                if (cv.listExperienciaLaborals().hasNext() && (reptype.equals("funcion") || reptype.equals("ambos"))&&!cv.isSinExperiencia()) {
                                    Iterator<ExperienciaLaboral> itga = cv.listExperienciaLaborals();
                                    while (itga.hasNext()) {
                                        explab = itga.next();
                                        String txt = explab.getFuncionesPrincipales() != null ? explab.getFuncionesPrincipales() : "";
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hm.put(cv.getId(), cv);
                                            hmorder.put(usrcv.getFullName() != null ? usrcv.getFullName() : usrcv.getLogin(), cv.getId());
                                        }
                                    }
                                }
                                if (cv.listAreaTalentos().hasNext() && (reptype.equals("habilidad") || reptype.equals("ambos"))) {
                                    Iterator<AreaTalento> itga = cv.listAreaTalentos();
                                    while (itga.hasNext()) {
                                        atalento = itga.next();
                                        String txt = atalento.getHabilidad() != null ? atalento.getHabilidad().getTitle() : "";
                                        txt = txt + (atalento.getOtraHabilidad() != null ? atalento.getOtraHabilidad() : "");
                                        txt = txt.trim().toLowerCase();
                                        txt = UtilsCVI.replaceSpecialCharacters(txt, Boolean.FALSE);
                                        if (txt.indexOf(txtbuscar) > -1) {
                                            hmhab.put(cv.getId(), cv);
                                            hmorder.put(usrcv.getFullName() != null ? usrcv.getFullName() : usrcv.getLogin(), cv.getId());
                                            hmyears.put(cv.getId(), ""+atalento.getYearExperienceTalento());
                                        }
                                    }
                                }
                                if (hm.get(cv.getId()) != null && hmhab.get(cv.getId()) != null && reptype.equals("ambos")) {
                                    hmdos.put(cv.getId(), cv);
                                    hmorder.put(usrcv.getFullName() != null ? usrcv.getFullName() : usrcv.getLogin(), cv.getId());
                                }
                            }

                        }

                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (!hm.isEmpty() || !hmhab.isEmpty() || !hmdos.isEmpty()) {


                            String txttype = "Expertise, Expertise TI, Habilidades, Indistria y Funciones Principales.";

                            if (reptype.equals("funcion")) {
                                txttype = "Funciones Principales.";
                                out.println(listReport(hm, hmorder, txttype, request.getParameter("search"), paramRequest, request));
                            } else if (reptype.equals("habilidad")) {
                                txttype = "Expertise, Expertise TI, Habilidades o Indistria.";
                                out.println(listReportYears(hmhab, hmorder, hmyears, txttype, request.getParameter("search"), paramRequest, request)); 
                            } else if (reptype.equals("ambos")) {
                                txttype = "Que tienen Expertise, Expertise TI, Habilidades, Indistria y Funciones Principales.";
                                out.println(listReportYears(hmdos, hmorder, hmyears, txttype, request.getParameter("search"), paramRequest, request)); 
                            }

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
                            if (request.getParameter("type") != null) {
                        %>
                        <input type="hidden" name="type" value="<%=reptype%>" />
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

    public String listReportYears(HashMap<String, CV> hm, HashMap<String, String> hmorder, HashMap<String,String> hmyears, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
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
        ret.append("                    <th>Usuario</th><th>Años de Experiencia</th><th>Detalle</th>");
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
            ret.append(hmyears.get(keyorder)!=null?hmyears.get(keyorder):"---");
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