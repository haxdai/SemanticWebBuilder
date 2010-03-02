package org.semanticwb.pymtur;

import org.semanticwb.SWBPortal;


public class Destination extends org.semanticwb.pymtur.base.DestinationBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Destination.class, new DestinationParser());
    }

    public Destination(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
