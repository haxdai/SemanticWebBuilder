/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.linkeddata.spider;

import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author victor.lorenzana
 */
public class SpiderDomain
{

    public final ConcurrentLinkedQueue<Spider> spiders = new ConcurrentLinkedQueue<Spider>();
    public final HashSet<Spider> totalSpiders = new HashSet<Spider>();
    public final Set<Spider> spidersRunning = Collections.synchronizedSet(new HashSet<Spider>());
    private final Timer timer = new Timer("Spiders");
    private String host;
    private static Logger log = SWBUtils.getLogger(SpiderDomain.class);
    private int max;

    public SpiderDomain(URL url)
    {
        this.max = 30;
        this.host = url.getHost();
        Monitor monitor = new Monitor(this, max);
        timer.schedule(monitor, 1000 * 30, 1000 * 30);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof SpiderDomain)
        {
            SpiderDomain domain = (SpiderDomain) obj;
            return domain.host.equals(host);
        }
        else
        {
            return false;
        }

    }

    @Override
    public int hashCode()
    {
        return host.hashCode();
    }

    @Override
    public String toString()
    {
        return host;
    }

    public void fireError(final Throwable e, final URL url)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        listener.onError(url, e);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);

                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }
    }

    public void fireEventnewTriple(final URI suj, final URI pred, final URI obj, final Spider spider, final String lang)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        //listener.onTriple(suj, pred, obj,spider);
                        listener.onTriple(suj, pred, obj, spider, lang);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }
    }

    public boolean fireVisit(final URI suj)
    {
        boolean fireVisit=true;
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            if(listener.onNewSubject(suj)==false)
            {
                fireVisit=false;
            }
        }
        return fireVisit;
    }

    public void onNewSubject(final URI suj)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        listener.onNewSubject(suj);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);

                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }
    }

    public void fireOnEnd(final URL url)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        listener.onEnd(url);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);

                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }

    }

    public void fireOnStart(final URL url)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        listener.onStart(url);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }
    }

    public void fireEventnewTriple(final URI suj, final URI pred, final String obj, final Spider spider, final String lang)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        //listener.onTriple(suj, pred, obj,spider);
                        listener.onTriple(suj, pred, obj, spider, lang);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }
    }

    public void fireEventNtFormat(final String row, final Spider spider, final URL url)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        //listener.onTriple(suj, pred, obj,spider);
                        listener.onNTFormat(row);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();

        }
    }

    public void fireError(final int code, final URL url)
    {
        for (final SpiderEventListener listener : SpiderManager.getListeners())
        {
            Runnable r = new Runnable()
            {

                public void run()
                {
                    try
                    {
                        listener.onError(url, code);
                    }
                    catch (Exception e)
                    {
                        log.debug(e);
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

    public void addSpider(Spider spider)
    {
        if (!totalSpiders.contains(spider))
        {
            totalSpiders.add(spider);
            spiders.add(spider);
            synchronized (spidersRunning)
            {
                if (spidersRunning.size() < max)
                {
                    Thread t = new Thread(spider);
                    t.start();
                    spidersRunning.add(spider);
                }

            }
        }
    }

    public void onDone(Spider spider)
    {
        synchronized (spidersRunning)
        {
            spidersRunning.remove(spider);
            int dif = max - spidersRunning.size();
            for (int i = 0; i < dif; i++)
            {
                Spider spiderToStart = spiders.poll();
                if (spiderToStart != null)
                {
                    Thread t = new Thread(spiderToStart);
                    t.start();
                    spidersRunning.add(spiderToStart);
                }
            }

        }
    }
}
