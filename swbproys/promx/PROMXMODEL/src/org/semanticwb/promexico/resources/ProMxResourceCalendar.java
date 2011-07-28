package org.semanticwb.promexico.resources;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class ProMxResourceCalendar extends org.semanticwb.promexico.resources.base.ProMxResourceCalendarBase 
{

    public ProMxResourceCalendar()
    {
    }

   /**
   * Constructs a ProMxResourceCalendar with a SemanticObject
   * @param base The SemanticObject with the properties for the ProMxResourceCalendar
   */
    public ProMxResourceCalendar(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello ProMxResourceCalendar...");    }

}
