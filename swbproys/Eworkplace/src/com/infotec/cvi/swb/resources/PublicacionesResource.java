/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Publicacion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author juan.fernandez
 */
public class PublicacionesResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(PublicacionesResource.class);

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

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        String id = request.getParameter("id");
        if (null == action) {
            action = "";
        }

        User usr = response.getUser();
        WebSite wsite = response.getWebPage().getWebSite();
        String eventid = request.getParameter("idevent");
        String page = request.getParameter("page");

        CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
        if(cv==null) {
            cv = CV.ClassMgr.createCV(usr.getId(),wsite);
            cv.setPropietario(usr);
        }
        
        if (SWBResourceURL.Action_ADD.equals(action)||SWBResourceURL.Action_EDIT.equals(action)) {
            
            String txttitulo = request.getParameter("txttitulo");
            String txtpublicado = request.getParameter("txtpublicado");
            int intfecha = 0;
            try {
                intfecha = Integer.parseInt(request.getParameter("intfecha"));
            } catch (Exception e) {
            }
            String msg = "";
            
            if(txttitulo!=null&&txtpublicado!=null&&intfecha>0)
            {
                Publicacion publi = null;
                if(id!=null){
                    publi = Publicacion.ClassMgr.getPublicacion(id,wsite);
                    msg="Se actualizó correctamente Publicación";
                }
                if(publi==null){
                    publi = Publicacion.ClassMgr.createPublicacion(wsite);
                    cv.addPublicacion(publi);
                    msg="Se agregó correctamente Publicación";
                }

                publi.setTitle(txttitulo);
                publi.setPublicado(txtpublicado);
                publi.setFechapublicado(intfecha);
                
                
                
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", msg);
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo procesar Publicación");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if(id!=null){
                Publicacion publi = Publicacion.ClassMgr.getPublicacion(id, wsite);
                if(publi!=null){
                    try {
                        publi.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente la Publicación.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar la Publicación");
                    }                    
                }                
            }
        }
        if (eventid != null) {
            response.setRenderParameter("id", eventid);
        }
        if (page != null) {
            response.setRenderParameter("page", page);
        }
    }

    
}

