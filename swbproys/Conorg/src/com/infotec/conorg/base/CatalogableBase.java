package com.infotec.conorg.base;

public interface CatalogableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty conorg_catalogIDsDOI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#catalogIDsDOI");
    public static final org.semanticwb.platform.SemanticProperty conorg_catalogIDsISBN=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#catalogIDsISBN");
    public static final org.semanticwb.platform.SemanticClass conorg_Catalogable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Catalogable");

    public String getDOI();

    public void setDOI(String value);

    public String getISBN();

    public void setISBN(String value);
}
