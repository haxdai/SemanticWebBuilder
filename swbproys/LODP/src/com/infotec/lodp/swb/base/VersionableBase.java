package com.infotec.lodp.swb.base;

public interface VersionableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass lodp_DatasetVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#DatasetVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_actualVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#actualVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_lastVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#lastVersion");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Versionable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Versionable");

   /**
   * Sets a value from the property ActualVersion
   * @param value An instance of org.semanticwb.platform.SemanticObject
   */
    public void setActualVersion(org.semanticwb.platform.SemanticObject value);

   /**
   * Remove the value from the property ActualVersion
   */
    public void removeActualVersion();

    public org.semanticwb.platform.SemanticObject getActualVersion();

   /**
   * Sets a value from the property LastVersion
   * @param value An instance of org.semanticwb.platform.SemanticObject
   */
    public void setLastVersion(org.semanticwb.platform.SemanticObject value);

   /**
   * Remove the value from the property LastVersion
   */
    public void removeLastVersion();

    public org.semanticwb.platform.SemanticObject getLastVersion();
}
