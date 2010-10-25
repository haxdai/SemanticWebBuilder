package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.RateSeason;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author carlos.ramos
 */
public class SeasonManager extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(PromotionManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = "";

        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }

        String siteUri = ((MicroSitePyme) community).getType().getURI();

        if(MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
            path = "/work/models/etour/jsp/pymestur/microsite/spSeasons.jsp";
        }else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            path = "/work/models/etour/jsp/pymestur/premier/spSeasons.jsp";
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException  {
        Resource base = getResourceBase();
        String action=response.getAction();

        if(action.equalsIgnoreCase("add_low_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try {
                SemanticObject sobj = mgr.processForm(request);
                RateSeason season = (RateSeason) sobj.createGenericInstance();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = request.getParameter("datei");
                    Date di = sdf.parse(date);
                    season.setSeasonStartDate(di);

                    date = request.getParameter("datef");
                    Date df = sdf.parse(date);
                    season.setSeasonEndDate(df);
                }catch(ParseException pe) {
                    log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                }
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                if(checkDates(serviceProv,request,"low"))
                {
                    serviceProv.addRateLowSeason(season);
                    serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
                    response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                }else
                {
                      response.setRenderParameter("messDates", "Las fechas se encuentran traslapadas y  no se ha podido guardar los datos");
                }
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equalsIgnoreCase("add_high_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    RateSeason season = (RateSeason) sobj.createGenericInstance();
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = request.getParameter("datei");
                        Date di = sdf.parse(date);
                        season.setSeasonStartDate(di);

                        date = request.getParameter("datef");
                        Date df = sdf.parse(date);
                        season.setSeasonEndDate(df);
                    }catch(ParseException pe) {
                        log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                    }
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    if(checkDates(serviceProv, request, "high"))
                    {
                        serviceProv.addRateHighSeason(season);
                        serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    }else
                    {
                        response.setRenderParameter("messDates", "Las fechas se encuentran traslapadas y  no se ha podido guardar los datos");
                    }
                }catch(Exception e){
                    log.error(e);
                }
        }
        else if(action.equalsIgnoreCase("edit_seasonHigh")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
            ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
            try {
                SemanticObject sobj = mgr.processForm(request);
                RateSeason rseason = (RateSeason) sobj.createGenericInstance();
                if(checkDates(serviceProv, request, "high"))
                {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = request.getParameter("datei");
                        Date di = sdf.parse(date);
                        rseason.setSeasonStartDate(di);
                        date = request.getParameter("datef");
                        Date df = sdf.parse(date);
                        rseason.setSeasonEndDate(df);
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    }catch(ParseException pe) {
                        log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                    }
                }else
                {
                    response.setRenderParameter("messDates", "Las fechas se encuentran traslapadas y  no se ha podido guardar los datos");
                }
                serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
            }catch(Exception e){
                log.error(e);
            }
        }
        else if(action.equalsIgnoreCase("edit_seasonLow")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
            ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
             try {
                SemanticObject sobj = mgr.processForm(request);
                RateSeason rseason = (RateSeason) sobj.createGenericInstance();
                if(checkDates(serviceProv, request, "low"))
                {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = request.getParameter("datei");
                        Date di = sdf.parse(date);
                        rseason.setSeasonStartDate(di);

                        date = request.getParameter("datef");
                        Date df = sdf.parse(date);
                        rseason.setSeasonEndDate(df);
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    }catch(ParseException pe) {
                        log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                    }
                }else
                {
                    response.setRenderParameter("messDates", "Las fechas se encuentran traslapadas y  no se ha podido guardar los datos");
                }
                serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
            }catch(Exception e){
                log.error(e);
            }
        }
        else if(action.equalsIgnoreCase("remove_low_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            RateSeason rseason = (RateSeason) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeRateLowSeason(rseason);
            semObject.remove();
        }
        else if(action.equalsIgnoreCase("remove_high_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            RateSeason rseason = (RateSeason) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeRateHighSeason(rseason);
            semObject.remove();
        }
         else if(action.equalsIgnoreCase("edit_cmnt")) {
             SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
             ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
             serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
         }
    }
    private boolean checkDates(ServiceProvider sprovider,HttpServletRequest request,String rate)
    {
        Iterator sp1;
        if("low".equals(rate))
        {
            sp1 = sprovider.listRateLowSeasons();
        }else
        {
            sp1 = sprovider.listRateHighSeasons();
        }
        boolean valid = true;
        String datei = request.getParameter("datei");

        String datef = request.getParameter("datef");
        if(datei==null||datef==null)
        {
            valid = false;
        }else{
            int year1 = Integer.parseInt(datei.substring(0,4));
            int year2 = Integer.parseInt(datef.substring(0,4));
            Date date1 = new Date(year1,Integer.parseInt(datei.substring(5,7))-1,Integer.parseInt(datei.substring(8,10)));
            date1.setYear(year1-1900);
            Date date2 = new Date(year2,Integer.parseInt(datef.substring(5,7))-1,Integer.parseInt(datef.substring(8,10)));
            date2.setYear(year2-1900);
            if(date1.getTime()>date2.getTime())
            {
                valid = false;
            }else{
                while(sp1.hasNext())
                {
                    RateSeason season = (RateSeason) sp1.next();
                    if(date1.getTime()>season.getSeasonStartDate().getTime())
                    {
                        if(date1.getTime()<=season.getSeasonEndDate().getTime())
                        {
                            valid = false;
                        }
                    }
                    else if(date1.getTime()==season.getSeasonStartDate().getTime())
                    {
                            valid = false;
                    }else
                    {
                        if(date2.getTime()>=season.getSeasonStartDate().getTime())
                        {
                            valid = false;
                        }
                    }
                }
            }
        }
        return valid;
    }
}