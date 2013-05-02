package com.infotec.lodp.swb.base;


public abstract class TopicBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticClass lodp_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#Topic");
    public static final org.semanticwb.platform.SemanticProperty lodp_parentTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#parentTopic");
    public static final org.semanticwb.platform.SemanticProperty lodp_topicTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#topicTitle");
    public static final org.semanticwb.platform.SemanticProperty lodp_topicDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#topicDescription");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Topic");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Topic");

    public static class ClassMgr
    {
       /**
       * Returns a list of Topic for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Topic
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Topic> listTopics(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Topic>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Topic for all models
       * @return Iterator of com.infotec.lodp.swb.Topic
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Topic> listTopics()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Topic>(it, true);
        }

        public static com.infotec.lodp.swb.Topic createTopic(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Topic.ClassMgr.createTopic(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Topic
       * @param id Identifier for com.infotec.lodp.swb.Topic
       * @param model Model of the com.infotec.lodp.swb.Topic
       * @return A com.infotec.lodp.swb.Topic
       */
        public static com.infotec.lodp.swb.Topic getTopic(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Topic)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Topic
       * @param id Identifier for com.infotec.lodp.swb.Topic
       * @param model Model of the com.infotec.lodp.swb.Topic
       * @return A com.infotec.lodp.swb.Topic
       */
        public static com.infotec.lodp.swb.Topic createTopic(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Topic)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Topic
       * @param id Identifier for com.infotec.lodp.swb.Topic
       * @param model Model of the com.infotec.lodp.swb.Topic
       */
        public static void removeTopic(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Topic
       * @param id Identifier for com.infotec.lodp.swb.Topic
       * @param model Model of the com.infotec.lodp.swb.Topic
       * @return true if the com.infotec.lodp.swb.Topic exists, false otherwise
       */

        public static boolean hasTopic(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTopic(id, model)!=null);
        }
    }

    public static TopicBase.ClassMgr getTopicClassMgr()
    {
        return new TopicBase.ClassMgr();
    }

   /**
   * Constructs a TopicBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Topic
   */
    public TopicBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Topic object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Topic object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

    public void setParentTopic(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(lodp_parentTopic, value);
    }

    public void removeParentTopic()
    {
        getSemanticObject().removeProperty(lodp_parentTopic);
    }

/**
* Gets the ParentTopic property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getParentTopic()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(lodp_parentTopic);
         return ret;
    }

/**
* Gets the TopicTitle property
* @return String with the TopicTitle
*/
    public String getTopicTitle()
    {
        return getSemanticObject().getProperty(lodp_topicTitle);
    }

/**
* Sets the TopicTitle property
* @param value long with the TopicTitle
*/
    public void setTopicTitle(String value)
    {
        getSemanticObject().setProperty(lodp_topicTitle, value);
    }

/**
* Gets the TopicDescription property
* @return String with the TopicDescription
*/
    public String getTopicDescription()
    {
        return getSemanticObject().getProperty(lodp_topicDescription);
    }

/**
* Sets the TopicDescription property
* @param value long with the TopicDescription
*/
    public void setTopicDescription(String value)
    {
        getSemanticObject().setProperty(lodp_topicDescription, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
