/**
 * SWB Social es una plataforma que descentraliza la publicación, seguimiento y
 * monitoreo hacia las principales redes sociales. SWB Social escucha y entiende
 * opiniones acerca de una organización, sus productos, sus servicios e
 * inclusive de su competencia, detectando en la información sentimientos,
 * influencia, geolocalización e idioma, entre mucha más información relevante
 * que puede ser útil para la toma de decisiones.
 * 
* SWB Social, es una herramienta basada en la plataforma SemanticWebBuilder.
 * SWB Social, como SemanticWebBuilder, es una creación original del Fondo de
 * Información y Documentación para la Industria INFOTEC, cuyo registro se
 * encuentra actualmente en trámite.
 * 
* INFOTEC pone a su disposición la herramienta SWB Social a través de su
 * licenciamiento abierto al público (‘open source’), en virtud del cual, usted
 * podrá usarla en las mismas condiciones con que INFOTEC la ha diseñado y
 * puesto a su disposición; aprender de élla; distribuirla a terceros; acceder a
 * su código fuente y modificarla, y combinarla o enlazarla con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA
 * ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización del
 * SemanticWebBuilder 4.0. y SWB Social 1.0
 * 
* INFOTEC no otorga garantía sobre SWB Social, de ninguna especie y naturaleza,
 * ni implícita ni explícita, siendo usted completamente responsable de la
 * utilización que le dé y asumiendo la totalidad de los riesgos que puedan
 * derivar de la misma.
 * 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder o SWB
 * Social, INFOTEC pone a su disposición la siguiente dirección electrónica:
 * http://www.semanticwebbuilder.org
 *
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Descriptiveable;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.DevicePlatform;
import org.semanticwb.social.MessageIn;
import org.semanticwb.social.PhotoIn;
import org.semanticwb.social.PostIn;
import org.semanticwb.social.SWBSocial;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialNetworkUser;
import org.semanticwb.social.SocialSite;
import org.semanticwb.social.SocialTopic;
import org.semanticwb.social.Stream;
import org.semanticwb.social.VideoIn;
import org.semanticwb.social.admin.resources.util.SWBSocialResUtil;
import org.semanticwb.social.util.SWBSocialUtil;

/**
 *
 * @author jorge.jimenez
 */
public class PieChart extends GenericResource {

    private static Logger log = SWBUtils.getLogger(PieChart.class);

    /**
     * Representa la gr&aacute;fica "Usuarios con m&aacute;s interacci&oacute;n"
     */
    public static final String MODE_TopUser = "topUser";
    /**
     * Representa la exportaci&oacute;n de la gr&aacute;fica "N&uacute;mero de
     * mensajes por hora del d&iacute;a" y "Mensajes por hora del d&iacute;a por
     * red social"
     */
    public static final String MODE_ExportSpecificData = "exportSpecificData";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if (request.getParameter("doView") == null) {
            doEdit(request, response, paramRequest);
            return;
        }
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/stream/pieChart.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(myPath);
        if (dis != null) {
            try {
                request.setAttribute("paramRequest", paramRequest);
                request.setAttribute("suri", request.getParameter("suri"));
                dis.include(request, response);
            } catch (Exception ex) {
                log.error(ex);
            }
        }

    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String sinceDateAnalysis = "";
        String toDateAnalysis = "";
        String suri = request.getParameter("suri");
        String paramSinceDateAnalysis = "sinceDateAnalysis";
        String paramToDateAnalysis = "toDateAnalysis";
        if (suri != null) {
            SemanticObject semObj = SemanticObject.createSemanticObject(suri);
            String clsName = semObj.createGenericInstance().getClass().getName();
            if (semObj != null) {
                sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName) == null ? "" : request.getParameter("sinceDateAnalysis" + clsName);
                toDateAnalysis = request.getParameter("toDateAnalysis" + clsName) == null ? "" : request.getParameter("toDateAnalysis" + clsName);
                //Stream socialNet = (Stream) SemanticObject.getSemanticObject(suri).createGenericInstance();
                out.println("<form id=\"frmFilter" + clsName + "\" name=\"frmFilter" + clsName + "\" dojoType=\"dijit.form.Form\" class=\"swbform\" method=\"post\" action=\""
                        + paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).setParameter("suri", semObj.getURI())
                        + "\" method=\"post\" "
                        + " onsubmit=\"submitForm('frmFilter" + clsName + "'); return false;\">");
                out.println("<label>Del día</label>");
                out.println("<input name=\"sinceDateAnalysis" + clsName + "\" id=\"sinceDateAnalysis" + clsName + "\" dojoType=\"dijit.form.DateTextBox\"  size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""
                        + sinceDateAnalysis + "\" data-dojo-id=\"sinceDateAnalysis" + semObj.getId() + "\""
                        + " onChange=\"toDateAnalysis" + semObj.getId() + ".constraints.min = arguments[0];\">");
                out.println("<label for=\"toDate\"> al día:</label>");
                out.println("<input name=\"toDateAnalysis" + clsName + "\" id=\"toDateAnalysis" + clsName + "\" dojoType=\"dijit.form.DateTextBox\"  size=\"11\" style=\"width:110px;\" hasDownArrow=\"true\" value=\""
                        + toDateAnalysis + "\" data-dojo-id=\"toDateAnalysis" + semObj.getId() + "\""
                        + " onChange=\"sinceDateAnalysis" + semObj.getId() + ".constraints.max = arguments[0];\">");
                out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\">Calcular</button>");
                out.println("</form>");
                paramSinceDateAnalysis += clsName;
                paramToDateAnalysis += clsName;
            }
        }
        out.println("<iframe width=\"100%\" height=\"100%\" src=\"" + paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).setParameter("doView", "1").setParameter("suri", request.getParameter("suri")).setParameter(paramToDateAnalysis, toDateAnalysis).setParameter(paramSinceDateAnalysis, sinceDateAnalysis) + "\"></iframe> ");
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (mode.equals("InfographBar")) {
            doPreview(request, response, paramRequest);
        } else if (mode.equals("showBarByDay")) {
            showBarByDay(request, response, paramRequest);
        } else if (mode.equals("showGraphBar") || mode.equals("anioMes")) {
            showGraphBar(request, response, paramRequest);
        } else if (mode.equals("exportExcel")) {
            try {
                doGenerateReport(request, response, paramRequest);
            } catch (Exception e) {
                log.error(e);
            }
        } else if (MODE_ExportSpecificData.equals(mode)) {
            doGenerateReportSpecificData(request, response, paramRequest);
        } else if (MODE_TopUser.equals(mode)) {
            doShowGraphTopUser(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    private void doPreview(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws IOException {
        RequestDispatcher rd = request.getRequestDispatcher(SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/stream/graphBarFilter.jsp");
        request.setAttribute("suri", request.getParameter("suri"));
        request.setAttribute("selected", request.getParameter("selected"));
        request.setAttribute("selectAnio2", request.getParameter("selectAnio2"));
        request.setAttribute("selectMes", request.getParameter("selectMes"));
        request.setAttribute("paramRequest", paramRequest);
        try {
            rd.include(request, response);
        } catch (ServletException ex) {
            log.error("Error  " + ex.getMessage());
        }
    }

    private void showGraphBar(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws IOException, SWBResourceException {

        if (request.getParameter("doViewGraph") == null) {
            doEditGraph(request, response, paramRequest);
            return;
        }

        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/stream/showGraphBar.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(myPath);
        if (dis != null) {
            try {
                request.setAttribute("suri", request.getParameter("suri"));
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception ex) {
                log.error(ex);
            }
        }
    }

    public void doEditGraph(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();

        String selectedanio = request.getParameter("selectedAnio") == null ? "" : request.getParameter("selectedAnio");
        String selectAnio = request.getParameter("selectAnio") == null ? "" : request.getParameter("selectAnio");
        String selectMes = request.getParameter("selectMes") == null ? "" : request.getParameter("selectMes");
        out.println("<iframe  id=\"inneriframe\" src=\"" + paramRequest.getRenderUrl().setMode("showGraphBar").setParameter("doViewGraph", "1").setParameter("suri", request.getParameter("suri")).setParameter("selectedAnio", selectedanio).setParameter("selectAnio", selectAnio).setParameter("selectMes", selectMes) + "\"  frameborder=\"0\" width=\"100%\"   marginheight=\"0\" marginwidth=\"0\"  scrolling=\"no\"></iframe>"); //frameborder=\"0\" style=\"overflow:hidden;overflow-x:hidden;overflow-y:hidden;height:100%;width:100%;position:absolute;top:0px;left:0px;right:0px;bottom:0px\" height=\"100%\" width=\"100%\" ></iframe> ");

    }

    private void showBarByDay(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws IOException, SWBResourceException {

        if (request.getParameter("doViewGraph") == null) {
            doEditGraphByDay(request, response, paramRequest);
            return;
        }

        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/stream/postInByHour.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(myPath);
        if (dis != null) {
            try {
                request.setAttribute("suri", request.getParameter("suri"));
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception ex) {
                log.error(ex);
            }
        }
    }

    public void doEditGraphByDay(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();

        String selectedAnio = request.getParameter("selectedAnio") == null ? "" : request.getParameter("selectedAnio");
        String selectedMes = request.getParameter("selectedMes") == null ? "" : request.getParameter("selectedMes");
        String selectedDia = request.getParameter("selectedDia") == null ? "" : request.getParameter("selectedDia");
        out.println("<iframe  id=\"inneriframe1\" src=\"" + paramRequest.getRenderUrl().setMode("showBarByDay").setParameter("doViewGraph", "1").setParameter("suri", request.getParameter("suri")).setParameter("selectedAnio", selectedAnio).setParameter("selectedMes", selectedMes).setParameter("selectedDia", selectedDia) + "\"  frameborder=\"0\" width=\"100%\"   marginheight=\"0\" marginwidth=\"0\"  scrolling=\"no\"></iframe>"); //frameborder=\"0\" style=\"overflow:hidden;overflow-x:hidden;overflow-y:hidden;height:100%;width:100%;position:absolute;top:0px;left:0px;right:0px;bottom:0px\" height=\"100%\" width=\"100%\" ></iframe> ");

    }

    private void doGenerateReport(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws JSONException, IOException, com.hp.hpl.jena.sparql.lib.org.json.JSONException {
        //HashMap hmapResult = filtros(swbSocialUser, webSite, searchWord, request, stream, page);
        String suri = request.getParameter("suri");
        String title = "";
        SemanticObject semObjParam = null;
        String clsName = "";

        if (SemanticObject.getSemanticObject(suri).getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) SemanticObject.getSemanticObject(suri).getGenericInstance();
            title = stream.getTitle();
            semObjParam = stream.getSemanticObject();
            clsName = stream.getClass().getName();
        } else if (SemanticObject.getSemanticObject(suri).getGenericInstance() instanceof SocialTopic) {
            SocialTopic sTopic = (SocialTopic) SemanticObject.getSemanticObject(suri).getGenericInstance();
            title = sTopic.getTitle();
            semObjParam = sTopic.getSemanticObject();
            clsName = sTopic.getClass().getName();
        }
        //clsName = semObjParam.createGenericInstance().getClass().getName();

        String type = request.getParameter("type");
        String filter = request.getParameter("filter");
        String filterGeneral = request.getParameter("filterGeneral");
        String sinceDateAnalysis = null;
        String toDateAnalysis = null;

        if (semObjParam != null) {
            sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName);
            toDateAnalysis = request.getParameter("toDateAnalysis" + clsName);
        }

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sinDateAnalysis = null;
        Date tDateAnalysis = null;
        if (sinceDateAnalysis != null && toDateAnalysis != null) {
            try {
                sinDateAnalysis = formatDate.parse(sinceDateAnalysis);
            } catch (java.text.ParseException e) {
            }
            try {
                toDateAnalysis += " 23:59:59";
                tDateAnalysis = formatTo.parse(toDateAnalysis);
            } catch (java.text.ParseException e) {
            }
        }
        ////System.out.println("\nGenerando Reporte: " + type+"-" + filter +"-" + filterGeneral+"-"+request.getParameter("lang"));
        if (filter == null) {
            filter = "";
        }
        Iterator<PostIn> setso = null;

        String lang = paramRequest.getUser().getLanguage();

        if (type.equals("socialNetwork")) {
            setso = getSocialNetwork(suri, lang, filterGeneral, filter);
        } else if (type.equals("graphBar")) {
            setso = getGraphBar(request, suri, lang, filterGeneral, filter);
        } else if (type.equals("graphBar2")) {
            setso = getGraphBar2(request, suri);
        } else if (type.equals("graphBarByHour")) {
            setso = getGraphBarByHour(request);
        } else if (type.equals("graphChartTopUser")) {
            setso = getGraphChartTopUser(request, semObjParam);
            sinDateAnalysis = null;
            tDateAnalysis = null;
        } else {
            setso = getListSentiment(suri, lang, filter);
        }
        if (sinDateAnalysis != null && tDateAnalysis != null) {
            setso = SWBSocialResUtil.Util.getFilterDates(setso, sinDateAnalysis, tDateAnalysis);
        }
        try {

            createExcel(setso, paramRequest, response, title);

        } catch (Exception e) {
            log.error(e);
        }
    }

    private Iterator getListSentiment(String suri, String lang, String filter) {

        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        int neutrals = 0, positives = 0, negatives = 0;

        ArrayList positivesArray = new ArrayList();
        ArrayList negativesArray = new ArrayList();
        ArrayList neutralsArray = new ArrayList();
        ArrayList totalArray = new ArrayList();
        Iterator i = null;

        Iterator<PostIn> itObjPostIns = null;
        if (semObj.getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) semObj.getGenericInstance();
            itObjPostIns = stream.listPostInStreamInvs();
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
            itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        }

        while (itObjPostIns.hasNext()) {
            PostIn postIn = itObjPostIns.next();
            if (postIn != null) {
                if (postIn.getPostSentimentalType() == 0) {
                    neutrals++;
                    neutralsArray.add(postIn);
                } else if (postIn.getPostSentimentalType() == 1) {
                    positives++;
                    positivesArray.add(postIn);
                } else if (postIn.getPostSentimentalType() == 2) {
                    negatives++;
                    negativesArray.add(postIn);
                }
                totalArray.add(postIn);
            }
        }

        if (filter.equals(SWBSocialResUtil.Util.getStringFromGenericLocale("neutral", lang))) {
            i = neutralsArray.iterator();
        } else if (filter.equals(SWBSocialResUtil.Util.getStringFromGenericLocale("positives", lang))) {
            i = positivesArray.iterator();
        } else if (filter.equals(SWBSocialResUtil.Util.getStringFromGenericLocale("negatives", lang))) {
            i = negativesArray.iterator();
        } else {
            i = totalArray.iterator();
        }

        return i;
    }

    private Iterator getSocialNetwork(String suri, String lang, String filterGeneral, String filter) {

        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        int neutrals = 0, positives = 0, negatives = 0;

        ArrayList positivesArray = new ArrayList();
        ArrayList negativesArray = new ArrayList();
        ArrayList neutralsArray = new ArrayList();
        ArrayList totalArray = new ArrayList();
        ArrayList networkArray = new ArrayList();
        ArrayList totalNetworkArray = new ArrayList();
        Iterator i = null;

        Iterator<PostIn> itObjPostIns = null;
        if (semObj.getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) semObj.getGenericInstance();
            itObjPostIns = stream.listPostInStreamInvs();
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
            itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        }
        while (itObjPostIns.hasNext()) {
            PostIn postIn = itObjPostIns.next();
            if (postIn != null && postIn.getPostInSocialNetwork() != null) {
                if (filterGeneral.equals(postIn.getPostInSocialNetwork().getURI())) {
                    if (postIn.getPostSentimentalType() == 0) {
                        neutrals++;
                        neutralsArray.add(postIn);
                    } else if (postIn.getPostSentimentalType() == 1) {
                        positives++;
                        positivesArray.add(postIn);
                    } else if (postIn.getPostSentimentalType() == 2) {
                        negatives++;
                        negativesArray.add(postIn);
                    }
                    totalNetworkArray.add(postIn);
                } else if (filter.equals(postIn.getPostInSocialNetwork().getId())) {
                    networkArray.add(postIn);
                } else if (filter.equalsIgnoreCase("") && filterGeneral.equalsIgnoreCase("all")) {
                    totalArray.add(postIn);
                }
            }
        }

        if (filter.equals(SWBSocialResUtil.Util.getStringFromGenericLocale("neutral", lang))) {
            i = neutralsArray.iterator();
        } else if (filter.equals(SWBSocialResUtil.Util.getStringFromGenericLocale("positives", lang))) {
            i = positivesArray.iterator();
        } else if (filter.equals(SWBSocialResUtil.Util.getStringFromGenericLocale("negatives", lang))) {
            i = negativesArray.iterator();
        } else if (filter.equalsIgnoreCase("") && filterGeneral.equalsIgnoreCase("all")) {
            i = totalArray.iterator();
        } else if (filter.equals("") && !filterGeneral.equals("all")) {
            i = totalNetworkArray.iterator();
        } else {
            i = networkArray.iterator();
        }

        return i;
    }

    public void createExcel(Iterator<PostIn> setso, SWBParamRequest paramRequest, HttpServletResponse response, String t) {
        try {
            // Defino el Libro de Excel
            // Iterator v = setso.iterator();
            String title = t;

            List list = IteratorUtils.toList(setso);
            Iterator<PostIn> setso1 = list.iterator();
            //  long size = SWBUtils.Collections.sizeOf(list.iterator());
            long limite = 65535;

            Workbook wb = null;
            if (list.size() <= limite) {

                wb = new HSSFWorkbook();
            } else if (list.size() > limite) {

                wb = new XSSFWorkbook();
            }

            // Creo la Hoja en Excel
            Sheet sheet = wb.createSheet("Mensajes " + title);

            sheet.setDisplayGridlines(false);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));

            // creo una nueva fila
            Row trow = sheet.createRow(0);
            createTituloCell(wb, trow, 0, CellStyle.ALIGN_CENTER,
                    CellStyle.VERTICAL_CENTER, "Mensajes " + title);

            // Creo la cabecera de mi listado en Excel
            Row row = sheet.createRow(2);

            // Creo las celdas de mi fila, se puede poner un diseño a la celda
            CellStyle cellStyle = wb.createCellStyle();

            createHead(wb, row, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Mensaje");
            createHead(wb, row, 1, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Tipo");
            createHead(wb, row, 2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Red");
            createHead(wb, row, 3, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Tema");
            createHead(wb, row, 4, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Creación");
            createHead(wb, row, 5, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Sentimiento");
            createHead(wb, row, 6, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Intensidad");
            createHead(wb, row, 7, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Emot");
            createHead(wb, row, 8, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "RT/Likes");
            createHead(wb, row, 9, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Usuario");
            createHead(wb, row, 10, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Seguidores");
            createHead(wb, row, 11, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Amigos");
            //createHead(wb, row, 12, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Klout");
            createHead(wb, row, 12, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Lugar");
            createHead(wb, row, 13, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Prioritario");

            String lang = paramRequest.getUser().getLanguage();

            //Número de filas
            int i = 3;

            while (setso1.hasNext()) {

                PostIn postIn = (PostIn) setso1.next();

                Row troww = sheet.createRow(i);

                if (postIn.getMsg_Text() != null) {
                    if (postIn.getMsg_Text().length() > 2000) {
                        createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, postIn.getMsg_Text().substring(0, 2000));

                    } else {
                        createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, postIn.getMsg_Text());
                    }

                } /*else if (postIn.getDescription() != null) {
                 if (postIn.getDescription().length() > 200) {
                 createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, postIn.getDescription().substring(0, 200));

                 } else {
                 createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, postIn.getDescription());
                 }
                 } */ else if (postIn.getTags() != null) {
                    if (postIn.getTags().length() > 200) {
                        createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, postIn.getTags().substring(0, 200));

                    } else {
                        createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, postIn.getTags());
                    }
                } else {
                    createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER, "---");

                }
                createCell(cellStyle, wb, troww, 1, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn instanceof MessageIn ? SWBSocialResUtil.Util.getStringFromGenericLocale("message", lang) : postIn instanceof PhotoIn ? SWBSocialResUtil.Util.getStringFromGenericLocale("photo", lang) : postIn instanceof VideoIn ? SWBSocialResUtil.Util.getStringFromGenericLocale("video", lang) : "---");
                if (postIn.getPostInSocialNetwork() != null) {
                    createCell(cellStyle, wb, troww, 2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn.getPostInSocialNetwork().getDisplayTitle(lang));
                } else {
                    createCell(cellStyle, wb, troww, 2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "---");
                }

                if (postIn.getSocialTopic() != null) {
                    createCell(cellStyle, wb, troww, 3, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn.getSocialTopic().getDisplayTitle(lang));
                } else {
                    createCell(cellStyle, wb, troww, 3, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "---");
                }
                SimpleDateFormat df = new SimpleDateFormat();
                //createCell(cellStyle, wb, troww, 4, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, SWBUtils.TEXT.getTimeAgo(postIn.getPi_created(), lang));
                createCell(cellStyle, wb, troww, 4, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, df.format(postIn.getPi_createdInSocialNet()));
                String path = "";

                if (postIn.getPostSentimentalType() == 0) {
                    createCell(cellStyle, wb, troww, 5, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "----");
                } else if (postIn.getPostSentimentalType() == 1) {
                    createCell(cellStyle, wb, troww, 5, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Positivo");
                } else if (postIn.getPostSentimentalType() == 2) {
                    createCell(cellStyle, wb, troww, 5, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Negativo");
                }
                createCell(cellStyle, wb, troww, 6, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn.getPostIntesityType() == 0 ? SWBSocialResUtil.Util.getStringFromGenericLocale("low", lang) : postIn.getPostIntesityType() == 1 ? SWBSocialResUtil.Util.getStringFromGenericLocale("medium", lang) : postIn.getPostIntesityType() == 2 ? SWBSocialResUtil.Util.getStringFromGenericLocale("high", lang) : "---");

                if (postIn.getPostSentimentalEmoticonType() == 1) {
                    createCell(cellStyle, wb, troww, 7, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Positivo");

                } else if (postIn.getPostSentimentalEmoticonType() == 2) {
                    createCell(cellStyle, wb, troww, 7, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Negativo");
                } else if (postIn.getPostSentimentalEmoticonType() == 0) {

                    createCell(cellStyle, wb, troww, 7, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "---");
                }
                int postS = postIn.getPostShared();
                String postShared = Integer.toString(postS);
                createCell(cellStyle, wb, troww, 8, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postShared);
                createCell(cellStyle, wb, troww, 9, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn.getPostInSocialNetworkUser() != null ? postIn.getPostInSocialNetworkUser().getSnu_name() : SWBSocialResUtil.Util.getStringFromGenericLocale("withoutUser", lang));
                Serializable foll = postIn.getPostInSocialNetworkUser() != null ? postIn.getPostInSocialNetworkUser().getFollowers() : SWBSocialResUtil.Util.getStringFromGenericLocale("withoutUser", lang);
                createCell(cellStyle, wb, troww, 10, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, foll.toString());
                Serializable amigos = postIn.getPostInSocialNetworkUser() != null ? postIn.getPostInSocialNetworkUser().getFriends() : SWBSocialResUtil.Util.getStringFromGenericLocale("withoutUser", lang);
                createCell(cellStyle, wb, troww, 11, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, amigos.toString());

                Serializable klout = postIn.getPostInSocialNetworkUser() != null ? postIn.getPostInSocialNetworkUser().getSnu_klout() : SWBSocialResUtil.Util.getStringFromGenericLocale("withoutUser", lang);

                //createCell(cellStyle, wb, troww, 12, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, klout.toString());
                createCell(cellStyle, wb, troww, 12, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn.getPostPlace() == null ? "---" : postIn.getPostPlace());
                createCell(cellStyle, wb, troww, 13, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, postIn.isIsPrioritary() ? "SI" : "NO");

                i++;

            }

            // Definimos el tamaño de las celdas, podemos definir un tamaña especifico o hacer que 
            //la celda se acomode según su tamaño
            Sheet ssheet = wb.getSheetAt(0);

            //ssheet.setColumnWidth(0, 256 * 40);
            ssheet.autoSizeColumn(0);
            ssheet.autoSizeColumn(1);
            ssheet.autoSizeColumn(2);
            ssheet.autoSizeColumn(3);
            ssheet.autoSizeColumn(4);
            ssheet.autoSizeColumn(5);
            ssheet.autoSizeColumn(6);
            ssheet.autoSizeColumn(7);
            ssheet.autoSizeColumn(8);
            ssheet.autoSizeColumn(9);
            ssheet.autoSizeColumn(10);
            ssheet.autoSizeColumn(11);
            ssheet.autoSizeColumn(12);
            ssheet.autoSizeColumn(13);
            //ssheet.autoSizeColumn(14);

            OutputStream ou = response.getOutputStream();
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            if (list.size() <= limite) {
                response.setHeader("Content-Disposition", "attachment; filename=\"Mensajes.xls\";");
            } else {
                response.setHeader("Content-Disposition", "attachment; filename=\"Mensajes.xlsx\";");
            }
            response.setContentType("application/octet-stream");
            wb.write(ou);
            ou.close();

        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * Crea un excel con informaci&oacute;n estadistica para las graficas
     * "N&uacute;mero de mensajes por hora del d&iacute;a" y "Mensajes por hora
     * del d&iacute;a por red social".
     *
     * @param map Contiene el titulo del Stream o Red Social como llave y un
     * conjunto de datos del conteo de Post positivos, negativos y neutros
     * clasificados por hora del d&iacute;a.
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @param response Proporciona funcionalidad especifica HTTP para
     * envi&oacute; en la respuesta
     * @param title Representa el titulo de la gr&acute;fica
     * @throws IOException Excepti&oacute;n de IO
     */
    public void createStatisticalExcel(HashMap map, SWBParamRequest paramRequest, HttpServletResponse response, String title) throws IOException {
        String[] feelings = {"Positivos", "Negativos", "Neutros", "Total"};
        String lang = paramRequest.getUser().getLanguage();

        // Defino el Libro de Excel
        long limite = 65535;
        Workbook wb = null;

        if (map.size() <= limite) {
            wb = new HSSFWorkbook();
        } else if (map.size() > limite) {
            wb = new XSSFWorkbook();
        }

        // Creo la Hoja en Excel
        Sheet sheet = wb.createSheet(title);
        sheet.setDisplayGridlines(false);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (4 * map.size())));

        // creo una nueva fila
        //Se crea el nombre de la gráfica a exportar
        Row trow = sheet.createRow(0);
        createTituloCell(wb, trow, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, title);
        int incCelds = 1;
        int incCelds2 = 1;

        Row trow1 = sheet.createRow(2);
        Row trow2 = sheet.createRow(3);

        Row[] rows = new Row[24];
        int iCreateRow = 4;
        for (int i = 0; i < rows.length; i++, iCreateRow++) {
            rows[i] = sheet.createRow(iCreateRow);
        }

        Iterator it = map.entrySet().iterator();
        boolean isFirst = true;
        int columnsDinamic = 1;
        while (it.hasNext()) {
            int iRow = 0;

            Map.Entry e = (Map.Entry) it.next();
            SemanticObject semObj1 = SemanticObject.getSemanticObject(e.getKey().toString());
            String titleDescr = "";
            if (semObj1 != null && semObj1.createGenericInstance() instanceof Descriptiveable) {
                Descriptiveable ele = (Descriptiveable) semObj1.createGenericInstance();
                titleDescr = ele.getDisplayTitle(lang);
            }
            
            //Se crea la fila con el nombre del Stream o Tema
            CellRangeAddress region = new CellRangeAddress(2, 2, incCelds, incCelds + (feelings.length - 1));
            sheet.addMergedRegion(region);
            createTituloCell(wb, trow1, incCelds, CellStyle.ALIGN_CENTER,
                    CellStyle.VERTICAL_CENTER, titleDescr + "");

            // Set the border and border colors.
            final short borderMediumDashed = CellStyle.BORDER_MEDIUM;
            RegionUtil.setBorderBottom(borderMediumDashed, region, sheet, wb);
            RegionUtil.setBorderTop(borderMediumDashed, region, sheet, wb);
            RegionUtil.setBorderLeft(borderMediumDashed, region, sheet, wb);
            RegionUtil.setBorderRight(borderMediumDashed, region, sheet, wb);

            incCelds += (feelings.length); //4
            //Se crea la fila con los textos: Horas del día, Positivos, Negativos, Neutros y Total
            createHead(wb, trow2, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Horas del día");
            for (String strFeelings : feelings) {
                createHead(wb, trow2, incCelds2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, strFeelings);
                incCelds2++;
            }

            CellStyle cellStyle = wb.createCellStyle();
            int dataArrayHelp[][] = (int[][]) e.getValue();

            int columnsDinamicA = columnsDinamic++;
            int columnsDinamicB = columnsDinamic++;
            int columnsDinamicC = columnsDinamic++;
            int columnsDinamicD = columnsDinamic++;

            //Se crean los datos dinámicos
            for (int i = 0; i < dataArrayHelp.length; i++) {
                if (isFirst) {

                    createHoursCell(wb, rows[iRow], 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, i);
                    //Workbook wb, Row row, int column, short halign, short valign, String strContenido
                }
                createIntCell(cellStyle, wb, rows[iRow], columnsDinamicA, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, dataArrayHelp[i][0]);
                createIntCell(cellStyle, wb, rows[iRow], columnsDinamicB, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, dataArrayHelp[i][1]);
                createIntCell(cellStyle, wb, rows[iRow], columnsDinamicC, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, dataArrayHelp[i][2]);
                createIntCell(cellStyle, wb, rows[iRow], columnsDinamicD, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, (dataArrayHelp[i][0]
                        + dataArrayHelp[i][1] + dataArrayHelp[i][2]));
                iRow++;
            }
            isFirst = false;
        }

        // Definimos el tamaño de las celdas, podemos definir un tamaña especifico o hacer que 
        //la celda se acomode según su tamaño
        Sheet ssheet = wb.getSheetAt(0);

        //ssheet.setColumnWidth(0, 256 * 40);
        for (int i = 0; i <= (map.size() * 3); i++) {
            ssheet.autoSizeColumn(i);
        }

        OutputStream ou = response.getOutputStream();
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        if (map.size() <= limite) {
            response.setHeader("Content-Disposition", "attachment; filename=\"Mensajes.xls\";");
        } else {
            response.setHeader("Content-Disposition", "attachment; filename=\"Mensajes.xlsx\";");
        }
        response.setContentType("application/octet-stream");
        wb.write(ou);
        ou.close();
    }

    public void createStatisticalMovilExcel(HashMap map, SWBParamRequest paramRequest, HttpServletResponse response, String title) throws IOException {
        String[] feelings = {"Positivos", "Negativos", "Neutros", "Total"};

        // Defino el Libro de Excel
        long limite = 65535;
        Workbook wb = null;

        if (map.size() <= limite) {
            wb = new HSSFWorkbook();
        } else if (map.size() > limite) {
            wb = new XSSFWorkbook();
        }

        // Creo la Hoja en Excel
        Sheet sheet = wb.createSheet(title);
        sheet.setDisplayGridlines(false);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (4)));// * map.size()

        // creo una nueva fila
        //Se crea el nombre de la gráfica a exportar
        Row trow = sheet.createRow(0);
        createTituloCell(wb, trow, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, title);
        int incCelds2 = 1;

        Row trow1 = sheet.createRow(2);

        createHead(wb, trow1, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Dispositivos móviles");
            for (String strFeelings : feelings) {
                createHead(wb, trow1, incCelds2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, strFeelings);
                incCelds2++;
            }
            

        Iterator it = map.entrySet().iterator();
        int iRow = 3;
        while (it.hasNext()) {
            Row troww = sheet.createRow(iRow);
            Map.Entry e = (Map.Entry) it.next();
            SemanticObject semObj1 = SemanticObject.getSemanticObject(e.getKey().toString());
            String titleDescr = "";
            if (semObj1 != null && semObj1.createGenericInstance() instanceof DevicePlatform) {
                DevicePlatform ele = (DevicePlatform) semObj1.createGenericInstance();
                titleDescr = ele.getId();
            }
            
            CellStyle cellStyle = wb.createCellStyle();
            int dataArrayHelp[] = (int[]) e.getValue();
            
            createCell(cellStyle, wb, troww, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, titleDescr);

            createIntCell(cellStyle, wb, troww, 1, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, dataArrayHelp[1]);
            createIntCell(cellStyle, wb, troww, 2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, dataArrayHelp[2]);
            createIntCell(cellStyle, wb, troww, 3, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, dataArrayHelp[0]);
            createIntCell(cellStyle, wb, troww, 4, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, (dataArrayHelp[0]
                    + dataArrayHelp[1] + dataArrayHelp[2]));
            iRow++;
        }

        // Definimos el tamaño de las celdas, podemos definir un tamaña especifico o hacer que 
        //la celda se acomode según su tamaño
        Sheet ssheet = wb.getSheetAt(0);

        for (int i = 0; i <= 4; i++) {
            ssheet.autoSizeColumn(i);
        }

        OutputStream ou = response.getOutputStream();
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        if (map.size() <= limite) {
            response.setHeader("Content-Disposition", "attachment; filename=\"Mensajes.xls\";");
        } else {
            response.setHeader("Content-Disposition", "attachment; filename=\"Mensajes.xlsx\";");
        }
        response.setContentType("application/octet-stream");
        wb.write(ou);
        ou.close();
    }

    
    /**
     * Crea celdas en un excel que tienen formato de horas.
     *
     * @param wb Libro en excel a partir del cual se crearán las celdas.
     * @param row Fila donde se encuentran las celdas a crear.
     * @param column Columna donde se encuentran las celdas a crear.
     * @param halign Tipo de alineaci&oacute;n horizontal para dar estilo a la
     * celda
     * @param valign Tipo de alineaci&oacute;n vertical para dar estilo a la
     * celda
     * @param strContenido Contenido de la celda.
     */
    public static void createHoursCell(Workbook wb, Row row, int column, short halign, short valign, int strContenido) {
        CellStyle cellStyle = wb.createCellStyle();
        CreationHelper createHelper = wb.getCreationHelper();
        Calendar date = Calendar.getInstance();//00- 12pm
        date.set(Calendar.HOUR, strContenido);
        date.set(Calendar.YEAR, 1970);
        date.set(Calendar.MONTH, 0);
        date.set(Calendar.DATE, 1);
        date.set(Calendar.MINUTE, 00);
        date.set(Calendar.SECOND, 00);
        date.get(Calendar.AM_PM);

        if (strContenido < 12) {
            date.set(Calendar.AM_PM, Calendar.AM);
        } else {
            date.set(Calendar.AM_PM, Calendar.PM);
        }

        TimeZone timeZone = TimeZone.getTimeZone("GMT-6");
        date.setTimeZone(timeZone);

        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("HH:mm"));

        Cell cell = row.createCell(column);

        cell.setCellValue(date);
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setBottomBorderColor((short) 8);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setLeftBorderColor((short) 8);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setRightBorderColor((short) 8);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setTopBorderColor((short) 8);
        cell.setCellStyle(cellStyle);
    }

    /**
     * Crea celdas en un excel que tienen formato de n&uacute;meros entero.
     *
     * @param cellStyle
     * @param wb Libro en excel a partir del cual se crearán las celdas.
     * @param row Fila donde se encuentran las celdas a crear.
     * @param column Columna donde se encuentran las celdas a crear.
     * @param halign Tipo de alineaci&oacute;n horizontal para dar estilo a la
     * celda
     * @param valign Tipo de alineaci&oacute;n vertical para dar estilo a la
     * celda
     * @param strContenido Contenido de la celda.
     */
    public static void createIntCell(CellStyle cellStyle, Workbook wb, Row row, int column, short halign, short valign, double strContenido) {
        Cell cell = row.createCell(column);

        cell.setCellValue(strContenido);
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setBottomBorderColor((short) 8);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setLeftBorderColor((short) 8);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setRightBorderColor((short) 8);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setTopBorderColor((short) 8);
        cell.setCellStyle(cellStyle);
    }

    public static void createTituloCell(Workbook wb, Row row, int column, short halign, short valign, String strContenido) {

        CreationHelper ch = wb.getCreationHelper();
        Cell cell = row.createCell(column);
        cell.setCellValue(ch.createRichTextString(strContenido));

        Font cellFont = wb.createFont();
        cellFont.setFontHeightInPoints((short) 11);
        cellFont.setFontName(HSSFFont.FONT_ARIAL);
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setFont(cellFont);
        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);

    }

    public static void createHead(Workbook wb, Row row, int column, short halign, short valign, String strContenido) {

        CreationHelper ch = wb.getCreationHelper();
        Cell cell = row.createCell(column);
        cell.setCellValue(ch.createRichTextString(strContenido));

        Font cellFont = wb.createFont();
        cellFont.setFontHeightInPoints((short) 11);
        cellFont.setFontName(HSSFFont.FONT_ARIAL);
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setFont(cellFont);
        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setBottomBorderColor((short) 8);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setLeftBorderColor((short) 8);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setRightBorderColor((short) 8);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setTopBorderColor((short) 8);

        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);

    }

    public static void createCell(CellStyle cellStyle, Workbook wb, Row row, int column, short halign, short valign, String strContenido) {

        CreationHelper ch = wb.getCreationHelper();
        Cell cell = row.createCell(column);

        cell.setCellValue(ch.createRichTextString(strContenido));
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setBottomBorderColor((short) 8);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setLeftBorderColor((short) 8);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setRightBorderColor((short) 8);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
        cellStyle.setTopBorderColor((short) 8);
        cell.setCellStyle(cellStyle);

    }

    private Iterator<PostIn> getGraphBar(HttpServletRequest request, String suri, String lang, String filterGeneral, String filter) {
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        ArrayList totalArray = new ArrayList();
        Iterator i = null;
        String selectedAnio = request.getParameter("selectedAnio");
        String selectAnio = request.getParameter("selectAnio");
        String selectMes = request.getParameter("selectMes");
        String selectDay = request.getParameter("selectDay");
        String selectMonth2 = request.getParameter("selectMonth2");

        Iterator<PostIn> itObjPostIns = null;
        if (semObj.getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) semObj.getGenericInstance();
            itObjPostIns = stream.listPostInStreamInvs();
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
            itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        }

        Calendar calendario = Calendar.getInstance();

        String anio = request.getParameter("selectedAnio");
        if (selectedAnio.equals("")) {
            selectedAnio = String.valueOf(calendario.get(Calendar.YEAR));
        }
        Date date; // your date
        Calendar cal = Calendar.getInstance();

        while (itObjPostIns.hasNext()) {
            PostIn postIn = itObjPostIns.next();
            if (postIn != null && postIn.getPostInSocialNetwork() != null) {
                cal.setTime(postIn.getPi_createdInSocialNet());

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DAY_OF_MONTH);

                if (!selectedAnio.equals("") && !selectMes.equals("") && selectDay.equals("")) {
                    if (year == Integer.parseInt(selectedAnio) && month == Integer.parseInt(selectMes)) {
                        totalArray.add(postIn);
                    }
                } else if (!selectedAnio.equals("") && !selectMonth2.equals("") && !selectDay.equals("")) {
                    if (year == Integer.parseInt(selectedAnio) && month == Integer.parseInt(selectMonth2) + 1 && day == Integer.parseInt(selectDay)) {
                        totalArray.add(postIn);
                    }
                }
            }
        }
        i = totalArray.iterator();
        return i;
    }

    /**
     * Obtiene los post en base al a&ntilde;o, o al mes y a&ntilde;o
     * seleccionados
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param suri Representa el objeto a partir del cual se obtendran los Post;
     * ya sea un Stream o un Tema
     * @return Conjunto de Post que cumplen con los requisitos del mes y
     * a&ntilde;o
     */
    private Iterator<PostIn> getGraphBar2(HttpServletRequest request, String suri) {
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        ArrayList totalArray = new ArrayList();
        Iterator i = null;
        String selectedAnio = request.getParameter("selectedAnio");
        String selectAnio = request.getParameter("selectAnio");
        String selectMes = request.getParameter("selectMes");

        Iterator<PostIn> itObjPostIns = null;
        if (semObj.getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) semObj.getGenericInstance();
            itObjPostIns = stream.listPostInStreamInvs();
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
            itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        }

        Calendar calendario = Calendar.getInstance();

        //String anio = request.getParameter("selectedAnio");
        if (selectedAnio.equals("")) {
            selectedAnio = String.valueOf(calendario.get(Calendar.YEAR));
        }
        //Date date; // your date
        Calendar cal = Calendar.getInstance();

        while (itObjPostIns.hasNext()) {
            PostIn postIn = itObjPostIns.next();
            if (postIn != null && postIn.getPostInSocialNetwork() != null) {
                cal.setTime(postIn.getPi_createdInSocialNet());

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;

                if (!selectAnio.equals("") && !selectMes.equals("")) {
                    if (year == Integer.parseInt(selectAnio) && month == Integer.parseInt(selectMes)) {
                        totalArray.add(postIn);
                    }
                } else if (!selectedAnio.equals("")) {
                    if (year == Integer.parseInt(selectedAnio)) {
                        totalArray.add(postIn);
                    }
                }
            }
        }
        i = totalArray.iterator();
        return i;
    }

    private Iterator<PostIn> getGraphBarByHour(HttpServletRequest request) {
        String suri = request.getParameter("suri");
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        ArrayList tmpArray = new ArrayList();
        ArrayList finalArray = new ArrayList();
        Iterator it = null;

        String selectedYear = request.getParameter("selectedYear") == null ? "" : request.getParameter("selectedYear");
        String selectedMonth = request.getParameter("selectedMonth") == null ? "" : request.getParameter("selectedMonth");
        String selectedDay = request.getParameter("selectedDay") == null ? "" : request.getParameter("selectedDay");
        String selectedHourTmp = request.getParameter("selectedHour") == null ? "" : request.getParameter("selectedHour");
        ////System.out.println("SELECTED HOUR:" + selectedHourTmp);
        int selectedHour = Integer.parseInt(selectedHourTmp);
        String fullDate = "";

        fullDate += selectedYear + "-" + (selectedMonth.length() == 1 ? "0" + selectedMonth : selectedMonth)
                + "-" + (selectedDay.length() == 1 ? "0" + selectedDay : selectedDay);

        if (semObj.getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) semObj.getGenericInstance();
            tmpArray = getPostInByStreamAndDay(stream, fullDate);
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
            tmpArray = getPostInBySocialTopicAndDay(socialTopic, fullDate);
        }

        for (int i = 0; i < tmpArray.size(); i++) {
            SemanticObject sobj = (SemanticObject) tmpArray.get(i);
            PostIn postIn = (PostIn) sobj.createGenericInstance();
            Calendar calendario = GregorianCalendar.getInstance();
            calendario.setTime(postIn.getPi_createdInSocialNet());
            int hourOfDay = calendario.get(Calendar.HOUR_OF_DAY);

            if (hourOfDay == selectedHour) {
                finalArray.add(postIn);
            }
        }
        it = finalArray.iterator();
        return it;
    }

    /**
     *
     * @param stream
     * @param a date in the format yyyy-mm-dd
     * @return the posts created some day.
     */
    public static ArrayList getPostInByStreamAndDay(org.semanticwb.social.Stream stream, String date) {
        ////System.out.println("entrando por los datos!");
        if (date == null || date.isEmpty()) {
            return null;
        }
        String query
                = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX social: <http://www.semanticwebbuilder.org/swb4/social#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "\n";

        query += "select ?semObj" + "\n";
        query
                += "where {\n"
                + " ?semObj social:postInStream <" + stream.getURI() + ">. \n"
                + " ?semObj social:pi_createdInSocialNet ?postInCreated. \n"
                + " FILTER regex(?postInCreated, \"" + date + "\", \"i\") \n"
                + "  }\n";

        WebSite wsite = WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        return SWBSocial.executeQueryArraySemObj(query, wsite);
    }

    /**
     *
     * @param socialTopic
     * @param a date in the format yyyy-mm-dd
     * @return the posts created some day.
     */
    public static ArrayList getPostInBySocialTopicAndDay(org.semanticwb.social.SocialTopic socialTopic, String date) {
        ////System.out.println("entrando por los datos!");
        if (date == null || date.isEmpty()) {
            return null;
        }
        String query
                = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX social: <http://www.semanticwebbuilder.org/swb4/social#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "\n";

        query += "select ?semObj" + "\n";
        query
                += "where {\n"
                + " ?semObj social:socialTopic <" + socialTopic.getURI() + ">. \n"
                + " ?semObj social:pi_createdInSocialNet ?postInCreated. \n"
                + " FILTER regex(?postInCreated, \"" + date + "\", \"i\") \n"
                + "  }\n";

        WebSite wsite = WebSite.ClassMgr.getWebSite(socialTopic.getSemanticObject().getModel().getName());
        return SWBSocial.executeQueryArraySemObj(query, wsite);
    }

    /**
     * Se encarga de filtrar los datos de la gr&aacute;fica de "Usuarios por
     * Interacci&oacute;n" por Red Social.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param response Proporciona funcionalidad especifica HTTP para
     * envi&oacute; en la respuesta
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @throws SWBResourceException SWBResourceException Excepti&oacute;n
     * utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    public void doShowGraphTopUser(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String suri = request.getParameter("suri") == null ? "" : request.getParameter("suri");
        SemanticObject semObj = SemanticObject.createSemanticObject(suri);
        String clsName = semObj.createGenericInstance().getClass().getName();
        String clsName2 = semObj.createGenericInstance().getClass().getSimpleName();
        String networkSocial = request.getParameter("networkSocial") == null ? "" : request.getParameter("networkSocial");
        String sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName);
        String toDateAnalysis = request.getParameter("toDateAnalysis" + clsName);
        out.println("<iframe  id=\"" + suri + "byUser\" src=\"/work/models/SWBAdmin/jsp/stream/topUserChart.jsp?suri=" + URLEncoder.encode(suri) + "&url=" + paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(PieChart.MODE_TopUser) + "&networkSocial=" + URLEncoder.encode(networkSocial) + ""
                + "&sinceDateAnalysis" + clsName2 + "=" + sinceDateAnalysis + "&toDateAnalysis" + clsName2 + "=" + toDateAnalysis + "&urlExport=" + paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("exportExcel") + "\"  frameborder=\"0\" width=\"100%\"   height=\"500\"  scrolling=\"no\"></iframe>"); //frameborder=\"0\" style=\"overflow:hidden;overflow-x:h
    }

    /**
     * Modo que se encarga de la generaci&oacute;n de un reporte con datos
     * estadisticos para las gr&aacute;ficas de N&uacute;mero de mensajes por
     * hora del d&iacute;a y Mensajes por hora del d&iacute;a por Red Social.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param response Proporciona funcionalidad especifica HTTP para
     * envi&oacute; en la respuesta
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @throws SWBResourceException SWBResourceException Excepti&oacute;n
     * utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    public void doGenerateReportSpecificData(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {
        //HashMap hmapResult = filtros(swbSocialUser, webSite, searchWord, request, stream, page);
        String suri = request.getParameter("suri");
        String title_elem = "";

        String type = request.getParameter("type");
        Iterator<PostIn> itObjPostIns = null;
        SemanticObject semObj = SemanticObject.createSemanticObject(suri);
        String clsName = semObj.createGenericInstance().getClass().getSimpleName();
        //HashMap<SocialNetwork, Integer> networks = new HashMap<SocialNetwork, Integer>();
        String sinceDateAnalysis = null;
        String toDateAnalysis = null;

        if (clsName != null) {
            sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName);
            toDateAnalysis = request.getParameter("toDateAnalysis" + clsName);
        }

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sinDateAnalysis = null;
        Date tDateAnalysis = null;
        if (sinceDateAnalysis != null && toDateAnalysis != null) {
            try {
                sinDateAnalysis = formatDate.parse(sinceDateAnalysis);
            } catch (java.text.ParseException e) {
            }
            try {
                toDateAnalysis += " 23:59:59";
                tDateAnalysis = formatTo.parse(toDateAnalysis);
            } catch (java.text.ParseException e) {
            }
        }
        Stream stream = null;
        SocialTopic socialTopic = null;
        
        if (semObj.getGenericInstance() instanceof Stream) {
            stream = (Stream) semObj.getGenericInstance();
            itObjPostIns = stream.listPostInStreamInvs();
            title_elem = stream.getURI();//Title() + "_" + stream.getId();
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            socialTopic = (SocialTopic) semObj.getGenericInstance();
            itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
            title_elem = socialTopic.getURI();//Title() + "_" + socialTopic.getId();
        }
        
        if (sinDateAnalysis != null && tDateAnalysis != null) {
            itObjPostIns = SWBSocialResUtil.Util.getFilterDates(itObjPostIns, sinDateAnalysis, tDateAnalysis);
        }
            
        HashMap map = new HashMap();
        if ("graphChartByHour".equals(type)) {
            /*if (semObj.getGenericInstance() instanceof Stream) {
                Stream stream = (Stream) semObj.getGenericInstance();
                itObjPostIns = stream.listPostInStreamInvs();
                title_elem = stream.getURI();//Title() + "_" + stream.getId();
            } else if (semObj.getGenericInstance() instanceof SocialTopic) {
                SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
                itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
                title_elem = socialTopic.getURI();//Title() + "_" + socialTopic.getId();
            }*/
//            if (sinDateAnalysis != null && tDateAnalysis != null) {
//                itObjPostIns = SWBSocialResUtil.Util.getFilterDates(itObjPostIns, sinDateAnalysis, tDateAnalysis);
//            }
            

            java.util.Date date = null;
            Calendar calendario = Calendar.getInstance();
            int dataArray[][] = new int[24][3];//positive, negative, neutrals
            //int totalPosts = 0;
            if (itObjPostIns != null) {
                while (itObjPostIns.hasNext()) {
                    PostIn postIn = itObjPostIns.next();
                    if (postIn.getPi_createdInSocialNet() != null) {
                        date = postIn.getPi_createdInSocialNet();
                    }

                    if (date != null) {
                        calendario.setTime(date);
                    } else {
                        continue;
                    }

                    int hourOfDay = calendario.get(Calendar.HOUR_OF_DAY);
                    if (postIn.getPostSentimentalType() == 0) {//neutrals
                        dataArray[hourOfDay][2]++;
                    } else if (postIn.getPostSentimentalType() == 1) {//positives
                        dataArray[hourOfDay][0]++;
                    } else if (postIn.getPostSentimentalType() == 2) {//negatives
                        dataArray[hourOfDay][1]++;
                    }
                    //totalPosts++;
                }
            }
            //dataArray[24][0] = totalPosts;
            map.put(title_elem, dataArray);
            createStatisticalExcel(map, paramRequest, response, "NÚMERO DE MENSAJES POR HORA DEL DÍA");
        } else if("graphChartByHourByNet".equals(type)) {
            if (stream != null) {
//                Stream stream = (Stream) semObj.getGenericInstance();
//                itObjPostIns = stream.listPostInStreamInvs();
                ArrayList nets = SWBSocialUtil.sparql.getStreamSocialNetworks(stream);
                for (Object net : nets) {
                    SocialNetwork snet = (SocialNetwork) ((SemanticObject) net).createGenericInstance();
                    map.put(snet, new int[24][3]);
                }
            } else if (socialTopic != null) {
//                SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
                ArrayList nets = SWBSocialUtil.sparql.getSocialTopicSocialNetworks(socialTopic);
                for (Object net : nets) {
                    SocialNetwork snet = (SocialNetwork) ((SemanticObject) net).createGenericInstance();
                    map.put(snet, new int[24][3]);
                }
//                itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
            }

//            if (sinDateAnalysis != null && tDateAnalysis != null) {
//                itObjPostIns = SWBSocialResUtil.Util.getFilterDates(itObjPostIns, sinDateAnalysis, tDateAnalysis);
//            }
            
            Date date = null;
            Calendar calendario = Calendar.getInstance();

            //int totalPosts = 0;
            while (itObjPostIns.hasNext()) {
                PostIn postIn = itObjPostIns.next();

                if (postIn.getPi_createdInSocialNet() != null) {
                    date = postIn.getPi_createdInSocialNet();
                }

                if (date != null) {
                    calendario.setTime(date);
                } else {
                    continue;
                }

                int dataArrayHelp[][] = (int[][]) map.get(postIn.getPostInSocialNetwork());

                int hourOfDay = calendario.get(Calendar.HOUR_OF_DAY);
                if (postIn.getPostSentimentalType() == 0) {//neutrals
                    dataArrayHelp[hourOfDay][2]++;
                } else if (postIn.getPostSentimentalType() == 1) {//positives
                    dataArrayHelp[hourOfDay][0]++;
                } else if (postIn.getPostSentimentalType() == 2) {//negatives
                    dataArrayHelp[hourOfDay][1]++;
                }
                //totalPosts++;
            }
            createStatisticalExcel(map, paramRequest, response, "NÚMERO DE MENSAJES POR HORA DEL DÍA");
        } else if("graphDevicePlatform".equals(type)) { 
            LinkedHashMap<DevicePlatform, int[]> lhm = new LinkedHashMap<DevicePlatform, int[]>();

//            if (semObj.getGenericInstance() instanceof Stream) {
//                Stream stream = (Stream) semObj.getGenericInstance();
//                title = stream.getTitle();
//                itObjPostIns = stream.listPostInStreamInvs();
//            } else if (semObj.getGenericInstance() instanceof SocialTopic) {
//                SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
//                title = socialTopic.getTitle();
//                itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
////            }
//            if (sinDateAnalysis != null && tDateAnalysis != null) {
//                itObjPostIns = SWBSocialResUtil.Util.getFilterDates(itObjPostIns, sinDateAnalysis, tDateAnalysis);
//            } 
            Iterator<DevicePlatform> dps = DevicePlatform.ClassMgr.listDevicePlatforms(SWBContext.getGlobalWebSite());
            while (dps.hasNext()) {
                DevicePlatform dp = dps.next();
                lhm.put(dp, new int[3]);
            }
            while (itObjPostIns.hasNext()) {
                PostIn postIn = itObjPostIns.next();
                DevicePlatform pInDP = postIn.getPostInDevicePlatform();
                if (pInDP != null) {
                    if (lhm.containsKey(pInDP)) {
                        int[] tmp = lhm.get(pInDP);//0Neutrals, 1positives, 2negatives
                        if (postIn.getPostSentimentalType() >= 0 && postIn.getPostSentimentalType() <= 2) {
                            tmp[postIn.getPostSentimentalType()]++;
                        }
                        lhm.put(pInDP, tmp);
                    }
                }
            }
            createStatisticalMovilExcel(lhm, paramRequest, response, "MENSAJES POR PLATAFORMA MÓVIL");

        }
        
    }

    /**
     * Obtiene los post para generar el reporte en excel de la gr&aacute;fica de
     * Usuarios con m&aacute;s interacci&oacute;n
     * 
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param semObj
     * @return Conjunto de Post que cumplen con los requisitos para la gr&aacute;fica
     * Usuarios con m&aacute;s interacci&oacute;n
     */
    private Iterator getGraphChartTopUser(HttpServletRequest request, SemanticObject semObj) {
        ArrayList listPost = new ArrayList();
        SocialTopic st = null;
        String clsName = semObj.createGenericInstance().getClass().getName();
        String clsName2 = semObj.createGenericInstance().getClass().getSimpleName();
        String ids = request.getParameter("idUsrs");
        String networkSocial = request.getParameter("networkSocial");
        String wsString = request.getParameter("ws");
        SocialSite ws = SocialSite.ClassMgr.getSocialSite(wsString);
        SemanticObject rdNetworkSocial = SemanticObject.getSemanticObject(networkSocial);
        boolean isSocialTopic = false;
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName);

        if (sinceDateAnalysis == null) {
            sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName2);
        }
        String toDateAnalysis = request.getParameter("toDateAnalysis" + clsName);
        if (toDateAnalysis == null) {
            toDateAnalysis = request.getParameter("toDateAnalysis" + clsName2);
        }
        Date sinDateAnalysis = null;
        Date tDateAnalysis = null;
        if (sinceDateAnalysis != null && toDateAnalysis != null) {
            try {
                sinDateAnalysis = formatDate.parse(sinceDateAnalysis);
            } catch (java.text.ParseException e) {
            }
            try {
                toDateAnalysis += " 23:59:59";
                tDateAnalysis = formatTo.parse(toDateAnalysis);
            } catch (java.text.ParseException e) {
            }
        }
        if (semObj.getGenericInstance() instanceof SocialTopic) {
            isSocialTopic = true;
            st = (SocialTopic) semObj.getGenericInstance();
        }

        String[] idUsr = ids.split(",");
        for (String idUsr1 : idUsr) {
            if (!idUsr1.equals("")) {
                SocialNetworkUser snetu = SocialNetworkUser.ClassMgr.getSocialNetworkUser(idUsr1, ws);//getSocialNetworkUserbyIDAndSocialNet(idSN[0], socNet, ws);
                if (snetu != null) {
                    Iterator posts = snetu.listPostInInvs();//Lists user posts 
                    if (sinDateAnalysis != null && tDateAnalysis != null) {
                        posts = SWBSocialResUtil.Util.getFilterDates(posts, sinDateAnalysis, tDateAnalysis);
                    }

                    while (posts.hasNext()) {
                        PostIn postIn = (PostIn) posts.next();
                        boolean isCount = false;
                        if ((rdNetworkSocial == null || rdNetworkSocial.equals(""))
                                || (rdNetworkSocial != null && rdNetworkSocial.equals(postIn.getPostInSocialNetwork()))) {
                            isCount = true;
                        }
                        if (isCount) {
                            if (isSocialTopic) {
                                if (postIn.getSocialTopic() == null) {
                                    continue;
                                }
                                if (!postIn.getSocialTopic().equals(st)) {
                                    continue;
                                }
                            }
                            //adds 1 depending what is the post sentiment
                            if (postIn.getPostSentimentalType() >= 0 && postIn.getPostSentimentalType() <= 2) {
                                listPost.add(postIn);
                            }
                        }
                    }
                }
            }
        }

        return listPost.iterator();
    }
}
