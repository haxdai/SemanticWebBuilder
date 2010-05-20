package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
                serviceProv.addRateLowSeason(season);
                serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
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
                    serviceProv.addRateHighSeason(season);
                    serviceProv.setSpRatesComments(request.getParameter("rtcmt")==null?"":request.getParameter("rtcmt"));
                }catch(Exception e){
                    log.error(e);
                }
        }
        else if(action.equalsIgnoreCase("edit_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try {
                SemanticObject sobj = mgr.processForm(request);
                RateSeason rseason = (RateSeason) sobj.createGenericInstance();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = request.getParameter("datei");
                    Date di = sdf.parse(date);
                    rseason.setSeasonStartDate(di);

                    date = request.getParameter("datef");
                    Date df = sdf.parse(date);
                    rseason.setSeasonEndDate(df);
                }catch(ParseException pe) {
                    log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                }
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
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
}