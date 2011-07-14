package mx.gob.se.promexico.portal.swb.resources.sem.slideshow.base;


public abstract class SlideShowBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticProperty promexico_targetNew=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#targetNew");
    public static final org.semanticwb.platform.SemanticClass promexico_PictureSlide=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.promexico.gob.mx#PictureSlide");
    public static final org.semanticwb.platform.SemanticProperty promexico_hasPictureSlides=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#hasPictureSlides");
    public static final org.semanticwb.platform.SemanticClass promexico_SlideShow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.promexico.gob.mx#SlideShow");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.promexico.gob.mx#SlideShow");

    public SlideShowBase()
    {
    }

   /**
   * Constructs a SlideShowBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SlideShow
   */
    public SlideShowBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /*
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() 
    {
        return getSemanticObject().hashCode();
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) 
    {
        if(obj==null)return false;
        return hashCode()==obj.hashCode();
    }
   /**
   * Sets the value for the property Resource
   * @param value Resource to set
   */

    public void setResource(org.semanticwb.model.Resource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_semanticResourceInv, value.getSemanticObject());
        }else
        {
            removeResource();
        }
    }
   /**
   * Remove the value for Resource property
   */

    public void removeResource()
    {
        getSemanticObject().removeProperty(swb_semanticResourceInv);
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_semanticResourceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the TargetNew property
* @return boolean with the TargetNew
*/
    public boolean isTargetNew()
    {
        return getSemanticObject().getBooleanProperty(promexico_targetNew);
    }

/**
* Sets the TargetNew property
* @param value long with the TargetNew
*/
    public void setTargetNew(boolean value)
    {
        getSemanticObject().setBooleanProperty(promexico_targetNew, value);
    }
   /**
   * Gets all the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
   * @return A GenericIterator with all the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
   */

    public org.semanticwb.model.GenericIterator<mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide> listPictureSlideses()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide>(getSemanticObject().listObjectProperties(promexico_hasPictureSlides));
    }

   /**
   * Gets true if has a PictureSlides
   * @param value mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide to verify
   * @return true if the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide exists, false otherwise
   */
    public boolean hasPictureSlides(mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promexico_hasPictureSlides,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PictureSlides
   * @param value mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide to add
   */

    public void addPictureSlides(mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide value)
    {
        getSemanticObject().addObjectProperty(promexico_hasPictureSlides, value.getSemanticObject());
    }
   /**
   * Removes all the PictureSlides
   */

    public void removeAllPictureSlides()
    {
        getSemanticObject().removeProperty(promexico_hasPictureSlides);
    }
   /**
   * Removes a PictureSlides
   * @param value mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide to remove
   */

    public void removePictureSlides(mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide value)
    {
        getSemanticObject().removeObjectProperty(promexico_hasPictureSlides,value.getSemanticObject());
    }

   /**
   * Gets the PictureSlides
   * @return a mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
   */
    public mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide getPictureSlides()
    {
         mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promexico_hasPictureSlides);
         if(obj!=null)
         {
             ret=(mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide)obj.createGenericInstance();
         }
         return ret;
    }
}
