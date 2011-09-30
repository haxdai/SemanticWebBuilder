package org.semanticwb.promexico.base;


   /**
   * Datos de un representante, se utiliza para las oficinas y para las regiones 
   */
public abstract class ManagerBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty promx_repreFax=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#repreFax");
    public static final org.semanticwb.platform.SemanticProperty promx_repreName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#repreName");
    public static final org.semanticwb.platform.SemanticProperty promx_reprePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#reprePhoto");
    public static final org.semanticwb.platform.SemanticProperty promx_repreAdress=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#repreAdress");
    public static final org.semanticwb.platform.SemanticProperty promx_repreEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#repreEmail");
    public static final org.semanticwb.platform.SemanticProperty promx_reprePhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#reprePhone");
   /**
   * Datos de un representante, se utiliza para las oficinas y para las regiones
   */
    public static final org.semanticwb.platform.SemanticClass promx_Manager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Manager");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Manager");

    public static class ClassMgr
    {
       /**
       * Returns a list of Manager for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Manager
       */

        public static java.util.Iterator<org.semanticwb.promexico.Manager> listManagers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Manager for all models
       * @return Iterator of org.semanticwb.promexico.Manager
       */

        public static java.util.Iterator<org.semanticwb.promexico.Manager> listManagers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager>(it, true);
        }

        public static org.semanticwb.promexico.Manager createManager(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.Manager.ClassMgr.createManager(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.Manager
       * @param id Identifier for org.semanticwb.promexico.Manager
       * @param model Model of the org.semanticwb.promexico.Manager
       * @return A org.semanticwb.promexico.Manager
       */
        public static org.semanticwb.promexico.Manager getManager(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Manager)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Manager
       * @param id Identifier for org.semanticwb.promexico.Manager
       * @param model Model of the org.semanticwb.promexico.Manager
       * @return A org.semanticwb.promexico.Manager
       */
        public static org.semanticwb.promexico.Manager createManager(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Manager)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Manager
       * @param id Identifier for org.semanticwb.promexico.Manager
       * @param model Model of the org.semanticwb.promexico.Manager
       */
        public static void removeManager(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Manager
       * @param id Identifier for org.semanticwb.promexico.Manager
       * @param model Model of the org.semanticwb.promexico.Manager
       * @return true if the org.semanticwb.promexico.Manager exists, false otherwise
       */

        public static boolean hasManager(String id, org.semanticwb.model.SWBModel model)
        {
            return (getManager(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Manager with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Manager
       * @return Iterator with all the org.semanticwb.promexico.Manager
       */

        public static java.util.Iterator<org.semanticwb.promexico.Manager> listManagerByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Manager with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Manager
       */

        public static java.util.Iterator<org.semanticwb.promexico.Manager> listManagerByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Manager with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Manager
       * @return Iterator with all the org.semanticwb.promexico.Manager
       */

        public static java.util.Iterator<org.semanticwb.promexico.Manager> listManagerByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Manager with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Manager
       */

        public static java.util.Iterator<org.semanticwb.promexico.Manager> listManagerByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ManagerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Manager
   */
    public ManagerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the RepreFax property
* @return String with the RepreFax
*/
    public String getRepreFax()
    {
        return getSemanticObject().getProperty(promx_repreFax);
    }

/**
* Sets the RepreFax property
* @param value long with the RepreFax
*/
    public void setRepreFax(String value)
    {
        getSemanticObject().setProperty(promx_repreFax, value);
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
* Gets the RepreName property
* @return String with the RepreName
*/
    public String getRepreName()
    {
        return getSemanticObject().getProperty(promx_repreName);
    }

/**
* Sets the RepreName property
* @param value long with the RepreName
*/
    public void setRepreName(String value)
    {
        getSemanticObject().setProperty(promx_repreName, value);
    }

/**
* Gets the ReprePhoto property
* @return String with the ReprePhoto
*/
    public String getReprePhoto()
    {
        return getSemanticObject().getProperty(promx_reprePhoto);
    }

/**
* Sets the ReprePhoto property
* @param value long with the ReprePhoto
*/
    public void setReprePhoto(String value)
    {
        getSemanticObject().setProperty(promx_reprePhoto, value);
    }

/**
* Gets the RepreAdress property
* @return String with the RepreAdress
*/
    public String getRepreAdress()
    {
        return getSemanticObject().getProperty(promx_repreAdress);
    }

/**
* Sets the RepreAdress property
* @param value long with the RepreAdress
*/
    public void setRepreAdress(String value)
    {
        getSemanticObject().setProperty(promx_repreAdress, value);
    }

/**
* Gets the RepreEmail property
* @return String with the RepreEmail
*/
    public String getRepreEmail()
    {
        return getSemanticObject().getProperty(promx_repreEmail);
    }

/**
* Sets the RepreEmail property
* @param value long with the RepreEmail
*/
    public void setRepreEmail(String value)
    {
        getSemanticObject().setProperty(promx_repreEmail, value);
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
* Gets the ReprePhone property
* @return String with the ReprePhone
*/
    public String getReprePhone()
    {
        return getSemanticObject().getProperty(promx_reprePhone);
    }

/**
* Sets the ReprePhone property
* @param value long with the ReprePhone
*/
    public void setReprePhone(String value)
    {
        getSemanticObject().setProperty(promx_reprePhone, value);
    }
}
