package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.AudioParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Audio extends com.infotec.conorg.base.AudioBase 
{
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Audio.class, new AudioParser());
        }
    }
    public Audio(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
