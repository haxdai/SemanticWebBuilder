package com.infotec.eworkplace.swb.base;


public abstract class VacacionesBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Vacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Vacaciones");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Vacaciones");

    public static class ClassMgr
    {
       /**
       * Returns a list of Vacaciones for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacioneses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Vacaciones for all models
       * @return Iterator of com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacioneses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return A com.infotec.eworkplace.swb.Vacaciones
       */
        public static com.infotec.eworkplace.swb.Vacaciones getVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Vacaciones)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return A com.infotec.eworkplace.swb.Vacaciones
       */
        public static com.infotec.eworkplace.swb.Vacaciones createVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Vacaciones)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       */
        public static void removeVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return true if the com.infotec.eworkplace.swb.Vacaciones exists, false otherwise
       */

        public static boolean hasVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVacaciones(id, model)!=null);
        }
    }

   /**
   * Constructs a VacacionesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Vacaciones
   */
    public VacacionesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
