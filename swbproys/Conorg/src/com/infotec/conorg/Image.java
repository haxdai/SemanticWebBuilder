package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.ImageParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Image extends com.infotec.conorg.base.ImageBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Image.class, new ImageParser());
        }
    }
    
    public Image(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
