package com.infotec.conorg.base;


public abstract class ResourceBase extends com.infotec.conorg.Tile implements org.semanticwb.model.Resourceable,org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,com.infotec.conorg.Topicable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Resource");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Resource");

    public static class ClassMgr
    {
       /**
       * Returns a list of Resource for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResources(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Resource for all models
       * @return Iterator of com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResources()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource>(it, true);
        }

        public static com.infotec.conorg.Resource createResource(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Resource.ClassMgr.createResource(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Resource
       * @param id Identifier for com.infotec.conorg.Resource
       * @param model Model of the com.infotec.conorg.Resource
       * @return A com.infotec.conorg.Resource
       */
        public static com.infotec.conorg.Resource getResource(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Resource)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Resource
       * @param id Identifier for com.infotec.conorg.Resource
       * @param model Model of the com.infotec.conorg.Resource
       * @return A com.infotec.conorg.Resource
       */
        public static com.infotec.conorg.Resource createResource(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Resource)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Resource
       * @param id Identifier for com.infotec.conorg.Resource
       * @param model Model of the com.infotec.conorg.Resource
       */
        public static void removeResource(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Resource
       * @param id Identifier for com.infotec.conorg.Resource
       * @param model Model of the com.infotec.conorg.Resource
       * @return true if the com.infotec.conorg.Resource exists, false otherwise
       */

        public static boolean hasResource(String id, org.semanticwb.model.SWBModel model)
        {
            return (getResource(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Resource
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Resource
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Resource
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Resource
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.conorg.Resource
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Resource with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.conorg.Resource
       */

        public static java.util.Iterator<com.infotec.conorg.Resource> listResourceByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Resource> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ResourceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Resource
   */
    public ResourceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.model.Resource
   * @return A GenericIterator with all the org.semanticwb.model.Resource
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource>(getSemanticObject().listObjectProperties(swb_hasResource));
    }

   /**
   * Gets true if has a Resource
   * @param value org.semanticwb.model.Resource to verify
   * @return true if the org.semanticwb.model.Resource exists, false otherwise
   */
    public boolean hasResource(org.semanticwb.model.Resource value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasResource,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Resource
   * @param value org.semanticwb.model.Resource to add
   */

    public void addResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().addObjectProperty(swb_hasResource, value.getSemanticObject());
    }
   /**
   * Removes all the Resource
   */

    public void removeAllResource()
    {
        getSemanticObject().removeProperty(swb_hasResource);
    }
   /**
   * Removes a Resource
   * @param value org.semanticwb.model.Resource to remove
   */

    public void removeResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().removeObjectProperty(swb_hasResource,value.getSemanticObject());
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasResource);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }
}
