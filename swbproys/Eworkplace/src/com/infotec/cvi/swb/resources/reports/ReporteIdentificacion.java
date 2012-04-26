/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources.reports;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 * * Recurso de contenido que permite imprimir el reporte de identificacion por edad genero y pais de nacimiento
 * 
 * @author rene.jara
 */
public class ReporteIdentificacion extends GenericResource {
    
    private Logger log = SWBUtils.getLogger(ReporteIdentificacion.class);
    /** Accion personalizada para reporte por genero     */
    public static final String Action_REP_GENDER="gen";
    /** Accion personalizada para reporte por edad     */
    public static final String Action_REP_AGE="age";
    /** Accion personalizada para reporte por nacionalidad     */
    public static final String Action_REP_NATIONATITY="nac";
    /** Modo personalizado para ejecutar doPrint   */
    public static final String Mode_PRINT="prn";
    /** Modo personalizado para ejecutar doExport  */
    public static final String Mode_EXPORT="exp";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if(Mode_PRINT.equals(mode)){
            doPrint(request, response, paramRequest);
        }else if(Mode_EXPORT.equals(mode)){
            doExport(request, response, paramRequest);
        }else{
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String repType =request.getParameter("repType");
        if(repType!=null&&!repType.equals("")){
            if(repType.equals("gender")){
                response.setAction(Action_REP_GENDER);
                response.setMode(Mode_PRINT);
            }else if(repType.equals("age")){
                response.setAction(Action_REP_AGE);
                response.setMode(Mode_PRINT);
            }else if(repType.equals("nationality")){
                response.setAction(Action_REP_NATIONATITY);
                response.setMode(Mode_PRINT);
            }

        }
    }

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
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
     * Modo que procesa la peticion doPrint para mostrar la informacion del reporte solicitado
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void doPrint(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String action = paramRequest.getAction();
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath;// + "print.jsp";
        if(action.equals(Action_REP_GENDER)){
            path+="gender.jsp";
        }else if(action.equals(Action_REP_AGE)){
            path+="age.jsp";
        }else{
            path+="nationality.jsp";
        }
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
        response.setHeader("Content-Disposition", " attachment; filename=\"ReporteIndentificacion_"+paramRequest.getAction()+ System.currentTimeMillis() + ".xls\";");
        response.setContentType("application/vnd.ms-excel");
        doPrint(request, response, paramRequest);
    }
    
}
