<%--   
    Document   : view Recurso ReevisaSolicitud
    Created on : 17/04/2012
    Author     : juan.fernandez
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
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
    String MODE_DETAIL = "detail";

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

    System.out.println("action: " + action);

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
                            urlact.setParameter("act", "solicitud");
                            SWBResourceURL urlsearch = paramRequest.getRenderUrl();
                            urlsearch.setParameter("act", "buscar");
                            urlsearch.setMode(MODE_DETAIL);
                    %>
                    <ul>
                        <li><a href="<%=urlact%>">Revisar Solicitudes de Recurso</a></li>
                        <li><a href="<%=urlsearch%>">Buscar Candidato</a></li>
                    </ul>
                    <%

                    } else if ("solicitud".equals(action)) {
                        String wptitle = "Solicitud de Recursos";
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
                            <button onclick="javascript:history.back(1);">Regresar</button>
                            <button type="submit" >Buscar</button>
                        </form>
                    </div>


                    <%
                    } else if ("2".equals(step)) { //step 2, 

                        String fromDate = request.getParameter("fromDate");
                        String toDate = request.getParameter("toDate");

                        System.out.println("fromDate >>>" + fromDate + "<<< toDate >>>" + toDate + "<<<");

                        boolean conservar = false;

                        HashMap<String, SolicitudRecurso> hm = new HashMap<String, SolicitudRecurso>();

                        SolicitudRecurso solrec = null;
                        long acum = 0;
                        Iterator<SolicitudRecurso> itcv = SolicitudRecurso.ClassMgr.listSolicitudRecursos(wsite);
                        while (itcv.hasNext()) {
                            solrec = itcv.next();
                            acum = 0;
                            long time_cv = (solrec.getFechaSolicitud() != null ? solrec.getFechaSolicitud().getTime() : 0);

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

                            conservar = true;

                            if (conservar) { // si cumple con rango de fechas

                                hm.put(solrec.getId(), solrec);

                            }
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        if (acum == 0) {
                    %>         
                    <p>No se encontraron registros</p>
                    <button onclick="javascript:history.back(1);">Regresar</button>
                    <%  } else {

                        String criteria = "Solicitudes de Recursos registrados en la base de datos.";
                        if (!fromDate.equals("") && !toDate.equals("")) {
                            criteria = "Solicitudes de Recursos registradas a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0))) + " al " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
                        } else if (toDate.equals("") && !fromDate.equals("")) {
                            criteria = "Solicitudes de Recursos registradas a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0)));
                        } else if (!toDate.equals("") && fromDate.equals("")) {
                            criteria = "Solicitudes de Recursos registradas hasta el " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
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
                            <button onclick="javascript:history.back(1);">Regresar</button>
                            <button type="submit" >Guardar Excel</button>
                        </form>
                        <%
                            }

                            // termina step 2
                        } else if ("3".equals(step)) { // step 3 detalle reporte 
                            String fromDate = request.getParameter("fromDate");
                            String toDate = request.getParameter("toDate");

                            boolean conservar = false;

                            HashMap<String, String> hmorder = new HashMap<String, String>();
                            HashMap<String, SolicitudRecurso> hm = new HashMap<String, SolicitudRecurso>();

                            SolicitudRecurso solrec = null;
                            long acum = 0;
                            Iterator<SolicitudRecurso> itcv = SolicitudRecurso.ClassMgr.listSolicitudRecursos(wsite);
                            while (itcv.hasNext()) {
                                solrec = itcv.next();
                                acum = 0;
                                long time_cv = (solrec.getFechaSolicitud() != null ? solrec.getFechaSolicitud().getTime() : 0);

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

                                conservar = true;

                                if (conservar) { // si cumple con rango de fechas

                                    hm.put(solrec.getId(), solrec);
                                    hmorder.put(solrec.getId(), solrec.getId());

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
                                <button onclick="javascript:history.back(1);">Regresar</button>
                                <button type="submit" >Guardar Excel</button>
                            </form>
                            <%
                                }
                                //termina step 3
                            } else { // step 4 detalle solicitud 

                                String id = request.getParameter("id");

                                SolicitudRecurso solrec = SolicitudRecurso.ClassMgr.getSolicitudRecurso(id, wsite);

                                SWBFormMgr fmgr = new SWBFormMgr(solrec.getSemanticObject(), SWBFormMgr.MODE_VIEW, SWBFormMgr.MODE_VIEW);

                                out.println(fmgr.renderForm(request));


                                String fromDate = request.getParameter("fromDate");
                                String toDate = request.getParameter("toDate");

                                boolean conservar = false;

                                HashMap<String, String> hmorder = new HashMap<String, String>();
                                HashMap<String, SolicitudRecurso> hm = new HashMap<String, SolicitudRecurso>();
                                /*
                                //SolicitudRecurso solrec = null;
                                long acum = 0;
                                Iterator<SolicitudRecurso> itcv = SolicitudRecurso.ClassMgr.listSolicitudRecursos(wsite);
                                while (itcv.hasNext()) {
                                solrec = itcv.next();
                                acum = 0;
                                long time_cv = 0; //solrec.getFechaSolicitud().getTime();
                                
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
                                
                                conservar=true;
                                
                                if (conservar) { // si cumple con rango de fechas
                                
                                hm.put(solrec.getId(), solrec);
                                hmorder.put(solrec.getId(), solrec.getId());
                                
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
                                
                                }*/
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
                                    <button onclick="javascript:history.back(1);">Regresar</button>
                                    <button type="submit" >Guardar Excel</button>
                                </form>
                                <%
                                        }
                                    } //step 4                                     
                                } else if ("buscar".equals(action)) {
                                    String wptitle = "Solicitud de Recursos";
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
                                        <button onclick="javascript:history.back(1);">Regresar</button>
                                        <button type="submit" >Buscar</button>
                                    </form>
                                </div>


                                <%
                                } else if ("2".equals(step)) { //step 2, hace la busqueda del texto en diplomados ó cursos TIC 

                                    String fromDate = request.getParameter("fromDate");
                                    String toDate = request.getParameter("toDate");

                                    //System.out.println("fromDate >>>" + fromDate + "<<< toDate >>>" + toDate + "<<<");

                                    boolean conservar = false;

                                    HashMap<String, SolicitudRecurso> hm = new HashMap<String, SolicitudRecurso>();

                                    SolicitudRecurso solrec = null;
                                    long acum = 0;
                                    Iterator<SolicitudRecurso> itcv = SolicitudRecurso.ClassMgr.listSolicitudRecursos(wsite);
                                    while (itcv.hasNext()) {
                                        solrec = itcv.next();
                                        acum = 0;
                                        long time_cv = 0; //solrec.getFechaSolicitud().getTime();

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

                                        conservar = true;

                                        if (conservar) { // si cumple con rango de fechas

                                            hm.put(solrec.getId(), solrec);

                                        }
                                    }
                                    acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                                    if (acum == 0) {
                                %>         
                                <p>No se encontraron registros</p>
                                <button onclick="javascript:history.back(1);">Regresar</button>
                                <%  } else {

                                    String criteria = "Solicitudes de Recursos registrados en la base de datos.";
                                    if (!fromDate.equals("") && !toDate.equals("")) {
                                        criteria = "Solicitudes de Recursos registradas a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0))) + " al " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
                                    } else if (toDate.equals("") && !fromDate.equals("")) {
                                        criteria = "Solicitudes de Recursos registradas a partir  del " + sdf.format(new Date(getTimeDate(fromDate, 0, 0, 0)));
                                    } else if (!toDate.equals("") && fromDate.equals("")) {
                                        criteria = "Solicitudes de Recursos registradas hasta el " + sdf.format(new Date(getTimeDate(toDate, 23, 59, 59)));
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
                                        <button onclick="javascript:history.back(1);">Regresar</button>
                                        <button type="submit" >Guardar Excel</button>
                                    </form>
                                    <%
                                        }

                                        // termina step 2
                                    } else if ("3".equals(step)) { // step 3 detalle reporte 
                                        String fromDate = request.getParameter("fromDate");
                                        String toDate = request.getParameter("toDate");

                                        boolean conservar = false;

                                        HashMap<String, String> hmorder = new HashMap<String, String>();
                                        HashMap<String, SolicitudRecurso> hm = new HashMap<String, SolicitudRecurso>();

                                        SolicitudRecurso solrec = null;
                                        long acum = 0;
                                        Iterator<SolicitudRecurso> itcv = SolicitudRecurso.ClassMgr.listSolicitudRecursos(wsite);
                                        while (itcv.hasNext()) {
                                            solrec = itcv.next();
                                            acum = 0;
                                            long time_cv = 0; //solrec.getFechaSolicitud().getTime();

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

                                            conservar = true;

                                            if (conservar) { // si cumple con rango de fechas

                                                hm.put(solrec.getId(), solrec);
                                                hmorder.put(solrec.getId(), solrec.getId());

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
                                            <button onclick="javascript:history.back(1);">Regresar</button>
                                            <button type="submit" >Guardar Excel</button>
                                        </form>
                                        <%
                                            }
                                            //termina step 3
                                        } else { // step 4 detalle solicitud 

                                            String id = request.getParameter("id");

                                            SolicitudRecurso solrec = SolicitudRecurso.ClassMgr.getSolicitudRecurso(id, wsite);

                                            SWBFormMgr fmgr = new SWBFormMgr(solrec.getSemanticObject(), SWBFormMgr.MODE_VIEW, SWBFormMgr.MODE_VIEW);

                                            out.println(fmgr.renderForm(request));


                                            String fromDate = request.getParameter("fromDate");
                                            String toDate = request.getParameter("toDate");

                                            boolean conservar = false;

                                            HashMap<String, String> hmorder = new HashMap<String, String>();
                                            HashMap<String, SolicitudRecurso> hm = new HashMap<String, SolicitudRecurso>();
                                            /*
                                            //SolicitudRecurso solrec = null;
                                            long acum = 0;
                                            Iterator<SolicitudRecurso> itcv = SolicitudRecurso.ClassMgr.listSolicitudRecursos(wsite);
                                            while (itcv.hasNext()) {
                                            solrec = itcv.next();
                                            acum = 0;
                                            long time_cv = 0; //solrec.getFechaSolicitud().getTime();
                                            
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
                                            
                                            conservar=true;
                                            
                                            if (conservar) { // si cumple con rango de fechas
                                            
                                            hm.put(solrec.getId(), solrec);
                                            hmorder.put(solrec.getId(), solrec.getId());
                                            
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
                                            
                                            }*/
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
                                                <button onclick="javascript:history.back(1);">Regresar</button>
                                                <button type="submit" >Guardar Excel</button>
                                            </form>
                                            <%
                                                    }
                                                } //step 4                                     
                                            } else if ("findcandidato".equals(action)) {
                                                //suri, smode, act, action
                                                
                                                out.println("find candidato<br/><br/>");
                                                String pFuncion = "", pEspecialidad = "", pAvance = "", pConocimiento = "", pCertificacion = "";
                                                String[] pCompetencias = null, pExpertise = null, pSector = null;
                                                Enumeration<String> enu = request.getParameterNames();
                                                while (enu.hasMoreElements()) {
                                                    String param = enu.nextElement();
                                                    if (!param.startsWith("solicitudRecurso.")) {
                                                        continue;
                                                    }
                                                    String[] params = null;
                                                    out.println(param + ": <br/>");
                                                    if (param.indexOf("has") != -1 || param.indexOf("sector") != -1) {
                                                        if (param.indexOf("hasExpertise") != -1) {
                                                            pExpertise = request.getParameterValues(param);
                                                        } else if (param.indexOf("hasCompetenciaReq") != -1) {
                                                            pCompetencias = request.getParameterValues(param);
                                                        } else if (param.indexOf("hasSectorExpertise") != -1) {
                                                            pSector = request.getParameterValues(param);
                                                        }
                                                        params = request.getParameterValues(param);
                                                        out.println("value(s): <br/>");
                                                        if (null != params) {
                                                            for (int i = 0; i < params.length; i++) {
                                                                out.println(">>>>>>>> " + params[i] + "<br/>");
                                                            }
                                                        } else {
                                                            out.println(">>>>>>>> <br/>");
                                                        }
                                                    } else {
                                                         if (param.indexOf("certificaciones") != -1) {
                                                            pCertificacion = request.getParameter(param);
                                                        } else if (param.indexOf("avance") != -1) {
                                                            pAvance = request.getParameter(param);
                                                        } else if (param.indexOf("funcionPrincipal") != -1) {
                                                            pFuncion = request.getParameter(param);
                                                        } else if (param.indexOf("conocimientoTecnico") != -1) {
                                                            pConocimiento = request.getParameter(param);
                                                        } else if (param.indexOf("especialidad") != -1) {
                                                            pEspecialidad = request.getParameter(param);
                                                        }
                                                        out.println("value(s): <br/>>>>>>>>> " + request.getParameter(param) + "<br/>");
                                                    }
                                                }
                                            }
                                            %>  
                                            </span></div>
                                            </div><!-- icv-data -->  
                                            </div>
                                            </div>

                                            <%!
                                                public String listReport(HashMap<String, SolicitudRecurso> hm, HashMap<String, String> hmorder, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
                                                    StringBuilder ret = new StringBuilder();
                                                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm", new Locale("es"));
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
                                                    ret.append("                    <th>Id Solicitud</th><th>Solicitante</th><th>Creado</th><th>Detalle</th>");
                                                    ret.append("                </tr>");
                                                    ret.append("            </thead>");
                                                    ret.append("            <tbody>");

                                                    ArrayList<String> list = new ArrayList(hmorder.keySet());
                                                    Collections.sort(list);

                                                    Iterator<String> itstr = list.iterator();
                                                    while (itstr.hasNext()) {
                                                        String key = itstr.next();
                                                        String keyorder = hmorder.get(key);

                                                        SolicitudRecurso solrec = hm.get(keyorder);
                                                        User usrcv = solrec.getSolicitanteRecurso();
                                                        WebPage wpage = wsite.getWebPage("ver_CV");
                                                        ret.append("                 <tr>");
                                                        ret.append("                     <td>");
                                                        ret.append(solrec.getId());
                                                        ret.append("                     </td>");
                                                        ret.append("                     <td>");
                                                        String usrname = (usrcv != null && usrcv.getFullName() != null ? usrcv.getFullName() : "---");
                                                        ret.append(usrname);
                                                        ret.append("                     </td>");
                                                        ret.append("                     <td>");
                                                        ret.append((solrec.getFechaSolicitud() != null ? sdf.format(solrec.getFechaSolicitud()) : "---"));
                                                        ret.append("                     </td>");
                                                        SWBResourceURL url = paramRequest.getRenderUrl();
                                                        //url.setAction("");
                                                        url.setParameter("id", solrec.getId());
                                                        url.setParameter("act", "");
                                                        //url.setParameter("step", "4");
                                                        url.setMode("detail");

                                                        ret.append("<td>");
                                                        if (!export.equals("excel")) {
                                                            //ret.append("<a href=\"#\" ");
                                                            //ret.append("onclick=\"javascript:newWin('");
                                                            //ret.append(url + "?id=" + solrec.getId()); //+usrcv.getId()
                                                            //ret.append("');return false;\" target=\"_blank\">ver</a>");
                                                            ret.append("<a href=\"#\" ");
                                                            ret.append("onclick=\"javascript:window.location='");
                                                            ret.append(url); //+usrcv.getId()
                                                            ret.append("';return false;\" >ver</a>");
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

                                            %>