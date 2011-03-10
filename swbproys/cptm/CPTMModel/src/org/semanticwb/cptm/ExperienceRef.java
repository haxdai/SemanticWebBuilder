package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;


   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public class ExperienceRef extends org.semanticwb.cptm.base.ExperienceRefBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(ExperienceRef.class, new ExperienceRefParser());
    }

    public ExperienceRef(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
