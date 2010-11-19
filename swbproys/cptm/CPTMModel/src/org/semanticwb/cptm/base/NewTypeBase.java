package org.semanticwb.cptm.base;


   /**
   * Catalogo de Tipos de Noticias 
   */
public abstract class NewTypeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Catálogo de Noticias
   */
    public static final org.semanticwb.platform.SemanticClass cptm_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#New");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNew=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNew");
   /**
   * Catalogo de Tipos de Noticias
   */
    public static final org.semanticwb.platform.SemanticClass cptm_NewType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#NewType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#NewType");

    public static class ClassMgr
    {
       /**
       * Returns a list of NewType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.NewType for all models
       * @return Iterator of org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.NewType
       * @param id Identifier for org.semanticwb.cptm.NewType
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return A org.semanticwb.cptm.NewType
       */
        public static org.semanticwb.cptm.NewType getNewType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.NewType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.NewType
       * @param id Identifier for org.semanticwb.cptm.NewType
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return A org.semanticwb.cptm.NewType
       */
        public static org.semanticwb.cptm.NewType createNewType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.NewType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.NewType
       * @param id Identifier for org.semanticwb.cptm.NewType
       * @param model Model of the org.semanticwb.cptm.NewType
       */
        public static void removeNewType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.NewType
       * @param id Identifier for org.semanticwb.cptm.NewType
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return true if the org.semanticwb.cptm.NewType exists, false otherwise
       */

        public static boolean hasNewType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNewType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined New
       * @param value New of the type org.semanticwb.cptm.New
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByNew(org.semanticwb.cptm.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNew, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined New
       * @param value New of the type org.semanticwb.cptm.New
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByNew(org.semanticwb.cptm.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNew,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.NewType
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.NewType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.NewType
       */

        public static java.util.Iterator<org.semanticwb.cptm.NewType> listNewTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a NewTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the NewType
   */
    public NewTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.New
   * @return A GenericIterator with all the org.semanticwb.cptm.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New> listNews()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.New>(getSemanticObject().listObjectProperties(cptm_hasNew));
    }

   /**
   * Gets true if has a New
   * @param value org.semanticwb.cptm.New to verify
   * @return true if the org.semanticwb.cptm.New exists, false otherwise
   */
    public boolean hasNew(org.semanticwb.cptm.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNew,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a New
   * @param value org.semanticwb.cptm.New to add
   */

    public void addNew(org.semanticwb.cptm.New value)
    {
        getSemanticObject().addObjectProperty(cptm_hasNew, value.getSemanticObject());
    }
   /**
   * Removes all the New
   */

    public void removeAllNew()
    {
        getSemanticObject().removeProperty(cptm_hasNew);
    }
   /**
   * Removes a New
   * @param value org.semanticwb.cptm.New to remove
   */

    public void removeNew(org.semanticwb.cptm.New value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasNew,value.getSemanticObject());
    }

   /**
   * Gets the New
   * @return a org.semanticwb.cptm.New
   */
    public org.semanticwb.cptm.New getNew()
    {
         org.semanticwb.cptm.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNew);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.New)obj.createGenericInstance();
         }
         return ret;
    }
}
