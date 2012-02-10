package com.infotec.eworkplace.swb.base;

public interface StatusBase extends org.semanticwb.model.GenericObject
{
   /**
   * Estatus de la sala 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_status=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#status");
    public static final org.semanticwb.platform.SemanticClass intranet_Status=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Status");

    public String getStatus();

    public void setStatus(String value);
}
