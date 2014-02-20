package org.semanticwb.applicate.base;


public abstract class EventDefinitionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass app_EventGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventGroup");
    public static final org.semanticwb.platform.SemanticProperty app_hasEventGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasEventGroup");
    public static final org.semanticwb.platform.SemanticProperty app_event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#event");
    public static final org.semanticwb.platform.SemanticProperty app_maxEventGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#maxEventGroup");
    public static final org.semanticwb.platform.SemanticClass app_EventDefinition=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventDefinition");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventDefinition");

    public static class ClassMgr
    {
       /**
       * Returns a list of EventDefinition for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.EventDefinition
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventDefinition> listEventDefinitions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventDefinition>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.EventDefinition for all models
       * @return Iterator of org.semanticwb.applicate.EventDefinition
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventDefinition> listEventDefinitions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventDefinition>(it, true);
        }

        public static org.semanticwb.applicate.EventDefinition createEventDefinition(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.EventDefinition.ClassMgr.createEventDefinition(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.EventDefinition
       * @param id Identifier for org.semanticwb.applicate.EventDefinition
       * @param model Model of the org.semanticwb.applicate.EventDefinition
       * @return A org.semanticwb.applicate.EventDefinition
       */
        public static org.semanticwb.applicate.EventDefinition getEventDefinition(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.EventDefinition)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.EventDefinition
       * @param id Identifier for org.semanticwb.applicate.EventDefinition
       * @param model Model of the org.semanticwb.applicate.EventDefinition
       * @return A org.semanticwb.applicate.EventDefinition
       */
        public static org.semanticwb.applicate.EventDefinition createEventDefinition(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.EventDefinition)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.EventDefinition
       * @param id Identifier for org.semanticwb.applicate.EventDefinition
       * @param model Model of the org.semanticwb.applicate.EventDefinition
       */
        public static void removeEventDefinition(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.EventDefinition
       * @param id Identifier for org.semanticwb.applicate.EventDefinition
       * @param model Model of the org.semanticwb.applicate.EventDefinition
       * @return true if the org.semanticwb.applicate.EventDefinition exists, false otherwise
       */

        public static boolean hasEventDefinition(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEventDefinition(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.applicate.EventDefinition with a determined EventGroup
       * @param value EventGroup of the type org.semanticwb.applicate.EventGroup
       * @param model Model of the org.semanticwb.applicate.EventDefinition
       * @return Iterator with all the org.semanticwb.applicate.EventDefinition
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventDefinition> listEventDefinitionByEventGroup(org.semanticwb.applicate.EventGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventDefinition> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(app_hasEventGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.applicate.EventDefinition with a determined EventGroup
       * @param value EventGroup of the type org.semanticwb.applicate.EventGroup
       * @return Iterator with all the org.semanticwb.applicate.EventDefinition
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventDefinition> listEventDefinitionByEventGroup(org.semanticwb.applicate.EventGroup value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventDefinition> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(app_hasEventGroup,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static EventDefinitionBase.ClassMgr getEventDefinitionClassMgr()
    {
        return new EventDefinitionBase.ClassMgr();
    }

   /**
   * Constructs a EventDefinitionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EventDefinition
   */
    public EventDefinitionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.applicate.EventGroup
   * @return A GenericIterator with all the org.semanticwb.applicate.EventGroup
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup> listEventGroups()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup>(getSemanticObject().listObjectProperties(app_hasEventGroup));
    }

   /**
   * Gets true if has a EventGroup
   * @param value org.semanticwb.applicate.EventGroup to verify
   * @return true if the org.semanticwb.applicate.EventGroup exists, false otherwise
   */
    public boolean hasEventGroup(org.semanticwb.applicate.EventGroup value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(app_hasEventGroup,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EventGroup
   * @param value org.semanticwb.applicate.EventGroup to add
   */

    public void addEventGroup(org.semanticwb.applicate.EventGroup value)
    {
        getSemanticObject().addObjectProperty(app_hasEventGroup, value.getSemanticObject());
    }
   /**
   * Removes all the EventGroup
   */

    public void removeAllEventGroup()
    {
        getSemanticObject().removeProperty(app_hasEventGroup);
    }
   /**
   * Removes a EventGroup
   * @param value org.semanticwb.applicate.EventGroup to remove
   */

    public void removeEventGroup(org.semanticwb.applicate.EventGroup value)
    {
        getSemanticObject().removeObjectProperty(app_hasEventGroup,value.getSemanticObject());
    }

   /**
   * Gets the EventGroup
   * @return a org.semanticwb.applicate.EventGroup
   */
    public org.semanticwb.applicate.EventGroup getEventGroup()
    {
         org.semanticwb.applicate.EventGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(app_hasEventGroup);
         if(obj!=null)
         {
             ret=(org.semanticwb.applicate.EventGroup)obj.createGenericInstance();
         }
         return ret;
    }

    public void setEvent(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(app_event, value);
    }

    public void removeEvent()
    {
        getSemanticObject().removeProperty(app_event);
    }

/**
* Gets the Event property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getEvent()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(app_event);
         return ret;
    }

/**
* Gets the MaxEventGroup property
* @return int with the MaxEventGroup
*/
    public int getMaxEventGroup()
    {
        return getSemanticObject().getIntProperty(app_maxEventGroup);
    }

/**
* Sets the MaxEventGroup property
* @param value long with the MaxEventGroup
*/
    public void setMaxEventGroup(int value)
    {
        getSemanticObject().setIntProperty(app_maxEventGroup, value);
    }
}
