/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.gob.stps.portalempleo.swb.filter;

import java.util.Iterator;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.searcher.SearchDocument;
import org.semanticwb.portal.indexer.searcher.SearchQuery;
import org.semanticwb.portal.indexer.searcher.SearchResults;
import org.semanticwb.portal.indexer.searcher.SearchTerm;

/**
 *
 * @author carlos.ramos
 */
public class Search {


    public void x(WebSite wsite, Resource base, String q, User user) {
//        String[] tokens = base.getTags().split(",");
//
//        SearchQuery query=new SearchQuery();
//        SearchTerm st = new SearchTerm(SWBIndexer.ATT_TAGS, q, SearchTerm.OPER_OR);
//        query.addTerm(st);
//        SWBIndexer indexer = SWBPortal.getIndexMgr().getModelIndexer(wsite);
//        if(indexer!=null) {
//            SearchResults results = indexer.search(query, user);
//
//            Iterator<SearchDocument>it=results.listDocuments(ipage);
//            while(it.hasNext()) {
//
//            }
//        }
    }
}
