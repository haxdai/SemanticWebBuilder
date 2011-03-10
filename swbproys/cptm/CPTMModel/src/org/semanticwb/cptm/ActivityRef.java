package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;


   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public class ActivityRef extends org.semanticwb.cptm.base.ActivityRefBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(ActivityRef.class, new ActivityRefParser());
    }

    public ActivityRef(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
