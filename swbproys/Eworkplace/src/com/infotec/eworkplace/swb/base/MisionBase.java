package com.infotec.eworkplace.swb.base;

public interface MisionBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_mision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#mision");
    public static final org.semanticwb.platform.SemanticClass intranet_Mision=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Mision");

    public String getMision();

    public void setMision(String value);
}
