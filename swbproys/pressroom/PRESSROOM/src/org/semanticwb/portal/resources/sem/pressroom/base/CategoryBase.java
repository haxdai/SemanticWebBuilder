package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class CategoryBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass swbpress_Content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Content");
    public static final org.semanticwb.platform.SemanticProperty swbpress_hasContent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#hasContent");
    public static final org.semanticwb.platform.SemanticProperty swbpress_catNumConsecutivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#catNumConsecutivo");
    public static final org.semanticwb.platform.SemanticClass swbpress_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Category");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Category");

    public static class ClassMgr
    {
       /**
       * Returns a list of Category for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.portal.resources.sem.pressroom.Category for all models
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Category createCategory(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Category.ClassMgr.createCategory(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.portal.resources.sem.pressroom.Category
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Category
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       * @return A org.semanticwb.portal.resources.sem.pressroom.Category
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Category getCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Category)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.portal.resources.sem.pressroom.Category
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Category
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       * @return A org.semanticwb.portal.resources.sem.pressroom.Category
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Category createCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Category)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.portal.resources.sem.pressroom.Category
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Category
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       */
        public static void removeCategory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.portal.resources.sem.pressroom.Category
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Category
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       * @return true if the org.semanticwb.portal.resources.sem.pressroom.Category exists, false otherwise
       */

        public static boolean hasCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCategory(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Category with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategoryByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Category with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategoryByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Category with a determined Content
       * @param value Content of the type org.semanticwb.portal.resources.sem.pressroom.Content
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategoryByContent(org.semanticwb.portal.resources.sem.pressroom.Content value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasContent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Category with a determined Content
       * @param value Content of the type org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategoryByContent(org.semanticwb.portal.resources.sem.pressroom.Content value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasContent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Category with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Category
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategoryByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Category with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Category
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Category> listCategoryByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Category> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CategoryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Category
   */
    public CategoryBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.portal.resources.sem.pressroom.Content
   * @return A GenericIterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContents()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content>(getSemanticObject().listObjectProperties(swbpress_hasContent));
    }

   /**
   * Gets true if has a Content
   * @param value org.semanticwb.portal.resources.sem.pressroom.Content to verify
   * @return true if the org.semanticwb.portal.resources.sem.pressroom.Content exists, false otherwise
   */
    public boolean hasContent(org.semanticwb.portal.resources.sem.pressroom.Content value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbpress_hasContent,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Content
   * @param value org.semanticwb.portal.resources.sem.pressroom.Content to add
   */

    public void addContent(org.semanticwb.portal.resources.sem.pressroom.Content value)
    {
        getSemanticObject().addObjectProperty(swbpress_hasContent, value.getSemanticObject());
    }
   /**
   * Removes all the Content
   */

    public void removeAllContent()
    {
        getSemanticObject().removeProperty(swbpress_hasContent);
    }
   /**
   * Removes a Content
   * @param value org.semanticwb.portal.resources.sem.pressroom.Content to remove
   */

    public void removeContent(org.semanticwb.portal.resources.sem.pressroom.Content value)
    {
        getSemanticObject().removeObjectProperty(swbpress_hasContent,value.getSemanticObject());
    }

   /**
   * Gets the Content
   * @return a org.semanticwb.portal.resources.sem.pressroom.Content
   */
    public org.semanticwb.portal.resources.sem.pressroom.Content getContent()
    {
         org.semanticwb.portal.resources.sem.pressroom.Content ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_hasContent);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Content)obj.createGenericInstance();
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
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
    }

/**
* Gets the CatNumConsecutivo property
* @return int with the CatNumConsecutivo
*/
    public int getCatNumConsecutivo()
    {
        return getSemanticObject().getIntProperty(swbpress_catNumConsecutivo);
    }

/**
* Sets the CatNumConsecutivo property
* @param value long with the CatNumConsecutivo
*/
    public void setCatNumConsecutivo(int value)
    {
        getSemanticObject().setIntProperty(swbpress_catNumConsecutivo, value);
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
