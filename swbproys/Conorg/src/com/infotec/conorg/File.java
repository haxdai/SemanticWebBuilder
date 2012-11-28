package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.FileParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class File extends com.infotec.conorg.base.FileBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(File.class, new FileParser());
        }
    }
    
    public File(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
}
