package org.semanticwb.bsc.base;


   /**
   * Los temas estratégicos agrupan objetivos con fines en común. A su vez, los temas están agrupados dentro de las perspectivas. 
   */
public abstract class ThemeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.RoleRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Filterable,org.semanticwb.bsc.Sortable,org.semanticwb.bsc.Causal,org.semanticwb.model.FilterableClass,org.semanticwb.model.Hiddenable,org.semanticwb.bsc.Help,org.semanticwb.model.FilterableNode,org.semanticwb.model.Referensable
{
   /**
   * Define las características de un Objetivo estratégico.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Objective=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Objective");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasObjective=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasObjective");
    public static final org.semanticwb.platform.SemanticClass bsc_Perspective=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Perspective");
    public static final org.semanticwb.platform.SemanticProperty bsc_perspectiveInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#perspectiveInv");
   /**
   * Los temas estratégicos agrupan objetivos con fines en común. A su vez, los temas están agrupados dentro de las perspectivas.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Theme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Theme");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Theme");

    public static class ClassMgr
    {
       /**
       * Returns a list of Theme for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.Theme for all models
       * @return Iterator of org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme>(it, true);
        }

        public static org.semanticwb.bsc.Theme createTheme(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.Theme.ClassMgr.createTheme(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.Theme
       * @param id Identifier for org.semanticwb.bsc.Theme
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return A org.semanticwb.bsc.Theme
       */
        public static org.semanticwb.bsc.Theme getTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.Theme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.Theme
       * @param id Identifier for org.semanticwb.bsc.Theme
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return A org.semanticwb.bsc.Theme
       */
        public static org.semanticwb.bsc.Theme createTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.Theme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.Theme
       * @param id Identifier for org.semanticwb.bsc.Theme
       * @param model Model of the org.semanticwb.bsc.Theme
       */
        public static void removeTheme(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.Theme
       * @param id Identifier for org.semanticwb.bsc.Theme
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return true if the org.semanticwb.bsc.Theme exists, false otherwise
       */

        public static boolean hasTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTheme(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined Objective
       * @param value Objective of the type org.semanticwb.bsc.element.Objective
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByObjective(org.semanticwb.bsc.element.Objective value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasObjective, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined Objective
       * @param value Objective of the type org.semanticwb.bsc.element.Objective
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByObjective(org.semanticwb.bsc.element.Objective value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasObjective,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined CausalTheme
       * @param value CausalTheme of the type org.semanticwb.bsc.Theme
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByCausalTheme(org.semanticwb.bsc.Theme value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasCausalTheme, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined CausalTheme
       * @param value CausalTheme of the type org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByCausalTheme(org.semanticwb.bsc.Theme value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasCausalTheme,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined CausalObjective
       * @param value CausalObjective of the type org.semanticwb.bsc.element.Objective
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByCausalObjective(org.semanticwb.bsc.element.Objective value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasCausalObjective, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined CausalObjective
       * @param value CausalObjective of the type org.semanticwb.bsc.element.Objective
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByCausalObjective(org.semanticwb.bsc.element.Objective value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasCausalObjective,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined Perspective
       * @param value Perspective of the type org.semanticwb.bsc.Perspective
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByPerspective(org.semanticwb.bsc.Perspective value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_perspectiveInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined Perspective
       * @param value Perspective of the type org.semanticwb.bsc.Perspective
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByPerspective(org.semanticwb.bsc.Perspective value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_perspectiveInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.bsc.Theme
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.Theme with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.bsc.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.Theme> listThemeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ThemeBase.ClassMgr getThemeClassMgr()
    {
        return new ThemeBase.ClassMgr();
    }

   /**
   * Constructs a ThemeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Theme
   */
    public ThemeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.bsc.element.Objective
   * @return A GenericIterator with all the org.semanticwb.bsc.element.Objective
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Objective> listObjectives()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Objective>(getSemanticObject().listObjectProperties(bsc_hasObjective));
    }

   /**
   * Gets true if has a Objective
   * @param value org.semanticwb.bsc.element.Objective to verify
   * @return true if the org.semanticwb.bsc.element.Objective exists, false otherwise
   */
    public boolean hasObjective(org.semanticwb.bsc.element.Objective value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasObjective,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Objective
   * @param value org.semanticwb.bsc.element.Objective to add
   */

    public void addObjective(org.semanticwb.bsc.element.Objective value)
    {
        getSemanticObject().addObjectProperty(bsc_hasObjective, value.getSemanticObject());
    }
   /**
   * Removes all the Objective
   */

    public void removeAllObjective()
    {
        getSemanticObject().removeProperty(bsc_hasObjective);
    }
   /**
   * Removes a Objective
   * @param value org.semanticwb.bsc.element.Objective to remove
   */

    public void removeObjective(org.semanticwb.bsc.element.Objective value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasObjective,value.getSemanticObject());
    }

   /**
   * Gets the Objective
   * @return a org.semanticwb.bsc.element.Objective
   */
    public org.semanticwb.bsc.element.Objective getObjective()
    {
         org.semanticwb.bsc.element.Objective ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasObjective);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.element.Objective)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the org.semanticwb.bsc.Theme
   * @return A GenericIterator with all the org.semanticwb.bsc.Theme
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme> listCausalThemes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Theme>(getSemanticObject().listObjectProperties(bsc_hasCausalTheme));
    }

   /**
   * Gets true if has a CausalTheme
   * @param value org.semanticwb.bsc.Theme to verify
   * @return true if the org.semanticwb.bsc.Theme exists, false otherwise
   */
    public boolean hasCausalTheme(org.semanticwb.bsc.Theme value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasCausalTheme,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CausalTheme
   * @param value org.semanticwb.bsc.Theme to add
   */

    public void addCausalTheme(org.semanticwb.bsc.Theme value)
    {
        getSemanticObject().addObjectProperty(bsc_hasCausalTheme, value.getSemanticObject());
    }
   /**
   * Removes all the CausalTheme
   */

    public void removeAllCausalTheme()
    {
        getSemanticObject().removeProperty(bsc_hasCausalTheme);
    }
   /**
   * Removes a CausalTheme
   * @param value org.semanticwb.bsc.Theme to remove
   */

    public void removeCausalTheme(org.semanticwb.bsc.Theme value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasCausalTheme,value.getSemanticObject());
    }

   /**
   * Gets the CausalTheme
   * @return a org.semanticwb.bsc.Theme
   */
    public org.semanticwb.bsc.Theme getCausalTheme()
    {
         org.semanticwb.bsc.Theme ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasCausalTheme);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.Theme)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        //Override this method in Theme object
        return getSemanticObject().getIntProperty(bsc_index,false);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        //Override this method in Theme object
        getSemanticObject().setIntProperty(bsc_index, value,false);
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
   * Gets all the org.semanticwb.bsc.element.Objective
   * @return A GenericIterator with all the org.semanticwb.bsc.element.Objective
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Objective> listCausalObjectives()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Objective>(getSemanticObject().listObjectProperties(bsc_hasCausalObjective));
    }

   /**
   * Gets true if has a CausalObjective
   * @param value org.semanticwb.bsc.element.Objective to verify
   * @return true if the org.semanticwb.bsc.element.Objective exists, false otherwise
   */
    public boolean hasCausalObjective(org.semanticwb.bsc.element.Objective value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasCausalObjective,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CausalObjective
   * @param value org.semanticwb.bsc.element.Objective to add
   */

    public void addCausalObjective(org.semanticwb.bsc.element.Objective value)
    {
        getSemanticObject().addObjectProperty(bsc_hasCausalObjective, value.getSemanticObject());
    }
   /**
   * Removes all the CausalObjective
   */

    public void removeAllCausalObjective()
    {
        getSemanticObject().removeProperty(bsc_hasCausalObjective);
    }
   /**
   * Removes a CausalObjective
   * @param value org.semanticwb.bsc.element.Objective to remove
   */

    public void removeCausalObjective(org.semanticwb.bsc.element.Objective value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasCausalObjective,value.getSemanticObject());
    }

   /**
   * Gets the CausalObjective
   * @return a org.semanticwb.bsc.element.Objective
   */
    public org.semanticwb.bsc.element.Objective getCausalObjective()
    {
         org.semanticwb.bsc.element.Objective ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasCausalObjective);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.element.Objective)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Perspective
   * @param value Perspective to set
   */

    public void setPerspective(org.semanticwb.bsc.Perspective value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_perspectiveInv, value.getSemanticObject());
        }else
        {
            removePerspective();
        }
    }
   /**
   * Remove the value for Perspective property
   */

    public void removePerspective()
    {
        getSemanticObject().removeProperty(bsc_perspectiveInv);
    }

   /**
   * Gets the Perspective
   * @return a org.semanticwb.bsc.Perspective
   */
    public org.semanticwb.bsc.Perspective getPerspective()
    {
         org.semanticwb.bsc.Perspective ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_perspectiveInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.Perspective)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Hidden property
* @return boolean with the Hidden
*/
    public boolean isHidden()
    {
        return getSemanticObject().getBooleanProperty(swb_hidden);
    }

/**
* Sets the Hidden property
* @param value long with the Hidden
*/
    public void setHidden(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_hidden, value);
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
