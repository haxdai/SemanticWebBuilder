package org.semanticwb.model.survey.base;


public abstract class UnidadSustantivaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_claveUnidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#claveUnidad");
    public static final org.semanticwb.platform.SemanticProperty cts_nombreUnidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#nombreUnidad");
    public static final org.semanticwb.platform.SemanticClass cts_UnidadSustantiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#UnidadSustantiva");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#UnidadSustantiva");

    public static class ClassMgr
    {
       /**
       * Returns a list of UnidadSustantiva for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.UnidadSustantiva
       */

        public static java.util.Iterator<org.semanticwb.model.survey.UnidadSustantiva> listUnidadSustantivas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.UnidadSustantiva>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.UnidadSustantiva for all models
       * @return Iterator of org.semanticwb.model.survey.UnidadSustantiva
       */

        public static java.util.Iterator<org.semanticwb.model.survey.UnidadSustantiva> listUnidadSustantivas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.UnidadSustantiva>(it, true);
        }
       /**
       * Gets a org.semanticwb.model.survey.UnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.UnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.UnidadSustantiva
       * @return A org.semanticwb.model.survey.UnidadSustantiva
       */
        public static org.semanticwb.model.survey.UnidadSustantiva getUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.UnidadSustantiva)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.UnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.UnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.UnidadSustantiva
       * @return A org.semanticwb.model.survey.UnidadSustantiva
       */
        public static org.semanticwb.model.survey.UnidadSustantiva createUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.UnidadSustantiva)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.UnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.UnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.UnidadSustantiva
       */
        public static void removeUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.UnidadSustantiva
       * @param id Identifier for org.semanticwb.model.survey.UnidadSustantiva
       * @param model Model of the org.semanticwb.model.survey.UnidadSustantiva
       * @return true if the org.semanticwb.model.survey.UnidadSustantiva exists, false otherwise
       */

        public static boolean hasUnidadSustantiva(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUnidadSustantiva(id, model)!=null);
        }
    }

    public static UnidadSustantivaBase.ClassMgr getUnidadSustantivaClassMgr()
    {
        return new UnidadSustantivaBase.ClassMgr();
    }

   /**
   * Constructs a UnidadSustantivaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UnidadSustantiva
   */
    public UnidadSustantivaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ClaveUnidad property
* @return String with the ClaveUnidad
*/
    public String getClaveUnidad()
    {
        return getSemanticObject().getProperty(cts_claveUnidad);
    }

/**
* Sets the ClaveUnidad property
* @param value long with the ClaveUnidad
*/
    public void setClaveUnidad(String value)
    {
        getSemanticObject().setProperty(cts_claveUnidad, value);
    }

/**
* Gets the NombreUnidad property
* @return String with the NombreUnidad
*/
    public String getNombreUnidad()
    {
        return getSemanticObject().getProperty(cts_nombreUnidad);
    }

/**
* Sets the NombreUnidad property
* @param value long with the NombreUnidad
*/
    public void setNombreUnidad(String value)
    {
        getSemanticObject().setProperty(cts_nombreUnidad, value);
    }
}
