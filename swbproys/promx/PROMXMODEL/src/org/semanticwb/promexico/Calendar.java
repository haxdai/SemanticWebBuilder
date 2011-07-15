package org.semanticwb.promexico;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class Calendar extends org.semanticwb.promexico.base.CalendarBase 
{

    public Calendar()
    {
    }

   /**
   * Constructs a Calendar with a SemanticObject
   * @param base The SemanticObject with the properties for the Calendar
   */
    public Calendar(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello Calendar...");    }

}
