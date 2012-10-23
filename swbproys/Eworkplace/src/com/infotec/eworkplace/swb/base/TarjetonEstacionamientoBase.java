package com.infotec.eworkplace.swb.base;


public abstract class TarjetonEstacionamientoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_TarjetonEstacionamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TarjetonEstacionamiento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TarjetonEstacionamiento");

    public static class ClassMgr
    {
       /**
       * Returns a list of TarjetonEstacionamiento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.TarjetonEstacionamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetonEstacionamiento> listTarjetonEstacionamientos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetonEstacionamiento>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.TarjetonEstacionamiento for all models
       * @return Iterator of com.infotec.eworkplace.swb.TarjetonEstacionamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetonEstacionamiento> listTarjetonEstacionamientos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetonEstacionamiento>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @return A com.infotec.eworkplace.swb.TarjetonEstacionamiento
       */
        public static com.infotec.eworkplace.swb.TarjetonEstacionamiento getTarjetonEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetonEstacionamiento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @return A com.infotec.eworkplace.swb.TarjetonEstacionamiento
       */
        public static com.infotec.eworkplace.swb.TarjetonEstacionamiento createTarjetonEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetonEstacionamiento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetonEstacionamiento
       */
        public static void removeTarjetonEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetonEstacionamiento
       * @return true if the com.infotec.eworkplace.swb.TarjetonEstacionamiento exists, false otherwise
       */

        public static boolean hasTarjetonEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTarjetonEstacionamiento(id, model)!=null);
        }
    }

    public static TarjetonEstacionamientoBase.ClassMgr getTarjetonEstacionamientoClassMgr()
    {
        return new TarjetonEstacionamientoBase.ClassMgr();
    }

   /**
   * Constructs a TarjetonEstacionamientoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TarjetonEstacionamiento
   */
    public TarjetonEstacionamientoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
