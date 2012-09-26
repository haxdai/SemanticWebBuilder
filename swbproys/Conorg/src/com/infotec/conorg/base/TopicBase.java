package com.infotec.conorg.base;


public abstract class TopicBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Topic");
    public static final org.semanticwb.platform.SemanticProperty conorg_parentTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#parentTopic");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Topic");

    public static class ClassMgr
    {
       /**
       * Returns a list of Topic for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopics(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Topic for all models
       * @return Iterator of com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopics()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic>(it, true);
        }

        public static com.infotec.conorg.Topic createTopic(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Topic.ClassMgr.createTopic(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Topic
       * @param id Identifier for com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Topic
       * @return A com.infotec.conorg.Topic
       */
        public static com.infotec.conorg.Topic getTopic(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Topic)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Topic
       * @param id Identifier for com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Topic
       * @return A com.infotec.conorg.Topic
       */
        public static com.infotec.conorg.Topic createTopic(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Topic)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Topic
       * @param id Identifier for com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Topic
       */
        public static void removeTopic(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Topic
       * @param id Identifier for com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Topic
       * @return true if the com.infotec.conorg.Topic exists, false otherwise
       */

        public static boolean hasTopic(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTopic(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Topic with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopicByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Topic with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopicByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Topic with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopicByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Topic with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopicByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Topic with a determined ParentTopic
       * @param value ParentTopic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopicByParentTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_parentTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Topic with a determined ParentTopic
       * @param value ParentTopic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Topic
       */

        public static java.util.Iterator<com.infotec.conorg.Topic> listTopicByParentTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_parentTopic,value.getSemanticObject(),sclass));
            return it;
        }
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
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }
   /**
   * Sets the value for the property ParentTopic
   * @param value ParentTopic to set
   */

    public void setParentTopic(com.infotec.conorg.Topic value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_parentTopic, value.getSemanticObject());
        }else
        {
            removeParentTopic();
        }
    }
   /**
   * Remove the value for ParentTopic property
   */

    public void removeParentTopic()
    {
        getSemanticObject().removeProperty(conorg_parentTopic);
    }

   /**
   * Gets the ParentTopic
   * @return a com.infotec.conorg.Topic
   */
    public com.infotec.conorg.Topic getParentTopic()
    {
         com.infotec.conorg.Topic ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_parentTopic);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Topic)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }

   /**
   * Gets the Place
   * @return a instance of com.infotec.conorg.Place
   */
    public com.infotec.conorg.Place getPlace()
    {
        return (com.infotec.conorg.Place)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
