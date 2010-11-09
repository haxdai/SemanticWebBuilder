package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class ThemeManager extends org.semanticwb.ecosikan.innova.base.ThemeManagerBase 
{

    public ThemeManager()
    {
    }

   /**
   * Constructs a ThemeManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ThemeManager
   */
    public ThemeManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("Hello ThemeManager...");    }

}
