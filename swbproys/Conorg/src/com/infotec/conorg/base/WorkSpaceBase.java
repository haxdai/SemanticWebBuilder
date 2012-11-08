package com.infotec.conorg.base;


public abstract class WorkSpaceBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Filterable,org.semanticwb.model.RoleRefable,com.infotec.conorg.Topicable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Viewable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Searchable,org.semanticwb.model.Localeable,org.semanticwb.model.Expirable,org.semanticwb.model.MetaTagable,org.semanticwb.model.Rankable,org.semanticwb.model.Traceable,org.semanticwb.model.Indexable,org.semanticwb.model.FilterableClass,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Resourceable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Undeleteable,com.infotec.conorg.Tileable,org.semanticwb.model.Countryable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Calendarable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasSubscribers=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasSubscribers");
    public static final org.semanticwb.platform.SemanticClass conorg_Place=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Place");
    public static final org.semanticwb.platform.SemanticProperty conorg_placeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#placeInv");
    public static final org.semanticwb.platform.SemanticClass conorg_Member=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Member");
    public static final org.semanticwb.platform.SemanticProperty conorg_hasMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#hasMember");
    public static final org.semanticwb.platform.SemanticClass conorg_WorkSpace=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#WorkSpace");

    public static class ClassMgr
    {
       /**
       * Returns a list of WorkSpace for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaces(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.WorkSpace for all models
       * @return Iterator of com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaces()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace>(it, true);
        }

        public static com.infotec.conorg.WorkSpace createWorkSpace(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.conorg.WorkSpace.ClassMgr.createWorkSpace(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return A com.infotec.conorg.WorkSpace
       */
        public static com.infotec.conorg.WorkSpace getWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.WorkSpace)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return A com.infotec.conorg.WorkSpace
       */
        public static com.infotec.conorg.WorkSpace createWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.WorkSpace)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       */
        public static void removeWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.WorkSpace
       * @param id Identifier for com.infotec.conorg.WorkSpace
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return true if the com.infotec.conorg.WorkSpace exists, false otherwise
       */

        public static boolean hasWorkSpace(String id, org.semanticwb.model.SWBModel model)
        {
            return (getWorkSpace(id, model)!=null);
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTopic(com.infotec.conorg.Topic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Topic
       * @param value Topic of the type com.infotec.conorg.Topic
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTopic(com.infotec.conorg.Topic value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Subscribers
       * @param value Subscribers of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceBySubscribers(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasSubscribers, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Subscribers
       * @param value Subscribers of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceBySubscribers(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasSubscribers,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Place
       * @param value Place of the type com.infotec.conorg.Place
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByPlace(com.infotec.conorg.Place value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_placeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Place
       * @param value Place of the type com.infotec.conorg.Place
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByPlace(com.infotec.conorg.Place value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_placeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCalendar(org.semanticwb.model.Calendar value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Calendar
       * @param value Calendar of the type org.semanticwb.model.Calendar
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCalendar(org.semanticwb.model.Calendar value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Member
       * @param value Member of the type com.infotec.conorg.Member
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByMember(com.infotec.conorg.Member value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasMember, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Member
       * @param value Member of the type com.infotec.conorg.Member
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByMember(com.infotec.conorg.Member value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasMember,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @param model Model of the com.infotec.conorg.WorkSpace
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTile(com.infotec.conorg.Tile value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.conorg.WorkSpace with a determined Tile
       * @param value Tile of the type com.infotec.conorg.Tile
       * @return Iterator with all the com.infotec.conorg.WorkSpace
       */

        public static java.util.Iterator<com.infotec.conorg.WorkSpace> listWorkSpaceByTile(com.infotec.conorg.Tile value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.conorg.WorkSpace> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(conorg_hasTile,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static WorkSpaceBase.ClassMgr getWorkSpaceClassMgr()
    {
        return new WorkSpaceBase.ClassMgr();
    }

   /**
   * Constructs a WorkSpaceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the WorkSpace
   */
    public WorkSpaceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.conorg.Topic
   * @return A GenericIterator with all the com.infotec.conorg.Topic
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic> listTopics()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Topic>(getSemanticObject().listObjectProperties(conorg_hasTopic));
    }

   /**
   * Gets true if has a Topic
   * @param value com.infotec.conorg.Topic to verify
   * @return true if the com.infotec.conorg.Topic exists, false otherwise
   */
    public boolean hasTopic(com.infotec.conorg.Topic value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasTopic,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Topic
   * @param value com.infotec.conorg.Topic to add
   */

    public void addTopic(com.infotec.conorg.Topic value)
    {
        getSemanticObject().addObjectProperty(conorg_hasTopic, value.getSemanticObject());
    }
   /**
   * Removes all the Topic
   */

    public void removeAllTopic()
    {
        getSemanticObject().removeProperty(conorg_hasTopic);
    }
   /**
   * Removes a Topic
   * @param value com.infotec.conorg.Topic to remove
   */

    public void removeTopic(com.infotec.conorg.Topic value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasTopic,value.getSemanticObject());
    }

   /**
   * Gets the Topic
   * @return a com.infotec.conorg.Topic
   */
    public com.infotec.conorg.Topic getTopic()
    {
         com.infotec.conorg.Topic ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasTopic);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Topic)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listSubscriberses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(conorg_hasSubscribers));
    }

   /**
   * Gets true if has a Subscribers
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasSubscribers(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasSubscribers,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Subscribers
   * @param value org.semanticwb.model.User to add
   */

    public void addSubscribers(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(conorg_hasSubscribers, value.getSemanticObject());
    }
   /**
   * Removes all the Subscribers
   */

    public void removeAllSubscribers()
    {
        getSemanticObject().removeProperty(conorg_hasSubscribers);
    }
   /**
   * Removes a Subscribers
   * @param value org.semanticwb.model.User to remove
   */

    public void removeSubscribers(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasSubscribers,value.getSemanticObject());
    }

   /**
   * Gets the Subscribers
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSubscribers()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasSubscribers);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Place
   * @param value Place to set
   */

    public void setPlace(com.infotec.conorg.Place value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(conorg_placeInv, value.getSemanticObject());
        }else
        {
            removePlace();
        }
    }
   /**
   * Remove the value for Place property
   */

    public void removePlace()
    {
        getSemanticObject().removeProperty(conorg_placeInv);
    }

   /**
   * Gets the Place
   * @return a com.infotec.conorg.Place
   */
    public com.infotec.conorg.Place getPlace()
    {
         com.infotec.conorg.Place ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_placeInv);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Place)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.Calendar
   * @return A GenericIterator with all the org.semanticwb.model.Calendar
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar> listCalendars()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar>(getSemanticObject().listObjectProperties(swb_hasCalendar));
    }

   /**
   * Gets true if has a Calendar
   * @param value org.semanticwb.model.Calendar to verify
   * @return true if the org.semanticwb.model.Calendar exists, false otherwise
   */
    public boolean hasCalendar(org.semanticwb.model.Calendar value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasCalendar,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Calendar
   * @param value org.semanticwb.model.Calendar to add
   */

    public void addCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().addObjectProperty(swb_hasCalendar, value.getSemanticObject());
    }
   /**
   * Removes all the Calendar
   */

    public void removeAllCalendar()
    {
        getSemanticObject().removeProperty(swb_hasCalendar);
    }
   /**
   * Removes a Calendar
   * @param value org.semanticwb.model.Calendar to remove
   */

    public void removeCalendar(org.semanticwb.model.Calendar value)
    {
        getSemanticObject().removeObjectProperty(swb_hasCalendar,value.getSemanticObject());
    }

   /**
   * Gets the Calendar
   * @return a org.semanticwb.model.Calendar
   */
    public org.semanticwb.model.Calendar getCalendar()
    {
         org.semanticwb.model.Calendar ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasCalendar);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Calendar)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.conorg.Member
   * @return A GenericIterator with all the com.infotec.conorg.Member
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Member> listMembers()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Member>(getSemanticObject().listObjectProperties(conorg_hasMember));
    }

   /**
   * Gets true if has a Member
   * @param value com.infotec.conorg.Member to verify
   * @return true if the com.infotec.conorg.Member exists, false otherwise
   */
    public boolean hasMember(com.infotec.conorg.Member value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasMember,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Member
   * @param value com.infotec.conorg.Member to add
   */

    public void addMember(com.infotec.conorg.Member value)
    {
        getSemanticObject().addObjectProperty(conorg_hasMember, value.getSemanticObject());
    }
   /**
   * Removes all the Member
   */

    public void removeAllMember()
    {
        getSemanticObject().removeProperty(conorg_hasMember);
    }
   /**
   * Removes a Member
   * @param value com.infotec.conorg.Member to remove
   */

    public void removeMember(com.infotec.conorg.Member value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasMember,value.getSemanticObject());
    }

   /**
   * Gets the Member
   * @return a com.infotec.conorg.Member
   */
    public com.infotec.conorg.Member getMember()
    {
         com.infotec.conorg.Member ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasMember);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Member)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.conorg.Tile
   * @return A GenericIterator with all the com.infotec.conorg.Tile
   */

    public org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile> listTiles()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Tile>(getSemanticObject().listObjectProperties(conorg_hasTile));
    }

   /**
   * Gets true if has a Tile
   * @param value com.infotec.conorg.Tile to verify
   * @return true if the com.infotec.conorg.Tile exists, false otherwise
   */
    public boolean hasTile(com.infotec.conorg.Tile value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(conorg_hasTile,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Tile
   * @param value com.infotec.conorg.Tile to add
   */

    public void addTile(com.infotec.conorg.Tile value)
    {
        getSemanticObject().addObjectProperty(conorg_hasTile, value.getSemanticObject());
    }
   /**
   * Removes all the Tile
   */

    public void removeAllTile()
    {
        getSemanticObject().removeProperty(conorg_hasTile);
    }
   /**
   * Removes a Tile
   * @param value com.infotec.conorg.Tile to remove
   */

    public void removeTile(com.infotec.conorg.Tile value)
    {
        getSemanticObject().removeObjectProperty(conorg_hasTile,value.getSemanticObject());
    }

   /**
   * Gets the Tile
   * @return a com.infotec.conorg.Tile
   */
    public com.infotec.conorg.Tile getTile()
    {
         com.infotec.conorg.Tile ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(conorg_hasTile);
         if(obj!=null)
         {
             ret=(com.infotec.conorg.Tile)obj.createGenericInstance();
         }
         return ret;
    }
}
