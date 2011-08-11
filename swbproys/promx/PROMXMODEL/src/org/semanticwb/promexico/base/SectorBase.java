package org.semanticwb.promexico.base;


public abstract class SectorBase extends org.semanticwb.promexico.ProMxWebPage implements org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Filterable,org.semanticwb.model.Resourceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Expirable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.Tagable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Viewable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Localeable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Searchable,org.semanticwb.model.Countryable
{
    public static final org.semanticwb.platform.SemanticClass promx_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");
    public static final org.semanticwb.platform.SemanticProperty promx_hasNews=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasNews");
   /**
   * Eventos de ProMéxico
   */
    public static final org.semanticwb.platform.SemanticClass promx_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Event");
    public static final org.semanticwb.platform.SemanticProperty promx_hasEventsInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasEventsInv");
    public static final org.semanticwb.platform.SemanticProperty promx_SectorPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#SectorPhoto");
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");

    public static class ClassMgr
    {
       /**
       * Returns a list of Sector for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Sector for all models
       * @return Iterator of org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.Sector
       * @param id Identifier for org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return A org.semanticwb.promexico.Sector
       */
        public static org.semanticwb.promexico.Sector getSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Sector)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Sector
       * @param id Identifier for org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return A org.semanticwb.promexico.Sector
       */
        public static org.semanticwb.promexico.Sector createSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Sector)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Sector
       * @param id Identifier for org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Sector
       */
        public static void removeSector(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Sector
       * @param id Identifier for org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return true if the org.semanticwb.promexico.Sector exists, false otherwise
       */

        public static boolean hasSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSector(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined News
       * @param value News of the type org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByNews(org.semanticwb.promexico.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasNews, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined News
       * @param value News of the type org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByNews(org.semanticwb.promexico.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasNews,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined EventsInv
       * @param value EventsInv of the type org.semanticwb.promexico.Event
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByEventsInv(org.semanticwb.promexico.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasEventsInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined EventsInv
       * @param value EventsInv of the type org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByEventsInv(org.semanticwb.promexico.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasEventsInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Sector with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.promexico.Sector
       */

        public static java.util.Iterator<org.semanticwb.promexico.Sector> listSectorByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SectorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Sector
   */
    public SectorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.promexico.New
   * @return A GenericIterator with all the org.semanticwb.promexico.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> listNewses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New>(getSemanticObject().listObjectProperties(promx_hasNews));
    }

   /**
   * Gets true if has a News
   * @param value org.semanticwb.promexico.New to verify
   * @return true if the org.semanticwb.promexico.New exists, false otherwise
   */
    public boolean hasNews(org.semanticwb.promexico.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasNews,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the News
   * @return a org.semanticwb.promexico.New
   */
    public org.semanticwb.promexico.New getNews()
    {
         org.semanticwb.promexico.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasNews);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.New)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.promexico.Event
   * @return A GenericIterator with all the org.semanticwb.promexico.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> listEventsInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event>(getSemanticObject().listObjectProperties(promx_hasEventsInv));
    }

   /**
   * Gets true if has a EventsInv
   * @param value org.semanticwb.promexico.Event to verify
   * @return true if the org.semanticwb.promexico.Event exists, false otherwise
   */
    public boolean hasEventsInv(org.semanticwb.promexico.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasEventsInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EventsInv
   * @return a org.semanticwb.promexico.Event
   */
    public org.semanticwb.promexico.Event getEventsInv()
    {
         org.semanticwb.promexico.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasEventsInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Event)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SectorPhoto property
* @return String with the SectorPhoto
*/
    public String getSectorPhoto()
    {
        return getSemanticObject().getProperty(promx_SectorPhoto);
    }

/**
* Sets the SectorPhoto property
* @param value long with the SectorPhoto
*/
    public void setSectorPhoto(String value)
    {
        getSemanticObject().setProperty(promx_SectorPhoto, value);
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
