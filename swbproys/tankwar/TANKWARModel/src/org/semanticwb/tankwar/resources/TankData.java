/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.tankwar.resources;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.tankwar.Tank;
import org.semanticwb.tankwar.TankComment;

/**
 *
 * @author jorge.jimenez
 */
public class TankData extends GenericResource{

     private static Logger log = SWBUtils.getLogger(ListTanks.class);

      @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
       String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/tankData.jsp" ;
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try{
            request.setAttribute("paramRequest",paramRequest);
            rd.include(request, response);
        }catch(Exception e)
        {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String action=response.getAction();
        WebSite wsite=response.getWebPage().getWebSite();
        User user=response.getUser();
        if(action!=null)
        {
            if(action.equals("addComent") && request.getParameter("tankUri")!=null && request.getParameter("description")!=null)
            {
                SWBFormMgr mgr = new SWBFormMgr(TankComment.tank_TankComment, wsite.getSemanticObject(), null);
                try
                {
                    mgr.setFilterRequired(false);
                    SemanticObject semObject = mgr.processForm(request);
                    TankComment TankComment = (TankComment) semObject.createGenericInstance();
                    //TankComment.setDescription(request.getParameter("description"));
                    SemanticObject semObjectTank = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                    Tank tank = (Tank) semObjectTank.createGenericInstance();
                    TankComment.setCommTank(tank);                    
                }catch(Exception e){
                    log.error(e);
                }
            }else  if(action.equals("addFavorite"))
            {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                Tank tank = (Tank) semObject.createGenericInstance();
                if(!tank.hasUserFavorite(user))
                {
                    tank.addUserFavorite(user);
                }
            }else if(action.equals("removeFavorite"))
            {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                Tank tank = (Tank) semObject.createGenericInstance();
                if(tank.hasUserFavorite(user))
                {
                    tank.removeUserFavorite(user);
                }
            }
            response.setRenderParameter("tankUri", request.getParameter("tankUri"));
            response.setAction(response.Mode_VIEW);
        }
    }

}
