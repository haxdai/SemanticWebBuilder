/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.MiPymeSite;
import org.semanticwb.pymtur.MiPymeSitePlus;
import org.semanticwb.pymtur.MicroSitePyme;

/**
 *
 * @author jorge.jimenez
 */
public class Surroundings extends GenericResource{

    private static Logger log = SWBUtils.getLogger(Surroundings.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        RequestDispatcher dis = null;
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = null;
        if (wp instanceof MicroSitePyme) {
            community = wp;
            System.out.println("Es instancia de MicroSitePyme");
        } else {
            community = wp.getParent();
            System.out.println("No es instancia de MicroSitePyme");
        }
        String siteUri = ((MicroSitePyme) community).getType().getURI();
        
        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
            path = "/work/models/etour/jsp/pymestur/microsite/surroundings.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            path = "/work/models/etour/jsp/pymestur/premier/surroundings.jsp";
        }
        dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

}
/*
         WebPage community = null;
        WebPage currentpage = (WebPage) request.getAttribute("webpage");
        if(currentpage == null) {
            currentpage = paramRequest.getWebPage();
        }
        if(currentpage instanceof MicroSitePyme) {
            community = currentpage;
        }else {
            community = currentpage.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
*/