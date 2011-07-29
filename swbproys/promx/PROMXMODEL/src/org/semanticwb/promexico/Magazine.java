package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


public class Magazine extends org.semanticwb.promexico.base.MagazineBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Magazine.class, new MagazineParser());
    }

    public Magazine(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
