package com.infotec.eworkplace.swb.base;

public interface OrdenBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass intranet_Organo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Organo");
    public static final org.semanticwb.platform.SemanticProperty intranet_perteneceA=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#perteneceA");
    public static final org.semanticwb.platform.SemanticClass intranet_Orden=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Orden");

   /**
   * Sets a value from the property PerteneceA
   * @param value An instance of com.infotec.eworkplace.swb.Organo
   */
    public void setPerteneceA(com.infotec.eworkplace.swb.Organo value);

   /**
   * Remove the value from the property PerteneceA
   */
    public void removePerteneceA();

    public com.infotec.eworkplace.swb.Organo getPerteneceA();
}
