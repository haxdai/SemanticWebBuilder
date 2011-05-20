package org.semanticwb.tankwar;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class TankWarResource extends org.semanticwb.tankwar.base.TankWarResourceBase 
{

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
        PrintWriter out=response.getWriter();
        out.println("Hello TankWarResource...");    
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {

        String action=response.getAction();
        if(action!=null)
        {
            if(action.equals("createTank")){

            }
        }
    }

}
