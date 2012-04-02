package com.infotec.cvi.swb.base;

   /**
   * Interfaz que se utiliza para que el candidato sea sujeto a tener CV 
   */
public interface CVableBase extends org.semanticwb.model.GenericObject
{
   /**
   * Interfaz que se utiliza para que el candidato sea sujeto a tener CV 
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CVable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CVable");
}
