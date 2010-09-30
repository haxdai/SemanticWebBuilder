package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar tarifas 
   */
public abstract class RateBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Clase que se encarga de administrar tarifas
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Rate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Rate");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Rate");

    public static class ClassMgr
    {
       /**
       * Returns a list of Rate for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Rate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Rate> listRates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Rate for all models
       * @return Iterator of org.semanticwb.pymtur.Rate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Rate> listRates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(it, true);
        }

        public static org.semanticwb.pymtur.Rate createRate(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Rate.ClassMgr.createRate(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.Rate
       * @param id Identifier for org.semanticwb.pymtur.Rate
       * @param model Model of the org.semanticwb.pymtur.Rate
       * @return A org.semanticwb.pymtur.Rate
       */
        public static org.semanticwb.pymtur.Rate getRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Rate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Rate
       * @param id Identifier for org.semanticwb.pymtur.Rate
       * @param model Model of the org.semanticwb.pymtur.Rate
       * @return A org.semanticwb.pymtur.Rate
       */
        public static org.semanticwb.pymtur.Rate createRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Rate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Rate
       * @param id Identifier for org.semanticwb.pymtur.Rate
       * @param model Model of the org.semanticwb.pymtur.Rate
       */
        public static void removeRate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Rate
       * @param id Identifier for org.semanticwb.pymtur.Rate
       * @param model Model of the org.semanticwb.pymtur.Rate
       * @return true if the org.semanticwb.pymtur.Rate exists, false otherwise
       */

        public static boolean hasRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRate(id, model)!=null);
        }
    }

   /**
   * Constructs a RateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Rate
   */
    public RateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
