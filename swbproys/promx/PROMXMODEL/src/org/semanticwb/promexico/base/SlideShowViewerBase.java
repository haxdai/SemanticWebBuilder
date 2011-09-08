package org.semanticwb.promexico.base;


public abstract class SlideShowViewerBase extends org.semanticwb.portal.resources.sem.slideshow.Viewer 
{
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass promx_SlideButton=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#SlideButton");
    public static final org.semanticwb.platform.SemanticProperty promx_hasButtons=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasButtons");
    public static final org.semanticwb.platform.SemanticProperty slideshow_targetNew=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/slideshow#targetNew");
    public static final org.semanticwb.platform.SemanticClass slideshow_PictureSlide=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/slideshow#PictureSlide");
    public static final org.semanticwb.platform.SemanticProperty slideshow_hasPictureSlides=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/slideshow#hasPictureSlides");
    public static final org.semanticwb.platform.SemanticClass promx_SlideShowViewer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#SlideShowViewer");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#SlideShowViewer");

    public SlideShowViewerBase()
    {
    }

   /**
   * Constructs a SlideShowViewerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SlideShowViewer
   */
    public SlideShowViewerBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.promexico.SlideButton
   * @return A GenericIterator with all the org.semanticwb.promexico.SlideButton
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.SlideButton> listButtonses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.SlideButton>(getSemanticObject().listObjectProperties(promx_hasButtons));
    }

   /**
   * Gets true if has a Buttons
   * @param value org.semanticwb.promexico.SlideButton to verify
   * @return true if the org.semanticwb.promexico.SlideButton exists, false otherwise
   */
    public boolean hasButtons(org.semanticwb.promexico.SlideButton value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasButtons,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Buttons
   * @param value org.semanticwb.promexico.SlideButton to add
   */

    public void addButtons(org.semanticwb.promexico.SlideButton value)
    {
        getSemanticObject().addObjectProperty(promx_hasButtons, value.getSemanticObject());
    }
   /**
   * Removes all the Buttons
   */

    public void removeAllButtons()
    {
        getSemanticObject().removeProperty(promx_hasButtons);
    }
   /**
   * Removes a Buttons
   * @param value org.semanticwb.promexico.SlideButton to remove
   */

    public void removeButtons(org.semanticwb.promexico.SlideButton value)
    {
        getSemanticObject().removeObjectProperty(promx_hasButtons,value.getSemanticObject());
    }

   /**
   * Gets the Buttons
   * @return a org.semanticwb.promexico.SlideButton
   */
    public org.semanticwb.promexico.SlideButton getButtons()
    {
         org.semanticwb.promexico.SlideButton ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasButtons);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.SlideButton)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the TargetNew property
* @return boolean with the TargetNew
*/
    public boolean isTargetNew()
    {
        return getSemanticObject().getBooleanProperty(slideshow_targetNew);
    }

/**
* Sets the TargetNew property
* @param value long with the TargetNew
*/
    public void setTargetNew(boolean value)
    {
        getSemanticObject().setBooleanProperty(slideshow_targetNew, value);
    }
   /**
   * Gets all the org.semanticwb.portal.resources.sem.slideshow.PictureSlide
   * @return A GenericIterator with all the org.semanticwb.portal.resources.sem.slideshow.PictureSlide
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.slideshow.PictureSlide> listPictureSlideses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.slideshow.PictureSlide>(getSemanticObject().listObjectProperties(slideshow_hasPictureSlides));
    }

   /**
   * Gets true if has a PictureSlides
   * @param value org.semanticwb.portal.resources.sem.slideshow.PictureSlide to verify
   * @return true if the org.semanticwb.portal.resources.sem.slideshow.PictureSlide exists, false otherwise
   */
    public boolean hasPictureSlides(org.semanticwb.portal.resources.sem.slideshow.PictureSlide value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(slideshow_hasPictureSlides,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PictureSlides
   * @param value org.semanticwb.portal.resources.sem.slideshow.PictureSlide to add
   */

    public void addPictureSlides(org.semanticwb.portal.resources.sem.slideshow.PictureSlide value)
    {
        getSemanticObject().addObjectProperty(slideshow_hasPictureSlides, value.getSemanticObject());
    }
   /**
   * Removes all the PictureSlides
   */

    public void removeAllPictureSlides()
    {
        getSemanticObject().removeProperty(slideshow_hasPictureSlides);
    }
   /**
   * Removes a PictureSlides
   * @param value org.semanticwb.portal.resources.sem.slideshow.PictureSlide to remove
   */

    public void removePictureSlides(org.semanticwb.portal.resources.sem.slideshow.PictureSlide value)
    {
        getSemanticObject().removeObjectProperty(slideshow_hasPictureSlides,value.getSemanticObject());
    }

   /**
   * Gets the PictureSlides
   * @return a org.semanticwb.portal.resources.sem.slideshow.PictureSlide
   */
    public org.semanticwb.portal.resources.sem.slideshow.PictureSlide getPictureSlides()
    {
         org.semanticwb.portal.resources.sem.slideshow.PictureSlide ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(slideshow_hasPictureSlides);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.slideshow.PictureSlide)obj.createGenericInstance();
         }
         return ret;
    }
}
