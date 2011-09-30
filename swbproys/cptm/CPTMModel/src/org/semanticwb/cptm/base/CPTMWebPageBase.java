package org.semanticwb.cptm.base;


   /**
   * Páginas web para Puntos Geográficos, se agrego esta clase para que solo se pudieran agregar Puntos geográficos en un elemento de tipo "Estado/State" 
   */
public abstract class CPTMWebPageBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.Filterable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Searchable,org.semanticwb.model.Expirable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Viewable,org.semanticwb.model.Trashable,org.semanticwb.model.Localeable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Countryable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Referensable,org.semanticwb.model.Undeleteable,org.semanticwb.model.RoleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.MetaTagable,org.semanticwb.model.Resourceable,org.semanticwb.model.Rankable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Indexable
{
   /**
   * Páginas web para Puntos Geográficos, se agrego esta clase para que solo se pudieran agregar Puntos geográficos en un elemento de tipo "Estado/State"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CPTMWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebPage");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMWebPage");

    public static class ClassMgr
    {
       /**
       * Returns a list of CPTMWebPage for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPages(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CPTMWebPage for all models
       * @return Iterator of org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPages()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return A org.semanticwb.cptm.CPTMWebPage
       */
        public static org.semanticwb.cptm.CPTMWebPage getCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMWebPage)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return A org.semanticwb.cptm.CPTMWebPage
       */
        public static org.semanticwb.cptm.CPTMWebPage createCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMWebPage)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       */
        public static void removeCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CPTMWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return true if the org.semanticwb.cptm.CPTMWebPage exists, false otherwise
       */

        public static boolean hasCPTMWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCPTMWebPage(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.CPTMWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMWebPage> listCPTMWebPageByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPTMWebPageBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CPTMWebPage
   */
    public CPTMWebPageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
