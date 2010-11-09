package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import org.semanticwb.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.*;

public class ThemeManager extends org.semanticwb.ecosikan.innova.base.ThemeManagerBase 
{
    private static Logger log = SWBUtils.getLogger(ThemeManager.class);

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
        String path = "/work/models/EcoSikan/jsp/themes/init.jsp";
        String action = paramRequest.getAction();
        if( paramRequest.Action_ADD.equals(action) )
            path = "/work/models/EcoSikan/jsp/themes/add.jsp";
        else if( paramRequest.Action_EDIT.equals(action) )
            path = "/work/models/EcoSikan/jsp/themes/edit.jsp";

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
            System.out.println(e);
        }
    }

}
