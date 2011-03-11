package org.semanticwb.cptm.base;


   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ActivityRefBase extends org.semanticwb.cptm.CPTMWebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Resourceable,org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.RoleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Viewable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Searchable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.model.Hiddenable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Rankable
{
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefActivity");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefLocality");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of ActivityRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ActivityRef for all models
       * @return Iterator of org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return A org.semanticwb.cptm.ActivityRef
       */
        public static org.semanticwb.cptm.ActivityRef getActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return A org.semanticwb.cptm.ActivityRef
       */
        public static org.semanticwb.cptm.ActivityRef createActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       */
        public static void removeActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return true if the org.semanticwb.cptm.ActivityRef exists, false otherwise
       */

        public static boolean hasActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivityRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Activity
       * @param value Activity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Activity
       * @param value Activity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActivityRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ActivityRef
   */
    public ActivityRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Activity
   * @param value Activity to set
   */

    public void setActivity(org.semanticwb.cptm.Activity value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefActivity, value.getSemanticObject());
        }else
        {
            removeActivity();
        }
    }
   /**
   * Remove the value for Activity property
   */

    public void removeActivity()
    {
        getSemanticObject().removeProperty(cptm_arefActivity);
    }

   /**
   * Gets the Activity
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getActivity()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Locality
   * @param value Locality to set
   */

    public void setLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefLocality, value.getSemanticObject());
        }else
        {
            removeLocality();
        }
    }
   /**
   * Remove the value for Locality property
   */

    public void removeLocality()
    {
        getSemanticObject().removeProperty(cptm_arefLocality);
    }

   /**
   * Gets the Locality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
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
