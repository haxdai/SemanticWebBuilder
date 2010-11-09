package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class ChallengeManager extends org.semanticwb.ecosikan.innova.base.ChallengeManagerBase 
{

    public ChallengeManager()
    {
    }

   /**
   * Constructs a ChallengeManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ChallengeManager
   */
    public ChallengeManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello ChallengeManager...");    }

}
