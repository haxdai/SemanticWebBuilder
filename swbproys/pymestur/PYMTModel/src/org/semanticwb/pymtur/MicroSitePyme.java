package org.semanticwb.pymtur;

import org.semanticwb.SWBPortal;



public class MicroSitePyme extends org.semanticwb.pymtur.base.MicroSitePymeBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(MicroSitePyme.class, new MicroSiteParser());
    }

    public MicroSitePyme(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
