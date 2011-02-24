package mx.gob.stps.portalempleo.swb;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class EventManager extends mx.gob.stps.portalempleo.swb.base.EventManagerBase 
{

    public EventManager()
    {
    }

   /**
   * Constructs a EventManager with a SemanticObject
   * @param base The SemanticObject with the properties for the EventManager
   */
    public EventManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello EventManager...");    }

}
