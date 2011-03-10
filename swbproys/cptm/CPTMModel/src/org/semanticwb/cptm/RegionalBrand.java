package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;


   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya) 
   */
public class RegionalBrand extends org.semanticwb.cptm.base.RegionalBrandBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(RegionalBrand.class, new LocalityParser()); //Registra Parser
    }

    public RegionalBrand(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

}
