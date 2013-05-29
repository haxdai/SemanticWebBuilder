package com.infotec.lodp.swb;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.SWBResourceMgr;
import org.semanticwb.portal.api.SWBParamRequestImp;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.api.SWBResourceModes;
import org.semanticwb.portal.util.SWBIFMethod;
import org.semanticwb.portal.util.SWBMethod;
import org.semanticwb.servlet.SWBHttpServletRequestWrapper;
import org.semanticwb.servlet.SWBHttpServletResponseWrapper;
import org.semanticwb.servlet.internal.DistributorParams;


public class Dataset extends com.infotec.lodp.swb.base.DatasetBase 
{
    
        
    /** The log. */
    private final static Logger log=SWBUtils.getLogger(Dataset.class);
    
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
    public void buildView(HttpServletRequest request, HttpServletResponse response, PrintWriter out, User user, WebPage topic, boolean savelog, String content, DistributorParams distparams) 
    {
        //System.out.println("Enter Builder...");
        StringBuffer logbuf = null;
        StringBuffer resbuf = null;
        long tini = 0;
        if (savelog)
        {
            tini = System.currentTimeMillis();
            resbuf = new StringBuffer(300);
            logbuf = new StringBuffer(300);
            logbuf.append("odv|");
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
        }
        log.debug("<!-- ApplicationView1:"+ (System.currentTimeMillis()-tini) +"ms -->");
        build(request, response, out, user, topic, savelog, content, distparams, parts, resbuf);
        if (savelog)
        {
            long tfin = System.currentTimeMillis() - tini;            
            SWBPortal.getMessageCenter().sendMessage(logbuf.toString()+"|"+tfin+resbuf.toString());
        }
        log.debug("<!-- ApplicationViewFin:"+ (System.currentTimeMillis()-tini) +"ms -->");
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
    public void buildHits(HttpServletRequest request, HttpServletResponse response, PrintWriter out, User user, WebPage topic, boolean savelog, String content, DistributorParams distparams) 
    {
        //System.out.println("Enter Builder...");
        StringBuffer logbuf = null;
        StringBuffer resbuf = null;
        long tini = 0;
        if (savelog)
        {
            tini = System.currentTimeMillis();
            resbuf = new StringBuffer(300);
            logbuf = new StringBuffer(300);
            logbuf.append("odh|");
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
        }
        log.debug("<!-- DatasetHit1:"+ (System.currentTimeMillis()-tini) +"ms -->");
        build(request, response, out, user, topic, savelog, content, distparams, parts, resbuf);
        if (savelog)
        {
            long tfin = System.currentTimeMillis() - tini;            
            SWBPortal.getMessageCenter().sendMessage(logbuf.toString()+"|"+tfin+resbuf.toString());
        }
        log.debug("<!-- DatasetHitFin:"+ (System.currentTimeMillis()-tini) +"ms -->");
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
     * @param parts the parts
     * @param resbuf the resbuf
     */
    public void build(HttpServletRequest request, HttpServletResponse response, PrintWriter out, User user, WebPage topic, boolean savelog, String content, DistributorParams distparams, ArrayList parts, StringBuffer resbuf)
    {
        if(parts==null)return;
        HashMap antresrc = new HashMap(5);                    //recursos evaluados anteriormente
        try
        {
            //PrintWriter out=response.getWriter();
            Iterator en = parts.iterator();
            while (en.hasNext())
            {
                Object obj = en.next();
                if (obj instanceof String)
                    out.print(obj);
                else if (obj instanceof SWBMethod)
                {
                    SWBMethod wbm = (SWBMethod) obj;
                    if (wbm.getObj() instanceof User)
                        out.print(wbm.invoke(user, topic, user, request,response));
                    else if (wbm.getObj() instanceof WebPage)
                        out.print(wbm.invoke(topic, topic, user, request,response));
                    else if (wbm.getObj() == HttpServletRequest.class)
                        out.print(wbm.invoke(request, topic, user, request,response));
                    else if (wbm.getObj() == HttpServletResponse.class)
                        out.print(wbm.invoke(response, topic, user, request,response));
                    else if (wbm.getObj() instanceof SWBResourceMgr)
                    {
                        HashMap args = (HashMap) wbm.getArguments(1);
                        if ("content".equals(wbm.getArguments(0)))   //es contenido
                        {
                            if (content != null)
                            {
                                out.println(content);
                                if (savelog && distparams!=null)
                                {
                                    resbuf.append("|");
                                    //System.out.println("distparams:"+distparams);
                                    //System.out.println("topic:"+topic);
                                    if(!topic.getWebSiteId().equals(distparams.getAccResourceTMID()))
                                        resbuf.append("0");
                                    resbuf.append(distparams.getAccResourceID());
                                }
                            } else
                            {
                                boolean first = true;

                                //cambio de topico en el contenido
                                String resTopic=(String)args.get("topic");
                                WebPage auxTopic=null;
                                if(resTopic!=null)
                                {
                                    auxTopic=topic.getWebSite().getWebPage(resTopic);
                                }

                                Iterator it;
                                if(auxTopic!=null)
                                    it = (Iterator) wbm.invoke((SWBResourceMgr) wbm.getObj(), user, auxTopic);
                                else
                                    it = (Iterator) wbm.invoke((SWBResourceMgr) wbm.getObj(), user, topic);
                                int con=-1;
                                while (it.hasNext())
                                {
                                    con++;
                                    SWBResource wbres = (SWBResource) it.next();
                                    //System.out.println("tpl id:"+wbres.getResourceBase().getId()+" prt:"+wbres.getResourceBase().getPriority()+wbres.getResourceBase().getRandPriority());

                                    String resTitle=(String)args.get("gettitle");
                                    if(resTitle!=null)
                                    {
                                        int rt=-1;
                                        try
                                        {
                                            rt=Integer.parseInt(resTitle);
                                        }catch(Exception e){log.error(e);}
                                        if(rt==con)out.print(wbres.getResourceBase().getTitle());
                                        continue;
                                    }

                                    String resDesc=(String)args.get("getdescription");
                                    if(resDesc!=null)
                                    {
                                        int rt=-1;
                                        try
                                        {
                                            rt=Integer.parseInt(resDesc);
                                        }catch(Exception e){log.error(e);}
                                        if(rt==con)out.print(wbres.getResourceBase().getDescription());
                                        continue;
                                    }
/*
                                    String resMUrl=(String)args.get("getmaximizedurl");
                                    if(resMUrl!=null)
                                    {
                                        int rt=-1;
                                        try
                                        {
                                            rt=Integer.parseInt(resMUrl);
                                        }catch(Exception e){AFUtils.log(e);}
                                        if(rt==con)
                                        {
                                            long rid=wbres.getResourceBase().getId();
                                            javax.servlet.http.HttpServletRequest req=null;
                                            if(distparams!=null)
                                            {
                                                req=distparams.getInternalRequest(request,rid);
                                            }else
                                            {
                                                req=new WBHttpServletRequestWrapper(request);
                                            }
                                            WBParamRequestImp resParams = new WBParamRequestImp(req,wbres.getResourceBase(),topic,user);
                                            out.print(resParams.getRenderUrl().setWindowState(WBResourceURL.WinState_MAXIMIZED));
                                        }
                                        continue;
                                    }
                                    String resDUrl=(String)args.get("getdirecturl");
                                    if(resDUrl!=null)
                                    {
                                        int rt=-1;
                                        try
                                        {
                                            rt=Integer.parseInt(resDUrl);
                                        }catch(Exception e){AFUtils.log(e);}
                                        if(rt==con)
                                        {
                                            long rid=wbres.getResourceBase().getId();
                                            javax.servlet.http.HttpServletRequest req=null;
                                            if(distparams!=null)
                                            {
                                                req=distparams.getInternalRequest(request,rid);
                                            }else
                                            {
                                                req=new WBHttpServletRequestWrapper(request);
                                            }
                                            WBParamRequestImp resParams = new WBParamRequestImp(req,wbres.getResourceBase(),topic,user);
                                            out.print(resParams.getRenderUrl().setCallMethod(WBResourceURL.Call_DIRECT));
                                        }
                                        continue;
                                    }
*/
                                    //System.out.println("tpl id:"+wbres.getResourceBase().getId()+" prt:"+wbres.getResourceBase().getIndex());
                                    //if (!(!first && wbres.getResourceBase().getIndex() <= 0))
                                    if(wbres.getResourceBase().getIndex()>0 || (first && wbres.getResourceBase().getIndex()==0 && !it.hasNext()))
                                    {
                                        String resCont=(String)args.get("getcontent");
                                        if(resCont!=null)
                                        {
                                            int rt=-1;
                                            try
                                            {
                                                rt=Integer.parseInt(resCont);
                                            }catch(Exception e){log.error(e);}
                                            if(rt!=con)continue;
                                        }

                                        //System.out.println("tpl ok");
                                        //out.print(SWBResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
                                        String rid=wbres.getResourceBase().getId();
                                        //String rid=wbres.getResourceBase().getSId();
                                        String mdo=null;
                                        String wst=null;
                                        String act=null;
                                        WebPage vtopic=null;
                                        String extParams=null;
                                        if(distparams!=null)
                                        {
                                            vtopic=distparams.getVirtWebPage();
                                            HashMap resp=distparams.getResourceURI(rid);
                                            if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getWebSiteId()))
                                            {
                                                mdo=(String)resp.get(DistributorParams.URLP_MODE);
                                                wst=(String)resp.get(DistributorParams.URLP_WINSTATE);
                                                act=(String)resp.get(DistributorParams.URLP_ACTION);
                                            }
                                            extParams=distparams.getNotAccResourceURI(rid);
                                        }

                                        //System.out.println("rid:"+rid);
                                        //System.out.println("distparams.getAccResourceID():"+distparams.getAccResourceID());

                                        SWBHttpServletResponseWrapper res=new SWBHttpServletResponseWrapper(response);
                                        javax.servlet.http.HttpServletRequest req=null;
                                        if(distparams!=null)
                                        {
                                            req=distparams.getInternalRequest(request,rid);
                                        }else
                                        {
                                            req=new SWBHttpServletRequestWrapper(request);
                                        }

                                        SWBParamRequestImp resParams = new SWBParamRequestImp(req,wbres.getResourceBase(),topic,user);
                                        resParams.setArguments(args);
                                        resParams.setExtURIParams(extParams);
                                        resParams.setCallMethod(SWBResourceModes.Call_CONTENT);
                                        if(act!=null)resParams.setAction(act);
                                        if(mdo!=null)resParams.setMode(mdo);
                                        if(wst!=null)resParams.setWindowState(wst);
                                        if(vtopic!=null)
                                        {
                                            resParams.setVirtualTopic(vtopic);
                                        }

                                        SWBPortal.getResourceMgr().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
                                        out.print(res.toString());

//                                        byte arr[]=res.toByteArray();
//                                        String r=res.toString();
//                                        int ri=r.indexOf("Jei ");
//                                        String f=r.substring(ri,ri+10);
//                                        System.out.println("res:"+f);
//                                        for(int x=0;x<f.length();x++)
//                                        {
//                                            System.out.println(" "+(int)f.charAt(x)+" "+arr[ri+x]);
//                                        }
//                                        //System.out.println("res:"+new String(res.toByteArray(),"UTF-8"));

                                        String intraBR=(String)args.get("intrabr");
                                        if(it.hasNext() && (intraBR==null || intraBR.equalsIgnoreCase("true")))
                                        {
                                            out.println("<br/>");
                                        }
                                        if(savelog)
                                        {
                                            resbuf.append("|");
                                            if(!wbres.getResourceBase().getWebSiteId().equals(topic.getWebSiteId()))
                                                resbuf.append("0");
                                            //resbuf.append(wbres.getResourceBase().getSId());
                                            resbuf.append(wbres.getResourceBase().getId());
                                        }
                                        first = false;
                                    }
                                }
                            }
                        } else                                        //es estrategia
                        {
                            String id = "" + args.get("type") + args.get("stype");       //id para guardar recurso en anteriores
                            if (antresrc.get(id) == null)
                            {
                                //System.out.println("id:"+id+":"+0);
                                Iterator it = (Iterator) wbm.invoke((SWBResourceMgr) wbm.getObj(), user, topic);
                                if (it.hasNext())
                                {
                                    SWBResource wbres = (SWBResource) it.next();
                                    //System.out.println("rec:"+wbres.getResourceBase().getId()+" typemap="+wbres.getResourceBase().getTopicMapId());

                                    //String rid=wbres.getResourceBase().getSId();
                                    String rid=wbres.getResourceBase().getId();
                                    String mdo=null;
                                    String wst=null;
                                    String act=null;
                                    WebPage vtopic=null;
                                    String extParams=null;
                                    if(distparams!=null)
                                    {
                                        vtopic=distparams.getVirtWebPage();
                                        HashMap resp=distparams.getResourceURI(rid);
                                        if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getWebSiteId()))
                                        {
                                            mdo=(String)resp.get(DistributorParams.URLP_MODE);
                                            wst=(String)resp.get(DistributorParams.URLP_WINSTATE);
                                            act=(String)resp.get(DistributorParams.URLP_ACTION);
                                        }
                                        extParams=distparams.getNotAccResourceURI(rid);
                                    }

                                    //out.print(SWBResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
                                    SWBHttpServletResponseWrapper res=new SWBHttpServletResponseWrapper(response);
                                    javax.servlet.http.HttpServletRequest req=null;
                                    if(distparams!=null)
                                    {
                                        req=distparams.getInternalRequest(request,rid);
                                    }else
                                    {
                                        req=new SWBHttpServletRequestWrapper(request);
                                    }

                                    SWBParamRequestImp resParams = new SWBParamRequestImp(request,wbres.getResourceBase(),topic,user);
                                    resParams.setArguments(args);
                                    resParams.setExtURIParams(extParams);
                                    resParams.setCallMethod(SWBResourceModes.Call_STRATEGY);
                                    if(act!=null)resParams.setAction(act);
                                    //resParams.setCallMethod(mto);
                                    if(mdo!=null)resParams.setMode(mdo);
                                    if(wst!=null)resParams.setWindowState(wst);
                                    if(vtopic!=null)
                                    {
                                        resParams.setVirtualTopic(vtopic);
                                    }

                                    SWBPortal.getResourceMgr().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
                                    out.print(res.toString());

                                    //System.out.println("Salida:"+wbres.getResourceBase().getId()+":"+res.toString());

                                    if (savelog)
                                    {
                                        resbuf.append("|");
                                        if(!wbres.getResourceBase().getWebSiteId().equals(topic.getWebSiteId()))
                                            resbuf.append("0");
                                        //resbuf.append(wbres.getResourceBase().getSId());
                                        resbuf.append(wbres.getResourceBase().getId());
                                    }
                                }
                                if (it.hasNext()) antresrc.put(id, it);
                            } else
                            {
                                //System.out.println("id:"+id+":n");
                                Iterator it = (Iterator) antresrc.get(id);
                                SWBResource wbres = (SWBResource) it.next();

                                //String rid=wbres.getResourceBase().getSId();
                                String rid=wbres.getResourceBase().getId();
                                String mdo=null;
                                String wst=null;
                                String act=null;
                                WebPage vtopic=null;
                                String extParams=null;
                                if(distparams!=null)
                                {
                                    vtopic=distparams.getVirtWebPage();
                                    HashMap resp=distparams.getResourceURI(rid);
                                    if(resp!=null && distparams.getResourceTMID(rid).equals(wbres.getResourceBase().getWebSiteId()))
                                    {
                                        mdo=(String)resp.get("_mod");
                                        wst=(String)resp.get("_wst");
                                        act=(String)resp.get("_act");
                                    }
                                    extParams=distparams.getNotAccResourceURI(rid);
                                }
                                //out.print(SWBResourceMgr.getInstance().getResourceTraceMgr().getHtmlTraced(wbres, request, response, user, topic, args));
                                SWBHttpServletResponseWrapper res=new SWBHttpServletResponseWrapper(response);
                                javax.servlet.http.HttpServletRequest req=null;
                                if(distparams!=null)
                                {
                                    req=distparams.getInternalRequest(request,rid);
                                }else
                                {
                                    req=new SWBHttpServletRequestWrapper(request);
                                }

                                SWBParamRequestImp resParams = new SWBParamRequestImp(request,wbres.getResourceBase(),topic,user);
                                resParams.setArguments(args);
                                resParams.setExtURIParams(extParams);
                                resParams.setCallMethod(SWBResourceModes.Call_STRATEGY);

                                if(act!=null)resParams.setAction(act);
                                //resParams.setCallMethod(mto);
                                if(mdo!=null)resParams.setMode(mdo);
                                if(wst!=null)resParams.setWindowState(wst);
                                if(vtopic!=null)
                                {
                                    resParams.setVirtualTopic(vtopic);
                                }

                                SWBPortal.getResourceMgr().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
                                out.print(res.toString());

                                if (!it.hasNext()) antresrc.remove(id);
                                if (savelog)
                                {
                                    resbuf.append("|");
                                    if(!wbres.getResourceBase().getWebSiteId().equals(topic.getWebSiteId()))
                                        resbuf.append("0");
                                    //resbuf.append(wbres.getResourceBase().getSId());
                                    resbuf.append(wbres.getResourceBase().getId());
                                }
                            }
                        }
                    }else if (wbm.getObj() instanceof String)
                    {
                        String aux=(String)wbm.getObj();
                        if(aux.equals("include"))
                        {
                            HashMap args = (HashMap) wbm.getArguments(1);
                            out.print(include((String)wbm.getArguments(0),request,response,user,topic,args));
                        }
                    } else
                    {
                        out.print(wbm.invoke(topic, user, request,response));
                    }
                }else if (obj instanceof SWBIFMethod)
                {
                    ArrayList subparts=((SWBIFMethod)obj).eval(user, topic);
                    //System.out.println("subparts:"+subparts);
                    build(request, response, out, user, topic, savelog, content, distparams, subparts, resbuf);
                }
            }
        } catch (Exception e)
        {
            log.error("Error Template Build...",e);
        }
    }
    
     /**
     * Include.
     * 
     * @param src the src
     * @param request the request
     * @param response the response
     * @param user the user
     * @param topic the topic
     * @param params the params
     * @return the string
     */
    public String include(String src, HttpServletRequest request, HttpServletResponse response, User user, WebPage topic, HashMap params)
    {
        String ret="";
        try
        {
            if(!(src.startsWith("/") || src.startsWith("http://")))
            {
                src=getActualPath()+src;
            }
            //System.out.println("Include src:"+src);
            SWBHttpServletResponseWrapper res=new SWBHttpServletResponseWrapper(response);
            request.setAttribute("topic", topic);
            request.setAttribute("webpage", topic);
            request.setAttribute("user", user);
            request.setAttribute("params", params);
            request.setAttribute("template", this);
            RequestDispatcher dispatcher = request.getRequestDispatcher(src);
            dispatcher.include(request, res);
            ret=res.toString();
        }catch(Exception e)
        {
            log.error(e);
        }finally
        {
            if(request!=null)
            {
                request.removeAttribute("topic");
                request.removeAttribute("webpage");
                request.removeAttribute("user");
                request.removeAttribute("params");            
                request.removeAttribute("template"); 
            }
        }
        return ret;
    }
    
        /**
     * Regresa ruta web de la version actual de la paltilla.
     * @return Value of property actPath.
     */
    public java.lang.String getActualPath()
    {
        return actPath;
    } 
    
}
