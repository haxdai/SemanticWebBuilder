/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico.resources;

import java.io.IOException;
//import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.SWBUtils.Collections;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.resources.sem.genericCalendar.EventType;
import org.semanticwb.promexico.Event;
import org.semanticwb.promexico.Office;
import org.semanticwb.promexico.Region;
import org.semanticwb.promexico.Sector;

/**
 *
 * @author martha.jimenez
 */
public class FilterEvents extends GenericAdmResource{

    Logger log = SWBUtils.getLogger(FilterEvents.class);

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals("redir")){
            doRedir(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/filterEvents.jsp" ;
        WebSite ws = paramRequest.getWebPage().getWebSite();
        Iterator<EventType> listEvtType = EventType.ClassMgr.listEventTypes(ws);
        Iterator<Sector> listSector = Sector.ClassMgr.listSectors(ws);
        Iterator<Region> listRegion = Region.ClassMgr.listRegions(ws);
        ArrayList listRegs = new ArrayList();
        ArrayList listSectrs = new ArrayList();
        while(listRegion.hasNext()){
            listRegs.add(listRegion.next());
        }
        while(listSector.hasNext()){
            Sector sct1 = listSector.next();
            Iterator tmp = Event.ClassMgr.listEventBySectores(sct1, ws);
            if(tmp.hasNext()) {
                listSectrs.add(sct1);
            }
        }
        String evType = request.getParameter(EventType.genCal_EventType.getName());
        String sec = request.getParameter(Sector.promx_Sector.getName());
        String reg = request.getParameter(Region.promx_Region.getName());
        String yr = request.getParameter("selectYear");
        String showData = "1";
        if(evType == null && sec == null && reg == null && yr == null) {
            showData = "0";
        }

        RequestDispatcher rd = request.getRequestDispatcher(path);

        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("typ", evType);
            request.setAttribute("sec", sec);
            request.setAttribute("yr", yr);
            request.setAttribute("showData", showData);
            request.setAttribute("regT", reg);
            request.setAttribute("lEvtType", listEvtType);
            request.setAttribute("lRegion", listRegs);
            request.setAttribute("lSector", listSectrs.iterator());
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }

    public void doRedir(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        WebPage wpRedi = paramRequest.getWebPage().getWebSite().getWebPage("showSearchEvents");
        String typ = request.getParameter(EventType.genCal_EventType.getName());
        String reg = "";
        String sec = "";
        String yr = "";
        if(typ != null && !typ.equals("Eventos_Nacionales1")) {
            reg = request.getParameter(Region.promx_Region.getName());
            sec = request.getParameter(Sector.promx_Sector.getName());
        }
        yr = request.getParameter("selectYear");
        boolean isFirst = true;
        String url2 = wpRedi.getUrl();
        String url2a = wpRedi.getUrl();

        if(typ != null && typ.trim().length() > 1) {
            if(isFirst) {
                url2 = url2 + "?typ=" + typ;
                isFirst = false;
            }
        }
        if(reg != null && reg.trim().length() > 1) {
            String letter = isFirst ? "?" : "&";
            if(isFirst) {
                isFirst = false;
            }
            url2 = url2 + letter + "regT=" + reg;
        }
        if(sec != null && sec.trim().length() > 1) {
            String letter = isFirst ? "?" : "&";
            if(isFirst) {
                isFirst = false;
            }
            url2 = url2 + letter + "sec=" + sec;
        }
        if(yr != null && yr.trim().length() > 1) {
            String letter = isFirst ? "?" : "&";
            if(isFirst) {
                isFirst = false;
            }
            url2 = url2 + letter + "yr=" + yr;
        }
        if(url2.equals(url2a)) {
            url2 = url2 + "?sv=false";
        }
        response.sendRedirect(url2);
    }
    public static Iterator filterEvts(String evType, String sec, String reg, String yr, WebSite ws) {
        List allEvts = new ArrayList();
        if(evType != null || sec != null || reg != null || yr != null) {
            Iterator it;
            if(evType != null && evType.trim().length() > 1) {
                EventType evtT = EventType.ClassMgr.getEventType(evType, ws);
                it = Event.ClassMgr.listEventByEvType(evtT);
            } else {
                it = Event.ClassMgr.listEvents(ws);
            }
            while(it.hasNext()) {
                allEvts.add(it.next());
            }
            if(sec != null && sec.trim().length() > 1) {
                Sector sector = Sector.ClassMgr.getSector(sec, ws);
                it = allEvts.iterator();
                allEvts = new ArrayList();
                while(it.hasNext()) {
                    Event event = (Event) it.next();
                    Iterator itSectors = event.listSectoreses();
                    List sectors = new ArrayList();
                    if(itSectors.hasNext()) {
                        sectors = Collections.copyIterator(itSectors);
                        if(!sectors.isEmpty() && sectors.contains(sector)) {
                            allEvts.add(event);
                        }
                    }
                }
            }
            /*if(allEvts != null && !allEvts.isEmpty()) {
                it = allEvts.iterator();
            }*/
            if(reg != null && reg.trim().length() > 1) {
                Region region = Region.ClassMgr.getRegion(reg, ws);
                Iterator<Office> offices = Office.ClassMgr.listOfficeByParent(region, ws);
                List offiByRegion = new ArrayList();
                if(offices.hasNext()) {
                    offiByRegion = Collections.copyIterator(offices);
                }
                it = allEvts.iterator();
                allEvts = new ArrayList();
                if(!offiByRegion.isEmpty()) {
                    while(it.hasNext()) {
                        Event event = (Event)it.next();
                        Iterator itOffice = event.listOffices();

                        while(itOffice.hasNext()){
                            Office of = (Office)itOffice.next();
                            if(offiByRegion.contains(of)) {
                                allEvts.add(event);
                                break;
                            }
                        }
                    }
                }
            }
            if(yr != null && yr.trim().length() > 1) {
                it = allEvts.iterator();
                allEvts = new ArrayList();
                while(it.hasNext()) {
                    Event evtTemp = (Event)it.next();
                    SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date ds = null;
                    int yearEvt = 0;
                    int yrAux = Integer.parseInt(yr);
                    if(yrAux > 0 && (evtTemp.getEventInitDate() != null && evtTemp.getEventInitDate().trim().length() > 1)) {
                        try {
                            ds = sd1.parse(evtTemp.getEventInitDate());
                            yearEvt = ds.getYear() + 1900;
                            if(yrAux == yearEvt) {
                                allEvts.add(evtTemp);
                            }
                        } catch(Exception e){
                            System.out.println("Exception in method filterEvts, convert to date" + e);
                        }
                    }
                }
            }
            if(allEvts != null && !allEvts.isEmpty()) {
                it = allEvts.iterator();
            }
        }
        return allEvts.iterator();
    }

}
