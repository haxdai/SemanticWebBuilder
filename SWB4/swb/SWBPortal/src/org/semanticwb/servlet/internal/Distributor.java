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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.servlet.internal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.Template;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.SWBActionResponseImp;
import org.semanticwb.portal.api.SWBParamRequestImp;
import org.semanticwb.portal.api.SWBResourceModes;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.servlet.SWBHttpServletResponseWrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Distributor.
 * 
 * @author Jei
 */
public class Distributor implements InternalServlet
{
    
    /** The log. */
    static Logger log=SWBUtils.getLogger(Distributor.class);
    
    /** The name. */
    String name = "swb";
    
    /** The agzip. */
    boolean agzip = true;
    
    /** The admin. */
    boolean admin = true;
    
    /** The secure. */
    boolean secure = false;
    
    /** The adm map. */
    String admMap=null;
    
    /* (non-Javadoc)
     * @see org.semanticwb.servlet.internal.InternalServlet#init(javax.servlet.ServletContext)
     */
    public void init(ServletContext scontext) 
    {
        log.event("Initializing InternalServlet Distributor...");
        name = SWBPlatform.getEnv("swb/distributor","swb");
        agzip = SWBPlatform.getEnv("swb/responseGZIPEncoding", "true").equalsIgnoreCase("true");
        admin = SWBPlatform.getEnv("swb/administration", "true").equalsIgnoreCase("true");
        secure = SWBPlatform.getEnv("swb/secureAdmin", "false").equalsIgnoreCase("true");
        admMap=SWBContext.WEBSITE_ADMIN;
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.servlet.internal.InternalServlet#doProcess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.servlet.internal.DistributorParams)
     */
    public void doProcess(HttpServletRequest request, HttpServletResponse response, DistributorParams dparams)throws IOException 
    {
        long time=System.currentTimeMillis();
        if(_doProcess(request, response, dparams))
        {
            SWBPortal.getMonitor().addinstanceHit(System.currentTimeMillis()-time);
        }
    }    
    
    /**
     * _do process.
     * 
     * @param request the request
     * @param response the response
     * @param dparams the dparams
     * @return true, if successful
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public boolean _doProcess(HttpServletRequest request, HttpServletResponse response, DistributorParams dparams)throws IOException 
    {
        long tini=System.currentTimeMillis();
        boolean ret=true;
        log.debug("Distributor->doProcess()");
        
        try
        {
            User user = dparams.getUser();
            ArrayList uri = dparams.getResourcesURI();
            WebPage webpage = dparams.getWebPage();
            WebPage vwebpage = dparams.getVirtWebPage();
            int ipfilter = dparams.getFiltered();
            boolean onlyContent = dparams.isOnlyContent();

            {
                log.trace("*********distributor**************");
                log.trace("email:" + user.getEmail());
                log.trace("session:" + request.getSession().getId());
                //out.println("isRegistered:" + user.isRegistered());
                //out.println("isloged:" + user.isLoged());
                log.trace("uri:" + request.getRequestURI());
                log.trace("servlet:" + request.getServletPath());
                log.trace("webpage:" + webpage);
                log.trace("virtWebpage:" + vwebpage);
                log.trace("ipfilter:" + ipfilter);
                log.trace("isSecure:" + request.isSecure());
                log.trace("onlyContent:" + onlyContent);
                log.trace("*****************************");
            }

            if (secure && webpage!=null && webpage.getWebSiteId().equals(admMap))
            {
                if (!request.isSecure()) 
                {
                    log.debug("Distributor: SendError 404");
                    response.sendError(404, "Not https protocol...");
                    return false;
                }
            }       

            if (ipfilter > 0)  //1:no access: 2:only access
            {
                log.debug("Distributor: SendError 404");
                response.sendError(404, "No tiene permiso para accesar a la pagina " + request.getRequestURI() + ", (IP Filter)... ");
                return false;
            }        
        
//            //TODO:cambiar por opcion en el topico needVirtualTopic            
//            if (webpage != null && webpage.getWebSite() == admMap && vwebpage == null) {
//                if (inti_StatusTopic == webpage || webpage.isChildof(sys_Topics) || webpage.isChildof(sys_Contents) || webpage.isChildof(info_Topic))
//                {
//                    log.debug("Distributor: SendError 404");
//                    response.sendError(404, "No tiene permiso para accesar a la pagina " + request.getRequestURI());
//                    return false;
//                }
//            }

            if (webpage == null || (!admin && webpage.getWebSite().equals(admMap))) 
            {
                response.sendError(404, "La pagina " + request.getRequestURI() + " no existe... ");
                log.debug("Distributor: SendError 404");
                return false;
            } else if (!webpage.getWebSite().isActive() || webpage.getWebSite().isDeleted() || !webpage.isValid())
            {
                response.sendError(404, "La pagina " + request.getRequestURI() + " no esta disponible por el momento... ");
                log.debug("Distributor: SendError 404");
                return false;
            }

            log.debug("User:"+user+" webpage:"+webpage);
            if (!user.haveAccess(webpage)) 
            {
                log.debug("Distributor->Don't access");
                //TODO:validar acciones
//                Iterator it = webpage.getConfigData(TopicMap.CNF_WBSecAction);
//                if (it.hasNext()) {
//                    //System.out.println("hasData");
//                    String data = (String) it.next();
//                    log.debug("Distributor->data:" + data);
//                    if (data.startsWith("SR:")) {
//                        response.sendRedirect(data.substring(3));
//                    } else if (data.startsWith("SE:")) {
//                        int err = Integer.parseInt(data.substring(3));
//                        if (err == 403)
//                            sendError403(request, response);
//                        else
//                            response.sendError(err);
//                    }
//                } else {
                    log.debug("Distributor->send403");
                    sendError403(request, response);
//                }

                return false;
            }

            String content = null;
            String resContentType = null;

            if (dparams.getAccType() == DistributorParams.ACC_TYPE_RENDER) // es un recurso
            {
                try {
                    String rid = dparams.getAccResourceID();
                    //System.out.println("rid:"+rid);
                    HashMap resp = dparams.getResourceURI(rid);
                    int mto = SWBUtils.TEXT.getInt((String)resp.get(DistributorParams.URLP_METHOD), SWBResourceModes.Call_CONTENT);
                    String mdo = (String) resp.get(DistributorParams.URLP_MODE);
                    String wst = (String) resp.get(DistributorParams.URLP_WINSTATE);
                    String act = (String) resp.get(DistributorParams.URLP_ACTION);
                    String idtm = dparams.getAccResourceTMID();
                    String extParams=dparams.getNotAccResourceURI(rid);

                    SWBResource base = SWBPortal.getResourceMgr().getResource(idtm, rid);
                    if (!webpage.getWebSite().equals(SWBContext.getAdminWebSite()))
                    {
                        if(base == null)
                        {
                            response.sendError(404, "No tiene permiso para accesar a la pagina " + request.getRequestURI() + ", (Control de IPs)... ");
                            log.debug("Distributor: SendError 404");
                            return false;
                        }else if(!user.haveAccess(base.getResourceBase()))
                        {
                            if(request.getMethod().equalsIgnoreCase("POST"))
                            {
                                response.sendRedirect(webpage.getUrl());
                                log.debug("Distributor: Resource "+base.getResourceBase().getId()+" restricted, send redirect to webpage:"+webpage.getUrl());
                            }else
                            {
                                response.sendError(403, "No tiene permiso para accesar a la pagina " + request.getRequestURI() + ", (Control de IPs)... ");
                                log.debug("Distributor: SendError 403");
                            }
                            return false;
                        }
                    }                    

                    if (mto == SWBResourceModes.Call_DIRECT) //call direct
                    {
                        //TODO:Falta envio de log de accesos
                        SWBResource currResource = SWBPortal.getResourceMgr().getResource(idtm, rid);
                        //SWBResponse resp=new SWBResponse(response);
                        SWBParamRequestImp resParams = new SWBParamRequestImp(request, currResource.getResourceBase(), webpage, user);
                        //resParams.setArguments(args);
                        resParams.setExtURIParams(extParams);
                        if (act != null) resParams.setAction(act);
                        resParams.setCallMethod(mto);
                        if (mdo != null) resParams.setMode(mdo);
                        if (wst != null) resParams.setWindowState(wst);
                        if (vwebpage != null) {
                            resParams.setVirtualTopic(vwebpage);
                        }
                        resParams.setOnlyContent(onlyContent);
                        SWBPortal.getResourceMgr().getResourceTraceMgr().renderTraced(currResource, request, response, resParams);
                        return true;
                    } else if (SWBResourceModes.WinState_MAXIMIZED.equals(wst)) //WinState_MAXIMIZED
                    {
                        SWBHttpServletResponseWrapper res = new SWBHttpServletResponseWrapper(response);
                        SWBResource currResource = SWBPortal.getResourceMgr().getResource(idtm, rid);
                        //SWBResponse resp=new SWBResponse(response);
                        SWBParamRequestImp resParams = new SWBParamRequestImp(request, currResource.getResourceBase(), webpage, user);
                        //resParams.setArguments(args);
                        resParams.setExtURIParams(extParams);
                        if (act != null) resParams.setAction(act);
                        resParams.setCallMethod(mto);
                        if (mdo != null) resParams.setMode(mdo);
                        if (wst != null) resParams.setWindowState(wst);
                        if (vwebpage != null) {
                            resParams.setVirtualTopic(vwebpage);
                        }
                        resParams.setOnlyContent(onlyContent);
                        SWBPortal.getResourceMgr().getResourceTraceMgr().renderTraced(currResource, request, res, resParams);
                        content = res.toString();
                        resContentType=res.getContentType();
                        if(res.isSendRedirect())
                        {
                            return false;
                        }
                    }
                } catch (Throwable e) 
                {
                    log.error(e);
                    log.debug("Distributor: SendError 500");
                    response.sendError(500, "Error to process request:" + request.getRequestURI());
                    return false;
                }
            } else if (dparams.getAccType() == DistributorParams.ACC_TYPE_ACTION) // process action
            {
                try {
                    String rid = dparams.getAccResourceID();
                    String idtm = dparams.getAccResourceTMID();
                    HashMap resp = dparams.getResourceURI(rid);
                    int mto = SWBUtils.TEXT.getInt((String) resp.get(DistributorParams.URLP_METHOD), SWBResourceModes.Call_CONTENT);
                    String mdo = (String) resp.get(DistributorParams.URLP_MODE);
                    String wst = (String) resp.get(DistributorParams.URLP_WINSTATE);
                    String act = (String) resp.get(DistributorParams.URLP_ACTION);
                    String extParams=dparams.getNotAccResourceURI(rid);

                    SWBResource currResource = SWBPortal.getResourceMgr().getResource(idtm, rid);
                    if(currResource==null)
                    {
                        log.warn("Error al procesar el URL:"+request.getRequestURL());
                        response.sendError(404, "No se encontro:" + request.getRequestURI() + "<br/>");
                        return false;
                    }
                    SWBActionResponseImp resParams = new SWBActionResponseImp(response);
                    if (act != null) resParams.setAction(act);
                    resParams.setExtURIParams(extParams);
                    resParams.setCallMethod(mto);
                    if (mdo != null) resParams.setMode(mdo);
                    if (wst != null) resParams.setWindowState(wst);
                    resParams.setResourceBase(currResource.getResourceBase());
                    resParams.setTopic(webpage);
                    if (vwebpage != null) {
                        resParams.setVirtualTopic(vwebpage);
                    }
                    resParams.setOnlyContent(onlyContent);
                    resParams.setUser(user);
                    //resParams.setUserLevel();
                    log.debug("Invoke ProcessAcion");
                    currResource.processAction(request, resParams);
                    log.debug("SendRedirect:"+resParams.toString());
                    response.sendRedirect(resParams.toString());
                    log.debug("Exit Distributor");
                    return true;
                } catch (Throwable e) {
                    log.error(e);
                    log.debug("Distributor: SendError 500");
                    response.sendError(500, "No es posible procesar el requerimiento:" + request.getRequestURI() + "<br/>" + e);
                    return false;
                }
            }

            try//Traer template y comprimir salida..
            {
                TemplateImp currTemplate = (TemplateImp)SWBPortal.getTemplateMgr().getTemplate(user, webpage);
                //Trae plantilla por defecto
                if(currTemplate==null)
                {
                    Template aux=webpage.getWebSite().getDefaultTemplate();
                    if(aux!=null)
                    {
                        currTemplate=(TemplateImp)SWBPortal.getTemplateMgr().getTemplateImp(aux);
                    }

                }
                if(currTemplate==null)
                {
                    log.warn("No se encontro template para la seccion:" + webpage.getId());
                    response.sendError(500, "La pagina " + request.getRequestURI() + " no esta disponible por el momento, no se encontro plantilla...");
                    log.debug("Distributor: SendError 500");
                    return false;
                }

                boolean gzip = false;
                if (agzip) {
                    if (request.getHeader("Via") != null 
                            || request.getHeader("X-Forwarded-For") != null
                            //|| request.getHeader("Cache-Control") != null
                        )
                    {
                        //using proxy -> no zip
                    } else {
                        String accept = request.getHeader("Accept-Encoding");
                        if (accept != null && accept.toLowerCase().indexOf("gzip") != -1) {
                            gzip = true;
                        }
                    }
                }

                SWBHttpServletResponseWrapper res = new SWBHttpServletResponseWrapper(response);
                try {
                    //System.out.println("DistributorImp->onlyContent:"+onlyContent);
                    PrintWriter out=res.getWriter();
                    //out.println("\n<!--Time: " + (System.currentTimeMillis() - tini) + "ms - " + webpage + "--> ");  //TODO encontrar una forma de configurar esto...
                    //out.println("Muestra Plantilla:"+currTemplate);
                    if (ipfilter == -1) {
                        if (onlyContent) {
                            currTemplate.buildContents(request, res, out, dparams, true, content);
                        } else {
                            currTemplate.build(request, res, out, user, webpage, true, content, dparams);
                        }
                    } else {
                        if (onlyContent) {
                            currTemplate.buildContents(request, res, out, dparams, false, content);
                        } else {
                            currTemplate.build(request, res, out, user, webpage, false, content, dparams);
                        }
                    }
                } catch (Exception e) {
                    log.error("Error al procesar template para la seccion:" + webpage.getId(),e);
                    response.sendError(500, "La pagina " + request.getRequestURI() + " no esta disponible por el momento... ");
                    //if(gzip)garr.close();
                    return false;
                }
                
                if(res.isSendRedirect())
                {
                    return false;
                }

                if(resContentType!=null)resContentType=res.getContentType();
                String tplContentType=currTemplate.getContentType();
                //System.out.println("resContentType: "+resContentType+" tplContentType"+tplContentType);
                String contentType="text/html; charset=ISO-8859-1";
                if(tplContentType!=null)
                {
                    contentType=tplContentType;
                }
                else if(resContentType!=null)
                {
                    contentType=resContentType;
                }
                response.setContentType(contentType);
                log.debug("dist: contentType:"+contentType);

                java.util.zip.GZIPOutputStream garr = null;
                PrintWriter out = null;
                
                if (gzip) {
                    response.setHeader("Content-Encoding", "gzip");
                    garr = new java.util.zip.GZIPOutputStream(response.getOutputStream());
                    out = new PrintWriter(garr, true);
                } else {
                    out = response.getWriter();
                }                
                //System.out.println("gzip:"+gzip);

                String rescharset=SWBUtils.TEXT.getHomCharSet(response.getCharacterEncoding());
                String defcharset=SWBUtils.TEXT.getHomCharSet(SWBUtils.TEXT.getDafaultEncoding());
                log.debug("rescharset:"+rescharset+" default:"+defcharset);
                String resp=res.toString();
                //System.out.println("resp:"+resp);
                if(rescharset.equals(defcharset))
                {
                    out.print(resp);
                }else
                {
                    out.print(SWBUtils.TEXT.encode(resp, rescharset));
                }
                long tfin = System.currentTimeMillis() - tini;
                out.println("\n<!--Time: " + tfin + "ms - SemanticWebBuilder: " + webpage + "--> ");  //TODO: encontrar una forma de configurar esto...

                //if (gzip)
                {
                    //garr.close();
                    out.close();
                }
            } catch (Exception e) {
                log.error("Get template and compress output...",e);
                return false;
            }
        } catch (Throwable e) 
        {
            log.error(e);
            return false;
        }
        return ret;
    }
    
    /**
     * Send error403.
     * 
     * @param request the request
     * @param response the response
     */
    private void sendError403(HttpServletRequest request, HttpServletResponse response) 
    {
        try
        {
            response.sendError(403, "No tiene permiso para accesar a la pagina " + request.getRequestURI()+"... ");
        }catch(IOException e)
        {
            log.error(e);
        }
    }
 



}
