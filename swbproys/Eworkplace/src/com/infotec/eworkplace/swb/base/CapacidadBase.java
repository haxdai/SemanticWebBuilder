package com.infotec.eworkplace.swb.base;

public interface CapacidadBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty ewp_domain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#domain");
    public static final org.semanticwb.platform.SemanticProperty ewp_experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#experience");
    public static final org.semanticwb.platform.SemanticClass ewp_Capacidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Capacidad");

    public String getDomain();

    public void setDomain(String value);

    public String getExperience();

    public void setExperience(String value);
}
