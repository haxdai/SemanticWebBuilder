package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el Tipo de contratación 
   */
public abstract class TipoContratacionBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Sortable
{
   /**
   * Catálogo utilizado para indicar el Tipo de contratación
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoContratacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoContratacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoContratacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.TipoContratacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoContratacion> listTipoContratacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoContratacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.TipoContratacion for all models
       * @return Iterator of com.infotec.cvi.swb.TipoContratacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoContratacion> listTipoContratacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoContratacion>(it, true);
        }

        public static com.infotec.cvi.swb.TipoContratacion createTipoContratacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.TipoContratacion.ClassMgr.createTipoContratacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.TipoContratacion
       * @param id Identifier for com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.cvi.swb.TipoContratacion
       * @return A com.infotec.cvi.swb.TipoContratacion
       */
        public static com.infotec.cvi.swb.TipoContratacion getTipoContratacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoContratacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.TipoContratacion
       * @param id Identifier for com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.cvi.swb.TipoContratacion
       * @return A com.infotec.cvi.swb.TipoContratacion
       */
        public static com.infotec.cvi.swb.TipoContratacion createTipoContratacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoContratacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.TipoContratacion
       * @param id Identifier for com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.cvi.swb.TipoContratacion
       */
        public static void removeTipoContratacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.TipoContratacion
       * @param id Identifier for com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.cvi.swb.TipoContratacion
       * @return true if the com.infotec.cvi.swb.TipoContratacion exists, false otherwise
       */

        public static boolean hasTipoContratacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoContratacion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoContratacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoContratacion
       * @return Iterator with all the com.infotec.cvi.swb.TipoContratacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoContratacion> listTipoContratacionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoContratacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoContratacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoContratacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoContratacion> listTipoContratacionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoContratacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoContratacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoContratacion
       * @return Iterator with all the com.infotec.cvi.swb.TipoContratacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoContratacion> listTipoContratacionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoContratacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoContratacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoContratacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoContratacion> listTipoContratacionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoContratacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static TipoContratacionBase.ClassMgr getTipoContratacionClassMgr()
    {
        return new TipoContratacionBase.ClassMgr();
    }

   /**
   * Constructs a TipoContratacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoContratacion
   */
    public TipoContratacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(swb_index, value);
    }
}
