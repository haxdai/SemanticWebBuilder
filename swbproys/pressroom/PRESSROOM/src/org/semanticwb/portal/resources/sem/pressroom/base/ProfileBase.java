package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class ProfileBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_wite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#wite");
    public static final org.semanticwb.platform.SemanticProperty swbpress_publish=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#publish");
    public static final org.semanticwb.platform.SemanticProperty swbpress_read=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#read");
    public static final org.semanticwb.platform.SemanticClass swbpress_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Category");
    public static final org.semanticwb.platform.SemanticProperty swbpress_hasCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#hasCategory");
    public static final org.semanticwb.platform.SemanticProperty swbpress_administration=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#administration");
    public static final org.semanticwb.platform.SemanticProperty swbpress_delete=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#delete");
    public static final org.semanticwb.platform.SemanticClass swbpress_Profile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Profile");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Profile");

    public static class ClassMgr
    {
       /**
       * Returns a list of Profile for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfiles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.portal.resources.sem.pressroom.Profile for all models
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfiles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Profile createProfile(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Profile.ClassMgr.createProfile(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       * @return A org.semanticwb.portal.resources.sem.pressroom.Profile
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Profile getProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Profile)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       * @return A org.semanticwb.portal.resources.sem.pressroom.Profile
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Profile createProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Profile)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       */
        public static void removeProfile(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Profile
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       * @return true if the org.semanticwb.portal.resources.sem.pressroom.Profile exists, false otherwise
       */

        public static boolean hasProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProfile(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Profile with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfileByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Profile with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfileByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Profile with a determined Category
       * @param value Category of the type org.semanticwb.portal.resources.sem.pressroom.Category
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfileByCategory(org.semanticwb.portal.resources.sem.pressroom.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasCategory, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Profile with a determined Category
       * @param value Category of the type org.semanticwb.portal.resources.sem.pressroom.Category
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfileByCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasCategory,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Profile with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Profile
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfileByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Profile with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Profile
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Profile> listProfileByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Profile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProfileBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Profile
   */
    public ProfileBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Wite property
* @return boolean with the Wite
*/
    public boolean isWite()
    {
        return getSemanticObject().getBooleanProperty(swbpress_wite);
    }

/**
* Sets the Wite property
* @param value long with the Wite
*/
    public void setWite(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbpress_wite, value);
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
* Gets the Publish property
* @return boolean with the Publish
*/
    public boolean isPublish()
    {
        return getSemanticObject().getBooleanProperty(swbpress_publish);
    }

/**
* Sets the Publish property
* @param value long with the Publish
*/
    public void setPublish(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbpress_publish, value);
    }

/**
* Gets the Read property
* @return boolean with the Read
*/
    public boolean isRead()
    {
        return getSemanticObject().getBooleanProperty(swbpress_read);
    }

/**
* Sets the Read property
* @param value long with the Read
*/
    public void setRead(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbpress_read, value);
    }
   /**
   * Gets all the org.semanticwb.portal.resources.sem.pressroom.Category
   * @return A GenericIterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategories()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category>(getSemanticObject().listObjectProperties(swbpress_hasCategory));
    }

   /**
   * Gets true if has a Category
   * @param value org.semanticwb.portal.resources.sem.pressroom.Category to verify
   * @return true if the org.semanticwb.portal.resources.sem.pressroom.Category exists, false otherwise
   */
    public boolean hasCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbpress_hasCategory,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Category
   * @param value org.semanticwb.portal.resources.sem.pressroom.Category to add
   */

    public void addCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
    {
        getSemanticObject().addObjectProperty(swbpress_hasCategory, value.getSemanticObject());
    }
   /**
   * Removes all the Category
   */

    public void removeAllCategory()
    {
        getSemanticObject().removeProperty(swbpress_hasCategory);
    }
   /**
   * Removes a Category
   * @param value org.semanticwb.portal.resources.sem.pressroom.Category to remove
   */

    public void removeCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
    {
        getSemanticObject().removeObjectProperty(swbpress_hasCategory,value.getSemanticObject());
    }

   /**
   * Gets the Category
   * @return a org.semanticwb.portal.resources.sem.pressroom.Category
   */
    public org.semanticwb.portal.resources.sem.pressroom.Category getCategory()
    {
         org.semanticwb.portal.resources.sem.pressroom.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_hasCategory);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Category)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Administration property
* @return boolean with the Administration
*/
    public boolean isAdministration()
    {
        return getSemanticObject().getBooleanProperty(swbpress_administration);
    }

/**
* Sets the Administration property
* @param value long with the Administration
*/
    public void setAdministration(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbpress_administration, value);
    }

/**
* Gets the Delete property
* @return boolean with the Delete
*/
    public boolean isDelete()
    {
        return getSemanticObject().getBooleanProperty(swbpress_delete);
    }

/**
* Sets the Delete property
* @param value long with the Delete
*/
    public void setDelete(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbpress_delete, value);
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
}
