package mx.gob.sep.portal.swb.becas.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

    /**
    * Representa una estructura para organizar la información del portal que consiste en representar
     *  una lista de secciones más visitas. Este recurso funciona para cualquier sección que tenga subsecciones.
     * <ul>
     * <li>Título del canal
     * <li>Título de cada subsección del canal
     * <li>Una imagen asociada a la propiedad iconClass del canal
     * </ul>
     * Recommended es un recurso de estrategia dentro del ambiente de SemanticWebBuilder 4.0.
     * Recommended cuenta con una interfaz de administración.
    * @author  Carlos Ramos
    * @version 1.0
    */

public class MostVisited extends GenericResource {
    private static Logger log = SWBUtils.getLogger(MostVisited.class);

    /**
     * Despliega la estructura html que representa el recurso MostVisited,
     * mostrando la lista de subsecciones más visitadas, ordenadas descendentemente. Este recurso se limita a mostrar las 3 subsecciones más
     * visitadas de la sección que contiene a la instancia de este recurso.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param response - el HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException - if paramRequest arroja una excepción de este tipo
     * @throws IOException - if request o response arroja una excepción de este tipo
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();

        WebPage node = paramRequest.getWebPage();
        WebPage home = base.getWebSite().getHomePage();
        if(node.equals(home)) {
            out.println("<div class=\"bloque\">");
            out.println("<h2 class=\"tweets\">"+base.getDisplayTitle(lang) +"</h2>");
            Iterator<WebPage> childs = SortWebPage.sortByViews(WebPage.ClassMgr.listWebPages(base.getWebSite()), false);
            for(int i=0; i<4 && childs.hasNext(); i++) {
                WebPage wp = childs.next();
                if(wp.isValid() && user.haveAccess(wp)) {
                    out.println("<div class=\"tweet\">");
                    out.println(" <a href=\""+wp.getRealUrl()+"\" title=\"ir a "+(wp.getDisplayTitle(lang)==null?wp.getTitle():wp.getDisplayTitle(lang))+"\">"+(wp.getDisplayTitle(lang)==null?wp.getTitle():wp.getDisplayTitle(lang))+"</a>");
                    out.println(" <p>"+(wp.getDisplayDescription(lang)==null?wp.getDescription():wp.getDisplayDescription(lang))+"</p>");
                    out.println(" <div style=\"clear:both;\"></div>");
                    out.println("</div>");
                }
            }
            out.println("</div>");
        }else {
            out.println("<div class=\"TabbedPanelsContent\">");
            Iterator<WebPage> childs = SortWebPage.sortByCreated(WebPage.ClassMgr.listWebPages(base.getWebSite()), false);
            for(int i=0; i<6 && childs.hasNext(); i++) {
                WebPage wp = childs.next();
                if(wp.isValid() && user.haveAccess(wp)) {
                    out.println(" <a href=\""+wp.getRealUrl()+"\" class=\"nota\" title=\"ir a "+(wp.getDisplayTitle(lang)==null?wp.getTitle():wp.getDisplayTitle(lang))+"\">"+(wp.getDisplayTitle(lang)==null?wp.getTitle():wp.getDisplayTitle(lang))+"</a>");
                    out.println(" <p>"+(wp.getDisplayDescription(lang)==null?wp.getDescription():wp.getDisplayDescription(lang))+"</p>");
                }
            }
            out.println("</div>");
            out.println("<div class=\"TabbedPanelsContent\">");
            childs = SortWebPage.sortByViews(WebPage.ClassMgr.listWebPages(base.getWebSite()), false);
            for(int i=0; i<6 && childs.hasNext(); i++) {
                WebPage wp = childs.next();
                if(wp.isValid() && user.haveAccess(wp)) {
                    out.println(" <a href=\""+wp.getRealUrl()+"\" class=\"nota\" title=\"ir a "+(wp.getDisplayTitle(lang)==null?wp.getTitle():wp.getDisplayTitle(lang))+"\">"+(wp.getDisplayTitle(lang)==null?wp.getTitle():wp.getDisplayTitle(lang))+"</a>");
                    out.println(" <p>"+(wp.getDisplayDescription(lang)==null?wp.getDescription():wp.getDisplayDescription(lang))+"</p>");
                }
            }
            out.println("</div>");
        }
    }

    /**
    * Permite ordenar WebPages, de acuerdo a diferentes criterios.
    * @author  Carlos Ramos
    * @version 1.0
    */
    public static class SortWebPage  {
        public static Iterator sortByViews(Iterator it, boolean ascendente) {
            return sortByViewsSet(it, ascendente).iterator();
        }
        
        public static Iterator sortByCreated(Iterator it, boolean ascendente) {
            return sortByCreatedSet(it, ascendente).iterator();
        }

        /**
         * Ordena un iterador de WebPage de acuerdo al número de visitas
         * @param it - El iterador de WebPage
         * @param ascendente - Si es true, el ordenamiento se hace ascendente. De lo contrario se hace descendiente.
         * @return Un conjunto de WebPage ordenadas ascendente o descendentemente de acuerdo al su número de visitas.
         */
        public static Set sortByViewsSet(Iterator it, boolean ascendente) {
            TreeSet set = null;
            if(ascendente) {
                set = new TreeSet(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof WebPage && o2 instanceof WebPage) {
                            long v1 = ((WebPage)o1).getViews();
                            long v2 = ((WebPage)o2).getViews();
                            return v1 > v2 ? 1 : -1;
                        }
                        return 0;
                    }
                });
            }else {
                set = new TreeSet(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof WebPage && o2 instanceof WebPage) {
                            long v1 = ((WebPage)o1).getViews();
                            long v2 = ((WebPage)o2).getViews();
                            return v1 > v2 ? -1 : 1;
                        }
                        return 0;
                    }
                });
            }

            while (it.hasNext()) {
                set.add(it.next());
            }
            return set;
        }
        
        public static Set sortByCreatedSet(Iterator it, boolean ascendente) {
            TreeSet set = null;
            if(ascendente) {
                set = new TreeSet(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof WebPage && o2 instanceof WebPage) {
                            Date v1 = ((WebPage)o1).getCreated();
                            Date v2 = ((WebPage)o2).getCreated();
                            return v1.compareTo(v2);
                        }
                        return 0;
                    }
                });
            }else {
                set = new TreeSet(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof WebPage && o2 instanceof WebPage) {
                            Date v1 = ((WebPage)o1).getCreated();
                            Date v2 = ((WebPage)o2).getCreated();
                            return v1.compareTo(v2);
                        }
                        return 0;
                    }
                });
            }

            while (it.hasNext()) {
                set.add(it.next());
            }
            return set;
        }
    }
}