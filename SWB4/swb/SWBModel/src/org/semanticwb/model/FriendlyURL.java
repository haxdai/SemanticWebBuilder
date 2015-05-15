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
import org.semanticwb.SWBPlatform;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticTSObserver;


public class FriendlyURL extends org.semanticwb.model.base.FriendlyURLBase 
{
    
    static class ConcurrentHashMapFriendlyURL extends ConcurrentHashMap<String, Object>
    {

        public static List<String> extractPaths(String path)
        {

            List<String> extractPaths = new ArrayList<String>();
            if (path == null || path.isEmpty())
            {
                return extractPaths;
            }
            if(path.equals("/"))
            {
                extractPaths.add(path);
                return extractPaths;
            }
            if(path.endsWith("/"))
            {
                path=path.substring(0,path.length()-1);
            }
            String[] values = path.split("/");

            List<String> paths = new ArrayList<String>();
            List<String> temp = Arrays.asList(values);
            paths.addAll(temp);
            //paths.remove(paths.size()-1);
            while (!paths.isEmpty())
            {
                StringBuilder newPath = new StringBuilder();
                for (String value : paths)
                {
                    if (!value.isEmpty())
                    {
                        newPath.append("/");
                        newPath.append(value);
                    }

                }
                if(!newPath.toString().isEmpty())
                {
                    extractPaths.add(newPath.toString());
                }
                paths.remove(paths.size()-1);
            }
            extractPaths.add("/");
            return extractPaths;

        }
        @Override
        public Object get(Object key)
        {
            Object ret=super.get(key);
            if(ret!=null)
            {
                return ret;
            }       
            if(key instanceof String)
            {
                String pathKey=(String)key;
                if(pathKey.endsWith("/"))
                {
                    pathKey=pathKey.substring(0,pathKey.length()-1);
                }
                List<String> subpaths=extractPaths(pathKey);
                for(String subpath : subpaths)
                {
                    ret=super.get(subpath);
                    if(ret!=null)
                    {
                        if(ret instanceof FriendlyURL)
                        {
                            FriendlyURL friendlyURL=(FriendlyURL)ret;
                            if(!friendlyURL.isFriendlySubPaths())
                            {
                                return null;
                            }
                            else
                            {
                                return ret;
                            }
                        }
                        else
                        {
                            return ret;
                        }
                    }
                }
                /*for(Object obj : this.values())
                {          
                    if(obj instanceof FriendlyURL)
                    {
                        FriendlyURL friendlyURL=(FriendlyURL)obj;                
                        if(friendlyURL.isFriendlySubPaths())
                        {
                            if(pathKey.startsWith(friendlyURL.getURL()))
                            {
                                return obj;
                            }
                        }
                    }
                    else if(obj instanceof ArrayList)
                    {
                        ArrayList list=(ArrayList)obj;
                        for(Object arrObj : list)
                        {
                            if(arrObj instanceof FriendlyURL)
                            {
                                FriendlyURL friendlyURL=(FriendlyURL)arrObj;  
                                if(friendlyURL.isFriendlySubPaths())
                                {
                                    if(pathKey.startsWith(friendlyURL.getURL()))
                                    {
                                        return list;
                                    }
                                }
                            }
                        }
                    }

                }*/
            }
            return super.get(key);
            
        }

        

        /*@Override
        public Object get(Object key)
        {
            Object ret=super.get(key);
            if(ret!=null)
            {
                return ret;
            }            
            if(key instanceof String)
            {
                String pathKey=(String)key;
                for(Object obj : this.values())
                {
                    if(obj instanceof FriendlyURL)
                    {
                        FriendlyURL friendlyURL=(FriendlyURL)obj;
                        if(friendlyURL.isFriendlySubPaths())
                        {
                            if(pathKey.startsWith(friendlyURL.getURL()))
                            {
                                return friendlyURL;
                            }
                        }
                    }
                }
                return super.get(key);
            }
            else
            {
                return super.get(key);
            }
        }*/
        
    }    
    
    /** The names. */
    private static ConcurrentHashMapFriendlyURL urls = null;

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
                        if(action.equals(SemanticObject.ACT_REMOVE))
                        {
                            //System.out.println("remove friendly...");
                            removeObject(obj);
                        }else
                        {
                            //System.out.println("add friendly...");
                            addFriendlyUrl((FriendlyURL)obj.createGenericInstance());                    
                        }
                    }
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
                    if(f.getURI().equals(obj.getURI()))it.remove();
                }
            }
        }
    }

    private static void addFriendlyUrl(FriendlyURL url)
    {
        if(url.getURL()==null)return;
        Object obj=urls.get(url.getURL());

        if(obj==null)
        {
            urls.put(url.getURL(), url);
        }else if(obj instanceof FriendlyURL)
        {
            ArrayList<FriendlyURL> arr=new ArrayList();
            arr.add((FriendlyURL)obj);
            arr.add(url);
            urls.put(url.getURL(), arr);
        }else if(obj instanceof ArrayList)
        {
            ArrayList<FriendlyURL> arr=(ArrayList<FriendlyURL>)obj;
            arr.add(url);
        }
    }

    /**
     * Refresh.
     */
    public static void refresh() 
    {
        if(urls!=null)return;
        urls = new ConcurrentHashMapFriendlyURL(); 
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
        if(obj==null)return null;
        if(obj instanceof FriendlyURL)return (FriendlyURL)obj;
        if(obj instanceof ArrayList)
        {
            Dns dns=Dns.getDns(host);
            FriendlyURL tmp=null;
            Iterator<FriendlyURL> it=((ArrayList)obj).iterator();
            while (it.hasNext())
            {
                FriendlyURL friendlyURL = it.next();
                //System.out.println("friendlyURL:"+friendlyURL+" page:"+friendlyURL.getWebPage()+" site:"+friendlyURL.getWebPage().isValid()+" "+friendlyURL.getWebPage().getWebSite().isValid());
                WebSite site=friendlyURL.getWebPage().getWebSite();
                
                if((dns==null || !dns.getWebSite().equals(site)) && friendlyURL.getWebPage().isValid() && site.isValid())
                {
                    tmp=friendlyURL;
                }else if(dns!=null && dns.getWebSite().equals(site))
                {
                    return friendlyURL;
                }
            }
            return tmp;
        }
        return null;
    }

}
