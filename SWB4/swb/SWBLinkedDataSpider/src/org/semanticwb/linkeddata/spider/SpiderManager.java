/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.linkeddata.spider;

import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author victor.lorenzana
 */
public class SpiderManager
{

    public static final Predicates predicates = new Predicates();
    private static SpiderDomainManager domainManager = new SpiderDomainManager();
    private static final Set<SpiderEventListener> listeners = Collections.synchronizedSet(new HashSet<SpiderEventListener>());
    public static final Set<URL> visited = Collections.synchronizedSet(new HashSet<URL>());

    public static void createSpider(URL url)
    {
        createSpider(url, null);
    }

    public static void createSpider(URL url, Spider source)
    {
        if (!SpiderManager.visited.contains(url))
        {
            SpiderDomain domain = new SpiderDomain(url);
            if (domainManager.containsKey(url))
            {
                domain = domainManager.get(url);
            }
            else
            {
                domainManager.put(url, domain);
            }

            Spider spider = new Spider(url, domain);
            domain.addSpider(spider);

        }
    }

    public synchronized static Set<SpiderEventListener> getListeners()
    {
        Set<SpiderEventListener> _listeners = new HashSet<SpiderEventListener>();
        _listeners.addAll(listeners);
        return _listeners;
    }

    public static SpiderSync createSpiderPred(URL url)
    {
        SpiderDomain domain = new SpiderDomain(url);
        if (domainManager.containsKey(url))
        {
            domain = domainManager.get(url);
        }
        else
        {
            domain = domainManager.put(url, domain);
        }

        SpiderSync spider = new SpiderSync(url, domain);
        domain.addSpider(spider);
        return spider;

    }

    public static void addSpiderEventListener(SpiderEventListener listener)
    {
        listeners.add(listener);
    }

    public static synchronized void onPred(URI pred, Spider spider)
    {
        // carga las propiedades de un predicado
//        try
//        {
//            SpiderSync _spider = new SpiderSync(pred.toURL(), spider.getDomain());
//            _spider.setFriend(spider);
//            _spider.run();
//            spider.fireVisit(pred);
//        }
//        catch (Exception e)
//        {
//            spider.fireError(e);
//        }
        loadPredicates(pred);
        

    }
    public static void loadPredicates(URI pred)
    {
        try
        {
            SpiderSync _spider = new SpiderSync(pred.toURL(),null);
            _spider.run();
            
        }
        catch (Exception e)
        {
            
        }
    }
    public static void addPredicate(TripleElement element)
    {
        predicates.add(element);
    }
}
