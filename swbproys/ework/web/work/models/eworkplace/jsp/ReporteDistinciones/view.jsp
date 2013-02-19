<%--   
    Document   : view Recurso ReporteInvestigacionDocencia
    Created on : 10/04/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Distincion"%>
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
                        <li><a href="<%=urlact%>?act=distinciones">Distinciones</a></li>

                    </ul>
                    <%

                    } else if ("distinciones".equals(action)) {
                        String wptitle = "Distinciones";

                        String step = "1";
                        if (request.getParameter("step") != null) {
                            step = request.getParameter("step");
                        }
                        if ("1".equals(step)) {

                            HashMap<String, CV> hm = new HashMap<String, CV>(); // cvs encontrados
                            HashMap<String, CV> hmno = new HashMap<String, CV>();
                            HashMap<String, String> hmorder = new HashMap<String, String>(); //
                            HashMap<String, String> hmorderno = new HashMap<String, String>();


                            boolean aplica = Boolean.FALSE;
                            Distincion distincion = null;
                            long acum = 0, acumno = 0;
                            Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                            while (itcv.hasNext()) {
                                CV cv = itcv.next();
                                User usercv = cv.getPropietario();
                                if (UtilsCVI.isCVIDone(cv) && usercv != null) {
                                    aplica = cv.isSinDistincion();
                                    //out.println("isSinDistinciones: "+aplica);
                                    if (cv.listDistincions().hasNext()&&!aplica) {
                                        Iterator<Distincion> itga = cv.listDistincions();
                                        while (itga.hasNext()) {
                                            distincion = itga.next();
                                            hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), cv.getId());
                                            hm.put(cv.getId(), cv);
                                        }
                                    } else {
                                        hmno.put(cv.getId(), cv);
                                        hmorderno.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), cv.getId());
                                    }
                                }
                            }
                            acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                            acumno = SWBUtils.Collections.sizeOf(hmno.keySet().iterator());

                            if (acum == 0 && acumno == 0) {
                    %>    
                    <p>No se encontraron registros.....</p> 
                    <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                    <%            } else {
                    %>    

                    <table>
                        <caption><%=wptitle%></caption>
                        <thead> 
                            <tr>
                                <th>Distinción</th>
                                <th>Encontrados</th>
                                <th>Detalle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                urldetail.setParameter("step", "2");
                                urldetail.setParameter("act", "distinciones");
                                urldetail.setParameter("reptype", "con");

                                SWBResourceURL urldetail2 = paramRequest.getRenderUrl();
                                urldetail2.setParameter("step", "2");
                                urldetail2.setParameter("act", "distinciones");
                                urldetail2.setParameter("reptype", "sin");
                            %>
                            <tr>
                                <td>Con Distinciones</td>
                                <td><%=acum%></td>
                                <%
                                    if (!export.equals("excel")) {
                                %>
                                <td><a href="<%=urldetail.toString()%>">ver</a></td>
                                <%
                                } else {
                                %>     
                                <td>&nbsp;</td>
                                <%                   }
                                %>
                            </tr>
                            <tr>
                                <td>Sin Distinciones</td>
                                <td><%=acumno%></td>
                                <%
                                    if (acumno == 0) {
                                %>
                                <td>&nbsp;</td>
                                <%                } else {
                                    if (!export.equals("excel")) {
                                %>        
                                <td><a href="<%=urldetail2.toString()%>">ver</a></td>
                                <%
                                } else {
                                %>
                                <td>&nbsp;</td>
                                <%                        }
                                    }
                                %>
                            </tr>
                        </tbody>
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

                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
                        <button type="submit" >Guardar Excel</button> 
                    </form>
                    <%
                            }


                        }
                    } else { //step 2 

                        HashMap<String, CV> hm = new HashMap<String, CV>(); // cvs encontrados
                        HashMap<String, CV> hmno = new HashMap<String, CV>();
                        HashMap<String, String> hmorder = new HashMap<String, String>(); //
                        HashMap<String, String> hmorderno = new HashMap<String, String>();
                        HashMap<String, String> hmdist = new HashMap<String, String>();


                        boolean aplica = Boolean.FALSE;
                        Distincion distincion = null;
                        long acum = 0, acumno = 0;
                        Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
                        while (itcv.hasNext()) {
                            CV cv = itcv.next();
                            User usercv = cv.getPropietario();
                            if (UtilsCVI.isCVIDone(cv) && usercv != null) {
                                aplica = cv.isSinDistincion();
                                if (cv.listDistincions().hasNext()&&!aplica) {
                                    Iterator<Distincion> itga = cv.listDistincions();
                                    while (itga.hasNext()) {
                                        distincion = itga.next();
                                        hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), cv.getId());
                                        hm.put(cv.getId(), cv);
                                        hmdist.put(cv.getId(), distincion.getTitle());
                                    }
                                } else {
                                    hmno.put(cv.getId(), cv);
                                    hmorderno.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), cv.getId());
                                }
                            }
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        String reptype = request.getParameter("reptype");
                        String reporte = "";
                        if (reptype.equals("con")) {
                            reporte = listReportCon(hm, hmorder,hmdist, "Distinciones", "con Distinciones", paramRequest, request);
                        } else {
                            reporte = listReport(hm, hmorderno, "Distinciones", "sin Distinciones", paramRequest, request);
                        }

                        out.println(reporte);

                        /////////////////////////
                        if (!export.equals("excel") && (acum > 0 || acumno > 0)) {
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

                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';">Regresar</button>
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
            WebPage wpage = wsite.getWebPage("ver_CV");
            ret.append("                 <tr>");
            ret.append("                     <td>");
            ret.append(usrcv.getFullName());
            ret.append("                     </td>");
            ret.append("<td>");
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
    
    public String listReportCon(HashMap<String, CV> hm, HashMap<String, String> hmorder, HashMap<String, String> hmdis, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
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
        ret.append("                    <th>Usuario</th><th>Distinción</th><th>Detalle</th>");
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
            ret.append("                     </td>");
            ret.append("<td>");
            ret.append(hmdis.get(usrcv.getId())!=null?hmdis.get(usrcv.getId()):" --- ");
            ret.append("                     </td>");
            ret.append("<td>");
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