package org.semanticwb.bsc.admin.resources.behavior;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.InitiativeAssignable;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Initiative;
import org.semanticwb.bsc.element.Risk;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 * Permite visualizar, editar y eliminar Iniciativas de un Riesgo en especifico.
 * Esta iniciativa fue creada desde el tablero de riesgos.
 *
 * @author martha.jimenez
 * @version %I%, %G%
 * @since 1.0
 */
public class InitiativeRiskManager extends GenericResource {
//    public static org.semanticwb.platform.SemanticProperty bsc_hasInitiativeRisk =
//            org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().
//            getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasInitiativeRisk");

    public static final String Action_DELETE = "delete";
    public static final String Action_ACTIVE_ALL = "actall";
    public static final String Action_DEACTIVE_ALL = "deactall";
    public static final String Action_UPDT_ACTIVE = "updactv";
    public static final String Action_UPDT_ASSIGN = "updassgn";
    public static final String STTS_MSG = "sttsmsg";

    /**
     * M&eacute;todo que se encarga de presentar la vista para visualizar,
     * editar o eliminar una iniciativa en un Riesgo. Esta iniciativa fue creada
     * desde el tablero de riesgos.
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
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        User user = paramRequest.getUser();
        if (user == null || !user.isSigned()) {
            response.sendError(403);
            return;
        }
        
        final String suri = request.getParameter("suri");
        /*final String suri = request.getParameter("suri") == null
                ? (request.getSession().getAttribute("suri") == null 
                    ? null 
                    : (String) request.getSession().getAttribute("suri"))
                : request.getParameter("suri");*/
        if(suri==null) {
            response.getWriter().println(paramRequest.getLocaleString("msgNoSuchSemanticElement"));
            return;
        }
        
        Risk risk;
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject semObj = ont.getSemanticObject(suri);
        if( !(semObj.createGenericInstance() instanceof Risk) ) {
            return;
        }else {
            risk = (Risk) semObj.createGenericInstance();
        }            
        if(risk==null) {
            response.getWriter().println(paramRequest.getLocaleString("msgNoSuchSemanticElement"));
            return;
        }
        
        final String lang = user.getLanguage();
        StringBuilder htm = new StringBuilder();
        htm.append("<script type=\"text/javascript\">");
        htm.append("  dojo.require('dojo.parser');");
        htm.append("  dojo.require('dijit.layout.ContentPane');");
        htm.append("  dojo.require('dijit.form.CheckBox');");
        htm.append("</script>");

        htm.append("<div class=\"swbform\">");
        htm.append("<fieldset>\n");
        htm.append("<table width=\"98%\">");
        htm.append("<thead>");
        htm.append("<tr>");
        htm.append("<th></th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblTitle"));
        htm.append("</th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblDescription"));
        htm.append("</th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblSponsor"));
        htm.append("</th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblArea"));
        htm.append("</th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblFirstPeriod"));
        htm.append("</th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblLastPeriod"));
        htm.append("</th>");
        htm.append("<th>");
        htm.append(paramRequest.getLocaleString("lblActive"));
        htm.append("</th>");
        htm.append("<th>").append(paramRequest.getLocaleString("lblRelate"));
        htm.append("</th>");
        htm.append("</tr>");
        htm.append("</thead>\n");
        
        InitiativeAssignable ias = (InitiativeAssignable)risk;
        //Iterator<Initiative> it = ias.listInitiatives();
        BSC bsc = (BSC)semObj.getModel().getModelObject().createGenericInstance();
        Iterator<Initiative> it = bsc.listInitiatives();
        
        Initiative initiative;
        SWBResourceURL urlDelete;
        urlDelete = paramRequest.getActionUrl();
        urlDelete.setAction(Action_DELETE);
        urlDelete.setParameter("suri", suri);
        urlDelete.setParameter("reloadTab", "true");
        SWBResourceURL urlAxn;
        urlAxn = paramRequest.getActionUrl();
        urlAxn.setParameter("suri", suri);
        Period p;
        while(it.hasNext())
        {
            initiative = it.next();
            if(null == initiative) {
                continue;
            }
            if(  (initiative.isValid() && user.haveAccess(initiative)) || (ias.hasInitiative(initiative) && !initiative.isActive() && user.haveAccess(initiative))  )
            {
                if(user.haveAccess(initiative)) {
                    
                    urlDelete.setParameter("sval", initiative.getId());
                    urlAxn.setParameter("sval", initiative.getId());
                    
                    htm.append("<tr>");
                    // Acción
                    htm.append("<td>");
                    htm.append("\n<a href=\"#\" onclick=\"if(confirm('");
                    htm.append(paramRequest.getLocaleString("msgDeleteQuery"));
                    htm.append("')){submitUrl('");
                    htm.append(urlDelete);
                    htm.append("',this);reloadTab('");
                    htm.append(ias.getURI());
                    htm.append("');} else{return false;}\">");
                    htm.append("\n<img src=\"");
                    htm.append(SWBPlatform.getContextPath());
                    htm.append("/swbadmin/icons/iconelim.png\" alt=\"");
                    htm.append(paramRequest.getLocaleString("lblDelete"));
                    htm.append("\"/>");
                    htm.append("\n</a>");
                    htm.append("</td>\n");
                    // Título de la iniciativa
                    htm.append("<td>");
                    htm.append("<a href=\"#\" onclick=\"addNewTab('");
                    htm.append(initiative.getURI());
                    htm.append("','");
                    htm.append(SWBPlatform.getContextPath());
                    htm.append("/swbadmin/jsp/objectTab.jsp");
                    htm.append("','");
                    htm.append(initiative.getTitle());
                    htm.append("');return false;\" >");
                    htm.append(initiative.getDisplayTitle(lang).replaceAll("'", ""));
                    htm.append("</a>");
                    htm.append("</td>\n");
                    // Descripción de la iniciativa
                    htm.append("<td>");                    
                    htm.append(initiative.getDisplayDescription(lang) == null
                            ? "Not set"
                            : initiative.getDisplayDescription(lang).substring(0
                                    , initiative.getDisplayDescription(lang).length()>=30
                                            ?30
                                            :initiative.getDisplayDescription(lang).length()));
                    htm.append("</td>\n");
                    // Responsable
                    htm.append("<td>");
                    htm.append(initiative.getInitiativeFacilitator()==null
                            ?"Not set":initiative.getInitiativeFacilitator().getFullName());
                    htm.append("</td>\n");
                    // Area
                    htm.append("<td>");
                    htm.append(initiative.getArea()==null?"Not set":initiative.getArea());
                    htm.append("</td>\n");
                    
                    p = initiative.getFirstPeriod();
                    if(null==p) {
                        htm.append("<td>Not set</td>\n");
                        htm.append("<td>Not set</td>\n");
                    }else {
                        htm.append("<td>");
                        htm.append(p.getDisplayTitle(lang));
                        htm.append("</td>\n");
                        p = initiative.getLastPeriod();
                        htm.append("<td>");
                        htm.append(p.getDisplayTitle(lang));
                        htm.append("</td>\n");
                    }
                    /*
                    // Fecha de creación de la iniciativa
                    htm.append("<td>");
                    htm.append((initiative.getCreated() == null ? "Not set"
                            : SWBUtils.TEXT.getStrDate(initiative.getCreated(),
                                    "es", "dd/mm/yyyy")));
                    htm.append("</td>\n");
                    // Fecha de la última actualización de la iniciativa
                    htm.append("<td>");
                    htm.append((initiative.getUpdated() == null ? "Not set"
                            : SWBUtils.TEXT.getStrDate(initiative.getCreated(),
                                    "es", "dd/mm/yyyy")));
                    htm.append("</td>\n");*/
                    
                    // Iniciativa activa/inactiva
                    htm.append("     <td align=\"center\"><input name=\"");
                    htm.append(Initiative.swb_active.getName());
                    htm.append("\"");
                    htm.append(" type=\"checkbox\" name=\"initiative\" value=\"");
                    htm.append(initiative.getId());
                    htm.append("\"  onchange=\"submitUrl('");
                    htm.append(urlAxn.setAction(Action_UPDT_ACTIVE));
                    htm.append("&'+this.attr('name')+'='+this.attr('value'),this.domNode)\" ");
                    htm.append(" dojoType=\"dijit.form.CheckBox\" ");
                    htm.append(initiative.isActive() ? "checked=\"checked\"" : "");
                    htm.append("/>");
                    htm.append("</td>\n");
                    // Asignar
                    htm.append("<td align=\"center\">");
                    htm.append("<input type=\"checkbox\" name=\"initiative\" ");
                    htm.append("onchange=\"submitUrl('");
                    htm.append(urlAxn.setAction(Action_UPDT_ASSIGN));
                    htm.append("&'+this.attr('name')+'='+this.attr('value'),this.domNode)\" ");
                    htm.append(" dojoType=\"dijit.form.CheckBox\" value=\"");
                    htm.append(initiative.getId()).append("\"");
                    //htm.append(semObj.hasObjectProperty(InitiativeAssignable.bsc_hasInitiative, initiative.getSemanticObject())?"checked=\"checked\"":"").append(" />");
                    htm.append(ias.hasInitiative(initiative)?" checked=\"checked\" ":"").append(" />");
                    htm.append("</td>\n");
                    
                    htm.append("</tr>\n");
                }
            }
        }
        htm.append("</table>\n");
        htm.append("</fieldset>\n");

        /*if (hasInitiative)
        {
            SWBResourceURL urlAll = paramRequest.getActionUrl();
            urlAll.setParameter("suri", suri);
            urlAll.setAction(Action_ACTIVE_ALL);
            htm.append("<fieldset>");
            htm.append("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('");
            htm.append(urlAll);
            htm.append("',this.domNode); \">");
            htm.append(paramRequest.getLocaleString("lblActiveAll"));
            htm.append("</button>");

            urlAll.setAction(Action_DEACTIVE_ALL);
            htm.append("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('");
            htm.append(urlAll);
            htm.append("',this.domNode); \">");
            htm.append(paramRequest.getLocaleString("lblDisabledAll"));
            htm.append("</button>");
            htm.append("</fieldset>");
        }*/
        htm.append("</div>");
        
        String statmsg = request.getParameter(STTS_MSG);
        if( statmsg!=null && !statmsg.isEmpty())
        {
            htm.append("<div dojoType=\"dojox.layout.ContentPane\">\n");
            htm.append("<script type=\"dojo/method\">\n");
            htm.append("showStatus('"); 
            htm.append(request.getParameter(STTS_MSG));
            htm.append("');\n");
            if(request.getParameter("objURI") != null && !request.getParameter("objURI").isEmpty()) {
                SemanticObject semObj1 = SemanticObject.createSemanticObject(request.getParameter("objURI"));
                htm.append("updateTreeNodeByURI('");
                htm.append(semObj1.getURI());
                htm.append("');\n");
            }
            if(request.getParameter("allURI") != null && !request.getParameter("allURI").isEmpty()) {
                Iterator<Initiative> aux;
                aux = risk.listInitiatives();
                Initiative ini;
                while (aux.hasNext()) {
                    ini = aux.next();
                    htm.append("updateTreeNodeByURI('");
                    htm.append(ini.getURI());
                    htm.append("');\n");
                }
            }
            htm.append("</script>\n");
            htm.append("</div>");
        }
        PrintWriter out = response.getWriter();
        out.println(htm.toString());
    }

    /**
     *
     * M&eacute;todo que se encarga de persistir la informaci&oacute;n de forma
     * segura de la administraci&oacute;n de iniciativas de un Riesgo. Esta
     * asociación se hace desde el tablero de Riesgos.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param response Objeto con el cual se acceden a los objetos de SWB
     * @throws SWBResourceException Excepti&oacute;n utilizada para recursos de
     * SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException {
        final String action = response.getAction();
        final String suri = request.getParameter("suri");
        response.setAction(SWBResourceURL.Action_EDIT);
        response.setRenderParameter("suri", suri);

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject semObj = ont.getSemanticObject(suri);
        if(semObj==null) {
            response.setRenderParameter("statmsg", response.getLocaleString("msgNoSuchSemanticElement"));
            return;
        }
        
        InitiativeAssignable ias = (InitiativeAssignable)semObj.getGenericInstance();
        User user = response.getUser();
        if(!user.isSigned() || !user.haveAccess(ias)) {
            response.setRenderParameter("statmsg", response.getLocaleString("msgUnauthorizedUser"));
            return;
        }
        BSC bsc = (BSC)semObj.getModel().getModelObject().createGenericInstance();
        
        if(Action_DELETE.equalsIgnoreCase(action))
        {
            final String mitInitiativeId = request.getParameter("sval");
            if (mitInitiativeId != null) {
                Initiative initiative;
                if (Initiative.ClassMgr.hasInitiative(mitInitiativeId, bsc)) {
                    initiative = Initiative.ClassMgr.
                            getInitiative(mitInitiativeId, bsc);
                    ias.removeInitiative(initiative);
                    initiative.remove();
                    response.setRenderParameter(STTS_MSG, response.getLocaleString("msgDeleteSuccessful"));
                }
            }
        }
        else if(Action_UPDT_ACTIVE.equalsIgnoreCase(action))
        {
            final String initiativeId = request.getParameter("sval");
            if(initiativeId != null) {
                if(Initiative.ClassMgr.hasInitiative(initiativeId, bsc)) {
                    Initiative initiative = Initiative.ClassMgr.getInitiative(initiativeId, bsc);
                    if(initiative.isActive()) {
                        initiative.setActive(false);
                        response.setRenderParameter(STTS_MSG, response.getLocaleString("msgDisabledInitiative"));
                    }else {
                        initiative.setActive(true);
                        response.setRenderParameter(STTS_MSG, response.getLocaleString("msgActiveInitiative"));
                    }
                    response.setRenderParameter("objURI", initiative.getURI());
                }else {
                    response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
                }
            }else {
                response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
            }
        }
        else if(Action_ACTIVE_ALL.equalsIgnoreCase(action))
        {
            Iterator it = ias.listInitiatives();
            while (it.hasNext()) {
                Initiative initiative = (Initiative) it.next();
                initiative.setActive(true);
            }
            response.setRenderParameter("allURI", "allURI");
            response.setRenderParameter(STTS_MSG, response.getLocaleString("msgActiveAllInitiatives"));
        }
        else if (Action_DEACTIVE_ALL.equalsIgnoreCase(action))
        {
            Iterator it = ias.listInitiatives();
            while (it.hasNext()) {
                Initiative initiative = (Initiative) it.next();
                initiative.setActive(false);
            }
            response.setRenderParameter("allURI", "allURI");
            response.setRenderParameter(STTS_MSG, response.getLocaleString("msgDisabledAllInitiatives"));
        }
        else if(Action_UPDT_ASSIGN.equalsIgnoreCase(action))
        {
            final String initiativeId = request.getParameter("sval");
            if(initiativeId != null) {
                if(Initiative.ClassMgr.hasInitiative(initiativeId, bsc)) {
                    Initiative initiative = Initiative.ClassMgr.getInitiative(initiativeId, bsc);
System.out.println("ias ya tiene esta iniciativa?:"+ias.hasInitiative(initiative));
                    if(ias.hasInitiative(initiative)) {
                        ias.removeInitiative(initiative);
                        response.setRenderParameter(STTS_MSG, response.getLocaleString("msgDeallocatedInitiative"));
                    }else {
                        ias.addInitiative(initiative);
                        response.setRenderParameter(STTS_MSG, response.getLocaleString("msgAssignedInitiative"));
                    }
                    response.setRenderParameter("objURI", initiative.getURI());
                }else {
                    response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
                }
            }else {
                response.setRenderParameter(STTS_MSG, response.getLocaleString("msgNoSuchSemanticElement"));
            }
        }
    }

}
