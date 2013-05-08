/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.utils;

import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.DatasetLog;

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
    
    /*
     *  Agrega Acción realizada a determinado DataSet
     */
    public static boolean addDSLog(WebSite wsite, Dataset ds, User usr, String description){
        boolean ret = Boolean.FALSE;
        
        try {
            DatasetLog dslog = DatasetLog.ClassMgr.createDatasetLog(wsite);
            dslog.setDataset(ds);
            dslog.setLogUser(usr);
            dslog.setLogDescription(description);
            dslog.setLogCreated(new java.util.Date(System.currentTimeMillis()));
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al generar el log del DataSet",e);
            ret = Boolean.FALSE;
        }
        
        return ret;
    }
}
