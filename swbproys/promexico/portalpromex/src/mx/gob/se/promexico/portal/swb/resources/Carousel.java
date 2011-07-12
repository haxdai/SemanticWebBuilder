
package mx.gob.se.promexico.portal.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceSubType;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author carlos.ramos
 */
public class Carousel extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Carousel.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        User user = paramRequest.getUser();

        String promoStype = paramRequest.getArgument("promosubtype");
        //String promoStype = "home";
System.out.println("promoStype="+promoStype);

        ResourceSubType stype = base.getWebSite().getResourceSubType(promoStype);
System.out.println("stype="+stype);

        StringBuilder preload = new StringBuilder();
        StringBuilder script = new StringBuilder();
        int i=0;

        Iterator<Resource>it = stype.listResources();
        List<Resource> rs = SWBUtils.Collections.copyIterator(it);
        for(Resource res:rs) {
        //while (it.hasNext()) {
            //Resource res = it.next();
System.out.println("res"+res);
            if(res.isActive() && user.haveAccess(res)) {
//System.out.println("\n--------------------------------------");
//System.out.println("urlinfo="+res.getAttribute("urlinfo"));
//System.out.println("urldoc="+res.getAttribute("urldoc"));
//System.out.println("urlpromo="+res.getAttribute("urlpromo"));
//
//System.out.println("thmbn="+res.getAttribute("thumbnail"));
//System.out.println("alt="+res.getAttribute("alt"));
//
//System.out.println("poster="+res.getAttribute("poster"));
//System.out.println("title="+res.getAttribute("title"));
                preload.append("var imagen"+(i)+" = new Image(); imagen"+(i++)+".src = '"+SWBPortal.getWebWorkPath()+res.getWorkPath()+"/"+res.getAttribute("poster")+"';\n");
                script.append("<a href=\"javascript:nav('crwlr_bckg','"+SWBPortal.getWebWorkPath()+res.getWorkPath()+"/"+res.getAttribute("poster")+"','"+res.getAttribute("urlpromo")+"')\" title=\""+res.getAttribute("title")+"\" class=\"crwlr_a\"><img alt=\""+res.getAttribute("alt")+"\" class=\"crwlr_img\" src=\""+SWBPortal.getWebWorkPath()+res.getWorkPath()+"/"+res.getAttribute("thmbn")+"\" /></a>\n");
            }
        }
        out.println("<script type=\"text/javascript\">");
        out.println(preload.toString());

        out.println("  function nav(id, img, url) {");
        out.println("    obj = document.getElementById(id)");
        out.println("    if(obj) {");
        out.println("      obj.src=img;");
        out.println("	  obj.parentNode.href=url;");
        out.println("	}");
        out.println("  }");
        out.println("</script>");

        out.println("<div id=\"pm_carousel_slideshow\">");
        i=0;
        out.println("  <a href=\""+rs.get(i).getAttribute("urlpromo")+"\" class=\"crwlr_a\"><img class=\"crwlr_img\" src=\""+SWBPortal.getWebWorkPath()+rs.get(i).getWorkPath()+"/"+rs.get(i).getAttribute("poster")+"\" alt=\""+rs.get(i).getAttribute("alt")+"\" id=\"crwlr_bckg\"/></a>");
        out.println("  <div id=\"banners_100\">");
        out.println(script.toString());
//        out.println("    <a href=\"javascript:nav('crwlr_bckg','bmv.png','http://www.google.com')\" title=\"promexico\" class=\"crwlr_a\"><img class=\"crwlr_img\" src=\"thumb_bmv.png\" /></a>");
//        out.println("    <a href=\"javascript:nav('crwlr_bckg','estela.png','http://www.google.com')\" title=\"promexico\" class=\"crwlr_a\"><img class=\"crwlr_img\" src=\"thumb_globo.png\" /></a>");
//        out.println("    <a href=\"javascript:nav('crwlr_bckg','ballena.png','http://www.google.com')\" title=\"promexico\" class=\"crwlr_a\"><img class=\"crwlr_img\" src=\"thumb_loro.png\" /></a>");
//        out.println("    <a href=\"javascript:nav('crwlr_bckg','starshiptroopers.png','http://www.google.com')\" title=\"promexico\" class=\"crwlr_a\"><img class=\"crwlr_img\" src=\"thumb_playa.png\" /></a>");
//        out.println("    <a href=\"javascript:nav('crwlr_bckg','cocona.png','http://www.google.com')\" title=\"promexico\" class=\"crwlr_a\"><img class=\"crwlr_img\" src=\"thumb_arcoiris.png\" /></a>");
        out.println("  </div>");
//        out.println("  <div class=\"msg\">");
//        out.println("    <div class=\"more\"><a href=\"#\" class=\"crwlr_a\">Empresa Exportadora</a></div>");
//        out.println("    <div class=\"more\"><a href=\"#\" class=\"crwlr_a\">Inicio a la Exportación</a></div>");
//        out.println("  </div>");
        out.println("</div>");

        out.println("<script type=\"text/javascript\">");
        out.println("  marqueeInit({");
        out.println("	uniqueid: 'banners_100',");
        out.println("	style: {");
        out.println("		'width': '408px',");
        out.println("		'height': '100px',");
        out.println("	},");
        out.println("	inc: 5,");
        out.println("	mouse: 'cursor driven',");
        out.println("	moveatleast: 0,");
        out.println("	neutral: 250,");
        out.println("	savedirection: false,");
        out.println("	random: true,");
        out.println("	stopped: true,");
        out.println("	noAddedSpace: true");
        out.println("  });");
        out.println("</script>");
    }
}
