package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos. 
   */
public abstract class DestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Estilo de Viaje en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelStyleDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleDestination");
   /**
   * Es removeDependency = true, ya que quiero que si se elimina el destino también se elimine el TravelStyleDestination, y Nunca al reves
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_TravelStyleDestinationPropInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyleDestinationPropInv");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceDestination");
   /**
   * Es removeDependency = true, ya que quiero que si se elimina el destino también se elimine el ExperienceDestination, y Nunca al reves
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasExperienceDestinationPropInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasExperienceDestinationPropInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");
   /**
   * Eventos que estan asignados a un cierto destino, se asignan en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEvent");
   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_RegionalBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");
   /**
   * En que Regiones se encuentra un Destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasRegDestinationInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasRegDestinationInv");
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
   /**
   * Actividades con las que cuenta un destino, estas se asignan desde el administrador
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestinationActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestinationActivity");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityDestination");
   /**
   * Es removeDependency = true, ya que quiero que si se elimina el destino también se elimine el ActivityDestination, y Nunca al reves
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasActivityDestinationPropInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasActivityDestinationPropInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestinationExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestinationExperience");
   /**
   * Clase que se encarga de manejar las rutas de viaje
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelRoute=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelRoute");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestinationTravelRouteInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestinationTravelRouteInv");
   /**
   * Fotos para mostrar del destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestPhotos");
   /**
   * Clase que se encarga del catalogo de "Estilos de Viaje"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_TravelStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#TravelStyle");
   /**
   * Clase que se encarga de manejar el catalogo de "Estilos de Viaje"
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasTravelStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasTravelStyle");
   /**
   * Foto principal para el destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_destPrincipalPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#destPrincipalPhoto");
   /**
   * Catálogo de Noticias
   */
    public static final org.semanticwb.platform.SemanticClass cptm_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#New");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNewDestinationInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNewDestinationInv");
   /**
   * Evento en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EventDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EventDestination");
   /**
   * Es removeDependency = true, ya que quiero que si se elimina el destino también se elimine el EvetDestination, y Nunca al reves
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_EventDestinationPropInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#EventDestinationPropInv");
    public static final org.semanticwb.platform.SemanticProperty cptm_destWeather=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#destWeather");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");

    public static class ClassMgr
    {
       /**
       * Returns a list of Destination for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Destination for all models
       * @return Iterator of org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Destination
       * @param id Identifier for org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return A org.semanticwb.cptm.Destination
       */
        public static org.semanticwb.cptm.Destination getDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Destination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Destination
       * @param id Identifier for org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return A org.semanticwb.cptm.Destination
       */
        public static org.semanticwb.cptm.Destination createDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Destination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Destination
       * @param id Identifier for org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.Destination
       */
        public static void removeDestination(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Destination
       * @param id Identifier for org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return true if the org.semanticwb.cptm.Destination exists, false otherwise
       */

        public static boolean hasDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDestination(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined TravelStyleDestinationPropInv
       * @param value TravelStyleDestinationPropInv of the type org.semanticwb.cptm.TravelStyleDestination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_TravelStyleDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ExperienceDestinationPropInv
       * @param value ExperienceDestinationPropInv of the type org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByEvent(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Event
       * @param value Event of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByEvent(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEvent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined RegDestinationInv
       * @param value RegDestinationInv of the type org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByRegDestinationInv(org.semanticwb.cptm.RegionalBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByDestinationActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined DestinationActivity
       * @param value DestinationActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByDestinationActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ActivityDestinationPropInv
       * @param value ActivityDestinationPropInv of the type org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActivityDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByDestinationExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined DestinationExperience
       * @param value DestinationExperience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByDestinationExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined DestinationTravelRouteInv
       * @param value DestinationTravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByTravelStyle(org.semanticwb.cptm.TravelStyle value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined TravelStyle
       * @param value TravelStyle of the type org.semanticwb.cptm.TravelStyle
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByTravelStyle(org.semanticwb.cptm.TravelStyle value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelStyle,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByNewDestinationInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined NewDestinationInv
       * @param value NewDestinationInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByNewDestinationInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewDestinationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined EventDestinationPropInv
       * @param value EventDestinationPropInv of the type org.semanticwb.cptm.EventDestination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByEventDestinationPropInv(org.semanticwb.cptm.EventDestination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_EventDestinationPropInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Destination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.Destination
       */

        public static java.util.Iterator<org.semanticwb.cptm.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Destination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
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
   * Sets the value for the property TravelStyleDestinationPropInv
   * @param value TravelStyleDestinationPropInv to set
   */

    public void setTravelStyleDestinationPropInv(org.semanticwb.cptm.TravelStyleDestination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_TravelStyleDestinationPropInv, value.getSemanticObject());
        }else
        {
            removeTravelStyleDestinationPropInv();
        }
    }
   /**
   * Remove the value for TravelStyleDestinationPropInv property
   */

    public void removeTravelStyleDestinationPropInv()
    {
        getSemanticObject().removeProperty(cptm_TravelStyleDestinationPropInv);
    }

   /**
   * Gets the TravelStyleDestinationPropInv
   * @return a org.semanticwb.cptm.TravelStyleDestination
   */
    public org.semanticwb.cptm.TravelStyleDestination getTravelStyleDestinationPropInv()
    {
         org.semanticwb.cptm.TravelStyleDestination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_TravelStyleDestinationPropInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelStyleDestination)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.ExperienceDestination
   * @return A GenericIterator with all the org.semanticwb.cptm.ExperienceDestination
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationPropInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination>(getSemanticObject().listObjectProperties(cptm_hasExperienceDestinationPropInv));
    }

   /**
   * Gets true if has a ExperienceDestinationPropInv
   * @param value org.semanticwb.cptm.ExperienceDestination to verify
   * @return true if the org.semanticwb.cptm.ExperienceDestination exists, false otherwise
   */
    public boolean hasExperienceDestinationPropInv(org.semanticwb.cptm.ExperienceDestination value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasExperienceDestinationPropInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the ExperienceDestinationPropInv
   * @return a org.semanticwb.cptm.ExperienceDestination
   */
    public org.semanticwb.cptm.ExperienceDestination getExperienceDestinationPropInv()
    {
         org.semanticwb.cptm.ExperienceDestination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasExperienceDestinationPropInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ExperienceDestination)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Event
   * @return A GenericIterator with all the org.semanticwb.cptm.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> listEvents()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(getSemanticObject().listObjectProperties(cptm_hasEvent));
    }

   /**
   * Gets true if has a Event
   * @param value org.semanticwb.cptm.Event to verify
   * @return true if the org.semanticwb.cptm.Event exists, false otherwise
   */
    public boolean hasEvent(org.semanticwb.cptm.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEvent,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Event
   * @param value org.semanticwb.cptm.Event to add
   */

    public void addEvent(org.semanticwb.cptm.Event value)
    {
        getSemanticObject().addObjectProperty(cptm_hasEvent, value.getSemanticObject());
    }
   /**
   * Removes all the Event
   */

    public void removeAllEvent()
    {
        getSemanticObject().removeProperty(cptm_hasEvent);
    }
   /**
   * Removes a Event
   * @param value org.semanticwb.cptm.Event to remove
   */

    public void removeEvent(org.semanticwb.cptm.Event value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasEvent,value.getSemanticObject());
    }

   /**
   * Gets the Event
   * @return a org.semanticwb.cptm.Event
   */
    public org.semanticwb.cptm.Event getEvent()
    {
         org.semanticwb.cptm.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEvent);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Event)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.RegionalBrand
   * @return A GenericIterator with all the org.semanticwb.cptm.RegionalBrand
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> listRegDestinationInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand>(getSemanticObject().listObjectProperties(cptm_hasRegDestinationInv));
    }

   /**
   * Gets true if has a RegDestinationInv
   * @param value org.semanticwb.cptm.RegionalBrand to verify
   * @return true if the org.semanticwb.cptm.RegionalBrand exists, false otherwise
   */
    public boolean hasRegDestinationInv(org.semanticwb.cptm.RegionalBrand value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasRegDestinationInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the RegDestinationInv
   * @return a org.semanticwb.cptm.RegionalBrand
   */
    public org.semanticwb.cptm.RegionalBrand getRegDestinationInv()
    {
         org.semanticwb.cptm.RegionalBrand ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasRegDestinationInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.RegionalBrand)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Activity
   * @return A GenericIterator with all the org.semanticwb.cptm.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> listDestinationActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(getSemanticObject().listObjectProperties(cptm_hasDestinationActivity));
    }

   /**
   * Gets true if has a DestinationActivity
   * @param value org.semanticwb.cptm.Activity to verify
   * @return true if the org.semanticwb.cptm.Activity exists, false otherwise
   */
    public boolean hasDestinationActivity(org.semanticwb.cptm.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasDestinationActivity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DestinationActivity
   * @param value org.semanticwb.cptm.Activity to add
   */

    public void addDestinationActivity(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().addObjectProperty(cptm_hasDestinationActivity, value.getSemanticObject());
    }
   /**
   * Removes all the DestinationActivity
   */

    public void removeAllDestinationActivity()
    {
        getSemanticObject().removeProperty(cptm_hasDestinationActivity);
    }
   /**
   * Removes a DestinationActivity
   * @param value org.semanticwb.cptm.Activity to remove
   */

    public void removeDestinationActivity(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasDestinationActivity,value.getSemanticObject());
    }

   /**
   * Gets the DestinationActivity
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getDestinationActivity()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasDestinationActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.ActivityDestination
   * @return A GenericIterator with all the org.semanticwb.cptm.ActivityDestination
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationPropInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination>(getSemanticObject().listObjectProperties(cptm_hasActivityDestinationPropInv));
    }

   /**
   * Gets true if has a ActivityDestinationPropInv
   * @param value org.semanticwb.cptm.ActivityDestination to verify
   * @return true if the org.semanticwb.cptm.ActivityDestination exists, false otherwise
   */
    public boolean hasActivityDestinationPropInv(org.semanticwb.cptm.ActivityDestination value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasActivityDestinationPropInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the ActivityDestinationPropInv
   * @return a org.semanticwb.cptm.ActivityDestination
   */
    public org.semanticwb.cptm.ActivityDestination getActivityDestinationPropInv()
    {
         org.semanticwb.cptm.ActivityDestination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasActivityDestinationPropInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ActivityDestination)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Experience
   * @return A GenericIterator with all the org.semanticwb.cptm.Experience
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> listDestinationExperiences()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience>(getSemanticObject().listObjectProperties(cptm_hasDestinationExperience));
    }

   /**
   * Gets true if has a DestinationExperience
   * @param value org.semanticwb.cptm.Experience to verify
   * @return true if the org.semanticwb.cptm.Experience exists, false otherwise
   */
    public boolean hasDestinationExperience(org.semanticwb.cptm.Experience value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasDestinationExperience,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DestinationExperience
   * @param value org.semanticwb.cptm.Experience to add
   */

    public void addDestinationExperience(org.semanticwb.cptm.Experience value)
    {
        getSemanticObject().addObjectProperty(cptm_hasDestinationExperience, value.getSemanticObject());
    }
   /**
   * Removes all the DestinationExperience
   */

    public void removeAllDestinationExperience()
    {
        getSemanticObject().removeProperty(cptm_hasDestinationExperience);
    }
   /**
   * Removes a DestinationExperience
   * @param value org.semanticwb.cptm.Experience to remove
   */

    public void removeDestinationExperience(org.semanticwb.cptm.Experience value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasDestinationExperience,value.getSemanticObject());
    }

   /**
   * Gets the DestinationExperience
   * @return a org.semanticwb.cptm.Experience
   */
    public org.semanticwb.cptm.Experience getDestinationExperience()
    {
         org.semanticwb.cptm.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasDestinationExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Experience)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.TravelRoute
   * @return A GenericIterator with all the org.semanticwb.cptm.TravelRoute
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> listDestinationTravelRouteInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute>(getSemanticObject().listObjectProperties(cptm_hasDestinationTravelRouteInv));
    }

   /**
   * Gets true if has a DestinationTravelRouteInv
   * @param value org.semanticwb.cptm.TravelRoute to verify
   * @return true if the org.semanticwb.cptm.TravelRoute exists, false otherwise
   */
    public boolean hasDestinationTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasDestinationTravelRouteInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the DestinationTravelRouteInv
   * @return a org.semanticwb.cptm.TravelRoute
   */
    public org.semanticwb.cptm.TravelRoute getDestinationTravelRouteInv()
    {
         org.semanticwb.cptm.TravelRoute ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasDestinationTravelRouteInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelRoute)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Iterator<String> listDestPhotoses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(cptm_hasDestPhotos);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addDestPhotos(String value)
    {
        getSemanticObject().addLiteralProperty(cptm_hasDestPhotos, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllDestPhotos()
    {
        getSemanticObject().removeProperty(cptm_hasDestPhotos);
    }

    public void removeDestPhotos(String value)
    {
        getSemanticObject().removeLiteralProperty(cptm_hasDestPhotos,new org.semanticwb.platform.SemanticLiteral(value));
    }
   /**
   * Gets all the org.semanticwb.cptm.TravelStyle
   * @return A GenericIterator with all the org.semanticwb.cptm.TravelStyle
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle> listTravelStyles()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelStyle>(getSemanticObject().listObjectProperties(cptm_hasTravelStyle));
    }

   /**
   * Gets true if has a TravelStyle
   * @param value org.semanticwb.cptm.TravelStyle to verify
   * @return true if the org.semanticwb.cptm.TravelStyle exists, false otherwise
   */
    public boolean hasTravelStyle(org.semanticwb.cptm.TravelStyle value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasTravelStyle,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a TravelStyle
   * @param value org.semanticwb.cptm.TravelStyle to add
   */

    public void addTravelStyle(org.semanticwb.cptm.TravelStyle value)
    {
        getSemanticObject().addObjectProperty(cptm_hasTravelStyle, value.getSemanticObject());
    }
   /**
   * Removes all the TravelStyle
   */

    public void removeAllTravelStyle()
    {
        getSemanticObject().removeProperty(cptm_hasTravelStyle);
    }
   /**
   * Removes a TravelStyle
   * @param value org.semanticwb.cptm.TravelStyle to remove
   */

    public void removeTravelStyle(org.semanticwb.cptm.TravelStyle value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasTravelStyle,value.getSemanticObject());
    }

   /**
   * Gets the TravelStyle
   * @return a org.semanticwb.cptm.TravelStyle
   */
    public org.semanticwb.cptm.TravelStyle getTravelStyle()
    {
         org.semanticwb.cptm.TravelStyle ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasTravelStyle);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelStyle)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DestPrincipalPhoto property
* @return String with the DestPrincipalPhoto
*/
    public String getDestPrincipalPhoto()
    {
        return getSemanticObject().getProperty(cptm_destPrincipalPhoto);
    }

/**
* Sets the DestPrincipalPhoto property
* @param value long with the DestPrincipalPhoto
*/
    public void setDestPrincipalPhoto(String value)
    {
        getSemanticObject().setProperty(cptm_destPrincipalPhoto, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.New
   * @return A GenericIterator with all the org.semanticwb.cptm.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New> listNewDestinationInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New>(getSemanticObject().listObjectProperties(cptm_hasNewDestinationInv));
    }

   /**
   * Gets true if has a NewDestinationInv
   * @param value org.semanticwb.cptm.New to verify
   * @return true if the org.semanticwb.cptm.New exists, false otherwise
   */
    public boolean hasNewDestinationInv(org.semanticwb.cptm.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNewDestinationInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewDestinationInv
   * @return a org.semanticwb.cptm.New
   */
    public org.semanticwb.cptm.New getNewDestinationInv()
    {
         org.semanticwb.cptm.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNewDestinationInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.New)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EventDestinationPropInv
   * @param value EventDestinationPropInv to set
   */

    public void setEventDestinationPropInv(org.semanticwb.cptm.EventDestination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_EventDestinationPropInv, value.getSemanticObject());
        }else
        {
            removeEventDestinationPropInv();
        }
    }
   /**
   * Remove the value for EventDestinationPropInv property
   */

    public void removeEventDestinationPropInv()
    {
        getSemanticObject().removeProperty(cptm_EventDestinationPropInv);
    }

   /**
   * Gets the EventDestinationPropInv
   * @return a org.semanticwb.cptm.EventDestination
   */
    public org.semanticwb.cptm.EventDestination getEventDestinationPropInv()
    {
         org.semanticwb.cptm.EventDestination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_EventDestinationPropInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EventDestination)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DestWeather property
* @return String with the DestWeather
*/
    public String getDestWeather()
    {
        return getSemanticObject().getProperty(cptm_destWeather);
    }

/**
* Sets the DestWeather property
* @param value long with the DestWeather
*/
    public void setDestWeather(String value)
    {
        getSemanticObject().setProperty(cptm_destWeather, value);
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
