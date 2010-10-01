/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 


package org.semanticwb.portal.admin.resources.reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.admin.resources.reports.beans.IncompleteFilterException;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.admin.resources.reports.beans.WBAFilterReportBean;
import org.semanticwb.portal.admin.resources.reports.jrresources.*;
import org.semanticwb.portal.admin.resources.reports.jrresources.data.JRSessionDataDetail;
import org.semanticwb.portal.db.SWBRecHit;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.semanticwb.SWBPortal;
import org.semanticwb.portal.admin.resources.reports.jrresources.data.JRGlobalAccessDataDetail;
import org.semanticwb.portal.api.SWBResourceURL;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// TODO: Auto-generated Javadoc
/** Esta clase genera el reporte de sesiones, toma la informaci�n de los
 * objetos de WebBuilder de acuerdo con los par�metros recibidos del usuario. Este
 * archivo es usado en la parte de reportes.
 *
 * This class generates the session report, takes information from
 * WebBuilder objects according with user parameters. this file is used in report
 * sections. 
 */

public class WBASessionReport extends GenericResource {
    
    /** The log. */
    private static Logger log = SWBUtils.getLogger(WBASessionReport.class);

    /** The Constant S_REPORT_IDAUX. */
    public static final String S_REPORT_IDAUX = "_";
    
    /** The Constant I_REPORT_TYPE. */
    public static final int I_REPORT_TYPE = 5;
    
    /** The str rsc type. */
    private String strRscType;

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#init()
     */
    @Override
    public void init(){
        Resource base = getResourceBase();
        try {
            strRscType = base.getResourceType().getResourceClassName();
        }catch (Exception e) {
            strRscType = "WBASessionReport";
        }
    }

    /**
     * Render.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        if(!paramsRequest.WinState_MINIMIZED.equals(paramsRequest.getWindowState())) {
            processRequest(request, response, paramsRequest);
        }
    }

    /**
     * Process request.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if(paramsRequest.getMode().equals("graph")) {
            doGraph(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("histogram")) {
            doHistrogram(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equals("xls")) {
            doRepExcel(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equals("xml")) {
            doRepXml(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equals("pdf")) {
            doRepPdf(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equals("rtf")) {
            doRepRtf(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }

    /**
     * Do view.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        
        final int I_ACCESS = 0;
        HashMap hm_repository = new HashMap();
        String rtype;

        try {
            // Evaluates if there are repository
            Iterator<UserRepository> repositories = SWBContext.listUserRepositories();
            while(repositories.hasNext()) {
                UserRepository repository = repositories.next();
                // Get access level of this user on this topicmap and if level is greater than "0" then user have access
                // TODO
//                i_access = AdmFilterMgr.getInstance().haveAccess2UserRep(paramsRequest.getUser(),ur_repository.getName());
//                if(I_ACCESS < i_access) {                    
                    hm_repository.put(repository.getId(), repository.getSemanticObject().getDisplayName(paramsRequest.getUser().getLanguage()));
//                }
            }
            // If there are repositories it continues
            if(hm_repository.size() > I_ACCESS) {
                String address = paramsRequest.getRenderUrl().toString();
                String repositoryName = request.getParameter("wb_repository");
                
                int groupDates;
                try {
                    groupDates = request.getParameter("wb_rep_type")==null ? 0:Integer.parseInt(request.getParameter("wb_rep_type"));
                }catch(NumberFormatException e) {
                    groupDates = 0;
                }

                GregorianCalendar cal = new GregorianCalendar();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fecha1 = request.getParameter("wb_fecha1")==null ? sdf.format(cal.getTime()):request.getParameter("wb_fecha1");
                try {
                    sdf.parse(fecha1);
                }catch(ParseException pe){
                    fecha1 = sdf.format(cal.getTime());
                }
                String fecha11 = request.getParameter("wb_fecha11")==null ? sdf.format(cal.getTime()):request.getParameter("wb_fecha11");
                try {
                    sdf.parse(fecha11);
                }catch(ParseException pe){
                    fecha11 = sdf.format(cal.getTime());
                }
                String fecha12 = request.getParameter("wb_fecha12")==null ? sdf.format(cal.getTime()):request.getParameter("wb_fecha12");
                try {
                    sdf.parse(fecha12);
                }catch(ParseException pe){
                    fecha12 = sdf.format(cal.getTime());
                }
                
                String topicId = paramsRequest.getWebPage().getId();
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

                // javascript
                out.println("<script type=\"text/javascript\">");
                
                out.println("dojo.require(\"dijit.form.DateTextBox\");");
                out.println("dojo.addOnLoad(doBlockade);");
                
                out.println("function getParams(accion) {");
                out.println("   var params = '?';");
                out.println("   params = params + 'wb_repository=' + dojo.byId('wb_repository').value;");
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
                out.println("       params = params + '&wb_year13=' + dojo.byId('wb_year13').options[dojo.byId('wb_year13').selectedIndex].value;");
                out.println("   }");
                out.println("   return params;");
                out.println("}");
                
                /*out.println("function validate(accion) {");
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
                out.println("}");*/
                
                out.println("function doXml(accion, size) { ");
                /*out.println("   if(validate(accion)) {");*/
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("xml")+"\"+params,\"graphWindow\",size);    ");
                /*out.println("   }");*/
                out.println("}");
                
                out.println("function doExcel(accion, size) { ");
                /*out.println("   if(validate(accion)) {");*/
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("xls")+"\"+params,\"graphWindow\",size);    ");
                /*out.println("   }");*/
                out.println("}");

                out.println("function doHistogram(accion, size) { ");
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("histogram")+"\"+params,\"graphWindow\",size);   ");
                out.println(" }");
                
                out.println("function doGraph(accion, size) { ");
                /*out.println("   if(validate(accion)) {");*/
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("graph")+"\"+params,\"graphWindow\",size);    ");
                /*out.println("   }");*/
                out.println(" }");
                
                out.println("function doPdf(accion, size) { ");
                /*out.println("   if(validate(accion)) {");*/
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("pdf")+"\"+params,\"graphWindow\",size);    ");
                /*out.println("   }");*/
                out.println("}");
                
                out.println("function doRtf(accion, size) { ");
                /*out.println("   if(validate(accion)) {");*/
                out.println("      var params = getParams(accion);");
                out.println("      window.open(\""+url.setMode("rtf")+"\"+params,\"graphWindow\",size);    ");
                /*out.println("   }");*/
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
                
                out.println(" function doApply() { ");
                /*out.println("   if(validate(dojo.byId('wb_rtype').value)) {");*/
                out.println("      dojo.byId('frmrep').submit(); ");
                /*out.println("   }");*/
                out.println(" }");                

                out.println("function doBlockade() {");
                out.println("  if(window.document.frmrep.wb_rep_type) {");
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
                out.println("  }");
                out.println("}");

                out.println("</script>");
                
                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                if(rtype.equals("0")) {
                    out.println(paramsRequest.getLocaleString("daily_report"));
                }else {
                    out.println(paramsRequest.getLocaleString("monthly_report"));
                }
                out.println("</fieldset>");

                out.println("<form id=\"frmrep\" name=\"frmrep\" method=\"post\" action=\"" + address + "\">");
                out.println("<fieldset>");
                out.println("<legend>"+paramsRequest.getLocaleString("session_report")+"</legend>");                
                out.println("<table border=\"0\" width=\"95%\" align=\"center\">");
                if(rtype.equals("0")) {
                    out.println("<tr><td width=\"183\"></td><td width=\"146\"></td><td width=\"157\"></td><td width=\"443\"></td></tr>");
                }else {
                    out.println("<tr><td width=\"100\"></td><td width=\"196\"></td><td width=\"224\"></td><td width=\"364\"></td></tr>");
                }
                
                out.println("<tr>");
                out.println("<td>" + paramsRequest.getLocaleString("repository") + ":</td>");
                out.println("<td colspan=\"2\">");
                out.println("<select id=\"wb_repository\" name=\"wb_repository\" size=\"1\">");
                Iterator<String> itKeys = hm_repository.keySet().iterator();
                while(itKeys.hasNext()) {
                    String key = itKeys.next();
                    out.println("<option value=\""+ key + "\"");
                        if(key.equalsIgnoreCase(repositoryName)) {
                            out.println(" selected=\"selected\"");
                        }
                    out.println(">" + (String)hm_repository.get(key) + "</option>");
                }
                out.println("</select>");
                out.println("</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");

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
                    out.println("<input type=\"text\" name=\"wb_fecha1\" onblur=\"if(!this.value){this.focus();}\" id=\"wb_fecha1\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""+fecha1+"\">");
                    out.println("</td>");
                    out.println("<td><input type=\"hidden\" id=\"wb_rtype\" name=\"wb_rtype\" value=\"0\" /></td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<label>");
                    out.println("<input type=\"radio\" value=\"1\" name=\"wb_rep_type\" id=\"wb_rep_type_1\" onclick=\"javascript: doBlockade();\"");
                    if(groupDates!=0) {
                        out.println(" checked=\"checked\"");
                    }
                    out.println(" />");
                    out.println("&nbsp;" + paramsRequest.getLocaleString("by_range"));
                    out.println("</label></td>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name=\"wb_fecha11\" onblur=\"if(!this.value){this.focus();}\" id=\"wb_fecha11\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""+fecha11+"\">");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name=\"wb_fecha12\" onblur=\"if(!this.value){this.focus();}\" id=\"wb_fecha12\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""+fecha12+"\">");
                    out.println("</td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("</tr>");
                    out.println("</table></fieldset>");

                    out.println("<fieldset>");
                    out.println("<table border=\"0\" width=\"95%\">");
                    out.println("<tr>");
                    out.println(" <td colspan=\"4\">&nbsp;&nbsp;&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doXml('"+ rtype +"', 'width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">XML</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doExcel('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">"+paramsRequest.getLocaleString("spread_sheet")+"</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doPdf('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">PDF</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doRtf('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">RTF</button>");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doGraph('"+ rtype +"','width=600, height=550, scrollbars, resizable')\">"+paramsRequest.getLocaleString("graph")+"</button>");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doHistogram('"+rtype+"', 'width=700, height=600, scrollbars, resizable, alwaysRaised')\">"+paramsRequest.getLocaleString("histogram")+"</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doApply()\">"+paramsRequest.getLocaleString("apply")+"</button>");
                    out.println(" </td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</fieldset>");
                    out.println("</form>");
                    if(request.getParameter("wb_rtype")!=null && repositoryName!=null ) {
                        out.println("<fieldset>");
                        out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"98%\">");                            
                        out.println("<tr>");
                        out.println("<td>");
                        WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                        JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                        JasperTemplate jasperTemplate = JasperTemplate.SESSION_DAILY_HTML;
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
                        out.println("<tr><td>&nbsp;</td></tr>");
                        out.println("</table>");
                        out.println("</fieldset>");
                    }
                }else { // REPORTE MENSUAL
                    GregorianCalendar gc_now = new GregorianCalendar();
                    int year13 = request.getParameter("wb_year13")==null ? gc_now.get(Calendar.YEAR):Integer.parseInt(request.getParameter("wb_year13"));
                    out.println("<tr>");
                    out.println("<td>" + paramsRequest.getLocaleString("year") + ":</td>");                    
                    out.println("<td colspan=\"2\"><select id=\"wb_year13\" name=\"wb_year13\">");
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
                    out.println("</table></fieldset>");

                    out.println("<fieldset>");
                    out.println("<table border=\"0\" width=\"95%\">");
                    out.println("<tr>");
                    out.println(" <td colspan=\"4\">&nbsp;&nbsp;&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doXml('"+ rtype +"', 'width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">XML</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doExcel('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">"+paramsRequest.getLocaleString("spread_sheet")+"</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doPdf('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">PDF</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doRtf('"+ rtype +"','width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">RTF</button>");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doGraph('"+ rtype +"','width=600, height=550, scrollbars, resizable')\">"+paramsRequest.getLocaleString("graph")+"</button>");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doHistogram('"+rtype+"', 'width=700, height=600, scrollbars, resizable, alwaysRaised, menubar')\">"+paramsRequest.getLocaleString("histogram")+"</button>&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doApply()\">"+paramsRequest.getLocaleString("apply")+"</button>");
                    out.println(" </td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</fieldset>");
                    out.println("</form>");
                    if(request.getParameter("wb_rtype")!=null && repositoryName!=null ) {
                        out.println("<fieldset>");
                        out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"98%\">");
                        out.println("<tr><td>");
                        WBAFilterReportBean filter = new WBAFilterReportBean();
                        filter.setSite(repositoryName);
                        filter.setIdaux(S_REPORT_IDAUX);
                        filter. setType(I_REPORT_TYPE);
                        filter.setYearI(year13);
                        JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                        JasperTemplate jasperTemplate = JasperTemplate.SESSION_MONTHLY_HTML;
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
                        out.println("</td></tr>");
                        out.println("<tr><td>&nbsp;</td></tr>");
                        out.println("</table>");
                        out.println("</fieldset>");
                    }
                }
                out.println("</div>");
            }
            else { // There are not repositories and displays a message
                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println("<legend>" + paramsRequest.getLocaleString("session_report") + "</legend>");
                out.println("<form method=\"Post\" class=\"box\" action=\"" + paramsRequest.getWebPage().getUrl() + "\" id=\"frmrep\" name=\"frmrep\">");
                out.println("<table border=0 width=\"100%\">");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr>");
                out.println("<td>&nbsp;</td>");
                out.println("<td colspan=\"2\" align=\"center\" class=\"datos\">" + paramsRequest.getLocaleString("no_repositories_found") + "</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("</table></form>");
                out.println("</fieldset></div>");
            }
        }
        catch (Exception e){
            log.error("Error on method DoView() resource " + strRscType + " with id " + base.getId(), e);
        }
        out.flush();
        out.close();
    }

    /**
     * Do graph.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doGraph(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/pdf");
        Resource base = getResourceBase();
        
        try{            
            String repositoryName = request.getParameter("wb_repository");
            String rtype = request.getParameter("wb_rtype")==null ? "0" : request.getParameter("wb_rtype");            
            HashMap params = new HashMap();
            params.put("swb", SWBUtils.getApplicationPath()+"/swbadmin/images/swb-logo-hor.jpg");
            params.put("site", repositoryName);
            
            if(rtype.equals("0")) {  // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.SESSION_DAILY_GRAPH;                
                try {
                    JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                    jrResource.prepareReport();
                    jrResource.exportReport(response);                            
                }catch (Exception e) {
                    throw new javax.servlet.ServletException(e);
                }
            }else {  // REPORTE MENSUAL
                String s_year_13 = request.getParameter("wb_year13");                
                if( s_year_13!=null ) {
                    WBAFilterReportBean filter = new WBAFilterReportBean();
                    filter.setSite(repositoryName);
                    filter.setIdaux(S_REPORT_IDAUX);
                    filter. setType(I_REPORT_TYPE);
                    filter.setYearI(Integer.parseInt(s_year_13));
                    JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                    JasperTemplate jasperTemplate = JasperTemplate.SESSION_MONTHLY_GRAPH;                        
                    try {
                        JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                        jrResource.prepareReport();
                        jrResource.exportReport(response);                            
                    }catch (Exception e) {
                        throw new javax.servlet.ServletException(e);
                    }
                }
            }
        }
        catch (Exception e){
            log.error("Error on method doGraph() resource " + strRscType + " with id " + base.getId(), e);
        }
    }

    /**
     * Do rep excel.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doRepExcel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"sr.xls\"");
        Resource base = getResourceBase();
        
        try{
            String repositoryName = request.getParameter("wb_repository");
            String rtype = request.getParameter("wb_rtype")==null ? "0" : request.getParameter("wb_rtype");            
            HashMap params = new HashMap();
            params.put("swb", SWBUtils.getApplicationPath()+"/swbadmin/images/swb-logo-hor.jpg");
            params.put("site", repositoryName);
            
            if(rtype.equals("0")) {  // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.SESSION_DAILY;                
                try {
                    JRResource jrResource = new JRXlsResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                    jrResource.prepareReport();
                    jrResource.exportReport(response);                            
                }catch (Exception e) {
                    throw new javax.servlet.ServletException(e);
                }
            }else {  // REPORTE MENSUAL
                String s_year_13 = request.getParameter("wb_year13");
                if( s_year_13!=null ){
                    WBAFilterReportBean filter = new WBAFilterReportBean();
                    filter.setSite(repositoryName);
                    filter.setIdaux(S_REPORT_IDAUX);
                    filter. setType(I_REPORT_TYPE);
                    filter.setYearI(Integer.parseInt(s_year_13));
                    JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                    JasperTemplate jasperTemplate = JasperTemplate.SESSION_MONTHLY;                        
                    try {
                        JRResource jrResource = new JRXlsResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                        jrResource.prepareReport();
                        jrResource.exportReport(response);                            
                    }catch (Exception e) {
                        throw new javax.servlet.ServletException(e);
                    }
                }
            }
        }
        catch (Exception e){
            log.error("Error on method doRepExcel() resource " + strRscType + " with id " + base.getId(), e);
        }
    }

    /**
     * Do rep xml.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doRepXml(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("text/xml;charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        
        Document dom = SWBUtils.XML.getNewDocument();        
        Resource base = getResourceBase();
        try {
            WBAFilterReportBean filter;            
            Iterator<SWBRecHit> itRecHits;
            int rtype = request.getParameter("wb_rtype")==null ? 0:Integer.parseInt(request.getParameter("wb_rtype"));
            if(rtype == 0) { // REPORTE DIARIO
                filter = buildFilter(request, paramsRequest);                
            }else { // REPORTE MENSUAL
                String repository = request.getParameter("wb_repository");
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                filter = new WBAFilterReportBean();
                filter.setSite(repository);
                filter.setIdaux(S_REPORT_IDAUX);
                filter. setType(I_REPORT_TYPE);
                filter.setYearI(year13);
            }
            int renglones = 0;
            Element report = dom.createElement("SessionReport");
            dom.appendChild(report);
            JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
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

                Element site = dom.createElement("repository");
                site.appendChild(dom.createTextNode(rec.getTopicmap()));
                row.appendChild(site);

                Element year = dom.createElement("year");
                year.appendChild(dom.createTextNode(Integer.toString(rec.getYear())));
                row.appendChild(year);

                Element month = dom.createElement("month");
                month.appendChild(dom.createTextNode(rec.getMonth()));
                row.appendChild(month);

                Element pages = dom.createElement("sessions");
                pages.appendChild(dom.createTextNode(Long.toString(rec.getHits())));
                row.appendChild(pages);
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
    
    /**
     * Do rep pdf.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doRepPdf(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/pdf");
        Resource base = getResourceBase();
        
        try {
            String repositoryName = request.getParameter("wb_repository");
            String rtype = request.getParameter("wb_rtype")==null ? "0" : request.getParameter("wb_rtype");            
            HashMap params = new HashMap();
            params.put("swb", SWBUtils.getApplicationPath()+"/swbadmin/images/swb-logo-hor.jpg");
            params.put("site", repositoryName);
            
            if(rtype.equals("0")) {  // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.SESSION_DAILY;                
                try {
                    JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                    jrResource.prepareReport();
                    jrResource.exportReport(response);                            
                }catch (Exception e) {
                    throw new javax.servlet.ServletException(e);
                }
            }else {  // REPORTE MENSUAL
                String s_year_13 = request.getParameter("wb_year13");
                /*if(!s_repository.equals(null)){*/
                    if( s_year_13!=null ){
                        WBAFilterReportBean filter = new WBAFilterReportBean();
                        filter.setSite(repositoryName);
                        filter.setIdaux(S_REPORT_IDAUX);
                        filter. setType(I_REPORT_TYPE);
                        filter.setYearI(Integer.parseInt(s_year_13));
                        JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                        JasperTemplate jasperTemplate = JasperTemplate.SESSION_MONTHLY;                        
                        try {
                            JRResource jrResource = new JRPdfResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                            jrResource.prepareReport();
                            jrResource.exportReport(response);                            
                        }catch (Exception e) {
                            throw new javax.servlet.ServletException(e);
                        }
                    }
                /*}*/
            }
        }
        catch (Exception e){
            log.error("Error on method doRepPdf() resource " + strRscType + " with id " + base.getId(), e);
        }
    }
    
    /**
     * Do rep rtf.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doRepRtf(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/rtf");
        response.setHeader("Content-Disposition", "inline; filename=\"sr.rtf\"");
        Resource base = getResourceBase();

        try {
            String repositoryName = request.getParameter("wb_repository");
            String rtype = request.getParameter("wb_rtype")==null ? "0" : request.getParameter("wb_rtype");            
            HashMap params = new HashMap();
            params.put("swb", SWBUtils.getApplicationPath()+"/swbadmin/images/swb-logo-hor.jpg");
            params.put("site", repositoryName);
            
            if(rtype.equals("0")) {  // REPORTE DIARIO
                WBAFilterReportBean filter = buildFilter(request, paramsRequest);
                JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                JasperTemplate jasperTemplate = JasperTemplate.SESSION_DAILY;                
                try {
                    JRResource jrResource = new JRRtfResource(jasperTemplate.getTemplatePath(),params, dataDetail.orderJRReport());
                    jrResource.prepareReport();
                    jrResource.exportReport(response);                            
                }catch (Exception e) {
                    throw new javax.servlet.ServletException(e);
                }
            }else {  // REPORTE MENSUAL
                String s_year_13 = request.getParameter("wb_year13");
                /*if(!s_repository.equals(null)){*/                    
                    if( s_year_13!=null ){
                        WBAFilterReportBean filter = new WBAFilterReportBean();
                        filter.setSite(repositoryName);
                        filter.setIdaux(S_REPORT_IDAUX);
                        filter. setType(I_REPORT_TYPE);
                        filter.setYearI(Integer.parseInt(s_year_13));
                        JRDataSourceable dataDetail = new JRSessionDataDetail(filter);
                        JasperTemplate jasperTemplate = JasperTemplate.SESSION_MONTHLY;                        
                        try {
                            JRResource jrResource = new JRRtfResource(jasperTemplate.getTemplatePath(), params, dataDetail.orderJRReport());
                            jrResource.prepareReport();
                            jrResource.exportReport(response);                            
                        }catch (Exception e) {
                            throw new javax.servlet.ServletException(e);
                        }
                    }
                /*}*/
            }
        }
        catch (Exception e){
            log.error("Error on method doRepRtf() resource " + strRscType + " with id " + base.getId(), e);
        }
    }

    /**
     * Do histrogram.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doHistrogram(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        StringBuffer sb_ret = new StringBuffer();
        StringBuffer sb_app = new StringBuffer();
        Resource base = paramsRequest.getResourceBase();
        String monthinyear = null;
        boolean hasBarname = false;
        int j = 0;

        try {
            String rtype = request.getParameter("wb_rtype")==null? "0":request.getParameter("wb_rtype");
            monthinyear = request.getParameter("wbr_barname");
            if(monthinyear != null){
                hasBarname = true;
            }

            sb_ret.append("<html>");
            sb_ret.append("<head>");
            sb_ret.append("<title>"+paramsRequest.getLocaleString("session_report")+"</title>");
            sb_ret.append("</head>");
            //sb_ret.append("<LINK href=\"" + WBUtils.getInstance().getWebPath() +"work/WBAdmin/templates/3/1/images/wb3.css\" rel=\"stylesheet\" type=\"text/css\" >");
            sb_ret.append("<body>");
            sb_ret.append("<table border=\"0\" width=\"98%\">");
            sb_ret.append("<tr>");
            sb_ret.append("<td colpsan=\"3\" align=\"center\">");
            sb_ret.append("<img src=\""+SWBPortal.getContextPath()+"/swbadmin/images/swb-logo-hor.jpg\" alt=\"\" width=\"229\" height=\"44\" />");
            sb_ret.append("</td>");
            sb_ret.append("</tr>");
            sb_ret.append("<tr><td colpsan=\"3\">&nbsp;</td></tr>");
            sb_ret.append("<tr>");
            sb_ret.append("<td colpsan=\"3\" align=\"right\">");
            if(hasBarname) {
                sb_ret.append("<input type=\"button\" class=\"boton\" onClick=\"window.history.back()\" value=\""+paramsRequest.getLocaleString("back")+"\" name=\"btnBack\">&nbsp;");
            }
            sb_ret.append("<input type=\"button\" class=\"boton\" onClick=\"window.print()\" value=\""+paramsRequest.getLocaleString("print")+"\" name=\"btnPrint\">&nbsp;");
            sb_ret.append("<input type=\"button\" class=\"boton\" onClick=\"window.close()\" value=\""+paramsRequest.getLocaleString("close")+"\" name=\"btnClose\">");
            sb_ret.append("</td>");
            sb_ret.append("</tr>");
            sb_ret.append("<tr><td colpsan=\"3\" align=\"center\">"+request.getParameter("wb_repository")+"</td></tr>");
            sb_ret.append("<tr>");
            sb_ret.append("<td colpsan=\"3\">");
            sb_ret.append(getHistogram(request, response, paramsRequest));
            /*sb_app.append("\n<APPLET code=\"applets.graph.WBGraph.class\" archive=\""+ SWBPortal.getContextPath() + "/swbadmin/lib/SWBAplGraph.jar\" width=\"98%\" height=\"450\">");
            sb_app.append("<param name=\"GraphType\" value=\"Bar\">");
            sb_app.append("<param name=\"ncdata\" value=\"1\">");
            sb_app.append("<param name=\"percent\" value=\"false\">");

            JRBeanCollectionDataSource  ds;
            if(rtype.equals("0")) { // by day
                WBAFilterReportBean filter;
                if(hasBarname) {
                    filter = new WBAFilterReportBean(paramsRequest.getUser().getLanguage());
                    filter.setSite(request.getParameter("wb_site"));
                    filter.setIdaux(S_REPORT_IDAUX);
                    filter.setType(I_REPORT_TYPE);
                    filter.setGroupedDates(true);

                    SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
                    Date di = format.parse("01/"+monthinyear);
                    GregorianCalendar ci = new GregorianCalendar();
                    ci.setTime(di);
                    GregorianCalendar cf = new GregorianCalendar();
                    cf.setTime(di);
                    cf.add(Calendar.DAY_OF_MONTH, cf.getActualMaximum(Calendar.DAY_OF_MONTH)-1);
                    filter.setYearI(ci.get(Calendar.YEAR));
                    filter.setMonthI(ci.get(Calendar.MONTH)+1);
                    filter.setDayI(ci.get(Calendar.DAY_OF_MONTH));
                    filter.setYearF(cf.get(Calendar.YEAR));
                    filter.setMonthF(cf.get(Calendar.MONTH)+1);
                    filter.setDayF(cf.get(Calendar.DAY_OF_MONTH));
                }else {
                    filter = buildFilter(request, paramsRequest);
                }
                JRDataSourceable dataDetail = new JRGlobalAccessDataDetail(filter);
                ds = dataDetail.orderJRReport();
                Iterator<SWBRecHit> it = ds.getData().iterator();
                while(it.hasNext()) {
                    SWBRecHit rh = it.next();
                    sb_app.append("<param name=\"label" + j + "\" value=\""+rh.getDay()+"-"+rh.getMonth("MMM")+"\">");
                    sb_app.append("<param name=\"data" + j + "\" value=\"" + rh.getHits() + "\">");
                    j++;
                }
                Locale loc = new Locale(paramsRequest.getUser().getLanguage());
                if(filter.isGroupedDates())
                    sb_app.append("<param name=\"Title\" value=\""+paramsRequest.getLocaleString("daily_report")+". "+paramsRequest.getLocaleString("query_range")+": "+paramsRequest.getLocaleString("from")+" "+DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(filter.getDateI())+" "+paramsRequest.getLocaleString("to")+" "+DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(filter.getDateF())+"\">");
                else
                    sb_app.append("<param name=\"Title\" value=\""+paramsRequest.getLocaleString("monthly_report")+". "+paramsRequest.getLocaleString("query_range")+": "+DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(filter.getDateI())+"\">");
                sb_app.append("<param name=\"ndata\" value=\""+ ds.getRecordCount() +"\">");
            }else { // by each month
                String websiteId = request.getParameter("wb_site");
                int year13 = Integer.parseInt(request.getParameter("wb_year13"));
                WBAFilterReportBean filter = new WBAFilterReportBean();
                filter.setSite(websiteId);
                filter.setIdaux(S_REPORT_IDAUX);
                filter. setType(I_REPORT_TYPE);
                filter.setYearI(year13);
                JRDataSourceable dataDetail = new JRGlobalAccessDataDetail(filter);
                ds = dataDetail.orderJRReport();
                Iterator<SWBRecHit> it = ds.getData().iterator();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                while(it.hasNext()) {
                    SWBRecHit rh = it.next();
                    sb_app.append("\n<param name=\"label" + j + "\" value=\""+rh.getMonth("MMM")+"/"+rh.getYear()+"\">");
                    sb_app.append("\n<param name=\"data" + j + "\" value=\"" + rh.getHits() + "\">");
                    j++;
                    sdf.format(new Date(rh.getDate().getTime()));
                }
                sb_app.append("\n<param name=\"Title\" value=\""+paramsRequest.getLocaleString("monthly_report")+". "+paramsRequest.getLocaleString("query_range")+": "+year13+"\">");
                sb_app.append("\n<param name=\"ndata\" value=\""+ ds.getRecordCount() +"\">");
                String url = paramsRequest.getRenderUrl().toString()+"?wb_rtype=0&wb_rep_type=1&wb_site="+websiteId+"&wb_year13="+year13+"&wbr_barname=";
                sb_app.append("\n<param name=\"link\" value=\""+ url+ "\">");
            }
            sb_app.append("<param name=\"barname0\" value=\"Hits\">");

            sb_app.append("<param name=\"color0\" value=\"100,100,255\">");
            sb_app.append("<param name=\"color1\" value=\"255,100,100\">");
            sb_app.append("<param name=\"color2\" value=\"100,255,100\">");
            sb_app.append("<param name=\"color3\" value=\"100,250,250\">");
            sb_app.append("<param name=\"color4\" value=\"250,100,250\">");
            sb_app.append("<param name=\"color5\" value=\"250,250,100\">");
            sb_app.append("<param name=\"color6\" value=\"0,0,250\">");
            sb_app.append("<param name=\"color7\" value=\"250,0,0\">");
            sb_app.append("<param name=\"color8\" value=\"0,250,0\">");
            sb_app.append("<param name=\"color9\" value=\"0,250,250\">");
            sb_app.append("<param name=\"color10\" value=\"250,0,250\">");
            sb_app.append("<param name=\"color11\" value=\"200,200,100\">");
            sb_app.append("<param name=\"color12\" value=\"230,180,80\">");

            sb_app.append("<param name=\"zoom\" value=\"true\">");
            sb_app.append("\n</APPLET>");

            // Evaluates if there are records
            if(ds.getData().isEmpty())
                sb_ret.append("\n<br/><br/><br/><br/><font color=\"black\">"+paramsRequest.getLocaleString("no_records")+"</font>");
            else
                sb_ret.append(sb_app.toString());*/
            sb_ret.append("\n</td>");
            sb_ret.append("</tr>");
            sb_ret.append("</table>");
            sb_ret.append("</body>");
            sb_ret.append("</html>");
        }
        catch (Exception e){
            log.error("Error on method doHistogram() resource " + strRscType + " with id " + base.getId(), e);
        }
        response.getWriter().print(sb_ret.toString());
    }

    /**
     * Gets the histogram.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @return the histogram
     * @throws SWBResourceException the sWB resource exception
     */
    public String getHistogram(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException {
        StringBuffer sb_ret = new StringBuffer();
        StringBuffer sb_app = new StringBuffer();
        boolean hasBarname = false;
        int j = 0;

        String rtype = request.getParameter("wb_rtype")==null? "1":request.getParameter("wb_rtype");
        String monthinyear = request.getParameter("wbr_barname");
        if(monthinyear != null){
            hasBarname = true;
        }
        sb_app.append("\n<APPLET code=\"applets.graph.WBGraph.class\" archive=\""+ SWBPortal.getContextPath() + "/swbadmin/lib/SWBAplGraph.jar\" width=\"98%\" height=\"450\">");
        sb_app.append("<param name=\"GraphType\" value=\"Bar\">");
        sb_app.append("<param name=\"ncdata\" value=\"1\">");
        sb_app.append("<param name=\"percent\" value=\"false\">");

        JRBeanCollectionDataSource  ds;
        if(rtype.equals("0")) { // by day
            WBAFilterReportBean filter;
            if(hasBarname) {
                filter = new WBAFilterReportBean(paramsRequest.getUser().getLanguage());
                filter.setSite(request.getParameter("wb_site"));
                filter.setIdaux(S_REPORT_IDAUX);
                filter.setType(I_REPORT_TYPE);
                filter.setGroupedDates(true);

                SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
                Date di = null;
                try {
                    di = format.parse("01/"+monthinyear);
                }catch(ParseException pe) {
                    throw new SWBResourceException(pe.getMessage());
                }
                GregorianCalendar ci = new GregorianCalendar();
                ci.setTime(di);
                GregorianCalendar cf = new GregorianCalendar();
                cf.setTime(di);
                cf.add(Calendar.DAY_OF_MONTH, cf.getActualMaximum(Calendar.DAY_OF_MONTH)-1);
                filter.setYearI(ci.get(Calendar.YEAR));
                filter.setMonthI(ci.get(Calendar.MONTH)+1);
                filter.setDayI(ci.get(Calendar.DAY_OF_MONTH));
                filter.setYearF(cf.get(Calendar.YEAR));
                filter.setMonthF(cf.get(Calendar.MONTH)+1);
                filter.setDayF(cf.get(Calendar.DAY_OF_MONTH));
            }else {
                try {
                    filter = buildFilter(request, paramsRequest);
                }catch(IncompleteFilterException ife) {
                    throw new SWBResourceException(ife.getMessage());
                }
            }
            JRDataSourceable dataDetail = new JRGlobalAccessDataDetail(filter);
            try {
                ds = dataDetail.orderJRReport();
            }catch(IncompleteFilterException ife) {
                throw new SWBResourceException(ife.getMessage());
            }
            Iterator<SWBRecHit> it = ds.getData().iterator();
            while(it.hasNext()) {
                SWBRecHit rh = it.next();
                sb_app.append("<param name=\"label" + j + "\" value=\""+rh.getDay()+"-"+rh.getMonth("MMM")+"\">");
                sb_app.append("<param name=\"data" + j + "\" value=\"" + rh.getHits() + "\">");
                j++;
            }
            Locale loc = new Locale(paramsRequest.getUser().getLanguage());
            if(filter.isGroupedDates())
                sb_app.append("<param name=\"Title\" value=\""+paramsRequest.getLocaleString("daily_report")+". "+paramsRequest.getLocaleString("query_range")+": "+paramsRequest.getLocaleString("from")+" "+DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(filter.getDateI())+" "+paramsRequest.getLocaleString("to")+" "+DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(filter.getDateF())+"\">");
            else
                sb_app.append("<param name=\"Title\" value=\""+paramsRequest.getLocaleString("daily_report")+". "+paramsRequest.getLocaleString("query_range")+": "+DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(filter.getDateI())+"\">");
            sb_app.append("<param name=\"ndata\" value=\""+ ds.getRecordCount() +"\">");
        }else { // by each month
            String repositoryId = request.getParameter("wb_repository")!=null?request.getParameter("wb_repository") : (String)request.getAttribute("wb_repository");
            int year13;
            try {
                year13 = Integer.parseInt(request.getParameter("wb_year13"));
            }catch(NumberFormatException nfe) {
                year13 = new GregorianCalendar().get(Calendar.YEAR);
            }
            WBAFilterReportBean filter = new WBAFilterReportBean();
            filter.setSite(repositoryId);
            filter.setIdaux(S_REPORT_IDAUX);
            filter. setType(I_REPORT_TYPE);
            filter.setYearI(year13);
            JRDataSourceable dataDetail = new JRGlobalAccessDataDetail(filter);
            try {
                ds = dataDetail.orderJRReport();
            }catch(IncompleteFilterException ife) {
                throw new SWBResourceException(ife.getMessage());
            }
            Iterator<SWBRecHit> it = ds.getData().iterator();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while(it.hasNext()) {
                SWBRecHit rh = it.next();
                sb_app.append("\n<param name=\"label" + j + "\" value=\""+rh.getMonth("MMM")+"/"+rh.getYear()+"\">");
                sb_app.append("\n<param name=\"data" + j + "\" value=\"" + rh.getHits() + "\">");
                j++;
                sdf.format(new Date(rh.getDate().getTime()));
            }
            sb_app.append("\n<param name=\"Title\" value=\""+paramsRequest.getLocaleString("monthly_report")+". "+paramsRequest.getLocaleString("query_range")+": "+year13+"\">");
            sb_app.append("\n<param name=\"ndata\" value=\""+ ds.getRecordCount() +"\">");
            String url = paramsRequest.getRenderUrl().toString()+"?wb_rtype=0&wb_rep_type=1&wb_site="+repositoryId+"&wb_year13="+year13+"&wbr_barname=";
            sb_app.append("\n<param name=\"link\" value=\""+ url+ "\">");
        }
        sb_app.append("<param name=\"barname0\" value=\"Hits\">");

        sb_app.append("<param name=\"color0\" value=\"100,100,255\">");
        sb_app.append("<param name=\"color1\" value=\"255,100,100\">");
        sb_app.append("<param name=\"color2\" value=\"100,255,100\">");
        sb_app.append("<param name=\"color3\" value=\"100,250,250\">");
        sb_app.append("<param name=\"color4\" value=\"250,100,250\">");
        sb_app.append("<param name=\"color5\" value=\"250,250,100\">");
        sb_app.append("<param name=\"color6\" value=\"0,0,250\">");
        sb_app.append("<param name=\"color7\" value=\"250,0,0\">");
        sb_app.append("<param name=\"color8\" value=\"0,250,0\">");
        sb_app.append("<param name=\"color9\" value=\"0,250,250\">");
        sb_app.append("<param name=\"color10\" value=\"250,0,250\">");
        sb_app.append("<param name=\"color11\" value=\"200,200,100\">");
        sb_app.append("<param name=\"color12\" value=\"230,180,80\">");

        sb_app.append("<param name=\"zoom\" value=\"true\">");
        sb_app.append("\n</APPLET>");

        // Evaluates if there are records
        if(ds.getData().isEmpty())
            sb_ret.append("\n<br/><br/><br/><br/><font color=\"black\">"+paramsRequest.getLocaleString("no_records")+"</font>");
        else
            sb_ret.append(sb_app.toString());
        return sb_ret.toString();
    }

    /**
     * Builds the filter.
     * 
     * @param request the request
     * @param paramsRequest the params request
     * @return the wBA filter report bean
     * @throws SWBResourceException the sWB resource exception
     * @throws IncompleteFilterException the incomplete filter exception
     */
    private WBAFilterReportBean buildFilter(HttpServletRequest request, SWBParamRequest paramsRequest) throws SWBResourceException, IncompleteFilterException {
        WBAFilterReportBean filterReportBean = null;        
        String repositoryName = request.getParameter("wb_repository")==null ? paramsRequest.getWebPage().getWebSite().getId():request.getParameter("wb_repository");
        int groupDates;
        try {
            groupDates = request.getParameter("wb_rep_type")==null ? 0:Integer.parseInt(request.getParameter("wb_rep_type"));
        }catch(NumberFormatException e) {
            groupDates = 0;
        }

        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha1 = request.getParameter("wb_fecha1")==null ? sdf.format(cal.getTime()):request.getParameter("wb_fecha1");
        try {
            sdf.parse(fecha1);
        }catch(ParseException pe){
            fecha1 = sdf.format(cal.getTime());
        }
        String fecha11 = request.getParameter("wb_fecha11")==null ? sdf.format(cal.getTime()):request.getParameter("wb_fecha11");
        try {
            sdf.parse(fecha11);
        }catch(ParseException pe){
            fecha11 = sdf.format(cal.getTime());
        }
        String fecha12 = request.getParameter("wb_fecha12")==null ? sdf.format(cal.getTime()):request.getParameter("wb_fecha12");
        try {
            sdf.parse(fecha12);
        }catch(ParseException pe){
            fecha12 = sdf.format(cal.getTime());
        }

        try {
            filterReportBean = new WBAFilterReportBean(paramsRequest.getUser().getLanguage());
            filterReportBean.setSite(repositoryName);
            filterReportBean.setIdaux(S_REPORT_IDAUX);
            filterReportBean.setType(I_REPORT_TYPE);
            if(groupDates==0) { // radio button was 0. Select only one date
                filterReportBean.setGroupedDates(false);
                String[] numFecha = fecha1.split("-");                
                filterReportBean.setYearI(Integer.parseInt(numFecha[0]));
                filterReportBean.setMonthI(Integer.parseInt(numFecha[1]));
                filterReportBean.setDayI(Integer.parseInt(numFecha[2]));
                
            }else { // radio button was 1. Select between two dates
                filterReportBean.setGroupedDates(true);
                String[] numFecha = fecha11.split("-");                
                filterReportBean.setYearI(Integer.parseInt(numFecha[0]));
                filterReportBean.setMonthI(Integer.parseInt(numFecha[1]));
                filterReportBean.setDayI(Integer.parseInt(numFecha[2]));

                numFecha = fecha12.split("-");
                filterReportBean.setYearF(Integer.parseInt(numFecha[0]));
                filterReportBean.setMonthF(Integer.parseInt(numFecha[1]));
                filterReportBean.setDayF(Integer.parseInt(numFecha[2]));
            }
        }
        catch (Exception e){
            log.error("Error on method buildFilter() resource " + strRscType + " with id " + getResourceBase().getId(), e);
        }
        return filterReportBean;
    }
}

