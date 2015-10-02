package org.semanticwb.bsc.accessory.base;


public abstract class PeriodGroupBase extends org.semanticwb.bsc.accessory.BSCAccessory implements org.semanticwb.model.Undeleteable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.RoleRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Filterable,org.semanticwb.model.FilterableNode,org.semanticwb.bsc.Help,org.semanticwb.model.Referensable
{
   /**
   * Período de medición.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Period=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Period");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasGroupedPeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasGroupedPeriod");
    public static final org.semanticwb.platform.SemanticClass bsc_PeriodGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#PeriodGroup");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#PeriodGroup");

    public static class ClassMgr
    {
       /**
       * Returns a list of PeriodGroup for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroups(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.accessory.PeriodGroup for all models
       * @return Iterator of org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroups()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup>(it, true);
        }

        public static org.semanticwb.bsc.accessory.PeriodGroup createPeriodGroup(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.accessory.PeriodGroup.ClassMgr.createPeriodGroup(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.accessory.PeriodGroup
       * @param id Identifier for org.semanticwb.bsc.accessory.PeriodGroup
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return A org.semanticwb.bsc.accessory.PeriodGroup
       */
        public static org.semanticwb.bsc.accessory.PeriodGroup getPeriodGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.accessory.PeriodGroup)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.accessory.PeriodGroup
       * @param id Identifier for org.semanticwb.bsc.accessory.PeriodGroup
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return A org.semanticwb.bsc.accessory.PeriodGroup
       */
        public static org.semanticwb.bsc.accessory.PeriodGroup createPeriodGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.accessory.PeriodGroup)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.accessory.PeriodGroup
       * @param id Identifier for org.semanticwb.bsc.accessory.PeriodGroup
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       */
        public static void removePeriodGroup(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.accessory.PeriodGroup
       * @param id Identifier for org.semanticwb.bsc.accessory.PeriodGroup
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return true if the org.semanticwb.bsc.accessory.PeriodGroup exists, false otherwise
       */

        public static boolean hasPeriodGroup(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPeriodGroup(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined GroupedPeriod
       * @param value GroupedPeriod of the type org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByGroupedPeriod(org.semanticwb.bsc.accessory.Period value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasGroupedPeriod, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined GroupedPeriod
       * @param value GroupedPeriod of the type org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByGroupedPeriod(org.semanticwb.bsc.accessory.Period value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasGroupedPeriod,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.bsc.accessory.PeriodGroup
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.accessory.PeriodGroup with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.bsc.accessory.PeriodGroup
       */

        public static java.util.Iterator<org.semanticwb.bsc.accessory.PeriodGroup> listPeriodGroupByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.PeriodGroup> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PeriodGroupBase.ClassMgr getPeriodGroupClassMgr()
    {
        return new PeriodGroupBase.ClassMgr();
    }

   /**
   * Constructs a PeriodGroupBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PeriodGroup
   */
    public PeriodGroupBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.bsc.accessory.Period
   * @return A GenericIterator with all the org.semanticwb.bsc.accessory.Period
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> listGroupedPeriods()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period>(getSemanticObject().listObjectProperties(bsc_hasGroupedPeriod));
    }

   /**
   * Gets true if has a GroupedPeriod
   * @param value org.semanticwb.bsc.accessory.Period to verify
   * @return true if the org.semanticwb.bsc.accessory.Period exists, false otherwise
   */
    public boolean hasGroupedPeriod(org.semanticwb.bsc.accessory.Period value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasGroupedPeriod,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a GroupedPeriod
   * @param value org.semanticwb.bsc.accessory.Period to add
   */

    public void addGroupedPeriod(org.semanticwb.bsc.accessory.Period value)
    {
        getSemanticObject().addObjectProperty(bsc_hasGroupedPeriod, value.getSemanticObject());
    }
   /**
   * Removes all the GroupedPeriod
   */

    public void removeAllGroupedPeriod()
    {
        getSemanticObject().removeProperty(bsc_hasGroupedPeriod);
    }
   /**
   * Removes a GroupedPeriod
   * @param value org.semanticwb.bsc.accessory.Period to remove
   */

    public void removeGroupedPeriod(org.semanticwb.bsc.accessory.Period value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasGroupedPeriod,value.getSemanticObject());
    }

   /**
   * Gets the GroupedPeriod
   * @return a org.semanticwb.bsc.accessory.Period
   */
    public org.semanticwb.bsc.accessory.Period getGroupedPeriod()
    {
         org.semanticwb.bsc.accessory.Period ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasGroupedPeriod);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.accessory.Period)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the BSC
   * @return a instance of org.semanticwb.bsc.BSC
   */
    public org.semanticwb.bsc.BSC getBSC()
    {
        return (org.semanticwb.bsc.BSC)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
