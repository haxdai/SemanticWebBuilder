package org.semanticwb.bsc.admin.resources.behavior;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.PeriodGroup;
import org.semanticwb.model.GenericObject;
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
public class PeriodGroupManager extends GenericResource
{
    public static final String Action_ACTIVE_ALL = "actall";
    public static final String Action_DEACTIVE_ALL = "offall";    
    public static final String Action_REMOVE_ALL = "remall";
    /**
     * M&eacute;todo que se encarga de presentar la forma al usuario para que
     * elija un conjunto de periodos
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param response Proporciona funcionalidad especifica HTTP para
     * envi&oacute; en la respuesta
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @throws SWBResourceException Excepti&oacute;n utilizada para recursos de
     * SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) 
            throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        String suri = request.getParameter("suri");
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        User user = paramRequest.getUser();
        out.println("<script type=\"text/javascript\">");
        out.println("  dojo.require('dojo.parser');\n");
        out.println("  dojo.require('dijit.layout.ContentPane');");
        out.println("  dojo.require('dijit.form.CheckBox');");
        out.println("  dojo.require('dijit.form.Button');");
        out.println("</script>");
        
        if (semObj != null) {
            SWBResourceURL urlAdd;

            GenericObject genericObject = semObj.getGenericInstance();
            Iterator<Period> itPeriodGroups;
            
            final PeriodGroup periodgroup = (PeriodGroup)genericObject;
            itPeriodGroups = periodgroup.listGroupedPeriods();
            SortedSet<Period> periodsO = new TreeSet<Period>();
            periodsO.addAll(SWBUtils.Collections.copyIterator(itPeriodGroups));
            itPeriodGroups = periodsO.iterator();
            
            boolean hasPeriods = itPeriodGroups.hasNext();
            
            //Colocar encabezado del listado con las columnas del mismo
            out.println("<div class=\"swbform\">");
            out.println(" <fieldset>");
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
//            out.println("     <th>" + paramRequest.getLocaleString("lbl_relate") + "</th>");            
            out.println("    </tr>");
            out.println("   </thead>");
            out.println("   <tbody>");
            
            boolean hasFormer;
            boolean hasNext;
            while (itPeriodGroups.hasNext())
            {
                Period period = itPeriodGroups.next();
                if( !period.isDeleted() && user.haveAccess(period) )
                {
                    urlAdd = paramRequest.getActionUrl();
                    urlAdd.setParameter("suri", suri);
                    
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
                    out.println("     <td>" + period.getStart() + "</td>");            
                    out.println("     <td>" + period.getEnd() + "</td>");            
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
                    out.println("     </tr>");

                }
            }
            out.println("   </tbody>");
            out.println("  </table>");
            out.println(" </fieldset>");

            if(hasPeriods)
            {
                SWBResourceURL urlAll = paramRequest.getActionUrl();
                urlAll.setParameter("suri", suri);
                urlAll.setAction(Action_ACTIVE_ALL);
                out.println("<fieldset>");
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("lblActiveAll") + "</button>");

                urlAll.setAction(Action_DEACTIVE_ALL);
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("lblOffAll") + "</button>");
                
                urlAll.setAction(Action_REMOVE_ALL);
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"if(confirm('"+paramRequest.getLocaleString("queryRemoveAll")+"')){submitUrl('"+urlAll+"',this.domNode);}return false;\">" + paramRequest.getLocaleString("lblRemoveAll") + "</button>");
                out.println("</fieldset>");
            }
            out.println("</div>");
                
            if (request.getParameter("statmsg") != null && !request.getParameter("statmsg").isEmpty()) {
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
    
    /**
     * M&eacute;todo que se encarga de persistir la informaci&oacute;n de forma
     * segura en un objetivo
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param response Objeto con el cual se acceden a los objetos de SWB
     * @throws SWBResourceException Excepti&oacute;n utilizada para recursos de
     * SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException
    {
        final String action = response.getAction();
        final String suri = request.getParameter("suri");
        
        response.setRenderParameter("suri", suri);
        
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
        
        if(Action_ACTIVE_ALL.equalsIgnoreCase(action))
        {
            Iterator<Period> periods;
            GenericObject genericObject = semObj.getGenericInstance();
            PeriodGroup periodgrp = (PeriodGroup)genericObject;
            periods = periodgrp.listGroupedPeriods();
            if(periods.hasNext()) {
                while(periods.hasNext()) {
                    periods.next().setActive(true);
                }
                response.setRenderParameter("statmsg", response.getLocaleString("msgActivatedAllPeriods"));
            }
        }
        else if(Action_DEACTIVE_ALL.equalsIgnoreCase(action))
        {
            Period period;
            Iterator<Period> periods;
            GenericObject genericObject = semObj.getGenericInstance();
            PeriodGroup periodgrp = (PeriodGroup)genericObject;
            periods = periodgrp.listGroupedPeriods();
            if(periods.hasNext()) {
                while(periods.hasNext()) {
                    period = periods.next();
                    if(!period.isUndeleteable()) {
                        period.setActive(false);
                    }
                }
                response.setRenderParameter("statmsg", response.getLocaleString("msgOffAllPeriods"));
            }
        }
        else if(Action_REMOVE_ALL.equalsIgnoreCase(action))
        {
            Period period;
            Iterator<Period> periods;
            GenericObject genericObject = semObj.getGenericInstance();
            PeriodGroup periodgrp = (PeriodGroup)genericObject;
            periods = periodgrp.listGroupedPeriods();
            if(periods.hasNext()) {
                while(periods.hasNext()) {
                    period = periods.next();
                    if(!period.isUndeleteable()) {
                        period.remove();
                    }
                }
                response.setRenderParameter("statmsg", response.getLocaleString("msgRemovedAllPeriods"));
            }
        }
    } 
}
