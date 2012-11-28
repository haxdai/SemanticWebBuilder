package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.BookParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Book extends com.infotec.conorg.base.BookBase 
{
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Book.class, new BookParser());
        }
    }
    public Book(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
