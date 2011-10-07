package org.semanticwb.promexico.base;


   /**
   * Servicios 
   */
public abstract class ServiceBase extends org.semanticwb.promexico.ProMxWebPage implements org.semanticwb.model.Viewable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.Indexable,org.semanticwb.model.Searchable,org.semanticwb.model.MetaTagable,org.semanticwb.model.Rankable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Trashable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Tagable,org.semanticwb.model.Expirable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Countryable,org.semanticwb.model.Filterable,org.semanticwb.model.Resourceable
{
    public static final org.semanticwb.platform.SemanticProperty promx_ServicePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#ServicePhoto");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideo");
    public static final org.semanticwb.platform.SemanticProperty promx_hasSrvVideosInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasSrvVideosInv");
   /**
   * Objeto controlador de oficinas
   */
    public static final org.semanticwb.platform.SemanticClass promx_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Office");
    public static final org.semanticwb.platform.SemanticProperty promx_hasOfficeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasOfficeInv");
   /**
   * Servicios
   */
    public static final org.semanticwb.platform.SemanticClass promx_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Service");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Service");

    public static class ClassMgr
    {
       /**
       * Returns a list of Service for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServices(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Service for all models
       * @return Iterator of org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServices()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.Service
       * @param id Identifier for org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.Service
       * @return A org.semanticwb.promexico.Service
       */
        public static org.semanticwb.promexico.Service getService(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Service)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Service
       * @param id Identifier for org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.Service
       * @return A org.semanticwb.promexico.Service
       */
        public static org.semanticwb.promexico.Service createService(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Service)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Service
       * @param id Identifier for org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.Service
       */
        public static void removeService(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Service
       * @param id Identifier for org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.Service
       * @return true if the org.semanticwb.promexico.Service exists, false otherwise
       */

        public static boolean hasService(String id, org.semanticwb.model.SWBModel model)
        {
            return (getService(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined SrvVideosInv
       * @param value SrvVideosInv of the type org.semanticwb.promexico.ProMxVideo
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceBySrvVideosInv(org.semanticwb.promexico.ProMxVideo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasSrvVideosInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined SrvVideosInv
       * @param value SrvVideosInv of the type org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceBySrvVideosInv(org.semanticwb.promexico.ProMxVideo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasSrvVideosInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined OfficeInv
       * @param value OfficeInv of the type org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByOfficeInv(org.semanticwb.promexico.Office value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasOfficeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined OfficeInv
       * @param value OfficeInv of the type org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByOfficeInv(org.semanticwb.promexico.Office value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasOfficeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Service with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.promexico.Service
       */

        public static java.util.Iterator<org.semanticwb.promexico.Service> listServiceByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ServiceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Service
   */
    public ServiceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ServicePhoto property
* @return String with the ServicePhoto
*/
    public String getServicePhoto()
    {
        return getSemanticObject().getProperty(promx_ServicePhoto);
    }

/**
* Sets the ServicePhoto property
* @param value long with the ServicePhoto
*/
    public void setServicePhoto(String value)
    {
        getSemanticObject().setProperty(promx_ServicePhoto, value);
    }
   /**
   * Gets all the org.semanticwb.promexico.ProMxVideo
   * @return A GenericIterator with all the org.semanticwb.promexico.ProMxVideo
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> listSrvVideosInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo>(getSemanticObject().listObjectProperties(promx_hasSrvVideosInv));
    }

   /**
   * Gets true if has a SrvVideosInv
   * @param value org.semanticwb.promexico.ProMxVideo to verify
   * @return true if the org.semanticwb.promexico.ProMxVideo exists, false otherwise
   */
    public boolean hasSrvVideosInv(org.semanticwb.promexico.ProMxVideo value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasSrvVideosInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the SrvVideosInv
   * @return a org.semanticwb.promexico.ProMxVideo
   */
    public org.semanticwb.promexico.ProMxVideo getSrvVideosInv()
    {
         org.semanticwb.promexico.ProMxVideo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasSrvVideosInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.ProMxVideo)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.promexico.Office
   * @return A GenericIterator with all the org.semanticwb.promexico.Office
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> listOfficeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office>(getSemanticObject().listObjectProperties(promx_hasOfficeInv));
    }

   /**
   * Gets true if has a OfficeInv
   * @param value org.semanticwb.promexico.Office to verify
   * @return true if the org.semanticwb.promexico.Office exists, false otherwise
   */
    public boolean hasOfficeInv(org.semanticwb.promexico.Office value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasOfficeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the OfficeInv
   * @return a org.semanticwb.promexico.Office
   */
    public org.semanticwb.promexico.Office getOfficeInv()
    {
         org.semanticwb.promexico.Office ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasOfficeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Office)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
