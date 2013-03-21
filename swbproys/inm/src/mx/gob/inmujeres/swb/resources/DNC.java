/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.inmujeres.swb.CursoEvaluacion;
import mx.gob.inmujeres.swb.Desempenio;
import mx.gob.inmujeres.swb.InstrumentoG;
import mx.gob.inmujeres.swb.MetaEvaluacion;
import mx.gob.inmujeres.swb.TemasPrograma;
import mx.gob.inmujeres.swb.TipoMedida;
import mx.gob.inmujeres.swb.Trimestre;
import mx.gob.inmujeres.swb.UserExtended;
import mx.gob.inmujeres.swb.base.MetaEvaluacionBase.ClassMgr;
import mx.gob.inmujeres.swb.resources.sem.base.Autentificacion;
import mx.gob.inmujeres.swb.resources.sem.base.UserSubordinado;


import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.process.model.FlowNodeInstance;
import org.semanticwb.process.model.ItemAwareReference;
import org.semanticwb.process.model.ProcessInstance;
import org.semanticwb.process.model.SWBProcessMgr;
import org.semanticwb.process.model.UserTask;

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

    public void finish(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String suri = request.getParameter("suri");

        FlowNodeInstance foi = null;
        if (suri != null && !suri.equals(""))
        {

            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            foi = (FlowNodeInstance) ont.getGenericObject(suri);

            Desempenio evaluacion = null;
            User evaluado = null;
            ProcessInstance pInstance = foi.getProcessInstance();
            Iterator<ItemAwareReference> dataObjs = pInstance.listAllItemAwareReferences();

            while (dataObjs.hasNext())
            {
                ItemAwareReference obj = dataObjs.next();
                if (obj != null)
                {

                    if ("EvaluacionDes".equalsIgnoreCase(obj.getItemAware().getName()))
                    {
                        evaluacion = ((Desempenio) obj.getProcessObject());
                        evaluado = ((Desempenio) obj.getProcessObject()).getEvaluado();
                    }
                }
            }
            String redirect = null;
            if (evaluado == null || evaluacion == null)
            {
                return;
            }
            else
            {
                Iterator<CursoEvaluacion> cursos = evaluacion.listCursoses();
                if (!cursos.hasNext())
                {
                    String msg = "!Debe capturar por lo menos un curso!";
                    // no se capturo cursos
                    SWBResourceURL url = paramRequest.getRenderUrl();
                    url.setMode(SWBResourceURL.Mode_VIEW);
                    url.setCallMethod(SWBResourceURL.Call_CONTENT);
                    url.setParameter("msg", msg);
                    url.setParameter("suri", suri);
                    response.sendRedirect(url.toString());
                    return;
                }
                int imetas = 0;
                int total = 0;
                Iterator<MetaEvaluacion> metas = evaluacion.listMetases();
                while (metas.hasNext())
                {
                    MetaEvaluacion meta = metas.next();
                    int peso = Integer.parseInt(meta.getPesoMeta());
                    total += peso;
                    imetas++;
                }
               
                if (imetas < 3)
                {
                    String msg = "!Debe capturar por lo menos 3 metas!";
                    // no se capturo cursos
                    SWBResourceURL url = paramRequest.getRenderUrl();
                    url.setMode(SWBResourceURL.Mode_VIEW);
                    url.setCallMethod(SWBResourceURL.Call_CONTENT);
                    url.setParameter("msg", msg);
                    url.setParameter("suri", suri);
                    response.sendRedirect(url.toString());
                    return;
                }
                if (imetas > 7)
                {
                    String msg = "!Debe capturar por máximo 7 metas!";
                    // no se capturo cursos
                    SWBResourceURL url = paramRequest.getRenderUrl();
                    url.setMode(SWBResourceURL.Mode_VIEW);
                    url.setCallMethod(SWBResourceURL.Call_CONTENT);
                    url.setParameter("msg", msg);
                    url.setParameter("suri", suri);
                    response.sendRedirect(url.toString());
                    return;
                }
                 if (total != 100)
                {
                    String msg = "!La suma de los pesos no es del 100%, favor de corregir!";
                    // no se capturo cursos
                    SWBResourceURL url = paramRequest.getRenderUrl();
                    url.setMode(SWBResourceURL.Mode_VIEW);
                    url.setCallMethod(SWBResourceURL.Call_CONTENT);
                    url.setParameter("msg", msg);
                    url.setParameter("suri", suri);
                    response.sendRedirect(url.toString());
                    return;
                }
            }
            int anio_anterior = evaluacion.getAnio() - 1;
            WebSite site = paramRequest.getWebPage().getWebSite();
            Iterator<Desempenio> evaluaciones = Desempenio.ClassMgr.listDesempenioByEvaluado(evaluacion.getEvaluado(), site);
            while (evaluaciones.hasNext())
            {

                Desempenio evaluacion_ant = evaluaciones.next();
                if (evaluacion_ant.getAnio() == anio_anterior && evaluacion_ant.getEvaluado() != null && evaluacion_ant.getEvaluado().getId().equals(evaluacion.getEvaluado().getId()))
                {
                    Iterator<MetaEvaluacion> metas = evaluacion_ant.listMetases();
                    while (metas.hasNext())
                    {
                        MetaEvaluacion meta = metas.next();
                        if (meta.getEvaluacion() == 0)
                        {
                            String msg = "!Debe evaluar las metas de la evaluación anterior!";
                            // no se capturo cursos
                            SWBResourceURL url = paramRequest.getRenderUrl();
                            url.setMode(SWBResourceURL.Mode_VIEW);
                            url.setCallMethod(SWBResourceURL.Call_CONTENT);
                            url.setParameter("msg", msg);
                            url.setParameter("suri", suri);
                            response.sendRedirect(url.toString());
                            return;
                        }
                    }
                }
            }



            foi.close(paramRequest.getUser(), ProcessInstance.ACTION_ACCEPT);




            if (foi.getFlowNodeType() instanceof UserTask && ((UserTask) foi.getFlowNodeType()).isLinkNextUserTask())
            {
                List<FlowNodeInstance> arr = SWBProcessMgr.getActiveUserTaskInstances(foi.getProcessInstance(), paramRequest.getUser());
                if (arr.size() > 0)
                {
                    redirect = arr.get(0).getUserTaskUrl();
                }
                else
                {
                    redirect = foi.getUserTaskInboxUrl();
                }
            }
            else
            {
                redirect = foi.getUserTaskInboxUrl();
            }
            if (redirect != null)
            {
                response.sendRedirect(redirect);
            }

        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if ("finish".equals(paramRequest.getMode()))
        {
            finish(request, response, paramRequest);
            return;
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }

    }

    public void addMetasAnt(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String suri = request.getParameter("suri");
        response.setRenderParameter("suri", suri);
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements())
        {
            String name = names.nextElement().toString();
            String value = request.getParameter(name);
            if (value != null)
            {
                int pos = name.indexOf("_");
                if (pos != -1)
                {
                    String idmeta = name.substring(pos + 1);
                    String tipo = name.substring(0, pos);
                    MetaEvaluacion meta = ClassMgr.getMetaEvaluacion(idmeta, site);
                    if (meta != null)
                    {
                        if ("comentarios".equals(tipo))
                        {
                            meta.setComentarios(value);
                        }
                        if ("calificacion".equals(tipo))
                        {
                            int ivalue = Integer.parseInt(value);
                            meta.setEvaluacion(ivalue);
                        }
                    }
                }
            }
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
            UserExtended ext = UserExtended.ClassMgr.getUserExtended(evaluador.getId(), evaluador.getUserRepository());
            User evaluado = site.getUserRepository().getUserByLogin(loginEvaluado);
            Iterator<User> subordinados = ext.listSubordinados();
            boolean found = true;
            while (subordinados.hasNext())
            {
                User loginsub = subordinados.next();
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
            Trimestre trimestre = null;
            Iterator<Trimestre> trimestres = Trimestre.ClassMgr.listTrimestres();
            while (trimestres.hasNext())
            {
                Trimestre t = trimestres.next();
                if (t.getId().equalsIgnoreCase(idTrimestre))
                {
                    trimestre = t;
                }
            }
            if (trimestre == null)
            {
                response.setRenderParameter("error", "Trimestre no encontrado");
                response.setMode(MODE_ERROR);
                return;
            }
            String suri = request.getParameter("suri");
            FlowNodeInstance foi = null;
            int anio = Calendar.getInstance().get(Calendar.YEAR);
            Desempenio evaluacion = null;

            if (suri != null && !suri.equals(""))
            {
                response.setRenderParameter("suri", suri);
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                foi = (FlowNodeInstance) ont.getGenericObject(suri);
                ProcessInstance pInstance = foi.getProcessInstance();
                Iterator<ItemAwareReference> dataObjs = pInstance.listAllItemAwareReferences();

                while (dataObjs.hasNext())
                {
                    ItemAwareReference obj = dataObjs.next();
                    if (obj != null)
                    {

                        if ("EvaluacionDes".equalsIgnoreCase(obj.getItemAware().getName()))
                        {
                            evaluacion = ((Desempenio) obj.getProcessObject());
                            evaluado = ((Desempenio) obj.getProcessObject()).getEvaluado();
                        }
                    }
                }
            }


            if (evaluacion == null)
            {
                evaluacion = Desempenio.ClassMgr.createDesempenio(site);
                evaluacion.setAnio(anio);
                evaluacion.setEvaluado(evaluado);
                evaluacion.setEvaluador(evaluador);
            }
            CursoEvaluacion cursoEvaluacion = CursoEvaluacion.ClassMgr.createCursoEvaluacion(site);
            cursoEvaluacion.setNombreCurso(curso);
            cursoEvaluacion.setJustificacionObjetivoRelacionado(objetivo);
            cursoEvaluacion.setTrimestreAnioAplicar(trimestre);
            evaluacion.addCursos(cursoEvaluacion);


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
        String instrumentoId = request.getParameter("instrumento");
        String temasId = request.getParameter("temas");

        String sobresaliente = request.getParameter("sobresaliente");
        String satisfactorio = request.getParameter("satisfactorio");
        String minimo = request.getParameter("minimo");
        String nosatisfactorio = request.getParameter("nosatisfactorio");

        String peso = request.getParameter("peso");


        String loginEvaluado = request.getParameter("evaluado");

        if (sobresaliente != null && peso != null && nosatisfactorio != null && minimo != null && satisfactorio != null && instrumentoId != null && temasId != null && loginEvaluado != null && meta != null && !"".equals(meta.trim()) && !"".equals(idmedida.trim()))
        {
            TemasPrograma _tema = null;
            Iterator<TemasPrograma> temas = TemasPrograma.ClassMgr.listTemasProgramas();
            while (temas.hasNext())
            {
                TemasPrograma tema = temas.next();
                if (tema.getId().equals(temasId))
                {
                    _tema = tema;
                }
            }
            InstrumentoG _instrumento = null;
            Iterator<InstrumentoG> instrumentos = InstrumentoG.ClassMgr.listInstrumentoGs();
            while (instrumentos.hasNext())
            {
                InstrumentoG instrumento = instrumentos.next();
                if (instrumento.getId().equals(instrumentoId))
                {
                    _instrumento = instrumento;
                }
            }

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
                response.setRenderParameter("error", "El evaluado no es subordinado del evaluador");
                response.setMode(MODE_ERROR);
                return;
            }

            try
            {
                int ipeso = Integer.parseInt(peso);
                if (ipeso <= 0)
                {
                    response.setRenderParameter("error", "El peso no puede ser negativo o cero");
                    response.setMode(MODE_ERROR);
                    return;
                }
                if (ipeso >= 100)
                {
                    response.setRenderParameter("error", "El peso no puede ser negativo o cero");
                    response.setMode(MODE_ERROR);
                    return;
                }
            }
            catch (NumberFormatException nfe)
            {
                response.setRenderParameter("error", "El peso debe ser un número entre cero y 100");
                response.setMode(MODE_ERROR);
                return;
            }
            TipoMedida medida = null;
            Iterator<TipoMedida> medidas = TipoMedida.ClassMgr.listTipoMedidas();
            while (medidas.hasNext())
            {
                TipoMedida t = medidas.next();
                if (t.getId().equalsIgnoreCase(idmedida))
                {
                    medida = t;
                }
            }
            if (medida == null)
            {
                response.setRenderParameter("error", "Tipo de medida no encontrada");
                response.setMode(MODE_ERROR);
                return;
            }
            int anio = Calendar.getInstance().get(Calendar.YEAR);
            String suri = request.getParameter("suri");
            FlowNodeInstance foi = null;

            Desempenio evaluacion = null;

            if (suri != null && !suri.equals(""))
            {
                response.setRenderParameter("suri", suri);
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                foi = (FlowNodeInstance) ont.getGenericObject(suri);
                ProcessInstance pInstance = foi.getProcessInstance();
                Iterator<ItemAwareReference> dataObjs = pInstance.listAllItemAwareReferences();

                while (dataObjs.hasNext())
                {
                    ItemAwareReference obj = dataObjs.next();
                    if (obj != null)
                    {

                        if ("EvaluacionDes".equalsIgnoreCase(obj.getItemAware().getName()))
                        {
                            evaluacion = ((Desempenio) obj.getProcessObject());
                            evaluado = ((Desempenio) obj.getProcessObject()).getEvaluado();
                        }
                    }
                }
            }
            if (evaluacion == null)
            {
                evaluacion = Desempenio.ClassMgr.createDesempenio(site);
                evaluacion.setEvaluado(evaluado);
                evaluacion.setEvaluador(evaluador);
                evaluacion.setAnio(anio);
            }

            MetaEvaluacion metaEvaluacion = MetaEvaluacion.ClassMgr.createMetaEvaluacion(site);
            metaEvaluacion.setInstrumentog(_instrumento);
            metaEvaluacion.setTemasPrograma(_tema);
            metaEvaluacion.setPSobresaliente(sobresaliente);
            metaEvaluacion.setMeta(meta);
            metaEvaluacion.setMedida(medida);
            metaEvaluacion.setPSatisfactorio(satisfactorio);
            metaEvaluacion.setPMinimoaceptable(minimo);
            metaEvaluacion.setPesoMeta(peso);
            metaEvaluacion.setPNoSatisfactorio(nosatisfactorio);
            evaluacion.addMetas(metaEvaluacion);

        }
        else
        {
            response.setRenderParameter("error", "La información es incorrecta");
            response.setMode(MODE_ERROR);
            return;
        }
    }

    public void deleteMeta(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String idMeta = request.getParameter("idmeta");
        MetaEvaluacion meta = ClassMgr.getMetaEvaluacion(idMeta, site);
        if (meta != null)
        {
            meta.remove();

        }
    }

    public void deleteCurso(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String idCurso = request.getParameter("idcurso");
        CursoEvaluacion curso = CursoEvaluacion.ClassMgr.getCursoEvaluacion(idCurso, site);
        if (curso != null)
        {
            curso.remove();

        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if (request.getParameter("curso") != null)
        {
            addCurso(request, response);
            response.setMode(SWBResourceURL.Mode_VIEW);

        }
        if (request.getParameter("metasant") != null)
        {
            addMetasAnt(request, response);
            response.setMode(SWBResourceURL.Mode_VIEW);
        }

        if (request.getParameter("meta") != null)
        {
            addMeta(request, response);
            response.setMode(SWBResourceURL.Mode_VIEW);

        }
        if (request.getParameter("idmeta") != null)
        {
            deleteMeta(request, response);
            response.setMode(SWBResourceURL.Mode_VIEW);
            response.setRenderParameter("suri", request.getParameter("suri"));

        }

        if (request.getParameter("idcurso") != null)
        {
            deleteCurso(request, response);
            response.setMode(SWBResourceURL.Mode_VIEW);
            response.setRenderParameter("suri", request.getParameter("suri"));

        }
    }
}
