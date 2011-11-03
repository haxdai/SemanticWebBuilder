package com.infotec.eworkplace.swb.base;

public interface PlaceableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty ewp_ubicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#ubicacion");
    public static final org.semanticwb.platform.SemanticClass ewp_Placeable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Placeable");

    public String getUbicacion();

    public void setUbicacion(String value);
}
