package org.semanticwb.cptm.base;


   /**
   * Tipo de Página, este tipo no se puede crear en el árbol de WebBuilder, solo sirve para ponerle la interfaz de fotos y que las subclases de esta clase poseean los atributos de esta interface (cptmGeneralData). 
   */
public abstract class CPTMPhotoWebPageBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Trashable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Searchable,org.semanticwb.model.Expirable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Indexable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Traceable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Resourceable,org.semanticwb.model.Localeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable,org.semanticwb.model.Referensable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Viewable,org.semanticwb.model.Activeable,org.semanticwb.model.RuleRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Filterable
{
   /**
   * Tipo de Página, este tipo no se puede crear en el árbol de WebBuilder, solo sirve para ponerle la interfaz de fotos y que las subclases de esta clase poseean los atributos de esta interface (cptmGeneralData).
   */
    public static final org.semanticwb.platform.SemanticClass cptm_CPTMPhotoWebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMPhotoWebPage");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CPTMPhotoWebPage");

    public static class ClassMgr
    {
       /**
       * Returns a list of CPTMPhotoWebPage for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPages(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CPTMPhotoWebPage for all models
       * @return Iterator of org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPages()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CPTMPhotoWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMPhotoWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return A org.semanticwb.cptm.CPTMPhotoWebPage
       */
        public static org.semanticwb.cptm.CPTMPhotoWebPage getCPTMPhotoWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMPhotoWebPage)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CPTMPhotoWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMPhotoWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return A org.semanticwb.cptm.CPTMPhotoWebPage
       */
        public static org.semanticwb.cptm.CPTMPhotoWebPage createCPTMPhotoWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CPTMPhotoWebPage)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CPTMPhotoWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMPhotoWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       */
        public static void removeCPTMPhotoWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CPTMPhotoWebPage
       * @param id Identifier for org.semanticwb.cptm.CPTMPhotoWebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return true if the org.semanticwb.cptm.CPTMPhotoWebPage exists, false otherwise
       */

        public static boolean hasCPTMPhotoWebPage(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCPTMPhotoWebPage(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.CPTMPhotoWebPage
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CPTMPhotoWebPage with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.CPTMPhotoWebPage
       */

        public static java.util.Iterator<org.semanticwb.cptm.CPTMPhotoWebPage> listCPTMPhotoWebPageByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CPTMPhotoWebPage> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPTMPhotoWebPageBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CPTMPhotoWebPage
   */
    public CPTMPhotoWebPageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
}
