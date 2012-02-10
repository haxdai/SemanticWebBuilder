package com.infotec.eworkplace.swb.base;

public interface CapacidadBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_dominio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#dominio");
    public static final org.semanticwb.platform.SemanticProperty intranet_experiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#experiencia");
    public static final org.semanticwb.platform.SemanticClass intranet_Capacidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Capacidad");

    public String getDominio();

    public void setDominio(String value);

    public String getExperiencia();

    public void setExperiencia(String value);
}
