/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.segob.pressroom.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.resources.sem.pressroom.Category;
import org.semanticwb.portal.resources.sem.pressroom.Content;

/**
 *
 * @author smp
 */
public class Rss extends GenericResource {

    public static Logger log = SWBUtils.getLogger(Rss.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        try {

            //Resource base = paramRequest.getResourceBase();
            //PrintWriter out = response.getWriter();
            //paramRequest.getWebPage().getTemplateRef().removeTemplate();

            List<Content> allNoticias = new ArrayList<Content>();
            Category cati = null;

            //SWBResourceURL url = paramRequest.getRenderUrl();
            WebPage wp = paramRequest.getWebPage();
            Iterator<Category> it2 = Category.ClassMgr.listCategories(wp.getWebSite());
            while (it2.hasNext()) {
                cati = it2.next();

                if (cati.isActive()) {

                    Iterator<Content> it = cati.listContents();
                    //if (it.hasNext()) {
                    //    it = SWBComparator.sortByCreated(it, false);
                    //}
                    while (it.hasNext()) {

                        Content noticia = it.next();
                        //noticia.setCategory(cati);

                        // está activa
                        if (noticia.isActive()) {

                            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");

                            Calendar start = Calendar.getInstance();
                            start.setTime(noticia.getStartDate());
                            start.set(Calendar.HOUR, 0);
                            start.set(Calendar.MINUTE, 0);
                            start.set(Calendar.SECOND, 0);
                            start.set(Calendar.MILLISECOND, 0);
                            //System.out.println(sdf.format(start.getTime()));

                            Calendar end = Calendar.getInstance();
                            end.setTime(noticia.getEndDate());
                            end.set(Calendar.HOUR, 0);
                            end.set(Calendar.MINUTE, 0);
                            end.set(Calendar.SECOND, 0);
                            end.set(Calendar.MILLISECOND, 0);
                            end.add(Calendar.DATE, 1);
                            end.add(Calendar.MILLISECOND, -1);
                            //System.out.println(sdf.format(end.getTime()));

                            Calendar now = Calendar.getInstance();
                            //System.out.println(sdf.format(now.getTime()));

                            // está dentro del rango de fechas de publicación
                            if (now.getTimeInMillis() >= start.getTimeInMillis() && now.getTimeInMillis() <= end.getTimeInMillis()) {
                                allNoticias.add(noticia);
                            }

                        }
                    }

                } //if(cati.isActive()){

            }




            String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/Noticias/ListadoRss.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("noticiasIt", allNoticias.iterator());
            response.setHeader("Content-Type", "application/xml; charset=ISO-8859-1");
            dis.include(request, response);




        } catch (Exception e) {
            log.error(e);
        }

    }
}

