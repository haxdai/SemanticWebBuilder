package org.semanticwb.tankwar.resources;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.*;

public class ListTanks extends org.semanticwb.tankwar.resources.base.ListTanksBase
{
    private static Logger log = SWBUtils.getLogger(ListTanks.class);

    public ListTanks()
    {
    }

   /**
   * Constructs a ListTanks with a SemanticObject
   * @param base The SemanticObject with the properties for the ListTanks
   */
    public ListTanks(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
       String path = SWBPortal.getWebWorkPath() +"/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/listTanks.jsp" ;
        RequestDispatcher rd = request.getRequestDispatcher(path);
        try{
            request.setAttribute("paramRequest",paramRequest);
            rd.include(request, response);
        }catch(Exception e)
        {
            log.error(e);
        }
    }
}