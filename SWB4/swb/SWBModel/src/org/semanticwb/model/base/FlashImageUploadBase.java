package org.semanticwb.model.base;


public abstract class FlashImageUploadBase extends org.semanticwb.model.FlashFileUpload implements org.semanticwb.model.ImageUploadable
{
    public static final org.semanticwb.platform.SemanticClass swb_FlashImageUpload=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#FlashImageUpload");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#FlashImageUpload");

    public static class ClassMgr
    {
       /**
       * Returns a list of FlashImageUpload for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.FlashImageUpload
       */

        public static java.util.Iterator<org.semanticwb.model.FlashImageUpload> listFlashImageUploads(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.FlashImageUpload>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.FlashImageUpload for all models
       * @return Iterator of org.semanticwb.model.FlashImageUpload
       */

        public static java.util.Iterator<org.semanticwb.model.FlashImageUpload> listFlashImageUploads()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.FlashImageUpload>(it, true);
        }
       /**
       * Gets a org.semanticwb.model.FlashImageUpload
       * @param id Identifier for org.semanticwb.model.FlashImageUpload
       * @param model Model of the org.semanticwb.model.FlashImageUpload
       * @return A org.semanticwb.model.FlashImageUpload
       */
        public static org.semanticwb.model.FlashImageUpload getFlashImageUpload(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.FlashImageUpload)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.FlashImageUpload
       * @param id Identifier for org.semanticwb.model.FlashImageUpload
       * @param model Model of the org.semanticwb.model.FlashImageUpload
       * @return A org.semanticwb.model.FlashImageUpload
       */
        public static org.semanticwb.model.FlashImageUpload createFlashImageUpload(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.FlashImageUpload)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.FlashImageUpload
       * @param id Identifier for org.semanticwb.model.FlashImageUpload
       * @param model Model of the org.semanticwb.model.FlashImageUpload
       */
        public static void removeFlashImageUpload(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.FlashImageUpload
       * @param id Identifier for org.semanticwb.model.FlashImageUpload
       * @param model Model of the org.semanticwb.model.FlashImageUpload
       * @return true if the org.semanticwb.model.FlashImageUpload exists, false otherwise
       */

        public static boolean hasFlashImageUpload(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFlashImageUpload(id, model)!=null);
        }
    }

    public static FlashImageUploadBase.ClassMgr getFlashImageUploadClassMgr()
    {
        return new FlashImageUploadBase.ClassMgr();
    }

   /**
   * Constructs a FlashImageUploadBase with a SemanticObject
   * @param base The SemanticObject with the properties for the FlashImageUpload
   */
    public FlashImageUploadBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ImgThumbnail property
* @return boolean with the ImgThumbnail
*/
    public boolean isImgThumbnail()
    {
        return getSemanticObject().getBooleanProperty(swbxf_imgThumbnail);
    }

/**
* Sets the ImgThumbnail property
* @param value long with the ImgThumbnail
*/
    public void setImgThumbnail(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbxf_imgThumbnail, value);
    }

/**
* Gets the ImgMaxHeight property
* @return int with the ImgMaxHeight
*/
    public int getImgMaxHeight()
    {
        return getSemanticObject().getIntProperty(swbxf_imgMaxHeight);
    }

/**
* Sets the ImgMaxHeight property
* @param value long with the ImgMaxHeight
*/
    public void setImgMaxHeight(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgMaxHeight, value);
    }

/**
* Gets the ImgThumbnailHeight property
* @return int with the ImgThumbnailHeight
*/
    public int getImgThumbnailHeight()
    {
        return getSemanticObject().getIntProperty(swbxf_imgThumbnailHeight);
    }

/**
* Sets the ImgThumbnailHeight property
* @param value long with the ImgThumbnailHeight
*/
    public void setImgThumbnailHeight(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgThumbnailHeight, value);
    }

/**
* Gets the ImgMaxWidth property
* @return int with the ImgMaxWidth
*/
    public int getImgMaxWidth()
    {
        return getSemanticObject().getIntProperty(swbxf_imgMaxWidth);
    }

/**
* Sets the ImgMaxWidth property
* @param value long with the ImgMaxWidth
*/
    public void setImgMaxWidth(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgMaxWidth, value);
    }

/**
* Gets the ImgThumbnailList property
* @return String with the ImgThumbnailList
*/
    public String getImgThumbnailList()
    {
        return getSemanticObject().getProperty(swbxf_imgThumbnailList);
    }

/**
* Sets the ImgThumbnailList property
* @param value long with the ImgThumbnailList
*/
    public void setImgThumbnailList(String value)
    {
        getSemanticObject().setProperty(swbxf_imgThumbnailList, value);
    }

/**
* Gets the ImgCrop property
* @return boolean with the ImgCrop
*/
    public boolean isImgCrop()
    {
        return getSemanticObject().getBooleanProperty(swbxf_imgCrop);
    }

/**
* Sets the ImgCrop property
* @param value long with the ImgCrop
*/
    public void setImgCrop(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbxf_imgCrop, value);
    }

/**
* Gets the ImgThumbnailWidth property
* @return int with the ImgThumbnailWidth
*/
    public int getImgThumbnailWidth()
    {
        return getSemanticObject().getIntProperty(swbxf_imgThumbnailWidth);
    }

/**
* Sets the ImgThumbnailWidth property
* @param value long with the ImgThumbnailWidth
*/
    public void setImgThumbnailWidth(int value)
    {
        getSemanticObject().setIntProperty(swbxf_imgThumbnailWidth, value);
    }
}
