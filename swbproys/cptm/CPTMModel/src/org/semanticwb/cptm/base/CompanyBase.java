package org.semanticwb.cptm.base;


   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico. 
   */
public abstract class CompanyBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.model.Rankable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Tagable,org.semanticwb.model.Searchable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Interactiveable
{
   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Company=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Company");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Company");

    public static class ClassMgr
    {
       /**
       * Returns a list of Company for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanies(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Company for all models
       * @return Iterator of org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanies()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company>(it, true);
        }

        public static org.semanticwb.cptm.Company createCompany(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.cptm.Company.ClassMgr.createCompany(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.cptm.Company
       * @param id Identifier for org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.Company
       * @return A org.semanticwb.cptm.Company
       */
        public static org.semanticwb.cptm.Company getCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Company)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Company
       * @param id Identifier for org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.Company
       * @return A org.semanticwb.cptm.Company
       */
        public static org.semanticwb.cptm.Company createCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Company)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Company
       * @param id Identifier for org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.Company
       */
        public static void removeCompany(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Company
       * @param id Identifier for org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.Company
       * @return true if the org.semanticwb.cptm.Company exists, false otherwise
       */

        public static boolean hasCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompany(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined DirectoryResource
       * @param value DirectoryResource of the type org.semanticwb.portal.community.DirectoryResource
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined DirectoryResource
       * @param value DirectoryResource of the type org.semanticwb.portal.community.DirectoryResource
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Profile
       * @param value Profile of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByProfile(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Profile
       * @param value Profile of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByProfile(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined TopicWebPage
       * @param value TopicWebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByTopicWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined TopicWebPage
       * @param value TopicWebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByTopicWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Comment
       * @param value Comment of the type org.semanticwb.portal.community.Comment
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByComment(org.semanticwb.portal.community.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Comment
       * @param value Comment of the type org.semanticwb.portal.community.Comment
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByComment(org.semanticwb.portal.community.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompanyBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Company
   */
    public CompanyBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ExtNumber property
* @return String with the ExtNumber
*/
    public String getExtNumber()
    {
        return getSemanticObject().getProperty(swbcomm_extNumber);
    }

/**
* Sets the ExtNumber property
* @param value long with the ExtNumber
*/
    public void setExtNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_extNumber, value);
    }

/**
* Gets the ContactPhoneNumber property
* @return String with the ContactPhoneNumber
*/
    public String getContactPhoneNumber()
    {
        return getSemanticObject().getProperty(swbcomm_contactPhoneNumber);
    }

/**
* Sets the ContactPhoneNumber property
* @param value long with the ContactPhoneNumber
*/
    public void setContactPhoneNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactPhoneNumber, value);
    }

/**
* Gets the ContactName property
* @return String with the ContactName
*/
    public String getContactName()
    {
        return getSemanticObject().getProperty(swbcomm_contactName);
    }

/**
* Sets the ContactName property
* @param value long with the ContactName
*/
    public void setContactName(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactName, value);
    }

/**
* Gets the Step property
* @return int with the Step
*/
    public int getStep()
    {
        return getSemanticObject().getIntProperty(swb_geoStep);
    }

/**
* Sets the Step property
* @param value long with the Step
*/
    public void setStep(int value)
    {
        getSemanticObject().setIntProperty(swb_geoStep, value);
    }

/**
* Gets the IntNumber property
* @return String with the IntNumber
*/
    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

/**
* Sets the IntNumber property
* @param value long with the IntNumber
*/
    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
    }

/**
* Gets the State property
* @return String with the State
*/
    public String getState()
    {
        return getSemanticObject().getProperty(swbcomm_state);
    }

/**
* Sets the State property
* @param value long with the State
*/
    public void setState(String value)
    {
        getSemanticObject().setProperty(swbcomm_state, value);
    }

/**
* Gets the Latitude property
* @return double with the Latitude
*/
    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

/**
* Sets the Latitude property
* @param value long with the Latitude
*/
    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
    }

/**
* Gets the Longitude property
* @return double with the Longitude
*/
    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(swb_longitude);
    }

/**
* Sets the Longitude property
* @param value long with the Longitude
*/
    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_longitude, value);
    }

/**
* Gets the StreetName property
* @return String with the StreetName
*/
    public String getStreetName()
    {
        return getSemanticObject().getProperty(swbcomm_streetName);
    }

/**
* Sets the StreetName property
* @param value long with the StreetName
*/
    public void setStreetName(String value)
    {
        getSemanticObject().setProperty(swbcomm_streetName, value);
    }

/**
* Gets the CityCouncil property
* @return String with the CityCouncil
*/
    public String getCityCouncil()
    {
        return getSemanticObject().getProperty(swbcomm_cityCouncil);
    }

/**
* Sets the CityCouncil property
* @param value long with the CityCouncil
*/
    public void setCityCouncil(String value)
    {
        getSemanticObject().setProperty(swbcomm_cityCouncil, value);
    }

/**
* Gets the City property
* @return String with the City
*/
    public String getCity()
    {
        return getSemanticObject().getProperty(swbcomm_city);
    }

/**
* Sets the City property
* @param value long with the City
*/
    public void setCity(String value)
    {
        getSemanticObject().setProperty(swbcomm_city, value);
    }

/**
* Gets the ContactEmail property
* @return String with the ContactEmail
*/
    public String getContactEmail()
    {
        return getSemanticObject().getProperty(swbcomm_contactEmail);
    }

/**
* Sets the ContactEmail property
* @param value long with the ContactEmail
*/
    public void setContactEmail(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactEmail, value);
    }
}
