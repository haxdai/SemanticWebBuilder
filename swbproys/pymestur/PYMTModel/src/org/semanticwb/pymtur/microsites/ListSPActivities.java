/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.Activity;
import org.semanticwb.pymtur.Hospedaje;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.pymtur.util.PymturUtils;

/**
 *
 * @author jorge.jimenez
 */
public class ListSPActivities extends GenericResource{

    private static Logger log = SWBUtils.getLogger(ListSPActivities.class);


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = null;
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId();
        String action = paramRequest.getAction();
        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }
        String siteUri = ((MicroSitePyme) community).getType().getURI();

        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
            path = siteWorkDir + "/jsp/pymestur/microsite/listSPActivities.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            if (action != null && action.equalsIgnoreCase("editActivities")){
                path = siteWorkDir + "/jsp/pymestur/premier/editSPActivities.jsp";
            } else{
                path = siteWorkDir + "/jsp/pymestur/premier/listSPActivities.jsp";
            }
        }
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if (request.getParameter("uri") != null && action != null && action.equalsIgnoreCase("saveSPActivities")) {
            try {
                response.setAction("editActivities");
                String description = request.getParameter(Hospedaje.pymtur_spActivitiesDescr.getName());
                int descLength=600+PymturUtils.countEnterChars(description,600);
                if( !PymturUtils.validateRegExp(description, "^([^(<>&%#)]{0,"+descLength+"})$")){
                    response.setRenderParameter("msgErrDescActs", "Verifica que el tamaño del texto no exceda los 600 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
                response.setAction(SWBResourceURL.Mode_VIEW);
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.clearProperties();
                mgr.addProperty(Hospedaje.pymtur_hasSPActivity);
                mgr.addProperty(Hospedaje.pymtur_spActivitiesDescr);
                ServiceProvider sprovider = (ServiceProvider)semObject.createGenericInstance();
                if(request.getParameterValues(Hospedaje.pymtur_hasSPActivity.getName())==null){
                    Iterator it = sprovider.listSPActivities();
                    while(it.hasNext()){
                        sprovider.removeSPActivity((Activity)it.next());
                    }
                }
                mgr.processForm(request);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
