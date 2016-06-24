package org.semanticwb.bsc.base;

   /**
   * Cualquier elemento BSC que se pueda actualizar periodicamente 
   */
public interface UpdateableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass bsc_Recommendation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Recommendation");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasRecommendation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasRecommendation");
    public static final org.semanticwb.platform.SemanticClass bsc_Analysis=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Analysis");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasAnalysis=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasAnalysis");
   /**
   * Cualquier elemento BSC que se pueda actualizar periodicamente 
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Updateable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Updateable");

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendations();
    public boolean hasRecommendation(org.semanticwb.bsc.catalogs.Recommendation value);

   /**
   * Adds the Recommendation
   * @param value An instance of org.semanticwb.bsc.catalogs.Recommendation
   */
    public void addRecommendation(org.semanticwb.bsc.catalogs.Recommendation value);

   /**
   * Remove all the values for the property Recommendation
   */
    public void removeAllRecommendation();

   /**
   * Remove a value from the property Recommendation
   * @param value An instance of org.semanticwb.bsc.catalogs.Recommendation
   */
    public void removeRecommendation(org.semanticwb.bsc.catalogs.Recommendation value);

/**
* Gets the Recommendation
* @return a instance of org.semanticwb.bsc.catalogs.Recommendation
*/
    public org.semanticwb.bsc.catalogs.Recommendation getRecommendation();

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysises();
    public boolean hasAnalysis(org.semanticwb.bsc.catalogs.Analysis value);

   /**
   * Adds the Analysis
   * @param value An instance of org.semanticwb.bsc.catalogs.Analysis
   */
    public void addAnalysis(org.semanticwb.bsc.catalogs.Analysis value);

   /**
   * Remove all the values for the property Analysis
   */
    public void removeAllAnalysis();

   /**
   * Remove a value from the property Analysis
   * @param value An instance of org.semanticwb.bsc.catalogs.Analysis
   */
    public void removeAnalysis(org.semanticwb.bsc.catalogs.Analysis value);

/**
* Gets the Analysis
* @return a instance of org.semanticwb.bsc.catalogs.Analysis
*/
    public org.semanticwb.bsc.catalogs.Analysis getAnalysis();
}
