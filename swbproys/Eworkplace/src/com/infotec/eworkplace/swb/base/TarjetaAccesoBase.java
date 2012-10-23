package com.infotec.eworkplace.swb.base;


public abstract class TarjetaAccesoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_TarjetaAcceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TarjetaAcceso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TarjetaAcceso");

    public static class ClassMgr
    {
       /**
       * Returns a list of TarjetaAcceso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.TarjetaAcceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetaAcceso> listTarjetaAccesos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetaAcceso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.TarjetaAcceso for all models
       * @return Iterator of com.infotec.eworkplace.swb.TarjetaAcceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetaAcceso> listTarjetaAccesos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetaAcceso>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       * @return A com.infotec.eworkplace.swb.TarjetaAcceso
       */
        public static com.infotec.eworkplace.swb.TarjetaAcceso getTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetaAcceso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       * @return A com.infotec.eworkplace.swb.TarjetaAcceso
       */
        public static com.infotec.eworkplace.swb.TarjetaAcceso createTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetaAcceso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       */
        public static void removeTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       * @return true if the com.infotec.eworkplace.swb.TarjetaAcceso exists, false otherwise
       */

        public static boolean hasTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTarjetaAcceso(id, model)!=null);
        }
    }

    public static TarjetaAccesoBase.ClassMgr getTarjetaAccesoClassMgr()
    {
        return new TarjetaAccesoBase.ClassMgr();
    }

   /**
   * Constructs a TarjetaAccesoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TarjetaAcceso
   */
    public TarjetaAccesoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
