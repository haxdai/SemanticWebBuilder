package org.semanticwb.bsc.admin.resources.behavior;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.Machinable;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.PeriodGroup;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class PeriodGeneratorManager extends GenericResource
{
    private static final Logger log = SWBUtils.getLogger(PeriodGeneratorManager.class);
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) 
            throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        String suri = request.getParameter("suri");
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        //User user = paramRequest.getUser();
                
        if (semObj != null) {
            final String id = "_"+semObj.getId();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            GregorianCalendar cal = new GregorianCalendar();
            String start;
            start = request.getParameter("start")==null ? sdf.format(cal.getTime()):request.getParameter("start");
            try {
                start = sdf.format(sdf.parse(start));
            }catch(ParseException pe) {
                start = sdf.format(cal.getTime());
            }
            String end;
            end = request.getParameter("end")==null ? sdf.format(cal.getTime()):request.getParameter("end");
            try {
                end = sdf.format(sdf.parse(end));
            }catch(ParseException pe) {
                end = sdf.format(cal.getTime());
            }
            String duration;
            duration = request.getParameter("dur")==null ?"1":request.getParameter("dur");
            try {
                Integer.parseInt(duration);
            }catch(NumberFormatException nfe) {
                duration = "1";
            }
            String time;
            time = request.getParameter("time")==null 
                    ? Integer.toString(Calendar.MONTH):request.getParameter("time");
            try {
                Integer.parseInt(time);
            }catch(NumberFormatException nfe) {
                time = Integer.toString(Calendar.MONTH);
            }

            out.println("<script type=\"text/javascript\">");
            out.println("  dojo.require('dojo.parser');\n");
            out.println("  dojo.require('dijit.layout.ContentPane');");
            out.println("  dojo.require('dijit.form.Form');");
            out.println("  dojo.require('dijit.form.DateTextBox');");
            out.println("  dojo.require('dijit.form.FilteringSelect');");
            out.println("  dojo.require('dijit.form.Button');");

            out.println("dojo.addOnLoad(function() {");
            out.println(" dijit.byId('dur"+id+"').set('value', '"+duration+"');");
            out.println(" dijit.byId('time"+id+"').set('value', '"+time+"');");
            out.println("});");

            out.println("</script>");
            
            Resource base = getResourceBase();
//            SWBResourceURL urlAction = paramRequest.getActionUrl();
//            urlAction.setAction(paramRequest.Action_EDIT);
            
            //Colocar encabezado del listado con las columnas del mismo
            out.println("<div class=\"swbform\">");
            //out.println("<form id=\"perGenMgrRes_"+base.getId()+"\" action=\""+urlAction+"\" method=\"post\" >");
            out.println("<form id=\"perGenMgrRes"+id+"\" method=\"post\" >");
            out.println(" <fieldset>");
            out.println("  <ul class=\"swbform-ul\">");
            //out.println("   <legend>");
            //out.println(paramRequest.getLocaleString("msgPeriodGeneratorForm"));
            //out.println("   </legend>");
            out.println("   <li class=\"swbform-li\">");
            out.println("    "+paramRequest.getLocaleString("lblPeriodize")+":");
            out.println("   </li>");
            
            out.println("   <li class=\"swbform-li\">");
            out.println("    <label for=\"start"+id+"\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblStart")+"</label>");
            out.println("    <input type=\"text\" name=\"start\" id=\"start"+id+"\" "
                    + " onblur=\"if(!this.value){this.focus();}\" "
                    + " onChange=\"dijit.byId('end"+id+"').constraints.min = arguments[0];\""
                    + " dojoType=\"dijit.form.DateTextBox\" required=\"true\" "
                    + " promptMessage=\""+paramRequest.getLocaleString("msgPromptMsgStart")+"\" invalidMessage=\"fecha mala\" "
                    + " constraints=\"{datePattern:'dd/MMM/yyyy', strict:true}\" size=\"11\" "
                    + " style=\"width:110px;\" hasDownArrow=\"true\" value=\""+start+"\"/>");
            out.print("     </li>");
            
            out.println("   <li class=\"swbform-li\">");
            out.println("    <label for=\"end"+id+"\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblEnd")+"</label>");
            out.println("    <input type=\"text\" name=\"end\" id=\"end"+id+"\" "
                    + " onblur=\"if(!this.value){this.focus();}\" "
                    + " onChange=\"dijit.byId('start"+id+"').constraints.max = arguments[0];\""
                    + " dojoType=\"dijit.form.DateTextBox\" required=\"true\" "
                    + " promptMessage=\""+paramRequest.getLocaleString("msgPromptMsgEnd")+"\" invalidMessage=\"fecha mala\" "
                    + " constraints=\"{datePattern:'dd/MMM/yyyy'}\" size=\"11\" "
                    + " style=\"width:110px;\" hasDownArrow=\"true\" value=\""+end+"\"/>");
            out.println("     </li>");
            
            out.println("   <li class=\"swbform-li\">");
            out.println("    "+paramRequest.getLocaleString("lblDuration")+":");
            out.println("   </li>");
            
            out.println("   <li class=\"swbform-li\">");
            out.println("    <label for=\"dur"+id+"\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblFrequency")+"</label>");
            out.println("    <select id=\"dur"+id+"\" name=\"dur\" dojoType=\"dijit.form.FilteringSelect\">");
            out.println("     <option value=\"1\">1</option>");
            out.println("     <option value=\"2\">2</option>");
            out.println("     <option value=\"3\">3</option>");
            out.println("     <option value=\"4\">4</option>");
            out.println("     <option value=\"5\">5</option>");
            out.println("     <option value=\"6\">6</option>");
            out.println("     <option value=\"7\">7</option>");
            out.println("    </select>");
            out.println("     </li>");
            
            out.println("   <li class=\"swbform-li\">");
            out.println("    <label for=\"time"+id+"\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblTime")+"</label>");
            out.println("    <select id=\"time"+id+"\" name=\"time\" dojoType=\"dijit.form.FilteringSelect\">");
            //out.println("     <option value=\""+Calendar.DAY_OF_MONTH+"\">"+paramRequest.getLocaleString("lblDayOfMonth")+"</option>");
            //out.println("     <option value=\""+Calendar.DAY_OF_WEEK+"\">"+paramRequest.getLocaleString("lblDayOfWeek")+"</option>");
            //out.println("     <option value=\""+Calendar.DAY_OF_YEAR+"\">"+paramRequest.getLocaleString("lblDayOfYear")+"</option>");
            out.println("     <option value=\""+Calendar.WEEK_OF_MONTH+"\">"+paramRequest.getLocaleString("lblWeekOfMonth")+"</option>");
            out.println("     <option value=\""+Calendar.WEEK_OF_YEAR+"\">"+paramRequest.getLocaleString("lblWeekOfYear")+"</option>");
            out.println("     <option value=\""+Calendar.MONTH+"\">"+paramRequest.getLocaleString("lblMonth")+"</option>");
            out.println("    </select>");
            out.println("     </li>");
            
            out.println("</ul>");
            out.println("</fieldset>");
            
            out.println("<fieldset>");
            SWBResourceURL urlIndex = paramRequest.getRenderUrl().setMode(paramRequest.Mode_INDEX);
            urlIndex.setParameter("suri", suri);
            urlIndex.setAction(paramRequest.Action_EDIT);
            out.println(" <button dojoType=\"dijit.form.Button\" type=\"button\" "
                    + "onclick=\"postHtml('"+urlIndex+"&st='+dojo.date.locale.format(dijit.byId('start"+id+"').value, {datePattern:'yyyy-MM-dd', selector: 'date'})+'&ed='+dojo.date.locale.format(dijit.byId('end"+id+"').value, {datePattern:'yyyy-MM-dd', selector: 'date'})+'&dur='+dijit.byId('dur"+id+"').get('value')+'&time='+dijit.byId('time"+id+"').get('value'),'p_cntr"+id+"');\">"
                    +paramRequest.getLocaleString("lblShow")+"</button>&nbsp;");
            urlIndex.setAction(paramRequest.Action_REMOVE);
            out.println(" <button dojoType=\"dijit.form.Button\" type=\"button\" onclick=\"postHtml('"+urlIndex+"','p_cntr"+id+"')\">"+paramRequest.getLocaleString("lblEraser")+"</button>");
            
            SWBResourceURL urlAction = paramRequest.getActionUrl();
            urlAction.setParameter("suri", suri);
            urlAction.setAction(paramRequest.Action_ADD);
            out.println("<button dojoType=\"dijit.form.Button\" "
                    + "onclick=\"if(confirm('"+paramRequest.getLocaleString("queryGenerateAll")+"')){submitUrl('"+urlAction+"&st='+dojo.date.locale.format(dijit.byId('start"+id+"').value, {datePattern:'yyyy-MM-dd', selector: 'date'})+'&ed='+dojo.date.locale.format(dijit.byId('end"+id+"').value, {datePattern:'yyyy-MM-dd', selector: 'date'})+'&dur='+dijit.byId('dur"+id+"').get('value')+'&time='+dijit.byId('time"+id+"').get('value'),this.domNode);} return false;\">" 
                    +paramRequest.getLocaleString("lblSubmit") + "</button>");
            out.println("</fieldset>");
            
            out.println("<fieldset>");
            out.println(" <div id=\"p_cntr"+id+"\">");
            if(request.getParameter("statmsg") != null && !request.getParameter("statmsg").isEmpty())
            {
                renderPeriodsList(request, response, paramRequest);
            }
            out.println(" </div>");
            out.println("</fieldset>");
                
//            out.println("<fieldset>");
//            SWBResourceURL urlAction = paramRequest.getActionUrl();
//            urlAction.setParameter("suri", suri);
//            urlAction.setAction(paramRequest.Action_ADD);
//            out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('"+urlAction+"&dur='+dijit.byId('dur').get('value')+'&time='+dijit.byId('time').get('value'),this.domNode); return false;\">" + paramRequest.getLocaleString("lblSubmit") + "</button>");
//            out.println("</fieldset>");

            out.println("</div>");
                
            if(request.getParameter("statmsg") != null && !request.getParameter("statmsg").isEmpty())
            {
                out.println("<div dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
                //out.println("updateTreeNodeByURI('"+semObj.getURI()+"');");
                out.println("reloadTreeNodeByURI('"+semObj.getURI()+"');");
                out.println("showStatus('" + request.getParameter("statmsg") + "');\n");
                out.println("</script>\n");
                out.println("</div>");
                
                
            }
        }
    }

    @Override
    public void doIndex(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        String suri = request.getParameter("suri");
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        //User user = paramRequest.getUser();
        
        if (semObj != null) {
            final String action = paramRequest.getAction();
            BSC bsc = (BSC)semObj.getModel().getModelObject().getGenericInstance();

            if(paramRequest.Action_EDIT.equals(action))
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date start, end;
                try {
                    start = sdf.parse(request.getParameter("st"));
                    end = sdf.parse(request.getParameter("ed"));
                }catch(ParseException pe) {
                    log.error(pe);
                    return;
                }
                
                int resolution;
                try {
                    resolution = Integer.parseInt( request.getParameter("dur")==null?"1":request.getParameter("dur") );
                }catch(NumberFormatException nfe) {
                    resolution = 1;
                }
                int freq;
                try {
                    freq = Integer.parseInt( request.getParameter("time")==null?"":request.getParameter("time") );
                }catch(NumberFormatException nfe) {
                    freq = Calendar.MONTH;
                }
                
                out.println("<table width=\"90%\">");
                out.println(" <thead>");
                out.println("  <tr>");
                out.println("   <th>" + paramRequest.getLocaleString("lblStart") + "</th>");
                out.println("   <th>" + paramRequest.getLocaleString("lblEnd") + "</th>");
                out.println("  </tr>");
                out.println(" </thead>");
                
                String lang = paramRequest.getUser().getLanguage();
                SimpleDateFormat my = new SimpleDateFormat("MMM yyyy", new Locale(lang));
                SimpleDateFormat dmmmy = new SimpleDateFormat("dd/MMMM/yyyy hh:mm", new Locale(lang));
                GregorianCalendar ci,cf, sh, aux;
                ci = new GregorianCalendar();
                ci.setTime(start);
                sh = (GregorianCalendar)ci.clone();
                cf = new GregorianCalendar();
                cf.setTime(end);
                
                Date from, to;
                boolean isLapseValid = true;
                out.println(" <tbody>");
                while(isLapseValid && sh.compareTo(cf)<=0) {
                    from = sh.getTime();
                    sh.add(freq, resolution);
                    aux = (GregorianCalendar)sh.clone();
                    aux.add(Calendar.DAY_OF_MONTH, -1);
                    to = aux.getTime();
                    isLapseValid = isLapseValid(bsc, from, to);
                    if(isLapseValid) {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(dmmmy.format(from));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(dmmmy.format(to));
                        out.println("</td>");
                        out.println("</tr>");
                    }
                }
                out.println(" </tbody>");
                if(!isLapseValid) {
                    out.println("<tfoot>");
                    out.println("<tr>");
                    out.println("<td colspan=\"2\">");
                    out.println(paramRequest.getLocaleString("msgElapseInvalid"));
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</tfoot>");
                }
                out.println("</table>");
            }
            else if(paramRequest.Action_REMOVE.equals(action))
            {
                // No hacer nada
            }
        }
        out.flush();
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        final String action = response.getAction();
        final String suri = request.getParameter("suri");
        
        setRenderParameter(request, response);
        
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject semObj = ont.getSemanticObject(suri);
        if(semObj==null) {
            response.setRenderParameter("statmsg", response.getLocaleString("msgNoSuchSemanticElement"));
            return;
        }
        
        User user = response.getUser();
        if( !user.isSigned() 
                || (!user.haveAccess(semObj.getGenericInstance())
                    && !SWBContext.getAdminRepository().hasUser(user.getId())) )
        {
            response.setRenderParameter("statmsg", response.getLocaleString("msgUnauthorizedUser"));
            return;
        }
        
        if(response.Action_ADD.equals(action))
        {
            BSC bsc = (BSC)semObj.getModel().getModelObject().getGenericInstance();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Iterator<Period> periods;
            Period period;
            Date start, end;
            int resolution, freq;
            Period p, prev, next;
            GenericObject genericObject = semObj.getGenericInstance();
            PeriodGroup periodgrp = (PeriodGroup)genericObject;
            
            // Revisar si algún período es Undeleteable. Es así cuando el período
            // ya ha sido asignado a algún elementos del scorecard
            periods = periodgrp.listGroupedPeriods();
            while(periods.hasNext()) {
                period = periods.next();
                if(period.isUndeleteable()) {
                    response.setRenderParameter("statmsg", response.getLocaleString("msgExistsUndeleteablePeriod"));
                    return;
                }
            }
            // Eliminación de los períodos del grupo
            periods = periodgrp.listGroupedPeriods();
            while(periods.hasNext()) {
                periods.next().remove();
            }
            periodgrp.removeAllGroupedPeriod();
            
            try {
                start = sdf.parse(request.getParameter("st"));
                end = sdf.parse(request.getParameter("ed"));
            }catch(ParseException pe) {
                log.error(pe);
                response.setRenderParameter("statmsg", response.getLocaleString("msgInvalidDateFormat"));
                return;
            }
            try {
                resolution = Integer.parseInt( request.getParameter("dur")==null?"1":request.getParameter("dur") );
            }catch(NumberFormatException nfe) {
                log.warn(nfe);
                resolution = 1;
            }
            try {
                freq = Integer.parseInt( request.getParameter("time")==null?"":request.getParameter("time") );
            }catch(NumberFormatException nfe) {
                log.warn(nfe);
                freq = Calendar.MONTH;
            }
            
            String lang = response.getUser().getLanguage();
            String pattern;
            switch(freq) {
                case Calendar.WEEK_OF_MONTH:
                    pattern = "W MM-yyyy";
                    break;
                case Calendar.WEEK_OF_YEAR:
                    pattern = "w yyyy";
                    break;
                case Calendar.MONTH:
                    pattern = "MMMM yyyy";
                    break;
                default:
                    pattern = "EE dd-MM-yy";
            }
            
            boolean isLapseValid = true;
            SimpleDateFormat my = new SimpleDateFormat(pattern, new Locale(lang));
            GregorianCalendar ci,cf, sh, aux;
            ci = new GregorianCalendar();
            ci.setTime(start);
            sh = (GregorianCalendar)ci.clone();
            cf = new GregorianCalendar();
            cf.setTime(end);
            Date from, to;
            while(sh.compareTo(cf)<=0) {
                from = sh.getTime();
                sh.add(freq, resolution);
                aux = (GregorianCalendar)sh.clone();
                if(freq == Calendar.WEEK_OF_YEAR) {
                    aux.add(Calendar.DAY_OF_YEAR, -1);
                }else {
                    aux.add(Calendar.DAY_OF_MONTH, -1);
                }
                to = aux.getTime();
                isLapseValid = isLapseValid && isLapseValid(bsc, from, to);
                if(isLapseValid) {
                    p = Period.ClassMgr.createPeriod(bsc);
                    p.setTitle(my.format(from));
                    p.setStart(from);
                    p.setEnd(to);
                    p.setActive(true);
                    periodgrp.addGroupedPeriod(p);
                }
            }
            // Asignar previo y siguiente a cada período del grupo
            Machinable m;
            ListIterator<Period> ps = periodgrp.listGroupedPeriods(true).listIterator();
            while(ps.hasNext()) {
                m = ps.next();
                ps.previous();
                if(ps.hasPrevious()) {
                    m.setPrevius(ps.previous());
                    ps.next();
                }
                ps.next();
                if(ps.hasNext()) {
                    m.setNext(ps.next());
                    ps.previous();
                }
            }
            if(isLapseValid) {
                response.setRenderParameter("statmsg", response.getLocaleString("msgUpdateSuccessful"));
            }else {
                response.setRenderParameter("statmsg", response.getLocaleString("msgElapseInvalid"));
            }
        }
    }
    
    public boolean isLapseValid(BSC bsc, Date start, Date end) {
        Date from, to;
        Iterator<Period> iperiods = Period.ClassMgr.listPeriods(bsc);
        while(iperiods.hasNext()) {
            Period p = iperiods.next();            
            from = p.getStart();
            to = p.getEnd();
            if(from==null || to==null) {
                continue;
            }
            if(  (from.getTime()<=start.getTime() && to.getTime()>=end.getTime()) 
                 || (start.getTime()<=from.getTime() && end.getTime()>=from.getTime())
                 || (start.getTime()<=to.getTime() && end.getTime()>=to.getTime()) ) {
               return false;
            }
        }
        return true;
    }
    
    private void renderPeriodsList(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) 
            throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        String suri = request.getParameter("suri");
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        User user = paramRequest.getUser();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale(user.getLanguage()));
                
        if (semObj != null) {
            GenericObject genericObject = semObj.getGenericInstance();
            final PeriodGroup periodgroup = (PeriodGroup)genericObject;
            Iterator<Period> periods = periodgroup.listGroupedPeriods();
            
            out.println("  <table width=\"98%\">"); 
            out.println("   <thead>");
            out.println("    <tr>");
            out.println("     <th>" + paramRequest.getLocaleString("lbl_index") + "</th>");
            out.println("     <th>" + paramRequest.getLocaleString("lbl_period") + "</th>");
            out.println("     <th>" + paramRequest.getLocaleString("lbl_fromDate") + "</th>");            
            out.println("     <th>" + paramRequest.getLocaleString("lbl_toDate") + "</th>");            
            out.println("     <th>" + paramRequest.getLocaleString("lbl_former") + "</th>");            
            out.println("     <th>" + paramRequest.getLocaleString("lbl_next") + "</th>");            
            out.println("     <th>" + paramRequest.getLocaleString("lbl_active") + "</th>");            
            //out.println("     <th>" + paramRequest.getLocaleString("lbl_relate") + "</th>");            
            out.println("    </tr>");
            out.println("   </thead>");
            out.println("   <tbody>");

            boolean hasFormer;
            boolean hasNext;
            while(periods.hasNext())
            {
                Period period = periods.next();
                //if (  (period.isValid() && user.haveAccess(period)) || (!period.isActive() && seasonable.hasPeriod(period) && user.haveAccess(period))  )
                //{
                    /*urlAdd = paramRequest.getActionUrl();
                    urlAdd.setParameter("suri", suri);
                    urlAdd.setParameter("sval", period.getId());
                    urlAdd.setAction(Action_UPDT_ACTIVE);*/

                    String title = period.getDisplayTitle(user.getLanguage());
                    String titleFormer;
                    String titleNext = null;
                    if (period.getPrevius() != null) {
                        Period former = (Period) period.getPrevius();
                        titleFormer = former.getDisplayTitle(user.getLanguage());
                        hasFormer = true;
                    }else {
                        titleFormer = "-";
                        hasFormer = false;
                    }
                    if (period.getNext() != null) {
                        Period next = (Period) period.getNext();
                        titleNext = next.getDisplayTitle(user.getLanguage()) ;
                        hasNext = true;
                    } else {
                        titleNext = "-";
                        hasNext = false;
                    }

                    //mostrar las columnas del listado con sus valores
                    out.println("    <tr>");
                    out.append("      <td>"+period.getIndex()+"</td>");
                    out.println("     <td>");
                    out.print("<a href=\"#\" onclick=\"addNewTab('" + period.getURI() + "','");
                    out.print(SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp','" + title);
                    out.println("');return false;\" >" + title + "</a>");
                    out.println("     </td>");
                    out.println("     <td>" + df.format(period.getStart()) + "</td>");
                    out.println("     <td>" + df.format(period.getEnd()) + "</td>");            
                    out.println("     <td>");
                    if (hasFormer) {
                        out.print("<a href=\"#\" onclick=\"addNewTab('" + period.getPrevius().getURI() + "','");
                        out.print(SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp','"+titleFormer);
                        out.println("');return false;\" >"+titleFormer+"</a>");
                    }else {
                        out.print(titleFormer);
                    }
                    out.println("     </td>");
                    out.println("     <td>");
                    if (hasNext) {
                        out.print("<a href=\"#\" onclick=\"addNewTab('" + period.getNext().getURI() + "','");
                        out.print(SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp','"+titleNext);
                        out.println("');return false;\" >"+titleNext+"</a>");
                    }else {
                        out.print(titleNext);
                    }
                    out.println("     </td>");

                    out.println("     <td align=\"center\">" + 
                            (period.isActive()
                             ? paramRequest.getLocaleString("lbl_isActive")
                             : paramRequest.getLocaleString("lbl_isNotActive")) +
                            "</td>");

                    /*out.println("     <td align=\"center\"><input name=\"period\""
                            + disabled
                            + " type=\"checkbox\" value=\"" + period.getId() + "\" "
                            + " onchange=\"submitUrl('" + urlAdd + "',this.domNode)\" "
                            + " dojoType=\"dijit.form.CheckBox\" " + (seasonable.hasPeriod(period)?"checked=\"checked\"":"") + "/></td>");*/
                    
                    out.println("     </tr>");

                //}
            }
            out.println("   </tbody>");
            out.println("  </table>");
        }
    }
    
    private void setRenderParameter(HttpServletRequest request, SWBActionResponse response) {
        response.setRenderParameter("suri", request.getParameter("suri"));
        response.setRenderParameter("start", request.getParameter("st"));
        response.setRenderParameter("end", request.getParameter("ed"));
        response.setRenderParameter("dur", request.getParameter("dur"));
        response.setRenderParameter("time", request.getParameter("time"));
    }
}
