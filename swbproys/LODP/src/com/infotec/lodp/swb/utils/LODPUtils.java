/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.utils;

import com.infotec.lodp.swb.Application;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.DatasetLog;
import com.infotec.lodp.swb.Tag;
import java.util.Date;
import java.util.Iterator;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;

/**
 *
 * @author juan.fernandez
 */
public class LODPUtils {
    public static final Logger log = SWBUtils.getLogger(LODPUtils.class);
    public static final int Log_Type_View = 1;
    public static final int Log_Type_Download = 2;
    public static final int Log_Type_Other = 3;
    
    /**
     * 
     *  Agrega Acción realizada a determinado DataSet
     */
    public static boolean addDSLog(WebSite wsite, Dataset ds, User usr, String description, int type){
        boolean ret = Boolean.FALSE;
        
        try {
            DatasetLog dslog = DatasetLog.ClassMgr.createDatasetLog(wsite);
            dslog.setDataset(ds);
            dslog.setLogUser(usr);
            dslog.setLogDescription(description);
            dslog.setLogType(type);
            dslog.setLogCreated(new java.util.Date(System.currentTimeMillis()));
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al generar el log del DataSet",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
    
    /**
     *  Update lastupdate information of the dataset
     * @param ds dataset to update date information
     * @return true or false
     */
    public static boolean updateDSLastUpdate(Dataset ds){
        boolean ret = Boolean.FALSE;  
        try {
            Date now = new Date(System.currentTimeMillis());
            ds.setDatasetUpdated(now);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al actualizar la fecha de ultima actualización del DataSet",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
   
    /**
     *  Add last download date and update number of downloads
     * @param ds dataset to modify download information
     * @return true or false
     */
    public static boolean updateDSDownload(Dataset ds){
        boolean ret = Boolean.FALSE;  
        try {
            Date now = new Date(System.currentTimeMillis());
            ds.setLastDownload(now);
            long downloads = 0;
            try {
                downloads = ds.getDownloads();
                downloads++;
            } catch (Exception e) {
                downloads=1;
            }
            ds.setDownloads(downloads);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al actualizar la información de descargas del DataSet",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
    
    /**
     * Updates dataset views information and last view date
     * @param ds dataset to modify views information
     * @return true or false
     */
    public static boolean updateDSViews(Dataset ds){
        boolean ret = Boolean.FALSE;  
        try {
            Date now = new Date(System.currentTimeMillis());
            ds.setLastView(now);
           
            long views = 0;
            try {
                views = ds.getViews();
                views++;
            } catch (Exception e) {
                views=1;
            }
            ds.setViews(views);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al actualizar la información de vistas del DataSet",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
    
    /**
     *  Update dataset evaluated information 
     * @param ds dataset to modify evaluated information
     * @param value, user value of evaluated dataset
     * @return 
     */
    public static boolean updateDSRank(Dataset ds, float value){
        boolean ret = Boolean.FALSE;  
        try {
            //Date now = new Date(System.currentTimeMillis());
            //ds.setLastDownload(now);
            float average = value;
            long ranks = 0;
            try {
                ranks = ds.getRanks();
                
                if(ranks>0){
                    float promedio = ds.getAverage();
                    average = (promedio * ranks)/(ranks+1);
                    ds.setAverage(promedio);
                }  else if(ranks==0){
                    ds.setAverage(average);
                }
                ranks++;
                ds.setRanks(ranks);
            } catch (Exception e) {
                ranks=0;
            }
            ds.setRanks(ranks);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al actualizar la información de valoración del DataSet",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
    
    /**
     *  Update application evaluated information 
     * @param app application to modify evaluated information
     * @param value,  value of evaluated application
     * @return 
     */
    public static boolean updateAppRank(Application app, float value){
        boolean ret = Boolean.FALSE;  
        try {
            //Date now = new Date(System.currentTimeMillis());
            //ds.setLastDownload(now);
            float average = value;
            long ranks = 0;
            try {
                ranks = app.getRanks();
                
                if(ranks>0){
                    float promedio = app.getAverage();
                    average = (promedio * ranks)/(ranks+1);
                    app.setAverage(promedio);
                }  else if(ranks==0){
                    app.setAverage(average);
                }
                ranks++;
                app.setRanks(ranks);
            } catch (Exception e) {
                ranks=0;
            }
            app.setRanks(ranks);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al actualizar la información de valoración del Aplicacion",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
    
        /**
     * Updates application views information and last view date
     * @param app application to modify views information
     * @return true or false
     */
    public static boolean updateAppViews(Application app){
        boolean ret = Boolean.FALSE;  
        try {
            Date now = new Date(System.currentTimeMillis());
            app.setLastView(now);
           
            long views = 0;
            try {
                views = app.getViews();
                views++;
            } catch (Exception e) {
                views=1;
            }
            app.setViews(views);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al actualizar la información de vistas de la Aplicacion",e);
            ret = Boolean.FALSE;
        }
        return ret;
    }
    
    public static final String getDSTagList(Dataset ds){
        StringBuilder ret = new StringBuilder("");
        if(null!=ds && ds.listTags().hasNext()){
            Iterator<Tag> ittag = ds.listTags();
            while (ittag.hasNext()) {
                Tag tag = ittag.next();
                ret.append(tag.getTagName()!=null?tag.getTagName().trim():"");
                if(ittag.hasNext()){
                    ret.append(" ");
                }
            }
        }
        return ret.toString();
    }
    
}
