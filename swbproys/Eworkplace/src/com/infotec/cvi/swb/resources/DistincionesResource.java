package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Distincion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author carlos.ramos
 */
public class DistincionesResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(DistincionesResource.class);
    
    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                    e.printStackTrace(System.out);
                }
            }
        }
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        User user = response.getUser();
        if(!user.isSigned())
            return;
        
        final String action = response.getAction();
        WebSite wsite = response.getWebPage().getWebSite();

        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        if(cv==null) {
            log.error("Objeto semantico cv del usuario es nulo");
        }
        String msg = "";
        if(SWBResourceURL.Action_ADD.equals(action)) {
            if(!validate(request, response))
                return;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Distincion distincion = Distincion.ClassMgr.createDistincion(wsite);
            distincion.setTitle(SWBUtils.XML.replaceXMLChars(request.getParameter("ttl")));
            distincion.setOtorgante(SWBUtils.XML.replaceXMLChars(request.getParameter("trgnt")));
            try {
                distincion.setFechaDistincion(sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("fp"))));
            }catch(ParseException e){
                response.setRenderParameter("alertmsg", "Fecha de premio mal");
                distincion.remove();
                return;
            }
            cv.addDistincion(distincion);
            cv.setSinDistincion(Boolean.FALSE);
            
        }else if(SWBResourceURL.Action_EDIT.equals(action)) {
            final String distincionId = request.getParameter("id");
            Distincion distincion;
            try {
                distincion = Distincion.ClassMgr.createDistincion(distincionId, wsite);
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "distincion no existe");
                return;
            }
            if(!validate(request, response))
                return;
            
            if(!cv.hasDistincion(distincion)) {
                response.setRenderParameter("alertmsg", "Tu cv no contiene esta distincion");
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            distincion.setTitle(SWBUtils.XML.replaceXMLChars(request.getParameter("ttl")));
            distincion.setOtorgante(SWBUtils.XML.replaceXMLChars(request.getParameter("trgnt")));
            try {
                distincion.setFechaDistincion(sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("fp"))));
            }catch(ParseException e){
                response.setRenderParameter("alertmsg", "Fecha de premio mal");
                distincion.remove();
                return;
            }
            response.setRenderParameter("alertmsg", "distincion modifcada bien");
        }else if(SWBResourceURL.Action_REMOVE.equals(action)) {
            final String distincionId = request.getParameter("id");
            try {
                Distincion  distincion = Distincion.ClassMgr.getDistincion(distincionId, wsite);
                if(cv.hasDistincion(distincion)) {
                    distincion.remove();
                    response.setRenderParameter("alertmsg", "distincion eliminada");
                }else {
                    response.setRenderParameter("alertmsg", "Tu cv no contiene esta distincion");
                }
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "distincion no se pudo eliminar");
                log.error(e);
            }
        } else if (action.equals("updateNoAplica")){
            //System.out.println("NoAplica: "+request.getParameter("noAplica"));
            String noAplica = request.getParameter("noAplica");
            msg="Se actualizó No aplican Distinciones";
            if(noAplica!=null&&noAplica.equals("true"))
            {
                cv.setSinDistincion(Boolean.TRUE);
            } else {
                cv.setSinDistincion(Boolean.FALSE);
            }

            response.setRenderParameter("act", "");
            response.setRenderParameter("alertmsg", msg);
            
        }
    }
    
    private boolean validate(HttpServletRequest request, SWBActionResponse response) {
        if(request.getParameter("ttl").isEmpty() || request.getParameter("trgnt")==null || request.getParameter("fp").isEmpty()) {
            response.setRenderParameter("alertmsg", "faltan datos");
            return false;
        }
        return true;
    }
}
