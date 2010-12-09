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
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.Hospedaje;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.Nearest;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.pymtur.util.PymturUtils;

/**
 *
 * @author jorge.jimenez
 */
public class Surroundings extends GenericResource{

    private static Logger log = SWBUtils.getLogger(Surroundings.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        RequestDispatcher dis = null;
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = null;
        String action = paramRequest.getAction();
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId();

        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }
        String siteUri = ((MicroSitePyme) community).getType().getURI();
        
        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite",
                wp.getWebSite()).getURI().equals(siteUri)) {
            path = siteWorkDir + "/jsp/pymestur/microsite/surroundings.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus",
                wp.getWebSite()).getURI().equals(siteUri)) {
            if (action != null && action.equalsIgnoreCase("editSurroundings")) {
                path = siteWorkDir + "/jsp/pymestur/premier/surroundingsEdit.jsp";
            } else {
                path = siteWorkDir + "/jsp/pymestur/premier/surroundings.jsp";
            }
        }
        dis = request.getRequestDispatcher(path);
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
        if (request.getParameter("uri") != null && action != null && action.equalsIgnoreCase("saveSurroundings"))
        {
            try {
                response.setAction("editSurroundings");
                String description = request.getParameter(Hospedaje.pymtur_NearestDescr.getName());
                int descLength=600+PymturUtils.calcLength(description,600);
                if( !PymturUtils.validateRegExp(description, "^([^(<>&%#)]{0,"+descLength+"})$"))
                {
                    response.setRenderParameter("msgErrDescSour", "Verifica que el tamaño del texto no exceda los 600 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
                response.setAction(null);
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.clearProperties();
                mgr.addProperty(Hospedaje.pymtur_hasNearest);
                mgr.addProperty(Hospedaje.pymtur_NearestDescr);
                ServiceProvider sprovider = (ServiceProvider)semObject.createGenericInstance();
                if(request.getParameterValues(Hospedaje.pymtur_hasNearest.getName())==null)
                {
                    Iterator it = sprovider.listNearests();
                    while(it.hasNext())
                    {
                        sprovider.removeNearest((Nearest)it.next());
                    }
                }
                mgr.processForm(request);
                
                /*if(description!=null&&description.length()>descLength)
                {
                    description = description.substring(0, descLength);
                    response.setRenderParameter("errNearDesc", "Unicamente se han guardado los primeros 600 caracteres del campo de descripción de Cercanías");
                    sprovider.setNearestDescr(description);
                }*/
            } catch (FormValidateException e) {
                log.error(e);
            }
        }
    }

}
