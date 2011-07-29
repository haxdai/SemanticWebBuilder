package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


public class Sector extends org.semanticwb.promexico.base.SectorBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Sector.class, new SectorParser());
    }

    public Sector(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
