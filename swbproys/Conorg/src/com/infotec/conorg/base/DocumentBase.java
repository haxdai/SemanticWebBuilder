package com.infotec.conorg.base;


public abstract class DocumentBase extends com.infotec.conorg.Tile implements org.semanticwb.model.Calendarable,org.semanticwb.model.Traceable,com.infotec.conorg.Topicable,org.semanticwb.model.Versionable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_editors=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#editors");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentPages=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentPages");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentCity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentCity");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentAbstract=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentAbstract");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentYear=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentYear");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentCountry=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentCountry");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentPublisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentPublisher");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentURL");
    public static final org.semanticwb.platform.SemanticProperty conorg_author=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#author");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentEdition=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentEdition");
    public static final org.semanticwb.platform.SemanticProperty conorg_documentFormat=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#documentFormat");
    public static final org.semanticwb.platform.SemanticClass conorg_Document=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Document");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Document");

    public static class ClassMgr
    {
       /**
       * Returns a list of Document for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocuments(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Document>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Document for all models
       * @return Iterator of com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocuments()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Document>(it, true);
        }

        public static com.infotec.conorg.Document createDocument(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Document.ClassMgr.createDocument(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Document
       * @param id Identifier for com.infotec.conorg.Document
       * @param model Model of the com.infotec.conorg.Document
       * @return A com.infotec.conorg.Document
       */
        public static com.infotec.conorg.Document getDocument(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Document)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Document
       * @param id Identifier for com.infotec.conorg.Document
       * @param model Model of the com.infotec.conorg.Document
       * @return A com.infotec.conorg.Document
       */
        public static com.infotec.conorg.Document createDocument(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Document)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Document
       * @param id Identifier for com.infotec.conorg.Document
       * @param model Model of the com.infotec.conorg.Document
       */
        public static void removeDocument(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Document
       * @param id Identifier for com.infotec.conorg.Document
       * @param model Model of the com.infotec.conorg.Document
       * @return true if the com.infotec.conorg.Document exists, false otherwise
       */

        public static boolean hasDocument(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDocument(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Document
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Document
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Document
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByActualVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined ActualVersion
       * @param value ActualVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByActualVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_actualVersion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Document
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Document
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @param model Model of the com.infotec.conorg.Document
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByLastVersion(org.semanticwb.model.VersionInfo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Document with a determined LastVersion
       * @param value LastVersion of the type org.semanticwb.model.VersionInfo
       * @return Iterator with all the com.infotec.conorg.Document
       */

        public static java.util.Iterator<com.infotec.conorg.Document> listDocumentByLastVersion(org.semanticwb.model.VersionInfo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Document> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_lastVersion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DocumentBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Document
   */
    public DocumentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Editors property
* @return String with the Editors
*/
    public String getEditors()
    {
        return getSemanticObject().getProperty(conorg_editors);
    }

/**
* Sets the Editors property
* @param value long with the Editors
*/
    public void setEditors(String value)
    {
        getSemanticObject().setProperty(conorg_editors, value);
    }
   /**
   * Sets the value for the property ActualVersion
   * @param value ActualVersion to set
   */

    public void setActualVersion(org.semanticwb.model.VersionInfo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_actualVersion, value.getSemanticObject());
        }else
        {
            removeActualVersion();
        }
    }
   /**
   * Remove the value for ActualVersion property
   */

    public void removeActualVersion()
    {
        getSemanticObject().removeProperty(swb_actualVersion);
    }

   /**
   * Gets the ActualVersion
   * @return a org.semanticwb.model.VersionInfo
   */
    public org.semanticwb.model.VersionInfo getActualVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_actualVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DocumentPages property
* @return String with the DocumentPages
*/
    public String getDocumentPages()
    {
        return getSemanticObject().getProperty(conorg_documentPages);
    }

/**
* Sets the DocumentPages property
* @param value long with the DocumentPages
*/
    public void setDocumentPages(String value)
    {
        getSemanticObject().setProperty(conorg_documentPages, value);
    }

/**
* Gets the DocumentCity property
* @return String with the DocumentCity
*/
    public String getDocumentCity()
    {
        return getSemanticObject().getProperty(conorg_documentCity);
    }

/**
* Sets the DocumentCity property
* @param value long with the DocumentCity
*/
    public void setDocumentCity(String value)
    {
        getSemanticObject().setProperty(conorg_documentCity, value);
    }

/**
* Gets the DocumentAbstract property
* @return String with the DocumentAbstract
*/
    public String getDocumentAbstract()
    {
        return getSemanticObject().getProperty(conorg_documentAbstract);
    }

/**
* Sets the DocumentAbstract property
* @param value long with the DocumentAbstract
*/
    public void setDocumentAbstract(String value)
    {
        getSemanticObject().setProperty(conorg_documentAbstract, value);
    }

/**
* Gets the DocumentYear property
* @return String with the DocumentYear
*/
    public String getDocumentYear()
    {
        return getSemanticObject().getProperty(conorg_documentYear);
    }

/**
* Sets the DocumentYear property
* @param value long with the DocumentYear
*/
    public void setDocumentYear(String value)
    {
        getSemanticObject().setProperty(conorg_documentYear, value);
    }

/**
* Gets the DocumentCountry property
* @return String with the DocumentCountry
*/
    public String getDocumentCountry()
    {
        return getSemanticObject().getProperty(conorg_documentCountry);
    }

/**
* Sets the DocumentCountry property
* @param value long with the DocumentCountry
*/
    public void setDocumentCountry(String value)
    {
        getSemanticObject().setProperty(conorg_documentCountry, value);
    }

/**
* Gets the DocumentPublisher property
* @return String with the DocumentPublisher
*/
    public String getDocumentPublisher()
    {
        return getSemanticObject().getProperty(conorg_documentPublisher);
    }

/**
* Sets the DocumentPublisher property
* @param value long with the DocumentPublisher
*/
    public void setDocumentPublisher(String value)
    {
        getSemanticObject().setProperty(conorg_documentPublisher, value);
    }

/**
* Gets the DocumentURL property
* @return String with the DocumentURL
*/
    public String getDocumentURL()
    {
        return getSemanticObject().getProperty(conorg_documentURL);
    }

/**
* Sets the DocumentURL property
* @param value long with the DocumentURL
*/
    public void setDocumentURL(String value)
    {
        getSemanticObject().setProperty(conorg_documentURL, value);
    }

/**
* Gets the Author property
* @return String with the Author
*/
    public String getAuthor()
    {
        return getSemanticObject().getProperty(conorg_author);
    }

/**
* Sets the Author property
* @param value long with the Author
*/
    public void setAuthor(String value)
    {
        getSemanticObject().setProperty(conorg_author, value);
    }

/**
* Gets the DocumentEdition property
* @return String with the DocumentEdition
*/
    public String getDocumentEdition()
    {
        return getSemanticObject().getProperty(conorg_documentEdition);
    }

/**
* Sets the DocumentEdition property
* @param value long with the DocumentEdition
*/
    public void setDocumentEdition(String value)
    {
        getSemanticObject().setProperty(conorg_documentEdition, value);
    }

/**
* Gets the DocumentFormat property
* @return String with the DocumentFormat
*/
    public String getDocumentFormat()
    {
        return getSemanticObject().getProperty(conorg_documentFormat);
    }

/**
* Sets the DocumentFormat property
* @param value long with the DocumentFormat
*/
    public void setDocumentFormat(String value)
    {
        getSemanticObject().setProperty(conorg_documentFormat, value);
    }
   /**
   * Sets the value for the property LastVersion
   * @param value LastVersion to set
   */

    public void setLastVersion(org.semanticwb.model.VersionInfo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_lastVersion, value.getSemanticObject());
        }else
        {
            removeLastVersion();
        }
    }
   /**
   * Remove the value for LastVersion property
   */

    public void removeLastVersion()
    {
        getSemanticObject().removeProperty(swb_lastVersion);
    }

   /**
   * Gets the LastVersion
   * @return a org.semanticwb.model.VersionInfo
   */
    public org.semanticwb.model.VersionInfo getLastVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_lastVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }
}
