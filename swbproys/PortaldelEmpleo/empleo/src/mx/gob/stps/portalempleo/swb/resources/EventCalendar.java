package mx.gob.stps.portalempleo.swb.resources;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.*;

public class EventCalendar extends mx.gob.stps.portalempleo.swb.resources.base.EventCalendarBase
{

    private static Logger log = SWBUtils.getLogger(EventCalendar.class);

    

    

    //private List<Event> events;
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
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equals("roll"))
            doRoll(request, response, paramRequest);
        else if (paramRequest.getMode().equals("vall"))
            doViewAll(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getCallMethod() == paramRequest.Call_CONTENT)
        {
            doViewAll(request, response, paramRequest);
        }
        else if (paramRequest.getCallMethod() == paramRequest.Call_STRATEGY)
        {
            try
        {
            String jsp = "/swbadmin/jsp/empleo/eventos/view.jsp";
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
        }
    }

    public void doRoll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        try
        {
            String jsp = "/swbadmin/jsp/empleo/eventos/roll.jsp";
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void doViewAll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        try
        {
            String jsp = "/swbadmin/jsp/empleo/eventos/eventos.jsp";
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
        /*response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();

        Locale locale = new Locale("es","MX");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy",locale);

        Iterator<Event> itevents = Event.ClassMgr.listEvents(paramRequest.getWebPage().getWebSite());
        List<Event> events = SWBUtils.Collections.copyIterator(itevents);
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
        out.println("<a name=\"a_"+base.getId()+"\" href=\""+url+"#a_"+base.getId()+"\" title=\"Regresar\">Regresar</a>");*/
    }
}
