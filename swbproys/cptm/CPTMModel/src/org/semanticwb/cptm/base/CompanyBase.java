package org.semanticwb.cptm.base;


   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico. 
   */
public abstract class CompanyBase extends org.semanticwb.cptm.GeneralCompany implements org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.portal.community.Addressable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Resourceable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Localeable,org.semanticwb.model.Expirable,org.semanticwb.model.Indexable
{
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompActivityRef");
   /**
   * Clase se administra el catálogo de Marcas de Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyBrand");
    public static final org.semanticwb.platform.SemanticProperty cptm_compCompanyBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#compCompanyBrand");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompExperienceRef");
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
       * Gets all org.semanticwb.cptm.Company with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByPromotion(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByPromotion(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.Company with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompanyLine(org.semanticwb.cptm.CompanyLine value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompanyLine(org.semanticwb.cptm.CompanyLine value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompActivityRef
       * @param value CompActivityRef of the type org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompActivityRef(org.semanticwb.cptm.ActivityRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompActivityRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompActivityRef
       * @param value CompActivityRef of the type org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompActivityRef(org.semanticwb.cptm.ActivityRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompActivityRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompCompanyBrand
       * @param value CompCompanyBrand of the type org.semanticwb.cptm.CompanyBrand
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompCompanyBrand(org.semanticwb.cptm.CompanyBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_compCompanyBrand, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompCompanyBrand
       * @param value CompCompanyBrand of the type org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompCompanyBrand(org.semanticwb.cptm.CompanyBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_compCompanyBrand,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompExperienceRef
       * @param value CompExperienceRef of the type org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompExperienceRef(org.semanticwb.cptm.ExperienceRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompExperienceRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompExperienceRef
       * @param value CompExperienceRef of the type org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompExperienceRef(org.semanticwb.cptm.ExperienceRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompExperienceRef,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.Company with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompanyType(org.semanticwb.cptm.CompanyType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByCompanyType(org.semanticwb.cptm.CompanyType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Company with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.Company
       */

        public static java.util.Iterator<org.semanticwb.cptm.Company> listCompanyByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
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
* Gets the Expiration property
* @return java.util.Date with the Expiration
*/
    public java.util.Date getExpiration()
    {
        return getSemanticObject().getDateProperty(swb_expiration);
    }

/**
* Sets the Expiration property
* @param value long with the Expiration
*/
    public void setExpiration(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_expiration, value);
    }
   /**
   * Sets the value for the property Language
   * @param value Language to set
   */

    public void setLanguage(org.semanticwb.model.Language value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_language, value.getSemanticObject());
        }else
        {
            removeLanguage();
        }
    }
   /**
   * Remove the value for Language property
   */

    public void removeLanguage()
    {
        getSemanticObject().removeProperty(swb_language);
    }

   /**
   * Gets the Language
   * @return a org.semanticwb.model.Language
   */
    public org.semanticwb.model.Language getLanguage()
    {
         org.semanticwb.model.Language ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_language);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Language)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.ActivityRef
   * @return A GenericIterator with all the org.semanticwb.cptm.ActivityRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> listCompActivityRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(getSemanticObject().listObjectProperties(cptm_hasCompActivityRef));
    }

   /**
   * Gets true if has a CompActivityRef
   * @param value org.semanticwb.cptm.ActivityRef to verify
   * @return true if the org.semanticwb.cptm.ActivityRef exists, false otherwise
   */
    public boolean hasCompActivityRef(org.semanticwb.cptm.ActivityRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompActivityRef,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CompActivityRef
   * @param value org.semanticwb.cptm.ActivityRef to add
   */

    public void addCompActivityRef(org.semanticwb.cptm.ActivityRef value)
    {
        getSemanticObject().addObjectProperty(cptm_hasCompActivityRef, value.getSemanticObject());
    }
   /**
   * Removes all the CompActivityRef
   */

    public void removeAllCompActivityRef()
    {
        getSemanticObject().removeProperty(cptm_hasCompActivityRef);
    }
   /**
   * Removes a CompActivityRef
   * @param value org.semanticwb.cptm.ActivityRef to remove
   */

    public void removeCompActivityRef(org.semanticwb.cptm.ActivityRef value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasCompActivityRef,value.getSemanticObject());
    }

   /**
   * Gets the CompActivityRef
   * @return a org.semanticwb.cptm.ActivityRef
   */
    public org.semanticwb.cptm.ActivityRef getCompActivityRef()
    {
         org.semanticwb.cptm.ActivityRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompActivityRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ActivityRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property CompCompanyBrand
   * @param value CompCompanyBrand to set
   */

    public void setCompCompanyBrand(org.semanticwb.cptm.CompanyBrand value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_compCompanyBrand, value.getSemanticObject());
        }else
        {
            removeCompCompanyBrand();
        }
    }
   /**
   * Remove the value for CompCompanyBrand property
   */

    public void removeCompCompanyBrand()
    {
        getSemanticObject().removeProperty(cptm_compCompanyBrand);
    }

   /**
   * Gets the CompCompanyBrand
   * @return a org.semanticwb.cptm.CompanyBrand
   */
    public org.semanticwb.cptm.CompanyBrand getCompCompanyBrand()
    {
         org.semanticwb.cptm.CompanyBrand ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_compCompanyBrand);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.CompanyBrand)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.ExperienceRef
   * @return A GenericIterator with all the org.semanticwb.cptm.ExperienceRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> listCompExperienceRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef>(getSemanticObject().listObjectProperties(cptm_hasCompExperienceRef));
    }

   /**
   * Gets true if has a CompExperienceRef
   * @param value org.semanticwb.cptm.ExperienceRef to verify
   * @return true if the org.semanticwb.cptm.ExperienceRef exists, false otherwise
   */
    public boolean hasCompExperienceRef(org.semanticwb.cptm.ExperienceRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompExperienceRef,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CompExperienceRef
   * @param value org.semanticwb.cptm.ExperienceRef to add
   */

    public void addCompExperienceRef(org.semanticwb.cptm.ExperienceRef value)
    {
        getSemanticObject().addObjectProperty(cptm_hasCompExperienceRef, value.getSemanticObject());
    }
   /**
   * Removes all the CompExperienceRef
   */

    public void removeAllCompExperienceRef()
    {
        getSemanticObject().removeProperty(cptm_hasCompExperienceRef);
    }
   /**
   * Removes a CompExperienceRef
   * @param value org.semanticwb.cptm.ExperienceRef to remove
   */

    public void removeCompExperienceRef(org.semanticwb.cptm.ExperienceRef value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasCompExperienceRef,value.getSemanticObject());
    }

   /**
   * Gets the CompExperienceRef
   * @return a org.semanticwb.cptm.ExperienceRef
   */
    public org.semanticwb.cptm.ExperienceRef getCompExperienceRef()
    {
         org.semanticwb.cptm.ExperienceRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompExperienceRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ExperienceRef)obj.createGenericInstance();
         }
         return ret;
    }
}
