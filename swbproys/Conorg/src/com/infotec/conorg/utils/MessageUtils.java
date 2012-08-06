/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.utils;

import com.infotec.conorg.Aviso;
import com.infotec.conorg.Member;
import com.infotec.conorg.WorkSpace;
import com.infotec.conorg.resources.MyShelf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;

/**
 * Utililerías para el manejo de avisos
 *
 * @author juan.fernandez
 */
public class MessageUtils {

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
    public static Iterator<Aviso> getUserMessages(User user) {
        return Aviso.ClassMgr.listAvisoByToUser(user);
    }

    /**
     * Busca los avisos o mensajes de un determinado espacio de trabajo o
     * workspace.
     *
     * @param wrkSpc Espacio de trabajo del cual se buscaran avisos o mensajes
     * @return iterador de avisos de un espacio de trabajo o workspace
     */
    public static Iterator<Aviso> getWorkSpaceMessages(WorkSpace wrkSpc) {
        return Aviso.ClassMgr.listAvisoByToWorkSpace(wrkSpc);

    }

    /**
     * Busca todos los mensajes de la comunidad ordenados por fecha de creación
     *
     * @param wsite sitio del cual se buscarán los avisos
     * @param ascendente true para ordenar ascendente, false descendente
     * @return iterador de avisos dirigidos a la comunidad
     */
    public static Iterator<Aviso> getCommunityMessages(WebSite wsite) {

        TreeSet<Aviso> tsavisos = new TreeSet<Aviso>();
        Iterator<Aviso> itaviso = Aviso.ClassMgr.listAvisos(wsite);
        while (itaviso.hasNext()) {
            Aviso aviso = itaviso.next();
            if (!aviso.listToUsers().hasNext() && aviso.getToUser() == null && aviso.getToWorkSpace() == null) {
                tsavisos.add(aviso);
            }
        }

        return tsavisos.iterator();
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
    
    public static Iterator<Aviso> getAllUserMessages(User user, WebSite wsite){
        
        TreeSet<Aviso> tsAvisos = new TreeSet<Aviso>();
        
        Iterator<Aviso> itcomm = getCommunityMessages(wsite);
        while (itcomm.hasNext()) {
            Aviso aviso = itcomm.next();
            tsAvisos.add(aviso);
        }
        Iterator<Aviso> itusr = getUserMessages(user);
        while (itusr.hasNext()) {
            Aviso aviso = itusr.next();
            tsAvisos.add(aviso);
        }
        Iterator<WorkSpace> itws = getUserWorkSpaces(user,wsite);
        while (itws.hasNext()) {
            WorkSpace workSpace = itws.next();
            Iterator<Aviso> itaws = getWorkSpaceMessages(workSpace);
            while (itaws.hasNext()) {
                Aviso aviso = itaws.next();
                tsAvisos.add(aviso);
            }
            
        }     

        
        return tsAvisos.iterator();
    }
    
    // membresias del usuario a los diferentes ws
    public static Iterator<WorkSpace> getUserWorkSpaces(User usr, WebSite wsite){
            
        Iterator<Member> itmem = Member.ClassMgr.listMemberByUser(usr, wsite);
        HashMap<WorkSpace, Member> hmmem = new HashMap<WorkSpace, Member>();
        while (itmem.hasNext()) {
            Member wsmember = itmem.next();
            WorkSpace wspace = wsmember.getWorkspace();
            if (wspace != null && wsmember.getUser() != null && usr.equals(wsmember.getUser())) {
                //System.out.println(wsmember.getMemberType()+" de: "+wsmember.getWorkspace().getTitle());
                int usrlevel = MyShelf.getLevelMember(wsmember);
                if (usrlevel > 0) {  //MyShelf.USRLEVEL_NO_MIEMBRO 
                    hmmem.put(wspace, wsmember);
                    if (!wspace.hasMember(wsmember)) {
                        wspace.addMember(wsmember);
                    }
                }
            } 
        }
        return hmmem.keySet().iterator();
    }
}
