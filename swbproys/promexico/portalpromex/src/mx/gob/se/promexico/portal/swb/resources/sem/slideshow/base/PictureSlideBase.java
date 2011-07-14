package mx.gob.se.promexico.portal.swb.resources.sem.slideshow.base;


public abstract class PictureSlideBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * URL Externa
   */
    public static final org.semanticwb.platform.SemanticProperty promexico_externalURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#externalURL");
   /**
   * Imagen miniatura
   */
    public static final org.semanticwb.platform.SemanticProperty promexico_thmbn=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#thmbn");
   /**
   * Cartel
   */
    public static final org.semanticwb.platform.SemanticProperty promexico_poster=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#poster");
   /**
   * URL Interna
   */
    public static final org.semanticwb.platform.SemanticProperty promexico_internaURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#internaURL");
   /**
   * Alternative descriptions. Accessibility Guidelines
   */
    public static final org.semanticwb.platform.SemanticProperty promexico_alt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.promexico.gob.mx#alt");
    public static final org.semanticwb.platform.SemanticClass promexico_PictureSlide=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.promexico.gob.mx#PictureSlide");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.promexico.gob.mx#PictureSlide");

    public static class ClassMgr
    {
       /**
       * Returns a list of PictureSlide for a model
       * @param model Model to find
       * @return Iterator of mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       */

        public static java.util.Iterator<mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide> listPictureSlides(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide>(it, true);
        }
       /**
       * Returns a list of mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide for all models
       * @return Iterator of mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       */

        public static java.util.Iterator<mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide> listPictureSlides()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide>(it, true);
        }

        public static mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide createPictureSlide(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide.ClassMgr.createPictureSlide(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param id Identifier for mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param model Model of the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @return A mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       */
        public static mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide getPictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param id Identifier for mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param model Model of the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @return A mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       */
        public static mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide createPictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param id Identifier for mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param model Model of the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       */
        public static void removePictureSlide(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param id Identifier for mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @param model Model of the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide
       * @return true if the mx.gob.se.promexico.portal.swb.resources.sem.slideshow.PictureSlide exists, false otherwise
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
* Gets the ExternalURL property
* @return String with the ExternalURL
*/
    public String getExternalURL()
    {
        return getSemanticObject().getProperty(promexico_externalURL);
    }

/**
* Sets the ExternalURL property
* @param value long with the ExternalURL
*/
    public void setExternalURL(String value)
    {
        getSemanticObject().setProperty(promexico_externalURL, value);
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

/**
* Gets the Thmbn property
* @return String with the Thmbn
*/
    public String getThmbn()
    {
        return getSemanticObject().getProperty(promexico_thmbn);
    }

/**
* Sets the Thmbn property
* @param value long with the Thmbn
*/
    public void setThmbn(String value)
    {
        getSemanticObject().setProperty(promexico_thmbn, value);
    }

/**
* Gets the Poster property
* @return String with the Poster
*/
    public String getPoster()
    {
        return getSemanticObject().getProperty(promexico_poster);
    }

/**
* Sets the Poster property
* @param value long with the Poster
*/
    public void setPoster(String value)
    {
        getSemanticObject().setProperty(promexico_poster, value);
    }

/**
* Gets the InternaURL property
* @return String with the InternaURL
*/
    public String getInternaURL()
    {
        return getSemanticObject().getProperty(promexico_internaURL);
    }

/**
* Sets the InternaURL property
* @param value long with the InternaURL
*/
    public void setInternaURL(String value)
    {
        getSemanticObject().setProperty(promexico_internaURL, value);
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
* Gets the Alt property
* @return String with the Alt
*/
    public String getAlt()
    {
        return getSemanticObject().getProperty(promexico_alt);
    }

/**
* Sets the Alt property
* @param value long with the Alt
*/
    public void setAlt(String value)
    {
        getSemanticObject().setProperty(promexico_alt, value);
    }

    public String getAlt(String lang)
    {
        return getSemanticObject().getProperty(promexico_alt, null, lang);
    }

    public String getDisplayAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(promexico_alt, lang);
    }

    public void setAlt(String alt, String lang)
    {
        getSemanticObject().setProperty(promexico_alt, alt, lang);
    }
}
