package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.ChapterBookParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class ChapterBook extends com.infotec.conorg.base.ChapterBookBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(ChapterBook.class, new ChapterBookParser());
        }
    }
    public ChapterBook(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
