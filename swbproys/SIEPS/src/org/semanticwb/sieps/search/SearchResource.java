/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.sieps.search;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.sieps.Busqueda;
import org.semanticwb.sieps.Busquedas;
import org.semanticwb.sieps.Empresa;
import org.semanticwb.sieps.EmpresaInteres;
import org.semanticwb.sieps.Producto;

/**
 *
 * @author victor.lorenzana
 */
public class SearchResource extends GenericResource
{

    private static Logger log = SWBUtils.getLogger(SearchResource.class);

    /**
     * Variables que determinan el tipo de resultado consultado.
     */
    private static final int TIPO_EMPRESA   = 1,
                             TIPO_PRODUCTO  = 2,
                             TIPO_WEBPAGE   = 3;

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action   =   response.getAction();
        log.debug("---> processAction = " + action);
        User user       =   response.getUser();
        boolean isUser  =   (user != null && user.isSigned());
        String mensaje  =   "";
        SWBModel webSite = getResourceBase().getWebSite();
        response.setMode(SWBParamRequest.Mode_VIEW);
        
        String query    =   request.getParameter("currentQuery");
        try {
            if (isUser) {
                if ("guardaConsulta".equals(action)) {
                    log.debug("---> action query = " + query);
                    // Crea el objeto búsqueda...
                    Busqueda busqueda   =   Busqueda.ClassMgr.createBusqueda(webSite);
                    busqueda.setSeach(query);
                    // Crea el objeto búsquedas (ligado a un usuario)...
                    Busquedas busquedasUsr  =    Busquedas.ClassMgr.createBusquedas(webSite);
                    busquedasUsr.addBusqueda(busqueda);
                    busquedasUsr.setUsuario(user);
                    mensaje = "La búsqueda ha sido agregada a su carpeta";

                } else if ("guardaEmpresas".equals(action)) {
                    String[] empresas   =   request.getParameterValues("chkEmpresas");
                    
                    if (empresas != null && empresas.length > 0) {
                        for (String uriEmpresa : empresas) {
                           if (uriEmpresa != null) {
                               String uri   =   request.getParameter("uri");
                               //Recupera la empresa...
                               Empresa emp  =   Empresa.ClassMgr.createEmpresa(uri, webSite);
                               //Crea la empresa de interés..
                               EmpresaInteres empresaInteres = EmpresaInteres.ClassMgr.createEmpresaInteres(webSite);
                               //Añade empresa...
                               empresaInteres.addEmpresa(emp);
                               //Añade usuario...
                               empresaInteres.setUsuario(user);
                           }
                          mensaje = "Las empresas han sido agregadas a su carpeta";
                        }
                    }
                } else {
                    super.processAction(request, response);
                }
            } else {
                mensaje = "El usuario debe de estar firmado en el sistema";
            }
        } catch (Exception e) {
            log.error(e);
            mensaje = "Imposible agregar a carpeta por el momento";
        }
        response.setRenderParameter("act", "results");
        response.setRenderParameter("query", query);
        response.setRenderParameter("mensaje", mensaje);
        return;
    }


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {   
        String path ="/swbadmin/jsp/sieps/resultsEmpresa.jsp";
        RequestDispatcher dis =null;
        try
        {
            if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY)
            {
                path = "/swbadmin/jsp/sieps/search.jsp";

            }
            else
            {
                String act = request.getParameter("act");
                if ("detail".equals(act)) {
                    String uri = request.getParameter("uri");
                    if (uri != null && uri.length() > 0) {
                        
                        SemanticObject semanticObject   =   SemanticObject.createSemanticObject(URLDecoder.decode(uri, "UTF-8"));
                        GenericObject genericObject     =   semanticObject.createGenericInstance();
                        int tipoResultadoDetalle        =   determinaTipoResultados(semanticObject);
                        request.setAttribute("obj", genericObject);
                        path = (TIPO_EMPRESA == tipoResultadoDetalle) 
                                    ? "/swbadmin/jsp/sieps/detailEmpresa.jsp"
                                    : "/swbadmin/jsp/sieps/detailProducto.jsp";
                    }
                } else if ("results".equals(act)) {
                    String query        =   request.getParameter("query");
                    log.debug("---> query = " + query );

                    NLSearcher searcher  =   new NLSearcher("es");
                    Iterator<SemanticObject> results    =  searcher.search(query, paramRequest.getWebPage().getWebSite(), paramRequest.getUser());

                    List<SemanticObject> listSemObj     =  construyeColeccionSemObjs(results);

                    int tipoResultados   =  determinaTipoResultados(listSemObj);

                    if (TIPO_EMPRESA == tipoResultados) {
                        log.debug("---> TIPO_EMPRESA");
                        List<Empresa> listEmpresas  = contruyeColeccionEmpresas(listSemObj);
                        request.setAttribute("results", listEmpresas);
                        path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                    } else if (TIPO_PRODUCTO == tipoResultados) {
                        log.debug("---> TIPO_PRODUCTO");
                        List<Producto> listProductos  = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        path = "/swbadmin/jsp/sieps/resultsProducto.jsp";
                    }
                    else if (TIPO_WEBPAGE == tipoResultados) {
                        log.debug("---> TIPO_PRODUCTO");
                        List<Producto> listProductos  = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        path = "/swbadmin/jsp/sieps/resultsWebPage.jsp";
                    }

                } else if ("cat".equals(act)) {
                    String uri      =   request.getParameter("uri");

                    if (uri != null && uri.length() > 0) {
                        SemanticObject semanticObject   =   SemanticObject.createSemanticObject(URLDecoder.decode(uri, "UTF-8"));
                        GenericObject genericObject     =   semanticObject.createGenericInstance();
                        int tipoResultadoDetalle        =   determinaTipoResultados(semanticObject);
                        request.setAttribute("obj", genericObject);
                        path = (TIPO_EMPRESA == tipoResultadoDetalle)
                                    ? "/swbadmin/jsp/sieps/catprod.jsp"
                                    : "/swbadmin/jsp/sieps/catempresa.jsp";
                    }

                } else if ("empresassimilares".equals(act)) {
                    String uri      =   request.getParameter("uri");

                    if (uri != null && uri.length() > 0) {
                        SemanticObject semanticObject   =   SemanticObject.createSemanticObject(URLDecoder.decode(uri, "UTF-8"));
                        GenericObject genericObject     =   semanticObject.createGenericInstance();
                        int tipoResultadoDetalle        =   determinaTipoResultados(semanticObject);
                        request.setAttribute("obj", genericObject);
                        path = (TIPO_EMPRESA == tipoResultadoDetalle)
                                    ? "/swbadmin/jsp/sieps/empresassimilares.jsp"
                                    : "/swbadmin/jsp/sieps/productossimilares.jsp";
                    }

                } else {
                    path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                }
            }
            dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
            
        } catch (Exception e)
        {
            log.error(e);
            dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            try { dis.include(request, response); } catch (Exception ex) { log.error(ex); }

        }

    }
    /**
     * Obtiene una colección de instancias de tipo Empresa a partir de un conjunto de objetos semánticos
     * @param semObjects Iterador sobre una colección de objetos semánticos
     * @return Colección con la información
     */
    private List<Empresa> contruyeColeccionEmpresas(List<SemanticObject> semObjects) {
        List<Empresa> results = Collections.emptyList();
        if (!semObjects.isEmpty()) {
            results = new ArrayList<Empresa>(semObjects.size());
            for (SemanticObject so : semObjects) {
                    GenericObject  go = so.createGenericInstance();
                    if (go instanceof Empresa) {
                        results.add((Empresa)go);
                    }
            }
        }
        return results;
    }
    /**
     * Obtiene una colección de instancias de tipo Productos a partir de un conjunto de objetos semánticos
     * @param semObjects Iterador sobre una colección de objetos semánticos
     * @return Colección con la información
     */
    private List<Producto> contruyeColeccionProductos(List<SemanticObject> semObjects) {
        List<Producto> results = Collections.emptyList();
        if (!semObjects.isEmpty()) {
            results     = new ArrayList<Producto>(semObjects.size());
            for (SemanticObject so: semObjects) {
                GenericObject  go = so.createGenericInstance();
                if (go instanceof Producto) {
                    results.add((Producto)go);
                }
            }

        }
        return results;
    }
    /**
     * Determina el tipo real de los elementos que integran una colección de objetos semánticos
     * @param results Iterador sobre una colección de objetos semánticos
     * @return identificador de tipo de resultado
     */
    private int determinaTipoResultados(List<SemanticObject> results) {
        int tipoRes = -1;
        if (!results.isEmpty()) {
            SemanticObject so =  results.get(0);
            GenericObject go  =  so.createGenericInstance();
            if (go instanceof Empresa) {
               tipoRes = TIPO_EMPRESA;
            } else if (go instanceof Producto) {
               tipoRes = TIPO_PRODUCTO;
            } else if (go instanceof WebPage) {
               tipoRes = TIPO_WEBPAGE;            
            } else {
                tipoRes = -1;
            }
        }
        return tipoRes;
    }
    /**
     * Determina el tipo real de un objeto semántico
     * @param semanticObject Objeto semántico
     * @return identificador de tipo de resultado
     */
    private int determinaTipoResultados(SemanticObject semanticObject) {
        int tipoRes = -1;
        if (semanticObject != null) {
            GenericObject go  =  semanticObject.createGenericInstance();
            if (go instanceof Empresa) {
               tipoRes = TIPO_EMPRESA;
            } else if (go instanceof Producto) {
               tipoRes = TIPO_PRODUCTO;
            } else {
                tipoRes = -1;
            }
        }
        return tipoRes;
    }

    private List<SemanticObject> construyeColeccionSemObjs(Iterator<SemanticObject> results) {
        List<SemanticObject> semObjs = Collections.emptyList();
        if (results != null) {
            semObjs =  new ArrayList<SemanticObject>();
            while (results.hasNext()) {
                SemanticObject semanticObject = results.next();
                if (semObjs != null) {
                    semObjs.add(semanticObject);
                }
            }
        }
        return semObjs;
    }
    
}
