package com.infotec.conorg.base;


public abstract class AudioBase extends com.infotec.conorg.Document implements org.semanticwb.model.Calendarable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Versionable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticClass conorg_Audio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Audio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Audio");

    public static class ClassMgr
    {
       /**
       * Returns a list of Audio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Audio for all models
       * @return Iterator of com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio>(it, true);
        }

        public static com.infotec.conorg.Audio createAudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Audio.ClassMgr.createAudio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Audio
       * @param id Identifier for com.infotec.conorg.Audio
       * @param model Model of the com.infotec.conorg.Audio
       * @return A com.infotec.conorg.Audio
       */
        public static com.infotec.conorg.Audio getAudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Audio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Audio
       * @param id Identifier for com.infotec.conorg.Audio
       * @param model Model of the com.infotec.conorg.Audio
       * @return A com.infotec.conorg.Audio
       */
        public static com.infotec.conorg.Audio createAudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Audio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Audio
       * @param id Identifier for com.infotec.conorg.Audio
       * @param model Model of the com.infotec.conorg.Audio
       */
        public static void removeAudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Audio
       * @param id Identifier for com.infotec.conorg.Audio
       * @param model Model of the com.infotec.conorg.Audio
       * @return true if the com.infotec.conorg.Audio exists, false otherwise
       */

        public static boolean hasAudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAudio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Editors
       * @param value Editors of the type com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByEditors(com.infotec.conorg.Editors value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasEditors, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Editors
       * @param value Editors of the type com.infotec.conorg.Editors
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByEditors(com.infotec.conorg.Editors value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasEditors,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Author
       * @param value Author of the type com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByAuthor(com.infotec.conorg.Author value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasAuthor, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Author
       * @param value Author of the type com.infotec.conorg.Author
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByAuthor(com.infotec.conorg.Author value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasAuthor,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Audio
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Audio with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Audio
       */

        public static java.util.Iterator<com.infotec.conorg.Audio> listAudioByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Audio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Audio
   */
    public AudioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
