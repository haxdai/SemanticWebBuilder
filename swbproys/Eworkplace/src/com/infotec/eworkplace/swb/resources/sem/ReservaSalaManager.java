package com.infotec.eworkplace.swb.resources.sem;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.*;

import com.infotec.eworkplace.swb.ReservacionSala;
import com.infotec.eworkplace.swb.Sala;
import java.net.URLDecoder;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBResourceURL;

public class ReservaSalaManager extends com.infotec.eworkplace.swb.resources.sem.base.ReservaSalaManagerBase {
    private static Logger log = SWBUtils.getLogger(ReservaSalaManager.class);
    public static final String Mode_ROLL = "roll";
    public static final String Mode_SALA = "sala";
    public static final String Roll_DATE = "date";
    public static final String Roll_MONTH = "month";
    public static final String Rel = "rel";
    public static final String Roll = "roll";
    public static final String Roll_RIGHT = "right";
    public static final String Roll_LEFT = "left";
    public static final String Set_DATE = "dom";
    
    public static final int Cleaning_Time = 29;
    
    public static final SimpleDateFormat dwid = new SimpleDateFormat("yyyyMMdd");
        
    public ReservaSalaManager()
    {
    }

   /**
   * Constructs a ReservaSalaManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaSalaManager
   */
    public ReservaSalaManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if(Mode_ROLL.equals(mode))
            doRoll(request, response, paramRequest);
        else if(Mode_SALA.equals(mode))
            doViewSala(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
//        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
            session.setAttribute("cur", current);
//        }else {
//            current = (GregorianCalendar)session.getAttribute("cur");
//        }
        
        final String dateId = dwid.format(current.getTime());
        
        if(userCanEdit(user)) {
            out.println("<div><a href=\"#\" title=\"\">Reservar una sala</a></div>");
            com.infotec.eworkplace.swb.Date date = com.infotec.eworkplace.swb.Date.ClassMgr.getDate(dateId, base.getWebSite());
            Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalaByFecha(date, base.getWebSite());
            if(reservations.hasNext()) {
                while(reservations.hasNext()) {
                    ReservacionSala rs = reservations.next();
                    if(rs!=null){
                        out.println("<p>rs="+rs+"</p>");
                    }
                }
            }else
                out.println("<p>no hay reservaciones</p>");
        }else {
            renderReservations(response, paramRequest, current, dateId, locale);
        }
    }
    
    public void doViewSala(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
        current = new GregorianCalendar(locale);
        session.setAttribute("cur", current);

        
        String uri = SWBUtils.XML.replaceXMLChars(request.getParameter("sl"));
        //String uri = request.getParameter("sl");
        uri = URLDecoder.decode(uri, "UTF-8");
        Sala sala = null;
        try {
            sala = (Sala)SemanticObject.createSemanticObject(uri).createGenericInstance();
        }catch(Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
        
        if(sala==null) {
            out.println("<p>no hay sala</p>");
            return;
        }

        out.println("<script type=\"text/javascript\">");
        out.println("dojo.require(\"dijit.Dialog\");");
        out.println("dojo.require(\"dojox.layout.ContentPane\");");
        out.println("dojo.require(\"dojo.parser\");");
  
        out.println("var hrs = [];");
        out.println("var f1=function(item,i,pfx) {");
        out.println("    var s = new String(pfx);");
        out.println("    return item.substring(0,2)==s.substring(0,2);");
        out.println("}");

        out.println("function validate() {");
        out.println("    if(hrs.length>0) {");
        out.println("        hrs.sort();");
        out.println("        if(dojo.every(hrs, f1)) {");
        out.println("            location.href='"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT)+"'+'?hrs='+hrs.join();");
        out.println("        }else {");
        out.println("            alert('no juegas');");
        out.println("            dojo.every(hrs, function(item){dojo.style(dojo.byId(item),'backgroundColor','#ffffff');return true;});");
        out.println("            hrs=[];");
        out.println("        }");
        out.println("    }else {");
        out.println("        alert('para jugar hay que  seleccionar');");
        out.println("    }");
        out.println("}");

        out.println("dojo.addOnLoad (");
        out.println("  function() {");
        out.println("    dojo.query(\".sltc\").connect(\"onclick\", function() {");
        out.println("                      if(dojo.hasClass(this, 'x'))");
        out.println("                          return;");
        out.println("                      if(dojo.colorFromString(dojo.style(dojo.attr(this, 'id'),'backgroundColor')).toHex()=='#1d75b9') {");//ffffff
        out.println("                          dojo.style(dojo.attr(this, 'id'),'backgroundColor','#ffffff');");//1d75b9
        out.println("                          hrs.push(dojo.attr(this, 'id'));");
        out.println("                      }else {");
        out.println("                          dojo.style(dojo.attr(this, 'id'),'backgroundColor','#1d75b9');");
        out.println("                          var i = dojo.indexOf(hrs, dojo.attr(this, 'id'));");
        out.println("                          if(i>=0)");
        out.println("                              hrs.splice(i,1);");
        out.println("                      }");
        out.println("                    }");
        out.println("    );");
        out.println("  }");
        out.println(");");
        out.println("</script>");
        
        
        
        
        
        
        
        Calendar cur =  Calendar.getInstance(locale);
        cur.setMinimalDaysInFirstWeek(1);
        cur.setFirstDayOfWeek(1);
        cur.setTime(current.getTime());
        final int month = cur.get(Calendar.MONTH);
        final int wom = cur.getActualMaximum(Calendar.WEEK_OF_MONTH);
        final int dow = cur.get(Calendar.DAY_OF_WEEK);
        cur.add(Calendar.DAY_OF_MONTH, 1-dow);
        int wk;
        try {
            wk = Integer.parseInt(request.getParameter("wk"));
        }catch(Exception e) {
            wk = cur.get(Calendar.WEEK_OF_MONTH);
        }
        out.println("<div>");
        out.println("<h3>Semana "+wk+"</h3>");
        out.println("<h3>"+sala.getDisplayTitle(locale.getLanguage())+"</h3>");
        if(wk>1)
            out.println("<a href=\"#\" title=\"\">anterior</a>");
        if(wk<wom)
            out.println("&nbsp;<a href=\"#\" title=\"\">siguiente</a>");
        out.println("<div>");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd", locale);
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println(" <td height=\"30\">Hora</td>");       
        final int fdcw = cur.get(Calendar.DAY_OF_MONTH);
        if(wk==1) {
            for(int k=1; k<=7; k++) {
                if(k>=dow && k<7)
                    out.println("<td height=\"30\">"+sdf.format(cur.getTime())+"</td>");
                else if(k>1 && k<7)
                    out.println("<td height=\"30\" class=\"deactive\">"+sdf.format(cur.getTime())+"</td>");
                cur.add(Calendar.DATE, 1);
            }
        }else {
            for(int k=1; k<=7; k++) {
                if(month<cur.get(Calendar.MONTH) && k<7)
                    out.println("<td height=\"30\" class=\"deactive\">"+sdf.format(cur.getTime())+"</td>");
                else if(k>1&&k<7)
                    out.println("<td height=\"30\">"+sdf.format(cur.getTime())+"</td>"); 
                cur.add(Calendar.DATE, 1);
            }
        }
        out.println("</tr>");
        
        sdf = new SimpleDateFormat("HH:mm");
        cur.set(Calendar.DAY_OF_MONTH, fdcw);
        cur.set(Calendar.HOUR_OF_DAY, 8);
        cur.set(Calendar.MINUTE, 0);
        cur.set(Calendar.SECOND, 0);
        for(int i=1; i<=14; i++) {
            out.println("<tr>");
            out.println(" <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(cur.getTime())+"</p></td>");
            if(wk==1) {
                for(int k=1; k<=7; k++) {
                    if(k>=dow && k<7) {
                        if(sala.isReservada(cur, cur.get(Calendar.HOUR_OF_DAY)*60))
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"sltc trCal1\">&nbsp;</td>");
                    }else if(k>1 && k<7) {
                        out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }
                    cur.add(Calendar.DATE, 1);
                }
            }else {
                 for(int k=1; k<=7; k++) {
                    if(month<cur.get(Calendar.MONTH) && k<7) {
                        out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }else if(k>1&&k<7) {
                        if(sala.isReservada(cur, cur.get(Calendar.HOUR_OF_DAY)*60))
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"sltc trCal1\">&nbsp;</td>");
                    }
                    cur.add(Calendar.DATE, 1);
                }
            }
            out.println("</tr>");
            cur.set(Calendar.DAY_OF_MONTH, fdcw);
            cur.add(Calendar.MINUTE, 30);
            cur.set(Calendar.SECOND, 0);
            out.println("<tr>");
            if(wk==1) {
                for(int k=1; k<=7; k++) {
                    if(k>=dow && k<7) {
                        if(sala.isReservada(cur, cur.get(Calendar.HOUR_OF_DAY)*60))
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"sltc trCal1\">&nbsp;</td>");
                    }else if(k>1 && k<7) {
                        out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }
                    cur.add(Calendar.DATE, 1);
                }
            }else {
                 for(int k=1; k<=7; k++) {
                    if(month<cur.get(Calendar.MONTH) && k<7) {
                        out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }else if(k>1&&k<7) {
                        if(sala.isReservada(cur, cur.get(Calendar.HOUR_OF_DAY)*60))
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println(" <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"sltc trCal1\">&nbsp;</td>");
                    }
                    cur.add(Calendar.DATE, 1);
                }
            }
            out.println("</tr>");
            cur.set(Calendar.DAY_OF_MONTH, fdcw);
            cur.add(Calendar.MINUTE, 30);
            cur.set(Calendar.SECOND, 0);
        }
        out.println("</table>");
    }
    
    private void renderReservations(HttpServletResponse response, SWBParamRequest paramRequest, GregorianCalendar current, final String dateId, Locale locale) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        PrintWriter out = response.getWriter();
        
out.println("<script type=\"text/javascript\">");
out.println("<!--");
out.println(" function showFormDialog(divId, bgcolor, opacity) {");
out.println("  createCoverDiv(divId, bgcolor, opacity);");
out.println("  var frmHolder = document.createElement('div');");
out.println("  var cwidth = 360;");
out.println("  var cheight = 650;");

out.println("  frmHolder.id='s_'+divId;");
out.println("  frmHolder.style.zIndex=1001;");
out.println("  frmHolder.style.position='absolute';");
out.println("  frmHolder.style.top='50%';");
out.println("  frmHolder.style.left='50%';");
out.println("  frmHolder.style.marginLeft=-cwidth/2+'px';");
out.println("  frmHolder.style.marginTop=-cheight/2+'px';");
out.println("  frmHolder.style.backgroundColor='#cccccc';");
out.println("  frmHolder.style.width=cwidth+'px';");
out.println("  frmHolder.style.height=cheight+'px';");
out.println("  var s = new String('');");
out.println("  s = s.concat('<form id=\"_rs_\" method=\"post\" action=\""+paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD)+"\">');");
//out.println("  s = s.concat('<input type=\"hidden\" name=\"hi\" value=\""+ihrs[0]+"\"/>');");
//out.println("  s = s.concat('<input type=\"hidden\" name=\"hf\" value=\""+(ihrs[ihrs.length-1]+59)+"\"/>');");
//out.println("  s = s.concat('<input type=\"hidden\" name=\"sl\" value=\""+sala.getURI()+"\"/>');");
out.println("  s = s.concat('<div id=\"mainPop\">');");
out.println("  s = s.concat(' <div id=\"popMiddle\">');");
out.println("  s = s.concat('  <p>Fecha de reservaci&oacute;n:<br />');");
out.println("  s = s.concat('   <span class=\"blueCal\">3 de Noviembre de 2011 10:00 AM </span><br />');");
out.println("  s = s.concat('   <span class=\"blueCal\">3 de Noviembre de 2011 12:00 PM</span>');");
out.println("  s = s.concat('  </p>');");
out.println("  s = s.concat('  <div id=\"usuarioCal\">');");
out.println("  s = s.concat('   <p><img src=\"images/placeholderCal.png\" width=\"80\" height=\"80\" alt=\"placeholder\" /></p>');");
out.println("  s = s.concat('   <p><span class=\"nombreCal\">Fulano de tal</span></p>');");
out.println("  s = s.concat('   <p>Consultor de arquitectura</p>');");
out.println("  s = s.concat('  </div>');");

out.println("  s = s.concat('  <p>');");
out.println("  s = s.concat('   <span class=\"blueCalTit\">Motivo de la reuni&oacute;n:</span><br />');");
out.println("  s = s.concat('   <span class=\"enfasisCal\">(140 caracteres m&aacute;ximo)</span><br />');");
out.println("  s = s.concat('   <label for=\"motive\"></label><textarea id=\"motive\" name=\"motive\" class=\"datosCal\"></textarea>');");
out.println("  s = s.concat('  </p>');");
out.println("  s = s.concat('  <div class=\"twinsCal\">');");
out.println("  s = s.concat('   <p><span class=\"blueCalTit\">Tipo de reuni&oacute;n</span>:</p>');");
out.println("  s = s.concat('   <ul>');");
out.println("  s = s.concat('    <li><label for=\"mtSng\">Interna <input type=\"radio\" name=\"typeMeet\" id=\"mtSng\" value=\"0\" onchange=\"collapse(\\'_tpcf_\\')\" checked=\"checked\" /></label></li>');");
out.println("  s = s.concat('    <li><label for=\"mtSpl\">Externa <input type=\"radio\" name=\"typeMeet\" id=\"mtSpl\" value=\"1\" onchange=\"expande(\\'_tpcf_\\')\" /></label></li>');");
out.println("  s = s.concat('   </ul>');");
out.println("  s = s.concat('  </div>');");
out.println("  s = s.concat('   <div id=\"_tpcf_\">');");
out.println("  s= s.concat('      <p>Cafeteria: </p>');");
out.println("  s = s.concat('     <ul>');");
out.println("  s = s.concat('      <li><label for=\"sngCf\">Sencilla <input type=\"radio\" name=\"typeCafe\" id=\"sngCf\" value=\"0\" checked=\"checked\" /></label></li>');");
out.println("  s = s.concat('      <li><label for=\"spcCf\">Especial <input type=\"radio\" name=\"typeCafe\" id=\"spcCf\" value=\"1\" /></label></li>');");
out.println("  s = s.concat('     </ul>');");
out.println("  s= s.concat('      <p>Cafe: </p>');");
out.println("  s = s.concat('     <ul>');");
out.println("  s = s.concat('      <li><label for=\"cfsrvct\">Si <input type=\"radio\" name=\"cfSrvc\" id=\"cfsrvct\" value=\"1\" checked=\"checked\" /></label></li>');");
out.println("  s = s.concat('      <li><label for=\"cfsrvcf\">No <input type=\"radio\" name=\"cfSrvc\" id=\"cfsrvcf\" value=\"0\" /></label></li>');");
out.println("  s = s.concat('     </ul>');");
out.println("  s= s.concat('      <p>Refrescos: </p>');");
out.println("  s = s.concat('     <ul>');");
out.println("  s = s.concat('      <li><label for=\"sdsrvct\">Si <input type=\"radio\" name=\"sdSrvc\" id=\"sdsrvct\" value=\"1\" checked=\"checked\" /></label></li>');");
out.println("  s = s.concat('      <li><label for=\"sdsrvcf\">No <input type=\"radio\" name=\"sdSrvc\" id=\"sdsrvcf\" value=\"0\" /></label></li>');");
out.println("  s = s.concat('     </ul>');");
out.println("  s= s.concat('      <p>Agua: </p>');");
out.println("  s = s.concat('     <ul>');");
out.println("  s = s.concat('      <li><label for=\"h2osrvct\">Si <input type=\"radio\" name=\"h2oSrvc\" id=\"h2osrvct\" value=\"1\" checked=\"checked\" /></label></li>');");
out.println("  s = s.concat('      <li><label for=\"h2osrvcf\">No <input type=\"radio\" name=\"h2oSrvc\" id=\"h2osrvcf\" value=\"0\" /></label></li>');");
out.println("  s = s.concat('     </ul>');");
out.println("  s= s.concat('      <p>Horario del servicio: </p>');");
out.println("  s = s.concat('     <ul>');");
out.println("  s = s.concat('      <li><label for=\"allsrvc\">Durante <input type=\"radio\" name=\"tmSrvc\" id=\"allsrvc\" value=\"1\" onchange=\"collapse(\\'_tmsrvc_\\')\" checked=\"checked\" /></label></li>');");
out.println("  s = s.concat('      <li><label for=\"brksrvc\">Receso <input type=\"radio\" name=\"tmSrvc\" id=\"brksrvc\" value=\"0\" onchange=\"expande(\\'_tmsrvc_\\')\" /></label></li>');");
out.println("  s = s.concat('     </ul>');");
out.println("  s = s.concat('   </div>');");
out.println("  s = s.concat('   <div id=\"_tmsrvc_\">');");
out.println("  s= s.concat('      <p><label for=\"tmSrvc\">Horario del servicio: <input type=\"text\" name=\"tmSrvc\" id=\"tmSrvc\" value=\"\" /></label></p>');");
out.println("  s = s.concat('   </div>');");
out.println("  s = s.concat('  <div class=\"twinsCal1\">');");
out.println("  s = s.concat('   <p><span class=\"blueCalTit\">N&uacute;mero de asistentes</span></p>');");
out.println("  s = s.concat('    <input type=\"text\" name=\"turnout\" id=\"turnout\" value=\"\" size=\"10\" maxlength=\"2\" />');");
out.println("  s = s.concat('  </div>');");
out.println("  s = s.concat('  <p>&nbsp;</p>');");
out.println("  s = s.concat('  <p class=\"blueCalTit\">Selecciona los servicios que solicitas </p>');");
out.println("  s = s.concat('  <ul>');");
out.println("  s = s.concat('   <li>');");
out.println("  s = s.concat('    <input type=\"checkbox\" name=\"equipment\" id=\"projector\" value=\"projector\" />');");
out.println("  s = s.concat('    <label for=\"interna2\"></label>');");
out.println("  s = s.concat('    Proyector');");
out.println("  s = s.concat('   </li>');");
out.println("  s = s.concat('   <li>');");
out.println("  s = s.concat('    <input type=\"checkbox\" name=\"equipment\" id=\"pcs\" value=\"pcs\" />');");
out.println("  s = s.concat('    Computadora');");
out.println("  s = s.concat('   </li>');");
out.println("  s = s.concat('  </ul>');");
out.println("  s = s.concat('  <p>');");
out.println("  s = s.concat('   <span class=\"blueCalTit\">Otros servicios necesarios</span><br />');");
out.println("  s = s.concat('   <label for=\"motivo\"></label><textarea id=\"services\" name=\"services\" class=\"datosCal\"></textarea>');");
out.println("  s = s.concat('  </p>');");
out.println("  s = s.concat('  <p><a href=\"javascript:removeCoverDiv(\\'');");
out.println("  s = s.concat(divId);");
out.println("  s = s.concat('\\')\" title=\"Cancelar\">Cancelar</a>');");
out.println("  s = s.concat('  <a href=\"javascript:dojo.byId(\\'_rs_\\').reset()\" title=\"Limpiar formulario\">Limpiar</a>');");
out.println("  s = s.concat('  <a href=\"#\" class=\"soliCal\">Solicitar</a></p>');");
out.println("  s = s.concat('  <p class=\"finePrint\">*Se te enviar&aacute; un e-mail con la confirmaci&oacute;n</p>');");
out.println("  s = s.concat(' </div>');");
out.println("  s = s.concat(' <p id=\"popBottom\"></p>');");
out.println("  s = s.concat('</div>');");
out.println("  s = s.concat('</form>');");
out.println("  frmHolder.innerHTML = s;");
out.println("  document.body.appendChild(frmHolder);");
out.println("  collapse('_tpcf_');");
out.println("  collapse('_tmsrvc_');");
out.println(" }");
out.println("-->");
out.println("</script>");
        
        
                
        out.println("<script type=\"text/javascript\">");
        out.println("dojo.require('dojo.parser');");
        out.println("dojo.require('dijit.Dialog');");
        out.println("dojo.require('dojox.layout.ContentPane');");
out.println("dojo.require('dojo.fx');");
out.println("dojo.require('dijit.dijit');");
        
        
out.println("function expande(domId) {");
out.println(" var anim1 = dojo.fx.wipeIn( {node:domId, duration:200 });");
out.println(" var anim2 = dojo.fadeIn({node:domId, duration:250});");
out.println(" dojo.fx.combine([anim1,anim2]).play();");
out.println("}");

out.println("function collapse(domId) {");
out.println(" var anim1 = dojo.fx.wipeOut( {node:domId, duration:200 });");
out.println(" var anim2 = dojo.fadeOut({node:domId, duration:250});");
out.println(" dojo.fx.combine([anim1, anim2]).play();");
out.println("}");
        
        out.println("var hrs = [];");
        out.println("var f1=function(item,i,pfx) {");
        out.println("    var s = new String(pfx);");
        out.println("    return item.substring(0,2)==s.substring(0,2);");
        out.println("}");

        out.println("function validate() {");
        out.println("    if(hrs.length>0) {");
        out.println("        hrs.sort();");
        out.println("        if(dojo.every(hrs, f1)) {");
        //out.println("            showDialog2('"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT).setCallMethod(SWBResourceURL.Call_DIRECT)+"'+'?hrs='+hrs.join(),'"+paramRequest.getLocaleString("usrmsg_doView_titleLbl")+"');");
        out.println("location.href='"+paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD) +"'+'?hrs='+hrs.join();");
        out.println("        }else {");
        out.println("            alert('no juegas');");
        out.println("            dojo.every(hrs, function(item){dojo.style(dojo.byId(item),'backgroundColor','#ffffff');return true;});");
        out.println("            hrs=[];");
        out.println("        }");
        out.println("    }else {");
        out.println("        alert('para jugar hay que  seleccionar');");
        out.println("    }");
        out.println("}");

        out.println("dojo.addOnLoad (");
        out.println("  function() {");
        out.println("    dojo.query(\".sltc\").connect(\"onclick\", function() {");
        out.println("                      if(dojo.hasClass(this, 'x'))");
        out.println("                          return;");
        out.println("                      if(dojo.colorFromString(dojo.style(dojo.attr(this, 'id'),'backgroundColor')).toHex()!='#1d75b9') {");
        out.println("                          dojo.style(dojo.attr(this, 'id'),'backgroundColor','#1d75b9');");
        out.println("                          hrs.push(dojo.attr(this, 'id'));");
        out.println("                      }else {");
        out.println("                          dojo.style(dojo.attr(this, 'id'),'backgroundColor','#ffffff');");
        out.println("                          var i = dojo.indexOf(hrs, dojo.attr(this, 'id'));");
        out.println("                          if(i>=0)");
        out.println("                              hrs.splice(i,1);");
        out.println("                      }");
        out.println("                    }");
        out.println("    );");
        out.println("  }");
        out.println(");");
        out.println("</script>");
        
        out.println("<div id=\"apartadoSalas\">");
        out.println("<div id=\"salasCal\">");
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(Mode_ROLL);
        url.setParameter(Rel, Roll_MONTH);
        url.setParameter(Roll, Roll_LEFT);
        out.println(" <a href=\"javascript:location.href='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a>");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", locale);
        out.println(" <span id=\"month\" class=\"salasMonthYear\">"+sdf.format(current.getTime()) +"</span>");
        url.setParameter(Roll, Roll_RIGHT);
        out.println(" <a href=\"javascript:location.href='"+url+"'\" class=\"salasAdelante\">adelante</a>");
        out.println(" <ul class=\"daysTop\">");
        out.println("  <li>D</li>");
        out.println("  <li>L</li>");
        out.println("  <li>M</li>");
        out.println("  <li>M</li>");
        out.println("  <li>J</li>");
        out.println("  <li>V</li>");
        out.println("  <li>S</li>");
        out.println(" </ul>");
        int daysInMonth = current.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        GregorianCalendar ci = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),1,0,0);
        int dayCounter = 1;
        int loopCounter = 1;
        int firstDay = ci.get(GregorianCalendar.DAY_OF_WEEK);
        out.println("<ul class=\"daysCal\">");
        sdf = new SimpleDateFormat("dd");
        url.setParameter(Rel, Set_DATE);
        for(int i=1; i<=6; i++) {
            for(int j=1; j<8; j++) {
                out.println("<li>");
                if( loopCounter>=firstDay && dayCounter<=daysInMonth ) {
                    url.setParameter(Roll, sdf.format(ci.getTime()));
                    out.print("<a href=\"javascript:location.href='"+url+"'\">");
                    out.println(sdf.format(ci.getTime())+"</a>");
                    
                    ci.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    dayCounter++;
                }
                loopCounter++;
                out.println("</li>");
            }
        }
        out.println(" </ul>");
        out.println("</div>");
        
        
        out.println("<div id=\"dayselectorCal\">");
        out.println(" <p class=\"disponibilidadSalas\">Disponibilidad de salas</p>");
        sdf = new SimpleDateFormat("yyyy,M,d", locale);
        url.setParameter(Rel, Roll_DATE);
        url.setParameter(Roll, Roll_LEFT);
        out.println(" <p><a href=\"javascript:location.href='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a></p>");
        sdf = new SimpleDateFormat("EEEE d 'de' MMMM", locale);
        out.println(" <p id=\"current\" class=\"dayAndMonth\">"+sdf.format(current.getTime())+"</p>");
        url.setParameter(Roll, Roll_RIGHT);
        out.println(" <p><a href=\"javascript:location.href='"+url+"'\" class=\"salasAdelante\">adelante</a></p>");
        out.println("</div>");
        
        
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        
if(!salas.isEmpty()) {
    out.println("<div id=\"roomselectorCal\">");
    out.println(" <p>Salas</p>");
    out.println(" <ul>");
    for(Sala sala:salas) {
        if(!sala.isActive())
            continue;
        out.println("<li><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\"ver sala\">");
        out.println(sala.getDisplayTitle(lang));
        out.println("</a></li>");
    }
    out.println(" </ul>");
    out.println("</div>");
}
        
        
        out.println("<br class=\"clear\"/>");
        out.println("<a href=\"javascript:showFormDialog('_cvr_','#000000',80)\" class=\"soliCal\">Solicitar</a>");
        
        sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        //isalas = salas.iterator();
        //while(isalas.hasNext()) {
        for(Sala sala:salas) {
            if(!sala.isActive())
                continue;
            out.println("  <td height=\"30\">"+sala.getDisplayTitle(lang)+"</td>");
        }
        out.println("</tr>");
        
        final com.infotec.eworkplace.swb.Date date = com.infotec.eworkplace.swb.Date.ClassMgr.getDate(dateId, base.getWebSite());
        
        GregorianCalendar hourOfDay = new GregorianCalendar(2011,0,1,8,0);//auxiliar
        for(int i=480; i<=1260; i+=30) {
            out.println("<tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(hourOfDay.getTime())+"</p></td>");
            for(Sala sala:salas) {
                if(sala.isReservada(date, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println("</tr>");
            out.println("<tr>");
            i+=30;
            for(Sala sala:salas) {
                if(sala.isReservada(date, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println("</tr>");
            hourOfDay.add(Calendar.HOUR_OF_DAY, 1);
        }
        out.println("</table>");
        //out.println("<p><input type=\"button\" value=\"reservar\" onclick=\"showFormDialog('_cvr_','#000000',80)\" /></p>");
        out.println("<a href=\"javascript:showFormDialog('_cvr_','#000000',80)\" class=\"soliCal\">Solicitar</a>");
        /*out.println("<p><a href=\""+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_HELP) +"\">borrar reservaciones</a></p>");*/
        out.println("</div>");
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        WebSite model = base.getWebSite();
        String action = response.getAction();
System.out.println("\n\n * processAction ******");
System.out.println("action="+action);

        if(SWBResourceURL.Action_ADD.equals(action)) {
System.out.println("add.........");

            String[] hrs = (request.getParameter("hrs")==null||request.getParameter("hrs").isEmpty())?null:request.getParameter("hrs").split(",");
            if(hrs==null || hrs.length==0) {
                return;
            }
            for(int i=0; i<hrs.length-1; i++) {
                if(!hrs[i].startsWith(hrs[i+1].substring(0, hrs[i+1].lastIndexOf("_")))) {
System.out.println("error 1");
                    return;
                }
            }
            int[] ihrs = new int[hrs.length];
            for(int i=0; i<hrs.length; i++) {
                try {
                    ihrs[i] = Integer.parseInt(hrs[i].substring(hrs[i].lastIndexOf("_")+1));
                }catch(NumberFormatException nfe) {
System.out.println("error 2");
                    return;
                }
            }
            Arrays.sort(ihrs);
            if(ihrs[0]==0 || ihrs[ihrs.length-1]==0) {
System.out.println("error 3");
                return;
            }
            final String id = hrs[0].substring(0, hrs[0].lastIndexOf("_"));
            final Sala sala = Sala.ClassMgr.getSala(id, base.getWebSite());
            if(sala==null) {
System.out.println("error 4");
                return;
            }
            try {
                HttpSession session = request.getSession(true);
                GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
                GregorianCalendar cur = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
                if(sala.isReservada(cur, ihrs[0], ihrs[ihrs.length-1])) {
System.out.println("error 5");
                    return;
                }
            }catch(Exception nfe) {
                log.error(nfe);
System.out.println("error 6");
nfe.printStackTrace(System.out);
                return;
            }

            
            User user = response.getUser();
            
            String motive = SWBUtils.XML.replaceXMLChars(request.getParameter("motive"));
            String typeMeet = request.getParameter("typeMeet");
            String turnout = SWBUtils.XML.replaceXMLChars(request.getParameter("turnout"));
            String[] equipment = request.getParameterValues("equipment");
            String services = SWBUtils.XML.replaceXMLChars(request.getParameter("services")); 
            String typeCafe = SWBUtils.XML.replaceXMLChars(request.getParameter("typeCafe"));
            String hoursService = SWBUtils.XML.replaceXMLChars(request.getParameter("hoursService"));

            /*final String uri = SWBUtils.XML.replaceXMLChars(request.getParameter("sl"));
            Sala sala = null;
            try {
                sala = (Sala)SemanticObject.createSemanticObject(uri).createGenericInstance();
            }catch(Exception e) {
                log.error(e);
                e.printStackTrace(System.out);
            }*/
                
            int hi=0, hf=0;
            try {
                hi = Integer.parseInt(request.getParameter("hi"));
                hf = Integer.parseInt(request.getParameter("hf"));
            }catch(NumberFormatException nfe) {
                log.error(nfe);
                nfe.printStackTrace(System.out);
                response.setMode(SWBResourceURL.Mode_EDIT);
                return;
            }
            
            HttpSession session = request.getSession(true);
            GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
            GregorianCalendar cur = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
            
            
            String dateId = dwid.format(current.getTime());
            com.infotec.eworkplace.swb.Date date = com.infotec.eworkplace.swb.Date.ClassMgr.getDate(dateId, model);
            if(date==null)
                date = com.infotec.eworkplace.swb.Date.ClassMgr.createDate(dateId, model);
            date.setDate(cur.getTime());
            
            
            /*if(sala!=null && date!=null && sala.isValid() && !sala.isReservada(date, hi, hf)) {
                ReservacionSala reservation = ReservacionSala.ClassMgr.createReservacionSala(model);
                //ReservacionSala reservation = getProcessReservation();
                sala.setReservada(true);
                reservation.setSala(sala);
                reservation.setResponsable(user);

                reservation.setFecha(date);
                reservation.setDe(hi);
                reservation.setA(hf);
            }*/
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        
        String[] hrs = (request.getParameter("hrs")==null||request.getParameter("hrs").isEmpty())?null:request.getParameter("hrs").split(",");
        if(hrs==null || hrs.length==0) {
            out.println("<p>1 desde el server las cosas no funcionan bien</p>");
            out.flush();
            out.close();
            return;
        }
        
        for(int i=0; i<hrs.length-1; i++) {
            if(!hrs[i].startsWith(hrs[i+1].substring(0, hrs[i+1].lastIndexOf("_")))) {
                out.println("<p>2 desde el server las cosas no funcionan bien</p>");
                out.flush();
                out.close();
                return;
            }
        }
        
        int[] ihrs = new int[hrs.length];
        for(int i=0; i<hrs.length; i++) {
            try {
                ihrs[i] = Integer.parseInt(hrs[i].substring(hrs[i].lastIndexOf("_")+1));
            }catch(NumberFormatException nfe) {
                out.println("<p>1.9 desde el server las cosas no funcionan bien</p>");
                out.flush();
                out.close();
                return;
            }
        }
        
        Arrays.sort(ihrs);
//        for(int i=0; i<ihrs.length-1; i++) {           
//            if(ihrs[i]+30 != ihrs[i+1]) {
//                out.println("<p>2.1 no se puede determinar el horario de reservaci&oacute;n</p>");
//                out.flush();
//                out.close();
//                return;
//            }
//        }
        
        if(ihrs[0]==0 || ihrs[ihrs.length-1]==0) {
            out.println("<p>3 no existe horario</p>");
            out.flush();
            out.close();
            return;
        }

        final String id = hrs[0].substring(0, hrs[0].lastIndexOf("_"));
        final Sala sala = Sala.ClassMgr.getSala(id, base.getWebSite());
        if(sala==null) {
            out.println("<p>4 no existe esa sala</p>");
            out.flush();
            out.close();
            return;
        }
        
        try {
            HttpSession session = request.getSession(true);
            GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
            GregorianCalendar cur = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
            if(sala.isReservada(cur, ihrs[0], ihrs[ihrs.length-1])) {
                out.println("<p>5 la sala esta ocupada</p>");
                out.flush();
                out.close();
                return;
            }
        }catch(Exception nfe) {
            log.error(nfe);
            out.println("<p>6 no hay fecha para comparar reservacioens</p>");
            out.flush();
            out.close();
            return;
        }
        
        out.println("<form id=\"rs\" method=\"post\" action=\""+paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD)+"\">");
        out.println("<input type=\"hidden\" name=\"hi\" value=\""+ihrs[0]+"\"/>");
        out.println("<input type=\"hidden\" name=\"hf\" value=\""+(ihrs[ihrs.length-1]+59)+"\"/>");
        out.println("<input type=\"hidden\" name=\"sl\" value=\""+sala.getURI()+"\"/>");
        out.println("<div id=\"mainPop\">");
        out.println("  <div id=\"popMiddle\">");
        out.println("    <p>Fecha de reservaci&oacute;n:<br />");
        out.println("      <span class=\"blueCal\">3 de Noviembre de 2011 10:00 AM </span><br />");
        out.println("      <span class=\"blueCal\">3 de Noviembre de 2011 12:00 PM</span>");
        out.println("    </p>");
        out.println("    <div id=\"usuarioCal\">");
        out.println("      <p><img src=\"images/placeholderCal.png\" width=\"80\" height=\"80\" alt=\"placeholder\" /></p>");
        out.println("      <p><span class=\"nombreCal\">Fulano de tal</span></p>");
        out.println("      <p>Consultor de arquitectura</p>");
        out.println("    </div>");

        out.println("    <p>");
        out.println("      <span class=\"blueCalTit\">Motivo de la reuni&oacute;n:</span><br />");
        out.println("      <span class=\"enfasisCal\">(140 caracteres m&aacute;ximo)</span><br />");
        out.println("      <label for=\"motive\"></label><textarea id=\"motive\" name=\"motive\" class=\"datosCal\"></textarea>");
        out.println("    </p>");

        out.println("    <div class=\"twinsCal\">");
        out.println("      <p><span class=\"blueCalTit\">Tipo de reuni&oacute;n</span>:</p>");
        out.println("      <ul>");
        out.println("        <li>");
        out.println("          <input type=\"radio\" name=\"typeMeet\" id=\"interna\" value=\"interna\" />");
        out.println("          <label for=\"interna\"></label>");
        out.println("          Interna");
        out.println("        </li>");
        out.println("        <li>");
        out.println("          <input type=\"radio\" name=\"typeMeet\" id=\"externa\" value=\"externa\" />");
        out.println("          <label for=\"externa\"></label>");
        out.println("          Externa");
        out.println("        </li>");
        out.println("      </ul>");
        out.println("    </div>");

        out.println("    <div class=\"twinsCal1\">");
        out.println("      <p><span class=\"blueCalTit\">N&uacute;mero de asistentes</span></p>");
        out.println("      <input type=\"text\" name=\"turnout\" id=\"turnout\" value=\"\" size=\"10\" maxlength=\"2\" />");
        out.println("    </div>");

        out.println("    <p>&nbsp;</p>");
        out.println("    <p class=\"blueCalTit\">Selecciona los servicios que solicitas </p>");
        out.println("    <ul>");
        out.println("      <li>");
        out.println("        <input type=\"checkbox\" name=\"equipment\" id=\"projector\" value=\"projector\" />");
        out.println("        <label for=\"interna2\"></label>");
        out.println("        Proyector");
        out.println("      </li>");
        out.println("      <li>");
        out.println("        <input type=\"checkbox\" name=\"equipment\" id=\"pcs\" value=\"pcs\" />");
        out.println("        Computadora");
        out.println("      </li>");
        out.println("    </ul>");

        out.println("    <p>");
        out.println("      <span class=\"blueCalTit\">Otros servicios necesarios</span><br />");
        out.println("      <label for=\"motivo\"></label><textarea id=\"services\" name=\"services\" class=\"datosCal\"></textarea>");
        out.println("    </p>");
        
        out.println("    <p><input type=\"submit\" class=\"soliCal\">Solicitar</a></p>");
        out.println("    <p class=\"finePrint\">*Se te enviar&aacute; un e-mail con la confirmaci&oacute;n</p>");
        out.println("  </div>");
        out.println("  <p id=\"popBottom\"></p>");
        out.println("</div>");
        out.println("</form>");
        
        
//out.println("<script type=\"text/javascript\">");
//out.println("<!--");
//out.println(" function showFormDialog(divId, bgcolor, opacity) {");
//out.println("  createCoverDiv(divId, bgcolor, opacity);");
//out.println("  var frmHolder = document.createElement('div');");
//out.println("  var cwidth = 360;");
//out.println("  var cheight = 550;");
//
//out.println("  frmHolder.id='s_'+divId;");
//out.println("  frmHolder.style.zIndex=1001;");
//out.println("  frmHolder.style.position='absolute';");
//out.println("  frmHolder.style.top='50%';");
//out.println("  frmHolder.style.left='50%';");
//out.println("  frmHolder.style.marginLeft=-cwidth/2+'px';");
//out.println("  frmHolder.style.marginTop=-cheight/2+'px';");
//out.println("  frmHolder.style.width=cwidth+'px';");
//out.println("  frmHolder.style.height=cheight+'px';");
//out.println("  var s = new String('');");
//out.println("  s = s.concat('<form id=\"rs\" method=\"post\" action=\""+paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD)+"\">');");
//out.println("  s = s.concat('<input type=\"hidden\" name=\"hi\" value=\""+ihrs[0]+"\"/>');");
//out.println("  s = s.concat('<input type=\"hidden\" name=\"hf\" value=\""+(ihrs[ihrs.length-1]+59)+"\"/>');");
//out.println("  s = s.concat('<input type=\"hidden\" name=\"sl\" value=\""+sala.getURI()+"\"/>');");
//out.println("  s = s.concat('<div id=\"mainPop\">');");
//out.println("  s = s.concat(' <div id=\"popMiddle\">');");
//out.println("  s = s.concat('  <p>Fecha de reservaci&oacute;n:<br />');");
//out.println("  s = s.concat('   <span class=\"blueCal\">3 de Noviembre de 2011 10:00 AM </span><br />');");
//out.println("  s = s.concat('   <span class=\"blueCal\">3 de Noviembre de 2011 12:00 PM</span>');");
//out.println("  s = s.concat('  </p>');");
//out.println("  s = s.concat('  <div id=\"usuarioCal\">');");
//out.println("  s = s.concat('   <p><img src=\"images/placeholderCal.png\" width=\"80\" height=\"80\" alt=\"placeholder\" /></p>');");
//out.println("  s = s.concat('   <p><span class=\"nombreCal\">Fulano de tal</span></p>');");
//out.println("  s = s.concat('   <p>Consultor de arquitectura</p>');");
//out.println("  s = s.concat('  </div>');");
//
//out.println("  s = s.concat('  <p>');");
//out.println("  s = s.concat('   <span class=\"blueCalTit\">Motivo de la reuni&oacute;n:</span><br />');");
//out.println("  s = s.concat('   <span class=\"enfasisCal\">(140 caracteres m&aacute;ximo)</span><br />');");
//out.println("  s = s.concat('   <label for=\"motive\"></label><textarea id=\"motive\" name=\"motive\" class=\"datosCal\"></textarea>');");
//out.println("  s = s.concat('  </p>');");
//out.println("  s = s.concat('  <div class=\"twinsCal\">');");
//out.println("  s = s.concat('   <p><span class=\"blueCalTit\">Tipo de reuni&oacute;n</span>:</p>');");
//out.println("  s = s.concat('   <ul>');");
//out.println("  s = s.concat('    <li>');");
//out.println("  s = s.concat('     <input type=\"radio\" name=\"typeMeet\" id=\"interna\" value=\"interna\" />');");
//out.println("  s = s.concat('      <label for=\"interna\"></label>');");
//out.println("  s = s.concat('      Interna');");
//out.println("  s = s.concat('    </li>');");
//out.println("  s = s.concat('    <li>');");
//out.println("  s = s.concat('     <input type=\"radio\" name=\"typeMeet\" id=\"externa\" value=\"externa\" />');");
//out.println("  s = s.concat('      <label for=\"externa\"></label>');");
//out.println("  s = s.concat('      Externa');");
//out.println("  s = s.concat('    </li>');");
//out.println("  s = s.concat('   </ul>');");
//out.println("  s = s.concat('  </div>');");
//out.println("  s = s.concat('  <div class=\"twinsCal1\">');");
//out.println("  s = s.concat('   <p><span class=\"blueCalTit\">N&uacute;mero de asistentes</span></p>');");
//out.println("  s = s.concat('    <input type=\"text\" name=\"turnout\" id=\"turnout\" value=\"\" size=\"10\" maxlength=\"2\" />');");
//out.println("  s = s.concat('  </div>');");
//out.println("  s = s.concat('  <p>&nbsp;</p>');");
//out.println("  s = s.concat('  <p class=\"blueCalTit\">Selecciona los servicios que solicitas </p>');");
//out.println("  s = s.concat('  <ul>');");
//out.println("  s = s.concat('   <li>');");
//out.println("  s = s.concat('    <input type=\"checkbox\" name=\"equipment\" id=\"projector\" value=\"projector\" />');");
//out.println("  s = s.concat('    <label for=\"interna2\"></label>');");
//out.println("  s = s.concat('    Proyector');");
//out.println("  s = s.concat('   </li>');");
//out.println("  s = s.concat('   <li>');");
//out.println("  s = s.concat('    <input type=\"checkbox\" name=\"equipment\" id=\"pcs\" value=\"pcs\" />');");
//out.println("  s = s.concat('    Computadora');");
//out.println("  s = s.concat('   </li>');");
//out.println("  s = s.concat('  </ul>');");
//out.println("  s = s.concat('  <p>');");
//out.println("  s = s.concat('   <span class=\"blueCalTit\">Otros servicios necesarios</span><br />');");
//out.println("  s = s.concat('   <label for=\"motivo\"></label><textarea id=\"services\" name=\"services\" class=\"datosCal\"></textarea>');");
//out.println("  s = s.concat('  </p>');");
//out.println("  s = s.concat('  <p><input type=\"submit\" class=\"soliCal\">Solicitar</a></p>');");
//out.println("  s = s.concat('  <p class=\"finePrint\">*Se te enviar&aacute; un e-mail con la confirmaci&oacute;n</p>');");
//out.println("  s = s.concat(' </div>');");
//out.println("  s = s.concat(' <p id=\"popBottom\"></p>');");
//out.println("  s = s.concat('</div>');");
//out.println("  s = s.concat('</form>');");
//out.println("  frmHolder.innerHTML = s;");    
//out.println("  document.body.appendChild(frmHolder);");        
//out.println(" }");
//out.println("-->");
//out.println("</script>");
    }
    
    public void doRoll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        PrintWriter out = response.getWriter();
        
        out.println("<script type=\"text/javascript\">");
        out.println("dojo.require(\"dijit.Dialog\");");
        out.println("dojo.require(\"dojox.layout.ContentPane\");");
        out.println("dojo.require(\"dojo.parser\");");
  
        out.println("var hrs = [];");
        out.println("var f1=function(item,i,pfx) {");
        out.println("    var s = new String(pfx);");
        out.println("    return item.substring(0,2)==s.substring(0,2);");
        out.println("}");

        out.println("function validate() {");
        out.println("    if(hrs.length>0) {");
        out.println("        hrs.sort();");
        out.println("        if(dojo.every(hrs, f1)) {");
        //out.println("            showDialog2('"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT).setCallMethod(SWBResourceURL.Call_DIRECT)+"'+'?hrs='+hrs.join(), '"+paramRequest.getLocaleString("usrmsg_doView_titleLbl")+"');");
        out.println("location.href='"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT)+"'+'?hrs='+hrs.join();");
        out.println("        }else {");
        out.println("            alert('no juegas');");
        out.println("            dojo.every(hrs, function(item){dojo.style(dojo.byId(item),'backgroundColor','#ffffff');return true;});");
        out.println("            hrs=[];");
        out.println("        }");
        out.println("    }else {");
        out.println("        alert('para jugar hay que  seleccionar');");
        out.println("    }");
        out.println("}");

        out.println("dojo.addOnLoad (");
        out.println("  function() {");
        out.println("    dojo.query(\".sltc\").connect(\"onclick\", function() {");
        out.println("                      if(dojo.hasClass(this, 'x'))");
        out.println("                          return;");
        out.println("                      if(dojo.colorFromString(dojo.style(dojo.attr(this, 'id'),'backgroundColor')).toHex()=='#ffffff') {");
        out.println("                          dojo.style(dojo.attr(this, 'id'),'backgroundColor','#1d75b9');");
        out.println("                          hrs.push(dojo.attr(this, 'id'));");
        out.println("                      }else {");
        out.println("                          dojo.style(dojo.attr(this, 'id'),'backgroundColor','#ffffff');");
        out.println("                          var i = dojo.indexOf(hrs, dojo.attr(this, 'id'));");
        out.println("                          if(i>=0)");
        out.println("                              hrs.splice(i,1);");
        out.println("                      }");
        out.println("                    }");
        out.println("    );");
        out.println("  }");
        out.println(");");
        out.println("</script>");
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
            session.setAttribute("cur", current);
        }else {
            current = (GregorianCalendar)session.getAttribute("cur") ;
        }     
        if(Roll_MONTH.equals(request.getParameter(Rel))) {
            String roll = request.getParameter(Roll);
            if(Roll_LEFT.equals(roll))
                current.add(Calendar.MONTH, -1);
            else
                current.add(Calendar.MONTH, 1);
        }else if(Roll_DATE.equals(request.getParameter(Rel))) {
            String roll = request.getParameter(Roll);
            if(Roll_LEFT.equals(roll))
                current.add(Calendar.DAY_OF_MONTH, -1);
            else
                current.add(Calendar.DAY_OF_MONTH, 1);
        }else if(Set_DATE.equals(request.getParameter(Rel))) {
            try {
                int date = Integer.parseInt(request.getParameter(Roll));
                current.set(Calendar.DATE, date);
            }catch(NumberFormatException nfe) {
            }
        } 
        final String dateId = dwid.format(current.getTime());
        
        out.println("<div id=\"apartadoSalas\">");
        out.println("<div id=\"salasCal\">");
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(Mode_ROLL);
        url.setParameter(Rel, Roll_MONTH);
        url.setParameter(Roll, Roll_LEFT);
        out.println(" <a href=\"javascript:location.href='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a>");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", locale);
        out.println(" <span id=\"month\" class=\"salasMonthYear\">"+sdf.format(current.getTime()) +"</span>");
        url.setParameter(Roll, Roll_RIGHT);
        out.println(" <a href=\"javascript:location.href='"+url+"'\" class=\"salasAdelante\">adelante</a>");    
        out.println("<ul class=\"daysTop\">");
        out.println("  <li>D</li>");
        out.println("  <li>L</li>");
        out.println("  <li>M</li>");
        out.println("  <li>M</li>");
        out.println("  <li>J</li>");
        out.println("  <li>V</li>");
        out.println("  <li>S</li>");
        out.println("</ul>");
        
        
        int daysInMonth = current.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        GregorianCalendar ci = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),1,0,0);
        int dayCounter = 1;
        int loopCounter = 1;
        int firstDay = ci.get(GregorianCalendar.DAY_OF_WEEK);
        out.println("<ul class=\"daysCal\">");
        sdf = new SimpleDateFormat("dd");
        url.setParameter(Rel, Set_DATE);
        for(int i=1; i<=6; i++) {
            for(int j=1; j<8; j++) {
                out.println("<li>");
                if( loopCounter>=firstDay && dayCounter<=daysInMonth ) {
                    url.setParameter(Roll, sdf.format(ci.getTime()));
                    out.println("<a href=\"javascript:location.href='"+url+"'\">"+sdf.format(ci.getTime())+"</a>");
                    ci.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    dayCounter++;
                }
                loopCounter++;
                out.println("</li>");
            }
        }
        out.println(" </ul>");
        out.println("</div>");//<div id="salasCal">
        
        out.println("<div id=\"dayselectorCal\">");
        out.println(" <p class=\"disponibilidadSalas\">Disponibilidad de salas</p>");
        url.setParameter(Rel, Roll_DATE);
        url.setParameter(Roll, Roll_LEFT);
        out.println(" <p><a href=\"javascript:location.href='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a></p>");
        sdf = new SimpleDateFormat("EEEE d 'de' MMMM", locale);
        out.println(" <p id=\"current\" class=\"dayAndMonth\">"+sdf.format(current.getTime())+"</p>");
        url.setParameter(Roll, Roll_RIGHT);
        out.println(" <p><a href=\"javascript:location.href='"+url+"'\" class=\"salasAdelante\">adelante</a></p>");
        out.println("</div>");
        
Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
isalas = SWBComparator.sortByDisplayName(isalas, lang);
List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        
        
if(!salas.isEmpty()) {
    out.println("<div id=\"roomselectorCal\">");
    out.println(" <p>Salas</p>");
    out.println(" <ul>");
    for(Sala sala:salas) {
        if(!sala.isActive())
            continue;
        out.println("<li><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\"ver sala\">");
        out.println(sala.getDisplayTitle(lang));
        out.println("</a></li>");
    }
    out.println(" </ul>");
    out.println("</div>");
}        
        
        out.println("<br class=\"clear\"/>");
        
        sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        //List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
//        isalas = salas.iterator();
//        while(isalas.hasNext()) {
        for(Sala sala:salas) {
            if(!sala.isActive())
                continue;
            out.println("  <td height=\"30\">"+sala.getDisplayTitle(lang) +"</td>");
        }
        out.println("</tr>");
        
        final com.infotec.eworkplace.swb.Date date = com.infotec.eworkplace.swb.Date.ClassMgr.getDate(dateId, base.getWebSite());
        GregorianCalendar gc = new GregorianCalendar(2011,0,1,8,0);//auxiliar
        for(int i=480; i<=1260; i+=30) {
            out.println("<tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(gc.getTime())+"</p></td>");
            for(Sala sala:salas) {
                if(sala.isReservada(date, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println("</tr>");
            out.println("<tr>");
            i+=30;
            for(Sala sala:salas) {
                if(sala.isReservada(date, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println("</tr>");
            gc.add(Calendar.HOUR_OF_DAY, 1);
        }
        out.println("</table>");
        out.println("<p><input type=\"button\" value=\"reservar\" onclick=\"validate()\" /></p>");
        out.println("<p><a href=\""+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_HELP) +"\">borrar reservaciones</a></p>");
        out.println("</div>");
    }
    
    @Override
    public void doHelp(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalas(getResourceBase().getWebSite());
        while(reservations.hasNext()) { 
            ReservacionSala rs = reservations.next();
            if(rs!=null){
                System.out.println("rs="+rs);   
                rs.getSala().setReservada(false);
                if(rs.getFecha()!=null)
                    rs.getFecha().remove();
                rs.remove();
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("location.href='"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW)+"'");
        out.println("</script>");
    }
    
    private boolean userCanEdit(User user) {
        boolean userCanEdit = false;
        String editAccessURI = getResourceBase().getAttribute("editAccess","").trim();
        try {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = null;
            gobj = ont.getGenericObject(editAccessURI);
            if(gobj instanceof UserGroup) {
                UserGroup ugrp = (UserGroup)gobj;
                if(user.hasUserGroup(ugrp)) {
                    userCanEdit = true;
                }
            }else if(gobj instanceof Role) {
                Role urole = (Role)gobj;
                if(user.hasRole(urole)) {
                    userCanEdit = true;
                }
            }
        }catch(Exception e) {
            userCanEdit = false;
            e.printStackTrace(System.out);
        }
        return userCanEdit;
    }
}