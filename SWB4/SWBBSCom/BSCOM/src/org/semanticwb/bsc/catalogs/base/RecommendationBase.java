package org.semanticwb.bsc.catalogs.base;


public abstract class RecommendationBase extends org.semanticwb.bsc.catalogs.Catalog implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Filterable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode
{
   /**
   * Indicación de las recomendaciones para el elemento correspondiente
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_recommendations=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#recommendations");
    public static final org.semanticwb.platform.SemanticClass bsc_Recommendation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Recommendation");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Recommendation");

    public static class ClassMgr
    {
       /**
       * Returns a list of Recommendation for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.catalogs.Recommendation
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.catalogs.Recommendation for all models
       * @return Iterator of org.semanticwb.bsc.catalogs.Recommendation
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation>(it, true);
        }

        public static org.semanticwb.bsc.catalogs.Recommendation createRecommendation(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.catalogs.Recommendation.ClassMgr.createRecommendation(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.catalogs.Recommendation
       * @param id Identifier for org.semanticwb.bsc.catalogs.Recommendation
       * @param model Model of the org.semanticwb.bsc.catalogs.Recommendation
       * @return A org.semanticwb.bsc.catalogs.Recommendation
       */
        public static org.semanticwb.bsc.catalogs.Recommendation getRecommendation(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.catalogs.Recommendation)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.catalogs.Recommendation
       * @param id Identifier for org.semanticwb.bsc.catalogs.Recommendation
       * @param model Model of the org.semanticwb.bsc.catalogs.Recommendation
       * @return A org.semanticwb.bsc.catalogs.Recommendation
       */
        public static org.semanticwb.bsc.catalogs.Recommendation createRecommendation(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.catalogs.Recommendation)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.catalogs.Recommendation
       * @param id Identifier for org.semanticwb.bsc.catalogs.Recommendation
       * @param model Model of the org.semanticwb.bsc.catalogs.Recommendation
       */
        public static void removeRecommendation(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.catalogs.Recommendation
       * @param id Identifier for org.semanticwb.bsc.catalogs.Recommendation
       * @param model Model of the org.semanticwb.bsc.catalogs.Recommendation
       * @return true if the org.semanticwb.bsc.catalogs.Recommendation exists, false otherwise
       */

        public static boolean hasRecommendation(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRecommendation(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Recommendation with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.catalogs.Recommendation
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Recommendation
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Recommendation with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Recommendation
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Recommendation with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.catalogs.Recommendation
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Recommendation
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Recommendation with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Recommendation
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static RecommendationBase.ClassMgr getRecommendationClassMgr()
    {
        return new RecommendationBase.ClassMgr();
    }

   /**
   * Constructs a RecommendationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Recommendation
   */
    public RecommendationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Recommendations property
* @return String with the Recommendations
*/
    public String getRecommendations()
    {
        return getSemanticObject().getProperty(bsc_recommendations);
    }

/**
* Sets the Recommendations property
* @param value long with the Recommendations
*/
    public void setRecommendations(String value)
    {
        getSemanticObject().setProperty(bsc_recommendations, value);
    }
}
