package org.semanticwb.pymtur.base;


   /**
   * Clase que extiende de swbcomm:MicroSite, la cual extiende a su vez de Webpage. Cada que una pyme contrata un paquete de tipo "Micrositio" o "Premier-Página web" se crea una instancia de esta clase para albergar el microsito de dicha pyme. 
   */
public abstract class MicroSitePymeBase extends org.semanticwb.portal.community.MicroSite implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Viewable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Rankable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Localeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RoleRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable
{
   /**
   * Clase principal del sistema de pymes turisticas. Una instancia de esta clase es en donde se almacena toda la información de una mipyme especifica.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
   /**
   * Objeto serviceprovider que esta asociado al micrositio.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_serviceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceProvider");
   /**
   * Clase que extiende de swbcomm:MicroSite, la cual extiende a su vez de Webpage. Cada que una pyme contrata un paquete de tipo "Micrositio" o "Premier-Página web" se crea una instancia de esta clase para albergar el microsito de dicha pyme.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_MicroSitePyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");

    public static class ClassMgr
    {
       /**
       * Returns a list of MicroSitePyme for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.MicroSitePyme for all models
       * @return Iterator of org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.MicroSitePyme
       * @param id Identifier for org.semanticwb.pymtur.MicroSitePyme
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return A org.semanticwb.pymtur.MicroSitePyme
       */
        public static org.semanticwb.pymtur.MicroSitePyme getMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MicroSitePyme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.MicroSitePyme
       * @param id Identifier for org.semanticwb.pymtur.MicroSitePyme
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return A org.semanticwb.pymtur.MicroSitePyme
       */
        public static org.semanticwb.pymtur.MicroSitePyme createMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MicroSitePyme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.MicroSitePyme
       * @param id Identifier for org.semanticwb.pymtur.MicroSitePyme
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       */
        public static void removeMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.MicroSitePyme
       * @param id Identifier for org.semanticwb.pymtur.MicroSitePyme
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return true if the org.semanticwb.pymtur.MicroSitePyme exists, false otherwise
       */

        public static boolean hasMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMicroSitePyme(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined About
       * @param value About of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAbout(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_about, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined About
       * @param value About of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAbout(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_about,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Member
       * @param value Member of the type org.semanticwb.portal.community.Member
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMember(org.semanticwb.portal.community.Member value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasMSMembersInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Member
       * @param value Member of the type org.semanticwb.portal.community.Member
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMember(org.semanticwb.portal.community.Member value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasMSMembersInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ServiceProvider
       * @param value ServiceProvider of the type org.semanticwb.pymtur.ServiceProvider
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByServiceProvider(org.semanticwb.pymtur.ServiceProvider value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_serviceProvider, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ServiceProvider
       * @param value ServiceProvider of the type org.semanticwb.pymtur.ServiceProvider
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_serviceProvider,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined MicroSiteUtil
       * @param value MicroSiteUtil of the type org.semanticwb.portal.community.MicroSiteWebPageUtil
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteWebPageUtil value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasMicroSiteUtilsInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined MicroSiteUtil
       * @param value MicroSiteUtil of the type org.semanticwb.portal.community.MicroSiteWebPageUtil
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteWebPageUtil value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasMicroSiteUtilsInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Type
       * @param value Type of the type org.semanticwb.portal.community.MicroSiteType
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByType(org.semanticwb.portal.community.MicroSiteType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_type, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined Type
       * @param value Type of the type org.semanticwb.portal.community.MicroSiteType
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByType(org.semanticwb.portal.community.MicroSiteType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_type,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.MicroSitePyme with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.pymtur.MicroSitePyme
       */

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a MicroSitePymeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the MicroSitePyme
   */
    public MicroSitePymeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ServiceProvider
   * @param value ServiceProvider to set
   */

    public void setServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(pymtur_serviceProvider, value.getSemanticObject());
        }else
        {
            removeServiceProvider();
        }
    }
   /**
   * Remove the value for ServiceProvider property
   */

    public void removeServiceProvider()
    {
        getSemanticObject().removeProperty(pymtur_serviceProvider);
    }

   /**
   * Gets the ServiceProvider
   * @return a org.semanticwb.pymtur.ServiceProvider
   */
    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_serviceProvider);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }
}
