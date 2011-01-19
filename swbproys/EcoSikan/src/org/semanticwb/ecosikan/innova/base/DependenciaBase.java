package org.semanticwb.ecosikan.innova.base;


public abstract class DependenciaBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Searchable,org.semanticwb.model.Trashable,org.semanticwb.model.Tagable,org.semanticwb.model.Localeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Referensable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Rankable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Viewable,org.semanticwb.model.Hiddenable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Resourceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable
{
    public static final org.semanticwb.platform.SemanticProperty ecoskn_image=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#image");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Dependencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Dependencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Dependencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Dependencia for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Dependencia for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia>(it, true);
        }

        public static org.semanticwb.ecosikan.innova.Dependencia createDependencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.ecosikan.innova.Dependencia.ClassMgr.createDependencia(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Dependencia
       * @param id Identifier for org.semanticwb.ecosikan.innova.Dependencia
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return A org.semanticwb.ecosikan.innova.Dependencia
       */
        public static org.semanticwb.ecosikan.innova.Dependencia getDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Dependencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Dependencia
       * @param id Identifier for org.semanticwb.ecosikan.innova.Dependencia
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return A org.semanticwb.ecosikan.innova.Dependencia
       */
        public static org.semanticwb.ecosikan.innova.Dependencia createDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Dependencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Dependencia
       * @param id Identifier for org.semanticwb.ecosikan.innova.Dependencia
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       */
        public static void removeDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Dependencia
       * @param id Identifier for org.semanticwb.ecosikan.innova.Dependencia
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return true if the org.semanticwb.ecosikan.innova.Dependencia exists, false otherwise
       */

        public static boolean hasDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDependencia(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.ecosikan.innova.Dependencia
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Dependencia with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Dependencia> listDependenciaByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DependenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Dependencia
   */
    public DependenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Image property
* @return String with the Image
*/
    public String getImage()
    {
        return getSemanticObject().getProperty(ecoskn_image);
    }

/**
* Sets the Image property
* @param value long with the Image
*/
    public void setImage(String value)
    {
        getSemanticObject().setProperty(ecoskn_image, value);
    }

   /**
   * Gets the BorraSite
   * @return a instance of org.semanticwb.ecosikan.innova.BorraSite
   */
    public org.semanticwb.ecosikan.innova.BorraSite getBorraSite()
    {
        return (org.semanticwb.ecosikan.innova.BorraSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
