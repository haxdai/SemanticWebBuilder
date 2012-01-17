package com.infotec.eworkplace.swb.base;

public interface VisionBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_vision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vision");
    public static final org.semanticwb.platform.SemanticClass intranet_Vision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Vision");

    public String getVision();

    public void setVision(String value);
}
