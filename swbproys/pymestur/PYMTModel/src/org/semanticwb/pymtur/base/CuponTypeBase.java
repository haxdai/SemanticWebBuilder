package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar tipos de cupones 
   */
public abstract class CuponTypeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable
{
   /**
   * Opcional : Propiedad con la que hace que se guarden las imagenes del cupon
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCuponPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCuponPhotos");
   /**
   * Clase que se encarga de administrar tipos de cupones
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_CuponType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CuponType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CuponType");

    public static class ClassMgr
    {
       /**
       * Returns a list of CuponType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.CuponType for all models
       * @return Iterator of org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.CuponType
       * @param id Identifier for org.semanticwb.pymtur.CuponType
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return A org.semanticwb.pymtur.CuponType
       */
        public static org.semanticwb.pymtur.CuponType getCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.CuponType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.CuponType
       * @param id Identifier for org.semanticwb.pymtur.CuponType
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return A org.semanticwb.pymtur.CuponType
       */
        public static org.semanticwb.pymtur.CuponType createCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.CuponType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.CuponType
       * @param id Identifier for org.semanticwb.pymtur.CuponType
       * @param model Model of the org.semanticwb.pymtur.CuponType
       */
        public static void removeCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.CuponType
       * @param id Identifier for org.semanticwb.pymtur.CuponType
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return true if the org.semanticwb.pymtur.CuponType exists, false otherwise
       */

        public static boolean hasCuponType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCuponType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.CuponType
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.CuponType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.CuponType
       */

        public static java.util.Iterator<org.semanticwb.pymtur.CuponType> listCuponTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.CuponType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CuponTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CuponType
   */
    public CuponTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Iterator<String> listCuponPhotoses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(pymtur_hasCuponPhotos);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addCuponPhotos(String value)
    {
        getSemanticObject().addLiteralProperty(pymtur_hasCuponPhotos, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllCuponPhotos()
    {
        getSemanticObject().removeProperty(pymtur_hasCuponPhotos);
    }

    public void removeCuponPhotos(String value)
    {
        getSemanticObject().removeProperty(pymtur_hasCuponPhotos,value);
    }
}
