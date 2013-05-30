/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.DatasetVersion;
import com.infotec.lodp.swb.Publisher;
import com.infotec.lodp.swb.utils.LODPUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURLImp;

/**
 *
 * @author juan.fernandez
 */
public class DSPublisherResource extends GenericAdmResource {

    public static final Logger log = SWBUtils.getLogger(DSPublisherResource.class);
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
    public static final String MODE_STATS = "stats";
    public static final String MODE_GRAPH = "graphs";

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
    
    /**
     * 
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException 
     */
    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        //super.doView(request, response, paramsRequest); //To change body of generated methods, choose Tools | Templates.

        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "edit.jsp";
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

    
    /**
 * 
 * @param request
 * @param response
 * @param paramsRequest
 * @throws SWBResourceException
 * @throws IOException 
 */
    public void doStat(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        //super.doView(request, response, paramsRequest); //To change body of generated methods, choose Tools | Templates.

        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "stats.jsp";
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
    
    
/**
 * 
 * @param request
 * @param response
 * @param paramsRequest
 * @throws SWBResourceException
 * @throws IOException 
 */
    public void doGraph(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        //super.doView(request, response, paramsRequest); //To change body of generated methods, choose Tools | Templates.

        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "graph.jsp";
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
    
    /**
     * 
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException 
     */
    public void doGetFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String action = request.getParameter("act");
        String metaformat = request.getParameter("mformat");
        String dsuri = request.getParameter("suri");

        if (null == action) {
            action = "";
        }
        if (null != metaformat) {
            metaformat = META_FORMAT_RDF;
        }

        User user = paramRequest.getUser();
        String fid = request.getParameter("fid");
        String verNumber = request.getParameter("verNum");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = null;
        GenericObject gobj = null;

        if ("meta".equals(action)) {

            obj = ont.getSemanticObject(dsuri);
            if (obj != null && obj.createGenericInstance() instanceof Dataset) {
                Dataset ds = (Dataset) obj.createGenericInstance();
                boolean dowloaded = LODPUtils.updateDSDownload(ds);
                
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

                } else if (META_FORMAT_JSON.equals(metaformat)) {
                    //Se crea JSON con meta del Dataset

                    response.setContentType("Content-Type: application/json");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + dsname + ".json\";");
                    try {
                        JSONObject json = new JSONObject();
                        Iterator<SemanticProperty> itsemprop = ds.getSemanticObject().listProperties();
                        while (itsemprop.hasNext()) {
                            SemanticProperty semprop = itsemprop.next();
                        }
                    } catch (Exception e) {
                        log.error("Error al exportar el Dataset a JSON", e);
                    }
                } else {
                    //format not supported
                }
            }
        } else if ("file".equals(action)) {


            int intVer = 1;
            if (verNumber != null) {
                intVer = Integer.parseInt(verNumber);
            }


            if (null != fid) {
                obj = ont.getSemanticObject(fid);
            }
            if (obj != null) {
                gobj = obj.createGenericInstance();
            }

            Dataset doc = null;
            if (gobj instanceof Dataset) {
                doc = (Dataset) gobj;
            }

            if (doc != null) {


                DatasetVersion ver = null;
                DatasetVersion vl = doc.getLastVersion();
                if (null != vl) {
                    ver = vl;
                    while (ver.getPreviousVersion() != null) { //
                        if (ver.getVersion() == intVer) {
                            break;
                        }
                        ver = ver.getPreviousVersion();
                    }
                }
                try {
                    response.setContentType(DEFAULT_MIME_TYPE);
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + ver.getFilePath() + "\";");

                    OutputStream out = response.getOutputStream();
                    SWBUtils.IO.copyStream(new FileInputStream(SWBPortal.getWorkPath() + doc.getWorkPath() + "/" + verNumber + "/" + ver.getVersion()), out);
                } catch (Exception e) {
                    log.error("Error al obtener el archivo del Repositorio de documentos.", e);
                }
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals(MODE_FILE)){
            doGetFile(request, response, paramRequest);
        } else  if(paramRequest.getMode().equals(MODE_STATS)){
            doStat(request, response, paramRequest);
        } else  if(paramRequest.getMode().equals(MODE_GRAPH)){
            doGraph(request, response, paramRequest);
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
        User usr = response.getUser();
        Resource base = getResourceBase();
        Publisher pub = LODPUtils.getPublisher(usr);
        WebSite wsite = response.getWebPage().getWebSite();
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject so = null;
        GenericObject go = null;
        DatasetVersion ver = null;
        Date dsdate = new Date(System.currentTimeMillis());
        String suri = request.getParameter("suri");
        
            if(null!=suri&&suri.trim().length()>0){
                so = ont.getSemanticObject(suri);
            }
            Dataset ds = null;
            
    String dstitle = request.getParameter("dstitle");
    String dsdescription = request.getParameter("dsdescription");
    String dsemail = request.getParameter("dsemail");
    String dscreated = request.getParameter("dscreated");
    String dsupdated = request.getParameter("dsupdated");
    String dsformat = request.getParameter("dsformat");
    String dsversion = request.getParameter("dsversion");
    String dspubname= request.getParameter("dspubname");
    String dstoplevelname = request.getParameter("dstoplevelname");
    String dswebsite = request.getParameter("dswebsite");
    String dsurl = request.getParameter("dsurl");
            
        if(SWBActionResponse.Action_ADD.equals(action) || SWBActionResponse.Action_EDIT.equals(action)){
            String dsuri = null;
            
            if(null!=so){
                go = so.createGenericInstance();
                if(null!=go && go instanceof Dataset){
                    // se carga Dataset para actualizar datos.
                    ds = (Dataset)go;
                }
            }
            
            if(null==ds){
                // Se crea nuevo dataset y la version inicial
                ds = Dataset.ClassMgr.createDataset(wsite);
                ver = DatasetVersion.ClassMgr.createDatasetVersion(wsite);
                dsuri = ver.getURI();
                ver.setVerPublisher(pub);
                ver.setVerComment("Versión inicial");
                ver.setVersion(1);
                ds.setActualVersion(ver);
                ds.setDatasetCreated(dsdate);  
                //redireccionar para agregar archivo
                
            }

            //Se procesan parámetros
            String title = request.getParameter("dstitle");
            String descrition = request.getParameter("dsdescription");
            
            ds.setDatasetTitle(title);
            ds.setDatasetDescription(descrition);
            ds.setDatasetUpdated(dsdate);
            ds.setDatasetSector(null);
            
            // se necesita saber si el ds tiene alguna version 
            
            // se necesita redireccionar para el archivo del ds a subir
        } else if(action.equals("addVersion")){
            
            if(null!=so){
                go = so.createGenericInstance();
                if(null!=go && go instanceof Dataset){
                    // se carga Dataset para actualizar datos.
                    ds = (Dataset)go;
                    ver = ds.getActualVersion();
                }
            }
            ds.setDatasetUpdated(dsdate);
            DatasetVersion newver = DatasetVersion.ClassMgr.createDatasetVersion(wsite);
            newver.setPreviousVersion(ver);
            ver.setNextVersion(newver);
            newver.setVersion(ver.getVersion()+1);
            
            String wpiduploadfile = base.getAttribute("uploadfileid","Subir_archivo");

            SWBResourceURLImp urlredirect = new SWBResourceURLImp(request, getResourceBase(), response.getWebPage(), SWBResourceURLImp.UrlType_ACTION);
            urlredirect.setAction("addVersionStep2");
            urlredirect.setParameter("suri", ds.getEncodedURI());
            urlredirect.setParameter("dsveruri", newver.getEncodedURI());
            String returnurl = urlredirect.toString(true);
            
            //redireccionar para subir archivo
            //url en donde está el archivo
            //url de retorno para actualizar datos finales de la versión
            
            String redirectuploadfile = wsite.getWebPage(wpiduploadfile).getUrl()+"?suri="+ds.getEncodedURI()+"&returl="+returnurl;
            response.sendRedirect(redirectuploadfile);
            
        } else if(action.equals("addVersionStep2")){
            
            // se tendría que revisar si se subió correctamente el archivo
            // corecto si existe el nombre del archivo en la version del dataset
            
            //parametros
            String dsveruri = request.getParameter("dsveruri");
            // falta generar la ruta en donde se guardaran los archhivos
            String urlfilesystempath = base.getAttribute("filesystempath");
            if(null!=so){
                go = so.createGenericInstance();
                if(null!=go && go instanceof Dataset){
                    // se carga Dataset para actualizar datos.
                    ds = (Dataset)go;
                    ver = ds.getActualVersion();
                    if(null!=dsveruri&&dsveruri.equals(ver.getURI())){
                        if(ver.getFilePath()!=null&&ver.getFilePath().trim().length()>0){
                            File f = new File(urlfilesystempath+"/"+ver.getFilePath());
                            if(null!=f&&f.exists()&&f.isFile()){
                            long filesize = f.getTotalSpace()/1024;  //kbytes
                            
                            String fileformat = ver.getFilePath();
                            fileformat = fileformat.substring(fileformat.lastIndexOf(".")+1);
                            
                            ds.setDatasetSize(filesize);
                            ds.setDatasetFormat(dsurl);
                            }
                            
                        }
                    }
                }
            }
            ds.setDatasetUpdated(dsdate);
            DatasetVersion newver = DatasetVersion.ClassMgr.createDatasetVersion(wsite);
            newver.setPreviousVersion(ver);
            ver.setNextVersion(newver);
            newver.setVersion(ver.getVersion()+1);
            String newveruri = newver.getEncodedURI();
            
            SWBResourceURLImp urlredirect = new SWBResourceURLImp(request, getResourceBase(), response.getWebPage(), SWBResourceURLImp.UrlType_ACTION);
            urlredirect.setAction("addVersionStep2");
            urlredirect.setParameter("suri", ds.getEncodedURI());
            urlredirect.setParameter("dsveruri", newver.getEncodedURI());
            String returnurl = urlredirect.toString(true);
            
            
            //redireccionar para subir archivo
            //url en donde está el archivo
            //url de retorno para actualizar datos finales de la versión
            
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

        System.out.println("Ordenamiento...");
        Set set = null;
        if (null != orderby && DataSetResource.ORDER_CREATED.equals(orderby)) {
            set = sortByCreated(it, false);
        } else if (null != orderby && DataSetResource.ORDER_DOWNLOAD.equals(orderby)) {
            set = sortByDownloads(it, false);
        } else if (null != orderby && DataSetResource.ORDER_VIEW.equals(orderby)) {
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
                    d1 = ((Dataset) o1).getActualVersion().getVersionCreated();
                    d2 = ((Dataset) o2).getActualVersion().getVersionCreated();
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
                    d1 = ((Dataset) o1).getActualVersion().getVersionCreated();
                    d2 = ((Dataset) o2).getActualVersion().getVersionCreated();
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
                    long d1;
                    long d2;
                    d1 = ((Dataset) o1).getRanks();
                    d2 = ((Dataset) o2).getRanks();
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1;
                    long d2;
                    d1 = ((Dataset) o1).getRanks();
                    d2 = ((Dataset) o2).getRanks();
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
    
}
