package com.infotec.conorg.base;


public abstract class PlaceBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Member=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Member");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasMember");
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasWorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasWorkSpace");
    public static final org.semanticwb.platform.SemanticClass conorg_Place=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Place");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Place");

    public static class ClassMgr
    {
       /**
       * Returns a list of Place for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaces(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Place>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Place for all models
       * @return Iterator of com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaces()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Place>(it, true);
        }

        public static com.infotec.conorg.Place createPlace(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Place.ClassMgr.createPlace(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @param model Model of the com.infotec.conorg.Place
       * @return A com.infotec.conorg.Place
       */
        public static com.infotec.conorg.Place getPlace(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Place)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @param model Model of the com.infotec.conorg.Place
       * @return A com.infotec.conorg.Place
       */
        public static com.infotec.conorg.Place createPlace(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Place)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @param model Model of the com.infotec.conorg.Place
       */
        public static void removePlace(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Place
       * @param id Identifier for com.infotec.conorg.Place
       * @param model Model of the com.infotec.conorg.Place
       * @return true if the com.infotec.conorg.Place exists, false otherwise
       */

        public static boolean hasPlace(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPlace(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Member
       * @param value Member of the type com.infotec.conorg.Member
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByMember(com.infotec.conorg.Member value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasMember, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined Member
       * @param value Member of the type com.infotec.conorg.Member
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByMember(com.infotec.conorg.Member value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasMember,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined WorkSpace
       * @param value WorkSpace of the type com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByWorkSpace(com.infotec.conorg.WorkSpace value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasWorkSpace, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Place with a determined WorkSpace
       * @param value WorkSpace of the type com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.Place
       */

        public static java.util.Iterator<com.infotec.conorg.Place> listPlaceByWorkSpace(com.infotec.conorg.WorkSpace value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Place> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasWorkSpace,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PlaceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Place
   */
    public PlaceBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the com.infotec.conorg.Member
   * @return A GenericIterator with all the com.infotec.conorg.Member
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> listMembers()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Member>(getSemanticObject().listObjectProperties(conorg_hasMember));
    }

   /**
   * Gets true if has a Member
   * @param value com.infotec.conorg.Member to verify
   * @return true if the com.infotec.conorg.Member exists, false otherwise
   */
    public boolean hasMember(com.infotec.conorg.Member value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasMember,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Member
   * @param value com.infotec.conorg.Member to add
   */

    public void addMember(com.infotec.conorg.Member value)
    {
        getSemanticObject().addObjectProperty(conorg_hasMember, value.getSemanticObject());
    }
   /**
   * Removes all the Member
   */

    public void removeAllMember()
    {
        getSemanticObject().removeProperty(conorg_hasMember);
    }
   /**
   * Removes a Member
   * @param value com.infotec.conorg.Member to remove
   */

    public void removeMember(com.infotec.conorg.Member value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasMember,value.getSemanticObject());
    }

   /**
   * Gets the Member
   * @return a com.infotec.conorg.Member
   */
    public com.infotec.conorg.Member getMember()
    {
         com.infotec.conorg.Member ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasMember);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Member)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.conorg.WorkSpace
   * @return A GenericIterator with all the com.infotec.conorg.WorkSpace
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> listWorkSpaces()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace>(getSemanticObject().listObjectProperties(conorg_hasWorkSpace));
    }

   /**
   * Gets true if has a WorkSpace
   * @param value com.infotec.conorg.WorkSpace to verify
   * @return true if the com.infotec.conorg.WorkSpace exists, false otherwise
   */
    public boolean hasWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasWorkSpace,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a WorkSpace
   * @param value com.infotec.conorg.WorkSpace to add
   */

    public void addWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        getSemanticObject().addObjectProperty(conorg_hasWorkSpace, value.getSemanticObject());
    }
   /**
   * Removes all the WorkSpace
   */

    public void removeAllWorkSpace()
    {
        getSemanticObject().removeProperty(conorg_hasWorkSpace);
    }
   /**
   * Removes a WorkSpace
   * @param value com.infotec.conorg.WorkSpace to remove
   */

    public void removeWorkSpace(com.infotec.conorg.WorkSpace value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasWorkSpace,value.getSemanticObject());
    }

   /**
   * Gets the WorkSpace
   * @return a com.infotec.conorg.WorkSpace
   */
    public com.infotec.conorg.WorkSpace getWorkSpace()
    {
         com.infotec.conorg.WorkSpace ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasWorkSpace);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.WorkSpace)obj.createGenericInstance();
         }
         return ret;
    }
}
