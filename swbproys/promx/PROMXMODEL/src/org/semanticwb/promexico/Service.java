package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


   /**
   * Servicios 
   */
public class Service extends org.semanticwb.promexico.base.ServiceBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Service.class, new ServiceParser());
    }

    public Service(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
