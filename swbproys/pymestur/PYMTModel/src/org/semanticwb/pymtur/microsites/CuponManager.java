
package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.util.Enumeration;
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
import org.semanticwb.pymtur.Cupon;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author carlos.ramos
 */
public class CuponManager extends GenericResource {
    private static Logger log = SWBUtils.getLogger(CuponManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        RequestDispatcher dis = request.getRequestDispatcher("/work/models/etour/jsp/pymestur/microsite/spCupons.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException  {
        String action=response.getAction();
        if(action.equals("add_cupon")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(Cupon.sclass, semObject, null);
            mgr.setFilterRequired(false);
            if( isValidValue(request.getParameter("title")) && isValidValue(request.getParameter("description")) ) {
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Cupon cupon = (Cupon) sobj.createGenericInstance();
                    cupon.setCuponType(request.getParameter("is"));
                    cupon.setCuponImg(request.getParameter("pimg"));
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    serviceProv.addCupon(cupon);
                }catch(Exception e){
                    log.error(e);
                }
            }
        }else if(action.equals("edit_cupon")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            mgr.setFilterRequired(false);
            if( isValidValue(request.getParameter("title")) && isValidValue(request.getParameter("description")) && isValidValue(request.getParameter("pimg")) ) {
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Cupon cupon = (Cupon) sobj.createGenericInstance();
                    cupon.setCuponType(request.getParameter("is"));
                    cupon.setCuponImg(request.getParameter("pimg"));
                }catch(Exception e){
                    log.error(e);
                }
            }
        }else if(action.equals("remove_cupon")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Cupon cupon = (Cupon) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeCupon(cupon);
            semObject.remove();
        }
    }

    private boolean isValidValue(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            validValue = true;
        return validValue;
    }

    private boolean isValidNumber(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            try {
                Double.parseDouble(param);
                validValue = true;
            }catch(NumberFormatException  nfe) {
                validValue = false;
            }
        return validValue;
    }
}
