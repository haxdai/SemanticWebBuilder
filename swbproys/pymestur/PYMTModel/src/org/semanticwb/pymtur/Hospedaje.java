package org.semanticwb.pymtur;

import org.semanticwb.SWBPortal;


public class Hospedaje extends org.semanticwb.pymtur.base.HospedajeBase 
{
    static {
        System.out.println(":::Llamando a registro de directory object parser");
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Hospedaje.class, new HospedajeParser());
    }

    public Hospedaje(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
