package com.infotec.eworkplace.swb.base;


public abstract class ArqSistemaBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_ArqSistema=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ArqSistema");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ArqSistema");

    public static class ClassMgr
    {
       /**
       * Returns a list of ArqSistema for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ArqSistema> listArqSistemas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ArqSistema>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ArqSistema for all models
       * @return Iterator of com.infotec.eworkplace.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ArqSistema> listArqSistemas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ArqSistema>(it, true);
        }

        public static com.infotec.eworkplace.swb.ArqSistema createArqSistema(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.ArqSistema.ClassMgr.createArqSistema(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ArqSistema
       * @param id Identifier for com.infotec.eworkplace.swb.ArqSistema
       * @param model Model of the com.infotec.eworkplace.swb.ArqSistema
       * @return A com.infotec.eworkplace.swb.ArqSistema
       */
        public static com.infotec.eworkplace.swb.ArqSistema getArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ArqSistema)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ArqSistema
       * @param id Identifier for com.infotec.eworkplace.swb.ArqSistema
       * @param model Model of the com.infotec.eworkplace.swb.ArqSistema
       * @return A com.infotec.eworkplace.swb.ArqSistema
       */
        public static com.infotec.eworkplace.swb.ArqSistema createArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ArqSistema)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ArqSistema
       * @param id Identifier for com.infotec.eworkplace.swb.ArqSistema
       * @param model Model of the com.infotec.eworkplace.swb.ArqSistema
       */
        public static void removeArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ArqSistema
       * @param id Identifier for com.infotec.eworkplace.swb.ArqSistema
       * @param model Model of the com.infotec.eworkplace.swb.ArqSistema
       * @return true if the com.infotec.eworkplace.swb.ArqSistema exists, false otherwise
       */

        public static boolean hasArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            return (getArqSistema(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ArqSistema with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ArqSistema
       * @return Iterator with all the com.infotec.eworkplace.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ArqSistema> listArqSistemaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ArqSistema with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ArqSistema> listArqSistemaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ArqSistema with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ArqSistema
       * @return Iterator with all the com.infotec.eworkplace.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ArqSistema> listArqSistemaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ArqSistema with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ArqSistema> listArqSistemaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ArqSistemaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ArqSistema
   */
    public ArqSistemaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
