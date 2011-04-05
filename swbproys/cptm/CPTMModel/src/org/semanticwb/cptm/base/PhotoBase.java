package org.semanticwb.cptm.base;


   /**
   * Clase generica para fotos 
   */
public abstract class PhotoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Imagen de la foto
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_PhotoImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#PhotoImage");
   /**
   * Texto Alterno de la Foto
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_PhotoAlt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#PhotoAlt");
   /**
   * Clase generica para fotos
   */
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

/**
* Gets the PhotoAlt property
* @return String with the PhotoAlt
*/
    public String getPhotoAlt()
    {
        return getSemanticObject().getProperty(cptm_PhotoAlt);
    }

/**
* Sets the PhotoAlt property
* @param value long with the PhotoAlt
*/
    public void setPhotoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_PhotoAlt, value);
    }

    public String getPhotoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_PhotoAlt, null, lang);
    }

    public String getDisplayPhotoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_PhotoAlt, lang);
    }

    public void setPhotoAlt(String PhotoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_PhotoAlt, PhotoAlt, lang);
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
