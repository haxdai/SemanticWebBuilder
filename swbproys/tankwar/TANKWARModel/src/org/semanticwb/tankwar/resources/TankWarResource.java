package org.semanticwb.tankwar.resources;


import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.tankwar.Tank;

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
    public void doView(HttpServletRequest request, HttpServletResponse response,
                       SWBParamRequest paramRequest)
                       throws SWBResourceException, IOException {

        String action = paramRequest.getAction();

        if (action == null || (action != null &&
                !action.equalsIgnoreCase(SWBParamRequest.Action_ADD))) {
            String path = SWBPortal.getWebWorkPath() + "/models/"
                    + paramRequest.getWebPage().getWebSiteId()
                    + "/jsp/tankWarResource.jsp" ;
            RequestDispatcher rd = request.getRequestDispatcher(path);
            try {
                request.setAttribute("paramRequest", paramRequest);
                if (request.getParameter("tankEditedRes") != null) {
                    request.setAttribute("tankEdited", "yes");
                }
                rd.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        } else {
            WebPage wp = WebPage.ClassMgr.getWebPage("Campo_de_Pruebas",
                                 paramRequest.getWebPage().getWebSite());
            response.sendRedirect(wp.getRealUrl(paramRequest.getUser().getLanguage()));
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
//        System.out.println("Entra a processAction");
        String action=response.getAction();
        WebSite wsite=response.getWebPage().getWebSite();
        
//        Enumeration<String> enumParams=request.getParameterNames();
//        while(enumParams.hasMoreElements())
//        {
//            String pName=enumParams.nextElement();
//            System.out.println("pName:"+pName+", value:"+request.getParameter(pName));
//        }
        
        if(action!=null)
        {
            if(action.equals(response.Action_ADD)) {
                SWBFormMgr mgr = new SWBFormMgr(Tank.tank_Tank, wsite.getSemanticObject(), null);
                try
                {
                    mgr.setFilterRequired(false);
                    SemanticObject semObject = mgr.processForm(request);
                    //Tank tank = (Tank) semObject.createGenericInstance();                    
                }catch(Exception e){
                    log.error(e);
                }
            } else if(action.equals(response.Action_EDIT)) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                try
                {
                    SemanticObject semObj=mgr.processForm(request);
                    Tank tank = (Tank) semObj.createGenericInstance();
                    response.setRenderParameter("tankEditedRes", "yes");
                }catch(Exception e){
                    log.error(e);
                }
            } else if(action.equals(response.Action_REMOVE)) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tankUri"));
                semObject.remove();
                //Tank tank = (Tank) semObject.createGenericInstance();
                //tank.remove();
            }
        }
    }

}
