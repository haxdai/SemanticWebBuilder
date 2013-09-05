/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.listener;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.SWBAppObject;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebSite;
import org.semanticwb.social.KeepAliveListenerable;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialSite;
import org.semanticwb.social.Stream;


/**
 *
 * @author jorge.jimenez
 */

/*
 *  Clase cuya funcionalidad es la de generar un timer por cada uno de los streams existentes y activos en todas las Marcas
 *  de una instancia de la herramienta swbsocial.
 *  Esta clase es llamada cuando se levanta el appserver mediante el archivo startup.properties o mediante la creación y/o edición
 *  de streams.
 */
public class ListenerMgr implements SWBAppObject {

    private static Logger log = SWBUtils.getLogger(ListenerMgr.class);
    //Timer timer;
    static private Hashtable<String, Timer> htTimers = new Hashtable();
    static private ListenerMgr instance;
    static final int MILISEG_IN_SEGUNDO=1000;
    //static private ReBindThread rbThread=null;
    
    
    static private boolean canEnter=true;

    /**
     * Retrieves a reference to the only one existing object of this class.
     * <p>Obtiene una referencia al &uacute;nico objeto existente de esta clase.</p>
     * @return a reference to the only one existing object of this class
     */
    static public synchronized ListenerMgr createInstance() {
        if (ListenerMgr.instance == null) {
            ListenerMgr.instance = new ListenerMgr();
        }
        return ListenerMgr.instance;
    }

    /*
     * Metodo constructor que levanta listener de cada uno de los streams de cada sitio de tipo SWBSocial
     */
    public ListenerMgr() {
        try {
            Iterator<WebSite> itWebSites = SWBContext.listWebSites(false);
            while (itWebSites.hasNext()) {
                WebSite wsite = itWebSites.next();
                if (wsite.isActive() && !wsite.isDeleted() && wsite instanceof SocialSite) {
                    Iterator<Stream> itStreams = Stream.ClassMgr.listStreams(wsite);
                    while (itStreams.hasNext()) {
                        Stream stream = itStreams.next();
                        if (createTimer(stream))
                        {
                            int time=stream.getPoolTime();
                            //Este número es por defecto, ya que si el stream maneja solo una red tipo listenAlive, es posible que no le hayan puesto un 
                            //valor a stream.getPoolTime(), por lo cual, en la línea de abajo que crea el timer marcaría un error (Non-positive period).
                            if(time<1) time=900; 
                            int periodTime = time*MILISEG_IN_SEGUNDO;
                            Timer timer = new Timer();
                            timer.schedule(new ListenerTask(stream), 0,periodTime);
                            htTimers.put(stream.getURI(), timer);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    /*
     * Metodo que crea y actualiza timers
     */
    public static boolean createUpdateTimers(Stream stream)
    {
        //System.out.println("createUpdateTimers/STREAM:"+stream);
        try
        {
            synchronized(stream)
            {
              //System.out.println("createUpdateTimers-1");  
              if(canEnter)
              {
                  //System.out.println("createUpdateTimers-2");  
                  canEnter=false;
                  createUpdateTimersReBind(stream);
              }
            }
        }catch(Exception e)
        {
            log.error(e);
        }
        return false;
    }

    /*
     * Metodo que crea o actualiza un thread de un determinado stream
     */
    private static void createUpdateTimersReBind(Stream stream)
    {
        //System.out.println("Entra a Listener/createUpdateTimersReBind-1");
        
        /*
        Iterator<SocialNetwork> itNets=stream.listSocialNetworks();
        while(itNets.hasNext())
        {
            SocialNetwork socialNet=itNets.next();
            System.out.println("SocialNetwork que tiene el stream:"+socialNet.getURI());
        }
        * */
        if(htTimers.get(stream.getURI())!=null)
        {
            try
            {
                //System.out.println("Entra a Listener/createUpdateTimers-2:"+stream.getURI());
                System.out.println("ListerJ1");
                //Se revisa si el timer del stream puede ser creado, esto es, si el stream esta activo, si hay palabras a buscar, etc., si no es así, se elimina
                if(!createTimer(stream))    
                {
                    //System.out.println("Entra a Listener/createUpdateTimers-3:"+stream.getURI());
                    System.out.println("ListerJ1.1");
                    removeTimer(stream, true);
                    System.out.println("Elimino timer k");
                }else
                {
                    //System.out.println("Entra a Listener/createUpdateTimers-4:"+stream.getURI());
                    System.out.println("ListerJ2");
                    Timer timer=removeTimer(stream, true);
                    timer=new Timer();
                    int time=stream.getPoolTime();
                    //Este número es por defecto, ya que si el stream maneja solo una red tipo listenAlive, es posible que no le hayan puesto un 
                    //valor a stream.getPoolTime(), por lo cual, en la línea de abajo que crea el timer marcaría un error (Non-positive period).
                    if(time<1) time=900; 
                    timer.schedule(new ListenerTask(stream), 3*MILISEG_IN_SEGUNDO,time*MILISEG_IN_SEGUNDO);
                    htTimers.put(stream.getURI(), timer);
                    return;
                }
            }catch(Exception e)
            {
                //System.out.println("Error:"+e.getMessage());
                log.error(e);
            }
        }else
        {
            System.out.println("ListerJ3");
            if(createTimer(stream))
            {
                //Se arranca un timer que se ejecutara cada tantos segundos configurados en el stream
                System.out.println("Levanta Timer:"+stream.getPoolTime());
                Timer timer = new Timer();
                int time=stream.getPoolTime();
                //Este número es por defecto, ya que si el stream maneja solo una red tipo listenAlive, es posible que no le hayan puesto un 
                //valor a stream.getPoolTime(), por lo cual, en la línea de abajo que crea el timer marcaría un error (Non-positive period).
                if(time<1) time=900; 
                timer.schedule(new ListenerTask(stream), 3*MILISEG_IN_SEGUNDO,time*MILISEG_IN_SEGUNDO); 
                htTimers.put(stream.getURI(), timer);
                return;
            }
        }
        canEnter=true;
    }
     

    /**
     * Clase de tipo Timer, hecha a andar las redes sociales adjudicadas a un stream.
     */ 
    private static class ListenerTask extends TimerTask
    {
        Stream stream=null;

        public ListenerTask(Stream stream)
        {
            this.stream=stream;
        }

        public void run() {
            if(createTimer(stream))
            {
                boolean isThereNoListenAliveNets=false;
                System.out.println("Ejecuta Timer:"+stream);
                Iterator<SocialNetwork> itSocialNets=stream.listSocialNetworks();
                while(itSocialNets.hasNext())
                {
                    SocialNetwork socialNet=itSocialNets.next();
                    if(stream.isKeepAliveManager())
                    {
                        //Si el Stream esta configurado para que maneje las redes sociales que así lo permitan en su forma "ListenAlive", y si la red social
                        //que se esta revisando en este momento es de tipo KeepAliveListenerable, entonces no hace nada e itera de nuevo para buscar la 
                        //siguiente red social del Stream, dado que la actual no se va a enviar a que escuche.
                        if(socialNet instanceof KeepAliveListenerable)
                        {
                            System.out.println("Ejecuta Red Social/ListenAlive:"+socialNet.getId());
                            KeepAliveListenerable listenAliveableNet=(KeepAliveListenerable)socialNet;
                            listenAliveableNet.listenAlive(stream);
                        }else   //De lo contrario, si se envía a que escuche
                        {
                            System.out.println("Ejecuta Red Social/Listen:"+socialNet.getId());
                            socialNet.listen(stream);
                            isThereNoListenAliveNets=true;
                        }
                    }else   //De lo contrario, si se envía a que escuche
                    {
                        System.out.println("Ejecuta Red Social/Listen:"+socialNet.getId());
                        socialNet.listen(stream);
                        isThereNoListenAliveNets=true;
                    }
                }
                //Si no existen redes sociales que NO sean ListenAlive, entonces elimina ese timer
                
                if(!isThereNoListenAliveNets)
                {
                    removeTimer(stream, false);
                }
            }else
            {
                System.out.println("stream es nulo o es inactivo o esta borrado.....:"+stream);
                removeTimer(stream, true);
            }
            canEnter=true;
        }
     }

    /*
     * Metodo cuya funcionalidad es la de verificar si se podría crear un thread de acuerdo a los datos que trae un stream dado.
     */
    private static boolean createTimer(Stream stream)
    {
        System.out.println("ListerJ5");
        if(stream!=null && stream.isActive() && !stream.isDeleted() && stream.getPhrase()!=null && stream.getPhrase().trim().length()>0 && stream.listSocialNetworks().hasNext())
        {
            //Si es isKeepAliveManager==true, no importaría si no le ponen un tiempo para que este llamandose el thread, 
            //ya que este es llamado internamente desde cada red social que maneje esta caracteristica
            if(stream.isKeepAliveManager())
            {
                return true;
            }else if(stream.getPoolTime() > 0) { //si es stream.isKeepAliveManager()=false, entonces para crear el thread debe haber un tiepo para estarse llamando
                return true;
            }
            //Revisa si en el Stream esta indicado (Active) si se va a manejar KeepAlive en las redes sociales que así lo permitan y que esten
            //asociadas a dicho Stream
            /*
            if(stream.isKeepAliveManager())
            {
                //Busca si alguna de las redes sociales que estan registradas en el Stream es de tipo KeepAliveListenerable, si es así no creara el Timer para ese Stream
                boolean isNotKeepAliveable=false;
                Iterator<SocialNetwork> itSocialNets=stream.listSocialNetworks(); 
                while(itSocialNets.hasNext())
                {
                   SocialNetwork socialNet=itSocialNets.next();
                   if(!(socialNet instanceof KeepAliveListenerable))
                   {
                       isNotKeepAliveable=true;
                       break;
                   }
                }
                //Si alguna red social del Stream, no es de tipo KeepAliveListenerable, entonces se regresa true, esto para que SI se genere un timer para ese stream
                if(isNotKeepAliveable) 
                {
                    return true;
                }
            }else{
                return true;
            }
            * */
        }
        return false;
    }
    
    /*
     * Metodo que elimina un thread de un stream
     */
     public static Timer removeTimer(Stream stream, boolean stopNetListeners)
     {
        if(htTimers.get(stream.getURI())!=null)
        {
            System.out.println("Entra a removeTimer de stream:"+stream.getURI());
            System.out.println("Entra a removeTimer de stream-GeorgEEEEEE:"+stream.getURI());
            if(stopNetListeners)
            {
                //Mandar llamar a cada una de las redes sociales con el Stream que deseo detener
                try
                {
                    Iterator<SocialNetwork> itSocialNets=stream.listSocialNetworks();
                    while(itSocialNets.hasNext())
                    {
                        SocialNetwork socialNet=itSocialNets.next();
                        if(socialNet instanceof KeepAliveListenerable)
                        {
                            KeepAliveListenerable keepAliveNet=(KeepAliveListenerable) socialNet;
                            //Envío llamar a ambos metodos, esto por si era el stream "isKeepAliveManager()=true" y se lo quitaron, 
                            //pero ya estaba ejecutandose mediante esa instancia una red social y viceversa, de lo contrario nunca
                            //detendría lo que ya tiene iniciado.
                            //Si una red social que estaba configurada en el stream, ya se la quitaron, tampoco entraría en todo este while
                            //pero para eso, ya lo estoy controlando con un if que detiene el proceso que esta en un hilo completamente por 
                            //separadoen el metodo "onStatus",  de la Clase SWBSocialStatusListener, hacer lo mismo para cuando se desee
                            //incorporar mas redes sociales de tipo KeepAlive
                            keepAliveNet.stopListenAlive(stream);
                            socialNet.stopListen(stream);  
                        }else{
                            socialNet.stopListen(stream);   
                        }
                    }                
                }catch(Exception e)
                {
                    log.error(e);
                }
                //////////////////
            }
            try
            {
                Timer timer=htTimers.get(stream.getURI());
                htTimers.remove(stream.getURI());
                timer.cancel();
                timer.purge();
                timer=null;
                System.out.println("Entra a removeTimer de stream-1:"+stream.getURI());
                return timer;
            }catch(Exception e)
            {
                log.error(e);
            }
        }
        return null;
     }
    
   
    @Override
    public void init() {
        //new Listener();
    }

    @Override
    public void destroy() {
        htTimers.clear();
    }

    @Override
    public void refresh() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * Metodo de prueba
     */
    public static void main(String args[]) {
        System.out.println("About to schedule task.");
        new ListenerMgr(); //C/cuantos segundos se ejecutara la tarea
        System.out.println("Task scheduled.");
    }
}
