/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.listener;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebSite;
import org.semanticwb.social.Rss;
import org.semanticwb.social.RssNew;
import org.semanticwb.social.RssSource;
import org.semanticwb.social.SocialSite;
import org.semanticwb.social.util.CommunityNews;
import org.semanticwb.social.util.SWBSocialCalendarMgr;
import org.semanticwb.social.util.SWBSocialUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author jorge.jimenez
 */
public class RssListenerMgr {
    
    private static Logger log = SWBUtils.getLogger(SWBSocialCalendarMgr.class);
    static final int MILISEG_IN_SEGUNDO = 1000;
    static private Hashtable<String, Timer> htTimers = new Hashtable();
    static private boolean canEnter=true;
    
     /*
     * Metodo constructor que levanta listener de cada uno de los streams de RSS de cada sitio de tipo SWBSocial
     */
    
    public RssListenerMgr() {
        //System.out.println("Entra a RssListenerMgr-1");
        try {
            Iterator<WebSite> itWebSites = SWBContext.listWebSites(false);
            while (itWebSites.hasNext()) {
                WebSite wsite = itWebSites.next();
                if (wsite.isActive() && !wsite.isDeleted() && wsite instanceof SocialSite) {
                    Iterator<Rss> itRssStreams = Rss.ClassMgr.listRsses(wsite); 
                    while (itRssStreams.hasNext()) {
                        Rss rss = itRssStreams.next();
                        //System.out.println("Entra a RssListenerMgr-2:"+rss);
                        if (canCreateTimer(rss))
                        {
                            //System.out.println("Entra a RssListenerMgr-3:"+rss);
                            createTimer(rss);
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
    public static boolean createUpdateTimers(Rss rss)
    {
        //System.out.println("createUpdateTimers/STREAM:"+stream);
        try
        {
            synchronized(rss)
            {
              //System.out.println("createUpdateTimers-1");  
              if(canEnter)
              {
                  //System.out.println("createUpdateTimers-2");  
                  canEnter=false;
                  createUpdateTimersReBind(rss);
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
    private static void createUpdateTimersReBind(Rss rss)
    {
        if(htTimers.get(rss.getURI())!=null)
        {
            removeTimer(rss);
        }
        if(canCreateTimer(rss))
        {
            createTimer(rss);
            return;
        }
        canEnter=true;
    }
    
    
    /**
     * Clase de tipo Timer, ejecuta listen de Rss
     */ 
    private static class ListenerTask extends TimerTask
    {
        Rss rss=null;
        public ListenerTask(Rss rss)
        {
            this.rss=rss;
        }
        public void run() {
            //System.out.println("Entra a RssListenerTask/run-1");
            if(canCreateTimer(rss))
            {
                //System.out.println("Entra a RssListenerTask/run-2");
                //check tags to compare in the Rss sites
                WebSite wsite=rss.getSocialSite();
               
                if(!rss.listRssNews().hasNext()) rss.setRssLastPubDate(null);
                Date rssLastUpdate=rss.getRssLastPubDate();
                if(rssLastUpdate==null) {
                    Calendar calRssLastUpdate=Calendar.getInstance();
                    calRssLastUpdate.add(Calendar.DAY_OF_MONTH, -365);
                    rssLastUpdate=calRssLastUpdate.getTime();
                }
                //if(rssLastUpdate!=null)System.out.println("rssLastUpdate:"+rssLastUpdate.toString());
                
                ArrayList<String> amsgWords=new ArrayList();
                String[] msgWords=rss.getTags().split(",");
                for(int i=0;i<msgWords.length;i++)
                {
                    String msgWord=msgWords[i];
                    if(msgWord!=null && msgWord.length()>0)
                    {
                        amsgWords.add(msgWord.toLowerCase());
                    }
                }
                //Ends check tags to compare in the Rss sites
                Date maxdateTmp=null;
                Iterator<RssSource> itRssSources=rss.listRssSourceses();
                while(itRssSources.hasNext())
                {
                    RssSource rssSource=itRssSources.next();
                    if(!rssSource.isActive()) continue;
                    {
                        //System.out.println("Entra a RssListenerTask/run-3:"+rssSource);
                        Document dom = SWBUtils.XML.getNewDocument();
                        dom=getDom(rssSource);
                        if(dom != null) 
                        {
                            //System.out.println("Entra a RssListenerTask/run-4:"+dom);
                            ArrayList swbNews=new ArrayList();
                            NodeList nListItems=dom.getElementsByTagName("item");
                            for(int i=0;i<nListItems.getLength();i++){  //Theorically, nListItems.getLength() must be allways equal to 1
                                NodeList nListItemChilds=nListItems.item(i).getChildNodes();
                                boolean createCommunityNew=false;
                                for(int j=0;j<nListItemChilds.getLength();j++)
                                {
                                    Node node=nListItemChilds.item(j);
                                    if(node.getNodeName().equalsIgnoreCase("title") || node.getNodeName().equalsIgnoreCase("description"))
                                    {
                                        for(int k=0;k<amsgWords.size();k++)
                                        {
                                            String word=amsgWords.get(k);
                                            //System.out.println("Entra a RssListenerTask/run-5:"+word);
                                            if(node.getFirstChild()!=null && node.getFirstChild().getNodeValue().toLowerCase().indexOf(word)>-1)
                                            {
                                                createCommunityNew=true;
                                                break;
                                            }
                                        }
                                    }
                                    if(createCommunityNew) break;
                                }
                                if(createCommunityNew)
                                {
                                    //System.out.println("Entra a RssListenerTask/run-6");
                                    CommunityNews comNews=new CommunityNews();
                                    comNews.setNode(nListItems.item(i));
                                    swbNews.add(comNews);
                                }
                            }
                            Iterator <CommunityNews> itNews=swbNews.iterator();
                            while(itNews.hasNext()){
                                CommunityNews comNew=itNews.next();
                                //System.out.println("Entra a RssListenerTask/run-7:"+comNew);
                                Date pubDate=null;
                                //System.out.println("comNew.getPubDate():"+comNew.getPubDate());
                                String newPubDate=comNew.getPubDate();
                                if(newPubDate!=null && newPubDate.trim().length()>0) {
                                    try{
                                        pubDate=new Date(newPubDate);
                                    }catch(Exception e) 
                                    {//Hay ocaciones que la fecha no exista de esta forma: Fri, 11 Sep 2015 12:44:22 GMT, que sería la forma correcta, 
                                        //en cambio luego biene de esta forma 17:15, que solo representa una hora (Esto sucede en www.eluniversal.com.mx, 
                                        //por lo que para ese caso se le da el siguiente tratamiento.
                                        int pos=newPubDate.indexOf(":");
                                        if(pos>-1)
                                        {
                                            try{
                                                String hour=newPubDate.substring(0,pos);
                                                String minute=newPubDate.substring(pos+1);
                                                Date newDate=new Date();
                                                newDate.setHours(Integer.parseInt(hour)); 
                                                newDate.setMinutes(Integer.parseInt(minute)); 
                                                pubDate=new Date(newDate.toString());
                                            }catch(Exception ignored){}
                                        }
                                    }
                                }
                                if(pubDate!=null && pubDate.after(rssLastUpdate))
                                {
                                    if(maxdateTmp==null || pubDate.after(maxdateTmp)) maxdateTmp=pubDate;
                                    //System.out.println("Entra a RssListenerTask/run-8:"+maxdateTmp);
                                    RssNew rssNew=RssNew.ClassMgr.createRssNew(wsite);
                                    try{
                                        rssNew.setTitle(SWBUtils.TEXT.encode(comNew.getTitle(), "iso8859-1")); 
                                        rssNew.setDescription(SWBUtils.TEXT.encode(comNew.getDescription(), "iso8859-1"));
                                        rssNew.setRssLink(comNew.getLink());
                                        rssNew.setMediaContent(comNew.getMediaContent());
                                        rssNew.setRssPubDate(pubDate);
                                        rssNew.setRssBelongs(rss);
                                        rssNew.setRssSource(rssSource);
                                        //System.out.println("Entra a RssListenerTask/run-9/NewRssNew:"+rssNew.getRssBelongs());
                                        //Checks Sentiment
                                        HashMap hmapValues = SWBSocialUtil.Classifier.classifyText(rssNew.getTitle()+rssNew.getDescription());
                                        //float promSentimentalValue = ((Float) hmapValues.get("promSentimentalValue")).floatValue();
                                        int rssSentimentalValueType = ((Integer) hmapValues.get("sentimentalTweetValueType")).intValue();
                                        //float promIntensityValue = ((Float) hmapValues.get("promIntensityValue")).floatValue();
                                        int rssIntensityValueType = ((Integer) hmapValues.get("intensityTweetValueType")).intValue();
                                        //String lang=(String)hmapValues.get("msg_lang");
                                        rssNew.setRssNewSentimentalType(rssSentimentalValueType);
                                        rssNew.setRssNewIntensityType(rssIntensityValueType);
                                    }catch(Exception ex){
                                        log.error(ex);
                                    }
                                }
                            }
                        }
                    }
                }               
                //System.out.println("maxdateTmp:"+maxdateTmp);
                if(maxdateTmp!=null) {
                    rss.setRssLastPubDate(maxdateTmp);
                }
                //List all the RssNews in the RSS
                //System.out.println("Rss/Lista RSSNewsGeorge:"+rss.getId()+",Tiene??:"+rss.listRssNews().hasNext());
                /*
                Iterator<RssNew> itRssNews=RssNew.ClassMgr.listRssNewByRssBelongs(rss);
                while(itRssNews.hasNext())
                {
                    RssNew rssNew=itRssNews.next();
                    System.out.println("rssNew Id:"+rssNew.getId());
                    System.out.println("rssNew Title:"+rssNew.getTitle());
                    System.out.println("rssNew Description:"+rssNew.getDescription());
                    System.out.println("rssNew Link:"+rssNew.getRssLink());
                    System.out.println("rssNew Media:"+rssNew.getMediaContent());
                    //System.out.println("rssNew PubDate:"+rssNew.getRssPubDate().toString());
                    System.out.println("rssNew SentimentalType:"+rssNew.getRssNewSentimentalType());
                    System.out.println("rssNew IntensityType:"+rssNew.getRssNewIntensityType());
                    //rssNew.remove();
                }*/
                
            }else
            {
                //System.out.println("Rss es nulo o es inactivo o esta borrado.....:"+rss);
                removeTimer(rss);
            }
            canEnter=true;
        }
     }
    
    
    /*
     * Metodo cuya funcionalidad es la de verificar si se podría crear un thread de acuerdo a los datos que posee un stream de Rss dado.
     */
    private static boolean canCreateTimer(Rss rss)
    {
        //System.out.println("ListerJ5");
        if(rss!=null && rss.getSocialSite().isValid()  && rss.isActive() && !rss.isDeleted()  && rss.listRssSourceses().hasNext())
        {
            //System.out.println("ListerJ5.1:"+stream.getPhrase());
            if(rss.getTags()!=null && (rss.getDailyHour()>0 || rss.getListenbyPeriodTime()>0))
            {
                Iterator<RssSource> itRssSources=rss.listRssSourceses();
                while(itRssSources.hasNext())
                {
                    RssSource rssSource=itRssSources.next();
                    if(rssSource.isActive())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    /*
     * Metodo que elimina un thread de un stream
     */
     public static Timer removeTimer(Rss rss)
     {
        if(htTimers.get(rss.getURI())!=null)
        {
            try
            {
                Timer timer=htTimers.get(rss.getURI());
                htTimers.remove(rss.getURI());
                timer.cancel();
                timer.purge();
                timer=null;
                //System.out.println("Entra a removeTimer de Rss:"+rss.getURI());
                return timer;
            }catch(Exception e)
            {
                log.error(e);
            }
        }
        return null;
     }
    
     private static void createTimer(Rss rss)
     {
        long time2Start=0;
        int period=0;
        if(rss.getDailyHour()>0)
        {
            //System.out.println("rss.getDailyHour():"+rss.getDailyHour());
            //Inicio del timer
            Calendar hour2Start = Calendar.getInstance();
            hour2Start.set(hour2Start.get(Calendar.YEAR),
                    hour2Start.get(Calendar.MONTH),
                    hour2Start.get(Calendar.DATE), rss.getDailyHour(), 00, 00); //Hora de inicio
            Calendar timeNow = Calendar.getInstance(); //Hora actual
            //Milisegundos para empezar por primera vez el timer
            time2Start = hour2Start.getTimeInMillis() - timeNow.getTimeInMillis();
            if(time2Start<0) {  //La hora actual es mayor a la hora de inicio de hoy, agregar un día para que inicie el timer.
                //System.out.println("hour2Start.toString()X:"+hour2Start.toString());
                hour2Start.add(Calendar.DAY_OF_MONTH, 1);
                //System.out.println("hour2Start.toString()Y:"+hour2Start.toString());
                time2Start = hour2Start.getTimeInMillis() - timeNow.getTimeInMillis();
            }
            //period = 60 * MILISEG_IN_SEGUNDO * 60 * 24; //1 día
            period = 60 * MILISEG_IN_SEGUNDO * 3; //3 min
        }else if(rss.getListenbyPeriodTime()>0){
            //System.out.println("rss.getListenbyPeriodTime():"+rss.getListenbyPeriodTime());
            time2Start = 180*MILISEG_IN_SEGUNDO;   //3 minutos
            //period = 60 * MILISEG_IN_SEGUNDO * 60 * rss.getListenbyPeriodTime();
            period = 60 * MILISEG_IN_SEGUNDO * rss.getListenbyPeriodTime(); //Haciendolo como minutos, para probar. El bueno es el de arriba.
        }
        //System.out.println("createTimer/time2Start:"+time2Start+",createTimer/period:"+period);
        if(time2Start>0 && period>0)
        {
            //System.out.println("RssListenerMsg/time2Start Para empezar por primera vez:"+time2Start);
            Timer timer = new Timer();
            timer.schedule(new RssListenerMgr.ListenerTask(rss), 0, 60 * 1000); //Cada minuto
            //Que empiece hoy a las streamRss.getDailyHour() y vuelve a iterar un dia despues y así se siga
            log.event("Initializing RssListenerMsg, starts in:"+time2Start+"ms, periodicity:"+period+",ms");
            //timer.schedule(new RssListenerMsg.CheckStreamsMsgbyDays(), time2Start, oneDay);
            //-->Bueno--timer.schedule(new RssListenerMgr.ListenerTask(rss), time2Start,period);   
            htTimers.put(rss.getURI(), timer);
        }
     }
     
      /**
     * Gets the dom.
     * 
     * @param request the request
     * @param response the response
     * @param paramReq the param req
     * @return the dom
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */
    public static org.w3c.dom.Document getDom(RssSource rssSource) 
    {
        
        try
        {
            URL url = new URL(rssSource.getRss_URL().trim());
            URLConnection urlconn = url.openConnection();
            InputStream is = urlconn.getInputStream();
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            //String rssStr=SWBUtils.IO.readInputStream(is);
            //rssStr=rssStr.replaceAll("~", "");
            //System.out.println("rssStr:"+rssStr);
            //Document dom = SWBUtils.XML.xmlToDom(rssStr);
            return doc;
        }
        catch (Exception e) {
            log.error("Error while generating DOM in resource: "+rssSource, e);
        }
        return null;
    }
     
}
