package org.semanticwb.bsc.element.base;


public abstract class BSCElementBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.RoleRefable,org.semanticwb.model.Traceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Trashable,org.semanticwb.model.FilterableClass,org.semanticwb.bsc.Attachmentable,org.semanticwb.model.Filterable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Searchable,org.semanticwb.model.FilterableNode,org.semanticwb.bsc.Help
{
    public static final org.semanticwb.platform.SemanticClass bsc_BSCElement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#BSCElement");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#BSCElement");

    public static class ClassMgr
    {
       /**
       * Returns a list of BSCElement for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElements(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.BSCElement for all models
       * @return Iterator of org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElements()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement>(it, true);
        }

        public static org.semanticwb.bsc.element.BSCElement createBSCElement(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.element.BSCElement.ClassMgr.createBSCElement(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.element.BSCElement
       * @param id Identifier for org.semanticwb.bsc.element.BSCElement
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return A org.semanticwb.bsc.element.BSCElement
       */
        public static org.semanticwb.bsc.element.BSCElement getBSCElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.BSCElement)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.BSCElement
       * @param id Identifier for org.semanticwb.bsc.element.BSCElement
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return A org.semanticwb.bsc.element.BSCElement
       */
        public static org.semanticwb.bsc.element.BSCElement createBSCElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.BSCElement)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.BSCElement
       * @param id Identifier for org.semanticwb.bsc.element.BSCElement
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       */
        public static void removeBSCElement(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.BSCElement
       * @param id Identifier for org.semanticwb.bsc.element.BSCElement
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return true if the org.semanticwb.bsc.element.BSCElement exists, false otherwise
       */

        public static boolean hasBSCElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBSCElement(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByAttachments(org.semanticwb.bsc.catalogs.Attachment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByAttachments(org.semanticwb.bsc.catalogs.Attachment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.bsc.element.BSCElement
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.BSCElement with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.bsc.element.BSCElement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.BSCElement> listBSCElementByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.BSCElement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static BSCElementBase.ClassMgr getBSCElementClassMgr()
    {
        return new BSCElementBase.ClassMgr();
    }

   /**
   * Constructs a BSCElementBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BSCElement
   */
    public BSCElementBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NotInheritRoleRef property
* @return boolean with the NotInheritRoleRef
*/
    public boolean isNotInheritRoleRef()
    {
        return getSemanticObject().getBooleanProperty(swb_notInheritRoleRef);
    }

/**
* Sets the NotInheritRoleRef property
* @param value long with the NotInheritRoleRef
*/
    public void setNotInheritRoleRef(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_notInheritRoleRef, value);
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Help property
* @return String with the Help
*/
    public String getHelp()
    {
        return getSemanticObject().getProperty(bsc_help);
    }

/**
* Sets the Help property
* @param value long with the Help
*/
    public void setHelp(String value)
    {
        getSemanticObject().setProperty(bsc_help, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

/**
* Gets the NotInheritUserGroupRef property
* @return boolean with the NotInheritUserGroupRef
*/
    public boolean isNotInheritUserGroupRef()
    {
        return getSemanticObject().getBooleanProperty(swb_notInheritUserGroupRef);
    }

/**
* Sets the NotInheritUserGroupRef property
* @param value long with the NotInheritUserGroupRef
*/
    public void setNotInheritUserGroupRef(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_notInheritUserGroupRef, value);
    }

/**
* Gets the Deleted property
* @return boolean with the Deleted
*/
    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

/**
* Sets the Deleted property
* @param value long with the Deleted
*/
    public void setDeleted(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, value);
    }

/**
* Gets the NotInheritRuleRef property
* @return boolean with the NotInheritRuleRef
*/
    public boolean isNotInheritRuleRef()
    {
        return getSemanticObject().getBooleanProperty(swb_notInheritRuleRef);
    }

/**
* Sets the NotInheritRuleRef property
* @param value long with the NotInheritRuleRef
*/
    public void setNotInheritRuleRef(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_notInheritRuleRef, value);
    }
   /**
   * Gets all the org.semanticwb.bsc.catalogs.Attachment
   * @return A GenericIterator with all the org.semanticwb.bsc.catalogs.Attachment
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Attachment> listAttachmentses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Attachment>(getSemanticObject().listObjectProperties(bsc_hasAttachments));
    }

   /**
   * Gets true if has a Attachments
   * @param value org.semanticwb.bsc.catalogs.Attachment to verify
   * @return true if the org.semanticwb.bsc.catalogs.Attachment exists, false otherwise
   */
    public boolean hasAttachments(org.semanticwb.bsc.catalogs.Attachment value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasAttachments,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Attachments
   * @param value org.semanticwb.bsc.catalogs.Attachment to add
   */

    public void addAttachments(org.semanticwb.bsc.catalogs.Attachment value)
    {
        getSemanticObject().addObjectProperty(bsc_hasAttachments, value.getSemanticObject());
    }
   /**
   * Removes all the Attachments
   */

    public void removeAllAttachments()
    {
        getSemanticObject().removeProperty(bsc_hasAttachments);
    }
   /**
   * Removes a Attachments
   * @param value org.semanticwb.bsc.catalogs.Attachment to remove
   */

    public void removeAttachments(org.semanticwb.bsc.catalogs.Attachment value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasAttachments,value.getSemanticObject());
    }

   /**
   * Gets the Attachments
   * @return a org.semanticwb.bsc.catalogs.Attachment
   */
    public org.semanticwb.bsc.catalogs.Attachment getAttachments()
    {
         org.semanticwb.bsc.catalogs.Attachment ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasAttachments);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.catalogs.Attachment)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
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
* Gets the AndEvalUserGroupRef property
* @return boolean with the AndEvalUserGroupRef
*/
    public boolean isAndEvalUserGroupRef()
    {
        return getSemanticObject().getBooleanProperty(swb_andEvalUserGroupRef);
    }

/**
* Sets the AndEvalUserGroupRef property
* @param value long with the AndEvalUserGroupRef
*/
    public void setAndEvalUserGroupRef(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_andEvalUserGroupRef, value);
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
* Gets the AndEvalRoleRef property
* @return boolean with the AndEvalRoleRef
*/
    public boolean isAndEvalRoleRef()
    {
        return getSemanticObject().getBooleanProperty(swb_andEvalRoleRef);
    }

/**
* Sets the AndEvalRoleRef property
* @param value long with the AndEvalRoleRef
*/
    public void setAndEvalRoleRef(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_andEvalRoleRef, value);
    }

/**
* Gets the AndEvalRuleRef property
* @return boolean with the AndEvalRuleRef
*/
    public boolean isAndEvalRuleRef()
    {
        return getSemanticObject().getBooleanProperty(swb_andEvalRuleRef);
    }

/**
* Sets the AndEvalRuleRef property
* @param value long with the AndEvalRuleRef
*/
    public void setAndEvalRuleRef(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_andEvalRuleRef, value);
    }
}
