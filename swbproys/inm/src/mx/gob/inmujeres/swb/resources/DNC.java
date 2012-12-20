/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.inmujeres.swb.Desempenio;
import mx.gob.inmujeres.swb.TipoMedida;
import mx.gob.inmujeres.swb.Trimestre;
import mx.gob.inmujeres.swb.resources.sem.base.Autentificacion;
import mx.gob.inmujeres.swb.resources.sem.base.UserSubordinado;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class DNC extends GenericResource
{

    static Logger log = SWBUtils.getLogger(Survey.class);
    public static final String MODE_ERROR = "error";
    public static final String MODE_FILL = "filldnc";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String mode = MODE_FILL;
        if (paramRequest.getMode() != null)
        {
            mode = paramRequest.getMode();
        }
        String jsp = "/work/models/" + siteId + "/jsp/" + DNC.class.getSimpleName() + "/" + mode + ".jsp";
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

    public void addCurso(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String curso = request.getParameter("curso");
        String objetivo = request.getParameter("objetivo");
        String idTrimestre = request.getParameter("trimestre");
        String loginEvaluado = request.getParameter("evaluado");

        if (loginEvaluado != null && curso != null && objetivo != null && idTrimestre != null && !"".equals(curso.trim()) && !"".equals(objetivo.trim()) && !"".equals(idTrimestre.trim()))
        {
            User evaluador = response.getUser();
            Autentificacion aut = new Autentificacion();
            User evaluado = site.getUserRepository().getUserByLogin(loginEvaluado);
            List<UserSubordinado> subordinados = aut.getSubordinados(evaluador.getLogin());
            boolean found = true;
            for (UserSubordinado loginsub : subordinados)
            {
                if (loginsub.getLogin().equals(evaluado.getLogin()))
                {
                    found = true;
                }
            }
            if (!found)
            {
                response.setRenderParameter("error", "El evaluado no es subordinado del evealuador");
                response.setMode(MODE_ERROR);
                return;
            }
            Trimestre trimestre = Trimestre.ClassMgr.getTrimestre(idTrimestre, site);
            if (trimestre == null)
            {
                response.setRenderParameter("error", "Trimestre no encontrado");
                response.setMode(MODE_ERROR);
                return;
            }
            int anio = Calendar.getInstance().get(Calendar.YEAR);
            Desempenio evaluacion=null;
            Iterator<Desempenio> evaluaciones=Desempenio.ClassMgr.listDesempenioByDatosEvaluador(evaluador,site);
            while(evaluaciones.hasNext())
            {
                Desempenio evaluacion_temp=evaluaciones.next();
                if(evaluacion_temp.getAnio()==anio && evaluacion_temp.getEvaluadoEvaluada()!=null && evaluacion_temp.getDatosEvaluado().equals(evaluado))
                {
                    evaluacion=evaluacion_temp;
                }
            }
            if(evaluacion==null)
            {
                evaluacion=Desempenio.ClassMgr.createDesempenio(site);
                evaluacion.setAnio(anio);
            }


        }
        else
        {
            response.setRenderParameter("error", "La información es incorrecta");
            response.setMode(MODE_ERROR);
            return;
        }
    }

    public void addMeta(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String meta = request.getParameter("meta");
        String idmedida = request.getParameter("medida");
        String loginEvaluado = request.getParameter("evaluado");

        if (loginEvaluado != null && meta != null && !"".equals(meta.trim()) && !"".equals(idmedida.trim()))
        {
            User evaluador = response.getUser();
            Autentificacion aut = new Autentificacion();
            User evaluado = site.getUserRepository().getUserByLogin(loginEvaluado);
            List<UserSubordinado> subordinados = aut.getSubordinados(evaluador.getLogin());
            boolean found = true;
            for (UserSubordinado loginsub : subordinados)
            {
                if (loginsub.getLogin().equals(evaluado.getLogin()))
                {
                    found = true;
                }
            }
            if (!found)
            {
                response.setRenderParameter("error", "El evaluado no es subordinado del evealuador");
                response.setMode(MODE_ERROR);
                return;
            }
            TipoMedida medida = TipoMedida.ClassMgr.getTipoMedida(idmedida, site);
            if (medida == null)
            {
                response.setRenderParameter("error", "Tipo de medida no encontrada");
                response.setMode(MODE_ERROR);
                return;
            }

        }
        else
        {
            response.setRenderParameter("error", "La información es incorrecta");
            response.setMode(MODE_ERROR);
            return;
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if (request.getParameter("addcurso") != null)
        {
            addCurso(request, response);

        }
        if (request.getParameter("addmeta") != null)
        {
            addMeta(request, response);

        }
    }
}
