package com.infotec.cvi.swb.resources;


import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.CV;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class ProgressBarResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(ProgressBarResource.class);
    
    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        User user = paramRequest.getUser();
        if(user.isSigned()) {
//            PrintWriter out = response.getWriter();
            Resource base = getResourceBase();
            WebSite wsite = base.getWebSite();
            CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
            if(cv == null) {
                cv = CV.ClassMgr.createCV(user.getId(), wsite);
                cv.setPropietario(user);
            }
            Academia aca = cv.getAcademia();
            if(aca == null) {
                aca = Academia.ClassMgr.createAcademia(wsite);
                cv.setAcademia(aca);
            }          
            final String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
            String path = null;

            if(paramRequest.getCallMethod() == SWBResourceURL.Call_STRATEGY) {
                path = basePath + "progressBar.jsp";
            }else {
                path = basePath + "progressResume.jsp";
            }
            
            RequestDispatcher dis = request.getRequestDispatcher(path);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            }catch(Exception e) {
                log.error(e);
            }
        }
    }
}
