package org.semanticwb.bsc.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.utils.EmailLog;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;


public class EmailLogResource extends GenericResource {

    /**
     * The log.
     */
    private static Logger log = SWBUtils.getLogger(EmailLogResource.class);

     /*
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if (!paramsRequest.WinState_MINIMIZED.equals(paramsRequest.getWindowState())) {
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
        if (paramsRequest.getMode().equalsIgnoreCase("fillgridmtr")) {
            doFillReport(request, response, paramsRequest);
        } else {
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
        HashMap hm_users = new HashMap();
        String rtype = "0";

        try {
            // Evaluates if there are users
            Iterator<User> itUser = User.ClassMgr.listUsers();
            while (itUser.hasNext()) {
                User usr = itUser.next();
                if (!usr.getUserRepository().getId().equals("uradm")) {
                    hm_users.put(usr.getURI(), usr.getFullName());
                }
            }
            // If there are users it continues
            if (hm_users.size() > 0) {
                String address = paramsRequest.getRenderUrl().toString();
                String userName = request.getParameter("wb_user");

                int groupDates;
                try {
                    groupDates = request.getParameter("wb_rep_type") == null ? 0 : Integer.parseInt(request.getParameter("wb_rep_type"));
                } catch (NumberFormatException e) {
                    groupDates = 0;
                }

                GregorianCalendar cal = new GregorianCalendar();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fecha1 = request.getParameter("wb_fecha1") == null ? sdf.format(cal.getTime()) : request.getParameter("wb_fecha1");
                try {
                    sdf.parse(fecha1);
                } catch (ParseException pe) {
                    fecha1 = sdf.format(cal.getTime());
                }
                String fecha11 = request.getParameter("wb_fecha11") == null ? sdf.format(cal.getTime()) : request.getParameter("wb_fecha11");
                try {
                    sdf.parse(fecha11);
                } catch (ParseException pe) {
                    fecha11 = sdf.format(cal.getTime());
                }
                String fecha12 = request.getParameter("wb_fecha12") == null ? sdf.format(cal.getTime()) : request.getParameter("wb_fecha12");
                try {
                    sdf.parse(fecha12);
                } catch (ParseException pe) {
                    fecha12 = sdf.format(cal.getTime());
                }

                SWBResourceURL url = paramsRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT);

                // javascript
                out.println("<script type=\"text/javascript\">");
                out.println("dojo.require(\"dijit.form.DateTextBox\");");

                out.println("dojo.require(\"dojox.grid.DataGrid\");");//--
                out.println("dojo.require(\"dojo.data.ItemFileReadStore\");");//--
                out.println("dojo.addOnLoad(doBlockade);");

                out.println("function fillGrid(grid, uri) {");
                out.println("   grid.store = new dojo.data.ItemFileReadStore({url: uri});");
                out.println("   grid._refresh();");
                out.println("}");

                out.println("var layout= null;");
                out.println("var jStrMaster = null;");
                out.println("var gridMaster = null;");
                out.println("var gridResources = null;");

                out.println("dojo.addOnLoad(function() {");
                out.println("   layout= [");
                out.println("      { field:\"repositorio\", width:\"100px\", name:\"Sitio\" },");
                out.println("      { field:\"de\", width:\"110px\", name:\"De\" },");
                out.println("      { field:\"para\", width:\"110px\", name:\"Para\" },");
                out.println("      { field:\"cc\", width:\"110px\", name:\"Cc\" },");
                out.println("      { field:\"otros\", width:\"110px\", name:\"Otros\" },");
                out.println("      { field:\"asunto\", width:\"110px\", name:\"Asunto\" },");
                out.println("      { field:\"fecha\", width:\"120px\", name:\"Fecha y Hora\" },");
                out.println("   ];");

                out.println("   gridMaster = new dojox.grid.DataGrid({");
                out.println("      id: \"gridMaster\",");
                out.println("      structure: layout,");
                out.println("      autoWidth: true,");
                out.println("      rowSelector: \"10px\",");
                out.println("      rowsPerPage: \"15\"");
                out.println("   }, \"gridMaster\");");
                out.println("   gridMaster.startup();");
                out.println("});");

                out.println(" function getTypeSelected(){");
                out.println("     var strType = \"0\";");
                out.println("     for(i=0;i<window.document.frmrep.wb_rep_type.length;i++){");
                out.println("       if(window.document.frmrep.wb_rep_type[i].checked==true){");
                out.println("           strType=window.document.frmrep.wb_rep_type[i].value;");
                out.println("       }");
                out.println("     }");
                out.println("     return strType;");
                out.println(" }");
                //--

                out.println("function getParams(accion) {");
                out.println(" var uri = dojo.byId('wb_user').value;");
                out.println(" var res = uri.replace(\"#\",\"-\");");
                out.println("   var params = '?';");
                out.println("   params = params + 'wb_user=' + res;");
                out.println("   params = params + '&wb_rtype=' + dojo.byId('wb_rtype').value;");
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
                out.println("   return params;");
                out.println("}");

                out.println("function doApply() {");
                out.println("   var grid = dijit.byId('gridMaster');");
                out.println("   var params = getParams(" + rtype + ");");
                out.println("   fillGrid(grid, '" + url.setMode("fillgridmtr") + "'+params);");
                out.println("}");

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
                out.println(paramsRequest.getLocaleString("lbl_title"));
                out.println("</fieldset>");

                out.println("<form id=\"frmrep\" name=\"frmrep\" method=\"post\" action=\"" + address + "\">");
                out.println("<fieldset>");
                out.println("<legend>" + paramsRequest.getLocaleString("lbl_legend") + "</legend>");
                out.println("<table border=\"0\" width=\"95%\" align=\"center\">");
                out.println("<tr><td width=\"183\"></td><td width=\"146\"></td><td width=\"157\"></td><td width=\"443\"></td></tr>");
                out.println("<tr>");
                out.println("<td>" + paramsRequest.getLocaleString("lbl_userFrom") + ":</td>");
                out.println("<td colspan=\"2\">");
                out.println("<select id=\"wb_user\" name=\"wb_user\" size=\"1\">");
                Iterator<String> itKeys = hm_users.keySet().iterator();
                while (itKeys.hasNext()) {
                    String key = itKeys.next();
                    out.println("<option value=\"" + key + "\"");
                    if (key.equalsIgnoreCase(userName)) {
                        out.println(" selected=\"selected\"");
                    }
                    out.println(">" + (String) hm_users.get(key) + "</option>");
                }
                out.println("</select>");
                out.println("</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");

                if (rtype.equals("0")) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<label>");
                    out.println("<input type=\"radio\" value=\"0\" name=\"wb_rep_type\" id=\"wb_rep_type_0\" onclick=\"javascript: doBlockade();\"");
                    if (groupDates == 0) {
                        out.println(" checked=\"checked\"");
                    }
                    out.println(" />");
                    out.println("&nbsp; Por día: ");
                    out.println("</label></td>");
                    out.println("<td colspan=\"2\">");
                    out.println("<input type=\"text\" name=\"wb_fecha1\" onblur=\"if(!this.value){this.focus();}\" id=\"wb_fecha1\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\"" + fecha1 + "\">");
                    out.println("</td>");
                    out.println("<td><input type=\"hidden\" id=\"wb_rtype\" name=\"wb_rtype\" value=\"0\" /></td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<label>");
                    out.println("<input type=\"radio\" value=\"1\" name=\"wb_rep_type\" id=\"wb_rep_type_1\" onclick=\"javascript: doBlockade();\"");
                    if (groupDates != 0) {
                        out.println(" checked=\"checked\"");
                    }
                    out.println(" />");
                    out.println("&nbsp; Por intervalo de &nbsp;fechas: ");
                    out.println("</label></td>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name=\"wb_fecha11\" onblur=\"if(!this.value){this.focus();}\" id=\"wb_fecha11\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\"" + fecha11 + "\">");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name=\"wb_fecha12\" onblur=\"if(!this.value){this.focus();}\" id=\"wb_fecha12\" dojoType=\"dijit.form.DateTextBox\" size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\"" + fecha12 + "\">");
                    out.println("</td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("</tr>");
                    out.println("</table></fieldset>");

                    out.println("<fieldset>");
                    out.println("<table border=\"0\" width=\"95%\">");
                    out.println("<tr>");
                    out.println(" <td colspan=\"4\">&nbsp;&nbsp;&nbsp;");
                    out.println("   <button dojoType=\"dijit.form.Button\" onclick=\"doApply()\">" + paramsRequest.getLocaleString("lbl_apply") + "</button>");
                    out.println(" </td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</fieldset>");
                    out.println("</form>");

                    out.println("<div id=\"ctnergrid\" style=\"height:350px; width:98%; margin: 1px; padding: 0px; border: 1px solid #DAE1FE;\">");
                    out.println("  <div id=\"gridMaster\" jsid=\"gridMaster\"></div>");
                    out.println("</div>");

                    out.println("</div>");

                }
                out.println("</div>");
            } else { // There are not repositories and displays a message
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
        } catch (Exception e) {
            log.error("Error on method DoView()" + e);
        }
        out.flush();
        out.close();
    }

    private void doFillReport(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/json;charset=iso-8859-1");
        Date date1 = new Date();
        Date date2 = new Date();
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        Calendar cal3 = new GregorianCalendar();
        User to = null;
        User cc = null;
        String from = "";
        String subject = "";
        String otherAccounts = "";
        JSONObject jobj = new JSONObject();
        JSONArray jarr = new JSONArray();
        
        try {
            jobj.put("label", "sect");
            jobj.put("items", jarr);
        } catch (JSONException jse) {
        }

        String uriUser = request.getParameter("wb_user") == null ? "1" : (String) request.getParameter("wb_user");
        String uri = uriUser.replace("-", "#");
        String radioDates = request.getParameter("wb_rep_type") == null ? "0" : (String) request.getParameter("wb_rep_type");
        SemanticObject sObj = SemanticObject.getSemanticObject(uri);
        SWBModel model = (SWBModel) sObj.getModel().getModelObject().createGenericInstance();
        SWBModel modelWS = model.getParentWebSite();
        User usr = User.ClassMgr.getUser(sObj.getId(), model);
        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDay = request.getParameter("wb_fecha1") == null ? sdf.format(cal.getTime()) : request.getParameter("wb_fecha1");
        String dateFrom = request.getParameter("wb_fecha11") == null ? sdf.format(cal.getTime()) : request.getParameter("wb_fecha11");
        String dateTo = request.getParameter("wb_fecha12") == null ? sdf.format(cal.getTime()) : request.getParameter("wb_fecha12");
        Iterator<EmailLog> itlogUser = EmailLog.ClassMgr.listEmailLogByFrom(usr, modelWS);
        try {
            if (radioDates.equals("0")) {
                date1 = sdf.parse(dateDay);
                date2 = sdf.parse(dateDay);
            } else if (radioDates.equals("1")) {
                date1 = sdf.parse(dateFrom);
                date2 = sdf.parse(dateTo);
            }
            cal1.setTime(date1);
            cal2.setTime(date2);
            String today = sdf.format(new Date());
            if (dateTo.equals(today)) {
                cal2.add(Calendar.DAY_OF_MONTH, +1);
            }
        } catch (ParseException ex) {
            log.error("Error on method doFillReport() ", ex);
        }

        while (itlogUser.hasNext()) {
            JSONObject obj = new JSONObject();
            EmailLog logEmail = itlogUser.next();
            Date dateLog = logEmail.getCreated();
            String strTo = "";
            String strCc = "";
            List mailTo = new ArrayList();
            List mailCc = new ArrayList();

            if (dateLog != null) {
                cal3.setTime(dateLog);
                if ((cal3.after(cal1) || cal3.equals(cal1)) && (cal3.before(cal2) || cal3.equals(cal2))) {
                    subject = logEmail.getSubject() == null ? "" : logEmail.getSubject();
                    otherAccounts = logEmail.getOtherAccounts() == null ? "" : logEmail.getOtherAccounts();
                    if (logEmail.getFrom() != null) {
                        from = logEmail.getFrom().getEmail();
                    }
                    Iterator<User> itTo = logEmail.listTos();
                        while (itTo.hasNext()) {
                            to = itTo.next();
                            mailTo.add(to.getEmail());
                        } 
                        strTo = java.util.Arrays.toString(mailTo.toArray());
                        Iterator<User> itCc = logEmail.listCcs();
                        while (itCc.hasNext()) {
                            cc = itCc.next();
                            mailCc.add(cc.getEmail());
                        } 
                        strCc = java.util.Arrays.toString(mailCc.toArray());
                    try {
                        obj.put("repositorio", modelWS.getId());
                        obj.put("de", from);
                        obj.put("para", strTo.replace("[", "").replace("]", ""));
                        obj.put("cc", strCc.replace("[", "").replace("]", ""));
                        obj.put("otros", otherAccounts);
                        obj.put("asunto", subject);
                        obj.put("fecha", dateLog);
                        jarr.put(obj);
                    } catch (JSONException jsone) {
                        log.error("Error on method doFillReport() ", jsone);
                    }
                }
            }
        }

        response.getOutputStream().println(jobj.toString());
    }
}
