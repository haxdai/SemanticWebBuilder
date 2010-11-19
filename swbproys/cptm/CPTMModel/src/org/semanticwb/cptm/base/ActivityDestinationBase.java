package org.semanticwb.cptm.base;


   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ActivityDestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");
    public static final org.semanticwb.platform.SemanticProperty cptm_ActivityDestinationProp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#ActivityDestinationProp");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityDestination");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityDestination");

    public static class ClassMgr
    {
       /**
       * Returns a list of ActivityDestination for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ActivityDestination for all models
       * @return Iterator of org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ActivityDestination
       * @param id Identifier for org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return A org.semanticwb.cptm.ActivityDestination
       */
        public static org.semanticwb.cptm.ActivityDestination getActivityDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityDestination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ActivityDestination
       * @param id Identifier for org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return A org.semanticwb.cptm.ActivityDestination
       */
        public static org.semanticwb.cptm.ActivityDestination createActivityDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityDestination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ActivityDestination
       * @param id Identifier for org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       */
        public static void removeActivityDestination(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ActivityDestination
       * @param id Identifier for org.semanticwb.cptm.ActivityDestination
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return true if the org.semanticwb.cptm.ActivityDestination exists, false otherwise
       */

        public static boolean hasActivityDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivityDestination(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ActivityDestinationProp
       * @param value ActivityDestinationProp of the type org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByActivityDestinationProp(org.semanticwb.cptm.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_ActivityDestinationProp, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ActivityDestinationProp
       * @param value ActivityDestinationProp of the type org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByActivityDestinationProp(org.semanticwb.cptm.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_ActivityDestinationProp,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.ActivityDestination
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.ActivityDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityDestination> listActivityDestinationByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActivityDestinationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ActivityDestination
   */
    public ActivityDestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ActivityDestinationProp
   * @param value ActivityDestinationProp to set
   */

    public void setActivityDestinationProp(org.semanticwb.cptm.Destination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_ActivityDestinationProp, value.getSemanticObject());
        }else
        {
            removeActivityDestinationProp();
        }
    }
   /**
   * Remove the value for ActivityDestinationProp property
   */

    public void removeActivityDestinationProp()
    {
        getSemanticObject().removeProperty(cptm_ActivityDestinationProp);
    }

   /**
   * Gets the ActivityDestinationProp
   * @return a org.semanticwb.cptm.Destination
   */
    public org.semanticwb.cptm.Destination getActivityDestinationProp()
    {
         org.semanticwb.cptm.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_ActivityDestinationProp);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Destination)obj.createGenericInstance();
         }
         return ret;
    }
}
