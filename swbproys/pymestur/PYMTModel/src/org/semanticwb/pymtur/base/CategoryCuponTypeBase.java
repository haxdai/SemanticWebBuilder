package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar tipos de cupones (catálogo)  de acuerdo a cierta categoría 
   */
public abstract class CategoryCuponTypeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Tagable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Localeable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable,org.semanticwb.model.Viewable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Expirable,org.semanticwb.model.RuleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RoleRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Referensable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Searchable,org.semanticwb.model.Resourceable,org.semanticwb.model.Rankable,org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.model.Indexable,org.semanticwb.model.PFlowRefable
{
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Giros.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_SPCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPCategory");
   /**
   * Selección del giro al que va dirigido un determinado tipo de cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_categoryCupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#categoryCupon");
   /**
   * Clase que se encarga de administrar tipos de cupones (catálogo)  de acuerdo a cierta categoría
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_CategoryCuponType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CategoryCuponType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CategoryCuponType");

    public static class ClassMgr
    {
       /**
       * Returns a list of CategoryCuponType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.CategoryCuponType for all models
       * @return Iterator of org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.CategoryCuponType
       * @param id Identifier for org.semanticwb.pymtur.CategoryCuponType
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return A org.semanticwb.pymtur.CategoryCuponType
       */
        public static org.semanticwb.pymtur.CategoryCuponType getCategoryCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.CategoryCuponType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.CategoryCuponType
       * @param id Identifier for org.semanticwb.pymtur.CategoryCuponType
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return A org.semanticwb.pymtur.CategoryCuponType
       */
        public static org.semanticwb.pymtur.CategoryCuponType createCategoryCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.CategoryCuponType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.CategoryCuponType
       * @param id Identifier for org.semanticwb.pymtur.CategoryCuponType
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       */
        public static void removeCategoryCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.CategoryCuponType
       * @param id Identifier for org.semanticwb.pymtur.CategoryCuponType
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return true if the org.semanticwb.pymtur.CategoryCuponType exists, false otherwise
       */

        public static boolean hasCategoryCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCategoryCuponType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined CategoryCupon
       * @param value CategoryCupon of the type org.semanticwb.pymtur.SPCategory
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByCategoryCupon(org.semanticwb.pymtur.SPCategory value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_categoryCupon, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined CategoryCupon
       * @param value CategoryCupon of the type org.semanticwb.pymtur.SPCategory
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByCategoryCupon(org.semanticwb.pymtur.SPCategory value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_categoryCupon,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.CategoryCuponType
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CategoryCuponType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.CategoryCuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CategoryCuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CategoryCuponTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CategoryCuponType
   */
    public CategoryCuponTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property CategoryCupon
   * @param value CategoryCupon to set
   */

    public void setCategoryCupon(org.semanticwb.pymtur.SPCategory value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_categoryCupon, value.getSemanticObject());
        }else
        {
            removeCategoryCupon();
        }
    }
   /**
   * Remove the value for CategoryCupon property
   */

    public void removeCategoryCupon()
    {
        getSemanticObject().removeProperty(pymtur_categoryCupon);
    }

   /**
   * Gets the CategoryCupon
   * @return a org.semanticwb.pymtur.SPCategory
   */
    public org.semanticwb.pymtur.SPCategory getCategoryCupon()
    {
         org.semanticwb.pymtur.SPCategory ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_categoryCupon);
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
