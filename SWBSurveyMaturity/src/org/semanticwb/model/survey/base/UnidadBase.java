package org.semanticwb.model.survey.base;

public interface UnidadBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass cts_UnidadSustantiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#UnidadSustantiva");
    public static final org.semanticwb.platform.SemanticProperty cts_unidadSustantiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#unidadSustantiva");
    public static final org.semanticwb.platform.SemanticClass cts_Unidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Unidad");

   /**
   * Sets a value from the property UnidadSustantiva
   * @param value An instance of org.semanticwb.model.survey.UnidadSustantiva
   */
    public void setUnidadSustantiva(org.semanticwb.model.survey.UnidadSustantiva value);

   /**
   * Remove the value from the property UnidadSustantiva
   */
    public void removeUnidadSustantiva();

    public org.semanticwb.model.survey.UnidadSustantiva getUnidadSustantiva();
}
