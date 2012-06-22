<%--   
    Document   : view Recurso ReporteMatriz
    Created on : 16/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.eworkplace.swb.Proyecto"%>
<%@page import="com.infotec.eworkplace.swb.SWProfile"%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<%@page import="com.infotec.cvi.swb.SituacionAcademica"%>
<%@page import="com.infotec.cvi.swb.Carrera"%>
<%@page import="com.infotec.cvi.swb.Grado"%>
<%@page import="com.infotec.cvi.swb.base.GradoBase"%>
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
    UserRepository usrrep = wsite.getUserRepository();
    UserGroup ugempleado = usrrep.getUserGroup("Empleado_exsitu"); //Infotec
    UserGroup ugcandidato = usrrep.getUserGroup("Candidato"); // Candidato, externo

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
                        <li><a href="<%=urlact%>?act=dominio">Dominio</a></li>
                        <!-- li><a href="<%//=urlact%>?act=tic">Diplomados, cursos y certificaciones, Cursos especiaizados en TICs</a></li>
                        <li><a href="<%//=urlact%>?act=idioma">Idiomas</a></li -->
                    </ul>
                    <%
                    } else if ("dominio".equals(action)) {
                        String wptitle = "Dominio";

                        String step = "1";
                        if (request.getParameter("step") != null) {
                            step = request.getParameter("step");
                        }
                        if ("1".equals(step)) {
                            HashMap<String, CV> hm = new HashMap<String, CV>(); // grado|situacion
                            HashMap<String, CV> hmc = new HashMap<String, CV>(); // tipoestudio|situacion
                            HashMap<String, String> hmorder = new HashMap<String, String>(); // grado|situacion
                            HashMap<String, String> hmesorder = new HashMap<String, String>(); // tipoestudio|situacion

                            long acuminfotec = 0;
                            long acumcandidatos = 0;
                            long acum = 0;
                            Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                            while (itcv.hasNext()) {
                                CV cv = itcv.next();
                                User user = cv.getPropietario();
                                if (UtilsCVI.isCVIDone(cv)&&user!=null) {
                                    acum++;
                                    
                                    if (user.hasUserGroup(ugempleado)) {
                                        hm.put(cv.getId(), cv);
                                        acuminfotec++;
                                    } else if (user.hasUserGroup(ugcandidato)) {
                                        hmc.put(cv.getId(), cv);
                                        acumcandidatos++;
                                    }
                                }
                            }
                            if (hm != null && hm.isEmpty() && hmc != null && hmc.isEmpty()) {
                    %>         
                    <p>No se encontraron registros</p>
                    <button onclick="javascript:history.back(1);" >Regresar</button>
                    <%} else {

                    %>
                    <table>
                        <caption>Matriz de cruces 'Dominio'</caption>
                        <tbody>
                            <%
                                if (acum == 0) {
                                    out.println("<tr><td colspan=\"3\">No se encontraron registros</td></tr>");
                                } else {

                                    SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                    urldetail.setParameter("step", "3");
                                    urldetail.setParameter("act", action);

                            %>
                            <tr>
                                <td>Totales en Base de Datos</td><td><%=acum%></td>
                                <%
                                    if (!export.equals("excel")) {
                                %>
                                <td>&nbsp;</td>
                                <%                                    //<a href="< % = urldetail % >?reptype=totales">ver</a>
                                } else {
                                %>
                                <td>&nbsp;</td>
                                <%                                        }
                                %>
                            </tr>
                            <tr>
                                <td>CVI - Disponibles</td><td><%=acumcandidatos%></td> 
                                <%
                                    if (!export.equals("excel")) {
                                %>
                                <td><a href="<%=urldetail%>&reptype=candidatos">ver</a></td>
                                <%
                                } else {
                                %>
                                <td>&nbsp;</td>
                                <%                                        }
                                %>
                            </tr>
                            <tr>
                                <td>CVI - Infotec</td><td><%=acuminfotec%></td>
                                <%
                                    if (!export.equals("excel")) {
                                %>
                                <td><a href="<%=urldetail%>&reptype=infotec">ver</a></td>
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
                        <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                        <%
                            }
                            if (request.getParameter("act") != null) {
                        %>
                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                        <%
                            }

                        %>
                        
                            <button type="button" onclick="javascript:history.back(1);">Regresar</button>
                            <button type="submit" >Guardar Excel</button> 
                        </form>
                        <%
                                }
                            }
                        } else { //step 2

                            String reptype = request.getParameter("reptype");
                            String txttype = "Matriz de cruces", criteria = "";
                            HashMap<String, CV> hm = new HashMap<String, CV>(); // 
                            HashMap<String, String> hmorder = new HashMap<String, String>(); // 
                            long acum = 0;
                            Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                            while (itcv.hasNext()) {
                                CV cv = itcv.next();
                                User user = cv.getPropietario();
                                if (UtilsCVI.isCVIDone(cv) && user!=null) {
                                    acum++;
                                    
                                    if ("infotec".equals(reptype) && user!=null && user.hasUserGroup(ugempleado)) {
                                        hm.put(cv.getId(), cv);
                                        hmorder.put(user.getFullName(), cv.getId());
                                        criteria = "CVI - Infotec";
                                    } else if ("candidatos".equals(reptype) &&  user!=null && user.hasUserGroup(ugcandidato)) {
                                        hm.put(cv.getId(), cv);
                                        hmorder.put(user.getFullName(), cv.getId());
                                        criteria = "CVI - Externo";
                                    }
                                }
                            }

                            if ("candidatos".equals(reptype)) {
                                out.println(listReport(hm, hmorder, txttype, criteria, paramRequest, request));
                            } else if ("infotec".equals(reptype)) {
                                out.println(listReportInfo(hm, hmorder, txttype, criteria, paramRequest, request));
                            }
////////////////
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
                            <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                            <%
                                }
                                if (request.getParameter("act") != null) {
                            %>
                            <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                            <%
                                }
                                if (request.getParameter("reptype") != null) {
                            %>
                            <input type="hidden" name="reptype" value="<%=request.getParameter("reptype")%>">
                            <%
                                }
                            %>
                            
                                <button type="button" onclick="javascript:history.back(1);">Regresar</button>
                                <button type="submit" >Guardar Excel</button> 
                            </form>
                            <%
                                    }
                                }
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

                                        CV cv = hm.get(keyorder);
                                        User usrcv = cv.getPropietario();
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

                                public String listReportInfo(HashMap<String, CV> hm, HashMap<String, String> hmorder, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
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
                                    ret.append("                    <th>Usuario</th>");
                                    ret.append("                    <th>Puesto</th>");
                                    ret.append("                    <th>Proyecto</th>");
                                    ret.append("                    <th>Ubicación</th>");
                                    ret.append("                    <th>Periodo</th>");
                                    ret.append("                    <th>Detalle</th>");
                                    ret.append("                </tr>");
                                    ret.append("            </thead>");
                                    ret.append("            <tbody>");
                                    ArrayList<String> list = new ArrayList(hmorder.keySet());
                                    Collections.sort(list);

                                    Iterator<String> itstr = list.iterator();
                                    while (itstr.hasNext()) {
                                        String key = itstr.next();
                                        String keyorder = hmorder.get(key);

                                        CV cv = hm.get(keyorder);
                                        User usrcv = cv.getPropietario();

                                        SWProfile swpro = SWProfile.ClassMgr.getSWProfile(cv.getId(), wsite);
                                        if (null == swpro) {
                                            swpro = SWProfile.ClassMgr.createSWProfile(cv.getId(), wsite);
                                        }
                                        WebPage wpage = wsite.getWebPage("ver_CV");
                                        ret.append("                 <tr>");
                                        ret.append("                     <td>");
                                        ret.append(usrcv.getFullName());
                                        ret.append("                     </td><td>");
                                        ret.append(swpro.getPuesto() != null ? swpro.getPuesto() : "---");
                                        ret.append("                     </td><td>");

                                        ret.append(getMostRecentProject(swpro));

                                        ret.append("                     </td><td>");

                                        String strUbicacion = "---";
                                        if (swpro.getUbicacion() != null ) {
                                            strUbicacion = swpro.getUbicacion();
                                        }

                                        ret.append(strUbicacion);
                                        ret.append("                     </td><td>");
                                        // periodo por el momento no aplica
                                        ret.append("---");
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

                                public String getMostRecentProject(SWProfile swpro) {
                                    String strRet = "---";

                                    long ahora = System.currentTimeMillis();
                                    Iterator<Proyecto> itpro = swpro.listProyectos();
                                    while (itpro.hasNext()) {
                                        Proyecto proy = itpro.next();
                                        long actualizado = proy.getUpdated().getTime();
                                        if(actualizado<ahora){
                                            ahora = actualizado;
                                            strRet = proy.getNombreProyecto()+"("+proy.getNumeroProyecto()+")";
                                        }
                                    }
                                    return strRet;
                                }

                            %>