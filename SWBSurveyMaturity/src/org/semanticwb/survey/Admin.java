/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.semanticwb.questionnaire.BankInstitution;
import org.semanticwb.questionnaire.BankQuestion;
import org.semanticwb.questionnaire.BankSubQuestion;
import org.semanticwb.questionnaire.BankUnitsSubstantive;
import org.semanticwb.questionnaire.OptionQuestion;
import org.semanticwb.questionnaire.Part;
import org.semanticwb.questionnaire.Question;
import org.semanticwb.questionnaire.Questionnaire;
import org.semanticwb.questionnaire.Section;

/**
 *
 * @author victor.lorenzana
 */
public class Admin extends GenericResource {

    public static final String MODE_ADMON_QUESTION = "admonquestion";
    public static final String MODE_ADMON_SURVEY = "admonSurvey";
    public static final String MODE_ADMON_SECTION = "admonSection";
    public static final String MODE_ADMON_PART = "admonParte";
    public static final String MODE_ADMON_UNIT = "admonUnit";
    public static final String MODE_ADMON_INSTITUTION = "admonInstitution";
    public static final String MODE_BANK_SUBQUESTION = "dialogbankSubquestion";
    public static final String MODE_ADMON_SELECT_INSTITUTE = "selectInstitute";
    public static final String MODE_ADMON_BANK_SUBQUESTION = "dialogbankSubquestion";
    public static final String MODE_ADMON_ADD_PART = "addPart";
    public static final String MODE_ADMON_ADD_SECTION = "addSection";
    public static final String MODE_ADMON_ADD_INSTITUTION = "addInstitution";
    public static final String MODE_ADMON_ADD_UNIT = "addUnit";
    public static final String MODE_ADMON_ADD_SURVEY = "addSurvey";
    public static final String MODE_DIV_REFRESH_ADDSUBQUESTION = "divrefreshaddSubquestion";
    public static final String MODE_DIALOG_ADD_BANKQUESTION = "dialogbankquestions";
    public static final String MODE_SELECT_QUESTION = "admonquestion";
    public static final String MODE_FILTER_QUESTION = "filterQuestion";
    // public static final String MODE_ADD_SUBQUESTION = "addSubquestions";
    private static final Logger log = SWBUtils.getLogger(SurveyMaturity.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        SWBResourceURL urlResponse = paramRequest.getRenderUrl();
        PrintWriter out = response.getWriter();

        if (paramRequest.getMode().equals(MODE_ADMON_QUESTION)) {
            doReload(request, response, paramRequest, MODE_ADMON_QUESTION);
        } else if (paramRequest.getMode().equals(MODE_ADMON_SURVEY)) {
            doReload(request, response, paramRequest, MODE_ADMON_SURVEY);
        } else if (paramRequest.getMode().equals(MODE_ADMON_SECTION)) {
            doReload(request, response, paramRequest, MODE_ADMON_SECTION);
        } else if (paramRequest.getMode().equals(MODE_ADMON_PART)) {
            doReload(request, response, paramRequest, MODE_ADMON_PART);
        } else if (paramRequest.getMode().equals(MODE_ADMON_SELECT_INSTITUTE)) {
            doReload(request, response, paramRequest, MODE_ADMON_SELECT_INSTITUTE);
        } else if (paramRequest.getMode().equals("detailSurvey")) {
            doDetailSurvey(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(MODE_ADMON_UNIT)) {
            doReload(request, response, paramRequest, MODE_ADMON_UNIT);
        } else if (paramRequest.getMode().equals(MODE_ADMON_INSTITUTION)) {
            doReload(request, response, paramRequest, MODE_ADMON_INSTITUTION);
        } else if (paramRequest.getMode().equals(MODE_ADMON_BANK_SUBQUESTION)) {
            doReload(request, response, paramRequest, MODE_ADMON_BANK_SUBQUESTION);
        } else if (paramRequest.getMode().equals(MODE_ADMON_ADD_PART)) {
            doReload(request, response, paramRequest, MODE_ADMON_ADD_PART);
        } else if (paramRequest.getMode().equals(MODE_ADMON_ADD_SECTION)) {
            doReload(request, response, paramRequest, MODE_ADMON_ADD_SECTION);
        } else if (paramRequest.getMode().equals(MODE_ADMON_ADD_INSTITUTION)) {
            doReload(request, response, paramRequest, MODE_ADMON_ADD_INSTITUTION);
        } else if (paramRequest.getMode().equals(MODE_ADMON_ADD_UNIT)) {
            doReload(request, response, paramRequest, MODE_ADMON_ADD_UNIT);

        } else if (paramRequest.getMode().equals(MODE_ADMON_ADD_SURVEY)) {
            doReload(request, response, paramRequest, MODE_ADMON_ADD_SURVEY);

        } else if (paramRequest.getMode().equals(MODE_DIV_REFRESH_ADDSUBQUESTION)) {
            doReload(request, response, paramRequest, MODE_DIV_REFRESH_ADDSUBQUESTION);
        } else if (paramRequest.getMode().equals(MODE_DIALOG_ADD_BANKQUESTION)) {
            doReload(request, response, paramRequest, MODE_DIALOG_ADD_BANKQUESTION);
        } //else if(paramRequest.getMode().equals(MODE_SELECT_QUESTION)){
        //  doReload(request, response, paramRequest, MODE_SELECT_QUESTION);
        //} 
        else if (paramRequest.getMode().equals(MODE_FILTER_QUESTION)) {
            doReload(request, response, paramRequest, MODE_FILTER_QUESTION);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doDetailSurvey(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String path = "/swbadmin/jsp/SurveyMaturity/admon/editSurvey.jsp";
        System.out.println("entor al dodetailsurvey");
        System.out.print("URIqe recibe" + request.getParameter("uri"));
        request.setAttribute("uri", request.getParameter("uri"));
        request.setAttribute("title", request.getParameter("title"));
        request.setAttribute("paramRequest", paramRequest);

        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.include(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("<script>");
        } catch (ServletException ex) {
            System.out.println(ex);
            //java.util.logging.Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doReload(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, String jsp) throws SWBResourceException, IOException {

        String siteId = paramRequest.getWebPage().getWebSiteId();
        String path = "/swbadmin/jsp/SurveyMaturity/admon/" + jsp + ".jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String siteId = paramRequest.getWebPage().getWebSiteId();

        //String path = "/work/models/" + siteId + "/jsp/" + SurveyMaturity.class.getSimpleName() + "/admon/view.jsp";
        String path = "/swbadmin/jsp/SurveyMaturity/admon/view.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {




        WebSite ws = response.getWebPage().getWebSite();
        Resource base = getResourceBase();
        String action = response.getAction();
        System.out.println("Entro al action");
        System.out.println("Action" + action);


        if ("addSurvey".equals(action)) {

            if (request.getParameter("survey") == null) {
                addSurvey(request, response);
            } else {
                String id = request.getParameter("survey");
                editSurvey(request, response, id);
            }


        } else if ("removeSurvey".equals(action)) {
            System.out.println("entro al remove survey");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            Questionnaire rec = (Questionnaire) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("Cuestionario eliminado:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro
            }

        } else if ("addSection".equals(action)) {

            if (request.getParameter("section") == null) {
                addSection(request, response);
            } else {
                String id = request.getParameter("section");
                editSection(request, response, id);
            }

        } else if ("removeSection".equals(action)) {

            System.out.println("entro al remove section");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            Section rec = (Section) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("Seccion eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro

                SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/products/" + rec.getId() + "/");
            }
        } else if ("addPart".equals(action)) {
            if (request.getParameter("part") == null) {
                addPart(request, response);
            } else {
                String id = request.getParameter("part");
                editPart(request, response, id);
            }
        } else if ("removePart".equals(action)) {
            System.out.println("entro al removePart");

            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            Part rec = (Part) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("Part eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro

                SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/products/" + rec.getId() + "/");
            }


        } else if ("addInstitution".equals(action)) {
            if (request.getParameter("institution") == null) {
                addInstitution(request, response);
            } else {
                String id = request.getParameter("institution");
                editInstitution(request, response, id);
            }

        } else if ("removeInstitution".equals(action)) {
            System.out.println("entro al remove Institution");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            BankInstitution rec = (BankInstitution) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("institution  eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro
                SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/products/" + rec.getId() + "/");
            }
        } else if ("addUnit".equals(action)) {


            if (request.getParameter("unit") == null) {
                addUnit(request, response);
            } else {
                String id = request.getParameter("unit");
                editUnit(request, response, id);
            }


        } else if ("removeUnit".equals(action)) {

            System.out.println("entro al remove Unit");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            BankUnitsSubstantive rec = (BankUnitsSubstantive) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("Unidad  eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro
                SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/products/" + rec.getId() + "/");
            }

        } else if ("addQuestion".equals(action)) {


//            if (request.getParameter("question") == null) {
            addQuestion(request, response);
//            } else {
//                String id = request.getParameter("question");
//                editQuestion(request, response, id);
//            }


        } else if ("removeQuestion".equals(action)) {

            System.out.println("entro al remove Unit");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            Question rec = (Question) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("Unidad  eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro
            }

        } else if ("addSub".equals(action)) {
            System.out.println("entro al addSub");
            String validationSub = request.getParameter("validationSub");
            System.out.println("validationSub" + validationSub);
            HttpSession s;

            ArrayList<BankSubQuestion> tempo = new ArrayList<BankSubQuestion>();

            if (request.getParameter("validationSub").equals("addtheQuestion")) {
                System.out.println("OBTIENE EL ID Y SE LO MANDA");
                s = request.getSession(true);
                s.setAttribute("idNewSubQ", request.getParameter("uriAddSubquestion"));

                listaTemporalSubpreguntas(s, tempo, request.getParameter("uriAddSubquestion"));

                System.out.println("Salio del addSUB CON URI " + request.getParameter("uriAddSubquestion"));

            }
            if (request.getParameter("validationSub").equals("addtheQuestionandsave")) {
                System.out.println("AGREGAR UNA SUB Y DESPUES LE MANDA EL ID");
                BankSubQuestion q = BankSubQuestion.ClassMgr.createBankSubQuestion(ws);
                String textSub = request.getParameter("textSub");
                String type = request.getParameter("subType");
                System.out.println("texto subpregunta" + textSub);
                System.out.println("typo" + type);

                q.setTitle(textSub);
                q.setTypeSubquestion(type);

                s = request.getSession(true);
                s.setAttribute("idNewSubQ", q.getURI());
                listaTemporalSubpreguntas(s, tempo, q.getURI());
                System.out.println("Salio del addSUB CON URI " + q.getTitle() + " " + q.getURI());

            }
        } else if ("removeSubquestion".equals(action)) {
            System.out.println("entro al removeSubquestion");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            BankSubQuestion rec = (BankSubQuestion) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("subpregunta eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                      //elimina el registro

            }

        } else if ("removeSubqueQue".equals(action)) {
            HttpSession s = request.getSession(true);
            System.out.println("** remover un elelemto de un objeto de session");
            String uri = request.getParameter("uri");
            System.out.println("uri que recibe" + uri);
            ArrayList<BankSubQuestion> tempo = new ArrayList<BankSubQuestion>();
            tempo = (ArrayList<BankSubQuestion>) s.getAttribute("listaTemporal");

            Iterator i = tempo.iterator();
            while (i.hasNext()) {
                BankSubQuestion c = (BankSubQuestion) i.next();
                System.out.println("C" + c);
                System.out.println("uri" + uri);
                String cc = c.getURI().toString();
                if (cc.equals(uri)) {
                    System.out.println("entro al if del remove");
                    tempo.remove(c);
                    break;
                }
            }

            s.setAttribute("listaTemporal", tempo);
        } else if ("removeBankquestion".equals(action)) {
            System.out.println("entro al remove bankquestion");
            String uri = request.getParameter("uri");
            System.out.println("URI" + uri);
            BankQuestion rec = (BankQuestion) SemanticObject.createSemanticObject(uri).createGenericInstance();

            System.out.println("BankQuestion  eliminada:" + uri);
            if (rec != null) {
                rec.remove();                                       //elimina el registro
                SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + base.getWorkPath() + "/products/" + rec.getId() + "/");
            }
        } else if ("addBankQuestion".equals(action)) {
            System.out.println("entro agregar pregunta");
            HttpSession s;

            ArrayList<BankQuestion> tempoBankQuestion = new ArrayList<BankQuestion>();
            String validation = request.getParameter("idDialogBankQuestion");
            System.out.println("comparara con " + validation);


            if (request.getParameter("idDialogBankQuestion").equals("")) {

                System.out.println("entro agregar nuevo en el bankquestion");
                String textQuestion = request.getParameter("textquestion");
                String descriptionQuestion = request.getParameter("descriptionQuestion");
                String noteQuestion = request.getParameter("noteQuestion");

                BankQuestion bq = BankQuestion.ClassMgr.createBankQuestion(ws);
                bq.setTextQuestion(textQuestion);
                bq.setDescription(descriptionQuestion);
                bq.setNote(noteQuestion);

                s = request.getSession(true);
                s.setAttribute("idNewQuestion", bq.getURI());
                listaTemporalPreguntas(s, tempoBankQuestion, bq.getURI());
                System.out.println("Salio del addbankquestion CON URI " + bq.getTitle() + " " + bq.getURI());



            } else {

                System.out.println("OBTIENE EL ID Y SE LO MANDA");
                s = request.getSession(true);
                s.setAttribute("idNewQuestion", request.getParameter("idDialogBankQuestion"));

                listaTemporalPreguntas(s, tempoBankQuestion, request.getParameter("idDialogBankQuestion"));

                System.out.println("Salio del addSUB CON URI " + request.getParameter("idDialogBankQuestion"));



            }



        } else if ("removequeQue".equals(action)) {
            System.out.println("borrar uan pregunta de la lista temporal");
            HttpSession s = request.getSession(true);

            String uri = request.getParameter("uri");
            System.out.println("uri que recibe" + uri);
            ArrayList<BankQuestion> tempo = new ArrayList<BankQuestion>();
            tempo = (ArrayList<BankQuestion>) s.getAttribute("listaTemporalBankQuestion");

            Iterator i = tempo.iterator();
            while (i.hasNext()) {
                BankQuestion c = (BankQuestion) i.next();
                System.out.println("C" + c);
                System.out.println("uri" + uri);
                String cc = c.getURI().toString();
                if (cc.equals(uri)) {
                    System.out.println("entro al if del remove");
                    tempo.remove(c);
                    break;
                }
            }

            s.setAttribute("listaTemporalBankQuestion", tempo);

        } else if ("cargarCuestionario".equals(action)) {
            System.out.println("entro al cargar cuestionario");
            System.out.println("++++" + response.toString());
            String valor = request.getParameter("insFilter");
            String valor2 = (String) request.getAttribute("insFilter");

            System.out.println("valorde insFilter" + valor);
            System.out.println("valorde insFilter" + valor2);

            request.setAttribute("insFilter", valor);
        } else if ("MODE_FILTER_QUESTION".equals(action)) {
            System.out.println("entra al action con ode_filter_question");

            HttpSession s = request.getSession(true);
            String id = (String) request.getAttribute("insFilter");
            System.out.println("valor de insFilter para andatselo a session" + id);
            s.setAttribute("insFilter", id);

            String sendquestionnaire = (String) request.getAttribute("sendquestionnaire");
            System.out.println("sendquestionnaire" + sendquestionnaire);
        }


    }

    public void listaTemporalSubpreguntas(HttpSession s, ArrayList<BankSubQuestion> tempo, String uri) {
        System.out.println("entro al metodo listaTemporal que trae la lista");
        if (s.getAttribute("listaTemporal") != null) {
            tempo = (ArrayList<BankSubQuestion>) s.getAttribute("listaTemporal");
        }
        BankSubQuestion rec = (BankSubQuestion) SemanticObject.createSemanticObject(uri).createGenericInstance();
        tempo.add(rec);

        Iterator i = tempo.iterator();
        while (i.hasNext()) {
            System.out.println("lista elemento" + i.next());
        }
        s.setAttribute("listaTemporal", tempo);
    }

    public void listaTemporalPreguntas(HttpSession s, ArrayList<BankQuestion> tempoBankQuestion, String uri) {
        System.out.println("entro al metodo listaTemporal que trae la lista");

        if (s.getAttribute("listaTemporalBankQuestion") != null) {
            tempoBankQuestion = (ArrayList<BankQuestion>) s.getAttribute("listaTemporalBankQuestion");
        }
        BankQuestion rec = (BankQuestion) SemanticObject.createSemanticObject(uri).createGenericInstance();
        tempoBankQuestion.add(rec);

        Iterator i = tempoBankQuestion.iterator();
        while (i.hasNext()) {
            System.out.println("lista elemento" + i.next());
        }
        s.setAttribute("listaTemporalBankQuestion", tempoBankQuestion);
    }

    public void editPart(HttpServletRequest request, SWBActionResponse response, String id) throws SWBResourceException, IOException {
        String tituloparte = request.getParameter("tituloparte");
        String descriptionparte = request.getParameter("descriptionparte");
        String namepart = request.getParameter("namepart");
        if (tituloparte != null && descriptionparte != null && namepart != null) {
            WebSite ws = response.getWebPage().getWebSite();
            Part part = Part.ClassMgr.getPart(id, ws);
            part.setNamePart(namepart);
            part.setTitle(tituloparte);
            part.setDescription(descriptionparte);
        }
    }

    public void addPart(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {

        String tituloparte = request.getParameter("tituloparte");
        String descriptionparte = request.getParameter("descriptionparte");
        String namepart = request.getParameter("namepart");
        if (tituloparte != null && descriptionparte != null && namepart != null) {
            WebSite ws = response.getWebPage().getWebSite();
            Part part = Part.ClassMgr.createPart(ws);
            part.setNamePart(namepart);
            part.setTitle(tituloparte);
            part.setDescription(descriptionparte);
        }

    }

    private void addSection(HttpServletRequest request, SWBActionResponse response) {
        System.out.println("entro al addsection");
        String title = request.getParameter("titulosection");
        String description = request.getParameter("descripcionsection");
        WebSite ws = response.getWebPage().getWebSite();

        Section q = Section.ClassMgr.createSection(ws);
        q.setTitle(title);
        q.setDescription(description);
    }

    private void editSection(HttpServletRequest request, SWBActionResponse response, String id) {
        System.out.println("entro al editsection");
        String title = request.getParameter("titulosection");
        String description = request.getParameter("descripcionsection");
        WebSite ws = response.getWebPage().getWebSite();

        Section s = Section.ClassMgr.getSection(id, ws);
        s.setTitle(title);
        s.setDescription(description);

    }

    private void addInstitution(HttpServletRequest request, SWBActionResponse response) {
        System.out.println("entro al addInstitution");
        WebSite ws = response.getWebPage().getWebSite();


        String name = request.getParameter("nameInstitution");
        String sectorInstitution = request.getParameter("sectorInstitution");
        String stateInstitution = request.getParameter("stateInstitution");
        String acronymInstitution = request.getParameter("acronymInstitution");
        String addressInstitution = request.getParameter("addressInstitution");

        BankInstitution q = BankInstitution.ClassMgr.createBankInstitution(ws);
        q.setNameInstitution(name);
        q.setSector(sectorInstitution);
        q.setAcronym(acronymInstitution);
        q.setAddress(addressInstitution);
        q.setState(stateInstitution);

    }

    private void editInstitution(HttpServletRequest request, SWBActionResponse response, String id) {
        System.out.println("entro al editInstitution");
        WebSite ws = response.getWebPage().getWebSite();

        String name = request.getParameter("nameInstitution");
        String sectorInstitution = request.getParameter("sectorInstitution");
        String stateInstitution = request.getParameter("stateInstitution");
        String acronymInstitution = request.getParameter("acronymInstitution");
        String addressInstitution = request.getParameter("addressInstitution");

        BankInstitution q = BankInstitution.ClassMgr.getBankInstitution(id, ws);
        q.setNameInstitution(name);
        q.setSector(sectorInstitution);
        q.setAcronym(acronymInstitution);
        q.setAddress(addressInstitution);
        q.setState(stateInstitution);

    }

    private void addUnit(HttpServletRequest request, SWBActionResponse response) {
        System.out.println("entro al addUnit");
        WebSite ws = response.getWebPage().getWebSite();
        String title = request.getParameter("nameUnit");
        String institution = request.getParameter("unitInstitution");
        System.out.println("institucion recibida" + institution);

        BankUnitsSubstantive q = BankUnitsSubstantive.ClassMgr.createBankUnitsSubstantive(ws);
        q.setNameUnitSubstantive(title);

    }

    private void editUnit(HttpServletRequest request, SWBActionResponse response, String id) {
        System.out.println("entro al editUnit");
        WebSite ws = response.getWebPage().getWebSite();

        String title = request.getParameter("nameUnit");
        String institution = request.getParameter("unitInstitution");
        System.out.println("institucion recibida" + institution);

        BankUnitsSubstantive q = BankUnitsSubstantive.ClassMgr.getBankUnitsSubstantive(id, ws);
        q.setNameUnitSubstantive(title);

    }

    private void addSurvey(HttpServletRequest request, SWBActionResponse response) {
        System.out.println("entro al add survey");
        WebSite ws = response.getWebPage().getWebSite();
        String title = request.getParameter("tituloSurvey");
        String presentation = request.getParameter("presentacion");
        String instructions = request.getParameter("instrucciones");

        Questionnaire q = Questionnaire.ClassMgr.createQuestionnaire(ws);
        q.setTitle(title);
        q.setPresentation(presentation);
        q.setInstructions(instructions);


    }

    private void editSurvey(HttpServletRequest request, SWBActionResponse response, String id) {
        System.out.println("entro al edit survey");
        WebSite ws = response.getWebPage().getWebSite();
        String title = request.getParameter("tituloSurvey");
        String presentation = request.getParameter("presentacion");
        String instructions = request.getParameter("instrucciones");
        String suri = request.getParameter("suri");

        Questionnaire rec = Questionnaire.ClassMgr.getQuestionnaire(id, ws);

        rec.setTitle(title);
        rec.setInstructions(instructions);
        rec.setPresentation(presentation);



    }

    private void addQuestion(HttpServletRequest request, SWBActionResponse response) {
        System.out.println("entro al addQuestion");
        HttpSession s = request.getSession(true);
        WebSite ws = response.getWebPage().getWebSite();
        String cuestionario = request.getParameter("sendquestionnaire");
        String p = request.getParameter("sendpart");
        String seccion = request.getParameter("sendsection");

        Part parte = Part.ClassMgr.getPart(p, ws);;
        Section section = Section.ClassMgr.getSection(seccion, ws);
        Questionnaire cues = Questionnaire.ClassMgr.getQuestionnaire(cuestionario, ws);;

        ArrayList<BankQuestion> listaTemporalBankQuestion = new ArrayList();
        listaTemporalBankQuestion = (ArrayList<BankQuestion>) s.getAttribute("listaTemporalBankQuestion");
        Iterator i = listaTemporalBankQuestion.iterator();

        BankQuestion bquestion = null;

        while (i.hasNext()) {
            bquestion = (BankQuestion) i.next();
            System.out.println("elementos de la lista temporal" + bquestion);
            Question question = Question.ClassMgr.createQuestion(ws);
            question.setOptionPart(parte);
            question.setOptionSection(section);
            question.setOptionQuestionnaire(cues);
            question.setQuestionBank(bquestion);

            
                ArrayList<BankSubQuestion> listaTemporalSubQuestion = new ArrayList();
                listaTemporalSubQuestion = (ArrayList<BankSubQuestion>) s.getAttribute("listaTemporal");
                Iterator ii = listaTemporalSubQuestion.iterator();
                
                OptionQuestion oq= null;
                while(ii.hasNext()){
                BankSubQuestion bankSubque= (BankSubQuestion)ii.next();
                    System.out.println("optQues"+bankSubque);
                    oq.addSubquestion(bankSubque);
                }
            

        }


        //+++++ERROR EN EL CASTEO

        //agregar las subpreguntas, para eso creamos un objeto de la clase option qestion y le agregamos las subpreguntas.
//        OptionQuestion o = OptionQuestion.ClassMgr.createOptionQuestion(ws);
//        
//        
//        
//        while(i.hasNext()){
//            
//        //Creas un cuestionario
//            BankQuestion bq= (BankQuestion)i.next();
//            Question question = Question.ClassMgr.createQuestion(ws);        
//            //question.setOptionQuestionnaire(rec);
//           // question.setOptionPart(part);
//            question.setOptionSection(sec);
//            question.setQuestionBank(bq);
//        
//        }
//        
//        Question que = (Question) Question.ClassMgr.listQuestions();
//        System.out.println("lista de question"+que);
//    
//        
    }

    private void editQuestion(HttpServletRequest request, SWBActionResponse response, String id) {
        System.out.println("entro al remove Question");
    }
}
