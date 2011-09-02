package com.infotec.conorg.base;


public abstract class WorkSpaceBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Calendarable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Place=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Place");
    public static final org.semanticwb.platform.SemanticProperty conorg_placeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#placeInv");
    public static final org.semanticwb.platform.SemanticClass conorg_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Topic");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasTopic");
    public static final org.semanticwb.platform.SemanticClass conorg_Tile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Tile");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasTile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasTile");
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");

    public static class ClassMgr
    {
       /**
       * Returns a list of WorkSpace for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaces(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.WorkSpace for all models
       * @return Iterator of com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaces()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace>(it, true);
        }

        public static com.infotec.conorg.WorkSpace createWorkSpace(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.WorkSpace.ClassMgr.createWorkSpace(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return A com.infotec.conorg.WorkSpace
       */
        public static com.infotec.conorg.WorkSpace getWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.WorkSpace)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return A com.infotec.conorg.WorkSpace
       */
        public static com.infotec.conorg.WorkSpace createWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.WorkSpace)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       */
        public static void removeWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return true if the com.infotec.conorg.WorkSpace exists, false otherwise
       */

        public static boolean hasWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            return (getWorkSpace(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Place
       * @param value Place of the type com.infotec.conorg.Place
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByPlace(com.infotec.conorg.Place value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_placeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Place
       * @param value Place of the type com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByPlace(com.infotec.conorg.Place value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_placeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTile(com.infotec.conorg.Tile value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTile(com.infotec.conorg.Tile value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a WorkSpaceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the WorkSpace
   */
    public WorkSpaceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Place
   * @param value Place to set
   */

    public void setPlace(com.infotec.conorg.Place value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_placeInv, value.getSemanticObject());
        }else
        {
            removePlace();
        }
    }
   /**
   * Remove the value for Place property
   */

    public void removePlace()
    {
        getSemanticObject().removeProperty(conorg_placeInv);
    }

   /**
   * Gets the Place
   * @return a com.infotec.conorg.Place
   */
    public com.infotec.conorg.Place getPlace()
    {
         com.infotec.conorg.Place ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_placeInv);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Place)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the com.infotec.conorg.Tile
   * @return A GenericIterator with all the com.infotec.conorg.Tile
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> listTiles()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile>(getSemanticObject().listObjectProperties(conorg_hasTile));
    }

   /**
   * Gets true if has a Tile
   * @param value com.infotec.conorg.Tile to verify
   * @return true if the com.infotec.conorg.Tile exists, false otherwise
   */
    public boolean hasTile(com.infotec.conorg.Tile value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasTile,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Tile
   * @param value com.infotec.conorg.Tile to add
   */

    public void addTile(com.infotec.conorg.Tile value)
    {
        getSemanticObject().addObjectProperty(conorg_hasTile, value.getSemanticObject());
    }
   /**
   * Removes all the Tile
   */

    public void removeAllTile()
    {
        getSemanticObject().removeProperty(conorg_hasTile);
    }
   /**
   * Removes a Tile
   * @param value com.infotec.conorg.Tile to remove
   */

    public void removeTile(com.infotec.conorg.Tile value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasTile,value.getSemanticObject());
    }

   /**
   * Gets the Tile
   * @return a com.infotec.conorg.Tile
   */
    public com.infotec.conorg.Tile getTile()
    {
         com.infotec.conorg.Tile ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasTile);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Tile)obj.createGenericInstance();
         }
         return ret;
    }
}
