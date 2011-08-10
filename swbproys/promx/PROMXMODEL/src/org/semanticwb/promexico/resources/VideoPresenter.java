/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico.resources;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.promexico.*;


/**
 * Presenta a traves de peticiones de AJAX, los videos pertenecientes a tipo seleccionado.
 * @author jose.jimenez
 */
public class VideoPresenter extends GenericResource {


    /**
     * Mantiene una referencia hacia el objeto que genera mensajes en la bit&aacute;cora
     */
    private static Logger log = SWBUtils.getLogger(VideoPresenter.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String path = SWBPortal.getWebWorkPath() + "/models/"
                    + paramRequest.getWebPage().getWebSite().getId() + "/jsp/VideoPresenter.jsp";
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (Exception e) {
            log.error("Al generar la vista de contenido del presentador de videos", e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        String mode = paramRequest.getMode();
        if ("extract".equals(mode)) {
            doExtractVideos(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Obtiene el conjunto de videos clasificados con el tipo de video indicado
     * en un par&aacute;metro del objeto {@code request} de nombre {@code typeId}.
     * @param request la petici&oacute;n HTTP que se est&aacute; atendiendo
     * @param response la respuesta HTTP a generar
     * @param paramRequest el conjunto de par&aacute;metros generados por SWB para
     *        atender la petici&oacute;n
     * @throws SWBResourceException en caso de alg&uacute;n problema durante la respuesta
     *        a la petici&oacute;n
     * @throws IOException en caso de alg&uacute;n problema de lectura o escritura
     */
    public void doExtractVideos(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        
        JSONObject videosResponse = new JSONObject();
        WebSite ws = paramRequest.getWebPage().getWebSite();
        String videoTypeId = request.getParameter("typeId");
        String lang = paramRequest.getUser().getLanguage();

        if (videoTypeId != null && !"".equals(videoTypeId)) {
            ProMxVideoType videoType = ProMxVideoType.ClassMgr.getProMxVideoType(videoTypeId, ws);
            Iterator<ProMxVideo> it = ProMxVideo.ClassMgr.listProMxVideoByVideoType(videoType, ws);
            JSONObject foundVideos = new JSONObject();

            while (it.hasNext()) {
                ProMxVideo video = it.next();
                try {
                    JSONObject jsonVideo = new JSONObject();
                    jsonVideo.put("path", video.getWorkPath());
                    jsonVideo.put("titulo", video.getDisplayTitle(lang));
                    jsonVideo.put("imagen", video.getPmVideoImage());
                    jsonVideo.put("video", video.getPmVideo());
                    foundVideos.put(video.getId(), jsonVideo);
                } catch (Exception e1) {
                    log.error("Al agregar un video a la respuesta", e1);
                }
            }
            try {
                videosResponse.put(videoTypeId, foundVideos);
            } catch (Exception e) {
                log.error("Al generar la respuesta para un tipo de video", e);
            }
        }
        out.print(videosResponse);
    }

}
