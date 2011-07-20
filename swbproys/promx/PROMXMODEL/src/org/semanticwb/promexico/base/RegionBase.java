package org.semanticwb.promexico.base;


public abstract class RegionBase extends org.semanticwb.promexico.ProMxWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Viewable,org.semanticwb.promexico.Representable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Resourceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Countryable,org.semanticwb.model.Searchable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Undeleteable,org.semanticwb.model.Rankable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Referensable
{
    public static final org.semanticwb.platform.SemanticClass promx_Region=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Region");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Region");

    public static class ClassMgr
    {
       /**
       * Returns a list of Region for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Region for all models
       * @return Iterator of org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.Region
       * @param id Identifier for org.semanticwb.promexico.Region
       * @param model Model of the org.semanticwb.promexico.Region
       * @return A org.semanticwb.promexico.Region
       */
        public static org.semanticwb.promexico.Region getRegion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Region)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Region
       * @param id Identifier for org.semanticwb.promexico.Region
       * @param model Model of the org.semanticwb.promexico.Region
       * @return A org.semanticwb.promexico.Region
       */
        public static org.semanticwb.promexico.Region createRegion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Region)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Region
       * @param id Identifier for org.semanticwb.promexico.Region
       * @param model Model of the org.semanticwb.promexico.Region
       */
        public static void removeRegion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Region
       * @param id Identifier for org.semanticwb.promexico.Region
       * @param model Model of the org.semanticwb.promexico.Region
       * @return true if the org.semanticwb.promexico.Region exists, false otherwise
       */

        public static boolean hasRegion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRegion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.promexico.Region
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Region with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.promexico.Region
       */

        public static java.util.Iterator<org.semanticwb.promexico.Region> listRegionByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Region> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a RegionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Region
   */
    public RegionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the RepreName property
* @return String with the RepreName
*/
    public String getRepreName()
    {
        return getSemanticObject().getProperty(promx_repreName);
    }

/**
* Sets the RepreName property
* @param value long with the RepreName
*/
    public void setRepreName(String value)
    {
        getSemanticObject().setProperty(promx_repreName, value);
    }

/**
* Gets the RepreEmail property
* @return String with the RepreEmail
*/
    public String getRepreEmail()
    {
        return getSemanticObject().getProperty(promx_repreEmail);
    }

/**
* Sets the RepreEmail property
* @param value long with the RepreEmail
*/
    public void setRepreEmail(String value)
    {
        getSemanticObject().setProperty(promx_repreEmail, value);
    }

/**
* Gets the ReprePhone property
* @return String with the ReprePhone
*/
    public String getReprePhone()
    {
        return getSemanticObject().getProperty(promx_reprePhone);
    }

/**
* Sets the ReprePhone property
* @param value long with the ReprePhone
*/
    public void setReprePhone(String value)
    {
        getSemanticObject().setProperty(promx_reprePhone, value);
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
