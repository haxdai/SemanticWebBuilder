package org.semanticwb.bsc.admin.resources.behavior;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.Committable;
import org.semanticwb.bsc.Seasonable;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.Undeleteable;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 * PeriodsManager es una clase que permite asociar o desasociar periodos a un
 * objetivo
 *
 *
 * @author Carlos Ramos Inchaustegui
 * @version %I%, %G%
 * @since 1.0
 */
public class PeriodsManager extends GenericResource {
    public static final String Action_UPDT_ACTIVE = "updactv";
    public static final String Action_ACTIVE_ALL = "actall";
    public static final String Action_DEACTIVE_ALL = "deactall";    

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
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
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
            Iterator<Period> itPeriods;
            
            final Seasonable seasonable = (Seasonable)genericObject;
            itPeriods = seasonable.listAvailablePeriods(false);
            
            final String disabled;
            if(genericObject instanceof Committable) {
                final Committable committable = (Committable)genericObject;
                if( committable.isCommited() &&  user.hasUserGroup(user.getUserRepository().getUserGroup("editor")) ) {
                    disabled = " disabled ";
                }else {
                    disabled = "";
                }
            }else {
                disabled = "";
            }
            
            boolean hasPeriods = itPeriods.hasNext();

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
            out.println("     <th>" + paramRequest.getLocaleString("lbl_relate") + "</th>");            
            out.println("    </tr>");
            out.println("   </thead>");
            out.println("   <tbody>");
            
            boolean hasFormer;
            boolean hasNext;
            while (itPeriods.hasNext())
            {
                Period period = itPeriods.next();
                if (  (period.isValid() && user.haveAccess(period)) || (!period.isActive() && seasonable.hasPeriod(period) && user.haveAccess(period))  )
                {
                    urlAdd = paramRequest.getActionUrl();
                    urlAdd.setParameter("suri", suri);
                    urlAdd.setParameter("sval", period.getId());
                    urlAdd.setAction(Action_UPDT_ACTIVE);
                    
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

                    out.println("     <td align=\"center\"><input name=\"period\""
                            + disabled
                            + " type=\"checkbox\" value=\"" + period.getId() + "\" "
                            + " onchange=\"submitUrl('" + urlAdd + "',this.domNode)\" "
                            + " dojoType=\"dijit.form.CheckBox\" " + (seasonable.hasPeriod(period)?"checked=\"checked\"":"") + "/></td>");
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
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("lbl_markAll") + "</button>");

                urlAll.setAction(Action_DEACTIVE_ALL);
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("lbl_unMarkAll") + "</button>");
                out.println("</fieldset>");
            }
            out.println("</div>");
                
            if (request.getParameter("statmsg") != null && !request.getParameter("statmsg").isEmpty()) {
                out.println("<div dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
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
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
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
        BSC model = (BSC)semObj.getModel().getModelObject().getGenericInstance();
        
        if(Action_UPDT_ACTIVE.equalsIgnoreCase(action))
        {
            final String periodId = request.getParameter("sval");
            if(periodId!=null)
            {
                if(Period.ClassMgr.hasPeriod(periodId, model)) {
                    Seasonable seasonable = (Seasonable) semObj.getGenericInstance();
                    Period period = Period.ClassMgr.getPeriod(periodId, model);
                    if(seasonable.hasPeriod(period)) {
                        seasonable.removePeriod(period);
                        if(!period.listSeasonables().hasNext())
                        {
                            period.setUndeleteable(false);
                            Iterator<Period> it = period.getBSC().listPeriods();
                            boolean periodRelated = false;
                            while(it.hasNext() && !periodRelated) {
                                Period aux = it.next();
                                periodRelated = periodRelated || aux.listSeasonables().hasNext();
                                if(!periodRelated) {
                                    aux.setUndeleteable(false);
                                }
                            }
                            if(!periodRelated) {
                                 period.setUndeleteable(false);
                            }
                        }
                        response.setRenderParameter("statmsg", response.getLocaleString("msgDeallocatedPeriod"));
                    }else {
                        seasonable.addPeriod(period);
                        period.setUndeleteable(true);
                        response.setRenderParameter("statmsg", response.getLocaleString("msgAssignedPeriod"));
                    }
                }else {
                    response.setRenderParameter("statmsg", "Objeto semantico no ubicado");
                }
            }
            else
            {
                response.setRenderParameter("statmsg", "Objeto semantico no ubicado.");
            }
        }
        else if(Action_ACTIVE_ALL.equalsIgnoreCase(action))
        {
            Iterator<Period> it;
            GenericObject genericObject = semObj.getGenericInstance();
            Seasonable seasonable = (Seasonable)genericObject;
            it = seasonable.listAvailablePeriods();
            List<Period> periods = SWBUtils.Collections.copyIterator(it);
            //Tratamiento para los períodos asignados anteriormente
            seasonable.removeAllPeriod();
            for(Period period : periods) {
                if(!period.listSeasonables().hasNext()) {
                    period.setUndeleteable(false);
                }
            }
            //Tratamiento para los nuevos períodos a asignar
            if(!periods.isEmpty()) {
                for(Period period : periods) {
                    seasonable.addPeriod(period);
                    period.setUndeleteable(true);
                }
                response.setRenderParameter("statmsg", response.getLocaleString("msgAssignedAllPeriods"));
            }
        }
        else if(Action_DEACTIVE_ALL.equalsIgnoreCase(action))
        {
            Seasonable seasonable = (Seasonable) semObj.getGenericInstance();
            seasonable.removeAllPeriod();
            
            BSC bsc;
            bsc = seasonable.getBSC();
//            GenericObject genericObject = semObj.getGenericInstance();
//            if(genericObject instanceof Indicator) {
//                bsc = ((Indicator)genericObject).getBSC();
//            }else if(genericObject instanceof Objective) {
//                bsc = ((Objective)genericObject).getBSC();
//            }
            if(bsc!=null) {
                Iterator<Period> it = bsc.listPeriods();
                if(!it.hasNext())
                {
                    boolean periodRelated;
                    while(it.hasNext()) {
                        Period aux = it.next();
                        periodRelated = aux.listSeasonables().hasNext();
                        if(!periodRelated) {
                            aux.setUndeleteable(false);
                        }
                    }
                }
            }
            response.setRenderParameter("statmsg", response.getLocaleString("msgDeallocatedAllPeriods"));
        }
    }

    /**
     * M&eacute;todo que se encarga de eliminar los periodos asociados a un
     * objeto Sem&aacute;ntico
     *
     * @param semObj
     */
    private void removePeriodsInSemObj(SemanticObject semObj) {
        Iterator<SemanticObject> itPeriods = (Iterator<SemanticObject>) semObj.listObjectProperties(Seasonable.bsc_hasPeriod);

        if (itPeriods != null && itPeriods.hasNext()) {
            while (itPeriods.hasNext()) {
                SemanticObject period = itPeriods.next();

                semObj.removeObjectProperty(Seasonable.bsc_hasPeriod, period);
                Iterator<SemanticObject> itObjs = period.listRelatedObjects();
                if(itObjs != null && itObjs.hasNext()){
                    period.setBooleanProperty(Undeleteable.swb_undeleteable, false);
                }
            }
        }
    }
}
