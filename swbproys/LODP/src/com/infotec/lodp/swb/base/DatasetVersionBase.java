package com.infotec.lodp.swb.base;


public abstract class DatasetVersionBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticProperty lodp_verComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#verComment");
   /**
   * Validacion del sistema de si es correcto el archivo
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_validated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#validated");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Publisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Publisher");
    public static final org.semanticwb.platform.SemanticProperty lodp_verPublisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#verPublisher");
   /**
   * URL directa (generada automáticamente)
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_filePath=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#filePath");
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticClass lodpcg_DatasetVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#DatasetVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_nextVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#nextVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_version=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#version");
    public static final org.semanticwb.platform.SemanticProperty lodp_previousVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#previousVersion");
    public static final org.semanticwb.platform.SemanticProperty lodp_versionHash=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#versionHash");
    public static final org.semanticwb.platform.SemanticProperty lodp_versionCreated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#versionCreated");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#DatasetVersion");

    public static class ClassMgr
    {
       /**
       * Returns a list of DatasetVersion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.DatasetVersion for all models
       * @return Iterator of com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion>(it, true);
        }

        public static com.infotec.lodp.swb.DatasetVersion createDatasetVersion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.DatasetVersion.ClassMgr.createDatasetVersion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.DatasetVersion
       * @param id Identifier for com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       * @return A com.infotec.lodp.swb.DatasetVersion
       */
        public static com.infotec.lodp.swb.DatasetVersion getDatasetVersion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.DatasetVersion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.DatasetVersion
       * @param id Identifier for com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       * @return A com.infotec.lodp.swb.DatasetVersion
       */
        public static com.infotec.lodp.swb.DatasetVersion createDatasetVersion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.DatasetVersion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.DatasetVersion
       * @param id Identifier for com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       */
        public static void removeDatasetVersion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.DatasetVersion
       * @param id Identifier for com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       * @return true if the com.infotec.lodp.swb.DatasetVersion exists, false otherwise
       */

        public static boolean hasDatasetVersion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDatasetVersion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetVersion with a determined VerPublisher
       * @param value VerPublisher of the type com.infotec.lodp.swb.Publisher
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersionByVerPublisher(com.infotec.lodp.swb.Publisher value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_verPublisher, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetVersion with a determined VerPublisher
       * @param value VerPublisher of the type com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersionByVerPublisher(com.infotec.lodp.swb.Publisher value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_verPublisher,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetVersion with a determined NextVersion
       * @param value NextVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersionByNextVersion(com.infotec.lodp.swb.DatasetVersion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_nextVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetVersion with a determined NextVersion
       * @param value NextVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersionByNextVersion(com.infotec.lodp.swb.DatasetVersion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_nextVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetVersion with a determined PreviousVersion
       * @param value PreviousVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersionByPreviousVersion(com.infotec.lodp.swb.DatasetVersion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_previousVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetVersion with a determined PreviousVersion
       * @param value PreviousVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.DatasetVersion
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetVersion> listDatasetVersionByPreviousVersion(com.infotec.lodp.swb.DatasetVersion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetVersion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_previousVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DatasetVersionBase.ClassMgr getDatasetVersionClassMgr()
    {
        return new DatasetVersionBase.ClassMgr();
    }

   /**
   * Constructs a DatasetVersionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DatasetVersion
   */
    public DatasetVersionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the VerComment property
* @return String with the VerComment
*/
    public String getVerComment()
    {
        return getSemanticObject().getProperty(lodp_verComment);
    }

/**
* Sets the VerComment property
* @param value long with the VerComment
*/
    public void setVerComment(String value)
    {
        getSemanticObject().setProperty(lodp_verComment, value);
    }

/**
* Gets the Validated property
* @return boolean with the Validated
*/
    public boolean isValidated()
    {
        return getSemanticObject().getBooleanProperty(lodp_validated);
    }

/**
* Sets the Validated property
* @param value long with the Validated
*/
    public void setValidated(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_validated, value);
    }
   /**
   * Sets the value for the property VerPublisher
   * @param value VerPublisher to set
   */

    public void setVerPublisher(com.infotec.lodp.swb.Publisher value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_verPublisher, value.getSemanticObject());
        }else
        {
            removeVerPublisher();
        }
    }
   /**
   * Remove the value for VerPublisher property
   */

    public void removeVerPublisher()
    {
        getSemanticObject().removeProperty(lodp_verPublisher);
    }

   /**
   * Gets the VerPublisher
   * @return a com.infotec.lodp.swb.Publisher
   */
    public com.infotec.lodp.swb.Publisher getVerPublisher()
    {
         com.infotec.lodp.swb.Publisher ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_verPublisher);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Publisher)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FilePath property
* @return String with the FilePath
*/
    public String getFilePath()
    {
        return getSemanticObject().getProperty(lodp_filePath);
    }

/**
* Sets the FilePath property
* @param value long with the FilePath
*/
    public void setFilePath(String value)
    {
        getSemanticObject().setProperty(lodp_filePath, value);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in DatasetVersion object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in DatasetVersion object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }
   /**
   * Sets the value for the property NextVersion
   * @param value NextVersion to set
   */

    public void setNextVersion(com.infotec.lodp.swb.DatasetVersion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_nextVersion, value.getSemanticObject());
        }else
        {
            removeNextVersion();
        }
    }
   /**
   * Remove the value for NextVersion property
   */

    public void removeNextVersion()
    {
        getSemanticObject().removeProperty(lodp_nextVersion);
    }

   /**
   * Gets the NextVersion
   * @return a com.infotec.lodp.swb.DatasetVersion
   */
    public com.infotec.lodp.swb.DatasetVersion getNextVersion()
    {
         com.infotec.lodp.swb.DatasetVersion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_nextVersion);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.DatasetVersion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Version property
* @return int with the Version
*/
    public int getVersion()
    {
        return getSemanticObject().getIntProperty(lodp_version);
    }

/**
* Sets the Version property
* @param value long with the Version
*/
    public void setVersion(int value)
    {
        getSemanticObject().setIntProperty(lodp_version, value);
    }
   /**
   * Sets the value for the property PreviousVersion
   * @param value PreviousVersion to set
   */

    public void setPreviousVersion(com.infotec.lodp.swb.DatasetVersion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_previousVersion, value.getSemanticObject());
        }else
        {
            removePreviousVersion();
        }
    }
   /**
   * Remove the value for PreviousVersion property
   */

    public void removePreviousVersion()
    {
        getSemanticObject().removeProperty(lodp_previousVersion);
    }

   /**
   * Gets the PreviousVersion
   * @return a com.infotec.lodp.swb.DatasetVersion
   */
    public com.infotec.lodp.swb.DatasetVersion getPreviousVersion()
    {
         com.infotec.lodp.swb.DatasetVersion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_previousVersion);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.DatasetVersion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the VersionHash property
* @return String with the VersionHash
*/
    public String getVersionHash()
    {
        return getSemanticObject().getProperty(lodp_versionHash);
    }

/**
* Sets the VersionHash property
* @param value long with the VersionHash
*/
    public void setVersionHash(String value)
    {
        getSemanticObject().setProperty(lodp_versionHash, value);
    }

/**
* Gets the VersionCreated property
* @return java.util.Date with the VersionCreated
*/
    public java.util.Date getVersionCreated()
    {
        return getSemanticObject().getDateProperty(lodp_versionCreated);
    }

/**
* Sets the VersionCreated property
* @param value long with the VersionCreated
*/
    public void setVersionCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_versionCreated, value);
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
