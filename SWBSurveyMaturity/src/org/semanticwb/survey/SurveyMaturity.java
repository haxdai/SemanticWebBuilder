/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.survey;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.WebSite;
import org.semanticwb.model.survey.Aplicacion;
import org.semanticwb.model.survey.CostoAplicacion;
import org.semanticwb.model.survey.CostoAplicacionAnio;
import org.semanticwb.model.survey.CostoTramite;
import org.semanticwb.model.survey.CostoUnidadSustantiva;
import org.semanticwb.model.survey.IncrementoCosto;
import org.semanticwb.model.survey.P10;
import org.semanticwb.model.survey.P11;
import org.semanticwb.model.survey.P12;
import org.semanticwb.model.survey.P13;
import org.semanticwb.model.survey.P2;
import org.semanticwb.model.survey.P3;
import org.semanticwb.model.survey.P4;
import org.semanticwb.model.survey.P5;
import org.semanticwb.model.survey.P6;
import org.semanticwb.model.survey.P7;
import org.semanticwb.model.survey.P8;
import org.semanticwb.model.survey.P9;
import org.semanticwb.model.survey.Survey;
import org.semanticwb.model.survey.Tramite;
import org.semanticwb.model.survey.UnidadSustantiva;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author victor.lorenzana
 */
public class SurveyMaturity extends GenericResource
{

    private static final Logger log = SWBUtils.getLogger(SurveyMaturity.class);

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String mode = "view";
        String siteId = paramRequest.getWebPage().getWebSiteId();
        
        String path = "/swbadmin/jsp/" + SurveyMaturity.class.getSimpleName() + "/" + mode + ".jsp";
        if (request.getParameter("step") != null)
        {
            String step = request.getParameter("step");
            path = "/swbadmin/jsp/" + SurveyMaturity.class.getSimpleName() + "/" + step + ".jsp";
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    public void p11(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP11() == null)
        {
            P11 p11 = P11.ClassMgr.createP11(site);
            survey.setP11(p11);
        }
        String[] values = request.getParameterValues("r");
        for (String value : values)
        {
            String prefix = "p11_" + value + "_";
            Iterator<SemanticProperty> props = survey.getP10().getSemanticObject().listProperties();
            {
                while (props.hasNext())
                {
                    SemanticProperty prop = props.next();
                    if (prop.getName().startsWith(prefix))
                    {
                        survey.getP10().getSemanticObject().setBooleanProperty(prop, true);
                    }
                }
            }

        }
    }

    public void p13(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP13() == null)
        {
            P13 p13 = P13.ClassMgr.createP13(site);
            survey.setP13(p13);
        }
        if (request.getParameter("p_back") != null)
        {
            survey.getP13().setP13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Back_Office(Integer.parseInt(request.getParameter("p_back")));
        }
        if (request.getParameter("p_front") != null)
        {
            survey.getP13().setP13_Porcentaje_del_Costo_total_de_TIC_en_apoyo_del_Front_Office(Integer.parseInt(request.getParameter("p_front")));
        }
    }

    public void p12(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP12() == null)
        {
            P12 p12 = P12.ClassMgr.createP12(site);
            survey.setP12(p12);
        }
        String[] values = request.getParameterValues("r");
        for (String value : values)
        {
            String prefix = "p12_" + value + "_";
            Iterator<SemanticProperty> props = survey.getP10().getSemanticObject().listProperties();
            {
                while (props.hasNext())
                {
                    SemanticProperty prop = props.next();
                    if (prop.getName().startsWith(prefix))
                    {
                        survey.getP10().getSemanticObject().setBooleanProperty(prop, true);
                    }
                }
            }

        }
    }

    public void p10(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP10() == null)
        {
            P10 p10 = P10.ClassMgr.createP10(site);
            survey.setP10(p10);
        }
        String[] values = request.getParameterValues("r");
        for (String value : values)
        {
            String prefix = "p10_" + value + "_";
            Iterator<SemanticProperty> props = survey.getP10().getSemanticObject().listProperties();
            {
                while (props.hasNext())
                {
                    SemanticProperty prop = props.next();
                    if (prop.getName().startsWith(prefix))
                    {
                        survey.getP10().getSemanticObject().setBooleanProperty(prop, true);
                    }
                }
            }

        }
    }

    public void p9(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP9() == null)
        {
            P9 p9 = P9.ClassMgr.createP9(site);
            survey.setP9(p9);
        }
        survey.getP9().removeAllCostoAplicacion();
        GenericIterator<Aplicacion> aplicaciones = survey.listAplicacioneses();
        while (aplicaciones.hasNext())
        {
            Aplicacion app = aplicaciones.next();
            String clave = app.getClaveAplicacion();
            CostoAplicacion costo = CostoAplicacion.ClassMgr.createCostoAplicacion(site);
            costo.setAplicacion(app);
            survey.getP9().addCostoAplicacion(costo);
            {
                Enumeration<String> names = request.getParameterNames();
                while (names.hasMoreElements())
                {
                    String name = names.nextElement();
                    if (name.startsWith("p_costo_") && name.endsWith(String.valueOf(clave)))
                    {
                        costo.setP_Total_del_Portafolio_de_servicios_de_aplicaciones(Integer.parseInt(name));
                    }
                }
            }

            // costo por año

            int anio = Calendar.getInstance().get(Calendar.YEAR) - 1;
            for (int i = 0; i < 8; i++)
            {
                int anio_show = anio + i;
                CostoAplicacionAnio costo_anio = CostoAplicacionAnio.ClassMgr.createCostoAplicacionAnio(site);
                costo_anio.setAnio_costo(anio_show);
                costo.addCostoAplicacionAnio(costo_anio);
                Enumeration<String> names = request.getParameterNames();
                while (names.hasMoreElements())
                {
                    String name = names.nextElement();
                    String value = request.getParameter(name);
                    String clave_anio = clave + "_" + anio_show;
                    if (name.startsWith("p_incremento_") && name.endsWith(String.valueOf(clave_anio)))
                    {
                        costo_anio.setCostoapp(Integer.parseInt(value));
                    }
                }
            }


        }
    }

    public void p8(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP8() == null)
        {
            P8 p8 = P8.ClassMgr.createP8(site);
            survey.setP8(p8);
        }
        survey.getP8().removeAllIncrementoCosto();
        int anio = Calendar.getInstance().get(Calendar.YEAR) - 1;
        for (int i = 0; i < 8; i++)
        {
            int anio_show = anio + i;
            IncrementoCosto costo = IncrementoCosto.ClassMgr.createIncrementoCosto(site);
            costo.setAnio(anio_show);
            survey.getP8().addIncrementoCosto(costo);
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = names.nextElement();
                String value = request.getParameter(name);
                if (name.startsWith("p_aplicaciones_") && name.endsWith(String.valueOf(anio_show)))
                {
                    costo.setCambio_porcentual_anual_del_Portafolio_de_servicios_de_aplicaciones(Integer.parseInt(value));
                }
                if (name.startsWith("p_infra_") && name.endsWith(String.valueOf(anio_show)))
                {
                    costo.setCambio_porcentual_anual_del_Portafolio_de_Servicios_Propios(Integer.parseInt(value));
                }
                if (name.startsWith("p_servicios_") && name.endsWith(String.valueOf(anio_show)))
                {
                    costo.setCambio_porcentual_anual_del_Portafolio_de_Servicios_a_Usuarios(Integer.parseInt(value));
                }
                if (name.startsWith("p_gestion_") && name.endsWith(String.valueOf(anio_show)))
                {
                    costo.setCambio_porcentual_anual_del_Portafolio_de_Servicios_de_Gestion(Integer.parseInt(value));
                }
                if (name.startsWith("p_proyectos_") && name.endsWith(String.valueOf(anio_show)))
                {
                    costo.setCambio_porcentual_anual_del_Portafolio_de_Servicios_de_Proyectos(Integer.parseInt(value));
                }
            }
        }
    }

    public void p7(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP7() == null)
        {
            P7 p7 = P7.ClassMgr.createP7(site);
            survey.setP7(p7);
        }
        GenericIterator<Tramite> tramites = survey.listTramiteses();
        while (tramites.hasNext())
        {
            Tramite tramite = tramites.next();
            UnidadSustantiva unidad = tramite.getUnidadSustantiva();
            String idtramite = tramite.getId();
            CostoTramite costo = CostoTramite.ClassMgr.createCostoTramite(site);
            costo.setTramite(tramite);
            survey.getP7().addCostosTramites(costo);
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = names.nextElement();
                String value = request.getParameter(name);
                if (name.startsWith("p_tramite_apoyado_") && name.endsWith(idtramite))
                {
                    costo.setTramite_apoyado_por_TIC(Integer.parseInt(value));
                }
                if (name.startsWith("p_tramite_numero_") && name.endsWith(idtramite))
                {
                    costo.setNumero_de_Tramites_Anuales(Integer.parseInt(value));
                }
                if (name.startsWith("p_aplicacion_") && name.endsWith(idtramite))
                {
                    costo.setCostos_de_Servicio_de_Aplicacion(Integer.parseInt(value));
                }
                if (name.startsWith("p_infra_") && name.endsWith(idtramite))
                {
                    costo.setCostos_de_Servicio_de_Infraestructura(Integer.parseInt(value));
                }
            }

        }

    }

    public void p1(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        if (request.getParameter("shcp") != null)
        {
            int shcp = Integer.parseInt(request.getParameter("shcp"));
            survey.setP1(shcp);
        }

    }

    public void p2(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP2() == null)
        {
            P2 p2 = P2.ClassMgr.createP2(site);
            survey.setP2(p2);
        }
        if (request.getParameter("personal") != null)
        {
            int personal = Integer.parseInt(request.getParameter("personal"));
            survey.getP2().setP2_costo_personal(personal);
        }
        if (request.getParameter("outsourcing") != null)
        {
            int outsourcing = Integer.parseInt(request.getParameter("outsourcing"));
            survey.getP2().setP2_costo_outsourcing(outsourcing);
        }
        if (request.getParameter("otros") != null)
        {
            int otros = Integer.parseInt(request.getParameter("otros"));
            survey.getP2().setP2_costo_otros(otros);
        }
    }

    public void p3(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP3() == null)
        {
            P3 p3 = P3.ClassMgr.createP3(site);
            survey.setP3(p3);
        }

        if (request.getParameter("mpersonal") != null)
        {
            int mpersonal = Integer.parseInt(request.getParameter("mpersonal"));
            survey.getP3().setP3_costo_total_de_personal(mpersonal);
        }
        if (request.getParameter("moutsourcing") != null)
        {
            int moutsourcing = Integer.parseInt(request.getParameter("moutsourcing"));
            survey.getP3().setCosto_total_de_outsourcing(moutsourcing);
        }
        if (request.getParameter("motros") != null)
        {
            int motros = Integer.parseInt(request.getParameter("motros"));
            survey.getP3().setCosto_total_de_otros_costos(motros);
        }
        if (request.getParameter("pcostoout") != null)
        {
            int pcostoout = Integer.parseInt(request.getParameter("pcostoout"));
            survey.getP3().setP3_Porcentaje_de_los_costos_de_outsourcing_que_representan_al_personal(pcostoout);
        }

    }

    public void p5(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP5() == null)
        {
            P5 p5 = P5.ClassMgr.createP5(site);
            survey.setP5(p5);
        }
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements())
        {
            String name = names.nextElement();
            String value = request.getParameter(name);
            if (name.startsWith("p_aplicacion"))
            {
                survey.getP5().setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Aplicaciones(Integer.parseInt(value));
            }
            if (name.startsWith("p_directasinfra"))
            {
                survey.getP5().setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios(Integer.parseInt(value));
            }
            if (name.startsWith("p_soporte"))
            {
                survey.getP5().setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_Directas_de_Servicio_a_Infraestructura_Actividades_de_Soporte_a_Usuarios(Integer.parseInt(value));
            }
            if (name.startsWith("p_admon"))
            {
                survey.getP5().setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Administración_de(Integer.parseInt(value));
            }
            if (name.startsWith("p_desarrollo"))
            {
                survey.getP5().setCosto_de_las_Actividades_de_Operaciones_de_Infraestructura_Actividades_de_Desarrollo_del_Proyecto(Integer.parseInt(value));
            }
        }

    }

    public void p6(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP6() == null)
        {
            P6 p6 = P6.ClassMgr.createP6(site);
            survey.setP6(p6);
        }
        GenericIterator<UnidadSustantiva> unidades = survey.listUnidadesSustantivases();
        survey.getP6().removeAllCostosUnidades();
        while (unidades.hasNext())
        {
            UnidadSustantiva unidad = unidades.next();
            CostoUnidadSustantiva costo = CostoUnidadSustantiva.ClassMgr.createCostoUnidadSustantiva(site);
            costo.setUnidadSustantiva(unidad);
            String clave = unidad.getClaveUnidad();
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = names.nextElement();
                String value = request.getParameter(name);
                if (name.startsWith("p_aplicacion_") && name.endsWith(clave))
                {
                    costo.setCostos_del_Portafolio_de_servicios(Integer.parseInt(value));
                }
                if (name.startsWith("p_infra_") && name.endsWith(clave))
                {
                    costo.setCostos_del_Portafolio_de_Servicios_Propios(Integer.parseInt(value));
                }
                if (name.startsWith("p_servicios_") && name.endsWith(clave))
                {
                    costo.setCostos_del_Portafolio_de_Servicios_al_Usuario(Integer.parseInt(value));
                }
                if (name.startsWith("p_gestion_") && name.endsWith(clave))
                {
                    costo.setCostos_del_Portafolio_de_Servicios_de_Gestion(Integer.parseInt(value));
                }
                if (name.startsWith("p_proyectos_") && name.endsWith(clave))
                {
                    costo.setCostos_del_Portafolio_de_Servicios_de_Proyecto(Integer.parseInt(value));
                }

            }
        }
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements())
        {
            String name = names.nextElement();
            String value = request.getParameter(name);
            if (name.startsWith("p_aplicacion_"))
            {
                survey.getP6().setCostos_del_Portafolio_de_servicios(Integer.parseInt(value));
            }
            if (name.startsWith("p_infra_"))
            {
                survey.getP6().setCostos_del_Portafolio_de_Servicios_Propios(Integer.parseInt(value));
            }
            if (name.startsWith("p_servicios_"))
            {
                survey.getP6().setCostos_del_Portafolio_de_Servicios_al_Usuario(Integer.parseInt(value));
            }
            if (name.startsWith("p_gestion_"))
            {
                survey.getP6().setCostos_del_Portafolio_de_Servicios_de_Gestion(Integer.parseInt(value));
            }
            if (name.startsWith("p_proyectos_"))
            {
                survey.getP6().setCostos_del_Portafolio_de_Servicios_de_Proyecto(Integer.parseInt(value));
            }

        }
    }

    public void p4(HttpServletRequest request, SWBActionResponse response, Survey survey) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (survey.getP4() == null)
        {
            P4 p4 = P4.ClassMgr.createP4(site);
            survey.setP4(p4);
        }
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements())
        {
            String name = names.nextElement();
            if (name.startsWith("p_aplicacion_"))
            {
                String value = request.getParameter(name);
                if (name.endsWith("personal"))
                {
                    survey.getP4().setActividades_de_aplicacion_costo_de_personal(Integer.parseInt(value));
                }
                if (name.endsWith("out"))
                {
                    survey.getP4().setActividades_de_aplicacion_costos_de_outsourcing(Integer.parseInt(value));
                }
                if (name.endsWith("otros"))
                {
                    survey.getP4().setActividades_de_aplicacion_otros_costos(Integer.parseInt(value));
                }
            }
            if (name.startsWith("p_operaciones_"))
            {
                String value = request.getParameter(name);
                if (name.endsWith("personal"))
                {
                    survey.getP4().setActividades_de_Operaciones_e_Infraestructura_Costo_de_Personal(Integer.parseInt(value));
                }
                if (name.endsWith("out"))
                {
                    survey.getP4().setActividades_de_Operaciones_e_Infraestructura_Costos_de_Outsourcing(Integer.parseInt(value));
                }
                if (name.endsWith("otros"))
                {
                    survey.getP4().setActividades_de_Operaciones_e_Infraestructura_Otros_Costos(Integer.parseInt(value));
                }
            }
            if (name.startsWith("p_soporte_"))
            {
                String value = request.getParameter(name);
                if (name.endsWith("personal"))
                {
                    survey.getP4().setActividades_de_Soporte_a_Usuarios_Costo_de_Personal(Integer.parseInt(value));
                }
                if (name.endsWith("out"))
                {
                    survey.getP4().setActividades_de_Soporte_a_Usuarios_Costos_de_Outsourcing(Integer.parseInt(value));
                }
                if (name.endsWith("otros"))
                {
                    survey.getP4().setActividades_de_Soporte_a_Usuarios_Otros_Costos(Integer.parseInt(value));
                }
            }
            if (name.startsWith("p_admon_"))
            {
                String value = request.getParameter(name);
                if (name.endsWith("personal"))
                {
                    survey.getP4().setActividades_de_Administracion_de_TIC_Costo_de_Personal(Integer.parseInt(value));
                }
                if (name.endsWith("out"))
                {
                    survey.getP4().setActividades_de_Administracion_de_TIC_Costos_de_Outsourcing(Integer.parseInt(value));
                }
                if (name.endsWith("otros"))
                {
                    survey.getP4().setActividades_de_Administracion_de_TIC_Otros_Costos(Integer.parseInt(value));
                }
            }

            if (name.startsWith("p_desarrollo_"))
            {
                String value = request.getParameter(name);
                if (name.endsWith("personal"))
                {
                    survey.getP4().setActividades_de_Desarrollo_de_Proyecto_Costo_de_Personal(Integer.parseInt(value));
                }
                if (name.endsWith("out"))
                {
                    survey.getP4().setActividades_de_Desarrollo_de_Proyecto_Costos_de_Outsourcing(Integer.parseInt(value));
                }
                if (name.endsWith("otros"))
                {
                    survey.getP4().setActividades_de_Desarrollo_de_Proyecto_Otros_Costos(Integer.parseInt(value));
                }
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        if (request.getParameter("from") != null)
        {
            Survey survey = (Survey) request.getAttribute("survey");
            if (survey == null)
            {
                if(Survey.ClassMgr.getSurvey("1", site)==null)
                {
                    survey=Survey.ClassMgr.createSurvey("1", site);
                }
                else
                {
                    survey=Survey.ClassMgr.getSurvey("1", site);
                }
                

            }
            String from = request.getParameter("from");
            if ("1".equals(from))
            {
                p1(request, response, survey);
            }
            if ("2".equals(from))
            {
                p2(request, response, survey);
            }
            if ("3".equals(from))
            {
                p3(request, response, survey);
            }
            if ("4".equals(from))
            {
                p4(request, response, survey);
            }
            if ("5".equals(from))
            {
                p5(request, response, survey);
            }
            if ("6".equals(from))
            {
                p6(request, response, survey);
            }

            if ("7".equals(from))
            {
                p7(request, response, survey);
            }
            if ("8".equals(from))
            {
                p8(request, response, survey);
            }

            if ("9".equals(from))
            {
                p9(request, response, survey);
            }
            if ("10".equals(from))
            {
                p10(request, response, survey);
            }
            if ("11".equals(from))
            {
                p11(request, response, survey);
            }
            if ("12".equals(from))
            {
                p12(request, response, survey);
            }
            if ("13".equals(from))
            {
                p13(request, response, survey);
            }
        }
        if (request.getParameter("step") != null)
        {
            String step = request.getParameter("step");
            response.setRenderParameter("step", step);
        }
    }
}
