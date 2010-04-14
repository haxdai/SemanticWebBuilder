/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.util;

import java.util.Date;
import java.util.Iterator;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.pymtur.PymesLog;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class PymturUtils {

    public static final int Registrado=1;
    public static final int Pagado=2;
    public static final int Aclaracion=3;
    public static final int Activado=4;
    public static final int Desactivado=5;
    public static final int Rechazado=6;
    public static final int Baja=7;

    public static boolean logServiceProvider(ServiceProvider serviceProvider, int status, String comment, User user, SWBModel model){
        PymesLog pymesLog=PymesLog.ClassMgr.createPymesLog(model);
        pymesLog.setServiceProviderLog(serviceProvider);
        pymesLog.setSpLogStatus(status);
        pymesLog.setSpLogStatusComment(comment);
        pymesLog.setLogUser(user);
        pymesLog.setLogDate(new Date());

        Iterator <PymesLog> itPymesLog=PymesLog.ClassMgr.listPymesLogs();
        while(itPymesLog.hasNext()){
            PymesLog plog=itPymesLog.next();
            System.out.println("plog sp:"+plog.getServiceProviderLog());
            System.out.println("plog stat:"+plog.getSpLogStatus());
            System.out.println("plog comment:"+plog.getSpLogStatusComment());
            System.out.println("plog user:"+plog.getLogUser());
            System.out.println("plog date:"+plog.getLogDate());
        }


        return true;
    }

}
