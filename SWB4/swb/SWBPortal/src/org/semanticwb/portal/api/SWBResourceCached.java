/**  
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
**/ 
 

/*
 * WBResourceCached.java
 *
 * Created on 5 de noviembre de 2002, 17:01
 */

package org.semanticwb.portal.api;

import javax.servlet.http.*;
import java.io.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.servlet.SWBHttpServletResponseWrapper;


/**
 * Objeto: Se encarga de cachar el resultado de la consulta de un recurso.
 *
 * Object: Its in charge of catch the result of a resource query.
 *
 * @author Javier Solis Gonzalez
 */
public class SWBResourceCached implements SWBResource, SWBResourceWindow
{
    private static Logger log = SWBUtils.getLogger(SWBResourceCached.class);
    
    SWBResource resource;
    String cache = null;
    int cachetime = 0;
    long lasttime = 0;
    
    SWBResourceCachedMgr cacheMgr;

    /** Creates a new instance of WBResourceCached
     * @param resource  */
    public SWBResourceCached(SWBResource resource)
    {
        this.resource = resource;
        try
        {
            cachetime = resource.getResourceBase().getResourceType().getResourceCache() * 1000;
        } catch (Exception e)
        {
            log.error(e);
        }
        cacheMgr=SWBPortal.getResourceMgr().getResourceCacheMgr();
    }

    /**
     *
     * @throws SWBResourceException
     */    
    public void init() throws SWBResourceException
    {
        resource.init();
    }
    
    /** regresa la informacion de base de datos del recurso
     * @return  */
    public Resource getResourceBase()
    {
        return resource.getResourceBase();
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws AFException
     * @throws IOException
     */    
    public void processAction(HttpServletRequest request, SWBActionResponse response)
        throws SWBResourceException, java.io.IOException
    {
        resource.processAction(request, response);
    }
    
    /**
     *
     * @param request
     * @param response
     * @param resReq
     * @throws AFException
     * @throws IOException
     */    
    public void render(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest)
        throws SWBResourceException, java.io.IOException
    {
        if(paramsRequest.getMode().equals(paramsRequest.Mode_VIEW))
        {        
            String ret = null;
            if (cachetime == 0)
            {
                resource.render(request, response, paramsRequest);
            } else
            {
                cacheMgr.incCacheHits();
                //if (request.getParameterNames().hasMoreElements())
                //{
                //    resource.render(request, response, resReq);
                //} else
                {
                    if (cache == null || (System.currentTimeMillis() - lasttime > cachetime))
                    {
                        synchronized(this)
                        {
                            if (cache == null || (System.currentTimeMillis() - lasttime > cachetime))
                            {
                                cacheMgr.incCacheLoadHits();
                                lasttime = System.currentTimeMillis();
                                SWBHttpServletResponseWrapper res=new SWBHttpServletResponseWrapper(response);
                                resource.render(request, res, paramsRequest);
                                cache = res.toString();
                            }
                        }
                    }
                    ret = cache;
                    //if (ret == null || ret.length() == 0 || ret.endsWith("<nocache/>")) cache = null;
                    if (ret == null || ret.length() == 0) cache = null;
                    response.getWriter().print(ret);
                }
            }
            /*
            if (ret == null || ret.length() == 0)
            {
                ret = "Temporalmente fuera de servicio..";
            }
             */
            //System.out.println("resource:"+getResourceBase().getId()+" cached");
        }else
        {
            resource.render(request, response, paramsRequest);            
        }
    }
    
    
    /** asigna la informacion de base de datos al recurso
     * @param base  */
    public void setResourceBase(Resource base) throws SWBResourceException
    {
        resource.setResourceBase(base);
        cache = null;
    }

    /** Metodo que es llamado al momento de instalar el recurso en webbuilder
     * @param recobj informaci�n de base de datos de la definici�n del Recurso
     */
    public void install(ResourceType recobj) throws SWBResourceException
    {
        resource.install(recobj);
    }

    /** Metodo que es llamado al momento de desinstalar el recurso en webbuilder
     * @param recobj informaci�n de base de datos de la definici�n del Recurso
     */
    public void uninstall(ResourceType recobj) throws SWBResourceException
    {
        resource.uninstall(recobj);
    }
    
    public void destroy()
    {
        resource.destroy();
    }

    public String[] getModes(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, java.io.IOException
    {
        if(resource instanceof SWBResourceWindow)
        {
            return ((SWBResourceWindow)resource).getModes(request, paramRequest);
        }
        return new String[]{paramRequest.Mode_VIEW};
    }
    
    public String getTitle(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, java.io.IOException
    {
        if(resource instanceof SWBResourceWindow)
        {
            return ((SWBResourceWindow)resource).getTitle(request, paramRequest);
        }        
        return paramRequest.getWindowTitle();
    }
    
    public String[] getWindowStates(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, java.io.IOException
    {
        if(resource instanceof SWBResourceWindow)
        {
            return ((SWBResourceWindow)resource).getWindowStates(request, paramRequest);
        }     
        return new String[]{paramRequest.WinState_MINIMIZED, paramRequest.WinState_NORMAL, paramRequest.WinState_MAXIMIZED};
    }
    
    public boolean windowSupport(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, java.io.IOException
    {
        if(resource instanceof SWBResourceWindow)
        {
            return ((SWBResourceWindow)resource).windowSupport(request, paramRequest);
        }          
        return false;
    }
    
}
