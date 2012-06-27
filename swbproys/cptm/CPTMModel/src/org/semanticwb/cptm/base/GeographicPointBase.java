package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Puntos Geográficos (Cancun, Tampico, etc) 
   */
public abstract class GeographicPointBase extends org.semanticwb.cptm.CPTMWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.cptm.Videoable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.model.RuleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.cptm.LocalityInt,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable
{
    public static final org.semanticwb.platform.SemanticProperty cptm_destWeather=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#destWeather");
   /**
   * Clase para administrar tipos de Destinos, pudiendo ser: Destinos, Pueblos Mágicos ó Atractivos
   */
    public static final org.semanticwb.platform.SemanticClass cptm_DestinationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#DestinationType");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasDestinationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasDestinationType");
   /**
   * Catálogo de Marcas Regionales (Ej. Riviera Maya, Riviera Nayarit, etc). Estos contienen Puntos Geográficos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_RegionalBrand=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RegionalBrand");
   /**
   * En que Regiones se encuentra un Destino
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasRegGeographicPointInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasRegGeographicPointInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Puntos Geográficos (Cancun, Tampico, etc)
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ActLocalityInv
       * @param value ActLocalityInv of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByActLocalityInv(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ActLocalityInv
       * @param value ActLocalityInv of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByActLocalityInv(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActLocalityInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ArefLocalityInv
       * @param value ArefLocalityInv of the type org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByArefLocalityInv(org.semanticwb.cptm.ActivityRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ArefLocalityInv
       * @param value ArefLocalityInv of the type org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByArefLocalityInv(org.semanticwb.cptm.ActivityRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocalityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined GeneralAttribute
       * @param value GeneralAttribute of the type org.semanticwb.cptm.GeneralAttractive
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeneralAttribute, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined GeneralAttribute
       * @param value GeneralAttribute of the type org.semanticwb.cptm.GeneralAttractive
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByGeneralAttribute(org.semanticwb.cptm.GeneralAttractive value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeneralAttribute,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined CompanyLocalityInv
       * @param value CompanyLocalityInv of the type org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCompanyLocalityInv(org.semanticwb.cptm.GeneralCompany value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined CompanyLocalityInv
       * @param value CompanyLocalityInv of the type org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCompanyLocalityInv(org.semanticwb.cptm.GeneralCompany value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLocalityInv,value.getSemanticObject(),sclass));
            return it;
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ExpLocalityInv
       * @param value ExpLocalityInv of the type org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByExpLocalityInv(org.semanticwb.cptm.ExperienceRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ExpLocalityInv
       * @param value ExpLocalityInv of the type org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByExpLocalityInv(org.semanticwb.cptm.ExperienceRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocalityInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ExperienceLocalityInv
       * @param value ExperienceLocalityInv of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByExperienceLocalityInv(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceLocalityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined ExperienceLocalityInv
       * @param value ExperienceLocalityInv of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByExperienceLocalityInv(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExperienceLocalityInv,value.getSemanticObject(),sclass));
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
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined LocalityEditNoteInv
       * @param value LocalityEditNoteInv of the type org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByLocalityEditNoteInv(org.semanticwb.cptm.EditNote value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityEditNoteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeographicPoint with a determined LocalityEditNoteInv
       * @param value LocalityEditNoteInv of the type org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.GeographicPoint
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeographicPoint> listGeographicPointByLocalityEditNoteInv(org.semanticwb.cptm.EditNote value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocalityEditNoteInv,value.getSemanticObject(),sclass));
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
   * Gets the CPTMWebSite
   * @return a instance of org.semanticwb.cptm.CPTMWebSite
   */
    public org.semanticwb.cptm.CPTMWebSite getCPTMWebSite()
    {
        return (org.semanticwb.cptm.CPTMWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
