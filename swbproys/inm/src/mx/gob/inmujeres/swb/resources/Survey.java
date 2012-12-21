/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.inmujeres.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.inmujeres.swb.Cuestionario;
import mx.gob.inmujeres.swb.Desempenio;
import mx.gob.inmujeres.swb.EvaluacionCuestionario;
import mx.gob.inmujeres.swb.Grupo;
import mx.gob.inmujeres.swb.Nivel;
import mx.gob.inmujeres.swb.Pregunta;
import mx.gob.inmujeres.swb.Respuesta;
import mx.gob.inmujeres.swb.Score;
import mx.gob.inmujeres.swb.SubGrupo;
import mx.gob.inmujeres.swb.resources.sem.base.Autentificacion;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author victor.lorenzana
 */
public class Survey extends GenericResource
{

    public static final String MODE_ERROR = "error";
    public static final String MODE_MENU = "menu";
    public static final String MODE_ADDSUBGROUP = "addsubgroup";
    public static final String MODE_LISTSUBGROUP = "listSubgroup";
    public static final String MODE_ADDGROUP = "addgroup";
    public static final String MODE_LISTGROUP = "listgroup";
    public static final String MODE_ADDNIVEL = "addnivel";
    public static final String MODE_LISTNIVEL = "listnivel";
    public static final String MODE_ADDQUESTION = "addquestion";
    public static final String MODE_LISTQUESTION = "listquestion";
    public static final String MODE_EDITQUESTION = "editQuestion";
    public static final String MODE_LISTSURVEY = "listsurvey";
    public static final String MODE_FILL = "fillsurvey";
    public static final String MODE_ADDSCORE = "addScore";
    public static final String MODE_LISTSCORE = "listScore";
    public static final String MODE_SHOWRESULTS = "showResults";
    static Logger log = SWBUtils.getLogger(Survey.class);

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();
        String mode = MODE_FILL;
        if (paramRequest.getMode() != null)
        {
            mode = paramRequest.getMode();
        }
        String jsp = "/work/models/" + siteId + "/jsp/" + Survey.class.getSimpleName() + "/" + mode + ".jsp";
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

    public static boolean existsGrupoByName(String title, WebSite site)
    {
        boolean existsGrupo = false;
        Iterator<Grupo> grupos = Grupo.ClassMgr.listGrupos(site);
        while (grupos.hasNext())
        {
            Grupo grupo = grupos.next();
            if (title.equalsIgnoreCase(grupo.getTitle()))
            {
                existsGrupo = true;
                break;
            }
        }
        return existsGrupo;
    }

    public static boolean existsNivelByName(String title, WebSite site)
    {
        boolean existsnivel = false;
        Iterator<Nivel> niveles = Nivel.ClassMgr.listNivels(site);
        while (niveles.hasNext())
        {
            Nivel grupo = niveles.next();
            if (title.equalsIgnoreCase(grupo.getTitle()))
            {
                existsnivel = true;
                break;
            }
        }
        return existsnivel;
    }

    public static boolean existsSGrupoByName(Grupo group, String title, WebSite site)
    {
        boolean existsGrupo = false;
        GenericIterator<SubGrupo> subgrupos = group.listSubGroups();
        while (subgrupos.hasNext())
        {
            SubGrupo subgrupo = subgrupos.next();
            if (title.equalsIgnoreCase(subgrupo.getTitle()))
            {
                existsGrupo = true;
                break;
            }
        }
        return existsGrupo;
    }

    public static boolean existsGrupoById(String id, WebSite site)
    {
        boolean existsGrupo = false;
        Grupo grupo = Grupo.ClassMgr.getGrupo(id, site);
        if (grupo != null)
        {
            existsGrupo = true;
        }
        return existsGrupo;
    }

    private void checkpreguntas(WebSite site)
    {
        // borra cuestionarios
        Iterator<Pregunta> preguntas = Pregunta.ClassMgr.listPreguntas(site);
        while (preguntas.hasNext())
        {
            Pregunta pregunta = preguntas.next();
            if (pregunta.getScoreMax() == null)
            {
                pregunta.remove();
                continue;
            }
            if (!pregunta.listNiveleses().hasNext())
            {
                pregunta.remove();
                continue;
            }
        }

    }

    private void deleteGrupo(Grupo grupo, WebSite site)
    {
        GenericIterator<SubGrupo> subgrupos = grupo.listSubGroups();
        while (subgrupos.hasNext())
        {
            SubGrupo subGrupo = subgrupos.next();
            deletesubGrupo(subGrupo, site);
        }
        grupo.removeAllSubGroup();

    }

    private void checkEvaluaciones(Pregunta pregunta, WebSite site)
    {
        Iterator<EvaluacionCuestionario> evaluaciones = EvaluacionCuestionario.ClassMgr.listEvaluacionCuestionarios(site);
        while (evaluaciones.hasNext())
        {
            EvaluacionCuestionario evaluacion = evaluaciones.next();
            Iterator<Respuesta> respuestas = evaluacion.listRespuestases();
            while (respuestas.hasNext())
            {
                Respuesta respuesta = respuestas.next();
                if (respuesta.getPregunta().equals(pregunta))
                {
                    respuesta.remove();
                }
            }
            respuestas = evaluacion.listRespuestases();
            if (!respuestas.hasNext())
            {
                evaluacion.remove();
            }
        }
    }

    private void deletesubGrupo(SubGrupo subGrupo, WebSite site)
    {
        Iterator<Pregunta> preguntas = Pregunta.ClassMgr.listPreguntaBySubgrupo(subGrupo, site);
        while (preguntas.hasNext())
        {
            Pregunta pregunta = preguntas.next();
            checkEvaluaciones(pregunta, site);
            pregunta.remove();
        }
        subGrupo.remove();

    }

    private void deleteObject(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String uri = request.getParameter("uri");
        SemanticObject obj = SemanticObject.getSemanticObject(uri);
        GenericObject gi = obj.getGenericInstance();
        if (gi instanceof Nivel)
        {
            checkpreguntas(site);
        }
        if (gi instanceof Score)
        {
            checkpreguntas(site);
        }
        if (gi instanceof Grupo)
        {
            // borra subgrupos
            Grupo grupo = (Grupo) gi;
            deleteGrupo(grupo, site);
        }
        if (gi instanceof SubGrupo)
        {
            // borra subgrupos
            SubGrupo grupo = (SubGrupo) gi;
            deletesubGrupo(grupo, site);
        }
        if (obj != null)
        {
            obj.remove();
        }
        checkpreguntas(site);
        String mode = Survey.MODE_MENU;
        if (request.getParameter("view") != null && !"".equalsIgnoreCase(request.getParameter("view").trim()))
        {
            mode = request.getParameter("view");
        }
        String[] parameters = request.getParameterValues("parameter");
        if (parameters != null && parameters.length > 0)
        {
            for (String name : parameters)
            {
                String value = request.getParameter("name");
                if (value != null)
                {
                    response.setRenderParameter(name, value);

                }
            }
        }
        response.setMode(mode);
    }

    private void addSGroup(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String groupId = request.getParameter("groupToSubgruop");
        if (!existsGrupoById(groupId, site))
        {
            // mandar error
            response.setRenderParameter("error", "El grupo no existe");
            response.setMode(MODE_ERROR);
            return;
        }
        Grupo group = Grupo.ClassMgr.getGrupo(groupId, site);
        String sgroup = request.getParameter("sgroup");
        if (!existsSGrupoByName(group, sgroup, site))
        {
            SubGrupo sgrupo = SubGrupo.ClassMgr.createSubGrupo(site);
            sgrupo.setTitle(sgroup);
            group.addSubGroup(sgrupo);
            response.setRenderParameter("grupo", groupId);
            //response.setWindowState(SWBResourceURL.WinState_NORMAL);
            response.setMode(MODE_LISTSUBGROUP);
        }
        else
        {
            response.setRenderParameter("error", "El subgrupo ya existe");
            response.setMode(MODE_ERROR);
        }


    }

    private void addNivel(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String name = request.getParameter("nivel");
        if (!existsNivelByName(name, site))
        {

            Nivel nivel = Nivel.ClassMgr.createNivel(name.toLowerCase(), site);
            String descripcion = request.getParameter("description");
            if (descripcion != null)
            {
                nivel.setDescription(descripcion);
            }
            nivel.setTitle(name);
            response.setMode(Survey.MODE_LISTNIVEL);
        }
        else
        {
            response.setRenderParameter("error", "el nivel ya existe");
            response.setMode(Survey.MODE_ERROR);
        }

    }

    private void addEvaluacion(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String idNivel = request.getParameter("niveladdSurvey");
        String[] preguntas = request.getParameterValues("preguntaToAddSurvey");
        if (idNivel != null && preguntas != null && preguntas.length > 0)
        {
            Nivel nivel = Nivel.ClassMgr.getNivel(idNivel.toLowerCase(), site);
            if (nivel == null)
            {
                response.setRenderParameter("error", "El nivel " + idNivel + " no existe");
                response.setMode(MODE_ERROR);
                return;
            }
            for (String idPregunta : preguntas)
            {
                if (!Pregunta.ClassMgr.hasPregunta(idPregunta, site))
                {
                    response.setRenderParameter("error", "La pregunta " + idPregunta + " no existe");
                    response.setMode(MODE_ERROR);
                    return;
                }
            }
            if (Cuestionario.ClassMgr.hasCuestionario(idNivel.toLowerCase(), site))
            {
                response.setRenderParameter("error", "Ya existe una evaluación para el nivel " + idNivel);
                response.setMode(MODE_ERROR);
                return;
            }
            Cuestionario cuestionario = Cuestionario.ClassMgr.createCuestionario(idNivel.toLowerCase(), site);
            cuestionario.setNivel(nivel);
            for (String idPregunta : preguntas)
            {
                Pregunta pregunta = Pregunta.ClassMgr.getPregunta(idPregunta, site);
                cuestionario.addPreguntas(pregunta);
                response.setMode(MODE_LISTSURVEY);
            }


        }
        else
        {
            if (idNivel == null)
            {
                response.setRenderParameter("error", "Indique el nivel del cuestionario");
                response.setMode(MODE_ERROR);
                return;
            }
            if (preguntas == null || preguntas.length == 0)
            {
                response.setRenderParameter("error", "Indique por lo menos una pregunta");
                response.setMode(MODE_ERROR);
                return;
            }
        }
    }

    private void addPregunta(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String groupoPregunta = request.getParameter("groupoPregunta");
        String sgroupoPregunta = request.getParameter("sgroupoPregunta");
        String pregunta = request.getParameter("pregunta");
        String[] niveles = request.getParameterValues("niveles");
        if (groupoPregunta != null && sgroupoPregunta != null && niveles != null && niveles.length > 0 && pregunta != null)
        {
            if (!existsGrupoById(groupoPregunta, site))
            {
                response.setRenderParameter("error", "El grupo no existe");
                response.setMode(MODE_ERROR);
                return;
            }
            if ("".equals(pregunta))
            {
                response.setRenderParameter("error", "El texto de la pregunta no esta definido");
                response.setMode(MODE_ERROR);
                return;
            }
            if (niveles.length == 0)
            {
                response.setRenderParameter("error", "Debe indicar los niveles de la pregunta");
                response.setMode(MODE_ERROR);
                return;
            }
            for (String idNivel : niveles)
            {
                Nivel nivel = Nivel.ClassMgr.getNivel(idNivel.toLowerCase(), site);
                if (nivel == null)
                {
                    response.setRenderParameter("error", "Uno de los niveles no existe");
                    response.setMode(MODE_ERROR);
                    return;
                }
            }
            Grupo grupo = Grupo.ClassMgr.getGrupo(groupoPregunta, site);
            Iterator<SubGrupo> subgrupos = grupo.listSubGroups();
            SubGrupo subgrupo = null;
            while (subgrupos.hasNext())
            {
                SubGrupo sg = subgrupos.next();
                if (sgroupoPregunta.equalsIgnoreCase(sg.getId()))
                {
                    subgrupo = sg;
                    break;
                }
            }
            if (subgrupo == null)
            {
                response.setRenderParameter("error", "El subgrupo no existe");
                response.setMode(MODE_ERROR);
                return;
            }
            String idCal = request.getParameter("calmax");
            Score score = Score.ClassMgr.getScore(idCal, site);
            if (score == null)
            {
                response.setRenderParameter("error", "La calificación no existe");
                response.setMode(MODE_ERROR);
                return;
            }
            Pregunta objpregunta = Pregunta.ClassMgr.createPregunta(site);
            objpregunta.setScoreMax(score);
            objpregunta.setSubgrupo(subgrupo);
            for (String idNivel : niveles)
            {
                Nivel nivel = Nivel.ClassMgr.getNivel(idNivel.toLowerCase(), site);
                if (nivel != null)
                {
                    objpregunta.addNiveles(nivel);
                }
            }
            objpregunta.setTexto(pregunta);
            response.setMode(Survey.MODE_LISTQUESTION);
        }
        else
        {
            if (groupoPregunta == null)
            {
                response.setRenderParameter("error", "Indique el grupo al que pertenece la pregunta");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
            if (sgroupoPregunta == null)
            {
                response.setRenderParameter("error", "Indique el Subgrupo al que pertenece la pregunta");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
            if (pregunta == null)
            {
                response.setRenderParameter("error", "Indique la pregunta");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
            if (niveles == null || niveles.length <= 0)
            {
                response.setRenderParameter("error", "Indique los niveles de la pregunta");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
        }
    }

    private void addScore(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String snumber = request.getParameter("scoreToAdd");
        String titulo = request.getParameter("titulo");
        if (snumber != null && titulo != null)
        {
            try
            {
                Integer value = Integer.parseInt(snumber);
                Score score = Score.ClassMgr.createScore(site);
                score.setScore(value);
                score.setTitle(titulo);
                response.setRenderParameter("error", "el valor de la calificación no es un entero");
                response.setMode(Survey.MODE_LISTSCORE);
                return;
            }
            catch (Exception e)
            {
                response.setRenderParameter("error", "el valor de la calificación no es un entero");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
        }
        else
        {
            if (snumber == null)
            {
                response.setRenderParameter("error", "Debe indicar el valor de la calficación");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
            if (titulo == null)
            {
                response.setRenderParameter("error", "Debe indicar el título de la calficación");
                response.setMode(Survey.MODE_ERROR);
                return;
            }
        }
    }

    private boolean hasNivel(Pregunta pregunta, Nivel nivelUsuario)
    {
        boolean hasNivel = false;
        Iterator<Nivel> niveles = pregunta.listNiveleses();
        while (niveles.hasNext())
        {
            Nivel nivel = niveles.next();
            if (nivel.equals(nivelUsuario))
            {
                return true;
            }
        }
        return hasNivel;
    }

    private Score getScore(String idScore, WebSite site)
    {
        return Score.ClassMgr.getScore(idScore, site);
    }

    private void checkPreguntas(WebSite site, Nivel nivelUsuario, Map<String, String> respuestas) throws Exception
    {
        Set<String> listPreguntas = new HashSet<String>();
        Iterator<Pregunta> preguntas = Pregunta.ClassMgr.listPreguntaByNiveles(nivelUsuario, site);
        while (preguntas.hasNext())
        {
            Pregunta pregunta = preguntas.next();
            listPreguntas.add(pregunta.getId());
        }
        if (respuestas.keySet().size() != listPreguntas.size())
        {
            throw new Exception("El número de respuestas no corresponde con el cuestionario");
        }
        for (String idPregunta : respuestas.keySet())
        {
            if (!listPreguntas.contains(idPregunta))
            {
                throw new Exception("La pregunta " + idPregunta + " No corresponde con el cuestionario para el nivel " + nivelUsuario.getId());
            }
        }
    }

    private void addRespuestas(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String login = request.getParameter("evaluado");
        User evaluador = response.getUser();
        User evaluado = site.getUserRepository().getUserByLogin(login);
        if (evaluado == null)
        {
            response.setRenderParameter("error", "El evaludo es nulo");
            response.setMode(Survey.MODE_ERROR);
            return;
        }
        Autentificacion aut = new Autentificacion();
        String nivelId = aut.getCamposLogin(evaluado.getLogin()).getNivel();
        if (nivelId == null)
        {
            response.setRenderParameter("error", "El usuario evaluado no tiene nivel");
            response.setMode(Survey.MODE_ERROR);
            return;
        }
        Nivel nivelUsuario = Nivel.ClassMgr.getNivel(nivelId, site);
        if (nivelUsuario == null)
        {
            response.setRenderParameter("error", "El nivel del evaluado es nulo");
            response.setMode(Survey.MODE_ERROR);
            return;
        }
        Map<String, String> respuestas = new HashMap<String, String>();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements())
        {
            String name = names.nextElement();
            if (name.startsWith("pregunta_"))
            {
                int pos = name.indexOf('_');
                String idPregunta = name.substring(pos + 1).trim();
                Pregunta pregunta = Pregunta.ClassMgr.getPregunta(idPregunta, site);
                if (hasNivel(pregunta, nivelUsuario))
                {
                    String valor = request.getParameter(name);
                    if (valor == null)
                    {
                        response.setRenderParameter("error", "El valor de la pregunta " + idPregunta + " no es correcto, valor: " + valor);
                        response.setMode(Survey.MODE_ERROR);

                        return;
                    }
                    respuestas.put(idPregunta, valor);

                }
                else
                {
                    response.setRenderParameter("error", "El cuestionario fue llenado con preguntas que no corresponde con el nivel");
                    response.setMode(Survey.MODE_ERROR);
                    return;
                }

            }
        }
        if (respuestas.isEmpty())
        {
            response.setRenderParameter("error", "El cuestionario no tiene respuestas");
            response.setMode(Survey.MODE_ERROR);
            return;
        }
        for (String idPregunta : respuestas.keySet())
        {
            String idScore = respuestas.get(idPregunta);
            Score score = getScore(idScore, site);
            if (score == null)
            {
                response.setRenderParameter("error", "La respuesta " + idPregunta + " tiene un valor no permitido: " + idScore);
                response.setMode(Survey.MODE_ERROR);
                return;
            }
            else
            {
                Pregunta pregunta = Pregunta.ClassMgr.getPregunta(idPregunta, site);
                if (pregunta.getScoreMax().getScore() < score.getScore())
                {
                    response.setRenderParameter("error", "El valor " + idScore + " es más grande (" + pregunta.getScoreMax().getScore() + ") del valor permitido para la pregunta " + idPregunta);
                    response.setMode(Survey.MODE_ERROR);
                    return;
                }
            }

        }
        try
        {
            checkPreguntas(site, nivelUsuario, respuestas);
        }
        catch (Exception e)
        {
            response.setRenderParameter("error", e.getMessage());
            response.setMode(Survey.MODE_ERROR);
            return;
        }



        // guarda resultados despues de la validación
        int iAnio = Calendar.getInstance().get(Calendar.YEAR);
        String anio = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String id = evaluado.getId() + "_" + evaluador.getId() + "_" + anio;
        if (EvaluacionCuestionario.ClassMgr.hasEvaluacionCuestionario(id, site))
        {
            response.setRenderParameter("error", "El cuestionario ya existe para ese evaluador y ese evaluado");
            response.setMode(Survey.MODE_ERROR);
            return;
        }
        Desempenio desempenio = null;
        Iterator<Desempenio> desempenios = Desempenio.ClassMgr.listDesempenioByEvaluado(evaluador, site);
        while (desempenios.hasNext())
        {
            Desempenio test = desempenios.next();
            if (test.getEvaluado() != null && test.getEvaluado().equals(evaluado) && iAnio == test.getAnio())
            {
                desempenio = test;
            }
        }
        EvaluacionCuestionario cuestionario = EvaluacionCuestionario.ClassMgr.createEvaluacionCuestionario(id, site);
        if (desempenio != null)
        {
            desempenio.setCuestionarioAplicado(cuestionario);
        }
        else
        {
            response.setRenderParameter("error", "No se encontro el objeto desempenio asociado al evaluador, evaludo y año");
            response.setMode(Survey.MODE_ERROR);
            return;
        }
//        cuestionario.setEvaluado(evaluado);
//        cuestionario.setEvaluador(evaluador);
//        cuestionario.setFechaevaluacion(new Date());
        for (String idPregunta : respuestas.keySet())
        {
            String idScore = respuestas.get(idPregunta);
            Respuesta respuesta = Respuesta.ClassMgr.createRespuesta(idPregunta, site);
            Pregunta pregunta = Pregunta.ClassMgr.getPregunta(idPregunta, site);
            respuesta.setPregunta(pregunta);
            Score score = getScore(idScore, site);
            respuesta.setScorePregunta(score);
            cuestionario.addRespuestas(respuesta);
        }
        response.setMode(Survey.MODE_SHOWRESULTS);
        response.setRenderParameter("user", evaluado.getLogin());
    }

    private void addGroup(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite site = response.getWebPage().getWebSite();
        String name = request.getParameter("group");
        if (!existsGrupoByName(name, site))
        {
            Grupo grupo = Grupo.ClassMgr.createGrupo(site);
            response.setRenderParameter("grupo", grupo.getId());
            response.setMode(Survey.MODE_LISTGROUP);
            grupo.setTitle(name);
        }
        else
        {
            response.setRenderParameter("error", "Existe el grupo con nombre: " + name);
            response.setMode(Survey.MODE_ERROR);
        }


    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if (request.getParameter("group") != null && !"".equalsIgnoreCase(request.getParameter("group").trim()))
        {
            addGroup(request, response);
        }
        if (request.getParameter("groupToSubgruop") != null && !"".equalsIgnoreCase(request.getParameter("groupToSubgruop").trim()))
        {
            addSGroup(request, response);
        }

        if (request.getParameter("nivel") != null && !"".equalsIgnoreCase(request.getParameter("nivel").trim()))
        {
            addNivel(request, response);
        }
        if (request.getParameter("groupoPregunta") != null && !"".equalsIgnoreCase(request.getParameter("groupoPregunta").trim()))
        {
            addPregunta(request, response);
        }

        if (request.getParameter("niveladdSurvey") != null && !"".equalsIgnoreCase(request.getParameter("niveladdSurvey").trim()))
        {
            addEvaluacion(request, response);
        }
        if (request.getParameter("evaluado") != null && !"".equalsIgnoreCase(request.getParameter("evaluado").trim()))
        {
            addRespuestas(request, response);
        }
        if (request.getParameter("scoreToAdd") != null && !"".equalsIgnoreCase(request.getParameter("scoreToAdd").trim()))
        {
            addScore(request, response);
        }

        if (request.getParameter("uri") != null && !"".equalsIgnoreCase(request.getParameter("uri").trim()))
        {
            if ("delete".equalsIgnoreCase(request.getParameter("mode")))
            {
                deleteObject(request, response);
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String siteId = paramRequest.getWebPage().getWebSiteId();


        if (SWBResourceURL.Mode_VIEW.equals(paramRequest.getMode()))
        {
            doView(request, response, paramRequest);
            return;
        }
        if (SWBResourceURL.Mode_ADMHLP.equals(paramRequest.getMode()))
        {
            doAdminHlp(request, response, paramRequest);
            return;
        }
        if (SWBResourceURL.Mode_HELP.equals(paramRequest.getMode()))
        {
            doHelp(request, response, paramRequest);
            return;
        }
        if (SWBResourceURL.Mode_EDIT.equals(paramRequest.getMode()))
        {
            doEdit(request, response, paramRequest);
            return;
        }

        String mode = "menu";
        if (paramRequest.getMode() != null)
        {
            mode = paramRequest.getMode();
        }


        if (SWBResourceURL.Mode_ADMIN.equals(paramRequest.getMode()))
        {
            mode = "menu";
        }
        if ("gtwListSubGroups".equalsIgnoreCase(mode))
        {
            WebSite site = paramRequest.getWebPage().getWebSite();
            String grupo = request.getParameter("groupoPregunta");
            Grupo _grupo = Grupo.ClassMgr.getGrupo(grupo, site);
            if (_grupo != null)
            {
                GenericIterator<SubGrupo> subgrupos = _grupo.listSubGroups();
                StringBuilder sb = new StringBuilder();
                while (subgrupos.hasNext())
                {
                    SubGrupo subGrupo = subgrupos.next();
                    String title = subGrupo.getTitle();
                    sb.append("<option value=\"").append(subGrupo.getId()).append("\">").append(title).append("</option>");
                }
                PrintWriter out = response.getWriter();
                out.write(sb.toString());
            }
            return;
        }

        if ("gtwListPreguntas".equalsIgnoreCase(mode))
        {
            WebSite site = paramRequest.getWebPage().getWebSite();
            String nivel = request.getParameter("nivellist");
            Nivel objNivel = Nivel.ClassMgr.getNivel(nivel.toLowerCase(), site);
            if (objNivel == null)
            {
                return;
            }
            PrintWriter out = response.getWriter();
            StringBuilder sb = new StringBuilder();
            Iterator<Pregunta> preguntas = Pregunta.ClassMgr.listPreguntas(site);
            if (preguntas.hasNext())
            {
                sb.append("<table width=\"100%\">");
            }
            while (preguntas.hasNext())
            {
                Pregunta pregunta = preguntas.next();
                Iterator<Nivel> niveles = pregunta.listNiveleses();
                while (niveles.hasNext())
                {
                    Nivel onivel = niveles.next();
                    if (objNivel.equals(onivel))
                    {
                        String id = pregunta.getId();
                        String name = pregunta.getTexto();
                        String sgrupo = pregunta.getSubgrupo().getTitle();
                        String titleGrupo = pregunta.getSubgrupo().getGrupo().getTitle();
                        sb.append("<tr><td><input type=\"checkbox\" name=\"preguntaToAddSurvey\" value=\"").append(id).append("\">").append(name).append("</td><td>").append(sgrupo).append("</td><td>").append(titleGrupo).append("</td></tr>");
                    }
                }
            }
            if (preguntas.hasNext())
            {
                sb.append("</table>");
            }
            if ("".equals(sb.toString()))
            {
                sb.append("<p>No hay preguntas para este nivel></p>");
            }
            out.write(sb.toString());
            return;
        }


        String jsp = "/work/models/" + siteId + "/jsp/" + Survey.class.getSimpleName() + "/" + mode + ".jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }
}
