package org.semanticwb.cptm.base;


   /**
   * Marca Regional. La cual puede tener relaciodos Destinos Turisticos y Puntos geográficos (Ej. La Riviera Maya) 
   */
public abstract class RegionalBrandBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Referensable,org.semanticwb.model.RuleRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Expirable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Viewable,org.semanticwb.model.Rankable,org.semanticwb.model.Indexable,org.semanticwb.model.Searchable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Trashable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Tagable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Resourceable,org.semanticwb.model.CalendarRefable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeographicPoint");
   /**
   * Destinos con los que esta conformada la "Marca Regional".Pudiera ser cualaquier subclase de la clase "GeographicPoint"
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasRegGeographicPoint=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasRegGeographicPoint");
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
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegGeographicPoint
       * @param value RegGeographicPoint of the type org.semanticwb.cptm.GeographicPoint
       * @param model Model of the org.semanticwb.cptm.RegionalBrand
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPoint, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.RegionalBrand with a determined RegGeographicPoint
       * @param value RegGeographicPoint of the type org.semanticwb.cptm.GeographicPoint
       * @return Iterator with all the org.semanticwb.cptm.RegionalBrand
       */

        public static java.util.Iterator<org.semanticwb.cptm.RegionalBrand> listRegionalBrandByRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RegionalBrand> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasRegGeographicPoint,value.getSemanticObject(),sclass));
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
   * Gets all the org.semanticwb.cptm.GeographicPoint
   * @return A GenericIterator with all the org.semanticwb.cptm.GeographicPoint
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint> listRegGeographicPoints()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeographicPoint>(getSemanticObject().listObjectProperties(cptm_hasRegGeographicPoint));
    }

   /**
   * Gets true if has a RegGeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to verify
   * @return true if the org.semanticwb.cptm.GeographicPoint exists, false otherwise
   */
    public boolean hasRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasRegGeographicPoint,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a RegGeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to add
   */

    public void addRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        getSemanticObject().addObjectProperty(cptm_hasRegGeographicPoint, value.getSemanticObject());
    }
   /**
   * Removes all the RegGeographicPoint
   */

    public void removeAllRegGeographicPoint()
    {
        getSemanticObject().removeProperty(cptm_hasRegGeographicPoint);
    }
   /**
   * Removes a RegGeographicPoint
   * @param value org.semanticwb.cptm.GeographicPoint to remove
   */

    public void removeRegGeographicPoint(org.semanticwb.cptm.GeographicPoint value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasRegGeographicPoint,value.getSemanticObject());
    }

   /**
   * Gets the RegGeographicPoint
   * @return a org.semanticwb.cptm.GeographicPoint
   */
    public org.semanticwb.cptm.GeographicPoint getRegGeographicPoint()
    {
         org.semanticwb.cptm.GeographicPoint ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasRegGeographicPoint);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeographicPoint)obj.createGenericInstance();
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
