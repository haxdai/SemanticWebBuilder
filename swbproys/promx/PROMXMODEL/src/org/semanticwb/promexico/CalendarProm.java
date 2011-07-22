package org.semanticwb.promexico;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.*;

public class CalendarProm extends org.semanticwb.promexico.base.CalendarPromBase 
{

    Logger log = SWBUtils.getLogger(CalendarProm.class);

    public CalendarProm()
    {
    }

   /**
   * Constructs a CalendarProm with a SemanticObject
   * @param base The SemanticObject with the properties for the CalendarProm
   */
    public CalendarProm(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        String path = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/calendar/viewGralCalendar.jsp";
        org.semanticwb.portal.resources.sem.calendar.Calendar cal = (org.semanticwb.portal.resources.sem.calendar.Calendar)getSemanticObject().createGenericInstance();
        if(cal.getJspView() != null) {
            if(cal.getJspView().indexOf(".jsp") > 0) {
                path = cal.getJspView();
                RequestDispatcher rd = request.getRequestDispatcher(path);
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    rd.include(request, response);
                } catch(Exception e) {
                    log.error(e);
                }
            } else {
                out.println("Method not implemented");
            }
        } else {
            out.println("Method not implemented");
        }
    }

    @Override
    public void doStrategy(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/calendar/listEvents.jsp";//"/swbadmin/jsp/calendar/listEvents.jsp";
        org.semanticwb.portal.resources.sem.calendar.Calendar cal = (org.semanticwb.portal.resources.sem.calendar.Calendar)getSemanticObject().createGenericInstance();
        if(cal.getJspStrategy() != null ) {
            if(cal.getJspStrategy().lastIndexOf(".jsp") > 0) {
                path = cal.getJspStrategy();
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }

    @Override
    public void doChangeCalendar(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        org.semanticwb.promexico.CalendarProm cal = (org.semanticwb.promexico.CalendarProm)getSemanticObject().createGenericInstance();
        //org.semanticwb.portal.resources.sem.calendar.Calendar cal = (org.semanticwb.portal.resources.sem.calendar.Calendar)getSemanticObject().createGenericInstance();//(org.semanticwb.portal.resources.sem.calendar.Calendar) base.getSemanticObject().createGenericInstance();
        String value = request.getParameter("month");
        int mont = 0, year=0;
        HashMap eventMonth = new HashMap();
        try {
            mont = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            log.error("Error while convert month in Calendar: " + e);
        }
        value = request.getParameter("year");
        try {
            year = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            log.error("Error while convert year in Calendar: " + e);
        }
        //boolean EventType.ClassMgr.listEventTypes(paramRequest.getWebPage().getWebSite());
        boolean isOnlyType = getEvtType() != null ? true : false;

        if(mont > 0 && year > 0) {
            Iterator ist=null;
            if(isOnlyType && getEvtType().toString().trim().length() > 1) {
                EventType type = (EventType) getEvtType();
                ist = Event.ClassMgr.listEventByEvType(type, paramRequest.getWebPage().getWebSite());
            } else {
                ist = Event.ClassMgr.listEvents(paramRequest.getWebPage().getWebSite());
            }
            //ist = cal.listEventses();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while(ist.hasNext()) {
                Event ev = (Event)ist.next();
                try {
                    if(ev.getEventInitDate() != null) {
                        int valueMonth=sdf.parse(ev.getEventInitDate()).getMonth()+1;
                        int valueYear = sdf.parse(ev.getEventInitDate()).getYear();
                        int year1 = (valueYear< 1000) ? valueYear + 1900 : valueYear;
                        int valueDay = sdf.parse(ev.getEventInitDate()).getDate();

                        boolean isYearly = (mont == valueMonth && ev.getPeriodicity().equals("yearly")) ? true : false;
                        int monthCurrent = java.util.Calendar.getInstance().MONTH + 1;
                        boolean isMonthly = ev.getPeriodicity().equals("monthly") && valueDay <= lastDayOfMonth(monthCurrent, year) ? true : false;//java.util.Calendar.getInstance().DAY_OF_MONTH == valueMonth ? true : false;
                        boolean isWeekly = ev.getPeriodicity().equals("weekly") ? true : false;
                        int valMonthEndEvt, valYearEndEvt, year2;
                        valMonthEndEvt = valYearEndEvt = year2 = 0;
                        if(ev.getEventEndDate() != null ) {
                            valMonthEndEvt = sdf.parse(ev.getEventEndDate()).getMonth()+1;
                        }
                        if(ev.getEventEndDate() != null) {
                            valYearEndEvt = sdf.parse(ev.getEventEndDate()).getYear();
                            year2 = (valYearEndEvt < 1000) ? valYearEndEvt + 1900 : valYearEndEvt;
                        }

                        if(((mont == valueMonth) && (year == year1)) || (isYearly && year >= year2) || (isMonthly && year >= year2 ) || (isWeekly && year >= year2)) {
                            ArrayList listEvents = new ArrayList();
                            if((!isWeekly && year <= year2 && mont <= valMonthEndEvt && mont >= valueMonth && year >= year1) || (!isWeekly && mont >= valueMonth && year >= year1 && ev.getEventEndDate() == null)) {
                                if(eventMonth.containsKey(valueDay)) {
                                    listEvents = (ArrayList)eventMonth.get(valueDay);
                                    listEvents.add(ev);
                                    eventMonth.remove(valueDay);
                                } else {
                                    listEvents.add(ev);
                                }
                                eventMonth.put(valueDay, listEvents);
                            } else if((year <= year2 && mont <= valMonthEndEvt && mont >= valueMonth) || (mont >= valueMonth && year >= year1 && ev.getEventEndDate() == null)) {
                                ArrayList week = getWeekly(ev, mont-1, year);
                                Iterator it = week.iterator();
                                while(it.hasNext()) {
                                    int day = Integer.parseInt(it.next().toString());
                                    if(eventMonth.containsKey(day)) {
                                        listEvents = (ArrayList)eventMonth.get(day);
                                        listEvents.add(ev);
                                        eventMonth.remove(day);
                                    } else {
                                        listEvents.add(ev);
                                    }
                                    eventMonth.put(day, listEvents);
                                }
                            }

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
                JSONObject getEv = getEvents(eventos, paramRequest, cal);
                objEventMonth.put(day, getEv);
            } catch(Exception e1) {
                log.error("Error while build the events for day: " + e1);
            }
        }
        out.print(objEventMonth);
    }

    private int lastDayOfMonth(int month,int year) {
        int day = 0;
        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                if((year % 4 == 0)||((year % 100 == 0) && (year % 400 == 0))) {
                    day = 29;
                } else {
                    day = 28;
                }
        }
        return day;
    }

    private JSONObject getEvents(ArrayList Events,SWBParamRequest paramRequest, org.semanticwb.portal.resources.sem.calendar.Calendar cal)
    {
        JSONObject objJSONEvents = new JSONObject();
        Iterator it = Events.iterator();
        while(it.hasNext()) {
            Event event = (Event)it.next();
            if(paramRequest.getUser().haveAccess(event))
            {
                try {
                    objJSONEvents.put(SWBUtils.TEXT.encode(event.getTitle(paramRequest.getUser().getLanguage())==null?event.getTitle():event.getTitle(paramRequest.getUser().getLanguage()), SWBUtils.TEXT.CHARSET_UTF8), getData(event, paramRequest, cal)); //SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8)
                }catch(Exception e) {
                    log.error("Error while build properties in Events: "+e);
                }
            }
        }
        return objJSONEvents;
    }

    private ArrayList getWeekly(Event event, int month, int year){
        ArrayList daysWeekly = new ArrayList();
        int dayInEvt, dayInMonth = 0;
        if(event.getPeriodicity().equals("weekly")) {
            try {
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                dayInEvt =  sdf1.parse(event.getEventInitDate()).getDay();
                int daysMonthSel = lastDayOfMonth(month + 1, year);
                Date date = new Date();
                date.setMonth(month);
                date.setDate(1);
                date.setYear(year);
                dayInMonth =  date.getDay();
                int yearInEvt = sdf1.parse(event.getEventInitDate()).getYear() + 1900;

                if((month >= sdf1.parse(event.getEventInitDate()).getMonth() && yearInEvt == year) || (year > yearInEvt)) {
                    for(int i = 1; i <= daysMonthSel; i++) {
                        Date date1 = new Date();
                        date1.setDate(i);
                        date1.setMonth(month);
                        date1.setYear(year-1900);
                        if((month == sdf1.parse(event.getEventInitDate()).getMonth() && date1.getDate() >= sdf1.parse(event.getEventInitDate()).getDate() && date1.getDay() == dayInEvt) || (month > sdf1.parse(event.getEventInitDate()).getMonth() && date1.getDay() == dayInEvt)) {
                            if(event.getEventEndDate() != null) {
                                if((month == sdf1.parse(event.getEventEndDate()).getMonth() && date1.getDate() <= sdf1.parse(event.getEventEndDate()).getDate()) || month < sdf1.parse(event.getEventEndDate()).getMonth()) {
                                    daysWeekly.add(i);
                                    i = i + 5;
                                }
                            } else {
                                daysWeekly.add(i);
                            }
                        }
                    }
                }
            } catch(Exception e) {
                log.error("Error in getWeekly: " + e);
            }
        }
        return daysWeekly;
    }

    private JSONObject getData(Event event,SWBParamRequest paramRequest, org.semanticwb.portal.resources.sem.calendar.Calendar cal)
    {
        JSONObject objJSONData = new JSONObject();
        String url, photo, target;
        photo = url= target = "";
        if(event.getUrlExternal() != null) {
            url = event.getUrlExternal();
        } else if(event.isUrlInternal()) {
            WebPage wp;
            if(cal.getIdPage() != null) {
                wp = paramRequest.getWebPage().getWebSite().getWebPage(cal.getIdPage());
                if(wp != null && wp.isActive()) {
                   url = wp.getUrl() + "?id=" + event.getId();
                }
            }
        }
        if(event.isNewWindow()) {
            target = "_black";
        }
        if(event.getImage() != null && event.getImage().trim().length() > 0) {
             photo= SWBPortal.getWebWorkPath()+event.getWorkPath()+"/"+event.getImage();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

        if(event.getPeriodicity().equals("yearly")) {
            sd = new SimpleDateFormat("dd/MM");
        }
        String dates = "";
        if(!event.getPeriodicity().equals("weekly") && !event.getPeriodicity().equals("monthly")) {
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

    @Override
    public void doEvent(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Method not implemented");
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Method not implemented");
    }

    @Override
    public void doPagination(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Method not implemented");
    }

}
