package com.infotec.lodp.swb.base;


public abstract class DatasetBase extends org.semanticwb.model.SWBClass implements com.infotec.lodp.swb.Rankable,com.infotec.lodp.swb.Versionable,com.infotec.lodp.swb.Approveable,com.infotec.lodp.swb.Hitable,com.infotec.lodp.swb.Commentable
{
   /**
   * URL al dataset (endpoint)
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetURL");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Topic");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasTopic");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetCreated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetCreated");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetActive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetActive");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetFormat=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetFormat");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetSize=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetSize");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Publisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Publisher");
   /**
   * Enlace técnico, es el que publica(carga) el dataset
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_publisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#publisher");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Tag=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Tag");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasTag=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasTag");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetTitle");
    public static final org.semanticwb.platform.SemanticClass lodpcg_LicenseType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#LicenseType");
    public static final org.semanticwb.platform.SemanticProperty lodp_license=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#license");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Institution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Institution");
    public static final org.semanticwb.platform.SemanticProperty lodp_institution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#institution");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetView=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetView");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetUpdated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetUpdated");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Sector");
    public static final org.semanticwb.platform.SemanticProperty lodpcg_datasetSector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/lodpCodeGen#datasetSector");
    public static final org.semanticwb.platform.SemanticProperty lodp_datasetDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#datasetDescription");
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
       * Gets all com.infotec.lodp.swb.Dataset with a determined Topic
       * @param value Topic of the type com.infotec.lodp.swb.Topic
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByTopic(com.infotec.lodp.swb.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Topic
       * @param value Topic of the type com.infotec.lodp.swb.Topic
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByTopic(com.infotec.lodp.swb.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined ActualVersion
       * @param value ActualVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByActualVersion(com.infotec.lodp.swb.DatasetVersion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined ActualVersion
       * @param value ActualVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByActualVersion(com.infotec.lodp.swb.DatasetVersion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Publisher
       * @param value Publisher of the type com.infotec.lodp.swb.Publisher
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByPublisher(com.infotec.lodp.swb.Publisher value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_publisher, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Publisher
       * @param value Publisher of the type com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByPublisher(com.infotec.lodp.swb.Publisher value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_publisher,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Tag
       * @param value Tag of the type com.infotec.lodp.swb.Tag
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByTag(com.infotec.lodp.swb.Tag value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_hasTag, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Tag
       * @param value Tag of the type com.infotec.lodp.swb.Tag
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByTag(com.infotec.lodp.swb.Tag value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_hasTag,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined License
       * @param value License of the type com.infotec.lodp.swb.LicenseType
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByLicense(com.infotec.lodp.swb.LicenseType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_license, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined License
       * @param value License of the type com.infotec.lodp.swb.LicenseType
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByLicense(com.infotec.lodp.swb.LicenseType value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_license,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Institution
       * @param value Institution of the type com.infotec.lodp.swb.Institution
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByInstitution(com.infotec.lodp.swb.Institution value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_institution, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined Institution
       * @param value Institution of the type com.infotec.lodp.swb.Institution
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByInstitution(com.infotec.lodp.swb.Institution value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_institution,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined DatasetSector
       * @param value DatasetSector of the type com.infotec.lodp.swb.Sector
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByDatasetSector(com.infotec.lodp.swb.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodpcg_datasetSector, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined DatasetSector
       * @param value DatasetSector of the type com.infotec.lodp.swb.Sector
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByDatasetSector(com.infotec.lodp.swb.Sector value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodpcg_datasetSector,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined LastVersion
       * @param value LastVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @param model Model of the com.infotec.lodp.swb.Dataset
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByLastVersion(com.infotec.lodp.swb.DatasetVersion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Dataset with a determined LastVersion
       * @param value LastVersion of the type com.infotec.lodp.swb.DatasetVersion
       * @return Iterator with all the com.infotec.lodp.swb.Dataset
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Dataset> listDatasetByLastVersion(com.infotec.lodp.swb.DatasetVersion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Dataset> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_lastVersion,value.getSemanticObject(),sclass));
            return it;
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
* Gets the DatasetURL property
* @return String with the DatasetURL
*/
    public String getDatasetURL()
    {
        return getSemanticObject().getProperty(lodp_datasetURL);
    }

/**
* Sets the DatasetURL property
* @param value long with the DatasetURL
*/
    public void setDatasetURL(String value)
    {
        getSemanticObject().setProperty(lodp_datasetURL, value);
    }
   /**
   * Gets all the com.infotec.lodp.swb.Topic
   * @return A GenericIterator with all the com.infotec.lodp.swb.Topic
   */

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Topic> listTopics()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Topic>(getSemanticObject().listObjectProperties(lodp_hasTopic));
    }

   /**
   * Gets true if has a Topic
   * @param value com.infotec.lodp.swb.Topic to verify
   * @return true if the com.infotec.lodp.swb.Topic exists, false otherwise
   */
    public boolean hasTopic(com.infotec.lodp.swb.Topic value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(lodp_hasTopic,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Topic
   * @param value com.infotec.lodp.swb.Topic to add
   */

    public void addTopic(com.infotec.lodp.swb.Topic value)
    {
        getSemanticObject().addObjectProperty(lodp_hasTopic, value.getSemanticObject());
    }
   /**
   * Removes all the Topic
   */

    public void removeAllTopic()
    {
        getSemanticObject().removeProperty(lodp_hasTopic);
    }
   /**
   * Removes a Topic
   * @param value com.infotec.lodp.swb.Topic to remove
   */

    public void removeTopic(com.infotec.lodp.swb.Topic value)
    {
        getSemanticObject().removeObjectProperty(lodp_hasTopic,value.getSemanticObject());
    }

   /**
   * Gets the Topic
   * @return a com.infotec.lodp.swb.Topic
   */
    public com.infotec.lodp.swb.Topic getTopic()
    {
         com.infotec.lodp.swb.Topic ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_hasTopic);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Topic)obj.createGenericInstance();
         }
         return ret;
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

/**
* Gets the DatasetCreated property
* @return java.util.Date with the DatasetCreated
*/
    public java.util.Date getDatasetCreated()
    {
        return getSemanticObject().getDateProperty(lodp_datasetCreated);
    }

/**
* Sets the DatasetCreated property
* @param value long with the DatasetCreated
*/
    public void setDatasetCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_datasetCreated, value);
    }
   /**
   * Sets the value for the property ActualVersion
   * @param value ActualVersion to set
   */

    public void setActualVersion(com.infotec.lodp.swb.DatasetVersion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_actualVersion, value.getSemanticObject());
        }else
        {
            removeActualVersion();
        }
    }
   /**
   * Remove the value for ActualVersion property
   */

    public void removeActualVersion()
    {
        getSemanticObject().removeProperty(lodp_actualVersion);
    }

   /**
   * Gets the ActualVersion
   * @return a com.infotec.lodp.swb.DatasetVersion
   */
    public com.infotec.lodp.swb.DatasetVersion getActualVersion()
    {
         com.infotec.lodp.swb.DatasetVersion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_actualVersion);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.DatasetVersion)obj.createGenericInstance();
         }
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
* Gets the DatasetActive property
* @return boolean with the DatasetActive
*/
    public boolean isDatasetActive()
    {
        return getSemanticObject().getBooleanProperty(lodp_datasetActive);
    }

/**
* Sets the DatasetActive property
* @param value long with the DatasetActive
*/
    public void setDatasetActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(lodp_datasetActive, value);
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
* Gets the DatasetFormat property
* @return String with the DatasetFormat
*/
    public String getDatasetFormat()
    {
        return getSemanticObject().getProperty(lodp_datasetFormat);
    }

/**
* Sets the DatasetFormat property
* @param value long with the DatasetFormat
*/
    public void setDatasetFormat(String value)
    {
        getSemanticObject().setProperty(lodp_datasetFormat, value);
    }

/**
* Gets the DatasetSize property
* @return float with the DatasetSize
*/
    public float getDatasetSize()
    {
        return getSemanticObject().getFloatProperty(lodp_datasetSize);
    }

/**
* Sets the DatasetSize property
* @param value long with the DatasetSize
*/
    public void setDatasetSize(float value)
    {
        getSemanticObject().setFloatProperty(lodp_datasetSize, value);
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
   * Sets the value for the property Publisher
   * @param value Publisher to set
   */

    public void setPublisher(com.infotec.lodp.swb.Publisher value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_publisher, value.getSemanticObject());
        }else
        {
            removePublisher();
        }
    }
   /**
   * Remove the value for Publisher property
   */

    public void removePublisher()
    {
        getSemanticObject().removeProperty(lodp_publisher);
    }

   /**
   * Gets the Publisher
   * @return a com.infotec.lodp.swb.Publisher
   */
    public com.infotec.lodp.swb.Publisher getPublisher()
    {
         com.infotec.lodp.swb.Publisher ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_publisher);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Publisher)obj.createGenericInstance();
         }
         return ret;
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
   /**
   * Gets all the com.infotec.lodp.swb.Tag
   * @return A GenericIterator with all the com.infotec.lodp.swb.Tag
   */

    public org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Tag> listTags()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Tag>(getSemanticObject().listObjectProperties(lodp_hasTag));
    }

   /**
   * Gets true if has a Tag
   * @param value com.infotec.lodp.swb.Tag to verify
   * @return true if the com.infotec.lodp.swb.Tag exists, false otherwise
   */
    public boolean hasTag(com.infotec.lodp.swb.Tag value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(lodp_hasTag,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Tag
   * @param value com.infotec.lodp.swb.Tag to add
   */

    public void addTag(com.infotec.lodp.swb.Tag value)
    {
        getSemanticObject().addObjectProperty(lodp_hasTag, value.getSemanticObject());
    }
   /**
   * Removes all the Tag
   */

    public void removeAllTag()
    {
        getSemanticObject().removeProperty(lodp_hasTag);
    }
   /**
   * Removes a Tag
   * @param value com.infotec.lodp.swb.Tag to remove
   */

    public void removeTag(com.infotec.lodp.swb.Tag value)
    {
        getSemanticObject().removeObjectProperty(lodp_hasTag,value.getSemanticObject());
    }

   /**
   * Gets the Tag
   * @return a com.infotec.lodp.swb.Tag
   */
    public com.infotec.lodp.swb.Tag getTag()
    {
         com.infotec.lodp.swb.Tag ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_hasTag);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Tag)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DatasetTitle property
* @return String with the DatasetTitle
*/
    public String getDatasetTitle()
    {
        return getSemanticObject().getProperty(lodp_datasetTitle);
    }

/**
* Sets the DatasetTitle property
* @param value long with the DatasetTitle
*/
    public void setDatasetTitle(String value)
    {
        getSemanticObject().setProperty(lodp_datasetTitle, value);
    }
   /**
   * Sets the value for the property License
   * @param value License to set
   */

    public void setLicense(com.infotec.lodp.swb.LicenseType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_license, value.getSemanticObject());
        }else
        {
            removeLicense();
        }
    }
   /**
   * Remove the value for License property
   */

    public void removeLicense()
    {
        getSemanticObject().removeProperty(lodp_license);
    }

   /**
   * Gets the License
   * @return a com.infotec.lodp.swb.LicenseType
   */
    public com.infotec.lodp.swb.LicenseType getLicense()
    {
         com.infotec.lodp.swb.LicenseType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_license);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.LicenseType)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Institution
   * @param value Institution to set
   */

    public void setInstitution(com.infotec.lodp.swb.Institution value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_institution, value.getSemanticObject());
        }else
        {
            removeInstitution();
        }
    }
   /**
   * Remove the value for Institution property
   */

    public void removeInstitution()
    {
        getSemanticObject().removeProperty(lodp_institution);
    }

   /**
   * Gets the Institution
   * @return a com.infotec.lodp.swb.Institution
   */
    public com.infotec.lodp.swb.Institution getInstitution()
    {
         com.infotec.lodp.swb.Institution ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_institution);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Institution)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DatasetView property
* @return int with the DatasetView
*/
    public int getDatasetView()
    {
        return getSemanticObject().getIntProperty(lodp_datasetView);
    }

/**
* Sets the DatasetView property
* @param value long with the DatasetView
*/
    public void setDatasetView(int value)
    {
        getSemanticObject().setIntProperty(lodp_datasetView, value);
    }

/**
* Gets the DatasetUpdated property
* @return java.util.Date with the DatasetUpdated
*/
    public java.util.Date getDatasetUpdated()
    {
        return getSemanticObject().getDateProperty(lodp_datasetUpdated);
    }

/**
* Sets the DatasetUpdated property
* @param value long with the DatasetUpdated
*/
    public void setDatasetUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_datasetUpdated, value);
    }
   /**
   * Sets the value for the property DatasetSector
   * @param value DatasetSector to set
   */

    public void setDatasetSector(com.infotec.lodp.swb.Sector value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodpcg_datasetSector, value.getSemanticObject());
        }else
        {
            removeDatasetSector();
        }
    }
   /**
   * Remove the value for DatasetSector property
   */

    public void removeDatasetSector()
    {
        getSemanticObject().removeProperty(lodpcg_datasetSector);
    }

   /**
   * Gets the DatasetSector
   * @return a com.infotec.lodp.swb.Sector
   */
    public com.infotec.lodp.swb.Sector getDatasetSector()
    {
         com.infotec.lodp.swb.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodpcg_datasetSector);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Sector)obj.createGenericInstance();
         }
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
   * Sets the value for the property LastVersion
   * @param value LastVersion to set
   */

    public void setLastVersion(com.infotec.lodp.swb.DatasetVersion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_lastVersion, value.getSemanticObject());
        }else
        {
            removeLastVersion();
        }
    }
   /**
   * Remove the value for LastVersion property
   */

    public void removeLastVersion()
    {
        getSemanticObject().removeProperty(lodp_lastVersion);
    }

   /**
   * Gets the LastVersion
   * @return a com.infotec.lodp.swb.DatasetVersion
   */
    public com.infotec.lodp.swb.DatasetVersion getLastVersion()
    {
         com.infotec.lodp.swb.DatasetVersion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_lastVersion);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.DatasetVersion)obj.createGenericInstance();
         }
         return ret;
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
* Gets the DatasetDescription property
* @return String with the DatasetDescription
*/
    public String getDatasetDescription()
    {
        return getSemanticObject().getProperty(lodp_datasetDescription);
    }

/**
* Sets the DatasetDescription property
* @param value long with the DatasetDescription
*/
    public void setDatasetDescription(String value)
    {
        getSemanticObject().setProperty(lodp_datasetDescription, value);
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
