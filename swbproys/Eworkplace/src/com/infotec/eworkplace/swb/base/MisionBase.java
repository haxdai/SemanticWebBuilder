package com.infotec.eworkplace.swb.base;

public interface MisionBase extends org.semanticwb.model.GenericObject
{
   /**
   * Misión del órgano 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_mision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#mision");
    public static final org.semanticwb.platform.SemanticClass ewp_Mision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Mision");

    public String getMision();

    public void setMision(String value);
}
