package mx.gob.stps.portalempleo.swb.base;


public abstract class YearBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.RoleRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Indexable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Rankable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Searchable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.Viewable
{
    public static final org.semanticwb.platform.SemanticClass portalempleo_Month=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Month");
    public static final org.semanticwb.platform.SemanticProperty portalempleo_hasMonth=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.stps.gob.mx/swb4/portalempleo#hasMonth");
    public static final org.semanticwb.platform.SemanticClass portalempleo_Year=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Year");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.stps.gob.mx/swb4/portalempleo#Year");

    public static class ClassMgr
    {
       /**
       * Returns a list of Year for a model
       * @param model Model to find
       * @return Iterator of mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYears(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year>(it, true);
        }
       /**
       * Returns a list of mx.gob.stps.portalempleo.swb.Year for all models
       * @return Iterator of mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYears()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year>(it, true);
        }
       /**
       * Gets a mx.gob.stps.portalempleo.swb.Year
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Year
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return A mx.gob.stps.portalempleo.swb.Year
       */
        public static mx.gob.stps.portalempleo.swb.Year getYear(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.stps.portalempleo.swb.Year)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.stps.portalempleo.swb.Year
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Year
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return A mx.gob.stps.portalempleo.swb.Year
       */
        public static mx.gob.stps.portalempleo.swb.Year createYear(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.stps.portalempleo.swb.Year)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.stps.portalempleo.swb.Year
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Year
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       */
        public static void removeYear(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.stps.portalempleo.swb.Year
       * @param id Identifier for mx.gob.stps.portalempleo.swb.Year
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return true if the mx.gob.stps.portalempleo.swb.Year exists, false otherwise
       */

        public static boolean hasYear(String id, org.semanticwb.model.SWBModel model)
        {
            return (getYear(id, model)!=null);
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Month
       * @param value Month of the type mx.gob.stps.portalempleo.swb.Month
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByMonth(mx.gob.stps.portalempleo.swb.Month value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(portalempleo_hasMonth, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Month
       * @param value Month of the type mx.gob.stps.portalempleo.swb.Month
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByMonth(mx.gob.stps.portalempleo.swb.Month value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(portalempleo_hasMonth,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the mx.gob.stps.portalempleo.swb.Year
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.stps.portalempleo.swb.Year with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the mx.gob.stps.portalempleo.swb.Year
       */

        public static java.util.Iterator<mx.gob.stps.portalempleo.swb.Year> listYearByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Year> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a YearBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Year
   */
    public YearBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the mx.gob.stps.portalempleo.swb.Month
   * @return A GenericIterator with all the mx.gob.stps.portalempleo.swb.Month
   */

    public org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month> listMonths()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.stps.portalempleo.swb.Month>(getSemanticObject().listObjectProperties(portalempleo_hasMonth));
    }

   /**
   * Gets true if has a Month
   * @param value mx.gob.stps.portalempleo.swb.Month to verify
   * @return true if the mx.gob.stps.portalempleo.swb.Month exists, false otherwise
   */
    public boolean hasMonth(mx.gob.stps.portalempleo.swb.Month value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(portalempleo_hasMonth,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Month
   * @param value mx.gob.stps.portalempleo.swb.Month to add
   */

    public void addMonth(mx.gob.stps.portalempleo.swb.Month value)
    {
        getSemanticObject().addObjectProperty(portalempleo_hasMonth, value.getSemanticObject());
    }
   /**
   * Removes all the Month
   */

    public void removeAllMonth()
    {
        getSemanticObject().removeProperty(portalempleo_hasMonth);
    }
   /**
   * Removes a Month
   * @param value mx.gob.stps.portalempleo.swb.Month to remove
   */

    public void removeMonth(mx.gob.stps.portalempleo.swb.Month value)
    {
        getSemanticObject().removeObjectProperty(portalempleo_hasMonth,value.getSemanticObject());
    }

   /**
   * Gets the Month
   * @return a mx.gob.stps.portalempleo.swb.Month
   */
    public mx.gob.stps.portalempleo.swb.Month getMonth()
    {
         mx.gob.stps.portalempleo.swb.Month ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(portalempleo_hasMonth);
         if(obj!=null)
         {
             ret=(mx.gob.stps.portalempleo.swb.Month)obj.createGenericInstance();
         }
         return ret;
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
