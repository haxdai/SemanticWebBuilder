package org.semanticwb.social.base;


   /**
   * Clase en donde se almacenan todos los post de tipo Video y que entran por el Listener 
   */
public abstract class VideoInBase extends org.semanticwb.social.PostIn implements org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.social.Video_able,org.semanticwb.model.Traceable
{
   /**
   * Clase en donde se almacenan todos los post de tipo Video y que entran por el Listener
   */
    public static final org.semanticwb.platform.SemanticClass social_VideoIn=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#VideoIn");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#VideoIn");

    public static class ClassMgr
    {
       /**
       * Returns a list of VideoIn for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoIns(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.VideoIn for all models
       * @return Iterator of org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoIns()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn>(it, true);
        }
       /**
       * Gets a org.semanticwb.social.VideoIn
       * @param id Identifier for org.semanticwb.social.VideoIn
       * @param model Model of the org.semanticwb.social.VideoIn
       * @return A org.semanticwb.social.VideoIn
       */
        public static org.semanticwb.social.VideoIn getVideoIn(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.VideoIn)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.VideoIn
       * @param id Identifier for org.semanticwb.social.VideoIn
       * @param model Model of the org.semanticwb.social.VideoIn
       * @return A org.semanticwb.social.VideoIn
       */
        public static org.semanticwb.social.VideoIn createVideoIn(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.VideoIn)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.VideoIn
       * @param id Identifier for org.semanticwb.social.VideoIn
       * @param model Model of the org.semanticwb.social.VideoIn
       */
        public static void removeVideoIn(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.VideoIn
       * @param id Identifier for org.semanticwb.social.VideoIn
       * @param model Model of the org.semanticwb.social.VideoIn
       * @return true if the org.semanticwb.social.VideoIn exists, false otherwise
       */

        public static boolean hasVideoIn(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVideoIn(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.VideoIn with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.VideoIn
       * @return Iterator with all the org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoInByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.VideoIn with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoInByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.VideoIn with a determined PostListenerBase
       * @param value PostListenerBase of the type org.semanticwb.social.PostListenerContainerBase
       * @param model Model of the org.semanticwb.social.VideoIn
       * @return Iterator with all the org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoInByPostListenerBase(org.semanticwb.social.PostListenerContainerBase value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_postListenerBase, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.VideoIn with a determined PostListenerBase
       * @param value PostListenerBase of the type org.semanticwb.social.PostListenerContainerBase
       * @return Iterator with all the org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoInByPostListenerBase(org.semanticwb.social.PostListenerContainerBase value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_postListenerBase,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.VideoIn with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.VideoIn
       * @return Iterator with all the org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoInByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.VideoIn with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.VideoIn
       */

        public static java.util.Iterator<org.semanticwb.social.VideoIn> listVideoInByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.VideoIn> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VideoInBase with a SemanticObject
   * @param base The SemanticObject with the properties for the VideoIn
   */
    public VideoInBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Video property
* @return String with the Video
*/
    public String getVideo()
    {
        return getSemanticObject().getProperty(social_video);
    }

/**
* Sets the Video property
* @param value long with the Video
*/
    public void setVideo(String value)
    {
        getSemanticObject().setProperty(social_video, value);
    }
}
