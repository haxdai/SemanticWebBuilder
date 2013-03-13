/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.inmujeres.swb.UserExtended;
import mx.gob.inmujeres.swb.resources.sem.base.UserSubordinado;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class Reportes extends GenericResource
{

    public static final String MODE_REPORTE_RETRO = "retro";
    public static final String MODE_REPORTE_METAS = "metas";
    public static final String MODE_REPORTE_DNC = "dnc";
    public static final String MODE_REPORTE_CUESTIONARIO = "cuestionario";
    public static final String MODE_REPORTE_STATUS = "status";
    public static final String MODE_REPORTE_FILTRO = "filtro";
    public static final String MODE_REPORTE_MENU = "menu";
    public static final String MODE_LIST_SUBORDINADOS = "subordinados";
    public static final String MODE_REPORTE_DNC_GENERAL = "dncgeneral";
    public static final String MODE_REPORTE_EVAL_METAS_ANT = "metasant";
    static Logger log = SWBUtils.getLogger(Survey.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String mode = MODE_REPORTE_MENU;
        if (paramRequest.getMode() != null)
        {
            mode = paramRequest.getMode();
        }
        String jsp = "/work/models/" + siteId + "/jsp/" + Reportes.class.getSimpleName() + "/" + mode + ".jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        request.setAttribute("paramRequest", paramRequest);

        try
        {
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void listSubordinados(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        String iduser = request.getParameter("user");
        out.println("<p>Evaluado:</p><select name=\"evaluado\">");
        if (iduser != null)
        {

            WebSite site = paramRequest.getWebPage().getWebSite();
            User user = site.getUserRepository().getUser(iduser);
            UserExtended ext = UserExtended.ClassMgr.getUserExtended(user.getId(), user.getUserRepository());
            Iterator<User> subordinados = ext.listSubordinados();


            while (subordinados.hasNext())
            {
                User subordinado = subordinados.next();
                out.println("<option value=\"" + subordinado.getId() + "\">" + subordinado.getFullName() + "</option>");
            }

        }
        out.println("</select>");
        //out.close();
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (MODE_LIST_SUBORDINADOS.equals(paramRequest.getMode()))
        {
            listSubordinados(request, response, paramRequest);
            return;
        }
        else if (MODE_REPORTE_EVAL_METAS_ANT.equals(paramRequest.getMode()) || MODE_REPORTE_DNC_GENERAL.equals(paramRequest.getMode()) || MODE_REPORTE_STATUS.equals(paramRequest.getMode()) || MODE_REPORTE_RETRO.equals(paramRequest.getMode()) || MODE_REPORTE_METAS.equals(paramRequest.getMode()) || MODE_REPORTE_MENU.equals(paramRequest.getMode()) || MODE_REPORTE_FILTRO.equals(paramRequest.getMode()) || MODE_REPORTE_DNC.equals(paramRequest.getMode()) || MODE_REPORTE_CUESTIONARIO.equals(paramRequest.getMode()))
        {
            doView(request, response, paramRequest);
            return;
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }

    }
}
