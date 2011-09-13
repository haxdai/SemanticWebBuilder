package com.infotec.eworkplace.swb.resources;

import com.infotec.eworkplace.swb.search.Search;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.portal.resources.sem.favoriteWebPages.SWBFavoriteWebPagesResource;

/**
 *
 * @author carlos.ramos
 */


public class RelatedPages extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(RelatedPages.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        PrintWriter out =  response.getWriter();
        StringBuilder htm = new StringBuilder();
        
        User user = paramsRequest.getUser();
        WebPage wp = paramsRequest.getWebPage();
        WebSite wsite = base.getWebSite();
        
        SWBIndexer indexer = SWBPortal.getIndexMgr().getModelIndexer(wsite);
        Searchable[] refs;
        GenericParser parser;
        Search search = new Search();
        String lang = user.getLanguage();

        Iterator<WebPage> webPages = SWBFavoriteWebPagesResource.getFavWebPages(user, wsite).iterator();
        while(webPages.hasNext()) {
            WebPage p = webPages.next();
            if(p!=null && p.getTags()!=null && p.isValid() && user.haveAccess(p)) {
                String[] tags = p.getTags().split(",");           
                for(String t:tags) {
                    refs = search.x(wsite, t.trim(), user);
                    if(refs!=null && refs.length>0) {
                        //StringBuilder htm = new StringBuilder();
                        for(Searchable srch:refs) {
                            if(!(srch instanceof WebPage))
                                continue;
                            if(srch.equals(p))
                                continue;
                            parser = indexer.getParser(srch);
                            htm.append("<li><a href=\""+parser.getUrl(srch)+"\" title=\"Ir a la referencia\">"+parser.getTitle(srch, lang)+"</a></li>");
                        }            
                        //out.println(htm.toString());
                    }
                }
            }
        }
        out.println(htm.toString());
//        refs = search.x(wsite, "un token", user);
//        /*out.println("<div class=\"user_rel envolvente\">");
//        out.println("  <p class=\"title\">Esto puede interesarte:</p>");
//        out.println("  <ul>");*/
//        if(refs!=null && refs.length>0) {
//            StringBuilder htm = new StringBuilder();
//            for(Searchable srch:refs) {
//                if(srch.equals(wp))
//                    continue;
//                parser = indexer.getParser(srch);
//                htm.append("<li><a href=\""+parser.getUrl(srch)+"\" title=\"Ir a la referencia\">"+parser.getTitle(srch, lang)+"</a></li>");
//            }            
//            out.println(htm.toString());
//        }else {
//            out.println("<li><a href=\"#\">Sin referencias</a></li>");
//        }
//        /*out.println("  </ul>");
//        out.println("</div>");*/
        
    }
}
