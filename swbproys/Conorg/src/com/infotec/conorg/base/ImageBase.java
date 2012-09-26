package com.infotec.conorg.base;


public abstract class ImageBase extends com.infotec.conorg.Document implements org.semanticwb.model.Tagable,org.semanticwb.model.Versionable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,com.infotec.conorg.Topicable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_imageRights=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#imageRights");
    public static final org.semanticwb.platform.SemanticClass conorg_Image=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Image");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Image");

    public static class ClassMgr
    {
       /**
       * Returns a list of Image for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImages(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Image>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Image for all models
       * @return Iterator of com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImages()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Image>(it, true);
        }

        public static com.infotec.conorg.Image createImage(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Image.ClassMgr.createImage(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Image
       * @param id Identifier for com.infotec.conorg.Image
       * @param model Model of the com.infotec.conorg.Image
       * @return A com.infotec.conorg.Image
       */
        public static com.infotec.conorg.Image getImage(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Image)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Image
       * @param id Identifier for com.infotec.conorg.Image
       * @param model Model of the com.infotec.conorg.Image
       * @return A com.infotec.conorg.Image
       */
        public static com.infotec.conorg.Image createImage(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Image)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Image
       * @param id Identifier for com.infotec.conorg.Image
       * @param model Model of the com.infotec.conorg.Image
       */
        public static void removeImage(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Image
       * @param id Identifier for com.infotec.conorg.Image
       * @param model Model of the com.infotec.conorg.Image
       * @return true if the com.infotec.conorg.Image exists, false otherwise
       */

        public static boolean hasImage(String id, org.semanticwb.model.SWBModel model)
        {
            return (getImage(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Image
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Image
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Image
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Image
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Image
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Image
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Image with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Image
       */

        public static java.util.Iterator<com.infotec.conorg.Image> listImageByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Image> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ImageBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Image
   */
    public ImageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ImageRights property
* @return String with the ImageRights
*/
    public String getImageRights()
    {
        return getSemanticObject().getProperty(conorg_imageRights);
    }

/**
* Sets the ImageRights property
* @param value long with the ImageRights
*/
    public void setImageRights(String value)
    {
        getSemanticObject().setProperty(conorg_imageRights, value);
    }
}
