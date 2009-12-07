/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 
package org.semanticwb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.log4j.PropertyConfigurator;
import org.semanticwb.base.db.DBConnectionManager;
import org.semanticwb.base.db.DBConnectionPool;
import org.semanticwb.base.db.PoolConnectionTimeLock;
import org.semanticwb.base.util.imp.Logger4jImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.EmailAttachment;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import org.semanticwb.base.util.ErrorElement;
import org.semanticwb.base.util.SFBase64;
import org.semanticwb.base.util.SWBMailSender;
import org.semanticwb.base.util.SWBMail;
import org.semanticwb.base.util.SWBProperties;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
//import sun.misc.BASE64Encoder;


/**
 * Contains utileries for managing error logs, text, database, IO, Zip files, emails,
 * Xml, Xslt , Dom, Collections and encriptions
 * <p>Contiene utilerias para manejo de log de errores, texto, base de datos, IO,
 * Zip, Email, Xml, colecciones y encripciones</p>
 * @author  Javier Solis Gonzalez (jsolis@infotec.com.mx)
 * @author Jorge Jiménez (george24@infotec.com.mx)
 * @version 1.0
 */
public class SWBUtils {


    /**
     * Holds a reference to a log utility.
     * <p>Mantiene una referencia a la utiler&iacute;a de generaci&oacute;n de bit&aacute;coras.</p>
     */
    private static Logger log = getLogger(SWBUtils.class);

    /**
     * Holds a reference to an object of this class.
     * <p>Mantiene una referencia a un objeto de esta clase.</p>
     */
    static private SWBUtils instance;

    /**
     * The string representing this application's physical path.
     * <p>La cadena que representa la ruta f&iacute;sica de esta aplicaci&oacute;n</p>
     */
    private static String applicationPath = SWBUtils.class.getResource("/").toString();

    /**
     * Defines the size used for creating arrays that will be used in I/O operations.
     * <p>Define el tama&ntilde;o utilizado en la creaci&oacute;n de arrays que
     * ser&aacute;n utilizados en operaciones de entrada/salida.</p>
     */
    private static int bufferSize = 8192;

    /**
     * Indicates wheater or not the logger services have been iniciated.
     * <p>Indica si los servicios del generador de bit&aacute;coras se han iniciado o no.</p>
     */
    private static boolean initLogger = false;

    /**
     * Specifies a default language to use.
     * <p>Especifica un lenguaje a usar por defecto.</p>
     */
    private static Locale locale = Locale.ENGLISH;
    public static String LOCALE_SERVICES = null;

    /**
     * Stablishes the logger's output as the one used for {@link System.err}
     * <p>Establece la salida del generador de bit&aacute;coras, como el mismo que usa {@code System.err}</p>
     */
    private static PrintWriter log2File = new PrintWriter(System.err);

    /**
     * Contains the error elements to show in the administration site's error viewer.
     * <p>Contiene los elementos de error a mostrar en el visor de errores del sitio
     * de administraci&oacute;n.</p>
     */
    private static Vector errorElement=new Vector();

    /**
     * Specifies the number of error elements to show in the administration site's error viewer.
     * <p>Indica el n&uacute;mero de elementos de error a mostrar en el visor de
     * errores del sitio de administraci&oacute;n.</p>
     */
    private static int errorElementSize=200;


    /**
     * Creates a new object of this class
     */
    private SWBUtils() {

        log.event("Initializing SemanticWebBuilder Base...");
        log.event("-->AppicationPath: " + applicationPath);
        init();
        log.event("-->Default Encoding: "+TEXT.getDafaultEncoding());
    }

    /**
     * Retrieves a reference to the only one existing object of this class.
     * <p>Obtiene una referencia al &uacute;nico objeto existente de esta clase.</p>
     * @param applicationPath a string representing the path for this application
     * @return a reference to the only one existing object of this class
     */
    static public synchronized SWBUtils createInstance(String applicationPath) {

        SWBUtils.applicationPath = IO.normalizePath(applicationPath);
        if (instance == null) {
            initFileLogger();
            instance = new SWBUtils();
        }
        return instance;
    }

    /*
     * Initializes the class variables needed to provide this object's services
     * <p>Inicializa las variables de clase necesarias para proveer los servicios de este objeto.</p>
     */
    private void init() {

        LOCALE_SERVICES = "locale_services";
    }

    /**
     * Gets the physical path for the Web application to serve. For example: <br/>/tomcat/webapps/swb
     * <p>Obtiene la ruta f&iacute;sica de la aplicaci&oacute;n Web a servir.</p>
     * @return a string representing the physical path for the Web application to serve
     */
    public static String getApplicationPath() {

        return applicationPath;
    }

    /**
     * Initializes the configuration fot the default logger for SWB. The following
     * is the configuration set:
     * <br/>{@code log4j.rootLogger=info, stdout}
     * <br/>{@code log4j.appender.stdout=org.apache.log4j.ConsoleAppender}
     * <br/>{@code log4j.appender.stdout.layout=org.apache.log4j.PatternLayout}
     * <br/>{@code log4j.appender.stdout.layout.ConversionPattern=%d %p - %m%n}
     * <br/>{@code log4j.logger.org.semanticwb=trace}
     * <p>Inicializa el generador de bit&aacute;coras por defecto de SWB, con la
     * configuraci&oacute;n descrita anteriormente.</p>
     */
    private static void initLogger() {

        String log_conf = "log4j.rootLogger=info, stdout" + "\n" +
                "log4j.appender.stdout=org.apache.log4j.ConsoleAppender" + "\n" +
                "log4j.appender.stdout.layout=org.apache.log4j.PatternLayout" + "\n" +
                "log4j.appender.stdout.layout.ConversionPattern=%d %p - %m%n" + "\n" +
                "log4j.logger.org.semanticwb=trace";

        try {
            Properties proper = new Properties();
            proper.load(IO.getStreamFromString(log_conf));
            PropertyConfigurator.configure(proper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //org.apache.log4j.Logger.getLogger("org.semanticwb").setLevel(Level.TRACE);
        initLogger = true;
    }

    /**
     * Initializes the configuration fot the SWB's logger according to
     * the content of a file. The file which stores the configuration to set is
     * located in the directory {@literal /WEB-INF/classes/logging.properties} within
     * the current application path.
     * <p>Inicializa la configuraci&oacute;n del generador de bit&aacute;coras de
     * SWB de acuerdo al contenido de un archivo. El archivo que almacena la
     * configuraci&oacute;n a usar se ubica en el directorio {@literal /WEB-INF/classes/logging.properties}
     * dentro de la ruta f&iacute;sica de la aplicaci&oacute;n.</p>
     */
    private static void initFileLogger() {

        try {
            FileInputStream in = new FileInputStream(applicationPath
                    + "/WEB-INF/classes/logging.properties");
            String log_conf = IO.readInputStream(in);
            log_conf = SWBUtils.TEXT.replaceAll(log_conf, "{apppath}", applicationPath);
            Properties proper = new Properties();
            proper.load(IO.getStreamFromString(log_conf));
            PropertyConfigurator.configure(proper);
        } catch (Exception e) {
            log.error("Error: logging.properties not found...", e);
        }
        //org.apache.log4j.Logger.getLogger("org.semanticwb").setLevel(Level.TRACE);
        initLogger = true;
    }

    /**
     * Creates a logger's instance and relates it to the class received.
     * <p>Crea una instancia de un generador de archivos de bit&aacute;cora y
     * la relaciona con la clase recibida.</p>
     * @param cls a class to relate to the creating instance
     * @return a logger related to the class specified
     */
    public static Logger getLogger(Class cls) {
        if (!initLogger) {
            initLogger();
        }
        return new Logger4jImpl(cls);
    }
    
    /**
     * Manages the element errors that are shown in the error viewer.
     * <p>Administra los elementos que se muestran en el visor de errores.</p>
     */
    public static class ERROR 
    {


        /**
         * Adds an element to the class variable {@link SWBUtils.errorElement}.
         * If the quantity of elements exceeds the {@link SWBUtils.errorElementSize}'s
         * value, the last element of {@code SWBUtils.errorElement} is removed. Every
         * element is added at the beggining of {@code SWBUtils.errorElement}.
         * <p>Agrega un elemento a la variable de clase {@code SWBUtils.errorElement}.
         * Si la cantidad de elementos excede el valor de {@code SWBUtils.errorElementSize},
         * el &uacute;ltimo elemento de {@code SWBUtils.errorElement} es eliminado.
         * Cada elemento se agrega al inicio de {@code SWBUtils.errorElement}.</p>
         * @param msg a string containing the error's description
         * @param e the throwable object generated by the error
         * @param cls the class asociated to the logger
         * @param level a string representing the error element's level
         */
        public static void addError(String msg, Throwable e, Class cls, String level)
        {
            try
            {
                SWBUtils.errorElement.add(0, new ErrorElement(e, msg, cls, level));
                if (SWBUtils.errorElement.size() > SWBUtils.errorElementSize)
                {
                    SWBUtils.errorElement.remove(SWBUtils.errorElementSize);
                }
            } catch (Exception noe) {}
        }

        /**
         * Retrieves the {@code SWBUtils.errorElement}'s iterator, whose size
         * is defined by the class member {@code SWBUtils.errorElementSize}.
         * <p>Regresa el iterador de {@code SWBUtils.errorElement}, cuyo tamaño
         * est&aacute; definido por la variable de clase {@code SWBUtils.errorElementSize}.
         */
        public static Iterator getErrorElements()
        {
            return new Vector(SWBUtils.errorElement).iterator();
        }

        /**
         * Gets the value of the class member {@code SWBUtils.errorElementSize}.
         * <p>Obtiene el valor de la variable de clase {@code SWBUtils.errorElementSize}.</p>
         * @return the value of the class member {@code SWBUtils.errorElementSize}.
         */
        public static int getErrorElementSize()
        {
            return SWBUtils.errorElementSize;
        }    

        /**
         * Sets the value of the class member {@code SWBUtils.errorElementSize}.
         * <p>Asigna el valor de la variable de clase {@code SWBUtils.errorElementSize}.</p>
         * @param errorElementSize the new value of the class member {@code SWBUtils.errorElementSize}.
         */
        public static void setErrorElementSize(int errorElementSize)
        {
            SWBUtils.errorElementSize = errorElementSize;
        }            
    }


    /**
     * Supplies several functions for handling strings commonly used, like: encoding,
     * parsing, formatting, replacement, i18n and localization.
     * <p>Provee varias funciones para la manipulaci&oacute;n de cadenas de texto
     * utilizadas com&uacute;nmente, como: codificaci&oacute;n, an&aacute;lisis
     * sint&aacute;ctico, formato y reemplazo, internacionalizaci&oacute;n y localizaci&oacute;n.</p>
     */
    public static class TEXT {


        /**
         * Specifies the value for the charset ISO8859-1.
         * <p>Especifica el valor para el c&oacute;digo de caracteres ISO8859-1.</p>
         */
        public static final String CHARSET_ISO8859_1="ISO8859_1";

        /**
         * Specifies the value for the charset UTF-8
         * <p>Especifica el valor para el c&oacute;digo de caracteres UTF-8.</p>
         */
        public static final String CHARSET_UTF8="UTF8";

        /**
         * Stores the name of the character encoding used by default.
         * <p>Almacena el nombre del c&oacute;digo de caracteres utilizado por defecto.</p>
         */
        private static String defencoding=null;


        /**
         * Given a string specifying a charset, returns the value of {@code SWBUtils.TEXT.CHARSET_ISO8859_1}
         * or the value of {@code SWBUtils.TEXT.CHARSET_UTF8}. If {@code charset} contains <quote>UTF</quote> anywhere
         * the value returned will be {@value #CHARSET_UTF8} otherwise the value returned
         * will be {@value #CHARSET_ISO8859_1}. For example: <br>if {@code charset} contains <quote>UTF-8</quote>
         * or <quote>UTF-2</quote>, the value returned will be {@value #CHARSET_UTF8}.
         * <p>Dada una cadena especificando un c&oacute;digo de caracteres, regresa el valor de
         * {@code SWBUtils.TEXT.CHARSET_ISO8859_1} o el valor de {@code SWBUtils.TEXT.CHARSET_UTF8}.
         * Ejemplo: <br>si {@code charset} contiene <quote>ISO-8859-1</quote> o <quote>ISO8859-1</quote> o
         * <quote>8859-1</quote> el valor regresado, ser&aacute; {@value #CHARSET_ISO8859_1}</p>
         * @param charset a string representing the name of a charset (like <quote>ISO-8859-1</quote> or
         * <quote>ISO8859-1</quote> or <quote>8859-1</quote> or <quote>UTF-8</quote> or <quote>UTF_8</quote>
         * @return the string contained in {@code SWBUtils.TEXT.CHARSET_ISO8859_1}
         *         or in {@code SWBUtils.TEXT.CHARSET_UTF8}, depending on the value
         *         received in {@code charset}.
         */
        public static String getHomCharSet(String charset)
        {
            String ret=CHARSET_ISO8859_1;
            if(charset.toUpperCase().indexOf("UTF")>-1)
            {
                ret=CHARSET_UTF8;
            }
            return ret;
        }

        /**
         * Returns the number corresponding to the month's full name specified according
         * to the language received.
         * <p>Regresa el n&uacute;mero correspondiente al nombre (completo) del mes
         * especificado, el nombre del mes debe ser especificado en el lenguaje indicado
         * en {@code language}.</p>
         * @param month a string representing the month's full name in the specified {@code language}
         * @param language a string representing the language in which the month's name is specified
         * @return the number of month corresponding to the specified month's name.
         *         If there is no match found between the name received and a month's name
         *         in the specified language, a value of -1 is returned. If the language
         *         specified is not accepted by {@link java.util.Locale}, the English language
         *         will be used.
         *         <p>el n&uacute;mero de mes correspondiente al nombre de mes especificado.
         *         Si no hay correspondencia entre el nombre recibido y un nombre de mes
         *         en el lenguaje especificado, un valor de -1, ser&aacute; regresado.
         *         Si el lenguage especificado no es aceptado por {@code Locale}, el lenguaje
         *         Ingl&eacute;s sera utilizado.</p>
         */
        public static int monthToInt(String month, String language) {
            Locale loc;
            try {
                loc = new Locale(language);
            }catch(Exception e) {
                loc = locale;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM");
            GregorianCalendar gc = new GregorianCalendar(loc);
            gc.set(Calendar.MONTH, Calendar.JANUARY);
            gc.set(Calendar.DATE, 1);
            int i;
            for(i=1; i<=12; i++) {
                if( formatter.format(gc.getTime()).equalsIgnoreCase(month) ) {
                    return i;
                }
                gc.add(Calendar.MONTH, 1);
            }
            return -1;
        }

        /**
         * Returns the name of the character encoding used by default.
         * <p>Regresa el nombre del c&oacute;digo de caracteres utilizado por defecto.</p>
         * @return a string representing the character encoding used by default.
         *         <p>una cadena que representa el c&oacute;digo de caracteres utilizado por defecto.</p>
         */
        public static String getDafaultEncoding()
        {
            if (defencoding == null)
            {
                OutputStreamWriter out = new OutputStreamWriter(new ByteArrayOutputStream());
                defencoding=out.getEncoding();
            }
            return defencoding;
        }

        /**
         * Replaces from {@code str} all the occurrences of {@code match} with the
         * content in {@code replace}. <p>Reemplaza en {@code str} las ocurrencias
         * encontradas de {@code match} con el contenido de {@code replace}.</p>
         * @param str a string with the original content to modify
         * @param match a string with the content to find in {@code str}
         * @param replace a string with the replacing text
         * @return a string with all the occurrences of {@code match} found  in {@code str}
         *         substituted by {@code replace}.
         *         <p>una cadena con todas las ocurrencias de {@code match} encontradas
         *         en {@code str} substituidas por {@code replace}.</p>
         */
        public static String replaceAll(String str, String match, String replace) {

            if (match == null || match.length() == 0) {
                return str;
            }
            if (replace == null) {
                replace = "";
            }
            if (match.equals(replace)) return str;
            StringBuffer ret = new StringBuffer();
            int i = str.indexOf(match);
            int y = 0;
            while (i >= 0) {
                //System.out.println("i:"+i+" y:"+y);
                ret.append(str.substring(y, i));
                ret.append(replace);
                //str = str.substring(y, i) + replace + str.substring(i + match.length());
                y = i + match.length();
                i = str.indexOf(match,y);
            }
            ret.append(str.substring(y));
            return ret.toString();
        }

        /**
         * Replaces from {@code str} all the occurrences of {@code match} with the
         * content in {@code replace} ignoring case. <p>Reemplaza en {@code str} las ocurrencias
         * encontradas de {@code match} con el contenido de {@code replace} sin
         * sensibilidad a las may&uacute;sculas.</p>
         * @param str a string with the original content to modify
         * @param match a string with the content to find in {@code str}
         * @param replace a string with the replacing text
         * @return a string with all the occurrences of {@code match} found in {@code str}
         *         substituted by {@code replace}.
         *         <p>una cadena con todas las ocurrencias de {@code match} encontradas
         *         en {@code str} substituidas por {@code replace}.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static String replaceAllIgnoreCase(String str, String match, String replace) {
            if (match == null || match.length() == 0) {
                return str;
            }
            if (replace == null) {
                replace = "";
            }
            int i = str.toLowerCase().indexOf(match.toLowerCase());
            int y = 0;
            while (i >= 0) {
                str = str.substring(0, i) + replace + str.substring(i + match.length());
                y = i + replace.length();
                i = str.toLowerCase().indexOf(match.toLowerCase(), y);
            }
            return str;
        }

        /**
         * Replaces the first occurrence of {@code match} in {@code str} with the
         * content of {@code replace} ignoring case.
         * <p>Reemplaza la primera ocurrencia de {@code match} en {@code str} con
         * el contenido de {@code replace} ignorando las may&uacute;sculas.</p>
         * @param str a string with the original content to modify
         * @param match a string with the content to find in {@code str}
         * @param replace a string with the replacing text
         * @return a string with the first occurrence of {@code match} found in {@code str}
         *         substituted by {@code replace}.
         *         <p>una cadena con la primer ocurrencia de {@code match} encontrada
         *         en {@code str} substituida por {@code replace}.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static String replaceFirstIgnoreCase(String str, String match, String replace) {
            if (match == null || match.length() == 0) {
                return str;
            }
            if (replace == null) {
                replace = "";
            }
            int i = str.toLowerCase().indexOf(match.toLowerCase());
            if (i >= 0) {
                str = str.substring(0, i) + replace + str.substring(i + match.length());
            }
            return str;
        }

        /**
         * Converts a date into a string with the format {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}.
         * <p>Convierte un objeto date a uno string con el formato {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}.</p>
         * @param date a date to convert
         * @return a string representing the date received with the format {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}.
         *         <p>un objeto string que representa al date recibido, con el
         *         formato {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}.</p>
         */
        public static String iso8601DateFormat(Date date) 
        {
            SimpleDateFormat iso8601dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS");
            return iso8601dateFormat.format(date);
        }

        /**
         * Converts a string representing a date with the format {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}
         * into a date. <p>Convierte un objeto string que representa una fecha con formato
         * {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}, en un objeto date.</p>
         * @param date a string representing a date with the format {@literal yyyy-MM-dd'T'HH:mm:ss'.'SSS}
         * @return a date equivalent to the value of to the string received.
         *         <p>un objeto date equivalente al valor representado por el string recibido.</p>
         * @throws java.text.ParseException if the value received does not represent a valid date.
         *         <p>Si el valor recibido no representa una fecha valida.</p>
         */
        public static Date iso8601DateParse(String date) throws ParseException
        {
            SimpleDateFormat iso8601dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS");
            return iso8601dateFormat.parse(date);
        }

        /**
         * Converts a string in an integer value; if this is not possible, it returns
         * the integer received. <p>Convierte un objeto string en un valor entero;
         * si no es posible, devuelve el valor entero recibido.</p>
         * @param val a string representing a valid integer
         * @param defa a value to return in case the convertion is not possible
         * @return an integer equivalent to the value represented by {@code val}, or {@code defa}
         *         if the convertion is not possible or if {@code val} is {@code null}.
         *         <p>un entero equivalente al valor representado por {@code val},
         *         o {@code defa}, si la conversi&oacute;n no es posible o si {@code val}
         *         es {@code null}.</p>
         */
        public static int getInt(String val, int defa) {
            if (val == null) {
                return defa;
            }
            try {
                return Integer.parseInt(val);
            } catch (Exception e) {
                return defa;
            }
        }

        /**
         * Applies the charset specified in {@code enc} to the {@code data} received.
         * <p>Aplica el conjunto de caracteres especificado en {@code enc} a la
         * informaci&oacute;n recibida en {@code data}.</p>
         * @param data a string with the information to apply the charset
         * @param enc the charset to apply
         * @return the string containing the {@code data} received with the charset applied.
         *         <p>el objeto string que contiene la informaci&oacute;n recibida
         *         con el conjunto de caracteres aplicado.</p>
         * @throws java.io.UnsupportedEncodingException If the specified charset's
         *         name is not supported. <p>Si el nombre del conjunto de caracteres
         *         especificado no es soportado.</p>
         * @throws java.io.IOException If there is a problem when applying the charset.
         *         <p>Si ocurre un problema al aplicar el conjunto de caracteres.</p>
         */
        public static String encode(String data, String enc) 
                throws java.io.UnsupportedEncodingException, java.io.IOException {

            ByteArrayOutputStream sw = new java.io.ByteArrayOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(sw, enc);
            out.write(data);
            out.flush();
            return new String(sw.toByteArray());
        }

        /**
         * Decodes a string applying the specified charset in {@code enc}.
         * <p>Decodifica el contenido de {@code data} aplicando el conjunto de caracteres
         * especificado en {@code enc}.</p>
         * @param data the string to decode
         * @param enc the charset to apply
         * @return a string resulting from applying the charset specified on {@code data}.
         *         <p>el objeto string que contiene la informaci&oacute;n recibida
         *         con el conjunto de caracteres aplicado.</p>
         * @throws java.io.UnsupportedEncodingException If the specified charset's
         *         name is not supported. <p>Si el nombre del conjunto de caracteres
         *         especificado no es soportado.</p>
         * @throws java.io.IOException If there is a problem when applying the charset.
         *         <p>Si ocurre un problema al aplicar el conjunto de caracteres.</p>
         */
        public static String decode(String data, String enc)
                throws java.io.UnsupportedEncodingException, java.io.IOException {

            ByteArrayInputStream sw = new ByteArrayInputStream(data.getBytes());
            InputStreamReader in = new InputStreamReader(sw, enc);

            StringBuffer ret = new StringBuffer(data.length());

            char[] bfile = new char[bufferSize];
            int x;
            while ((x = in.read(bfile, 0, bufferSize)) > -1) {
                ret.append(new String(bfile, 0, x));
            }
            in.close();
            return ret.toString();
        }

        /**
         * Encodes an regular ASCII string into the corresponding values in Base 64.
         * <p>Codifica un objeto string en los valores correspondientes en Base 64.</p>
         * @param txt a string to convert to Base 64 encoding
         * @return a string equivalent to {@code txt} with the content represented in Base 64.
         *         <p>un objeto string equivalente a {@code txt} con el contenido
         *         representado en Base 64.</p>
         */
        public static String encodeBase64(String txt) {
            return SFBase64.encodeString(txt);
        }

        /**
         * Decodes an ASCII Base 64 represented string into the corresponding values
         * in regular ASCII. <p>Decodifica un objeto string representado en ASCII en Base 64
         * en los valores correspondientes en c&oacute;digo ASCII regular.</p>
         * @param txt a string to convert from Base 64 encoding
         * @return a string equivalent to {@code txt} with the content represented in ASCII encoding.
         *         <p>un objeto string equivalente a {@code txt} con el contenido
         *         representado en c&oacute;digo ASCII.</p>
         */
        public static String decodeBase64(String txt) {
            return SFBase64.decodeToString(txt);
        }

        /**
         * Converts to upper case the first letter of each word in {@code str}. Every
         * blank space, period, hyphen and underscore is considered a word separator.
         * <p>Convierte a may&uacute;scula la primera letra de cada palabra en {@code str}.
         * Cada espacio en blanco, punto, gui&oacute;n y gui&oacute;n bajo se considera como
         * separador de palabras.</p>
         * @param str a string whose content is going to be modified
         * @return a string with the same content as {@code str} but with every word's
         *         first letter turned to upper case.
         *         <p>un objeto string con el mismo contenido de {@code str} pero con
         *         cada inicial de palabra convertida a may&uacute;scula.</p>
         */
        public static String toUpperCaseFL(String str) {
            boolean b = true;
            String ret = "";
            for (int x = 0; x < str.length(); x++) {
                char c = str.charAt(x);
                if (b) {
                    ret += Character.toUpperCase(c);
                    b = false;
                } else {
                    ret += c;
                }
                if (c == ' ' || c == '.' || c == '-' || c == '_') {
                    b = true;
                }
            }
            return ret;
        }

        /**
         * Replaces accented characters and blank spaces in the string given.
         * Makes the changes in a case sensitive manner, the following are some examples
         * of the changes this method makes: <br>
         * {@literal Á} is replaced by {@literal A} <br>
         * {@literal Ê} is replaced by {@literal E} <br>
         * {@literal Ï} is replaced by {@literal I} <br>
         * {@literal â} is replaced by {@literal a} <br>
         * {@literal ç} is replaced by {@literal c} <br>
         * {@literal ñ} is replaced by {@literal n} <br>
         * and blank spaces are replaced by underscore characters, any symbol in
         * {@code txt} other than underscore is eliminated.
         * <p>Reemplaza caracteres acentuados y espacios en blanco en {@code txt}.
         * Realiza los cambios respetando caracteres en may&uacute;sculas o min&uacute;sculas
         * los caracteres en blanco son reemplazados por guiones bajos, cualquier s&iacute;mbolo
         * diferente a gui&oacute;n bajo es eliminado.</p>
         * @param txt a string in which the characters are going to be replaced
         * @param replaceSpaces a {@code boolean} indicating if blank spaces are going to be replaced or not
         * @return a string similar to {@code txt} but with neither accented or
         *         special characters nor symbols in it. <p>un objeto string similar
         *         a {@code txt} pero sin caracteres acentuados o especiales y sin s&iacute;mbolos</p>
         */
        public static String replaceSpecialCharacters(String txt, boolean replaceSpaces) {
            StringBuffer ret = new StringBuffer();
            String aux = txt;
            //aux = aux.toLowerCase();
            aux = aux.replace('Á', 'A');
            aux = aux.replace('Ä', 'A');
            aux = aux.replace('Å', 'A');
            aux = aux.replace('Â', 'A');
            aux = aux.replace('À', 'A');
            aux = aux.replace('Ã', 'A');

            aux = aux.replace('É', 'E');
            aux = aux.replace('Ê', 'E');
            aux = aux.replace('È', 'E');
            aux = aux.replace('Ë', 'E');

            aux = aux.replace('Í', 'I');
            aux = aux.replace('Î', 'I');
            aux = aux.replace('Ï', 'I');
            aux = aux.replace('Ì', 'I');

            aux = aux.replace('Ó', 'O');
            aux = aux.replace('Ö', 'O');
            aux = aux.replace('Ô', 'O');
            aux = aux.replace('Ò', 'O');
            aux = aux.replace('Õ', 'O');

            aux = aux.replace('Ú', 'U');
            aux = aux.replace('Ü', 'U');
            aux = aux.replace('Û', 'U');
            aux = aux.replace('Ù', 'U');

            aux = aux.replace('Ñ', 'N');


            aux = aux.replace('Ç', 'C');
            aux = aux.replace('Ý', 'Y');

            aux = aux.replace('á', 'a');
            aux = aux.replace('à', 'a');
            aux = aux.replace('ã', 'a');
            aux = aux.replace('â', 'a');
            aux = aux.replace('ä', 'a');
            aux = aux.replace('å', 'a');

            aux = aux.replace('é', 'e');
            aux = aux.replace('è', 'e');
            aux = aux.replace('ê', 'e');
            aux = aux.replace('ë', 'e');

            aux = aux.replace('í', 'i');
            aux = aux.replace('ì', 'i');
            aux = aux.replace('î', 'i');
            aux = aux.replace('ï', 'i');

            aux = aux.replace('ó', 'o');
            aux = aux.replace('ò', 'o');
            aux = aux.replace('ô', 'o');
            aux = aux.replace('ö', 'o');
            aux = aux.replace('õ', 'o');

            aux = aux.replace('ú', 'u');
            aux = aux.replace('ù', 'u');
            aux = aux.replace('ü', 'u');
            aux = aux.replace('û', 'u');

            aux = aux.replace('ñ', 'n');

            aux = aux.replace('ç', 'c');
            aux = aux.replace('ÿ', 'y');
            aux = aux.replace('ý', 'y');

            if (replaceSpaces) {
                aux = aux.replace(' ', '_');
            }
            int l = aux.length();
            for (int x = 0; x < l; x++) {
                char ch = aux.charAt(x);
                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '_') {
                    ret.append(ch);
                }
            }
            aux = ret.toString();
            return aux;
        }

        /**
         * Gets the value for a {@code key} in the specified {@code Bundle} with
         * the default {@code locale}. <p>Obtiene el valor correspondiente al {@code key}
         * especificado con el objeto {@code locale} utilizado por defecto.</p>
         * @param Bundle a string specifying the bundle that contains the data to retrieve
         * @param key a string indicating the key name whose value is required
         * @return a string representing the specified {@code key}'s value stored in {@code Bundle}.
         *         <p>un objeto string que representa el valor del elemento {@code key}
         *         especificado almacenado en {@code Bundle}.</p>
         */
        public static String getLocaleString(String Bundle, String key)
        {
            return getLocaleString(Bundle, key, locale);
        }

        /**
         * Gets the value for a {@code key} in the specified {@code Bundle} with
         * the indicated {@code locale}. <p>Obtiene el valor correspondiente al {@code key}
         * especificado con el objeto {@code locale} indicado.</p>
         * @param Bundle a string specifying the bundle that contains the data to retrieve
         * @param key a string indicating the key name whose value is required
         * @param locale the locale that will be used to retrieve the {@code key} specified
         * @return a string representing the specified {@code key}'s value stored in {@code Bundle}
         *         in the language indicated by {@code locale}.
         *         <p>un objeto string que representa el valor del elemento {@code key}
         *         especificado almacenado en {@code Bundle}.</p>
         */
        public static String getLocaleString(String Bundle, String key, Locale locale)
        {
            return getLocaleString(Bundle, key, locale, null);
        }

        /**
         * Gets the value for a {@code key} in the specified {@code Bundle} with
         * the indicated {@code locale} and class loader. <p>Obtiene el valor correspondiente
         * al {@code key} especificado con los objetos {@code locale} y {@code loader} indicados.</p>
         * @param Bundle a string specifying the bundle that contains the data to retrieve
         * @param key a string indicating the key name whose value is required
         * @param locale the locale that will be used to retrieve the {@code key} specified
         * @param loader the class loader from which the resource bundle is loaded
         * @return a string representing the specified {@code key}'s value stored in {@code Bundle}
         *         in the language indicated by {@code locale}.
         *         <p>un objeto string que representa el valor del elemento {@code key}
         *         especificado almacenado en {@code Bundle}.</p>
         */
        public static String getLocaleString(String Bundle, String key, Locale locale, ClassLoader loader)
        {
            String cad = "";
            try {
                if (loader == null) {
                    cad = java.util.ResourceBundle.getBundle(Bundle, locale).getString(key);
                } else {
                    cad = java.util.ResourceBundle.getBundle(Bundle, locale, loader).getString(key);
                }
            //System.out.println("cad:" + cad);
            } catch (Exception e) {
                log.error("Error while looking for properties key", e);
                return "";
            }
            return cad;
        }

        /**
         * Returns the language which this object is working with.
         * <p>Regresa el lenguaje con el que est&aacute; trabajando este objeto.</p>
         * return the {@code locale} which this object is working with.
         *        <p>el objeto {@code locale} con el que est&aacute; trabajando este objeto.</p>
         */
        public static Locale getLocale() {
            return locale;
        }

        /**
         * Splits a string according to a regular expression which is treated as a
         * delimiter. All the splits and the delimiters found in {@code txt} are stored
         * in an array list which is then returned.
         * <p>Divide un objeto string de acuerdo a una expresi&oacute;n regular que es
         * tratada como delimitador. Todas las divisiones (subcadenas) y los delimitadores
         * encontrados se almacenan en un array list para al final ser devuelto.</p>
         * @param txt a string to be split
         * @param regexp a regular expression used as a delimeter to split {@code txt}
         * @return an array list containing the substrings delimited by {@code regexp}
         *         and all the substrings that complied with {@code regexp}
         *         <p>un objeto array list que contiene las subcadenas delimitadas
         *         por {@code regexp} y todas las subcadenas que cumplen con {@code regexp}.</p>
         */
        //version 1.4
        public static ArrayList regExpSplit(String txt, String regexp) {
            int index = 0;
            ArrayList matchList = new ArrayList();
            java.util.regex.Matcher m = java.util.regex.Pattern.compile(regexp).matcher(txt);

            while (m.find()) {
                String match = txt.substring(index, m.start());
                if (match.length() > 0) {
                    matchList.add(match);
                }
                match = txt.substring(m.start(), m.end());
                if (match.length() > 0) {
                    matchList.add(match);
                }
                index = m.end();
            }

            String match = txt.substring(index, txt.length());
            if (match.length() > 0) {
                matchList.add(match);
            }
            return matchList;
        }

        /**
         * Finds the substrings delimited by two given strings, inside another string.
         * <p>Encuentra las subcadenas delimitadas por dos objetos string dados, dentro
         * de otro objeto string.</p>
         * @param str a string into which the substrings are going to be looked for
         * @param pre a string that precedes the substring to extract from {@code str}
         * @param pos pos a string that goes immediatly after the substring to extract from {@code str}
         * @return an iterator with all the substrings found.
         *         <p>un objeto iterator con todas las subcadenas encontradas.</p>
         */
        public static Iterator<String> findInterStr(String str, String pre, String pos) {
            ArrayList<String> ret = new ArrayList();
            int y = 0;
            do {
                y = findInterStr(str, pre, pos, y, ret);
            } while (y > -1);
            return ret.iterator();
        }

        /**
         * Finds a substring in {@code str} which position must be after {@code index}
         * and is delimited by {@code pre} and {@code pos} strings.
         * The substring found is then stored in {@code arr}.
         * <p>Encuentra una subcadena en {@code str} cuya posici&oacute;n debe ser
         * posterior a {@code index} y es delimitada por las cadenas {@code pre} y {@code pos}.
         * La subcadena encontrada se almacena en {@code arr}.</p>
         * @param str a string from which a substring is going to be extracted
         * @param pre a string that precedes the substring to extract from {@code str}
         * @param pos a string that goes immediatly after the substring to extract from {@code str}
         * @param index the position in {@code str} from which {@code pre} is looked for
         * @param arr the object in which the substring extracted is going to be stored
         * @return the index in {@code str} immediatly after {@code pos}, or -1
         *         if {@code pre} is not found in {@code str}.
         *         <p>El &iacute;ndice en {@code str} inmediatamente despu&eacute;s de
         *         {@code pos}, o -1 si {@code pre} no es encontrado en {@code str}.</p>
         */
        private static int findInterStr(String str, String pre, String pos, int index, ArrayList arr) {
            int i = str.indexOf(pre, index);
            if (i > -1) {
                i = i + pre.length();
                int j = str.indexOf(pos, i);
                if (j > -1) {
                    arr.add(str.substring(i, j));
                    return j + pos.length();
                }
            }
            return -1;
        }

        /**
         * Obtains the day's name corresponding to the number received specifying
         * the day of the week. The first day of the week is Sunday and its day number is zero.
         * <p>Obtiene el nombre del d&iacute;a correspondiente al n&uacute;mero recibido
         * especificando el d&iacute;a de la semana. El primer d&iacute;a de la
         * semana es Domingo y le corresponde el n&uacute;mero cero.</p>
         * @param day the number of the day of the week
         * @param lang a string representing a language for obtaining the corresponding name
         * @return a string representing the name of the day specified.
         *         <p>un objeto string que representa el nombre del d&iacute;a de la
         *         semana especificado.</p>
         */
        public static String getStrDay(int day, String lang) {
            return getLocaleString("locale_date", "day_" + day, new Locale(lang));
        }

        /**
         * Obtains the month's name corresponding to the number received specifying
         * the month of the year. The first month of the year is January and its corresponding number is zero.
         * <p>Obtiene el nombre del mes correspondiente al n&uacute;mero recibido
         * especificando el mes del a&ntilde;o. El primer mes del a&ntilde;o es
         * Enero y le corresponde el n&uacute;mero cero.</p>
         * @param month the number of the month of the year
         * @param lang a string representing a language for obtaining the corresponding name
         * @return a string representing the name of the month specified.
         *         <p>un objeto string que representa el nombre del mes especificado.</p>
         */
        public static String getStrMonth(int month, String lang) {
            return getLocaleString("locale_date", "month_" + month, new Locale(lang));
        }

        /**
         * Converts a given date into a string in the language specified.
         * <p>Convierte un objeto date dado en un objeto string en el lenguaje especificado.</p>
         * @param date a date to be converted
         * @param lang a string representing the language to use in the convertion
         * @return a string representing the date specified writen in the language specified.
         *         <p>un objeto string representando el objeto date especificado, escrito en el
         *         lenguaje especificado.</p>
         */
        public static String getStrDate(Date date, String lang) {
            return getStrDate(date, lang, null);
        }

        /*
         * Da formato a una fecha y la regresa en el lenguaje deseado.
         */
        /**
         * Converts a date into a string with the format and in the language specified.
         * <p>Convierte una fecha en una cadena con el formato y en el lenguaje especificados.</p>
         * @param date a date to convert to a string
         * @param lang a string representing the language of the string to return
         * @param format a string representing the date format to show in the string to return
         * @return a string representing the date received, in the language and with
         *         the format specified.
         *         <p>un objeto string que representa la fecha recibida, en el lenguaje y
         *         con el formato especificados.</p>
         */
        public static String getStrDate(Date date, String lang, String format) {
            String ret = "";
            if (format != null) {
                ret = getStrFormat(date, format, lang);
            } else if (lang != null) {
                if (lang.equalsIgnoreCase("es")) {
                    ret = getStrDay(date.getDay(), lang) + " " + date.getDate() + " de " + getStrMonth(date.getMonth(), lang).toLowerCase() + " de " + (date.getYear() + 1900);
                } else if (lang.equalsIgnoreCase("en")) {
                    ret = getStrDay(date.getDay(), lang) + ", " + getStrMonth(date.getMonth(), lang) + " " + date.getDate() + ", " + (date.getYear() + 1900);
                } else {
                    ret = getStrDay(date.getDay(), lang) + ", " + getStrMonth(date.getMonth(), lang) + " " + date.getDate() + ", " + (date.getYear() + 1900);
                }
            } else {
                ret = date.toLocaleString();
            }
            if (ret == null || ret.length() == 0) {
                ret = date.toLocaleString();
            }
            return ret;
        }

        /**
         * Formats a given {@code date} according to the specified {@code format} and language.
         * The valid patterns for each field in the date, are as follows:<br/>
         *   Day:     DAY, Day, day, dd<br/>
         *   Month:   MONTH, Month, month, mm<br/>
         *   Year:    yyyy, yy<br/>
         *   Hours:   hh<br/>
         *   Minutes: %m<br/>
         *   Seconds: ss
         * <p>Da formato a una fecha proporcionada de acuerdo al patr&oacute;n de formato
         * y lenguaje especificado. Los patrones v&aacute;lidos para cada uno de los campos
         * de la fecha se describen arriba.</p>
         * @param date a date to format
         * @param format a string representing the pattern to use in the convertion
         * @param lang a string representing the language of the string to return
         * @return a string representing the date received expressed in the format
         *         and language specified.
         *         <p>un objeto string que representa la fecha recibida, expresada
         *         en el formato y lenguaje especificados.</p>
         */
        private static String getStrFormat(Date date, String format, String lang) {
            String ret = format;
            ret = replaceAll(ret, "Day", getStrDay(date.getDay(), lang));
            ret = replaceAll(ret, "DAY", getStrDay(date.getDay(), lang).toUpperCase());
            ret = replaceAll(ret, "day", getStrDay(date.getDay(), lang).toLowerCase());
            ret = replaceAll(ret, "dd", dateCeroComp(date.getDate()));
            ret = replaceAll(ret, "Month", getStrMonth(date.getMonth(), lang));
            ret = replaceAll(ret, "MONTH", getStrMonth(date.getMonth(), lang).toUpperCase());
            ret = replaceAll(ret, "month", getStrMonth(date.getMonth(), lang).toLowerCase());
            ret = replaceAll(ret, "mm", dateCeroComp(date.getMonth() + 1));
            ret = replaceAll(ret, "yy", dateCeroComp(date.getYear() - 100));
            ret = replaceAll(ret, "yyyy", dateCeroComp(date.getYear() + 1900));
            ret = replaceAll(ret, "hh", dateCeroComp(date.getHours()));
            ret = replaceAll(ret, "%m", dateCeroComp(date.getMinutes()));
            ret = replaceAll(ret, "ss", dateCeroComp(date.getSeconds()));
            return ret;
        }

        /**
         * Gets the difference in time between one date given and the system date.
         * This difference is expressed in the biggest unit of time possible.
         * These units of time being: seconds, minutes, hours, days, months
         * and years.
         * <p>Obtiene la diferencia en tiempo entre una fecha dada y la fecha del sistema.
         * Esta diferencia se expresa en la unidad de tiempo m&aacute;s grande posible.
         * Las unidades de tiempo manejadas son: segundos, minutos, horas,
         * d&iacute;s, meses y a&ntilde;os.</p>
         * @param CreationDate the date to compare
         * @param lang a string indicating the language in which the date is going to be presented
         * @return a string representing the difference between the date given and
         *         the system's date, expressed in the biggest unit of time possible.
         *         <p>un objeto string que representa la diferencia entre la fecha dada
         *         y la fecha del sistema, expresada en la unidad de tiempo
         *         m&aacute;s grande posible.</p>
         */
        public static String getTimeAgo(Date CreationDate, String lang)
        {
            return getTimeAgo(new Date(), CreationDate, lang);
        }

        /**
         * Gets the difference in time between two dates given. This difference is expressed
         * in the biggest unit of time possible. These units of time being: seconds, minutes,
         * hours, days, months and years.
         * <p>Obtiene la diferencia en tiempo entre dos fechas dadas. Esta diferencia se
         * expresa en la unidad de tiempo m&aacute;s grande posible. Las unidades de
         * tiempo manejadas son: segundos, minutos, horas, d&iacute;s, meses y a&ntilde;os.</p>
         * @param CurrentDate the most recent date to compare
         * @param CreationDate the oldest date to compare
         * @param lang a string indicating the language in which the date is going to be presented
         * @return a string representing the difference between the two dates given,
         *         expressed in the biggest unit of time possible.
         *         <p>un objeto string que representa la diferencia entre dos fechas
         *         dadas, expresada en la unidad de tiempo m&aacute;s grande posible.</p>
         */
        public static String getTimeAgo(Date CurrentDate, Date CreationDate, String lang)
        {
            String ret = "";
            int second;
            int secondCurrent;
            int secondCreation;
            int minute;
            int minuteCurrent;
            int minuteCreation;
            int hour;
            int hourCurrent;
            int hourCreation;
            int day;
            int dayCurrent;
            int dayCreation;
            int month;
            int monthCurrent;
            int monthCreation;
            int year;
            int yearCurrent;
            int yearCreation;
            int dayMonth;

            secondCurrent = CurrentDate.getSeconds();
            secondCreation = CreationDate.getSeconds();
            minuteCurrent = CurrentDate.getMinutes();
            minuteCreation = CreationDate.getMinutes();
            hourCurrent = CurrentDate.getHours();
            hourCreation = CreationDate.getHours();
            dayCurrent = CurrentDate.getDate();
            dayCreation = CreationDate.getDate();
            monthCurrent = CurrentDate.getMonth();
            monthCreation = CreationDate.getMonth();
            yearCurrent = CurrentDate.getYear();
            yearCreation = CreationDate.getYear();

            boolean leapYear = false;
            if (monthCurrent > 1 || (dayCreation == 29 && monthCreation == 1))
                leapYear = (yearCreation % 4 == 0) && (yearCreation % 100 != 0 || yearCreation % 400 == 0);
            dayMonth = 0;
            day = 0;
            switch (monthCreation) {
                case 0:
                    dayMonth = 31;
                    break;
                case 1:
                    if (leapYear) {
                        dayMonth = 29;
                    } else {
                        dayMonth = 28;
                    }
                    break;
                case 2:
                    dayMonth = 31;
                    break;
                case 3:
                    dayMonth = 30;
                    break;
                case 4:
                    dayMonth = 31;
                    break;
                case 5:
                    dayMonth = 30;
                    break;
                case 6:
                    dayMonth = 31;
                    break;
                case 7:
                    dayMonth = 31;
                    break;
                case 8:
                    dayMonth = 30;
                    break;
                case 9:
                    dayMonth = 31;
                    break;
                case 10:
                    dayMonth = 30;
                    break;
                case 11:
                    dayMonth = 31;
                    break;
            }
            if (secondCurrent >= secondCreation) {
                second = secondCurrent - secondCreation;
            } else {
                second = (60 - secondCreation) + secondCurrent;
                minuteCurrent = minuteCurrent - 1;
            }
            if (minuteCurrent >= minuteCreation) {
                minute = minuteCurrent - minuteCreation;
            } else {
                minute = (60 - minuteCreation) + minuteCurrent;
                hourCurrent = hourCurrent - 1;
            }
            if (hourCurrent >= hourCreation) {
                hour = hourCurrent - hourCreation;
            } else {
                hour = (24 - hourCreation) + hourCurrent;
                dayCurrent = dayCurrent - 1;
            }
            if (dayCurrent >= dayCreation) {
                day = day + (dayCurrent - dayCreation);
            } else {
                day = day + ((dayMonth - dayCreation) + dayCurrent);
                monthCurrent = monthCurrent - 1;
            }
            if (monthCurrent >= monthCreation) {
                month = monthCurrent - monthCreation;
            } else {
                month = (12 - monthCreation) + monthCurrent;
                yearCurrent = yearCurrent - 1;
            }

            year = yearCurrent - yearCreation;
            if ("en".equals(lang)) {
                if (year > 0) {
                    ret=(year + " years ago");
                } else if (month > 0) {
                    ret=(month + " month ago");
                } else if (day > 0) {
                    ret=(day + " days ago");
                } else if (hour > 0) {
                    ret=(hour + " hours ago");
                } else if (minute > 0) {
                    ret=(minute + " minutes ago");
                } else {
                    ret=(second + " second ago");
                }
            } else {
                if (year > 0) {
                    ret=(year + " año(s) atrás");
                } else if (month > 0) {
                    ret=(month + " mes(es) atrás");
                } else if (day > 0) {
                    ret=(day + " día(s) atrás");
                } else if (hour > 0) {
                    ret=(hour + " hora(s) atrás");
                } else if (minute > 0) {
                    ret=(minute + " minuto(s) atrás");
                } else {
                    ret=(second + " segundo(s) atrás");
                }
            }
            return ret;
        }

        /**
         * Converts an integer into a string and adds a zero to the left if that
         * integer has only one digit.
         * <p>Convierte un entero en un objeto string y le agrega un cero a la izquierda
         * si ese entero est&aacute; formado por un solo d&iacute;gito.</p>
         * @param num an integer to convert to a string
         * @return a string representing the integer received, with a zero preceding
         *         the integer if it is formed by only one digit.
         *         <p>un objeto string que representa el entero recibido, con un cero
         *         precediendo al valor entero si &eacute;ste est&aacute; formado
         *         solo por un d&iacute;gito.</p>
         */
        private static String dateCeroComp(int num) {
            String ret = "" + num;
            if (ret.length() == 1) {
                ret = "0" + ret;
            }
            return ret;
        }

        /**
         * Finds in {@code path} the query string contained and extracts all the
         * parameters and their corrresponding values. Every parameter has associated
         * an array of strings containing all its values.
         * <p>Encuentra en {@code path} la cadena de consulta contenida y extrae
         * todos los par&aacute;metros y sus valores correspondientes. Cada par&aacute;metro
         * tiene asociado un array de objetos string conteniendo todos sus valores.</p>
         * @param path a string representing a path that contains a query string
         * @return a map that matches every parameter's name with its values.
         *         <p>un objeto map que relaciona el nombre de cada par&aacute;metro
         *         con el conjunto de sus valores almacenados en un array de objetos string.</p>
         */
        public static Map parseQueryParams(String path) {
            Map map = new java.util.HashMap();
            if (path == null) {
                return map;
            }
            int idx = path.indexOf("?");
            String parms = path.substring(idx + 1);
            StringTokenizer st = new StringTokenizer(parms, "&");
            while (st.hasMoreTokens()) {
                String pair = st.nextToken();
                if (pair.indexOf("=") > 0) {
                    String key = pair.substring(0, pair.indexOf("="));
                    String val = pair.substring(pair.indexOf("=") + 1);
                    map.put(key, new String[] {val});
                }
            }
            return map;
        }

        /**
         * Creates a properties object from the file whose name equals the value of
         * the parameter {@code name}.
         * <p>Crea un objeto properties a partir de un archivo cuyo nombre sea el mismo
         * que el valor del par&aacute;metro {@code name}.</p>
         * @param name a string representing the name of the file from which the 
         *             object properties is going to be created.
         * @return a properties object whose name equals the value of the parameter
         *         {@code name}.
         *         <p>un objeto properties cuyo nombre es el mismo que el valor
         *         del par&aacute;metro {@code name}.</p>
         */
        public static Properties getPropertyFile(String name) {
            
            Properties p = null;
            try {
                p = new SWBProperties();
                InputStream in = SWBUtils.class.getResourceAsStream(name);
                try {
                    log.info("-->Loading Property File:"+name);
                    p.load(in);
                } catch (Exception e) {
                    log.error("Error reading property file:"+name,e);
                }
            } catch (Exception e) {
                log.error("Error loading property file:"+name,e);
            }
            return p;
        }

        /**
         * Encodes from {@code str} those characters whose ASCII code is greater than 127.
         * If a character has an ASCII code greater than 127, that character is replaced by
         * {@literal &#[ASCIIcode];} in {@code str}.
         * <p>Codifica aquellos caracteres cuyo c&oacute;digo ASCII es superior a 127 en {@code str}.
         * Si un caracter tiene un c&oacute;digo ASCII superior a 127, ese caracter
         * es reemplazado por {@literal &#[codigoASCII];}</p>
         * @param str a string to be parsed and modified
         * @return a string with those characters whose ASCII code is greater than
         *         127 replaced. If {@code str} is {@code null}, the empty string is returned.
         *         <p>un objeto string con aquellos caracteres cuyo c&oacute;digo ASCII
         *         es superior a 127 reemplazados. Si {@code str} es nulo, regresa cadena vacia.
         */
        public static String encodeExtendedCharacters(String str)
        {
            StringBuffer ret = new StringBuffer();
            if (str != null)
            {
                for (int x = 0; x < str.length(); x++)
                {
                    char ch = str.charAt(x);
                    if (ch > 127) {
                        ret.append("&#" + (int)ch + ";");
                    } else {
                        ret.append(ch);
                    }
                }
            }
            return ret.toString();
        }

        /**
         * Decodes a string like the ones returned by {@link #encodeExtendedCharacters(java.lang.String)}.
         * <p>Decodifica una cadena como las que regresa el m&eacute;todo
         * {@code encodeExtendedCharacters(java.lang.String)}.</p>
         * @param str a string with those characters whose ASCII code is greater than 127
         *            encoded as {@literal &#[ASCIIcode];}
         * @return a string with no characters encoded.
         *         <p>un objeto string sin caracteres codificados como en el objeto original.</p>
         */
        public static String decodeExtendedCharacters(String str)
        {
            StringBuffer ret = new StringBuffer();
            int l = str.length();
            for (int x = 0; x < l; x++)
            {
                char ch = str.charAt(x);
                boolean addch = false;
                if (ch == '&' && (x + 1) < l && str.charAt(x + 1) == '#')
                {
                    int i = str.indexOf(";", x);
                    if (i > 2)
                    {
                        try
                        {
                            int v = Integer.parseInt(str.substring(x + 2, i));
                            if (v > 255)
                            {
                                ret.append((char) v);
                                x = i;
                                addch = true;
                            }
                        } catch (NumberFormatException e) {}
                    }
                }
                if (!addch) ret.append(ch);
            }
            return ret.toString();
        }


        public static String getOfficeFileText(File file) throws InvalidFormatException, OpenXML4JException, XmlException, java.io.IOException {
             POITextExtractor textExtractor = ExtractorFactory.createExtractor(file);
             return textExtractor.getText();
    }

        public String pdfExtractor(File file) throws java.io.IOException {
        FileInputStream is=new FileInputStream(file);
        org.pdfbox.pdmodel.PDDocument pdfDocument = null;
        try {
            pdfDocument = org.pdfbox.pdmodel.PDDocument.load( is );


            if( pdfDocument.isEncrypted() ) {
                //Just try using the default password and move on
                pdfDocument.decrypt( "" );
            }

            //create a writer where to append the text content.
            StringWriter writer = new StringWriter();
            org.pdfbox.util.PDFTextStripper stripper = new org.pdfbox.util.PDFTextStripper();
            stripper.writeText( pdfDocument, writer );

            // Note: the buffer to string operation is costless;
            // the char array value of the writer buffer and the content string
            // is shared as long as the buffer content is not modified, which will
            // not occur here.
            String contents = writer.getBuffer().toString();
            return contents;
        }
        catch( org.pdfbox.exceptions.CryptographyException e ) {
            throw new IOException( "Error decrypting document(" + file.getPath() + "): " + e );
        }
        catch( org.pdfbox.exceptions.InvalidPasswordException e ) {
            //they didn't suppply a password and the default of "" was wrong.
            throw new IOException( "Error: The document(" + file.getPath() + ") is encrypted and will not be indexed." );
        }
        finally {
            if( pdfDocument != null ) {
                pdfDocument.close();
            }
        }
    }

    }

    /**
     * Supplies several I/O functions commonly used, involving streams, files, strings and
     * entire file system structures.
     * <p>Provee varias funciones de E/S utilizadas com&uacute;nmente, involucrando flujos,
     * arhcivos, cadenas y estructuras completas del sistema de archivos.</p>
     */
    public static class IO {


        /**
         * Gets the value for the class variable {@code SWBUtils.bufferSize}.
         * <p>Obtiene el valor de la variable de clase {@code SWBUtils.bufferSize}.</p>
         * @return the integer value for the class variable {@code SWBUtils.bufferSize}.
         *         <p>el valor de la variable de clase {@code SWBUtils.bufferSize}.</p>
         */
        public static int getBufferSize() {
            return bufferSize;
        }

        /**
         * Creates an inputStream from the string received.
         * <p>Crea un objeto inputStream con el contenido del objeto string recibido.</p>
         * @param str a string from which an input stream is created
         * @return the input stream created from the string received.
         *         <p>el objeto inputStream creado a partir del objeto string recibido.</p>
         */
        public static InputStream getStreamFromString(String str) {
            if (str == null) {
                return null;
            }
            return new ByteArrayInputStream(str.getBytes());
        }

        /**
         * Copies an input stream into an output stream using the buffer size
         * defined by {@code SWBUtils.bufferSize} in the reading/writing operations.
         * <p>Copia un flujo de entrada en uno de salida utilizando el tama&ntilde;o
         * de buffer definido por {@code SWBUtils.bufferSize} en las operaciones
         * de lectura/escritura.</p>
         * @param in the input stream to read from
         * @param out the output stream to write to
         * @throws IOException if either the input or the output stream is {@code null}.
         *         <p>Si el flujo de entrada o el de salida es {@code null}.</p>
         */
        public static void copyStream(InputStream in, OutputStream out) throws IOException {
            copyStream(in, out, bufferSize);
        }

        /**
         * Copies an input stream into an output stream using the specified buffer size
         * in the reading/writing operations.
         * <p>Copia un flujo de entrada en uno de salida utilizando el tama&ntilde;o
         * de buffer especificado en las operaciones de lectura/escritura.</p>
         * @param in the input stream to read from
         * @param out the output stream to write to
         * @param bufferSize the number of bytes read/writen at the same time in each I/O operation
         * @throws IOException if either the input or the output stream is {@code null}.
         *         <p>Si el flujo de entrada o el de salida es {@code null}.</p>
         */
        public static void copyStream(InputStream in, OutputStream out, int bufferSize) throws IOException {
            if (in == null) {
                throw new IOException("Input Stream null");
            }
            if (out == null) {
                throw new IOException("Ouput Stream null");
            }
            byte[] bfile = new byte[bufferSize];
            int x;
            while ((x = in.read(bfile, 0, bufferSize)) > -1) {
                out.write(bfile, 0, x);
            }
            in.close();
            out.flush();
            out.close();
        }

        /**
         * Reads an input stream and creates a string with that content.
         * <p>Lee un objeto inputStream y crea un objeto string con el contenido le&iacute;do.</p>
         * @param in an input stream to read its content
         * @return a string whose content is the same as for the input stream read.
         *         <p>un objeto string cuyo contenido es el mismo que el del objeto
         *         inputStream le&iacute;do.</p>
         * @throws IOException if the input stream received is {@code null}.
         *                     <p>Si el objeto inputStream recibido tiene un valor {@code null}.</p>
         */
        public static String readInputStream(InputStream in) throws IOException {
            if (in == null) {
                throw new IOException("Input Stream null");
            }
            StringBuffer buf = new StringBuffer();
            byte[] bfile = new byte[bufferSize];
            int x;
            while ((x = in.read(bfile, 0, bufferSize)) > -1) {
                String aux = new String(bfile, 0, x);
                buf.append(aux);
            }
            in.close();
            return buf.toString();
        }

        /**
         * Reads an input stream and creates a string with the content read using
         * the charset especified by name through {@code enc}.
         * <p>Lee un objeto inputStream y crea una cadena con el contenido le&iacute;do
         * utilizando el conjunto de caracteres especificado por nombre a trav&eacute;s de
         * {@code enc}.
         * @param inp the input stream to read
         * @param enc the charset's name to use for representing the input stream's content
         * @return a string representing the input stream's content with the charset
         *         specified.
         *         <p>un objeto string que representa el contenido del objeto inputStream
         *         con el conjunto de caracteres especificado.</p>
         * @throws java.io.UnsupportedEncodingException if {@code enc} is {@code null}.
         *         <p>si el valor de {@code enc} es {@code null}.</p>
         * @throws java.io.IOException if {@code inp} is {@code null}.
         *         <p>si el valor de {@code inp} es {@code null}.</p>
         */
        public static String readInputStream(InputStream inp, String enc)
                throws java.io.UnsupportedEncodingException, java.io.IOException {

            if (inp == null) {
                throw new IOException("Input Stream null");
            }
            if (enc == null) {
                throw new UnsupportedEncodingException("Encoding null");
            }
            InputStreamReader in = new InputStreamReader(inp, enc);

            StringBuffer ret = new StringBuffer();

            char[] bfile = new char[bufferSize];
            int x;
            while ((x = in.read(bfile, 0, bufferSize)) > -1) {
                ret.append(new String(bfile, 0, x));
            }
            in.close();
            return ret.toString();
        }

        /**
         * Normalizes the {@code path} received. Substitutes the following characters:<br/>
         * <quote> \ </quote> for <quote>/</quote><br/>
         * <quote> \\ </quote> for <quote>/</quote><br/>
         * <quote> // </quote> for <quote>/</quote><br/>
         * <quote> /./ </quote> for <quote>/</quote><br/>
         * and removes any relative path.
         * <p>Normaliza la ruta descrita por {@code path}. Sustituyendo algunos
         * caracteres como se describe arriba y eliminando las rutas relativas encontradas.
         * @param path a string representing a path
         * @return a string representing the path received normalized according to
         *         the rules described above.
         *         <p>un objeto string que representa la ruta recibida, normalizada de
         *         acuerdo a las reglas descritas anteriormente.</p>
         */
        public static String normalizePath(String path) {

            if (path == null) {
                return null;
            }
            String normalized = path;
            if (normalized.equals("/.")) {
                return "/";
            }
            if (normalized.indexOf('\\') >= 0) {
                normalized = normalized.replace('\\', '/');
            }
            if (!normalized.startsWith("/") && normalized.indexOf(':') < 0) {
                normalized = "/" + normalized;
            }
            do {
                int index = normalized.indexOf("//");
                if (index < 0) {
                    break;
                }
                normalized = normalized.substring(0, index) + normalized.substring(index + 1);
            } while (true);
            do {
                int index = normalized.indexOf("/./");
                if (index < 0) {
                    break;
                }
                normalized = normalized.substring(0, index) + normalized.substring(index + 2);
            } while (true);
            do {
                int index = normalized.indexOf("/../");
                if (index >= 0) {
                    if (index == 0) {
                        return null;
                    }
                    int index2 = normalized.lastIndexOf('/', index - 1);
                    normalized = normalized.substring(0, index2) + normalized.substring(index + 3);
                } else {
                    return normalized;
                }
            } while (true);
        }

        /**
         * Deletes from file system the directory (with all its files and subdirectories)
         * whose {@code path} is specified.
         * <p>Elimina del sistema de archivos, el directorio (con todos sus archivos
         * y subdirectorios) cuya ruta es especificada por {@code path}.</p>
         * @param path a string representing the directory's path
         * @return a {@code boolean} indicating wheather the directory was eliminated or not.
         *         <p>un booleano indicando si el directorio fue eliminado o no.</p>
         */
        public static boolean removeDirectory(String path) {
            try {
                File dir = new File(path);
                if (dir != null && dir.exists() && dir.isDirectory()) {
                    File[] listado = dir.listFiles();
                    for (int i = 0; i < listado.length; i++) {
                        if (listado[i].isFile()) {
                            listado[i].delete();
                        }
                        if (listado[i].isDirectory()) {
                            path = listado[i].getPath();
                            boolean flag = removeDirectory(path);
                            if (flag) {
                                listado[i].delete();
                            }
                        }
                    }
                }
                if (dir.isDirectory() && dir.delete()) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        /**
         * Reads the file corresponding to the {@code path} specified.
         * <p>Lee el archivo correspondiente a la ruta especificada por {@code path}.</p>
         * @param path a string representing the path of the file to read.
         * @return a string with the file's content read.
         *         <p>un objeto string con el contenido del archivo le&iacute;do</p>
         */
        public static String getFileFromPath(String path) {
            StringBuffer ret = new StringBuffer(bufferSize);
            try {
                InputStream file = null;
                file = new FileInputStream(path);
                byte[] bfile = new byte[bufferSize];
                int x;
                while ((x = file.read(bfile, 0, bufferSize)) > -1) {
                    ret.append(new String(bfile, 0, x));
                }
                file.close();
            } catch (Exception e) {
            }
            return ret.toString();
        }

        /**
         * Calculates the number of bytes occupied by the abstract pathname specified.
         * If the pathname corresponds to a directory, the size of each file the directory
         * contains its considered and added to the result.
         * <p>Calcula el n&uacute;mero de bytes ocupados por la ruta abstracta especificada.
         * Si la ruta corresponde a un directorio, se considera el tama&ntilde;o de
         * cada archivo que contiene el directorio y se agrega al resultado.</p>
         * @param path a string representing the abstract pathname
         * @return a {@code long} value representing (in bytes) the length of the file, or the
         *         size of the directory represented by the pathname received.
         *         <p>un valor {@code long} que representa (en bytes) la longitud del archivo,
         *         o el tama&ntilde;o del directorio representado por la ruta recibida.</p>
         * @throws NullPointerException if the pathname received is {@code null}.
         *         <p>si la ruta recibida es {@code null}.</p>
         */
        public static long getFileSize(String path)
        {
            return getFileSize(new File(path));
        }

        /**
         * Calculates the number of bytes occupied by the file or directory specified.
         * If it's a directory, the size of each file the directory
         * contains its considered and added to the result.
         * <p>Calcula el n&uacute;mero de bytes ocupados por el archivo o directorio especificado.
         * Si la ruta corresponde a un directorio, se considera el tama&ntilde;o de
         * cada archivo que contiene el directorio y se agrega al resultado.</p>
         * @param file a file representing an abstract pathname
         * @return a {@code long} value representing (in bytes) the length of the file, or the
         *         size of the directory represented by the pathname received.
         *         <p>un valor {@code long} que representa (en bytes) la longitud del archivo,
         *         o el tama&ntilde;o del directorio representado por la ruta recibida.</p>
         * @throws NullPointerException if the {@code file} received is {@code null}.
         *         <p>si el objeto {@code file} recibido es {@code null}.</p>
         */
        public static long getFileSize(File file)
        {
            long ret = 0;
            if (file.isFile()) ret = file.length();
            else if (file.isDirectory())
            {
                File files[] = file.listFiles();
                for (int x = 0; x < files.length; x++)
                {
                    File ch = files[x];
                    ret += getFileSize(ch);
                }
            }
            return ret;
        }

        /**
         * Creates a directory in the specified pathname.
         * <p>Crea un directorio en el nombre de ruta especificado</p>
         * @param path a string representing the pathname in which the new directory
         *        will reside. If this parameter's value is {@code null} the directory
         *        won't be created.
         * @return a {@code boolean} indicating wheather the directory was crated or not.
         *         <p>un valor booleano indicando si el directorio fue creado o no.</p>
         */
        public static boolean createDirectory(String path) {
            try {
                File f = new File(path);
                if (!f.exists()) {
                    f.mkdirs();
                }
                return true;
            } catch (Exception e) {
                log.error(e);
            }
            return false;
        }

        /**
         * Creates a copy of the given pathname's file system substructure. The origen
         * pathname ({@code source}) must represent a directory's path in the file system.
         * <p>Crea una copia de la subestructura del sistema de archivos de la ruta dada.
         * La ruta de origen ({@code source}) debe representar la ruta de un directorio
         * en el sistema de archivos.</p>
         * @param source pathname of the directory to copy. Must not be null.
         * @param target pathname of the new directory where file system's substructure
         *               will be copied. Must not be null.
         * @return a {@code boolean} indicating if the source directory was copied succefully or not.
         *         <p>un valor booleano indicando si el directorio fuente fue copiado exitosamente o no.</p>
         */
        public static boolean copyStructure(String source, String target) {
            try {
                copyStructure(source, target, false, "", "");
                return true;
            } catch (Exception e) {
                log.error(e);
            }
            return false;
        }

        /**
         * Creates a copy of the given pathname's file system substructure and replaces
         * a specified path located within the files of that substructure. The origen
         * pathname ({@code source}) must represent a directory's path in the file system.
         * <p>Crea una copia de la subestructura del sistema de archivos de la ruta dada y
         * reemplaza una ruta especificada por {@code sourcePath} en el contenido de los
         * archivos a copiar. La ruta de origen ({@code source}) debe representar la
         * ruta de un directorio en el sistema de archivos.</p>
         * @param source pathname of the directory to copy. Must not be null.
         * @param target pathname of the new directory where file system's substructure
         *               will be copied. Must not be null.
         * @param ChangePath a {@code boolean} that indicates if the files' content
         *               will be parsed. Must not be null.
         * @param sourcePath a pathname string located in the source files to be
         *               replaced by {@code targetPath}. Must not be null.
         * @param targetPath the pathname string to write in the target files in replacement of {@code sourcePath}
         * @return a {@code boolean} indicating if the source directory was copied succefully or not.
         *         <p>un valor booleano indicando si el directorio fuente fue copiado exitosamente o no.</p>
         */
        public static boolean copyStructure(String source, String target,
                boolean ChangePath, String sourcePath, String targetPath) {
            try {
                File ftarget = new File(target);
                if (!ftarget.exists()) {
                    ftarget.mkdirs();
                }
                File dir = new File(source);
                if (dir != null && dir.exists() && dir.isDirectory()) {
                    File[] listado = dir.listFiles();
                    for (int i = 0; i < listado.length; i++) {
                        try {
                            if (listado[i].isFile()) {
                                File targetFile = new File(target + listado[i].getName());
                                if (targetFile.length() == 0) {
                                    copy(source + listado[i].getName(), target + listado[i].getName(), ChangePath, sourcePath, targetPath);
                                }
                            }
                            if (listado[i].isDirectory()) {
                                String newpath = listado[i].getPath();
                                File f = new File(target + listado[i].getName());
                                f.mkdirs();
                                boolean flag = copyStructure(newpath + "/", target + listado[i].getName() + "/", ChangePath, sourcePath, targetPath);
                                if (flag) {
                                    listado[i].delete();
                                }
                            }
                        } catch (Exception e) {
                            log.error(e);
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e);
                return false;
            }
            return true;
        }

        /**
         * Copies a file to another directory, modifying a path in its content.
         * If indicated through {@code ChangePath} the string represented by
         * {@code sourcePath} is looked for in the file's content and replaced by
         * {@code targetPath}, only if the file to copy has an extension like: {@literal html},
         * {@literal html}, {@literal htm.orig} or {@literal html.orig}.
         * <p>Copia un archivo a otro directorio, modificando una ruta en su contenido.
         * Si se indica a trav&eacute;s de {@code ChangePath} el objeto string representado
         * en {@code sourcePath} se busca en el contenido del archivo y se reemplaza por
         * el representado en {@code targetPath}, solo si el archivo a copiar tiene
         * por extensi&oacute;n: {@literal html}, {@literal html}, {@literal htm.orig}
         * o {@literal html.orig}.</p>
         * @param source_name pathname of the file to copy. Must not be null.
         * @param dest_name pathname of the new location of the file to copy. Must not be null.
         * @param ChangePath a {@code boolean} indicating if the file will be parsed to modify its content
         * @param sourcePath a pathname string in the source file to be replaced
         * @param targetPath a pathname string that will replace {@code sourcePath}
         */
        public static void copy(String source_name, String dest_name, 
                boolean ChangePath, String sourcePath, String targetPath)
                throws IOException {

            File source_file = new File(source_name);
            File destination_file = new File(dest_name);
            FileInputStream source = null;
            java.io.FileOutputStream destination = null;

            try {
                source = new FileInputStream(source_file);
                destination = new FileOutputStream(destination_file);
                if (ChangePath && (source_file.getName().endsWith(".htm") || 
                                   source_file.getName().endsWith(".html") ||
                                   source_file.getName().endsWith(".html.orig") ||
                                   source_file.getName().endsWith(".htm.orig"))) {
                    String content = readInputStream(source);
                    content = content.replaceAll(sourcePath, targetPath);
                    copyStream(getStreamFromString(content), destination);
                } else {
                    copyStream(source, destination);
                }
            } catch (Exception e) {
                log.error(e);
            } finally {
                if (source != null) {
                    try {
                        source.close();
                    } catch (IOException e) {
                    }
                }
                if (destination != null) {
                    try {
                        destination.close();
                    } catch (IOException e) {
                    }
                }
            }
        }

        /**
         * Decodes the hexadecimal formatted string received and deserializes the result
         * to create an object.
         * <p>Decodifica el objeto string con formato hexadecimal recibido y deserealiza
         * el resultado para crear un objeto.</p>
         * @param txt a hexadecimal formatted string representing an object's state
         * @return a deserialized object
         *         <p>un objeto deserializado</p>
         * @throws IOException if an I/O error occurs while reading stream header
         *         <p>si un error de E/S ocurre mientras se lee el encabezado del objeto stream</p>
         * @throws ClassNotFoundException if the Class of a serialized object cannot be found
         *         <p>si la clase de un objeto serializado no puede encontrarse</p>
         */
        public static Object decodeObject(String txt) throws IOException, ClassNotFoundException {
            byte arr[] = new byte[txt.length() / 2];
            for (int x = 0; x < txt.length(); x += 2) {
                String val = txt.substring(x, x + 2);
                int v = Integer.decode("0x" + val).intValue();
                if (v > 127) {
                    v = v - 256;
                }
                arr[x / 2] = (byte) (v);
            }
            java.io.ObjectInputStream s = new java.io.ObjectInputStream(new ByteArrayInputStream(arr));
            Object obj = s.readObject();
            return obj;
        }

        /**
         * Serializes the object received and generates a hexadecimal formatted
         * string with the object's state.
         * <p>Serializa el objeto recibido y genera un objeto string con el estado del
         * objeto en formato hexadecimal.</p>
         * @param obj an object to serialize
         * @return a hexadecimal formatted string representing the received object's state
         *         <p>un objeto string con formato hexadecimal que representa el
         *         estado del objeto recibido.</p>
         * @throws IOException if any I/O problem occurs while serializing the object.
         *         <p>si cualquier problema de E/S ocurre mientras se serializa el
         *         objeto.</p>
         */
        public static String encodeObject(Object obj) throws IOException {
            ByteArrayOutputStream f = new ByteArrayOutputStream();
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject(obj);
            s.flush();
            s.close();
            byte arr[] = f.toByteArray();
            String hex = "";
            for (int x = 0; x < arr.length; x++) {
                int v = arr[x];
                if (v < 0) {
                    v = 256 + v;
                }
                String val = Integer.toHexString(v);
                if (val.length() == 1) {
                    val = "0" + val;
                }
                hex += val;
            }
            return hex;
        }

        /*
         * Reads a file and stores the content in an array of bytes.
         * <p>Lee un archivo y almacena el contenido en un arreglo de bytes</p>
         * @param file the {@code file} to read. Must not be {@code null}
         * @return an array of bytes that stores the content of the file specified.
         *         <p>un arreglo de bytes que almecena el contenido del archivo especificado.</p>
         * @throws java.io.FileNotFoundException if the specified file does not exists.
         *         <p>si el archivo especificado no existe.</p>
         * @throws java.io.IOException if an I/O error occurs while reading the file's content.
         *         <p>si un error de E/S ocurre durante la lectura del contenido del archivo.</p>
         */
        public static byte[] readFile(File file) throws FileNotFoundException, IOException {
            if (!file.exists()) {
                throw new FileNotFoundException("File Not Found...");
            }
            FileInputStream in = new FileInputStream(file);
            if (in == null) {
                throw new FileNotFoundException("File Not Found...");
            }

            int len = (int) file.length();

            byte[] bfile = new byte[len];
            int x = 0;
            int y = 0;
            while ((x = in.read(bfile, y, len - y)) > -1) {
                y += x;
                if (y == len) {
                    break;
                }
            }
            in.close();
            return bfile;
        }

        /**
         * Extracts the files included in an HTTP request and stores them in the pathname
         * indicated.
         * <p>Extrae los archivos incluidos en una petici&oacute;n HTTP y los almacena
         * en la ruta especificada.</p>
         * @param request an HTTP request that contains the files to store.
         * @param path2Save the string representing the pathname where the files are to be stored
         * @return an iterator containing the file items detected in the HTTP request.
         *         <p>un objeto iterador que contiene los archivos detectados en la
         *         petici&oacute;n HTTP.</p>
         */
        public static Iterator<FileItem> fileUpload(javax.servlet.http.HttpServletRequest request,
                String path2Save) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fu = new ServletFileUpload(factory);
            java.util.List items = null;
            try {
                items = fu.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            if (items != null && path2Save == null) {
                Iterator<FileItem> iter = items.iterator();
                return iter;
            } else if (items != null && path2Save != null) {
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    //Si No es un campo de forma comun, es un campo tipo file, grabarlo
                    if (!item.isFormField()) {
                        File fichero = new File(path2Save + item.getName());
                        try {
                            item.write(fichero);
                        } catch (Exception e) {
                            log.error(e);
                        }
                    }
                }
                return iter;
            }
            return null;
        }

        /**
         * Logs the message indicated in {@code msg} into the {@code filePath} received.
         * <p>Registra el mensaje indicado en {@code msg} dentro del archivo definido 
         * por la ruta recibida en {@code filePath}.</p>
         * @param pathFile a string representing a file path to register the message.
         *        Must not be {@code null}.
         * @param msg a string containing the message to register
         * @throws java.io.IOException if an I/O error occurs, which is possible
         *         because the construction of the canonical pathname may require
         *         filesystem queries or while writing the message into the file.
         *         <p>si un error de E/S ocurre, lo que es posible debido a que la
         *         construcci&oacute;n de la ruta de archivo can&oacute;nica puede
         *         requerir consultas del sistema de archivos o que ocurra durante
         *         la escritura del mensaje en el archivo.</p>
         * @throws NullPointerException if the pathname argument is {@code null}.
         *         <p>si el argumento de la ruta del archivo es {@code null}.</p>
         */
        public static void log2File(String filePath, String msg) throws IOException {
            String path = null;
            int pos = filePath.lastIndexOf("/");
            if (pos > -1) {
                path = filePath.substring(0, pos - 1);
            }
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            String logFile = new File(filePath).getCanonicalPath().replace('\\', '/');
            log2File = new PrintWriter(new FileWriter(logFile, true), true);
            log2File.println(msg);
        }

        /**
         * Compress a directory's content into the zip output stream indicated.
         * <p>Comprime el contenido de un directorio en el objeto zip output stream indicado.</p>
         * @param directory the {@code file} denoting the directory to compress.
         *        If it is {@code null} or non-existent, no operation is done.
         * @param base the {@code file} denoting the directory base whose path is
         *        treated as the base path for the files contained in the zip output stream.
         * @param zos the zip output stream to contain the directory's content
         * @throws java.io.IOException if there is any I/O error during: ZIP formatting,
         *         file inclusion in the zip output stream, data writing in the zip
         *         output stream or closure of the streams used to read or to write data.
         *         <p>si hay alg&uacute;n error de E/S durante: el formato en zip
         *         de la informaci&oacute;n, la inclusi&oacute;n en el objeto {@code zip
         *         output stream}; o el cierre de los flujos utilizados para para leer o
         *         escribir informaci&oacute;n.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static final void zip(File directory, File base, ZipOutputStream zos) throws IOException {
            if (directory == null || !directory.exists()) {
                return;
            }
            byte[] buffer = new byte[SWBUtils.bufferSize];
            int read = 0;
            File[] files = directory.listFiles();
            for (int i = 0, n = files.length; i < n; i++) {
                if (files[i].isDirectory()) {
                    zip(files[i], base, zos);
                } else {
                    FileInputStream in = new FileInputStream(files[i]);
                    ZipEntry entry = new ZipEntry(files[i].getPath().substring(base.getPath().length() + 1));
                    zos.putNextEntry(entry);
                    while (-1 != (read = in.read(buffer))) {
                        zos.write(buffer, 0, read);
                    }
                    zos.closeEntry();
                    in.close();
                }
            }
        }

        /**
         * Adds the files received to the specified zip file.
         * <p>Agrega los archivos recibidos al archivo comprimido especificado.</p>
         * @param zipFile a compressed file to include some files at
         * @param files an array of files that will be added to {@code zipFile}
         * @throws java.io.IOException if some I/O error occurs during data reading
         *         or writing.
         *         <p>si alg&uacute;n error de E/S ocurre durante la lectura o
         *         escritura de informaci&oacute;n.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static void addFilesToExistingZip(File zipFile, File[] files) throws IOException {
            // get a temp file
            //MAPS74 En Solaris no se vale renombrar un archivo hacia /var/tmp
            File tempFile = File.createTempFile(zipFile.getName(), null, zipFile.getParentFile());
            // delete it, otherwise you cannot rename your existing zip to it.
            tempFile.delete();

            boolean renameOk = zipFile.renameTo(tempFile);
            if (!renameOk) {
                throw new RuntimeException("could not rename the file " 
                        + zipFile.getAbsolutePath() + " to "
                        + tempFile.getAbsolutePath());
            }
            byte[] buf = new byte[1024];

            ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));

            ZipEntry entry = zin.getNextEntry();
            while (entry != null) {
                String name = entry.getName();
                boolean notInFiles = true;
                for (File f : files) {
                    if (f.getName().equals(name)) {
                        notInFiles = false;
                        break;
                    }
                }
                if (notInFiles) {
                    // Add ZIP entry to output stream.
                    out.putNextEntry(new ZipEntry(name));
                    // Transfer bytes from the ZIP file to the output file
                    int len;
                    while ((len = zin.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                }
                entry = zin.getNextEntry();
            }
            // Close the streams		
            zin.close();
            // Compress the files
            for (int i = 0; i < files.length; i++) {
                InputStream in = new FileInputStream(files[i]);
                // Add ZIP entry to output stream.
                out.putNextEntry(new ZipEntry(files[i].getName()));
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                // Complete the entry
                out.closeEntry();
                in.close();
            }
            // Complete the ZIP file
            out.close();
            tempFile.delete();
        }

        /**
         * Unzips a zipped file to a specific directory.
         * <p>Descomprime un archivo comprimido en un directorio espec&iacute;fico.</p>
         * @param zip a zipped file
         * @param extractTo a file that denotes a directory path
         * @throws java.io.IOException if an I/O error occurs during reading or writing data.
         *         <p>si un error ocurre durante la lectura o escritura de informaci&oacute;n.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static final void unzip(File zip, File extractTo) throws IOException {
            unzip(zip, extractTo, new ArrayList(), null, null);
        }

        /**
         * Unzips a zipped file to a specific directory with the option of replacing
         * a string in those files whose names end with specified extensions.
         * <p>Descomprime un archivo comprimido a un directorio espec&iacute;fico
         * con la opci&oacute;n de reemplazar una cadena en aquellos archivos
         * cuyos nombres tengan las extensiones especificadas.</p>
         * @param zip the zipped file to unzip
         * @param extractTo the directory in which the file will be unzipped
         * @param fext2parse list of the file extensions to consider for replacing a string in file's content
         * @param parse a string to look for in the file's content
         * @param parse2 a string that will replace {@code parse} in file's content
         * @throws java.io.IOException if an I/O error occurs during reading or writing data.
         *         <p>si un error ocurre durante la lectura o escritura de informaci&oacute;n.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static final void unzip(File zip, File extractTo, ArrayList fext2parse, String parse, String parse2) throws IOException {
            ZipFile archive = new ZipFile(zip);
            Enumeration e = archive.entries();
            while (e.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) e.nextElement();
                File file = new File(extractTo, TEXT.replaceAll(entry.getName(),"\\", "/")); //TODO:Pienso que con esto se soluciona el problema de creación de rutas en linux
                //File file = new File(extractTo, entry.getName());
                if (entry.isDirectory() && !file.exists()) {
                    file.mkdirs();
                } else {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    InputStream in = archive.getInputStream(entry);
                    //Parse file content
                    if (!fext2parse.isEmpty()) {
                        String ext = null;
                        int pos = file.getName().lastIndexOf(".");
                        if (pos > -1) {
                            ext = file.getName().substring(pos + 1);
                        }
                        if (fext2parse.contains(ext)) {
                            String content = readInputStream(in);
                            content = content.replaceAll(parse, parse2);
                            in=getStreamFromString(content);
                        }
                    }

                    //Writes content
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        copyStream(in, out);
                        out.close();
                        in.close();
                    } catch (Exception ex) {
                        log.debug(ex);
                    }
                }
            }
            archive.close();
        }

        /**
         * Reads a zipped file's content and returns all files in an {@link java.util.Iterator}
         * <p>Lee el contenido de un archivo comprimido y regresa todos los archivos
         * en un {@code java.util.Iterator}</p>
         * @param zipName a string representing the name of the zipped file to read
         * @return an {@code java.util.Iterator} containing all the entries (files)
         *         in the zipped file specified.
         *         <p>un objeto {@code java.util.Iterator} que contiene todas las
         *         entradas (archivos) contenidas en el archivo comprimido.</p>
         */
        public static final Iterator<ZipEntry> readZip(String zipName) {
            ArrayList itFiles = new ArrayList();
            ZipFile zf = null;
            try {
                zf = new ZipFile(zipName);
                java.util.Enumeration enu = zf.entries();
                while (enu.hasMoreElements()) {
                    ZipEntry zen = (ZipEntry) enu.nextElement();
                    if (zen.isDirectory()) {
                        continue;
                    } else {
                        itFiles.add(zen);
                    }
                }
            } catch (Exception ex) {
                log.error(ex); //MAPS74
            } finally {
                if (zf != null) {
                    try {
                        zf.close();
                    } catch (Exception ex1) {
                    }
                }
            }
            return itFiles.iterator();
        }

        /**
         * Reads a specific file contained in a zipped file.
         * <p>Lee un archivo espec&iacute;fico contenido en un archivo comprimido.</p>
         * @param zipName a string representing the pathname of a zipped file
         * @param file2Read a string representing the pathname of a file inside the zipped file
         * @return a string with the specified file's content.
         *         <p>un objeto string con el contenido del archivo especificado.</p>
         * @author Jorge Jim&eacute;nez
         */
        public static final String readFileFromZipAsString(String zipName, String file2Read) {
            String content = null;
            try {
                ZipFile zip = new ZipFile(new File(zipName));
                for (Enumeration e = zip.entries(); e.hasMoreElements();) {
                    ZipEntry entry = (ZipEntry) e.nextElement();
                    if (entry.getName() != null && entry.getName().equals(file2Read)) {
                        InputStream is = zip.getInputStream(entry);
                        content=readInputStream(is);
                    }
                }
            } catch (Exception e) {
                log.debug(e);
            }
            return content;
        }
    }


    /**
     * Supplies several functions commonly used for sending e-mails.
     * <p>Provee varias funciones para env&iacute;o de correos electr&oacute;nicos
     * utilizadas com&uacute;nmente.</p>
     * @author Jorge Jim&eacute;nez
     */
    public static class EMAIL {


        /**
         * Represents the domain name or IP addres for the SMTP server to use.
         * <p>Reresenta el nombre de dominio o direcci&oacute;n IP del servidor
         * SMTP a usar.</p>
         */
        private static String smtpserver = null;

        /**
         * Represents the user name registered in the SMTP server for sending messages.
         * <p>Representa el nombre de usuario registrado en el servidor SMTP para
         * enviar mensajes.</p>
         */
        private static String smtpuser = null;

        /**
         * Represents the user's password registered in the SMTP server for sending messages.
         * <p>Representa la contrase&ntilde;a del usuario registrada en el servidor
         * SMTP para enviar mensajes.</p>
         */
        private static String smtppassword = null;

        /**
         * Represents the e-mail account designated to receive e-mail communications.
         * <p>Representa la cuenta de correo designada para recibir las comunicaciones
         * por correo electr&oacute;nico.</p>
         */
        private static String adminEmail = null;

        /**
         * Sets the domain name or IP address for the SMTP server to use.
         * <p>Fija el nombre de dominio o la direcci&oacute;n IP del servidor
         * SMTP a usar.</p>
         * @param smtpserver a string representing the domain name or the IP address
         *        for the SMTP server.
         *        <p>un objeto string que representa el nombre de dominio o la direcci&oacute;n
         *        IP del servidor SMTP.</p>
         */
        public static void setSMTPServer(String smtpserver) {
            EMAIL.smtpserver = smtpserver;
        }

        /**
         * Gets the domain name or IP address for the SMTP server in use.
         * <p>Obtiene el nombre de dominio o la direcci&oacute;n IP del servidor
         * SMTP en uso.</p>
         * @return a string representing the domain name or IP address for the SMTP
         *         server in use.
         *         <p>un objeto string que representa el nombre de dominio o la
         *         direcci&oacute;n IP del servidor SMTP en uso.</p>
         */
        public static String getSMTPServer() {
            return EMAIL.smtpserver;
        }

        /**
         * Sets an e-mail account to generate e-mail messages.
         * <p>Fija una cuenta de correo para generar mensajes de correo electr&oacute;nico.</p>
         * @param adminEmail a string representing a valid e-mail account.
         *        <p>un objeto string que representa una cuenta de correo electr&oacute;nico
         *        v&aacute;lida.</p>
         */
        public static void setAdminEmail(String adminEmail) {
            EMAIL.adminEmail = adminEmail;
        }

        /**
         * Sends an e-mail with the information supplied. The e-mail body can be
         * formatted as HTML or plain text.
         * <p>Env&iacute;a un correo electr&oacute;nico con la informaci&oacute;n
         * proporcionada. El cuerpo del correo puede ser enviado en formato HTML
         * o en texto plano.</p>
         * @param fromEmail a string representing the sender's e-mail account.
         *        Must be a valid e-mail account, otherwise the mail will not be sent.
         * @param fromName  a string representing the sender's name
         * @param address   a collection of the recipients' e-mail accounts. Every
         *        element in the collection is expected to be a valid {@link java.mail.internet.InternetAddress}.
         *        Must not be null, otherwise the mail will not be sent.
         * @param ccEmail   a collection of e-mail accounts to send the email as a copy. Every
         *        element in the collection is expected to be a valid {@literal java.mail.internet.InternetAddress}.
         *        If it is {@code null}, the mail won't be sent as a carbon copy to anyone.
         * @param bccEmail  a collection of e-mail accounts to send the email as a blind carbon copy. Every
         *        element in the collection is expected to be a valid {@literal java.mail.internet.InternetAddress}.
         *        If it is {@code null}, the mail won't be sent as a blind carbon copy to anyone.
         * @param subject   a string indicating the e-mail's subject
         * @param contentType a string indicating the content type of the mail. {@literal HTML}
         *        indicates the body has an HTML format, otherwise it will be send
         *        in text plain format. Must not be {@code null}.
         * @param data      a string containing the e-mail body's text
         * @param login     a string representing a login name for SMTP server
         *        authentication. If it is {@code null} authentication will not be performed.
         * @param password  a string representing a password for SMTP server
         *        authentication. If it is {@code null} authentication will not be performed.
         * @param attachments a list containing all the attachments for the e-mail. Every
         *        element in the collection is expected to be of type {@literal org.apache.commons.mail.EmailAttachment}.
         * @return a string that at the moment of writing this documentation is
         *         equal to {@code null}.
         *         <p>un objeto string que al momento de escribir esta documentaci&oacute;n
         *         es igual a {@code null}.</p>
         */
        public static String sendMail(String fromEmail, String fromName, 
                Collection address, Collection ccEmail, Collection bccEmail,
                String subject, String contentType, String data, String login, 
                String password, ArrayList<EmailAttachment> attachments) {

            try {
                HtmlEmail email = new HtmlEmail();

                if (attachments != null && attachments.size() > 0) {
                    Iterator itAttaches = attachments.iterator();
                    while (itAttaches.hasNext()) {
                        EmailAttachment attchment = (EmailAttachment) itAttaches.next();
                        email.attach(attchment);
                    }
                }

                email.setHostName(EMAIL.smtpserver);
                email.setFrom(fromEmail, fromName);
                email.setTo(address);
                if (ccEmail != null) {
                    email.setCc(ccEmail);
                }
                if (bccEmail != null) {
                    email.setBcc(bccEmail);
                }
                email.setSubject(subject);

                if (contentType.equalsIgnoreCase("HTML")) {
                    email.setHtmlMsg(data); // set the html message

                } else {
                    email.setMsg(data);
                }

                if (login != null && password != null) {
                    email.setAuthentication(login, password);
                }
                return email.send();
            } catch (Exception e) {
                log.error(e);
            }
            return null;
        }

        /**
         * Sends an e-mail with the information supplied through {@code message}.
         * The e-mail body can be formatted as HTML or plain text.
         * <p>Env&iacute;a un correo electr&oacute;nico con la informaci&oacute;n
         * proporcionada a trav&eacute;s de {@code message}. El cuerpo del correo
         * puede ser enviado en formato HTML o en texto plano.</p>
         * @param message an object of type {@link org.semanticwb.base.util.SWBMail}
         * @return a string that at the moment of writing this documentation is
         *         equal to {@code null}.
         *         <p>un objeto string que al momento de escribir esta documentaci&oacute;n
         *         es igual a {@code null}.</p>
         * @throws java.net.SocketException
         */
        public static String sendMail(SWBMail message) throws java.net.SocketException {
            try {
                HtmlEmail email = new HtmlEmail();

                Iterator itAttaches = message.getAttachments().iterator();
                while (itAttaches.hasNext()) {
                    EmailAttachment attchment = (EmailAttachment) itAttaches.next();
                    email.attach(attchment);
                }

                email.setHostName(EMAIL.smtpserver);
                email.setFrom(message.getFromEmail(), message.getFromName());
                email.setTo(message.getAddresses());
                if (message.getCcEmail() != null) {
                    email.setCc(message.getCcEmail());
                }
                if (message.getBccEmail() != null) {
                    email.setBcc(message.getBccEmail());
                }
                email.setSubject(message.getSubject());

                if (message.getContentType().equalsIgnoreCase("HTML")) {
                    email.setHtmlMsg(message.getData()); // set the html message
                } else {
                    email.setMsg(message.getData());
                }

                if (message.getLogin() != null && message.getPassword() != null) {
                    email.setAuthentication(message.getLogin(), message.getPassword());
                }
                return email.send();
            } catch (Exception e) {
                log.error(e);
            }
            return null;
        }

        /**
         * Sends an e-mail in background mode with the sender address as the one
         * set in {@code EMAIL.adminEmail}.
         * <p>Env&iacute;a un correo electr&oacute;nico en segundo plano con la
         * cuenta de correo del remitente como la asignada a {@code EMAIL.adminEmail}.</p>
         * @param toEmail a string representing the repicients' e-mail accounts.
         *        This string can contain more than one e-mail accounts, semicolon-separated.
         *        If it is {@code null} the e-mail will not be sent.
         * @param subject a string representing the message's subject
         * @param body a string containing the message's body
         * @throws java.net.SocketException if an error occurs while creating the mail sender.
         *         <p>si ocurre alg&uacute;n error en la creaci&oacute;n del remitente
         *         de correos.</p>
         */
        public static void sendBGEmail(String toEmail, String subject, String body)
                throws java.net.SocketException {

             ArrayList acol = new ArrayList();
             if (toEmail != null && toEmail.indexOf(";") > 0) {
                 StringTokenizer strTokens = new StringTokenizer(toEmail, ";");
                 while (strTokens.hasMoreTokens()) {
                     String token = strTokens.nextToken();
                     if (token == null) continue;
                     javax.mail.internet.InternetAddress address = new javax.mail.internet.InternetAddress();
                     address.setAddress(token);
                     acol.add(address);
                 }
             } else if (toEmail != null) {
                 javax.mail.internet.InternetAddress address = new javax.mail.internet.InternetAddress();
                 address.setAddress(toEmail);
                 acol.add(address);
             }
             EMAIL.sendBGEmail(EMAIL.adminEmail, null, acol, null, null, subject,
                     null, body, null, null, null);
        }
        
        /**
         * Sends an e-mail in background mode with the information supplied.
         * <p>Env&iacute;a un correo electr&oacute;nico en segundo plano con
         * la informaci&oacute;n proporcionada.</p>
         * @param fromEmail a string representing the sender's e-mail account.
         *        Must be a valid e-mail account, if it is equal to {@code null},
         *        the value of {@code EMAIL.adminEmail} will be used.
         * @param fromName  a string representing the sender's name
         * @param address   a collection of the recipients' e-mail accounts. Every
         *        element in the collection is expected to be a valid {@link java.mail.internet.InternetAddress}.
         *        Must not be null, otherwise the mail will not be sent.
         * @param ccEmail   a collection of e-mail accounts to send the email as a copy. Every
         *        element in the collection is expected to be a valid {@literal java.mail.internet.InternetAddress}.
         *        If it is {@code null}, the mail won't be sent as a carbon copy to anyone.
         * @param bccEmail  a collection of e-mail accounts to send the email as a blind carbon copy. Every
         *        element in the collection is expected to be a valid {@literal java.mail.internet.InternetAddress}.
         *        If it is {@code null}, the mail won't be sent as a blind carbon copy to anyone.
         * @param subject   a string indicating the e-mail's subject
         * @param contentType a string indicating the content type of the mail. {@literal HTML}
         *        indicates the body has an HTML format, otherwise it will be send
         *        in text plain format. Must not be {@code null}.
         * @param data      a string containing the e-mail body's text
         * @param login     a string representing a login name for SMTP server
         *        authentication. If it is {@code null} authentication will not be performed.
         * @param password  a string representing a password for SMTP server
         *        authentication. If it is {@code null} authentication will not be performed.
         * @param attachments a list containing all the attachments for the e-mail. Every
         *        element in the collection is expected to be of type {@literal org.apache.commons.mail.EmailAttachment}.
         * @throws java.net.SocketException if an error occurs during new thread's
         *         creation for working in background mode.
         *         <p>si ocurre un error durante la creaci&oacute;n del nuevo
         *         thread para trabajar en segundo plano.</p>
         */
        public static void sendBGEmail(String fromEmail, String fromName,
                Collection address, Collection ccEmail, Collection bccEmail,
                String subject, String contentType, String data, String login,
                String password, ArrayList<EmailAttachment> attachments)
                throws java.net.SocketException {
            
            SWBMail message = new SWBMail();
            if (fromEmail == null && EMAIL.adminEmail != null) fromEmail = EMAIL.adminEmail;
            if (fromEmail != null) message.setFromEmail(fromEmail);
            if (fromName != null) message.setFromName(fromName);
            if (address != null) message.setAddress((ArrayList) address);
            if (ccEmail != null) message.setCcEmail(ccEmail);
            if (bccEmail != null) message.setBccEmail(bccEmail);
            if (subject != null) message.setSubject(subject);
            if (contentType == null) contentType = "HTML";
            if (contentType != null) message.setContentType(contentType);
            if (data != null) message.setData(data);
            if (login != null) message.setLogin(login);
            if (password != null) message.setPassword(password);
            if (attachments != null) message.setAttachments(attachments);

            SWBMailSender swbMailSender = new SWBMailSender();
            swbMailSender.addEMail(message);
            swbMailSender.start();
        }

        /**
         * Sends an e-mail in background mode with the information supplied
         * through {@code message}.
         * <p>Env&iacute;a un correo electr&oacute;nico en segundo plano con
         * la informaci&oacute;n proporcionada a trav&eacute;s de {@code message}.</p>
         * @param message an object of type {@link org.semanticwb.base.util.SWBMail}
         * @throws java.net.SocketException if an error occurs during new thread's
         *         creation for working in background mode.
         *         <p>si ocurre un error durante la creaci&oacute;n del nuevo
         *         thread para trabajar en segundo plano.</p>
         */
        public static void sendBGEmail(SWBMail message) throws java.net.SocketException {
            SWBMailSender swbMailSender = new SWBMailSender();
            swbMailSender.addEMail(message);
            swbMailSender.start();
        }

        /**
         * Sets the value for the user's name registered in the SMTP server for
         * sending messages.
         * <p>Asigna el valor del nombre de usuario registrado en el servidor SMTP para
         * enviar mensajes.</p>
         * @param smtpuser a string representing a user's name registered in the SMTP server.
         */
        public static void setSMTPUser(String smtpuser) {
            EMAIL.smtpuser = smtpuser;
        }

        /**
         * Sets the value for the user's password registered in the SMTP server for
         * sending messages.
         * <p>Asigna el valor de la contrase&ntilde;a de usuario registrado en el servidor SMTP para
         * enviar mensajes.</p>
         * @param smtppassword a string representing a user's password registered in the SMTP server.
         */
        public static void setSMTPPassword(String smtppassword) {
            EMAIL.smtppassword = smtppassword;
        }

    }


    /**
     * 
     */
    public static class XML {


        /**
         * The only one instance of this object for the entire application.
         * <p>La &uacute;nica instancia de este objeto para toda la aplicaci&oacute;n.</p>
         */
        private static XML m_xml = null;

        /**
         * A DOM object trees producer.
         * <p>Un generador de &aacute;rboles de objetos DOM.</p>
         */
        private DocumentBuilderFactory m_dbf = null;

        /**
         * Creator of objects of type {@link javax.xml.transform.Transformer} and
         * {@link javax.xml.transform.Templates}.
         * <p>Creador de objetos de tipo {@link javax.xml.transform.Transformer}
         * y {@link javax.xml.transform.Templates}.</p>
         */
        private TransformerFactory m_tFactory = null;        // 1. Instantiate an XPathFactory.

        /**
         * Creator of {@link javax.xml.xpath.XPath} objects.
         * <p>Creador de objetos {@code javax.xml.xpath.XPath}</p>
         */
        private XPathFactory xpath_factory = null;

        /**
         * Evaluator of XPath expressions.
         * <p>Evaluador de expresiones XPath.</p>
         */
        private XPath xpathObj = null;

        
        /**
         * Gets the factory object of {@code javax.xml.xpath.XPath} objects.
         * <p>Obtiene el objeto f&aacute;brica de objetos {@code javax.xml.xpath.XPath}.</p>
         * @return the factory object of {@code javax.xml.xpath.XPath} objects.
         *         <p>el objeto f&aacute;brica de objetos {@code javax.xml.xpath.XPath}.</p>
         */
        public static XPathFactory getXPathFactory() {
            XML xml = getInstance();
            return xml.xpath_factory;
        }

        /**
         * Gets the {@code XPath} object of this object.
         * <p>Obtiene el objeto {@code XPath} de este objeto.</p>
         * @return the {@code XPath} object of this object.
         *         <p>el objeto {@code XPath} de este objeto.</p>
         */
        public static XPath getXPathObject() {
            XML xml = getInstance();
            return xml.xpathObj;
        }

        /**
         * Gets a reference for the only one instance of this object.
         * <p>Obtiene una referencia para la &uacute;nica instancia de este objeto.</p>
         * @return a reference for the only one instance of this object.
         *         <p>una referencia para la &uacute;nica instancia de este objeto.</p>
         */
        private static XML getInstance() {
            if (m_xml == null) {
                m_xml = new XML();
            }
            return m_xml;
        }

        /**
         * Gets this object's document builder factory.
         * <p>Obtiene la f&aacute;brica constructora de documentos
         * de este objeto.</p>
         * @return this object's document builder factory.
         *         <p>la f&aacute;brica constructora de documentos
         *         de este objeto.</p>
         */
        public static DocumentBuilderFactory getDocumentBuilderFactory() {
            XML xml = getInstance();
            return xml.m_dbf;
        }

        /**
         * Gets this object's transformer factory.
         * <p>Obtiene la f&aacute;brica transformadora de este objeto.</p>
         * @return this object's transformer factory.
         *         <p>la f&aacute;brica transformadora de este objeto.</p>
         */
        public static TransformerFactory getTransformerFactory() {
            XML xml = getInstance();
            return xml.m_tFactory;
        }

        /**
         * Creates an instance of this object. The instance's document builder factory
         * will provide support for XML namespaces, and its parsers created must
         * eliminate whitespace in element content.
         * <p>Crea una instancia de este objeto. La f&aacute;brica constructora de
         * documentos de esta instancia proveer&aacute; de soporte para namespaces
         * de XML, y los analizadores sint&aacute;cticos que cree deber&aacute;n
         * eliminar los espacios en blanco del contenido de los elementos.</p>
         */
        private XML() {
            try {
                m_dbf = DocumentBuilderFactory.newInstance();
                m_dbf.setNamespaceAware(true);
                m_dbf.setIgnoringElementContentWhitespace(true);
                //db=dbf.newDocumentBuilder();
                //xpath
                xpath_factory = javax.xml.xpath.XPathFactory.newInstance();
                xpathObj = xpath_factory.newXPath();

            } catch (Exception e) {
                log.error("Error getting DocumentBuilderFactory...", e);
            }

            try {
                m_tFactory = TransformerFactory.newInstance();
            } catch (Exception e) {
                log.error("Error getting TransformerFactory...", e);
            }
        }

        /**
         * Transforms a DOM document into a XML formatted string.
         * <p>Transforma un documento DOM en un objeto string con formato XML.</p>
         *Crea un objeto String a partir de un objeto Document con cierta codificación especificada y 
         * teniendo la posibilidad de identar la salida, la identación que se tiene especificada en el método es 2.
         * @param dom a DOM document to transform. Must not be {@code null}.
         * @param encode a string representing the preferred character encoding
         *        to use in the transformation. Must not be {@code null}.
         * @param indent a {@code boolean} indicating wheather or not to indent the XML to generate.
         * @return a string representing the DOM document received.
         *         <p>un objeto string que representa el documento DOM recibido.</p>
         */
        public static String domToXml(Document dom, String encode, boolean indent) {
            ByteArrayOutputStream sw = new java.io.ByteArrayOutputStream();
            OutputStreamWriter osw = null;
            try {
                osw = new java.io.OutputStreamWriter(sw, encode);
                StreamResult streamResult = new StreamResult(osw);
                TransformerFactory tFactory = getTransformerFactory();
                Transformer transformer = null;
                synchronized (tFactory) {
                    transformer = tFactory.newTransformer();
                }
                transformer.setOutputProperty(OutputKeys.ENCODING, encode);
                if (indent) {
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    try {
                        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    } catch (Exception noe) {/*No soportado en algunos xerses*/

                    }
                }
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.transform(new DOMSource(dom), streamResult);
            } catch (Exception e) {
                log.error(e);
            }
            return sw.toString();
        }

        /**
         * Transforms a DOM document into a XML formatted string using the UTF-8
         * character encoding with no indentation.
         * <p>Transforma un documento DOM en un objeto string con formato XML
         * utilizando codificaci&oacute;n UTF-8 sin sangr&iacute;as.</p>
         * @param dom a DOM document to transform. Must not be {@code null}.
         * @return a XML formatted, UTF-8 encodedstring representing the DOM document received.
         *         <p>un objeto string que representa el documento DOM recibido.</p>
         */
        public static String domToXml(Document dom) {
            return domToXml(dom, "UTF-8", false);
        }

        /**
         * Crea un objeto String a partir de un objeto Document con codificación UTF-8 y teniendo la posibilidad de
         * identar la salida, la identación que se tiene especificada en el método es 2.
         * @param dom
         * @param ident
         * @return  */
        public static String domToXml(Document dom, boolean ident) {
            return domToXml(dom, "UTF-8", ident);
        }

        /**
         * Crea una copia exacta de un objeto Document
         * Creates an exactly copy of Document object
         * @param dom
         * @throws org.w3c.dom.DOMException
         * @return  */
        public static Document copyDom(Document dom) throws SWBException {
            Document n = getNewDocument();
            if (dom != null && dom.hasChildNodes()) {
                Node node = n.importNode(dom.getFirstChild(), true);
                n.appendChild(node);
            }
            return n;
        }

        /**
         * Crea un objeto Document a partir de un objeto String.
         * Creates a document object in base of String object
         * @param xml
         * @return  */
        public static Document xmlToDom(String xml) {
            if (xml == null || xml.length() == 0) {
                return null;
            }
            Document dom = null;
            try {
                ByteArrayInputStream sr = new java.io.ByteArrayInputStream(xml.getBytes());
                dom = xmlToDom(sr);
            } catch (Exception e) {
                log.error(e);
            }
            return dom;
        }

        /**
         * Crea un objeto Document a partir de un objeto InputStream.
         * Creates a document object in base of InputStream object
         * @param xml
         * @return  */
        public static Document xmlToDom(InputStream xml) {
            Document dom = null;
            try {
                dom = xmlToDom(new InputSource(xml));
            //xml.close();
            } catch (Exception e) {
                log.error(e);
            }
            return dom;
        }

        /**
         * Crea un objeto Document a partir de un objeto InputSource.
         * Creates a document object in base of InputSource object
         * @param xml
         * @return  */
        public static Document xmlToDom(InputSource xml) {
            DocumentBuilderFactory dbf = null;
            DocumentBuilder db = null;
            Document dom = null;
            try {
                dbf = getDocumentBuilderFactory();
                synchronized (dbf) {
                    db = dbf.newDocumentBuilder();
                }
                if (xml != null) {
                    dom = db.parse(xml);
                    try {
                        dom = copyDom(dom);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
            return dom;
        }

        /**
         * Crea un nuevo objeto Document.
         * Creates a new object document
         * @throws com.infotec.appfw.exception.AFException
         * @return  */
        public static Document getNewDocument() //throws SWBException
        {
            DocumentBuilderFactory dbf = getDocumentBuilderFactory();
            DocumentBuilder db = null;
            Document dom = null;
            try {
                synchronized (dbf) {
                    db = dbf.newDocumentBuilder();
                }
                dom = db.newDocument();
            } catch (Exception e) {
                log.error(e);
            //throw new SWBException("Error getting new XML Document", e);
            }
            return dom;
        }

        /**
         * Carga un objeto InputStream de un xslt para ser utilizado como plantilla.
         * @param stream
         * @throws javax.xml.transform.TransformerConfigurationException
         * @return  */
        public static Templates loadTemplateXSLT(InputStream stream) throws TransformerConfigurationException {
            TransformerFactory transFact = getTransformerFactory();
            return transFact.newTemplates(new StreamSource(stream));
        }

        /**
         * Transforma un objeto Document con un Template (xslt) especificado, 
         * regresando un objeto String con dicha transformación y listo para ser desplegado.
         * @param tpl
         * @param doc
         * @throws javax.xml.transform.TransformerException
         * @return  a String object ready to be displayed
         */
        public static String transformDom(Templates tpl, Document doc) throws TransformerException {
            ByteArrayOutputStream sw = new java.io.ByteArrayOutputStream();
            Transformer trans = tpl.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        }

        public static boolean xmlVerifier(org.xml.sax.InputSource schema, org.xml.sax.InputSource xml) {
            return xmlVerifier(null, schema, null, xml);
        }

        public static boolean xmlVerifier(String idschema, org.xml.sax.InputSource schema, String idxml, org.xml.sax.InputSource xml) {
            boolean bOk = false;
            if (schema == null || xml == null) {
                if (schema == null) {
                    log.error("Error WBAdmResourceUtils.XMLVerifier(): Schema source is null.");
                } else {
                    log.event("Error WBAdmResourceUtils.XMLVerifier(): The input document source is null.");
                }
                return bOk;
            }

            if (idschema != null && !idschema.trim().equals("")) {
                schema.setSystemId(idschema);
            }
            if (idxml != null && !idxml.trim().equals("")) {
                xml.setSystemId(idxml);
            }
            bOk = xmlVerifierImpl(schema.getSystemId(), schema, xml);
            return bOk;
        }

        public static boolean xmlVerifier(java.io.InputStream schema, java.io.InputStream xml) {
            return xmlVerifier(null, schema, xml);
        }

        public static boolean xmlVerifier(String idschema, java.io.InputStream schema, java.io.InputStream xml) {
            boolean bOk = false;
            if (schema == null || xml == null) {
                if (schema == null) {
                    log.error("Error WBAdmResourceUtils.XMLVerifier(): Schema stream is null.");
                } else {
                    log.error("Error WBAdmResourceUtils.XMLVerifier(): The input document stream is null.");
                }
                return bOk;
            }
            org.xml.sax.InputSource inxml = new org.xml.sax.InputSource(xml);
            bOk = xmlVerifierImpl(idschema, schema, inxml);
            return bOk;
        }

        /**
         * Transforma un objeto Document con un Template (xslt) especificado, 
         * regresando un objeto String con dicha transformación y listo para ser desplegado.
         * 
         * Transforms a Document object with specified template (xslt)
         * @param sysid
         * @param objschema
         * @param objxml
         * @return a String object ready to be displayed
         */
        private static boolean xmlVerifierImpl(String sysid, Object objschema, Object objxml) {
            boolean bOk = false;
            if (objschema == null || objxml == null) {
                if (objschema == null) {
                    log.error("Error WBAdmResourceUtils.XMLVerifier(): Schema is null.");
                } else {
                    log.error("Error WBAdmResourceUtils.XMLVerifier(): The input document is null.");
                }
                return bOk;
            }
            org.iso_relax.verifier.VerifierFactory factory = new com.sun.msv.verifier.jarv.TheFactoryImpl();
            org.iso_relax.verifier.Schema schema = null;
            try {
                if (objschema instanceof java.io.File) {
                    schema = factory.compileSchema((java.io.File) objschema);
                } else if (objschema instanceof org.xml.sax.InputSource) {
                    schema = factory.compileSchema((org.xml.sax.InputSource) objschema);
                } else if (objschema instanceof java.io.InputStream) {
                    if (sysid != null && !sysid.trim().equals("")) {
                        schema = factory.compileSchema((java.io.InputStream) objschema, sysid);
                    } else {
                        schema = factory.compileSchema((java.io.InputStream) objschema);
                    }
                } else if (objschema instanceof java.lang.String) {
                    schema = factory.compileSchema((java.lang.String) objschema);
                }
                try {
                    org.iso_relax.verifier.Verifier verifier = schema.newVerifier();
                    verifier.setErrorHandler(silentErrorHandler);

                    if (objxml instanceof java.io.File) {
                        bOk = verifier.verify((java.io.File) objxml);
                    } else if (objxml instanceof org.xml.sax.InputSource) {
                        bOk = verifier.verify((org.xml.sax.InputSource) objxml);
                    } else if (objxml instanceof org.w3c.dom.Node) {
                        bOk = verifier.verify((org.w3c.dom.Node) objxml);
                    } else if (objxml instanceof java.lang.String) {
                        bOk = verifier.verify((java.lang.String) objxml);
                    }
                } catch (org.iso_relax.verifier.VerifierConfigurationException e) {
                    log.error("Error WBAdmResourceUtils.XMLVerifier(): Unable to create a new verifier.", e);
                } catch (org.xml.sax.SAXException e) {
                    log.event("Error WBAdmResourceUtils.XMLVerifier(): The input document is not wellformed.", e);
                }
            } catch (Exception e) {
                log.event("Error WBAdmResourceUtils.XMLVerifier(): Unable to parse the schema file.", e);
            }
            return bOk;
        }

        public static boolean xmlVerifier(String schema, String xml) {
            return xmlVerifierByURL(null, schema, xml);
        }

        public static boolean xmlVerifierByURL(String sysid, String schema, String xml) {
            return xmlVerifierImpl(sysid, schema, xml);
        }

        /**
         * Comvierte un Node a Document
         * Converts Node to Document object
         * Todo: Meter en AFUtils
         */
        public static Document node2Document(Node node) throws SWBException {
            // ensure xerces dom
            if (node instanceof org.apache.xerces.dom.DocumentImpl) {
                return (Document) node;
            }
            Document document = getNewDocument();
            if (node instanceof Document) {
                node = ((Document) node).getDocumentElement();
            }
            document.appendChild(document.importNode(node, true));
            return document;
        }

        /**
         * Obtiene el contenido del objeto Document como xml y 
         * lo envía a un archivo especificado (serialización) con codificación UTF-8 e identación de 2.
         * @param dom
         * @param file  */
        public static void DomtoFile(Document dom, String file) {
            domtoFile(dom, file, "UTF-8");
        }

        /**
         * Obtiene el contenido del objeto Document como xml y 
         * lo envía a un archivo especificado (serialización) bajo cierta codificación que se especifique e identación de 2.
         * 
         * Serialize a document object
         * 
         * @param dom
         * @param file
         * @param encode  
         */
        public static void domtoFile(Document dom, String file, String encode) {
            java.io.FileOutputStream osw = null;
            try {
                osw = new FileOutputStream(new java.io.File(file));
                StreamResult streamResult = new StreamResult(osw);

                Transformer transformer = null;
                TransformerFactory tFactory = getTransformerFactory();
                synchronized (tFactory) {
                    transformer = tFactory.newTransformer();
                }
                transformer.setOutputProperty(OutputKeys.ENCODING, encode);
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.transform(new DOMSource(dom), streamResult);
                osw.flush();
                osw.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
        /**
         * An error handler implementation that doesn't report any error.
         */
        private static final org.xml.sax.ErrorHandler silentErrorHandler = new org.xml.sax.ErrorHandler() {

            public void fatalError(org.xml.sax.SAXParseException e) {
            }

            public void error(org.xml.sax.SAXParseException e) {
            }

            public void warning(org.xml.sax.SAXParseException e) {
            }
        };

        /**
         * Replace special characters in xml String
         * @param str Reemplaza caracteres especiales en un xml
         * @return
         */
        static public String replaceXMLChars(String str) {
            if (str == null) {
                return null;
            }
            StringBuffer ret = new StringBuffer();

            // split tokens
            StringTokenizer tokenizer = new StringTokenizer(str, " \t@%^&()-+=|\\{}[].;\"<>", true);
            while (tokenizer.hasMoreTokens()) {
                // next token
                String token = tokenizer.nextToken();

                // replace '\t' by the content of "tabulation"
                if (token.startsWith("\t")) {
                    ret.append("    ");
                    continue;
                }

                // replace '<' by '&lt;'
                if (token.startsWith("<")) {
                    ret.append("&lt;");
                    continue;
                }

                // replace '>' by '&gt;'
                if (token.startsWith(">")) {
                    ret.append("&gt;");
                    continue;
                }

                // replace '&' by '&amp;'
                if (token.startsWith("&")) {
                    ret.append("&amp;");
                    continue;
                }
                ret.append(token);
            }
            return ret.toString();

        }

        /**
         * Reemplaza caracteres especiales de tags en un xml
         * @param txt
         * @return  */
        static public String replaceXMLTags(String txt)
        {
            if(txt==null)return null;
            StringBuffer str = new StringBuffer(txt);
            for (int x = 0; x < str.length(); x++)
            {
                char ch = str.charAt(x);
                if (ch == '&')
                {
                    if (str.substring(x, x + 4).equals("&lt;"))
                    {
                        str.replace(x, x + 4, "<");
                    } else if (str.substring(x, x + 4).equals("&gt;"))
                    {
                        str.replace(x, x + 4, ">");
                    } else if (str.substring(x, x + 5).equals("&amp;"))
                    {
                        str.replace(x, x + 5, "&");
                    }
                }
            }
            return str.toString();
    }


        /**
         * Creates a node as child of other one
         * @param ele Node pather
         * @param name Node name to create
         * @return a new Element (Node)
         */
        static public Element appendChild(Element ele, String name) {
            Document doc = ele.getOwnerDocument();
            Element e = doc.createElement(name);
            ele.appendChild(e);
            return e;
        }

        /**
         * Creates a node as child of other one and assign a value to it
         * @param ele Node pather
         * @param name Node name to create
         * @param value Node Value to create
         * @return a new Element (Node)
         */
        static public Element appendChild(Element ele, String name, String value) {
            Document doc = ele.getOwnerDocument();
            Element e = doc.createElement(name);
            e.appendChild(doc.createTextNode(value));
            ele.appendChild(e);
            return e;
        }

        /**
         * Eval a xpath expression in an input source
         * @param expression xpath xpression
         * @param input input to eval
         * @param resultType Object type to return
         * @return a specified object QName according to XPathConstants object, ej. XPathConstants.NODE)
         * @throws javax.xml.xpath.XPathExpressionException
         */
        public static Object getXpathEval(String expression, InputSource input, QName resultType) throws javax.xml.xpath.XPathExpressionException {
            XPath xpathObj = getXPathObject();
            javax.xml.xpath.XPathExpression xpathExpression = xpathObj.compile(expression);
            return xpathExpression.evaluate(input, resultType);
        }

        /** Asigna un atributo al DOM del recurso.
         * Si no existe el atributo, lo crea y si existe lo modifica
         * @param name String nombre del atributo
         * @param value String valor del atributo
         */
        public static void setAttribute(Document dom, String name, String value) {
            NodeList data = dom.getElementsByTagName(name);
            if (data.getLength() > 0) {
                Node txt = data.item(0).getFirstChild();
                if (txt != null) {
                    if (value != null) {
                        txt.setNodeValue(value);
                    } else {
                        data.item(0).removeChild(txt);
                    }
                } else {
                    if (value != null) {
                        data.item(0).appendChild(dom.createTextNode(value));
                    }
                }
            } else {
                Element res = (Element) dom.getFirstChild();
                Element ele = dom.createElement(name);
                if (value != null) {
                    ele.appendChild(dom.createTextNode(value));
                }
                res.appendChild(ele);
            }
        }

        /** Lee un atributo del DOM del Recurso
         * Si el atributo no esta declarado regresa el valor por defecto defvalue.
         */
        public static String getAttribute(Document dom, String name, String defvalue) {
            String ret = getAttribute(dom, name);
            if (ret == null) {
                ret = defvalue;
            }
            return ret;
        }

        /** Lee un atributo del DOM del Recurso
         * Si el atributo no esta declarado regresa null.
         */
        public static String getAttribute(Document dom, String name) {
            String ret = null;
            NodeList data = dom.getElementsByTagName(name);
            if (data.getLength() > 0) {
                Node txt = data.item(0).getFirstChild();
                if (txt != null) {
                    ret = txt.getNodeValue();
                }
            }
            return ret;
        }
    }

    /**
     * 
     */
    public static class DB 
    {


        public static final String DBTYPE_HSQL="HSQL";
        public static final String DBTYPE_MySQL="MySQL";
        public static final String DBTYPE_MsSQL="MsSQL";
        public static final String DBTYPE_Oracle="Oracle";
        public static final String DBTYPE_PostgreSQL="PostgreSQL";
        public static final String DBTYPE_Derby="Derby";

        private static DBConnectionManager manager = null;
        private static String defaultPoolName = "swb";

        private static DBConnectionManager getConnectionManager() {
            if (manager == null) {
                manager = new DBConnectionManager();
            }
            return manager;
        }

        /** Returns an enumeration of DBConnectionPool
         * @return an enumeration of DBConnectionPool
         */
        public static Enumeration<DBConnectionPool> getPools() {
            return getConnectionManager().getPools().elements();
        }

        /** Returns a DBConnectionPool
         * @return a DBConnectionPool
         */
        public static DBConnectionPool getPool(String name) {
            return (DBConnectionPool) getConnectionManager().getPools().get(name);
        }

        /** Returns a default DBConnectionPool
         * @return a default DBConnectionPool
         */
        public static DBConnectionPool getDefaultPool() {
            return (DBConnectionPool) getConnectionManager().getPools().get(defaultPoolName);
        }

        /** Returns a ConnectionPoolName
         * @return a ConnectionPoolName
         */
        public static String getDefaultPoolName() {
            return defaultPoolName;
        }

        /**
         * 
         * @param poolName
         */
        public static void setDefaultPool(String poolName) {
            defaultPoolName = poolName;
        }

        /** Getter for Connection form DBPool.
         * @return Connection from DBPool.
         * @param poolName 
         */
        public static Connection getNoPoolConnection(String poolName) {
            return getConnectionManager().getNoPoolConnection(poolName);
        }

        /** Getter for Connection form DBPool.
         * @param description 
         * @return Connection from DBPool.
         */
        public static Connection getDefaultConnection(String description) {
            return getConnection(defaultPoolName, description);
        }

        /** Getter for Connection form DBPool.
         * @return Connection from DBPool.
         */
        public static Connection getDefaultConnection() {
            return getConnection(defaultPoolName);
        }

        /** Getter for Connection form DBPool.
         * @return Connection from DBPool.
         * @param poolName 
         * @param description 
         */
        public static Connection getConnection(String poolName, String description) {
            return getConnectionManager().getConnection(poolName, description);
        //return dbPool.getNoPoolConnection(name);
        }

        /** Getter for Connection form DBPool.
         * @return Connection from DBPool.
         * @param name  */
        public static Connection getConnection(String name) {
            return getConnectionManager().getConnection(name);
        }

        /** Nombre de base de datos.
         * DataBase name
         *  @return String nombre de la base de datos.
         */
        public static String getDatabaseName() {
            return getDatabaseName(defaultPoolName);
        }

        /** Nombre de base de datos.
         * DataBase name
         *  @param poolName 
         * @return String nombre de la base de datos.
         */
        public static String getDatabaseName(String poolName) {
            String ret = null;
            try {
                Connection con = getConnectionManager().getConnection(poolName);
                if (con != null) {
                    java.sql.DatabaseMetaData md = con.getMetaData();
                    ret = md.getDatabaseProductName();
                    con.close();
                }
            } catch (Exception e) {
                log.error("Not Database Found...", e);
            }
            return ret;
        }

        /** Tipo de base de datos.
         * DataBase type
         */
        public static String getDatabaseType() {
            return getDatabaseType(defaultPoolName);
        }

        /** Tipo de base de datos.
         * DataBase type
         *  @param poolName
         * @return String nombre de la base de datos.
         */
        public static String getDatabaseType(String poolName) {
            String ret = getDatabaseName(poolName);
            if(ret.toLowerCase().indexOf("hsql")>-1)ret=DBTYPE_HSQL;
            else if(ret.toLowerCase().indexOf("mysql")>-1)ret=DBTYPE_MySQL;
            else if(ret.toLowerCase().indexOf("mssql")>-1)ret=DBTYPE_MsSQL;
            else if(ret.toLowerCase().indexOf("oracle")>-1)ret=DBTYPE_Oracle;
            else if(ret.toLowerCase().indexOf("postgresql")>-1)ret=DBTYPE_PostgreSQL;
            else if(ret.toLowerCase().indexOf("derby")>-1)ret=DBTYPE_Derby;
            return ret;
        }


        public static int getConnections(String poolName) {
            return getConnectionManager().getConnections(poolName);
        }

        public static int getFreeConnections(String poolName) {
            return getConnectionManager().getFreeConnections(poolName);
        }

        /**
         * Obtains the DBConnectionManager's PoolConnectionTimeLock.
         * @return a reference to the PoolConnectionTimeLock used by the DBConnectionManager
         */
        public static PoolConnectionTimeLock getTimeLock() {
            return getConnectionManager().getTimeLock();
        }
    }

    public static class CryptoWrapper {


        public static String passwordDigest(String toEncode) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            if (toEncode.startsWith("{SHA-512}") ||
                    toEncode.startsWith("{SHA}") ||
                    toEncode.startsWith("{SSHA}") ||
                    toEncode.startsWith("{CRYPT}") ||
                    toEncode.startsWith("{SMD5}") ||
                    toEncode.startsWith("{MD5}")) {
                return toEncode;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            //return "{SHA-512}" + new BASE64Encoder().encode(messageDigest.digest(toEncode.getBytes()));
            return "{SHA-512}" + SFBase64.encodeBytes(messageDigest.digest(toEncode.getBytes("ISO8859-1")), false);
        }

        public static String comparablePassword(String toEncode) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            return comparablePassword(toEncode, "SHA-512");
        }

        public static String comparablePassword(String toEncode, String digestAlgorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            MessageDigest messageDigest = MessageDigest.getInstance(digestAlgorithm);
            //return "{SHA-512}" + new BASE64Encoder().encode(messageDigest.digest(toEncode.getBytes()));
            return "{SHA-512}" + SFBase64.encodeBytes(messageDigest.digest(toEncode.getBytes("ISO8859-1")), false);
        }

        public static byte[] PBEAES128Cipher(String passPhrese, byte[] data) throws GeneralSecurityException {
            byte[] key = new byte[16];
            byte[] tmp = passPhrese.getBytes();
            int pos = 0;
            while (pos < 16) {
                System.arraycopy(tmp, 0, key, pos, Math.min(16 - pos, tmp.length));
                pos += tmp.length;
            }
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        }

        public static byte[] PBEAES128Decipher(String passPhrese, byte[] data) throws GeneralSecurityException {
            byte[] key = new byte[16];
            byte[] tmp = passPhrese.getBytes();
            int pos = 0;
            while (pos < 16) {
                System.arraycopy(tmp, 0, key, pos, Math.min(16 - pos, tmp.length));
                pos += tmp.length;
            }
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        }
    }

    public static class Collections {

        
        public static List copyIterator(Iterator it) {
            ArrayList ret = new ArrayList();
            while (it.hasNext()) {
                Object ref = it.next();
                ret.add(ref);
            }
            return ret;
        }

        public static long sizeOf(Iterator it) {
            long size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
            return size;
        }

    }
}
