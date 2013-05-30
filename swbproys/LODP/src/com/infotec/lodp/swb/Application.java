package com.infotec.lodp.swb;

import static com.infotec.lodp.swb.Dataset.datasetDBHit;
import static com.infotec.lodp.swb.Dataset.datasetDBView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.SWBObserver;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.access.SWBHitCounter;


public class Application extends com.infotec.lodp.swb.base.ApplicationBase 
{
     /** The log. */
    private final static Logger log=SWBUtils.getLogger(Application.class);

        /** The parts. */
    private ArrayList parts;
    
        /** The act path. */
    private String actPath;    
    
    /** The views. */
    private long views=-1;
    
        /** The hits. */
    private long hits=-1;
    
    /** The timer. */
    private long timer;                     //valores de sincronizacion de views, hits
    
    /** The time. */
    private static long time;                      //tiempo en milisegundos por cada actualizacion
    
    /** The viewed. */
    private boolean viewed = false;
    
    /** The hitted. */
    private boolean hitted = false;

    private static HashMap logv, logh, appviewsmap, apphitsmap;
    
    private static String dbpatern=null;
    
    static
    {
        time = 600000L;
        try
        {
            time = 1000L * Long.parseLong((String) SWBPlatform.getEnv("swb/accessLogTime","600"));
        } catch (Exception e)
        {
            log.error("Error to read accessLogTime...",e);
        }
        
        logv=new HashMap();
        logh=new HashMap();
         appviewsmap =new HashMap();
         apphitsmap =new HashMap();
        
        SWBPortal.getMessageCenter().registerObserver("apv", new SWBObserver() {
            @Override
            public void sendDBNotify(String s, Object obj)
            {
                String str=(String)obj;
                
                StringTokenizer st = new StringTokenizer(str, "|");
                if (st.hasMoreTokens())
                {
                    String prefijo = st.nextToken();
                    String date = st.nextToken();
                    String ipuser = st.nextToken();
                    String ipserver = st.nextToken();
                    String sess = st.nextToken();
                    String map = st.nextToken();
                    String topic = st.nextToken();
                    String rep = st.nextToken();
                    String user = st.nextToken();
                    String usertype = st.nextToken();
                    String device = st.nextToken();
                    String lang = st.nextToken();
                    String ds = st.nextToken();
                    
                    if (!SWBPortal.isClient())
                    {      
                        str=str.substring(prefijo.length()+1);
                        SWBPortal.getAccessLog().log(logv,map,"_app_views",str);
                        
                        String sdate = date.substring(0, 10);
                        
                        if(!sdate.equals(dbpatern))
                        {
                            SWBPortal.getAccessLog().updateHitsIter(appviewsmap.values().iterator());
                            SWBPortal.getAccessLog().updateHitsIter(apphitsmap.values().iterator());
                            dbpatern=sdate;
                        }                        
                        datasetDBView(map, ds, sdate);
                    }
                    
                    try
                    {
                        Dataset dataset=(Dataset)SemanticObject.createSemanticObject(SemanticObject.shortToFullURI(ds)).createGenericInstance();
                        if(dataset.incViews() && !SWBPortal.isClient()) dataset.updateViews();
                    } catch (Exception e)
                    {
                        log.error("Error to increment views of Application:"+ds,e);
                    }
                }
            }
        });
        SWBPortal.getMessageCenter().registerObserver("aph", new SWBObserver() {
            @Override
            public void sendDBNotify(String s, Object obj)
            {
                String str=(String)obj;
                
                StringTokenizer st = new StringTokenizer(str, "|");
                if (st.hasMoreTokens())
                {
                    String prefijo = st.nextToken();
                    String date = st.nextToken();
                    String ipuser = st.nextToken();
                    String ipserver = st.nextToken();
                    String sess = st.nextToken();
                    String map = st.nextToken();
                    String topic = st.nextToken();
                    String rep = st.nextToken();
                    String user = st.nextToken();
                    String usertype = st.nextToken();
                    String device = st.nextToken();
                    String lang = st.nextToken();
                    String ds = st.nextToken();
                    
                    
                    if (!SWBPortal.isClient())
                    {             
                        str=str.substring(prefijo.length()+1);
                        SWBPortal.getAccessLog().log(logh,map,"_app_hits",str);
                        
                        String sdate = date.substring(0, 10);
                        
                        datasetDBHit(map, ds, sdate);
                    }
                    
                    try
                    {
                        Dataset dataset=(Dataset)SemanticObject.createSemanticObject(SemanticObject.shortToFullURI(ds)).createGenericInstance();
                        if(dataset.incHits() && !SWBPortal.isClient()) dataset.updateViews();
                    } catch (Exception e)
                    {
                        log.error("Error to increment Hits of Application:"+ds,e);
                    }
                }                
            }
        });  
    }
    
    public Application(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    /**
     * Topic hit.
     * 
     * @param map the map
     * @param tp the tp
     * @param sdate the sdate
     */
    public static void applicationDBView(String map, String app_suri, String sdate)
    {
        Object obj = appviewsmap.get(map);
        if (obj != null)
        {
            HashMap ma = (HashMap) obj;
            obj = ma.get(app_suri);
            if (obj != null)
            {
                SWBHitCounter cont = (SWBHitCounter) obj;
                cont.hit(sdate);
            } else
            {
                SWBHitCounter cont = new SWBHitCounter(map, app_suri, 13, 0, sdate);
                ma.put(app_suri, cont);
                cont.hit(sdate);
            }
        } else
        {
            HashMap ma = new HashMap();
            appviewsmap.put(map, ma);
            SWBHitCounter cont = new SWBHitCounter(map, app_suri, 13, 0, sdate);
            ma.put(app_suri, cont);
            cont.hit(sdate);
        }
    }    
    
    /**
     * Topic hit.
     * 
     * @param map the map
     * @param tp the tp
     * @param sdate the sdate
     */
    public static void applicationDBHit(String map, String app_suri, String sdate)
    {
        Object obj = apphitsmap.get(map);
        if (obj != null)
        {
            HashMap ma = (HashMap) obj;
            obj = ma.get(app_suri);
            if (obj != null)
            {
                SWBHitCounter cont = (SWBHitCounter) obj;
                cont.hit(sdate);
            } else
            {
                SWBHitCounter cont = new SWBHitCounter(map, app_suri, 14, 0, sdate);
                ma.put(app_suri, cont);
                cont.hit(sdate);
            }
        } else
        {
            HashMap ma = new HashMap();
            apphitsmap.put(map, ma);
            SWBHitCounter cont = new SWBHitCounter(map, app_suri, 14, 0, sdate);
            ma.put(app_suri, cont);
            cont.hit(sdate);
        }
    }     
    
    /**
     * Inc views.
     * 
     * @return true, if successful
     */
    public boolean incViews()
    {
        synchronized(this)
        {
            viewed = true;
            if(views==-1)
            {
                views=getViews();
            }
            views+=1;
            long t = System.currentTimeMillis() - timer;
            if (t > time || t < -time)
            {
                return true;
            }
            return false;
        }
    }
    
    /**
     * Update views.
     */
    public void updateViews()
    {
        if(viewed || hitted)
        {
            timer = System.currentTimeMillis();
            setViews(views);
            setDownloads(hits);
            if(viewed)setLastView(new Date());
            if(hitted)setLastDownload(new Date());
            viewed = false;
            hitted = false;
            //System.out.println("******************************** Update WebPage ************************");
            //System.out.println((char)7);
        }
    }    
    
     /**
     * Inc views.
     * 
     * @return true, if successful
     */
    public boolean incHits()
    {
        synchronized(this)
        {
            hitted = true;
            if(hits==-1)
            {
                hits=getDownloads();
            }
            hits+=1;
            long t = System.currentTimeMillis() - timer;
            if (t > time || t < -time)
            {
                return true;
            }
            return false;
        }
    }
 /**
     * Builds the.
     * 
     * @param request the request
     * @param response the response
     * @param out the out
     * @param user the user
     * @param topic the topic
     * @param savelog the savelog
     * @param content the content
     * @param distparams the distparams
     */
    public void sendView(HttpServletRequest request, User user, WebPage topic) 
    {
        //System.out.println("Enter Builder...");
        StringBuffer logbuf = null;
        if (true)
        {
            logbuf = new StringBuffer(300);
            logbuf.append("apv|");
            logbuf.append(request.getRemoteAddr());
            logbuf.append("|");
            logbuf.append(SWBPortal.getMessageCenter().getAddress());
            //logbuf.append("_");
            logbuf.append("|");
            String sess=request.getSession().getId();
            if(sess!=null)
            {
                sess=""+sess.hashCode();
            }else sess="_";
            logbuf.append(sess);
            logbuf.append("|");
            logbuf.append(topic.getWebSiteId());
            logbuf.append("|");
            //logbuf.append(topic.getSId());
            logbuf.append(topic.getId());
            logbuf.append("|");
            logbuf.append(user.getUserRepository().getId());
            logbuf.append("|");
            if (user.getLogin() != null)
                logbuf.append(user.getLogin());
            else
                logbuf.append("_");
            logbuf.append("|");
            logbuf.append(user.getSemanticObject().getSemanticClass().getClassId());
            logbuf.append("|");
            if(user.getDevice()!=null)
                logbuf.append(user.getDevice().getId());
            else
                logbuf.append("_");
            logbuf.append("|");
            if (user.getLanguage() != null && user.getLanguage().length() > 0)
                logbuf.append(user.getLanguage());
            else
                logbuf.append("_");
            logbuf.append("|");
            logbuf.append(this.getShortURI());
        }
        if (true)
        {
            SWBPortal.getMessageCenter().sendMessage(logbuf.toString());
        }
    }
    
     /**
     * Builds the.
     * 
     * @param request the request
     * @param response the response
     * @param out the out
     * @param user the user
     * @param topic the topic
     * @param savelog the savelog
     * @param content the content
     * @param distparams the distparams
     */
    public void sendHit(HttpServletRequest request, User user, WebPage topic) 
    {
        //System.out.println("Enter Builder...");
        StringBuffer logbuf = null;
        if (true)
        {
            logbuf = new StringBuffer(300);
            logbuf.append("aph|");
            logbuf.append(request.getRemoteAddr());
            logbuf.append("|");
            logbuf.append(SWBPortal.getMessageCenter().getAddress());
            //logbuf.append("_");
            logbuf.append("|");
            String sess=request.getSession().getId();
            if(sess!=null)
            {
                sess=""+sess.hashCode();
            }else sess="_";
            logbuf.append(sess);
            logbuf.append("|");
            logbuf.append(topic.getWebSiteId());
            logbuf.append("|");
            //logbuf.append(topic.getSId());
            logbuf.append(topic.getId());
            logbuf.append("|");
            logbuf.append(user.getUserRepository().getId());
            logbuf.append("|");
            if (user.getLogin() != null)
                logbuf.append(user.getLogin());
            else
                logbuf.append("_");
            logbuf.append("|");
            logbuf.append(user.getSemanticObject().getSemanticClass().getClassId());
            logbuf.append("|");
            if(user.getDevice()!=null)
                logbuf.append(user.getDevice().getId());
            else
                logbuf.append("_");
            logbuf.append("|");
            if (user.getLanguage() != null && user.getLanguage().length() > 0)
                logbuf.append(user.getLanguage());
            else
                logbuf.append("_");
            logbuf.append("|");
            logbuf.append(this.getShortURI());
        }
        if (true)
        {
            SWBPortal.getMessageCenter().sendMessage(logbuf.toString());
        }
    }
    
}
