package com.infotec.eworkplace.swb.resources.sem;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.*;

import com.infotec.eworkplace.swb.ReservacionSala;
import com.infotec.eworkplace.swb.Sala;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Date;

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
    
    public static final SimpleDateFormat dateDojo = new SimpleDateFormat("yyyy-MM-dd");
    public static final int T_MIN = 89;
    public static final int TRNOUT_MIN = 5;
        
    public ReservaSalaManager() {
    }

   /**
   * Constructs a ReservaSalaManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaSalaManager
   */
    public ReservaSalaManager(org.semanticwb.platform.SemanticObject base) {
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
        current = new GregorianCalendar(locale);
        session.setAttribute("cur", current);
        
        
//        if(userCanEdit(user)) {
//            out.println("<div><a href=\"#\" title=\"\">Reservar una sala</a></div>");
//            com.infotec.eworkplace.swb.Date date = com.infotec.eworkplace.swb.Date.ClassMgr.getDate(dateId, base.getWebSite());
//            Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalaByFecha(date, base.getWebSite());
//            if(reservations.hasNext()) {
//                while(reservations.hasNext()) {
//                    ReservacionSala rs = reservations.next();
//                    if(rs!=null){
//                        out.println("<p>rs="+rs+"</p>");
//                    }
//                }
//            }else
//                out.println("<p>no hay reservaciones</p>");
//        }else {
            renderReservations(request, response, paramRequest, current, locale);
//        }
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        response.setRenderParameter("suri", request.getParameter("suri"));
        User user = response.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite model = base.getWebSite();
        String action = response.getAction();

        if(SWBResourceURL.Action_ADD.equals(action)) {
            HttpSession session = request.getSession(true);
            GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
            
            Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));

            Sala sala = null;
            try {
                sala = Sala.ClassMgr.getSala(request.getParameter("sl"), model);
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrRoomMismatch"));
                return;
            }
            if(sala==null) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrRoomMismatch"));
                return;
            }
            
            int sh,fh;
            try {
                sh = Integer.parseInt(request.getParameter("sh"));
                fh = Integer.parseInt(request.getParameter("fh"));
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrHourMismatch"));
                return;
            }
            fh += 30;
            if(fh-sh<T_MIN) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrHourMismatch"));
                return;
            }
            
            GregorianCalendar csd = new GregorianCalendar(locale), cfd = null;
            try {
                csd.setTime(current.getTime());
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrHourMismatch"));
                return;
            }
            csd.set(Calendar.HOUR_OF_DAY, 0);
            csd.set(Calendar.MINUTE, sh);
            csd.set(Calendar.SECOND, 0);
            csd.set(Calendar.MILLISECOND, 0);
            
            try {
                Date fd = dateDojo.parse(request.getParameter("fd"));
                cfd = new GregorianCalendar(locale);
                cfd.setTime(fd);
                cfd.set(Calendar.HOUR_OF_DAY, 0);
                cfd.set(Calendar.MINUTE, fh);
                cfd.set(Calendar.SECOND, 0);
                cfd.set(Calendar.MILLISECOND, 0);
            }catch(ParseException e) {
                response.setRenderParameter("alertmsg", "5 ..."+response.getLocaleString("msgErrHourMismatch"));
                return;
            }

            String mtv = SWBUtils.XML.replaceXMLChars(request.getParameter("mtv"));
            if(mtv.isEmpty()) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrMoviteMissing"));
                return;
            }

            ReservacionSala.TipoReunion tpmeet; 
            try {
                tpmeet = ReservacionSala.TipoReunion.valueOf(request.getParameter("tpmeet"));
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrMeetTypeMissing"));
                return;
            }
            
            ReservacionSala.Cafeteria tpcf = null;
            ReservacionSala.Horario tmsrvc = null;
            String hrsrvc = null;
            if(ReservacionSala.TipoReunion.Externa == tpmeet) {
                try {
                    tpcf = ReservacionSala.Cafeteria.valueOf(request.getParameter("tpcf"));
                }catch(Exception e) {
                    response.setRenderParameter("alertmsg", response.getLocaleString("msgErrCafeteriaMissing"));
                    return;
                }
                
                try {
                    tmsrvc = ReservacionSala.Horario.valueOf(request.getParameter("tmsrvc"));
                }catch(Exception e) {
                    response.setRenderParameter("alertmsg", response.getLocaleString("msgErrCafeServiceMissing"));
                    return;
                }
                
                if(ReservacionSala.Horario.Receso == tmsrvc) {
                    hrsrvc = SWBUtils.XML.replaceXMLChars(request.getParameter("hrsrvc"));
                    if(hrsrvc.isEmpty()) {
                        response.setRenderParameter("alertmsg", "10 ..."+response.getLocaleString("msgErrCafeServiceMissing"));
                        return;
                    }
                }
            }
            
            int turnout = 0;
            try {
                turnout = Integer.parseInt(request.getParameter("turnout"));
            }catch(NumberFormatException e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrTurnOutMissing"));
                return;
            }
            if(turnout<TRNOUT_MIN || sala.getCapacidad()<turnout) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrTurnOutMismatch"));
                return;
            }
            
            if(!sala.isReservada(csd.getTime(), cfd.getTime())) {
                ReservacionSala reservation = ReservacionSala.ClassMgr.createReservacionSala(model);
                reservation.setSala(sala);
                reservation.setFechaInicio(csd.getTime());
                reservation.setFechaFinal(cfd.getTime());
                reservation.setAsistentes(turnout);
                reservation.setMotivo(mtv);
                reservation.setTipoReunion(tpmeet.toString());
                if(ReservacionSala.TipoReunion.Externa == tpmeet) {
                    reservation.setRequiereCafeGrano(request.getParameter("cfgrn")!=null);
                    reservation.setRequiereCafeSoluble(request.getParameter("cfslb")!=null);
                    reservation.setRequiereRefrescos(request.getParameter("sds")!=null);
                    reservation.setRequiereAgua(request.getParameter("h2o")!=null);
                    reservation.setRequiereGalletas(request.getParameter("cks")!=null);
                    if(ReservacionSala.Horario.Receso == tmsrvc) {
                        reservation.setRequiereServicioContinuo(false);
                        reservation.setHorarioServicio(hrsrvc);
                    }else {
                        reservation.setRequiereServicioContinuo(true);
                    }
                }
                reservation.setRequiereProyector(request.getParameter("prjctr")!=null);
                reservation.setRequiereComputo(request.getParameter("pcs")!=null);
                if(!request.getParameter("osrvcs").isEmpty())
                    reservation.setServiciosAdicionales(request.getParameter("osrvcs").trim());
            }else {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrReservationMismatch"));
                return;
            }
        }
    }
    
    public void doViewSala(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
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
        out.println(" <h3>"+sala.getDisplayTitle(locale.getLanguage())+"</h3>");
        out.println(" <h3>Semana "+wk+"</h3>");
        
        if(wk>1)
            out.println("<a href=\"#\" title=\"\">anterior</a>");
        if(wk<wom)
            out.println("&nbsp;<a href=\"#\" title=\"\">siguiente</a>");
        out.println("<div>");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd", locale);
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");       
        final int fdcw = cur.get(Calendar.DAY_OF_MONTH);
        if(wk==1) {
            for(int k=1; k<=7; k++) {
                if(k>=dow && k<7)
                    out.println("  <td height=\"30\">"+sdf.format(cur.getTime())+"</td>");
                else if(k>1 && k<7)
                    out.println("  <td height=\"30\" class=\"deactive\">"+sdf.format(cur.getTime())+"</td>");
                cur.add(Calendar.DATE, 1);
            }
        }else {
            for(int k=1; k<=7; k++) {
                if(month<cur.get(Calendar.MONTH) && k<7)
                    out.println("  <td height=\"30\" class=\"deactive\">"+sdf.format(cur.getTime())+"</td>");
                else if(k>1 && k<7)
                    out.println("  <td height=\"30\">"+sdf.format(cur.getTime())+"</td>"); 
                cur.add(Calendar.DATE, 1);
            }
        }
        out.println(" </tr>");
//        cur.set(Calendar.DAY_OF_MONTH, fdcw);
        
        
        sdf = new SimpleDateFormat("HH:mm");
        //GregorianCalendar begin = new GregorianCalendar(cur.get(Calendar.YEAR),cur.get(Calendar.MONTH),cur.get(Calendar.DATE),0,0,0);
        GregorianCalendar begin = new GregorianCalendar(cur.get(Calendar.YEAR),cur.get(Calendar.MONTH),fdcw,0,0,0);
        begin.set(Calendar.MINUTE, 480);
        //GregorianCalendar end = new GregorianCalendar(cur.get(Calendar.YEAR),cur.get(Calendar.MONTH),cur.get(Calendar.DATE),0,0,0);
        GregorianCalendar end = new GregorianCalendar(cur.get(Calendar.YEAR),cur.get(Calendar.MONTH),fdcw,0,0,0);
        end.set(Calendar.MINUTE, 509);
        
        for(int i=1; i<=14; i++) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(begin.getTime())+"</p></td>");
            if(wk==1) {
                for(int k=1; k<=7; k++) {
                    if(k>=dow && k<7) {
                        if(sala.isReservada(begin.getTime(), end.getTime()))
                            out.println("  <td class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                    }else if(k>1 && k<7) {
                        out.println("  <td class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }else {
                 for(int k=1; k<=7; k++) {
                    if(month<cur.get(Calendar.MONTH) && k<7) {
                        out.println("  <td id=\""+sala.getId()+"_"+cur.getTimeInMillis()+"\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }else if(k>1&&k<7) {
                        if(sala.isReservada(begin.getTime(), end.getTime()))
                            out.println("  <td class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }
            out.println(" </tr>");
            begin.set(Calendar.DAY_OF_MONTH, fdcw);
            begin.add(Calendar.MINUTE, 30);
            end.set(Calendar.DAY_OF_MONTH, fdcw);
            end.add(Calendar.MINUTE, 30);
            out.println(" <tr>");
            if(wk==1) {
                for(int k=1; k<=7; k++) {
                    if(k>=dow && k<7) {
                        if(sala.isReservada(begin.getTime(), end.getTime()))
                            out.println("  <td class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                    }else if(k>1 && k<7) {
                        out.println("  <td class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }else {
                 for(int k=1; k<=7; k++) {
                    if(month<cur.get(Calendar.MONTH) && k<7) {
                        out.println("  <td class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }else if(k>1&&k<7) {
                        if(sala.isReservada(begin.getTime(), end.getTime()))
                            out.println("  <td class=\"x sltc trCal1\">&nbsp;</td>");
                        else
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }
            out.println(" </tr>");
            begin.set(Calendar.DAY_OF_MONTH, fdcw);
            begin.add(Calendar.MINUTE, 30);
            end.set(Calendar.DAY_OF_MONTH, fdcw);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</table>");
    }
    
    private String getScript(HttpServletRequest request, SWBParamRequest paramRequest, Locale locale) {
        StringBuilder js = new StringBuilder();
        js.append("\n<script type=\"text/javascript\">");
        js.append("\n<!--");
        
        js.append("\n dojo.require('dojox.layout.ContentPane');");
        js.append("\n dojo.require('dijit.form.Form');");
        js.append("\n dojo.require('dijit.form.CheckBox');");
        js.append("\n dojo.require('dijit.form.DateTextBox');");
        js.append("\n dojo.require('dijit.form.SimpleTextarea');");
        js.append("\n dojo.require('dijit.form.FilteringSelect');");
        js.append("\n dojo.require('dijit.form.ValidationTextBox');");
        js.append("\n dojo.require('dojo.fx');");
        js.append("\n dojo.require('dijit.dijit');");

        js.append("\n dojo.declare(");
        js.append("\n     'ValidationTextarea',");
        js.append("\n     [dijit.form.ValidationTextBox, dijit.form.SimpleTextarea],");
        js.append("\n     {");
        js.append("\n         invalidMessage: 'Este dato es requerido',");
        js.append("\n         promptMessage: 'Ingresa',");
        js.append("\n         postCreate: function() {");
        js.append("\n             this.inherited(arguments);");
        js.append("\n         },");
        js.append("\n         validate: function() {");
        js.append("\n             if(arguments.length==0)");
        js.append("\n                 return this.validate(false);");
        js.append("\n             return this.inherited(arguments);");
        js.append("\n         },");
        js.append("\n         onFocus: function() {");
        js.append("\n             if(!this.isValid()) {");
        js.append("\n                 this.displayMessage(this.getErrorMessage());");
        js.append("\n             }");
        js.append("\n         },");
        js.append("\n         onBlur: function() {");
        js.append("\n             this.validate(false);");
        js.append("\n         }");
        js.append("\n      }");
        js.append("\n );");

        js.append("\n function expande(domId) {");
        js.append("\n  var anim1 = dojo.fx.wipeIn( {node:domId, duration:200 });");
        js.append("\n  var anim2 = dojo.fadeIn({node:domId, duration:250});");
        js.append("\n  dojo.fx.combine([anim1,anim2]).play();");
        js.append("\n }");

        js.append("\n function collapse(domId) {");
        js.append("\n  var anim1 = dojo.fx.wipeOut( {node:domId, duration:200 });");
        js.append("\n  var anim2 = dojo.fadeOut({node:domId, duration:250});");
        js.append("\n  dojo.fx.combine([anim1, anim2]).play();");
        js.append("\n }");

        js.append("\n function validateFrm() {");
        js.append("\n ");
        js.append("\n  var objd = dijit.byId('_rs_');");
        js.append("\n  if(objd.validate()) {");
        js.append("\n   if(dojo.byId('brksrvc').checked==true && isEmpty(dojo.byId('hrSrvc').value)) {");
        js.append("\n    alert('Datos incompletos para el horario de cafetería');");
        js.append("\n    return false;");
        js.append("\n   }");
        js.append("\n   return true;");
        js.append("\n  }else {");
        js.append("\n   alert('Datos incompletos o incorrectos');");
        js.append("\n   return false;");
        js.append("\n  }");
//        
//        js.append("\n    console.log('no pasa');");
//        js.append("\n  else");
//        js.append("\n    console.log('si pasa');");
//        js.append("\n  return true;");
        js.append("\n }");

        js.append("\n-->");
        js.append("\n</script>");
        return js.toString();
    }
    
    private String getForm(HttpServletRequest request, SWBParamRequest paramRequest, List<Sala> salas, Locale locale) {
        StringBuilder html = new StringBuilder();
        
        HttpSession session = request.getSession(true);
        GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", locale);
        SWBResourceURL url = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD).setParameter("suri", request.getParameter("suri"));
        html.append("<form id=\"_rs_\" method=\"post\" dojoType=\"dijit.form.Form\" action=\""+url.toString()+"\">");
        html.append("<div id=\"mainPop\">");
        html.append(" <p id=\"popTop\"></p>");
        html.append(" <div id=\"popMiddle\">");
        
        html.append(" <div class=\"salas4Cols salas-cual\">");
        html.append("  <p><span class=\"blueCalTit\">Sala:</span></p>");
        html.append("  <select name=\"sl\" id=\"sl\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\" promptMessage=\"Selecciona una sala\" invalidMessage=\"La sala es requerida\">");
        html.append("   <option value=\"\"></option>");
        for(Sala sala:salas) {
            html.append("   <option value=\""+sala.getId()+"\">"+sala.getDisplayTitle(locale.getLanguage())+"</option>");
        }
        html.append("  </select>");
        html.append(" </div>");
        html.append(" <div class=\"salas4Cols salas-fecha\">");
        html.append("  <p><span class=\"blueCalTit\">Fecha:</span></p>");
        html.append("     <label for=\"sd\">Del: </label><input type=\"text\" name=\"sd\" id=\"sd\" value=\""+sdf.format(current.getTime())+"\" dojoType=\"dijit.form.ValidationTextBox\" readonly=\"readonly\" />");
        html.append("     <label for=\"fd\">al: </label><input type=\"text\" name=\"fd\" id=\"fd\" value=\""+dateDojo.format(current.getTime())+"\" dojoType=\"dijit.form.DateTextBox\" constraints=\"{min:'"+dateDojo.format(current.getTime())+"',max:'2013-12-31',datePattern:'dd/MMM/yyyy'}\"  required=\"true\" trim=\"true\" promptMessage=\"formato de la fecha dd/MM/yyyy\" invalidMessage=\"Invalid date\" />");
        html.append(" </div>");
        html.append(" <div class=\"salas4Cols salas-hora\">");
        html.append("  <p><span class=\"blueCalTit\">Horario:</span></p>");
        html.append("  <label for=\"sh\">De: </label><select name=\"sh\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\" promptMessage=\"Hora inicial\" invalidMessage=\"La hora inicial es requerida\"><option value=\"480\">08:00</option><option value=\"510\">08:30</option><option value=\"540\">09:00</option><option value=\"570\">09:30</option><option value=\"600\">10:00</option><option value=\"630\">10:30</option><option value=\"660\">11:00</option><option value=\"690\">11:30</option><option value=\"720\">12:00</option><option value=\"750\">12:30</option><option value=\"780\">13:00</option><option value=\"810\">13:30</option><option value=\"840\">14:00</option><option value=\"870\">14:30</option><option value=\"900\">15:00</option><option value=\"930\">15:30</option> <option value=\"960\">16:00</option> <option value=\"990\">16:30</option><option value=\"1020\">17:00</option><option value=\"1050\">17:30</option><option value=\"1080\">18:00</option><option value=\"1110\">18:30</option><option value=\"1140\">19:00</option><option value=\"1170\">19:30</option><option value=\"1200\">20:00</option><option value=\"1230\">20:30</option><option value=\"1260\">21:00</option></select>");
        html.append("  <label for=\"fh\">a: </label><select  name=\"fh\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\" promptMessage=\"Hora final\" invalidMessage=\"La hora final es requerida\"><option value=\"539\">08:59</option><option value=\"569\">09:29</option><option value=\"599\">09:59</option><option value=\"629\">10:29</option><option value=\"659\">10:59</option><option value=\"689\">11:29</option><option value=\"719\">11:59</option><option value=\"749\">12:29</option><option value=\"779\">12:59</option><option value=\"809\">13:29</option><option value=\"839\">13:59</option><option value=\"869\">14:29</option><option value=\"899\">14:59</option><option value=\"929\">15:29</option><option value=\"959\">15:59</option><option value=\"989\">16:29</option><option value=\"1019\">16:59</option><option value=\"1049\">17:29</option><option value=\"1079\">17:59</option><option value=\"1109\">18:29</option><option value=\"1139\">18:59</option><option value=\"1169\">19:29</option><option value=\"1199\">19:59</option><option value=\"1229\">20:29</option><option value=\"1259\">20:59</option><option value=\"1289\">21:29</option><option value=\"1319\">21:59</option></select>");
        html.append(" </div>");
        html.append(" <div class=\"salas4Cols salas-tipo\">");
        html.append("  <p><span class=\"blueCalTit\">Tipo de reuni&oacute;n:</span></p>");
        html.append("  <ul>");
        html.append("   <li><label for=\"meetsng\">Interna <input  type=\"radio\" name=\"tpmeet\" id=\"meetsng\"  value=\""+ReservacionSala.TipoReunion.Interna+"\" onclick=\"collapse('_tpcf_')\" checked=\"checked\" /></label></li>");
        html.append("   <li><label for=\"meetspcl\">Externa <input type=\"radio\" name=\"tpmeet\" id=\"meetspcl\" value=\""+ReservacionSala.TipoReunion.Externa+"\" onclick=\"expande('_tpcf_')\" /></label></li>");
        html.append("  </ul>");
        html.append(" </div>");
        html.append(" <div class=\"clear\">&nbsp;</div>");
        
        html.append(" <div id=\"_tpcf_\">");
        html.append("  <div id=\"_tpcf_detalle\">");
        html.append("   <ul>");
        html.append("    <li class=\"cafe_cfsbl\"><label for=\"cfsbl\"><input type=\"checkbox\" name=\"cfslb\" id=\"cfslb\" value=\"true\" checked=\"checked\" /> Café soluble</label></li>");
        html.append("    <li class=\"cafe_cfgrn\"><label for=\"cfgrn\"><input type=\"checkbox\" name=\"cfgrn\" id=\"cfgrn\" value=\"true\" /> Café de grano</label></li>");
        html.append("    <li class=\"cafe_h2o\"><label for=\"h2o\"><input type=\"checkbox\" name=\"h2o\" id=\"h2o\" value=\"true\" checked=\"checked\" /> Agua</label></li>");
        html.append("    <li class=\"cafe_sds\"><label for=\"sds\"><input type=\"checkbox\" name=\"sds\" id=\"sds\" value=\"true\" /> Refrescos</label></li>");
        html.append("    <li class=\"cafe_cks\"><label for=\"cks\"><input type=\"checkbox\" name=\"cks\" id=\"cks\" value=\"true\" /> Galletas</label></li>");
        html.append("   </ul>");
        html.append("  </div>");
        html.append("  <div id=\"_tpcf_hora\">");
        html.append("   <p>Horario del servicio: </p>");
        html.append("   <ul>");
        html.append("    <li class=\"cafe_allsrvc\"><label for=\"allsrvc\">Durante <input type=\"radio\" name=\"tmsrvc\" id=\"allsrvc\" value=\""+ReservacionSala.Horario.Durante+"\" onclick=\"collapse('_tmsrvc_')\" checked=\"checked\" /></label></li>");
        html.append("    <li class=\"cafe_brksrvc\"><label for=\"brksrvc\">Receso <input type=\"radio\" name=\"tmsrvc\" id=\"brksrvc\" value=\""+ReservacionSala.Horario.Receso+"\" onclick=\"expande('_tmsrvc_')\" /></label></li>");
        html.append("   </ul>");
        html.append("   <div id=\"_tmsrvc_\">");
        html.append("    <p><label for=\"hrsrvc\">Horario del servicio: <input type=\"text\" name=\"hrsrvc\" id=\"hrsrvc\" value=\"\" /></label></p>");
        html.append("   </div>");
        html.append("  </div>");
        html.append(" </div>");
        
        html.append(" <div id=\"salas-motivo\">");
        html.append("  <p><span class=\"blueCalTit\">Motivo de la reuni&oacute;n:</span></p>");
        html.append("  <label for=\"mtv\"></label><textarea name=\"mtv\" id=\"mtv\" dojoType=\"ValidationTextarea\" required=\"true\" promptMessage=\"Motivo\" invalidMessage=\"El motivo de la junta es requerido\" class=\"datosCal\"></textarea>");
        html.append(" </div>");
        
        html.append(" <div id=\"salas-asistentes\">");
        html.append("  <p><span class=\"blueCalTit\">N&uacute;mero de asistentes:</span></p>");
        html.append("  <label for=\"turnout\"></label><input type=\"text\" name=\"turnout\" id=\"turnout\" value=\"\" size=\"10\" maxlength=\"3\" dojoType=\"dijit.form.ValidationTextBox\" required=\"true\" promptMessage=\"Asistentes\" invalidMessage=\"El valor es incorrecto\" regExp=\"\\d{1,3}\" trim=\"true\" />");
        html.append(" </div>");
        
        html.append(" <div id=\"salas-material\">");
        html.append("  <p><span class=\"blueCalTit\">Materiales y equipo:</span></p>");
        html.append("  <ul>");
//        html.append("   <li><label for=\"airc\"><input type=\"checkbox\" name=\"airc\" id=\"airc\" value=\"1\" />Aire acondicionado</label></li>");
        html.append("   <li><label for=\"prjctr\"><input type=\"checkbox\" name=\"prjctr\" id=\"prjctr\" value=\"1\" />Proyector</label></li>");
        html.append("   <li><label for=\"pcs\"><input type=\"checkbox\" name=\"pcs\" id=\"pcs\" value=\"1\" />Computadoras</label></li>");
//        html.append("   <li><label for=\"rtfl\"><input type=\"checkbox\" name=\"rtfl\" id=\"rtfl\" value=\"1\" />Rotafolio</label></li>");
        html.append("   <li><label for=\"osrvcs\"><textarea name=\"osrvcs\" id=\"osrvcs\" dojoType=\"ValidationTextarea\" trim=\"true\"></textarea></label></li>");
        html.append("  </ul>");        
        html.append(" </div>");
        html.append(" <div class=\"clear\">&nbsp;</div>");
        
        html.append("  <p>");
        html.append("   <a href=\"javascript:dojo.byId('_rs_').reset()\" title=\"Limpiar formulario\">Limpiar</a>");
        html.append("   <a href=\"javascript:if(validateFrm())dojo.byId('_rs_').submit()\" class=\"soliCal\">Solicitar</a>");
        html.append("  </p>");
        html.append("  <p class=\"finePrint\">*Se te enviar&aacute; un e-mail con la confirmaci&oacute;n</p>");
        html.append(" </div>");
        html.append(" <p id=\"popBottom\"></p>");
        html.append("</div>");
        html.append("</form>");
        return html.toString();
    }
    
    private String getCalendar(HttpServletRequest request, SWBParamRequest paramRequest, Locale locale) {
        StringBuilder html = new StringBuilder();
        
        HttpSession session = request.getSession(true);
        GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
        
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(Mode_ROLL).setParameter("suri", request.getParameter("suri"));
        
        html.append("\n<div id=\"dayselectorCal\">");
        html.append("\n <p class=\"disponibilidadSalas\">Disponibilidad de salas</p>");
        url.setParameter(Rel, Roll_DATE);
        url.setParameter(Roll, Roll_LEFT);
        html.append("\n <p><a href=\"javascript:location.href='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a></p>");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM", locale);
        html.append("\n <p id=\"current\" class=\"dayAndMonth\">"+sdf.format(current.getTime())+"</p>");
        url.setParameter(Roll, Roll_RIGHT);
        html.append("\n <p><a href=\"javascript:location.href='"+url+"'\" class=\"salasAdelante\">adelante</a></p>");
        html.append("\n</div>");
        
        html.append("\n<div id=\"salasCal\">");
        url.setParameter(Rel, Roll_MONTH);
        url.setParameter(Roll, Roll_LEFT);
        html.append("\n <a href=\"javascript:location.href='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a>");
        sdf = new SimpleDateFormat("MMMM yyyy", locale);
        html.append("\n <span id=\"month\" class=\"salasMonthYear\">"+sdf.format(current.getTime()) +"</span>");
        url.setParameter(Roll, Roll_RIGHT);
        html.append("\n <a href=\"javascript:location.href='"+url+"'\" class=\"salasAdelante\">adelante</a>");
        html.append("\n <ul class=\"daysTop\">");
        html.append("\n  <li>D</li>");
        html.append("\n  <li>L</li>");
        html.append("\n  <li>M</li>");
        html.append("\n  <li>M</li>");
        html.append("\n  <li>J</li>");
        html.append("\n  <li>V</li>");
        html.append("\n  <li>S</li>");
        html.append("\n </ul>");
        int daysInMonth = current.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        GregorianCalendar ci = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),1,0,0);
        int dayCounter = 1;
        int loopCounter = 1;
        int firstDay = ci.get(GregorianCalendar.DAY_OF_WEEK);
        html.append("\n <ul class=\"daysCal\">");
        sdf = new SimpleDateFormat("dd");
        url.setParameter(Rel, Set_DATE);
        for(int i=1; i<=6; i++) {
            for(int j=1; j<8; j++) {
                html.append("\n<li>");
                if( loopCounter>=firstDay && dayCounter<=daysInMonth ) {
                    url.setParameter(Roll, sdf.format(ci.getTime()));
                    html.append("<a href=\"javascript:location.href='"+url+"'\">");
                    html.append(sdf.format(ci.getTime())+"</a>");
                    
                    ci.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    dayCounter++;
                }
                loopCounter++;
                html.append("</li>");
            }
        }
        html.append("\n </ul>");
        html.append("\n</div>");        
        return html.toString();
    }
    
    private void renderReservations(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, GregorianCalendar current, Locale locale) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
//Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalas((SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
//while(reservations.hasNext()) {
// reservations.next().remove();
//}
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        PrintWriter out = response.getWriter();
        
        out.println(getScript(request, paramRequest, locale));       
        out.println("<div id=\"apartadoSalas\">");
        
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println("<script type=\"text/javascript\">");
            out.println("<!--");
            out.println( "alert('"+request.getParameter("alertmsg")+"');");
            out.println("-->");
            out.println("</script>");
        }
        
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        final List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        for(Sala sala:salas) {
            if(!user.haveAccess(sala) || !sala.isActive())
                salas.remove(sala);
        }
        out.println(getForm(request, paramRequest, salas, locale));
        out.println("<br class=\"clear\"/>");
        out.println(getCalendar(request, paramRequest, locale));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        for(Sala sala:salas) {
            out.println("  <td height=\"30\"><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\"ver sala\">"+sala.getDisplayTitle(lang)+"</a></td>");
        }
        out.println(" </tr>");
        
        GregorianCalendar hourOfDay = new GregorianCalendar(2011,0,1,8,0);//auxiliar
        GregorianCalendar begin = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        begin.set(Calendar.MINUTE, 480);
        GregorianCalendar end = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        end.set(Calendar.MINUTE, 509);

        for(int i=480; i<=1260; i+=30) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(hourOfDay.getTime())+"</p></td>");
            for(Sala sala:salas) {
                if(sala.isReservada(begin.getTime(), end.getTime()))
                    out.println("  <td class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println(" </tr>");
            out.println(" <tr>");
            i+=30;
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
            for(Sala sala:salas) {
                if(sala.isReservada(begin.getTime(), end.getTime()))
                    out.println("  <td class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println(" </tr>");
            hourOfDay.add(Calendar.HOUR_OF_DAY, 1);
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.addOnLoad(function() {");
        out.println("     collapse('_tpcf_');");
        out.println("     collapse('_tmsrvc_');");   
        out.println(" });");
        out.println("-->");
        out.println("</script>");
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
        session.setAttribute("cur", current);
        
        out.println(getScript(request, paramRequest, locale));
        out.println("<div id=\"apartadoSalas\">");
        
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println("<h1>"+request.getParameter("alertmsg")+"</h1>");
        }
        
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        final List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        for(Sala sala:salas) {
            if(!user.haveAccess(sala) || !sala.isActive())
                salas.remove(sala);
        }
        out.println(getForm(request, paramRequest, salas, locale));
        out.println("<br class=\"clear\"/>");
        out.println(getCalendar(request, paramRequest, locale));
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        for(Sala sala:salas) {
            out.println("  <td height=\"30\"><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\"ver sala\">"+sala.getDisplayTitle(lang)+"</a></td>");
        }
        out.println(" </tr>");
        
        GregorianCalendar hourOfDay = new GregorianCalendar(2011,0,1,8,0);//auxiliar
        GregorianCalendar begin = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        begin.set(Calendar.MINUTE, 480);
        GregorianCalendar end = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        end.set(Calendar.MINUTE, 509);

        for(int i=480; i<=1260; i+=30) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(hourOfDay.getTime())+"</p></td>");
            for(Sala sala:salas) {
                if(sala.isReservada(begin.getTime(), end.getTime()))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println(" </tr>");
            out.println(" <tr>");
            i+=30;
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
            for(Sala sala:salas) {
                if(sala.isReservada(begin.getTime(), end.getTime()))
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"x sltc trCal1\">&nbsp;</td>");
                else
                    out.println("  <td id=\""+sala.getId()+"_"+i+"\" class=\"sltc trCal1\">&nbsp;</td>");
            }
            out.println(" </tr>");
            hourOfDay.add(Calendar.HOUR_OF_DAY, 1);
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.addOnLoad(function() {");
        out.println("     collapse('_tpcf_');");
        out.println("     collapse('_tmsrvc_');");   
        out.println(" });");
        out.println("-->");
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