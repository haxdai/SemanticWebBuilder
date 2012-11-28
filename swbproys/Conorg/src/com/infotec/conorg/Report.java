package com.infotec.conorg;

import com.infotec.conorg.indexer.parser.ReportParser;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.indexer.SWBIndexer;


public class Report extends com.infotec.conorg.base.ReportBase 
{
    
    static {
        SWBIndexer index=SWBPortal.getIndexMgr().getDefaultIndexer();
        if(index!=null) {
            index.registerParser(Report.class, new ReportParser());
        }
    }
    
    public Report(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
