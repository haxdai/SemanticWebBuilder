/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (?open source?),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */
package org.semanticwb.portal.admin.resources.reports;

import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Device;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebSite;
import org.semanticwb.model.SWBContext;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.admin.resources.reports.beans.WBAFilterReportBean;
import org.semanticwb.portal.admin.resources.reports.beans.IncompleteFilterException;
import org.semanticwb.portal.admin.resources.reports.jrresources.*;
import org.semanticwb.portal.admin.resources.reports.jrresources.data.JRDeviceAccessDataDetail;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.db.SWBRecHit;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


/** Esta clase genera el reporte de dispositivos, toma la informaci�n de los
 * objetos de WebBuilder de acuerdo con los par�metros recibidos del usuario. Este
 * archivo es usado en la parte de reportes.
 *
 * This class generates the device report, takes information from
 * WebBuilder objects according with user parameters. this file is used in report
 * sections.
 *
 * WBADeviceReport.java

 */
public class WBADeviceReport extends GenericResource {
    private static Logger log = SWBUtils.getLogger(WBADeviceReport.class);
    
    public static final int I_REPORT_TYPE = 1;
    private String strRscType;

    public void init() {
        Resource base = getResourceBase();
        try {
            strRscType = base.getResourceType().getResourceClassName();
        }catch (Exception e) {
            strRscType = "WBADeviceReport";
        }
    }

    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if(paramsRequest.getMode().equalsIgnoreCase("fillSelect")) {
            doRenderSelect(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("graph")) {
            doGraph(request, response, paramsRequest);
        }else if (paramsRequest.getMode().equalsIgnoreCase("report_excel")) {
            doRepExcel(request, response, paramsRequest);
        }else if (paramsRequest.getMode().equalsIgnoreCase("report_xml")) {
            doRepXml(request, response, paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("report_pdf")){
            doRepPdf(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("report_rtf")){
            doRepRtf(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }
    
    public void doRenderSelect(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");

        StringBuilder ret = new StringBuilder();
        String space="";

        WebSite webSite = SWBContext.getWebSite(request.getParameter("site"));
        String[] seldevs = (String[]) request.getSession(true).getAttribute("devs");
        if(seldevs != null) {
            Arrays.sort(seldevs);
        }else {
            seldevs = new String[0];
        }

        ArrayList<Device> devs=new ArrayList<Device>();
        Iterator<Device> itDevices = webSite.listDevices();
        while (itDevices.hasNext()) {
            devs.add(itDevices.next());
        }
        devs.trimToSize();

        ret.append("<select id=\"wb_device\" name=\"wb_device\" size=\""+(devs.size()<10?5:10)+"\" multiple=\"multiple\">\n");
        while(!devs.isEmpty()) {
            Device device = devs.get(0);
            ret.append("<option value=\""+device.getId()+"\"");
            if(Arrays.binarySearch(seldevs, device.getId())>=0) {
                ret.append(" selected=\"selected\"");
            }
            ret.append(">"+space+device.getTitle()+"</option>\n");
            devs.remove(0);
            if(device.listChilds().hasNext()) {
                renderSelect(devs, device, ret, space+"&nbsp;&nbsp;&nbsp;", seldevs);
            }
        }
        ret.append("</select>\n");
        request.getSession(true).removeAttribute("devs");
        
        PrintWriter out = response.getWriter();
        out.print(ret.toString());
        out.flush();
        out.close();
    }

    private void renderSelect(ArrayList origList, Device node, StringBuilder ret, String space, String[] seldevs) {
        ArrayList<Device> devs=new ArrayList<Device>();
        Iterator<Device> itDevices = node.listChilds();
        while(itDevices.hasNext()) {
            devs.add(itDevices.next());
        }
        devs.trimToSize();

        while(!devs.isEmpty()) {
            Device device = devs.get(0);
            ret.append("<option value=\""+device.getId()+"\"");
            if(Arrays.binarySearch(seldevs, device.getId())>=0) {
                ret.append(" selected=\"selected\"");
            }
            ret.append(">"+space+device.getTitle()+"</option>\n");
            origList.remove(device);
            devs.remove(0);
            if(device.listChilds().hasNext()) {
                renderSelect(origList, device, ret, space+"&nbsp;&nbsp;&nbsp;", seldevs);
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache"); 
        response.setHeader("Pragma", "no-cache"); 
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        
        final int I_ACCESS = 0;        
        GregorianCalendar gc_now = new GregorianCalendar();
        HashMap hm_sites = new HashMap();
        String rtype = null;
        int i_access = 0;

        try {
            // Evaluates if there are sites
            Iterator<WebSite> webSites = SWBContext.listWebSites();
            while(webSites.hasNext()){
                WebSite site = webSites.next();
                // Evaluates if TopicMap is not Global
                if(!site.getId().equals(SWBContext.getGlobalWebSite().getId())) {
                    // Get access level of this user on this topicmap and if level is greater than "0" then user have access
                    // TODO
//                    i_access = AdmFilterMgr.getInstance().haveAccess2TopicMap(paramsRequest.getUser(),site.getDbdata().getId());
//                    if(I_ACCESS < i_access) {
//                        if(site.getDbdata().getDeleted()==0) {                            
                            hm_sites.put(site.getId(), site.getDisplayTitle(paramsRequest.getUser().getLanguage()));
//                        }
//                    }
                }
            }

            // If there are sites continue
            if (hm_sites.size() > I_ACCESS) {
                String address = paramsRequest.getTopic().getUrl();
                String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");                

                String[] devs=request.getParameterValues("wb_device");
                if(devs != null) {
                    request.getSession(true).setAttribute("devs", devs);
                }
                
                int groupDates;
                try {
                    groupDates = request.getParameter("wb_rep_type")==null ? 0:Integer.parseInt(request.getParameter("wb_rep_type"));
                }catch(NumberFormatException e) {
                    groupDates = 0;
                }
                String fecha1 = request.getParameter("wb_fecha1")==null ? "":request.getParameter("wb_fecha1");
                String fecha11 = request.getParameter("wb_fecha11")==null ? "":request.getParameter("wb_fecha11"); 
                String fecha12 = request.getParameter("wb_fecha12")==null ? "":request.getParameter("wb_fecha12");
                
                String topicId = paramsRequest.getTopic().getId();
                if(topicId.lastIndexOf("Daily") != -1) {
                    rtype = "0";
                }else if(topicId.lastIndexOf("Monthly") != -1) {
                    rtype = "1";
                }else {
                    rtype = request.getParameter("wb_rtype");
                }
                if(rtype == null) {
                    rtype = "0";
                }
                
                SWBResourceURL url=paramsRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT);                

                out.println("<script type=\"text/javascript\">");                
                out.println("dojo.require(\"dijit.form.DateTextBox\");");
                out.println("dojo.addOnLoad(doBlockade);");
                // llenar el select de dispositivos
                url.setMode("fillSelect");
                out.println("dojo.addOnLoad(function(){postHtml('"+url+"'+'?site="+webSiteId+"','slave')});");

                out.println("function getParams(accion) {");
                out.println("   var dp = null;");
                out.println("   var params = '?';");
                out.println("   params = params + 'wb_site=' + dojo.byId('wb_site').value;");

                out.println("   var devs=dojo.byId('wb_device');");
                out.println("   for(i=0; i<devs.options.length; i++) {");
                out.println("       if(devs.options[i].selected) {");
                out.println("           params = params + '&wb_device=' + devs.options[i].value;");
                out.println("       }");
                out.println("   }");
                
                out.println("   params = params + '&wb_rtype=' + dojo.byId('wb_rtype').value;");
                out.println("   if(accion == 0) {");
                out.println("       params = params + '&wb_rep_type=' + getTypeSelected();");
                out.println("       var fecha1 = new String(dojo.byId('wb_fecha1').value);");
                out.println("       var fecha2 = new String(dojo.byId('wb_fecha11').value);");
                out.println("       var fecha3 = new String(dojo.byId('wb_fecha12').value);");                
                out.println("       if(fecha1.length>0) {");
                out.println("           dp = fecha1.split('/');");
                out.println("           params = params + '&wb_fecha1=' + dp[2]+'-'+dp[1]+'-'+dp[0];");
                out.println("       }");                
                out.println("       if(fecha2.length>0) {");
                out.println("           dp = fecha2.split('/');");
                out.println("           params = params + '&wb_fecha11=' + dp[2]+'-'+dp[1]+'-'+dp[0];");
                out.println("       }");                
                out.println("       if(fecha3.length>0) {");
                out.println("           dp = fecha3.split('/');");
                out.println("           params = params + '&wb_fecha12=' + dp[2]+'-'+dp[1]+'-'+dp[0];");
                out.println("       }");
                out.println("   }else {");
                out.println("       var year = new String(dojo.byId('wb_year13').value);");
                out.println("       params = params + '&wb_year13=' + year;");
                out.println("   }");
                out.println("   return params;");
                out.println("}");
                
                out.println("function validate(accion) {");
                out.println("    var fecha1 = null;");
                out.println("    var fecha2 = null;");
                out.println("    var fecha3 = null;");
                out.println("    if(accion=='0') {");
                out.println("       fecha1 = new String(dojo.byId('wb_fecha1').value);");
                out.println("       fecha2 = new String(dojo.byId('wb_fecha11').value);");
                out.println("       fecha3 = new String(dojo.byId('wb_fecha12').value);");
                out.println("       if( (fecha1.length==0) && (fecha2.length==0 || fecha3.length==0) ) {");
                out.println("          alert('Especifique la fecha o el rango de fechas que desea consultar');");
                out.println("          return false;");
                out.println("       }");
                out.println("    }");
                out.println("    return true;");
                out.println("}");

                out.println("function doXml(accion, size) { ");
                out.println("   if(validate(accion)) {");
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("report_xml")+"\"+params,\"graphWindow\",size);");
                out.println("   }");
                out.println("}");

                out.println("function doExcel(accion, size) { ");
                out.println("   if(validate(accion)) {");
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("report_excel")+"\"+params,\"graphWindow\",size);");
                out.println("   }");
                out.println("}");

                out.println("function doGraph(accion, size) { ");
                out.println("   if(validate(accion)) {");
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("graph")+"\"+params,\"graphWindow\",size);");
                out.println("   }");
                out.println("}");

                out.println("function doPdf(accion, size) { ");
                out.println("   if(validate(accion)) {");
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("report_pdf")+"\"+params,\"graphWindow\",size);");
                out.println("   }");
                out.println("}");

                out.println("function doRtf(accion, size) { ");
                out.println("   if(validate(accion)) {");
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("report_rtf")+"\"+params,\"graphWindow\",size);    ");
                out.println("   }");
                out.println("}");

                out.println(" function getTypeSelected(){");
                out.println("     var strType = \"0\";");
                out.println("     for(i=0;i<window.document.frmrep.wb_rep_type.length;i++){");
                out.println("       if(window.document.frmrep.wb_rep_type[i].checked==true){");
                out.println("           strType=window.document.frmrep.wb_rep_type[i].value;");
                out.println("       }");
                out.println("     }");
                out.println("     return strType;");
                out.println(" }");

                out.println("function doApply() { ");
                out.println("   if(validate(dojo.byId('wb_rtype').value)) {");
                out.println("      window.document.frmrep.submit(); ");
                out.println("   }");
                out.println("}");
                
                out.println(" function doBlockade() {");
                out.println("   if(window.document.frmrep.wb_rep_type) {");
                out.println("     if(window.document.frmrep.wb_rep_type[0].checked){");
                out.println("       dojo.byId('wb_fecha1').disabled = false;");
                out.println("       dojo.byId('wb_fecha11').disabled = true;");
                out.println("       dojo.byId('wb_fecha12').disabled = true;");                
                out.println("     }");
                out.println("     if(window.document.frmrep.wb_rep_type[1].checked){");
                out.println("       dojo.byId('wb_fecha1').disabled = true;");
                out.println("       dojo.byId('wb_fecha11').disabled = false;");
                out.println("       dojo.byId('wb_fecha12').disabled = false;");
                out.println("     }");
                out.println("   }");
                out.println(" }");

                out.println("</script>");
                // javascript

                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println("<legend>" + paramsRequest.getLocaleString("device_report") + "</legend>");

                out.println("<form id=\"frmrep\" name=\"frmrep\" method=\"post\" action=\""+address+"\">");
                out.println("<table border=\"0\" width=\"95%\" align=\"center\">");
                if(rtype.equals("0")) {
                    out.println("<tr><td width=\"183\"></td><td width=\"146\"></td><td width=\"157\"></td><td width=\"443\"></td></tr>");
                }else {
                    out.println("<tr><td width=\"100\"></td><td width=\"196\"></td><td width=\"224\"></td><td width=\"364\"></td></tr>");
                }
                out.println("<tr>");
                out.println("<td colspan=\"4\">");
                // Show report description
                if(rtype.equals("0")) {
                    out.println(paramsRequest.getLocaleString("description_daily"));
                }else {
                    out.println(paramsRequest.getLocaleString("description_monthly"));
                }                    
                out.println("</td></tr>");

                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr>");
                out.println(" <td colspan=\"4\">&nbsp;&nbsp;&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doXml('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\" value=\"XML\" name=\"btnXml\" />&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doExcel('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\" value=\"Excel\" name=\"btnExcel\" />&nbsp;");                
                out.println("   <input type=\"button\" onClick=\"doPdf('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\" value=\"PDF\" name=\"btnPdf\" />&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doRtf('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\" value=\"RTF\" name=\"btnRtf\" />&nbsp;");                
                out.println("   <input type=\"button\" onClick=\"doGraph('"+ rtype +"','width=600, height=550, scrollbars, resizable')\" value=\"" + paramsRequest.getLocaleString("graph") + "\" name=\"btnGraph\" />&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doApply()\" value=\"" + paramsRequest.getLocaleString("apply") + "\" name=\"btnApply\" />");
                out.println(" </td>");
                out.println("</tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");

                out.println("<tr>");
                out.println("<td>" + paramsRequest.getLocaleString("site") + ":</td>");
                url.setMode("fillSelect");
                out.println("<td colspan=\"2\"><select id=\"wb_site\" name=\"wb_site\" onchange=\"postHtml('"+url+"'+'?site='+this.value,'slave');\">");
                Iterator<String> itKeys = hm_sites.keySet().iterator();                    
                while(itKeys.hasNext()) {
                    String key = itKeys.next();
                    out.println("<option value=\"" + key + "\"");
                    if(key.equalsIgnoreCase(webSiteId)) {
                        out.println(" selected=\"selected\"");
                    }
                    out.println(">" + (String)hm_sites.get(key) + "</option>");
                }                    
                out.println("</select>");
                out.println("</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td>" + paramsRequest.getLocaleString("device") + ":</td>");                
                out.println("<td colspan=\"2\"><div id=\"slave\"></div>");
                out.println("</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");

                if(rtype.equals("0")) { // REPORTE DIARIO
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<label>");
                    out.println("<input type=\"radio\" value=\"0\" name=\"wb_rep_type\" id=\"wb_rep_type_0\" onclick=\"javascript: doBlockade();\"");
                    if(groupDates==0) {
                        out.println(" checked=\"checked\"");
                    }
                    out.println(" />");
                    out.println("&nbsp;" + paramsRequest.getLocaleString("by_day"));
                    out.println("</label></td>");
                    out.println("<td colspan=\"2\">");
                    out.println("<input type=\"text\" name=\"wb_fecha1\" id=\"wb_fecha1\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""+fecha1+"\">");
                    out.println("</td>");
                    out.println("<td><input type=\"hidden\" id=\"wb_rtype\" name=\"wb_rtype\" value=\"0\" /></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td colspan=4>&nbsp;</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<label>");
                    out.println("<input type=\"radio\" value=\"1\" name=\"wb_rep_type\" id=\"wb_rep_type_1\" onclick=\"javascript: doBlockade();\"");
                    if(groupDates!=0) {
                        out.println(" checked=\"checked\"");
                    }
                    out.println(" />");
                    out.println("&nbsp;" + paramsRequest.getLocaleString("by_interval_dates"));
                    out.println("</label></td>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name=\"wb_fecha11\" id=\"wb_fecha11\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""+fecha11+"\">");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name=\"wb_fecha12\" id=\"wb_fecha12\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""+fecha12+"\">");
                    out.println("</td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td colspan=\"4\">");
                    if(request.getParameter("wb_rtype")==null || webSiteId==null ) {
                        out.println("&nbsp;");
                    }else {
                        out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"98%\">");                            
                        out.println("<tr>");
                        out.println("<td>");

                        WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                        JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                        JasperTemplate jasperTemplate = JasperTemplate.DEVICE_DAILY_HTML;
                        HashMap params = new HashMap();
                        params.put("swb", SWBUtils.getApplicationPath()+"/swbadmin/images/swb-logo-hor.jpg");
                        params.put("site", filter.getSite());
                        try {
                            JRResource jrResource = new JRHtmlResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                            jrResource.prepareReport();
                            jrResource.exportReport(response);
                        }catch (Exception e) {
                            throw new javax.servlet.ServletException(e);
                        }

                        out.println("</td>");
                        out.println("</tr>");
                        out.println("</table>");
                        /*out.println("<hr size=\"1\" noshade>");*/
                    }
                    out.println("</td>");
                    out.println("</tr>");
                }else { // REPORTE MENSUAL                    
                    int year13 = request.getParameter("wb_year13")==null ? gc_now.get(Calendar.YEAR):Integer.parseInt(request.getParameter("wb_year13"));
                    out.println("<tr>");
                    out.println("<td colspan=\"3\">" + paramsRequest.getLocaleString("year") + ":&nbsp;&nbsp;<select id=\"wb_year13\" name=\"wb_year13\">");
                    for (int i = 2000; i < 2021; i++) {
                        out.println("<option value=\"" + i + "\"");
                        if (year13==i) {
                            out.println(" selected=\"selected\"");
                        }
                        out.println(">" + i + "</option>");
                    }
                    out.println("</select>");
                    out.println("</td>");
                    out.println("<td><input type=\"hidden\" id=\"wb_rtype\" name=\"wb_rtype\" value=\"1\" /></td>");                        
                    out.println("</tr>");
                    
                    out.println("<tr>");
                    out.println("<td colspan=\"4\">");
                    if(request.getParameter("wb_rtype")==null || webSiteId==null ) {
                        out.println("&nbsp;");
                    }else {
                        out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"98%\">");                            
                        out.println("<tr>");
                        out.println("<td>");

                        WBAFilterReportBean filter = new WBAFilterReportBean();
                        filter.setSite(webSiteId);
                        
                        String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
                        deviceId = deviceId.replaceFirst("\\[", "");
                        deviceId = deviceId.replaceFirst("\\]", "");
                        deviceId = deviceId.replace(" ", "");
                        if(!deviceId.equalsIgnoreCase("null")) {
                            filter.setIdaux(deviceId);
                        }

                        filter. setType(I_REPORT_TYPE);
                        filter.setYearI(year13);
                        JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                        JasperTemplate jasperTemplate = JasperTemplate.DEVICE_MONTHLY_HTML;
                        HashMap params = new HashMap();
                        params.put("swb", SWBUtils.getApplicationPath()+"/swbadmin/images/swb-logo-hor.jpg");
                        params.put("site", filter.getSite());
                        try {
                            JRResource jrResource = new JRHtmlResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                            jrResource.prepareReport();
                            jrResource.exportReport(response);                            
                        }catch (Exception e) {
                            throw new javax.servlet.ServletException(e);
                        }
                        out.println("</td>");
                        out.println("</tr>");
                        out.println("</table>");
                        /*out.println("<hr size=\"1\" noshade>");*/
                    }
                    out.println("</td>");
                    out.println("</tr>");
                }

                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("</table></form>");
                out.println("</fieldset></div>");
            }else {
                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println("<legend>" + paramsRequest.getLocaleString("device_report") + "</legend>");
                out.println("<form method=\"Post\" action=\"" + paramsRequest.getTopic().getUrl() + "\" id=\"frmrep\" name=\"frmrep\">");
                out.println("<table border=0 width=\"100%\">");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr>");
                out.println("<td>&nbsp;</td>");
                out.println("<td colspan=\"2\" align=\"center\">" + paramsRequest.getLocaleString("no_sites_found") + "</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("</table></form>");
                out.println("</fieldset></div>");
            }
        } catch (Exception e) {
            log.error("Error on method DoView() resource " + strRscType + " with id " + base.getId(), e);
        }
        out.flush();
        out.close();
    }
    
    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doGraph(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("application/pdf");
        Resource base = getResourceBase();

        try {
            int rtype = request.getParameter("wb_rtype")==null ? 0:Integer.parseInt(request.getParameter("wb_rtype"));
            if(rtype == 0) { // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_DAILY_GRAPH;
                JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }else { // REPORTE MENSUAL                
                WBAFilterReportBean filter = new WBAFilterReportBean();
                String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");
                filter.setSite(webSiteId);

                String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
                deviceId = deviceId.replaceFirst("\\[", "");
                deviceId = deviceId.replaceFirst("\\]", "");
                deviceId = deviceId.replace(" ", "");
                if(!deviceId.equalsIgnoreCase("null")) {
                    filter.setIdaux(deviceId);
                }

                filter. setType(I_REPORT_TYPE);
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                filter.setYearI(year13);

                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_MONTHLY_GRAPH;
                JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }
        }catch (Exception e) {
            log.error("Error on method doGraph() resource " + strRscType + " with id " + base.getId(), e);
            throw new SWBResourceException(e.getMessage());
        }
    }
    
    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */    
    public void doRepExcel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"lar.xls\"");
        Resource base = getResourceBase();
        /*ArrayList idaux = new ArrayList();*/
        try {
            int rtype = request.getParameter("wb_rtype")==null ? 0:Integer.parseInt(request.getParameter("wb_rtype"));            
            if(rtype == 0) { // by day
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_DAILY;
                JRResource jrResource = new JRXlsResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }else { // by month                
                WBAFilterReportBean filter = new WBAFilterReportBean();
                String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");
                filter.setSite(webSiteId);

                String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
                deviceId = deviceId.replaceFirst("\\[", "");
                deviceId = deviceId.replaceFirst("\\]", "");
                deviceId = deviceId.replace(" ", "");
                if(!deviceId.equalsIgnoreCase("null")) {
                    filter.setIdaux(deviceId);
                }

                filter. setType(I_REPORT_TYPE);
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                filter.setYearI(year13);
                
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_MONTHLY;                        
                JRResource jrResource = new JRXlsResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }
        }catch(Exception e) {
            log.error("Error on method doRepExcel() resource " + strRscType + " with id " + base.getId(), e);
            throw new SWBResourceException(e.getMessage());
        }
    }

    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doRepXml(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/xml;charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        
        Document dom = SWBUtils.XML.getNewDocument();        
        Resource base = getResourceBase();
        /*ArrayList idaux = new ArrayList();*/
        
        try {
            int rtype = request.getParameter("wb_rtype")==null ? 0:Integer.parseInt(request.getParameter("wb_rtype"));
            Iterator<SWBRecHit> itRecHits;
            int renglones = 0;
            Element report = dom.createElement("DeviceReport");
            dom.appendChild(report);
            
            if(rtype == 0) { // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JRBeanCollectionDataSource ds = (JRBeanCollectionDataSource)dataDetail.orderJRReport();
                if(ds!=null){
                    itRecHits = ds.getData().iterator();
                }else {
                    itRecHits = Collections.EMPTY_LIST.iterator();
                }
                while(itRecHits.hasNext()) {
                    SWBRecHit rec = itRecHits.next();
                    Element row = dom.createElement("row");
                    row.appendChild(dom.createTextNode(""));
                    row.setAttribute("id",Integer.toString(++renglones));
                    report.appendChild(row);
                    Element device = dom.createElement("device");
                    device.appendChild(dom.createTextNode(rec.getItem()));
                    row.appendChild(device);
                    Element site = dom.createElement("site");
                    site.appendChild(dom.createTextNode(rec.getTopicmap()));
                    row.appendChild(site);
                    Element year = dom.createElement("year");
                    year.appendChild(dom.createTextNode(Integer.toString(rec.getYear())));
                    row.appendChild(year);
                    Element month = dom.createElement("month");
                    month.appendChild(dom.createTextNode(rec.getMonth()));
                    row.appendChild(month);
                    Element day = dom.createElement("day");
                    day.appendChild(dom.createTextNode(Integer.toString(rec.getDay())));
                    row.appendChild(day);
                    Element pages = dom.createElement("pages");
                    pages.appendChild(dom.createTextNode(Long.toString(rec.getHits())));
                    row.appendChild(pages);
                }
            }else { // REPORTE MENSUAL
                WBAFilterReportBean filter = new WBAFilterReportBean();
                String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");
                filter.setSite(webSiteId);

                String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
                deviceId = deviceId.replaceFirst("\\[", "");
                deviceId = deviceId.replaceFirst("\\]", "");
                deviceId = deviceId.replace(" ", "");
                if(!deviceId.equalsIgnoreCase("null")) {
                    filter.setIdaux(deviceId);
                }

                filter. setType(I_REPORT_TYPE);
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                filter.setYearI(year13);
                
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JRBeanCollectionDataSource ds = (JRBeanCollectionDataSource)dataDetail.orderJRReport();
                if(ds!=null){
                    itRecHits = ds.getData().iterator();
                }else {
                    itRecHits = Collections.EMPTY_LIST.iterator();
                }
                while(itRecHits.hasNext()) {
                    SWBRecHit rec = itRecHits.next();
                    Element row = dom.createElement("row");
                    row.appendChild(dom.createTextNode(""));
                    row.setAttribute("id",Integer.toString(++renglones));
                    report.appendChild(row);
                    Element device = dom.createElement("device");
                    device.appendChild(dom.createTextNode(rec.getItem()));
                    row.appendChild(device);
                    Element site = dom.createElement("site");
                    site.appendChild(dom.createTextNode(rec.getTopicmap()));
                    row.appendChild(site);
                    Element year = dom.createElement("year");
                    year.appendChild(dom.createTextNode(Integer.toString(rec.getYear())));
                    row.appendChild(year);
                    Element month = dom.createElement("month");
                    month.appendChild(dom.createTextNode(rec.getMonth()));
                    row.appendChild(month);
                    Element pages = dom.createElement("pages");
                    pages.appendChild(dom.createTextNode(Long.toString(rec.getHits())));
                    row.appendChild(pages);
                }
            }
            report.setAttribute("rows",Integer.toString(renglones));
        }
        catch (Exception e){            
            log.error("Error on method doRepXml() resource " + strRscType + " with id " + base.getId(), e);
        }
        out.print(SWBUtils.XML.domToXml(dom));
        out.flush();
        out.close();
    }

    public void doRepPdf(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"lar.xls\"");

        Resource base = getResourceBase();
        try {
            int rtype = request.getParameter("wb_rtype")==null ? 0:Integer.parseInt(request.getParameter("wb_rtype"));            
            if(rtype == 0) { // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_DAILY;
                JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }else { // REPORTE MENSUAL
                WBAFilterReportBean filter = new WBAFilterReportBean();
                String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");
                filter.setSite(webSiteId);

                String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
                deviceId = deviceId.replaceFirst("\\[", "");
                deviceId = deviceId.replaceFirst("\\]", "");
                deviceId = deviceId.replace(" ", "");
                if(!deviceId.equalsIgnoreCase("null")) {
                    filter.setIdaux(deviceId);
                }

                filter. setType(I_REPORT_TYPE);
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                filter.setYearI(year13);
                
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_MONTHLY;                        
                JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }
        }catch(Exception e) {
            log.error("Error on method doRepExcel() resource " + strRscType + " with id " + base.getId(), e);
            throw new SWBResourceException(e.getMessage());
        }
    }
    
    public void doRepRtf(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"lar.xls\"");

        Resource base = getResourceBase();
        /*ArrayList idaux = new ArrayList();*/
        try {
            int rtype = request.getParameter("wb_rtype")==null ? 0:Integer.parseInt(request.getParameter("wb_rtype"));            
            if(rtype == 0) { // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_DAILY;
                JRResource jrResource = new JRRtfResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }else { // REPORTE MENSUAL
                WBAFilterReportBean filter = new WBAFilterReportBean();
                String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");
                filter.setSite(webSiteId);

                String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
                deviceId = deviceId.replaceFirst("\\[", "");
                deviceId = deviceId.replaceFirst("\\]", "");
                deviceId = deviceId.replace(" ", "");
                if(!deviceId.equalsIgnoreCase("null")) {
                    filter.setIdaux(deviceId);
                }

                filter. setType(I_REPORT_TYPE);
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                filter.setYearI(year13);
                
                JRDataSourceable dataDetail = new JRDeviceAccessDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.DEVICE_MONTHLY;                        
                JRResource jrResource = new JRRtfResource(jasperTemplate.getTemplatePath(), dataDetail.orderJRReport());
                jrResource.prepareReport();
                jrResource.exportReport(response);
            }
        }catch(Exception e) {
            log.error("Error on method doRepExcel() resource " + strRscType + " with id " + base.getId(), e);
            throw new SWBResourceException(e.getMessage());
        }
    }
        
    private WBAFilterReportBean buildFilter(HttpServletRequest request, SWBParamRequest paramsRequest) throws SWBResourceException, IncompleteFilterException {
        WBAFilterReportBean filterReportBean = null;
        String webSiteId = request.getParameter("wb_site")==null ? paramsRequest.getTopic().getWebSite().getId():request.getParameter("wb_site");

        String deviceId = Arrays.toString(request.getParameterValues("wb_device"));
        deviceId = deviceId.replaceFirst("\\[", "");
        deviceId = deviceId.replaceFirst("\\]", "");
        deviceId = deviceId.replace(" ", "");

        int groupDates;
        try {
            groupDates = request.getParameter("wb_rep_type")==null ? 0:Integer.parseInt(request.getParameter("wb_rep_type"));
        }catch(NumberFormatException e) {
            groupDates = 0;
        }
        String fecha1 = request.getParameter("wb_fecha1");
        String fecha11 = request.getParameter("wb_fecha11");
        String fecha12 = request.getParameter("wb_fecha12");
        if(groupDates==0 && fecha1==null) {
            throw new IncompleteFilterException("Falta la fecha");
        }
        if(groupDates==1 && (fecha11==null || fecha12==null)) {
            throw new IncompleteFilterException("Faltan las fechas");
        }
        
        try {
            if(groupDates==0) { // radio button was 0. Select only one date
                String[] numFecha = fecha1.split("-");
                filterReportBean = new WBAFilterReportBean();
                filterReportBean.setSite(webSiteId);
                if(!deviceId.equalsIgnoreCase("null")) {
                    filterReportBean.setIdaux(deviceId);
                }
                filterReportBean.setType(I_REPORT_TYPE);
                filterReportBean.setYearI(Integer.parseInt(numFecha[0]));
                filterReportBean.setMonthI(Integer.parseInt(numFecha[1]));
                filterReportBean.setDayI(Integer.parseInt(numFecha[2]));
            }else { // radio button was 1. Select between two dates
                filterReportBean = new WBAFilterReportBean();
                filterReportBean.setSite(webSiteId);
                if(!deviceId.equalsIgnoreCase("null")) {
                    filterReportBean.setIdaux(deviceId);
                }
                filterReportBean.setType(I_REPORT_TYPE);
                
                String[] numFecha = fecha11.split("-");
                filterReportBean.setYearI(Integer.parseInt(numFecha[0]));
                filterReportBean.setMonthI(Integer.parseInt(numFecha[1]));
                filterReportBean.setDayI(Integer.parseInt(numFecha[2]));

                numFecha = fecha12.split("-");
                filterReportBean.setYearF(Integer.parseInt(numFecha[0]));
                filterReportBean.setMonthF(Integer.parseInt(numFecha[1]));
                filterReportBean.setDayF(Integer.parseInt(numFecha[2]));
            }
        }catch (Exception e) {
            log.error("Error on method buildFilter() resource " + strRscType + " with id " + getResourceBase().getId(), e);
            throw(new SWBResourceException(e.getMessage()));
        }       
        return filterReportBean;
    }
}
