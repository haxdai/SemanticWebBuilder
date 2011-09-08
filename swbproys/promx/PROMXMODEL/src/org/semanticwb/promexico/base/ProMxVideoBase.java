package org.semanticwb.promexico.base;


public abstract class ProMxVideoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,org.semanticwb.model.Searchable,org.semanticwb.model.Ruleable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
    public static final org.semanticwb.platform.SemanticProperty promx_hasVideoSector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasVideoSector");
   /**
   * Servicios
   */
    public static final org.semanticwb.platform.SemanticClass promx_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Service");
    public static final org.semanticwb.platform.SemanticProperty promx_hasVideoService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasVideoService");
    public static final org.semanticwb.platform.SemanticProperty promx_isMainVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#isMainVideo");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideoType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideoType");
    public static final org.semanticwb.platform.SemanticProperty promx_videoType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#videoType");
    public static final org.semanticwb.platform.SemanticProperty promx_pmVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#pmVideo");
    public static final org.semanticwb.platform.SemanticProperty promx_pmVideoEN=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#pmVideoEN");
    public static final org.semanticwb.platform.SemanticProperty promx_pmVideoImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#pmVideoImage");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideo");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProMxVideo for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.ProMxVideo for all models
       * @return Iterator of org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo>(it, true);
        }

        public static org.semanticwb.promexico.ProMxVideo createProMxVideo(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.ProMxVideo.ClassMgr.createProMxVideo(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.ProMxVideo
       * @param id Identifier for org.semanticwb.promexico.ProMxVideo
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return A org.semanticwb.promexico.ProMxVideo
       */
        public static org.semanticwb.promexico.ProMxVideo getProMxVideo(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProMxVideo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.ProMxVideo
       * @param id Identifier for org.semanticwb.promexico.ProMxVideo
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return A org.semanticwb.promexico.ProMxVideo
       */
        public static org.semanticwb.promexico.ProMxVideo createProMxVideo(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProMxVideo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.ProMxVideo
       * @param id Identifier for org.semanticwb.promexico.ProMxVideo
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       */
        public static void removeProMxVideo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.ProMxVideo
       * @param id Identifier for org.semanticwb.promexico.ProMxVideo
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return true if the org.semanticwb.promexico.ProMxVideo exists, false otherwise
       */

        public static boolean hasProMxVideo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProMxVideo(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined VideoSector
       * @param value VideoSector of the type org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByVideoSector(org.semanticwb.promexico.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasVideoSector, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined VideoSector
       * @param value VideoSector of the type org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByVideoSector(org.semanticwb.promexico.Sector value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasVideoSector,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined VideoService
       * @param value VideoService of the type org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByVideoService(org.semanticwb.promexico.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasVideoService, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined VideoService
       * @param value VideoService of the type org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByVideoService(org.semanticwb.promexico.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasVideoService,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByRule(org.semanticwb.model.Rule value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByRule(org.semanticwb.model.Rule value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined VideoType
       * @param value VideoType of the type org.semanticwb.promexico.ProMxVideoType
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByVideoType(org.semanticwb.promexico.ProMxVideoType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_videoType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined VideoType
       * @param value VideoType of the type org.semanticwb.promexico.ProMxVideoType
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByVideoType(org.semanticwb.promexico.ProMxVideoType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_videoType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideo with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideo
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideo> listProMxVideoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProMxVideoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProMxVideo
   */
    public ProMxVideoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.promexico.Sector
   * @return A GenericIterator with all the org.semanticwb.promexico.Sector
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> listVideoSectors()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector>(getSemanticObject().listObjectProperties(promx_hasVideoSector));
    }

   /**
   * Gets true if has a VideoSector
   * @param value org.semanticwb.promexico.Sector to verify
   * @return true if the org.semanticwb.promexico.Sector exists, false otherwise
   */
    public boolean hasVideoSector(org.semanticwb.promexico.Sector value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasVideoSector,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a VideoSector
   * @param value org.semanticwb.promexico.Sector to add
   */

    public void addVideoSector(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().addObjectProperty(promx_hasVideoSector, value.getSemanticObject());
    }
   /**
   * Removes all the VideoSector
   */

    public void removeAllVideoSector()
    {
        getSemanticObject().removeProperty(promx_hasVideoSector);
    }
   /**
   * Removes a VideoSector
   * @param value org.semanticwb.promexico.Sector to remove
   */

    public void removeVideoSector(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().removeObjectProperty(promx_hasVideoSector,value.getSemanticObject());
    }

   /**
   * Gets the VideoSector
   * @return a org.semanticwb.promexico.Sector
   */
    public org.semanticwb.promexico.Sector getVideoSector()
    {
         org.semanticwb.promexico.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasVideoSector);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Sector)obj.createGenericInstance();
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
   * Gets all the org.semanticwb.promexico.Service
   * @return A GenericIterator with all the org.semanticwb.promexico.Service
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> listVideoServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service>(getSemanticObject().listObjectProperties(promx_hasVideoService));
    }

   /**
   * Gets true if has a VideoService
   * @param value org.semanticwb.promexico.Service to verify
   * @return true if the org.semanticwb.promexico.Service exists, false otherwise
   */
    public boolean hasVideoService(org.semanticwb.promexico.Service value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasVideoService,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a VideoService
   * @param value org.semanticwb.promexico.Service to add
   */

    public void addVideoService(org.semanticwb.promexico.Service value)
    {
        getSemanticObject().addObjectProperty(promx_hasVideoService, value.getSemanticObject());
    }
   /**
   * Removes all the VideoService
   */

    public void removeAllVideoService()
    {
        getSemanticObject().removeProperty(promx_hasVideoService);
    }
   /**
   * Removes a VideoService
   * @param value org.semanticwb.promexico.Service to remove
   */

    public void removeVideoService(org.semanticwb.promexico.Service value)
    {
        getSemanticObject().removeObjectProperty(promx_hasVideoService,value.getSemanticObject());
    }

   /**
   * Gets the VideoService
   * @return a org.semanticwb.promexico.Service
   */
    public org.semanticwb.promexico.Service getVideoService()
    {
         org.semanticwb.promexico.Service ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasVideoService);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Service)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the IsMainVideo property
* @return boolean with the IsMainVideo
*/
    public boolean isIsMainVideo()
    {
        return getSemanticObject().getBooleanProperty(promx_isMainVideo);
    }

/**
* Sets the IsMainVideo property
* @param value long with the IsMainVideo
*/
    public void setIsMainVideo(boolean value)
    {
        getSemanticObject().setBooleanProperty(promx_isMainVideo, value);
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
   * Gets all the org.semanticwb.model.Rule
   * @return A GenericIterator with all the org.semanticwb.model.Rule
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule> listRules()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule>(getSemanticObject().listObjectProperties(swb_hasRule));
    }

   /**
   * Gets true if has a Rule
   * @param value org.semanticwb.model.Rule to verify
   * @return true if the org.semanticwb.model.Rule exists, false otherwise
   */
    public boolean hasRule(org.semanticwb.model.Rule value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasRule,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Rule
   * @param value org.semanticwb.model.Rule to add
   */

    public void addRule(org.semanticwb.model.Rule value)
    {
        getSemanticObject().addObjectProperty(swb_hasRule, value.getSemanticObject());
    }
   /**
   * Removes all the Rule
   */

    public void removeAllRule()
    {
        getSemanticObject().removeProperty(swb_hasRule);
    }
   /**
   * Removes a Rule
   * @param value org.semanticwb.model.Rule to remove
   */

    public void removeRule(org.semanticwb.model.Rule value)
    {
        getSemanticObject().removeObjectProperty(swb_hasRule,value.getSemanticObject());
    }

   /**
   * Gets the Rule
   * @return a org.semanticwb.model.Rule
   */
    public org.semanticwb.model.Rule getRule()
    {
         org.semanticwb.model.Rule ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRule);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Rule)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property VideoType
   * @param value VideoType to set
   */

    public void setVideoType(org.semanticwb.promexico.ProMxVideoType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(promx_videoType, value.getSemanticObject());
        }else
        {
            removeVideoType();
        }
    }
   /**
   * Remove the value for VideoType property
   */

    public void removeVideoType()
    {
        getSemanticObject().removeProperty(promx_videoType);
    }

   /**
   * Gets the VideoType
   * @return a org.semanticwb.promexico.ProMxVideoType
   */
    public org.semanticwb.promexico.ProMxVideoType getVideoType()
    {
         org.semanticwb.promexico.ProMxVideoType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_videoType);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.ProMxVideoType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PmVideo property
* @return String with the PmVideo
*/
    public String getPmVideo()
    {
        return getSemanticObject().getProperty(promx_pmVideo);
    }

/**
* Sets the PmVideo property
* @param value long with the PmVideo
*/
    public void setPmVideo(String value)
    {
        getSemanticObject().setProperty(promx_pmVideo, value);
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
* Gets the PmVideoEN property
* @return String with the PmVideoEN
*/
    public String getPmVideoEN()
    {
        return getSemanticObject().getProperty(promx_pmVideoEN);
    }

/**
* Sets the PmVideoEN property
* @param value long with the PmVideoEN
*/
    public void setPmVideoEN(String value)
    {
        getSemanticObject().setProperty(promx_pmVideoEN, value);
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }

/**
* Gets the PmVideoImage property
* @return String with the PmVideoImage
*/
    public String getPmVideoImage()
    {
        return getSemanticObject().getProperty(promx_pmVideoImage);
    }

/**
* Sets the PmVideoImage property
* @param value long with the PmVideoImage
*/
    public void setPmVideoImage(String value)
    {
        getSemanticObject().setProperty(promx_pmVideoImage, value);
    }

   /**
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
