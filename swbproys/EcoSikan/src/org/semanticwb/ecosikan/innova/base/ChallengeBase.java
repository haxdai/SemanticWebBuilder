package org.semanticwb.ecosikan.innova.base;


public abstract class ChallengeBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Searchable,org.semanticwb.model.Trashable,org.semanticwb.model.Tagable,org.semanticwb.model.Localeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Undeleteable,org.semanticwb.model.Referensable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Rankable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Viewable,org.semanticwb.model.Hiddenable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable
{
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasExpectation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasExpectation");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_image=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#image");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasDesire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasDesire");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasIdea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasIdea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_phase=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#phase");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Category");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasCategory");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_document=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#document");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasStakeholder=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasStakeholder");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Challenge=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Challenge");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Challenge");

    public static class ClassMgr
    {
       /**
       * Returns a list of Challenge for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallenges(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Challenge for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallenges()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge>(it, true);
        }

        public static org.semanticwb.ecosikan.innova.Challenge createChallenge(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.createChallenge(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return A org.semanticwb.ecosikan.innova.Challenge
       */
        public static org.semanticwb.ecosikan.innova.Challenge getChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Challenge)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return A org.semanticwb.ecosikan.innova.Challenge
       */
        public static org.semanticwb.ecosikan.innova.Challenge createChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Challenge)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       */
        public static void removeChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return true if the org.semanticwb.ecosikan.innova.Challenge exists, false otherwise
       */

        public static boolean hasChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            return (getChallenge(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Idea
       * @param value Idea of the type org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByIdea(org.semanticwb.ecosikan.innova.Idea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdea, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Idea
       * @param value Idea of the type org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByIdea(org.semanticwb.ecosikan.innova.Idea value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdea,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Category
       * @param value Category of the type org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByCategory(org.semanticwb.ecosikan.innova.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasCategory, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Category
       * @param value Category of the type org.semanticwb.ecosikan.innova.Category
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByCategory(org.semanticwb.ecosikan.innova.Category value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasCategory,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ChallengeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Challenge
   */
    public ChallengeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Iterator<String> listExpectations()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ecoskn_hasExpectation);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addExpectation(String value)
    {
        getSemanticObject().addLiteralProperty(ecoskn_hasExpectation, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllExpectation()
    {
        getSemanticObject().removeProperty(ecoskn_hasExpectation);
    }

    public void removeExpectation(String value)
    {
        getSemanticObject().removeLiteralProperty(ecoskn_hasExpectation,new org.semanticwb.platform.SemanticLiteral(value));
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

    public java.util.Iterator<String> listDesires()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ecoskn_hasDesire);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addDesire(String value)
    {
        getSemanticObject().addLiteralProperty(ecoskn_hasDesire, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllDesire()
    {
        getSemanticObject().removeProperty(ecoskn_hasDesire);
    }

    public void removeDesire(String value)
    {
        getSemanticObject().removeLiteralProperty(ecoskn_hasDesire,new org.semanticwb.platform.SemanticLiteral(value));
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Idea
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Idea
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> listIdeas()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea>(getSemanticObject().listObjectProperties(ecoskn_hasIdea));
    }

   /**
   * Gets true if has a Idea
   * @param value org.semanticwb.ecosikan.innova.Idea to verify
   * @return true if the org.semanticwb.ecosikan.innova.Idea exists, false otherwise
   */
    public boolean hasIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasIdea,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Idea
   * @param value org.semanticwb.ecosikan.innova.Idea to add
   */

    public void addIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasIdea, value.getSemanticObject());
    }
   /**
   * Removes all the Idea
   */

    public void removeAllIdea()
    {
        getSemanticObject().removeProperty(ecoskn_hasIdea);
    }
   /**
   * Removes a Idea
   * @param value org.semanticwb.ecosikan.innova.Idea to remove
   */

    public void removeIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasIdea,value.getSemanticObject());
    }

   /**
   * Gets the Idea
   * @return a org.semanticwb.ecosikan.innova.Idea
   */
    public org.semanticwb.ecosikan.innova.Idea getIdea()
    {
         org.semanticwb.ecosikan.innova.Idea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasIdea);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Idea)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Phase property
* @return String with the Phase
*/
    public String getPhase()
    {
        return getSemanticObject().getProperty(ecoskn_phase);
    }

/**
* Sets the Phase property
* @param value long with the Phase
*/
    public void setPhase(String value)
    {
        getSemanticObject().setProperty(ecoskn_phase, value);
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Category
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Category
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Category> listCategories()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Category>(getSemanticObject().listObjectProperties(ecoskn_hasCategory));
    }

   /**
   * Gets true if has a Category
   * @param value org.semanticwb.ecosikan.innova.Category to verify
   * @return true if the org.semanticwb.ecosikan.innova.Category exists, false otherwise
   */
    public boolean hasCategory(org.semanticwb.ecosikan.innova.Category value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasCategory,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Category
   * @param value org.semanticwb.ecosikan.innova.Category to add
   */

    public void addCategory(org.semanticwb.ecosikan.innova.Category value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasCategory, value.getSemanticObject());
    }
   /**
   * Removes all the Category
   */

    public void removeAllCategory()
    {
        getSemanticObject().removeProperty(ecoskn_hasCategory);
    }
   /**
   * Removes a Category
   * @param value org.semanticwb.ecosikan.innova.Category to remove
   */

    public void removeCategory(org.semanticwb.ecosikan.innova.Category value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasCategory,value.getSemanticObject());
    }

   /**
   * Gets the Category
   * @return a org.semanticwb.ecosikan.innova.Category
   */
    public org.semanticwb.ecosikan.innova.Category getCategory()
    {
         org.semanticwb.ecosikan.innova.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasCategory);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Category)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Document property
* @return String with the Document
*/
    public String getDocument()
    {
        return getSemanticObject().getProperty(ecoskn_document);
    }

/**
* Sets the Document property
* @param value long with the Document
*/
    public void setDocument(String value)
    {
        getSemanticObject().setProperty(ecoskn_document, value);
    }

    public java.util.Iterator<String> listStakeholders()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ecoskn_hasStakeholder);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addStakeholder(String value)
    {
        getSemanticObject().addLiteralProperty(ecoskn_hasStakeholder, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllStakeholder()
    {
        getSemanticObject().removeProperty(ecoskn_hasStakeholder);
    }

    public void removeStakeholder(String value)
    {
        getSemanticObject().removeLiteralProperty(ecoskn_hasStakeholder,new org.semanticwb.platform.SemanticLiteral(value));
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
