package com.infotec.lodp.swb.base;


public abstract class DeveloperBase extends org.semanticwb.model.User implements org.semanticwb.model.Expirable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Roleable,org.semanticwb.model.Filterable,org.semanticwb.model.UserGroupable,org.semanticwb.model.Referensable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass lodpcg_Developer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Developer");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Developer");

    public static class ClassMgr
    {
       /**
       * Returns a list of Developer for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDevelopers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Developer for all models
       * @return Iterator of com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDevelopers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer>(it, true);
        }

        public static com.infotec.lodp.swb.Developer createDeveloper(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Developer.ClassMgr.createDeveloper(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Developer
       * @param id Identifier for com.infotec.lodp.swb.Developer
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return A com.infotec.lodp.swb.Developer
       */
        public static com.infotec.lodp.swb.Developer getDeveloper(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Developer)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Developer
       * @param id Identifier for com.infotec.lodp.swb.Developer
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return A com.infotec.lodp.swb.Developer
       */
        public static com.infotec.lodp.swb.Developer createDeveloper(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Developer)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Developer
       * @param id Identifier for com.infotec.lodp.swb.Developer
       * @param model Model of the com.infotec.lodp.swb.Developer
       */
        public static void removeDeveloper(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Developer
       * @param id Identifier for com.infotec.lodp.swb.Developer
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return true if the com.infotec.lodp.swb.Developer exists, false otherwise
       */

        public static boolean hasDeveloper(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDeveloper(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined UserFavorite
       * @param value UserFavorite of the type org.semanticwb.model.UserFavorite
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByUserFavorite(org.semanticwb.model.UserFavorite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_usrFavorite, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined UserFavorite
       * @param value UserFavorite of the type org.semanticwb.model.UserFavorite
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByUserFavorite(org.semanticwb.model.UserFavorite value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_usrFavorite,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined AdminFilter
       * @param value AdminFilter of the type org.semanticwb.model.AdminFilter
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByAdminFilter(org.semanticwb.model.AdminFilter value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAdminFilter, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined AdminFilter
       * @param value AdminFilter of the type org.semanticwb.model.AdminFilter
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByAdminFilter(org.semanticwb.model.AdminFilter value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAdminFilter,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByUserGroup(org.semanticwb.model.UserGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByUserGroup(org.semanticwb.model.UserGroup value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByRole(org.semanticwb.model.Role value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByRole(org.semanticwb.model.Role value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the com.infotec.lodp.swb.Developer
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Developer with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the com.infotec.lodp.swb.Developer
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Developer> listDeveloperByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Developer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DeveloperBase.ClassMgr getDeveloperClassMgr()
    {
        return new DeveloperBase.ClassMgr();
    }

   /**
   * Constructs a DeveloperBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Developer
   */
    public DeveloperBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
