package org.semanticwb.cptm.base;


   /**
   * Tipo de Página, este tipo no se puede crear en el árbol de WebBuilder, solo sirve para ponerle la interfaz de fotos y que las subclases de esta clase poseean los atributos de esta interface (cptmGeneralData). 
   */
public abstract class CPTMGeneralWebPageBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.RuleRefable,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable
{
   /**
   * Relación de una sección con otra sección de otro modelo
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ModelRelation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ModelRelation");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasModelRelation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasModelRelation");
   /**
   * Sección oculta
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_cptmHiddenTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#cptmHiddenTopic");
   /**
   * Tipo de Página, este tipo no se puede crear en el árbol de WebBuilder, solo sirve para ponerle la interfaz de fotos y que las subclases de esta clase poseean los atributos de esta interface (cptmGeneralData).
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CPTMGeneralWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMGeneralWebPage");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMGeneralWebPage");

    public static class ClassMgr
    {
       /**
       * Returns a list of CPTMGeneralWebPage for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPages(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CPTMGeneralWebPage for all models
       * @return Iterator of org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPages()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CPTMGeneralWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMGeneralWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return A org.semanticwb.cptm.CPTMGeneralWebPage
       */
        public static org.semanticwb.cptm.CPTMGeneralWebPage getCPTMGeneralWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMGeneralWebPage)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CPTMGeneralWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMGeneralWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return A org.semanticwb.cptm.CPTMGeneralWebPage
       */
        public static org.semanticwb.cptm.CPTMGeneralWebPage createCPTMGeneralWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMGeneralWebPage)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CPTMGeneralWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMGeneralWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       */
        public static void removeCPTMGeneralWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CPTMGeneralWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMGeneralWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return true if the org.semanticwb.cptm.CPTMGeneralWebPage exists, false otherwise
       */

        public static boolean hasCPTMGeneralWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCPTMGeneralWebPage(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.CPTMGeneralWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMGeneralWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMGeneralWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMGeneralWebPage> listCPTMGeneralWebPageByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMGeneralWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPTMGeneralWebPageBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CPTMGeneralWebPage
   */
    public CPTMGeneralWebPageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.ModelRelation
   * @return A GenericIterator with all the org.semanticwb.cptm.ModelRelation
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ModelRelation> listModelRelations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ModelRelation>(getSemanticObject().listObjectProperties(cptm_hasModelRelation));
    }

   /**
   * Gets true if has a ModelRelation
   * @param value org.semanticwb.cptm.ModelRelation to verify
   * @return true if the org.semanticwb.cptm.ModelRelation exists, false otherwise
   */
    public boolean hasModelRelation(org.semanticwb.cptm.ModelRelation value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasModelRelation,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ModelRelation
   * @param value org.semanticwb.cptm.ModelRelation to add
   */

    public void addModelRelation(org.semanticwb.cptm.ModelRelation value)
    {
        getSemanticObject().addObjectProperty(cptm_hasModelRelation, value.getSemanticObject());
    }
   /**
   * Removes all the ModelRelation
   */

    public void removeAllModelRelation()
    {
        getSemanticObject().removeProperty(cptm_hasModelRelation);
    }
   /**
   * Removes a ModelRelation
   * @param value org.semanticwb.cptm.ModelRelation to remove
   */

    public void removeModelRelation(org.semanticwb.cptm.ModelRelation value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasModelRelation,value.getSemanticObject());
    }

   /**
   * Gets the ModelRelation
   * @return a org.semanticwb.cptm.ModelRelation
   */
    public org.semanticwb.cptm.ModelRelation getModelRelation()
    {
         org.semanticwb.cptm.ModelRelation ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasModelRelation);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ModelRelation)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PhotoEscudoAlt property
* @return String with the PhotoEscudoAlt
*/
    public String getPhotoEscudoAlt()
    {
        return getSemanticObject().getProperty(cptm_photoEscudoAlt);
    }

/**
* Sets the PhotoEscudoAlt property
* @param value long with the PhotoEscudoAlt
*/
    public void setPhotoEscudoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudoAlt, value);
    }

    public String getPhotoEscudoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_photoEscudoAlt, null, lang);
    }

    public String getDisplayPhotoEscudoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_photoEscudoAlt, lang);
    }

    public void setPhotoEscudoAlt(String photoEscudoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_photoEscudoAlt, photoEscudoAlt, lang);
    }

/**
* Gets the PhotoAuthor property
* @return String with the PhotoAuthor
*/
    public String getPhotoAuthor()
    {
        return getSemanticObject().getProperty(cptm_photoAuthor);
    }

/**
* Sets the PhotoAuthor property
* @param value long with the PhotoAuthor
*/
    public void setPhotoAuthor(String value)
    {
        getSemanticObject().setProperty(cptm_photoAuthor, value);
    }

/**
* Gets the PhotoEscudo property
* @return String with the PhotoEscudo
*/
    public String getPhotoEscudo()
    {
        return getSemanticObject().getProperty(cptm_photoEscudo);
    }

/**
* Sets the PhotoEscudo property
* @param value long with the PhotoEscudo
*/
    public void setPhotoEscudo(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudo, value);
    }

/**
* Gets the CptmHiddenTopic property
* @return boolean with the CptmHiddenTopic
*/
    public boolean isCptmHiddenTopic()
    {
        return getSemanticObject().getBooleanProperty(cptm_cptmHiddenTopic);
    }

/**
* Sets the CptmHiddenTopic property
* @param value long with the CptmHiddenTopic
*/
    public void setCptmHiddenTopic(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_cptmHiddenTopic, value);
    }

/**
* Gets the PhotoAlt property
* @return String with the PhotoAlt
*/
    public String getPhotoAlt()
    {
        return getSemanticObject().getProperty(cptm_photoAlt);
    }

/**
* Sets the PhotoAlt property
* @param value long with the PhotoAlt
*/
    public void setPhotoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_photoAlt, value);
    }

    public String getPhotoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_photoAlt, null, lang);
    }

    public String getDisplayPhotoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_photoAlt, lang);
    }

    public void setPhotoAlt(String photoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_photoAlt, photoAlt, lang);
    }

/**
* Gets the CptmAbstractDescription property
* @return String with the CptmAbstractDescription
*/
    public String getCptmAbstractDescription()
    {
        return getSemanticObject().getProperty(cptm_cptmAbstractDescription);
    }

/**
* Sets the CptmAbstractDescription property
* @param value long with the CptmAbstractDescription
*/
    public void setCptmAbstractDescription(String value)
    {
        getSemanticObject().setProperty(cptm_cptmAbstractDescription, value);
    }

    public String getCptmAbstractDescription(String lang)
    {
        return getSemanticObject().getProperty(cptm_cptmAbstractDescription, null, lang);
    }

    public String getDisplayCptmAbstractDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_cptmAbstractDescription, lang);
    }

    public void setCptmAbstractDescription(String cptmAbstractDescription, String lang)
    {
        getSemanticObject().setProperty(cptm_cptmAbstractDescription, cptmAbstractDescription, lang);
    }
   /**
   * Gets all the org.semanticwb.cptm.Photo
   * @return A GenericIterator with all the org.semanticwb.cptm.Photo
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo> listMorePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo>(getSemanticObject().listObjectProperties(cptm_hasMorePhoto));
    }

   /**
   * Gets true if has a MorePhoto
   * @param value org.semanticwb.cptm.Photo to verify
   * @return true if the org.semanticwb.cptm.Photo exists, false otherwise
   */
    public boolean hasMorePhoto(org.semanticwb.cptm.Photo value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasMorePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MorePhoto
   * @param value org.semanticwb.cptm.Photo to add
   */

    public void addMorePhoto(org.semanticwb.cptm.Photo value)
    {
        getSemanticObject().addObjectProperty(cptm_hasMorePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the MorePhoto
   */

    public void removeAllMorePhoto()
    {
        getSemanticObject().removeProperty(cptm_hasMorePhoto);
    }
   /**
   * Removes a MorePhoto
   * @param value org.semanticwb.cptm.Photo to remove
   */

    public void removeMorePhoto(org.semanticwb.cptm.Photo value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasMorePhoto,value.getSemanticObject());
    }

   /**
   * Gets the MorePhoto
   * @return a org.semanticwb.cptm.Photo
   */
    public org.semanticwb.cptm.Photo getMorePhoto()
    {
         org.semanticwb.cptm.Photo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasMorePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Photo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Photo property
* @return String with the Photo
*/
    public String getPhoto()
    {
        return getSemanticObject().getProperty(cptm_photo);
    }

/**
* Sets the Photo property
* @param value long with the Photo
*/
    public void setPhoto(String value)
    {
        getSemanticObject().setProperty(cptm_photo, value);
    }
}
