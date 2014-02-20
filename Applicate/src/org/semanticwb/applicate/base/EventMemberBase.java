package org.semanticwb.applicate.base;


public abstract class EventMemberBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty app_universityEventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#universityEventMember");
    public static final org.semanticwb.platform.SemanticProperty app_expertiseEventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#expertiseEventMember");
    public static final org.semanticwb.platform.SemanticProperty app_nameEventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#nameEventMember");
    public static final org.semanticwb.platform.SemanticProperty app_ageEventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#ageEventMember");
    public static final org.semanticwb.platform.SemanticProperty app_emailEventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#emailEventMember");
    public static final org.semanticwb.platform.SemanticClass app_EventMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventMember");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#EventMember");

    public static class ClassMgr
    {
       /**
       * Returns a list of EventMember for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.EventMember
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventMember> listEventMembers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventMember>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.EventMember for all models
       * @return Iterator of org.semanticwb.applicate.EventMember
       */

        public static java.util.Iterator<org.semanticwb.applicate.EventMember> listEventMembers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.EventMember>(it, true);
        }

        public static org.semanticwb.applicate.EventMember createEventMember(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.EventMember.ClassMgr.createEventMember(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.EventMember
       * @param id Identifier for org.semanticwb.applicate.EventMember
       * @param model Model of the org.semanticwb.applicate.EventMember
       * @return A org.semanticwb.applicate.EventMember
       */
        public static org.semanticwb.applicate.EventMember getEventMember(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.EventMember)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.EventMember
       * @param id Identifier for org.semanticwb.applicate.EventMember
       * @param model Model of the org.semanticwb.applicate.EventMember
       * @return A org.semanticwb.applicate.EventMember
       */
        public static org.semanticwb.applicate.EventMember createEventMember(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.EventMember)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.EventMember
       * @param id Identifier for org.semanticwb.applicate.EventMember
       * @param model Model of the org.semanticwb.applicate.EventMember
       */
        public static void removeEventMember(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.EventMember
       * @param id Identifier for org.semanticwb.applicate.EventMember
       * @param model Model of the org.semanticwb.applicate.EventMember
       * @return true if the org.semanticwb.applicate.EventMember exists, false otherwise
       */

        public static boolean hasEventMember(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEventMember(id, model)!=null);
        }
    }

    public static EventMemberBase.ClassMgr getEventMemberClassMgr()
    {
        return new EventMemberBase.ClassMgr();
    }

   /**
   * Constructs a EventMemberBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EventMember
   */
    public EventMemberBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the UniversityEventMember property
* @return String with the UniversityEventMember
*/
    public String getUniversityEventMember()
    {
        return getSemanticObject().getProperty(app_universityEventMember);
    }

/**
* Sets the UniversityEventMember property
* @param value long with the UniversityEventMember
*/
    public void setUniversityEventMember(String value)
    {
        getSemanticObject().setProperty(app_universityEventMember, value);
    }

/**
* Gets the ExpertiseEventMember property
* @return String with the ExpertiseEventMember
*/
    public String getExpertiseEventMember()
    {
        return getSemanticObject().getProperty(app_expertiseEventMember);
    }

/**
* Sets the ExpertiseEventMember property
* @param value long with the ExpertiseEventMember
*/
    public void setExpertiseEventMember(String value)
    {
        getSemanticObject().setProperty(app_expertiseEventMember, value);
    }

/**
* Gets the NameEventMember property
* @return String with the NameEventMember
*/
    public String getNameEventMember()
    {
        return getSemanticObject().getProperty(app_nameEventMember);
    }

/**
* Sets the NameEventMember property
* @param value long with the NameEventMember
*/
    public void setNameEventMember(String value)
    {
        getSemanticObject().setProperty(app_nameEventMember, value);
    }

/**
* Gets the AgeEventMember property
* @return String with the AgeEventMember
*/
    public String getAgeEventMember()
    {
        return getSemanticObject().getProperty(app_ageEventMember);
    }

/**
* Sets the AgeEventMember property
* @param value long with the AgeEventMember
*/
    public void setAgeEventMember(String value)
    {
        getSemanticObject().setProperty(app_ageEventMember, value);
    }

/**
* Gets the EmailEventMember property
* @return String with the EmailEventMember
*/
    public String getEmailEventMember()
    {
        return getSemanticObject().getProperty(app_emailEventMember);
    }

/**
* Sets the EmailEventMember property
* @param value long with the EmailEventMember
*/
    public void setEmailEventMember(String value)
    {
        getSemanticObject().setProperty(app_emailEventMember, value);
    }
}
