package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


public class ProMxVideo extends org.semanticwb.promexico.base.ProMxVideoBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(ProMxVideo.class, new ProMxVideoParser());
    }

    public ProMxVideo(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
