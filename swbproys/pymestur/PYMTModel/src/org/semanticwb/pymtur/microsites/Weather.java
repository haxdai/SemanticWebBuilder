package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.pymtur.Destination;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

/**
 * @author carlos.ramos
 */
public class Weather extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Weather.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        WebPage currentPage = paramsRequest.getWebPage();
        String q = "Ciudad de México";

        if( currentPage instanceof Destination ) {
            currentPage = (Destination)currentPage;
            q = currentPage.getDisplayTitle(paramsRequest.getUser().getLanguage());
        }else if( currentPage instanceof MicroSitePyme || currentPage.getParent() instanceof MicroSitePyme ) {
            MicroSitePyme ms;
            try {
                ms = (MicroSitePyme)currentPage;
            }catch(ClassCastException cce) {
                ms = (MicroSitePyme)currentPage.getParent();
            }
            ServiceProvider sprovider = ms.getServiceProvider();
            q = sprovider.getDestination().getDisplayTitle(paramsRequest.getUser().getLanguage());
        }
        
        PrintWriter out = response.getWriter();
        out.println("<!-- Yahoo! Weather Badge  -->");
        out.println("<iframe allowtransparency=\"true\" marginwidth=\"0\" marginheight=\"0\" hspace=\"0\" vspace=\"0\" frameborder=\"0\" scrolling=\"no\" src=\"http://mx.weather.yahoo.com/badge/?q="+q+"&u=c&t=trans&l=vertical\" height=\"255px\" width=\"186px\">");
        out.println("</iframe>");
        out.println("<!-- Yahoo! Weather Badge  -->");
    }

}
