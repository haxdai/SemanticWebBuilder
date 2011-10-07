package org.semanticwb.promexico.base;


public abstract class PictureSlideBase extends org.semanticwb.portal.resources.sem.slideshow.PictureSlide implements org.semanticwb.model.Descriptiveable
{
   /**
   * Almacena el número de orden en que se desplegará la imagen
   */
    public static final org.semanticwb.platform.SemanticProperty promx_imgOrder=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#imgOrder");
    public static final org.semanticwb.platform.SemanticClass promx_PictureSlide=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#PictureSlide");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#PictureSlide");

    public static class ClassMgr
    {
       /**
       * Returns a list of PictureSlide for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.PictureSlide
       */

        public static java.util.Iterator<org.semanticwb.promexico.PictureSlide> listPictureSlides(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.PictureSlide>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.PictureSlide for all models
       * @return Iterator of org.semanticwb.promexico.PictureSlide
       */

        public static java.util.Iterator<org.semanticwb.promexico.PictureSlide> listPictureSlides()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.PictureSlide>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.PictureSlide
       * @param id Identifier for org.semanticwb.promexico.PictureSlide
       * @param model Model of the org.semanticwb.promexico.PictureSlide
       * @return A org.semanticwb.promexico.PictureSlide
       */
        public static org.semanticwb.promexico.PictureSlide getPictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.PictureSlide)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.PictureSlide
       * @param id Identifier for org.semanticwb.promexico.PictureSlide
       * @param model Model of the org.semanticwb.promexico.PictureSlide
       * @return A org.semanticwb.promexico.PictureSlide
       */
        public static org.semanticwb.promexico.PictureSlide createPictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.PictureSlide)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.PictureSlide
       * @param id Identifier for org.semanticwb.promexico.PictureSlide
       * @param model Model of the org.semanticwb.promexico.PictureSlide
       */
        public static void removePictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.PictureSlide
       * @param id Identifier for org.semanticwb.promexico.PictureSlide
       * @param model Model of the org.semanticwb.promexico.PictureSlide
       * @return true if the org.semanticwb.promexico.PictureSlide exists, false otherwise
       */

        public static boolean hasPictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPictureSlide(id, model)!=null);
        }
    }

   /**
   * Constructs a PictureSlideBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PictureSlide
   */
    public PictureSlideBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ImgOrder property
* @return int with the ImgOrder
*/
    public int getImgOrder()
    {
        return getSemanticObject().getIntProperty(promx_imgOrder);
    }

/**
* Sets the ImgOrder property
* @param value long with the ImgOrder
*/
    public void setImgOrder(int value)
    {
        getSemanticObject().setIntProperty(promx_imgOrder, value);
    }
}
