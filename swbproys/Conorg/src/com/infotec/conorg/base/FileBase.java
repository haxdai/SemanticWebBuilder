package com.infotec.conorg.base;


public abstract class FileBase extends com.infotec.conorg.Document implements org.semanticwb.model.Indexable,org.semanticwb.model.Versionable,org.semanticwb.model.Traceable,com.infotec.conorg.Topicable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Calendarable
{
    public static final org.semanticwb.platform.SemanticClass conorg_File=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#File");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#File");

    public static class ClassMgr
    {
       /**
       * Returns a list of File for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFiles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.File>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.File for all models
       * @return Iterator of com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFiles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.File>(it, true);
        }

        public static com.infotec.conorg.File createFile(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.File.ClassMgr.createFile(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.File
       * @param id Identifier for com.infotec.conorg.File
       * @param model Model of the com.infotec.conorg.File
       * @return A com.infotec.conorg.File
       */
        public static com.infotec.conorg.File getFile(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.File)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.File
       * @param id Identifier for com.infotec.conorg.File
       * @param model Model of the com.infotec.conorg.File
       * @return A com.infotec.conorg.File
       */
        public static com.infotec.conorg.File createFile(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.File)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.File
       * @param id Identifier for com.infotec.conorg.File
       * @param model Model of the com.infotec.conorg.File
       */
        public static void removeFile(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.File
       * @param id Identifier for com.infotec.conorg.File
       * @param model Model of the com.infotec.conorg.File
       * @return true if the com.infotec.conorg.File exists, false otherwise
       */

        public static boolean hasFile(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFile(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.File with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.File
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.File
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.File
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.File
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.File
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.File
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.File with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.File
       */

        public static java.util.Iterator<com.infotec.conorg.File> listFileByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.File> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static FileBase.ClassMgr getFileClassMgr()
    {
        return new FileBase.ClassMgr();
    }

   /**
   * Constructs a FileBase with a SemanticObject
   * @param base The SemanticObject with the properties for the File
   */
    public FileBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
