package org.semanticwb.bsc.admin.resources.behavior;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.Committable;
import org.semanticwb.bsc.InitiativeAssignable;
import org.semanticwb.bsc.accessory.Period;
import static org.semanticwb.bsc.admin.resources.behavior.InitiativeRiskManager.STTS_MSG;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.element.Initiative;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 * InitiativeManager es una clase que permite asignar y desasignar inicitaivas a
 * un objetivo
 *
 * @ Version 1.0
 * @author Carlos Ramos
 */
public class InitiativeManager extends GenericResource {
    public static final String Action_UPDT_ACTIVE = "updactv";
    public static final String Action_ACTIVE_ALL = "actall";
    public static final String Action_DEACTIVE_ALL = "deactall";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        User user = paramRequest.getUser();
        if(user==null || !user.isSigned()) {
            response.sendError(403);
            return;
        }
        
        final String suri = request.getParameter("suri");
        if(suri==null) {
            response.getWriter().println(paramRequest.getLocaleString("msgNoSuchSemanticElement"));
            return;
        }
        
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();        
        SemanticObject semObj = ont.getSemanticObject(suri);
        GenericObject genObj = semObj.getGenericInstance();
        if( !(genObj instanceof Indicator) ) {
            return;
        }        
        
        final String lang = user.getLanguage();
        
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("  dojo.require('dojo.parser');");
        out.println("  dojo.require('dijit.layout.ContentPane');");
        out.println("  dojo.require('dijit.form.CheckBox');");
        out.println("</script>");

        out.println("<div class=\"swbform\">");
        out.println("<fieldset>\n");
        out.println("<table width=\"98%\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>" + paramRequest.getLocaleString("lblTitle") + "</th>");
        out.println("<th>" + paramRequest.getLocaleString("lblResponsible") + "</th>");
        //out.println("<th>" + paramRequest.getLocaleString("lblArea") + "</th>");
        out.println("<th>");
        out.println(paramRequest.getLocaleString("lblFirstPeriod"));
        out.println("</th>");
        out.println("<th>");
        out.println(paramRequest.getLocaleString("lblLastPeriod"));
        out.println("</th>");
        out.println("<th>" + paramRequest.getLocaleString("lblActive") + "</th>");
        out.println("<th>" + paramRequest.getLocaleString("lblRelate") + "</th>");
        out.println("</tr>");
        out.println("</thead>");


        final Committable committable = (Committable)genObj;
        final String disabled;
        if( committable.isCommited() && user.hasUserGroup(user.getUserRepository().getUserGroup("editor")) ) {
            disabled = " disabled ";
        }else {
            disabled = "";
        }
        
        BSC bsc = (BSC)semObj.getModel().getModelObject().getGenericInstance();
        Iterator<Initiative> itInit = bsc.listInitiatives();
        SWBResourceURL urlAdd;
        urlAdd = paramRequest.getActionUrl();
        urlAdd.setAction(Action_UPDT_ACTIVE);
        urlAdd.setParameter("suri", suri);
        Period p;
        while (itInit.hasNext()) {                    
            Initiative initiative = itInit.next();
            if(  (initiative.isValid() && user.haveAccess(initiative)) || (!initiative.isActive() && semObj.hasObjectProperty(InitiativeAssignable.bsc_hasInitiative, initiative.getSemanticObject()) && user.haveAccess(initiative))  )
            {
                urlAdd.setParameter("sval", initiative.getId());
                
                out.println("<tr>");
                // Título de la iniciativa
                out.println("<td>");
                out.print("<a href=\"#\" onclick=\"addNewTab('" + initiative.getURI() + "','");
                out.print(SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + initiative.getTitle());
                out.println("');return false;\" >" + initiative.getDisplayTitle(lang).replaceAll("'","") + "</a>");                  
                out.println("</td>");

                // Responsable
                out.println("<td>" + (initiative.getInitiativeFacilitator()==null 
                        ? "Not set"
                        : initiative.getInitiativeFacilitator().getFullName()) + "</td>");

                // Área
                /*out.println("<td>" + (initiative.getArea()==null
                        ? "Not set"
                        :initiative.getArea()) + "</td>");*/
                p = initiative.getFirstPeriod();
                if(null==p) {
                    out.println("<td>Not set</td>\n");
                    out.println("<td>Not set</td>\n");
                }else {
                    out.println("<td>");
                    out.println(p.getDisplayTitle(lang));
                    out.println("</td>\n");
                    p = initiative.getLastPeriod();
                    out.println("<td>");
                    out.println(p.getDisplayTitle(lang));
                    out.println("</td>\n");
                }

                // Activo?
                out.println("<td>"+(initiative.isActive()?paramRequest.getLocaleString("lblIsActive"):paramRequest.getLocaleString("lblIsNotActive"))+"</td>");

                // Asignar
                out.println("<td>");
                out.print("<input type=\"checkbox\" name=\"initiative\" ");
                out.print(disabled);
                out.print("onchange=\"submitUrl('" + urlAdd + "&'+this.attr('name')+'='+this.attr('value'),this.domNode)\" ");
                out.println(" dojoType=\"dijit.form.CheckBox\" value=\"" + initiative.getId() + "\" " + (semObj.hasObjectProperty(InitiativeAssignable.bsc_hasInitiative, initiative.getSemanticObject())?"checked=\"checked\"":"") + " />");
                out.println("</td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        out.println("</fieldset>\n");
        out.println("<fieldset>");

        SWBResourceURL urlAll = paramRequest.getActionUrl();
        urlAll.setParameter("suri", suri);
        urlAll.setAction(Action_ACTIVE_ALL);
        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("lblActiveAll") + "</button>");

        SWBResourceURL urldesAll = paramRequest.getActionUrl();
        urldesAll.setParameter("suri", suri);
        urldesAll.setAction(Action_DEACTIVE_ALL);
        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urldesAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("lblDeActiveAll") + "</button>");
        out.println("</fieldset>\n");
        out.println("</div>");
        
        String statmsg = request.getParameter(STTS_MSG);
        if( statmsg!=null && !statmsg.isEmpty()) {
            out.println("<div dojoType=\"dojox.layout.ContentPane\">");
            out.println("<script type=\"dojo/method\">");
            out.println("showStatus('" + statmsg + "');\n");
            out.println("</script>\n");
            out.println("</div>");
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final String action = response.getAction();
        final String suri = request.getParameter("suri");
        
        response.setAction(SWBResourceURL.Action_EDIT);
        response.setRenderParameter("suri", suri);
        
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject semObj = ont.getSemanticObject(suri);
        if(semObj==null) {
            response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
            return;
        }
        
        InitiativeAssignable ias = (InitiativeAssignable) semObj.getGenericInstance();
        User user = response.getUser();
        if(!user.isSigned() || !user.haveAccess(ias)) {
            response.setRenderParameter(STTS_MSG, response.getLocaleString("msgUnauthorizedUser"));
            return;
        }
        BSC model = (BSC)semObj.getModel().getModelObject().getGenericInstance();
        
        if(Action_UPDT_ACTIVE.equalsIgnoreCase(action))
        {
            final String initiativeId = request.getParameter("sval");
            if(initiativeId!=null)
            {
                Initiative initiative = null;
                if(Initiative.ClassMgr.hasInitiative(initiativeId, model)) {
                    initiative = Initiative.ClassMgr.getInitiative(initiativeId, model);
                    if(ias.hasInitiative(initiative)) {
                        ias.removeInitiative(initiative);
                        response.setRenderParameter(STTS_MSG, response.getLocaleString("msgDeallocatedInitiative"));
                    }else {
                        ias.addInitiative(initiative);
                        response.setRenderParameter(STTS_MSG, response.getLocaleString("msgAssignedInitiative"));
                    }
                }else {
                    response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
                }
            }
            else
            {
                response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
            }
        }
        else if(Action_ACTIVE_ALL.equalsIgnoreCase(action))
        {
            Iterator<Initiative> initiatives = model.listValidInitiatives().iterator();
            if(initiatives.hasNext()) {
                ias.removeAllInitiative();
                while(initiatives.hasNext()) {
                    ias.addInitiative(initiatives.next());
                }
                response.setRenderParameter(STTS_MSG, response.getLocaleString("msgAssignedInitiatives"));
            }
        }
        else if (Action_DEACTIVE_ALL.equalsIgnoreCase(action))
        {
            ias.removeAllInitiative();
            response.setRenderParameter(STTS_MSG, response.getLocaleString("msgDeallocatedInitiatives"));
        }
    }
}
