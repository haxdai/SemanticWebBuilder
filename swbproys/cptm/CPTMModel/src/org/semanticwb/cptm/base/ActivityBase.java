package org.semanticwb.cptm.base;


   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc) 
   */
public abstract class ActivityBase extends org.semanticwb.cptm.CPTMPhotoWebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Indexable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Tagable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Resourceable,org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Viewable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Searchable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.model.Hiddenable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Rankable
{
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefActivityInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefActivityInv");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEventActivityRefInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEventActivityRefInv");
   /**
   * Notas Editoriales
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEditNoteActivityInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEditNoteActivityInv");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
   /**
   * Destinos referenciados a una Actividad
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasActLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasActLocality");
   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");

    public static class ClassMgr
    {
       /**
       * Returns a list of Activity for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivities(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Activity for all models
       * @return Iterator of org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivities()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Activity
       * @param id Identifier for org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return A org.semanticwb.cptm.Activity
       */
        public static org.semanticwb.cptm.Activity getActivity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Activity)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Activity
       * @param id Identifier for org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return A org.semanticwb.cptm.Activity
       */
        public static org.semanticwb.cptm.Activity createActivity(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Activity)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Activity
       * @param id Identifier for org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Activity
       */
        public static void removeActivity(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Activity
       * @param id Identifier for org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return true if the org.semanticwb.cptm.Activity exists, false otherwise
       */

        public static boolean hasActivity(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivity(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ArefActivityInv
       * @param value ArefActivityInv of the type org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByArefActivityInv(org.semanticwb.cptm.ActivityRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ArefActivityInv
       * @param value ArefActivityInv of the type org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByArefActivityInv(org.semanticwb.cptm.ActivityRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined EventActivityRefInv
       * @param value EventActivityRefInv of the type org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByEventActivityRefInv(org.semanticwb.cptm.Event value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventActivityRefInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined EventActivityRefInv
       * @param value EventActivityRefInv of the type org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByEventActivityRefInv(org.semanticwb.cptm.Event value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventActivityRefInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined EditNoteActivityInv
       * @param value EditNoteActivityInv of the type org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByEditNoteActivityInv(org.semanticwb.cptm.EditNote value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEditNoteActivityInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined EditNoteActivityInv
       * @param value EditNoteActivityInv of the type org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByEditNoteActivityInv(org.semanticwb.cptm.EditNote value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEditNoteActivityInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ActLocality
       * @param value ActLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByActLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Activity with a determined ActLocality
       * @param value ActLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Activity
       */

        public static java.util.Iterator<org.semanticwb.cptm.Activity> listActivityByActLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasActLocality,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActivityBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Activity
   */
    public ActivityBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ArefActivityInv
   * @param value ArefActivityInv to set
   */

    public void setArefActivityInv(org.semanticwb.cptm.ActivityRef value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefActivityInv, value.getSemanticObject());
        }else
        {
            removeArefActivityInv();
        }
    }
   /**
   * Remove the value for ArefActivityInv property
   */

    public void removeArefActivityInv()
    {
        getSemanticObject().removeProperty(cptm_arefActivityInv);
    }

   /**
   * Gets the ArefActivityInv
   * @return a org.semanticwb.cptm.ActivityRef
   */
    public org.semanticwb.cptm.ActivityRef getArefActivityInv()
    {
         org.semanticwb.cptm.ActivityRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefActivityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ActivityRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Event
   * @return A GenericIterator with all the org.semanticwb.cptm.Event
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> listEventActivityRefInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(getSemanticObject().listObjectProperties(cptm_hasEventActivityRefInv));
    }

   /**
   * Gets true if has a EventActivityRefInv
   * @param value org.semanticwb.cptm.Event to verify
   * @return true if the org.semanticwb.cptm.Event exists, false otherwise
   */
    public boolean hasEventActivityRefInv(org.semanticwb.cptm.Event value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventActivityRefInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EventActivityRefInv
   * @return a org.semanticwb.cptm.Event
   */
    public org.semanticwb.cptm.Event getEventActivityRefInv()
    {
         org.semanticwb.cptm.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventActivityRefInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Event)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.EditNote
   * @return A GenericIterator with all the org.semanticwb.cptm.EditNote
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> listEditNoteActivityInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote>(getSemanticObject().listObjectProperties(cptm_hasEditNoteActivityInv));
    }

   /**
   * Gets true if has a EditNoteActivityInv
   * @param value org.semanticwb.cptm.EditNote to verify
   * @return true if the org.semanticwb.cptm.EditNote exists, false otherwise
   */
    public boolean hasEditNoteActivityInv(org.semanticwb.cptm.EditNote value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEditNoteActivityInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EditNoteActivityInv
   * @return a org.semanticwb.cptm.EditNote
   */
    public org.semanticwb.cptm.EditNote getEditNoteActivityInv()
    {
         org.semanticwb.cptm.EditNote ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEditNoteActivityInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EditNote)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listActLocalities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasActLocality));
    }

   /**
   * Gets true if has a ActLocality
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasActLocality(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasActLocality,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ActLocality
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addActLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasActLocality, value.getSemanticObject());
    }
   /**
   * Removes all the ActLocality
   */

    public void removeAllActLocality()
    {
        getSemanticObject().removeProperty(cptm_hasActLocality);
    }
   /**
   * Removes a ActLocality
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeActLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasActLocality,value.getSemanticObject());
    }

   /**
   * Gets the ActLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getActLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasActLocality);
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
