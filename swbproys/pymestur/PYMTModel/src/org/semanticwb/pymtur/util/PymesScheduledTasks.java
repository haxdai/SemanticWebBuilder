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
import org.semanticwb.pymtur.EmailText;
import org.semanticwb.pymtur.Parameter;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class PymesScheduledTasks {

    private static Timer timer;
    
    public static void init(SWBModel model) {
        if (timer == null) {
            timer = new Timer();
            //Inicio del timer
            Calendar hour2Start = Calendar.getInstance();
            hour2Start.set(hour2Start.get(Calendar.YEAR),
                    hour2Start.get(Calendar.MONTH),
                    hour2Start.get(Calendar.DATE), 23, 59, 00); //Hora a las 11:59 pm

            Calendar timeNow = Calendar.getInstance(); //Hora actual

            //Milisegundos para empezar por primera vez el timer
            long time2Start = hour2Start.getTimeInMillis() - timeNow.getTimeInMillis();

            int oneDay = 60 * 1000 * 60 * 24;

            //timer.schedule(new RemindTask(model), 0, 60 * 1000); //Cada minuto
            //Que empiece hoy a las 11:59 pm y vuelve a iterar un dia despues y así se siga
            timer.schedule(new RemindTask(model), time2Start, oneDay);
        }
    }
}


class RemindTask extends TimerTask {

    private static Logger log = SWBUtils.getLogger(RemindTask.class);

    SWBModel model = null;

    public RemindTask(SWBModel model) {
        this.model = model;
    }

    public void run() { //Lo que ejecutara cada x tiempo
        try {
            System.out.println("Ejecutando timer");
            ArrayList<InternetAddress> aPymesPagan = new ArrayList<InternetAddress>();
            ArrayList<InternetAddress> aPymesGratis = new ArrayList<InternetAddress>();
            ArrayList<InternetAddress> aAdminProviders = new ArrayList<InternetAddress>();
            Calendar calEmails = Calendar.getInstance();
            StringBuilder adminEmailTxt = new StringBuilder(128);
            String fromEmail = "mipymesturisticas@infotec.com.mx";
            String emailSubject = "Recordatorio de caducidad de anuncio";

            int maxDays2sendEmail = 15;
            String sbodyparam = "Cuerpo de correo";
            Parameter param = Parameter.ClassMgr.getParameter("MaxDays2sendEmail", this.model);
            EmailText emailText = EmailText.ClassMgr.getEmailText("EMAIL_PUBLICATIONENDING", this.model);

            try {
                if (param != null && param.getParamValue() != null &&
                        param.getParamValue().trim().length() > 0) {
                    maxDays2sendEmail = Integer.parseInt(param.getParamValue());
                }
            } catch (Exception e) {
                log.error("El parametro MaxDays2sendEmail debe ser númerico", e);
                maxDays2sendEmail = 15;
            }
            try {
                if (emailText != null && emailText.getEmailText() != null &&
                        emailText.getEmailText().trim().length() > 0) {
                    sbodyparam = emailText.getEmailText().trim();
                }
            } catch (Exception e) {
                log.error("El texto de correo EMAIL_PUBLICATIONENDING debe capturarse", e);
                sbodyparam = "Cuerpo de correo";
            }
            calEmails.add(Calendar.DATE, maxDays2sendEmail + 1); // 5 Es parametrizable (Número maximo de días apartir del cual se va ha empezar a enviar correos)
            Calendar calDisableAnnunce = Calendar.getInstance();
            Iterator<ServiceProvider> itProviders = ServiceProvider.ClassMgr.listServiceProviders(this.model);
            while (itProviders.hasNext()) {
                ServiceProvider servProvider = itProviders.next();
                Date spEndAnnounceDate = servProvider.getSpEndAnnuncePeriod();

                //Solo si esta publicado el service provider
                if (servProvider.getSpStatus() == PymturUtils.ESTATUS_ACEPTADO ||
                        servProvider.getSpStatus() == PymturUtils.ESTATUS_PUBLICADO &&
                        spEndAnnounceDate != null) {

                     //Todos los anuncios que tengan una fecha de expiración próxima
                    if (spEndAnnounceDate.before(calEmails.getTime())) {
                        //Se envía un cierto cuerpo de correo (anuncios de pymes gratuitos que pagan)
                        if (servProvider.getPymePaqueteType() > PymturUtils.PAQ_FICHA) {
                            String spEmail = servProvider.getContactEmail();
                            if (spEmail != null && spEmail.trim().length() > 0 &&
                                    spEmail.indexOf("@") > -1 &&
                                    spEmail.indexOf(".") > -1) {
                                InternetAddress interAddress = new InternetAddress();
                                interAddress.setAddress(spEmail);
                                aPymesPagan.add(interAddress);
                                adminEmailTxt.append("<br/>");
                                adminEmailTxt.append(servProvider.getTitle());
                            }
                          //Se envía un cierto cuerpo de correo (anuncios de pymes gratuitos)
                        } else if (servProvider.getPymePaqueteType() <= PymturUtils.PAQ_MICROSITIO) {
                            String spEmail = servProvider.getContactEmail();
                            if (spEmail != null && spEmail.trim().length() > 0 &&
                                    spEmail.indexOf("@") > -1 &&
                                    spEmail.indexOf(".") > -1) {
                                InternetAddress interAddress = new InternetAddress();
                                interAddress.setAddress(spEmail);
                                aPymesGratis.add(interAddress);
                                adminEmailTxt.append("<li>");
                                adminEmailTxt.append(servProvider.getTitle());
                                adminEmailTxt.append("</li>");
                            }
                        }
                    }
                    //Todos los anuncios que tengan una fecha de expiración antes de la fecha actual
                    if (spEndAnnounceDate.before(calDisableAnnunce.getTime())) {
                        servProvider.setSpStatus(PymturUtils.ESTATUS_VENCIDA); //Considerando que se desactivaría la pyme, pero ya la pyme ya se acepto y se pagó
                        PymturUtils.logServiceProvider(servProvider, null, null,
                                PymturUtils.ESTATUS_VENCIDA,
                                PymturUtils.COMMENT_STATUS,
                                "MIPyME Auto Expired");
                    }
                }
                spEndAnnounceDate = null;
                servProvider = null;
            }

            Role adminProviderRole = SWBContext.getWebSite(this.model.getId()
                    ).getUserRepository().getRole("adminProviders");
            Iterator <User> itUsers = User.ClassMgr.listUserByRole(adminProviderRole,
                    SWBContext.getWebSite(this.model.getId()).getUserRepository());
            while (itUsers.hasNext()) {
                User user = itUsers.next();
                String admProvEmail = user.getEmail();
                if (user.isActive() && admProvEmail != null && admProvEmail.trim().length() > 0 &&
                        admProvEmail.indexOf("@") > -1 && admProvEmail.indexOf(".") > -1) {
                    InternetAddress interAddress = new InternetAddress();
                    interAddress.setAddress(admProvEmail);
                    aAdminProviders.add(interAddress);
                }
                user = null;
            }

            //Enviar correos en backgraound a los usuarios que PAGAN y que esta
            //por vencerseles el periodo de publicicación de su anuncio
            if (aPymesPagan != null && aPymesPagan.size() > 0) {
                try {
                    SWBUtils.EMAIL.sendBGEmail(fromEmail, fromEmail, aPymesPagan,
                            null, null, emailSubject, "html", sbodyparam,
                            null, null, null);
                } catch (SocketException e) {
                    log.error(e);
                }
            }
            //Enviar correos en backgraound a los usuarios que NO PAGAN y que
            //esta por vencerseles el periodo de publicicación de su anuncio
            if (aPymesGratis != null && aPymesGratis.size() > 0) {
                try {
                    SWBUtils.EMAIL.sendBGEmail(fromEmail, fromEmail, aPymesGratis,
                            null, null, emailSubject, "html", sbodyparam,
                            null, null, null);
                } catch (SocketException e) {
                    log.error(e);
                }
            }
            //Enviar correo a administradores
            if (aAdminProviders != null && aAdminProviders.size() > 0 &&
                    adminEmailTxt.length() > 0) {
                try {
                    StringBuilder mailTxt = new StringBuilder(128);
                    mailTxt.append("Usuario administrador.<br/><br/>");
                    mailTxt.append("Se ha notificado a las siguientes");
                    mailTxt.append(" empresas sobre el pr&oacute;ximo ");
                    mailTxt.append("vencimiento de la publicaci&oacute;n de su ");
                    mailTxt.append("informaci&oacute;n en el sitio Siente M&eacute;xico<br/><br/><ul>");
                    mailTxt.append(adminEmailTxt);
                    mailTxt.append("</ul>");
                    //Envío de correo a los AdminProviders, para que también esten enterados
                    SWBUtils.EMAIL.sendBGEmail(fromEmail, fromEmail, aAdminProviders,
                            null, null, emailSubject, "html", mailTxt.toString(),
                            null, null, null);
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

