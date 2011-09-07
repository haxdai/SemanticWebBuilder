package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Estados de la República (Ej. Tamaulipas, Morelos) 
   */
public abstract class StateBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.FilterableNode,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.MetaTagable,org.semanticwb.model.FilterableClass,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Trashable,org.semanticwb.model.Viewable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.Resourceable,org.semanticwb.model.Countryable,org.semanticwb.model.Referensable,org.semanticwb.model.Localeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Activeable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Searchable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Expirable
{
   /**
   * Notas Editoriales
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNoteStateInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNoteStateInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEventStateInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEventStateInv");
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Estados de la República (Ej. Tamaulipas, Morelos)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#State");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#State");

    public static class ClassMgr
    {
       /**
       * Returns a list of State for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.State for all models
       * @return Iterator of org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.State
       * @param id Identifier for org.semanticwb.cptm.State
       * @param model Model of the org.semanticwb.cptm.State
       * @return A org.semanticwb.cptm.State
       */
        public static org.semanticwb.cptm.State getState(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.State)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.State
       * @param id Identifier for org.semanticwb.cptm.State
       * @param model Model of the org.semanticwb.cptm.State
       * @return A org.semanticwb.cptm.State
       */
        public static org.semanticwb.cptm.State createState(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.State)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.State
       * @param id Identifier for org.semanticwb.cptm.State
       * @param model Model of the org.semanticwb.cptm.State
       */
        public static void removeState(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.State
       * @param id Identifier for org.semanticwb.cptm.State
       * @param model Model of the org.semanticwb.cptm.State
       * @return true if the org.semanticwb.cptm.State exists, false otherwise
       */

        public static boolean hasState(String id, org.semanticwb.model.SWBModel model)
        {
            return (getState(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined NoteStateInv
       * @param value NoteStateInv of the type org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByNoteStateInv(org.semanticwb.cptm.EditNote value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteStateInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined NoteStateInv
       * @param value NoteStateInv of the type org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByNoteStateInv(org.semanticwb.cptm.EditNote value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteStateInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined EventStateInv
       * @param value EventStateInv of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByEventStateInv(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventStateInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined EventStateInv
       * @param value EventStateInv of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByEventStateInv(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventStateInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.State with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.State
       */

        public static java.util.Iterator<org.semanticwb.cptm.State> listStateByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a StateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the State
   */
    public StateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.EditNote
   * @return A GenericIterator with all the org.semanticwb.cptm.EditNote
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> listNoteStateInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote>(getSemanticObject().listObjectProperties(cptm_hasNoteStateInv));
    }

   /**
   * Gets true if has a NoteStateInv
   * @param value org.semanticwb.cptm.EditNote to verify
   * @return true if the org.semanticwb.cptm.EditNote exists, false otherwise
   */
    public boolean hasNoteStateInv(org.semanticwb.cptm.EditNote value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNoteStateInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NoteStateInv
   * @return a org.semanticwb.cptm.EditNote
   */
    public org.semanticwb.cptm.EditNote getNoteStateInv()
    {
         org.semanticwb.cptm.EditNote ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNoteStateInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EditNote)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Event
   * @return A GenericIterator with all the org.semanticwb.cptm.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> listEventStateInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(getSemanticObject().listObjectProperties(cptm_hasEventStateInv));
    }

   /**
   * Gets true if has a EventStateInv
   * @param value org.semanticwb.cptm.Event to verify
   * @return true if the org.semanticwb.cptm.Event exists, false otherwise
   */
    public boolean hasEventStateInv(org.semanticwb.cptm.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventStateInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EventStateInv
   * @return a org.semanticwb.cptm.Event
   */
    public org.semanticwb.cptm.Event getEventStateInv()
    {
         org.semanticwb.cptm.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventStateInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Event)obj.createGenericInstance();
         }
         return ret;
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
