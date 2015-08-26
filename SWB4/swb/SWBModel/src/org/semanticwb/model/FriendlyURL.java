/*
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 */
package org.semanticwb.model;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticTSObserver;


public class FriendlyURL extends org.semanticwb.model.base.FriendlyURLBase 
{
    private static Logger log = SWBUtils.getLogger(FriendlyURL.class);
    
    /** The names. */
    private static ConcurrentHashMap<String,Object> urls = null;
    /** The names. */
    private static ConcurrentHashMap<String,Object> suburls = null;

    public FriendlyURL(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }


    static
    {
        SWBPlatform.getSemanticMgr().registerTSObserver(new SemanticTSObserver() {

            @Override
            public void notify(SemanticObject obj, Statement stmt, String action, boolean remote)
            {
                if(stmt!=null)
                {
                    Property p=stmt.getPredicate();
                    if(p.equals(swb_friendlyURL.getRDFProperty()))
                    {
                        //System.out.println("swb_friendlyURL:"+action+" "+obj+" "+stmt);
                        if(action.equals(SemanticObject.ACT_REMOVE))
                        {
                            //System.out.println("remove friendly..."+obj);
                            removeObject(obj);
                        }else
                        {
                            //System.out.println("add friendly..."+obj);
                            addFriendlyUrl((FriendlyURL)obj.createGenericInstance());                    
                        }
                    }else if(p.equals(swb_friendlySubPaths.getRDFProperty()))
                    {
                        //System.out.println("swb_friendlySubPaths:"+action+" "+obj+" "+stmt);
                        if(action.equals(SemanticObject.ACT_REMOVE))
                        {
                            //System.out.println("remove friendly..."+obj);
                            removeObject(obj);
                        }else
                        {
                            //System.out.println("add friendly..."+obj);
                            addFriendlyUrl((FriendlyURL)obj.createGenericInstance());                    
                        }
                    }
                }else if(obj.instanceOf(FriendlyURL.sclass) && action.equals(SemanticObject.ACT_REMOVE))
                {
                    removeObject(obj);
                }
            }            
        });
        
        
//        swb_friendlyURL.registerObserver(new SemanticObserver()
//        {
//            public void notify(SemanticObject obj, Object prop, String lang, String action)
//            {
//                removeObject(obj);
//                addFriendlyUrl((FriendlyURL)obj.createGenericInstance());
//            }
//        });
//
//        swb_FriendlyURL.registerObserver(new SemanticObserver()
//        {
//            public void notify(SemanticObject obj, Object prop, String lang, String action)
//            {
//                if(action.equals(SemanticObject.ACT_REMOVE))
//                {
//                    removeObject(obj);
//                }
//            }
//        });
    }

    private static void removeObject(SemanticObject obj)
    {
        //System.out.println("removeObject:"+obj);
        Iterator it=urls.values().iterator();
        while (it.hasNext())
        {
            Object object = it.next();
            if(object instanceof FriendlyURL)
            {
                FriendlyURL f=(FriendlyURL)object;
                if(f.getURI().equals(obj.getURI()))it.remove();
            }
            if(object instanceof ArrayList)
            {
                Iterator<FriendlyURL> it2=((ArrayList)object).iterator();
                while (it2.hasNext())
                {
                    FriendlyURL f=(FriendlyURL)it2.next();
                    //System.out.println("removeObject 2:"+f+","+obj);
                    if(f.getURI().equals(obj.getURI()))it2.remove();
                }
            }
        }
        
        it=suburls.values().iterator();
        while (it.hasNext())
        {
            Object object = it.next();
            if(object instanceof FriendlyURL)
            {
                FriendlyURL f=(FriendlyURL)object;
                if(f.getURI().equals(obj.getURI()))it.remove();
            }
            if(object instanceof ArrayList)
            {
                Iterator<FriendlyURL> it2=((ArrayList)object).iterator();
                while (it2.hasNext())
                {
                    FriendlyURL f=(FriendlyURL)it2.next();
                    if(f.getURI().equals(obj.getURI()))it2.remove();
                }
            }
        }        
        
    }

    private static void addFriendlyUrl(FriendlyURL url)
    {
        if(url.getURL()==null)return;
        
        {
            Object obj=urls.get(url.getURL());

            if(obj==null)
            {
                urls.put(url.getURL(), url);
            }else if(obj instanceof FriendlyURL)
            {
                ArrayList<FriendlyURL> arr=new ArrayList();
                arr.add((FriendlyURL)obj);
                if(!arr.contains(url))arr.add(url);
                urls.put(url.getURL(), arr);
            }else if(obj instanceof ArrayList)
            {
                ArrayList<FriendlyURL> arr=(ArrayList<FriendlyURL>)obj;
                if(!arr.contains(url))arr.add(url);
            }
        }
        
        if(url.isFriendlySubPaths())
        {
            Object obj=suburls.get(url.getURL());

            if(obj==null)
            {
                suburls.put(url.getURL(), url);
            }else if(obj instanceof FriendlyURL)
            {
                ArrayList<FriendlyURL> arr=new ArrayList();
                arr.add((FriendlyURL)obj);
                if(!arr.contains(url))arr.add(url);
                suburls.put(url.getURL(), arr);
            }else if(obj instanceof ArrayList)
            {
                ArrayList<FriendlyURL> arr=(ArrayList<FriendlyURL>)obj;
                if(!arr.contains(url))arr.add(url);
            }        
        }
    }

    /**
     * Refresh.
     */
    public static void refresh() 
    {
        if(urls!=null)return;
        urls = new ConcurrentHashMap(); 
        suburls = new ConcurrentHashMap(); 
        Iterator<WebSite> its=SWBContext.listWebSites();
        while (its.hasNext())
        {
            WebSite webSite = its.next();
            
            Iterator<FriendlyURL> it = ClassMgr.listFriendlyURLs(webSite);
            while (it.hasNext())
            {
                FriendlyURL url = it.next();
                addFriendlyUrl(url);
            }
        }
    }
    
    /**
     * Gets the FriendlyURL.
     *
     * @param path the url
     * @return the FriendlyURL
     */
    public static FriendlyURL getFriendlyURL(String path, String host)
    {
        //System.out.println("path:"+path+" host:"+host);
        if(urls==null)return null;
        Object obj=urls.get(path);
        if(obj==null)
        {
            if(!suburls.isEmpty())
            {
                List<String> subpaths=extractPaths(path);
                for(String subpath : subpaths)
                {
                    obj=suburls.get(subpath);
                    if(obj!=null)
                    {
                        if(obj instanceof FriendlyURL)
                        {
                            WebPage wp=((FriendlyURL)obj).getWebPage();
                            if(wp==null)
                            {
                                suburls.remove(subpath);
                                obj=null;
                            }
                        }
                        break;
                    }
                }
                if(obj==null)return null;
            }else return null;
        }else
        {
            if(obj instanceof FriendlyURL)
            {
                WebPage wp=((FriendlyURL)obj).getWebPage();
                if(wp==null)
                {
                    urls.remove(path);
                    return null;
                }
            }
        }
        
        if(obj instanceof FriendlyURL)
        {
            return (FriendlyURL)obj;
        }
        
        if(obj instanceof ArrayList)
        {
            Dns dns=Dns.getDns(host);
            FriendlyURL tmp=null;
            Iterator<FriendlyURL> it=((ArrayList)obj).iterator();
            while (it.hasNext())
            {
                FriendlyURL friendlyURL = it.next();
                //System.out.println("friendlyURL:"+friendlyURL+" page:"+friendlyURL.getWebPage()+" site:"+friendlyURL.getWebPage().isValid()+" "+friendlyURL.getWebPage().getWebSite().isValid());
                WebPage wp=friendlyURL.getWebPage();
                if(wp!=null)
                {
                    WebSite site=wp.getWebSite();

                    if((dns==null || !dns.getWebSite().equals(site)) && friendlyURL.getWebPage().isValid() && site.isValid())
                    {
                        tmp=friendlyURL;
                    }else if(dns!=null && dns.getWebSite().equals(site))
                    {
                        return friendlyURL;
                    }
                }else
                {
                    log.warn("Remove bad FrindlyURL:"+friendlyURL);
                    it.remove();
                }
            }
            return tmp;
        }
        return null;
    }
    
    
    private static List<String> extractPaths(String path)
    {
        //"/swb/meta/jei/serch/"
        List<String> ret = new ArrayList<String>();
        String tmp=path;
        int i=-1;
        while((i=tmp.lastIndexOf('/'))>-1)
        {
            tmp=tmp.substring(0,i);
            ret.add(tmp+"/");
            if(tmp.length()>0)ret.add(tmp);
        }
        return ret;
    } 
    

}
