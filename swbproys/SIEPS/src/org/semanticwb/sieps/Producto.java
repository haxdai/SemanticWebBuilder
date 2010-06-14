package org.semanticwb.sieps;

import org.semanticwb.SWBPortal;
import org.semanticwb.sieps.search.ProductoParser;


public class Producto extends org.semanticwb.sieps.base.ProductoBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Producto.class, new ProductoParser());
    }

    public Producto(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}