package org.semanticwb.pymtur.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de tipos de eventos. 
   */
public abstract class EventTypeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de tipos de eventos.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#EventType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#EventType");

    public static class ClassMgr
    {
       /**
       * Returns a list of EventType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.EventType for all models
       * @return Iterator of org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.EventType
       * @param id Identifier for org.semanticwb.pymtur.EventType
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return A org.semanticwb.pymtur.EventType
       */
        public static org.semanticwb.pymtur.EventType getEventType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.EventType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.EventType
       * @param id Identifier for org.semanticwb.pymtur.EventType
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return A org.semanticwb.pymtur.EventType
       */
        public static org.semanticwb.pymtur.EventType createEventType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.EventType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.EventType
       * @param id Identifier for org.semanticwb.pymtur.EventType
       * @param model Model of the org.semanticwb.pymtur.EventType
       */
        public static void removeEventType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.EventType
       * @param id Identifier for org.semanticwb.pymtur.EventType
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return true if the org.semanticwb.pymtur.EventType exists, false otherwise
       */

        public static boolean hasEventType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEventType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.EventType
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.EventType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.EventType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.EventType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EventTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EventType
   */
    public EventTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
