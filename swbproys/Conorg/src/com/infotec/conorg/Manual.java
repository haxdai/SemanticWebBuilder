package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.ManualParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Manual extends com.infotec.conorg.base.ManualBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Manual.class, new ManualParser());
        }
    }
    public Manual(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
