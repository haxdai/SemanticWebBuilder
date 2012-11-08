package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.TileParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Document extends com.infotec.conorg.base.DocumentBase 
{
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Document.class, new DocumentParser());
        }
    }
    public Document(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
