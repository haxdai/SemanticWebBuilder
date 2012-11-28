package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.ArticleParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Article extends com.infotec.conorg.base.ArticleBase 
{
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Article.class, new ArticleParser());
        }
    }
    public Article(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
