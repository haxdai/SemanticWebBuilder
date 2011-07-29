package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


public class New extends org.semanticwb.promexico.base.NewBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(New.class, new NewParser());
    }

    public New(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
