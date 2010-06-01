/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.sieps.search;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class SearchResource extends GenericResource
{

    private static Logger log = SWBUtils.getLogger(SearchResource.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path ="/swbadmin/jsp/sieps/search.jsp";
        if ("search".equals(paramRequest.getArgument("mode")))
        {
            path = "/swbadmin/jsp/sieps/search.jsp";
        }
        else
        {
            String query=request.getParameter("query");
            if(null==query)
            {
                path = "/swbadmin/jsp/sieps/search.jsp";
            }
            else
            {
                Iterator<SemanticObject> results=null;
                request.setAttribute("results", results);
                String act = request.getParameter("act");
                if (act == null)
                {
                    act = "results";
                }
                path = "/swbadmin/jsp/sieps/results.jsp";
                if (act.equals("detail") && request.getParameter("uri")!=null)
                {
                    GenericObject obj=SemanticObject.createSemanticObject(request.getParameter("uri")).createGenericInstance();
                    if(obj==null)
                    {
                        path = "/swbadmin/jsp/sieps/search.jsp";
                    }
                    else
                    {
                        request.setAttribute("obj", obj);
                        path = "/swbadmin/jsp/sieps/detail.jsp";
                    }
                    
                    
                }
            }
        }
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }
}
