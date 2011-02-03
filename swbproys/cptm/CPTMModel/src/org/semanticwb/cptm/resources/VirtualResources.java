/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPortal;
import org.semanticwb.cptm.ActivityRef;
import org.semanticwb.cptm.Event;
import org.semanticwb.cptm.ExperienceRef;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBActionResponseImp;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBParamRequestImp;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author jorge.jimenez
 */
public class VirtualResources extends GenericResource{

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        WebPage page=paramRequest.getWebPage();
        Resource base=paramRequest.getResourceBase();
        Resourceable resourceAble=null;
        if(request.getParameter("id")!=null && request.getParameter("show")!=null){
            String id=request.getParameter("id");
            String show=request.getParameter("show");
            if(show.equalsIgnoreCase("activity")) resourceAble=ActivityRef.ClassMgr.getActivityRef(id, page.getWebSite());
            else if(show.equalsIgnoreCase("experience")) resourceAble=ExperienceRef.ClassMgr.getExperienceRef(id, page.getWebSite());
            else if(show.equalsIgnoreCase("event")) resourceAble=Event.ClassMgr.getEvent(id, page.getWebSite());

            if(resourceAble!=null)
            {
                Iterator<Resource> it=SWBComparator.sortSortableObject(resourceAble.listResources());
                while(it.hasNext())
                {
                    Resource res=it.next();
                    if(res.isValid() && paramRequest.getUser().haveAccess(res))
                    {
                        SWBResource swbres=SWBPortal.getResourceMgr().getResource(res);
                        //SWBParamRequestImp pr=new SWBParamRequestImp(request,res,paramRequest.getWebPage(),paramRequest.getUser());
                        ((SWBParamRequestImp)paramRequest).setResourceBase(res);
                        ((SWBParamRequestImp)paramRequest).setVirtualResource(base);
                        ((SWBParamRequestImp)paramRequest).setCallMethod(SWBParamRequest.Call_CONTENT);
                        swbres.render(request, response, paramRequest);
                    }
                }
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebPage page=response.getWebPage();
        Resource base=response.getResourceBase();
        Resourceable resourceAble=null;
        if(request.getParameter("id")!=null && request.getParameter("show")!=null){
            String id=request.getParameter("id");
            String show=request.getParameter("show");
            if(show.equalsIgnoreCase("activity")) resourceAble=ActivityRef.ClassMgr.getActivityRef(id, page.getWebSite());
            else if(show.equalsIgnoreCase("experience")) resourceAble=ExperienceRef.ClassMgr.getExperienceRef(id, page.getWebSite());
            else if(show.equalsIgnoreCase("event")) resourceAble=Event.ClassMgr.getEvent(id, page.getWebSite());

            if(resourceAble!=null)
            {
                Iterator<Resource> it=SWBComparator.sortSortableObject(resourceAble.listResources());
                while(it.hasNext())
                {
                    Resource res=it.next();
                    if(res.isValid() && response.getUser().haveAccess(res))
                    {
                        SWBResource swbres=SWBPortal.getResourceMgr().getResource(res);
                        //SWBParamRequestImp pr=new SWBParamRequestImp(request,res,paramRequest.getWebPage(),paramRequest.getUser());
                        ((SWBActionResponseImp)response).setResourceBase(res);
                        ((SWBActionResponseImp)response).setVirtualResource(base);
                        swbres.processAction(request, response);
                    }
                }
            }
        }

    }
}
