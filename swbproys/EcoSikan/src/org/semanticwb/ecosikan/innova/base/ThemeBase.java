package org.semanticwb.ecosikan.innova.base;


public abstract class ThemeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Iconable,org.semanticwb.model.Trashable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.ImageUploadable
{
    public static final org.semanticwb.platform.SemanticProperty ecoskn_active=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#active");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Secretaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Secretaria");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_secretaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#secretaria");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasIdeas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasIdeas");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Theme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Theme");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Theme");

    public static class ClassMgr
    {
       /**
       * Returns a list of Theme for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Theme for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme>(it, true);
        }

        public static org.semanticwb.ecosikan.innova.Theme createTheme(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.ecosikan.innova.Theme.ClassMgr.createTheme(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return A org.semanticwb.ecosikan.innova.Theme
       */
        public static org.semanticwb.ecosikan.innova.Theme getTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Theme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return A org.semanticwb.ecosikan.innova.Theme
       */
        public static org.semanticwb.ecosikan.innova.Theme createTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Theme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       */
        public static void removeTheme(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return true if the org.semanticwb.ecosikan.innova.Theme exists, false otherwise
       */

        public static boolean hasTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTheme(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Secretaria
       * @param value Secretaria of the type org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeBySecretaria(org.semanticwb.ecosikan.innova.Secretaria value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_secretaria, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Secretaria
       * @param value Secretaria of the type org.semanticwb.ecosikan.innova.Secretaria
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeBySecretaria(org.semanticwb.ecosikan.innova.Secretaria value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_secretaria,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Ideas
       * @param value Ideas of the type org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByIdeas(org.semanticwb.ecosikan.innova.Idea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdeas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Ideas
       * @param value Ideas of the type org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByIdeas(org.semanticwb.ecosikan.innova.Idea value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdeas,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ThemeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Theme
   */
    public ThemeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ImgMaxHeight property
* @return int with the ImgMaxHeight
*/
    public int getImgMaxHeight()
    {
        return getSemanticObject().getIntProperty(swbxf_imgMaxHeight);
    }

/**
* Sets the ImgMaxHeight property
* @param value long with the ImgMaxHeight
*/
    public void setImgMaxHeight(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgMaxHeight, value);
    }

/**
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(ecoskn_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(ecoskn_active, value);
    }

/**
* Gets the Deleted property
* @return boolean with the Deleted
*/
    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

/**
* Sets the Deleted property
* @param value long with the Deleted
*/
    public void setDeleted(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, value);
    }

/**
* Gets the ImgMaxWidth property
* @return int with the ImgMaxWidth
*/
    public int getImgMaxWidth()
    {
        return getSemanticObject().getIntProperty(swbxf_imgMaxWidth);
    }

/**
* Sets the ImgMaxWidth property
* @param value long with the ImgMaxWidth
*/
    public void setImgMaxWidth(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgMaxWidth, value);
    }

/**
* Gets the ImgThumbnailHeight property
* @return int with the ImgThumbnailHeight
*/
    public int getImgThumbnailHeight()
    {
        return getSemanticObject().getIntProperty(swbxf_imgThumbnailHeight);
    }

/**
* Sets the ImgThumbnailHeight property
* @param value long with the ImgThumbnailHeight
*/
    public void setImgThumbnailHeight(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgThumbnailHeight, value);
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
* Gets the IconClass property
* @return String with the IconClass
*/
    public String getIconClass()
    {
        return getSemanticObject().getProperty(swb_iconClass);
    }

/**
* Sets the IconClass property
* @param value long with the IconClass
*/
    public void setIconClass(String value)
    {
        getSemanticObject().setProperty(swb_iconClass, value);
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
* Gets the ImgThumbnailWidth property
* @return int with the ImgThumbnailWidth
*/
    public int getImgThumbnailWidth()
    {
        return getSemanticObject().getIntProperty(swbxf_imgThumbnailWidth);
    }

/**
* Sets the ImgThumbnailWidth property
* @param value long with the ImgThumbnailWidth
*/
    public void setImgThumbnailWidth(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgThumbnailWidth, value);
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
* Gets the ImgCrop property
* @return boolean with the ImgCrop
*/
    public boolean isImgCrop()
    {
        return getSemanticObject().getBooleanProperty(swbxf_imgCrop);
    }

/**
* Sets the ImgCrop property
* @param value long with the ImgCrop
*/
    public void setImgCrop(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbxf_imgCrop, value);
    }

/**
* Gets the ImgThumbnail property
* @return boolean with the ImgThumbnail
*/
    public boolean isImgThumbnail()
    {
        return getSemanticObject().getBooleanProperty(swbxf_imgThumbnail);
    }

/**
* Sets the ImgThumbnail property
* @param value long with the ImgThumbnail
*/
    public void setImgThumbnail(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbxf_imgThumbnail, value);
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
   * Sets the value for the property Secretaria
   * @param value Secretaria to set
   */

    public void setSecretaria(org.semanticwb.ecosikan.innova.Secretaria value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_secretaria, value.getSemanticObject());
        }else
        {
            removeSecretaria();
        }
    }
   /**
   * Remove the value for Secretaria property
   */

    public void removeSecretaria()
    {
        getSemanticObject().removeProperty(ecoskn_secretaria);
    }

   /**
   * Gets the Secretaria
   * @return a org.semanticwb.ecosikan.innova.Secretaria
   */
    public org.semanticwb.ecosikan.innova.Secretaria getSecretaria()
    {
         org.semanticwb.ecosikan.innova.Secretaria ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_secretaria);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Secretaria)obj.createGenericInstance();
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
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Idea
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Idea
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> listIdeases()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea>(getSemanticObject().listObjectProperties(ecoskn_hasIdeas));
    }

   /**
   * Gets true if has a Ideas
   * @param value org.semanticwb.ecosikan.innova.Idea to verify
   * @return true if the org.semanticwb.ecosikan.innova.Idea exists, false otherwise
   */
    public boolean hasIdeas(org.semanticwb.ecosikan.innova.Idea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasIdeas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Ideas
   * @param value org.semanticwb.ecosikan.innova.Idea to add
   */

    public void addIdeas(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasIdeas, value.getSemanticObject());
    }
   /**
   * Removes all the Ideas
   */

    public void removeAllIdeas()
    {
        getSemanticObject().removeProperty(ecoskn_hasIdeas);
    }
   /**
   * Removes a Ideas
   * @param value org.semanticwb.ecosikan.innova.Idea to remove
   */

    public void removeIdeas(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasIdeas,value.getSemanticObject());
    }

   /**
   * Gets the Ideas
   * @return a org.semanticwb.ecosikan.innova.Idea
   */
    public org.semanticwb.ecosikan.innova.Idea getIdeas()
    {
         org.semanticwb.ecosikan.innova.Idea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasIdeas);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Idea)obj.createGenericInstance();
         }
         return ret;
    }
}
