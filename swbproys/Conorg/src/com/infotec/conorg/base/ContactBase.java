package com.infotec.conorg.base;


public abstract class ContactBase extends com.infotec.conorg.Tile implements org.semanticwb.model.Calendarable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticProperty conorg_contactOfficePhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactOfficePhone");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactExperienceArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactExperienceArea");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactHomePhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactHomePhone");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactAddress=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactAddress");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactDegree=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactDegree");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactOrganization=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactOrganization");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactOrganizationPosition=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactOrganizationPosition");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactMobilePhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactMobilePhone");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactLastName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactLastName");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactEmail");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactFirstName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactFirstName");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactOrganizationArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactOrganizationArea");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactURL");
    public static final org.semanticwb.platform.SemanticProperty conorg_contactSocialNetworkId=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#contactSocialNetworkId");
    public static final org.semanticwb.platform.SemanticClass conorg_Contact=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Contact");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Contact");

    public static class ClassMgr
    {
       /**
       * Returns a list of Contact for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContacts(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Contact for all models
       * @return Iterator of com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContacts()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact>(it, true);
        }

        public static com.infotec.conorg.Contact createContact(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.Contact.ClassMgr.createContact(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.Contact
       * @param id Identifier for com.infotec.conorg.Contact
       * @param model Model of the com.infotec.conorg.Contact
       * @return A com.infotec.conorg.Contact
       */
        public static com.infotec.conorg.Contact getContact(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Contact)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Contact
       * @param id Identifier for com.infotec.conorg.Contact
       * @param model Model of the com.infotec.conorg.Contact
       * @return A com.infotec.conorg.Contact
       */
        public static com.infotec.conorg.Contact createContact(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Contact)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Contact
       * @param id Identifier for com.infotec.conorg.Contact
       * @param model Model of the com.infotec.conorg.Contact
       */
        public static void removeContact(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Contact
       * @param id Identifier for com.infotec.conorg.Contact
       * @param model Model of the com.infotec.conorg.Contact
       * @return true if the com.infotec.conorg.Contact exists, false otherwise
       */

        public static boolean hasContact(String id, org.semanticwb.model.SWBModel model)
        {
            return (getContact(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Contact
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.Contact
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.Contact
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.Contact
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.Contact with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.Contact
       */

        public static java.util.Iterator<com.infotec.conorg.Contact> listContactByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.Contact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ContactBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Contact
   */
    public ContactBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ContactOfficePhone property
* @return String with the ContactOfficePhone
*/
    public String getContactOfficePhone()
    {
        return getSemanticObject().getProperty(conorg_contactOfficePhone);
    }

/**
* Sets the ContactOfficePhone property
* @param value long with the ContactOfficePhone
*/
    public void setContactOfficePhone(String value)
    {
        getSemanticObject().setProperty(conorg_contactOfficePhone, value);
    }

/**
* Gets the ContactExperienceArea property
* @return String with the ContactExperienceArea
*/
    public String getContactExperienceArea()
    {
        return getSemanticObject().getProperty(conorg_contactExperienceArea);
    }

/**
* Sets the ContactExperienceArea property
* @param value long with the ContactExperienceArea
*/
    public void setContactExperienceArea(String value)
    {
        getSemanticObject().setProperty(conorg_contactExperienceArea, value);
    }

/**
* Gets the ContactHomePhone property
* @return String with the ContactHomePhone
*/
    public String getContactHomePhone()
    {
        return getSemanticObject().getProperty(conorg_contactHomePhone);
    }

/**
* Sets the ContactHomePhone property
* @param value long with the ContactHomePhone
*/
    public void setContactHomePhone(String value)
    {
        getSemanticObject().setProperty(conorg_contactHomePhone, value);
    }

/**
* Gets the ContactAddress property
* @return String with the ContactAddress
*/
    public String getContactAddress()
    {
        return getSemanticObject().getProperty(conorg_contactAddress);
    }

/**
* Sets the ContactAddress property
* @param value long with the ContactAddress
*/
    public void setContactAddress(String value)
    {
        getSemanticObject().setProperty(conorg_contactAddress, value);
    }

/**
* Gets the ContactDegree property
* @return String with the ContactDegree
*/
    public String getContactDegree()
    {
        return getSemanticObject().getProperty(conorg_contactDegree);
    }

/**
* Sets the ContactDegree property
* @param value long with the ContactDegree
*/
    public void setContactDegree(String value)
    {
        getSemanticObject().setProperty(conorg_contactDegree, value);
    }

/**
* Gets the ContactOrganization property
* @return String with the ContactOrganization
*/
    public String getContactOrganization()
    {
        return getSemanticObject().getProperty(conorg_contactOrganization);
    }

/**
* Sets the ContactOrganization property
* @param value long with the ContactOrganization
*/
    public void setContactOrganization(String value)
    {
        getSemanticObject().setProperty(conorg_contactOrganization, value);
    }

/**
* Gets the ContactOrganizationPosition property
* @return String with the ContactOrganizationPosition
*/
    public String getContactOrganizationPosition()
    {
        return getSemanticObject().getProperty(conorg_contactOrganizationPosition);
    }

/**
* Sets the ContactOrganizationPosition property
* @param value long with the ContactOrganizationPosition
*/
    public void setContactOrganizationPosition(String value)
    {
        getSemanticObject().setProperty(conorg_contactOrganizationPosition, value);
    }

/**
* Gets the ContactMobilePhone property
* @return String with the ContactMobilePhone
*/
    public String getContactMobilePhone()
    {
        return getSemanticObject().getProperty(conorg_contactMobilePhone);
    }

/**
* Sets the ContactMobilePhone property
* @param value long with the ContactMobilePhone
*/
    public void setContactMobilePhone(String value)
    {
        getSemanticObject().setProperty(conorg_contactMobilePhone, value);
    }

/**
* Gets the ContactLastName property
* @return String with the ContactLastName
*/
    public String getContactLastName()
    {
        return getSemanticObject().getProperty(conorg_contactLastName);
    }

/**
* Sets the ContactLastName property
* @param value long with the ContactLastName
*/
    public void setContactLastName(String value)
    {
        getSemanticObject().setProperty(conorg_contactLastName, value);
    }

/**
* Gets the ContactEmail property
* @return String with the ContactEmail
*/
    public String getContactEmail()
    {
        return getSemanticObject().getProperty(conorg_contactEmail);
    }

/**
* Sets the ContactEmail property
* @param value long with the ContactEmail
*/
    public void setContactEmail(String value)
    {
        getSemanticObject().setProperty(conorg_contactEmail, value);
    }

/**
* Gets the ContactFirstName property
* @return String with the ContactFirstName
*/
    public String getContactFirstName()
    {
        return getSemanticObject().getProperty(conorg_contactFirstName);
    }

/**
* Sets the ContactFirstName property
* @param value long with the ContactFirstName
*/
    public void setContactFirstName(String value)
    {
        getSemanticObject().setProperty(conorg_contactFirstName, value);
    }

/**
* Gets the ContactOrganizationArea property
* @return String with the ContactOrganizationArea
*/
    public String getContactOrganizationArea()
    {
        return getSemanticObject().getProperty(conorg_contactOrganizationArea);
    }

/**
* Sets the ContactOrganizationArea property
* @param value long with the ContactOrganizationArea
*/
    public void setContactOrganizationArea(String value)
    {
        getSemanticObject().setProperty(conorg_contactOrganizationArea, value);
    }

/**
* Gets the ContactURL property
* @return String with the ContactURL
*/
    public String getContactURL()
    {
        return getSemanticObject().getProperty(conorg_contactURL);
    }

/**
* Sets the ContactURL property
* @param value long with the ContactURL
*/
    public void setContactURL(String value)
    {
        getSemanticObject().setProperty(conorg_contactURL, value);
    }

/**
* Gets the ContactSocialNetworkId property
* @return String with the ContactSocialNetworkId
*/
    public String getContactSocialNetworkId()
    {
        return getSemanticObject().getProperty(conorg_contactSocialNetworkId);
    }

/**
* Sets the ContactSocialNetworkId property
* @param value long with the ContactSocialNetworkId
*/
    public void setContactSocialNetworkId(String value)
    {
        getSemanticObject().setProperty(conorg_contactSocialNetworkId, value);
    }
}
