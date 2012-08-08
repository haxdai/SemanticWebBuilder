package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el Tipo de promoción 
   */
public abstract class TipoPromocionBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para indicar el Tipo de promoción
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoPromocion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoPromocion");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoPromocion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.TipoPromocion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoPromocion> listTipoPromocions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoPromocion>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.TipoPromocion for all models
       * @return Iterator of com.infotec.cvi.swb.TipoPromocion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoPromocion> listTipoPromocions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoPromocion>(it, true);
        }

        public static com.infotec.cvi.swb.TipoPromocion createTipoPromocion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.TipoPromocion.ClassMgr.createTipoPromocion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.TipoPromocion
       * @param id Identifier for com.infotec.cvi.swb.TipoPromocion
       * @param model Model of the com.infotec.cvi.swb.TipoPromocion
       * @return A com.infotec.cvi.swb.TipoPromocion
       */
        public static com.infotec.cvi.swb.TipoPromocion getTipoPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoPromocion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.TipoPromocion
       * @param id Identifier for com.infotec.cvi.swb.TipoPromocion
       * @param model Model of the com.infotec.cvi.swb.TipoPromocion
       * @return A com.infotec.cvi.swb.TipoPromocion
       */
        public static com.infotec.cvi.swb.TipoPromocion createTipoPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.TipoPromocion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.TipoPromocion
       * @param id Identifier for com.infotec.cvi.swb.TipoPromocion
       * @param model Model of the com.infotec.cvi.swb.TipoPromocion
       */
        public static void removeTipoPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.TipoPromocion
       * @param id Identifier for com.infotec.cvi.swb.TipoPromocion
       * @param model Model of the com.infotec.cvi.swb.TipoPromocion
       * @return true if the com.infotec.cvi.swb.TipoPromocion exists, false otherwise
       */

        public static boolean hasTipoPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoPromocion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoPromocion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoPromocion
       * @return Iterator with all the com.infotec.cvi.swb.TipoPromocion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoPromocion> listTipoPromocionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoPromocion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoPromocion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoPromocion> listTipoPromocionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoPromocion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.TipoPromocion
       * @return Iterator with all the com.infotec.cvi.swb.TipoPromocion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoPromocion> listTipoPromocionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.TipoPromocion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.TipoPromocion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.TipoPromocion> listTipoPromocionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.TipoPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TipoPromocionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoPromocion
   */
    public TipoPromocionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
