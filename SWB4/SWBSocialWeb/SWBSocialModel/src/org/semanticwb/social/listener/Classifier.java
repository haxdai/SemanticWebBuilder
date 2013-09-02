/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.social.listener;

import java.util.ArrayList;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.social.ExternalPost;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.Stream;

/**
 *
 * @author jorge.jimenez
 * 
 * Class which creates a ClassifierThread (Thread) to classify all messages retrieving from a SocialNetwork.
 * 
 */

/*
 * Clase cuya funcionalidad es la de levantar un thread por cada mensaje que llega por medio del listener.
 */
public class Classifier {

    private Logger log = SWBUtils.getLogger(Classifier.class);

    /*
    PostIn post=null;
    public Classifier (PostIn post)
    {
        this.post=post;
        try{
            ClassifierThread classThread=new ClassifierThread(post);
            //System.out.println("THREAD CREADO:"+classThread);
            classThread.start();
            //System.out.println("classThread.isAlive():"+classThread);
        }catch(Exception e){
            log.error(e);
        }

    }
    * */
    
    /*
     * Method that creates 
     */
    public Classifier (ArrayList <ExternalPost> aListExternalPost, Stream stream, SocialNetwork socialNetwork, boolean classifyGeoLocation)
    {
        try{
            ClassifierThread classThread=new ClassifierThread(aListExternalPost, stream, socialNetwork, classifyGeoLocation);
            //System.out.println("THREAD CREADO:"+classThread);
            classThread.start();
            //System.out.println("classThread.isAlive():"+classThread);
        }catch(Exception e){
            log.error(e);
        }

    }

}
