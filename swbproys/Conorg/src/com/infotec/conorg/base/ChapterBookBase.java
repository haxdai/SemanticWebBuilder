package com.infotec.conorg.base;


public abstract class ChapterBookBase extends com.infotec.conorg.Document implements com.infotec.conorg.Topicable,org.semanticwb.model.Versionable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,com.infotec.conorg.Catalogable,org.semanticwb.model.Calendarable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_chaptherBookTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#chaptherBookTitle");
    public static final org.semanticwb.platform.SemanticClass conorg_ChapterBook=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#ChapterBook");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#ChapterBook");

    public static class ClassMgr
    {
       /**
       * Returns a list of ChapterBook for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBooks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.ChapterBook for all models
       * @return Iterator of com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBooks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook>(it, true);
        }

        public static com.infotec.conorg.ChapterBook createChapterBook(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.ChapterBook.ClassMgr.createChapterBook(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.ChapterBook
       * @param id Identifier for com.infotec.conorg.ChapterBook
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return A com.infotec.conorg.ChapterBook
       */
        public static com.infotec.conorg.ChapterBook getChapterBook(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.ChapterBook)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.ChapterBook
       * @param id Identifier for com.infotec.conorg.ChapterBook
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return A com.infotec.conorg.ChapterBook
       */
        public static com.infotec.conorg.ChapterBook createChapterBook(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.ChapterBook)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.ChapterBook
       * @param id Identifier for com.infotec.conorg.ChapterBook
       * @param model Model of the com.infotec.conorg.ChapterBook
       */
        public static void removeChapterBook(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.ChapterBook
       * @param id Identifier for com.infotec.conorg.ChapterBook
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return true if the com.infotec.conorg.ChapterBook exists, false otherwise
       */

        public static boolean hasChapterBook(String id, org.semanticwb.model.SWBModel model)
        {
            return (getChapterBook(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_resource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_resource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.ChapterBook
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.ChapterBook with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.ChapterBook
       */

        public static java.util.Iterator<com.infotec.conorg.ChapterBook> listChapterBookByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.ChapterBook> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ChapterBookBase.ClassMgr getChapterBookClassMgr()
    {
        return new ChapterBookBase.ClassMgr();
    }

   /**
   * Constructs a ChapterBookBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ChapterBook
   */
    public ChapterBookBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the DOI property
* @return String with the DOI
*/
    public String getDOI()
    {
        return getSemanticObject().getProperty(conorg_catalogIDsDOI);
    }

/**
* Sets the DOI property
* @param value long with the DOI
*/
    public void setDOI(String value)
    {
        getSemanticObject().setProperty(conorg_catalogIDsDOI, value);
    }

/**
* Gets the ISBN property
* @return String with the ISBN
*/
    public String getISBN()
    {
        return getSemanticObject().getProperty(conorg_catalogIDsISBN);
    }

/**
* Sets the ISBN property
* @param value long with the ISBN
*/
    public void setISBN(String value)
    {
        getSemanticObject().setProperty(conorg_catalogIDsISBN, value);
    }

/**
* Gets the ChaptherBookTitle property
* @return String with the ChaptherBookTitle
*/
    public String getChaptherBookTitle()
    {
        return getSemanticObject().getProperty(conorg_chaptherBookTitle);
    }

/**
* Sets the ChaptherBookTitle property
* @param value long with the ChaptherBookTitle
*/
    public void setChaptherBookTitle(String value)
    {
        getSemanticObject().setProperty(conorg_chaptherBookTitle, value);
    }
}
