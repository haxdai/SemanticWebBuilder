package com.infotec.cvi.swb.base;


public abstract class EntidadFederativaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_EntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");

    public static class ClassMgr
    {
       /**
       * Returns a list of EntidadFederativa for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.EntidadFederativa for all models
       * @return Iterator of com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa>(it, true);
        }
       /**
       * Gets a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return A com.infotec.cvi.swb.EntidadFederativa
       */
        public static com.infotec.cvi.swb.EntidadFederativa getEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.EntidadFederativa)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return A com.infotec.cvi.swb.EntidadFederativa
       */
        public static com.infotec.cvi.swb.EntidadFederativa createEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.EntidadFederativa)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       */
        public static void removeEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.EntidadFederativa
       * @param id Identifier for com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return true if the com.infotec.cvi.swb.EntidadFederativa exists, false otherwise
       */

        public static boolean hasEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEntidadFederativa(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EntidadFederativa with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EntidadFederativa> listEntidadFederativaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EntidadFederativa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EntidadFederativaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EntidadFederativa
   */
    public EntidadFederativaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
