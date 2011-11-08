/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico.resources;


import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.promexico.*;

/**
 * Obtiene el video principal y selecciona, de manera aleatoria, dos videos m&aacute;s
 * para presentar la interfaz por la cual se pueden reproducir.
 * @author jose.jimenez
 */
public class VideoSelector extends GenericAdmResource {

    /**
     * Mantiene una referencia hacia el objeto que genera mensajes en la bit&aacute;cora
     */
    private static Logger log = SWBUtils.getLogger(VideoSelector.class);

    /**
     * Almacena las instancias de los videos a mostrar temporalmente
     */
    private ArrayList<ProMxVideo> videos;


    /**
     * Instancia para el que aparecer&aacute; como video principal
     */
    private ProMxVideo mainVideo;

    /**
     * Indica la hora de la &uacute;ltima generaci&oacute;n del arreglo de videos
     */
    private long lastGeneratedAt;

    /**
     * Obtiene el video principal y el conjunto de videos del cual se seleccionar&aacute;n
     * 2, para presentarlos en la p&aacute;gina web correspondiente. La selecci&oacute;n de los
     * videos y la presentaci&oacute;n de la interfaz se realiza en la JSP que se incluye
     * en este metodo (/jsp/VideoSelector.jsp).
     * @param request la petici&oacute;n HTTP que se est&aacute; atendiendo
     * @param response la respuesta HTTP a generar
     * @param paramRequest el conjunto de par&aacute;metros generados por SWB para
     *        atender la petici&oacute;n
     * @throws SWBResourceException en caso de algun problema durante la respuesta
     *        a la petici&oacute;n
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException {

        Resource base = getResourceBase();
        long cacheInMiliSecs = 0;
        short minutes = 0;
        long requestTime = System.currentTimeMillis();
        WebSite ws = paramRequest.getWebPage().getWebSite();
        ArrayList<ProMxVideo> toShow = new ArrayList<ProMxVideo>();

        if (base.getAttribute("cacheInMins") != null) {
            try {
                if (base.getAttribute("cacheInMins") != null &&
                        !"".equalsIgnoreCase(base.getAttribute("cacheInMins"))) {
                    minutes = Short.parseShort(base.getAttribute("cacheInMins"));
                } else {
                    minutes = 10;
                }
            } catch (NumberFormatException nfe) {
                minutes = 10;
                log.error("Asignando valor por defecto en minutos de cache", nfe);
            }
        }

        //tiempo en cache (milisegundos)
        cacheInMiliSecs = minutes * 60000;

        if (this.videos == null) {
            this.videos = new ArrayList<ProMxVideo>();
        }

        if (this.videos.isEmpty() || (this.lastGeneratedAt > 0 &&
                cacheInMiliSecs < (requestTime - this.lastGeneratedAt))) {
            this.videos = getVideos(ws);
            Iterator<SemanticObject> itSemObjects = ws.getSemanticModel().listSubjects(
                    ProMxVideo.promx_isMainVideo, true);
            this.mainVideo = itSemObjects != null && itSemObjects.hasNext()
                             ? ((ProMxVideo) itSemObjects.next().createGenericInstance()) : null;
            this.lastGeneratedAt = System.currentTimeMillis();
        }

        Iterator<ProMxVideo> it = videos.iterator();
        while (it.hasNext()) {
            ProMxVideo v = it.next();
            toShow.add(v);
        }

        try {
            String path = SWBPortal.getWebWorkPath() + "/models/"
                    + ws.getId() + "/jsp/VideoSelector.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("videoList", toShow);
            request.setAttribute("mainVideo", this.mainVideo);
            rd.include(request, response);
        } catch (Exception e) {
            log.error("Al generar la vista de contenido del selector de videos", e);
        }
    }

    private ArrayList<ProMxVideo> getVideos(WebSite ws) {

        Iterator<SemanticObject> videosIt = ws.getSemanticModel().listSubjects(
                    ProMxVideo.promx_isShownAtHome, true);
        ArrayList<ProMxVideo> array = new ArrayList<ProMxVideo>();

        if (videosIt != null) {
            while (videosIt.hasNext()) {
                ProMxVideo proMxVideo = (ProMxVideo) videosIt.next().createGenericInstance();
                if (!proMxVideo.isIsMainVideo()) {
                    array.add(proMxVideo);
                }
            }
        }
        return array;
    }
}
