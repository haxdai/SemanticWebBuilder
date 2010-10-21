package org.semanticwb.pymtur.base;


   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Giros. 
   */
public abstract class SPCategoryBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Tagable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Localeable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable,org.semanticwb.model.Viewable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Expirable,org.semanticwb.model.RuleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RoleRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Referensable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Searchable,org.semanticwb.model.Resourceable,org.semanticwb.model.Rankable,org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.model.Indexable,org.semanticwb.model.PFlowRefable
{
   /**
   * Clase que que encarga de administrar instalaciones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
   /**
   * Instalaciones que estan asignadas a un cierto Giro, se asignan en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCategoryInstalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCategoryInstalation");
   /**
   * Clase en la que se agregan instancias de tipo Rate, para que alguna  sea asignada a un giro especifico por parte de un administrador.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_RateType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateType");
   /**
   * Tipo de clase de tarifas (ej. Hospedaje, Alimentos) que esta asignada al Giro, se asigna en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCategoryRateType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCategoryRateType");
   /**
   * Clase que se encarga de administrar servicios del catalogo
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
   /**
   * Servicios que estan asignados a un cierto Giro, se asignan en la administración
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCategoryService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCategoryService");
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Giros.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_SPCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPCategory");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPCategory");

    public static class ClassMgr
    {
       /**
       * Returns a list of SPCategory for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.SPCategory for all models
       * @return Iterator of org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.SPCategory
       * @param id Identifier for org.semanticwb.pymtur.SPCategory
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return A org.semanticwb.pymtur.SPCategory
       */
        public static org.semanticwb.pymtur.SPCategory getSPCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.SPCategory)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.SPCategory
       * @param id Identifier for org.semanticwb.pymtur.SPCategory
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return A org.semanticwb.pymtur.SPCategory
       */
        public static org.semanticwb.pymtur.SPCategory createSPCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.SPCategory)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.SPCategory
       * @param id Identifier for org.semanticwb.pymtur.SPCategory
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       */
        public static void removeSPCategory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.SPCategory
       * @param id Identifier for org.semanticwb.pymtur.SPCategory
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return true if the org.semanticwb.pymtur.SPCategory exists, false otherwise
       */

        public static boolean hasSPCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSPCategory(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined CategoryInstalation
       * @param value CategoryInstalation of the type org.semanticwb.pymtur.Instalation
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCategoryInstalation(org.semanticwb.pymtur.Instalation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCategoryInstalation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined CategoryInstalation
       * @param value CategoryInstalation of the type org.semanticwb.pymtur.Instalation
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCategoryInstalation(org.semanticwb.pymtur.Instalation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCategoryInstalation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined CategoryService
       * @param value CategoryService of the type org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCategoryService(org.semanticwb.pymtur.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCategoryService, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined CategoryService
       * @param value CategoryService of the type org.semanticwb.pymtur.Service
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByCategoryService(org.semanticwb.pymtur.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCategoryService,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.SPCategory with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.SPCategory
       */

        public static java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategoryByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.SPCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SPCategoryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SPCategory
   */
    public SPCategoryBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.pymtur.Instalation
   * @return A GenericIterator with all the org.semanticwb.pymtur.Instalation
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation> listCategoryInstalations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation>(getSemanticObject().listObjectProperties(pymtur_hasCategoryInstalation));
    }

   /**
   * Gets true if has a CategoryInstalation
   * @param value org.semanticwb.pymtur.Instalation to verify
   * @return true if the org.semanticwb.pymtur.Instalation exists, false otherwise
   */
    public boolean hasCategoryInstalation(org.semanticwb.pymtur.Instalation value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasCategoryInstalation,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CategoryInstalation
   * @param value org.semanticwb.pymtur.Instalation to add
   */

    public void addCategoryInstalation(org.semanticwb.pymtur.Instalation value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasCategoryInstalation, value.getSemanticObject());
    }
   /**
   * Removes all the CategoryInstalation
   */

    public void removeAllCategoryInstalation()
    {
        getSemanticObject().removeProperty(pymtur_hasCategoryInstalation);
    }
   /**
   * Removes a CategoryInstalation
   * @param value org.semanticwb.pymtur.Instalation to remove
   */

    public void removeCategoryInstalation(org.semanticwb.pymtur.Instalation value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasCategoryInstalation,value.getSemanticObject());
    }

   /**
   * Gets the CategoryInstalation
   * @return a org.semanticwb.pymtur.Instalation
   */
    public org.semanticwb.pymtur.Instalation getCategoryInstalation()
    {
         org.semanticwb.pymtur.Instalation ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasCategoryInstalation);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Instalation)obj.createGenericInstance();
         }
         return ret;
    }

    public void setSpCategoryRateType(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(pymtur_spCategoryRateType, value);
    }

    public void removeSpCategoryRateType()
    {
        getSemanticObject().removeProperty(pymtur_spCategoryRateType);
    }

/**
* Gets the SpCategoryRateType property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getSpCategoryRateType()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(pymtur_spCategoryRateType);
         return ret;
    }
   /**
   * Gets all the org.semanticwb.pymtur.Service
   * @return A GenericIterator with all the org.semanticwb.pymtur.Service
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> listCategoryServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service>(getSemanticObject().listObjectProperties(pymtur_hasCategoryService));
    }

   /**
   * Gets true if has a CategoryService
   * @param value org.semanticwb.pymtur.Service to verify
   * @return true if the org.semanticwb.pymtur.Service exists, false otherwise
   */
    public boolean hasCategoryService(org.semanticwb.pymtur.Service value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasCategoryService,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CategoryService
   * @param value org.semanticwb.pymtur.Service to add
   */

    public void addCategoryService(org.semanticwb.pymtur.Service value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasCategoryService, value.getSemanticObject());
    }
   /**
   * Removes all the CategoryService
   */

    public void removeAllCategoryService()
    {
        getSemanticObject().removeProperty(pymtur_hasCategoryService);
    }
   /**
   * Removes a CategoryService
   * @param value org.semanticwb.pymtur.Service to remove
   */

    public void removeCategoryService(org.semanticwb.pymtur.Service value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasCategoryService,value.getSemanticObject());
    }

   /**
   * Gets the CategoryService
   * @return a org.semanticwb.pymtur.Service
   */
    public org.semanticwb.pymtur.Service getCategoryService()
    {
         org.semanticwb.pymtur.Service ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasCategoryService);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Service)obj.createGenericInstance();
         }
         return ret;
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
