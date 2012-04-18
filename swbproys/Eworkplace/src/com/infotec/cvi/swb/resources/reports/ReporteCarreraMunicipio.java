/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources.reports;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 * Recurso de contenido que permite a imprimir el reporte de Carrera  Municipio
 *
 * @author rene.jara
 */
public class ReporteCarreraMunicipio extends GenericResource {
    
    private Logger log = SWBUtils.getLogger(ReporteExperiencia.class);
        /** Modo personalizado para ejecutar doPrint   */
    public static final String Mode_EXPORT="exp";
        /** Modo personalizado para enviar datos por ajax     */
    public static final String Mode_AJAX = "ajax";

        @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
//System.out.println("********************************************************processRequest");
        String mode = paramRequest.getMode();
        if (Mode_AJAX.equals(mode)) {
            doAjax(request, response, paramRequest);
        } else if(Mode_EXPORT.equals(mode)){
            doExport(request, response, paramRequest);
        }else{
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);

            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
        
        

    }
    /**
     *  Modo que procesa las peticiones de las consultas ajax de la forma para CP
     *
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doAjax(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        RequestDispatcher dis = request.getRequestDispatcher(basePath + "ajax.jsp");
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }
    public void doExport(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setHeader("Content-Disposition", " attachment; filename=\"ReporteExperienciaSector_"+ System.currentTimeMillis() + ".xls\";");
        response.setContentType("application/vnd.ms-excel");
        doView(request, response, paramRequest);
    }

}
