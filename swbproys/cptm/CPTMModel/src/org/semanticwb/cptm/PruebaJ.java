package org.semanticwb.cptm;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class PruebaJ extends org.semanticwb.cptm.base.PruebaJBase 
{

    public PruebaJ()
    {
    }

   /**
   * Constructs a PruebaJ with a SemanticObject
   * @param base The SemanticObject with the properties for the PruebaJ
   */
    public PruebaJ(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello PruebaJ...");    }

}
