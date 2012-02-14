/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Docencia;
import com.infotec.cvi.swb.Investigacion;
import com.infotec.cvi.swb.NivelDocencia;
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
public class DocenciaResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(DocenciaResource.class);

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
            
            String txtasignatura = request.getParameter("txtasignatura");
            String txtinstitucion = request.getParameter("txtinstitucion");
            String idnivel = request.getParameter("idnivel");
            
            int intyears = 0;
            try {
                intyears = Integer.parseInt(request.getParameter("intyears"));
            } catch (Exception e) {
            }
            
            NivelDocencia nivel = NivelDocencia.ClassMgr.getNivelDocencia(idnivel,wsite); 
            
            if(txtasignatura!=null&&txtinstitucion!=null&&nivel!=null&&intyears>0)
            {
                Docencia docencia = null;
                if(id!=null) docencia = Docencia.ClassMgr.getDocencia(id,wsite);
                if(docencia==null){
                    docencia = Docencia.ClassMgr.createDocencia(wsite);
                    cv.addDocencia(docencia);
                }

                docencia.setAsignatura(txtasignatura);
                docencia.setInstitucion(txtinstitucion);
                docencia.setNivelDocencia(nivel); 
                docencia.setAniosDocencia(intyears);

                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", "Se agregó correctamente Docencia");
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo agregar Docencia");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if(id!=null){
                Investigacion invest = Investigacion.ClassMgr.getInvestigacion(id, wsite);
                if(invest!=null){
                    try {
                        invest.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente la Docencia.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar la Docencia");
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

