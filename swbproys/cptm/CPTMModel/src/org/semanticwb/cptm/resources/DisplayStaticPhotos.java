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
import org.semanticwb.cptm.Photo;
import org.semanticwb.model.User;
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
        long start = System.currentTimeMillis();
        String path = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId() + "/jsp/displayPhotos.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        WebPage wp = paramRequest.getWebPage();
        SemanticObject so = wp.getSemanticObject();
        SemanticProperty prop = so.getSemanticClass().getProperty(
                CptmgeneralData.cptm_hasMorePhoto.getName());
        Iterator fotos = null;
        ArrayList listImage = new ArrayList();
        if (wp.getId().matches("Mostrar_Evento") || wp.getId().matches("Mostrar-Evento")) {
            if (request.getParameter("show") != null &&
                    request.getParameter("show").equalsIgnoreCase("event")) {

                String id = request.getParameter("id");
                if (id != null) {
                    Event evento = Event.ClassMgr.getEvent(id, wp.getWebSite());
                    fotos = evento.listMorePhotos();
                    while (fotos.hasNext() && (listImage.size() < 8)) {
                        Photo objPhoto=(Photo)fotos.next();
                        String image = objPhoto.getPhotoImage();//getDisplayTitle(user.getLanguage());
                        if(image != null) {
                            image = SWBPortal.getWebWorkPath() + "/" +objPhoto.getWorkPath() + "/" + Photo.cptm_PhotoImage.getName()+"_" +objPhoto.getId()+"_"+objPhoto.getSemanticObject().getProperty(Photo.cptm_PhotoImage);
                            String txtAlt =  "";
                            if(objPhoto.getPhotoAlt(paramRequest.getUser().getLanguage()) != null) {
                                txtAlt = objPhoto.getPhotoAlt(paramRequest.getUser().getLanguage());
                            } else if(objPhoto.getPhotoAlt() != null) {
                                txtAlt = objPhoto.getPhotoAlt();
                            }
                            String txtDescr =  objPhoto.getDescription(paramRequest.getUser().getLanguage()) != null ?
                                objPhoto.getDescription(paramRequest.getUser().getLanguage()) : "";
                            String [] data = { image , txtAlt, txtDescr };
                            listImage.add(data);
                        }
                    }
                }
            }
        } else if(wp instanceof CptmgeneralData) {
            Iterator<Photo> it = ((CptmgeneralData) wp).listMorePhotos();
            while(it.hasNext()&& (listImage.size() < 8)) {
                Photo phot = it.next();
                String image = phot.getPhotoImage();
                if(image != null) {
                    image = SWBPortal.getWebWorkPath() + "/" +phot.getWorkPath() + "/" + Photo.cptm_PhotoImage.getName()+"_" +phot.getId()+"_"+phot.getPhotoImage();
                    String txtAlt =  "";
                    if(phot.getPhotoAlt(paramRequest.getUser().getLanguage()) != null) {
                        txtAlt = phot.getPhotoAlt(paramRequest.getUser().getLanguage());
                    } else if(phot.getPhotoAlt() != null) {
                        txtAlt = phot.getPhotoAlt();
                    }
                    String txtDescr =  phot.getDescription(paramRequest.getUser().getLanguage()) != null ?
                        phot.getDescription(paramRequest.getUser().getLanguage()) : "";
                    String [] data = { image , txtAlt, txtDescr };
                    listImage.add(data);
                }
            }
        }
        /*else if (prop != null) { //&& !prop.isObjectProperty() && prop.getCardinality() != 1
            Iterator<SemanticObject> lista = so.listObjectProperties(prop);//listLiteralProperties(prop);

            if (lista != null) {
                while (lista.hasNext() && (listImage.size() < 8)) {
                    SemanticObject lit = lista.next();

                    if(lit instanceof Photo) {
                        Photo phot = (Photo)lit;
                        String image = lit.getProperty(Photo.cptm_PhotoImage);
                        if(image != null) {
                            image = SWBPortal.getWebWorkPath() + "/" +lit.getWorkPath() + "/" + Photo.cptm_PhotoImage.getName()+"_" +lit.getId()+"_"+lit.getProperty(Photo.cptm_PhotoImage);
                            String txtAlt =  lit.getProperty(Photo.cptm_PhotoAlt) == null ? "" : lit.getProperty(Photo.cptm_PhotoAlt);
                            String [] data = { image , txtAlt };
                            listImage.add(data);
                        }
                    }
                }
            }
        } */

        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("listImage", listImage);
            request.setAttribute("start", start);
            request.setAttribute("typeGalery", "");
            rd.include(request, response);
        } catch(Exception e) {
            log.error(e);
        }
    }
}
