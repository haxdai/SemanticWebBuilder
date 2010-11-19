package org.semanticwb.cptm.base;


   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ExperienceDestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.model.Filterable,org.semanticwb.model.Indexable,org.semanticwb.model.RoleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Viewable,org.semanticwb.model.Expirable,org.semanticwb.model.Localeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Tagable,org.semanticwb.model.Referensable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Destination");
    public static final org.semanticwb.platform.SemanticProperty cptm_ExperienceDestinationProp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceDestinationProp");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceDestination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceDestination");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceDestination");

    public static class ClassMgr
    {
       /**
       * Returns a list of ExperienceDestination for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinations(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ExperienceDestination for all models
       * @return Iterator of org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinations()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ExperienceDestination
       * @param id Identifier for org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return A org.semanticwb.cptm.ExperienceDestination
       */
        public static org.semanticwb.cptm.ExperienceDestination getExperienceDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ExperienceDestination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ExperienceDestination
       * @param id Identifier for org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return A org.semanticwb.cptm.ExperienceDestination
       */
        public static org.semanticwb.cptm.ExperienceDestination createExperienceDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ExperienceDestination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ExperienceDestination
       * @param id Identifier for org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       */
        public static void removeExperienceDestination(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ExperienceDestination
       * @param id Identifier for org.semanticwb.cptm.ExperienceDestination
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return true if the org.semanticwb.cptm.ExperienceDestination exists, false otherwise
       */

        public static boolean hasExperienceDestination(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExperienceDestination(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ExperienceDestinationProp
       * @param value ExperienceDestinationProp of the type org.semanticwb.cptm.Destination
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByExperienceDestinationProp(org.semanticwb.cptm.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_ExperienceDestinationProp, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ExperienceDestinationProp
       * @param value ExperienceDestinationProp of the type org.semanticwb.cptm.Destination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByExperienceDestinationProp(org.semanticwb.cptm.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_ExperienceDestinationProp,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.ExperienceDestination
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceDestination with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.ExperienceDestination
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceDestination> listExperienceDestinationByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceDestination> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ExperienceDestinationBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ExperienceDestination
   */
    public ExperienceDestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ExperienceDestinationProp
   * @param value ExperienceDestinationProp to set
   */

    public void setExperienceDestinationProp(org.semanticwb.cptm.Destination value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_ExperienceDestinationProp, value.getSemanticObject());
        }else
        {
            removeExperienceDestinationProp();
        }
    }
   /**
   * Remove the value for ExperienceDestinationProp property
   */

    public void removeExperienceDestinationProp()
    {
        getSemanticObject().removeProperty(cptm_ExperienceDestinationProp);
    }

   /**
   * Gets the ExperienceDestinationProp
   * @return a org.semanticwb.cptm.Destination
   */
    public org.semanticwb.cptm.Destination getExperienceDestinationProp()
    {
         org.semanticwb.cptm.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_ExperienceDestinationProp);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Destination)obj.createGenericInstance();
         }
         return ret;
    }
}
