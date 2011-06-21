package org.semanticwb.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;


public class FriendlyURL extends org.semanticwb.model.base.FriendlyURLBase 
{
    /** The names. */
    private static ConcurrentHashMap<String, Object> urls = null;

    public FriendlyURL(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }


    static
    {
        swb_friendlyURL.registerObserver(new SemanticObserver()
        {
            public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                removeObject(obj);
                addFriendlyUrl((FriendlyURL)obj.createGenericInstance());
            }
        });

        swb_FriendlyURL.registerObserver(new SemanticObserver()
        {
            public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                if(action.equals(SemanticObject.ACT_REMOVE))
                {
                    removeObject(obj);
                }
            }
        });
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
        urls = new ConcurrentHashMap();
        Iterator<FriendlyURL> it = ClassMgr.listFriendlyURLs();

        while (it.hasNext())
        {
            FriendlyURL url = it.next();
            addFriendlyUrl(url);
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
        if(urls==null)return null;
        Object obj=urls.get(path);
        if(obj==null)return null;
        if(obj instanceof FriendlyURL)return (FriendlyURL)obj;
        if(obj instanceof ArrayList)
        {
            Iterator<FriendlyURL> it=((ArrayList)obj).iterator();
            while (it.hasNext())
            {
                FriendlyURL friendlyURL = it.next();
                WebSite site=friendlyURL.getWebPage().getWebSite();
                Iterator<Dns> it2=site.listDnses();
                while (it2.hasNext())
                {
                    Dns dns = it2.next();
                    if(dns.getDns().equals(host))
                    {
                        return friendlyURL;
                    }
                }
            }
        }
        return null;
    }

}
