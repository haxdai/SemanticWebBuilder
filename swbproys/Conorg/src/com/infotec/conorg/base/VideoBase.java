package com.infotec.conorg.base;


public abstract class VideoBase extends com.infotec.conorg.Document implements org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,org.semanticwb.model.Versionable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_videoRights=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#videoRights");
    public static final org.semanticwb.platform.SemanticClass conorg_Video=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Video");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Video");

    public static class ClassMgr
    {
       /**
       * Returns a list of Video for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Video>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Video for all models
       * @return Iterator of com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Video>(it, true);
        }

        public static com.infotec.conorg.Video createVideo(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Video.ClassMgr.createVideo(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Video
       * @param id Identifier for com.infotec.conorg.Video
       * @param model Model of the com.infotec.conorg.Video
       * @return A com.infotec.conorg.Video
       */
        public static com.infotec.conorg.Video getVideo(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Video)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Video
       * @param id Identifier for com.infotec.conorg.Video
       * @param model Model of the com.infotec.conorg.Video
       * @return A com.infotec.conorg.Video
       */
        public static com.infotec.conorg.Video createVideo(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Video)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Video
       * @param id Identifier for com.infotec.conorg.Video
       * @param model Model of the com.infotec.conorg.Video
       */
        public static void removeVideo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Video
       * @param id Identifier for com.infotec.conorg.Video
       * @param model Model of the com.infotec.conorg.Video
       * @return true if the com.infotec.conorg.Video exists, false otherwise
       */

        public static boolean hasVideo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVideo(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Editors
       * @param value Editors of the type com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByEditors(com.infotec.conorg.Editors value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasEditors, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Editors
       * @param value Editors of the type com.infotec.conorg.Editors
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByEditors(com.infotec.conorg.Editors value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasEditors,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Author
       * @param value Author of the type com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByAuthor(com.infotec.conorg.Author value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasAuthor, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Author
       * @param value Author of the type com.infotec.conorg.Author
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByAuthor(com.infotec.conorg.Author value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasAuthor,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Video
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Video with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Video
       */

        public static java.util.Iterator<com.infotec.conorg.Video> listVideoByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Video> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VideoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Video
   */
    public VideoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the VideoRights property
* @return String with the VideoRights
*/
    public String getVideoRights()
    {
        return getSemanticObject().getProperty(conorg_videoRights);
    }

/**
* Sets the VideoRights property
* @param value long with the VideoRights
*/
    public void setVideoRights(String value)
    {
        getSemanticObject().setProperty(conorg_videoRights, value);
    }
}
