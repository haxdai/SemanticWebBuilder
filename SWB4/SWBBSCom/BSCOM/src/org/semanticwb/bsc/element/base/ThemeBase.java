package org.semanticwb.bsc.element.base;


public abstract class ThemeBase extends org.semanticwb.bsc.element.BSCElement implements org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Sortable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass bsc_Objective=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Objective");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasObjective=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasObjective");
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
       * @return Iterator of org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.Theme for all models
       * @return Iterator of org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme>(it, true);
        }

        public static org.semanticwb.bsc.element.Theme createTheme(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.element.Theme.ClassMgr.createTheme(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.element.Theme
       * @param id Identifier for org.semanticwb.bsc.element.Theme
       * @param model Model of the org.semanticwb.bsc.element.Theme
       * @return A org.semanticwb.bsc.element.Theme
       */
        public static org.semanticwb.bsc.element.Theme getTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Theme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.Theme
       * @param id Identifier for org.semanticwb.bsc.element.Theme
       * @param model Model of the org.semanticwb.bsc.element.Theme
       * @return A org.semanticwb.bsc.element.Theme
       */
        public static org.semanticwb.bsc.element.Theme createTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Theme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.Theme
       * @param id Identifier for org.semanticwb.bsc.element.Theme
       * @param model Model of the org.semanticwb.bsc.element.Theme
       */
        public static void removeTheme(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.Theme
       * @param id Identifier for org.semanticwb.bsc.element.Theme
       * @param model Model of the org.semanticwb.bsc.element.Theme
       * @return true if the org.semanticwb.bsc.element.Theme exists, false otherwise
       */

        public static boolean hasTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTheme(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.Theme with a determined Objective
       * @param value Objective of the type org.semanticwb.bsc.Objective
       * @param model Model of the org.semanticwb.bsc.element.Theme
       * @return Iterator with all the org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemeByObjective(org.semanticwb.bsc.Objective value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasObjective, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Theme with a determined Objective
       * @param value Objective of the type org.semanticwb.bsc.Objective
       * @return Iterator with all the org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemeByObjective(org.semanticwb.bsc.Objective value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasObjective,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Theme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Theme
       * @return Iterator with all the org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Theme with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Theme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Theme
       * @return Iterator with all the org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Theme with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Theme
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Theme> listThemeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
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
   * Gets all the org.semanticwb.bsc.Objective
   * @return A GenericIterator with all the org.semanticwb.bsc.Objective
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Objective> listObjectives()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.Objective>(getSemanticObject().listObjectProperties(bsc_hasObjective));
    }

   /**
   * Gets true if has a Objective
   * @param value org.semanticwb.bsc.Objective to verify
   * @return true if the org.semanticwb.bsc.Objective exists, false otherwise
   */
    public boolean hasObjective(org.semanticwb.bsc.Objective value)
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
   * @param value org.semanticwb.bsc.Objective to add
   */

    public void addObjective(org.semanticwb.bsc.Objective value)
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
   * @param value org.semanticwb.bsc.Objective to remove
   */

    public void removeObjective(org.semanticwb.bsc.Objective value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasObjective,value.getSemanticObject());
    }

   /**
   * Gets the Objective
   * @return a org.semanticwb.bsc.Objective
   */
    public org.semanticwb.bsc.Objective getObjective()
    {
         org.semanticwb.bsc.Objective ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasObjective);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.Objective)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(swb_index, value);
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
}
