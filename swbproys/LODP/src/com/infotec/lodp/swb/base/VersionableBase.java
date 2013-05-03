package com.infotec.lodp.swb.base;

public interface VersionableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass lodpcg_DatasetVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#DatasetVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_actualVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#actualVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_lastVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#lastVersion");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Versionable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Versionable");

   /**
   * Sets a value from the property ActualVersion
   * @param value An instance of com.infotec.lodp.swb.DatasetVersion
   */
    public void setActualVersion(com.infotec.lodp.swb.DatasetVersion value);

   /**
   * Remove the value from the property ActualVersion
   */
    public void removeActualVersion();

    public com.infotec.lodp.swb.DatasetVersion getActualVersion();

   /**
   * Sets a value from the property LastVersion
   * @param value An instance of com.infotec.lodp.swb.DatasetVersion
   */
    public void setLastVersion(com.infotec.lodp.swb.DatasetVersion value);

   /**
   * Remove the value from the property LastVersion
   */
    public void removeLastVersion();

    public com.infotec.lodp.swb.DatasetVersion getLastVersion();
}
