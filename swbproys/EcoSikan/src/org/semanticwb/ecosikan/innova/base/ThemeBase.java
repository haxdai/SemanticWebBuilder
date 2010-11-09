package org.semanticwb.ecosikan.innova.base;


public abstract class ThemeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Trashable
{
    public static final org.semanticwb.platform.SemanticProperty ecoskn_active=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#active");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Secretaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Secretaria");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_secretaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#secretaria");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasIdeas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasIdeas");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Theme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Theme");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Theme");

    public static class ClassMgr
    {
       /**
       * Returns a list of Theme for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Theme for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme>(it, true);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return A org.semanticwb.ecosikan.innova.Theme
       */
        public static org.semanticwb.ecosikan.innova.Theme getTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Theme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return A org.semanticwb.ecosikan.innova.Theme
       */
        public static org.semanticwb.ecosikan.innova.Theme createTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Theme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       */
        public static void removeTheme(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Theme
       * @param id Identifier for org.semanticwb.ecosikan.innova.Theme
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return true if the org.semanticwb.ecosikan.innova.Theme exists, false otherwise
       */

        public static boolean hasTheme(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTheme(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Secretaria
       * @param value Secretaria of the type org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeBySecretaria(org.semanticwb.ecosikan.innova.Secretaria value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_secretaria, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Secretaria
       * @param value Secretaria of the type org.semanticwb.ecosikan.innova.Secretaria
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeBySecretaria(org.semanticwb.ecosikan.innova.Secretaria value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_secretaria,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Ideas
       * @param value Ideas of the type org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Theme
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByIdeas(org.semanticwb.ecosikan.innova.Idea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdeas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Theme with a determined Ideas
       * @param value Ideas of the type org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Theme
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Theme> listThemeByIdeas(org.semanticwb.ecosikan.innova.Idea value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdeas,value.getSemanticObject(),sclass));
            return it;
        }
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
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(ecoskn_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(ecoskn_active, value);
    }
   /**
   * Sets the value for the property Secretaria
   * @param value Secretaria to set
   */

    public void setSecretaria(org.semanticwb.ecosikan.innova.Secretaria value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_secretaria, value.getSemanticObject());
        }else
        {
            removeSecretaria();
        }
    }
   /**
   * Remove the value for Secretaria property
   */

    public void removeSecretaria()
    {
        getSemanticObject().removeProperty(ecoskn_secretaria);
    }

   /**
   * Gets the Secretaria
   * @return a org.semanticwb.ecosikan.innova.Secretaria
   */
    public org.semanticwb.ecosikan.innova.Secretaria getSecretaria()
    {
         org.semanticwb.ecosikan.innova.Secretaria ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_secretaria);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Secretaria)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Idea
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Idea
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> listIdeases()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea>(getSemanticObject().listObjectProperties(ecoskn_hasIdeas));
    }

   /**
   * Gets true if has a Ideas
   * @param value org.semanticwb.ecosikan.innova.Idea to verify
   * @return true if the org.semanticwb.ecosikan.innova.Idea exists, false otherwise
   */
    public boolean hasIdeas(org.semanticwb.ecosikan.innova.Idea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasIdeas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Ideas
   * @param value org.semanticwb.ecosikan.innova.Idea to add
   */

    public void addIdeas(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasIdeas, value.getSemanticObject());
    }
   /**
   * Removes all the Ideas
   */

    public void removeAllIdeas()
    {
        getSemanticObject().removeProperty(ecoskn_hasIdeas);
    }
   /**
   * Removes a Ideas
   * @param value org.semanticwb.ecosikan.innova.Idea to remove
   */

    public void removeIdeas(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasIdeas,value.getSemanticObject());
    }

   /**
   * Gets the Ideas
   * @return a org.semanticwb.ecosikan.innova.Idea
   */
    public org.semanticwb.ecosikan.innova.Idea getIdeas()
    {
         org.semanticwb.ecosikan.innova.Idea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasIdeas);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Idea)obj.createGenericInstance();
         }
         return ret;
    }
}
