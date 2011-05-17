package org.semanticwb.remotetriplestore;

import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.rdf.model.impl.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.remotetriplestore.protocol.Command;
import org.semanticwb.remotetriplestore.protocol.OOK;
import org.semanticwb.remotetriplestore.protocol.Response;
import org.semanticwb.remotetriplestore.protocol.SWBRTSCmd;


/**
 *
 * @author serch
 */
class SWBRTSPrefixMapping implements PrefixMapping
{
    private static Logger log = SWBUtils.getLogger(SWBRTSPrefixMapping.class);
    private SWBRTSGraph graph;
    private SWBRTSThreadPool pool;

    private Map<String,String> map=new ConcurrentHashMap<String, String>();

    public SWBRTSPrefixMapping(SWBRTSGraph graph, SWBRTSThreadPool pool)
    {
        this.graph = graph;
        this.pool = pool;
        getNsPrefixMap();
    }

    public PrefixMapping setNsPrefix(String prefix, String uri)
    {
        if(!map.containsKey(prefix) || map.get(prefix)==null || !map.get(prefix).equals(uri))
        {
            try {
                SWBRTSCmd cmd = new SWBRTSCmd();
                cmd.cmd = Command.SET_NS_PREFIX;
                cmd.paramNumber=3;
                SWBRTSUtil util =  new SWBRTSUtil(pool.getAddress(), pool.getPort());
                util.setCommand(cmd);
                String[] params = {graph.getName(), prefix, uri};
                util.setParams(params);
                Future<Response> future = pool.getPool().submit(util);
                Response resp = future.get();
                if (!(resp.data instanceof OOK))
                {
                    map.put(prefix, uri);
                }
            } catch (Exception e)
            {
                log.error(e);
            }
        }
        return this;
    }

    public PrefixMapping removeNsPrefix(String prefix)
    {
        try {
            SWBRTSCmd cmd = new SWBRTSCmd();
            cmd.cmd = Command.REMOVE_NS_PREFIX;
            cmd.paramNumber=2;
            SWBRTSUtil util =  new SWBRTSUtil(pool.getAddress(), pool.getPort());
            util.setCommand(cmd);
            String[] params = {graph.getName(), prefix};
            util.setParams(params);
            Future<Response> future = pool.getPool().submit(util);
            Response resp = future.get();
            if (!(resp.data instanceof OOK))
            {
                map.remove(prefix);
            }
        } catch (Exception e)
        {
            log.error(e);
        }
        return this;
    }

    public PrefixMapping setNsPrefixes(PrefixMapping other)
    {
        return setNsPrefixes(other.getNsPrefixMap());
    }

    public PrefixMapping setNsPrefixes(Map<String, String> map)
    {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext())
        {
            String prefix = it.next();
            setNsPrefix(prefix, map.get(prefix));
        }
        return this;
    }

    public PrefixMapping withDefaultMappings(PrefixMapping map)
    {
        for (Map.Entry<String, String> e : map.getNsPrefixMap().entrySet())
        {
            String prefix = e.getKey(), uri = e.getValue();
            if (getNsPrefixURI(prefix) == null && getNsURIPrefix(uri) == null)
            {
                setNsPrefix(prefix, uri);
            }
        }
        return this;
    }

    public String getNsPrefixURI(String prefix)
    {
        String str=map.get(prefix);
        if(str==null)
        {
            try {
                SWBRTSCmd cmd = new SWBRTSCmd();
                cmd.cmd = Command.GET_NS_PREFIX_URI;
                cmd.paramNumber=2;
                SWBRTSUtil util =  new SWBRTSUtil(pool.getAddress(), pool.getPort());
                util.setCommand(cmd);
                String[] params = {graph.getName(), prefix};
                util.setParams(params);
                Future<Response> future = pool.getPool().submit(util);
                Response resp = future.get();
                str  = (String) resp.data;
            } catch (Exception e)
            {
                log.error(e);
            }
            if(str!=null)map.put(prefix, str);
        }
        return str;
    }

    public String getNsURIPrefix(String uri)
    {
        Map.Entry<String, String> e = findMapping(uri, false);
        if (e != null)
        {
            return e.getKey();
        }
        return null;
    }

    public Map<String, String> getNsPrefixMap()
    {
        Map<String,String> mapt;
        try {
            SWBRTSCmd cmd = new SWBRTSCmd();
            cmd.cmd = Command.GET_NS_PREFIX_MAP;
            cmd.paramNumber=1;
            SWBRTSUtil util =  new SWBRTSUtil(pool.getAddress(), pool.getPort());
            util.setCommand(cmd);
            String[] params = {graph.getName()};
            util.setParams(params);
            Future<Response> future = pool.getPool().submit(util);
            Response resp = future.get();
            mapt  = (Map<String,String>) resp.data;
            this.map=mapt;
        } catch (Exception e)
        {
            log.error(e);
        }
        return map;
    }

    public String expandPrefix(String prefixed)
    {
        int colon = prefixed.indexOf(':');
        if (colon < 0)
        {
            return prefixed;
        } else
        {
            String uri = getNsPrefixURI(prefixed.substring(0, colon));
            return uri == null ? prefixed : uri + prefixed.substring(colon + 1);
        }
    }

    public String shortForm(String uri)
    {
        Map.Entry<String, String> e = findMapping(uri, true);
        return e == null ? uri : e.getKey() + ":" + uri.substring((e.getValue()).length());
    }

    public String qnameFor(String uri)
    {
        int split = Util.splitNamespace(uri);
        String ns = uri.substring(0, split), local = uri.substring(split);
        if (local.equals(""))
        {
            return null;
        }
        String prefix = getNsURIPrefix(ns);
        return prefix == null ? null : prefix + ":" + local;
    }

    public PrefixMapping lock()
    {
        //TODO
        //throw new UnsupportedOperationException("Not supported yet.");
        return this;
    }

    public boolean samePrefixMappingAs(PrefixMapping other)
    {
        return other instanceof SWBRTSPrefixMapping
                ? equals((SWBRTSPrefixMapping) other)
                : equalsByMap(other);
    }

    protected final boolean equalsByMap(PrefixMapping other)
    {
        return getNsPrefixMap().equals(other.getNsPrefixMap());
    }

    /**
    Answer a prefixToURI entry in which the value is an initial substring of <code>uri</code>.
    If <code>partial</code> is false, then the value must equal <code>uri</code>.

    Does a linear search of the entire prefixToURI, so not terribly efficient for large maps.

    @param uri the value to search for
    @param partial true if the match can be any leading substring, false for exact match
    @return some entry (k, v) such that uri starts with v [equal for partial=false]
     */
    private Map.Entry<String, String> findMapping(String uri, boolean partial)
    {
        Map<String, String> map = getNsPrefixMap();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, String> e = it.next();
            String ss = e.getValue();
            if (uri.startsWith(ss) && (partial || ss.length() == uri.length()))
            {
                return e;
            }
        }
        return null;
    }
}
