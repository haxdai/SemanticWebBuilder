package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar el código de videos hospedados en youtube 
   */
public abstract class VideoYouTubeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Código del video hospedado en los servidores de youtube
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_youtubeVideoCode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#youtubeVideoCode");
   /**
   * Clase que se encarga de administrar el código de videos hospedados en youtube
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_VideoYouTube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VideoYouTube");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VideoYouTube");

    public static class ClassMgr
    {
       /**
       * Returns a list of VideoYouTube for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.VideoYouTube
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VideoYouTube> listVideoYouTubes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VideoYouTube>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.VideoYouTube for all models
       * @return Iterator of org.semanticwb.pymtur.VideoYouTube
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VideoYouTube> listVideoYouTubes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VideoYouTube>(it, true);
        }

        public static org.semanticwb.pymtur.VideoYouTube createVideoYouTube(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.VideoYouTube.ClassMgr.createVideoYouTube(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.VideoYouTube
       * @param id Identifier for org.semanticwb.pymtur.VideoYouTube
       * @param model Model of the org.semanticwb.pymtur.VideoYouTube
       * @return A org.semanticwb.pymtur.VideoYouTube
       */
        public static org.semanticwb.pymtur.VideoYouTube getVideoYouTube(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.VideoYouTube)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.VideoYouTube
       * @param id Identifier for org.semanticwb.pymtur.VideoYouTube
       * @param model Model of the org.semanticwb.pymtur.VideoYouTube
       * @return A org.semanticwb.pymtur.VideoYouTube
       */
        public static org.semanticwb.pymtur.VideoYouTube createVideoYouTube(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.VideoYouTube)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.VideoYouTube
       * @param id Identifier for org.semanticwb.pymtur.VideoYouTube
       * @param model Model of the org.semanticwb.pymtur.VideoYouTube
       */
        public static void removeVideoYouTube(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.VideoYouTube
       * @param id Identifier for org.semanticwb.pymtur.VideoYouTube
       * @param model Model of the org.semanticwb.pymtur.VideoYouTube
       * @return true if the org.semanticwb.pymtur.VideoYouTube exists, false otherwise
       */

        public static boolean hasVideoYouTube(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVideoYouTube(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.VideoYouTube with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.VideoYouTube
       * @return Iterator with all the org.semanticwb.pymtur.VideoYouTube
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VideoYouTube> listVideoYouTubeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VideoYouTube> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VideoYouTube with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.VideoYouTube
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VideoYouTube> listVideoYouTubeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VideoYouTube> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VideoYouTube with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.VideoYouTube
       * @return Iterator with all the org.semanticwb.pymtur.VideoYouTube
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VideoYouTube> listVideoYouTubeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VideoYouTube> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VideoYouTube with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.VideoYouTube
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VideoYouTube> listVideoYouTubeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VideoYouTube> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VideoYouTubeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the VideoYouTube
   */
    public VideoYouTubeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the YoutubeVideoCode property
* @return String with the YoutubeVideoCode
*/
    public String getYoutubeVideoCode()
    {
        return getSemanticObject().getProperty(pymtur_youtubeVideoCode);
    }

/**
* Sets the YoutubeVideoCode property
* @param value long with the YoutubeVideoCode
*/
    public void setYoutubeVideoCode(String value)
    {
        getSemanticObject().setProperty(pymtur_youtubeVideoCode, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
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
