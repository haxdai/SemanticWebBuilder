package org.semanticwb.catalogs.base;


public abstract class EstadoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass cat_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Municipio");
    public static final org.semanticwb.platform.SemanticProperty cat_hasMunicipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.catalogs.org/ontology#hasMunicipio");
    public static final org.semanticwb.platform.SemanticClass cat_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Estado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.catalogs.org/ontology#Estado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Estado for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.catalogs.Estado for all models
       * @return Iterator of org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado>(it, true);
        }

        public static org.semanticwb.catalogs.Estado createEstado(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.catalogs.Estado.ClassMgr.createEstado(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.catalogs.Estado
       * @param id Identifier for org.semanticwb.catalogs.Estado
       * @param model Model of the org.semanticwb.catalogs.Estado
       * @return A org.semanticwb.catalogs.Estado
       */
        public static org.semanticwb.catalogs.Estado getEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.catalogs.Estado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.catalogs.Estado
       * @param id Identifier for org.semanticwb.catalogs.Estado
       * @param model Model of the org.semanticwb.catalogs.Estado
       * @return A org.semanticwb.catalogs.Estado
       */
        public static org.semanticwb.catalogs.Estado createEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.catalogs.Estado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.catalogs.Estado
       * @param id Identifier for org.semanticwb.catalogs.Estado
       * @param model Model of the org.semanticwb.catalogs.Estado
       */
        public static void removeEstado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.catalogs.Estado
       * @param id Identifier for org.semanticwb.catalogs.Estado
       * @param model Model of the org.semanticwb.catalogs.Estado
       * @return true if the org.semanticwb.catalogs.Estado exists, false otherwise
       */

        public static boolean hasEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstado(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.catalogs.Estado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.catalogs.Estado
       * @return Iterator with all the org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstadoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Estado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstadoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Estado with a determined Municipio
       * @param value Municipio of the type org.semanticwb.catalogs.Municipio
       * @param model Model of the org.semanticwb.catalogs.Estado
       * @return Iterator with all the org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstadoByMunicipio(org.semanticwb.catalogs.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cat_hasMunicipio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Estado with a determined Municipio
       * @param value Municipio of the type org.semanticwb.catalogs.Municipio
       * @return Iterator with all the org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstadoByMunicipio(org.semanticwb.catalogs.Municipio value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cat_hasMunicipio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Estado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.catalogs.Estado
       * @return Iterator with all the org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstadoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.catalogs.Estado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.catalogs.Estado
       */

        public static java.util.Iterator<org.semanticwb.catalogs.Estado> listEstadoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Estado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EstadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Estado
   */
    public EstadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.catalogs.Municipio
   * @return A GenericIterator with all the org.semanticwb.catalogs.Municipio
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Municipio> listMunicipios()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.catalogs.Municipio>(getSemanticObject().listObjectProperties(cat_hasMunicipio));
    }

   /**
   * Gets true if has a Municipio
   * @param value org.semanticwb.catalogs.Municipio to verify
   * @return true if the org.semanticwb.catalogs.Municipio exists, false otherwise
   */
    public boolean hasMunicipio(org.semanticwb.catalogs.Municipio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cat_hasMunicipio,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Municipio
   * @param value org.semanticwb.catalogs.Municipio to add
   */

    public void addMunicipio(org.semanticwb.catalogs.Municipio value)
    {
        getSemanticObject().addObjectProperty(cat_hasMunicipio, value.getSemanticObject());
    }
   /**
   * Removes all the Municipio
   */

    public void removeAllMunicipio()
    {
        getSemanticObject().removeProperty(cat_hasMunicipio);
    }
   /**
   * Removes a Municipio
   * @param value org.semanticwb.catalogs.Municipio to remove
   */

    public void removeMunicipio(org.semanticwb.catalogs.Municipio value)
    {
        getSemanticObject().removeObjectProperty(cat_hasMunicipio,value.getSemanticObject());
    }

   /**
   * Gets the Municipio
   * @return a org.semanticwb.catalogs.Municipio
   */
    public org.semanticwb.catalogs.Municipio getMunicipio()
    {
         org.semanticwb.catalogs.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cat_hasMunicipio);
         if(obj!=null)
         {
             ret=(org.semanticwb.catalogs.Municipio)obj.createGenericInstance();
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
   * Gets the Catalogs
   * @return a instance of org.semanticwb.catalogs.Catalogs
   */
    public org.semanticwb.catalogs.Catalogs getCatalogs()
    {
        return (org.semanticwb.catalogs.Catalogs)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
