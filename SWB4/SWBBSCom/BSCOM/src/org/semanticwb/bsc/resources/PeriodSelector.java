package org.semanticwb.bsc.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.base.util.URLEncoder;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 * Muestra la interface para que el usuario seleccione el período deseado a fin de visualizar la información.
 * @author Jose.Jimenez
 */
public class PeriodSelector extends GenericResource {
    
    public static final String Action_CHANGE_PERIOD = "changep";
    
    private Period getNearestPeriod(final List<Period> periods) {
        final User user = SWBContext.getSessionUser(getResourceBase().getWebSite().getUserRepository().getId());
        
        GregorianCalendar left;
        GregorianCalendar right;        
        GregorianCalendar current = new GregorianCalendar(TimeZone.getDefault(),
                new Locale(user.getLanguage() == null ? "es" : user.getLanguage(),
                user.getCountry() == null ? "MX" : user.getCountry()));
        for (Period period : periods) {
            left = new GregorianCalendar();
            left.setTime(period.getStart());
            right = new GregorianCalendar();
            
            Calendar calEnd = new GregorianCalendar();
            calEnd.setTime(period.getEnd());
            calEnd.set(Calendar.HOUR, 23);
            calEnd.set(Calendar.MINUTE, 59);
            calEnd.set(Calendar.SECOND, 59);
            right.setTime(calEnd.getTime());
            if (current.compareTo(left) >= 0 && current.compareTo(right) <= 0) {
                return period;
            }
        }
        try {
            BSC bsc = (BSC)getResourceBase().getWebSite();
            Period period = bsc.listValidPeriods().iterator().next();
            return period;
        }catch(NoSuchElementException nse) {
        }
        return null;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
                SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        User user = paramRequest.getUser();
        //Validar usuario autorizado
        if (!user.isSigned()) {
            response.flushBuffer();
            return;
        }
        final String lang = user.getLanguage()==null?"es":user.getLanguage();
        
        
        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder(64);
        //Obtener el Scorecard actual
        BSC currentBsc = (BSC) paramRequest.getWebPage().getWebSite();
        
        //Obtener listado de instancias de Periodos en el Scorecard
        Iterator<Period> allPeriods = Period.ClassMgr.listPeriods(currentBsc);
        List<Period> periods = SWBUtils.Collections.filterIterator(allPeriods, new GenericFilterRule<Period>() {
                @Override
                public boolean filter(Period s) {
                    User user = SWBContext.getSessionUser(getResourceBase().getWebSite().getUserRepository().getId());
                    return !s.isValid() || !user.haveAccess(s);
                }
            });
        
        Period nearestPeriod = null;
        //Obtener el Periodo actual
        String periodId = (String) request.getSession().getAttribute(currentBsc.getId());
        //Verificar que exista el periodo válido en sesión. Si no existe, ponerlo
        if(Period.ClassMgr.hasPeriod(periodId, currentBsc)) {
            nearestPeriod = Period.ClassMgr.getPeriod(periodId, currentBsc);
        }else {
            nearestPeriod = getNearestPeriod(periods);
            if(nearestPeriod != null) {
                periodId = nearestPeriod.getId();
                request.getSession(true).setAttribute(currentBsc.getId(), periodId);
            }else {
                return;
            }
        }        
        SWBResourceURL actionUrl = paramRequest.getActionUrl().setAction(Action_CHANGE_PERIOD);
        final String suri = request.getParameter("suri");
        if(suri!=null) {
            actionUrl.setParameter("suri", URLEncoder.encode(request.getParameter("suri"),"utf-8"));
        }        
        output.append("  <li class=\"dropdown\">\n");
        output.append("    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><span class=\"hidden-xs\">");
        output.append(paramRequest.getLocaleString("lbl_title"));
        output.append(":&nbsp;</span>");
        output.append(nearestPeriod != null ? nearestPeriod.getTitle() : "");
        if(periods.size() > 1) {
            output.append("<span class=\"caret\"></span>");
        }
        output.append("</a>\n");
        if(!periods.isEmpty()) {
            String title;
            output.append("    <ul class=\"dropdown-menu\" role=\"menu\">\n");
            for(Period nextPeriod:periods) {
                title = nextPeriod.getDisplayTitle(lang)==null?nextPeriod.getTitle():nextPeriod.getDisplayTitle(lang);
                if(nextPeriod==nearestPeriod) {
                    output.append("      <li role=\"presentation\" class=\"disabled\">");
                    output.append("<a role=\"menuitem\" href=\"#\">");
                    output.append(title);
                    output.append("</a></li>").append("\n");
                    output.append("<li role=\"presentation\" class=\"divider\"></li>").append("\n");
                }else {
                    actionUrl.setParameter("periodId", nextPeriod.getId());
                    output.append("      <li role=\"presentation\">");
                    output.append("<a href=\"#\" onclick=\"location.href='"+actionUrl.toString()+"'\">");
                    output.append(title);
                    output.append("</a></li>\n");
                }
            }
            output.append("    </ul>\n");
        }
        output.append("  </li>\n");
        out.println(output.toString());
    }

    @Override
    public void processAction(HttpServletRequest request,
            SWBActionResponse response) throws SWBResourceException, IOException {
        
        final String action = response.getAction();
        final String lang = response.getUser().getLanguage()==null?"es":response.getUser().getLanguage();
        
        if(Action_CHANGE_PERIOD.equals(action))
        {
            String periodId = request.getParameter("periodId");
            WebSite website = response.getWebPage().getWebSite();
            if( Period.ClassMgr.hasPeriod(periodId, website) ) {
                Period period = Period.ClassMgr.getPeriod(periodId, website);
                if (period != null) {
                    request.getSession(true).setAttribute(website.getId(), period.getId());
                }
            }
            final String suri = request.getParameter("suri");
            if(suri != null) {
                response.sendRedirect(response.getWebPage().getUrl(lang)+"?suri="+suri);
            }else {
                response.sendRedirect(response.getWebPage().getUrl(lang));
            }
            
        }
        else
        {
            super.processAction(request, response);
        }
    }
}
