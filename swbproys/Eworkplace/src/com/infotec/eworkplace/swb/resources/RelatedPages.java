package com.infotec.eworkplace.swb.resources;

import com.infotec.eworkplace.swb.search.Search;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
    public static final int MX_DSPLY = 5;

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
        
        HashSet<Searchable> pages = new HashSet<Searchable>();
        List<WebPage> webPages = SWBFavoriteWebPagesResource.getFavorites(user, wsite);
        for(int i=0; i<webPages.size() && pages.size()<=MX_DSPLY; i++) {
            WebPage p = webPages.get(i);
            if(p!=null && p.getTags()!=null && p.isValid() && user.haveAccess(p)) {
                String[] tags = p.getTags().split(",");
                if(tags.length>0) {
                    Random r = new Random((new Date()).getTime());
                    int j = r.nextInt(tags.length); 
                    refs = search.x(wsite, tags[j].trim(), user);
                    if(refs!=null && refs.length>0) {
                        for(Searchable srch:refs) {
                            if(srch==null)
                                continue;
                            if(!(srch instanceof WebPage))
                                continue;
                            if(srch.equals(p))
                                continue;
                            pages.add(srch);
                            //parser = indexer.getParser(srch);
                            //htm.append("<li><a href=\""+parser.getUrl(srch)+"\" title=\"Ir a la referencia\">"+parser.getTitle(srch, lang)+"</a></li>");
                            break;
                        }            
                    }
                }
            }
        }
        Iterator<Searchable> it = pages.iterator();
        while(it.hasNext()) {
            Searchable srch = it.next();
            parser = indexer.getParser(srch);
            out.println("<li><a href=\""+parser.getUrl(srch)+"\" title=\"Ir a la referencia\">");
            try {
                out.println(parser.getTitle(srch, lang).substring(0,80));
            }catch(IndexOutOfBoundsException iobe) {
                out.println(parser.getTitle(srch, lang));
            }
            out.println("</a></li>"); 
        }
        //out.println(htm.toString());
    }
}
