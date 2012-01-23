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

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBResourceURL;

public class ReservaSalaManager extends com.infotec.eworkplace.swb.resources.sem.base.ReservaSalaManagerBase {
    private static Logger log = SWBUtils.getLogger(ReservaSalaManager.class);
    public static final String Mode_ROLL = "roll";
    public static final String Roll_DATE = "date";
    public static final String Roll_MONTH = "month";
    public static final String Rel = "rel";
    public static final String Roll = "roll";
    public static final String Roll_RIGHT = "right";
    public static final String Roll_LEFT = "left";
    public static final String Set_DATE = "dom";
    
    public static final int Cleaning_Time = 29;
    
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
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
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
        //out.println("            showDialog2('"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT).setCallMethod(SWBResourceURL.Call_DIRECT)+"'+'?hrs='+hrs.join(),'"+paramRequest.getLocaleString("usrmsg_doView_titleLbl")+"');");
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
        
        
//        out.println("<div dojoType=\"dijit.Dialog\" class=\"soria\" style=\"display:none;\" id=\"swbDialog\" " +
//                "title=\"Agregar\" onFocus=\"hideApplet(true);\" onBlur=\"if(!this.open)hideApplet(false);\" >\n" +
//                "  <div dojoType=\"dojox.layout.ContentPane\" class=\"soria\" id=\"swbDialogImp\" executeScripts=\"true\">\n" +
//                "    Cargando...\n" +
//                "  </div>\n" +
//                "</div>\n");
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
            session.setAttribute("cur", current);
        }else {
            current = (GregorianCalendar)session.getAttribute("cur");
        }
        out.println("<div id=\"apartadoSalas\">");
        //out.println("<div id=\"cal\">");
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
        //out.println("</div>");//<div id="cal">
        
        
        out.println("<br class=\"clear\"/>");
        
        sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        isalas = salas.iterator();
        while(isalas.hasNext()) {
            out.println("  <td height=\"30\">"+isalas.next().getDisplayTitle(lang) +"</td>");
        }
        out.println("</tr>");
        
        GregorianCalendar gc = new GregorianCalendar(2011,0,1,8,0);//auxiliar
        GregorianCalendar cur = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        cur.add(Calendar.MINUTE, 450);
        for(int i=480; i<=1320; i+=30) {
            cur.add(Calendar.MINUTE, 30);
            out.println("<tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(gc.getTime())+"</p></td>");
            for(Sala sala:salas) {
                if(sala.isReservada(cur, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\"></td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\"></td>");
            }
            cur.add(Calendar.MINUTE, 30);
            out.println("<tr>");
            i+=30;
            for(Sala sala:salas) {
                if(sala.isReservada(cur, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\"></td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\"></td>");
            }
            out.println("</tr>");
            gc.add(Calendar.HOUR_OF_DAY, 1);
        }
        out.println("</table>");
        out.println("<p><input type=\"button\" value=\"reservar\" onclick=\"validate()\" /></p>");
        //out.println("<a href=\"javascript:validate()\">Reservar</a>");
        out.println("<p><a href=\""+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_HELP) +"\">borrar reservaciones</a></p>");
        out.println("</div>");
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        String action = response.getAction();
        if(SWBResourceURL.Action_ADD.equals(action)) {
            response.setMode(SWBResourceURL.Mode_VIEW);
            
            User user = response.getUser();
            
            String motive = SWBUtils.XML.replaceXMLChars(request.getParameter("motive"));
            String typeMeet = request.getParameter("typeMeet");
            String turnout = SWBUtils.XML.replaceXMLChars(request.getParameter("turnout"));
            String[] equipment = request.getParameterValues("equipment");
            String services = SWBUtils.XML.replaceXMLChars(request.getParameter("services")); 
            String typeCafe = SWBUtils.XML.replaceXMLChars(request.getParameter("typeCafe"));
            String hoursService = SWBUtils.XML.replaceXMLChars(request.getParameter("hoursService"));

            final String uri = SWBUtils.XML.replaceXMLChars(request.getParameter("sl"));
            Sala sala = null;
            try {
                sala = (Sala)SemanticObject.createSemanticObject(uri).createGenericInstance();
            }catch(Exception e) {
                log.error(e);
                e.printStackTrace(System.out);
            }
                
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
            
            if(sala!=null && sala.isValid() && !sala.isReservada(cur, hi, hf)) {
                ReservacionSala reservation = ReservacionSala.ClassMgr.createReservacionSala(base.getWebSite());
                sala.setReservada(true);
                reservation.setSala(sala);
                reservation.setResponsable(user);
                reservation.setFecha(cur.getTime());
                reservation.setDe(hi);
                reservation.setA(hf);
System.out.println("reservacion creada..."+reservation.toString());
            }
        }
        /*else if(SWBResourceURL.Action_EDIT.equals(action)) {
            String editAccessURI = request.getParameter("editAccess");
            if(editAccessURI!=null) {
                base.setAttribute("editAccess", editAccessURI);
                try {
                    base.updateAttributesToDB();
                }catch(Exception e) {
                    log.error("Error al guardar Role/UserGroup para acceso al InlineEdit.",e);
                }finally {
                    response.setAction(response.Action_ADD);
                }
            }
        }*/
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
        out.println("<input type=\"hidden\" name=\"hf\" value=\""+ihrs[ihrs.length-1]+"\"/>");
        out.println("<input type=\"hidden\" name=\"sl\" value=\""+sala.getURI()+"\"/>");
        out.println("<div id=\"mainPop\">");
        out.println("  <div id=\"popMiddle\">");
        out.println("    <p>Fecha de reservaci&oacute;n:<br />");
        out.println("      <span class=\"blueCal\">3 de Noviembre de 2011 10:00 AM </span><br />");
        out.println("      <span class=\"blueCal\">3 de Noviembre de 2011 12:00 PM</span>");
        out.println("    </p>");
        out.println("    <div id=\"usuarioCal\">");
        //out.println("      <p><img src=\"images/placeholderCal.png\" width=\"80\" height=\"80\" alt=\"placeholder\" /></p>");
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

        //out.println("    <p><a href=\"\" onclick=\"dojo.byId('rs').submit()\" class=\"soliCal\">Solicitar</a></p>");
        out.println("    <p><input type=\"submit\" class=\"soliCal\">Solicitar</a></p>");
        out.println("    <p class=\"finePrint\">*Se te enviar&aacute; un e-mail con la confirmaci&oacute;n</p>");
        out.println("  </div>");
        out.println("  <p id=\"popBottom\"></p>");
        out.println("</div>");
        out.println("</form>");
        
        
//out.println("<script type=\"text/javascript\">");
//out.println("    createCoverDiv(divId, bgcolor, opacity);");
//out.println("    var contactHolder = document.createElement('div');");
//out.println("    var cwidth = 360;");
//out.println("    var cheight = 550;");
//
//out.println("    contactHolder.id='s_'+divId;");
//out.println("    contactHolder.style.zIndex=1001;");
//out.println("    contactHolder.style.position='absolute';");
//out.println("    contactHolder.style.top='50%';");
//out.println("    contactHolder.style.left='50%';");
//out.println("    contactHolder.style.marginLeft=-cwidth/2+'px';");
//out.println("    contactHolder.style.marginTop=-cheight/2+'px';");
//out.println("    contactHolder.style.width=cwidth+'px';");
//out.println("    contactHolder.style.height=cheight+'px';");
//out.println("    document.body.appendChild(contactHolder);");
//out.println("  }");
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
        
        
//        out.println("<div dojoType=\"dijit.Dialog\" class=\"soria\" style=\"display:none;\" id=\"swbDialog\" " +
//                "title=\"Agregar\" onFocus=\"hideApplet(true);\" onBlur=\"if(!this.open)hideApplet(false);\" >\n" +
//                "  <div dojoType=\"dojox.layout.ContentPane\" class=\"soria\" id=\"swbDialogImp\" executeScripts=\"true\">\n" +
//                "    Cargando...\n" +
//                "  </div>\n" +
//                "</div>\n");
        
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
        
        
        
        out.println("<br class=\"clear\"/>");   
        
        sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        isalas = salas.iterator();
        while(isalas.hasNext()) {
            out.println("  <td height=\"30\">"+isalas.next().getDisplayTitle(lang) +"</td>");
        }
        out.println("</tr>");
        
        GregorianCalendar gc = new GregorianCalendar(2011,0,1,8,0);//auxiliar
        GregorianCalendar cur = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        cur.add(Calendar.MINUTE, 450);
        for(int i=480; i<=1320; i+=30) {
            cur.add(Calendar.MINUTE, 30);
            out.println("<tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(gc.getTime())+"</p></td>");
            for(Sala sala:salas) {
                if(sala.isReservada(cur, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\"></td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\"></td>");
            }
            cur.add(Calendar.MINUTE, 30);
            out.println("<tr>");
            i+=30;
            for(Sala sala:salas) {
                if(sala.isReservada(cur, i, i+29))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\"></td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\"></td>");
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
                rs.remove();
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("location.href='"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW)+"'");
        out.println("</script>");
    }
    
    private boolean userCanEdit(SWBParamRequest paramrequest) {
        boolean access = false;
        String editAccessURI = getResourceBase().getAttribute("editAccess");
        User user = paramrequest.getUser();
        try {
            if(editAccessURI!=null) {
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                GenericObject gobj = null;
                try {
                    gobj = ont.getGenericObject(editAccessURI);
                }catch (Exception e) {
                    log.error(e);
                }
//                if(!editAccessURI.equals("0")) {
                if(gobj != null) {
                    UserGroup ugrp = null;
                    Role urole = null;
                    if(gobj instanceof UserGroup) {
                        ugrp = (UserGroup)gobj;
                        if(user.hasUserGroup(ugrp)) {
                            access = true;
                        }
                    }else if(gobj instanceof Role) {
                        urole = (Role)gobj;
                        if(user.hasRole(urole)) {
                            access = true;
                        }
                    }
                }
                else {
                    access = true;
                }
//                } else {
//                    access = true;
//                }
            }
        }catch(Exception e) {
            access = false;
        }

//        if(editAccessURI==null && user==null) {
//            access = true;
//        }else if(editAccessURI!=null && user==null) {
//            access = false;
//        }else if(editAccessURI==null && user!=null) {
//            access = true;
//        }
        return access;
    }
}