package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class PhotosBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty swbpress_PFooter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#PFooter");
    public static final org.semanticwb.platform.SemanticProperty swbpress_namePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#namePhoto");
    public static final org.semanticwb.platform.SemanticProperty swbpress_pPrincipal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#pPrincipal");
    public static final org.semanticwb.platform.SemanticClass swbpress_Photos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Photos");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Photos");

    public static class ClassMgr
    {
       /**
       * Returns a list of Photos for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Photos
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Photos> listPhotoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.portal.resources.sem.pressroom.Photos for all models
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.Photos
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.Photos> listPhotoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.Photos>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.Photos createPhotos(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.Photos.ClassMgr.createPhotos(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Photos
       * @return A org.semanticwb.portal.resources.sem.pressroom.Photos
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Photos getPhotos(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Photos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Photos
       * @return A org.semanticwb.portal.resources.sem.pressroom.Photos
       */
        public static org.semanticwb.portal.resources.sem.pressroom.Photos createPhotos(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.Photos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Photos
       */
        public static void removePhotos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.Photos
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.Photos
       * @return true if the org.semanticwb.portal.resources.sem.pressroom.Photos exists, false otherwise
       */

        public static boolean hasPhotos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPhotos(id, model)!=null);
        }
    }

   /**
   * Constructs a PhotosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Photos
   */
    public PhotosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the PFooter property
* @return String with the PFooter
*/
    public String getPFooter()
    {
        return getSemanticObject().getProperty(swbpress_PFooter);
    }

/**
* Sets the PFooter property
* @param value long with the PFooter
*/
    public void setPFooter(String value)
    {
        getSemanticObject().setProperty(swbpress_PFooter, value);
    }

/**
* Gets the NamePhoto property
* @return String with the NamePhoto
*/
    public String getNamePhoto()
    {
        return getSemanticObject().getProperty(swbpress_namePhoto);
    }

/**
* Sets the NamePhoto property
* @param value long with the NamePhoto
*/
    public void setNamePhoto(String value)
    {
        getSemanticObject().setProperty(swbpress_namePhoto, value);
    }

/**
* Gets the PPrincipal property
* @return boolean with the PPrincipal
*/
    public boolean isPPrincipal()
    {
        return getSemanticObject().getBooleanProperty(swbpress_pPrincipal);
    }

/**
* Sets the PPrincipal property
* @param value long with the PPrincipal
*/
    public void setPPrincipal(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbpress_pPrincipal, value);
    }
}
