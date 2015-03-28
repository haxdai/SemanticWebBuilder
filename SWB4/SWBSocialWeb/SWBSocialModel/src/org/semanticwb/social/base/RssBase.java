package org.semanticwb.social.base;


   /**
   * Manejo de Rss en una marca 
   */
public abstract class RssBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.Filterable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Tagable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty social_dailyHour=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#dailyHour");
   /**
   * Instancias de Noticias escuchadas por el Listener de Rss
   */
    public static final org.semanticwb.platform.SemanticClass social_RssNew=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#RssNew");
    public static final org.semanticwb.platform.SemanticProperty social_hasRssNew=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#hasRssNew");
   /**
   * Fuente de Rss
   */
    public static final org.semanticwb.platform.SemanticClass social_RssSource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#RssSource");
    public static final org.semanticwb.platform.SemanticProperty social_hasRssSources=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#hasRssSources");
   /**
   * La fecha del RssNew mas actual guardado en la iteración anterior.
   */
    public static final org.semanticwb.platform.SemanticProperty social_rssLastPubDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssLastPubDate");
    public static final org.semanticwb.platform.SemanticProperty social_listenbyPeriodTime=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#listenbyPeriodTime");
   /**
   * Manejo de Rss en una marca
   */
    public static final org.semanticwb.platform.SemanticClass social_Rss=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Rss");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Rss");

    public static class ClassMgr
    {
       /**
       * Returns a list of Rss for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRsses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.Rss for all models
       * @return Iterator of org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRsses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss>(it, true);
        }

        public static org.semanticwb.social.Rss createRss(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.social.Rss.ClassMgr.createRss(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.social.Rss
       * @param id Identifier for org.semanticwb.social.Rss
       * @param model Model of the org.semanticwb.social.Rss
       * @return A org.semanticwb.social.Rss
       */
        public static org.semanticwb.social.Rss getRss(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Rss)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.Rss
       * @param id Identifier for org.semanticwb.social.Rss
       * @param model Model of the org.semanticwb.social.Rss
       * @return A org.semanticwb.social.Rss
       */
        public static org.semanticwb.social.Rss createRss(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Rss)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.Rss
       * @param id Identifier for org.semanticwb.social.Rss
       * @param model Model of the org.semanticwb.social.Rss
       */
        public static void removeRss(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.Rss
       * @param id Identifier for org.semanticwb.social.Rss
       * @param model Model of the org.semanticwb.social.Rss
       * @return true if the org.semanticwb.social.Rss exists, false otherwise
       */

        public static boolean hasRss(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRss(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Rss
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined RssNew
       * @param value RssNew of the type org.semanticwb.social.RssNew
       * @param model Model of the org.semanticwb.social.Rss
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByRssNew(org.semanticwb.social.RssNew value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasRssNew, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined RssNew
       * @param value RssNew of the type org.semanticwb.social.RssNew
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByRssNew(org.semanticwb.social.RssNew value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasRssNew,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined RssSources
       * @param value RssSources of the type org.semanticwb.social.RssSource
       * @param model Model of the org.semanticwb.social.Rss
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByRssSources(org.semanticwb.social.RssSource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasRssSources, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined RssSources
       * @param value RssSources of the type org.semanticwb.social.RssSource
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByRssSources(org.semanticwb.social.RssSource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasRssSources,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Rss
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Rss with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Rss
       */

        public static java.util.Iterator<org.semanticwb.social.Rss> listRssByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Rss> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static RssBase.ClassMgr getRssClassMgr()
    {
        return new RssBase.ClassMgr();
    }

   /**
   * Constructs a RssBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Rss
   */
    public RssBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the DailyHour property
* @return int with the DailyHour
*/
    public int getDailyHour()
    {
        return getSemanticObject().getIntProperty(social_dailyHour);
    }

/**
* Sets the DailyHour property
* @param value long with the DailyHour
*/
    public void setDailyHour(int value)
    {
        getSemanticObject().setIntProperty(social_dailyHour, value);
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
   /**
   * Gets all the org.semanticwb.social.RssNew
   * @return A GenericIterator with all the org.semanticwb.social.RssNew
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew> listRssNews()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew>(getSemanticObject().listObjectProperties(social_hasRssNew));
    }

   /**
   * Gets true if has a RssNew
   * @param value org.semanticwb.social.RssNew to verify
   * @return true if the org.semanticwb.social.RssNew exists, false otherwise
   */
    public boolean hasRssNew(org.semanticwb.social.RssNew value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(social_hasRssNew,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the RssNew
   * @return a org.semanticwb.social.RssNew
   */
    public org.semanticwb.social.RssNew getRssNew()
    {
         org.semanticwb.social.RssNew ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_hasRssNew);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.RssNew)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.social.RssSource
   * @return A GenericIterator with all the org.semanticwb.social.RssSource
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.social.RssSource> listRssSourceses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.social.RssSource>(getSemanticObject().listObjectProperties(social_hasRssSources));
    }

   /**
   * Gets true if has a RssSources
   * @param value org.semanticwb.social.RssSource to verify
   * @return true if the org.semanticwb.social.RssSource exists, false otherwise
   */
    public boolean hasRssSources(org.semanticwb.social.RssSource value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(social_hasRssSources,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RssSources
   * @param value org.semanticwb.social.RssSource to add
   */

    public void addRssSources(org.semanticwb.social.RssSource value)
    {
        getSemanticObject().addObjectProperty(social_hasRssSources, value.getSemanticObject());
    }
   /**
   * Removes all the RssSources
   */

    public void removeAllRssSources()
    {
        getSemanticObject().removeProperty(social_hasRssSources);
    }
   /**
   * Removes a RssSources
   * @param value org.semanticwb.social.RssSource to remove
   */

    public void removeRssSources(org.semanticwb.social.RssSource value)
    {
        getSemanticObject().removeObjectProperty(social_hasRssSources,value.getSemanticObject());
    }

   /**
   * Gets the RssSources
   * @return a org.semanticwb.social.RssSource
   */
    public org.semanticwb.social.RssSource getRssSources()
    {
         org.semanticwb.social.RssSource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_hasRssSources);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.RssSource)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Deleted property
* @return boolean with the Deleted
*/
    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

/**
* Sets the Deleted property
* @param value long with the Deleted
*/
    public void setDeleted(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, value);
    }

/**
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
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
* Gets the RssLastPubDate property
* @return java.util.Date with the RssLastPubDate
*/
    public java.util.Date getRssLastPubDate()
    {
        return getSemanticObject().getDateProperty(social_rssLastPubDate);
    }

/**
* Sets the RssLastPubDate property
* @param value long with the RssLastPubDate
*/
    public void setRssLastPubDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(social_rssLastPubDate, value);
    }

/**
* Gets the ListenbyPeriodTime property
* @return int with the ListenbyPeriodTime
*/
    public int getListenbyPeriodTime()
    {
        return getSemanticObject().getIntProperty(social_listenbyPeriodTime);
    }

/**
* Sets the ListenbyPeriodTime property
* @param value long with the ListenbyPeriodTime
*/
    public void setListenbyPeriodTime(int value)
    {
        getSemanticObject().setIntProperty(social_listenbyPeriodTime, value);
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
   * Gets the SocialSite
   * @return a instance of org.semanticwb.social.SocialSite
   */
    public org.semanticwb.social.SocialSite getSocialSite()
    {
        return (org.semanticwb.social.SocialSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
