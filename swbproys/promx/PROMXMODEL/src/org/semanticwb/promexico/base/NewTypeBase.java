package org.semanticwb.promexico.base;


   /**
   * Tipos de Noticias 
   */
public abstract class NewTypeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass promx_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");
    public static final org.semanticwb.platform.SemanticProperty promx_hasNewsInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasNewsInv");
   /**
   * Tipos de Noticias
   */
    public static final org.semanticwb.platform.SemanticClass promx_NewType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#NewType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#NewType");

    public static class ClassMgr
    {
       /**
       * Returns a list of NewType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.NewType for all models
       * @return Iterator of org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType>(it, true);
        }

        public static org.semanticwb.promexico.NewType createNewType(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.NewType.ClassMgr.createNewType(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.NewType
       * @param id Identifier for org.semanticwb.promexico.NewType
       * @param model Model of the org.semanticwb.promexico.NewType
       * @return A org.semanticwb.promexico.NewType
       */
        public static org.semanticwb.promexico.NewType getNewType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.NewType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.NewType
       * @param id Identifier for org.semanticwb.promexico.NewType
       * @param model Model of the org.semanticwb.promexico.NewType
       * @return A org.semanticwb.promexico.NewType
       */
        public static org.semanticwb.promexico.NewType createNewType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.NewType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.NewType
       * @param id Identifier for org.semanticwb.promexico.NewType
       * @param model Model of the org.semanticwb.promexico.NewType
       */
        public static void removeNewType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.NewType
       * @param id Identifier for org.semanticwb.promexico.NewType
       * @param model Model of the org.semanticwb.promexico.NewType
       * @return true if the org.semanticwb.promexico.NewType exists, false otherwise
       */

        public static boolean hasNewType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNewType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.NewType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.NewType
       * @return Iterator with all the org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.NewType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.NewType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.NewType
       * @return Iterator with all the org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.NewType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.NewType with a determined NewsInv
       * @param value NewsInv of the type org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.NewType
       * @return Iterator with all the org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypeByNewsInv(org.semanticwb.promexico.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasNewsInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.NewType with a determined NewsInv
       * @param value NewsInv of the type org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.NewType
       */

        public static java.util.Iterator<org.semanticwb.promexico.NewType> listNewTypeByNewsInv(org.semanticwb.promexico.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.NewType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasNewsInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a NewTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the NewType
   */
    public NewTypeBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.promexico.New
   * @return A GenericIterator with all the org.semanticwb.promexico.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> listNewsInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New>(getSemanticObject().listObjectProperties(promx_hasNewsInv));
    }

   /**
   * Gets true if has a NewsInv
   * @param value org.semanticwb.promexico.New to verify
   * @return true if the org.semanticwb.promexico.New exists, false otherwise
   */
    public boolean hasNewsInv(org.semanticwb.promexico.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasNewsInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewsInv
   * @return a org.semanticwb.promexico.New
   */
    public org.semanticwb.promexico.New getNewsInv()
    {
         org.semanticwb.promexico.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasNewsInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.New)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
