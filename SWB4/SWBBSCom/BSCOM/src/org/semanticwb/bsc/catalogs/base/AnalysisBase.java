package org.semanticwb.bsc.catalogs.base;


public abstract class AnalysisBase extends org.semanticwb.bsc.catalogs.Catalog implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Filterable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode
{
   /**
   * Anotaciones del análisis realizado al estado del elemento correspondiente
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_analysis=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#analysis");
    public static final org.semanticwb.platform.SemanticClass bsc_Analysis=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Analysis");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Analysis");

    public static class ClassMgr
    {
       /**
       * Returns a list of Analysis for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.catalogs.Analysis
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysises(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.catalogs.Analysis for all models
       * @return Iterator of org.semanticwb.bsc.catalogs.Analysis
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysises()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis>(it, true);
        }

        public static org.semanticwb.bsc.catalogs.Analysis createAnalysis(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.catalogs.Analysis.ClassMgr.createAnalysis(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.catalogs.Analysis
       * @param id Identifier for org.semanticwb.bsc.catalogs.Analysis
       * @param model Model of the org.semanticwb.bsc.catalogs.Analysis
       * @return A org.semanticwb.bsc.catalogs.Analysis
       */
        public static org.semanticwb.bsc.catalogs.Analysis getAnalysis(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.catalogs.Analysis)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.catalogs.Analysis
       * @param id Identifier for org.semanticwb.bsc.catalogs.Analysis
       * @param model Model of the org.semanticwb.bsc.catalogs.Analysis
       * @return A org.semanticwb.bsc.catalogs.Analysis
       */
        public static org.semanticwb.bsc.catalogs.Analysis createAnalysis(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.catalogs.Analysis)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.catalogs.Analysis
       * @param id Identifier for org.semanticwb.bsc.catalogs.Analysis
       * @param model Model of the org.semanticwb.bsc.catalogs.Analysis
       */
        public static void removeAnalysis(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.catalogs.Analysis
       * @param id Identifier for org.semanticwb.bsc.catalogs.Analysis
       * @param model Model of the org.semanticwb.bsc.catalogs.Analysis
       * @return true if the org.semanticwb.bsc.catalogs.Analysis exists, false otherwise
       */

        public static boolean hasAnalysis(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAnalysis(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Analysis with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.catalogs.Analysis
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Analysis
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysisByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Analysis with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Analysis
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysisByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Analysis with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.catalogs.Analysis
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Analysis
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysisByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.catalogs.Analysis with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.catalogs.Analysis
       */

        public static java.util.Iterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysisByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static AnalysisBase.ClassMgr getAnalysisClassMgr()
    {
        return new AnalysisBase.ClassMgr();
    }

   /**
   * Constructs a AnalysisBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Analysis
   */
    public AnalysisBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Analysis property
* @return String with the Analysis
*/
    public String getAnalysis()
    {
        return getSemanticObject().getProperty(bsc_analysis);
    }

/**
* Sets the Analysis property
* @param value long with the Analysis
*/
    public void setAnalysis(String value)
    {
        getSemanticObject().setProperty(bsc_analysis, value);
    }
}
