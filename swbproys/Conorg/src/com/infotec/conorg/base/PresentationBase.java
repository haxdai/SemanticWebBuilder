package com.infotec.conorg.base;


public abstract class PresentationBase extends com.infotec.conorg.Document implements com.infotec.conorg.Topicable,org.semanticwb.model.Versionable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.Calendarable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_presentationVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#presentationVersion");
    public static final org.semanticwb.platform.SemanticClass conorg_Presentation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Presentation");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Presentation");

    public static class ClassMgr
    {
       /**
       * Returns a list of Presentation for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Presentation for all models
       * @return Iterator of com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation>(it, true);
        }

        public static com.infotec.conorg.Presentation createPresentation(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Presentation.ClassMgr.createPresentation(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Presentation
       * @param id Identifier for com.infotec.conorg.Presentation
       * @param model Model of the com.infotec.conorg.Presentation
       * @return A com.infotec.conorg.Presentation
       */
        public static com.infotec.conorg.Presentation getPresentation(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Presentation)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Presentation
       * @param id Identifier for com.infotec.conorg.Presentation
       * @param model Model of the com.infotec.conorg.Presentation
       * @return A com.infotec.conorg.Presentation
       */
        public static com.infotec.conorg.Presentation createPresentation(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Presentation)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Presentation
       * @param id Identifier for com.infotec.conorg.Presentation
       * @param model Model of the com.infotec.conorg.Presentation
       */
        public static void removePresentation(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Presentation
       * @param id Identifier for com.infotec.conorg.Presentation
       * @param model Model of the com.infotec.conorg.Presentation
       * @return true if the com.infotec.conorg.Presentation exists, false otherwise
       */

        public static boolean hasPresentation(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPresentation(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_resource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_resource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Presentation
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Presentation with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Presentation
       */

        public static java.util.Iterator<com.infotec.conorg.Presentation> listPresentationByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Presentation> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PresentationBase.ClassMgr getPresentationClassMgr()
    {
        return new PresentationBase.ClassMgr();
    }

   /**
   * Constructs a PresentationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Presentation
   */
    public PresentationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the PresentationVersion property
* @return String with the PresentationVersion
*/
    public String getPresentationVersion()
    {
        return getSemanticObject().getProperty(conorg_presentationVersion);
    }

/**
* Sets the PresentationVersion property
* @param value long with the PresentationVersion
*/
    public void setPresentationVersion(String value)
    {
        getSemanticObject().setProperty(conorg_presentationVersion, value);
    }
}
