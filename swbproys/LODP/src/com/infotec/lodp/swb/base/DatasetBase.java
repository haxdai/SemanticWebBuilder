package com.infotec.lodp.swb.base;


public abstract class DatasetBase extends org.semanticwb.model.SWBClass implements com.infotec.lodp.swb.Commentable,com.infotec.lodp.swb.Hitable,com.infotec.lodp.swb.Approveable,com.infotec.lodp.swb.Versionable,com.infotec.lodp.swb.Rankable
{
    public static final org.semanticwb.platform.SemanticClass lodpcg_Dataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Dataset");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Dataset");

    public static class ClassMgr
    {
       /**
       * Returns a list of Dataset for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasets(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Dataset for all models
       * @return Iterator of com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasets()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset>(it, true);
        }

        public static com.infotec.lodp.swb.Dataset createDataset(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Dataset.ClassMgr.createDataset(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Dataset
       * @param id Identifier for com.infotec.lodp.swb.Dataset
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return A com.infotec.lodp.swb.Dataset
       */
        public static com.infotec.lodp.swb.Dataset getDataset(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Dataset)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Dataset
       * @param id Identifier for com.infotec.lodp.swb.Dataset
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return A com.infotec.lodp.swb.Dataset
       */
        public static com.infotec.lodp.swb.Dataset createDataset(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Dataset)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Dataset
       * @param id Identifier for com.infotec.lodp.swb.Dataset
       * @param model Model of the com.infotec.lodp.swb.Dataset
       */
        public static void removeDataset(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Dataset
       * @param id Identifier for com.infotec.lodp.swb.Dataset
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return true if the com.infotec.lodp.swb.Dataset exists, false otherwise
       */

        public static boolean hasDataset(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDataset(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Comment
       * @param value Comment of the type com.infotec.lodp.swb.Comment
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByComment(com.infotec.lodp.swb.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Comment
       * @param value Comment of the type com.infotec.lodp.swb.Comment
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByComment(com.infotec.lodp.swb.Comment value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DatasetBase.ClassMgr getDatasetClassMgr()
    {
        return new DatasetBase.ClassMgr();
    }

   /**
   * Constructs a DatasetBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Dataset
   */
    public DatasetBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Approved property
* @return boolean with the Approved
*/
    public boolean isApproved()
    {
        return getSemanticObject().getBooleanProperty(lodp_approved);
    }

/**
* Sets the Approved property
* @param value long with the Approved
*/
    public void setApproved(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_approved, value);
    }

    public void setActualVersion(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(lodp_actualVersion, value);
    }

    public void removeActualVersion()
    {
        getSemanticObject().removeProperty(lodp_actualVersion);
    }

/**
* Gets the ActualVersion property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getActualVersion()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(lodp_actualVersion);
         return ret;
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
* Gets the Reviewed property
* @return boolean with the Reviewed
*/
    public boolean isReviewed()
    {
        return getSemanticObject().getBooleanProperty(lodp_reviewed);
    }

/**
* Sets the Reviewed property
* @param value long with the Reviewed
*/
    public void setReviewed(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_reviewed, value);
    }

    public void setLastVersion(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(lodp_lastVersion, value);
    }

    public void removeLastVersion()
    {
        getSemanticObject().removeProperty(lodp_lastVersion);
    }

/**
* Gets the LastVersion property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getLastVersion()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(lodp_lastVersion);
         return ret;
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
}
