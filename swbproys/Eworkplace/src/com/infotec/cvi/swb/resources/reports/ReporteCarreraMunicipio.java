/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources.reports;

import com.infotec.cvi.swb.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;

/**
 * Recurso de contenido que permite imprimir el reporte por Carrera - Municipio
 *
 * @author rene.jara
 */
public class ReporteCarreraMunicipio extends GenericResource {
    
    private Logger log = SWBUtils.getLogger(ReporteExperiencia.class);
        /** Modo personalizado para ejecutar doExport  */
    public static final String Mode_EXPORT="exp";
        /** Modo personalizado para enviar datos por ajax     */
    public static final String Mode_AJAX = "ajax";
        /** Modo especial para ejecutar getTipo  */
    public static final String MODE_TIPO = "mod_tipo";
    /** Modo especial para ejecutar getArea  */
    public static final String MODE_AREA = "mod_area";
    /** Modo especial para ejecutar getCarrera  */
    public static final String MODE_CARRERA = "mod_carrera";

        @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if (MODE_TIPO.equals(mode)) {
            getTipo(request, response, paramRequest);
        } else if (MODE_AREA.equals(mode)) {
            getArea(request, response, paramRequest);
        } else if (MODE_CARRERA.equals(mode)) {
            getCarrera(request, response, paramRequest);
        } else if (Mode_AJAX.equals(mode)) {
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
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
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

    /**
     * Modo que procesa la peticiones JSON relacionadas al tipo de carrera
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void getTipo(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("application/json; charset=ISO-8859-1");//ISO-8859-1
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User usr = paramRequest.getUser();
        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<TipoCarrera> it = SWBComparator.sortByDisplayName(TipoCarrera.ClassMgr.listTipoCarreras(wsite), usr.getLanguage());
            while (it.hasNext()) {
                TipoCarrera tipo = it.next();
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", tipo.getId());
                jtipo.put("name", tipo.getTitle());
                Iterator<AreaCarrera> itarea = tipo.listAreas();
                while (itarea.hasNext()) {
                    AreaCarrera areaCarrera = itarea.next();
                    jtipo.put("area", areaCarrera.getId());
                }
            }

            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }

    /**
     * Modo que procesa la peticiones JSON relacionadas al area de la carrera
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void getArea(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");//ISO-8859-1
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User usr = paramRequest.getUser();

        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<AreaCarrera> it = SWBComparator.sortByDisplayName(AreaCarrera.ClassMgr.listAreaCarreras(wsite), usr.getLanguage());
            while (it.hasNext()) {
                AreaCarrera area = it.next();
                JSONObject jarea = new JSONObject();
                items.put(jarea);
                jarea.put("id", area.getId());
                jarea.put("name", area.getTitle());
                TipoCarrera tipo = area.getTipoCarreraInv();
                    if (tipo != null) {
                        jarea.put("tipo", area.getTipoCarreraInv().getId());
                    }
            }
            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }

    /**
     * Modo que procesa la peticiones JSON relacionadas a la carrera
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
    public void getCarrera(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");//ISO-8859-1
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        User usr = paramRequest.getUser();
        String ret = "";
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            Iterator<Carrera> it = SWBComparator.sortByDisplayName(Carrera.ClassMgr.listCarreras(wsite), usr.getLanguage());
            while (it.hasNext()) {
                Carrera car = it.next();
                JSONObject jcarrera = new JSONObject();
                items.put(jcarrera);
                jcarrera.put("id", car.getId());
                jcarrera.put("name", car.getTitle());
                AreaCarrera area = car.getAreaCarrera();
                if(area!=null){
                    jcarrera.put("area", area.getId());
                    TipoCarrera tipo = area.getTipoCarreraInv();
                    if (tipo != null) {
                        jcarrera.put("tipo", area.getTipoCarreraInv().getId());
                    }
                }
            }
            ret = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        out.print(ret);
    }


}
