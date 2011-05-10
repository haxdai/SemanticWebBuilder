/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;


import com.arthurdo.parser.HtmlStreamTokenizer;
import com.arthurdo.parser.HtmlTag;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.*;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * Realiza una petici&oacute;n a una p&aacute;gina del Sistema de Internet de la Presidencia
 * para obtener los datos del clima en un destino. El destino se determina en base a la
 * secci&oacute;n del sitio presentada al usuario y sus relaciones con los destinos del sitio.
 * @author Juan Antonio Fernández Arias
 * Conversion a SWB - jose.jimenez
 */
public class WeatherVisit extends GenericAdmResource {


    /**
     * Mantiene una referencia hacia el objeto que genera mensajes en la bit&aacute;cora
     */
    private static Logger log = SWBUtils.getLogger(WeatherVisit.class);

    /**
     * Representa la URL de la p&aacute;agina a consultar.
     */
    private String URL_REQUESTED = "http://datos.gob.mx/clima/clima_h.php?clima=";

    /**
     * Contiene la plantilla a utilizar para presentar los datos del clima
     */
    private javax.xml.transform.Templates tpl;

    /**
     * Almacena el código HTML generado para cada destino posible
     */
    private String[] generatedCode = new String[74];

    /**
     * Almacena la hora en que se gener&oacute; por &uacute;ltima vez el reporte
     * del clima para cada destino
     */
    private long[] generatedAt = new long[74];


    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
        } catch (Exception e) {
            log.error("Error while setting resource base: " + base.getId()
                    + "-" + base.getTitle(), e);
        }
        if (!"".equals(base.getAttribute("template", "").trim())) {
            try {
                tpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath(base.getWorkPath() + "/"
                                + base.getAttribute("template").trim()));
//                path = SWBPortal.getWebWorkPath() +  base.getWorkPath() + "/";
            } catch (Exception e) {
                tpl = null;
                log.error("Error while loading resource template: "
                        + base.getId(), e);
            }
        }
        if (tpl == null) {
            try {
                tpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath("/models/"
                                + base.getWebSite().getId()
                                + "/xsl/WeatherVisit.xslt"));
            } catch (Exception e) {
                log.error("Error while loading default resource template: "
                        + base.getId(), e);
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        //Por defecto muestra la información de Ciudad de México id = 53
        short destinationId = 53;
        String calculatedId = null;
        WebPage wp = paramRequest.getWebPage();
        Resource base = getResourceBase();
        int cacheInMiliSecs = 0;
        short minutes = 0;
        String HTMLString = null;
        long requestTime = System.currentTimeMillis();

        //Se obtiene el identificador del destino del que se desea reportar el clima
        if (wp instanceof GeographicPoint) {
            calculatedId = ((GeographicPoint) wp).getDestWeather();
        } else if (wp instanceof ActivityRef) {
            calculatedId = ((GeographicPoint) (
                            (ActivityRef) wp).getLocality()).getDestWeather();
        } else if (wp instanceof ExperienceRef) {
            calculatedId = ((GeographicPoint) (
                            (ExperienceRef) wp).getLocality()).getDestWeather();
        } else if (wp instanceof WebPage &&
                request.getParameter("show") != null &&
                request.getParameter("show").equalsIgnoreCase("event") &&
                request.getParameter("id") != null) {
            Event e = Event.ClassMgr.getEvent(request.getParameter("id"),
                                              wp.getWebSite());
            if (e.getEventLocality() != null) {
                calculatedId = ((GeographicPoint)
                                e.getEventLocality()).getDestWeather();
            } else if (e.getEventActivityRef() != null) {
                calculatedId = ((GeographicPoint)
                        e.getEventActivityRef().getActLocality()).getDestWeather();
            }
        }
        if (calculatedId != null) {
            try {
                destinationId = Short.parseShort(calculatedId);
                if (destinationId < 1 || destinationId > 74) {
                    destinationId = 53;
                }
            } catch (NumberFormatException nfe) {
                destinationId = 53;
            }
        }

        if (base.getAttribute("cacheInMins") != null) {
            try {
                if (base.getAttribute("cacheInMins") != null &&
                        !"".equalsIgnoreCase(base.getAttribute("cacheInMins"))) {
                    minutes = Short.parseShort(base.getAttribute("cacheInMins"));
                } else {
                    minutes = 10;
                }
            } catch (NumberFormatException nfe) {
                
            }
        }
        
        //tiempo en cache (milisegundos)
        cacheInMiliSecs = minutes * 60000;

        if (generatedCode[destinationId - 1] != null &&
                cacheInMiliSecs >= (requestTime - generatedAt[destinationId - 1])) {
            HTMLString = generatedCode[destinationId - 1];
        } else {
            generatedCode[destinationId - 1] = processHTMLCode(destinationId,
                    request, paramRequest);
            generatedAt[destinationId - 1] = requestTime;
            HTMLString = generatedCode[destinationId - 1];
        }
        
        PrintWriter out = response.getWriter();
        out.println(HTMLString);

    }

    /**
     * Obtiene el c&oacute;digo HTML a mostrar para el reporte del clima del destino
     * cuyo identificador se indica en el par&aacute;metro recibido.
     * @param destinationId identificador del destino
     * @return la cadena que representa el HTML con el reporte del clima del destino
     *         con identificador {@code destinationId}
     */
    private String processHTMLCode(short destinationId, HttpServletRequest request,
            SWBParamRequest paramRequest) {

        Document dom = null;
        String propiedad = null;
        String imagen = null;
        String destino = null;
        String HTMLGenerated = null;

        //Se obtiene información del clima para el destino indicado
        try {

            URL pagina = new URL(URL_REQUESTED + destinationId);
            String hostCookie = pagina.getHost();
            String cookie = (String)request.getSession().getAttribute("Cookie:" + hostCookie);
            String sheader = request.getHeader("user-agent");
            URLConnection conex = null;

            try {
                //Se realiza la peticion a la página externa
                conex = pagina.openConnection();
            } catch (Exception nexc) {
                conex = null;
                dom = null;
            }

            if (conex != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(System.currentTimeMillis());
                int diaMes = cal.get(cal.DATE);
                int mes = cal.get(cal.MONTH);
                String url = paramRequest.getRenderUrl().toString();

                if (cookie != null) {
                    conex.setRequestProperty("Cookie", cookie);
                }
                if (sheader != null) {
                    conex.setRequestProperty("user-agent", sheader);
                }
                if (hostCookie != null) {
                    conex.setRequestProperty("host", hostCookie);
                }

                DataInputStream datos = new DataInputStream(conex.getInputStream());
                HtmlStreamTokenizer tok = new HtmlStreamTokenizer(
                                              new InputStreamReader(datos));

                String[] dia = new String[5];
                String[] temps = new String[5];
                String[] imgSrc = new String[5];
                String[] imgAlt = new String[5];
                int cont = 0;
                HtmlTag tag = new HtmlTag();
                boolean entrar = false;
                boolean entrar_img = false;

                dom = SWBUtils.XML.getNewDocument();
                Element ele = dom.createElement("clima");
                dom.appendChild(ele);

                Element clima = dom.createElement("titulo");
                clima.appendChild((Node) dom.createTextNode(
                                  paramRequest.getLocaleString("msgClima")));
                ele.appendChild(clima);

                Element tp_url = dom.createElement("url");
                tp_url.appendChild((Node) dom.createTextNode(url));
                ele.appendChild(tp_url);

                Element clima_id = dom.createElement("clima");
                clima_id.appendChild((Node) dom.createTextNode(
                                     Short.toString(destinationId)));
                ele.appendChild(clima_id);

                Element img_path = dom.createElement("ruta");
                img_path.appendChild((Node) dom.createTextNode(
                                     SWBPortal.getWebWorkPath()));
                ele.appendChild(img_path);

                //Se realiza el parseo del contenido de la petición
                while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF) {

                    String clima_dia = null;
                    String clima_temps = null;
                    String src_img = null;
                    String txt_alt = null;
                    int ttype = tok.getTokenType();
                    //Si es un tag
                    if (ttype == HtmlStreamTokenizer.TT_TAG) {
                        tok.parseTag(tok.getStringValue(), tag);
                        if (tag.getTagString().equalsIgnoreCase("span")) {
                            Enumeration en = tag.getParamNames();
                            int i = 0;

                            while (en.hasMoreElements()) {
                                String p_name = (String) en.nextElement();
                                if (p_name.equalsIgnoreCase("class")) {
                                    String p_valor = tag.getParamValue(i);
                                    if (p_valor.equalsIgnoreCase("clima_ciudad")) {
                                        propiedad = "clima_ciudad";
                                        entrar = true;
                                    } else if (p_valor.equalsIgnoreCase("clima_dias")) {
                                        propiedad = "clima_dias";
                                        entrar = true;
                                        entrar_img = false;
                                    }
                                    if (p_valor.equalsIgnoreCase("clima_temperaturas")) {
                                        propiedad = "clima_temperaturas";
                                        entrar = true;
                                        entrar_img = false;
                                    }
                                }
                                i++;
                            }
                        } else if (tag.getTagString().equalsIgnoreCase("img") &&
                                   !entrar_img) {
                            Enumeration en = tag.getParamNames();
                            int i = 0;
                            while (en.hasMoreElements()) {
                                String p_name = (String) en.nextElement();
                                if (p_name.equalsIgnoreCase("src")) {
                                    src_img = tag.getParamValue(i);
                                    imgSrc[cont] = src_img;
                                }
                                if (p_name.equalsIgnoreCase("alt")) {
                                    txt_alt = tag.getParamValue(i);
                                    imgAlt[cont] = txt_alt;
                                }
                                i++;
                            }
                            imagen = tag.toString();
                            entrar_img = true;
                        }
                    //Si no es un tag, sino texto
                    } else if (ttype == HtmlStreamTokenizer.TT_TEXT && entrar) {
                        if (null == destino &&
                                propiedad.equalsIgnoreCase("clima_ciudad")) {
                            destino = tok.getStringValue().toString();

                            Element n_destino = dom.createElement("destino");
                            n_destino.appendChild((Node) dom.createTextNode(destino));
                            ele.appendChild(n_destino);
                        }
                        if (null == clima_dia &&
                                propiedad.equalsIgnoreCase("clima_dias")) {
                            clima_dia = tok.getStringValue().toString();
                            dia[cont] = clima_dia;
                        }
                        if (null == clima_temps &&
                                propiedad.equalsIgnoreCase("clima_temperaturas")) {
                            clima_temps = tok.getStringValue().toString();
                            temps[cont] = clima_temps;
                        }
                        entrar = false;
                    }
                    if (cont < dia.length && dia[cont] != null && temps[cont] != null &&
                            imgSrc[cont] != null && imgAlt[cont] != null) {
                        cont++;
                    }
                }

                try {
                    for (int i = 0; i < dia.length; i++) {
                        Element row = dom.createElement("row");

                        Element n_fecha = dom.createElement("fecha");
                        n_fecha.appendChild((Node) dom.createTextNode(dia[i]));
                        row.appendChild(n_fecha);

                        Element n_grados = dom.createElement("temperatura");
                        n_grados.appendChild((Node) dom.createTextNode(temps[i]));
                        row.appendChild(n_grados);

                        Element img_clima = dom.createElement("img_temp");
                        img_clima.appendChild((Node) dom.createTextNode(imgSrc[i]));
                        row.appendChild(img_clima);

                        Element img_alt = dom.createElement("img_alt");
                        img_alt.appendChild((Node) dom.createTextNode(imgAlt[i]));
                        row.appendChild(img_alt);
                        
                        ele.appendChild(row);
                    }

                } catch (Exception edom) {
                    log.error("Error al generar el DOM de WeatherVisit.processHTMLCode()", edom);
                }
            }

        } catch (Exception e) {
            log.error("Error al obtener datos remotos, WeatherVisit.processHTMLCode()", e);
        }

        if (null != dom) {
            try {
                HTMLGenerated = SWBUtils.XML.transformDom(tpl, dom);
            } catch (Exception transexc) {
                log.error("Error durante la transformación del XSL para WeatherVisit.processHTMLCode()", transexc);
            }
        }

        return HTMLGenerated;
    }

    /**
     * En base al n&uacute;mero de mes recibido devuelve el nombre del mes correspondiente
     * @param mes n&uacute;mero de mes del que se desea obtener el nombre
     * @param paramRequest contiene datos complementarios de la petici&oacute;n recibida
     * @return una cadena que representa el nombre del mes cuyo n&uacute;mero es igual a {@code mes}
     */
    private String getMonthName(int mes, SWBParamRequest paramRequest) {

        String m_name = "";

        try {
            if (mes > 0 && mes < 13) {
                switch (mes) {
                    case 1: m_name = paramRequest.getLocaleString("msgEne");
                            break;
                    case 2: m_name = paramRequest.getLocaleString("msgFeb");
                            break;
                    case 3: m_name = paramRequest.getLocaleString("msgMar");
                            break;
                    case 4: m_name = paramRequest.getLocaleString("msgAbr");
                            break;
                    case 5: m_name = paramRequest.getLocaleString("msgMay");
                            break;
                    case 6: m_name = paramRequest.getLocaleString("msgJun");
                            break;
                    case 7: m_name = paramRequest.getLocaleString("msgJul");
                            break;
                    case 8: m_name = paramRequest.getLocaleString("msgAgo");
                            break;
                    case 9: m_name = paramRequest.getLocaleString("msgSep");
                            break;
                    case 10: m_name = paramRequest.getLocaleString("msgOct");
                             break;
                    case 11: m_name = paramRequest.getLocaleString("msgNov");
                             break;
                    case 12: m_name = paramRequest.getLocaleString("msgDic");
                }
            }
        } catch (Exception e) {
            log.error("Error al obtener propiedad de archivo de i18n "
                    + "(WeatherVisit.properties). WeatherVisit.getMonthName()", e);
        }
        return m_name;

    }

}
