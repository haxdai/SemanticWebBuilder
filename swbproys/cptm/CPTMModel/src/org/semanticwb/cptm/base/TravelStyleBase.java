package org.semanticwb.cptm.base;


   /**
   * Clase que se encarga del catalogo de "Estilos de Viaje" 
   */
public abstract class TravelStyleBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.RuleRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable,org.semanticwb.model.Rankable,org.semanticwb.model.Indexable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Localeable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Traceable,org.semanticwb.model.FilterableClass,org.semanticwb.model.FilterableNode,org.semanticwb.model.Resourceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Viewable,org.semanticwb.model.Tagable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Searchable,org.semanticwb.model.Activeable,org.semanticwb.model.Expirable
{
   /**
   * Clase que se encarga del catalogo de "Estilos de Viaje"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyle");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyle");

    public static class ClassMgr
    {
       /**
       * Returns a list of TravelStyle for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TravelStyle for all models
       * @return Iterator of org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TravelStyle
       * @param id Identifier for org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return A org.semanticwb.cptm.TravelStyle
       */
        public static org.semanticwb.cptm.TravelStyle getTravelStyle(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelStyle)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TravelStyle
       * @param id Identifier for org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return A org.semanticwb.cptm.TravelStyle
       */
        public static org.semanticwb.cptm.TravelStyle createTravelStyle(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelStyle)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TravelStyle
       * @param id Identifier for org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       */
        public static void removeTravelStyle(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TravelStyle
       * @param id Identifier for org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return true if the org.semanticwb.cptm.TravelStyle exists, false otherwise
       */

        public static boolean hasTravelStyle(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTravelStyle(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyle with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.TravelStyle
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyle> listTravelStyleByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TravelStyleBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TravelStyle
   */
    public TravelStyleBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
