package org.semanticwb.portal.resources.sem.pressroom;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class PressRoom extends org.semanticwb.portal.resources.sem.pressroom.base.PressRoomBase 
{

    public PressRoom()
    {
    }

   /**
   * Constructs a PressRoom with a SemanticObject
   * @param base The SemanticObject with the properties for the PressRoom
   */
    public PressRoom(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello PressRoom...");    }

}
