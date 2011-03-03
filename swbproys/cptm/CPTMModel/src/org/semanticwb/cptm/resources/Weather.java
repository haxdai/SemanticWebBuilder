package org.semanticwb.cptm.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.cptm.GeographicPoint;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 * @author carlos.ramos
 */
public class Weather extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Weather.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        WebPage currentPage = paramsRequest.getWebPage();
        String q = "NAM|MX|MX009|CIUDAD DE MEXICO|";
        String qPrev = null;
        String lang = paramsRequest.getUser().getLanguage();
        String uri = request.getParameter("uri");

        /*
         * actualmente implementado con accuweather. http://www.accuweather.com/
         */

        if (currentPage instanceof GeographicPoint) {
            GeographicPoint dest = (GeographicPoint) currentPage;
//            q = currentPage.getDisplayTitle(lang)+","+currentPage.getParent().getDisplayTitle(lang);
            qPrev = dest.getDestWeather();
        }

        if (qPrev != null && !qPrev.trim().equals("")) {
            q = qPrev;
        }
//        q = q.replaceAll(" ", "+");
        PrintWriter out = response.getWriter();
        out.println("<div class=\"weather\">");
        out.println("<div style='width: 180px; height: 150px; background-image: url( http://vortex.accuweather.com/adcbin/netweather_v2/backgrounds/silver_180x150_bg.jpg ); background-repeat: no-repeat; background-color: #86888B;' >");
        out.println("  <div id='NetweatherContainer' style='height: 138px;' >");
        out.println("    <script src='http://netweather.accuweather.com/adcbin/netweather_v2/netweatherV2ex.asp?partner=netweather&tStyle=whteYell&logo=1&zipcode="+q+"&lang=esp&size=8&theme=silver&metric=1&target=_new'></script>");
        out.println("  </div>");
        out.println("  <div style='text-align: center; font-family: arial, helvetica, verdana, sans-serif; font-size: 10px; line-height: 12px; color: #FFFFFF; background: #86888b' >");
        out.println("    <a style='color: #FFFFFF' href='http://www.accuweather.com/world-index-forecast.asp?partner=netweather&locCode="+q+"&metric=1' target=\"_new\">Weather Forecast</a>");
        out.println("  </div>");
        out.println("</div>");
        out.println("</div>");
//        out.println("<!-- Yahoo! Weather Badge  -->");
//        out.println("<iframe allowtransparency=\"true\" marginwidth=\"0\" marginheight=\"0\" hspace=\"0\" vspace=\"0\" frameborder=\"0\" scrolling=\"no\" src=\"http://mx.weather.yahoo.com/badge/?q=escape("+q+")&u=c&t=trans&l=vertical\" height=\"255px\" width=\"186px\">");
//        out.println("</iframe>");
//        out.println("<!-- Yahoo! Weather Badge  -->");
    }

}
