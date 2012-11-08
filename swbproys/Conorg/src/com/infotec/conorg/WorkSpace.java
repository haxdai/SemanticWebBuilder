package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.WorkSpaceParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class WorkSpace extends com.infotec.conorg.base.WorkSpaceBase 
{
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(WorkSpace.class, new WorkSpaceParser());
        }
    }
    
    public WorkSpace(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
