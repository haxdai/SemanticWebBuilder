package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.ReferenceParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Reference extends com.infotec.conorg.base.ReferenceBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Reference.class, new ReferenceParser());
        }
    }
    
    public Reference(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
