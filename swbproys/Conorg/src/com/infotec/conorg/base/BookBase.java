package com.infotec.conorg.base;


public abstract class BookBase extends com.infotec.conorg.Document implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_catalogIDsDOI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#catalogIDsDOI");
    public static final org.semanticwb.platform.SemanticProperty conorg_catalogIDsISBN=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#catalogIDsISBN");
    public static final org.semanticwb.platform.SemanticClass conorg_Book=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Book");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Book");

    public static class ClassMgr
    {
       /**
       * Returns a list of Book for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBooks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Book>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Book for all models
       * @return Iterator of com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBooks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Book>(it, true);
        }

        public static com.infotec.conorg.Book createBook(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Book.ClassMgr.createBook(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Book
       * @param id Identifier for com.infotec.conorg.Book
       * @param model Model of the com.infotec.conorg.Book
       * @return A com.infotec.conorg.Book
       */
        public static com.infotec.conorg.Book getBook(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Book)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Book
       * @param id Identifier for com.infotec.conorg.Book
       * @param model Model of the com.infotec.conorg.Book
       * @return A com.infotec.conorg.Book
       */
        public static com.infotec.conorg.Book createBook(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Book)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Book
       * @param id Identifier for com.infotec.conorg.Book
       * @param model Model of the com.infotec.conorg.Book
       */
        public static void removeBook(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Book
       * @param id Identifier for com.infotec.conorg.Book
       * @param model Model of the com.infotec.conorg.Book
       * @return true if the com.infotec.conorg.Book exists, false otherwise
       */

        public static boolean hasBook(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBook(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Book
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Book
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Book
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Book
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Book with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Book
       */

        public static java.util.Iterator<com.infotec.conorg.Book> listBookByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Book> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a BookBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Book
   */
    public BookBase(org.semanticwb.platform.SemanticObject base)
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
}
