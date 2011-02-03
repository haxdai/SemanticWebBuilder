/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericResource;
import javax.xml.transform.Templates;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 *
 * @author jose.jimenez
 */
public class BookingEngine extends GenericResource {


    private static Templates xsltBestday = null;
    Templates xsltExpedia = null;
    private static String htmlBestday_es = null;
    private static String htmlBestday_pt = null;
    private static String htmlTravelocity_en = null;
    private static String htmlTravelocity_es = null;
    private static String htmlTravelocity_fr = null;
    private static String htmlTravelocity_de = null;
    private static String htmlTravelocity_it = null;
    private static Logger log = SWBUtils.getLogger(BookingEngine.class);


    public BookingEngine() {

    }

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {

        super.setResourceBase(base);
        try {
            if (BookingEngine.xsltBestday == null) {
                BookingEngine.xsltBestday = SWBUtils.XML.loadTemplateXSLT(SWBUtils.IO.getStreamFromString(
                        SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId()
                        + "/css/images/bookengine/BestDay_es.xsl")));
            }
//            if (BookingEngine.htmlBestday_es == null) {
//                BookingEngine.htmlBestday_es = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
//                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/BestDay_es.html");
//            }
            if (BookingEngine.htmlBestday_pt == null) {
                BookingEngine.htmlBestday_pt = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/BestDay_pt.html");
            }
        } catch (Exception e) {
            BookingEngine.log.error("Error while getting BestDay's template.", e);
        }
        try {
            if (BookingEngine.htmlTravelocity_en == null) {
                BookingEngine.htmlTravelocity_en = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/Travelocity_en.html");
            }
            if (BookingEngine.htmlTravelocity_es == null) {
                BookingEngine.htmlTravelocity_es = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/Travelocity_es.html");
            }
            if (BookingEngine.htmlTravelocity_fr == null) {
                BookingEngine.htmlTravelocity_fr = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/Travelocity_fr.html");
            }
        } catch (Exception e) {
            BookingEngine.log.error("Error while getting Travelocity's template.", e);
        }

        try {
            xsltExpedia = SWBUtils.XML.loadTemplateXSLT(SWBUtils.IO.getStreamFromString(
                    SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                    + "/models/" + base.getWebSiteId()
                    + "/css/images/bookengine/Expidia_es.xsl")));
        } catch (Exception e) {
            BookingEngine.log.error("Error while getting Expedia's template.", e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String language = null;
        String userLanguage = null;
        String browserLanguage = null;
        int userPais = 0;
        Enumeration<Locale> locales = request.getLocales();
        User user = paramRequest.getUser();

        if (locales.hasMoreElements()) {
            Locale loc = locales.nextElement();
            browserLanguage = loc.getLanguage();
        }

        //Se obtienen los valores del Lenguaje y del País
        userLanguage = user.getLanguage() != null ? user.getLanguage() : "es";
        try {
            if (user != null && user.getCountry() != null) {
                //userPais = Integer.parseInt(user.getCountry().getId());
            } else {
                userPais = 0;
            }
        } catch (NumberFormatException nfe) {
            userPais = 0;
        }
        /*
         * 6-Argentina, 10-Brasil, 13-Chile, 44-Mexico, 65-Centro America, 66-Sudamerica ---> BestDay
         * 12-Canada-en --> Travelocity en,
         * 12-Canada-fr --> Travelocity fr,
         * 25-Estados Unidos-en Travelocity en,
         * 25-Estados Unidos-es Travelocity es
         */

        //Se determina la interfaz a mostrar en base a los valores conocidos de lenguaje y país
        switch (userPais) {
            case 0:
                 if (browserLanguage.equalsIgnoreCase("es")) {
                     doViewBestDay(request, response, paramRequest);
                 } else {
                     doViewTravelocity(request, response, paramRequest);
                 }
                 break;
            case 6:
            case 10:
            case 13:
            case 44:
            case 65:
            case 66:
                doViewBestDay(request, response, paramRequest);
                break;
            case 12://canada
            case 25://estados unidos
           // case 24://España
           // case 3: // alemania
           // case 29:// francia
           //  case 38:// Italia
           // case 51:// Reino Unido
                 doViewTravelocity(request, response, paramRequest);
                break;
            default:
                doViewExpidia(request, response, paramRequest);
                break;

        }
    }

    public void doViewBestDay(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Element elem_parameters = null;
        Element elem_parameter = null;

        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String userLanguage = null;
        int userPais = 0;
        //String xsl = "/BookEngineXslt/BestDay_es.xsl";

        //Obtenemos los valores del languaje y del país
        userLanguage = user.getLanguage() != null ? user.getLanguage() : "es";
        try {
            if (user != null && user.getCountry() != null) {
                //userPais = Integer.parseInt(user.getCountry().getId());
            } else {
                userPais = 44;
            }
        } catch (NumberFormatException nfe) {
            userPais = 44;
        }

        try {
            if (userLanguage.equals("es")) {
                Document doc = SWBUtils.XML.getNewDocument();
                elem_parameters = doc.createElement("parameters");
                doc.appendChild(elem_parameters);
                elem_parameter = getElement(doc, "idm", userLanguage);
                elem_parameters.appendChild(elem_parameter);
                elem_parameter = getElement(doc, "Pais", "" + userPais);
                elem_parameters.appendChild(elem_parameter);

    //            out.println(new GenerateHtml().getHtml(doc, xsl));   //todo descomentar este si es generico y comentar el siguiente
                out.println(SWBUtils.XML.transformDom(BookingEngine.xsltBestday, doc));
//                out.println(BookingEngine.htmlBestday_es);//Ingles, paises que lo manejen
            } else if (userLanguage.equals("pt")) {//Portugés
                out.println(BookingEngine.htmlBestday_pt);
            }
        } catch (Exception e) {
            BookingEngine.log.error("Error while generating Best Day's view", e);
        }
    }

    public void doViewTravelocity(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String userLanguage = null;

        //String fileJsp = null;
        //boolean useXslt = false;


        userLanguage = user.getLanguage() != null ? user.getLanguage() : "es";

        try {
  /*        // todo descomentar esto y comentar el resto para hacerlo generico
            if (useXslt) {
                String xsl = "/BookEngineXslt/Travelocity_" + userLanguage + ".xsl";
                Document doc = AFUtils.getInstance().getNewDocument();
                out.println(new GenerateHtml().getHtml(doc, xsl));  //todo
            } else {
                fileJsp = "/work/BookEngineXslt/Travelocity_" + userLanguage + ".html";

                RequestDispatcher rd = request.getRequestDispatcher(fileJsp);
                rd.include(request, response);
            }
*//**Modifico  Javier Tinoco Diaz para presentar italiano y aleman
   *
 */
            if (userLanguage.equals("en")) {
                out.println(BookingEngine.htmlTravelocity_en);//Ingles, paises que lo manejen
            } else if (userLanguage.equals("fr")) {//Frances
                out.println(BookingEngine.htmlTravelocity_fr);
            } else if (userLanguage.equals("es")) {//Español, paises que lo manejen
                out.println(BookingEngine.htmlTravelocity_es);
            }/*else if(userLanguage.equals("it")){//Italiano
                out.println(htmlTravelocity_it);
            }else if(userLanguage.equals("de")){
                out.println(htmlTravelocity_de); //aleman
            }*/

        } catch (Exception e) {
            BookingEngine.log.error("Error while generating Travelocity's form.", e);
        }
    }

    public void doViewExpidia(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        //User user = paramRequest.getUser();

        try {
            Document doc = SWBUtils.XML.getNewDocument();
            out.println(SWBUtils.XML.transformDom(xsltExpedia, doc));
        } catch (Exception e) {
            BookingEngine.log.error("Error while generating Expedia's form.", e);
        }
    }

    public Element getElement(Document doc, String name, String value) {
        Element element = null;
        Text text = null;
        try {
            element = doc.createElement(name);
            text = doc.createTextNode(value);
            element.appendChild(text);
        } catch (DOMException dome) {
            BookingEngine.log.error("Error while creating DOM element for view.", dome);
        }
        return element;
    }

}
