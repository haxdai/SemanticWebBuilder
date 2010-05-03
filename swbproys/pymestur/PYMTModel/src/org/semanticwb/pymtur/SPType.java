package org.semanticwb.pymtur;

import org.semanticwb.SWBPortal;


public class SPType extends org.semanticwb.pymtur.base.SPTypeBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(SPType.class, new SPTypeParser());
    }

    public SPType(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
