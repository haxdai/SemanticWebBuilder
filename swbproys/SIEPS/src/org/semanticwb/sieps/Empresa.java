package org.semanticwb.sieps;

import org.semanticwb.SWBPortal;
import org.semanticwb.sieps.search.EmpresaParser;


public class Empresa extends org.semanticwb.sieps.base.EmpresaBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Empresa.class, new EmpresaParser());
    }

    public Empresa(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}