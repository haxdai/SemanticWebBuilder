package org.semanticwb.cptm.base;


public abstract class PhotoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cptm_PhotoThumbnail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#PhotoThumbnail");
    public static final org.semanticwb.platform.SemanticProperty cptm_PhotoMimeType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#PhotoMimeType");
    public static final org.semanticwb.platform.SemanticProperty cptm_PhotoSize=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#PhotoSize");
   /**
   * Imagen de la foto
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_PhotoImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#PhotoImage");
    public static final org.semanticwb.platform.SemanticClass cptm_Photo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Photo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Photo");

    public static class ClassMgr
    {
       /**
       * Returns a list of Photo for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Photo
       */

        public static java.util.Iterator<org.semanticwb.cptm.Photo> listPhotos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Photo for all models
       * @return Iterator of org.semanticwb.cptm.Photo
       */

        public static java.util.Iterator<org.semanticwb.cptm.Photo> listPhotos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Photo
       * @param id Identifier for org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Photo
       * @return A org.semanticwb.cptm.Photo
       */
        public static org.semanticwb.cptm.Photo getPhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Photo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Photo
       * @param id Identifier for org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Photo
       * @return A org.semanticwb.cptm.Photo
       */
        public static org.semanticwb.cptm.Photo createPhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Photo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Photo
       * @param id Identifier for org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Photo
       */
        public static void removePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Photo
       * @param id Identifier for org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Photo
       * @return true if the org.semanticwb.cptm.Photo exists, false otherwise
       */

        public static boolean hasPhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPhoto(id, model)!=null);
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
* Gets the PhotoThumbnail property
* @return String with the PhotoThumbnail
*/
    public String getPhotoThumbnail()
    {
        return getSemanticObject().getProperty(cptm_PhotoThumbnail);
    }

/**
* Sets the PhotoThumbnail property
* @param value long with the PhotoThumbnail
*/
    public void setPhotoThumbnail(String value)
    {
        getSemanticObject().setProperty(cptm_PhotoThumbnail, value);
    }

/**
* Gets the PhotoMimeType property
* @return String with the PhotoMimeType
*/
    public String getPhotoMimeType()
    {
        return getSemanticObject().getProperty(cptm_PhotoMimeType);
    }

/**
* Sets the PhotoMimeType property
* @param value long with the PhotoMimeType
*/
    public void setPhotoMimeType(String value)
    {
        getSemanticObject().setProperty(cptm_PhotoMimeType, value);
    }

/**
* Gets the PhotoSize property
* @return float with the PhotoSize
*/
    public float getPhotoSize()
    {
        return getSemanticObject().getFloatProperty(cptm_PhotoSize);
    }

/**
* Sets the PhotoSize property
* @param value long with the PhotoSize
*/
    public void setPhotoSize(float value)
    {
        getSemanticObject().setFloatProperty(cptm_PhotoSize, value);
    }

/**
* Gets the PhotoImage property
* @return String with the PhotoImage
*/
    public String getPhotoImage()
    {
        return getSemanticObject().getProperty(cptm_PhotoImage);
    }

/**
* Sets the PhotoImage property
* @param value long with the PhotoImage
*/
    public void setPhotoImage(String value)
    {
        getSemanticObject().setProperty(cptm_PhotoImage, value);
    }
}
