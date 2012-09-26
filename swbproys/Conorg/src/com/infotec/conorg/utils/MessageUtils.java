/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.utils;

import com.infotec.conorg.Aviso;
import com.infotec.conorg.Member;
import com.infotec.conorg.WorkSpace;
import com.infotec.conorg.resources.MyShelf;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import javax.mail.internet.InternetAddress;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;

/**
 * Utililerías para el manejo de avisos
 *
 * @author juan.fernandez
 */
public class MessageUtils {

    public static final Logger log = SWBUtils.getLogger(MessageUtils.class);

    /**
     * Envio de aviso a usuario
     *
     * @param fromUser usuario que genera el aviso
     * @param toUser usuario a quien va dirigido el aviso
     * @param title información del mensaje
     * @param description descripción del aviso
     * @param wsite sitio o modelo en donde se generará el aviso
     * @return regresa true si el mensaje fue enviado correntamente, de lo
     * contrario regresa false
     */
    public static Aviso createUserMessage(User fromUser, User toUser, String title, String description, WebSite wsite) {
        Aviso aviso = Aviso.ClassMgr.createAviso(wsite);
        aviso.setTitle(title);
        if (description == null) {
            description = "";
        }
        aviso.setDescription(description);
        aviso.setFromUser(fromUser);
        aviso.addToUser(toUser);
        return aviso;
    }

    /**
     * Envio de un aviso a todos los participantes de un WorkSpace (Espacio de
     * trabajo)
     *
     * @param fromUser usuario que genera el aviso
     * @param towrkSpc espacio de trabajo al cual el mensaje va dirigido
     * @param title titulo o asunto del aviso
     * @param description descripción del aviso
     * @param wsite sitio o modelo en donde se generará el aviso
     * @return regresa el aviso generado.
     */
    public static Aviso createWorkSpaceMessage(User fromUser, WorkSpace towrkSpc, String title, String description, WebSite wsite) {
        Aviso aviso = Aviso.ClassMgr.createAviso(wsite);
        aviso.setTitle(title);
        if (description == null) {
            description = "";
        }
        aviso.setDescription(description);
        aviso.setFromUser(fromUser);
        aviso.setToWorkSpace(towrkSpc);
        return aviso;
    }

    /**
     * Genera un aviso para todos
     *
     * @param fromUser usuario que genera el aviso
     * @param title titulo o asunto del aviso
     * @param wsite sitio en donde se generará el mensaje
     * @param description descripción del aviso
     * @return regresa el aviso generado.
     */
    public static Aviso createCommunityMessage(User fromUser, String title, String description, WebSite wsite) {
        Aviso aviso = Aviso.ClassMgr.createAviso(wsite);
        aviso.setTitle(title);
        if (description == null) {
            description = "";
        }
        aviso.setDescription(description);
        aviso.setFromUser(fromUser);
        // touser==null && workspace==null esto sería mensaje para la comunidad
        return aviso;
    }

    /**
     * Busca los avisos o mensajes de un determinado usuario
     *
     * @param user usuario del cual se buscaran avisos o mensajes
     * @return iterador de avisos de un usuario
     */
    public static Iterator<Aviso> getUserMessages(User user, WebSite wsite) {
        return Aviso.ClassMgr.listAvisoByToUser(user, wsite);
    }

    /**
     * Busca los avisos o mensajes de un determinado espacio de trabajo o
     * workspace.
     *
     * @param wrkSpc Espacio de trabajo del cual se buscaran avisos o mensajes
     * @return iterador de avisos de un espacio de trabajo o workspace
     */
    public static Iterator<Aviso> getWorkSpaceMessages(WorkSpace wrkSpc, WebSite wsite) {
        if (wrkSpc == null) {
            return null;
        }
        return Aviso.ClassMgr.listAvisoByToWorkSpace(wrkSpc, wsite);
    }

    /**
     * Busca todos los mensajes de la comunidad ordenados por fecha de creación
     *
     * @param wsite sitio del cual se buscarán los avisos
     * @param ascendente true para ordenar ascendente, false descendente
     * @return iterador de avisos dirigidos a la comunidad
     */
    public static Iterator<Aviso> getCommunityMessages(WebSite wsite) {

        HashMap<String, Aviso> hmavisos = new HashMap<String, Aviso>();
        Iterator<Aviso> itaviso = Aviso.ClassMgr.listAvisos(wsite);
        while (itaviso.hasNext()) {
            Aviso aviso = itaviso.next();
            if (!aviso.listToUsers().hasNext() && aviso.getToUser() == null && aviso.getToWorkSpace() == null) {
                hmavisos.put(aviso.getId(), aviso);
            }
        }

        return hmavisos.values().iterator();
    }

    /**
     *
     * @param wsite
     * @param ascendente
     * @return
     */
    public static Iterator<Aviso> getOrderedMessagesByCreated(Iterator<Aviso> ite, boolean ascendente) {

        return SWBComparator.sortByCreated(ite, ascendente);
    }

    /**
     *
     * @param wsite
     * @param lang
     * @return
     */
    public static Iterator<Aviso> getOrderedMessagesByTitle(Iterator<Aviso> ite, String lang) {
        return SWBComparator.sortByDisplayName(ite, lang);
    }

    public static Iterator<Aviso> getAllUserMessages(User user, WebSite wsite) {

        HashMap<String, Aviso> hmAvisos = new HashMap<String, Aviso>();
        //System.out.println("===> Community msg");
        Iterator<Aviso> itcomm = getCommunityMessages(wsite);
        while (itcomm.hasNext()) {
            Aviso aviso = itcomm.next();
            //System.out.println("aviso added (community)");
            hmAvisos.put(aviso.getId(), aviso);
        }
        //System.out.println("===> user msg");
        Iterator<Aviso> itusr = getUserMessages(user, wsite);
        while (itusr.hasNext()) {
            Aviso aviso = itusr.next();
            //System.out.println("aviso added (user)");
            hmAvisos.put(aviso.getId(), aviso);
        }

        //System.out.println("===> ws msg");
        Iterator<WorkSpace> itws = getUserWorkSpaces(user, wsite);
        while (itws.hasNext()) {
            WorkSpace workSpace = itws.next();
            //System.out.println("revisando ws: "+workSpace.getId());
            Iterator<Aviso> itaws = getWorkSpaceMessages(workSpace, wsite);
            while (itaws.hasNext()) {
                //System.out.println(" .... revisando avisos del ws");
                Aviso aviso = itaws.next();
                //System.out.println("aviso added (ws)");
                hmAvisos.put(aviso.getId(), aviso);
            }

        }
        //System.out.println("fin get all msg <===");


        return hmAvisos.values().iterator();
    }

    // membresias del usuario a los diferentes ws
    public static Iterator<WorkSpace> getUserWorkSpaces(User usr, WebSite wsite) {
        //System.out.println("revisando miembro con wspcsss");
        Iterator<Member> itmem = Member.ClassMgr.listMemberByUser(usr, wsite);
        HashMap<WorkSpace, Member> hmmem = new HashMap<WorkSpace, Member>();
        while (itmem.hasNext()) {
            Member wsmember = itmem.next();
            WorkSpace wspace = wsmember.getWorkspace();
            if (wspace != null && wsmember.getUser() != null && usr.equals(wsmember.getUser())) {
                //System.out.println(wsmember.getMemberType()+" de: "+wsmember.getWorkspace().getTitle());
                int usrlevel = MyShelf.getLevelMember(wsmember);
                if (usrlevel > 0) {  //MyShelf.USRLEVEL_NO_MIEMBRO 
                    //System.out.println("es miembro del ws "+wspace.getId());
                    hmmem.put(wspace, wsmember);
                    if (!wspace.hasMember(wsmember)) {
                        wspace.addMember(wsmember);
                    }
                }
            }
        }
        return hmmem.keySet().iterator();
    }

    public static boolean sendWorkSpaceChangesEmail2Suscribers(WorkSpace wspace, String email_admin, String subject, String msg_content) {

        boolean ret = Boolean.FALSE;
        try {
            //envia correo electrónico del administrador a los usuarios suscritos al espacio de trabajo.
            InternetAddress emailAdmin = new InternetAddress();
            emailAdmin.setAddress(email_admin);
            ArrayList<InternetAddress> arr = new ArrayList();
            arr.add(emailAdmin);

            Iterator<User> itusr = wspace.listSubscriberses();
            ArrayList<InternetAddress> arrBCC = new ArrayList<InternetAddress>();
            while (itusr.hasNext()) {
                User user = itusr.next();
                try {
                    InternetAddress intAddr = new InternetAddress();
                    intAddr.setAddress(user.getEmail());
                    arrBCC.add(intAddr);
                } catch (Exception e) {
                    log.error("Error al obtener el correo electrónico del usuario: " + user.getLogin(), e);
                }
            }

//                String dataEmail = "<h2>Propuesta nuevo tema - "+wsite.getTitle()+"</h2>"
//                        + "<table><tr><td><h3>Título del Tema:</h3></td><td><h3>" + temaTitle + "</h3></td></tr>"
//                        + "<tr><td><h3>Descripción:</h3></td><td><h3>" + temaDescr + "</h3></td></tr>"
//                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
//                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
//                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
//                        + "<tr><td colspan=\"2\" align=\"center\"><h3>Datos Solicitante:</h3></td></tr>"
//                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
//                        + "<tr><td>Nombre:</td><td>" + user.getFullName() + "</td></tr>"
//                        + "<tr><td>Correo electrónico:</td><td><a href=\"mailto:" + user.getEmail() + "\">" + user.getEmail() + "</a></td></tr>"
//                        + "<tr><td>Fecha Solicitud:</td><td>" + sdf.format(new Date(System.currentTimeMillis())) + "</td></tr>"
//                        + "<tr><td colspan=\"2\">&nbsp;</td></tr></table>";

            String dataEmail = msg_content;

            String userName ="Administrador del sistema CONORG";
            String asunto = subject;
            String tipo = "text/html";
            String login = SWBPlatform.getEnv("swb/smtpUser");
            String pass = SWBPlatform.getEnv("swb/smtpPassword");

            SWBUtils.EMAIL.sendBGEmail(email_admin, userName, arr, null, arrBCC, asunto, tipo, dataEmail, login, pass, null);
            ret = Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error al enviar por correo electrónico los cambios del espacio de trabajo a los usuarios suscritos.", e);
            ret = Boolean.FALSE;
            
        }
        return ret;
    }
}
