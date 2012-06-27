package org.semanticwb.cptm.base;


   /**
   * Clase que administra el catálogo de Cadenas de Empresas 
   */
public abstract class CompanyChainBase extends org.semanticwb.cptm.GeneralCompany implements org.semanticwb.model.Tagable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Resourceable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Indexable
{
   /**
   * Clase se administra el catálogo de Marcas de Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyBrand");
    public static final org.semanticwb.platform.SemanticProperty cptm_chainCompanyBrandInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#chainCompanyBrandInv");
   /**
   * Clase que administra el catálogo de Cadenas de Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyChain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyChain");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyChain");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompanyChain for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChains(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CompanyChain for all models
       * @return Iterator of org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChains()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CompanyChain
       * @param id Identifier for org.semanticwb.cptm.CompanyChain
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return A org.semanticwb.cptm.CompanyChain
       */
        public static org.semanticwb.cptm.CompanyChain getCompanyChain(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyChain)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CompanyChain
       * @param id Identifier for org.semanticwb.cptm.CompanyChain
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return A org.semanticwb.cptm.CompanyChain
       */
        public static org.semanticwb.cptm.CompanyChain createCompanyChain(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyChain)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CompanyChain
       * @param id Identifier for org.semanticwb.cptm.CompanyChain
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       */
        public static void removeCompanyChain(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CompanyChain
       * @param id Identifier for org.semanticwb.cptm.CompanyChain
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return true if the org.semanticwb.cptm.CompanyChain exists, false otherwise
       */

        public static boolean hasCompanyChain(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompanyChain(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByPromotion(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByPromotion(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCompanyLine(org.semanticwb.cptm.CompanyLine value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCompanyLine(org.semanticwb.cptm.CompanyLine value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined ChainCompanyBrandInv
       * @param value ChainCompanyBrandInv of the type org.semanticwb.cptm.CompanyBrand
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByChainCompanyBrandInv(org.semanticwb.cptm.CompanyBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_chainCompanyBrandInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined ChainCompanyBrandInv
       * @param value ChainCompanyBrandInv of the type org.semanticwb.cptm.CompanyBrand
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByChainCompanyBrandInv(org.semanticwb.cptm.CompanyBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_chainCompanyBrandInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCompLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCompLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCompanyType(org.semanticwb.cptm.CompanyType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByCompanyType(org.semanticwb.cptm.CompanyType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.CompanyChain
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyChain with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.CompanyChain
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyChain> listCompanyChainByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyChain> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompanyChainBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompanyChain
   */
    public CompanyChainBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ChainCompanyBrandInv
   * @param value ChainCompanyBrandInv to set
   */

    public void setChainCompanyBrandInv(org.semanticwb.cptm.CompanyBrand value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_chainCompanyBrandInv, value.getSemanticObject());
        }else
        {
            removeChainCompanyBrandInv();
        }
    }
   /**
   * Remove the value for ChainCompanyBrandInv property
   */

    public void removeChainCompanyBrandInv()
    {
        getSemanticObject().removeProperty(cptm_chainCompanyBrandInv);
    }

   /**
   * Gets the ChainCompanyBrandInv
   * @return a org.semanticwb.cptm.CompanyBrand
   */
    public org.semanticwb.cptm.CompanyBrand getChainCompanyBrandInv()
    {
         org.semanticwb.cptm.CompanyBrand ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_chainCompanyBrandInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.CompanyBrand)obj.createGenericInstance();
         }
         return ret;
    }
}
