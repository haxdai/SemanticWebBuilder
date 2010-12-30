/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.segob.pressroom.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.resources.sem.pressroom.Category;
import org.semanticwb.portal.resources.sem.pressroom.Content;

/**
 *
 * @author smp
 */
public class Noticias extends GenericResource {

    public static Logger log = SWBUtils.getLogger(Noticias.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String uri = request.getParameter("uri");
        String uriCat = request.getParameter("cat");

        Content noticia = null;
        Category categoria = null;

        //System.out.println("uri: " + uri);
        if (uri != null) {
            SemanticObject sObj = SemanticObject.createSemanticObject(uri);

            //if (sObj == null) {
            //    uri = URLEncoder.encode(uri);
            //    System.out.println("URLEncoder.encode(uri): " + uri);
            //    sObj = SemanticObject.createSemanticObject(uri);
            //}
            //System.out.println("sObj: " + sObj);

            if (sObj != null) {
                noticia = (Content) sObj.createGenericInstance();
            }
        }

        //System.out.println("uriCat: " + uriCat);
        if (uriCat != null) {
            SemanticObject sObj = SemanticObject.createSemanticObject(uriCat);

            //if (sObj == null) {
            //    uriCat = URLEncoder.encode(uriCat);
            //    System.out.println("URLEncoder.encode(uriCat): " + uriCat);
            //    sObj = SemanticObject.createSemanticObject(uriCat);
            //}
            //System.out.println("sObj: " + sObj);

            if (sObj != null) {
                categoria = (Category) sObj.createGenericInstance();
            }
        }

        //System.out.println("noticia: " + noticia);
        //System.out.println("categoria: " + categoria);

        if (noticia != null && categoria != null) {
            doNoticia(request, response, paramRequest, noticia, categoria);
        } else {
            doListado(request, response, paramRequest);
        }

    }

    private void doNoticia(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, Content noticia, Category categoria) {

        try {

            boolean showNoticia = false;



            // está activa
            if (noticia.isActive() && categoria.isActive()) {

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
                    showNoticia = true;
                }

            } // if (noticia.isActive() && categoria.isActive()) {

            if (!showNoticia) {
                doListado(request, response, paramRequest);
            } else {

                String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/Noticias/Noticia.jsp";
                RequestDispatcher dis = request.getRequestDispatcher(path);
                request.setAttribute("noticia", noticia);
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);

            }

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            log.error(e);
        }

    }

    private void doListado(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {

        try {

            List<Content> allNoticias = new ArrayList<Content>();
            Category cati = null;

            SWBResourceURL url = paramRequest.getRenderUrl();
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
                        //System.out.println("si esta el comentario");

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

            // ordenarlas descendentemente por fecha de inicio de publicacion
            Collections.sort(allNoticias, new Comparator() {

                public int compare(Object o1, Object o2) {
                    Content p1 = (Content) o1;
                    Content p2 = (Content) o2;
                    return -(new Long(p1.getStartDate().getTime()).compareTo(new Long(p2.getStartDate().getTime())));
                }
            });

            // JFMR paginacion -----------------------------------------------------------------------------------------------------------------------------------------
            int pages2show = 5; // cuantas paginas mostrar a cada lado de la current page
            int pageLen = 5; // cuantos registros por pagina mostrar
            int idx = 0;
            int page = 1;
            int totPages = (int) Math.ceil((double) allNoticias.size() / (double) pageLen);
            if (request.getParameter("page") == null) {
                Object prcp = request.getSession().getAttribute("PRNoticiasCurrentPage");
                if (prcp != null) {
                    page = ((Integer) prcp).intValue();
                }
            } else {
                try {
                    page = Integer.parseInt(request.getParameter("page"));
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Error in CategoryMgr's view mode", e);
                }
            }
            if (page < 1 || page > totPages) {
                page = 1;
            }
            idx = (page - 1) * pageLen;
            int idxEnd = idx + pageLen;
            int i = 0;
            List<Content> cats = new ArrayList<Content>();
            for (Content category : allNoticias) {
                if (i >= idx && i < idxEnd) {
                    cats.add(category);
                }
                if (i >= idxEnd) {
                    break;
                }
                i++;
            }
            Iterator<Content> noticiasIt = cats.iterator();
            request.getSession().setAttribute("PRNoticiasCurrentPage", new Integer(page));
            request.setAttribute("pag_pages2show", new Integer(pages2show));
            request.setAttribute("pag_totPages", new Integer(totPages));
            request.setAttribute("pag_curPage", new Integer(page));
            request.setAttribute("noticiasIt", noticiasIt);
            //request.setAttribute("ca", noticiasIt);
            // JFMR paginacion -----------------------------------------------------------------------------------------------------------------------------------------


            String path = "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/pressroom/Noticias/Listado.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }

    }

    public void doRss(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {


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
                    //int i = 0;
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
                                //i++;
                            }

                            //if (i >= 100) {
                            //    break;
                            //}

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


            /*
            out.println("<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>");
            out.println("<rss version=\"2.0\">");
            out.println("<channel>");
            out.println("<title>SEGOB - Síntesis Informativa</title>");
            out.println("<description>SEGOB - Síntesis Informativa</description>");
            out.println("<link>" + paramRequest.getWebPage().getUrl() + "/es/" + paramRequest.getWebPage().getWebSiteId() + "/Sintesis_Informativa</link>");
            out.println("<lastBuildDate>24/08/2010</lastBuildDate>");
            out.println("<pubDate>24/08/2010</pubDate>");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Content noticia : allNoticias) {
            out.println("<item>");
            out.println("<title>" + SWBUtils.XML.replaceXMLChars(noticia.getTitle()) + "</title>");
            out.println("<description>" + SWBUtils.XML.replaceXMLChars(noticia.getDescription()) + "</description>");
            out.println("<link>" + paramRequest.getWebPage().getUrl() + "/es/" + paramRequest.getWebPage().getWebSiteId() + "/Sintesis_Informativa?uri=" + noticia.getEncodedURI() + "&cat=" + noticia.getCategory().getEncodedURI() + "</link>");
            out.println("<pubDate>" + sdf.format(noticia.getStartDate()) + "</pubDate>");
            out.println("</item>");
            }
            out.println("</channel>");
            out.println("</rss>");
             */

        } catch (Exception e) {
            log.error(e);
        }


    }

    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        if (paramRequest.getMode().equalsIgnoreCase("rss")) {
            doRss(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
}
