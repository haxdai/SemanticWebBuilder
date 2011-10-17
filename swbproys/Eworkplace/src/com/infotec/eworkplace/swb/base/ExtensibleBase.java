package com.infotec.eworkplace.swb.base;

public interface ExtensibleBase extends org.semanticwb.model.GenericObject
{
   /**
   * Extensión telefónica 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_extension=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#extension");
    public static final org.semanticwb.platform.SemanticClass ewp_Extensible=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Extensible");

    public int getExtension();

    public void setExtension(int value);
}
