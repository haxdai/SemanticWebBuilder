/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Comment;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.Institution;
import static com.infotec.lodp.swb.resources.CommentsViewResource.log;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author Sabino
 */

public class StatisticsResource extends GenericAdmResource{   
    public static final String MODE_FILE = "file";    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, 
        SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() 
                    + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        request.setAttribute("paramRequest", paramRequest);
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
    
    public static List<String> getNameOfColumns (String idStatistic, SWBParamRequest paramRequest) throws SWBResourceException{
        List columns= new ArrayList();
        int opc = Integer.parseInt(idStatistic);        
        switch(opc){
            case 1:{                
                columns.add(0,paramRequest.getLocaleString("lbl_title_table_DSByInst"));
                columns.add(1,paramRequest.getLocaleString("lbl_col1_table_DSByInst"));
                columns.add(2,paramRequest.getLocaleString("lbl_col2_table_DSByInst"));
                break;
            }
            case 2:{
                columns.add(0,paramRequest.getLocaleString("lbl_title_table_AplByDS"));
                columns.add(1,paramRequest.getLocaleString("lbl_col1_table_AplByDS"));
                columns.add(2,paramRequest.getLocaleString("lbl_col2_table_AplByDS"));
                columns.add(3,paramRequest.getLocaleString("lbl_col3_table_AplByDS"));
                break;
            }
            case 3:{                
                columns.add(0,paramRequest.getLocaleString("lbl_title_table_UseDS"));
                columns.add(1,paramRequest.getLocaleString("lbl_col1_table_UseDS"));
                //columns.add(2,paramRequest.getLocaleString("lbl_col2_table_UseDS"));
                columns.add(2,paramRequest.getLocaleString("lbl_col3_table_UseDS"));
                columns.add(3,paramRequest.getLocaleString("lbl_col4_table_UseDS"));
                columns.add(4,paramRequest.getLocaleString("lbl_col5_table_UseDS"));
                columns.add(5,paramRequest.getLocaleString("lbl_col6_table_UseDS"));
                columns.add(6,paramRequest.getLocaleString("lbl_col7_table_UseDS"));
                break;
            }
            case 4:{                
                columns.add(0,paramRequest.getLocaleString("lbl_title_table_UseApp"));
                columns.add(1,paramRequest.getLocaleString("lbl_col1_table_UseApp"));
                //columns.add(2,paramRequest.getLocaleString("lbl_col2_table_UseApp"));
                columns.add(2,paramRequest.getLocaleString("lbl_col3_table_UseApp"));
                columns.add(3,paramRequest.getLocaleString("lbl_col4_table_UseApp"));
                columns.add(4,paramRequest.getLocaleString("lbl_col5_table_UseApp"));
                columns.add(5,paramRequest.getLocaleString("lbl_col6_table_UseApp"));
                columns.add(6,paramRequest.getLocaleString("lbl_col7_table_UseApp"));
                break;
            } 
            case 5:{                
                columns.add(0,paramRequest.getLocaleString("lbl_title_table_UsersSat"));
                columns.add(1,paramRequest.getLocaleString("lbl_col1_table_UserSat"));
                columns.add(2,paramRequest.getLocaleString("lbl_col2_table_UserSat"));
                columns.add(3,paramRequest.getLocaleString("lbl_col3_table_UserSat"));
                columns.add(4,paramRequest.getLocaleString("lbl_col4_table_UserSat"));
                break;
            }    
        }
        return columns;
    }
    
    public static Set<DSByIntBean> getDSByIntBean(WebSite wsite,String column,String asc){
        List<DSByIntBean> list = new ArrayList();
        Iterator<Institution> listInst= Institution.ClassMgr.listInstitutions(wsite);        
        while(listInst.hasNext()){            
            Institution institucion = listInst.next();
            Iterator<Dataset> listDS = Dataset.ClassMgr.listDatasetByInstitution(institucion, wsite);
            List<Dataset> ds = new ArrayList();
            while(listDS.hasNext()){
                Dataset dataset =listDS.next();
                if(dataset.isApproved() && dataset.isDatasetActive()){
                    ds.add(dataset);
                }
            }            
            DSByIntBean dsbyins = new DSByIntBean(institucion.getInstitutionTitle(),ds.size());
            list.add(dsbyins);
        }
        Set listArray = null;
        if(!list.isEmpty()){
            listArray = sortDSByInt(list.iterator(),column,asc);
        }
        return listArray;
    }
    
    public static Set<AplByDSBean> getAplByDS(WebSite wsite,String column,String asc){
        List<AplByDSBean> list = new ArrayList();
        Iterator<Dataset> listDS= Dataset.ClassMgr.listDatasets(wsite);
        while(listDS.hasNext()){
            Dataset ds = listDS.next();
            Iterator<Application> itAppl= Application.ClassMgr.listApplicationByRelatedDataset(ds, wsite);
            List<Application> app = new ArrayList();
            while(itAppl.hasNext()){
                Application application = itAppl.next();
                if(application.isAppValid()){
                    app.add(application);
                }
            }
            AplByDSBean aplbyds = new AplByDSBean(ds.getDatasetTitle(),ds.getInstitution().getInstitutionTitle(), app.size());            
            list.add(aplbyds);
        }
        Set listArray = null;
        if(!list.isEmpty()){
            listArray = sortAplByDs(list.iterator(),column,asc);
        }
        return listArray;
    }
    
    public static Set<UseDSBean> getDSUse(WebSite wsite,String column,String asc){
        List<UseDSBean> list = new ArrayList();
        Iterator<Institution> listInst= Institution.ClassMgr.listInstitutions(wsite);
        while(listInst.hasNext()){
            Institution institution = listInst.next();
            Iterator<Dataset> listDS = Dataset.ClassMgr.listDatasetByInstitution(institution, wsite);
            
            listDS = Dataset.ClassMgr.listDatasetByInstitution(institution, wsite);
            while(listDS.hasNext()){
                Dataset ds = listDS.next();
                if(ds.isApproved() && ds.isDatasetActive()){
                    UseDSBean useds = new UseDSBean(institution.getInstitutionTitle(),
                        ds.getDatasetTitle(),ds.getDownloads(),ds.getLastDownload(),ds.getViews(), 
                        ds.getLastView());
                    list.add(useds);
                }
            }
        }
        Set listArray = null;
        if(!list.isEmpty()){
            listArray = sortUseDS(list.iterator(),column,asc);
        }else{
            listArray = new HashSet();
        }
        return listArray;        
    }
    
    public static Set<UseAppBean> getAppUse(WebSite wsite,String column,String asc){        
        List<UseAppBean> list = new ArrayList();
        Iterator<Institution> listInst = Institution.ClassMgr.listInstitutions(wsite);
        while(listInst.hasNext()){
            Institution institution = listInst.next();
            Iterator<Dataset> listDS = Dataset.ClassMgr.listDatasetByInstitution(institution, wsite);
            
            listDS = Dataset.ClassMgr.listDatasetByInstitution(institution, wsite);
            while(listDS.hasNext()){
                Dataset ds = listDS.next();
                Iterator<Application> listApp = Application.ClassMgr.listApplicationByRelatedDataset(ds, wsite);
                while(listApp.hasNext()){
                    Application app = listApp.next();
                    if(app.isAppValid()){
                        UseAppBean useapp = new UseAppBean(institution.getInstitutionTitle(),
                                app.getAppTitle(),app.getDownloads(),app.getLastDownload(),
                                app.getViews(), app.getLastView());
                        list.add(useapp); 
                    }
                }    
            }            
        }            
        Set listArray = null;
        if(!list.isEmpty()){
            listArray = sortUseApp(list.iterator(),column,asc);
        }else{
            listArray = new HashSet();
        }
        return listArray;
    }
    
    public static Set<UsersSatBean> getUsersSat(WebSite wsite,String column,String asc){ 
        List<UsersSatBean> list = new ArrayList();
        Iterator<Institution> listInst = Institution.ClassMgr.listInstitutions(wsite);
        while(listInst.hasNext()){
            Institution institution = listInst.next();
            Iterator<Dataset> listDS = Dataset.ClassMgr.listDatasetByInstitution(institution, wsite);
            while(listDS.hasNext()){
                Dataset ds = listDS.next();
                if(ds.isApproved() && ds.isDatasetActive()){
                    long totComments=0;
                    Iterator<Comment> itComments = ds.listComments();
                    while (itComments.hasNext()){
                        itComments.next();
                        totComments++;
                    }
                    UsersSatBean userssat = new UsersSatBean(institution.getInstitutionTitle(),
                            ds.getDatasetTitle(),ds.getAverage(),totComments);
                    list.add(userssat); 
                }
            }
        }
        Set listArray = null;        
        if(!list.isEmpty()){            
            listArray = sortUsersDS(list.iterator(),column,asc);
        }else{
            listArray = new HashSet();
        } 
        return listArray;
    }
    
    public static String formatFecha(Date date){
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        String fecha=null;
        if(date != null){
             fecha=  df1.format(date);
        }else{
            fecha = "No disponible";
        }
        return fecha;
    }
    
    public void doGetFile(HttpServletRequest request, HttpServletResponse response, 
            SWBParamRequest paramRequest)throws SWBResourceException, IOException {
        response.reset();
        response.setHeader("Cache-Control", "must-revalidate");
        response.setHeader("Pragma", "must-revalidate");        
        response.setContentType("application/vnd.ms-excel");
        String statistic = request.getParameter("statistic");        
        List<String> columnNames = getNameOfColumns(statistic,paramRequest);
        response.setHeader("Content-Disposition", "attachment; filename=\""+columnNames.get(0)+".csv\";");
        String csv = "";
        for(int i=1;i<columnNames.size();i++){
            csv+=columnNames.get(i);
            if(i<columnNames.size()-1){
                csv+=",";
            }
            else{
                csv+="\n";
            }
        }                
        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();  
        String column = request.getParameter("column")==null?"1":request.getParameter("column");
        String asc = request.getParameter("asc")==null?"true":request.getParameter("asc");
        if(statistic.trim().equals("1")){
            Set<DSByIntBean> list = StatisticsResource.getDSByIntBean(wsite,column,asc);            
            for(DSByIntBean dsbyins: list){                
                csv+=dsbyins.getInstitution()+",";
                csv+=dsbyins.getNumDS()+"\n";
            }
        }
        if(statistic.trim().equals("2")){
            Set<AplByDSBean> list = StatisticsResource.getAplByDS(wsite,column,asc);            
            for(AplByDSBean aplbyds : list){
                csv+=aplbyds.getDataset()+",";
                csv+=aplbyds.getInstitution()+",";
                csv+=aplbyds.getNumApp()+"\n";               
            }
        }
        if(statistic.trim().equals("3")){
            Set<UseDSBean> list = StatisticsResource.getDSUse(wsite,column,asc);            
            for(UseDSBean useds : list){                
                csv+=useds.getInstitution()+",";
                csv+=useds.getDataset()+",";
                csv+=useds.getHits()+",";
                csv+=StatisticsResource.formatFecha(useds.getLastDownload())+",";
                csv+=useds.getViews()+",";
                csv+=StatisticsResource.formatFecha(useds.getLastView())+"\n";                
            }
        }
        if(statistic.trim().equals("4")){
            Set<UseAppBean> list = StatisticsResource.getAppUse(wsite,column,asc);            
            for(UseAppBean appl : list){
                csv+=appl.getInstitution()+",";
                csv+=appl.getApplication()+",";
                csv+=appl.getHits()+",";
                csv+=StatisticsResource.formatFecha(appl.getLastDownload())+",";
                csv+=appl.getViews()+",";
                csv+=StatisticsResource.formatFecha(appl.getLastView())+"\n";
            }
        }
        if(statistic.trim().equals("5")){
            Set<UsersSatBean> list = StatisticsResource.getUsersSat(wsite,column,asc);            
            for(UsersSatBean userssat : list){
                csv+=userssat.getInstitution()+",";
                csv+=userssat.getDataset()+",";
                csv+=userssat.getAverage()+",";                
                csv+=userssat.getNumComments()+"\n";
            }
        }
        OutputStream out = response.getOutputStream();        
        SWBUtils.IO.copyStream(SWBUtils.IO.getStreamFromString(csv), out);
    }
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals(MODE_FILE)){
            doGetFile(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static Set sortDSByInt(Iterator it, String attribute, String asc) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (asc.equals("true") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((DSByIntBean) o1).getInstitution();
                    String d2 = ((DSByIntBean) o2).getInstitution();                    
                    int ret = d1.compareTo(d2);                    
                    return ret;                    
                }
            });
        } else if (asc.equals("true") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((DSByIntBean) o1).getNumDS();
                    long d2 = ((DSByIntBean) o2).getNumDS();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((DSByIntBean) o1).getInstitution();
                    String d2 = ((DSByIntBean) o2).getInstitution();                    
                    int ret = d2.compareTo(d1);                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((DSByIntBean) o1).getNumDS();
                    long d2 = ((DSByIntBean) o2).getNumDS();                    
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }
    
    private static Set sortAplByDs(Iterator it, String attribute, String asc) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (asc.equals("true") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((AplByDSBean) o1).getDataset();
                    String d2 = ((AplByDSBean) o2).getDataset();                    
                    int ret = d1.compareTo(d2);                    
                    return ret;                    
                }
            });
        } else if (asc.equals("true") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((AplByDSBean) o1).getInstitution();
                    String d2 = ((AplByDSBean) o2).getInstitution();                    
                    int ret = d1.compareTo(d2)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((AplByDSBean) o1).getNumApp();
                    long d2 = ((AplByDSBean) o2).getNumApp();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((AplByDSBean) o1).getDataset();
                    String d2 = ((AplByDSBean) o2).getDataset();                    
                    int ret = d2.compareTo(d1);                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((AplByDSBean) o1).getInstitution();
                    String d2 = ((AplByDSBean) o2).getInstitution();                    
                    int ret = d2.compareTo(d1)<=0?-1:1;                    
                    return ret;                   
                }
            });
        }else if (asc.equals("false") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((AplByDSBean) o1).getNumApp();
                    long d2 = ((AplByDSBean) o2).getNumApp();                    
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }
    
    private static Set sortUseDS(Iterator it, String attribute, String asc) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        else if (asc.equals("true") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseDSBean) o1).getInstitution();
                    String d2 = ((UseDSBean) o2).getInstitution();                    
                    int ret = d1.compareTo(d2)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseDSBean) o1).getDataset();
                    String d2 = ((UseDSBean) o2).getDataset();                    
                    int ret = d1.compareTo(d2)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseDSBean) o1).getHits();
                    long d2 = ((UseDSBean) o2).getHits();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("4")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseDSBean) o1).getLastDownload();
                    Date d2 = ((UseDSBean) o2).getLastDownload();                    
                    int ret = d1.getTime()<d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("5")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseDSBean) o1).getViews();
                    long d2 = ((UseDSBean) o2).getViews();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("6")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseDSBean) o1).getLastView();
                    Date d2 = ((UseDSBean) o2).getLastView();                    
                    int ret = d1.getTime()<d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseDSBean) o1).getInstitution();
                    String d2 = ((UseDSBean) o2).getInstitution();                    
                    int ret = d2.compareTo(d1)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseDSBean) o1).getDataset();
                    String d2 = ((UseDSBean) o2).getDataset();                    
                    int ret = d2.compareTo(d1)<=0?-1:1;                    
                    return ret;                   
                }
            });
        }else if (asc.equals("false") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseDSBean) o1).getHits();
                    long d2 = ((UseDSBean) o2).getHits();                    
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("4")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseDSBean) o1).getLastDownload();
                    Date d2 = ((UseDSBean) o2).getLastDownload();                    
                    int ret = d1.getTime()>d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("5")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseDSBean) o1).getViews();
                    long d2 = ((UseDSBean) o2).getViews();                    
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("6")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseDSBean) o1).getLastView();
                    Date d2 = ((UseDSBean) o2).getLastView();                    
                    int ret = d1.getTime()>d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }
        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }
    
    private static Set sortUseApp(Iterator it, String attribute, String asc) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
         else if (asc.equals("true") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseAppBean) o1).getInstitution();
                    String d2 = ((UseAppBean) o2).getInstitution();                    
                    int ret = d1.compareTo(d2)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseAppBean) o1).getApplication();
                    String d2 = ((UseAppBean) o2).getApplication();                    
                    int ret = d1.compareTo(d2)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseAppBean) o1).getHits();
                    long d2 = ((UseAppBean) o2).getHits();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("4")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseAppBean) o1).getLastDownload();
                    Date d2 = ((UseAppBean) o2).getLastDownload();                    
                    int ret = d1.getTime()<d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("5")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseAppBean) o1).getViews();
                    long d2 = ((UseAppBean) o2).getViews();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("6")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseAppBean) o1).getLastView();
                    Date d2 = ((UseAppBean) o2).getLastView();                    
                    int ret = d1.getTime()<d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseAppBean) o1).getInstitution();
                    String d2 = ((UseAppBean) o2).getInstitution();                    
                    int ret = d2.compareTo(d1)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UseAppBean) o1).getApplication();
                    String d2 = ((UseAppBean) o2).getApplication();                    
                    int ret = d2.compareTo(d1)<=0?-1:1;                    
                    return ret;                   
                }
            });
        }else if (asc.equals("false") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseAppBean) o1).getHits();
                    long d2 = ((UseAppBean) o2).getHits();                    
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("4")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseAppBean) o1).getLastDownload();
                    Date d2 = ((UseAppBean) o2).getLastDownload();                    
                    int ret = d1.getTime()>d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("5")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UseAppBean) o1).getViews();
                    long d2 = ((UseAppBean) o2).getViews();                    
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("6")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Date d1 = ((UseAppBean) o1).getLastView();
                    Date d2 = ((UseAppBean) o2).getLastView();                    
                    int ret = d1.getTime()>d2.getTime()?-1:1;                    
                    return ret;                    
                }
            });
        }
        while (it.hasNext()) {
            set.add(it.next());
        }
        return set;
    }
    
    private static Set sortUsersDS(Iterator it, String attribute, String asc) {
        TreeSet set = null;
        if (it == null) {
            return null;
        }
        if (asc.equals("true") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UsersSatBean) o1).getInstitution();
                    String d2 = ((UsersSatBean) o2).getInstitution();                    
                    int ret = d1.compareTo(d2)<=0?-1:1;                    
                    return ret;                    
                }
            });
        } else if (asc.equals("true") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UsersSatBean) o1).getDataset();
                    String d2 = ((UsersSatBean) o2).getDataset();                    
                    int ret = d1.compareTo(d2);                    
                    return ret;                    
                }
            });
        }else if (asc.equals("true") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    float d1 = ((UsersSatBean) o1).getAverage();
                    float d2 = ((UsersSatBean) o2).getAverage();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }if (asc.equals("true") && attribute.equals("4")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UsersSatBean) o1).getNumComments();
                    long d2 = ((UsersSatBean) o2).getNumComments();                    
                    int ret = d1<d2?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("1")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UsersSatBean) o1).getInstitution();
                    String d2 = ((UsersSatBean) o2).getInstitution();                    
                    int ret = d2.compareTo(d1)<=0?-1:1;                    
                    return ret;                    
                }
            });
        }else if (asc.equals("false") && attribute.equals("2")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    String d1 = ((UsersSatBean) o1).getDataset();
                    String d2 = ((UsersSatBean) o2).getDataset();                    
                    int ret = d2.compareTo(d1);                    
                    return ret;                   
                }
            });
        }else if (asc.equals("false") && attribute.equals("3")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    float d1 = ((UsersSatBean) o1).getAverage();
                    float d2 = ((UsersSatBean) o2).getAverage();                     
                    int ret = d1>d2?-1:1;                    
                    return ret;                    
                }
            });
        }if (asc.equals("false") && attribute.equals("4")) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                    long d1 = ((UsersSatBean) o1).getNumComments();
                    long d2 = ((UsersSatBean) o2).getNumComments();                    
                    int ret = d1>d2?-1:1;                    
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