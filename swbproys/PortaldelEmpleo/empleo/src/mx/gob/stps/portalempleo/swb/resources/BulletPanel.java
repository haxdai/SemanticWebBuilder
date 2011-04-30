package mx.gob.stps.portalempleo.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

    /**
    * Representa una estructura para organizar la información del portal que consiste en representar
     * cada canal, dentro del portal, con un punto. Cada punto despliega la siguiente información:
     * <ul>
     * <li>Título del canal
     * <li>Título de cada subsección del canal
     * <li>Una imagen asociada a la propiedad iconClass del canal
     * </ul>
     * BulletPanel es un recurso de estrategia dentro del ambiente de SemanticWebBuilder 4.0. 
     * BulletPanel no cuenta con una interfaz de administración. Se configura automáticamente de acuerdo a la
     * estructura del portal.
    * @author  Carlos Ramos
    * @version 1.0
    */

public class BulletPanel  extends GenericResource {
    private static Logger log = SWBUtils.getLogger(BulletPanel.class);

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
    }

    /**
     * Despliega la estructura html que representa el BulletPanel.
     * Mostrando, aleatoriamente, uno de los canales del portal.
     * El manejador del evento click del BulletPanel, está implementado con ajax para atenuar los
     * saltos al interactual con el recurso.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param response - el HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException - if paramRequest arroja una excepción de este tipo
     * @throws IOException - if request o response arroja una excepción de este tipo
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        List<WebPage> channels = SWBUtils.Collections.copyIterator(paramRequest.getWebPage().getWebSite().getHomePage().listChilds(null, true, false, false, true));
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        
        User user = paramRequest.getUser();
        String lang=user.getLanguage();
        WebSite wsite = paramRequest.getWebPage().getWebSite();

        String tpcId = request.getParameter("tpc");
        WebPage channel = wsite.getWebPage(tpcId);
        if(channel==null) {
            try {
                Random r = new Random((new Date()).getTime());
                channel = channels.get(r.nextInt(channels.size()));
            }catch(IndexOutOfBoundsException iobe) {
                out.println("No existen canales disponibles");
                return;
            }
        }

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
                    out.println("<li><a href=\""+wpage.getUrl()+"\">"+wpage.getDisplayTitle(lang)+"</a></li>");
                }
            }
            out.println(" </ul>");
            out.println("</div>");
        }

        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode(paramRequest.Mode_INDEX);
        out.println("<ul class=\"nav_caja\">");
        for(WebPage wp:channels) {
            url.setParameter("tpc", wp.getId());
            if(wp==channel)
                out.println("<li class=\"seleccionado\">"+wp.getId()+"</li>");
            else
                out.println("<li><a href=\"javascript:postHtml('"+url+"','caja')\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getId()+"</a></li>");
        }
        out.println("</ul>");
        out.println("<a href=\""+channel.getUrl()+"\" class=\"ver_mas_1\" >Ver m&aacute;s</a>");
        out.println("</div>");
    }

    /**
     * Despliega la estructura html que representa el BulletPanel. Response a una solicitud ajax
     * proviniente del manejador del evento click del BulletPanel.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param response - el HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException - if paramRequest arroja una excepción de este tipo
     * @throws IOException - if request o response arroja una excepción de este tipo
     */
    @Override
    public void doIndex(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        List<WebPage> channels = SWBUtils.Collections.copyIterator(paramRequest.getWebPage().getWebSite().getHomePage().listChilds(null, true, false, false, true));
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
                Random r = new Random((new Date()).getTime());
                channel = channels.get(r.nextInt(channels.size()));
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
                    out.println("<li><a href=\""+wpage.getUrl()+"\">"+wpage.getDisplayTitle(lang)+"</a></li>");
                }
            }
            out.println(" </ul>");
            out.println("</div>");
        }

        SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode(paramRequest.Mode_INDEX);
        out.println("<ul class=\"nav_caja\">");
        for(WebPage wp:channels) {
            url.setParameter("tpc", wp.getId());
            if(wp==channel)
                out.println("<li class=\"seleccionado\">"+wp.getId()+"</li>");
            else
                out.println("<li><a href=\"javascript:postHtml('"+url+"','caja')\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getId()+"</a></li>");
        }
        out.println("</ul>");
        out.println("<a href=\""+channel.getUrl()+"\" class=\"ver_mas_1\" >Ver m&aacute;s</a>");
    }
}
