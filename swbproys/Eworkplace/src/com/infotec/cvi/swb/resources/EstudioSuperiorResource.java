/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.eworkplace.swb.Academia;
import com.infotec.eworkplace.swb.Avance;
import com.infotec.eworkplace.swb.CV;
import com.infotec.eworkplace.swb.Carrera;
import com.infotec.eworkplace.swb.EstudioSuperior;
import com.infotec.eworkplace.swb.Estudios;
import com.infotec.eworkplace.swb.Grado;
import com.infotec.eworkplace.swb.GradoAcademico;
import com.infotec.eworkplace.swb.SituacionAcademica;
import com.infotec.eworkplace.swb.base.GradoBase;
import java.io.IOException;
import java.util.Iterator;
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
public class EstudioSuperiorResource extends GenericResource
{

    private Logger log = SWBUtils.getLogger(EstudioSuperiorResource.class);

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
             
        Academia aca = cv.getAcademia();
        if(aca==null){
            aca = Academia.ClassMgr.createAcademia(wsite);
            cv.setAcademia(aca);
        }
        
        
        if ("add".equals(action)) {
            
            String idestudio = request.getParameter("idestudio");
            String idgavance = request.getParameter("idgavance");
            int intPeriodo = request.getParameter("periodo")!=null?Integer.parseInt(request.getParameter("periodo")):0;
            
            Estudios estudio = Estudios.ClassMgr.getEstudios(idestudio, wsite);
            Avance gavance = Avance.ClassMgr.getAvance(idgavance, wsite);
            
            if(estudio!=null&&gavance!=null&&intPeriodo>=0)
            {
                EstudioSuperior estSuperior = EstudioSuperior.ClassMgr.createEstudioSuperior(wsite);

                estSuperior.setGradoAvance(gavance);
                estSuperior.setEstudiosSuperiores(estudio);
                estSuperior.setPeriodoYears(intPeriodo);
                
                aca.addEstudioSuperior(estSuperior);
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", "Se agregó correctamente el Estudio Superior");
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo agregar Estudio Superior");
            }

        } else if ("del".equals(action)) {
            if(id!=null){
                EstudioSuperior estSuperior = EstudioSuperior.ClassMgr.getEstudioSuperior(id, wsite);
                if(estSuperior!=null){
                    try {
                        estSuperior.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Estudio Superior.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Estudio Superior");
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
