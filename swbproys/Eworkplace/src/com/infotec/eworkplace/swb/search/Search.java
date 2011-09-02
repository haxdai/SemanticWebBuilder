package com.infotec.eworkplace.swb.search;

import java.util.*;
import java.util.Collections;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.portal.indexer.searcher.SearchDocument;
import org.semanticwb.portal.indexer.searcher.SearchQuery;
import org.semanticwb.portal.indexer.searcher.SearchResults;
import org.semanticwb.portal.indexer.searcher.SearchTerm;

    /**
    * Define los mecanismos para buscar determinados tokens dentro de la base de
    * datos una instancia de SemanticWebBuilder 4
    * @author  Carlos Ramos
    * @version 1.0
    */

public class Search {

    /**
     * Busca el token especificado dentro de la base de datos indexada de SemanticWebBuilder 4.0.
     * @param wsite - El modelo semántico o sitio web definido dentro de un ambiente de SemanticWebBuilder 4.0
     * @param q - El token a buscar
     * @param user - El usuario con el que se busca el token dentro del índice de la base de datos de SemanticWebBuilder.
     * @return - Un arreglo Searchable
     */
    public Searchable[] x(WebSite wsite, String q, User user) {
        Set<Searchable> uris = new HashSet<Searchable>();

        SearchQuery query=new SearchQuery();
        SearchTerm st1 = new SearchTerm(SWBIndexer.ATT_TAGS, q, SearchTerm.OPER_AND);
        query.addTerm(st1);

        SearchQuery tquery=new SearchQuery(SearchQuery.OPER_AND);
        SearchTerm st2 = new SearchTerm(SWBIndexer.ATT_CLASS, "WebPage", SearchTerm.OPER_OR);
        //SearchTerm st3 = new SearchTerm(SWBIndexer.ATT_CLASS, "Resource", SearchTerm.OPER_OR);
        tquery.addTerm(st2);
        //tquery.addTerm(st3);

        query.addQuery(tquery);
        
        SWBIndexer indexer = SWBPortal.getIndexMgr().getModelIndexer(wsite);
        if(indexer!=null) {
            SearchResults results = indexer.search(query, user);

            Iterator<SearchDocument>it = results.listDocuments();
            while(it.hasNext()) {
                SearchDocument obj = it.next();
                Searchable srch = obj.getSearchable();

                GenericParser parser=indexer.getParser(srch);
                uris.add(srch);
            }
        }
        Searchable[]res=new Searchable[uris.size()];
        uris.toArray(res);
        return res;
    }
}
