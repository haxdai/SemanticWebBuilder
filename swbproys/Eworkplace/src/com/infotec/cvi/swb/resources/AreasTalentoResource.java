package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.AreaTalento;

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
 * @author carlos.ramos
 */
public class AreasTalentoResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(AreasTalentoResource.class);
    
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
        
        if(SWBResourceURL.Action_ADD.equals(action)) {
            if(!validate(request, response))
                return;
            AreaTalento talento = AreaTalento.ClassMgr.createAreaTalento(wsite);
            talento.setAreaTalento(SWBUtils.XML.replaceXMLChars(request.getParameter("tlnt")));
            talento.setYearExperienceTalento(Integer.parseInt(request.getParameter("ytlnt")));
            talento.setAreaDestrezaTI(SWBUtils.XML.replaceXMLChars(request.getParameter("dstrz")));
            talento.setYearExpirienceTI(Integer.parseInt(request.getParameter("ydstrz")));
            cv.addAreaTalento(talento);
        }else if(SWBResourceURL.Action_EDIT.equals(action)) {
            final String distincionId = request.getParameter("id");
            AreaTalento talento;
            try {
                talento = AreaTalento.ClassMgr.getAreaTalento(distincionId, wsite);
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "distincion no existe");
                return;
            }
            if(!validate(request, response))
                return;
            
            if(!cv.hasAreaTalento(talento)) {
                response.setRenderParameter("alertmsg", "Tu cv no contiene esta distincion");
                return;
            }
            
            talento.setAreaTalento(SWBUtils.XML.replaceXMLChars(request.getParameter("tlnt")));
            talento.setYearExperienceTalento(Integer.parseInt(request.getParameter("ytlnt")));
            talento.setAreaDestrezaTI(SWBUtils.XML.replaceXMLChars(request.getParameter("dstrz")));
            talento.setYearExpirienceTI(Integer.parseInt(request.getParameter("ydstrz")));
            response.setRenderParameter("alertmsg", "talento modifcado bien");
        }else if(SWBResourceURL.Action_REMOVE.equals(action)) {
            final String talentoId = request.getParameter("id");
            try {
                AreaTalento talento = AreaTalento.ClassMgr.getAreaTalento(talentoId, wsite);
                if(cv.hasAreaTalento(talento)) {
                    talento.remove();
                    response.setRenderParameter("alertmsg", "talento eliminado");
                }else {
                    response.setRenderParameter("alertmsg", "Tu cv no contiene este talento");
                }
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "talento no se pudo eliminar");
                log.error(e);
            }
        }
    }
    
    private boolean validate(HttpServletRequest request, SWBActionResponse response) {
        if(request.getParameter("tlnt").isEmpty() || request.getParameter("dstrz").isEmpty()) {
            response.setRenderParameter("alertmsg", "faltan datos");
            return false;
        }
        try {
            Integer.parseInt(request.getParameter("ytlnt"));
            Integer.parseInt(request.getParameter("ydstrz"));
        }catch(Exception e) {
            response.setRenderParameter("alertmsg", "Los años de experiencia esta mal");
            return false;
        }
        return true;
    }
}
