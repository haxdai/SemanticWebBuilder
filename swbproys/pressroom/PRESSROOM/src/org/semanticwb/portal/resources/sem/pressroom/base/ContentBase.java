package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class ContentBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_numConsecutivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#numConsecutivo");
    public static final org.semanticwb.platform.SemanticClass swbpress_Photos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Photos");
    public static final org.semanticwb.platform.SemanticProperty swbpress_hasPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#hasPhoto");
    public static final org.semanticwb.platform.SemanticClass swbpress_Files=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Files");
    public static final org.semanticwb.platform.SemanticProperty swbpress_hasFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#hasFile");
    public static final org.semanticwb.platform.SemanticProperty swbpress_content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#content");
   /**
   * Una Página Web es el elemento de SemanticWebBuilder a través del cual se estructura la información del portal.
   */
    public static final org.semanticwb.platform.SemanticClass swb_WebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebPage");
    public static final org.semanticwb.platform.SemanticProperty swbpress_WebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#WebPage");
    public static final org.semanticwb.platform.SemanticProperty swbpress_endDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#endDate");
    public static final org.semanticwb.platform.SemanticProperty swbpress_startDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#startDate");
    public static final org.semanticwb.platform.SemanticProperty swbpress_priority=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#priority");
    public static final org.semanticwb.platform.SemanticProperty swbpress_place=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#place");
    public static final org.semanticwb.platform.SemanticClass swbpress_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Category");
    public static final org.semanticwb.platform.SemanticProperty swbpress_category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#category");
    public static final org.semanticwb.platform.SemanticClass swbpress_Content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Content");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Content");

    public static class ClassMgr
    {
       /**
       * Returns a list of Content for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.portal.resources.sem.pressroom.Content for all models
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Content createContent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Content.ClassMgr.createContent(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.portal.resources.sem.pressroom.Content
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Content
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return A org.semanticwb.portal.resources.sem.pressroom.Content
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Content getContent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Content)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.portal.resources.sem.pressroom.Content
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Content
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return A org.semanticwb.portal.resources.sem.pressroom.Content
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Content createContent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Content)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.portal.resources.sem.pressroom.Content
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Content
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       */
        public static void removeContent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.portal.resources.sem.pressroom.Content
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Content
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return true if the org.semanticwb.portal.resources.sem.pressroom.Content exists, false otherwise
       */

        public static boolean hasContent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getContent(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined Photo
       * @param value Photo of the type org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasPhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined Photo
       * @param value Photo of the type org.semanticwb.portal.resources.sem.pressroom.Photos
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasPhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined File
       * @param value File of the type org.semanticwb.portal.resources.sem.pressroom.Files
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByFile(org.semanticwb.portal.resources.sem.pressroom.Files value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasFile, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined File
       * @param value File of the type org.semanticwb.portal.resources.sem.pressroom.Files
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_hasFile,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_WebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_WebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined Category
       * @param value Category of the type org.semanticwb.portal.resources.sem.pressroom.Category
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCategory(org.semanticwb.portal.resources.sem.pressroom.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_category, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined Category
       * @param value Category of the type org.semanticwb.portal.resources.sem.pressroom.Category
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_category,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.Content with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.Content
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Content> listContentByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Content> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ContentBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Content
   */
    public ContentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NumConsecutivo property
* @return int with the NumConsecutivo
*/
    public int getNumConsecutivo()
    {
        return getSemanticObject().getIntProperty(swbpress_numConsecutivo);
    }

/**
* Sets the NumConsecutivo property
* @param value long with the NumConsecutivo
*/
    public void setNumConsecutivo(int value)
    {
        getSemanticObject().setIntProperty(swbpress_numConsecutivo, value);
    }
   /**
   * Gets all the org.semanticwb.portal.resources.sem.pressroom.Photos
   * @return A GenericIterator with all the org.semanticwb.portal.resources.sem.pressroom.Photos
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos> listPhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos>(getSemanticObject().listObjectProperties(swbpress_hasPhoto));
    }

   /**
   * Gets true if has a Photo
   * @param value org.semanticwb.portal.resources.sem.pressroom.Photos to verify
   * @return true if the org.semanticwb.portal.resources.sem.pressroom.Photos exists, false otherwise
   */
    public boolean hasPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbpress_hasPhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Photo
   * @param value org.semanticwb.portal.resources.sem.pressroom.Photos to add
   */

    public void addPhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
    {
        getSemanticObject().addObjectProperty(swbpress_hasPhoto, value.getSemanticObject());
    }
   /**
   * Removes all the Photo
   */

    public void removeAllPhoto()
    {
        getSemanticObject().removeProperty(swbpress_hasPhoto);
    }
   /**
   * Removes a Photo
   * @param value org.semanticwb.portal.resources.sem.pressroom.Photos to remove
   */

    public void removePhoto(org.semanticwb.portal.resources.sem.pressroom.Photos value)
    {
        getSemanticObject().removeObjectProperty(swbpress_hasPhoto,value.getSemanticObject());
    }

   /**
   * Gets the Photo
   * @return a org.semanticwb.portal.resources.sem.pressroom.Photos
   */
    public org.semanticwb.portal.resources.sem.pressroom.Photos getPhoto()
    {
         org.semanticwb.portal.resources.sem.pressroom.Photos ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_hasPhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Photos)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.portal.resources.sem.pressroom.Files
   * @return A GenericIterator with all the org.semanticwb.portal.resources.sem.pressroom.Files
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files> listFiles()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Files>(getSemanticObject().listObjectProperties(swbpress_hasFile));
    }

   /**
   * Gets true if has a File
   * @param value org.semanticwb.portal.resources.sem.pressroom.Files to verify
   * @return true if the org.semanticwb.portal.resources.sem.pressroom.Files exists, false otherwise
   */
    public boolean hasFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbpress_hasFile,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a File
   * @param value org.semanticwb.portal.resources.sem.pressroom.Files to add
   */

    public void addFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
    {
        getSemanticObject().addObjectProperty(swbpress_hasFile, value.getSemanticObject());
    }
   /**
   * Removes all the File
   */

    public void removeAllFile()
    {
        getSemanticObject().removeProperty(swbpress_hasFile);
    }
   /**
   * Removes a File
   * @param value org.semanticwb.portal.resources.sem.pressroom.Files to remove
   */

    public void removeFile(org.semanticwb.portal.resources.sem.pressroom.Files value)
    {
        getSemanticObject().removeObjectProperty(swbpress_hasFile,value.getSemanticObject());
    }

   /**
   * Gets the File
   * @return a org.semanticwb.portal.resources.sem.pressroom.Files
   */
    public org.semanticwb.portal.resources.sem.pressroom.Files getFile()
    {
         org.semanticwb.portal.resources.sem.pressroom.Files ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_hasFile);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Files)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Content property
* @return String with the Content
*/
    public String getContent()
    {
        return getSemanticObject().getProperty(swbpress_content);
    }

/**
* Sets the Content property
* @param value long with the Content
*/
    public void setContent(String value)
    {
        getSemanticObject().setProperty(swbpress_content, value);
    }
   /**
   * Sets the value for the property WebPage
   * @param value WebPage to set
   */

    public void setWebPage(org.semanticwb.model.WebPage value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swbpress_WebPage, value.getSemanticObject());
        }else
        {
            removeWebPage();
        }
    }
   /**
   * Remove the value for WebPage property
   */

    public void removeWebPage()
    {
        getSemanticObject().removeProperty(swbpress_WebPage);
    }

   /**
   * Gets the WebPage
   * @return a org.semanticwb.model.WebPage
   */
    public org.semanticwb.model.WebPage getWebPage()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_WebPage);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EndDate property
* @return java.util.Date with the EndDate
*/
    public java.util.Date getEndDate()
    {
        return getSemanticObject().getDateProperty(swbpress_endDate);
    }

/**
* Sets the EndDate property
* @param value long with the EndDate
*/
    public void setEndDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbpress_endDate, value);
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
* Gets the StartDate property
* @return java.util.Date with the StartDate
*/
    public java.util.Date getStartDate()
    {
        return getSemanticObject().getDateProperty(swbpress_startDate);
    }

/**
* Sets the StartDate property
* @param value long with the StartDate
*/
    public void setStartDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swbpress_startDate, value);
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
* Gets the Priority property
* @return int with the Priority
*/
    public int getPriority()
    {
        return getSemanticObject().getIntProperty(swbpress_priority);
    }

/**
* Sets the Priority property
* @param value long with the Priority
*/
    public void setPriority(int value)
    {
        getSemanticObject().setIntProperty(swbpress_priority, value);
    }

/**
* Gets the Place property
* @return String with the Place
*/
    public String getPlace()
    {
        return getSemanticObject().getProperty(swbpress_place);
    }

/**
* Sets the Place property
* @param value long with the Place
*/
    public void setPlace(String value)
    {
        getSemanticObject().setProperty(swbpress_place, value);
    }
   /**
   * Sets the value for the property Category
   * @param value Category to set
   */

    public void setCategory(org.semanticwb.portal.resources.sem.pressroom.Category value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swbpress_category, value.getSemanticObject());
        }else
        {
            removeCategory();
        }
    }
   /**
   * Remove the value for Category property
   */

    public void removeCategory()
    {
        getSemanticObject().removeProperty(swbpress_category);
    }

   /**
   * Gets the Category
   * @return a org.semanticwb.portal.resources.sem.pressroom.Category
   */
    public org.semanticwb.portal.resources.sem.pressroom.Category getCategory()
    {
         org.semanticwb.portal.resources.sem.pressroom.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_category);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Category)obj.createGenericInstance();
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
