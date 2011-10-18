package org.semanticwb.process.schema.base;


public abstract class FileBase extends org.semanticwb.process.model.DataTypes 
{
    public static final org.semanticwb.platform.SemanticProperty swp_fileValue=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/process#fileValue");
    public static final org.semanticwb.platform.SemanticClass swp_RepositoryFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#RepositoryFile");
    public static final org.semanticwb.platform.SemanticProperty swp_repositoryFileRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/process#repositoryFileRef");
    public static final org.semanticwb.platform.SemanticClass swps_File=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process/schema#File");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process/schema#File");

    public static class ClassMgr
    {
       /**
       * Returns a list of File for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.schema.File
       */

        public static java.util.Iterator<org.semanticwb.process.schema.File> listFiles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.schema.File>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.schema.File for all models
       * @return Iterator of org.semanticwb.process.schema.File
       */

        public static java.util.Iterator<org.semanticwb.process.schema.File> listFiles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.schema.File>(it, true);
        }
       /**
       * Gets a org.semanticwb.process.schema.File
       * @param id Identifier for org.semanticwb.process.schema.File
       * @param model Model of the org.semanticwb.process.schema.File
       * @return A org.semanticwb.process.schema.File
       */
        public static org.semanticwb.process.schema.File getFile(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.schema.File)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.schema.File
       * @param id Identifier for org.semanticwb.process.schema.File
       * @param model Model of the org.semanticwb.process.schema.File
       * @return A org.semanticwb.process.schema.File
       */
        public static org.semanticwb.process.schema.File createFile(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.schema.File)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.schema.File
       * @param id Identifier for org.semanticwb.process.schema.File
       * @param model Model of the org.semanticwb.process.schema.File
       */
        public static void removeFile(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.schema.File
       * @param id Identifier for org.semanticwb.process.schema.File
       * @param model Model of the org.semanticwb.process.schema.File
       * @return true if the org.semanticwb.process.schema.File exists, false otherwise
       */

        public static boolean hasFile(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFile(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.schema.File with a determined RepositoryFile
       * @param value RepositoryFile of the type org.semanticwb.process.model.RepositoryFile
       * @param model Model of the org.semanticwb.process.schema.File
       * @return Iterator with all the org.semanticwb.process.schema.File
       */

        public static java.util.Iterator<org.semanticwb.process.schema.File> listFileByRepositoryFile(org.semanticwb.process.model.RepositoryFile value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.schema.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_repositoryFileRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.schema.File with a determined RepositoryFile
       * @param value RepositoryFile of the type org.semanticwb.process.model.RepositoryFile
       * @return Iterator with all the org.semanticwb.process.schema.File
       */

        public static java.util.Iterator<org.semanticwb.process.schema.File> listFileByRepositoryFile(org.semanticwb.process.model.RepositoryFile value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.schema.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_repositoryFileRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a FileBase with a SemanticObject
   * @param base The SemanticObject with the properties for the File
   */
    public FileBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Value property
* @return String with the Value
*/
    public String getValue()
    {
        return getSemanticObject().getProperty(swp_fileValue);
    }

/**
* Sets the Value property
* @param value long with the Value
*/
    public void setValue(String value)
    {
        getSemanticObject().setProperty(swp_fileValue, value);
    }
   /**
   * Sets the value for the property RepositoryFile
   * @param value RepositoryFile to set
   */

    public void setRepositoryFile(org.semanticwb.process.model.RepositoryFile value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swp_repositoryFileRef, value.getSemanticObject());
        }else
        {
            removeRepositoryFile();
        }
    }
   /**
   * Remove the value for RepositoryFile property
   */

    public void removeRepositoryFile()
    {
        getSemanticObject().removeProperty(swp_repositoryFileRef);
    }

   /**
   * Gets the RepositoryFile
   * @return a org.semanticwb.process.model.RepositoryFile
   */
    public org.semanticwb.process.model.RepositoryFile getRepositoryFile()
    {
         org.semanticwb.process.model.RepositoryFile ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swp_repositoryFileRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.process.model.RepositoryFile)obj.createGenericInstance();
         }
         return ret;
    }
}
