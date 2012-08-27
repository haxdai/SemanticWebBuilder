package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar las diferentes Habilidades 
   */
public abstract class HabilidadBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para almacenar los tipos de talentos utilizados en Habilidades
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoTalento");
   /**
   * Tipo de talento relacionado a la Habilidad
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoTalento");
   /**
   * Catálogo utilizado para indicar las diferentes Habilidades
   */
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
       * @return Iterator of com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidads(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Habilidad for all models
       * @return Iterator of com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidads()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad>(it, true);
        }

        public static com.infotec.cvi.swb.Habilidad createHabilidad(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Habilidad.ClassMgr.createHabilidad(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Habilidad
       * @param id Identifier for com.infotec.cvi.swb.Habilidad
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       * @return A com.infotec.cvi.swb.Habilidad
       */
        public static com.infotec.cvi.swb.Habilidad getHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Habilidad)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Habilidad
       * @param id Identifier for com.infotec.cvi.swb.Habilidad
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       * @return A com.infotec.cvi.swb.Habilidad
       */
        public static com.infotec.cvi.swb.Habilidad createHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Habilidad)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Habilidad
       * @param id Identifier for com.infotec.cvi.swb.Habilidad
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       */
        public static void removeHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Habilidad
       * @param id Identifier for com.infotec.cvi.swb.Habilidad
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       * @return true if the com.infotec.cvi.swb.Habilidad exists, false otherwise
       */

        public static boolean hasHabilidad(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHabilidad(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Habilidad with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       * @return Iterator with all the com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidadByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Habilidad with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidadByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Habilidad with a determined TipoTalento
       * @param value TipoTalento of the type com.infotec.cvi.swb.TipoTalento
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       * @return Iterator with all the com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidadByTipoTalento(com.infotec.cvi.swb.TipoTalento value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoTalento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Habilidad with a determined TipoTalento
       * @param value TipoTalento of the type com.infotec.cvi.swb.TipoTalento
       * @return Iterator with all the com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidadByTipoTalento(com.infotec.cvi.swb.TipoTalento value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoTalento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Habilidad with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Habilidad
       * @return Iterator with all the com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidadByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Habilidad with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Habilidad
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Habilidad> listHabilidadByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
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
   /**
   * Sets the value for the property TipoTalento
   * @param value TipoTalento to set
   */

    public void setTipoTalento(com.infotec.cvi.swb.TipoTalento value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_tipoTalento, value.getSemanticObject());
        }else
        {
            removeTipoTalento();
        }
    }
   /**
   * Remove the value for TipoTalento property
   */

    public void removeTipoTalento()
    {
        getSemanticObject().removeProperty(intranet_tipoTalento);
    }

   /**
   * Gets the TipoTalento
   * @return a com.infotec.cvi.swb.TipoTalento
   */
    public com.infotec.cvi.swb.TipoTalento getTipoTalento()
    {
         com.infotec.cvi.swb.TipoTalento ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_tipoTalento);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoTalento)obj.createGenericInstance();
         }
         return ret;
    }
}
