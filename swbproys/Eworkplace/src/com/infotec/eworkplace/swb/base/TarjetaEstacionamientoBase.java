package com.infotec.eworkplace.swb.base;


public abstract class TarjetaEstacionamientoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_nte=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#nte");
    public static final org.semanticwb.platform.SemanticProperty ewp_tipo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#tipo");
    public static final org.semanticwb.platform.SemanticClass ewp_TarjetaEstacionamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#TarjetaEstacionamiento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#TarjetaEstacionamiento");

    public static class ClassMgr
    {
       /**
       * Returns a list of TarjetaEstacionamiento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.TarjetaEstacionamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetaEstacionamiento> listTarjetaEstacionamientos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetaEstacionamiento>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.TarjetaEstacionamiento for all models
       * @return Iterator of com.infotec.eworkplace.swb.TarjetaEstacionamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetaEstacionamiento> listTarjetaEstacionamientos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetaEstacionamiento>(it, true);
        }

        public static com.infotec.eworkplace.swb.TarjetaEstacionamiento createTarjetaEstacionamiento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.TarjetaEstacionamiento.ClassMgr.createTarjetaEstacionamiento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @return A com.infotec.eworkplace.swb.TarjetaEstacionamiento
       */
        public static com.infotec.eworkplace.swb.TarjetaEstacionamiento getTarjetaEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetaEstacionamiento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @return A com.infotec.eworkplace.swb.TarjetaEstacionamiento
       */
        public static com.infotec.eworkplace.swb.TarjetaEstacionamiento createTarjetaEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetaEstacionamiento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaEstacionamiento
       */
        public static void removeTarjetaEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaEstacionamiento
       * @return true if the com.infotec.eworkplace.swb.TarjetaEstacionamiento exists, false otherwise
       */

        public static boolean hasTarjetaEstacionamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTarjetaEstacionamiento(id, model)!=null);
        }
    }

   /**
   * Constructs a TarjetaEstacionamientoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TarjetaEstacionamiento
   */
    public TarjetaEstacionamientoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Nte property
* @return String with the Nte
*/
    public String getNte()
    {
        return getSemanticObject().getProperty(ewp_nte);
    }

/**
* Sets the Nte property
* @param value long with the Nte
*/
    public void setNte(String value)
    {
        getSemanticObject().setProperty(ewp_nte, value);
    }

/**
* Gets the Tipo property
* @return boolean with the Tipo
*/
    public boolean isTipo()
    {
        return getSemanticObject().getBooleanProperty(ewp_tipo);
    }

/**
* Sets the Tipo property
* @param value long with the Tipo
*/
    public void setTipo(boolean value)
    {
        getSemanticObject().setBooleanProperty(ewp_tipo, value);
    }
}
