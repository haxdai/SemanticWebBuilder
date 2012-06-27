package org.semanticwb.cptm.base;


   /**
   * Páginas web para Puntos Geográficos, se agrego esta clase para que solo se pudieran agregar Puntos geográficos en un elemento de tipo "Estado/State" 
   */
public abstract class CPTMWebPageBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.cptm.Videoable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.model.RuleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.cptm.LocalityInt,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable
{
   /**
   * Páginas web para Puntos Geográficos, se agrego esta clase para que solo se pudieran agregar Puntos geográficos en un elemento de tipo "Estado/State"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CPTMWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebPage");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebPage");

    public static class ClassMgr
    {
       /**
       * Returns a list of CPTMWebPage for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPages(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CPTMWebPage for all models
       * @return Iterator of org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPages()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return A org.semanticwb.cptm.CPTMWebPage
       */
        public static org.semanticwb.cptm.CPTMWebPage getCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMWebPage)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return A org.semanticwb.cptm.CPTMWebPage
       */
        public static org.semanticwb.cptm.CPTMWebPage createCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMWebPage)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       */
        public static void removeCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return true if the org.semanticwb.cptm.CPTMWebPage exists, false otherwise
       */

        public static boolean hasCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCPTMWebPage(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByEventGeographicPointInv(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByEventGeographicPointInv(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ActLocalityInv
       * @param value ActLocalityInv of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByActLocalityInv(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ActLocalityInv
       * @param value ActLocalityInv of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByActLocalityInv(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActLocalityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ArefLocalityInv
       * @param value ArefLocalityInv of the type org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByArefLocalityInv(org.semanticwb.cptm.ActivityRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ArefLocalityInv
       * @param value ArefLocalityInv of the type org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByArefLocalityInv(org.semanticwb.cptm.ActivityRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocalityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined GeneralAttribute
       * @param value GeneralAttribute of the type org.semanticwb.cptm.GeneralAttractive
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeneralAttribute, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined GeneralAttribute
       * @param value GeneralAttribute of the type org.semanticwb.cptm.GeneralAttractive
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeneralAttribute,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByNewGeographicPointInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByNewGeographicPointInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Proximity
       * @param value Proximity of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByProximity(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasProximity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Proximity
       * @param value Proximity of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByProximity(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasProximity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined CompanyLocalityInv
       * @param value CompanyLocalityInv of the type org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCompanyLocalityInv(org.semanticwb.cptm.GeneralCompany value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined CompanyLocalityInv
       * @param value CompanyLocalityInv of the type org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCompanyLocalityInv(org.semanticwb.cptm.GeneralCompany value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLocalityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ExpLocalityInv
       * @param value ExpLocalityInv of the type org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByExpLocalityInv(org.semanticwb.cptm.ExperienceRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ExpLocalityInv
       * @param value ExpLocalityInv of the type org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByExpLocalityInv(org.semanticwb.cptm.ExperienceRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocalityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ExperienceLocalityInv
       * @param value ExperienceLocalityInv of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByExperienceLocalityInv(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ExperienceLocalityInv
       * @param value ExperienceLocalityInv of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByExperienceLocalityInv(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceLocalityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined LocalityEditNoteInv
       * @param value LocalityEditNoteInv of the type org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByLocalityEditNoteInv(org.semanticwb.cptm.EditNote value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityEditNoteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined LocalityEditNoteInv
       * @param value LocalityEditNoteInv of the type org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByLocalityEditNoteInv(org.semanticwb.cptm.EditNote value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityEditNoteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPTMWebPageBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CPTMWebPage
   */
    public CPTMWebPageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Videoyoutube property
* @return String with the Videoyoutube
*/
    public String getVideoyoutube()
    {
        return getSemanticObject().getProperty(cptm_videoyoutube);
    }

/**
* Sets the Videoyoutube property
* @param value long with the Videoyoutube
*/
    public void setVideoyoutube(String value)
    {
        getSemanticObject().setProperty(cptm_videoyoutube, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.Event
   * @return A GenericIterator with all the org.semanticwb.cptm.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> listEventGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(getSemanticObject().listObjectProperties(cptm_hasEventGeographicPointInv));
    }

   /**
   * Gets true if has a EventGeographicPointInv
   * @param value org.semanticwb.cptm.Event to verify
   * @return true if the org.semanticwb.cptm.Event exists, false otherwise
   */
    public boolean hasEventGeographicPointInv(org.semanticwb.cptm.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EventGeographicPointInv
   * @return a org.semanticwb.cptm.Event
   */
    public org.semanticwb.cptm.Event getEventGeographicPointInv()
    {
         org.semanticwb.cptm.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Event)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Activity
   * @return A GenericIterator with all the org.semanticwb.cptm.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> listActLocalityInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(getSemanticObject().listObjectProperties(cptm_hasActLocalityInv));
    }

   /**
   * Gets true if has a ActLocalityInv
   * @param value org.semanticwb.cptm.Activity to verify
   * @return true if the org.semanticwb.cptm.Activity exists, false otherwise
   */
    public boolean hasActLocalityInv(org.semanticwb.cptm.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasActLocalityInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the ActLocalityInv
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getActLocalityInv()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasActLocalityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Latitude property
* @return double with the Latitude
*/
    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(cptm_latitude);
    }

/**
* Sets the Latitude property
* @param value long with the Latitude
*/
    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(cptm_latitude, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.TravelRoute
   * @return A GenericIterator with all the org.semanticwb.cptm.TravelRoute
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> listTravelRouteInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute>(getSemanticObject().listObjectProperties(cptm_hasTravelRouteInv));
    }

   /**
   * Gets true if has a TravelRouteInv
   * @param value org.semanticwb.cptm.TravelRoute to verify
   * @return true if the org.semanticwb.cptm.TravelRoute exists, false otherwise
   */
    public boolean hasTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasTravelRouteInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the TravelRouteInv
   * @return a org.semanticwb.cptm.TravelRoute
   */
    public org.semanticwb.cptm.TravelRoute getTravelRouteInv()
    {
         org.semanticwb.cptm.TravelRoute ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasTravelRouteInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelRoute)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ArefLocalityInv
   * @param value ArefLocalityInv to set
   */

    public void setArefLocalityInv(org.semanticwb.cptm.ActivityRef value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefLocalityInv, value.getSemanticObject());
        }else
        {
            removeArefLocalityInv();
        }
    }
   /**
   * Remove the value for ArefLocalityInv property
   */

    public void removeArefLocalityInv()
    {
        getSemanticObject().removeProperty(cptm_arefLocalityInv);
    }

   /**
   * Gets the ArefLocalityInv
   * @return a org.semanticwb.cptm.ActivityRef
   */
    public org.semanticwb.cptm.ActivityRef getArefLocalityInv()
    {
         org.semanticwb.cptm.ActivityRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefLocalityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ActivityRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.GeneralAttractive
   * @return A GenericIterator with all the org.semanticwb.cptm.GeneralAttractive
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralAttractive> listGeneralAttributes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralAttractive>(getSemanticObject().listObjectProperties(cptm_hasGeneralAttribute));
    }

   /**
   * Gets true if has a GeneralAttribute
   * @param value org.semanticwb.cptm.GeneralAttractive to verify
   * @return true if the org.semanticwb.cptm.GeneralAttractive exists, false otherwise
   */
    public boolean hasGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasGeneralAttribute,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a GeneralAttribute
   * @param value org.semanticwb.cptm.GeneralAttractive to add
   */

    public void addGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value)
    {
        getSemanticObject().addObjectProperty(cptm_hasGeneralAttribute, value.getSemanticObject());
    }
   /**
   * Removes all the GeneralAttribute
   */

    public void removeAllGeneralAttribute()
    {
        getSemanticObject().removeProperty(cptm_hasGeneralAttribute);
    }
   /**
   * Removes a GeneralAttribute
   * @param value org.semanticwb.cptm.GeneralAttractive to remove
   */

    public void removeGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasGeneralAttribute,value.getSemanticObject());
    }

   /**
   * Gets the GeneralAttribute
   * @return a org.semanticwb.cptm.GeneralAttractive
   */
    public org.semanticwb.cptm.GeneralAttractive getGeneralAttribute()
    {
         org.semanticwb.cptm.GeneralAttractive ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasGeneralAttribute);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeneralAttractive)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.New
   * @return A GenericIterator with all the org.semanticwb.cptm.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New> listNewGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New>(getSemanticObject().listObjectProperties(cptm_hasNewGeographicPointInv));
    }

   /**
   * Gets true if has a NewGeographicPointInv
   * @param value org.semanticwb.cptm.New to verify
   * @return true if the org.semanticwb.cptm.New exists, false otherwise
   */
    public boolean hasNewGeographicPointInv(org.semanticwb.cptm.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNewGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewGeographicPointInv
   * @return a org.semanticwb.cptm.New
   */
    public org.semanticwb.cptm.New getNewGeographicPointInv()
    {
         org.semanticwb.cptm.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNewGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.New)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listProximities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasProximity));
    }

   /**
   * Gets true if has a Proximity
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasProximity(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasProximity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Proximity
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addProximity(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasProximity, value.getSemanticObject());
    }
   /**
   * Removes all the Proximity
   */

    public void removeAllProximity()
    {
        getSemanticObject().removeProperty(cptm_hasProximity);
    }
   /**
   * Removes a Proximity
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeProximity(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasProximity,value.getSemanticObject());
    }

   /**
   * Gets the Proximity
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getProximity()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasProximity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.GeneralCompany
   * @return A GenericIterator with all the org.semanticwb.cptm.GeneralCompany
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> listCompanyLocalityInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany>(getSemanticObject().listObjectProperties(cptm_hasCompanyLocalityInv));
    }

   /**
   * Gets true if has a CompanyLocalityInv
   * @param value org.semanticwb.cptm.GeneralCompany to verify
   * @return true if the org.semanticwb.cptm.GeneralCompany exists, false otherwise
   */
    public boolean hasCompanyLocalityInv(org.semanticwb.cptm.GeneralCompany value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompanyLocalityInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the CompanyLocalityInv
   * @return a org.semanticwb.cptm.GeneralCompany
   */
    public org.semanticwb.cptm.GeneralCompany getCompanyLocalityInv()
    {
         org.semanticwb.cptm.GeneralCompany ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompanyLocalityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeneralCompany)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ExpLocalityInv
   * @param value ExpLocalityInv to set
   */

    public void setExpLocalityInv(org.semanticwb.cptm.ExperienceRef value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_ExpLocalityInv, value.getSemanticObject());
        }else
        {
            removeExpLocalityInv();
        }
    }
   /**
   * Remove the value for ExpLocalityInv property
   */

    public void removeExpLocalityInv()
    {
        getSemanticObject().removeProperty(cptm_ExpLocalityInv);
    }

   /**
   * Gets the ExpLocalityInv
   * @return a org.semanticwb.cptm.ExperienceRef
   */
    public org.semanticwb.cptm.ExperienceRef getExpLocalityInv()
    {
         org.semanticwb.cptm.ExperienceRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_ExpLocalityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ExperienceRef)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Longitude property
* @return double with the Longitude
*/
    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(cptm_longitude);
    }

/**
* Sets the Longitude property
* @param value long with the Longitude
*/
    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(cptm_longitude, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.Experience
   * @return A GenericIterator with all the org.semanticwb.cptm.Experience
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> listExperienceLocalityInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience>(getSemanticObject().listObjectProperties(cptm_hasExperienceLocalityInv));
    }

   /**
   * Gets true if has a ExperienceLocalityInv
   * @param value org.semanticwb.cptm.Experience to verify
   * @return true if the org.semanticwb.cptm.Experience exists, false otherwise
   */
    public boolean hasExperienceLocalityInv(org.semanticwb.cptm.Experience value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasExperienceLocalityInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the ExperienceLocalityInv
   * @return a org.semanticwb.cptm.Experience
   */
    public org.semanticwb.cptm.Experience getExperienceLocalityInv()
    {
         org.semanticwb.cptm.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasExperienceLocalityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Experience)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.EditNote
   * @return A GenericIterator with all the org.semanticwb.cptm.EditNote
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> listLocalityEditNoteInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote>(getSemanticObject().listObjectProperties(cptm_hasLocalityEditNoteInv));
    }

   /**
   * Gets true if has a LocalityEditNoteInv
   * @param value org.semanticwb.cptm.EditNote to verify
   * @return true if the org.semanticwb.cptm.EditNote exists, false otherwise
   */
    public boolean hasLocalityEditNoteInv(org.semanticwb.cptm.EditNote value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasLocalityEditNoteInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the LocalityEditNoteInv
   * @return a org.semanticwb.cptm.EditNote
   */
    public org.semanticwb.cptm.EditNote getLocalityEditNoteInv()
    {
         org.semanticwb.cptm.EditNote ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasLocalityEditNoteInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EditNote)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the CPTMWebSite
   * @return a instance of org.semanticwb.cptm.CPTMWebSite
   */
    public org.semanticwb.cptm.CPTMWebSite getCPTMWebSite()
    {
        return (org.semanticwb.cptm.CPTMWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
