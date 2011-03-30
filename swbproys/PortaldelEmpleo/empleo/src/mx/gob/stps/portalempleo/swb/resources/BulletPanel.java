package mx.gob.stps.portalempleo.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

public class BulletPanel  extends GenericResource {
    private static Logger log = SWBUtils.getLogger(MostVisited.class);
    private List<WebPage>channels;

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        channels = SWBUtils.Collections.copyIterator(base.getWebSite().getHomePage().listChilds(null, true, false, false, true));
    }


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        
        User user = paramRequest.getUser();
        String lang=user.getLanguage();
        WebSite wsite = paramRequest.getWebPage().getWebSite();

        //List<WebPage>channels = SWBUtils.Collections.copyIterator(wsite.getHomePage().listChilds(lang, true, false, false, true));
        String tpcId = request.getParameter("tpc");
        WebPage channel = wsite.getWebPage(tpcId);
        if(channel==null) {
            try {
                channel = channels.get(0);
            }catch(IndexOutOfBoundsException iobe) {
                out.println("No existen canales disponibles");
                return;
            }
        }
        //channels.remove(channel);

        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.require('dijit.dijit');");
        out.println("-->");
        out.println("</script>");
        out.println("<div id=\"caja\">");
        WebPage wpage;
        Iterator<WebPage>childs = MostVisited.SortWebPage.sortByViews(channel.listChilds(user.getLanguage(), true, false, false, true), false);
        if(childs.hasNext()) {
            out.println("<div class=\""+channel.getId()+"\">");
            out.println("<h3>"+channel.getDisplayTitle(lang)+"</h3>");
            out.println(" <ul class=\"contenido_caja\">");
            for(int i=0; i<5 && childs.hasNext(); i++) {
                wpage = childs.next();
                if(user.haveAccess(wpage)) {
                    out.println("<li><a href=\""+wpage.getRealUrl(lang)+"\">"+wpage.getDisplayTitle(lang)+"</a></li>");
                }
            }
            out.println(" </ul>");
            out.println("</div>");
        }

        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode(paramRequest.Mode_INDEX);
        out.println("<ul class=\"nav_caja\">");
        for(WebPage wp:channels) {
            url.setParameter("tpc", wp.getId());
            //out.println("<li><a href=\"#\" onclick=\"postHtml('"+url+"','caja')\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getId()+"</a></li>");
            out.println("<li><a href=\"javascript:postHtml('"+url+"','caja')\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getId()+"</a></li>");
        }
        out.println("</ul>");
        out.println("<a href=\""+channel.getRealUrl(lang)+"\" class=\"ver_mas_1\" >Ver m&aacute;s</a>");
        out.println("</div>");
    }

    @Override
    public void doIndex(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();

        User user = paramRequest.getUser();
        String lang=user.getLanguage();
        WebSite wsite = paramRequest.getWebPage().getWebSite();

        //List<WebPage>channels = SWBUtils.Collections.copyIterator(wsite.getHomePage().listChilds(lang, true, false, false, true));
        String tpcId = request.getParameter("tpc");
        WebPage channel = wsite.getWebPage(tpcId);
        if(channel==null) {
            try {
                channel = channels.get(0);
            }catch(IndexOutOfBoundsException iobe) {
                out.println("No existen canales disponibles");
                return;
            }
        }
        //channels.remove(channel);
        
        WebPage wpage;
        Iterator<WebPage>childs = MostVisited.SortWebPage.sortByViews(channel.listChilds(user.getLanguage(), true, false, false, true), false);
        if(childs.hasNext()) {
            out.println("<div class=\""+channel.getId()+"\">");
            out.println("<h3>"+channel.getDisplayTitle(lang)+"</h3>");
            out.println(" <ul class=\"contenido_caja\">");
            for(int i=0; i<5 && childs.hasNext(); i++) {
                wpage = childs.next();
                if(user.haveAccess(wpage)) {
                    out.println("<li><a href=\""+wpage.getRealUrl(lang)+"\">"+wpage.getDisplayTitle(lang)+"</a></li>");
                }
            }
            out.println(" </ul>");
            out.println("</div>");
        }

        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode(paramRequest.Mode_INDEX);
        out.println("<ul class=\"nav_caja\">");
        for(WebPage wp:channels) {
            url.setParameter("tpc", wp.getId());
            //out.println("<li><a href=\"#\" onclick=\"postHtml('"+url+"','caja')\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getId()+"</a></li>");
            out.println("<li><a href=\"javascript:postHtml('"+url+"','caja')\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getId()+"</a></li>");
        }
        out.println("</ul>");
        out.println("<a href=\""+channel.getRealUrl(lang)+"\" class=\"ver_mas_1\" >Ver m&aacute;s</a>");
    }
}
