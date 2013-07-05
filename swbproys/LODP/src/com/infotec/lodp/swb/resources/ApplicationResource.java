/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Category;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.Developer;
import com.infotec.lodp.swb.LicenseType;
import com.infotec.lodp.swb.Publisher;
import static com.infotec.lodp.swb.resources.DataSetResource.log;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.mail.internet.InternetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SWBMail;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author Lennin
 */
public class ApplicationResource extends GenericAdmResource{
    
    public static final String MODE_TERMINOS = "ACEPTATERMINOS";
    public static final String ADD_APPLICATION = "ADDAPPLICATION";
    public static final String REDIRECT_URL = "URLREDIRECT";
    public static final String ORDER_RANK = "rank";
    public static final String ORDER_COMMENTS = "comments";
    public static final String ORDER_CREATED = "date";
    public static final String FILTER_CATEGORY = "categoria";
    public static final String FILTER_INSTITUTION = "institution";
    public static final String FILTER_AUTHOR = "autor";
    public static final String ADMIN_COMMENT = "SECCADMIN";


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
      
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
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
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        
            if(mode.equals(ADD_APPLICATION)){
                doAddApplication(request, response, paramRequest);
            }else if(mode.equals(MODE_TERMINOS)){
                viewConditions(request, response, paramRequest);
            }else if(mode.equals(REDIRECT_URL)){
                redirectURL(request, response, paramRequest);
            }else if (mode.equals(ADMIN_COMMENT)){
                adminApp(request, response, paramRequest);
            }      
            else{
                super.processRequest(request, response, paramRequest);
            }
    
    }
    
    public void doAddApplication(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "addApplication.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {  
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    
    public void viewConditions(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "terminosCondiciones.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {  
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "editApplication.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try { 
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
       
    }
    
    public void redirectURL(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String uri = request.getParameter("uri");
        SemanticObject semObj = SemanticObject.createSemanticObject(URLDecoder.decode(SemanticObject.shortToFullURI(uri)));
        Application apl = (Application)semObj.createGenericInstance();
        apl.sendHit(request, paramRequest.getUser(), paramRequest.getWebPage());
        response.sendRedirect(apl.getAppURL());
    }
    
     public void adminApp(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String uri = request.getParameter("uri");
        SemanticObject semObj = SemanticObject.createSemanticObject(URLDecoder.decode(SemanticObject.shortToFullURI(uri)));
        Application apl = (Application)semObj.createGenericInstance();
        apl.sendHit(request, paramRequest.getUser(), paramRequest.getWebPage());
        response.sendRedirect(apl.getAppURL());
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        User usr = response.getUser();
        WebSite ws = response.getWebPage().getWebSite();
        String[] itAppList = request.getParameterValues("dataSet");
         
        if(action.equals(SWBResourceURL.Action_ADD)&& (usr.isSigned() && (usr.getSemanticObject().createGenericInstance() instanceof Developer || usr.getSemanticObject().createGenericInstance() instanceof Publisher))){
            
                Application app = Application.ClassMgr.createApplication(ws);
                
                         
                String titleApp = request.getParameter("titleApp")==null ? "" : request.getParameter("titleApp");
                String descripcion = request.getParameter("descripcion")==null ? "" : request.getParameter("descripcion");
                String licencia = request.getParameter("licencia")==null ? "" : request.getParameter("licencia");  
                String cat = request.getParameter("idCat")==null ? "" : request.getParameter("idCat"); 
                String url = request.getParameter("url")==null ? "" : request.getParameter("url");
                LicenseType lic = LicenseType.ClassMgr.getLicenseType(licencia,ws);
                Category category = Category.ClassMgr.getCategory(cat,ws);
                app.setAppTitle(titleApp);
                app.setAppDescription(descripcion);   
                
                for(int i=0; i<itAppList.length; i++){
                    Dataset dataSetClass = Dataset.ClassMgr.getDataset(itAppList[i], ws);
                    app.addRelatedDataset(dataSetClass); 
                } 
                
                app.setAppAuthor(usr.getSemanticObject());
                app.setAppLicense(lic);
                
                if(category!=null){
                    app.setCategory(category);
                }
                app.setApproved(false);
                app.setReviewed(false);
                app.setAppCreated(new Date());
                app.setAppURL(url); 
                response.setRenderParameter("msgExitoAPP", response.getLocaleString("msg_appExito"));
            
            
        } else if (action.equals(SWBResourceURL.Action_EDIT)){
            String uri = request.getParameter("uri");
            SemanticObject semObj = SemanticObject.createSemanticObject(URLDecoder.decode(uri) );
            Application apl = (Application)semObj.createGenericInstance();
            
            apl.removeAllRelatedDataset();
            
            String titleApp = request.getParameter("titleApp")==null ? "" : request.getParameter("titleApp");
            String descripcion = request.getParameter("descripcion")==null ? "" : request.getParameter("descripcion");
            String cat = request.getParameter("idCat")==null ? "" : request.getParameter("idCat"); 
            String licencia = request.getParameter("licencia")==null ? "" : request.getParameter("licencia"); 
            String url = request.getParameter("url")==null ? "" : request.getParameter("url");
            LicenseType lic = LicenseType.ClassMgr.getLicenseType(licencia,ws);
            Category category = Category.ClassMgr.getCategory(cat, ws);
            
            for(int i=0; i<itAppList.length; i++){
                Dataset dataSetClass = Dataset.ClassMgr.getDataset(itAppList[i], ws);
                apl.addRelatedDataset(dataSetClass);
            }
            
            apl.setAppTitle(titleApp);
            apl.setAppDescription(descripcion);
            apl.setCategory(category);
            apl.setAppCreated(new Date());
            apl.setValid(false);
            apl.setAppAuthor(usr.getSemanticObject());
            apl.setAppLicense(lic);
            apl.setAppURL(url);  
            apl.setApproved(false);
            apl.setReviewed(false);
            response.setRenderParameter("msgExitoAPP", response.getLocaleString("msg_appExito"));
            
        }else if(action.equals(ADMIN_COMMENT)){
            String appUri = request.getParameter("appUri");
            String comment = request.getParameter("commentAPPAdmin");
            String btnApprove = request.getParameter("btnApprove");
            String btnReject = request.getParameter("btnReject");
            String lenguaje = "";
            String correo = "";
            
            if(null!=appUri && appUri.trim().length()>0){
                
                SemanticObject so = SemanticObject.getSemanticObject(SemanticObject.shortToFullURI(appUri));
                
                if(null!=so){
                    
                    Application app = (Application) so.createGenericInstance();
                    app.setReviewed(Boolean.TRUE);
                    String mensaje = "";
                    
                    if(null!=app){
                        
                        if(null!=btnApprove){
                            app.setApproved(Boolean.TRUE);
                           
                        } else if(null!=btnReject){
                            app.setApproved(Boolean.FALSE);
                        }
        
            // Envio de notificación al usuario creador
            GenericObject ob = app.getAppAuthor().createGenericInstance();

            if(ob instanceof Developer  ){
                Developer db = (Developer)ob ;
                lenguaje= db.getLanguage();
                correo = db.getEmail();
            }

            if(ob instanceof Publisher){
                Publisher pb = (Publisher)ob ;
                lenguaje= pb.getLanguage();
                correo = pb.getEmail();
                
            }  
                                         
            if(!correo.equals("")){
                try {
                if(SWBUtils.EMAIL.isValidEmailAddress(correo)){
                   InternetAddress intaddr = new InternetAddress(correo);
                   ArrayList<InternetAddress> arr = new ArrayList<InternetAddress>();
                   arr.add(intaddr);
                   SWBMail mail = new SWBMail();
                   mail.setToEmail(arr);
                   String fromEmail = SWBPortal.getEnv("af/adminEmail","webbuilder@infotec.com.mx");
                   mail.setFromEmail(fromEmail);
                   mail.setFromName("WebMaster");

                   // falta armar el mensaje para el envio del correo
//                   String subject = "Notificación Revisión Dataset "+ds.getDatasetTitle();   // cambiar por properties
                   if( lenguaje.equals("es") && app.isApproved() ) { 
                        mensaje = getResourceBase().getAttribute("msjAPPAprobada_es","");
                    } else if( lenguaje.equals("es") && !app.isApproved() ) { 
                        mensaje = getResourceBase().getAttribute("msjAPPRechazada_es","");
                    } else  if( lenguaje.equals("en") && app.isApproved() ) { 
                        mensaje = getResourceBase().getAttribute("msjAPPAprobada_en","");
                    } else if( lenguaje.equals("en") && !app.isApproved() ) { 
                        mensaje = getResourceBase().getAttribute("msjAPPRechazada_en","");
                    } else  if( app.isApproved() ) { 
                        mensaje = getResourceBase().getAttribute("msjAPPAprobada_es","");
                    } else if(  !app.isApproved() ) { 
                        mensaje = getResourceBase().getAttribute("msjAPPRechazada_es","");
                    } 

                   if(comment!=null){
                       mensaje = "<br/><br/>"+comment;
                   }
                   
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
        response.setMode(SWBResourceURL.Mode_VIEW);
    }
    
    public static Iterator<Application> orderDS(Iterator<Application> it, String orderby) {

        Set set = null;
        
        if (null != orderby && ApplicationResource.ORDER_RANK.equals(orderby)) {
            set = sortByRank(it, false);
        } else if (null != orderby && ApplicationResource.ORDER_COMMENTS.equals(orderby)) {
            set = sortByComments(it, false);
        } else if (null != orderby && ApplicationResource.ORDER_CREATED.equals(orderby)) {
            set = sortByCreated(it, false);
        } else {
            set = new TreeSet();
            while (it.hasNext()) {
                Application aplication = it.next();
                set.add(aplication);
            }
        }

        return set.iterator();
    }
    
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
                    d1 = ((Application) o1).getAverage();
                    d2 = ((Application) o2).getAverage();
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    float d1;
                    float d2;
                    d1 = ((Application) o1).getAverage();
                    d2 = ((Application) o2).getAverage();
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
    
    private static Set sortByComments(Iterator it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    
                    Iterator<Application> itapp = ((Application) o1).listComments();
                    Iterator<Application> itapp1 = ((Application) o2).listComments();
                    
                    long d1 = 0;
                    long d2 = 0;
                    
                    while(itapp.hasNext()){
                       d1= d1++;
                    }
                    
                    while(itapp1.hasNext()){
                       d2 = d2++;
                    }
                    
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Iterator<Application> itapp = ((Application) o1).listComments();
                    Iterator<Application> itapp1 = ((Application) o2).listComments();
                    
                    long d1 = 0;
                    long d2 = 0;
                    
                    while(itapp.hasNext()){
                       d1= d1++;
                    }
                    
                    while(itapp1.hasNext()){
                       d2 = d2++;
                    }
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
    
    public static Set sortByCreated(Iterator<Application> it, boolean ascendente) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1;
                    Date d2;
                    d1 = ((Application) o1).getAppCreated();
                    d2 = ((Application) o2).getAppCreated();
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
                    d1 = ((Application) o1).getAppCreated();
                    d2 = ((Application) o2).getAppCreated();
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
                
}
