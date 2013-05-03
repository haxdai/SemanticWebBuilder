package com.infotec.lodp.swb.base;


public abstract class DatasetLogBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * Persona que ejecutó la acción sobre el dataset
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_logUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#logUser");
   /**
   * Descripción de la acción sobre el dataset
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_logDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#logDescription");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Dataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Dataset");
    public static final org.semanticwb.platform.SemanticProperty lodp_dataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#dataset");
    public static final org.semanticwb.platform.SemanticProperty lodp_logCreated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#logCreated");
    public static final org.semanticwb.platform.SemanticClass lodpcg_DatasetLog=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#DatasetLog");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#DatasetLog");

    public static class ClassMgr
    {
       /**
       * Returns a list of DatasetLog for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.DatasetLog
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetLog> listDatasetLogs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetLog>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.DatasetLog for all models
       * @return Iterator of com.infotec.lodp.swb.DatasetLog
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetLog> listDatasetLogs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetLog>(it, true);
        }

        public static com.infotec.lodp.swb.DatasetLog createDatasetLog(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.DatasetLog.ClassMgr.createDatasetLog(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.DatasetLog
       * @param id Identifier for com.infotec.lodp.swb.DatasetLog
       * @param model Model of the com.infotec.lodp.swb.DatasetLog
       * @return A com.infotec.lodp.swb.DatasetLog
       */
        public static com.infotec.lodp.swb.DatasetLog getDatasetLog(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.DatasetLog)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.DatasetLog
       * @param id Identifier for com.infotec.lodp.swb.DatasetLog
       * @param model Model of the com.infotec.lodp.swb.DatasetLog
       * @return A com.infotec.lodp.swb.DatasetLog
       */
        public static com.infotec.lodp.swb.DatasetLog createDatasetLog(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.DatasetLog)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.DatasetLog
       * @param id Identifier for com.infotec.lodp.swb.DatasetLog
       * @param model Model of the com.infotec.lodp.swb.DatasetLog
       */
        public static void removeDatasetLog(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.DatasetLog
       * @param id Identifier for com.infotec.lodp.swb.DatasetLog
       * @param model Model of the com.infotec.lodp.swb.DatasetLog
       * @return true if the com.infotec.lodp.swb.DatasetLog exists, false otherwise
       */

        public static boolean hasDatasetLog(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDatasetLog(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetLog with a determined LogUser
       * @param value LogUser of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.lodp.swb.DatasetLog
       * @return Iterator with all the com.infotec.lodp.swb.DatasetLog
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetLog> listDatasetLogByLogUser(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetLog> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_logUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetLog with a determined LogUser
       * @param value LogUser of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.lodp.swb.DatasetLog
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetLog> listDatasetLogByLogUser(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetLog> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_logUser,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetLog with a determined Dataset
       * @param value Dataset of the type com.infotec.lodp.swb.Dataset
       * @param model Model of the com.infotec.lodp.swb.DatasetLog
       * @return Iterator with all the com.infotec.lodp.swb.DatasetLog
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetLog> listDatasetLogByDataset(com.infotec.lodp.swb.Dataset value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetLog> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_dataset, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.DatasetLog with a determined Dataset
       * @param value Dataset of the type com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.DatasetLog
       */

        public static java.util.Iterator<com.infotec.lodp.swb.DatasetLog> listDatasetLogByDataset(com.infotec.lodp.swb.Dataset value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.DatasetLog> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_dataset,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DatasetLogBase.ClassMgr getDatasetLogClassMgr()
    {
        return new DatasetLogBase.ClassMgr();
    }

   /**
   * Constructs a DatasetLogBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DatasetLog
   */
    public DatasetLogBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in DatasetLog object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in DatasetLog object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }
   /**
   * Sets the value for the property LogUser
   * @param value LogUser to set
   */

    public void setLogUser(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_logUser, value.getSemanticObject());
        }else
        {
            removeLogUser();
        }
    }
   /**
   * Remove the value for LogUser property
   */

    public void removeLogUser()
    {
        getSemanticObject().removeProperty(lodp_logUser);
    }

   /**
   * Gets the LogUser
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getLogUser()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_logUser);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the LogDescription property
* @return String with the LogDescription
*/
    public String getLogDescription()
    {
        return getSemanticObject().getProperty(lodp_logDescription);
    }

/**
* Sets the LogDescription property
* @param value long with the LogDescription
*/
    public void setLogDescription(String value)
    {
        getSemanticObject().setProperty(lodp_logDescription, value);
    }
   /**
   * Sets the value for the property Dataset
   * @param value Dataset to set
   */

    public void setDataset(com.infotec.lodp.swb.Dataset value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_dataset, value.getSemanticObject());
        }else
        {
            removeDataset();
        }
    }
   /**
   * Remove the value for Dataset property
   */

    public void removeDataset()
    {
        getSemanticObject().removeProperty(lodp_dataset);
    }

   /**
   * Gets the Dataset
   * @return a com.infotec.lodp.swb.Dataset
   */
    public com.infotec.lodp.swb.Dataset getDataset()
    {
         com.infotec.lodp.swb.Dataset ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_dataset);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Dataset)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the LogCreated property
* @return java.util.Date with the LogCreated
*/
    public java.util.Date getLogCreated()
    {
        return getSemanticObject().getDateProperty(lodp_logCreated);
    }

/**
* Sets the LogCreated property
* @param value long with the LogCreated
*/
    public void setLogCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_logCreated, value);
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
