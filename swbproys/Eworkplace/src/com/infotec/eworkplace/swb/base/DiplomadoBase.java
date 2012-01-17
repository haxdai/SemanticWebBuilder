package com.infotec.eworkplace.swb.base;


public abstract class DiplomadoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Diplomado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Diplomado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Diplomado for all models
       * @return Iterator of com.infotec.eworkplace.swb.Diplomado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       * @return A com.infotec.eworkplace.swb.Diplomado
       */
        public static com.infotec.eworkplace.swb.Diplomado getDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Diplomado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       * @return A com.infotec.eworkplace.swb.Diplomado
       */
        public static com.infotec.eworkplace.swb.Diplomado createDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Diplomado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       */
        public static void removeDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       * @return true if the com.infotec.eworkplace.swb.Diplomado exists, false otherwise
       */

        public static boolean hasDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDiplomado(id, model)!=null);
        }
    }

   /**
   * Constructs a DiplomadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Diplomado
   */
    public DiplomadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
