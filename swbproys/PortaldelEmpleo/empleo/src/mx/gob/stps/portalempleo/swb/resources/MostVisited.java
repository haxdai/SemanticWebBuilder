package mx.gob.stps.portalempleo.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
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
    * @see Manual de implementación
    * @author  Carlos Ramos
    * @version 1.0
    */

public class MostVisited extends GenericResource {
    private static Logger log = SWBUtils.getLogger(MostVisited.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();

        WebPage node = paramRequest.getWebPage();
        if(node!=null) {
            Iterator<WebPage> childs = SortWebPage.sortByViews(node.listChilds(user.getLanguage(), true, false, false, true), false);
            for(int i=0; i<3 && childs.hasNext(); i++) {
                WebPage child = childs.next();
                if(child.isActive() && user.haveAccess(child)) {
                    out.println("<div class=\"esbozo\">");
                    out.println(" <h3>"+child.getDisplayTitle(lang)+"</h3>");
                    out.println(" <p>"+child.getDescription()+"</p>");
                    out.println(" <a class=\"ver_mas\" href=\""+child.getRealUrl()+"\">Leer más</a>");
                    out.println("</div>");
                }
            }
        }
    }

    /**
    * Permite ordenar WebPages, de acuerdo a diferentes criterios.
    * @see Manual de implementación
    * @author  Carlos Ramos
    * @version 1.0
    */
    public static class SortWebPage  {
        public static Iterator sortByViews(Iterator it, boolean ascendente) {
            return sortByViewsSet(it, ascendente).iterator();
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
    }
}