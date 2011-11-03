package com.infotec.eworkplace.swb.base;


public abstract class ReservaAutoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_ReservaAuto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaAuto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaAuto");

    public static class ClassMgr
    {
       /**
       * Returns a list of ReservaAuto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ReservaAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaAuto> listReservaAutos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaAuto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ReservaAuto for all models
       * @return Iterator of com.infotec.eworkplace.swb.ReservaAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservaAuto> listReservaAutos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaAuto>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ReservaAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservaAuto
       * @return A com.infotec.eworkplace.swb.ReservaAuto
       */
        public static com.infotec.eworkplace.swb.ReservaAuto getReservaAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservaAuto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ReservaAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservaAuto
       * @return A com.infotec.eworkplace.swb.ReservaAuto
       */
        public static com.infotec.eworkplace.swb.ReservaAuto createReservaAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservaAuto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ReservaAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservaAuto
       */
        public static void removeReservaAuto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ReservaAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservaAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservaAuto
       * @return true if the com.infotec.eworkplace.swb.ReservaAuto exists, false otherwise
       */

        public static boolean hasReservaAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReservaAuto(id, model)!=null);
        }
    }

   /**
   * Constructs a ReservaAutoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaAuto
   */
    public ReservaAutoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
