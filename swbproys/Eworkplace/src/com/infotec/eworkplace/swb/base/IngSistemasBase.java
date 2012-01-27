package com.infotec.eworkplace.swb.base;


public abstract class IngSistemasBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_IngSistemas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#IngSistemas");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#IngSistemas");

    public static class ClassMgr
    {
       /**
       * Returns a list of IngSistemas for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.IngSistemas
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.IngSistemas> listIngSistemases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.IngSistemas>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.IngSistemas for all models
       * @return Iterator of com.infotec.eworkplace.swb.IngSistemas
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.IngSistemas> listIngSistemases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.IngSistemas>(it, true);
        }

        public static com.infotec.eworkplace.swb.IngSistemas createIngSistemas(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.IngSistemas.ClassMgr.createIngSistemas(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.IngSistemas
       * @param id Identifier for com.infotec.eworkplace.swb.IngSistemas
       * @param model Model of the com.infotec.eworkplace.swb.IngSistemas
       * @return A com.infotec.eworkplace.swb.IngSistemas
       */
        public static com.infotec.eworkplace.swb.IngSistemas getIngSistemas(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.IngSistemas)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.IngSistemas
       * @param id Identifier for com.infotec.eworkplace.swb.IngSistemas
       * @param model Model of the com.infotec.eworkplace.swb.IngSistemas
       * @return A com.infotec.eworkplace.swb.IngSistemas
       */
        public static com.infotec.eworkplace.swb.IngSistemas createIngSistemas(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.IngSistemas)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.IngSistemas
       * @param id Identifier for com.infotec.eworkplace.swb.IngSistemas
       * @param model Model of the com.infotec.eworkplace.swb.IngSistemas
       */
        public static void removeIngSistemas(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.IngSistemas
       * @param id Identifier for com.infotec.eworkplace.swb.IngSistemas
       * @param model Model of the com.infotec.eworkplace.swb.IngSistemas
       * @return true if the com.infotec.eworkplace.swb.IngSistemas exists, false otherwise
       */

        public static boolean hasIngSistemas(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIngSistemas(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.IngSistemas with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.IngSistemas
       * @return Iterator with all the com.infotec.eworkplace.swb.IngSistemas
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.IngSistemas> listIngSistemasByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.IngSistemas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.IngSistemas with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.IngSistemas
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.IngSistemas> listIngSistemasByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.IngSistemas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.IngSistemas with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.IngSistemas
       * @return Iterator with all the com.infotec.eworkplace.swb.IngSistemas
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.IngSistemas> listIngSistemasByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.IngSistemas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.IngSistemas with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.IngSistemas
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.IngSistemas> listIngSistemasByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.IngSistemas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a IngSistemasBase with a SemanticObject
   * @param base The SemanticObject with the properties for the IngSistemas
   */
    public IngSistemasBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
