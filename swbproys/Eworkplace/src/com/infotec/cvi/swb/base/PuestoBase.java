package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar los tipos de puesto 
   */
public abstract class PuestoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para indicar el Tipo de contratación
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoContratacion");
   /**
   * Tipo de contratación asociado el puesto
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoContrato");
   /**
   * Catálogo utilizado para indicar los tipos de puesto
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Puesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Puesto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Puesto");

    public static class ClassMgr
    {
       /**
       * Returns a list of Puesto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Puesto for all models
       * @return Iterator of com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto>(it, true);
        }

        public static com.infotec.cvi.swb.Puesto createPuesto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Puesto.ClassMgr.createPuesto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Puesto
       * @param id Identifier for com.infotec.cvi.swb.Puesto
       * @param model Model of the com.infotec.cvi.swb.Puesto
       * @return A com.infotec.cvi.swb.Puesto
       */
        public static com.infotec.cvi.swb.Puesto getPuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Puesto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Puesto
       * @param id Identifier for com.infotec.cvi.swb.Puesto
       * @param model Model of the com.infotec.cvi.swb.Puesto
       * @return A com.infotec.cvi.swb.Puesto
       */
        public static com.infotec.cvi.swb.Puesto createPuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Puesto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Puesto
       * @param id Identifier for com.infotec.cvi.swb.Puesto
       * @param model Model of the com.infotec.cvi.swb.Puesto
       */
        public static void removePuesto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Puesto
       * @param id Identifier for com.infotec.cvi.swb.Puesto
       * @param model Model of the com.infotec.cvi.swb.Puesto
       * @return true if the com.infotec.cvi.swb.Puesto exists, false otherwise
       */

        public static boolean hasPuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPuesto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Puesto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Puesto
       * @return Iterator with all the com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Puesto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Puesto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Puesto
       * @return Iterator with all the com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Puesto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Puesto with a determined TipoContrato
       * @param value TipoContrato of the type com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.cvi.swb.Puesto
       * @return Iterator with all the com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestoByTipoContrato(com.infotec.cvi.swb.TipoContratacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Puesto with a determined TipoContrato
       * @param value TipoContrato of the type com.infotec.cvi.swb.TipoContratacion
       * @return Iterator with all the com.infotec.cvi.swb.Puesto
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Puesto> listPuestoByTipoContrato(com.infotec.cvi.swb.TipoContratacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Puesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoContrato,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PuestoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Puesto
   */
    public PuestoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property TipoContrato
   * @param value TipoContrato to set
   */

    public void setTipoContrato(com.infotec.cvi.swb.TipoContratacion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_tipoContrato, value.getSemanticObject());
        }else
        {
            removeTipoContrato();
        }
    }
   /**
   * Remove the value for TipoContrato property
   */

    public void removeTipoContrato()
    {
        getSemanticObject().removeProperty(intranet_tipoContrato);
    }

   /**
   * Gets the TipoContrato
   * @return a com.infotec.cvi.swb.TipoContratacion
   */
    public com.infotec.cvi.swb.TipoContratacion getTipoContrato()
    {
         com.infotec.cvi.swb.TipoContratacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_tipoContrato);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoContratacion)obj.createGenericInstance();
         }
         return ret;
    }
}
