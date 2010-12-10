package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.RateSeason;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.pymtur.util.PymturUtils;

/**
 *
 * @author carlos.ramos
 */
public class SeasonManager extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(PromotionManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId();
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = "";
        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }
        String siteUri = ((MicroSitePyme) community).getType().getURI();
        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
            path = siteWorkDir + "/jsp/pymestur/microsite/spSeasons.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            path = siteWorkDir + "/jsp/pymestur/premier/spSeasons.jsp";
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
        if(action!=null&&action.equalsIgnoreCase("add_low_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try {
                SemanticObject sobj = mgr.processForm(request);
                response.setAction("addNewLowSeason");
                String date1 = request.getParameter("datei");
                if(date1!=null){
                    if(!PymturUtils.validateRegExp(date1, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatei", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                String date2 = request.getParameter("datef");
                if(date2!=null){
                    if(!PymturUtils.validateRegExp(date2, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatef", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date di = sdf.parse(date1);
                    Date df = sdf.parse(date2);
                    if(checkDates(serviceProv,null,di,df)){
                        RateSeason season = (RateSeason) sobj.createGenericInstance();
                        season.setSeasonStartDate(di);
                        season.setSeasonEndDate(df);
                        serviceProv.addRateLowSeason(season);
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    } else {
                        response.setRenderParameter("messDates", "Verifica que la fecha inicial sea menor a la fecha final y que las fechas no se encuentren traslapadas");
                        return;
                    }
                }catch(ParseException pe) {
                    log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                }
            }catch(Exception e){
                log.error(e);
            }
            response.setAction(SWBResourceURL.Mode_VIEW);
        }else if(action!=null&&action.equalsIgnoreCase("add_high_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(RateSeason.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try {
                SemanticObject sobj = mgr.processForm(request);
                response.setAction("addNewHighSeason");
                String date1 = request.getParameter("datei");
                if(date1!=null){
                    if(!PymturUtils.validateRegExp(date1, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatei", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                String date2 = request.getParameter("datef");
                if(date2!=null){
                    if(!PymturUtils.validateRegExp(date2, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatef", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date di = sdf.parse(date1);
                    Date df = sdf.parse(date2);
                    if(checkDates(serviceProv, null,di,df)){
                        RateSeason season = (RateSeason) sobj.createGenericInstance();
                        season.setSeasonStartDate(di);
                        season.setSeasonEndDate(df);
                        serviceProv.addRateHighSeason(season);
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    } else {
                        response.setRenderParameter("messDates", "Verifica que la fecha inicial sea menor a la fecha final y que las fechas no se encuentren traslapadas");
                        return;
                    }
                }catch(ParseException pe) {
                    log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                }
            }catch(Exception e){
                log.error(e);
            }
            response.setAction(SWBResourceURL.Mode_VIEW);
        }else if(action!=null&&action.equalsIgnoreCase("edit_seasonHigh")) {
            try {
                response.setAction("editSeasonHigh");
                String date1 = request.getParameter("datei");
                if(date1!=null){
                    if(!PymturUtils.validateRegExp(date1, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatei", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                String date2 = request.getParameter("datef");
                if(date2!=null){
                    if(!PymturUtils.validateRegExp(date2, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatef", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
                SemanticObject objReason = SemanticObject.createSemanticObject(request.getParameter("uri"));
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                RateSeason rseason = (RateSeason)objReason.createGenericInstance();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date di = sdf.parse(date1);
                    Date df = sdf.parse(date2);
                    if(checkDates(serviceProv, rseason,di,df)){
                        rseason.setSeasonStartDate(di);
                        rseason.setSeasonEndDate(df);
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    } else {
                        response.setRenderParameter("messDates", "Verifica que la fecha inicial sea menor a la fecha final y que las fechas no se encuentren traslapadas");
                    }
                }catch(ParseException pe) {
                    log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                }
            }catch(Exception e){
                log.error(e);
            }
            response.setAction(SWBResourceURL.Mode_VIEW);
        }
        else if(action!=null&&action.equalsIgnoreCase("edit_seasonLow")) {
             try {
                response.setAction("editSeasonLow");
                String date1 = request.getParameter("datei");
                if(date1!=null){
                    if(!PymturUtils.validateRegExp(date1, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatei", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                String date2 = request.getParameter("datef");
                if(date2!=null){
                    if(!PymturUtils.validateRegExp(date2, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")){
                        response.setRenderParameter("msgErrDatef", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                        return;
                    }
                }
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
                SemanticObject objReason = SemanticObject.createSemanticObject(request.getParameter("uri"));
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                RateSeason rseason = (RateSeason)objReason.createGenericInstance();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date di = sdf.parse(date1);
                    Date df = sdf.parse(date2);
                    if(checkDates(serviceProv, rseason,di,df)){
                        rseason.setSeasonStartDate(di);
                        rseason.setSeasonEndDate(df);
                        response.setRenderParameter("messDates", "Se han guardado satisfactoriamente los datos");
                    } else {
                        response.setRenderParameter("messDates", "Verifica que la fecha inicial sea menor a la fecha final y que las fechas no se encuentren traslapadas");
                        return;
                    }
                }catch(ParseException pe) {
                    log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                }
            }catch(Exception e){
                log.error(e);
            }
             response.setAction(SWBResourceURL.Mode_VIEW);
        }
        else if(action!=null&&action.equalsIgnoreCase("remove_low_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            RateSeason rseason = (RateSeason) semObject.createGenericInstance();
            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();
            serviceProv.removeRateLowSeason(rseason);
            semObject.remove();
        }
        else if(action!=null&&action.equalsIgnoreCase("remove_high_season")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            RateSeason rseason = (RateSeason) semObject.createGenericInstance();
            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();
            serviceProv.removeRateHighSeason(rseason);
            semObject.remove();
        }
         else if(action!=null&&action.equalsIgnoreCase("edit_cmnt")) {
            response.setAction("editCmnt");
            String comment = request.getParameter("rtcmt");
            if(comment!=null) {
                int descLength=1200+PymturUtils.countEnterChars(comment,1200);
                if( !PymturUtils.validateRegExp(comment, "^([^(<>&%#)]{0,"+descLength+"})$")) {
                    response.setRenderParameter("msgErrCommenSeason", "Verifica que el tamaño del texto no exceda los 1200 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                serviceProv.setSpRatesComments(comment);
            }
            response.setAction(SWBResourceURL.Mode_VIEW);
         }
    }
    private boolean checkDates(ServiceProvider sprovider,RateSeason current, Date datei, Date datef)
    {
        Iterator sp1 = sprovider.listRateLowSeasons();
        ArrayList temp = new ArrayList();
        while(sp1.hasNext()) {
            temp.add(sp1.next());
        }
        sp1 = sprovider.listRateHighSeasons();
        while(sp1.hasNext()) {
            temp.add(sp1.next());
        }
        sp1 = temp.iterator();
        temp = new ArrayList();
        if(current!=null) {
            while(sp1.hasNext()) {
                RateSeason rateCurrent =  (RateSeason)sp1.next();
                if(!rateCurrent.equals(current)) {
                    temp.add(rateCurrent);
                }
            }
            sp1 = temp.iterator();
        }
        boolean valid = true;
        try {
            if(datei.getTime()>datef.getTime()) {
                valid = false;
            }else {
                while(sp1.hasNext()) {
                    RateSeason season = (RateSeason) sp1.next();
                    if(datei.getTime()>season.getSeasonStartDate().getTime()) {
                        if(datei.getTime()<=season.getSeasonEndDate().getTime()) {
                            valid = false;
                        }
                    }
                    else if(datei.getTime()==season.getSeasonStartDate().getTime()) {
                            valid = false;
                    } else {
                        if(datef.getTime()>=season.getSeasonStartDate().getTime()) {
                            valid = false;
                        }
                    }
                }
            }
        }catch(Exception e) {
            log.error(e);
        }
        return valid;
    }
}