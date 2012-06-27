package org.semanticwb.cptm.base;


   /**
   * Clase se administra el catálogo de Marcas de Empresas 
   */
public abstract class CompanyBrandBase extends org.semanticwb.cptm.GeneralCompany implements org.semanticwb.model.Tagable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Resourceable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Indexable
{
   /**
   * Clase que administra el catálogo de Cadenas de Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyChain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyChain");
    public static final org.semanticwb.platform.SemanticProperty cptm_brandCompanyChain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#brandCompanyChain");
   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Company=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Company");
    public static final org.semanticwb.platform.SemanticProperty cptm_brandCompanyInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#brandCompanyInv");
   /**
   * Clase se administra el catálogo de Marcas de Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyBrand");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyBrand");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompanyBrand for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrands(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CompanyBrand for all models
       * @return Iterator of org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrands()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CompanyBrand
       * @param id Identifier for org.semanticwb.cptm.CompanyBrand
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return A org.semanticwb.cptm.CompanyBrand
       */
        public static org.semanticwb.cptm.CompanyBrand getCompanyBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyBrand)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CompanyBrand
       * @param id Identifier for org.semanticwb.cptm.CompanyBrand
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return A org.semanticwb.cptm.CompanyBrand
       */
        public static org.semanticwb.cptm.CompanyBrand createCompanyBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyBrand)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CompanyBrand
       * @param id Identifier for org.semanticwb.cptm.CompanyBrand
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       */
        public static void removeCompanyBrand(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CompanyBrand
       * @param id Identifier for org.semanticwb.cptm.CompanyBrand
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return true if the org.semanticwb.cptm.CompanyBrand exists, false otherwise
       */

        public static boolean hasCompanyBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompanyBrand(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByPromotion(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByPromotion(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCompanyLine(org.semanticwb.cptm.CompanyLine value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCompanyLine(org.semanticwb.cptm.CompanyLine value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined BrandCompanyChain
       * @param value BrandCompanyChain of the type org.semanticwb.cptm.CompanyChain
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByBrandCompanyChain(org.semanticwb.cptm.CompanyChain value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_brandCompanyChain, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined BrandCompanyChain
       * @param value BrandCompanyChain of the type org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByBrandCompanyChain(org.semanticwb.cptm.CompanyChain value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_brandCompanyChain,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCompLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCompLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCompanyType(org.semanticwb.cptm.CompanyType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByCompanyType(org.semanticwb.cptm.CompanyType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined BrandCompanyInv
       * @param value BrandCompanyInv of the type org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByBrandCompanyInv(org.semanticwb.cptm.Company value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_brandCompanyInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyBrand with a determined BrandCompanyInv
       * @param value BrandCompanyInv of the type org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.CompanyBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyBrand> listCompanyBrandByBrandCompanyInv(org.semanticwb.cptm.Company value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_brandCompanyInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompanyBrandBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompanyBrand
   */
    public CompanyBrandBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property BrandCompanyChain
   * @param value BrandCompanyChain to set
   */

    public void setBrandCompanyChain(org.semanticwb.cptm.CompanyChain value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_brandCompanyChain, value.getSemanticObject());
        }else
        {
            removeBrandCompanyChain();
        }
    }
   /**
   * Remove the value for BrandCompanyChain property
   */

    public void removeBrandCompanyChain()
    {
        getSemanticObject().removeProperty(cptm_brandCompanyChain);
    }

   /**
   * Gets the BrandCompanyChain
   * @return a org.semanticwb.cptm.CompanyChain
   */
    public org.semanticwb.cptm.CompanyChain getBrandCompanyChain()
    {
         org.semanticwb.cptm.CompanyChain ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_brandCompanyChain);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.CompanyChain)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property BrandCompanyInv
   * @param value BrandCompanyInv to set
   */

    public void setBrandCompanyInv(org.semanticwb.cptm.Company value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_brandCompanyInv, value.getSemanticObject());
        }else
        {
            removeBrandCompanyInv();
        }
    }
   /**
   * Remove the value for BrandCompanyInv property
   */

    public void removeBrandCompanyInv()
    {
        getSemanticObject().removeProperty(cptm_brandCompanyInv);
    }

   /**
   * Gets the BrandCompanyInv
   * @return a org.semanticwb.cptm.Company
   */
    public org.semanticwb.cptm.Company getBrandCompanyInv()
    {
         org.semanticwb.cptm.Company ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_brandCompanyInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Company)obj.createGenericInstance();
         }
         return ret;
    }
}
