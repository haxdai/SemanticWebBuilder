package org.semanticwb.cptm.base;


   /**
   * Destino turistico en el cual existe infraestructura para hospedarse (Ej. Cancún) 
   */
public abstract class TouristDestinationBase extends org.semanticwb.cptm.Destination implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Punto Geografico en el país (Ej. Chichen itza) , sin llegar a ser un destino turistico (Ej. Cancún)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasGeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasGeographicPoint");
   /**
   * Destino turistico en el cual existe infraestructura para hospedarse (Ej. Cancún)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TouristDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TouristDestination");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TouristDestination");

    public static class ClassMgr
    {
       /**
       * Returns a list of TouristDestination for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TouristDestination for all models
       * @return Iterator of org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TouristDestination
       * @param id Identifier for org.semanticwb.cptm.TouristDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return A org.semanticwb.cptm.TouristDestination
       */
        public static org.semanticwb.cptm.TouristDestination getTouristDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TouristDestination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TouristDestination
       * @param id Identifier for org.semanticwb.cptm.TouristDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return A org.semanticwb.cptm.TouristDestination
       */
        public static org.semanticwb.cptm.TouristDestination createTouristDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TouristDestination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TouristDestination
       * @param id Identifier for org.semanticwb.cptm.TouristDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       */
        public static void removeTouristDestination(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TouristDestination
       * @param id Identifier for org.semanticwb.cptm.TouristDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return true if the org.semanticwb.cptm.TouristDestination exists, false otherwise
       */

        public static boolean hasTouristDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTouristDestination(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByEvent(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByEvent(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByDestinationActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByDestinationActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByDestinationExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByDestinationExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByTravelStyle(org.semanticwb.cptm.TravelStyle value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByTravelStyle(org.semanticwb.cptm.TravelStyle value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByNewDestinationInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByNewDestinationInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined GeographicPoint
       * @param value GeographicPoint of the type org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByGeographicPoint(org.semanticwb.cptm.GeographicPoint value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPoint, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined GeographicPoint
       * @param value GeographicPoint of the type org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPoint,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.TouristDestination
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TouristDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.TouristDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TouristDestination> listTouristDestinationByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TouristDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TouristDestinationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TouristDestination
   */
    public TouristDestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.GeographicPoint
   * @return A GenericIterator with all the org.semanticwb.cptm.GeographicPoint
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> listGeographicPoints()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint>(getSemanticObject().listObjectProperties(cptm_hasGeographicPoint));
    }

   /**
   * Gets true if has a GeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to verify
   * @return true if the org.semanticwb.cptm.GeographicPoint exists, false otherwise
   */
    public boolean hasGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasGeographicPoint,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a GeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to add
   */

    public void addGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        getSemanticObject().addObjectProperty(cptm_hasGeographicPoint, value.getSemanticObject());
    }
   /**
   * Removes all the GeographicPoint
   */

    public void removeAllGeographicPoint()
    {
        getSemanticObject().removeProperty(cptm_hasGeographicPoint);
    }
   /**
   * Removes a GeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to remove
   */

    public void removeGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasGeographicPoint,value.getSemanticObject());
    }

   /**
   * Gets the GeographicPoint
   * @return a org.semanticwb.cptm.GeographicPoint
   */
    public org.semanticwb.cptm.GeographicPoint getGeographicPoint()
    {
         org.semanticwb.cptm.GeographicPoint ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasGeographicPoint);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeographicPoint)obj.createGenericInstance();
         }
         return ret;
    }
}
