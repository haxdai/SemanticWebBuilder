package org.semanticwb.transparencia.model.base;


public abstract class ResponsabilidadesBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty trans_hasPersonasRelacionadas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#hasPersonasRelacionadas");
    public static final org.semanticwb.platform.SemanticClass trans_Actividad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.transparencia.org/ontology#Actividad");
    public static final org.semanticwb.platform.SemanticProperty trans_hasActividadesRelacionadas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#hasActividadesRelacionadas");
    public static final org.semanticwb.platform.SemanticProperty trans_tipoDependencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#tipoDependencia");
    public static final org.semanticwb.platform.SemanticProperty trans_descripCorta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#descripCorta");
    public static final org.semanticwb.platform.SemanticClass trans_Responsabilidades=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.transparencia.org/ontology#Responsabilidades");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.transparencia.org/ontology#Responsabilidades");

    public static class ClassMgr
    {
       /**
       * Returns a list of Responsabilidades for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadeses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.transparencia.model.Responsabilidades for all models
       * @return Iterator of org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadeses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades>(it, true);
        }

        public static org.semanticwb.transparencia.model.Responsabilidades createResponsabilidades(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.transparencia.model.Responsabilidades.ClassMgr.createResponsabilidades(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.transparencia.model.Responsabilidades
       * @param id Identifier for org.semanticwb.transparencia.model.Responsabilidades
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return A org.semanticwb.transparencia.model.Responsabilidades
       */
        public static org.semanticwb.transparencia.model.Responsabilidades getResponsabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.transparencia.model.Responsabilidades)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.transparencia.model.Responsabilidades
       * @param id Identifier for org.semanticwb.transparencia.model.Responsabilidades
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return A org.semanticwb.transparencia.model.Responsabilidades
       */
        public static org.semanticwb.transparencia.model.Responsabilidades createResponsabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.transparencia.model.Responsabilidades)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.transparencia.model.Responsabilidades
       * @param id Identifier for org.semanticwb.transparencia.model.Responsabilidades
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       */
        public static void removeResponsabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.transparencia.model.Responsabilidades
       * @param id Identifier for org.semanticwb.transparencia.model.Responsabilidades
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return true if the org.semanticwb.transparencia.model.Responsabilidades exists, false otherwise
       */

        public static boolean hasResponsabilidades(String id, org.semanticwb.model.SWBModel model)
        {
            return (getResponsabilidades(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined PersonasRelacionadas
       * @param value PersonasRelacionadas of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByPersonasRelacionadas(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(trans_hasPersonasRelacionadas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined PersonasRelacionadas
       * @param value PersonasRelacionadas of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByPersonasRelacionadas(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(trans_hasPersonasRelacionadas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined ActividadesRelacionadas
       * @param value ActividadesRelacionadas of the type org.semanticwb.transparencia.model.Actividad
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByActividadesRelacionadas(org.semanticwb.transparencia.model.Actividad value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(trans_hasActividadesRelacionadas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined ActividadesRelacionadas
       * @param value ActividadesRelacionadas of the type org.semanticwb.transparencia.model.Actividad
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByActividadesRelacionadas(org.semanticwb.transparencia.model.Actividad value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(trans_hasActividadesRelacionadas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.transparencia.model.Responsabilidades
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Responsabilidades with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.transparencia.model.Responsabilidades
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Responsabilidades> listResponsabilidadesByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Responsabilidades> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ResponsabilidadesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Responsabilidades
   */
    public ResponsabilidadesBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listPersonasRelacionadases()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(trans_hasPersonasRelacionadas));
    }

   /**
   * Gets true if has a PersonasRelacionadas
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasPersonasRelacionadas(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(trans_hasPersonasRelacionadas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PersonasRelacionadas
   * @param value org.semanticwb.model.User to add
   */

    public void addPersonasRelacionadas(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(trans_hasPersonasRelacionadas, value.getSemanticObject());
    }
   /**
   * Removes all the PersonasRelacionadas
   */

    public void removeAllPersonasRelacionadas()
    {
        getSemanticObject().removeProperty(trans_hasPersonasRelacionadas);
    }
   /**
   * Removes a PersonasRelacionadas
   * @param value org.semanticwb.model.User to remove
   */

    public void removePersonasRelacionadas(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(trans_hasPersonasRelacionadas,value.getSemanticObject());
    }

   /**
   * Gets the PersonasRelacionadas
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getPersonasRelacionadas()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(trans_hasPersonasRelacionadas);
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
   * Gets all the org.semanticwb.transparencia.model.Actividad
   * @return A GenericIterator with all the org.semanticwb.transparencia.model.Actividad
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Actividad> listActividadesRelacionadases()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Actividad>(getSemanticObject().listObjectProperties(trans_hasActividadesRelacionadas));
    }

   /**
   * Gets true if has a ActividadesRelacionadas
   * @param value org.semanticwb.transparencia.model.Actividad to verify
   * @return true if the org.semanticwb.transparencia.model.Actividad exists, false otherwise
   */
    public boolean hasActividadesRelacionadas(org.semanticwb.transparencia.model.Actividad value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(trans_hasActividadesRelacionadas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ActividadesRelacionadas
   * @param value org.semanticwb.transparencia.model.Actividad to add
   */

    public void addActividadesRelacionadas(org.semanticwb.transparencia.model.Actividad value)
    {
        getSemanticObject().addObjectProperty(trans_hasActividadesRelacionadas, value.getSemanticObject());
    }
   /**
   * Removes all the ActividadesRelacionadas
   */

    public void removeAllActividadesRelacionadas()
    {
        getSemanticObject().removeProperty(trans_hasActividadesRelacionadas);
    }
   /**
   * Removes a ActividadesRelacionadas
   * @param value org.semanticwb.transparencia.model.Actividad to remove
   */

    public void removeActividadesRelacionadas(org.semanticwb.transparencia.model.Actividad value)
    {
        getSemanticObject().removeObjectProperty(trans_hasActividadesRelacionadas,value.getSemanticObject());
    }

   /**
   * Gets the ActividadesRelacionadas
   * @return a org.semanticwb.transparencia.model.Actividad
   */
    public org.semanticwb.transparencia.model.Actividad getActividadesRelacionadas()
    {
         org.semanticwb.transparencia.model.Actividad ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(trans_hasActividadesRelacionadas);
         if(obj!=null)
         {
             ret=(org.semanticwb.transparencia.model.Actividad)obj.createGenericInstance();
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
* Gets the TipoDependencia property
* @return String with the TipoDependencia
*/
    public String getTipoDependencia()
    {
        return getSemanticObject().getProperty(trans_tipoDependencia);
    }

/**
* Sets the TipoDependencia property
* @param value long with the TipoDependencia
*/
    public void setTipoDependencia(String value)
    {
        getSemanticObject().setProperty(trans_tipoDependencia, value);
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
* Gets the DescripcionCorta property
* @return String with the DescripcionCorta
*/
    public String getDescripcionCorta()
    {
        return getSemanticObject().getProperty(trans_descripCorta);
    }

/**
* Sets the DescripcionCorta property
* @param value long with the DescripcionCorta
*/
    public void setDescripcionCorta(String value)
    {
        getSemanticObject().setProperty(trans_descripCorta, value);
    }
}
