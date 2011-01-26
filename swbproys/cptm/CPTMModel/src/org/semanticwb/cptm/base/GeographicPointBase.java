package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos. 
   */
public abstract class GeographicPointBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Referensable,org.semanticwb.model.RuleRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Expirable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Viewable,org.semanticwb.model.Indexable,org.semanticwb.model.Rankable,org.semanticwb.model.Searchable,org.semanticwb.cptm.LocalityInt,org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Trashable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Tagable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Resourceable,org.semanticwb.model.CalendarRefable
{
   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_RegionalBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");
   /**
   * En que Regiones se encuentra un Destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasRegGeographicPointInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasRegGeographicPointInv");
   /**
   * Fotos para mostrar del destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestPhotos");
   /**
   * Foto principal para el destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_destPrincipalPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#destPrincipalPhoto");
   /**
   * Clase para administrar tipos de Destinos, pudiendo ser: Destinos, Pueblos Mágicos ó Atractivos
   */
    public static final org.semanticwb.platform.SemanticClass cptm_DestinationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#DestinationType");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestinationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestinationType");
    public static final org.semanticwb.platform.SemanticProperty cptm_destWeather=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#destWeather");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined PromotionInv
       * @param value PromotionInv of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByPromotionInv(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotionInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined PromotionInv
       * @param value PromotionInv of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByPromotionInv(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotionInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByEventGeographicPointInv(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByEventGeographicPointInv(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventGeographicPointInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByNewGeographicPointInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByNewGeographicPointInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined GeographicPointProxInv
       * @param value GeographicPointProxInv of the type org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByGeographicPointProxInv(org.semanticwb.cptm.Proximity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointProxInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined GeographicPointProxInv
       * @param value GeographicPointProxInv of the type org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByGeographicPointProxInv(org.semanticwb.cptm.Proximity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointProxInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RegGeographicPointInv
       * @param value RegGeographicPointInv of the type org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRegGeographicPointInv(org.semanticwb.cptm.RegionalBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined RegGeographicPointInv
       * @param value RegGeographicPointInv of the type org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByRegGeographicPointInv(org.semanticwb.cptm.RegionalBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPointInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ProxGeographicPointInv
       * @param value ProxGeographicPointInv of the type org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByProxGeographicPointInv(org.semanticwb.cptm.Proximity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_proxGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ProxGeographicPointInv
       * @param value ProxGeographicPointInv of the type org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByProxGeographicPointInv(org.semanticwb.cptm.Proximity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_proxGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Proximity
       * @param value Proximity of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByProximity(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasProximity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Proximity
       * @param value Proximity of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByProximity(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasProximity,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationType
       * @param value DestinationType of the type org.semanticwb.cptm.DestinationType
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationType(org.semanticwb.cptm.DestinationType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined DestinationType
       * @param value DestinationType of the type org.semanticwb.cptm.DestinationType
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByDestinationType(org.semanticwb.cptm.DestinationType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasDestinationType,value.getSemanticObject(),sclass));
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
   * Gets all the org.semanticwb.cptm.Promotion
   * @return A GenericIterator with all the org.semanticwb.cptm.Promotion
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> listPromotionInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(getSemanticObject().listObjectProperties(cptm_hasPromotionInv));
    }

   /**
   * Gets true if has a PromotionInv
   * @param value org.semanticwb.cptm.Promotion to verify
   * @return true if the org.semanticwb.cptm.Promotion exists, false otherwise
   */
    public boolean hasPromotionInv(org.semanticwb.cptm.Promotion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasPromotionInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the PromotionInv
   * @return a org.semanticwb.cptm.Promotion
   */
    public org.semanticwb.cptm.Promotion getPromotionInv()
    {
         org.semanticwb.cptm.Promotion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasPromotionInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Promotion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.TravelRoute
   * @return A GenericIterator with all the org.semanticwb.cptm.TravelRoute
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute> listTravelRouteInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.TravelRoute>(getSemanticObject().listObjectProperties(cptm_hasTravelRouteInv));
    }

   /**
   * Gets true if has a TravelRouteInv
   * @param value org.semanticwb.cptm.TravelRoute to verify
   * @return true if the org.semanticwb.cptm.TravelRoute exists, false otherwise
   */
    public boolean hasTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasTravelRouteInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the TravelRouteInv
   * @return a org.semanticwb.cptm.TravelRoute
   */
    public org.semanticwb.cptm.TravelRoute getTravelRouteInv()
    {
         org.semanticwb.cptm.TravelRoute ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasTravelRouteInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.TravelRoute)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Event
   * @return A GenericIterator with all the org.semanticwb.cptm.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> listEventGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(getSemanticObject().listObjectProperties(cptm_hasEventGeographicPointInv));
    }

   /**
   * Gets true if has a EventGeographicPointInv
   * @param value org.semanticwb.cptm.Event to verify
   * @return true if the org.semanticwb.cptm.Event exists, false otherwise
   */
    public boolean hasEventGeographicPointInv(org.semanticwb.cptm.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EventGeographicPointInv
   * @return a org.semanticwb.cptm.Event
   */
    public org.semanticwb.cptm.Event getEventGeographicPointInv()
    {
         org.semanticwb.cptm.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Event)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.New
   * @return A GenericIterator with all the org.semanticwb.cptm.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New> listNewGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New>(getSemanticObject().listObjectProperties(cptm_hasNewGeographicPointInv));
    }

   /**
   * Gets true if has a NewGeographicPointInv
   * @param value org.semanticwb.cptm.New to verify
   * @return true if the org.semanticwb.cptm.New exists, false otherwise
   */
    public boolean hasNewGeographicPointInv(org.semanticwb.cptm.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNewGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewGeographicPointInv
   * @return a org.semanticwb.cptm.New
   */
    public org.semanticwb.cptm.New getNewGeographicPointInv()
    {
         org.semanticwb.cptm.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNewGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.New)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Proximity
   * @return A GenericIterator with all the org.semanticwb.cptm.Proximity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity> listGeographicPointProxInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Proximity>(getSemanticObject().listObjectProperties(cptm_hasGeographicPointProxInv));
    }

   /**
   * Gets true if has a GeographicPointProxInv
   * @param value org.semanticwb.cptm.Proximity to verify
   * @return true if the org.semanticwb.cptm.Proximity exists, false otherwise
   */
    public boolean hasGeographicPointProxInv(org.semanticwb.cptm.Proximity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasGeographicPointProxInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the GeographicPointProxInv
   * @return a org.semanticwb.cptm.Proximity
   */
    public org.semanticwb.cptm.Proximity getGeographicPointProxInv()
    {
         org.semanticwb.cptm.Proximity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasGeographicPointProxInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Proximity)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.RegionalBrand
   * @return A GenericIterator with all the org.semanticwb.cptm.RegionalBrand
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> listRegGeographicPointInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand>(getSemanticObject().listObjectProperties(cptm_hasRegGeographicPointInv));
    }

   /**
   * Gets true if has a RegGeographicPointInv
   * @param value org.semanticwb.cptm.RegionalBrand to verify
   * @return true if the org.semanticwb.cptm.RegionalBrand exists, false otherwise
   */
    public boolean hasRegGeographicPointInv(org.semanticwb.cptm.RegionalBrand value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasRegGeographicPointInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the RegGeographicPointInv
   * @return a org.semanticwb.cptm.RegionalBrand
   */
    public org.semanticwb.cptm.RegionalBrand getRegGeographicPointInv()
    {
         org.semanticwb.cptm.RegionalBrand ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasRegGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.RegionalBrand)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ProxGeographicPointInv
   * @param value ProxGeographicPointInv to set
   */

    public void setProxGeographicPointInv(org.semanticwb.cptm.Proximity value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_proxGeographicPointInv, value.getSemanticObject());
        }else
        {
            removeProxGeographicPointInv();
        }
    }
   /**
   * Remove the value for ProxGeographicPointInv property
   */

    public void removeProxGeographicPointInv()
    {
        getSemanticObject().removeProperty(cptm_proxGeographicPointInv);
    }

   /**
   * Gets the ProxGeographicPointInv
   * @return a org.semanticwb.cptm.Proximity
   */
    public org.semanticwb.cptm.Proximity getProxGeographicPointInv()
    {
         org.semanticwb.cptm.Proximity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_proxGeographicPointInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Proximity)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Latitude property
* @return double with the Latitude
*/
    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(cptm_latitude);
    }

/**
* Sets the Latitude property
* @param value long with the Latitude
*/
    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(cptm_latitude, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listProximities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasProximity));
    }

   /**
   * Gets true if has a Proximity
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasProximity(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasProximity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Proximity
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addProximity(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasProximity, value.getSemanticObject());
    }
   /**
   * Removes all the Proximity
   */

    public void removeAllProximity()
    {
        getSemanticObject().removeProperty(cptm_hasProximity);
    }
   /**
   * Removes a Proximity
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeProximity(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasProximity,value.getSemanticObject());
    }

   /**
   * Gets the Proximity
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getProximity()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasProximity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
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
* Gets the Longitude property
* @return double with the Longitude
*/
    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(cptm_longitude);
    }

/**
* Sets the Longitude property
* @param value long with the Longitude
*/
    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(cptm_longitude, value);
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
   * Gets all the org.semanticwb.cptm.DestinationType
   * @return A GenericIterator with all the org.semanticwb.cptm.DestinationType
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType> listDestinationTypes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.DestinationType>(getSemanticObject().listObjectProperties(cptm_hasDestinationType));
    }

   /**
   * Gets true if has a DestinationType
   * @param value org.semanticwb.cptm.DestinationType to verify
   * @return true if the org.semanticwb.cptm.DestinationType exists, false otherwise
   */
    public boolean hasDestinationType(org.semanticwb.cptm.DestinationType value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasDestinationType,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DestinationType
   * @param value org.semanticwb.cptm.DestinationType to add
   */

    public void addDestinationType(org.semanticwb.cptm.DestinationType value)
    {
        getSemanticObject().addObjectProperty(cptm_hasDestinationType, value.getSemanticObject());
    }
   /**
   * Removes all the DestinationType
   */

    public void removeAllDestinationType()
    {
        getSemanticObject().removeProperty(cptm_hasDestinationType);
    }
   /**
   * Removes a DestinationType
   * @param value org.semanticwb.cptm.DestinationType to remove
   */

    public void removeDestinationType(org.semanticwb.cptm.DestinationType value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasDestinationType,value.getSemanticObject());
    }

   /**
   * Gets the DestinationType
   * @return a org.semanticwb.cptm.DestinationType
   */
    public org.semanticwb.cptm.DestinationType getDestinationType()
    {
         org.semanticwb.cptm.DestinationType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasDestinationType);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.DestinationType)obj.createGenericInstance();
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
