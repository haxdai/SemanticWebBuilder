/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.listener;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.SWBAppObject;
import org.semanticwb.model.DisplayObject;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebSite;
import org.semanticwb.social.Facebook;
import org.semanticwb.social.KeepAliveListenerable;
import org.semanticwb.social.SWBSocial;
import org.semanticwb.social.SocialNetStreamSearch;
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
    static final int MILIGSEG_IN_SEG=1000;
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
                            int initTime=180*MILIGSEG_IN_SEG;   //3 minutos
                            //Este número es por defecto, ya que si el stream maneja solo una red tipo listenAlive, es posible que no le hayan puesto un 
                            //valor a stream.getPoolTime(), por lo cual, en la línea de abajo que crea el timer marcaría un error (Non-positive period).
                            if(time<1) time=15; //15 milisegundos por defecto
                            int periodTime = (time*MILIGSEG_IN_SEG)*60;    //El tiempo por 1000 para que sea en segundos y por 60 para que sea en minutos
                            Timer timer = new Timer();
                            log.event("Initializing ListenerMgr, starts in:"+initTime+"ms, periodicity:"+periodTime+"ms"+",Stream:"+stream);
                            timer.schedule(new ListenerTask(stream), initTime,periodTime);   //Dentro de 180 Segundos(3 min) inicias(Damos tiempo para que arranque el appserver completamente) y lo ejecutas cada sucesivamente cada que se cumpla periodTime
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
                //System.out.println("ListerJ1");
                //Se revisa si el timer del stream puede ser creado, esto es, si el stream esta activo, si hay palabras a buscar, etc., si no es así, se elimina
                if(!createTimer(stream))    
                {
                    //System.out.println("Entra a Listener/createUpdateTimers-3:"+stream.getURI());
                    //System.out.println("ListerJ1.1");
                    removeTimer(stream, true);
                    //System.out.println("Elimino timer k");
                }else
                {
                    //System.out.println("Entra a Listener/createUpdateTimers-4:"+stream.getURI());
                    //System.out.println("ListerJ2");
                    Timer timer=removeTimer(stream, true);
                    timer=new Timer();
                    int time=stream.getPoolTime();
                    //Este número es por defecto, ya que si el stream maneja solo una red tipo listenAlive, es posible que no le hayan puesto un 
                    //valor a stream.getPoolTime(), por lo cual, en la línea de abajo que crea el timer marcaría un error (Non-positive period).
                    if(time<1) time=15; //15 milisegundos por defecto
                    int periodTime = (time*MILIGSEG_IN_SEG)*60; //El tiempo por 1000 para que sea en segundos y por 60 para que sea en minutos
                    timer.schedule(new ListenerTask(stream), 3*MILIGSEG_IN_SEG,periodTime);  //Dentro de 3 Segundos, me avisas cada que se cumpla periodTime
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
            //System.out.println("ListerJ3");
            if(createTimer(stream))
            {
                //Se arranca un timer que se ejecutara cada tantos segundos configurados en el stream
                //System.out.println("Levanta Timer:"+stream.getPoolTime());
                Timer timer = new Timer();
                int time=stream.getPoolTime();
                //Este número es por defecto, ya que si el stream maneja solo una red tipo listenAlive, es posible que no le hayan puesto un 
                //valor a stream.getPoolTime(), por lo cual, en la línea de abajo que crea el timer marcaría un error (Non-positive period).
                if(time<1) time=15; //15 milisegundos por defecto
                int periodTime = (time*MILIGSEG_IN_SEG)*60; //El tiempo por 1000 para que sea en segundos y por 60 para que sea en minutos
                timer.schedule(new ListenerTask(stream), 3*MILIGSEG_IN_SEG,periodTime); 
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
        boolean firstTime=true;

        public ListenerTask(Stream stream)
        {
            this.stream=stream;
        }

        public void run() {
            if(firstTime)
            {
                doSomeTask(stream);
                firstTime=false;
            }
            if(createTimer(stream))
            {
                //////////////////////Agregado para alerta de cantidad de mensajes inusuales en un Stream
                int streamIterations=stream.getStreamIterations();
                System.out.println("Ejecuta Timer:"+stream+",streamIterations:"+streamIterations);
                if(streamIterations>0 && stream.getStreamPercentageAlert()>0 && stream.getStreamEmail2Alerts().trim().length()>0) //Si los usuarios escribieron un porcentaje en el dato del Stream, entonces se revisa
                {
                    float oldStreamPostInAvg=stream.getPromPostNumber();
                    int newStreamPostIns = Integer.parseInt(getAllPostInStream_Query(stream)); 
                    float newStreamPostInAvg=newStreamPostIns/streamIterations;
                    stream.setPromPostNumber(newStreamPostInAvg);   //Se graba el nuevo promedio en el Stream
                    //System.out.println("oldStreamPostInAvg:"+oldStreamPostInAvg+",newStreamPostInAvg:"+newStreamPostInAvg);    
                    if(oldStreamPostInAvg>0)
                    {
                        float difAvgs=((newStreamPostInAvg*100)/oldStreamPostInAvg)-100;
                        //System.out.println("difAvgs:"+difAvgs);
                        if(difAvgs>0 && difAvgs>=(stream.getStreamPercentageAlert()))
                        {//Si se cumple, entonces envía alerta
                            //System.out.println("Entra a Notificar por correo:"+difAvgs);
                            String messageBody="Notificación:<br/><br/>";
                            messageBody+="El Stream con nombre:"+stream.getDisplayTitle("es")+", perteneciente a la marca:"+stream.getSemanticObject().getModel().getName()+",<br/><br/>";
                            messageBody+="ha sobrepasado el porcentaje del "+stream.getStreamPercentageAlert()+"% definido para el stream en cada iteración.<br/><br/><br/><br/><br/><br/><br/><br/>";
                            messageBody+="<b>Atte. Servicio de Notificaciones de SWBSocial</b>";
                            String emails=stream.getStreamEmail2Alerts();
                            System.out.println("Se enviarían emails a estas cuentas notificando que se sobrepaso el porcentaje de mensajes de entrada del Stream:"+emails);
                            try{
                                SWBUtils.EMAIL.sendBGEmail(emails, "Notificación-Mensajes sobrepasó promedio en Stream:"+stream.getDisplayTitle("es"), messageBody);
                                //System.out.println("Envió correo:"+difAvgs);
                            }catch(Exception e)
                            {
                                e.printStackTrace();
                                log.error(e);
                            }
                        }
                    }
                }
                stream.setStreamIterations(streamIterations+1); //Grava la primera iteración
                System.out.println("Iteración:"+stream.getStreamIterations());
                ///////////////////// Termina Agregado para alerta de cantidad de mensajes inusuales en un Stream
                boolean isThereNoListenAliveNets=false;
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
                            //System.out.println("Ejecuta Red Social/ListenAlive:"+socialNet.getId());
                            KeepAliveListenerable listenAliveableNet=(KeepAliveListenerable)socialNet;
                            try{
                                listenAliveableNet.listenAlive(stream);
                            }catch(Exception e){
                                log.error(e);
                            }
                        }else   //De lo contrario, si se envía a que escuche
                        {
                            //System.out.println("Ejecuta Red Social/Listen:"+socialNet.getId());
                            try{
                                //socialNet.listen(stream);
                                 ListenerClassifierThread lisClassThread=new ListenerClassifierThread(socialNet, stream);
                                 lisClassThread.start();
                            }catch(Exception e){
                                log.error(e);
                            }
                            isThereNoListenAliveNets=true;
                        }
                    }else   //De lo contrario, si se envía a que escuche
                    {
                        //System.out.println("Ejecuta Red Social/Listen:"+socialNet.getId());
                        try{
                            //socialNet.listen(stream);
                            ListenerClassifierThread lisClassThread=new ListenerClassifierThread(socialNet, stream);
                            lisClassThread.start();
                        }catch(Exception e){
                            log.error(e);
                        }
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
                //System.out.println("stream es nulo o es inactivo o esta borrado.....:"+stream);
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
        //System.out.println("ListerJ5");
        if(stream!=null && stream.getSocialSite().isValid()  && stream.isActive() && !stream.isDeleted()  && stream.listSocialNetworks().hasNext())
        {
            //System.out.println("ListerJ5.1:"+stream.getPhrase());
            if(stream.getPhrase()!=null || stream.getStream_allPhrases()!=null || stream.getStream_exactPhrase()!=null || stream.getStream_fromAccount()!=null)
            {
                Iterator<SocialNetwork> itNets=stream.listSocialNetworks();
                while(itNets.hasNext())
                {
                    SocialNetwork socialNets=itNets.next();
                    if(!socialNets.isActive() || socialNets.isDeleted())
                    {
                        //System.out.println("ListerJ6-FALSE");
                        return false;
                    }
                }
                
                //Si es isKeepAliveManager==true, no importaría si no le ponen un tiempo para que este llamandose el thread, 
                //ya que este es llamado internamente desde cada red social que maneje esta caracteristica
                //System.out.println("IsKeppAlive:"+stream.isKeepAliveManager()+",poolTime:"+stream.getPoolTime());
                if(stream.isKeepAliveManager() || stream.getPoolTime() > 0)
                {
                    //System.out.println("ListerJ7-True");
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
            //System.out.println("Entra a removeTimer de stream:"+stream.getURI());
            //System.out.println("Entra a removeTimer de stream-GeorgEEEEEE:"+stream.getURI());
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
                //System.out.println("Entra a removeTimer de stream-1:"+stream.getURI());
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
    
    
    private static void doSomeTask(Stream stream)
    {
        //TODO:Desabilitar guardado de log, revisar con Javier despues
        WebSite wsite=WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        wsite.getSemanticModel().setTraceable(false);
        //System.out.println("DESACTIVA TRACE DE MODELO:"+wsite);
        //Termina
                
        //System.out.println("Entra a doSomeTask...-1");
        //Revisar redes sociales que se encuentran en este momento en el stream
        ArrayList asocialNetIDs=new ArrayList();    //White List -Lista buena-Lista que si esta en el stream
        Iterator <SocialNetwork> itSn=stream.listSocialNetworks();
        while(itSn.hasNext())
        {
            SocialNetwork socialNet=itSn.next();
            //System.out.println("doSomeTask/socialNet lista blanca:"+socialNet.getURI());
            asocialNetIDs.add(socialNet.getURI());   //Se agrega el id de la red social a la lista blanca (asocialNetIDs)
        }

        //Si en la clase SocialNetStreamSearch existe alguna instancia de SocialNetwork para el stream que no este en la mismo Stream(Lista blanca de arriba), entonces se elimina
        Iterator <SocialNetStreamSearch> itSocialNetStreamSearch=SocialNetStreamSearch.ClassMgr.listSocialNetStreamSearchByStream(stream, stream.getSocialSite());
        while(itSocialNetStreamSearch.hasNext())
        {
            SocialNetStreamSearch socialNetStreamSearch=itSocialNetStreamSearch.next();
            if(socialNetStreamSearch.getSocialNetwork()!=null)
            {
                //Si la red social del objeto socialNetStreamSearch, no se encuentra en la lista blanca, se eliminara dicho objeto
                if(!asocialNetIDs.contains(socialNetStreamSearch.getSocialNetwork().getURI()))  
                {
                    //System.out.println("doSomeTask/Se elimina SocialNet:"+socialNetStreamSearch.getSocialNetwork().getURI()+" de la clase:SocialNetStreamSearch, puesto que ya no esta en el strea:"+stream.getURI());
                    socialNetStreamSearch.remove();
                }
            }
        }
        //System.out.println("Entra a doSomeTask...-2");
        //Se actualiza el Listener del stream
    }
    
    
    private static String getAllPostInStream_Query(Stream stream) {
        String query =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX social: <http://www.semanticwebbuilder.org/swb4/social#>"
                + "\n";
        query += "select DISTINCT (COUNT(?postUri) AS ?c1) \n";    //Para Gena
        query +=
                "where {\n"
                + "  ?postUri social:postInStream <" + stream.getURI() + ">. \n"
                + "  }\n";
        //System.out.println("query:"+query);
        WebSite wsite = WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        query = SWBSocial.executeQuery(query, wsite);
        return query;
    }
    

    /*
     * Metodo de prueba
     */
    public static void main(String args[]) {
        //System.out.println("About to schedule task.");
        new ListenerMgr(); //C/cuantos segundos se ejecutara la tarea
        //System.out.println("Task scheduled.");
    }
}
