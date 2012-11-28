package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.PresentationParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Presentation extends com.infotec.conorg.base.PresentationBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Presentation.class, new PresentationParser());
        }
    }
        
    public Presentation(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
