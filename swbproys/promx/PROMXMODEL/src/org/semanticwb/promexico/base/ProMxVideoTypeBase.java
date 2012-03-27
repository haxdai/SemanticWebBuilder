package org.semanticwb.promexico.base;


public abstract class ProMxVideoTypeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Define el orden de despliegue de estos objetos
   */
    public static final org.semanticwb.platform.SemanticProperty promx_displayOrder=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#displayOrder");
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideoType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideoType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideoType");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProMxVideoType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.ProMxVideoType
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideoType> listProMxVideoTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideoType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.ProMxVideoType for all models
       * @return Iterator of org.semanticwb.promexico.ProMxVideoType
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideoType> listProMxVideoTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideoType>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.ProMxVideoType
       * @param id Identifier for org.semanticwb.promexico.ProMxVideoType
       * @param model Model of the org.semanticwb.promexico.ProMxVideoType
       * @return A org.semanticwb.promexico.ProMxVideoType
       */
        public static org.semanticwb.promexico.ProMxVideoType getProMxVideoType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProMxVideoType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.ProMxVideoType
       * @param id Identifier for org.semanticwb.promexico.ProMxVideoType
       * @param model Model of the org.semanticwb.promexico.ProMxVideoType
       * @return A org.semanticwb.promexico.ProMxVideoType
       */
        public static org.semanticwb.promexico.ProMxVideoType createProMxVideoType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProMxVideoType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.ProMxVideoType
       * @param id Identifier for org.semanticwb.promexico.ProMxVideoType
       * @param model Model of the org.semanticwb.promexico.ProMxVideoType
       */
        public static void removeProMxVideoType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.ProMxVideoType
       * @param id Identifier for org.semanticwb.promexico.ProMxVideoType
       * @param model Model of the org.semanticwb.promexico.ProMxVideoType
       * @return true if the org.semanticwb.promexico.ProMxVideoType exists, false otherwise
       */

        public static boolean hasProMxVideoType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProMxVideoType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideoType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProMxVideoType
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideoType
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideoType> listProMxVideoTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideoType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideoType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideoType
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideoType> listProMxVideoTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideoType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideoType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProMxVideoType
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideoType
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideoType> listProMxVideoTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideoType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProMxVideoType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProMxVideoType
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProMxVideoType> listProMxVideoTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideoType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProMxVideoTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProMxVideoType
   */
    public ProMxVideoTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the DisplayOrder property
* @return int with the DisplayOrder
*/
    public int getDisplayOrder()
    {
        return getSemanticObject().getIntProperty(promx_displayOrder);
    }

/**
* Sets the DisplayOrder property
* @param value long with the DisplayOrder
*/
    public void setDisplayOrder(int value)
    {
        getSemanticObject().setIntProperty(promx_displayOrder, value);
    }
}
