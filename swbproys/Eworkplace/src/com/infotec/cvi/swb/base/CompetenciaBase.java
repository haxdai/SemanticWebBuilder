package com.infotec.cvi.swb.base;


public abstract class CompetenciaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Competencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Competencia> listCompetencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Competencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Competencia for all models
       * @return Iterator of com.infotec.cvi.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Competencia> listCompetencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Competencia>(it, true);
        }

        public static com.infotec.cvi.swb.Competencia createCompetencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Competencia.ClassMgr.createCompetencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Competencia
       * @param id Identifier for com.infotec.cvi.swb.Competencia
       * @param model Model of the com.infotec.cvi.swb.Competencia
       * @return A com.infotec.cvi.swb.Competencia
       */
        public static com.infotec.cvi.swb.Competencia getCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Competencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Competencia
       * @param id Identifier for com.infotec.cvi.swb.Competencia
       * @param model Model of the com.infotec.cvi.swb.Competencia
       * @return A com.infotec.cvi.swb.Competencia
       */
        public static com.infotec.cvi.swb.Competencia createCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Competencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Competencia
       * @param id Identifier for com.infotec.cvi.swb.Competencia
       * @param model Model of the com.infotec.cvi.swb.Competencia
       */
        public static void removeCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Competencia
       * @param id Identifier for com.infotec.cvi.swb.Competencia
       * @param model Model of the com.infotec.cvi.swb.Competencia
       * @return true if the com.infotec.cvi.swb.Competencia exists, false otherwise
       */

        public static boolean hasCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetencia(id, model)!=null);
        }
    }

   /**
   * Constructs a CompetenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Competencia
   */
    public CompetenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
