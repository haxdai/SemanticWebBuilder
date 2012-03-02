/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Investigacion;
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
        String msg = "";
        if (SWBResourceURL.Action_ADD.equals(action)||SWBResourceURL.Action_EDIT.equals(action)) {
            
            String txtareainv = request.getParameter("txtareainv");
            String txtempresa = request.getParameter("txtempresa");
            String txtnomjefe = request.getParameter("txtnomjefe");
            String txtnompuesto = request.getParameter("txtnompuesto");
            String idsniconacyt = request.getParameter("idsniconacyt");
            int fechafin = 0;
            try {
                fechafin = Integer.parseInt(request.getParameter("txtfechafin"));
            } catch (Exception e) {
            }
            int numtel = 0;
            try {
                numtel = Integer.parseInt(request.getParameter("numtel"));
            } catch (Exception e) {
            }

            if(txtareainv!=null&&txtempresa!=null&&txtnomjefe!=null&&txtnompuesto!=null&&fechafin>0&&numtel>0)
            {
                Investigacion inves = null;
                if(id!=null){
                    inves = Investigacion.ClassMgr.getInvestigacion(id,wsite);
                    msg="Se actualizó correctamente la Investigación";
                }
                if(inves==null){
                    inves = Investigacion.ClassMgr.createInvestigacion(wsite);
                    cv.addInvestigacion(inves);
                    msg="Se agregó correctamente la Investigación";
                    cv.setSinInvestigacion(Boolean.FALSE);
                }

                inves.setAreaInvestigacion(txtareainv);
                inves.setNombreEmpresa(txtempresa);
                inves.setNombreJefePuesto(txtnomjefe);
                inves.setNombrePuesto(txtnompuesto);
                inves.setFechaTermino(fechafin);
                inves.setNumTelefono(numtel);
                if(idsniconacyt!=null) inves.setSniConacyt(idsniconacyt);
                
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", msg);
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo procesar Investigación");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if(id!=null){
                Investigacion invest = Investigacion.ClassMgr.getInvestigacion(id, wsite);
                if(invest!=null){
                    try {
                        invest.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente la Investigación.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar la Investigación");
                    }                    
                }                
            }
        } else if (action.equals("updateNoAplica")){
            //System.out.println("NoAplica: "+request.getParameter("noAplica"));
            String noAplica = request.getParameter("noAplica");
            msg="Se actualizó No aplica Investigación";
            if(noAplica!=null&&noAplica.equals("true"))
            {
                cv.setSinInvestigacion(Boolean.TRUE);
            } else {
                cv.setSinInvestigacion(Boolean.FALSE);
            }

            response.setRenderParameter("act", "");
            response.setRenderParameter("alertmsg", msg);
            
        }
        if (eventid != null) {
            response.setRenderParameter("id", eventid);
        }
        if (page != null) {
            response.setRenderParameter("page", page);
        }
    }

    
}

