package org.semanticwb.social.base;


   /**
   * Instancias de Noticias escuchadas por el Listener de Rss 
   */
public abstract class RssNewBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty social_mediaContent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#mediaContent");
    public static final org.semanticwb.platform.SemanticProperty social_rssLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssLink");
    public static final org.semanticwb.platform.SemanticProperty social_rssPubDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#rssPubDate");
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
* Gets the RssPubDate property
* @return String with the RssPubDate
*/
    public String getRssPubDate()
    {
        return getSemanticObject().getProperty(social_rssPubDate);
    }

/**
* Sets the RssPubDate property
* @param value long with the RssPubDate
*/
    public void setRssPubDate(String value)
    {
        getSemanticObject().setProperty(social_rssPubDate, value);
    }
}
