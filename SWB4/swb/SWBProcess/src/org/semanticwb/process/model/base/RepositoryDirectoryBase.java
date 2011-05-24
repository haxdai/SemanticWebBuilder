package org.semanticwb.process.model.base;


public abstract class RepositoryDirectoryBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Undeleteable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Countryable,org.semanticwb.model.FilterableClass,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Expirable,org.semanticwb.model.Searchable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Viewable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Filterable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.Localeable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Hiddenable,org.semanticwb.model.Tagable,org.semanticwb.model.Trashable,org.semanticwb.model.Resourceable,org.semanticwb.model.Indexable,org.semanticwb.model.TemplateRefable
{
    public static final org.semanticwb.platform.SemanticClass swp_RepositoryFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#RepositoryFile");
    public static final org.semanticwb.platform.SemanticProperty swp_hasRepositoryFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/process#hasRepositoryFile");
    public static final org.semanticwb.platform.SemanticClass swp_RepositoryDirectory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#RepositoryDirectory");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#RepositoryDirectory");

    public static class ClassMgr
    {
       /**
       * Returns a list of RepositoryDirectory for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.RepositoryDirectory for all models
       * @return Iterator of org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory>(it, true);
        }
       /**
       * Gets a org.semanticwb.process.model.RepositoryDirectory
       * @param id Identifier for org.semanticwb.process.model.RepositoryDirectory
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return A org.semanticwb.process.model.RepositoryDirectory
       */
        public static org.semanticwb.process.model.RepositoryDirectory getRepositoryDirectory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.RepositoryDirectory)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.RepositoryDirectory
       * @param id Identifier for org.semanticwb.process.model.RepositoryDirectory
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return A org.semanticwb.process.model.RepositoryDirectory
       */
        public static org.semanticwb.process.model.RepositoryDirectory createRepositoryDirectory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.RepositoryDirectory)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.RepositoryDirectory
       * @param id Identifier for org.semanticwb.process.model.RepositoryDirectory
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       */
        public static void removeRepositoryDirectory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.RepositoryDirectory
       * @param id Identifier for org.semanticwb.process.model.RepositoryDirectory
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return true if the org.semanticwb.process.model.RepositoryDirectory exists, false otherwise
       */

        public static boolean hasRepositoryDirectory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRepositoryDirectory(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined RepositoryFile
       * @param value RepositoryFile of the type org.semanticwb.process.model.RepositoryFile
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByRepositoryFile(org.semanticwb.process.model.RepositoryFile value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasRepositoryFile, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined RepositoryFile
       * @param value RepositoryFile of the type org.semanticwb.process.model.RepositoryFile
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByRepositoryFile(org.semanticwb.process.model.RepositoryFile value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasRepositoryFile,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.process.model.RepositoryDirectory
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.RepositoryDirectory with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.process.model.RepositoryDirectory
       */

        public static java.util.Iterator<org.semanticwb.process.model.RepositoryDirectory> listRepositoryDirectoryByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryDirectory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a RepositoryDirectoryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RepositoryDirectory
   */
    public RepositoryDirectoryBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.process.model.RepositoryFile
   * @return A GenericIterator with all the org.semanticwb.process.model.RepositoryFile
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryFile> listRepositoryFiles()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.RepositoryFile>(getSemanticObject().listObjectProperties(swp_hasRepositoryFile));
    }

   /**
   * Gets true if has a RepositoryFile
   * @param value org.semanticwb.process.model.RepositoryFile to verify
   * @return true if the org.semanticwb.process.model.RepositoryFile exists, false otherwise
   */
    public boolean hasRepositoryFile(org.semanticwb.process.model.RepositoryFile value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swp_hasRepositoryFile,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the RepositoryFile
   * @return a org.semanticwb.process.model.RepositoryFile
   */
    public org.semanticwb.process.model.RepositoryFile getRepositoryFile()
    {
         org.semanticwb.process.model.RepositoryFile ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swp_hasRepositoryFile);
         if(obj!=null)
         {
             ret=(org.semanticwb.process.model.RepositoryFile)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the ProcessSite
   * @return a instance of org.semanticwb.process.model.ProcessSite
   */
    public org.semanticwb.process.model.ProcessSite getProcessSite()
    {
        return (org.semanticwb.process.model.ProcessSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
