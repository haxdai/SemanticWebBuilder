package org.semanticwb.cptm.base;


   /**
   * Estilo de Viaje en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class TravelStyleDestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");
    public static final org.semanticwb.platform.SemanticProperty cptm_TravelStyleDestinationProp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleDestinationProp");
   /**
   * Estilo de Viaje en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelStyleDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleDestination");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleDestination");

    public static class ClassMgr
    {
       /**
       * Returns a list of TravelStyleDestination for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.TravelStyleDestination for all models
       * @return Iterator of org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.TravelStyleDestination
       * @param id Identifier for org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return A org.semanticwb.cptm.TravelStyleDestination
       */
        public static org.semanticwb.cptm.TravelStyleDestination getTravelStyleDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelStyleDestination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.TravelStyleDestination
       * @param id Identifier for org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return A org.semanticwb.cptm.TravelStyleDestination
       */
        public static org.semanticwb.cptm.TravelStyleDestination createTravelStyleDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.TravelStyleDestination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.TravelStyleDestination
       * @param id Identifier for org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       */
        public static void removeTravelStyleDestination(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.TravelStyleDestination
       * @param id Identifier for org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return true if the org.semanticwb.cptm.TravelStyleDestination exists, false otherwise
       */

        public static boolean hasTravelStyleDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTravelStyleDestination(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined TravelStyleDestinationProp
       * @param value TravelStyleDestinationProp of the type org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByTravelStyleDestinationProp(org.semanticwb.cptm.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationProp, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined TravelStyleDestinationProp
       * @param value TravelStyleDestinationProp of the type org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByTravelStyleDestinationProp(org.semanticwb.cptm.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationProp,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.TravelStyleDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.TravelStyleDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.TravelStyleDestination> listTravelStyleDestinationByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyleDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TravelStyleDestinationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TravelStyleDestination
   */
    public TravelStyleDestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property TravelStyleDestinationProp
   * @param value TravelStyleDestinationProp to set
   */

    public void setTravelStyleDestinationProp(org.semanticwb.cptm.Destination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_TravelStyleDestinationProp, value.getSemanticObject());
        }else
        {
            removeTravelStyleDestinationProp();
        }
    }
   /**
   * Remove the value for TravelStyleDestinationProp property
   */

    public void removeTravelStyleDestinationProp()
    {
        getSemanticObject().removeProperty(cptm_TravelStyleDestinationProp);
    }

   /**
   * Gets the TravelStyleDestinationProp
   * @return a org.semanticwb.cptm.Destination
   */
    public org.semanticwb.cptm.Destination getTravelStyleDestinationProp()
    {
         org.semanticwb.cptm.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_TravelStyleDestinationProp);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Destination)obj.createGenericInstance();
         }
         return ret;
    }
}
