package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de tipos de actividades (Ej. Aventura y Ecoturismo, Cultura) 
   */
public abstract class ActivityTypeBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Indexable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.cptm.Videoable,org.semanticwb.model.Referensable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.RuleRefable,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable,org.semanticwb.cptm.CptmGeo
{
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de tipos de actividades (Ej. Aventura y Ecoturismo, Cultura)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityType");

    public static class ClassMgr
    {
       /**
       * Returns a list of ActivityType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ActivityType for all models
       * @return Iterator of org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ActivityType
       * @param id Identifier for org.semanticwb.cptm.ActivityType
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return A org.semanticwb.cptm.ActivityType
       */
        public static org.semanticwb.cptm.ActivityType getActivityType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ActivityType
       * @param id Identifier for org.semanticwb.cptm.ActivityType
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return A org.semanticwb.cptm.ActivityType
       */
        public static org.semanticwb.cptm.ActivityType createActivityType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ActivityType
       * @param id Identifier for org.semanticwb.cptm.ActivityType
       * @param model Model of the org.semanticwb.cptm.ActivityType
       */
        public static void removeActivityType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ActivityType
       * @param id Identifier for org.semanticwb.cptm.ActivityType
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return true if the org.semanticwb.cptm.ActivityType exists, false otherwise
       */

        public static boolean hasActivityType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivityType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.ActivityType
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityType with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityType
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityType> listActivityTypeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActivityTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ActivityType
   */
    public ActivityTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Videoyoutube property
* @return String with the Videoyoutube
*/
    public String getVideoyoutube()
    {
        return getSemanticObject().getProperty(cptm_videoyoutube);
    }

/**
* Sets the Videoyoutube property
* @param value long with the Videoyoutube
*/
    public void setVideoyoutube(String value)
    {
        getSemanticObject().setProperty(cptm_videoyoutube, value);
    }

/**
* Gets the Cptm_latitude property
* @return float with the Cptm_latitude
*/
    public float getCptm_latitude()
    {
        return getSemanticObject().getFloatProperty(cptm_cptm_latitude);
    }

/**
* Sets the Cptm_latitude property
* @param value long with the Cptm_latitude
*/
    public void setCptm_latitude(float value)
    {
        getSemanticObject().setFloatProperty(cptm_cptm_latitude, value);
    }

/**
* Gets the Cptm_longitude property
* @return float with the Cptm_longitude
*/
    public float getCptm_longitude()
    {
        return getSemanticObject().getFloatProperty(cptm_cptm_longitude);
    }

/**
* Sets the Cptm_longitude property
* @param value long with the Cptm_longitude
*/
    public void setCptm_longitude(float value)
    {
        getSemanticObject().setFloatProperty(cptm_cptm_longitude, value);
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
