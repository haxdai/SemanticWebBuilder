package mx.gob.stps.portalempleo.swb.base;


public abstract class MonthBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.RoleRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Indexable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Rankable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Searchable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.Viewable
{
    public static final org.semanticwb.platform.SemanticClass portalempleo_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Event");
    public static final org.semanticwb.platform.SemanticProperty portalempleo_hasEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.stps.gob.mx/swb4/portalempleo#hasEvent");
    public static final org.semanticwb.platform.SemanticClass portalempleo_Month=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Month");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Month");

    public static class ClassMgr
    {
       /**
       * Returns a list of Month for a model
       * @param model Model to find
       * @return Iterator of mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonths(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month>(it, true);
        }
       /**
       * Returns a list of mx.gob.stps.portalempleo.swb.Month for all models
       * @return Iterator of mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonths()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month>(it, true);
        }
       /**
       * Gets a mx.gob.stps.portalempleo.swb.Month
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Month
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return A mx.gob.stps.portalempleo.swb.Month
       */
        public static mx.gob.stps.portalempleo.swb.Month getMonth(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.stps.portalempleo.swb.Month)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.stps.portalempleo.swb.Month
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Month
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return A mx.gob.stps.portalempleo.swb.Month
       */
        public static mx.gob.stps.portalempleo.swb.Month createMonth(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.stps.portalempleo.swb.Month)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.stps.portalempleo.swb.Month
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Month
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       */
        public static void removeMonth(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.stps.portalempleo.swb.Month
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Month
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return true if the mx.gob.stps.portalempleo.swb.Month exists, false otherwise
       */

        public static boolean hasMonth(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMonth(id, model)!=null);
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Event
       * @param value Event of the type mx.gob.stps.portalempleo.swb.resources.Event
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByEvent(mx.gob.stps.portalempleo.swb.resources.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(portalempleo_hasEvent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Event
       * @param value Event of the type mx.gob.stps.portalempleo.swb.resources.Event
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByEvent(mx.gob.stps.portalempleo.swb.resources.Event value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(portalempleo_hasEvent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Month with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Month
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Month> listMonthByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a MonthBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Month
   */
    public MonthBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the mx.gob.stps.portalempleo.swb.resources.Event
   * @return A GenericIterator with all the mx.gob.stps.portalempleo.swb.resources.Event
   */

    public org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.resources.Event> listEvents()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.resources.Event>(getSemanticObject().listObjectProperties(portalempleo_hasEvent));
    }

   /**
   * Gets true if has a Event
   * @param value mx.gob.stps.portalempleo.swb.resources.Event to verify
   * @return true if the mx.gob.stps.portalempleo.swb.resources.Event exists, false otherwise
   */
    public boolean hasEvent(mx.gob.stps.portalempleo.swb.resources.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(portalempleo_hasEvent,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Event
   * @param value mx.gob.stps.portalempleo.swb.resources.Event to add
   */

    public void addEvent(mx.gob.stps.portalempleo.swb.resources.Event value)
    {
        getSemanticObject().addObjectProperty(portalempleo_hasEvent, value.getSemanticObject());
    }
   /**
   * Removes all the Event
   */

    public void removeAllEvent()
    {
        getSemanticObject().removeProperty(portalempleo_hasEvent);
    }
   /**
   * Removes a Event
   * @param value mx.gob.stps.portalempleo.swb.resources.Event to remove
   */

    public void removeEvent(mx.gob.stps.portalempleo.swb.resources.Event value)
    {
        getSemanticObject().removeObjectProperty(portalempleo_hasEvent,value.getSemanticObject());
    }

   /**
   * Gets the Event
   * @return a mx.gob.stps.portalempleo.swb.resources.Event
   */
    public mx.gob.stps.portalempleo.swb.resources.Event getEvent()
    {
         mx.gob.stps.portalempleo.swb.resources.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(portalempleo_hasEvent);
         if(obj!=null)
         {
             ret=(mx.gob.stps.portalempleo.swb.resources.Event)obj.createGenericInstance();
         }
         return ret;
    }
}
