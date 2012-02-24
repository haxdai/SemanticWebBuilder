package com.infotec.cvi.swb.base;

public interface EquipoJustificacionBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_justificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#justificacion");
    public static final org.semanticwb.platform.SemanticClass intranet_EquipoJustificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EquipoJustificacion");

    public String getJustificacion();

    public void setJustificacion(String value);
}
