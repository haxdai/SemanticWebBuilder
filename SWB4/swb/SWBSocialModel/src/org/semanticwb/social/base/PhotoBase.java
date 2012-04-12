package org.semanticwb.social.base;


public abstract class PhotoBase extends org.semanticwb.social.Post implements org.semanticwb.social.Comentable,org.semanticwb.model.Traceable,org.semanticwb.model.Expirable
{
   /**
   * Ruta del archivo de la imagen (Foto)
   */
    public static final org.semanticwb.platform.SemanticProperty social_photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/socialNet#photo");
    public static final org.semanticwb.platform.SemanticClass social_Photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/socialNet#Photo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/socialNet#Photo");

    public static class ClassMgr
    {
       /**
       * Returns a list of Photo for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.Photo for all models
       * @return Iterator of org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo>(it, true);
        }

        public static org.semanticwb.social.Photo createPhoto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.social.Photo.ClassMgr.createPhoto(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.social.Photo
       * @param id Identifier for org.semanticwb.social.Photo
       * @param model Model of the org.semanticwb.social.Photo
       * @return A org.semanticwb.social.Photo
       */
        public static org.semanticwb.social.Photo getPhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Photo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.Photo
       * @param id Identifier for org.semanticwb.social.Photo
       * @param model Model of the org.semanticwb.social.Photo
       * @return A org.semanticwb.social.Photo
       */
        public static org.semanticwb.social.Photo createPhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Photo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.Photo
       * @param id Identifier for org.semanticwb.social.Photo
       * @param model Model of the org.semanticwb.social.Photo
       */
        public static void removePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.Photo
       * @param id Identifier for org.semanticwb.social.Photo
       * @param model Model of the org.semanticwb.social.Photo
       * @return true if the org.semanticwb.social.Photo exists, false otherwise
       */

        public static boolean hasPhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPhoto(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.Photo with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Photo
       * @return Iterator with all the org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Photo with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Photo with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Photo
       * @return Iterator with all the org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Photo with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Photo with a determined PostContainer_PostInv
       * @param value PostContainer_PostInv of the type org.semanticwb.social.PostContainer
       * @param model Model of the org.semanticwb.social.Photo
       * @return Iterator with all the org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotoByPostContainer_PostInv(org.semanticwb.social.PostContainer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostContainer_PostInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Photo with a determined PostContainer_PostInv
       * @param value PostContainer_PostInv of the type org.semanticwb.social.PostContainer
       * @return Iterator with all the org.semanticwb.social.Photo
       */

        public static java.util.Iterator<org.semanticwb.social.Photo> listPhotoByPostContainer_PostInv(org.semanticwb.social.PostContainer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Photo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostContainer_PostInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PhotoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Photo
   */
    public PhotoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Photo property
* @return String with the Photo
*/
    public String getPhoto()
    {
        return getSemanticObject().getProperty(social_photo);
    }

/**
* Sets the Photo property
* @param value long with the Photo
*/
    public void setPhoto(String value)
    {
        getSemanticObject().setProperty(social_photo, value);
    }

/**
* Gets the Comment property
* @return String with the Comment
*/
    public String getComment()
    {
        return getSemanticObject().getProperty(social_comment);
    }

/**
* Sets the Comment property
* @param value long with the Comment
*/
    public void setComment(String value)
    {
        getSemanticObject().setProperty(social_comment, value);
    }
}
