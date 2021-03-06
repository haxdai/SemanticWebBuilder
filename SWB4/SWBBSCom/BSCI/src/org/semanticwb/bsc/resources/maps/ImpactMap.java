package org.semanticwb.bsc.resources.maps;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author carlos.ramos
 */
public class ImpactMap extends GenericResource {
    private final Logger log = SWBUtils.getLogger(ImpactMap.class);
    public static String path;
    private String urlObjectivePage;

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        setUrlObjectivePage(base.getWebSite().getWebPage(Objective.class.getSimpleName()).getUrl());
        path = "/work/models/" + getResourceBase().getWebSiteId() + "/jsp/" 
                + this.getClass().getSimpleName() + "/" + "view.jsp";
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        if( !paramRequest.getUser().isSigned() ) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgUserHasNotPermissions")+"</div>");
            response.flushBuffer();
            return;
        }
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("these", this);
            dis.include(request, response);
        }catch(ServletException e) {
            log.error(e);
        }catch(IOException e) {
            log.error(e);
        }catch(NullPointerException e) {
            log.error(e);
        }
    }
    
    /**
     * @return the urlObjectivePage
     */
    public String getUrlObjectivePage() {
        return urlObjectivePage;
    }

    /**
     * @param urlObjectivePage the urlObjectivePage to set
     */
    private void setUrlObjectivePage(String urlObjectivePage) {
        this.urlObjectivePage = urlObjectivePage;
    }
}
