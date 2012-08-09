package com.infotec.conorg.base;


public abstract class TileBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,com.infotec.conorg.Topicable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Tile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Tile");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Tile");

    public static class ClassMgr
    {
       /**
       * Returns a list of Tile for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTiles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Tile for all models
       * @return Iterator of com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTiles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile>(it, true);
        }

        public static com.infotec.conorg.Tile createTile(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Tile.ClassMgr.createTile(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Tile
       * @param id Identifier for com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.Tile
       * @return A com.infotec.conorg.Tile
       */
        public static com.infotec.conorg.Tile getTile(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Tile)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Tile
       * @param id Identifier for com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.Tile
       * @return A com.infotec.conorg.Tile
       */
        public static com.infotec.conorg.Tile createTile(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Tile)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Tile
       * @param id Identifier for com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.Tile
       */
        public static void removeTile(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Tile
       * @param id Identifier for com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.Tile
       * @return true if the com.infotec.conorg.Tile exists, false otherwise
       */

        public static boolean hasTile(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTile(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Tile with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Tile
       */

        public static java.util.Iterator<com.infotec.conorg.Tile> listTileByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TileBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Tile
   */
    public TileBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the com.infotec.conorg.Topic
   * @return A GenericIterator with all the com.infotec.conorg.Topic
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> listTopics()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic>(getSemanticObject().listObjectProperties(conorg_hasTopic));
    }

   /**
   * Gets true if has a Topic
   * @param value com.infotec.conorg.Topic to verify
   * @return true if the com.infotec.conorg.Topic exists, false otherwise
   */
    public boolean hasTopic(com.infotec.conorg.Topic value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasTopic,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Topic
   * @param value com.infotec.conorg.Topic to add
   */

    public void addTopic(com.infotec.conorg.Topic value)
    {
        getSemanticObject().addObjectProperty(conorg_hasTopic, value.getSemanticObject());
    }
   /**
   * Removes all the Topic
   */

    public void removeAllTopic()
    {
        getSemanticObject().removeProperty(conorg_hasTopic);
    }
   /**
   * Removes a Topic
   * @param value com.infotec.conorg.Topic to remove
   */

    public void removeTopic(com.infotec.conorg.Topic value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasTopic,value.getSemanticObject());
    }

   /**
   * Gets the Topic
   * @return a com.infotec.conorg.Topic
   */
    public com.infotec.conorg.Topic getTopic()
    {
         com.infotec.conorg.Topic ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasTopic);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Topic)obj.createGenericInstance();
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
   * Gets all the org.semanticwb.model.Calendar
   * @return A GenericIterator with all the org.semanticwb.model.Calendar
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar> listCalendars()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar>(getSemanticObject().listObjectProperties(swb_hasCalendar));
    }

   /**
   * Gets true if has a Calendar
   * @param value org.semanticwb.model.Calendar to verify
   * @return true if the org.semanticwb.model.Calendar exists, false otherwise
   */
    public boolean hasCalendar(org.semanticwb.model.Calendar value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasCalendar,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Calendar
   * @param value org.semanticwb.model.Calendar to add
   */

    public void addCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().addObjectProperty(swb_hasCalendar, value.getSemanticObject());
    }
   /**
   * Removes all the Calendar
   */

    public void removeAllCalendar()
    {
        getSemanticObject().removeProperty(swb_hasCalendar);
    }
   /**
   * Removes a Calendar
   * @param value org.semanticwb.model.Calendar to remove
   */

    public void removeCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().removeObjectProperty(swb_hasCalendar,value.getSemanticObject());
    }

   /**
   * Gets the Calendar
   * @return a org.semanticwb.model.Calendar
   */
    public org.semanticwb.model.Calendar getCalendar()
    {
         org.semanticwb.model.Calendar ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasCalendar);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Calendar)obj.createGenericInstance();
         }
         return ret;
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
}
