/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;


import java.io.IOException;
import java.io.PrintWriter;
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
 * Muestra, dependiendo de los valores del pais e idioma del usuario, las 
 * interfaces de las cajas de reservaciones para BestDay y Travelocity.
 * @author jose.jimenez
 */
public class BookingEngine extends GenericResource {


    /**
     * Contiene la plantilla de transformaci&oacute;n de BestDay
     */
    private static Templates xsltBestday = null;

    /**
     * Contiene la plantilla de transformaci&oacute;n de Travelocity
     */
    Templates xsltExpedia = null;

    /**
     * Contiene el c&oacute;digo HTML de la caja de reservaciones de BestDay en Espa&ntilde;ol
     */
    private static String htmlBestday_es = null;

    /**
     * Contiene el c&oacute;digo HTML de la caja de reservaciones de BestDay en Portugu&eacute;s
     */
    private static String htmlBestday_pt = null;

    /**
     * Contiene el c&oacute;digo HTML de la caja de reservaciones de Travelocity en Ingl&eacute;s
     */
    private static String htmlTravelocity_en = null;

    /**
     * Contiene el c&oacute;digo HTML de la caja de reservaciones de Travelocity en Espa&ntilde;ol
     */
    private static String htmlTravelocity_es = null;

    /**
     * Contiene el c&oacute;digo HTML de la caja de reservaciones de Travelocity en Franc&eacute;s
     */
    private static String htmlTravelocity_fr = null;

    /**
     * Contiene el identificador del pa&iacute;s utilizado por defecto
     */
    private static String defaultContry = "mx";

    /**
     * Contiene el identificador del idioma utilizado por defecto
     */
    private static String defaultLanguage = "es";

    /**
     * Referencia al objeto que realiza operaciones de escritura en la bit&aacute;cora configurada
     */
    private static Logger log = SWBUtils.getLogger(BookingEngine.class);


    public BookingEngine() {

    }

    /**
     * Fija los valores de configuraci&oacute;n de la instancia de este recurso
     * @param base instancia base del recurso
     * @throws SWBResourceException Generada si ocurre alg&uacute;n problema con la
     *         asignación del recurso base
     */
    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {

        super.setResourceBase(base);
        try {
//            if (BookingEngine.xsltBestday == null) {
//                BookingEngine.xsltBestday = SWBUtils.XML.loadTemplateXSLT(SWBUtils.IO.getStreamFromString(
//                        SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
//                        + "/models/" + base.getWebSiteId()
//                        + "/css/images/bookengine/BestDay_es.xsl")));
                BookingEngine.htmlBestday_es = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/BestDay_es.html");
//            }
//            if (BookingEngine.htmlBestday_es == null) {
//                BookingEngine.htmlBestday_es = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
//                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/BestDay_es.html");
//            }
//            if (BookingEngine.htmlBestday_pt == null) {
                BookingEngine.htmlBestday_pt = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/BestDay_pt.html");
//            }
        } catch (Exception e) {
            BookingEngine.log.error("Error while getting BestDay's template.", e);
        }
        try {
//            if (BookingEngine.htmlTravelocity_en == null) {
                BookingEngine.htmlTravelocity_en = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/Travelocity_en.html");
//            }
//            if (BookingEngine.htmlTravelocity_es == null) {
                BookingEngine.htmlTravelocity_es = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/Travelocity_es.html");
//            }
//            if (BookingEngine.htmlTravelocity_fr == null) {
                BookingEngine.htmlTravelocity_fr = SWBUtils.IO.getFileFromPath(SWBPortal.getWorkPath()
                        + "/models/" + base.getWebSiteId() + "/css/images/bookengine/Travelocity_fr.html");
//            }
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

    /**
     * En base a los valores del idioma y pa&iacute;s asignados al usuario, determina
     * si muestra la interfaz de BestDay (Argentina, Brasil, Chile, M&eacute;xico,
     * Centro Am&eacute;rica y Sudam&eacute;rica) o de Travelocity (Estados Unidos
     * o Canad&aacute;).
     * @param request la petici&oacute;n HTTP a atender
     * @param response la respuesta HTTP a devolver
     * @param paramRequest valores y objetos asociados a la petici&oacute;n HTTP
     * @throws SWBResourceException generada si hay alg&uacute;n problema durante
     *         la atenci&oacute;n a la petici&oacute;n
     * @throws IOException generada si hay alg&uacute;n problema de I/O durante
     *         la atenci&oacute;n a la petici&oacute;n
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String userCountry = null;
        User user = paramRequest.getUser();

        //Se obtiene el valor del País
        try {
            if (user != null && user.getCountry() != null) {
                userCountry = user.getCountry();
            } else {
                userCountry = BookingEngine.defaultContry;
            }
        } catch (Exception e) {
            userCountry = BookingEngine.defaultContry;
        }

        /*
         * ar-Argentina, br-Brasil, cl-Chile, mx-Mexico, a2-Centro America, a3-Sudamerica ---> BestDay
         * ca-Canada-en --> Travelocity en,
         * ca-Canada-fr --> Travelocity fr,
         * us-Estados Unidos-en Travelocity en,
         * us-Estados Unidos-es Travelocity es
         */

        //Se determina la interfaz a mostrar en base al país
        if (userCountry.equalsIgnoreCase("ca") || userCountry.equalsIgnoreCase("us")) {
            doViewTravelocity(request, response, paramRequest);
        } else if (userCountry.equalsIgnoreCase("ar") || userCountry.equalsIgnoreCase("br") ||
                userCountry.equalsIgnoreCase("cl") || userCountry.equalsIgnoreCase("mx") ||
                userCountry.equalsIgnoreCase("a2") || userCountry.equalsIgnoreCase("a3")) {
            doViewBestDay(request, response, paramRequest);
        }
    }

    /**
     * Muestra la caja de reservaciones de BestDay de acuerdo al idioma del usuario.
     * @param request la petici&oacute;n HTTP a atender
     * @param response la respuesta HTTP a devolver
     * @param paramRequest valores y objetos asociados a la petici&oacute;n HTTP
     * @throws SWBResourceException generada si hay alg&uacute;n problema durante
     *         la atenci&oacute;n a la petici&oacute;n
     * @throws IOException generada si hay alg&uacute;n problema de I/O durante
     *         la atenci&oacute;n a la petici&oacute;n
     */
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
        String userCountry = null;
        int countryCode = 0;

        //Obtenemos los valores del languaje y del país
        userLanguage = user.getLanguage() != null
                     ? user.getLanguage()
                     : BookingEngine.defaultLanguage;
        try {
            if (user != null && user.getCountry() != null) {
                userCountry = user.getCountry();
            } else {
                userCountry = BookingEngine.defaultContry;
            }
        } catch (Exception e) {
            userCountry = BookingEngine.defaultContry;
        }

        /*
         * ar-Argentina, br-Brasil, cl-Chile, mx-Mexico, a2-Centro America, a3-Sudamerica ---> BestDay
         */
        //Se obtiene la equivalencia con las claves de paises usadas anteriormente
        if (userCountry.equalsIgnoreCase("ar")) {
            countryCode = 6;
        } else if (userCountry.equalsIgnoreCase("br")) {
            countryCode = 10;
        } else if (userCountry.equalsIgnoreCase("cl")) {
            countryCode = 13;
        } else if (userCountry.equalsIgnoreCase("mx")) {
            countryCode = 44;
        } else if (userCountry.equalsIgnoreCase("a2")) {
            countryCode = 65;
        } else if (userCountry.equalsIgnoreCase("a3")) {
            countryCode = 66;
        }

        try {
            if (userLanguage.equalsIgnoreCase(BookingEngine.defaultLanguage)) {
//                Document doc = SWBUtils.XML.getNewDocument();
//                elem_parameters = doc.createElement("parameters");
//                doc.appendChild(elem_parameters);
//                elem_parameter = getElement(doc, "idm", userLanguage);
//                elem_parameters.appendChild(elem_parameter);
//                elem_parameter = getElement(doc, "Pais", "" + countryCode);
//                elem_parameters.appendChild(elem_parameter);
//            out.println(new GenerateHtml().getHtml(doc, xsl));   //todo descomentar este si es generico y comentar el siguiente
//                out.println(SWBUtils.XML.transformDom(BookingEngine.xsltBestday, doc));
                out.println(BookingEngine.htmlBestday_es);//Ingles, paises que lo manejen
            } else if (userLanguage.equals("pt")) {//Portugés
                out.println(BookingEngine.htmlBestday_pt);
            }
        } catch (Exception e) {
            BookingEngine.log.error("Error while generating Best Day's view", e);
        }
    }

    /**
     * Muestra la caja de reservaciones de Travelocity, de acuerdo al pa&iacute;s
     * y al idioma del usuario. Estados Unidos (Ingl&eacute;s o Espa&ntilde;ol) o
     * Canad&aacute; (Ingl&eacute;s o Franc&eacute;s).
     * @param request la petici&oacute;n HTTP a atender
     * @param response la respuesta HTTP a devolver
     * @param paramRequest valores y objetos asociados a la petici&oacute;n HTTP
     * @throws SWBResourceException generada si hay alg&uacute;n problema durante
     *         la atenci&oacute;n a la petici&oacute;n
     * @throws IOException generada si hay alg&uacute;n problema de I/O durante
     *         la atenci&oacute;n a la petici&oacute;n
     */
    public void doViewTravelocity(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String userLanguage = null;
        String userCountry = null;

        //Obtenemos los valores del languaje y del país
        userLanguage = user.getLanguage() != null
                     ? user.getLanguage()
                     : BookingEngine.defaultLanguage;
        try {
            if (user != null && user.getCountry() != null) {
                userCountry = user.getCountry();
            } else {
                userCountry = BookingEngine.defaultContry;
            }
        } catch (Exception e) {
            userCountry = BookingEngine.defaultContry;
        }

        try {
            //Esta interfaz solo se muestra para Canada y EU
            if (userCountry.equalsIgnoreCase("ca") || userCountry.equalsIgnoreCase("us")) {
                if (userLanguage.equals("en")) {
                    out.println(BookingEngine.htmlTravelocity_en);//Ingles, paises que lo manejen
                } else if (userLanguage.equals("fr")) {//Frances
                    out.println(BookingEngine.htmlTravelocity_fr);
                } else if (userLanguage.equals("es")) {//Español, paises que lo manejen
                    out.println(BookingEngine.htmlTravelocity_es);
                }
            }
        } catch (Exception e) {
            BookingEngine.log.error("Error while generating Travelocity's form.", e);
        }
    }

    /**
     * Muestra la caja de texto de Expidia, actualmente, este m&eacute;todo no se usa.
     * @param request la petici&oacute;n HTTP a atender
     * @param response la respuesta HTTP a devolver
     * @param paramRequest valores y objetos asociados a la petici&oacute;n HTTP
     * @throws SWBResourceException generada si hay alg&uacute;n problema durante
     *         la atenci&oacute;n a la petici&oacute;n
     * @throws IOException generada si hay alg&uacute;n problema de I/O durante
     *         la atenci&oacute;n a la petici&oacute;n
     */
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

    /**
     * Crea elementos de un documento DOM.
     * @param doc el documento en que se agregar&aacute;n los elementos
     * @param name cadena que representa el nombre del elemento a crear
     * @param value cadena que representa el valor del elemento a crear
     * @return un objeto de tipo {@code Element} listo para agregarse a un documento DOM
     */
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
