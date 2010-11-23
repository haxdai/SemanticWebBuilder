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
import org.semanticwb.pymtur.Instalation;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author martha.jimenez
 */
public class Installations extends GenericResource{
    private static Logger log = SWBUtils.getLogger(Installations.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        RequestDispatcher dis = null;
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
            path = siteWorkDir + "/jsp/pymestur/microsite/installations.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            if (action != null && action.equalsIgnoreCase("editInstallations"))
            {
                path = siteWorkDir + "/jsp/pymestur/premier/editInstallations.jsp";
            } else
            {
                path = siteWorkDir + "/jsp/pymestur/premier/installations.jsp";
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
        try {
            if (request.getParameter("uri") != null && action != null && action.equalsIgnoreCase("saveInstallations")) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.clearProperties();
                mgr.addProperty(Hospedaje.pymtur_hasInstalation);
                mgr.addProperty(Hospedaje.pymtur_spInstalationsDescr);
                ServiceProvider sprovider = (ServiceProvider)semObject.createGenericInstance();
                if(request.getParameterValues(Hospedaje.pymtur_hasInstalation.getName())==null)
                {
                    Iterator it = sprovider.listInstalations();
                    while(it.hasNext())
                    {
                        sprovider.removeInstalation((Instalation)it.next());
                    }
                }
                mgr.processForm(request);
                String description = request.getParameter(Hospedaje.pymtur_spInstalationsDescr.getName());
                if(description!=null&&description.length()>600)
                {
                    description = description.substring(0, 599);
                    response.setRenderParameter("errInstDesc", "Unicamente se han guardado los primeros 600 caracteres del campo de descripción de Instalaciones");
                    sprovider.setSpInstalationsDescr(description);
                }

            }
        } catch (FormValidateException e) {
            log.error(e);
        }
    }

}
