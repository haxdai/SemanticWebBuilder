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
 * Recurso de contenido que permite imprimir el reporte de experiencia laboral por sector
 *
 * @author rene.jara
 */
public class ReporteExperienciaSector extends GenericResource {
    
    private Logger log = SWBUtils.getLogger(ReporteExperiencia.class);
        /** Modo personalizado para ejecutar doPrint   */
    public static final String Mode_EXPORT="exp";

        @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if(Mode_EXPORT.equals(mode)){
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
     * Modo que procesa la peticion doExport para exportar la informacion. solo cambia el content-type a Excel y llama al doView
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void doExport(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setHeader("Content-Disposition", " attachment; filename=\"ReporteExperienciaSector_"+ System.currentTimeMillis() + ".xls\";");
        response.setContentType("application/vnd.ms-excel");
        doView(request, response, paramRequest);
    }

}
