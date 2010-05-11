/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.pymtur.util;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.internet.InternetAddress;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBModel;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class PymesScheduledTasks {

    private static Logger log = SWBUtils.getLogger(PymesScheduledTasks.class);
    Timer timer;

    public PymesScheduledTasks(SWBModel model) {
        //Inicio del timer
        Calendar hour2Start = Calendar.getInstance();
        hour2Start.set(hour2Start.get(hour2Start.YEAR), hour2Start.get(hour2Start.MONTH), hour2Start.get(hour2Start.DATE), 23, 59, 00); //Hora a las 11:59 pm

        Calendar timeNow = Calendar.getInstance(); //Hora actual

        long time2Start = hour2Start.getTimeInMillis() - timeNow.getTimeInMillis(); //Milisegundos para empezar por primera vez el timer

        int oneDay = 60 * 1000 * 60 * 24;
        timer = new Timer();
        timer.schedule(new RemindTask(model), 0, 60 * 1000);
    }

    class RemindTask extends TimerTask {

        SWBModel model = null;

        public RemindTask(SWBModel model) {
            this.model = model;
        }

        public void run() { //Lo que ejecutara cada x tiempo
            try {
                ArrayList aPymesPagan = new ArrayList();
                ArrayList aPymesGratis = new ArrayList();
                Calendar calEmails = Calendar.getInstance();
                Calendar calDisableAnnunce = Calendar.getInstance();
                calEmails.add(calEmails.DATE, 5 + 1); // 5 Es parametrizable (Número maximo de días apartir del cual se va ha empezar a enviar correos)
                calDisableAnnunce.add(calDisableAnnunce.DATE, 5);
                Iterator<ServiceProvider> itProviders = ServiceProvider.ClassMgr.listServiceProviders(model);
                while (itProviders.hasNext()) {
                    ServiceProvider servProvider = itProviders.next();
                    Date spEndAnnunceDate = servProvider.getSpEndAnnuncePeriod();
                    if (spEndAnnunceDate != null && spEndAnnunceDate.before(calEmails.getTime())) { //Todos los anuncios que tengan una fecha de expiración
                        if (servProvider.getPymePaqueteType() > PymturUtils.PAQ_FICHA) { //Se envía un cierto cuerpo de correo (anuncios de pymes gratuitos que pagan)
                            String spEmail = servProvider.getContactEmail();
                            if (spEmail != null && spEmail.trim().length() > 0 && spEmail.indexOf("@") > -1 && spEmail.indexOf(".") > -1) {
                                InternetAddress interAddress = new InternetAddress();
                                interAddress.setAddress(spEmail);
                                aPymesPagan.add(interAddress);
                            }
                        } else if (servProvider.getPymePaqueteType() <= PymturUtils.PAQ_MICROSITIO) { //Se envía un cierto cuerpo de correo (anuncios de pymes gratuitos)
                            String spEmail = servProvider.getContactEmail();
                            if (spEmail != null && spEmail.trim().length() > 0 && spEmail.indexOf("@") > -1 && spEmail.indexOf(".") > -1) {
                                InternetAddress interAddress = new InternetAddress();
                                interAddress.setAddress(spEmail);
                                aPymesGratis.add(interAddress);
                            }
                        }
                    }
                    if (spEndAnnunceDate != null && spEndAnnunceDate.compareTo(calDisableAnnunce.getTime()) >= 0) { //Todos los anuncios que tengan una fecha de expiración
                        servProvider.setSpStatus(PymturUtils.ESTATUS_DESACTIVADO); //Considerando que se desactivaría la pyme
                    }
                }
                if (aPymesPagan != null && aPymesPagan.size() > 0) { //Enviar correos en backgraound a los usuarios que PAGAN y que esta por vencerseles el periodo de publicicación de su anuncio
                    try {
                        SWBUtils.EMAIL.sendBGEmail("pymestur@infotec.com.mx", "PymesTur", aPymesPagan, null, null, "Recordatorio de caducidad de anuncio", "html", "Cuerpo de correo aqui", null, null, null);
                    } catch (SocketException e) {
                        log.error(e);
                    }
                }
                if (aPymesGratis != null && aPymesGratis.size() > 0) { //Enviar correos en backgraound a los usuarios que NO PAGAN y que esta por vencerseles el periodo de publicicación de su anuncio
                    try {
                        SWBUtils.EMAIL.sendBGEmail("pymestur@infotec.com.mx", "PymesTur", aPymesGratis, null, null, "Recordatorio de caducidad de anuncio", "html", "Cuerpo de correo aqui", null, null, null);
                    } catch (SocketException e) {
                        log.error(e);
                    }
                }
                //System.exit(0); //Detiene la ejecución de todo
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
