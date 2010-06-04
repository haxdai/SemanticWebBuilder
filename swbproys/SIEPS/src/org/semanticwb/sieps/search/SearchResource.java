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
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.scian.Clase;
import org.semanticwb.sieps.Empresa;
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
                             TIPO_PRODUCTO  = 2;

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
                    log.info("---> query = " + query );

                    NLSearcher searcher  =   new NLSearcher("es");
                    Iterator<SemanticObject> results = searcher.search(query, paramRequest.getWebPage().getWebSite(), paramRequest.getUser());
                    int tipoResultados   = determinaTipoResultados(results);

                    if (TIPO_EMPRESA == tipoResultados) {
                        log.info("---> TIPO_EMPRESA");
                        List<Empresa> listEmpresas  = contruyeColeccionEmpresas(results);
                        request.setAttribute("results", listEmpresas);
                        path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                    } else if (TIPO_PRODUCTO == tipoResultados) {
                        log.info("---> TIPO_PRODUCTO");
                        List<Producto> listProductos  = contruyeColeccionProductos(results);
                        request.setAttribute("results", listProductos);
                        path = "/swbadmin/jsp/sieps/resultsProducto.jsp";
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
    private List<Empresa> contruyeColeccionEmpresas(Iterator<SemanticObject> semObjects) {
        List<Empresa> results = Collections.emptyList();
        if (semObjects != null) {
            results = new ArrayList<Empresa>();
            while (semObjects.hasNext()) {
                SemanticObject so = semObjects.next();
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
    private List<Producto> contruyeColeccionProductos(Iterator<SemanticObject> semObjects) {
        List<Producto> results = Collections.emptyList();
        if (semObjects != null) {
            results = new ArrayList<Producto>();
            while (semObjects.hasNext()) {
                SemanticObject so = semObjects.next();
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
    private int determinaTipoResultados(Iterator<SemanticObject> results) {
        int tipoRes = -1;
        if (results != null && results.hasNext()) {
            SemanticObject so =  results.next();
            GenericObject go  =  so.createGenericInstance();
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
    
}
