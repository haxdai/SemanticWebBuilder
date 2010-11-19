package org.semanticwb.cptm.base;


   /**
   * Clase que se encarga de manejar las rutas de viaje 
   */
public abstract class TravelRouteBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestination");
   /**
   * Clase que se encarga de manejar las rutas de viaje
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelRoute=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRoute");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRoute");

    public static class ClassMgr
    {
       /**
       * Returns a list of TravelRoute for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRoutes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TravelRoute for all models
       * @return Iterator of org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRoutes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TravelRoute
       * @param id Identifier for org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return A org.semanticwb.cptm.TravelRoute
       */
        public static org.semanticwb.cptm.TravelRoute getTravelRoute(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelRoute)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TravelRoute
       * @param id Identifier for org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return A org.semanticwb.cptm.TravelRoute
       */
        public static org.semanticwb.cptm.TravelRoute createTravelRoute(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelRoute)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TravelRoute
       * @param id Identifier for org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       */
        public static void removeTravelRoute(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TravelRoute
       * @param id Identifier for org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return true if the org.semanticwb.cptm.TravelRoute exists, false otherwise
       */

        public static boolean hasTravelRoute(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTravelRoute(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Destination
       * @param value Destination of the type org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByDestination(org.semanticwb.cptm.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestination, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Destination
       * @param value Destination of the type org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByDestination(org.semanticwb.cptm.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestination,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelRoute with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.TravelRoute
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelRoute> listTravelRouteByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TravelRouteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TravelRoute
   */
    public TravelRouteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.Destination
   * @return A GenericIterator with all the org.semanticwb.cptm.Destination
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> listDestinations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination>(getSemanticObject().listObjectProperties(cptm_hasDestination));
    }

   /**
   * Gets true if has a Destination
   * @param value org.semanticwb.cptm.Destination to verify
   * @return true if the org.semanticwb.cptm.Destination exists, false otherwise
   */
    public boolean hasDestination(org.semanticwb.cptm.Destination value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasDestination,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Destination
   * @param value org.semanticwb.cptm.Destination to add
   */

    public void addDestination(org.semanticwb.cptm.Destination value)
    {
        getSemanticObject().addObjectProperty(cptm_hasDestination, value.getSemanticObject());
    }
   /**
   * Removes all the Destination
   */

    public void removeAllDestination()
    {
        getSemanticObject().removeProperty(cptm_hasDestination);
    }
   /**
   * Removes a Destination
   * @param value org.semanticwb.cptm.Destination to remove
   */

    public void removeDestination(org.semanticwb.cptm.Destination value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasDestination,value.getSemanticObject());
    }

   /**
   * Gets the Destination
   * @return a org.semanticwb.cptm.Destination
   */
    public org.semanticwb.cptm.Destination getDestination()
    {
         org.semanticwb.cptm.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasDestination);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Destination)obj.createGenericInstance();
         }
         return ret;
    }
}
