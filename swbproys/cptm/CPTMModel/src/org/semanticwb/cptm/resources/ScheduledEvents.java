/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.Event;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author martha.jimenez
 */
public class ScheduledEvents extends GenericResource{

    public static Logger log = SWBUtils.getLogger(ScheduledEvents.class);
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/scheduledEvents.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        }catch(Exception e)
        {
            log.error(e);
        }

    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals("change"))
        {
            doChangeCalendar(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doChangeCalendar(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        WebPage wp = paramRequest.getWebPage();
        String value = request.getParameter("month");
        int mont = 0, year=0;
        HashMap eventMonth = new HashMap();
        try{
            mont = Integer.parseInt(value);
        }catch(NumberFormatException e)
        {
            log.error("Error while convert month in ScheduledEvents: " + e);
        }
        value = request.getParameter("year");
        try
        {
            year = Integer.parseInt(value);
        }catch(NumberFormatException e)
        {
            log.error("Error while convert year in ScheduledEvents: " + e);
        }
        if(mont>0&&year>0)
        {
             Iterator ist = Event.ClassMgr.listEvents(wp.getWebSite());
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             while(ist.hasNext())
             {
                 Event ev = (Event)ist.next();
                 try
                 {
                     if(ev.getEventInitDate()!=null){
                         int valueMonth=sdf.parse(ev.getEventInitDate()).getMonth()+1;
                         int valueYear = sdf.parse(ev.getEventInitDate()).getYear();
                         int year1 = (valueYear< 1000) ? valueYear + 1900 : valueYear;
                         int valueDay = sdf.parse(ev.getEventInitDate()).getDate();
                         if((mont==valueMonth)&&(year==year1))
                         {
                             ArrayList listEvents = new ArrayList();
                             if(eventMonth.containsKey(valueDay))
                             {
                                 listEvents = (ArrayList)eventMonth.get(valueDay);
                                 listEvents.add(ev);
                                 eventMonth.remove(valueDay);
                             } else {
                                 listEvents.add(ev);
                             }
                              eventMonth.put(valueDay, listEvents);
                         }
                     }
                 }catch(Exception e)
                 {
                     log.error("Error while process events in ScheduledEvents" + e);
                 }
             }
        }
        JSONObject objEventMonth = new JSONObject();
        Iterator it = eventMonth.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry e = (Map.Entry)it.next();
            String day = e.getKey().toString();
            ArrayList eventos = (ArrayList)e.getValue();
            try
            {
                JSONObject getEv = getEvents(eventos,paramRequest);
                objEventMonth.put(day, getEv); 
            }catch(Exception e1)
            {
                log.error("Error while build the events for day: " + e1);
            }
        }
        out.print(objEventMonth);
    }

    private JSONObject getEvents(ArrayList Events,SWBParamRequest paramRequest)
    {
        JSONObject objJSONEvents = new JSONObject();
        Iterator it = Events.iterator();
        while(it.hasNext())
        {
            Event event = (Event)it.next();
            try
            {
                objJSONEvents.put(SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8), getData(event, paramRequest));
            }catch(Exception e)
            {
                log.error("Error while build properties in Events: "+e);
            }
        }
        return objJSONEvents;
    }

    private JSONObject getData(Event event,SWBParamRequest paramRequest)
    {
        JSONObject objJSONData = new JSONObject();
        String url = "#";
        WebPage wp = paramRequest.getWebPage().getWebSite().getWebPage("Mostrar_Evento");
        if(wp!=null){
           url = wp.getUrl()+"?id=" + event.getId()+"&show=event";
        }
        String photo = "";
        if(event.getPhotoEscudo()!=null)
        {
             photo=SWBPortal.getWebWorkPath()+event.getWorkPath()+"/"+event.cptm_photoEscudo.getName()+"_"+event.getId()+"_"+event.getPhotoEscudo();
        }
        try{
            objJSONData.put("url", url);
            objJSONData.put("title", SWBUtils.TEXT.encode(event.getTitle(paramRequest.getUser().getLanguage())==null?event.getTitle():event.getTitle(paramRequest.getUser().getLanguage()), SWBUtils.TEXT.CHARSET_UTF8));
            objJSONData.put("image", photo);
            objJSONData.put("description", SWBUtils.TEXT.encode(event.getDescription()==null?"":event.getDescription(), SWBUtils.TEXT.CHARSET_UTF8));

        }catch(Exception e)
        {
            log.error("Error while add the properties to Events: " + e);
        }
        return objJSONData;
    }
}
