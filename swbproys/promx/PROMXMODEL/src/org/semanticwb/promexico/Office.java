package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


   /**
   * Objeto controlador de oficinas 
   */
public class Office extends org.semanticwb.promexico.base.OfficeBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Office.class, new OfficeParser());
    }

    public Office(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
