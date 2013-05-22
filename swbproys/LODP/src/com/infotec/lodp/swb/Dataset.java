package com.infotec.lodp.swb;

import static com.infotec.lodp.swb.utils.LODPUtils.log;
import java.util.Date;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;


public class Dataset extends com.infotec.lodp.swb.base.DatasetBase 
{
    
        
    /** The log. */
    private final static Logger log=SWBUtils.getLogger(WebPage.class);

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
    }
    
    public Dataset(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
        if(viewed)
        {
            timer = System.currentTimeMillis();
            updateDSViews();//setViews(views);
            viewed = false;
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
     * Update views.
     */
    public void updateHits()
    {
        if(hitted)
        {
            timer = System.currentTimeMillis();
            updateDSDownload(); //setDownloads(hits);
            hitted = false;
        }
    }
        
     /**
     *  Add last download date and update number of downloads
     * @param ds dataset to modify download information
     * @return true or false
     */
    public void updateDSDownload(){
        try {
            Date now = new Date(System.currentTimeMillis());
            setLastDownload(now);
            incHits();
            setDownloads(hits);
        } catch (Exception e) {
            log.error("Error al actualizar la información de descargas del DataSet",e);
        }
    }
    
    /**
     * Updates dataset views information and last view date
     * @param ds dataset to modify views information
     * @return true or false
     */
    public void updateDSViews(){
        try {
            Date now = new Date(System.currentTimeMillis());
            setLastView(now);
           incViews();
            setViews(views);
        } catch (Exception e) {
            log.error("Error al actualizar la información de vistas del DataSet",e);
        }
    }
    
}
