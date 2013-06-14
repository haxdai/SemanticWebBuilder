/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.infotec.filesender.SenderService;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.DatasetLog;
import com.infotec.lodp.swb.DatasetVersion;
import com.infotec.lodp.swb.Publisher;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.mail.internet.InternetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.SWBObserver;
import org.semanticwb.base.util.SWBMail;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SWBMessageCenter;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author juan.fernandez
 */
public class DataSetResource extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(DataSetResource.class);
    public static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    public static final String KML_MIME_TYPE = "application/octet-stream";
    public static final String CSV_MIME_TYPE = "application/octet-stream";
    public static final String RDF_MIME_TYPE = "application/rdf+xml";
    public static final String JSON_MIME_TYPE = "application/json";
    public static final String META_FORMAT_RDF = "rdf";
    public static final String META_FORMAT_JSON = "json";
    public static final String FILTER_SECTOR = "sector";
    public static final String FILTER_INSTITUTION = "institution";
    public static final String FILTER_TOPIC = "topic";
    public static final String ORDER_CREATED = "date";
    public static final String ORDER_VIEW = "view";
    public static final String ORDER_DOWNLOAD = "hit";
    public static final String ORDER_RANK = "rank";
    public static final String MODE_FILE = "file";

            

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        //super.doView(request, response, paramsRequest); //To change body of generated methods, choose Tools | Templates.

        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        //System.out.println("basePath:"+path);
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    public void doGetFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String action = request.getParameter("act");
        String metaformat = request.getParameter("mformat");
        String dsuri = request.getParameter("suri");

        WebSite wsite = paramRequest.getWebPage().getWebSite();
        
        
        if (null == action) {
            action = "";
        }
        if (null == metaformat) {
            metaformat = META_FORMAT_RDF;
        }

        User user = paramRequest.getUser();
        String fid = request.getParameter("fid");
       

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = null;
        GenericObject gobj = null;

        if ("meta".equals(action)) {

            //System.out.println("Entro a meta");
            obj = ont.getSemanticObject(SemanticObject.shortToFullURI(dsuri));
            if (obj != null && obj.createGenericInstance() instanceof Dataset) {
                Dataset ds = (Dataset) obj.createGenericInstance();
                
                ds.sendHit(request, user, paramRequest.getWebPage());
                
                //System.out.println("Recibe DataSET");
                //System.out.println("Formato a generar:"+metaformat);
                String dsname = ds.getDatasetTitle();
                dsname = SWBUtils.TEXT.replaceSpecialCharacters(dsname, true);
                if (META_FORMAT_RDF.equals(metaformat)) {
                    //Se crea RDF con meta del Dataset
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + dsname + ".rdf\";");
                    try {
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();

                        Model model = ModelFactory.createDefaultModel();
                        model.add(obj.getRDFResource().listProperties());
                        // "RDF/XML", "RDF/XML-ABBREV", "N-TRIPLE" and "N3"
                        model.write(bout, "RDF/XML");

                        String txt = bout.toString("UTF8");
                        OutputStream out = response.getOutputStream();
                        SWBUtils.IO.copyStream(SWBUtils.IO.getStreamFromString(txt), out);
                    } catch (Exception e) {
                        log.error("Error al exportar el Dataset a RDF", e);
                    }
                    //SWBUtils.IO.copyStream(new FileInputStream(SWBPortal.getWorkPath() + doc.getWorkPath() + "/" + verNumber + "/" + ver.getVersion()), out);


                } else if (META_FORMAT_JSON.equals(metaformat)) {
                    //Se crea JSON con meta del Dataset
                    //System.out.println("JSON File");
                    //response.setContentType("Content-Type: text/javascript");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + dsname + ".json\";");
                    try {
                        JSONObject json = new JSONObject();                      
                        Iterator<SemanticProperty> itsemprop = ds.getSemanticObject().listProperties();
                        while (itsemprop.hasNext()) {
                            SemanticProperty semprop = itsemprop.next();
                            //if(ds.getSemanticObject().getProperty(semprop)!=null){
                                json.put(semprop.getName(),getValueSemProp(ds.getSemanticObject(),semprop));
                           // }
                        }
                        String txt = json.toString(); 
                         OutputStream out = response.getOutputStream();
                        SWBUtils.IO.copyStream(SWBUtils.IO.getStreamFromString(txt), out);
                    } catch (Exception e) {
                        log.error("Error al exportar el Dataset a JSON", e);
                    }
                } else {
                    //format not supported
                    String retmsg = "Formato no soportado...";
                }
            }
        } else if ("file".equals(action)) {

            
            obj = ont.getSemanticObject(SemanticObject.shortToFullURI(dsuri));
            if (obj != null && obj.createGenericInstance() instanceof Dataset) {

            Dataset ds = (Dataset) obj.createGenericInstance();
            
            if (ds != null) {

                 DatasetVersion ver = ds.getActualVersion();   
                 
                //actualizo el numero de descragas del dataset
                //boolean dowloaded = LODPUtils.updateDSDownload(ds);
               // boolean okAddLog = LODPUtils.addDSLog(wsite, ds, user, "Descarga de dataset", LODPUtils.Log_Type_Download);

                ds.sendHit(request, user, paramRequest.getWebPage());

                try {

                    
                    String redirectURL = getDSWebFileURL(request, ver);
                    
                    response.setContentType(DEFAULT_MIME_TYPE);
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + ver.getFilePath() + "\";");

                    response.sendRedirect(redirectURL);
                    
                    //OutputStream out = response.getOutputStream();
                    //SWBUtils.IO.copyStream(new FileInputStream(SWBPortal.getWorkPath() +ver.getWorkPath() + "/" + ver.getFilePath()), out);
                    //ver.getSemanticObject().getSemanticClass().getClassCodeName()
                    //   ver.getSemanticObject().getId()
                     //  ver.getFilePath()
                    // hacer un sendredirect a: [app]/cgi-bin/recover/[classid]/[objid]/[filename]"
                   // String redirectURL = request.getLocalAddr()+request.getLocalPort()+"/cgi-bin/recover/"+ver.getSemanticObject().getSemanticClass().getClassCodeName()+"/"+ver.getSemanticObject().getId()+"/"+ver.getFilePath();
                    //System.out.println("Redirect URL:"+redirectURL);
                    //response.sendRedirect(redirectURL);
                    
                    
                } catch (Exception e) {
                    log.error("Error al obtener el archivo del Repositorio de documentos.", e);
                }
            }
        }
        }
    }

    public static String getDSWebFileURL(HttpServletRequest request, DatasetVersion ver){
        
                    String protocol = "";
                    if(request.getProtocol().toLowerCase().startsWith("http/")){
                        protocol="http://";
                    } else if(request.getProtocol().toLowerCase().startsWith("https/")){
                        protocol="https://";
                    }
                    String servername=request.getServerName();
                    String serverport = ""+request.getServerPort();
                    if(serverport.equals("80")){
                        serverport = "";
                    } else {
                        serverport=":"+serverport;
                    }

                    String retURL = protocol+servername+serverport+"/cgi-bin/recover/"+ver.getSemanticObject().getSemanticClass().getClassCodeName()+"/"+ver.getSemanticObject().getId()+"/"+ver.getFilePath();
                    //System.out.println("Redirect URL:"+redirectURL);
                   return retURL;
    }
    
    
     /**
     * Gets the value sem prop.
     * 
     * @param obj the obj
     * @param prop the prop
     * @return the value sem prop
     * @return
     */
    public String getValueSemProp(SemanticObject obj, SemanticProperty prop) {
        String ret = "";
        try {
            if (prop.isDataTypeProperty()) {
                log.debug("getValueSemProp(" + prop.getName() + ")" + obj.getProperty(prop));
                if (prop.isBoolean()) {
                    ret = "" + obj.getBooleanProperty(prop);
                }
                if (prop.isInt() || prop.isFloat()) {
                    ret = "" + obj.getLongProperty(prop);
                }
                if (prop.isString()) {
                    ret = obj.getProperty(prop);
                }
                if (prop.isDateTime()) {
                    ret = "" + obj.getDateProperty(prop);
                }
            } else if (prop.isObjectProperty()) {
                ret = obj.getObjectProperty(prop).getURI();
            }
        } catch (Exception e) {
            ret = "Not set";
        }
        return ret;
    }
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals(MODE_FILE)){
            doGetFile(request, response, paramRequest);
        } else {
        super.processRequest(request, response, paramRequest); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if(null==action){
            action="";
        }

        
        
        if("review".equals(action)){
            String dsuri = request.getParameter("dsuri");
            String comment = request.getParameter("comment");
            String btnok = request.getParameter("btnok");
            String btnreject = request.getParameter("btnreject");
            if(null!=dsuri && dsuri.trim().length()>0){
                SemanticObject so = SemanticObject.getSemanticObject(SemanticObject.shortToFullURI(dsuri));
                if(null!=so){
                    Dataset ds = (Dataset) so.createGenericInstance();
                    ds.setReviewed(Boolean.TRUE);
                    String mensaje = "";
                    if(null!=ds){
                        if(null!=btnok){
                            ds.setApproved(Boolean.TRUE);
                           
                        } else if(null!=btnreject){
                            ds.setApproved(Boolean.FALSE);
                        }
                        // Envio de notificación al usuario creador
                        Publisher pub = ds.getPublisher();
                        if(null!=pub&&pub.getEmail()!=null){
                            try {
                            if(SWBUtils.EMAIL.isValidEmailAddress(pub.getEmail())){
                                InternetAddress intaddr = new InternetAddress(pub.getEmail());
                                ArrayList<InternetAddress> arr = new ArrayList<InternetAddress>();
                                arr.add(intaddr);
                               SWBMail mail = new SWBMail();
                               mail.setToEmail(arr);
                               String fromEmail = SWBPortal.getEnv("af/adminEmail","webbuilder@infotec.com.mx");
                               mail.setFromEmail(fromEmail);
                               mail.setFromName("WebMaster");
                               
                               // falta armar el mensaje para el envio del correo
                               String subject = "Notificación Revisión Dataset "+ds.getDatasetTitle();   // cambiar por properties
                               if( null!=pub.getLanguage() && pub.getLanguage().equals("es") && ds.isApproved() ) { 
                                    mensaje = getResourceBase().getAttribute("msgaprobado_es","");
                                } else if( null!=pub.getLanguage() && pub.getLanguage().equals("es") && !ds.isApproved() ) { 
                                    mensaje = getResourceBase().getAttribute("msgreject_es","");
                                } else  if( null!=pub.getLanguage() && pub.getLanguage().equals("en") && ds.isApproved() ) { 
                                    mensaje = getResourceBase().getAttribute("msgaprobado_en","");
                                } else if( null!=pub.getLanguage() && pub.getLanguage().equals("en") && !ds.isApproved() ) { 
                                    mensaje = getResourceBase().getAttribute("msgreject_en","");
                                } else  if( ds.isApproved() ) { 
                                    mensaje = getResourceBase().getAttribute("msgaprobado_es","");
                                } else if(  !ds.isApproved() ) { 
                                    mensaje = getResourceBase().getAttribute("msgreject_es","");
                                } 
                               
                               if(comment!=null) mensaje = "<br/><br/>"+comment;
                               mail.setData(mensaje);
                               
                               // TODO: falta armar el mensaje de notificación
                               
                               SWBUtils.EMAIL.sendBGEmail(mail);
                            }
                            } catch (Exception e) {
                            }
                            
                        }
                    }
                }
            }
        }
    }

    /**
     * Ordena el dataset por orderby
     *
     * @param it Iterador con Dataset
     * @param orderby tipo de ordenamiento
     * @return Iterador de dataset ordenado
     */
    public static Iterator<Dataset> orderDS(Iterator<Dataset> it, String orderby) {

        //System.out.println("Ordenamiento..."+orderby);
        Set set = null;
        if (null != orderby && DataSetResource.ORDER_CREATED.equals(orderby)) {
            //mas reciente
            set = sortByCreated(it, false);
        } else if (null != orderby && DataSetResource.ORDER_DOWNLOAD.equals(orderby)) {
            // mas descargado
            set = sortByDownloads(it, false);
        } else if (null != orderby && DataSetResource.ORDER_VIEW.equals(orderby)) {
            //mas visto
            set = sortByViews(it, false);
        } else if (null != orderby && DataSetResource.ORDER_RANK.equals(orderby)) {
            set = sortByRank(it, false);
        } else {
            set = new TreeSet();
            while (it.hasNext()) {
                Dataset dataset = it.next();
                set.add(dataset);
            }
        }

        return set.iterator();
    }

    /**
     * Sort by created set.
     *
     * @param it the iterator of datasets
     * @param ascendente the ascendente
     * @return the sets ordered by created
     */
    public static Set sortByCreated(Iterator<Dataset> it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1;
                    Date d2;
                    
                    DatasetVersion ver1 =  ((Dataset) o1).getActualVersion();
                    DatasetVersion ver2 =  ((Dataset) o2).getActualVersion();
                    d1 =ver1!=null&&ver1.getVersionCreated()!=null?ver1.getVersionCreated():null;
                    d2 =ver2!=null&&ver2.getVersionCreated()!=null?ver2.getVersionCreated():null;
                     if(d1==null){
                        d1=((Dataset) o1).getDatasetCreated();
                    }
                    if(d2==null){
                        d2=((Dataset) o2).getDatasetCreated();
                    }
                    
                    
                    if (d1 == null && d2 != null) {
                        return -1;
                    }
                    if (d1 != null && d2 == null) {
                        return 1;
                    }
                    if (d1 == null && d2 == null) {
                        return -1;
                    } else {
                        int ret = d1.getTime() > d2.getTime() ? 1 : -1;
                        return ret;
                    }
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1;
                    Date d2;
                    DatasetVersion ver1 =  ((Dataset) o1).getActualVersion();
                    DatasetVersion ver2 =  ((Dataset) o2).getActualVersion();
                    d1 =ver1!=null&&ver1.getVersionCreated()!=null?ver1.getVersionCreated():null;
                    d2 =ver2!=null&&ver2.getVersionCreated()!=null?ver2.getVersionCreated():null;
                    
                    if(d1==null){
                        d1=((Dataset) o1).getDatasetCreated();
                    }
                    if(d2==null){
                        d2=((Dataset) o2).getDatasetCreated();
                    }

                    if (d1 == null && d2 != null) {
                        return -1;
                    }
                    if (d1 != null && d2 == null) {
                        return 1;
                    }
                    if (d1 == null && d2 == null) {
                        return -1;
                    } else {
                        int ret = d1.getTime() > d2.getTime() ? -1 : 1;
                        return ret;
                    }

                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }

    /**
     * Sort by hits or downloads.
     *
     * @param it the it
     * @param ascendente the ascendente
     * @return the sets the
     */
    public static Set sortByDownloads(Iterator it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1;
                    long d2;
                    d1 = ((Dataset) o1).getDownloads();
                    d2 = ((Dataset) o2).getDownloads();
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1;
                    long d2;
                    d1 = ((Dataset) o1).getDownloads();
                    d2 = ((Dataset) o2).getDownloads();
                    int ret = d1 > d2 ? -1 : 1;
                    return ret;
                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }

    /**
     * Sort by views.
     *
     * @param it the it
     * @param ascendente the ascendente
     * @return the sets the
     */
    public static Set sortByViews(Iterator it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1;
                    long d2;
                    d1 = ((Dataset) o1).getViews();
                    d2 = ((Dataset) o2).getViews();
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1;
                    long d2;
                    d1 = ((Dataset) o1).getViews();
                    d2 = ((Dataset) o2).getViews();
                    int ret = d1 > d2 ? -1 : 1;
                    return ret;
                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }

    /**
     * Sort by rank.
     *
     * @param it the it
     * @param ascendente the ascendente
     * @return the sets the
     */
    private static Set sortByRank(Iterator it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    float d1;
                    float d2;
                    d1 = ((Dataset) o1).getAverage();
                    d2 = ((Dataset) o2).getAverage();
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    float d1;
                    float d2;
                    d1 = ((Dataset) o1).getAverage();
                    d2 = ((Dataset) o2).getAverage();
                    int ret = d1 > d2 ? -1 : 1;
                    return ret;
                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }
    
    /**
     * Sort by created set.
     *
     * @param it the iterator of datasets
     * @param ascendente the ascendente
     * @return the sets ordered by created
     */
    public static Set sortDSLogByCreated(Iterator<DatasetLog> it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1;
                    Date d2;
                    d1 = ((DatasetLog) o1).getLogCreated();
                    d2 = ((DatasetLog) o2).getLogCreated();
                    if (d1 == null && d2 != null) {
                        return -1;
                    }
                    if (d1 != null && d2 == null) {
                        return 1;
                    }
                    if (d1 == null && d2 == null) {
                        return -1;
                    } else {
                        int ret = d1.getTime() > d2.getTime() ? 1 : -1;
                        return ret;
                    }
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1;
                    Date d2;
                    d1 = ((DatasetLog) o1).getLogCreated();
                    d2 = ((DatasetLog) o2).getLogCreated();
                    if (d1 == null && d2 != null) {
                        return -1;
                    }
                    if (d1 != null && d2 == null) {
                        return 1;
                    }
                    if (d1 == null && d2 == null) {
                        return -1;
                    } else {
                        int ret = d1.getTime() > d2.getTime() ? -1 : 1;
                        return ret;
                    }

                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }
    
    public static boolean reviewQuery(HashMap<String, String> hm, String texto) {
        boolean res = Boolean.FALSE;
        if (null != hm) {
            Iterator<String> itstr = hm.keySet().iterator();
            while (itstr.hasNext()) {
                String skey = itstr.next();
                if (texto.indexOf(skey) > -1) {
                    res = Boolean.TRUE;
                    break;
                } 
            }
        }
        return res;
    }
}
