package com.infotec.eworkplace.swb.resources.sem;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class ReservaEventoManager extends com.infotec.eworkplace.swb.resources.sem.base.ReservaEventoManagerBase 
{

    public ReservaEventoManager()
    {
    }

   /**
   * Constructs a ReservaEventoManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaEventoManager
   */
    public ReservaEventoManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello ReservaEventoManager...");    }

}
