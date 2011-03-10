package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias. 
   */
public class Experience extends org.semanticwb.cptm.base.ExperienceBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Experience.class, new ExperienceParser());
    }

    public Experience(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
