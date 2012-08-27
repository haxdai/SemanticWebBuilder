package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para Arquitecto de Sistemas 
   */
public abstract class ArqSistemaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para Arquitecto de Sistemas
   */
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
       * @return Iterator of com.infotec.cvi.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ArqSistema> listArqSistemas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ArqSistema>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.ArqSistema for all models
       * @return Iterator of com.infotec.cvi.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ArqSistema> listArqSistemas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ArqSistema>(it, true);
        }

        public static com.infotec.cvi.swb.ArqSistema createArqSistema(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.ArqSistema.ClassMgr.createArqSistema(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.ArqSistema
       * @param id Identifier for com.infotec.cvi.swb.ArqSistema
       * @param model Model of the com.infotec.cvi.swb.ArqSistema
       * @return A com.infotec.cvi.swb.ArqSistema
       */
        public static com.infotec.cvi.swb.ArqSistema getArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ArqSistema)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.ArqSistema
       * @param id Identifier for com.infotec.cvi.swb.ArqSistema
       * @param model Model of the com.infotec.cvi.swb.ArqSistema
       * @return A com.infotec.cvi.swb.ArqSistema
       */
        public static com.infotec.cvi.swb.ArqSistema createArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ArqSistema)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.ArqSistema
       * @param id Identifier for com.infotec.cvi.swb.ArqSistema
       * @param model Model of the com.infotec.cvi.swb.ArqSistema
       */
        public static void removeArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.ArqSistema
       * @param id Identifier for com.infotec.cvi.swb.ArqSistema
       * @param model Model of the com.infotec.cvi.swb.ArqSistema
       * @return true if the com.infotec.cvi.swb.ArqSistema exists, false otherwise
       */

        public static boolean hasArqSistema(String id, org.semanticwb.model.SWBModel model)
        {
            return (getArqSistema(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.ArqSistema with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ArqSistema
       * @return Iterator with all the com.infotec.cvi.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ArqSistema> listArqSistemaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ArqSistema with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ArqSistema> listArqSistemaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ArqSistema with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ArqSistema
       * @return Iterator with all the com.infotec.cvi.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ArqSistema> listArqSistemaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ArqSistema with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ArqSistema
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ArqSistema> listArqSistemaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ArqSistema> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
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
