package org.semanticwb.social.base;


   /**
   * Instancias de Noticias escuchadas por el Listener de Rss 
   */
public abstract class RssNewBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Fuente de Rss
   */
    public static final org.semanticwb.platform.SemanticClass social_RssSource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#RssSource");
   /**
   * RssSource de donde proviene el RSSNew (Ej. El universal)
   */
    public static final org.semanticwb.platform.SemanticProperty social_rssSource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssSource");
   /**
   * Propiedad con valor entero que representa el tipo de Sentimientos que expresa el Rss, estos se estan definiendo de esta manera: 0) Neutro 1) Positivo 2)Negativo, estos valores pueden ser mas y permanecer en un objeto tipo colección en lo futuro.
   */
    public static final org.semanticwb.platform.SemanticProperty social_rssNewSentimentalType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssNewSentimentalType");
    public static final org.semanticwb.platform.SemanticProperty social_mediaContent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#mediaContent");
    public static final org.semanticwb.platform.SemanticProperty social_rssLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssLink");
   /**
   * Tipo de Intensidad. 2=Alta;1=Media;0=Baja;
   */
    public static final org.semanticwb.platform.SemanticProperty social_rssNewIntensityType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssNewIntensityType");
    public static final org.semanticwb.platform.SemanticProperty social_rssPubDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssPubDate");
   /**
   * Manejo de Rss en una marca
   */
    public static final org.semanticwb.platform.SemanticClass social_Rss=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Rss");
    public static final org.semanticwb.platform.SemanticProperty social_rssBelongs=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssBelongs");
   /**
   * Instancias de Noticias escuchadas por el Listener de Rss
   */
    public static final org.semanticwb.platform.SemanticClass social_RssNew=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#RssNew");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#RssNew");

    public static class ClassMgr
    {
       /**
       * Returns a list of RssNew for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.RssNew
       */

        public static java.util.Iterator<org.semanticwb.social.RssNew> listRssNews(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.RssNew for all models
       * @return Iterator of org.semanticwb.social.RssNew
       */

        public static java.util.Iterator<org.semanticwb.social.RssNew> listRssNews()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew>(it, true);
        }

        public static org.semanticwb.social.RssNew createRssNew(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.social.RssNew.ClassMgr.createRssNew(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.social.RssNew
       * @param id Identifier for org.semanticwb.social.RssNew
       * @param model Model of the org.semanticwb.social.RssNew
       * @return A org.semanticwb.social.RssNew
       */
        public static org.semanticwb.social.RssNew getRssNew(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.RssNew)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.RssNew
       * @param id Identifier for org.semanticwb.social.RssNew
       * @param model Model of the org.semanticwb.social.RssNew
       * @return A org.semanticwb.social.RssNew
       */
        public static org.semanticwb.social.RssNew createRssNew(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.RssNew)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.RssNew
       * @param id Identifier for org.semanticwb.social.RssNew
       * @param model Model of the org.semanticwb.social.RssNew
       */
        public static void removeRssNew(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.RssNew
       * @param id Identifier for org.semanticwb.social.RssNew
       * @param model Model of the org.semanticwb.social.RssNew
       * @return true if the org.semanticwb.social.RssNew exists, false otherwise
       */

        public static boolean hasRssNew(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRssNew(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.RssNew with a determined RssSource
       * @param value RssSource of the type org.semanticwb.social.RssSource
       * @param model Model of the org.semanticwb.social.RssNew
       * @return Iterator with all the org.semanticwb.social.RssNew
       */

        public static java.util.Iterator<org.semanticwb.social.RssNew> listRssNewByRssSource(org.semanticwb.social.RssSource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_rssSource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.RssNew with a determined RssSource
       * @param value RssSource of the type org.semanticwb.social.RssSource
       * @return Iterator with all the org.semanticwb.social.RssNew
       */

        public static java.util.Iterator<org.semanticwb.social.RssNew> listRssNewByRssSource(org.semanticwb.social.RssSource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_rssSource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.RssNew with a determined RssBelongs
       * @param value RssBelongs of the type org.semanticwb.social.Rss
       * @param model Model of the org.semanticwb.social.RssNew
       * @return Iterator with all the org.semanticwb.social.RssNew
       */

        public static java.util.Iterator<org.semanticwb.social.RssNew> listRssNewByRssBelongs(org.semanticwb.social.Rss value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_rssBelongs, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.RssNew with a determined RssBelongs
       * @param value RssBelongs of the type org.semanticwb.social.Rss
       * @return Iterator with all the org.semanticwb.social.RssNew
       */

        public static java.util.Iterator<org.semanticwb.social.RssNew> listRssNewByRssBelongs(org.semanticwb.social.Rss value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.RssNew> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_rssBelongs,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static RssNewBase.ClassMgr getRssNewClassMgr()
    {
        return new RssNewBase.ClassMgr();
    }

   /**
   * Constructs a RssNewBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RssNew
   */
    public RssNewBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Sets the value for the property RssSource
   * @param value RssSource to set
   */

    public void setRssSource(org.semanticwb.social.RssSource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(social_rssSource, value.getSemanticObject());
        }else
        {
            removeRssSource();
        }
    }
   /**
   * Remove the value for RssSource property
   */

    public void removeRssSource()
    {
        getSemanticObject().removeProperty(social_rssSource);
    }

   /**
   * Gets the RssSource
   * @return a org.semanticwb.social.RssSource
   */
    public org.semanticwb.social.RssSource getRssSource()
    {
         org.semanticwb.social.RssSource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_rssSource);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.RssSource)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RssNewSentimentalType property
* @return int with the RssNewSentimentalType
*/
    public int getRssNewSentimentalType()
    {
        return getSemanticObject().getIntProperty(social_rssNewSentimentalType);
    }

/**
* Sets the RssNewSentimentalType property
* @param value long with the RssNewSentimentalType
*/
    public void setRssNewSentimentalType(int value)
    {
        getSemanticObject().setIntProperty(social_rssNewSentimentalType, value);
    }

/**
* Gets the MediaContent property
* @return String with the MediaContent
*/
    public String getMediaContent()
    {
        return getSemanticObject().getProperty(social_mediaContent);
    }

/**
* Sets the MediaContent property
* @param value long with the MediaContent
*/
    public void setMediaContent(String value)
    {
        getSemanticObject().setProperty(social_mediaContent, value);
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
* Gets the RssLink property
* @return String with the RssLink
*/
    public String getRssLink()
    {
        return getSemanticObject().getProperty(social_rssLink);
    }

/**
* Sets the RssLink property
* @param value long with the RssLink
*/
    public void setRssLink(String value)
    {
        getSemanticObject().setProperty(social_rssLink, value);
    }

/**
* Gets the RssNewIntensityType property
* @return int with the RssNewIntensityType
*/
    public int getRssNewIntensityType()
    {
        return getSemanticObject().getIntProperty(social_rssNewIntensityType);
    }

/**
* Sets the RssNewIntensityType property
* @param value long with the RssNewIntensityType
*/
    public void setRssNewIntensityType(int value)
    {
        getSemanticObject().setIntProperty(social_rssNewIntensityType, value);
    }

/**
* Gets the RssPubDate property
* @return java.util.Date with the RssPubDate
*/
    public java.util.Date getRssPubDate()
    {
        return getSemanticObject().getDateProperty(social_rssPubDate);
    }

/**
* Sets the RssPubDate property
* @param value long with the RssPubDate
*/
    public void setRssPubDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(social_rssPubDate, value);
    }
   /**
   * Sets the value for the property RssBelongs
   * @param value RssBelongs to set
   */

    public void setRssBelongs(org.semanticwb.social.Rss value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(social_rssBelongs, value.getSemanticObject());
        }else
        {
            removeRssBelongs();
        }
    }
   /**
   * Remove the value for RssBelongs property
   */

    public void removeRssBelongs()
    {
        getSemanticObject().removeProperty(social_rssBelongs);
    }

   /**
   * Gets the RssBelongs
   * @return a org.semanticwb.social.Rss
   */
    public org.semanticwb.social.Rss getRssBelongs()
    {
         org.semanticwb.social.Rss ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_rssBelongs);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.Rss)obj.createGenericInstance();
         }
         return ret;
    }
}
