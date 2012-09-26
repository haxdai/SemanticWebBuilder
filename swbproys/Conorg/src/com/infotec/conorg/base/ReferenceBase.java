package com.infotec.conorg.base;


public abstract class ReferenceBase extends com.infotec.conorg.Document implements org.semanticwb.model.Tagable,org.semanticwb.model.Versionable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,com.infotec.conorg.Topicable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Reference=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Reference");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Reference");

    public static class ClassMgr
    {
       /**
       * Returns a list of Reference for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferences(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Reference for all models
       * @return Iterator of com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferences()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference>(it, true);
        }

        public static com.infotec.conorg.Reference createReference(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Reference.ClassMgr.createReference(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Reference
       * @param id Identifier for com.infotec.conorg.Reference
       * @param model Model of the com.infotec.conorg.Reference
       * @return A com.infotec.conorg.Reference
       */
        public static com.infotec.conorg.Reference getReference(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Reference)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Reference
       * @param id Identifier for com.infotec.conorg.Reference
       * @param model Model of the com.infotec.conorg.Reference
       * @return A com.infotec.conorg.Reference
       */
        public static com.infotec.conorg.Reference createReference(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Reference)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Reference
       * @param id Identifier for com.infotec.conorg.Reference
       * @param model Model of the com.infotec.conorg.Reference
       */
        public static void removeReference(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Reference
       * @param id Identifier for com.infotec.conorg.Reference
       * @param model Model of the com.infotec.conorg.Reference
       * @return true if the com.infotec.conorg.Reference exists, false otherwise
       */

        public static boolean hasReference(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReference(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Reference
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Reference
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Reference
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Reference
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Reference
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Reference
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Reference with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Reference
       */

        public static java.util.Iterator<com.infotec.conorg.Reference> listReferenceByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Reference> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ReferenceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Reference
   */
    public ReferenceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
