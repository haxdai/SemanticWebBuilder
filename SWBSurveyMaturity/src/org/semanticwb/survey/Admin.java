/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.questionnaire.Part;
import org.semanticwb.questionnaire.Questionnaire;
import org.semanticwb.questionnaire.Section;

/**
 *
 * @author victor.lorenzana
 */
public class Admin extends GenericResource
{

    public static final String MODE_ADMON_QUESTION = "admonquestion";
    public static final String MODE_ADMON_SURVEY = "admonSurvey";
    public static final String MODE_ADMON_SECTION = "admonSection";
    public static final String MODE_ADMON_PART = "admonParte";
    public static final String MODE_ADMON_SHOW_QUESTIONS = "showQuestions";
    public static final String MODE_ADMON_ADD_PART = "addPart";
    private static final Logger log = SWBUtils.getLogger(SurveyMaturity.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        SWBResourceURL urlResponse = paramRequest.getRenderUrl();

        if (paramRequest.getMode().equals(MODE_ADMON_QUESTION))
        {
            doReload(request, response, paramRequest, MODE_ADMON_QUESTION);
        }
        if (paramRequest.getMode().equals(MODE_ADMON_ADD_PART))
        {
            doReload(request, response, paramRequest, MODE_ADMON_ADD_PART);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_SURVEY))
        {
            doReload(request, response, paramRequest, MODE_ADMON_SURVEY);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_SECTION))
        {
            doReload(request, response, paramRequest, MODE_ADMON_SECTION);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_PART))
        {
            doReload(request, response, paramRequest, MODE_ADMON_PART);
        }
        else if (paramRequest.getMode().equals(MODE_ADMON_SHOW_QUESTIONS))
        {
            doReload(request, response, paramRequest, MODE_ADMON_SHOW_QUESTIONS);
        }
        else if (paramRequest.getMode().equals("reloadComments"))
        {
            PrintWriter out = response.getWriter();
            Iterator<Questionnaire> report = Questionnaire.ClassMgr.listQuestionnaires(paramRequest.getWebPage().getWebSite());
            SWBResourceURL url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
            urlResponse = paramRequest.getRenderUrl();

            out.println("<script type=\"text/javascript\">");
            out.println("function showEditSurvey()");
            out.println("{");
            out.println("dijit.byId(\"dialogeditSurvey\").show(); ");
            out.println("}");
            out.println("</script>");


            out.println("<fieldset>");
            out.println(" <legend>Cuestionarios</legend>");
            out.println("<table class=\"tabla-bandeja\" border=\"1\" width=\"100%\" style=\"overflow: auto\">");
            out.println("    <thead>");
            out.println(" <th >");
            out.println("   Cuestionarios disponibles");
            out.println("  </th>");
            out.println(" <th width=\"160px\" align=\"right\">");
            out.println("     Acciones");
            out.println(" </th>");
            out.println(" </thead>");
            while (report.hasNext())
            {
                Questionnaire rp = report.next();
                out.println("<tr> ");
                out.println("<td class=\"tban-tarea\">");
                out.println("  " + rp.getTitle() + "");
                out.println("</td>");
                out.println("<td style=\"text-align: center;\" class=\"tban-tarea\">");
                String suri = rp.getURI();
                String surii = URLEncoder.encode(suri);
                urlResponse.setMode("edit");
                out.println(" <a href=\"#\" title=\"Editar\" onclick=\" showEditSurvey();\"><img src=\"/swbadmin/jsp/Questionnaire/images/edit.png\"></a>");
                url.setParameter("uri", suri);
                out.println(" <a href=\"#\" title=\"Eliminar\" onclick=\"postHtml('" + url.setAction(SWBResourceURL.Action_REMOVE) + "','respuesta'); return false;\" ><img src=\"/swbadmin/jsp/Questionnaire/images/delete.png\"></a>");
                out.println("  <a href=\" # \" title=\"Vista previa\"><img src=\"/swbadmin/jsp/Questionnaire/images/preview.png\"></a> ");
                out.println("</td>");
                out.println(" </tr>");
            }
            out.println("  </table>");
            out.println("</fieldset>");

        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doReload(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, String jsp) throws SWBResourceException, IOException
    {

        String siteId = paramRequest.getWebPage().getWebSiteId();
        String path = "/swbadmin/jsp/SurveyMaturity/admon/" + jsp + ".jsp";
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

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        String siteId = paramRequest.getWebPage().getWebSiteId();

        //String path = "/work/models/" + siteId + "/jsp/" + SurveyMaturity.class.getSimpleName() + "/admon/view.jsp";
        String path = "/swbadmin/jsp/SurveyMaturity/admon/view.jsp";
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

    public void editPart(HttpServletRequest request, SWBActionResponse response,String id) throws SWBResourceException, IOException
    {
        String tituloparte = request.getParameter("tituloparte");
        String descriptionparte = request.getParameter("descriptionparte");
        String namepart = request.getParameter("namepart");
        if (tituloparte != null && descriptionparte != null && namepart != null)
        {
            WebSite ws = response.getWebPage().getWebSite();
            Part part = Part.ClassMgr.getPart(id,ws);
            part.setNamePart(namepart);
            part.setTitle(tituloparte);
            part.setDescription(descriptionparte);
        }
    }
    public void addPart(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {

        String tituloparte = request.getParameter("tituloparte");
        String descriptionparte = request.getParameter("descriptionparte");
        String namepart = request.getParameter("namepart");
        if (tituloparte != null && descriptionparte != null && namepart != null)
        {
            WebSite ws = response.getWebPage().getWebSite();
            Part part = Part.ClassMgr.createPart(ws);
            part.setNamePart(namepart);
            part.setTitle(tituloparte);
            part.setDescription(descriptionparte);
        }

    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {

        WebSite ws = response.getWebPage().getWebSite();
        Resource base = getResourceBase();
        String action = response.getAction();
        System.out.println("Entro al action");
        System.out.println("Action" + action);
        if (SWBResourceURL.Action_ADD.equals(action))
        {

            System.out.println("entro al add");
            String title = request.getParameter("title");
            String presentacion = request.getParameter("presentacion");
            String instrucciones = request.getParameter("instrucciones");

            Questionnaire q = Questionnaire.ClassMgr.createQuestionnaire(ws);
            q.setTitle(title);
            q.setPresentation(presentacion);
            q.setInstructions(instrucciones);


        }
        else if (SWBResourceURL.Action_REMOVE.equals(action))
        {


            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            Questionnaire rec = (Questionnaire) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("Cuestionario eliminado:" + uri);
            if (rec != null)
            {
                rec.remove();                                       //elimina el registro
                //Elimina filesystem de thread
                SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/products/" + rec.getId() + "/");

            }
            response.setMode("reloadComments");

        }
        else if (SWBResourceURL.Action_EDIT.equals(action))
        {
            System.out.println("entro al edit");

            String textInst = request.getParameter("textInst");
            String title = request.getParameter("title");
            String textPre = request.getParameter("textPre");
            String suri = request.getParameter("suri");

            Questionnaire rec = (Questionnaire) SemanticObject.createSemanticObject(suri).createGenericInstance();
            rec.setTitle(title);
            rec.setInstructions(textInst);
            rec.setPresentation(textPre);

        }
        else if ("addPart".equals(action))
        {
            if(request.getParameter("part")==null)
            {
                addPart(request, response);
            }
            else
            {
                String id=request.getParameter("part");
                editPart(request, response,id);
            }
        }
        else if ("addSection".equals(action))
        {
            System.out.println("entro al addsection");
            String title = request.getParameter("titleSection");
            String description = request.getParameter("descriptionSection");
            Section q = Section.ClassMgr.createSection(ws);
            q.setTitle(title);
            q.setDescription(description);

        }
        else if ("removePart".equals(action))
        {
            String uri = request.getParameter("uri");            
            Part rec = (Part) SemanticObject.createSemanticObject(uri).createGenericInstance();            
            if (rec != null)
            {
                rec.remove();                                       //elimina el registro
            }
        }
    }
}
