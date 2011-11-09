package com.infotec.eworkplace.swb.base;

public interface VisionBase extends org.semanticwb.model.GenericObject
{
   /**
   * Visión del órgano 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_vision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#vision");
    public static final org.semanticwb.platform.SemanticClass ewp_Vision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Vision");

    public String getVision();

    public void setVision(String value);
}
