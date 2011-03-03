/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources;

import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.CptmgeneralData;
import org.semanticwb.cptm.Event;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.*;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author miguel.ortiz
 */

public class DisplayStaticPhotos extends GenericResource{
    private static Logger log = SWBUtils.getLogger(DisplayStaticPhotos.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String path = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId() + "/jsp/displayPhotos.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        WebPage wp = paramRequest.getWebPage();
        SemanticObject so = wp.getSemanticObject();
        SemanticProperty prop = so.getSemanticClass().getProperty(
                CptmgeneralData.cptm_hasMorePhoto.getName());
        Iterator fotos = null;
        ArrayList<String> listImage = new ArrayList<String>();

        if (wp.getId().matches("Mostrar_Evento")) {
            if (request.getParameter("show") != null &&
                    request.getParameter("show").equalsIgnoreCase("event")) {

                String id = request.getParameter("id");

                if (id != null) {
                    Event evento = Event.ClassMgr.getEvent(id, wp.getWebSite());

                    fotos = evento.listMorePhotos();
                    while (fotos.hasNext() && (listImage.size() < 8)) {
                        String imagen = (String)fotos.next();
                        String ruta = SWBPortal.getWebWorkPath()
                                + evento.getWorkPath() + "/" + imagen;
                        listImage.add(ruta);
                    }
                }
            }
        } else if (prop != null && !prop.isObjectProperty() &&
                prop.getCardinality() != 1) {

            Iterator<SemanticLiteral> lista = so.listLiteralProperties(prop);

            if (lista != null) {
                while (lista.hasNext() && (listImage.size() < 8)) {
                    SemanticLiteral lit = lista.next();
                    String fname = lit.getString();
                    String ruta = SWBPortal.getWebWorkPath() + so.getWorkPath()
                            + "/" + fname;
                    listImage.add(ruta);
                }
            }
        }

        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("listImage", listImage);
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }
}
