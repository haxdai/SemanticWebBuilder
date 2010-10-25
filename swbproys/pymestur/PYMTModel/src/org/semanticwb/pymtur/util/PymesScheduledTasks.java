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
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.pymtur.Parameter;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class PymesScheduledTasks {

    private static Logger log = SWBUtils.getLogger(PymesScheduledTasks.class);

    private static SWBModel model=null;
    
    public PymesScheduledTasks(SWBModel model) {
        if(this.model!=null) {
            System.out.println("model en Timer:"+this.model.getURI());
            return;
        }
        this.model=model;
        
        //Inicio del timer
        Calendar hour2Start = Calendar.getInstance();
        hour2Start.set(hour2Start.get(hour2Start.YEAR), hour2Start.get(hour2Start.MONTH), hour2Start.get(hour2Start.DATE), 23, 59, 00); //Hora a las 11:59 pm

        Calendar timeNow = Calendar.getInstance(); //Hora actual

        long time2Start = hour2Start.getTimeInMillis() - timeNow.getTimeInMillis(); //Milisegundos para empezar por primera vez el timer

        int oneDay = 60 * 1000 * 60 * 24;
        Timer timer = new Timer();

        timer.schedule(new RemindTask(model), time2Start, oneDay); //Que empiece hoy a las 11:59 pm y vuelve a iterar un dia despues y así se siga

        //timer.schedule(new RemindTask(model), 0, 60 * 1000); //Cada minuto

    }

    class RemindTask extends TimerTask {

        SWBModel model = null;

        public RemindTask(SWBModel model) {
            this.model = model;
        }

        public void run() { //Lo que ejecutara cada x tiempo
            try {
                System.out.println("Ejecutando timer");
                ArrayList aPymesPagan = new ArrayList();
                ArrayList aPymesGratis = new ArrayList();
                ArrayList aAdminProviders = new ArrayList();
                Calendar calEmails = Calendar.getInstance();

                int maxDays2sendEmail=15;
                String sbodyparam="Cuerpo de correo";
                Parameter param=Parameter.ClassMgr.getParameter("MaxDays2sendEmail", model);
                Parameter bodyparam=Parameter.ClassMgr.getParameter("Body2sendEmail", model);
                try{
                    if(param!=null && param.getParamValue()!=null && param.getParamValue().trim().length()>0) maxDays2sendEmail=Integer.parseInt(param.getParamValue());
                    if(bodyparam!=null && bodyparam.getParamValue()!=null && bodyparam.getParamValue().trim().length()>0) {
                        sbodyparam=bodyparam.getParamValue();
                    }
                }catch(Exception e){log.error("El parametro MaxDays2sendEmail debe ser númerico", e); maxDays2sendEmail=15;}
                calEmails.add(calEmails.DATE, maxDays2sendEmail + 1); // 5 Es parametrizable (Número maximo de días apartir del cual se va ha empezar a enviar correos)
                Calendar calDisableAnnunce = Calendar.getInstance();
                Iterator<ServiceProvider> itProviders = ServiceProvider.ClassMgr.listServiceProviders(model);
                while (itProviders.hasNext()) {
                    ServiceProvider servProvider = itProviders.next();
                    Date spEndAnnunceDate = servProvider.getSpEndAnnuncePeriod();
                    if(servProvider.getSpStatus()==PymturUtils.ESTATUS_ACEPTADO || servProvider.getSpStatus()==PymturUtils.ESTATUS_PUBLICADO && spEndAnnunceDate!=null) //Solo si esta publicado el service provider
                    {
                        if (spEndAnnunceDate.before(calEmails.getTime())) { //Todos los anuncios que tengan una fecha de expiración
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
                        if (spEndAnnunceDate.before(calDisableAnnunce.getTime())) { //Todos los anuncios que tengan una fecha de expiración antes de la fecha actual
                            servProvider.setSpStatus(PymturUtils.ESTATUS_VENCIDA); //Considerando que se desactivaría la pyme, pero ya la pyme ya se acepto y se pagó
                        }
                    }
                }
                
                Role adminProviderRole = SWBContext.getWebSite("ss").getUserRepository().getRole("adminProviders");
                Iterator <User> itUsers=User.ClassMgr.listUserByRole(adminProviderRole, model);
                while(itUsers.hasNext()){
                    User user=itUsers.next();
                    String admProvEmail=user.getEmail();
                    if (admProvEmail != null && admProvEmail.trim().length() > 0 && admProvEmail.indexOf("@") > -1 && admProvEmail.indexOf(".") > -1) {
                        InternetAddress interAddress = new InternetAddress();
                        interAddress.setAddress(admProvEmail);
                        aAdminProviders.add(interAddress);
                    }
                }


                if (aPymesPagan != null && aPymesPagan.size() > 0) { //Enviar correos en backgraound a los usuarios que PAGAN y que esta por vencerseles el periodo de publicicación de su anuncio
                    try {
                        SWBUtils.EMAIL.sendBGEmail(null, null, aPymesPagan, null, null, "Recordatorio de caducidad de anuncio", "html", sbodyparam, null, null, null);
                        //Envío de correo a los AdminProviders, para que también esten enterados
                        SWBUtils.EMAIL.sendBGEmail(null, null, aAdminProviders, null, null, "Recordatorio de caducidad de anuncio", "html", sbodyparam, null, null, null);
                    } catch (SocketException e) {
                        log.error(e);
                    }
                }
                if (aPymesGratis != null && aPymesGratis.size() > 0) { //Enviar correos en backgraound a los usuarios que NO PAGAN y que esta por vencerseles el periodo de publicicación de su anuncio
                    try {
                        SWBUtils.EMAIL.sendBGEmail(null, null, aPymesGratis, null, null, "Recordatorio de caducidad de anuncio", "html", sbodyparam, null, null, null);
                        //Envío de correo a los AdminProviders, para que también esten enterados
                        SWBUtils.EMAIL.sendBGEmail(null, null, aAdminProviders, null, null, "Recordatorio de caducidad de anuncio", "html", sbodyparam, null, null, null);
                    } catch (SocketException e) {
                        log.error(e);
                    }
                }
                System.out.println("Termina de ejecutar timer");
                //System.exit(0); //Detiene la ejecución de todo
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
