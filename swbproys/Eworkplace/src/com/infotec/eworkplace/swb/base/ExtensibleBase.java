package com.infotec.eworkplace.swb.base;

public interface ExtensibleBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_extension=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#extension");
    public static final org.semanticwb.platform.SemanticClass intranet_Extensible=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Extensible");

    public int getExtension();

    public void setExtension(int value);
}
