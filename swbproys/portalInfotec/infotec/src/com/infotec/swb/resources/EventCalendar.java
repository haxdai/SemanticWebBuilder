package com.infotec.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

public class EventCalendar extends GenericResource {
    private static Logger log = SWBUtils.getLogger(EventCalendar.class);

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
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

GregorianCalendar gc = new GregorianCalendar();
gc.setTime(null);
gc.add(GregorianCalendar.SECOND, 86399);




        if (paramRequest.getCallMethod() == paramRequest.Call_CONTENT)
        {
            doViewAll(request, response, paramRequest);
        }
        else if (paramRequest.getCallMethod() == paramRequest.Call_STRATEGY)
        {
            try
        {
            String jsp = SWBPortal.getContextPath()+"/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/eventos/view.jsp";
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

    public void doRoll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try
        {
            String jsp = SWBPortal.getContextPath()+"/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/eventos/roll.jsp";
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void doViewAll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try
        {
            String jsp = SWBPortal.getContextPath()+"/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/eventos/eventos.jsp";
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


    public static class EventSortByExpiration implements Comparator<WebPage>{
        @Override
        public int compare(WebPage event1, WebPage event2) {
            return event1.getExpiration().compareTo( event2.getExpiration() );
        }
    }
}
