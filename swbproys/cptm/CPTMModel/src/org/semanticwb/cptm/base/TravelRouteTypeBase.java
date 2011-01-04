package org.semanticwb.cptm.base;


public abstract class TravelRouteTypeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Localeable,org.semanticwb.model.Rankable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Expirable,org.semanticwb.model.Activeable,org.semanticwb.model.Referensable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Tagable,org.semanticwb.model.Searchable,org.semanticwb.model.FilterableClass
{
    public static final org.semanticwb.platform.SemanticClass cptm_TravelRouteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRouteType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRouteType");

    public static class ClassMgr
    {
       /**
       * Returns a list of TravelRouteType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TravelRouteType for all models
       * @return Iterator of org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TravelRouteType
       * @param id Identifier for org.semanticwb.cptm.TravelRouteType
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return A org.semanticwb.cptm.TravelRouteType
       */
        public static org.semanticwb.cptm.TravelRouteType getTravelRouteType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelRouteType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TravelRouteType
       * @param id Identifier for org.semanticwb.cptm.TravelRouteType
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return A org.semanticwb.cptm.TravelRouteType
       */
        public static org.semanticwb.cptm.TravelRouteType createTravelRouteType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelRouteType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TravelRouteType
       * @param id Identifier for org.semanticwb.cptm.TravelRouteType
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       */
        public static void removeTravelRouteType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TravelRouteType
       * @param id Identifier for org.semanticwb.cptm.TravelRouteType
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return true if the org.semanticwb.cptm.TravelRouteType exists, false otherwise
       */

        public static boolean hasTravelRouteType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTravelRouteType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.TravelRouteType
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRouteType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.TravelRouteType
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRouteType> listTravelRouteTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRouteType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TravelRouteTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TravelRouteType
   */
    public TravelRouteTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
