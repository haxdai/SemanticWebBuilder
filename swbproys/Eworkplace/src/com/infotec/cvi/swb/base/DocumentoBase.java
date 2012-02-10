package com.infotec.cvi.swb.base;

public interface DocumentoBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_filename=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#filename");
    public static final org.semanticwb.platform.SemanticClass intranet_Documento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Documento");

    public String getFilename();

    public void setFilename(String value);
}
