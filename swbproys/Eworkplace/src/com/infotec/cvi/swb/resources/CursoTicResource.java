
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.CursoTIC;
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
public class CursoTicResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(CursoTicResource.class);

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
            
            String nomcurso = request.getParameter("nomcurso");
            String nominstitucion = request.getParameter("nominstitucion");
            String fechaini = request.getParameter("fechaini");
            String fechafin = request.getParameter("fechafin");
            String docobtenido = request.getParameter("docobtenido");
            
            int intfechaini = 0;
            try {
                intfechaini = Integer.parseInt(fechaini);
            } catch (Exception e) {
            }
            int intfechafin = 0;
            try {
                intfechafin = Integer.parseInt(fechafin);
            } catch (Exception e) {
            }
            String msg ="";
            if(nomcurso!=null&&nominstitucion!=null&&fechaini!=null&&fechafin!=null&&docobtenido!=null)
            {
                CursoTIC ctic = null;
                
                if(id!=null){
                    ctic = CursoTIC.ClassMgr.getCursoTIC(id,wsite);
                    msg="Se actualizó correctamente el Curso TIC";
                }

                if(ctic==null){
                    ctic = CursoTIC.ClassMgr.createCursoTIC(wsite);
                    cv.addCursosTIC(ctic);
                    msg="Se agregó correctamente el Curso TIC";
                }
                
                
                ctic.setNombreInstitucion(nominstitucion);
                ctic.setTitle(nomcurso);
                ctic.setDocumentoObtenido(docobtenido);
                ctic.setInicio(intfechaini);
                ctic.setFin(intfechafin);
                
                
                
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", msg);
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo procesar Curso TIC");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if(id!=null){
                CursoTIC ctic = CursoTIC.ClassMgr.getCursoTIC(id, wsite);
                if(ctic!=null){
                    try {
                        ctic.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Curso.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Curso");
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

