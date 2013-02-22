/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.eworkplace.swb.resources;

import com.infotec.eworkplace.swb.ReservacionSala;
import com.infotec.eworkplace.swb.Sala;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class ReservaSalaResume extends GenericResource {
    private static Logger log = SWBUtils.getLogger(ReservaSalaResume.class);
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
    public static final SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat HH = new SimpleDateFormat("HH:");
    public static final int MIN_TIME = 89;
    public static final int QUORUM = 5;
    public static final int START_HOUR = 7; // 07:00 hrs
    public static final int START_MIN = 420; // 07:00 hrs en minutos
        
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if(Mode_ROLL.equals(mode))
        {
            doRoll(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        resume(request, response, paramRequest);
    }
    
    public void resume(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=utf-8");
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        PrintWriter out = response.getWriter();
        
        GregorianCalendar current;
//        HttpSession session = request.getSession(true);
//        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
//            session.setAttribute("cur", current);
//        }else {
//            current = (GregorianCalendar)session.getAttribute("cur");
//        }
        
//        out.println(getScript(request, paramRequest, locale));       
        out.println("<div id=\"apartadoSalas\">");
        
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        List<Sala> _remove=new ArrayList<Sala>();
        for(Sala sala:salas) {
            if(!user.haveAccess(sala) || !sala.isActive())
                //salas.remove(sala);
                _remove.add(sala);

        }
        for(Sala _sala : _remove)
        {
            salas.remove(_sala);
            
        }
        out.println(getCalendar(request, paramRequest, locale));
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<thead>");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <th class=\"thCalHora\">Hora</td>");
        for(Sala sala:salas) {
            out.println("  <th class=\"thCalS_"+sala.getId()+"\"><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\""+sala.getDisplayTitle(lang)+" ("+sala.getCapacidad()+")\">"+sala.getDisplayTitle(lang)+"</a></td>");
        }
        out.println(" </tr>");
        out.println("</thead>");
        
        Calendar today = Calendar.getInstance();//auxiliar
        reset(today,START_HOUR,0);
        GregorianCalendar begin = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        begin.set(Calendar.MINUTE, START_MIN);
        GregorianCalendar end = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        end.set(Calendar.MINUTE, 449);
        
        ReservacionSala myReservation;
        out.println("<tbody>");
        for(int i=START_MIN; i<=1260; i+=30) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+HHmm.format(today.getTime())+"</p></td>");
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    myReservation = null;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            out.println(" <tr>");
            i+=30;
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    myReservation = null;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            today.add(Calendar.HOUR_OF_DAY, 1);
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<br class=\"clear\"/>");
        
//        if(current.get(Calendar.DAY_OF_YEAR)>=today.get(Calendar.DAY_OF_YEAR)) {
//            out.println(getScript(request, paramRequest, locale));
//            out.println(getForm(request, paramRequest, salas, locale));
//        }
        
        out.println("</div>");
//        out.println("<script type=\"text/javascript\">");
//        out.println("<!--");
//        out.println(" dojo.addOnLoad(function() {");
//        out.println(  request.getParameter("tpmeet")==null?"collapse('_tpcf_');":(request.getParameter("tpmeet").equals(ReservacionSala.TipoReunion.Interna.name())?"collapse('_tpcf_');":"expande('_tpcf_');")   );
//        out.println(  request.getParameter("tmsrvc")==null?"collapse('_tmsrvc_');":(request.getParameter("tmsrvc").equals(ReservacionSala.Horario.Durante.name())?"collapse('_tmsrvc_');":"expande('_tmsrvc_');")   );
//        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
//            out.println( "alert('"+request.getParameter("alertmsg")+"');");
//        }        
//        out.println(" });");
//        out.println("-->");
//        out.println("</script>");
    }
    
    private String getCalendar(HttpServletRequest request, SWBParamRequest paramRequest, Locale locale) throws SWBResourceException
    {
        StringBuilder html = new StringBuilder();
        
        HttpSession session = request.getSession(true);
        GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(Mode_ROLL).setParameter("suri", request.getParameter("suri"));
        
        html.append("\n<div id=\"dayselectorCal\">");
        html.append("\n <p class=\"disponibilidadSalas\">"+paramRequest.getLocaleString("lblAvailability")+"</p>");
        url.setParameter(Rel, Roll_DATE);
        url.setParameter(Roll, Roll_LEFT);
        html.append("\n <p><a href=\"javascript:window.location='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a></p>");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM", locale);
        html.append("\n <p id=\"current\" class=\"dayAndMonth\">"+sdf.format(current.getTime())+"</p>");
        url.setParameter(Roll, Roll_RIGHT);
        html.append("\n <p><a href=\"javascript:window.location='"+url+"'\" class=\"salasAdelante\">adelante</a></p>");
        html.append("\n</div>");
        
        html.append("\n<div id=\"salasCal\">");
        url.setParameter(Rel, Roll_MONTH);
        url.setParameter(Roll, Roll_LEFT);
        html.append("\n <a href=\"\" onclick=\"javascript:location.href='"+url+"'; return false;\" class=\"salasAtras\">atr&aacute;s</a>");
        sdf = new SimpleDateFormat("MMMM yyyy", locale);
        html.append("\n <span id=\"month\" class=\"salasMonthYear\">"+sdf.format(current.getTime()) +"</span>");
        url.setParameter(Roll, Roll_RIGHT);
        html.append("\n <a href=\"\" onclick=\"javascript:location.href='"+url+"'; return false;\" class=\"salasAdelante\">adelante</a>");
        html.append("\n <ul class=\"daysTop\">");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblSundayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblMondayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblThrusdayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblWednesdayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblTuesdayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblFridayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblSaturdayE")+"</li>");
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
                    html.append("<a href=\"\" onclick=\"javascript:location.href='"+url+"'; return false;\">");
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
    
    public void doRoll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
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
            current = (GregorianCalendar)session.getAttribute("cur");
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
        
//        out.println(getScript(request, paramRequest, locale));
        out.println("<div id=\"apartadoSalas\">");
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println("<h1>"+request.getParameter("alertmsg")+"</h1>");
        }
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);

        ArrayList<Sala> _remove=new ArrayList<Sala>();

        for(Sala sala:salas) {
            if(!user.haveAccess(sala) || !sala.isActive())
                //salas.remove(sala);
                _remove.add(sala);

        }
        for(Sala _sala : _remove)
        {
            salas.remove(_sala);
        }
        out.println(getCalendar(request, paramRequest, locale));
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<thead>");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <th class=\"thCalHora\">Hora</td>");
        for(Sala sala:salas) {
            out.println("  <th class=\"thCalS_"+sala.getId()+"\"><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\""+sala.getDisplayTitle(lang)+" ("+sala.getCapacidad()+")\"\">"+sala.getDisplayTitle(lang)+"</a></td>");
        }
        out.println(" </tr>");
        out.println("</thead>");
        
        Calendar today = Calendar.getInstance();//auxiliar
        reset(today,START_HOUR,0);
        GregorianCalendar begin = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        begin.set(Calendar.MINUTE, START_MIN);
        GregorianCalendar end = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        end.set(Calendar.MINUTE, 449);
        
        ReservacionSala myReservation, raux=null;
        out.println("<tbody>");
        for(int i=START_MIN; i<=1260; i+=30) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+HHmm.format(today.getTime())+"</p></td>");
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    raux = myReservation;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            out.println(" <tr>");
            i+=30;
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    myReservation = null;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            today.add(Calendar.HOUR_OF_DAY, 1);
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<br class=\"clear\"/>");
        
//        if(current.get(Calendar.DAY_OF_YEAR)>=today.get(Calendar.DAY_OF_YEAR)) {
//            out.println(getScript(request, paramRequest, locale));
//            out.println(getForm(request, paramRequest, salas, locale));
//        }
        out.println("</div>");
//        out.println("<script type=\"text/javascript\">");
//        out.println("<!--");
//        out.println(" dojo.addOnLoad(function() {");
//        out.println(  request.getParameter("tpmeet")==null?"collapse('_tpcf_');":(request.getParameter("tpmeet").equals(ReservacionSala.TipoReunion.Interna.name())?"collapse('_tpcf_');":"expande('_tpcf_');")   );
//        out.println(  request.getParameter("tmsrvc")==null?"collapse('_tmsrvc_');":(request.getParameter("tmsrvc").equals(ReservacionSala.Horario.Durante.name())?"collapse('_tmsrvc_');":"expande('_tmsrvc_');")   );
//        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
//            out.println( "alert('"+request.getParameter("alertmsg")+"');");
//        }        
//        out.println(" });");
//        out.println("-->");
//        out.println("</script>");
    }
    
    private void reset(Calendar cal, int hour, int minute) {
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }
    
    private void reset(Calendar cal) {
        reset(cal, 0, 0);
    }
}
