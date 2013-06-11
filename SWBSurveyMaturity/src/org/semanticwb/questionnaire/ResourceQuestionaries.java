package org.semanticwb.questionnaire;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class ResourceQuestionaries extends org.semanticwb.questionnaire.base.ResourceQuestionariesBase 
{

    public ResourceQuestionaries()
    {
    }

   /**
   * Constructs a ResourceQuestionaries with a SemanticObject
   * @param base The SemanticObject with the properties for the ResourceQuestionaries
   */
    public ResourceQuestionaries(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello ResourceQuestionaries...");    }

}
