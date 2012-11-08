package com.infotec.conorg.base;


public abstract class ManualBase extends com.infotec.conorg.Document implements com.infotec.conorg.Topicable,org.semanticwb.model.Versionable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.Calendarable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_manualVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#manualVersion");
    public static final org.semanticwb.platform.SemanticClass conorg_Manual=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Manual");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Manual");

    public static class ClassMgr
    {
       /**
       * Returns a list of Manual for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManuals(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Manual for all models
       * @return Iterator of com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManuals()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual>(it, true);
        }

        public static com.infotec.conorg.Manual createManual(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Manual.ClassMgr.createManual(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Manual
       * @param id Identifier for com.infotec.conorg.Manual
       * @param model Model of the com.infotec.conorg.Manual
       * @return A com.infotec.conorg.Manual
       */
        public static com.infotec.conorg.Manual getManual(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Manual)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Manual
       * @param id Identifier for com.infotec.conorg.Manual
       * @param model Model of the com.infotec.conorg.Manual
       * @return A com.infotec.conorg.Manual
       */
        public static com.infotec.conorg.Manual createManual(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Manual)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Manual
       * @param id Identifier for com.infotec.conorg.Manual
       * @param model Model of the com.infotec.conorg.Manual
       */
        public static void removeManual(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Manual
       * @param id Identifier for com.infotec.conorg.Manual
       * @param model Model of the com.infotec.conorg.Manual
       * @return true if the com.infotec.conorg.Manual exists, false otherwise
       */

        public static boolean hasManual(String id, org.semanticwb.model.SWBModel model)
        {
            return (getManual(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_resource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_resource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Manual
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Manual with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Manual
       */

        public static java.util.Iterator<com.infotec.conorg.Manual> listManualByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Manual> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ManualBase.ClassMgr getManualClassMgr()
    {
        return new ManualBase.ClassMgr();
    }

   /**
   * Constructs a ManualBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Manual
   */
    public ManualBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ManualVersion property
* @return String with the ManualVersion
*/
    public String getManualVersion()
    {
        return getSemanticObject().getProperty(conorg_manualVersion);
    }

/**
* Sets the ManualVersion property
* @param value long with the ManualVersion
*/
    public void setManualVersion(String value)
    {
        getSemanticObject().setProperty(conorg_manualVersion, value);
    }
}
