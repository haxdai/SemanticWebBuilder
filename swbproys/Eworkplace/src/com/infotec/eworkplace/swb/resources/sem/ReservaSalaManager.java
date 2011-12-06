package com.infotec.eworkplace.swb.resources.sem;

import com.infotec.eworkplace.swb.Sala;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.*;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBResourceURL;

public class ReservaSalaManager extends com.infotec.eworkplace.swb.resources.sem.base.ReservaSalaManagerBase {

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

//    @Override
//    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
//        final String mode = paramRequest.getMode();
//        if("sf".equals(mode))
//            
//        else
//            super.processRequest(request, response, paramRequest);
//    }


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        
        PrintWriter out = response.getWriter();
        
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        GregorianCalendar gc = new GregorianCalendar(2011,0,1,8,0);
        
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
//        out.println("    if(hrs.length>0) {");
//        out.println("        hrs.sort();");
//        out.println("        if(dojo.every(hrs, f1)) {");
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT).setCallMethod(SWBResourceURL.Call_DIRECT);
        out.println("            showDialog2('"+url+"'+'?hrs='+hrs.join(), '"+paramRequest.getLocaleString("title")+"');");
//        out.println("        }else {");
//        out.println("            alert('no juegas');");
//        out.println("            dojo.every(hrs, function(item){dojo.style(dojo.byId(item),'backgroundColor','#ffffff');return true;});");
//        out.println("            hrs=[];");
//        out.println("        }");
//        out.println("    }else {");
//        out.println("        alert('para jugar hay que  seleccionar');");
//        out.println("    }");
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
        
        
        out.println("<div dojoType=\"dijit.Dialog\" class=\"soria\" style=\"display:none;\" id=\"swbDialog\" " +
                "title=\"Agregar\" onFocus=\"hideApplet(true);\" onBlur=\"if(!this.open)hideApplet(false);\" >\n" +
                "  <div dojoType=\"dojox.layout.ContentPane\" class=\"soria\" id=\"swbDialogImp\" executeScripts=\"true\">\n" +
                "    Cargando...\n" +
                "  </div>\n" +
                "</div>\n");
        

        out.println("<div id=\"dayselectorCal\">");
        out.println(" <p class=\"disponibilidadSalas\">Disponibilidad de salas</p>");
        out.println(" <p><a href=\"#\" class=\"salasAtras\">atr&aacute;s</a></p>");
        out.println(" <p class=\"dayAndMonth\">Domingo 3 de Noviembre</p>");
        out.println(" <p><a href=\"#\" class=\"salasAdelante\">adelante</a></p>");
        out.println("</div>");
        out.println("<br class=\"clear\"/>");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        isalas = salas.iterator();
        while(isalas.hasNext()) {
            out.println("  <td height=\"30\">"+isalas.next().getDisplayTitle(lang) +"</td>");
        }
        out.println("</tr>");
        for(int i=480; i<=1260; i+=30) {
            out.println("<tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(gc.getTime())+"</p></td>");
            for(Sala sala:salas) {
                out.println("  <td id=\""+sala.getClave()+"_"+i+"\" class=\"sltc trCal1\"></td>");
            }
//            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(gc.getTime())+"</p></td>");
//            out.println("  <td id=\"am_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s1_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s2_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s3_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s4_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s5_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s6_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s7_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s8_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("  <td id=\"s9_0_"+i+"\"  class=\"sltc trCal1\"></td>");
//            out.println("</tr>");
            i+=30;
            out.println("<tr>");
            for(Sala sala:salas) {
                out.println("  <td id=\""+sala.getClave()+"_"+i+"\"  class=\"sltc trCal2\"></td>");
            }
//            out.println("  <td id=\"am_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s1_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s2_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s3_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s4_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s5_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s6_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s7_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s8_1_"+i+"\"  class=\"sltc trCal2\"></td>");
//            out.println("  <td id=\"s9_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("</tr>");
            gc.add(Calendar.HOUR_OF_DAY, 1);
        }
        out.println("</table>");
        out.println("<p><input type=\"button\" value=\"reservar\" onclick=\"validate()\" /></p>");
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        
        String[] hrs = (request.getParameter("hrs")==null||request.getParameter("hrs").isEmpty())?null:request.getParameter("hrs").split(",");
        //System.out.println("\n--------------------\n");
        //System.out.println("hrs.length="+hrs.length);
        //System.out.println("hrs="+Arrays.toString(hrs));
        //System.out.println("\n--------------------\n");
        if(hrs==null || hrs.length<1) {
            out.println("<p>1desde el server las cosas no funcionan bien</p>");
            out.flush();
            return;        
        }
        
        for(int i=0; i<hrs.length-1; i++) {
            if(hrs[i].startsWith(hrs[i+1].substring(0, hrs[i+1].indexOf("_")))) {
                out.println("<p>2desde el server las cosas no funcionan bien</p>");
                out.flush();
                return;
            }
        }        
        Iterator<Sala> salas = Sala.ClassMgr.listSalas(base.getWebSite());
        boolean v = Boolean.TRUE;
        final String clave = hrs[0].substring(0, hrs[0].indexOf("_"));
        String cve;
        while(v && salas.hasNext()) {
            cve = salas.next().getClave();
            v = cve.equals(clave);
        }
        if(!v) {
            out.println("<p>3desde el server las cosas no funcionan bien</p>");
            out.flush();
            return;
        }
        
out.println("<form id=\"rs\" method=\"post\" action=\""+paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD)+"\">");
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
       
out.println("    <p><a href=\"\" onclick=\"dojo.byId('rs').submit()\" class=\"soliCal\">Solicitar</a></p>");
out.println("    <p class=\"finePrint\">*Se te enviar&aacute; un e-mail con la confirmaci&oacute;n</p>");
out.println("  </div>");
out.println("  <p id=\"popBottom\"></p>");
out.println("</div>");
out.println("</form>");
out.flush();
    }


    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if(SWBResourceURL.Action_ADD.equals(action)) {
            String motive = SWBUtils.XML.replaceXMLChars(request.getParameter("motive"));
            String typeMeet = request.getParameter("typeMeet");
            String turnout = SWBUtils.XML.replaceXMLChars(request.getParameter("turnout"));
            String[] equipment = request.getParameterValues("equipment");
            String services = SWBUtils.XML.replaceXMLChars(request.getParameter("services"));
            
            String typeCafe = SWBUtils.XML.replaceXMLChars(request.getParameter("typeCafe"));
            String hoursService = SWBUtils.XML.replaceXMLChars(request.getParameter("hoursService"));
            System.out.println("motive="+motive);
            System.out.println("typeMeet="+typeMeet);
            System.out.println("turnout="+turnout);
            System.out.println(Arrays.toString(equipment));
            System.out.println("services="+services);
        }
    }
}