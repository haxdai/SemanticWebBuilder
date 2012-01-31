/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;


import com.arthurdo.parser.HtmlStreamTokenizer;
import com.arthurdo.parser.HtmlTag;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
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
import org.w3c.dom.DOMException;
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
     * Contiene la plantilla a utilizar para presentar los datos del clima como contenido
     */
    private javax.xml.transform.Templates contentTmplt;

    /**
     * Contiene la plantilla a utilizar para presentar los datos del clima como estrategia
     */
    private javax.xml.transform.Templates strategyTpl;

    /**
     * Almacena el código HTML generado (cache interno) para cada destino posible, como contenido
     */
    private String[] contentCode = new String[74];

    /**
     * Almacena el código HTML generado (cache interno) para cada destino posible, como estrategia
     */
    private String[] strategyCode = new String[74];

    /**
     * Almacena la hora en que se gener&oacute; por &uacute;ltima vez el reporte
     * del clima para cada destino y as&iacute; poder controlar el cache interno
     */
    private long[] generatedAt = new long[74];


    @Override
    public void setResourceBase(Resource base) {

        String tmpltFile = null;

        try {
            super.setResourceBase(base);
        } catch (Exception e) {
            WeatherVisit.log.error("Error while setting resource base: " + base.getId()
                    + "-" + base.getTitle(), e);
        }

        tmpltFile = base.getAttribute("contTemplate", "").trim();
        if (tmpltFile != null && !"".equals(tmpltFile)) {
            try {
                contentTmplt = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath(base.getWorkPath() + "/"
                                                      + tmpltFile));
//                path = SWBPortal.getWebWorkPath() +  base.getWorkPath() + "/";
            } catch (Exception e) {
                contentTmplt = null;
                WeatherVisit.log.error("Error while loading resource's content template: "
                        + base.getId(), e);
            }
        }

        if (contentTmplt == null) {
            try {
                contentTmplt = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath("/models/"
                                + base.getWebSite().getId()
                                + "/xsl/WeatherVisitCntnt.xslt"));
            } catch (Exception e) {
                WeatherVisit.log.error("Error while loading default resource's content template: "
                        + base.getId(), e);
            }
        }

        tmpltFile = base.getAttribute("stratTemplate", "").trim();
        if (tmpltFile != null && !"".equals(tmpltFile)) {
            try {
                strategyTpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath(base.getWorkPath() + "/"
                                                      + tmpltFile));
//                path = SWBPortal.getWebWorkPath() +  base.getWorkPath() + "/";
            } catch (Exception e) {
                strategyTpl = null;
                WeatherVisit.log.error("Error while loading resource's strategy template: "
                        + base.getId(), e);
            }
        }

        if (strategyTpl == null) {
            try {
                strategyTpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getFileFromWorkPath("/models/"
                                + base.getWebSite().getId()
                                + "/xsl/WeatherVisitStrat.xslt"));
            } catch (Exception e) {
                WeatherVisit.log.error("Error while loading default resource's strategy template: "
                        + base.getId(), e);
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
            doStrategyCall(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Genera y presenta el c&oacute;digo HTML del reporte del clima con la informaci&oacute;n
     * facilitada por la URL especificada, para la vista como contenido.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP a devolver
     * @param paramRequest los par&aacute;metros de la petici&oacute;n generados por SWB
     * @throws SWBResourceException en caso de ocurrir alg&uacute;n problema en la ejecuci&on del recurso
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException {

        //Por defecto muestra la información de Ciudad de México id = 53
        short destinationId = 53;
        Resource base = getResourceBase();
        int cacheInMiliSecs = 0;
        short minutes = 0;
        String HTMLString = null;
        long requestTime = System.currentTimeMillis();

        try {
            if (request.getParameter(("idDest")) != null) {
                destinationId = Short.parseShort(request.getParameter(("idDest")));
            }
        } catch (Exception e) {
            destinationId = 53;
        }

        //Se obtiene el valor de los minutos de duracion del cache configurados en la administracion del recurso
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
        
        //tiempo en cache configurado (milisegundos)
        cacheInMiliSecs = minutes * 60000;

        //Si el tiempo en cache no se ha sobrepasado se devuelve la cadena generada y almacenada previamente
        if (this.contentCode[destinationId - 1] != null &&
                cacheInMiliSecs >= (requestTime - this.generatedAt[destinationId - 1])) {
            HTMLString = this.contentCode[destinationId - 1];
        } else {
            //Si el tiempo en cache se ha sobrepasado, se genera de nuevo el código a mostrar.
            processHTMLCode(destinationId, request, paramRequest);
            if (this.contentCode[destinationId - 1] != null) {
                this.generatedAt[destinationId - 1] = requestTime;
                HTMLString = this.contentCode[destinationId - 1];
            } else {
                HTMLString = "";
            }
        }

        //Se muestra la cadena del reporte del clima con algunos ajustes de acuerdo al idioma de la petici&oacute;n
        try {
            PrintWriter out = response.getWriter();
            out.println(HTMLString.replaceFirst("TituloParaI18N",
                    paramRequest.getLocaleString("msgClima")).replaceFirst(
                    "HoyParaI18N", paramRequest.getLocaleString("msgHoy")
                    ).replaceFirst("ManianaParaI18N",
                    paramRequest.getLocaleString("msgManiana")));
        } catch (IOException ioe) {
            WeatherVisit.log.error("Al generar la vista de contenido del Clima", ioe);
        }

    }

    /**
     * Genera y presenta el c&oacute;digo HTML del reporte del clima con la informaci&oacute;n
     * facilitada por la URL especificada, para la vista como estrategia.
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param response la respuesta HTTP a devolver
     * @param paramRequest los par&aacute;metros de la petici&oacute;n generados por SWB
     * @throws SWBResourceException en caso de ocurrir alg&uacute;n problema en la ejecuci&on del recurso
     */
    private void doStrategyCall(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException {

        short destinationId = 53;  //por defecto (D.F.)
        String calculatedId = null;
        WebPage wp = paramRequest.getWebPage();
        String HTMLString = null;
        long requestTime = System.currentTimeMillis();
        Resource base = getResourceBase();
        int cacheInMiliSecs = 0;
        short minutes = 0;
        
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

        //Se obtiene el valor de los minutos de duracion del cache configurados en la administracion del recurso
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

        //Si el tiempo en cache no se ha sobrepasado se devuelve la cadena generada y almacenada previamente
        if (this.strategyCode[destinationId - 1] != null &&
                cacheInMiliSecs >= (requestTime - this.generatedAt[destinationId - 1])) {
            HTMLString = this.strategyCode[destinationId - 1];
        } else {
            //Si el tiempo en cache se ha sobrepasado, se genera de nuevo el código a mostrar.
            processHTMLCode(destinationId, request, paramRequest);
            if (this.strategyCode[destinationId - 1] != null) {
                HTMLString = this.strategyCode[destinationId - 1];
            } else {
                HTMLString = "";
            }
        }

        //Se muestra la cadena del reporte del clima con algunos ajustes de acuerdo al idioma de la petici&oacute;n
        try {
            PrintWriter out = response.getWriter();
            out.println(HTMLString.replaceFirst("TituloParaI18N",
                    paramRequest.getLocaleString("msgClima")).replaceFirst(
                    "HoyParaI18N", paramRequest.getLocaleString("msgHoy")
                    ).replaceFirst("ManianaParaI18N",
                    paramRequest.getLocaleString("msgManiana")));
        } catch (IOException ioe) {
            WeatherVisit.log.error("Al generar la vista por estrategia del Clima", ioe);
        }
    }

    /**
     * Genera el c&oacute;digo HTML a mostrar para el reporte del clima del destino
     * cuyo identificador se indica en el par&aacute;metro recibido. Almacena en
     * {@code contentCode} y en {@code strategyCode} los c&oacute;digos HTML correspondientes
     * y en {@code generatedAt} el momento en que se actualiza dicho c&oacute;digo.
     * @param destinationId identificador del destino
     * @param request la petici&oacute;n HTTP en atenci&oacute;n
     * @param paramRequest los par&aacute;metros de la petici&oacute;n generados por SWB
     */
    private void processHTMLCode(short destinationId, HttpServletRequest request,
            SWBParamRequest paramRequest) {

        Document dom = null;
        String propiedad = null;
        String imagen = null;
        String destino = null;

        //Se obtiene información del clima para el destino indicado
        try {

            URL pagina = new URL(URL_REQUESTED + destinationId);
            String hostCookie = pagina.getHost();
            String cookie = (String)request.getSession().getAttribute("Cookie:" + hostCookie);
            String sheader = request.getHeader("user-agent");
            WebPage climaWP = WebPage.ClassMgr.getWebPage(
                              getResourceBase().getAttribute("pageId", "Clima"),
                              paramRequest.getWebPage().getWebSite());
            URLConnection conex = null;

            try {
                //Se realiza la peticion a la página externa
                conex = pagina.openConnection();
                conex.setConnectTimeout(5000);
            } catch (Exception nexc) {
                conex = null;
                dom = null;
            }

            if (conex != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(System.currentTimeMillis());
                int diaMes = cal.get(Calendar.DATE);
                int mes = cal.get(Calendar.MONTH);
                String url = climaWP.getRealUrl(
                        paramRequest.getUser().getLanguage()) + "?idDest="
                        + destinationId;

                if (cookie != null) {
                    conex.setRequestProperty("Cookie", cookie);
                }
                if (sheader != null) {
                    conex.setRequestProperty("user-agent", sheader);
                }
                if (hostCookie != null) {
                    conex.setRequestProperty("host", hostCookie);
                }

                //Se prepara el an&aacute;lisis de la respuesta para obtener los datos del clima
                DataInputStream datos = new DataInputStream(conex.getInputStream());
                HtmlStreamTokenizer tok = new HtmlStreamTokenizer(
                                              new InputStreamReader(datos));

                String[] dia = new String[5];
                String[] temps = new String[5];
                String[] imgSrc = new String[5];
                String[] imgAlt = new String[5];
                StringBuilder selectOptions = new StringBuilder(128);
                int cont = 0;
                HtmlTag tag = new HtmlTag();
                boolean entrar = false;
                boolean entrar_img = false;
                boolean optionTag = false;

                dom = SWBUtils.XML.getNewDocument();
                Element ele = dom.createElement("clima");
                dom.appendChild(ele);

                Element clima = dom.createElement("titulo");
                clima.appendChild((Node) dom.createTextNode("TituloParaI18N"));
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

                //Se realiza el parseo del contenido de la respuesta
                while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF) {

                    String clima_dia = null;
                    String clima_temps = null;
                    String src_img = null;
                    String txt_alt = null;
                    int ttype = tok.getTokenType();
                    //Si es un tag
                    if (ttype == HtmlStreamTokenizer.TT_TAG) {
                        tok.parseTag(tok.getStringValue(), tag);
                        //De los span se obtienen los datos de nombre del destino,
                        //fecha del pronóstico y temperaturas del pronóstico
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
                            //De las imágenes se obtienen la ruta y el texto alterno
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
                        } else if (tag.getTagString().equalsIgnoreCase("option") &&
                                !tag.isEndTag()) {
                            Enumeration en = tag.getParamNames();
                            int i = 0;
                            String prueba = null;
                            //Se obtiene el identificador del destino en turno
                            while (en.hasMoreElements()) {
                                String p_name = (String) en.nextElement();
                                if (p_name.equalsIgnoreCase("value")) {
                                    selectOptions.append(tag.getParamValue(i));
                                    selectOptions.append("-");
                                    prueba = tag.getParamValue(i);
                                }
                                i++;
                            }
                            optionTag = true;
                            entrar = true;
                        }
                    //Si no es un tag, sino texto, se obtienen los datos
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
                            switch (cont) {
                                case 0: clima_dia = "HoyParaI18N";
                                        break;
                                case 1: clima_dia = "ManianaParaI18N";
                                        break;
                                default: clima_dia = tok.getStringValue().toString();
                            }
                            dia[cont] = clima_dia;
                        }
                        if (null == clima_temps &&
                                propiedad.equalsIgnoreCase("clima_temperaturas")) {
                            clima_temps = tok.getStringValue().toString();
                            temps[cont] = clima_temps;
                        }
                        if (optionTag) {
                            //arma el conjunto de valores para las opciones de destinos a consultar (select - HTML)
                            optionTag = false;
                            if (tok.getStringValue() != null &&
                                    !"".equals(tok.getStringValue())) {
                                selectOptions.append(tok.getStringValue());
                                selectOptions.append("@");
                            }
                        }
                        entrar = false;
                        propiedad = "";
                    }
                    if (cont < dia.length && dia[cont] != null && temps[cont] != null &&
                            imgSrc[cont] != null && imgAlt[cont] != null) {
                        cont++;
                    }
                }

                //Agrega al DOM las fechas y temperaturas del pronóstico
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

                    Element fechaEstrategia = dom.createElement("fechaEstrategia");
                    fechaEstrategia.appendChild((Node) dom.createTextNode(diaMes
                            + " " + getMonthName(mes + 1, paramRequest)));
                    ele.appendChild(fechaEstrategia);

                } catch (Exception edom) {
                    WeatherVisit.log.error("Error al generar el DOM de WeatherVisit.processHTMLCode()", edom);
                }

                //Agrega en el DOM, los destinos (extraídos de la petición remota) posibles de consultar
                if (selectOptions.length() > 0) {
                    try {
                    String[] options = selectOptions.toString().split("@");
                    Element destination = dom.createElement("destOptions");
                    for (int j = 0; j < options.length; j++) {
                        String[] values = options[j].split("-");
                        if (values != null && values.length == 2) {
                            Element option = dom.createElement("option");
                            
                            Element optnValue = dom.createElement("value");
                            optnValue.appendChild((Node) dom.createTextNode(values[0]));
                            option.appendChild(optnValue);
                            
                            Element optnText = dom.createElement("text");
                            optnText.appendChild((Node) dom.createTextNode(values[1]));
                            option.appendChild(optnText);
                            
                            destination.appendChild(option);
                            ele.appendChild(destination);
                        }
                    }
                    } catch (DOMException dome) {
                        WeatherVisit.log.error("Al agregar destinos del combo.", dome);
                    }
                }
            }

        } catch (SocketTimeoutException stoe) {
            dom = null;
        } catch (Exception e) {
            WeatherVisit.log.error("Error al obtener datos remotos, WeatherVisit.processHTMLCode()", e);
        }

        //Se generan y almacenan las cadenas del código HTML para las vistas de contenido y estrategia
        //con los datos remotos obtenidos, así como el momento en que se generan dichas cadenas, para control de cache
        if (null != dom) {
            try {
                this.contentCode[destinationId - 1] = SWBUtils.XML.transformDom(
                        this.contentTmplt, dom);
                this.strategyCode[destinationId - 1] = SWBUtils.XML.transformDom(
                        this.strategyTpl, dom);
                this.generatedAt[destinationId - 1] = System.currentTimeMillis();
            } catch (Exception transexc) {
                WeatherVisit.log.error("Error durante la transformación del XSL para WeatherVisit.processHTMLCode()", transexc);
            }
        }

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
            WeatherVisit.log.error("Error al obtener propiedad de archivo de i18n "
                    + "(WeatherVisit.properties). WeatherVisit.getMonthName()", e);
        }
        return m_name;

    }

}
