/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.eworkplace.swb.CV;
import com.infotec.eworkplace.swb.Conversacion;
import com.infotec.eworkplace.swb.Escritura;
import com.infotec.eworkplace.swb.GradoAcademico;
import com.infotec.eworkplace.swb.Idioma;
import com.infotec.eworkplace.swb.Idiomas;
import com.infotec.eworkplace.swb.Lectura;
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

/**
 *
 * @author juan.fernandez
 */
public class InvestigacionResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(InvestigacionResource.class);

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
        
        if ("add".equals(action)) {
            
            String ididioma = request.getParameter("ididoma");
            String idconversacion = request.getParameter("idconversacion");
            String idlectura = request.getParameter("idlectura");
            String idescritura = request.getParameter("idescritura");
            
            Idiomas idiomas = Idiomas.ClassMgr.getIdiomas(ididioma,wsite); 
            Conversacion conv = Conversacion.ClassMgr.getConversacion(idconversacion, wsite);
            Lectura lectura = Lectura.ClassMgr.getLectura(idlectura, wsite);
            Escritura escritura = Escritura.ClassMgr.getEscritura(idescritura, wsite); 
            
            if(idiomas!=null&&conv!=null&&lectura!=null&&escritura!=null)
            {
                Idioma idioma = Idioma.ClassMgr.createIdioma(wsite);

                idioma.setConversacion(conv);
                idioma.setEscritura(escritura);
                idioma.setIdiomas(idiomas);
                idioma.setLectura(lectura);
                
                cv.addIdioma(idioma);
                
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", "Se agregó correctamente el Idioma");
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo agregar Idioma");
            }

        } else if ("del".equals(action)) {
            if(id!=null){
                Idioma idioma = Idioma.ClassMgr.getIdioma(id, wsite);
                if(idioma!=null){
                    try {
                        idioma.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Idioma.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Idioma");
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

