package org.semanticwb.pymtur.base;


   /**
   * Clase que hereda de WebPage.Mediante esta se administran las variantes en cuanto a diseño (CSS) que tiene cada tipo de plantilla (PaqTemplate). 
   */
public abstract class VariantPaqTemplateBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Expirable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable
{
   /**
   * Estilo (CSS , ej. Calido, neutro, frio) asignado al tipo de plantilla.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_varianStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#varianStyle");
   /**
   * Clase que hereda de WebPage.Mediante esta se administran las variantes en cuanto a diseño (CSS) que tiene cada tipo de plantilla (PaqTemplate).
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_VariantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VariantPaqTemplate");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VariantPaqTemplate");

    public static class ClassMgr
    {
       /**
       * Returns a list of VariantPaqTemplate for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.VariantPaqTemplate for all models
       * @return Iterator of org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.VariantPaqTemplate
       * @param id Identifier for org.semanticwb.pymtur.VariantPaqTemplate
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return A org.semanticwb.pymtur.VariantPaqTemplate
       */
        public static org.semanticwb.pymtur.VariantPaqTemplate getVariantPaqTemplate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.VariantPaqTemplate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.VariantPaqTemplate
       * @param id Identifier for org.semanticwb.pymtur.VariantPaqTemplate
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return A org.semanticwb.pymtur.VariantPaqTemplate
       */
        public static org.semanticwb.pymtur.VariantPaqTemplate createVariantPaqTemplate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.VariantPaqTemplate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.VariantPaqTemplate
       * @param id Identifier for org.semanticwb.pymtur.VariantPaqTemplate
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       */
        public static void removeVariantPaqTemplate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.VariantPaqTemplate
       * @param id Identifier for org.semanticwb.pymtur.VariantPaqTemplate
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return true if the org.semanticwb.pymtur.VariantPaqTemplate exists, false otherwise
       */

        public static boolean hasVariantPaqTemplate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVariantPaqTemplate(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.VariantPaqTemplate with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.VariantPaqTemplate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplateByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.VariantPaqTemplate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VariantPaqTemplateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the VariantPaqTemplate
   */
    public VariantPaqTemplateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the VarianStyle property
* @return String with the VarianStyle
*/
    public String getVarianStyle()
    {
        return getSemanticObject().getProperty(pymtur_varianStyle);
    }

/**
* Sets the VarianStyle property
* @param value long with the VarianStyle
*/
    public void setVarianStyle(String value)
    {
        getSemanticObject().setProperty(pymtur_varianStyle, value);
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
