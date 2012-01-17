package com.infotec.eworkplace.swb.base;


public abstract class ReservacionAutoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_ReservacionAuto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionAuto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionAuto");

    public static class ClassMgr
    {
       /**
       * Returns a list of ReservacionAuto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ReservacionAuto for all models
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto>(it, true);
        }

        public static com.infotec.eworkplace.swb.ReservacionAuto createReservacionAuto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.ReservacionAuto.ClassMgr.createReservacionAuto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return A com.infotec.eworkplace.swb.ReservacionAuto
       */
        public static com.infotec.eworkplace.swb.ReservacionAuto getReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionAuto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return A com.infotec.eworkplace.swb.ReservacionAuto
       */
        public static com.infotec.eworkplace.swb.ReservacionAuto createReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionAuto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       */
        public static void removeReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return true if the com.infotec.eworkplace.swb.ReservacionAuto exists, false otherwise
       */

        public static boolean hasReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReservacionAuto(id, model)!=null);
        }
    }

   /**
   * Constructs a ReservacionAutoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservacionAuto
   */
    public ReservacionAutoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
