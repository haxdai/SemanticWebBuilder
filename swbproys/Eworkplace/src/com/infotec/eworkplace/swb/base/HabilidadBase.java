package com.infotec.eworkplace.swb.base;


public abstract class HabilidadBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Habilidad");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Habilidad");

    public static class ClassMgr
    {
       /**
       * Returns a list of Habilidad for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Habilidad> listHabilidads(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidad>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Habilidad for all models
       * @return Iterator of com.infotec.eworkplace.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Habilidad> listHabilidads()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidad>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       * @return A com.infotec.eworkplace.swb.Habilidad
       */
        public static com.infotec.eworkplace.swb.Habilidad getHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Habilidad)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       * @return A com.infotec.eworkplace.swb.Habilidad
       */
        public static com.infotec.eworkplace.swb.Habilidad createHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Habilidad)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       */
        public static void removeHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Habilidad
       * @param id Identifier for com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Habilidad
       * @return true if the com.infotec.eworkplace.swb.Habilidad exists, false otherwise
       */

        public static boolean hasHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHabilidad(id, model)!=null);
        }
    }

   /**
   * Constructs a HabilidadBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Habilidad
   */
    public HabilidadBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
