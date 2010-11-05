package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class Challenge extends org.semanticwb.ecosikan.innova.base.ChallengeBase 
{

    public Challenge()
    {
    }

   /**
   * Constructs a Challenge with a SemanticObject
   * @param base The SemanticObject with the properties for the Challenge
   */
    public Challenge(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("título del reto");
        out.println("descripción del reto");
        out.println("editar");
        out.println("ideas...");
    }

}
