/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.semanticwb.cptm.GeographicPoint;
import org.semanticwb.cptm.State;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }

    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/adminScheduledEvents.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if(action.equals("adm")) {
            Resource base = response.getResourceBase();
            String ly = request.getParameter("lastYear");
            String ny = request.getParameter("nextYear");
            Document doc = null;
            try {
                doc = SWBUtils.XML.getNewDocument();
                Element root = doc.createElement("YearsScheduledEvents");
                doc.appendChild(root);
                Date date = new Date();
                int yc = (date.getYear()< 1000) ? date.getYear() + 1900 : date.getYear();
                Element lyear = doc.createElement("LastYear");
                root.appendChild(lyear);
                if(ly!=null) {
                    lyear.setTextContent("" + (yc-1));
                }
                Element nyear = doc.createElement("NextYear");
                root.appendChild(nyear);
                if(ny!=null) {
                    nyear.setTextContent("" + (yc+1));
                }
                base.setData(SWBUtils.XML.domToXml(doc));
            } catch (Exception e) {
                throw new SWBResourceException("Error al generar el documento XML de YearScheduledEvents", e);
            }
        }
        response.setMode(response.Mode_ADMIN);
    }


    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals("change")) {
            doChangeCalendar(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doChangeCalendar(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        WebPage wp = paramRequest.getWebPage();
        User user = paramRequest.getUser();
        String value = request.getParameter("month");
        int mont = 0, year=0;
        HashMap eventMonth = new HashMap();
        try {
            mont = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            log.error("Error while convert month in ScheduledEvents: " + e);
        }
        value = request.getParameter("year");
        try {
            year = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            log.error("Error while convert year in ScheduledEvents: " + e);
        }
        value = request.getParameter("uri");
        if(mont > 0 && year > 0) {
            Iterator ist=null;
            if(value.equals("")) {
                 ist = Event.ClassMgr.listEvents(wp.getWebSite());
            } else {
                SemanticObject obj = SemanticObject.createSemanticObject(value);
                State state = (State) obj.createGenericInstance();
                ArrayList allDest = new ArrayList();
                Iterator itState =state.listEventStateInvs();
                while(itState.hasNext()) {
                    allDest.add(itState.next());
                }
                itState = state.listVisibleChilds(user.getLanguage());
                while(itState.hasNext()) {
                    WebPage chSta = (WebPage)itState.next();
                    if(chSta.getSemanticObject().getSemanticClass().getName().equals("GeographicPoint")) {
                        GeographicPoint point = (GeographicPoint) chSta;
                        ist = point.listEventGeographicPointInvs();
                        while(ist.hasNext()) {
                            allDest.add(ist.next());
                        }
                    }
                }
                ist=allDest.iterator();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while(ist.hasNext()) {
                Event ev = (Event)ist.next();
                try {
                    if(ev.getEventInitDate() != null) {
                        int valueMonth=sdf.parse(ev.getEventInitDate()).getMonth()+1;
                        int valueYear = sdf.parse(ev.getEventInitDate()).getYear();
                        int year1 = (valueYear< 1000) ? valueYear + 1900 : valueYear;
                        int valueDay = sdf.parse(ev.getEventInitDate()).getDate();
                        boolean isPeriodic = ev.isIsRepeatable();
                        if(((mont == valueMonth) && (year == year1))||((mont == valueMonth) && (isPeriodic))) {
                            ArrayList listEvents = new ArrayList();
                            if(eventMonth.containsKey(valueDay)) {
                                listEvents = (ArrayList)eventMonth.get(valueDay);
                                listEvents.add(ev);
                                eventMonth.remove(valueDay);
                            } else {
                                listEvents.add(ev);
                            }
                            eventMonth.put(valueDay, listEvents);
                        } 
                    }
                } catch(Exception e) {
                    log.error("Error while process events in ScheduledEvents" + e);
                }
            }
        }

        JSONObject objEventMonth = new JSONObject();
        Iterator it = eventMonth.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            String day = e.getKey().toString();
            ArrayList eventos = (ArrayList)e.getValue();
            try {
                JSONObject getEv = getEvents(eventos,paramRequest);
                objEventMonth.put(day, getEv); 
            } catch(Exception e1) {
                log.error("Error while build the events for day: " + e1);
            }
        }
        out.print(objEventMonth);
    }

    private JSONObject getEvents(ArrayList Events,SWBParamRequest paramRequest)
    {
        JSONObject objJSONEvents = new JSONObject();
        Iterator it = Events.iterator();
        while(it.hasNext()) {
            Event event = (Event)it.next();
            if(paramRequest.getUser().haveAccess(event))
            {
                try {
                    objJSONEvents.put(SWBUtils.TEXT.encode(event.getTitle(paramRequest.getUser().getLanguage())==null?event.getTitle():event.getTitle(paramRequest.getUser().getLanguage()), SWBUtils.TEXT.CHARSET_UTF8), getData(event, paramRequest)); //SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8)
                }catch(Exception e) {
                    log.error("Error while build properties in Events: "+e);
                }
            }
        }
        return objJSONEvents;
    }

    private JSONObject getData(Event event,SWBParamRequest paramRequest)
    {
        JSONObject objJSONData = new JSONObject();
        String url = "", target = "";
        WebPage wp;
        if(!event.isEventIsWithoutLink()) {
            if(event.getEventURL() != null && event.getEventURL().trim().length() > 1) {
                url = event.getEventURL();
                target = "_blank";
            } else if(event.getEventInternalURL() != null && event.getEventInternalURL().trim().length() > 1) {
                wp = paramRequest.getWebPage().getWebSite().getWebPage(event.getEventInternalURL());
                url = wp.getUrl(paramRequest.getUser().getLanguage());
            } else {
                wp = paramRequest.getWebPage().getWebSite().getWebPage("Mostrar_Evento");
                if(wp == null) {
                    wp = paramRequest.getWebPage().getWebSite().getWebPage("Mostrar-Evento");
                }
                if(wp!=null) {
                   url = wp.getUrl()+"?id=" + event.getId()+"&show=event";
                }
            }
        }
        String photo = "";
        if(event.getPhotoEscudo()!=null) {
             photo=SWBPortal.getWebWorkPath()+event.getWorkPath()+"/"+event.cptm_photoEscudo.getName()+"_"+event.getId()+"_"+event.getPhotoEscudo();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        if(event.isIsRepeatable()) {
            sd = new SimpleDateFormat("dd/MM");
        }
        String dates = "";
        if(event.getEventInitDate() != null && event.getEventInitDate().length() > 1) {
            try{
                Date ds = sdf.parse(event.getEventInitDate());
                dates = dates + sd.format(ds);
            }catch(Exception e)
            {
            }
        }
        if(event.getEventEndDate() != null && event.getEventEndDate().length() > 1) {
            try {
                Date de = sdf.parse(event.getEventEndDate());
                if(dates.length()>1) {
                    dates = dates + " - ";
                }
                dates = dates +sd.format(de);
            } catch(Exception e) {
            }
        }
        try {
            objJSONData.put("target", target);
            objJSONData.put("url", url);
            objJSONData.put("title", SWBUtils.TEXT.encode(event.getTitle(paramRequest.getUser().getLanguage())==null?event.getTitle():event.getTitle(paramRequest.getUser().getLanguage()), SWBUtils.TEXT.CHARSET_UTF8));
            objJSONData.put("image", photo);
            String descr = "";
            if(event.getDescription(paramRequest.getUser().getLanguage()) != null) {
                descr = SWBUtils.TEXT.encode(event.getDescription(paramRequest.getUser().getLanguage()),SWBUtils.TEXT.CHARSET_UTF8);
            } else if(event.getDescription() != null) {
                descr = SWBUtils.TEXT.encode(event.getDescription(),SWBUtils.TEXT.CHARSET_UTF8);
            }
            objJSONData.put("description", descr);
            objJSONData.put("rdates", dates);
        } catch(Exception e) {
            log.error("Error while add the properties to Events: " + e);
        }
        return objJSONData;
    }
}