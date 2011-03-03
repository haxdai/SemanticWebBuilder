package mx.gob.stps.portalempleo.swb.base;


public abstract class EventBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.RoleRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Indexable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Rankable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Searchable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.Viewable
{
    public static final org.semanticwb.platform.SemanticClass portalempleo_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Event");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Event");

    public static class ClassMgr
    {
       /**
       * Returns a list of Event for a model
       * @param model Model to find
       * @return Iterator of mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event>(it, true);
        }
       /**
       * Returns a list of mx.gob.stps.portalempleo.swb.Event for all models
       * @return Iterator of mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event>(it, true);
        }

        public static mx.gob.stps.portalempleo.swb.Event createEvent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.stps.portalempleo.swb.Event.ClassMgr.createEvent(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.stps.portalempleo.swb.Event
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Event
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return A mx.gob.stps.portalempleo.swb.Event
       */
        public static mx.gob.stps.portalempleo.swb.Event getEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.stps.portalempleo.swb.Event)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.stps.portalempleo.swb.Event
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Event
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return A mx.gob.stps.portalempleo.swb.Event
       */
        public static mx.gob.stps.portalempleo.swb.Event createEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.stps.portalempleo.swb.Event)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.stps.portalempleo.swb.Event
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Event
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       */
        public static void removeEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.stps.portalempleo.swb.Event
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Event
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return true if the mx.gob.stps.portalempleo.swb.Event exists, false otherwise
       */

        public static boolean hasEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvent(id, model)!=null);
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the mx.gob.stps.portalempleo.swb.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Event with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Event
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Event> listEventByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EventBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Event
   */
    public EventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

   /**
   * Gets the EmpleoWebSite
   * @return a instance of mx.gob.stps.portalempleo.swb.EmpleoWebSite
   */
    public mx.gob.stps.portalempleo.swb.EmpleoWebSite getEmpleoWebSite()
    {
        return (mx.gob.stps.portalempleo.swb.EmpleoWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
