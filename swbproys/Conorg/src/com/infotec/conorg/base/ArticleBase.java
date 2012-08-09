package com.infotec.conorg.base;


public abstract class ArticleBase extends com.infotec.conorg.Document implements org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,com.infotec.conorg.Topicable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Versionable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_articleISSN=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#articleISSN");
    public static final org.semanticwb.platform.SemanticProperty conorg_articleNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#articleNumber");
    public static final org.semanticwb.platform.SemanticProperty conorg_articleIssue=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#articleIssue");
    public static final org.semanticwb.platform.SemanticProperty conorg_articleVolume=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#articleVolume");
    public static final org.semanticwb.platform.SemanticProperty conorg_articleJournal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#articleJournal");
    public static final org.semanticwb.platform.SemanticClass conorg_Article=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Article");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Article");

    public static class ClassMgr
    {
       /**
       * Returns a list of Article for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Article>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Article for all models
       * @return Iterator of com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Article>(it, true);
        }

        public static com.infotec.conorg.Article createArticle(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Article.ClassMgr.createArticle(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Article
       * @param id Identifier for com.infotec.conorg.Article
       * @param model Model of the com.infotec.conorg.Article
       * @return A com.infotec.conorg.Article
       */
        public static com.infotec.conorg.Article getArticle(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Article)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Article
       * @param id Identifier for com.infotec.conorg.Article
       * @param model Model of the com.infotec.conorg.Article
       * @return A com.infotec.conorg.Article
       */
        public static com.infotec.conorg.Article createArticle(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Article)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Article
       * @param id Identifier for com.infotec.conorg.Article
       * @param model Model of the com.infotec.conorg.Article
       */
        public static void removeArticle(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Article
       * @param id Identifier for com.infotec.conorg.Article
       * @param model Model of the com.infotec.conorg.Article
       * @return true if the com.infotec.conorg.Article exists, false otherwise
       */

        public static boolean hasArticle(String id, org.semanticwb.model.SWBModel model)
        {
            return (getArticle(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Editors
       * @param value Editors of the type com.infotec.conorg.Editors
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByEditors(com.infotec.conorg.Editors value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasEditors, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Editors
       * @param value Editors of the type com.infotec.conorg.Editors
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByEditors(com.infotec.conorg.Editors value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasEditors,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Author
       * @param value Author of the type com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByAuthor(com.infotec.conorg.Author value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasAuthor, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Author
       * @param value Author of the type com.infotec.conorg.Author
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByAuthor(com.infotec.conorg.Author value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasAuthor,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Article
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Article with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Article
       */

        public static java.util.Iterator<com.infotec.conorg.Article> listArticleByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Article> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ArticleBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Article
   */
    public ArticleBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ArticleISSN property
* @return String with the ArticleISSN
*/
    public String getArticleISSN()
    {
        return getSemanticObject().getProperty(conorg_articleISSN);
    }

/**
* Sets the ArticleISSN property
* @param value long with the ArticleISSN
*/
    public void setArticleISSN(String value)
    {
        getSemanticObject().setProperty(conorg_articleISSN, value);
    }

/**
* Gets the ArticleNumber property
* @return String with the ArticleNumber
*/
    public String getArticleNumber()
    {
        return getSemanticObject().getProperty(conorg_articleNumber);
    }

/**
* Sets the ArticleNumber property
* @param value long with the ArticleNumber
*/
    public void setArticleNumber(String value)
    {
        getSemanticObject().setProperty(conorg_articleNumber, value);
    }

/**
* Gets the ArticleIssue property
* @return String with the ArticleIssue
*/
    public String getArticleIssue()
    {
        return getSemanticObject().getProperty(conorg_articleIssue);
    }

/**
* Sets the ArticleIssue property
* @param value long with the ArticleIssue
*/
    public void setArticleIssue(String value)
    {
        getSemanticObject().setProperty(conorg_articleIssue, value);
    }

/**
* Gets the ArticleVolume property
* @return String with the ArticleVolume
*/
    public String getArticleVolume()
    {
        return getSemanticObject().getProperty(conorg_articleVolume);
    }

/**
* Sets the ArticleVolume property
* @param value long with the ArticleVolume
*/
    public void setArticleVolume(String value)
    {
        getSemanticObject().setProperty(conorg_articleVolume, value);
    }

/**
* Gets the ArticleJournal property
* @return String with the ArticleJournal
*/
    public String getArticleJournal()
    {
        return getSemanticObject().getProperty(conorg_articleJournal);
    }

/**
* Sets the ArticleJournal property
* @param value long with the ArticleJournal
*/
    public void setArticleJournal(String value)
    {
        getSemanticObject().setProperty(conorg_articleJournal, value);
    }
}
