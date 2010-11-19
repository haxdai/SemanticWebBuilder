package org.semanticwb.cptm.base;


   /**
   * Punto Geografico en el país (Ej. Chichen itza) , sin llegar a ser un destino turistico (Ej. Cancún) 
   */
public abstract class GeographicPointBase extends org.semanticwb.cptm.Destination implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Destino turistico en el cual existe infraestructura para hospedarse (Ej. Cancún)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TouristDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TouristDestination");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasGeographicPointInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasGeographicPointInv");
   /**
   * Punto Geografico en el país (Ej. Chichen itza) , sin llegar a ser un destino turistico (Ej. Cancún)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");

    public static class ClassMgr
    {
       /**
       * Returns a list of GeographicPoint for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPoints(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.GeographicPoint for all models
       * @return Iterator of org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPoints()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.GeographicPoint
       * @param id Identifier for org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return A org.semanticwb.cptm.GeographicPoint
       */
        public static org.semanticwb.cptm.GeographicPoint getGeographicPoint(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.GeographicPoint)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.GeographicPoint
       * @param id Identifier for org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return A org.semanticwb.cptm.GeographicPoint
       */
        public static org.semanticwb.cptm.GeographicPoint createGeographicPoint(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.GeographicPoint)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.GeographicPoint
       * @param id Identifier for org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       */
        public static void removeGeographicPoint(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.GeographicPoint
       * @param id Identifier for org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return true if the org.semanticwb.cptm.GeographicPoint exists, false otherwise
       */

        public static boolean hasGeographicPoint(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGeographicPoint(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByEvent(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByEvent(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTravelStyle(org.semanticwb.cptm.TravelStyle value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTravelStyle(org.semanticwb.cptm.TravelStyle value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined GeographicPointInv
       * @param value GeographicPointInv of the type org.semanticwb.cptm.TouristDestination
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByGeographicPointInv(org.semanticwb.cptm.TouristDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined GeographicPointInv
       * @param value GeographicPointInv of the type org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByGeographicPointInv(org.semanticwb.cptm.TouristDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByNewDestinationInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByNewDestinationInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GeographicPointBase with a SemanticObject
   * @param base The SemanticObject with the properties for the GeographicPoint
   */
    public GeographicPointBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.TouristDestination
   * @return A GenericIterator with all the org.semanticwb.cptm.TouristDestination
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> listGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination>(getSemanticObject().listObjectProperties(cptm_hasGeographicPointInv));
    }

   /**
   * Gets true if has a GeographicPointInv
   * @param value org.semanticwb.cptm.TouristDestination to verify
   * @return true if the org.semanticwb.cptm.TouristDestination exists, false otherwise
   */
    public boolean hasGeographicPointInv(org.semanticwb.cptm.TouristDestination value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the GeographicPointInv
   * @return a org.semanticwb.cptm.TouristDestination
   */
    public org.semanticwb.cptm.TouristDestination getGeographicPointInv()
    {
         org.semanticwb.cptm.TouristDestination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TouristDestination)obj.createGenericInstance();
         }
         return ret;
    }
}
