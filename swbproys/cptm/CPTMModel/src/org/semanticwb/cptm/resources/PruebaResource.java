/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

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

/**
 *
 * @author jorge.jimenez
 */
public class PruebaResource extends GenericResource{

    private static Logger log = SWBUtils.getLogger(PruebaResource.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/prueba.jsp";
        System.out.println("path:"+path);
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
        WebPage wpage = response.getWebPage();
        System.out.println("Entra a processAction");
        SWBFormMgr mgr = new SWBFormMgr(org.semanticwb.cptm.Prueba.sclass, getResourceBase().getSemanticObject(), SWBFormMgr.MODE_CREATE);
        try{
            SemanticObject sobj=mgr.processForm(request);
            mgr.processElement(request, org.semanticwb.cptm.Prueba.cptm_hasfiles);
            org.semanticwb.cptm.Prueba pruebaObj=(org.semanticwb.cptm.Prueba)sobj.createGenericInstance();
            System.out.println("Entra a processAction-Proceso...:"+pruebaObj.listfileses());
            Iterator<String> itsFiles=pruebaObj.listfileses();
            while (itsFiles.hasNext()) {
                String sFile = itsFiles.next();
                System.out.println("File:"+sFile);
            }

        }catch(Exception e){
            log.error(e);
        }
    }
}