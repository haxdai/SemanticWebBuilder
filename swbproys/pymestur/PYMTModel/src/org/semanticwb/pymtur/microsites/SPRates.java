/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.pymtur.Rate;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class SPRates extends GenericResource{

    private static Logger log = SWBUtils.getLogger(SPRates.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        RequestDispatcher dis = request.getRequestDispatcher("/work/models/etour/jsp/pymestur/microsite/spRates.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String action=response.getAction();
        if(action.equals(response.Action_ADD)){
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(Rate.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try
            {
                SemanticObject sobj = mgr.processForm(request);
                Rate rate = (Rate) sobj.createGenericInstance();
                
                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                serviceProv.addRate(rate);
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equals(response.Action_EDIT)){
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            mgr.setFilterRequired(false);
            try
            {
                mgr.processForm(request);
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equals(response.Action_REMOVE)){
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Rate rate = (Rate) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeRate(rate);
            semObject.remove();
        }
    }

}
