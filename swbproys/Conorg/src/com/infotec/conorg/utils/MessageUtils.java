/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.conorg.utils;

import com.infotec.conorg.Aviso;
import com.infotec.conorg.WorkSpace;
import java.util.Iterator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;

/**
 * Utililerías para el manejo de avisos
 * @author juan.fernandez
 */
public class MessageUtils {

    /**
     * Envio de aviso a usuario
     * @param toUser usuario a quien va dirigido el aviso
     * @param title información del mensaje
     * @return regresa true si el mensaje fue enviado correntamente, de lo contrario regresa false
     */
    public static Aviso sendUserMessage(User fromUser, User toUser, String title, String description, WebSite wsite){
        Aviso aviso = null;
        aviso = Aviso.ClassMgr.createAviso(wsite);
        return aviso;
    }
    
    /** 
     * Envio de un aviso a todos los participantes de un WorkSpace (Espacio de trabajo)
     * @param wrkSpc Espacio de trabajo al cual se le enviará el aviso
     * @param aviso información del mensaje
     * @return regresa true si el mensaje fue enviado correntamente, de lo contrario regresa false
     */
    public static boolean sendWorkSpaceMessage(WorkSpace wrkSpc, Aviso aviso){
        boolean msgSended = false;
        return msgSended;
    }
    
    /**
     * 
     * @param wsite sitio en donde se generará el mensaje
     * @param aviso información del mensaje
     * @return regresa true si el mensaje fue enviado correntamente, de lo contrario regresa false
     */
    public static boolean sendCommunityMessage(WebSite wsite, Aviso aviso){
        boolean msgSended = false;
        return msgSended;
    }
    
    
    
    /**
     * 
     * @param user
     * @return 
     */
    public static Iterator<Aviso> getUserMessages(User user){
        return Aviso.ClassMgr.listAvisoByToUser(user);
    }
    
    /**
     * 
     * @param wrkSpc
     * @return
     */
    public static Iterator<Aviso> getWorkSpaceMessages(WorkSpace wrkSpc){
        return Aviso.ClassMgr.listAvisoByToWorkSpace(wrkSpc);
        
    }
    
    /**
     * 
     * @param wsite
     * @return
     */
    public static Iterator<Aviso> getCommunityMessages(WebSite wsite){
        return Aviso.ClassMgr.listAvisos(wsite);
    }
    
    /**
     * 
     * @param wsite
     * @return
     */
    public static Iterator<Aviso> getOrderedMessages(WebSite wsite){
        return Aviso.ClassMgr.listAvisos(wsite);
    }
}
