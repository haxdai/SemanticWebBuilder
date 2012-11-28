package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.VideoParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Video extends com.infotec.conorg.base.VideoBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Video.class, new VideoParser());
        }
    }
    public Video(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
