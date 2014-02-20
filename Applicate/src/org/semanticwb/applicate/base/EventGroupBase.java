package org.semanticwb.applicate.base;


public abstract class EventGroupBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty app_userEventGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#userEventGroup");
    public static final org.semanticwb.platform.SemanticProperty app_nameGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#nameGroup");
    public static final org.semanticwb.platform.SemanticProperty app_folio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#folio");
    public static final org.semanticwb.platform.SemanticClass app_EventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventMember");
    public static final org.semanticwb.platform.SemanticProperty app_hasEventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasEventMember");
    public static final org.semanticwb.platform.SemanticClass app_EventGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventGroup");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventGroup");

    public static class ClassMgr
    {
       /**
       * Returns a list of EventGroup for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.EventGroup
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventGroup> listEventGroups(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.EventGroup for all models
       * @return Iterator of org.semanticwb.applicate.EventGroup
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventGroup> listEventGroups()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup>(it, true);
        }

        public static org.semanticwb.applicate.EventGroup createEventGroup(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.EventGroup.ClassMgr.createEventGroup(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.EventGroup
       * @param id Identifier for org.semanticwb.applicate.EventGroup
       * @param model Model of the org.semanticwb.applicate.EventGroup
       * @return A org.semanticwb.applicate.EventGroup
       */
        public static org.semanticwb.applicate.EventGroup getEventGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.EventGroup)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.EventGroup
       * @param id Identifier for org.semanticwb.applicate.EventGroup
       * @param model Model of the org.semanticwb.applicate.EventGroup
       * @return A org.semanticwb.applicate.EventGroup
       */
        public static org.semanticwb.applicate.EventGroup createEventGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.EventGroup)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.EventGroup
       * @param id Identifier for org.semanticwb.applicate.EventGroup
       * @param model Model of the org.semanticwb.applicate.EventGroup
       */
        public static void removeEventGroup(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.EventGroup
       * @param id Identifier for org.semanticwb.applicate.EventGroup
       * @param model Model of the org.semanticwb.applicate.EventGroup
       * @return true if the org.semanticwb.applicate.EventGroup exists, false otherwise
       */

        public static boolean hasEventGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEventGroup(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.applicate.EventGroup with a determined UserEventGroup
       * @param value UserEventGroup of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.applicate.EventGroup
       * @return Iterator with all the org.semanticwb.applicate.EventGroup
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventGroup> listEventGroupByUserEventGroup(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(app_userEventGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.applicate.EventGroup with a determined UserEventGroup
       * @param value UserEventGroup of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.applicate.EventGroup
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventGroup> listEventGroupByUserEventGroup(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(app_userEventGroup,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.applicate.EventGroup with a determined EventMember
       * @param value EventMember of the type org.semanticwb.applicate.EventMember
       * @param model Model of the org.semanticwb.applicate.EventGroup
       * @return Iterator with all the org.semanticwb.applicate.EventGroup
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventGroup> listEventGroupByEventMember(org.semanticwb.applicate.EventMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(app_hasEventMember, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.applicate.EventGroup with a determined EventMember
       * @param value EventMember of the type org.semanticwb.applicate.EventMember
       * @return Iterator with all the org.semanticwb.applicate.EventGroup
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventGroup> listEventGroupByEventMember(org.semanticwb.applicate.EventMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(app_hasEventMember,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static EventGroupBase.ClassMgr getEventGroupClassMgr()
    {
        return new EventGroupBase.ClassMgr();
    }

   /**
   * Constructs a EventGroupBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EventGroup
   */
    public EventGroupBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property UserEventGroup
   * @param value UserEventGroup to set
   */

    public void setUserEventGroup(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(app_userEventGroup, value.getSemanticObject());
        }else
        {
            removeUserEventGroup();
        }
    }
   /**
   * Remove the value for UserEventGroup property
   */

    public void removeUserEventGroup()
    {
        getSemanticObject().removeProperty(app_userEventGroup);
    }

   /**
   * Gets the UserEventGroup
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUserEventGroup()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(app_userEventGroup);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NameGroup property
* @return String with the NameGroup
*/
    public String getNameGroup()
    {
        return getSemanticObject().getProperty(app_nameGroup);
    }

/**
* Sets the NameGroup property
* @param value long with the NameGroup
*/
    public void setNameGroup(String value)
    {
        getSemanticObject().setProperty(app_nameGroup, value);
    }

/**
* Gets the Folio property
* @return String with the Folio
*/
    public String getFolio()
    {
        return getSemanticObject().getProperty(app_folio);
    }

/**
* Sets the Folio property
* @param value long with the Folio
*/
    public void setFolio(String value)
    {
        getSemanticObject().setProperty(app_folio, value);
    }
   /**
   * Gets all the org.semanticwb.applicate.EventMember
   * @return A GenericIterator with all the org.semanticwb.applicate.EventMember
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventMember> listEventMembers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventMember>(getSemanticObject().listObjectProperties(app_hasEventMember));
    }

   /**
   * Gets true if has a EventMember
   * @param value org.semanticwb.applicate.EventMember to verify
   * @return true if the org.semanticwb.applicate.EventMember exists, false otherwise
   */
    public boolean hasEventMember(org.semanticwb.applicate.EventMember value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(app_hasEventMember,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EventMember
   * @param value org.semanticwb.applicate.EventMember to add
   */

    public void addEventMember(org.semanticwb.applicate.EventMember value)
    {
        getSemanticObject().addObjectProperty(app_hasEventMember, value.getSemanticObject());
    }
   /**
   * Removes all the EventMember
   */

    public void removeAllEventMember()
    {
        getSemanticObject().removeProperty(app_hasEventMember);
    }
   /**
   * Removes a EventMember
   * @param value org.semanticwb.applicate.EventMember to remove
   */

    public void removeEventMember(org.semanticwb.applicate.EventMember value)
    {
        getSemanticObject().removeObjectProperty(app_hasEventMember,value.getSemanticObject());
    }

   /**
   * Gets the EventMember
   * @return a org.semanticwb.applicate.EventMember
   */
    public org.semanticwb.applicate.EventMember getEventMember()
    {
         org.semanticwb.applicate.EventMember ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(app_hasEventMember);
         if(obj!=null)
         {
             ret=(org.semanticwb.applicate.EventMember)obj.createGenericInstance();
         }
         return ret;
    }
}
