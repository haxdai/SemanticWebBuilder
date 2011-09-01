package gob.sep.becas;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class BecasContent extends gob.sep.becas.base.BecasContentBase 
{

    public BecasContent()
    {
    }

   /**
   * Constructs a BecasContent with a SemanticObject
   * @param base The SemanticObject with the properties for the BecasContent
   */
    public BecasContent(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello BecasContent...");    }

}
