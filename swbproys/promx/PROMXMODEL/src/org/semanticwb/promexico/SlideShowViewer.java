package org.semanticwb.promexico;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class SlideShowViewer extends org.semanticwb.promexico.base.SlideShowViewerBase 
{

    public SlideShowViewer()
    {
    }

   /**
   * Constructs a SlideShowViewer with a SemanticObject
   * @param base The SemanticObject with the properties for the SlideShowViewer
   */
    public SlideShowViewer(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello SlideShowViewer...");    }

}
