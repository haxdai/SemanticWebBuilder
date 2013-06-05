package com.infotec.lodp.swb.base;


public abstract class ApplicationBase extends org.semanticwb.model.base.GenericObjectBase implements com.infotec.lodp.swb.Rankable,com.infotec.lodp.swb.Hitable,com.infotec.lodp.swb.Commentable
{
    public static final org.semanticwb.platform.SemanticClass lodpcg_ApplicationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#ApplicationType");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasApplicationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasApplicationType");
    public static final org.semanticwb.platform.SemanticProperty lodp_appCreated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appCreated");
   /**
   * Si la aplicación ha sido aprobada
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_appValid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appValid");
   /**
   * URL de descarga de la aplicación
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_appURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appURL");
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticClass lodpcg_LicenseType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#LicenseType");
    public static final org.semanticwb.platform.SemanticProperty lodp_appLicense=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appLicense");
    public static final org.semanticwb.platform.SemanticProperty lodp_appAuthor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appAuthor");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Category");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasCategory");
    public static final org.semanticwb.platform.SemanticProperty lodp_appTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appTitle");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Dataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Dataset");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasRelatedDataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasRelatedDataset");
    public static final org.semanticwb.platform.SemanticProperty lodp_appDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appDescription");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Application=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Application");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Application");

    public static class ClassMgr
    {
       /**
       * Returns a list of Application for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplications(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Application for all models
       * @return Iterator of com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplications()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application>(it, true);
        }

        public static com.infotec.lodp.swb.Application createApplication(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Application.ClassMgr.createApplication(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Application
       * @param id Identifier for com.infotec.lodp.swb.Application
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return A com.infotec.lodp.swb.Application
       */
        public static com.infotec.lodp.swb.Application getApplication(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Application)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Application
       * @param id Identifier for com.infotec.lodp.swb.Application
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return A com.infotec.lodp.swb.Application
       */
        public static com.infotec.lodp.swb.Application createApplication(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Application)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Application
       * @param id Identifier for com.infotec.lodp.swb.Application
       * @param model Model of the com.infotec.lodp.swb.Application
       */
        public static void removeApplication(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Application
       * @param id Identifier for com.infotec.lodp.swb.Application
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return true if the com.infotec.lodp.swb.Application exists, false otherwise
       */

        public static boolean hasApplication(String id, org.semanticwb.model.SWBModel model)
        {
            return (getApplication(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined ApplicationType
       * @param value ApplicationType of the type com.infotec.lodp.swb.ApplicationType
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByApplicationType(com.infotec.lodp.swb.ApplicationType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasApplicationType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined ApplicationType
       * @param value ApplicationType of the type com.infotec.lodp.swb.ApplicationType
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByApplicationType(com.infotec.lodp.swb.ApplicationType value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasApplicationType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined AppLicense
       * @param value AppLicense of the type com.infotec.lodp.swb.LicenseType
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByAppLicense(com.infotec.lodp.swb.LicenseType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_appLicense, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined AppLicense
       * @param value AppLicense of the type com.infotec.lodp.swb.LicenseType
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByAppLicense(com.infotec.lodp.swb.LicenseType value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_appLicense,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined Category
       * @param value Category of the type com.infotec.lodp.swb.Category
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByCategory(com.infotec.lodp.swb.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasCategory, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined Category
       * @param value Category of the type com.infotec.lodp.swb.Category
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByCategory(com.infotec.lodp.swb.Category value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasCategory,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined Comment
       * @param value Comment of the type com.infotec.lodp.swb.Comment
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByComment(com.infotec.lodp.swb.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined Comment
       * @param value Comment of the type com.infotec.lodp.swb.Comment
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByComment(com.infotec.lodp.swb.Comment value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined RelatedDataset
       * @param value RelatedDataset of the type com.infotec.lodp.swb.Dataset
       * @param model Model of the com.infotec.lodp.swb.Application
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByRelatedDataset(com.infotec.lodp.swb.Dataset value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasRelatedDataset, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Application with a determined RelatedDataset
       * @param value RelatedDataset of the type com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Application
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Application> listApplicationByRelatedDataset(com.infotec.lodp.swb.Dataset value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Application> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasRelatedDataset,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ApplicationBase.ClassMgr getApplicationClassMgr()
    {
        return new ApplicationBase.ClassMgr();
    }

   /**
   * Constructs a ApplicationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Application
   */
    public ApplicationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the LastDownload property
* @return java.util.Date with the LastDownload
*/
    public java.util.Date getLastDownload()
    {
        return getSemanticObject().getDateProperty(lodp_lastDownload);
    }

/**
* Sets the LastDownload property
* @param value long with the LastDownload
*/
    public void setLastDownload(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_lastDownload, value);
    }
   /**
   * Gets all the com.infotec.lodp.swb.ApplicationType
   * @return A GenericIterator with all the com.infotec.lodp.swb.ApplicationType
   */

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.ApplicationType> listApplicationTypes()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.ApplicationType>(getSemanticObject().listObjectProperties(lodp_hasApplicationType));
    }

   /**
   * Gets true if has a ApplicationType
   * @param value com.infotec.lodp.swb.ApplicationType to verify
   * @return true if the com.infotec.lodp.swb.ApplicationType exists, false otherwise
   */
    public boolean hasApplicationType(com.infotec.lodp.swb.ApplicationType value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(lodp_hasApplicationType,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ApplicationType
   * @param value com.infotec.lodp.swb.ApplicationType to add
   */

    public void addApplicationType(com.infotec.lodp.swb.ApplicationType value)
    {
        getSemanticObject().addObjectProperty(lodp_hasApplicationType, value.getSemanticObject());
    }
   /**
   * Removes all the ApplicationType
   */

    public void removeAllApplicationType()
    {
        getSemanticObject().removeProperty(lodp_hasApplicationType);
    }
   /**
   * Removes a ApplicationType
   * @param value com.infotec.lodp.swb.ApplicationType to remove
   */

    public void removeApplicationType(com.infotec.lodp.swb.ApplicationType value)
    {
        getSemanticObject().removeObjectProperty(lodp_hasApplicationType,value.getSemanticObject());
    }

   /**
   * Gets the ApplicationType
   * @return a com.infotec.lodp.swb.ApplicationType
   */
    public com.infotec.lodp.swb.ApplicationType getApplicationType()
    {
         com.infotec.lodp.swb.ApplicationType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_hasApplicationType);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.ApplicationType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the AppCreated property
* @return java.util.Date with the AppCreated
*/
    public java.util.Date getAppCreated()
    {
        return getSemanticObject().getDateProperty(lodp_appCreated);
    }

/**
* Sets the AppCreated property
* @param value long with the AppCreated
*/
    public void setAppCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_appCreated, value);
    }

/**
* Gets the Ranks property
* @return long with the Ranks
*/
    public long getRanks()
    {
        return getSemanticObject().getLongProperty(lodp_ranks);
    }

/**
* Sets the Ranks property
* @param value long with the Ranks
*/
    public void setRanks(long value)
    {
        getSemanticObject().setLongProperty(lodp_ranks, value);
    }

/**
* Gets the AppValid property
* @return boolean with the AppValid
*/
    public boolean isAppValid()
    {
        return getSemanticObject().getBooleanProperty(lodp_appValid);
    }

/**
* Sets the AppValid property
* @param value long with the AppValid
*/
    public void setAppValid(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_appValid, value);
    }

/**
* Gets the AppURL property
* @return String with the AppURL
*/
    public String getAppURL()
    {
        return getSemanticObject().getProperty(lodp_appURL);
    }

/**
* Sets the AppURL property
* @param value long with the AppURL
*/
    public void setAppURL(String value)
    {
        getSemanticObject().setProperty(lodp_appURL, value);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Application object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Application object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }
   /**
   * Sets the value for the property AppLicense
   * @param value AppLicense to set
   */

    public void setAppLicense(com.infotec.lodp.swb.LicenseType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_appLicense, value.getSemanticObject());
        }else
        {
            removeAppLicense();
        }
    }
   /**
   * Remove the value for AppLicense property
   */

    public void removeAppLicense()
    {
        getSemanticObject().removeProperty(lodp_appLicense);
    }

   /**
   * Gets the AppLicense
   * @return a com.infotec.lodp.swb.LicenseType
   */
    public com.infotec.lodp.swb.LicenseType getAppLicense()
    {
         com.infotec.lodp.swb.LicenseType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_appLicense);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.LicenseType)obj.createGenericInstance();
         }
         return ret;
    }

    public void setAppAuthor(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(lodp_appAuthor, value);
    }

    public void removeAppAuthor()
    {
        getSemanticObject().removeProperty(lodp_appAuthor);
    }

/**
* Gets the AppAuthor property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getAppAuthor()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(lodp_appAuthor);
         return ret;
    }

/**
* Gets the Downloads property
* @return long with the Downloads
*/
    public long getDownloads()
    {
        return getSemanticObject().getLongProperty(lodp_downloads);
    }

/**
* Sets the Downloads property
* @param value long with the Downloads
*/
    public void setDownloads(long value)
    {
        getSemanticObject().setLongProperty(lodp_downloads, value);
    }
   /**
   * Gets all the com.infotec.lodp.swb.Category
   * @return A GenericIterator with all the com.infotec.lodp.swb.Category
   */

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Category> listCategories()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Category>(getSemanticObject().listObjectProperties(lodp_hasCategory));
    }

   /**
   * Gets true if has a Category
   * @param value com.infotec.lodp.swb.Category to verify
   * @return true if the com.infotec.lodp.swb.Category exists, false otherwise
   */
    public boolean hasCategory(com.infotec.lodp.swb.Category value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(lodp_hasCategory,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Category
   * @param value com.infotec.lodp.swb.Category to add
   */

    public void addCategory(com.infotec.lodp.swb.Category value)
    {
        getSemanticObject().addObjectProperty(lodp_hasCategory, value.getSemanticObject());
    }
   /**
   * Removes all the Category
   */

    public void removeAllCategory()
    {
        getSemanticObject().removeProperty(lodp_hasCategory);
    }
   /**
   * Removes a Category
   * @param value com.infotec.lodp.swb.Category to remove
   */

    public void removeCategory(com.infotec.lodp.swb.Category value)
    {
        getSemanticObject().removeObjectProperty(lodp_hasCategory,value.getSemanticObject());
    }

   /**
   * Gets the Category
   * @return a com.infotec.lodp.swb.Category
   */
    public com.infotec.lodp.swb.Category getCategory()
    {
         com.infotec.lodp.swb.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_hasCategory);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Category)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the AppTitle property
* @return String with the AppTitle
*/
    public String getAppTitle()
    {
        return getSemanticObject().getProperty(lodp_appTitle);
    }

/**
* Sets the AppTitle property
* @param value long with the AppTitle
*/
    public void setAppTitle(String value)
    {
        getSemanticObject().setProperty(lodp_appTitle, value);
    }

/**
* Gets the Views property
* @return long with the Views
*/
    public long getViews()
    {
        return getSemanticObject().getLongProperty(lodp_views);
    }

/**
* Sets the Views property
* @param value long with the Views
*/
    public void setViews(long value)
    {
        getSemanticObject().setLongProperty(lodp_views, value);
    }
   /**
   * Gets all the com.infotec.lodp.swb.Comment
   * @return A GenericIterator with all the com.infotec.lodp.swb.Comment
   */

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Comment> listComments()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Comment>(getSemanticObject().listObjectProperties(lodp_hasComment));
    }

   /**
   * Gets true if has a Comment
   * @param value com.infotec.lodp.swb.Comment to verify
   * @return true if the com.infotec.lodp.swb.Comment exists, false otherwise
   */
    public boolean hasComment(com.infotec.lodp.swb.Comment value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(lodp_hasComment,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Comment
   * @param value com.infotec.lodp.swb.Comment to add
   */

    public void addComment(com.infotec.lodp.swb.Comment value)
    {
        getSemanticObject().addObjectProperty(lodp_hasComment, value.getSemanticObject());
    }
   /**
   * Removes all the Comment
   */

    public void removeAllComment()
    {
        getSemanticObject().removeProperty(lodp_hasComment);
    }
   /**
   * Removes a Comment
   * @param value com.infotec.lodp.swb.Comment to remove
   */

    public void removeComment(com.infotec.lodp.swb.Comment value)
    {
        getSemanticObject().removeObjectProperty(lodp_hasComment,value.getSemanticObject());
    }

   /**
   * Gets the Comment
   * @return a com.infotec.lodp.swb.Comment
   */
    public com.infotec.lodp.swb.Comment getComment()
    {
         com.infotec.lodp.swb.Comment ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_hasComment);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Comment)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the LastView property
* @return java.util.Date with the LastView
*/
    public java.util.Date getLastView()
    {
        return getSemanticObject().getDateProperty(lodp_lastView);
    }

/**
* Sets the LastView property
* @param value long with the LastView
*/
    public void setLastView(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_lastView, value);
    }
   /**
   * Gets all the com.infotec.lodp.swb.Dataset
   * @return A GenericIterator with all the com.infotec.lodp.swb.Dataset
   */

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> listRelatedDatasets()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset>(getSemanticObject().listObjectProperties(lodp_hasRelatedDataset));
    }

   /**
   * Gets true if has a RelatedDataset
   * @param value com.infotec.lodp.swb.Dataset to verify
   * @return true if the com.infotec.lodp.swb.Dataset exists, false otherwise
   */
    public boolean hasRelatedDataset(com.infotec.lodp.swb.Dataset value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(lodp_hasRelatedDataset,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RelatedDataset
   * @param value com.infotec.lodp.swb.Dataset to add
   */

    public void addRelatedDataset(com.infotec.lodp.swb.Dataset value)
    {
        getSemanticObject().addObjectProperty(lodp_hasRelatedDataset, value.getSemanticObject());
    }
   /**
   * Removes all the RelatedDataset
   */

    public void removeAllRelatedDataset()
    {
        getSemanticObject().removeProperty(lodp_hasRelatedDataset);
    }
   /**
   * Removes a RelatedDataset
   * @param value com.infotec.lodp.swb.Dataset to remove
   */

    public void removeRelatedDataset(com.infotec.lodp.swb.Dataset value)
    {
        getSemanticObject().removeObjectProperty(lodp_hasRelatedDataset,value.getSemanticObject());
    }

   /**
   * Gets the RelatedDataset
   * @return a com.infotec.lodp.swb.Dataset
   */
    public com.infotec.lodp.swb.Dataset getRelatedDataset()
    {
         com.infotec.lodp.swb.Dataset ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_hasRelatedDataset);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Dataset)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Average property
* @return float with the Average
*/
    public float getAverage()
    {
        return getSemanticObject().getFloatProperty(lodp_average);
    }

/**
* Sets the Average property
* @param value long with the Average
*/
    public void setAverage(float value)
    {
        getSemanticObject().setFloatProperty(lodp_average, value);
    }

/**
* Gets the AppDescription property
* @return String with the AppDescription
*/
    public String getAppDescription()
    {
        return getSemanticObject().getProperty(lodp_appDescription);
    }

/**
* Sets the AppDescription property
* @param value long with the AppDescription
*/
    public void setAppDescription(String value)
    {
        getSemanticObject().setProperty(lodp_appDescription, value);
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
