package org.semanticwb.pymtur.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos. 
   */
public abstract class DestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable
{
   /**
   * Clase que se encarga de administrar tipos de turismo
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_TourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#TourismType");
   /**
   * Tipos de turismo que estan asignados a un cierto destino, se asignan en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasTourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasTourismType");
   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
   /**
   * Inversa.Mediante esta se puede saber que mipymes se encuentran en un destino
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestServiceProviderInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Event");
   /**
   * Eventos que estan asignados a un cierto destino, se asignan en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasEvent");
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Actividades.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
   /**
   * Actividades con las que cuenta un destino, estas se asignan desde el administrador
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestinationActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestinationActivity");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Experience");
   /**
   * Experiencias que estan asignadas a un cierto destino, se asignan en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestinationExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestinationExperience");
   /**
   * Fotos para mostrar del destino
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestPhotos");
   /**
   * Foto principal para el destino
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_destPrincipalPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destPrincipalPhoto");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");

    public static class ClassMgr
    {
       /**
       * Returns a list of Destination for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Destination for all models
       * @return Iterator of org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.Destination
       * @param id Identifier for org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return A org.semanticwb.pymtur.Destination
       */
        public static org.semanticwb.pymtur.Destination getDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Destination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Destination
       * @param id Identifier for org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return A org.semanticwb.pymtur.Destination
       */
        public static org.semanticwb.pymtur.Destination createDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Destination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Destination
       * @param id Identifier for org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.Destination
       */
        public static void removeDestination(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Destination
       * @param id Identifier for org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return true if the org.semanticwb.pymtur.Destination exists, false otherwise
       */

        public static boolean hasDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDestination(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined TourismType
       * @param value TourismType of the type org.semanticwb.pymtur.TourismType
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTourismType(org.semanticwb.pymtur.TourismType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasTourismType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined TourismType
       * @param value TourismType of the type org.semanticwb.pymtur.TourismType
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTourismType(org.semanticwb.pymtur.TourismType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasTourismType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ServiceProvider
       * @param value ServiceProvider of the type org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByServiceProvider(org.semanticwb.pymtur.ServiceProvider value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestServiceProviderInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ServiceProvider
       * @param value ServiceProvider of the type org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestServiceProviderInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Event
       * @param value Event of the type org.semanticwb.pymtur.Event
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByEvent(org.semanticwb.pymtur.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEvent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Event
       * @param value Event of the type org.semanticwb.pymtur.Event
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByEvent(org.semanticwb.pymtur.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEvent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.pymtur.Activity
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationActivity(org.semanticwb.pymtur.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.pymtur.Activity
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationActivity(org.semanticwb.pymtur.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.pymtur.Experience
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationExperience(org.semanticwb.pymtur.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.pymtur.Experience
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationExperience(org.semanticwb.pymtur.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Destination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.Destination
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DestinationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Destination
   */
    public DestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.pymtur.TourismType
   * @return A GenericIterator with all the org.semanticwb.pymtur.TourismType
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> listTourismTypes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType>(getSemanticObject().listObjectProperties(pymtur_hasTourismType));
    }

   /**
   * Gets true if has a TourismType
   * @param value org.semanticwb.pymtur.TourismType to verify
   * @return true if the org.semanticwb.pymtur.TourismType exists, false otherwise
   */
    public boolean hasTourismType(org.semanticwb.pymtur.TourismType value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasTourismType,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a TourismType
   * @param value org.semanticwb.pymtur.TourismType to add
   */

    public void addTourismType(org.semanticwb.pymtur.TourismType value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasTourismType, value.getSemanticObject());
    }
   /**
   * Removes all the TourismType
   */

    public void removeAllTourismType()
    {
        getSemanticObject().removeProperty(pymtur_hasTourismType);
    }
   /**
   * Removes a TourismType
   * @param value org.semanticwb.pymtur.TourismType to remove
   */

    public void removeTourismType(org.semanticwb.pymtur.TourismType value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasTourismType,value.getSemanticObject());
    }

   /**
   * Gets the TourismType
   * @return a org.semanticwb.pymtur.TourismType
   */
    public org.semanticwb.pymtur.TourismType getTourismType()
    {
         org.semanticwb.pymtur.TourismType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasTourismType);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.TourismType)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.ServiceProvider
   * @return A GenericIterator with all the org.semanticwb.pymtur.ServiceProvider
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(getSemanticObject().listObjectProperties(pymtur_hasDestServiceProviderInv));
    }

   /**
   * Gets true if has a ServiceProvider
   * @param value org.semanticwb.pymtur.ServiceProvider to verify
   * @return true if the org.semanticwb.pymtur.ServiceProvider exists, false otherwise
   */
    public boolean hasServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestServiceProviderInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the ServiceProvider
   * @return a org.semanticwb.pymtur.ServiceProvider
   */
    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestServiceProviderInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.Event
   * @return A GenericIterator with all the org.semanticwb.pymtur.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> listEvents()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event>(getSemanticObject().listObjectProperties(pymtur_hasEvent));
    }

   /**
   * Gets true if has a Event
   * @param value org.semanticwb.pymtur.Event to verify
   * @return true if the org.semanticwb.pymtur.Event exists, false otherwise
   */
    public boolean hasEvent(org.semanticwb.pymtur.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasEvent,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Event
   * @param value org.semanticwb.pymtur.Event to add
   */

    public void addEvent(org.semanticwb.pymtur.Event value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasEvent, value.getSemanticObject());
    }
   /**
   * Removes all the Event
   */

    public void removeAllEvent()
    {
        getSemanticObject().removeProperty(pymtur_hasEvent);
    }
   /**
   * Removes a Event
   * @param value org.semanticwb.pymtur.Event to remove
   */

    public void removeEvent(org.semanticwb.pymtur.Event value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasEvent,value.getSemanticObject());
    }

   /**
   * Gets the Event
   * @return a org.semanticwb.pymtur.Event
   */
    public org.semanticwb.pymtur.Event getEvent()
    {
         org.semanticwb.pymtur.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasEvent);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Event)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.Activity
   * @return A GenericIterator with all the org.semanticwb.pymtur.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity> listDestinationActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity>(getSemanticObject().listObjectProperties(pymtur_hasDestinationActivity));
    }

   /**
   * Gets true if has a DestinationActivity
   * @param value org.semanticwb.pymtur.Activity to verify
   * @return true if the org.semanticwb.pymtur.Activity exists, false otherwise
   */
    public boolean hasDestinationActivity(org.semanticwb.pymtur.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestinationActivity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DestinationActivity
   * @param value org.semanticwb.pymtur.Activity to add
   */

    public void addDestinationActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasDestinationActivity, value.getSemanticObject());
    }
   /**
   * Removes all the DestinationActivity
   */

    public void removeAllDestinationActivity()
    {
        getSemanticObject().removeProperty(pymtur_hasDestinationActivity);
    }
   /**
   * Removes a DestinationActivity
   * @param value org.semanticwb.pymtur.Activity to remove
   */

    public void removeDestinationActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasDestinationActivity,value.getSemanticObject());
    }

   /**
   * Gets the DestinationActivity
   * @return a org.semanticwb.pymtur.Activity
   */
    public org.semanticwb.pymtur.Activity getDestinationActivity()
    {
         org.semanticwb.pymtur.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestinationActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Activity)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.Experience
   * @return A GenericIterator with all the org.semanticwb.pymtur.Experience
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Experience> listDestinationExperiences()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Experience>(getSemanticObject().listObjectProperties(pymtur_hasDestinationExperience));
    }

   /**
   * Gets true if has a DestinationExperience
   * @param value org.semanticwb.pymtur.Experience to verify
   * @return true if the org.semanticwb.pymtur.Experience exists, false otherwise
   */
    public boolean hasDestinationExperience(org.semanticwb.pymtur.Experience value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestinationExperience,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DestinationExperience
   * @param value org.semanticwb.pymtur.Experience to add
   */

    public void addDestinationExperience(org.semanticwb.pymtur.Experience value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasDestinationExperience, value.getSemanticObject());
    }
   /**
   * Removes all the DestinationExperience
   */

    public void removeAllDestinationExperience()
    {
        getSemanticObject().removeProperty(pymtur_hasDestinationExperience);
    }
   /**
   * Removes a DestinationExperience
   * @param value org.semanticwb.pymtur.Experience to remove
   */

    public void removeDestinationExperience(org.semanticwb.pymtur.Experience value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasDestinationExperience,value.getSemanticObject());
    }

   /**
   * Gets the DestinationExperience
   * @return a org.semanticwb.pymtur.Experience
   */
    public org.semanticwb.pymtur.Experience getDestinationExperience()
    {
         org.semanticwb.pymtur.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestinationExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Experience)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Iterator<String> listDestPhotoses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(pymtur_hasDestPhotos);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addDestPhotos(String value)
    {
        getSemanticObject().addLiteralProperty(pymtur_hasDestPhotos, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllDestPhotos()
    {
        getSemanticObject().removeProperty(pymtur_hasDestPhotos);
    }

    public void removeDestPhotos(String value)
    {
        getSemanticObject().removeProperty(pymtur_hasDestPhotos,value);
    }

/**
* Gets the DestPrincipalPhoto property
* @return String with the DestPrincipalPhoto
*/
    public String getDestPrincipalPhoto()
    {
        return getSemanticObject().getProperty(pymtur_destPrincipalPhoto);
    }

/**
* Sets the DestPrincipalPhoto property
* @param value long with the DestPrincipalPhoto
*/
    public void setDestPrincipalPhoto(String value)
    {
        getSemanticObject().setProperty(pymtur_destPrincipalPhoto, value);
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
