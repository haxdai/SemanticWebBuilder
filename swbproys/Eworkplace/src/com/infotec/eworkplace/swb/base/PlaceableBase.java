package com.infotec.eworkplace.swb.base;

public interface PlaceableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_ubicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ubicacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Placeable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Placeable");

    public String getUbicacion();

    public void setUbicacion(String value);
}
