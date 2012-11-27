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
package org.semanticwb.triplestore.gemfire;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.Model;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.rdf.AbstractStore;

/**
 *
 * @author jei
 */
public class SWBTSGemFire implements AbstractStore
{
    private static Logger log=SWBUtils.getLogger(SWBTSGemFire.class);

    SWBTSGemFireModelMaker maker;
    
    private static Cache cache;
    
        public static Cache getCache()
    {
        if(cache==null)
        { 
            log.event("Initializing GemFire Connection...");
            try
            {
                CacheFactory cf=new CacheFactory().set("cache-xml-file", "xml/gemfire.xml").set("mcast-port", "0");
                if(SWBPlatform.getEnv("swb/gemfire_locators")!=null)
                {
                    cf.set("locators", SWBPlatform.getEnv("swb/gemfire_locators"));
                }
                
                if(SWBPlatform.getEnv("swb/gemfire_license-application-cache")!=null)
                {
                    cf.set("license-application-cache", SWBPlatform.getEnv("swb/gemfire_license-application-cache"));
                }
                
                if(SWBPlatform.getEnv("swb/gemfire_license-data-management")!=null)
                {
                    cf.set("license-data-management", SWBPlatform.getEnv("swb/gemfire_license-data-management"));
                }
                
                cache = cf.create();
            }catch(Exception e)
            {
                log.error(e);
            }        
        }
        return cache;
    }
    
    @Override
    public void init()
    {
        log.event("SWBTSGemFire Initializing...");
        maker=new SWBTSGemFireModelMaker();
    }

    @Override
    public void removeModel(String name)
    {
        maker.removeModel(name);
    }

    @Override
    public Model loadModel(String name)
    {
        return maker.createModel(name);
    }

    @Override
    public Iterator<String> listModelNames()
    {
        return maker.listModelNames();
    }
    
    @Override
    public Model getModel(String name) 
    {
        return maker.getModel(name);
    }    

    @Override
    public void close()
    {
        if(cache!=null)
        {
            cache.close();
            cache=null;
        }
    }

    @Override
    public Dataset getDataset()
    {
        return null;
    }

    public SWBTSGemFireModelMaker getMaker()
    {
        return maker;
    }
}
