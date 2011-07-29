package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


   /**
   * Preguntas Frecuentes 
   */
public class Faq extends org.semanticwb.promexico.base.FaqBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Faq.class, new FaqParser());
    }

    public Faq(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
