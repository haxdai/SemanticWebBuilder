/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.segob.pressroom.resources;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.resources.sem.pressroom.Category;
import org.semanticwb.portal.resources.sem.pressroom.Content;
import org.semanticwb.portal.resources.sem.pressroom.ContentPriority;

/**
 *
 * @author smp
 */
public class NoticiaPrincipal extends GenericResource {

    public static Logger log = SWBUtils.getLogger(ContentMgr.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        try {

            Content noticia = null;
            Category categoria = null;

            Iterator<ContentPriority> it = ContentPriority.ClassMgr.listContentPriorities();
            if (it.hasNext()) {

                Content destacada = it.next().getContentPriority();

                // está activa
                if (destacada.isActive()) {

                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");

                    Calendar start = Calendar.getInstance();
                    start.setTime(destacada.getStartDate());
                    start.set(Calendar.HOUR, 0);
                    start.set(Calendar.MINUTE, 0);
                    start.set(Calendar.SECOND, 0);
                    start.set(Calendar.MILLISECOND, 0);
                    //System.out.println(sdf.format(start.getTime()));

                    Calendar end = Calendar.getInstance();
                    end.setTime(destacada.getEndDate());
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

                        noticia = destacada;
                        categoria = noticia.getCategory();

                    }

                }


            }





            String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/Noticias/Portada.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            request.setAttribute("destacada", noticia);
            request.setAttribute("categoria", categoria);
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }


    }
}
