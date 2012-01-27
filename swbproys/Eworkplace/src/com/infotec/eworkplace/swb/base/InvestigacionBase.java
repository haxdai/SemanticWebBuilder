package com.infotec.eworkplace.swb.base;


public abstract class InvestigacionBase extends com.infotec.eworkplace.swb.InvestigacionDocencia 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Investigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Investigacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Investigacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Investigacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Investigacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Investigacion> listInvestigacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Investigacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Investigacion for all models
       * @return Iterator of com.infotec.eworkplace.swb.Investigacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Investigacion> listInvestigacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Investigacion>(it, true);
        }

        public static com.infotec.eworkplace.swb.Investigacion createInvestigacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Investigacion.ClassMgr.createInvestigacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Investigacion
       * @param id Identifier for com.infotec.eworkplace.swb.Investigacion
       * @param model Model of the com.infotec.eworkplace.swb.Investigacion
       * @return A com.infotec.eworkplace.swb.Investigacion
       */
        public static com.infotec.eworkplace.swb.Investigacion getInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Investigacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Investigacion
       * @param id Identifier for com.infotec.eworkplace.swb.Investigacion
       * @param model Model of the com.infotec.eworkplace.swb.Investigacion
       * @return A com.infotec.eworkplace.swb.Investigacion
       */
        public static com.infotec.eworkplace.swb.Investigacion createInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Investigacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Investigacion
       * @param id Identifier for com.infotec.eworkplace.swb.Investigacion
       * @param model Model of the com.infotec.eworkplace.swb.Investigacion
       */
        public static void removeInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Investigacion
       * @param id Identifier for com.infotec.eworkplace.swb.Investigacion
       * @param model Model of the com.infotec.eworkplace.swb.Investigacion
       * @return true if the com.infotec.eworkplace.swb.Investigacion exists, false otherwise
       */

        public static boolean hasInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInvestigacion(id, model)!=null);
        }
    }

   /**
   * Constructs a InvestigacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Investigacion
   */
    public InvestigacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
