package com.infotec.eworkplace.swb.base;


public abstract class SubGerenciaBase extends com.infotec.eworkplace.swb.Organo implements com.infotec.eworkplace.swb.Mision,com.infotec.eworkplace.swb.Vision,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ewp_SubGerencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#SubGerencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#SubGerencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of SubGerencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SubGerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SubGerencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SubGerencia for all models
       * @return Iterator of com.infotec.eworkplace.swb.SubGerencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SubGerencia> listSubGerencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SubGerencia>(it, true);
        }

        public static com.infotec.eworkplace.swb.SubGerencia createSubGerencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.SubGerencia.ClassMgr.createSubGerencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return A com.infotec.eworkplace.swb.SubGerencia
       */
        public static com.infotec.eworkplace.swb.SubGerencia getSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SubGerencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return A com.infotec.eworkplace.swb.SubGerencia
       */
        public static com.infotec.eworkplace.swb.SubGerencia createSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SubGerencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       */
        public static void removeSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SubGerencia
       * @param id Identifier for com.infotec.eworkplace.swb.SubGerencia
       * @param model Model of the com.infotec.eworkplace.swb.SubGerencia
       * @return true if the com.infotec.eworkplace.swb.SubGerencia exists, false otherwise
       */

        public static boolean hasSubGerencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubGerencia(id, model)!=null);
        }
    }

   /**
   * Constructs a SubGerenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SubGerencia
   */
    public SubGerenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
