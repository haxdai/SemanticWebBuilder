package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar temporadas (altas y bajas para las tarifas) 
   */
public abstract class RateSeasonBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Fecha inicial de la temporada
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_seasonStartDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#seasonStartDate");
   /**
   * Fecha final de la temporada
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_seasonEndDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#seasonEndDate");
   /**
   * Clase que se encarga de administrar temporadas (altas y bajas para las tarifas)
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_RateSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateSeason");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateSeason");

    public static class ClassMgr
    {
       /**
       * Returns a list of RateSeason for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.RateSeason
       */

        public static java.util.Iterator<org.semanticwb.pymtur.RateSeason> listRateSeasons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.RateSeason for all models
       * @return Iterator of org.semanticwb.pymtur.RateSeason
       */

        public static java.util.Iterator<org.semanticwb.pymtur.RateSeason> listRateSeasons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(it, true);
        }

        public static org.semanticwb.pymtur.RateSeason createRateSeason(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RateSeason.ClassMgr.createRateSeason(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.RateSeason
       * @param id Identifier for org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.RateSeason
       * @return A org.semanticwb.pymtur.RateSeason
       */
        public static org.semanticwb.pymtur.RateSeason getRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateSeason)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.RateSeason
       * @param id Identifier for org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.RateSeason
       * @return A org.semanticwb.pymtur.RateSeason
       */
        public static org.semanticwb.pymtur.RateSeason createRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RateSeason)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.RateSeason
       * @param id Identifier for org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.RateSeason
       */
        public static void removeRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.RateSeason
       * @param id Identifier for org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.RateSeason
       * @return true if the org.semanticwb.pymtur.RateSeason exists, false otherwise
       */

        public static boolean hasRateSeason(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRateSeason(id, model)!=null);
        }
    }

   /**
   * Constructs a RateSeasonBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RateSeason
   */
    public RateSeasonBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the SeasonStartDate property
* @return java.util.Date with the SeasonStartDate
*/
    public java.util.Date getSeasonStartDate()
    {
        return getSemanticObject().getDateProperty(pymtur_seasonStartDate);
    }

/**
* Sets the SeasonStartDate property
* @param value long with the SeasonStartDate
*/
    public void setSeasonStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_seasonStartDate, value);
    }

/**
* Gets the SeasonEndDate property
* @return java.util.Date with the SeasonEndDate
*/
    public java.util.Date getSeasonEndDate()
    {
        return getSemanticObject().getDateProperty(pymtur_seasonEndDate);
    }

/**
* Sets the SeasonEndDate property
* @param value long with the SeasonEndDate
*/
    public void setSeasonEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_seasonEndDate, value);
    }
}
