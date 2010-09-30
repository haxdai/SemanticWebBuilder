package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar tipos de promociones de acuerdo a cierta categoría 
   */
public abstract class CategoryPromotionTypeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Expirable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable
{
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Giros.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_SPCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPCategory");
   /**
   * Selección del giro al que va dirigido un determinado tipo de promoción
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_categoryPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#categoryPromotion");
   /**
   * Clase que se encarga de administrar tipos de promociones de acuerdo a cierta categoría
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_CategoryPromotionType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CategoryPromotionType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CategoryPromotionType");

    public static class ClassMgr
    {
       /**
       * Returns a list of CategoryPromotionType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.CategoryPromotionType for all models
       * @return Iterator of org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.CategoryPromotionType
       * @param id Identifier for org.semanticwb.pymtur.CategoryPromotionType
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return A org.semanticwb.pymtur.CategoryPromotionType
       */
        public static org.semanticwb.pymtur.CategoryPromotionType getCategoryPromotionType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.CategoryPromotionType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.CategoryPromotionType
       * @param id Identifier for org.semanticwb.pymtur.CategoryPromotionType
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return A org.semanticwb.pymtur.CategoryPromotionType
       */
        public static org.semanticwb.pymtur.CategoryPromotionType createCategoryPromotionType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.CategoryPromotionType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.CategoryPromotionType
       * @param id Identifier for org.semanticwb.pymtur.CategoryPromotionType
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       */
        public static void removeCategoryPromotionType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.CategoryPromotionType
       * @param id Identifier for org.semanticwb.pymtur.CategoryPromotionType
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return true if the org.semanticwb.pymtur.CategoryPromotionType exists, false otherwise
       */

        public static boolean hasCategoryPromotionType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCategoryPromotionType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined CategoryPromotion
       * @param value CategoryPromotion of the type org.semanticwb.pymtur.SPCategory
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByCategoryPromotion(org.semanticwb.pymtur.SPCategory value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_categoryPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined CategoryPromotion
       * @param value CategoryPromotion of the type org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByCategoryPromotion(org.semanticwb.pymtur.SPCategory value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_categoryPromotion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.CategoryPromotionType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryPromotionType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.CategoryPromotionType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryPromotionType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CategoryPromotionTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CategoryPromotionType
   */
    public CategoryPromotionTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property CategoryPromotion
   * @param value CategoryPromotion to set
   */

    public void setCategoryPromotion(org.semanticwb.pymtur.SPCategory value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_categoryPromotion, value.getSemanticObject());
        }else
        {
            removeCategoryPromotion();
        }
    }
   /**
   * Remove the value for CategoryPromotion property
   */

    public void removeCategoryPromotion()
    {
        getSemanticObject().removeProperty(pymtur_categoryPromotion);
    }

   /**
   * Gets the CategoryPromotion
   * @return a org.semanticwb.pymtur.SPCategory
   */
    public org.semanticwb.pymtur.SPCategory getCategoryPromotion()
    {
         org.semanticwb.pymtur.SPCategory ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_categoryPromotion);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.SPCategory)obj.createGenericInstance();
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
