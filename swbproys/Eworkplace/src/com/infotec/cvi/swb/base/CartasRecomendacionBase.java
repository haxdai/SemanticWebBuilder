package com.infotec.cvi.swb.base;


public abstract class CartasRecomendacionBase extends com.infotec.cvi.swb.DocumentoProbatorio implements org.semanticwb.model.Iconable,org.semanticwb.model.Traceable,com.infotec.cvi.swb.Documento
{
    public static final org.semanticwb.platform.SemanticClass intranet_CartasRecomendacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CartasRecomendacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CartasRecomendacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of CartasRecomendacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CartasRecomendacion> listCartasRecomendacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CartasRecomendacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.CartasRecomendacion for all models
       * @return Iterator of com.infotec.cvi.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CartasRecomendacion> listCartasRecomendacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CartasRecomendacion>(it, true);
        }

        public static com.infotec.cvi.swb.CartasRecomendacion createCartasRecomendacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.CartasRecomendacion.ClassMgr.createCartasRecomendacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.cvi.swb.CartasRecomendacion
       * @param model Model of the com.infotec.cvi.swb.CartasRecomendacion
       * @return A com.infotec.cvi.swb.CartasRecomendacion
       */
        public static com.infotec.cvi.swb.CartasRecomendacion getCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CartasRecomendacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.cvi.swb.CartasRecomendacion
       * @param model Model of the com.infotec.cvi.swb.CartasRecomendacion
       * @return A com.infotec.cvi.swb.CartasRecomendacion
       */
        public static com.infotec.cvi.swb.CartasRecomendacion createCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CartasRecomendacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.cvi.swb.CartasRecomendacion
       * @param model Model of the com.infotec.cvi.swb.CartasRecomendacion
       */
        public static void removeCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.CartasRecomendacion
       * @param id Identifier for com.infotec.cvi.swb.CartasRecomendacion
       * @param model Model of the com.infotec.cvi.swb.CartasRecomendacion
       * @return true if the com.infotec.cvi.swb.CartasRecomendacion exists, false otherwise
       */

        public static boolean hasCartasRecomendacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCartasRecomendacion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.CartasRecomendacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CartasRecomendacion
       * @return Iterator with all the com.infotec.cvi.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CartasRecomendacion> listCartasRecomendacionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CartasRecomendacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CartasRecomendacion> listCartasRecomendacionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CartasRecomendacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CartasRecomendacion
       * @return Iterator with all the com.infotec.cvi.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CartasRecomendacion> listCartasRecomendacionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CartasRecomendacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CartasRecomendacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CartasRecomendacion> listCartasRecomendacionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CartasRecomendacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CartasRecomendacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CartasRecomendacion
   */
    public CartasRecomendacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
