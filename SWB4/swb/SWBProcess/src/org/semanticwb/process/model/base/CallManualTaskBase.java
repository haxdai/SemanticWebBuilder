package org.semanticwb.process.model.base;


public abstract class CallManualTaskBase extends org.semanticwb.process.model.CallTask implements org.semanticwb.model.Traceable,org.semanticwb.process.model.ResourceAssignmentable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass swp_CallManualTask=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CallManualTask");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CallManualTask");

    public static class ClassMgr
    {
       /**
       * Returns a list of CallManualTask for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTasks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.CallManualTask for all models
       * @return Iterator of org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTasks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask>(it, true);
        }

        public static org.semanticwb.process.model.CallManualTask createCallManualTask(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.CallManualTask.ClassMgr.createCallManualTask(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.process.model.CallManualTask
       * @param id Identifier for org.semanticwb.process.model.CallManualTask
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return A org.semanticwb.process.model.CallManualTask
       */
        public static org.semanticwb.process.model.CallManualTask getCallManualTask(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.CallManualTask)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.CallManualTask
       * @param id Identifier for org.semanticwb.process.model.CallManualTask
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return A org.semanticwb.process.model.CallManualTask
       */
        public static org.semanticwb.process.model.CallManualTask createCallManualTask(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.CallManualTask)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.CallManualTask
       * @param id Identifier for org.semanticwb.process.model.CallManualTask
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       */
        public static void removeCallManualTask(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.CallManualTask
       * @param id Identifier for org.semanticwb.process.model.CallManualTask
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return true if the org.semanticwb.process.model.CallManualTask exists, false otherwise
       */

        public static boolean hasCallManualTask(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCallManualTask(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByContainer(org.semanticwb.process.model.Containerable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_container, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByContainer(org.semanticwb.process.model.Containerable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_container,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined FlowObjectInstance
       * @param value FlowObjectInstance of the type org.semanticwb.process.model.FlowNodeInstance
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByFlowObjectInstance(org.semanticwb.process.model.FlowNodeInstance value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasFlowNodeInstanceInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined FlowObjectInstance
       * @param value FlowObjectInstance of the type org.semanticwb.process.model.FlowNodeInstance
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByFlowObjectInstance(org.semanticwb.process.model.FlowNodeInstance value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasFlowNodeInstanceInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined CalledElement
       * @param value CalledElement of the type org.semanticwb.process.model.Callable
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByCalledElement(org.semanticwb.process.model.Callable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_calledElement, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined CalledElement
       * @param value CalledElement of the type org.semanticwb.process.model.Callable
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByCalledElement(org.semanticwb.process.model.Callable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_calledElement,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined ResourceAssignment
       * @param value ResourceAssignment of the type org.semanticwb.process.model.ResourceAssignment
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByResourceAssignment(org.semanticwb.process.model.ResourceAssignment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_resourceAssignment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined ResourceAssignment
       * @param value ResourceAssignment of the type org.semanticwb.process.model.ResourceAssignment
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByResourceAssignment(org.semanticwb.process.model.ResourceAssignment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_resourceAssignment,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByChild(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByChild(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.CallManualTask
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByParent(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_parent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CallManualTask with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.CallManualTask
       */

        public static java.util.Iterator<org.semanticwb.process.model.CallManualTask> listCallManualTaskByParent(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CallManualTask> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_parent,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CallManualTaskBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CallManualTask
   */
    public CallManualTaskBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
