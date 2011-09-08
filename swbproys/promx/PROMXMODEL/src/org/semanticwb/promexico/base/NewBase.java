package org.semanticwb.promexico.base;


public abstract class NewBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Resourceable,org.semanticwb.model.Tagable,org.semanticwb.model.Searchable,org.semanticwb.model.Ruleable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty promx_newUrl=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#newUrl");
   /**
   * Objeto controlador de oficinas
   */
    public static final org.semanticwb.platform.SemanticClass promx_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Office");
   /**
   * Oficinas relacionadas (En las que aparece) con la Noticia
   */
    public static final org.semanticwb.platform.SemanticProperty promx_hasOffices=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasOffices");
   /**
   * Foto de Noticia
   */
    public static final org.semanticwb.platform.SemanticProperty promx_newPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#newPhoto");
    public static final org.semanticwb.platform.SemanticProperty promx_newSource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#newSource");
    public static final org.semanticwb.platform.SemanticProperty promx_fileAttach=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#fileAttach");
   /**
   * Tipos de Noticias
   */
    public static final org.semanticwb.platform.SemanticClass promx_NewType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#NewType");
    public static final org.semanticwb.platform.SemanticProperty promx_newType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#newType");
    public static final org.semanticwb.platform.SemanticProperty promx_enFileAttach=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#enFileAttach");
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
   /**
   * Sectores Relacionados con la Noticia
   */
    public static final org.semanticwb.platform.SemanticProperty promx_hasSector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasSector");
    public static final org.semanticwb.platform.SemanticClass promx_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");

    public static class ClassMgr
    {
       /**
       * Returns a list of New for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNews(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.New for all models
       * @return Iterator of org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNews()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New>(it, true);
        }

        public static org.semanticwb.promexico.New createNew(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.New.ClassMgr.createNew(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.New
       * @param id Identifier for org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.New
       * @return A org.semanticwb.promexico.New
       */
        public static org.semanticwb.promexico.New getNew(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.New)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.New
       * @param id Identifier for org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.New
       * @return A org.semanticwb.promexico.New
       */
        public static org.semanticwb.promexico.New createNew(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.New)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.New
       * @param id Identifier for org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.New
       */
        public static void removeNew(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.New
       * @param id Identifier for org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.New
       * @return true if the org.semanticwb.promexico.New exists, false otherwise
       */

        public static boolean hasNew(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNew(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Offices
       * @param value Offices of the type org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByOffices(org.semanticwb.promexico.Office value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasOffices, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Offices
       * @param value Offices of the type org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByOffices(org.semanticwb.promexico.Office value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasOffices,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByRule(org.semanticwb.model.Rule value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByRule(org.semanticwb.model.Rule value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined NewType
       * @param value NewType of the type org.semanticwb.promexico.NewType
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByNewType(org.semanticwb.promexico.NewType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_newType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined NewType
       * @param value NewType of the type org.semanticwb.promexico.NewType
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByNewType(org.semanticwb.promexico.NewType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_newType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Sector
       * @param value Sector of the type org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewBySector(org.semanticwb.promexico.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasSector, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.New with a determined Sector
       * @param value Sector of the type org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.New
       */

        public static java.util.Iterator<org.semanticwb.promexico.New> listNewBySector(org.semanticwb.promexico.Sector value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasSector,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a NewBase with a SemanticObject
   * @param base The SemanticObject with the properties for the New
   */
    public NewBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the NewUrl property
* @return String with the NewUrl
*/
    public String getNewUrl()
    {
        return getSemanticObject().getProperty(promx_newUrl);
    }

/**
* Sets the NewUrl property
* @param value long with the NewUrl
*/
    public void setNewUrl(String value)
    {
        getSemanticObject().setProperty(promx_newUrl, value);
    }
   /**
   * Gets all the org.semanticwb.promexico.Office
   * @return A GenericIterator with all the org.semanticwb.promexico.Office
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> listOfficeses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office>(getSemanticObject().listObjectProperties(promx_hasOffices));
    }

   /**
   * Gets true if has a Offices
   * @param value org.semanticwb.promexico.Office to verify
   * @return true if the org.semanticwb.promexico.Office exists, false otherwise
   */
    public boolean hasOffices(org.semanticwb.promexico.Office value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasOffices,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Offices
   * @param value org.semanticwb.promexico.Office to add
   */

    public void addOffices(org.semanticwb.promexico.Office value)
    {
        getSemanticObject().addObjectProperty(promx_hasOffices, value.getSemanticObject());
    }
   /**
   * Removes all the Offices
   */

    public void removeAllOffices()
    {
        getSemanticObject().removeProperty(promx_hasOffices);
    }
   /**
   * Removes a Offices
   * @param value org.semanticwb.promexico.Office to remove
   */

    public void removeOffices(org.semanticwb.promexico.Office value)
    {
        getSemanticObject().removeObjectProperty(promx_hasOffices,value.getSemanticObject());
    }

   /**
   * Gets the Offices
   * @return a org.semanticwb.promexico.Office
   */
    public org.semanticwb.promexico.Office getOffices()
    {
         org.semanticwb.promexico.Office ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasOffices);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Office)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NewPhoto property
* @return String with the NewPhoto
*/
    public String getNewPhoto()
    {
        return getSemanticObject().getProperty(promx_newPhoto);
    }

/**
* Sets the NewPhoto property
* @param value long with the NewPhoto
*/
    public void setNewPhoto(String value)
    {
        getSemanticObject().setProperty(promx_newPhoto, value);
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
* Gets the NewSource property
* @return String with the NewSource
*/
    public String getNewSource()
    {
        return getSemanticObject().getProperty(promx_newSource);
    }

/**
* Sets the NewSource property
* @param value long with the NewSource
*/
    public void setNewSource(String value)
    {
        getSemanticObject().setProperty(promx_newSource, value);
    }
   /**
   * Gets all the org.semanticwb.model.Rule
   * @return A GenericIterator with all the org.semanticwb.model.Rule
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule> listRules()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule>(getSemanticObject().listObjectProperties(swb_hasRule));
    }

   /**
   * Gets true if has a Rule
   * @param value org.semanticwb.model.Rule to verify
   * @return true if the org.semanticwb.model.Rule exists, false otherwise
   */
    public boolean hasRule(org.semanticwb.model.Rule value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasRule,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Rule
   * @param value org.semanticwb.model.Rule to add
   */

    public void addRule(org.semanticwb.model.Rule value)
    {
        getSemanticObject().addObjectProperty(swb_hasRule, value.getSemanticObject());
    }
   /**
   * Removes all the Rule
   */

    public void removeAllRule()
    {
        getSemanticObject().removeProperty(swb_hasRule);
    }
   /**
   * Removes a Rule
   * @param value org.semanticwb.model.Rule to remove
   */

    public void removeRule(org.semanticwb.model.Rule value)
    {
        getSemanticObject().removeObjectProperty(swb_hasRule,value.getSemanticObject());
    }

   /**
   * Gets the Rule
   * @return a org.semanticwb.model.Rule
   */
    public org.semanticwb.model.Rule getRule()
    {
         org.semanticwb.model.Rule ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRule);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Rule)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FileAttach property
* @return String with the FileAttach
*/
    public String getFileAttach()
    {
        return getSemanticObject().getProperty(promx_fileAttach);
    }

/**
* Sets the FileAttach property
* @param value long with the FileAttach
*/
    public void setFileAttach(String value)
    {
        getSemanticObject().setProperty(promx_fileAttach, value);
    }
   /**
   * Sets the value for the property NewType
   * @param value NewType to set
   */

    public void setNewType(org.semanticwb.promexico.NewType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(promx_newType, value.getSemanticObject());
        }else
        {
            removeNewType();
        }
    }
   /**
   * Remove the value for NewType property
   */

    public void removeNewType()
    {
        getSemanticObject().removeProperty(promx_newType);
    }

   /**
   * Gets the NewType
   * @return a org.semanticwb.promexico.NewType
   */
    public org.semanticwb.promexico.NewType getNewType()
    {
         org.semanticwb.promexico.NewType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_newType);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.NewType)obj.createGenericInstance();
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
   * Gets all the org.semanticwb.model.Resource
   * @return A GenericIterator with all the org.semanticwb.model.Resource
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource>(getSemanticObject().listObjectProperties(swb_hasResource));
    }

   /**
   * Gets true if has a Resource
   * @param value org.semanticwb.model.Resource to verify
   * @return true if the org.semanticwb.model.Resource exists, false otherwise
   */
    public boolean hasResource(org.semanticwb.model.Resource value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasResource,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Resource
   * @param value org.semanticwb.model.Resource to add
   */

    public void addResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().addObjectProperty(swb_hasResource, value.getSemanticObject());
    }
   /**
   * Removes all the Resource
   */

    public void removeAllResource()
    {
        getSemanticObject().removeProperty(swb_hasResource);
    }
   /**
   * Removes a Resource
   * @param value org.semanticwb.model.Resource to remove
   */

    public void removeResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().removeObjectProperty(swb_hasResource,value.getSemanticObject());
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasResource);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EnFileAttach property
* @return String with the EnFileAttach
*/
    public String getEnFileAttach()
    {
        return getSemanticObject().getProperty(promx_enFileAttach);
    }

/**
* Sets the EnFileAttach property
* @param value long with the EnFileAttach
*/
    public void setEnFileAttach(String value)
    {
        getSemanticObject().setProperty(promx_enFileAttach, value);
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }
   /**
   * Gets all the org.semanticwb.promexico.Sector
   * @return A GenericIterator with all the org.semanticwb.promexico.Sector
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> listSectors()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector>(getSemanticObject().listObjectProperties(promx_hasSector));
    }

   /**
   * Gets true if has a Sector
   * @param value org.semanticwb.promexico.Sector to verify
   * @return true if the org.semanticwb.promexico.Sector exists, false otherwise
   */
    public boolean hasSector(org.semanticwb.promexico.Sector value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasSector,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Sector
   * @param value org.semanticwb.promexico.Sector to add
   */

    public void addSector(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().addObjectProperty(promx_hasSector, value.getSemanticObject());
    }
   /**
   * Removes all the Sector
   */

    public void removeAllSector()
    {
        getSemanticObject().removeProperty(promx_hasSector);
    }
   /**
   * Removes a Sector
   * @param value org.semanticwb.promexico.Sector to remove
   */

    public void removeSector(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().removeObjectProperty(promx_hasSector,value.getSemanticObject());
    }

   /**
   * Gets the Sector
   * @return a org.semanticwb.promexico.Sector
   */
    public org.semanticwb.promexico.Sector getSector()
    {
         org.semanticwb.promexico.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasSector);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Sector)obj.createGenericInstance();
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
