package org.semanticwb.cptm.base;


   /**
   * Punto Geografico en el país (Ej. Chichen itza) , sin llegar a ser un destino turistico (Ej. Cancún) 
   */
public abstract class AttractiveBase extends org.semanticwb.cptm.GeographicPoint implements org.semanticwb.model.RuleRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.cptm.LocalityInt,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable,org.semanticwb.model.Rankable,org.semanticwb.model.Indexable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Localeable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Traceable,org.semanticwb.model.FilterableNode,org.semanticwb.model.FilterableClass,org.semanticwb.model.Resourceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Viewable,org.semanticwb.model.Tagable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Searchable,org.semanticwb.model.Activeable,org.semanticwb.model.Expirable
{
   /**
   * Punto Geografico en el país (Ej. Chichen itza) , sin llegar a ser un destino turistico (Ej. Cancún)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Attractive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Attractive");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Attractive");

    public static class ClassMgr
    {
       /**
       * Returns a list of Attractive for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractives(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Attractive for all models
       * @return Iterator of org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractives()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Attractive
       * @param id Identifier for org.semanticwb.cptm.Attractive
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return A org.semanticwb.cptm.Attractive
       */
        public static org.semanticwb.cptm.Attractive getAttractive(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Attractive)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Attractive
       * @param id Identifier for org.semanticwb.cptm.Attractive
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return A org.semanticwb.cptm.Attractive
       */
        public static org.semanticwb.cptm.Attractive createAttractive(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Attractive)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Attractive
       * @param id Identifier for org.semanticwb.cptm.Attractive
       * @param model Model of the org.semanticwb.cptm.Attractive
       */
        public static void removeAttractive(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Attractive
       * @param id Identifier for org.semanticwb.cptm.Attractive
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return true if the org.semanticwb.cptm.Attractive exists, false otherwise
       */

        public static boolean hasAttractive(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAttractive(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined PromotionInv
       * @param value PromotionInv of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByPromotionInv(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotionInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined PromotionInv
       * @param value PromotionInv of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByPromotionInv(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotionInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByTravelRouteInv(org.semanticwb.cptm.TravelRoute value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined TravelRouteInv
       * @param value TravelRouteInv of the type org.semanticwb.cptm.TravelRoute
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByTravelRouteInv(org.semanticwb.cptm.TravelRoute value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasTravelRouteInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByNewGeographicPointInv(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined NewGeographicPointInv
       * @param value NewGeographicPointInv of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByNewGeographicPointInv(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNewGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined GeographicPointProxInv
       * @param value GeographicPointProxInv of the type org.semanticwb.cptm.Proximity
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByGeographicPointProxInv(org.semanticwb.cptm.Proximity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointProxInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined GeographicPointProxInv
       * @param value GeographicPointProxInv of the type org.semanticwb.cptm.Proximity
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByGeographicPointProxInv(org.semanticwb.cptm.Proximity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasGeographicPointProxInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined RegGeographicPointInv
       * @param value RegGeographicPointInv of the type org.semanticwb.cptm.RegionalBrand
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByRegGeographicPointInv(org.semanticwb.cptm.RegionalBrand value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined RegGeographicPointInv
       * @param value RegGeographicPointInv of the type org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByRegGeographicPointInv(org.semanticwb.cptm.RegionalBrand value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByEventGeographicPointInv(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_eventGeographicPointInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined EventGeographicPointInv
       * @param value EventGeographicPointInv of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByEventGeographicPointInv(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_eventGeographicPointInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.Attractive
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Attractive with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.Attractive
       */

        public static java.util.Iterator<org.semanticwb.cptm.Attractive> listAttractiveByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Attractive> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AttractiveBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Attractive
   */
    public AttractiveBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
