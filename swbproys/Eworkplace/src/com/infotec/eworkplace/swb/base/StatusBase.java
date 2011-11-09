package com.infotec.eworkplace.swb.base;

public interface StatusBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty ewp_status=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#status");
    public static final org.semanticwb.platform.SemanticClass ewp_Status=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Status");

    public String getStatus();

    public void setStatus(String value);
}
