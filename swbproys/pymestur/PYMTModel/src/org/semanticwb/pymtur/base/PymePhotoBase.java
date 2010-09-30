package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar fotos 
   */
public abstract class PymePhotoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Tamaño de la imagen
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_photoSize=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#photoSize");
   /**
   * Thumbnail de la imagen
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_photoThumbnail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#photoThumbnail");
   /**
   * MimeType de la foto
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_photoMimeType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#photoMimeType");
   /**
   * Imagen de la foto
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_PhotoImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoImage");
   /**
   * Clase que se encarga de administrar fotos
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");

    public static class ClassMgr
    {
       /**
       * Returns a list of PymePhoto for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.PymePhoto
       */

        public static java.util.Iterator<org.semanticwb.pymtur.PymePhoto> listPymePhotos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.PymePhoto for all models
       * @return Iterator of org.semanticwb.pymtur.PymePhoto
       */

        public static java.util.Iterator<org.semanticwb.pymtur.PymePhoto> listPymePhotos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(it, true);
        }

        public static org.semanticwb.pymtur.PymePhoto createPymePhoto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.PymePhoto.ClassMgr.createPymePhoto(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.PymePhoto
       * @param id Identifier for org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.PymePhoto
       * @return A org.semanticwb.pymtur.PymePhoto
       */
        public static org.semanticwb.pymtur.PymePhoto getPymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.PymePhoto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.PymePhoto
       * @param id Identifier for org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.PymePhoto
       * @return A org.semanticwb.pymtur.PymePhoto
       */
        public static org.semanticwb.pymtur.PymePhoto createPymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.PymePhoto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.PymePhoto
       * @param id Identifier for org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.PymePhoto
       */
        public static void removePymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.PymePhoto
       * @param id Identifier for org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.PymePhoto
       * @return true if the org.semanticwb.pymtur.PymePhoto exists, false otherwise
       */

        public static boolean hasPymePhoto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPymePhoto(id, model)!=null);
        }
    }

   /**
   * Constructs a PymePhotoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PymePhoto
   */
    public PymePhotoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the PhotoSize property
* @return float with the PhotoSize
*/
    public float getPhotoSize()
    {
        return getSemanticObject().getFloatProperty(pymtur_photoSize);
    }

/**
* Sets the PhotoSize property
* @param value long with the PhotoSize
*/
    public void setPhotoSize(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_photoSize, value);
    }

/**
* Gets the PhotoThumbnail property
* @return String with the PhotoThumbnail
*/
    public String getPhotoThumbnail()
    {
        return getSemanticObject().getProperty(pymtur_photoThumbnail);
    }

/**
* Sets the PhotoThumbnail property
* @param value long with the PhotoThumbnail
*/
    public void setPhotoThumbnail(String value)
    {
        getSemanticObject().setProperty(pymtur_photoThumbnail, value);
    }

/**
* Gets the PhotoMimeType property
* @return String with the PhotoMimeType
*/
    public String getPhotoMimeType()
    {
        return getSemanticObject().getProperty(pymtur_photoMimeType);
    }

/**
* Sets the PhotoMimeType property
* @param value long with the PhotoMimeType
*/
    public void setPhotoMimeType(String value)
    {
        getSemanticObject().setProperty(pymtur_photoMimeType, value);
    }

/**
* Gets the PhotoImage property
* @return String with the PhotoImage
*/
    public String getPhotoImage()
    {
        return getSemanticObject().getProperty(pymtur_PhotoImage);
    }

/**
* Sets the PhotoImage property
* @param value long with the PhotoImage
*/
    public void setPhotoImage(String value)
    {
        getSemanticObject().setProperty(pymtur_PhotoImage, value);
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
}
