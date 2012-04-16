package org.semanticwb.promexico.resources;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.resources.sem.genericCalendar.EventType;
import org.semanticwb.portal.resources.sem.genericCalendar.ResourceCalendar;
import org.semanticwb.promexico.Event;
import org.semanticwb.promexico.Sector;
import org.semanticwb.promexico.Training;
import org.semanticwb.promexico.TrainingType;
import org.semanticwb.promexico.TrainingTypeCalendar;

public class ProMxResourceCalendar extends org.semanticwb.promexico.resources.base.ProMxResourceCalendarBase 
{

    Logger log = SWBUtils.getLogger(ProMxResourceCalendar.class);

    public ProMxResourceCalendar()
    {
    }

   /**
   * Constructs a ProMxResourceCalendar with a SemanticObject
   * @param base The SemanticObject with the properties for the ProMxResourceCalendar
   */
    public ProMxResourceCalendar(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        User user = paramRequest.getUser();
        HashMap eventMonth = new HashMap();
        HashMap traiMonth = new HashMap();
        java.util.Calendar now = Calendar.getInstance();
        int monthP = request.getParameter("mP") == null ? now.get(Calendar.MONTH) + 1 : Integer.parseInt(request.getParameter("mP")+"");
        int yearP = request.getParameter("yP") == null ? now.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("yP")+"");

        int minYear = now.get(Calendar.YEAR);
        int maxYear = minYear;
        if (isPreviousYear()) {
            minYear = minYear - 1;
        }
        if (isNextYear()) {
            maxYear = maxYear + 1;
        }
        if (yearP > maxYear) {
            yearP = maxYear;
        }
        if(yearP < minYear) {
            yearP = minYear;
        }

        if(request.getParameter("chYear") != null && request.getParameter("chYear").equals("1")) {
            if(request.getParameter("monthP") != null && request.getParameter("menuSelectYear") != null) {
                monthP = Integer.parseInt(request.getParameter("monthP"));
                yearP = Integer.parseInt(request.getParameter("menuSelectYear"));
            }
        }

        WebSite ws  = paramRequest.getWebPage().getWebSite();
        if(monthP > 0 && yearP > 0) {
            Iterator ist = null;
            Iterator ist2 = null;
            Iterator istEvts = EventType.ClassMgr.listEventTypes(ws);// listEvtTypes();
            Iterator istTraining = TrainingTypeCalendar.ClassMgr.listTrainingTypeCalendars(ws);//TrainingType.ClassMgr.listTrainingTypes();// listCalTrainingTypes();

            if(istEvts.hasNext() && istTraining.hasNext()) {
                ist = getListEvtsType(istEvts, ws);
                ist2 = getListTrainingType(istTraining, ws);
            } else if(istEvts.hasNext()) {
                ist = getListEvtsType(istEvts, ws);
            } else if(istTraining.hasNext()) {
                ist2 = getListTrainingType(istTraining, ws);
            } else {
                ist = Event.ClassMgr.listEvents(ws);
                ist2 = Training.ClassMgr.listTrainings(ws);
            }

            if(ist != null) {
                eventMonth = getHashMapListEvts(ist, user, monthP, yearP);
            }
            if(ist2 != null) {
                traiMonth = getHashMapListTraining(ist2, user, monthP, yearP);
            }
        }


        String path = "/swbadmin/jsp/genericCalendar/viewGralCalendar.jsp";
        if(getJspView() != null) {
            if(getJspView().indexOf(".jsp") > 0) {
                path = getJspView();
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("eventMonth", eventMonth);
            request.setAttribute("traiMonth", traiMonth);
            request.setAttribute("mP", monthP);
            request.setAttribute("yP", yearP);
            request.setAttribute("nextYear", isNextYear());
            request.setAttribute("prevYear", isPreviousYear());
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
        ProMxResourceCalendar cal = (ProMxResourceCalendar)getSemanticObject().createGenericInstance();
        WebSite ws = paramRequest.getWebPage().getWebSite();
        User user = paramRequest.getUser();
        String value = request.getParameter("month");
        int mont = 0, year=0;
        HashMap eventMonth = new HashMap();
        HashMap traiMonth = new HashMap();
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

        if(mont > 0 && year > 0) {
            Iterator ist = null;
            Iterator ist2 = null;
            Iterator istEvts = listEvtTypes();
            Iterator istTraining = listCalTrainingTypes();

            if(istEvts.hasNext() && istTraining.hasNext()) {
                ist = getListEvtsType(istEvts, ws);
                ist2 = getListTrainingType(istTraining, ws);
            } else if(istEvts.hasNext()) {
                ist = getListEvtsType(istEvts, ws);
            } else if(istTraining.hasNext()) {
                ist2 = getListTrainingType(istTraining, ws);
            } else {
                ist = Event.ClassMgr.listEvents(ws);
                ist2 = Training.ClassMgr.listTrainings(ws);
            }
            
            if(ist != null) {
                eventMonth = getHashMapListEvts(ist, user, mont, year);
            }
            /*---Lectura de Capacitaciones---*/
            if(ist2 != null) {
                traiMonth = getHashMapListTraining(ist2, user, mont, year);
            /*-------------------------------*/
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
        /* --Capacitaciones-- */
            it = traiMonth.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                String day = e.getKey().toString();
                ArrayList training = (ArrayList)e.getValue();
                try {
                    JSONObject getEv = null;
                    if(objEventMonth.has(day)) {
                         getEv = (JSONObject)objEventMonth.get(day);
                         objEventMonth.remove(day);
                    }
                    JSONObject train = getTraining(training, paramRequest, cal, getEv);
                    objEventMonth.put(day, train);

                } catch(Exception e1) {
                    log.error("Error while build the events for day: " + e1);
                }
            }
            /*--------------------------------*/
            out.print(objEventMonth);
        }
    }

    private HashMap getHashMapListTraining(Iterator ist2, User user, int mont, int year) {
        HashMap traiMonth = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while(ist2.hasNext()) {
            Training training = (Training)ist2.next();
            if(user.haveAccess(training)) {
                try {
                    if(training.getTraInitDate() != null) {
                        int valueMonth=sdf.parse(training.getTraInitDate()).getMonth()+1;
                        int valueYear = sdf.parse(training.getTraInitDate()).getYear();
                        int year1 = (valueYear< 1000) ? valueYear + 1900 : valueYear;
                        int valueDay = sdf.parse(training.getTraInitDate()).getDate();

                        if((mont == valueMonth) && (year == year1)) {
                            ArrayList listTraining = new ArrayList();
                            if(traiMonth.containsKey(valueDay)) {
                                listTraining = (ArrayList)traiMonth.get(valueDay);
                                listTraining.add(training);
                                traiMonth.remove(valueDay);
                            } else {
                                listTraining.add(training);
                            }
                            traiMonth.put(valueDay, listTraining);
                        }
                    }
                } catch(Exception e) {
                    log.error("Error while process events in ScheduledEvents" + e);
                }
            }
        }
        return traiMonth;
    }

    private HashMap getHashMapListEvts(Iterator ist, User user, int mont, int year) {
        HashMap eventMonth = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while(ist.hasNext()) {
            Event ev = (Event)ist.next();
            if(user.haveAccess(ev)) {
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
        return eventMonth;
    }

    private Iterator getListEvtsType (Iterator<EventType> istEvts, WebSite site) {
        ArrayList allList = new ArrayList();
        while(istEvts.hasNext()) {
            EventType type =  (EventType)istEvts.next();
            Iterator ist = Event.ClassMgr.listEventByEvType(type, site);
            while(ist.hasNext()) {
                allList.add(ist.next());
            }
        }
        return allList.iterator();
    }

    private Iterator getListTrainingType(Iterator<TrainingTypeCalendar> istTraining, WebSite site){
        ArrayList allList = new ArrayList();
        while(istTraining.hasNext()) {
            Object obj = istTraining.next();
            if(obj instanceof TrainingTypeCalendar)
            {
                TrainingTypeCalendar type =  (TrainingTypeCalendar)obj;
                Iterator ist2 = Training.ClassMgr.listTrainingByTraTypeCalendar(type, site);//listTrainingByTraType(type, site);
                while(ist2.hasNext()) {
                    allList.add(ist2.next());
                }
            } else if(obj instanceof TrainingType) {
                TrainingType type =  (TrainingType)obj;
                type.remove();
            }
        }
        return allList.iterator();
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

    private JSONObject getEvents(ArrayList Events,SWBParamRequest paramRequest, ResourceCalendar cal)
    {
        JSONObject objJSONEvents = new JSONObject();
        Iterator it = Events.iterator();
        while(it.hasNext()) {
            Event event = (Event)it.next();
            try {
                objJSONEvents.put(event.getTitle(paramRequest.getUser().getLanguage())==null?event.getTitle():event.getTitle(paramRequest.getUser().getLanguage()), getData(event, paramRequest, cal)); //SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8)
//                objJSONEvents.put(SWBUtils.TEXT.encode(event.getTitle(paramRequest.getUser().getLanguage())==null?event.getTitle():event.getTitle(paramRequest.getUser().getLanguage()), SWBUtils.TEXT.CHARSET_UTF8), getData(event, paramRequest, cal)); //SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8)
            }catch(Exception e) {
                log.error("Error while build properties in Events: " + e);
            }
        }
        try {
            objJSONEvents.put("color", "event");
        }  catch (Exception e) {
            log.error("Error while build properties in Events: " + e);
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

    private JSONObject getData(Event event,SWBParamRequest paramRequest, ResourceCalendar cal)
    {
        JSONObject objJSONData = new JSONObject();
        User user = paramRequest.getUser();
        String url, photo, target;
        photo = url= target = "";
        if(event.getUrlExternal() != null) {
            url = event.getUrlExternal();
        } else if(event.isUrlInternal()) {
            WebPage wp;
            if(cal.getIdPage() != null) {
                wp = paramRequest.getWebPage().getWebSite().getWebPage(cal.getIdPage());
                if(wp != null && wp.isActive()) {
                   url = wp.getUrl() + "?id=" + event.getId()+"&show=event";
                }
            }
        }
        if(event.isNewWindow()) {
            target = "_black";
        }
        if(event.getTooltipImage() != null && event.getTooltipImage().trim().length() > 0) {
             photo= SWBPortal.getWebWorkPath() + event.getWorkPath() + "/" + Event.genCal_tooltipImage.getName() +
                     "_" + event.getId() + "_" +event.getTooltipImage();
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
        String evtType = (event.getEvType() == null) ? "" : (event.getEvType().getTitle(user.getLanguage()) == null ? (event.getEvType().getTitle() == null ? "" : event.getEvType().getTitle()) : event.getEvType().getTitle(user.getLanguage()));
        Iterator<Sector> itSec = event.listSectoreses();
        String sector = "";
        while(itSec.hasNext()) {
            Sector sec = itSec.next();
            String nameSec = sec.getDisplayName(user.getLanguage()) == null ? (sec.getDisplayName() == null ? "" : sec.getDisplayName()) : sec.getDisplayName(user.getLanguage());
            String n = sector.trim().length() > 1 ? ", ": "";
            /*try {
                nameSec = SWBUtils.TEXT.encode(nameSec, SWBUtils.TEXT.CHARSET_UTF8);
            } catch(Exception e) {
            }*/
            sector = sector + n + nameSec;
        }
        try {
            objJSONData.put("target", target);
            objJSONData.put("url", url);
            objJSONData.put("title", event.getTitle(user.getLanguage()) == null ? event.getTitle() : event.getTitle(user.getLanguage()));
//            objJSONData.put("title", SWBUtils.TEXT.encode(event.getTitle(user.getLanguage()) == null ? event.getTitle() : event.getTitle(user.getLanguage()), SWBUtils.TEXT.CHARSET_UTF8));
            objJSONData.put("image", photo);
            String descr = "";
            if(event.getDescription(user.getLanguage()) != null) {
                descr = event.getDescription(user.getLanguage());
 //               descr = SWBUtils.TEXT.encode(event.getDescription(user.getLanguage()),SWBUtils.TEXT.CHARSET_UTF8);
            } else if(event.getDescription() != null) {
                descr = event.getDescription();
//                descr = SWBUtils.TEXT.encode(event.getDescription(),SWBUtils.TEXT.CHARSET_UTF8);
            }
            objJSONData.put("description", descr);
            objJSONData.put("rdates", dates);
            objJSONData.put("evtType", evtType);
            objJSONData.put("sector", sector);
        } catch(Exception e) {
            log.error("Error while add the properties to Events: " + e);
        }
        return objJSONData;
    }

    private JSONObject getTraining(ArrayList traing,SWBParamRequest paramRequest, ResourceCalendar cal, JSONObject getAllEvts)
    {
        String color = "both";
        if(getAllEvts == null) {
            getAllEvts = new JSONObject();
            color = "training";
        }
        Iterator<Training> it = traing.iterator();
        while(it.hasNext()) {
            Training tr = it.next();
            try {
                getAllEvts.put(tr.getTitle(paramRequest.getUser().getLanguage()) == null ? tr.getTitle() : tr.getTitle(paramRequest.getUser().getLanguage()), getDataTrai(tr, paramRequest, cal)); //SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8)
//                getAllEvts.put(SWBUtils.TEXT.encode(tr.getTitle(paramRequest.getUser().getLanguage()) == null ? tr.getTitle() : tr.getTitle(paramRequest.getUser().getLanguage()), SWBUtils.TEXT.CHARSET_UTF8), getDataTrai(tr, paramRequest, cal)); //SWBUtils.TEXT.encode(event.getTitle(),SWBUtils.TEXT.CHARSET_UTF8)
            }catch(Exception e) {
                log.error("Error while build properties in Events: "+e);
            }
        }
        try {
            getAllEvts.put("color", color);
        }catch(Exception e) {
            log.error("Error while build properties in Events: "+e);
        }
        return getAllEvts;
    }

    private JSONObject getDataTrai(Training train,SWBParamRequest paramRequest, ResourceCalendar cal)
    {
        JSONObject objJSONData = new JSONObject();
        User user = paramRequest.getUser();
        String url, photo, target;
        photo = url= target = "";
        if(train.getTraExternalUrl() != null) {
            url = train.getTraExternalUrl();
        } else  {
            WebPage wp;
            if(cal.getIdPage() != null) {
                wp = paramRequest.getWebPage().getWebSite().getWebPage(cal.getIdPage());
                if(wp != null && wp.isActive()) {
                   url = wp.getUrl() + "?id=" + train.getId()+"&show=training";
                }
            }
        }
        if(train.isTraOpenInNewWindow()) {
            target = "_black";
        }
        if(train.getTraPhoto() != null && train.getTraPhoto().trim().length() > 0) {
             photo= SWBPortal.getWebWorkPath() + train.getWorkPath() + "/" + Training.promx_traPhoto.getName() +
                     "_" + train.getId() + "_" + train.getTraPhoto();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

        String dates = "";
       if(train.getTraInitDate() != null && train.getTraInitDate().length() > 1) {
            try{
                Date ds = sdf.parse(train.getTraInitDate());
                dates = dates + sd.format(ds);
            }catch(Exception e)
            {
            }
        }

        if(train.getTraEndDate() != null && train.getTraEndDate().length() > 1) {
            try {
                Date de = sdf.parse(train.getTraEndDate());
                if(dates.length()>1) {
                    dates = dates + " - ";
                }
                dates = dates +sd.format(de);
            } catch(Exception e) {
            }
        }
        String trainingEvt = (train.getTraType() == null) ? "" : (train.getTraType().getTitle(user.getLanguage()) == null ? (train.getTraType().getTitle() == null ? "" : train.getTraType().getTitle()) : train.getTraType().getTitle(user.getLanguage()));
        String trainingTypeEvt = (train.getTraTypeCalendar() == null) ? "" : (train.getTraTypeCalendar().getTitle(user.getLanguage()) == null ? (train.getTraTypeCalendar().getTitle() == null ? "" : train.getTraTypeCalendar().getTitle()) : train.getTraTypeCalendar().getTitle(user.getLanguage()));
        Iterator<Sector> itSec = train.listTraSectoreses();
        String sector = "";
        while(itSec.hasNext()) {
            Sector sec = itSec.next();
            String nameSec = sec.getDisplayName(user.getLanguage()) == null ? (sec.getDisplayName() == null ? "" : sec.getDisplayName()) : sec.getDisplayName(user.getLanguage());
            String n = sector.trim().length() > 1 ? ", ": "";
            /*try {
                nameSec = SWBUtils.TEXT.encode(nameSec, SWBUtils.TEXT.CHARSET_UTF8);
            } catch(Exception e) {
            }*/
            sector = sector + n + nameSec;
        }
        try {
            objJSONData.put("target", target);
            objJSONData.put("url", url);
            objJSONData.put("title", train.getTitle(user.getLanguage()) == null ? train.getTitle() : train.getTitle(user.getLanguage()));
//            objJSONData.put("title", SWBUtils.TEXT.encode(train.getTitle(user.getLanguage()) == null ? train.getTitle() : train.getTitle(user.getLanguage()), SWBUtils.TEXT.CHARSET_UTF8));
            objJSONData.put("image", photo);
            String descr = "";
            if(train.getDescription(user.getLanguage()) != null) {
                descr = train.getDescription(user.getLanguage());
//                descr = SWBUtils.TEXT.encode(train.getDescription(user.getLanguage()),SWBUtils.TEXT.CHARSET_UTF8);
            } else if(train.getDescription() != null) {
                descr = train.getDescription();
//                descr = SWBUtils.TEXT.encode(train.getDescription(),SWBUtils.TEXT.CHARSET_UTF8);
            }
            objJSONData.put("description", descr);
            objJSONData.put("rdates", dates);
            objJSONData.put("trainingEvt", trainingEvt);
            objJSONData.put("trainingTypeEvt", trainingTypeEvt);
            objJSONData.put("sector", sector);
        } catch(Exception e) {
            log.error("Error while add the properties to Events: " + e);
        }
        return objJSONData;
    }


}
