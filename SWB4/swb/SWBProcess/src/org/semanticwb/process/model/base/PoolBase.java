package org.semanticwb.process.model.base;


public abstract class PoolBase extends org.semanticwb.process.model.GraphicalElement implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Referensable,org.semanticwb.model.RoleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Traceable,org.semanticwb.process.model.ResourceAssignmentable,org.semanticwb.model.RuleRefable
{
    public static final org.semanticwb.platform.SemanticClass swp_Pool=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#Pool");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#Pool");

    public static class ClassMgr
    {
       /**
       * Returns a list of Pool for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPools(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.Pool for all models
       * @return Iterator of org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPools()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool>(it, true);
        }

        public static org.semanticwb.process.model.Pool createPool(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.Pool.ClassMgr.createPool(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return A org.semanticwb.process.model.Pool
       */
        public static org.semanticwb.process.model.Pool getPool(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.Pool)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return A org.semanticwb.process.model.Pool
       */
        public static org.semanticwb.process.model.Pool createPool(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.Pool)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       */
        public static void removePool(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return true if the org.semanticwb.process.model.Pool exists, false otherwise
       */

        public static boolean hasPool(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPool(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByChild(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByChild(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByParent(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_parent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByParent(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_parent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByContainer(org.semanticwb.process.model.Containerable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_container, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByContainer(org.semanticwb.process.model.Containerable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_container,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PoolBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Pool
   */
    public PoolBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ResourceAssignationRule property
* @return int with the ResourceAssignationRule
*/
    public int getResourceAssignationRule()
    {
        return getSemanticObject().getIntProperty(swp_resourceAssignationRule);
    }

/**
* Sets the ResourceAssignationRule property
* @param value long with the ResourceAssignationRule
*/
    public void setResourceAssignationRule(int value)
    {
        getSemanticObject().setIntProperty(swp_resourceAssignationRule, value);
    }
   /**
   * Gets all the org.semanticwb.model.RuleRef
   * @return A GenericIterator with all the org.semanticwb.model.RuleRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef> listRuleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef>(getSemanticObject().listObjectProperties(swb_hasRuleRef));
    }

   /**
   * Gets true if has a RuleRef
   * @param value org.semanticwb.model.RuleRef to verify
   * @return true if the org.semanticwb.model.RuleRef exists, false otherwise
   */
    public boolean hasRuleRef(org.semanticwb.model.RuleRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasRuleRef,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets all the RuleRefs inherits
   * @return A GenericIterator with all the org.semanticwb.model.RuleRef
   */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef> listInheritRuleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef>(getSemanticObject().listInheritProperties(swb_hasRuleRef));
    }
   /**
   * Adds a RuleRef
   * @param value org.semanticwb.model.RuleRef to add
   */

    public void addRuleRef(org.semanticwb.model.RuleRef value)
    {
        getSemanticObject().addObjectProperty(swb_hasRuleRef, value.getSemanticObject());
    }
   /**
   * Removes all the RuleRef
   */

    public void removeAllRuleRef()
    {
        getSemanticObject().removeProperty(swb_hasRuleRef);
    }
   /**
   * Removes a RuleRef
   * @param value org.semanticwb.model.RuleRef to remove
   */

    public void removeRuleRef(org.semanticwb.model.RuleRef value)
    {
        getSemanticObject().removeObjectProperty(swb_hasRuleRef,value.getSemanticObject());
    }

   /**
   * Gets the RuleRef
   * @return a org.semanticwb.model.RuleRef
   */
    public org.semanticwb.model.RuleRef getRuleRef()
    {
         org.semanticwb.model.RuleRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRuleRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.RuleRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.UserGroupRef
   * @return A GenericIterator with all the org.semanticwb.model.UserGroupRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef> listUserGroupRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef>(getSemanticObject().listObjectProperties(swb_hasUserGroupRef));
    }

   /**
   * Gets true if has a UserGroupRef
   * @param value org.semanticwb.model.UserGroupRef to verify
   * @return true if the org.semanticwb.model.UserGroupRef exists, false otherwise
   */
    public boolean hasUserGroupRef(org.semanticwb.model.UserGroupRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasUserGroupRef,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets all the UserGroupRefs inherits
   * @return A GenericIterator with all the org.semanticwb.model.UserGroupRef
   */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef> listInheritUserGroupRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef>(getSemanticObject().listInheritProperties(swb_hasUserGroupRef));
    }
   /**
   * Adds a UserGroupRef
   * @param value org.semanticwb.model.UserGroupRef to add
   */

    public void addUserGroupRef(org.semanticwb.model.UserGroupRef value)
    {
        getSemanticObject().addObjectProperty(swb_hasUserGroupRef, value.getSemanticObject());
    }
   /**
   * Removes all the UserGroupRef
   */

    public void removeAllUserGroupRef()
    {
        getSemanticObject().removeProperty(swb_hasUserGroupRef);
    }
   /**
   * Removes a UserGroupRef
   * @param value org.semanticwb.model.UserGroupRef to remove
   */

    public void removeUserGroupRef(org.semanticwb.model.UserGroupRef value)
    {
        getSemanticObject().removeObjectProperty(swb_hasUserGroupRef,value.getSemanticObject());
    }

   /**
   * Gets the UserGroupRef
   * @return a org.semanticwb.model.UserGroupRef
   */
    public org.semanticwb.model.UserGroupRef getUserGroupRef()
    {
         org.semanticwb.model.UserGroupRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasUserGroupRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroupRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.RoleRef
   * @return A GenericIterator with all the org.semanticwb.model.RoleRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listRoleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listObjectProperties(swb_hasRoleRef));
    }

   /**
   * Gets true if has a RoleRef
   * @param value org.semanticwb.model.RoleRef to verify
   * @return true if the org.semanticwb.model.RoleRef exists, false otherwise
   */
    public boolean hasRoleRef(org.semanticwb.model.RoleRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasRoleRef,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets all the RoleRefs inherits
   * @return A GenericIterator with all the org.semanticwb.model.RoleRef
   */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listInheritRoleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listInheritProperties(swb_hasRoleRef));
    }
   /**
   * Adds a RoleRef
   * @param value org.semanticwb.model.RoleRef to add
   */

    public void addRoleRef(org.semanticwb.model.RoleRef value)
    {
        getSemanticObject().addObjectProperty(swb_hasRoleRef, value.getSemanticObject());
    }
   /**
   * Removes all the RoleRef
   */

    public void removeAllRoleRef()
    {
        getSemanticObject().removeProperty(swb_hasRoleRef);
    }
   /**
   * Removes a RoleRef
   * @param value org.semanticwb.model.RoleRef to remove
   */

    public void removeRoleRef(org.semanticwb.model.RoleRef value)
    {
        getSemanticObject().removeObjectProperty(swb_hasRoleRef,value.getSemanticObject());
    }

   /**
   * Gets the RoleRef
   * @return a org.semanticwb.model.RoleRef
   */
    public org.semanticwb.model.RoleRef getRoleRef()
    {
         org.semanticwb.model.RoleRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRoleRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.RoleRef)obj.createGenericInstance();
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
