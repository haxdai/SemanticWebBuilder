package org.semanticwb.tankwar.resources;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.tankwar.Tank;
import org.semanticwb.tankwar.TankComment;
import org.semanticwb.tankwar.TankType;

public class TankWarResource extends org.semanticwb.tankwar.resources.base.TankWarResourceBase 
{
    private static Logger log = SWBUtils.getLogger(TankWarResource.class);

    public TankWarResource()
    {
    }

   /**
   * Constructs a TankWarResource with a SemanticObject
   * @param base The SemanticObject with the properties for the TankWarResource
   */
    public TankWarResource(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/tankWarResource.jsp" ;
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
        if(action!=null)
        {
            if(action.equals(response.Action_ADD)){
                SWBFormMgr mgr = new SWBFormMgr(Tank.tank_Tank, wsite.getSemanticObject(), null);
                try
                {
                    SemanticObject semObject = mgr.processForm(request);
                    Tank tank = (Tank) semObject.createGenericInstance();
                    if(request.getParameter("tankTypeUri")!=null)
                    {
                        SemanticObject sObjTankType = SemanticObject.createSemanticObject(request.getParameter("tankTypeUri"));
                        TankType tankType = (TankType) sObjTankType.createGenericInstance();
                        tank.setTankType(tankType);
                    }
                }catch(Exception e){
                    log.error(e);
                }
            }else if(action.equals(response.Action_EDIT)){
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                try
                {
                    SemanticObject semObj=mgr.processForm(request);
                    Tank tank = (Tank) semObj.createGenericInstance();
                    if(request.getParameter("tankTypeUri")!=null)
                    {
                        SemanticObject sObjTankType = SemanticObject.createSemanticObject(request.getParameter("tankTypeUri"));
                        TankType tankType = (TankType) sObjTankType.createGenericInstance();
                        tank.setTankType(tankType);
                    }
                }catch(Exception e){
                    log.error(e);
                }
            }else if(action.equals(response.Action_REMOVE))
            {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                semObject.remove();
                //Tank tank = (Tank) semObject.createGenericInstance();
                //tank.remove();
            }else if(action.equals("addComent") && request.getParameter("tankUri")!=null && request.getParameter("description")!=null)
            {
                SWBFormMgr mgr = new SWBFormMgr(TankComment.tank_TankComment, wsite.getSemanticObject(), null);
                try
                {
                    SemanticObject semObject = mgr.processForm(request);
                    TankComment TankComment = (TankComment) semObject.createGenericInstance();
                    TankComment.setDescription(request.getParameter("description"));
                    SemanticObject semObjectTank = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                    Tank tank = (Tank) semObjectTank.createGenericInstance();
                    TankComment.setCommTank(tank);

                }catch(Exception e){
                    log.error(e);
                }
            }
        }
    }

}
