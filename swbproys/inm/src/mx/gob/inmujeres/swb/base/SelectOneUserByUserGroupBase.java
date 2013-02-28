package mx.gob.inmujeres.swb.base;


public abstract class SelectOneUserByUserGroupBase extends org.semanticwb.model.SelectOne 
{
    public static final org.semanticwb.platform.SemanticClass inm_SelectOneUserByUserGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SelectOneUserByUserGroup");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SelectOneUserByUserGroup");

    public static class ClassMgr
    {
       /**
       * Returns a list of SelectOneUserByUserGroup for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SelectOneUserByUserGroup> listSelectOneUserByUserGroups(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SelectOneUserByUserGroup>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.SelectOneUserByUserGroup for all models
       * @return Iterator of mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SelectOneUserByUserGroup> listSelectOneUserByUserGroups()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SelectOneUserByUserGroup>(it, true);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param id Identifier for mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param model Model of the mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @return A mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       */
        public static mx.gob.inmujeres.swb.SelectOneUserByUserGroup getSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SelectOneUserByUserGroup)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param id Identifier for mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param model Model of the mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @return A mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       */
        public static mx.gob.inmujeres.swb.SelectOneUserByUserGroup createSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SelectOneUserByUserGroup)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param id Identifier for mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param model Model of the mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       */
        public static void removeSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param id Identifier for mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @param model Model of the mx.gob.inmujeres.swb.SelectOneUserByUserGroup
       * @return true if the mx.gob.inmujeres.swb.SelectOneUserByUserGroup exists, false otherwise
       */

        public static boolean hasSelectOneUserByUserGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSelectOneUserByUserGroup(id, model)!=null);
        }
    }

    public static SelectOneUserByUserGroupBase.ClassMgr getSelectOneUserByUserGroupClassMgr()
    {
        return new SelectOneUserByUserGroupBase.ClassMgr();
    }

   /**
   * Constructs a SelectOneUserByUserGroupBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SelectOneUserByUserGroup
   */
    public SelectOneUserByUserGroupBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
