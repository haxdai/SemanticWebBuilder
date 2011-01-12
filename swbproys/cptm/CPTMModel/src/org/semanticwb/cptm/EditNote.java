package org.semanticwb.cptm;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class EditNote extends org.semanticwb.cptm.base.EditNoteBase 
{

    public EditNote()
    {
    }

   /**
   * Constructs a EditNote with a SemanticObject
   * @param base The SemanticObject with the properties for the EditNote
   */
    public EditNote(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello EditNote...");    }

}
