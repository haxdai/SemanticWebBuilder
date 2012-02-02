package com.infotec.eworkplace.swb.base;


public abstract class EmprendedorBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Emprendedor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Emprendedor");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Emprendedor");

    public static class ClassMgr
    {
       /**
       * Returns a list of Emprendedor for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Emprendedor
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Emprendedor> listEmprendedors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Emprendedor>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Emprendedor for all models
       * @return Iterator of com.infotec.eworkplace.swb.Emprendedor
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Emprendedor> listEmprendedors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Emprendedor>(it, true);
        }

        public static com.infotec.eworkplace.swb.Emprendedor createEmprendedor(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Emprendedor.ClassMgr.createEmprendedor(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Emprendedor
       * @param id Identifier for com.infotec.eworkplace.swb.Emprendedor
       * @param model Model of the com.infotec.eworkplace.swb.Emprendedor
       * @return A com.infotec.eworkplace.swb.Emprendedor
       */
        public static com.infotec.eworkplace.swb.Emprendedor getEmprendedor(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Emprendedor)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Emprendedor
       * @param id Identifier for com.infotec.eworkplace.swb.Emprendedor
       * @param model Model of the com.infotec.eworkplace.swb.Emprendedor
       * @return A com.infotec.eworkplace.swb.Emprendedor
       */
        public static com.infotec.eworkplace.swb.Emprendedor createEmprendedor(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Emprendedor)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Emprendedor
       * @param id Identifier for com.infotec.eworkplace.swb.Emprendedor
       * @param model Model of the com.infotec.eworkplace.swb.Emprendedor
       */
        public static void removeEmprendedor(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Emprendedor
       * @param id Identifier for com.infotec.eworkplace.swb.Emprendedor
       * @param model Model of the com.infotec.eworkplace.swb.Emprendedor
       * @return true if the com.infotec.eworkplace.swb.Emprendedor exists, false otherwise
       */

        public static boolean hasEmprendedor(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEmprendedor(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Emprendedor with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Emprendedor
       * @return Iterator with all the com.infotec.eworkplace.swb.Emprendedor
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Emprendedor> listEmprendedorByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Emprendedor> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Emprendedor with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Emprendedor
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Emprendedor> listEmprendedorByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Emprendedor> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Emprendedor with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Emprendedor
       * @return Iterator with all the com.infotec.eworkplace.swb.Emprendedor
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Emprendedor> listEmprendedorByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Emprendedor> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Emprendedor with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Emprendedor
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Emprendedor> listEmprendedorByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Emprendedor> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EmprendedorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Emprendedor
   */
    public EmprendedorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
