package mx.gob.stps.portalempleo.swb;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.http.*;
import mx.gob.stps.portalempleo.swb.Month.MonthOfYear;
import mx.gob.stps.portalempleo.swb.resources.Event;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class EventManager extends mx.gob.stps.portalempleo.swb.base.EventManagerBase {
    private static Logger log = SWBUtils.getLogger(EventManager.class);

    public EventManager()
    {
    }

   /**
   * Constructs a EventManager with a SemanticObject
   * @param base The SemanticObject with the properties for the EventManager
   */
    public EventManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();

        if(wp instanceof Month) {
            Month month = (Month)wp;
            Iterator<Event> events = month.listEvents();
            boolean hasEvents = events.hasNext();
            if(hasEvents) {
                out.println("<div class=\"\">");
                out.println("<ul class=\"\">");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", new Locale("es","MX"));
            while(events.hasNext()) {
                Event event = events.next();
                out.println("<li class=\"\"><div class=\"\">"+event.getTitle()+"</div>");
                out.println("<div class=\"\">"+event.getDescription()+"</div>");
                out.println("<div class=\"\">"+sdf.format(event.getExpiration())+"</div></li>");
            }
            if(hasEvents) {
                out.println("</ul>");
                out.println("</div>");
            }

//            final String modelId = wp.getWebSiteId();
//            RequestDispatcher dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/event/list.jsp");
//            request.setAttribute("paramRequest", paramRequest);
//            try {
//                dis.include(request, response);
//            }catch (Exception e) {
//                log.error(e);
//            }
//            String action = paramRequest.getAction();
//            if(paramRequest.Action_ADD.equals(action)) {
//                dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/event/add.jsp");
//                try {
//                    dis.include(request, response);
//                }catch (Exception e) {
//                    log.error(e);
//                }
//            }else {
//                out.println("<a href=\""+paramRequest.getRenderUrl().setAction(paramRequest.Action_ADD)+"\">agregar evento</a>");
//            }
        }else {
            SimpleDateFormat m = new SimpleDateFormat("MMMM", new Locale("es","MX"));
            SimpleDateFormat y = new SimpleDateFormat("yyyy", new Locale("es","MX"));
            GregorianCalendar gc = new GregorianCalendar(new Locale("es","MX"));

            try {
                Year year = Year.ClassMgr.getYear(y.format(gc.getTime()), model);
                if(year!=null) {
System.out.println("year="+year.getId());
System.out.println("mes="+m.format(gc.getTime()).toLowerCase());
                    MonthOfYear moy = MonthOfYear.valueOf(m.format(gc.getTime()).toLowerCase());
System.out.println("month id="+moy.getDescription()+"_"+year.getId());
                    Month month = Month.ClassMgr.getMonth(moy.getDescription()+"_"+year.getId(), model);
                    if(month!=null) {
                        out.println("<p>el mes es "+moy.getDescription()+" "+moy.ordinal()+"</p>");
                        Iterator<Event> events = month.listEvents();
                        boolean hasEvents = events.hasNext();
                        if(hasEvents) {
System.out.println("hay eventos");
                            out.println("<div class=\"\">");
                            out.println("<ul class=\"\">");
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", new Locale("es","MX"));
                        while(events.hasNext()) {
                            Event event = events.next();
                            out.println("<li class=\"\"><div class=\"\">"+event.getTitle()+"</div>");
                            out.println("<div class=\"\">"+event.getDescription()+"</div>");
                            out.println("<div class=\"\">"+sdf.format(event.getExpiration())+"</div></li>");
                        }
                        if(hasEvents) {
                            out.println("</ul>");
                            out.println("</div>");
                        }
                    }
                }
            }catch(IllegalArgumentException iae) {
                log.error(iae);
                iae.printStackTrace(System.out);
            }
        }
    }

}
