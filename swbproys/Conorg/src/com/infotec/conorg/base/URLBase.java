package com.infotec.conorg.base;


public abstract class URLBase extends com.infotec.conorg.Tile implements org.semanticwb.model.Calendarable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_url=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#url");
    public static final org.semanticwb.platform.SemanticClass conorg_URL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#URL");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#URL");

    public static class ClassMgr
    {
       /**
       * Returns a list of URL for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.URL>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.URL for all models
       * @return Iterator of com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.URL>(it, true);
        }

        public static com.infotec.conorg.URL createURL(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.URL.ClassMgr.createURL(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.URL
       * @param id Identifier for com.infotec.conorg.URL
       * @param model Model of the com.infotec.conorg.URL
       * @return A com.infotec.conorg.URL
       */
        public static com.infotec.conorg.URL getURL(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.URL)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.URL
       * @param id Identifier for com.infotec.conorg.URL
       * @param model Model of the com.infotec.conorg.URL
       * @return A com.infotec.conorg.URL
       */
        public static com.infotec.conorg.URL createURL(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.URL)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.URL
       * @param id Identifier for com.infotec.conorg.URL
       * @param model Model of the com.infotec.conorg.URL
       */
        public static void removeURL(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.URL
       * @param id Identifier for com.infotec.conorg.URL
       * @param model Model of the com.infotec.conorg.URL
       * @return true if the com.infotec.conorg.URL exists, false otherwise
       */

        public static boolean hasURL(String id, org.semanticwb.model.SWBModel model)
        {
            return (getURL(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.URL
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.URL
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.URL
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.URL
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.URL with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.URL
       */

        public static java.util.Iterator<com.infotec.conorg.URL> listURLByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.URL> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a URLBase with a SemanticObject
   * @param base The SemanticObject with the properties for the URL
   */
    public URLBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Url property
* @return String with the Url
*/
    public String getUrl()
    {
        return getSemanticObject().getProperty(conorg_url);
    }

/**
* Sets the Url property
* @param value long with the Url
*/
    public void setUrl(String value)
    {
        getSemanticObject().setProperty(conorg_url, value);
    }
}
