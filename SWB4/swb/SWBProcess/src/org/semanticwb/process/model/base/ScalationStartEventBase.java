package org.semanticwb.process.model.base;


public abstract class ScalationStartEventBase extends org.semanticwb.process.model.StartEventNode implements org.semanticwb.process.model.ActionCodeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Sortable,org.semanticwb.model.Traceable,org.semanticwb.process.model.BPMNSerializable
{
    public static final org.semanticwb.platform.SemanticClass swp_ScalationStartEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ScalationStartEvent");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ScalationStartEvent");

    public static class ClassMgr
    {
       /**
       * Returns a list of ScalationStartEvent for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.ScalationStartEvent for all models
       * @return Iterator of org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent>(it, true);
        }

        public static org.semanticwb.process.model.ScalationStartEvent createScalationStartEvent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.ScalationStartEvent.ClassMgr.createScalationStartEvent(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.process.model.ScalationStartEvent
       * @param id Identifier for org.semanticwb.process.model.ScalationStartEvent
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return A org.semanticwb.process.model.ScalationStartEvent
       */
        public static org.semanticwb.process.model.ScalationStartEvent getScalationStartEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.ScalationStartEvent)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.ScalationStartEvent
       * @param id Identifier for org.semanticwb.process.model.ScalationStartEvent
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return A org.semanticwb.process.model.ScalationStartEvent
       */
        public static org.semanticwb.process.model.ScalationStartEvent createScalationStartEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.ScalationStartEvent)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.ScalationStartEvent
       * @param id Identifier for org.semanticwb.process.model.ScalationStartEvent
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       */
        public static void removeScalationStartEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.ScalationStartEvent
       * @param id Identifier for org.semanticwb.process.model.ScalationStartEvent
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return true if the org.semanticwb.process.model.ScalationStartEvent exists, false otherwise
       */

        public static boolean hasScalationStartEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getScalationStartEvent(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Next
       * @param value Next of the type org.semanticwb.process.model.FlowNode
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByNext(org.semanticwb.process.model.FlowNode value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_ie_next, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Next
       * @param value Next of the type org.semanticwb.process.model.FlowNode
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByNext(org.semanticwb.process.model.FlowNode value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_ie_next,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByContainer(org.semanticwb.process.model.Containerable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_container, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByContainer(org.semanticwb.process.model.Containerable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_container,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByParent(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_parent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByParent(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_parent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Documentation
       * @param value Documentation of the type org.semanticwb.process.model.Documentation
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByDocumentation(org.semanticwb.process.model.Documentation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasDocumentation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Documentation
       * @param value Documentation of the type org.semanticwb.process.model.Documentation
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByDocumentation(org.semanticwb.process.model.Documentation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasDocumentation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined FlowObjectInstance
       * @param value FlowObjectInstance of the type org.semanticwb.process.model.FlowNodeInstance
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByFlowObjectInstance(org.semanticwb.process.model.FlowNodeInstance value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasFlowNodeInstanceInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined FlowObjectInstance
       * @param value FlowObjectInstance of the type org.semanticwb.process.model.FlowNodeInstance
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByFlowObjectInstance(org.semanticwb.process.model.FlowNodeInstance value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasFlowNodeInstanceInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByChild(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByChild(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.ScalationStartEvent
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ScalationStartEvent with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.ScalationStartEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ScalationStartEvent> listScalationStartEventByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ScalationStartEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ScalationStartEventBase.ClassMgr getScalationStartEventClassMgr()
    {
        return new ScalationStartEventBase.ClassMgr();
    }

   /**
   * Constructs a ScalationStartEventBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ScalationStartEvent
   */
    public ScalationStartEventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ActionCode property
* @return String with the ActionCode
*/
    public String getActionCode()
    {
        return getSemanticObject().getProperty(swp_actionCode);
    }

/**
* Sets the ActionCode property
* @param value long with the ActionCode
*/
    public void setActionCode(String value)
    {
        getSemanticObject().setProperty(swp_actionCode, value);
    }

   /**
   * Gets the ProcessSite
   * @return a instance of org.semanticwb.process.model.ProcessSite
   */
    public org.semanticwb.process.model.ProcessSite getProcessSite()
    {
        return (org.semanticwb.process.model.ProcessSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
