package com.infotec.lodp.swb.base;


public abstract class PublisherBase extends org.semanticwb.model.User implements org.semanticwb.model.CalendarRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.UserGroupable,org.semanticwb.model.Referensable,org.semanticwb.model.Roleable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable
{
    public static final org.semanticwb.platform.SemanticProperty lodp_pubPosition=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubPosition");
   /**
   * Unidad Administrativa a la que pertenece
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_pubUniAdmin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubUniAdmin");
    public static final org.semanticwb.platform.SemanticProperty lodp_chiefName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#chiefName");
    public static final org.semanticwb.platform.SemanticClass lodp_Dataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#Dataset");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasPubDataset=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasPubDataset");
    public static final org.semanticwb.platform.SemanticProperty lodp_chiefEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#chiefEmail");
   /**
   * Cerificado digital de la Firma Electrónica Avanzada
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_pubCertificate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubCertificate");
   /**
   * Dirección General a la que pertenece
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_pubDirGral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubDirGral");
    public static final org.semanticwb.platform.SemanticProperty lodp_pubPhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubPhone");
    public static final org.semanticwb.platform.SemanticClass lodp_Institution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#Institution");
    public static final org.semanticwb.platform.SemanticProperty lodp_pubInstitution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubInstitution");
    public static final org.semanticwb.platform.SemanticProperty lodp_pubRFC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#pubRFC");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Publisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Publisher");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Publisher");

    public static class ClassMgr
    {
       /**
       * Returns a list of Publisher for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublishers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Publisher for all models
       * @return Iterator of com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublishers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher>(it, true);
        }
       /**
       * Gets a com.infotec.lodp.swb.Publisher
       * @param id Identifier for com.infotec.lodp.swb.Publisher
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return A com.infotec.lodp.swb.Publisher
       */
        public static com.infotec.lodp.swb.Publisher getPublisher(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Publisher)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Publisher
       * @param id Identifier for com.infotec.lodp.swb.Publisher
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return A com.infotec.lodp.swb.Publisher
       */
        public static com.infotec.lodp.swb.Publisher createPublisher(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Publisher)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Publisher
       * @param id Identifier for com.infotec.lodp.swb.Publisher
       * @param model Model of the com.infotec.lodp.swb.Publisher
       */
        public static void removePublisher(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Publisher
       * @param id Identifier for com.infotec.lodp.swb.Publisher
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return true if the com.infotec.lodp.swb.Publisher exists, false otherwise
       */

        public static boolean hasPublisher(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPublisher(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined UserFavorite
       * @param value UserFavorite of the type org.semanticwb.model.UserFavorite
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByUserFavorite(org.semanticwb.model.UserFavorite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_usrFavorite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined UserFavorite
       * @param value UserFavorite of the type org.semanticwb.model.UserFavorite
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByUserFavorite(org.semanticwb.model.UserFavorite value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_usrFavorite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined AdminFilter
       * @param value AdminFilter of the type org.semanticwb.model.AdminFilter
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByAdminFilter(org.semanticwb.model.AdminFilter value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAdminFilter, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined AdminFilter
       * @param value AdminFilter of the type org.semanticwb.model.AdminFilter
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByAdminFilter(org.semanticwb.model.AdminFilter value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAdminFilter,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByUserGroup(org.semanticwb.model.UserGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByUserGroup(org.semanticwb.model.UserGroup value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByRole(org.semanticwb.model.Role value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByRole(org.semanticwb.model.Role value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the com.infotec.lodp.swb.Publisher
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Publisher with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the com.infotec.lodp.swb.Publisher
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Publisher> listPublisherByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Publisher> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PublisherBase.ClassMgr getPublisherClassMgr()
    {
        return new PublisherBase.ClassMgr();
    }

   /**
   * Constructs a PublisherBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Publisher
   */
    public PublisherBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the PubPosition property
* @return String with the PubPosition
*/
    public String getPubPosition()
    {
        return getSemanticObject().getProperty(lodp_pubPosition);
    }

/**
* Sets the PubPosition property
* @param value long with the PubPosition
*/
    public void setPubPosition(String value)
    {
        getSemanticObject().setProperty(lodp_pubPosition, value);
    }

/**
* Gets the PubUniAdmin property
* @return String with the PubUniAdmin
*/
    public String getPubUniAdmin()
    {
        return getSemanticObject().getProperty(lodp_pubUniAdmin);
    }

/**
* Sets the PubUniAdmin property
* @param value long with the PubUniAdmin
*/
    public void setPubUniAdmin(String value)
    {
        getSemanticObject().setProperty(lodp_pubUniAdmin, value);
    }

/**
* Gets the ChiefName property
* @return String with the ChiefName
*/
    public String getChiefName()
    {
        return getSemanticObject().getProperty(lodp_chiefName);
    }

/**
* Sets the ChiefName property
* @param value long with the ChiefName
*/
    public void setChiefName(String value)
    {
        getSemanticObject().setProperty(lodp_chiefName, value);
    }

/**
* Gets the ChiefEmail property
* @return String with the ChiefEmail
*/
    public String getChiefEmail()
    {
        return getSemanticObject().getProperty(lodp_chiefEmail);
    }

/**
* Sets the ChiefEmail property
* @param value long with the ChiefEmail
*/
    public void setChiefEmail(String value)
    {
        getSemanticObject().setProperty(lodp_chiefEmail, value);
    }

/**
* Gets the PubCertificate property
* @return String with the PubCertificate
*/
    public String getPubCertificate()
    {
        return getSemanticObject().getProperty(lodp_pubCertificate);
    }

/**
* Sets the PubCertificate property
* @param value long with the PubCertificate
*/
    public void setPubCertificate(String value)
    {
        getSemanticObject().setProperty(lodp_pubCertificate, value);
    }

/**
* Gets the PubDirGral property
* @return String with the PubDirGral
*/
    public String getPubDirGral()
    {
        return getSemanticObject().getProperty(lodp_pubDirGral);
    }

/**
* Sets the PubDirGral property
* @param value long with the PubDirGral
*/
    public void setPubDirGral(String value)
    {
        getSemanticObject().setProperty(lodp_pubDirGral, value);
    }

/**
* Gets the PubPhone property
* @return String with the PubPhone
*/
    public String getPubPhone()
    {
        return getSemanticObject().getProperty(lodp_pubPhone);
    }

/**
* Sets the PubPhone property
* @param value long with the PubPhone
*/
    public void setPubPhone(String value)
    {
        getSemanticObject().setProperty(lodp_pubPhone, value);
    }

    public void setPubInstitution(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(lodp_pubInstitution, value);
    }

    public void removePubInstitution()
    {
        getSemanticObject().removeProperty(lodp_pubInstitution);
    }

/**
* Gets the PubInstitution property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getPubInstitution()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(lodp_pubInstitution);
         return ret;
    }

/**
* Gets the PubRFC property
* @return String with the PubRFC
*/
    public String getPubRFC()
    {
        return getSemanticObject().getProperty(lodp_pubRFC);
    }

/**
* Sets the PubRFC property
* @param value long with the PubRFC
*/
    public void setPubRFC(String value)
    {
        getSemanticObject().setProperty(lodp_pubRFC, value);
    }
}
