package mx.gob.stps.portalempleo.swb.resources;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.*;
import mx.gob.stps.portalempleo.swb.Event;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBResourceURL;

public class EventCalendar extends mx.gob.stps.portalempleo.swb.resources.base.EventCalendarBase {
    
    public enum MonthOfYear {
        enero("Enero"),
        febrero("Febrero"),
        marzo("Marzo"),
        abril("Abril"),
        mayo("Mayo"),
        junio("Junio"),
        julio("Julio"),
        agosto("Agosto"),
        septiembre("Septiembre"),
        octubre("Octubre"),
        noviembre("Noviembre"),
        diciembre("Diciembre");
        private String description;
        MonthOfYear(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
        public MonthOfYear previus() {
            switch(this) {
                case enero:
                    return enero;
                case febrero:
                    return enero;
                case marzo:
                    return febrero;
                case abril:
                    return marzo;
                case mayo:
                    return abril;
                case junio:
                    return mayo;
                case julio:
                    return junio;
                case agosto:
                    return julio;
                case septiembre:
                    return agosto;
                case octubre:
                    return septiembre;
                case noviembre:
                    return octubre;
                case diciembre:
                    return noviembre;
                default:
                    return null;
            }
        }
        public MonthOfYear next() {
            switch(this) {
                case enero:
                    return febrero;
                case febrero:
                    return marzo;
                case marzo:
                    return abril;
                case abril:
                    return mayo;
                case mayo:
                    return junio;
                case junio:
                    return julio;
                case julio:
                    return agosto;
                case agosto:
                    return septiembre;
                case septiembre:
                    return octubre;
                case octubre:
                    return noviembre;
                case noviembre:
                    return diciembre;
                case diciembre:
                    return diciembre;
                default:
                    return null;
            }
        }
        public boolean hasNext() {
            switch(this) {
                case diciembre:
                    return false;
                default:
                    return true;
            }
        }
        public static MonthOfYear valueOf(int value) throws IllegalArgumentException {
            switch(value) {
                case 0: return enero;
                case 1: return febrero;
                case 2: return marzo;
                case 3: return abril;
                case 4: return mayo;
                case 5: return junio;
                case 6: return julio;
                case 7: return agosto;
                case 8: return septiembre;
                case 9: return octubre;
                case 10: return noviembre;
                case 11: return diciembre;
                default: return null;
            }
        }
    }


    private List<Event> events;
    private static Logger log = SWBUtils.getLogger(EventCalendar.class);

    public EventCalendar()
    {
    }

   /**
   * Constructs a EventCalendar with a SemanticObject
   * @param base The SemanticObject with the properties for the EventCalendar
   */
    public EventCalendar(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

//    @Override
//    public void setResourceBase(Resource base) {
//        try {
//            super.setResourceBase(base);
//
//            Iterator<Event> itevents = Event.ClassMgr.listEvents(base.getWebSite());
//            events = SWBUtils.Collections.copyIterator(itevents);
//            Collections.sort(events, new Event.EventSortByExpiration());
//            System.out.println("total de eventos ya ordenados="+events.size());
//        }catch(Exception e) {
//            log.error(e);
//        }
//    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals("roll"))
            doRoll(request, response, paramRequest);
        else if(paramRequest.getMode().equals("vall"))
            doViewAll(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException  {
        PrintWriter out=response.getWriter();

        Iterator<Event> itevents = Event.ClassMgr.listEvents(paramRequest.getWebPage().getWebSite());
        events = SWBUtils.Collections.copyIterator(itevents);
        Collections.sort(events, new Event.EventSortByExpiration());

        Locale locale = new Locale("es","MX");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM",locale);
        GregorianCalendar gc = new GregorianCalendar(locale);
        boolean hasAhead=false, hasBehind=false;

        MonthOfYear moy;
        if(request.getParameter("m")==null) {
            try {
                moy = MonthOfYear.valueOf(sdf.format(gc.getTime()).toLowerCase());
            }catch(IllegalArgumentException e) {
                e.printStackTrace(System.out);
                moy = MonthOfYear.enero;
            }
        }else {
            try {
                moy = MonthOfYear.valueOf(Integer.parseInt(request.getParameter("m")));
                if(moy.ordinal()<gc.get(Calendar.MONTH))
                    hasBehind = false;
                else
                    hasBehind = true;
            }catch(NumberFormatException e) {
                e.printStackTrace(System.out);
                moy = MonthOfYear.enero;
            }
        }
        int m = moy.ordinal();

        gc = new GregorianCalendar(gc.get(Calendar.YEAR),m,1,0,0,0);
        Date di = gc.getTime();
        gc = new GregorianCalendar(gc.get(Calendar.YEAR),m,gc.getActualMaximum(Calendar.DAY_OF_MONTH),23,59,59);
        Date df = gc.getTime();
        //int i=0;
        ArrayList<Event> eventsOnMonth  = new ArrayList();
        for(int i=0,j=0; i<3 && j<events.size(); j++) {
            Event event = events.get(j);
            Date expiration = event.getExpiration();
            if(expiration.before(di)) {
                continue;
            }else {
                try {
                    while(i<3 && i<events.size() && event.getExpiration().after(di) && event.getExpiration().before(df)) {
                        eventsOnMonth.add(event);
                        i++;
                        event = events.get(i);
                    }
                    if(event.getExpiration().after(df))
                        hasAhead = true;
                    else
                        hasAhead = false;
                    break;
                }catch(IndexOutOfBoundsException iobe) {
                    hasAhead = false;
                }
            }
        }

        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.require('dijit.dijit');");
        out.println("-->");
        out.println("</script>");
        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode("roll");
        out.println("<div id=\"calendario_eventos\">");
        out.println(" <div id=\"mes\">");
        out.println("  <h3>"+moy.getDescription()+"</h3>");
        if(hasBehind) {
            url.setParameter("m", Integer.toString(moy.previus().ordinal()));
            out.println(" <a id=\"mes_anterior\" href=\"#\" onclick=\"postHtml('"+url+"','calendario_eventos')\">mes anterior</a>");
        }
        if(hasAhead) {
            url.setParameter("m", Integer.toString(moy.next().ordinal()));
            out.println(" <a id=\"mes_siguiente\" href=\"#\" onclick=\"postHtml('"+url+"','calendario_eventos')\">mes siguiente</a>");
        }
        out.println(" </div>");

        sdf = new SimpleDateFormat("dd",locale);
        itevents=eventsOnMonth.iterator();
        while(itevents.hasNext()) {
            Event event = itevents.next();
            out.println(" <div>");
            out.println("  <span class=\"dia_calendario\">"+sdf.format(event.getExpiration())+"</span><p><a href=\""+event.getRealUrl()+"\">"+event.getTitle()+"</a></p>");
            out.println(" </div>");
        }
        //url.setMode("vall").setCallMethod(paramRequest.Call_CONTENT);
        out.println("</div>");

        url.setCallMethod(paramRequest.Call_CONTENT).setMode("vall");
        out.println("<div class=\"bottom_calendario\">");
        out.println(" <a style=\"float: right; margin: 10px 20px 0pt 0pt;\" href=\""+url+"\" class=\"links\">ver todos los eventos</a>");
        out.println("</div>");
    }

    public void doRoll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException  {
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out=response.getWriter();

        Iterator<Event> itevents = Event.ClassMgr.listEvents(paramRequest.getWebPage().getWebSite());
        events = SWBUtils.Collections.copyIterator(itevents);
        Collections.sort(events, new Event.EventSortByExpiration());

        Locale locale = new Locale("es","MX");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM",locale);
        GregorianCalendar gc = new GregorianCalendar(locale);
        boolean hasAhead=false, hasBehind=false;

        MonthOfYear moy;
        if(request.getParameter("m")==null) {
            try {
                moy = MonthOfYear.valueOf(sdf.format(gc.getTime()).toLowerCase());
            }catch(IllegalArgumentException e) {
                e.printStackTrace(System.out);
                moy = MonthOfYear.enero;
            }
        }else {
            try {
                moy = MonthOfYear.valueOf(Integer.parseInt(request.getParameter("m")));
                if(moy.ordinal()<gc.get(Calendar.MONTH))
                    hasBehind = false;
                else
                    hasBehind = true;
            }catch(NumberFormatException e) {
                e.printStackTrace(System.out);
                moy = MonthOfYear.enero;
            }
        }
        int m = moy.ordinal();

        gc = new GregorianCalendar(gc.get(Calendar.YEAR),m,1,0,0,0);
        Date di = gc.getTime();
        gc = new GregorianCalendar(gc.get(Calendar.YEAR),m,gc.getActualMaximum(Calendar.DAY_OF_MONTH),23,59,59);
        Date df = gc.getTime();
        //int i=0;
        ArrayList<Event> eventsOnMonth  = new ArrayList();
        for(int i=0,j=0; i<3 && j<events.size(); j++) {
            Event event = events.get(j);
            Date expiration = event.getExpiration();
            if(expiration.before(di)) {
                continue;
            }else {
                try {
                    while(i<3 && i<events.size() && event.getExpiration().after(di) && event.getExpiration().before(df)) {
                        eventsOnMonth.add(event);
                        i++;
                        event = events.get(i);
                    }
                    if(event.getExpiration().after(df))
                        hasAhead = true;
                    else
                        hasAhead = false;
                    break;
                }catch(IndexOutOfBoundsException iobe) {
                    hasAhead = false;
                }
            }
        }

        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.require('dijit.dijit');");
        out.println("-->");
        out.println("</script>");
        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode("roll");
//        out.println("<div id=\"calendario_eventos\">");
        out.println(" <div id=\"mes\">");
        out.println("  <h3>"+moy.getDescription()+"</h3>");
        if(hasBehind) {
            url.setParameter("m", Integer.toString(moy.previus().ordinal()));
            out.println(" <a id=\"mes_anterior\" href=\"#\" onclick=\"postHtml('"+url+"','calendario_eventos')\">mes anterior</a>");
        }
        if(hasAhead) {
            url.setParameter("m", Integer.toString(moy.next().ordinal()));
            out.println(" <a id=\"mes_siguiente\" href=\"#\" onclick=\"postHtml('"+url+"','calendario_eventos')\">mes siguiente</a>");
        }
        out.println(" </div>");

        sdf = new SimpleDateFormat("dd",locale);
        itevents=eventsOnMonth.iterator();
        while(itevents.hasNext()) {
            Event event = itevents.next();
            out.println(" <div>");
            out.println("  <span class=\"dia_calendario\">"+sdf.format(event.getExpiration())+"</span><p><a href=\""+event.getRealUrl()+"\">"+event.getTitle()+"</a></p>");
            out.println(" </div>");
        }
//        out.println("</div>");
//        url.setMode("vall").setCallMethod(paramRequest.Call_CONTENT);
//        out.println("<div class=\"bottom_calendario\">");
//        out.println(" <a style=\"float: right; margin: 10px 20px 0pt 0pt;\" href=\""+url+"\" class=\"links\">ver todos los eventos</a>");
//        out.println("</div>");
    }

    public void doViewAll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException  {
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();

        Locale locale = new Locale("es","MX");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy",locale);

        Iterator<Event> itevents = Event.ClassMgr.listEvents(paramRequest.getWebPage().getWebSite());
        events = SWBUtils.Collections.copyIterator(itevents);
        Collections.sort(events, new Event.EventSortByExpiration());
        itevents = events.iterator();
        if(itevents.hasNext()) {
            out.println("<ul>");
            while(itevents.hasNext()) {
                Event event = itevents.next();
                out.println("<li>");
                out.println("<p><a href=\""+event.getRealUrl()+"\">"+event.getTitle()+"</a></p>");
                out.println("<p>"+event.getDescription()+"</p>");
                out.println("<p>"+sdf.format(event.getExpiration())+"</p>");
                out.println("</li>");
            }
            out.println("</ul>");
        }
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(paramRequest.Mode_VIEW);
        out.println("<a href=\""+url+"\" title=\"Regresar\">Regresar</a>");
    }
}
