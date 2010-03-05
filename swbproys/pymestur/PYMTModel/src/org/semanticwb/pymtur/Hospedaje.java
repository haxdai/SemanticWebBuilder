package org.semanticwb.pymtur;

import org.semanticwb.SWBPortal;


public class Hospedaje extends org.semanticwb.pymtur.base.HospedajeBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Hospedaje.class, new HospedajeParser());
    }

    public Hospedaje(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
