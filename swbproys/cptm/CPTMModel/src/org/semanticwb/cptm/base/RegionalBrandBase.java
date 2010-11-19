package org.semanticwb.cptm.base;


   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya) 
   */
public abstract class RegionalBrandBase extends org.semanticwb.cptm.Destination implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");
   /**
   * Destinos con los que esta conformada la "Marca Regional".Pudiera ser cualaquier subclase de la clase "Destino"
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasRegDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasRegDestination");
   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_RegionalBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");

    public static class ClassMgr
    {
       /**
       * Returns a list of RegionalBrand for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrands(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.RegionalBrand for all models
       * @return Iterator of org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrands()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return A org.semanticwb.cptm.RegionalBrand
       */
        public static org.semanticwb.cptm.RegionalBrand getRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.RegionalBrand)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return A org.semanticwb.cptm.RegionalBrand
       */
        public static org.semanticwb.cptm.RegionalBrand createRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.RegionalBrand)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       */
        public static void removeRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.RegionalBrand
       * @param id Identifier for org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return true if the org.semanticwb.cptm.RegionalBrand exists, false otherwise
       */

        public static boolean hasRegionalBrand(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRegionalBrand(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegDestination
       * @param value RegDestination of the type org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegDestination(org.semanticwb.cptm.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestination, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegDestination
       * @param value RegDestination of the type org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegDestination(org.semanticwb.cptm.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestination,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByEvent(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByEvent(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByDestinationActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByDestinationActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByDestinationExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByDestinationExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTravelStyle(org.semanticwb.cptm.TravelStyle value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByTravelStyle(org.semanticwb.cptm.TravelStyle value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByNewDestinationInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByNewDestinationInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a RegionalBrandBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RegionalBrand
   */
    public RegionalBrandBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.Destination
   * @return A GenericIterator with all the org.semanticwb.cptm.Destination
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> listRegDestinations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination>(getSemanticObject().listObjectProperties(cptm_hasRegDestination));
    }

   /**
   * Gets true if has a RegDestination
   * @param value org.semanticwb.cptm.Destination to verify
   * @return true if the org.semanticwb.cptm.Destination exists, false otherwise
   */
    public boolean hasRegDestination(org.semanticwb.cptm.Destination value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasRegDestination,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RegDestination
   * @param value org.semanticwb.cptm.Destination to add
   */

    public void addRegDestination(org.semanticwb.cptm.Destination value)
    {
        getSemanticObject().addObjectProperty(cptm_hasRegDestination, value.getSemanticObject());
    }
   /**
   * Removes all the RegDestination
   */

    public void removeAllRegDestination()
    {
        getSemanticObject().removeProperty(cptm_hasRegDestination);
    }
   /**
   * Removes a RegDestination
   * @param value org.semanticwb.cptm.Destination to remove
   */

    public void removeRegDestination(org.semanticwb.cptm.Destination value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasRegDestination,value.getSemanticObject());
    }

   /**
   * Gets the RegDestination
   * @return a org.semanticwb.cptm.Destination
   */
    public org.semanticwb.cptm.Destination getRegDestination()
    {
         org.semanticwb.cptm.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasRegDestination);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Destination)obj.createGenericInstance();
         }
         return ret;
    }
}
