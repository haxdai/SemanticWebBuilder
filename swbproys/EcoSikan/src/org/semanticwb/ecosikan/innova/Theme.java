package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class Theme extends org.semanticwb.ecosikan.innova.base.ThemeBase 
{

    public Theme()
    {
    }

   /**
   * Constructs a Theme with a SemanticObject
   * @param base The SemanticObject with the properties for the Theme
   */
    public Theme(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("listado de secretarías");
        out.println("secretaría");
        out.println("título del tema");
        out.println("descripción del tema");
        out.println("agregar|editar|eliminar");
        out.println("ideas...");
        out.println("ver listado de temas");
    }

}
