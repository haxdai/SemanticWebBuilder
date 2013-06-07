/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Category;
import com.infotec.lodp.swb.Comment;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.Developer;
import com.infotec.lodp.swb.LicenseType;
import com.infotec.lodp.swb.Publisher;
import static com.infotec.lodp.swb.resources.DataSetResource.log;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
         User usr = response.getUser();
         WebSite ws = response.getWebPage().getWebSite();
         String dataSet = request.getParameter("dataSet")==null ? "" : request.getParameter("dataSet");
         
        if(action.equals(SWBResourceURL.Action_ADD)&& (usr.isSigned() && (usr.getSemanticObject().createGenericInstance() instanceof Developer || usr.getSemanticObject().createGenericInstance() instanceof Publisher))){
            
            if(!dataSet.equals("")){
                Application app = Application.ClassMgr.createApplication(ws); 
                String titleApp = request.getParameter("titleApp")==null ? "" : request.getParameter("titleApp");
                String descripcion = request.getParameter("descripcion")==null ? "" : request.getParameter("descripcion");
                String licencia = request.getParameter("licencia")==null ? "" : request.getParameter("licencia");  
                String cat = request.getParameter("idCat")==null ? "" : request.getParameter("idCat"); 
                String url = request.getParameter("url")==null ? "" : request.getParameter("url");
                LicenseType lic = LicenseType.ClassMgr.getLicenseType(licencia,ws);
                Dataset dataSetClass = Dataset.ClassMgr.getDataset(dataSet, ws);
                Category category = Category.ClassMgr.getCategory(cat,ws);
                app.setAppTitle(titleApp);
                app.setAppDescription(descripcion);         
                app.addRelatedDataset(dataSetClass);           
                app.setAppAuthor(usr.getSemanticObject());
                app.setAppLicense(lic);
                if(category!=null){
                    app.addCategory(category);
                }
                app.setAppValid(false);    
                app.setAppCreated(new Date());
                app.setAppURL(url); 
                response.setRenderParameter("msgExitoAPP", response.getLocaleString("msg_appExito"));
            }
            
        } else if (action.equals(SWBResourceURL.Action_EDIT)){
            String uri = request.getParameter("uri");
            SemanticObject semObj = SemanticObject.createSemanticObject(URLDecoder.decode(uri) );
            Application apl = (Application)semObj.createGenericInstance();
            System.out.println("Es el id del dataset :" + apl.getRelatedDataset().getId());
            String titleApp = request.getParameter("titleApp")==null ? "" : request.getParameter("titleApp");
            String descripcion = request.getParameter("descripcion")==null ? "" : request.getParameter("descripcion");
            String cat = request.getParameter("idCat")==null ? "" : request.getParameter("idCat"); 
            String licencia = request.getParameter("licencia")==null ? "" : request.getParameter("licencia"); 
            System.out.println("Es el id del dataset :" + dataSet);
            String url = request.getParameter("url")==null ? "" : request.getParameter("url");
            LicenseType lic = LicenseType.ClassMgr.getLicenseType(licencia,ws);
            Category category = Category.ClassMgr.getCategory(cat, ws);
            Dataset dataSetClass = Dataset.ClassMgr.getDataset(dataSet, ws);
            apl.setAppTitle(titleApp);
            apl.setAppDescription(descripcion);
            apl.addCategory(category);
            apl.getRelatedDataset().remove();
            apl.addRelatedDataset(dataSetClass);
            apl.setAppCreated(new Date());
            apl.setValid(false);
            apl.setAppAuthor(usr.getSemanticObject());
            apl.setAppLicense(lic);
            apl.setAppURL(url);  
            apl.setAppValid(false);
            response.setRenderParameter("msgExitoAPP", response.getLocaleString("msg_appExito"));
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
                    long d1;
                    long d2;
                    d1 = ((Application) o1).getRanks();
                    d2 = ((Application) o2).getRanks();
                    int ret = d1 > d2 ? 1 : -1;
                    return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1;
                    long d2;
                    d1 = ((Application) o1).getRanks();
                    d2 = ((Application) o2).getRanks();
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
                    String d1;
                    String d2;
                    d1 = ((Comment) o1).getComment();
                    d2 = ((Comment) o2).getComment();
                    if (d1 == null && d2 != null) {
                        return -1;
                    }
                    if (d1 != null && d2 == null) {
                        return 1;
                    }
                    if (d1 == null && d2 == null) {
                        return -1;
                    } else {
                        int ret = 1;
                        return ret;
                    }
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1;
                    String d2;
                    d1 = ((Comment) o1).getComment();
                    d2 = ((Comment) o2).getComment();
                    if (d1 == null && d2 != null) {
                        return -1;
                    }
                    if (d1 != null && d2 == null) {
                        return 1;
                    }
                    if (d1 == null && d2 == null) {
                        return -1;
                    } else {
                       int ret = -1;
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
