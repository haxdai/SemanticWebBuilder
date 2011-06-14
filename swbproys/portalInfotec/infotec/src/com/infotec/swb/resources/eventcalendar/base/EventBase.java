package com.infotec.swb.resources.eventcalendar.base;


public abstract class EventBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.UserGroupRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Localeable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Undeleteable,org.semanticwb.model.Countryable,org.semanticwb.model.RuleRefable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Rankable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Searchable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Traceable,org.semanticwb.model.Expirable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.Viewable,org.semanticwb.model.Resourceable
{
   /**
   * Start date
   */
    public static final org.semanticwb.platform.SemanticProperty infotec_start=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx#start");
   /**
   * Fecha final
   */
    public static final org.semanticwb.platform.SemanticProperty infotec_end=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx#end");
   /**
   * Schedule
   */
    public static final org.semanticwb.platform.SemanticProperty infotec_schedule=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx#schedule");
    public static final org.semanticwb.platform.SemanticClass infotec_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx#Event");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx#Event");

    public static class ClassMgr
    {
       /**
       * Returns a list of Event for a model
       * @param model Model to find
       * @return Iterator of com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event>(it, true);
        }
       /**
       * Returns a list of com.infotec.swb.resources.eventcalendar.Event for all models
       * @return Iterator of com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event>(it, true);
        }

        public static com.infotec.swb.resources.eventcalendar.Event createEvent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.swb.resources.eventcalendar.Event.ClassMgr.createEvent(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.swb.resources.eventcalendar.Event
       * @param id Identifier for com.infotec.swb.resources.eventcalendar.Event
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return A com.infotec.swb.resources.eventcalendar.Event
       */
        public static com.infotec.swb.resources.eventcalendar.Event getEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.swb.resources.eventcalendar.Event)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.swb.resources.eventcalendar.Event
       * @param id Identifier for com.infotec.swb.resources.eventcalendar.Event
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return A com.infotec.swb.resources.eventcalendar.Event
       */
        public static com.infotec.swb.resources.eventcalendar.Event createEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.swb.resources.eventcalendar.Event)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.swb.resources.eventcalendar.Event
       * @param id Identifier for com.infotec.swb.resources.eventcalendar.Event
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       */
        public static void removeEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.swb.resources.eventcalendar.Event
       * @param id Identifier for com.infotec.swb.resources.eventcalendar.Event
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return true if the com.infotec.swb.resources.eventcalendar.Event exists, false otherwise
       */

        public static boolean hasEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvent(id, model)!=null);
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the com.infotec.swb.resources.eventcalendar.Event
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.swb.resources.eventcalendar.Event with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the com.infotec.swb.resources.eventcalendar.Event
       */

        public static java.util.Iterator<com.infotec.swb.resources.eventcalendar.Event> listEventByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.swb.resources.eventcalendar.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
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
* Gets the Start property
* @return java.util.Date with the Start
*/
    public java.util.Date getStart()
    {
        return getSemanticObject().getDateProperty(infotec_start);
    }

/**
* Sets the Start property
* @param value long with the Start
*/
    public void setStart(java.util.Date value)
    {
        getSemanticObject().setDateProperty(infotec_start, value);
    }

/**
* Gets the End property
* @return java.util.Date with the End
*/
    public java.util.Date getEnd()
    {
        return getSemanticObject().getDateProperty(infotec_end);
    }

/**
* Sets the End property
* @param value long with the End
*/
    public void setEnd(java.util.Date value)
    {
        getSemanticObject().setDateProperty(infotec_end, value);
    }

/**
* Gets the Schedule property
* @return String with the Schedule
*/
    public String getSchedule()
    {
        return getSemanticObject().getProperty(infotec_schedule);
    }

/**
* Sets the Schedule property
* @param value long with the Schedule
*/
    public void setSchedule(String value)
    {
        getSemanticObject().setProperty(infotec_schedule, value);
    }

   /**
   * Gets the PortalInfotecWebSite
   * @return a instance of com.infotec.swb.PortalInfotecWebSite
   */
    public com.infotec.swb.PortalInfotecWebSite getPortalInfotecWebSite()
    {
        return (com.infotec.swb.PortalInfotecWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
