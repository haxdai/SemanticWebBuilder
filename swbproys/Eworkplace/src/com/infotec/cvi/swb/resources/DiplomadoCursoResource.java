/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Diplomado;
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
public class DiplomadoCursoResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(DiplomadoCursoResource.class);

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
            
            String nomcurso = request.getParameter("nomcurso");
            String nominstitucion = request.getParameter("nominstitucion");
            String fechaini = request.getParameter("fechaini");
            String fechafin = request.getParameter("fechafin");
            String docobtenido = request.getParameter("docobtenido");
            
            if(nomcurso!=null&&nominstitucion!=null&&fechaini!=null&&fechafin!=null&&docobtenido!=null)
            {
                Diplomado ctic = Diplomado.ClassMgr.createDiplomado(wsite);

                ctic.setNombreInstitucion(nominstitucion);
                ctic.setTitle(nomcurso);
                ctic.setDocumentoObtenido(docobtenido);
                ctic.setInicio(null);
                ctic.setFin(null);
                
                cv.addDiplomado(ctic);
                
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", "Se agregó correctamente el Diplomado / Curso");
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo agregar Diplomado / Curso");
            }

        } else if ("del".equals(action)) {
            if(id!=null){
                Diplomado ctic = Diplomado.ClassMgr.getDiplomado(id, wsite);
                if(ctic!=null){
                    try {
                        ctic.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Diplomado / Curso.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Diplomado / Curso");
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

