package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Competencia;

import java.io.IOException;
import java.util.Arrays;
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
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class AutoEvaluacionCompetenciasResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(AutoEvaluacionCompetenciasResource.class);
    
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
            return;
        }
        if(SWBResourceURL.Action_EDIT.equals(action)) {
            if(!validate(request, response)) {
                return;
            }
            
            cv.removeAllCompetencia();
            
//            Iterator<Competencia> competencias = cv.listCompetencias();
//            while(competencias.hasNext()) {
//                Competencia competencia = competencias.next();
//                if(competencia!=null)
//                    competencia.remove();
//            }
            String[] cmptncs = request.getParameterValues("cmptc");
            if(cmptncs!=null) {
                for(String cmptncId:cmptncs) {
                    try {
System.out.println("cmptncId="+cmptncId);
                        Competencia cmptnc = Competencia.ClassMgr.getCompetencia(cmptncId, wsite);
                        cv.addCompetencia(cmptnc);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            response.setRenderParameter("alertmsg", "competencias agregadas bien");
        }
    }
    
    private boolean validate(HttpServletRequest request, SWBActionResponse response) {
        boolean validate = true;
        CV cv = CV.ClassMgr.getCV(response.getUser().getId(), getResourceBase().getWebSite());
//        if(request.getParameterValues("cmptc")==null) {
//            response.setRenderParameter("alertmsg", "Marca al menos una competencia");
//            return false;
//        }
//        if(request.getParameterValues("cmptc").length==0) {
//            response.setRenderParameter("alertmsg", "marca al menos una competencia");
//            return false;
//        }
        try {
            if(request.getParameterValues("cmptc").length>5) {
                response.setRenderParameter("alertmsg", "marca hasta 5 competencias");
                validate = false;
            }
        }catch(Exception e) {
        }
        if(SWBUtils.Collections.sizeOf(cv.listCompetencias())>=5 && request.getParameterValues("cmptc").length>0) {
            validate = false;
            response.setRenderParameter("alertmsg", "valor maximo alcanzado");
        }
            
        return validate;
    }
}
