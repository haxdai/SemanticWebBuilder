package com.infotec.lodp.swb.base;

public interface RankableBase extends org.semanticwb.model.GenericObject
{
   /**
   * Numero total de veces calificado 
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_ranks=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#ranks");
   /**
   * Promedio de calificaciones 
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_average=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#average");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Rankable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Rankable");

    public long getRanks();

    public void setRanks(long value);

    public float getAverage();

    public void setAverage(float value);
}
