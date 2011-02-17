package org.semanticwb.transparencia.model.base;


public abstract class DependenciaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty trans_tipo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#tipo");
    public static final org.semanticwb.platform.SemanticProperty trans_meta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#meta");
    public static final org.semanticwb.platform.SemanticProperty trans_objetivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#objetivo");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty trans_responsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#responsable");
    public static final org.semanticwb.platform.SemanticProperty trans_vigencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.transparencia.org/ontology#vigencia");
    public static final org.semanticwb.platform.SemanticClass trans_Dependencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.transparencia.org/ontology#Dependencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.transparencia.org/ontology#Dependencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Dependencia for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.transparencia.model.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Dependencia> listDependencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Dependencia>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.transparencia.model.Dependencia for all models
       * @return Iterator of org.semanticwb.transparencia.model.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Dependencia> listDependencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Dependencia>(it, true);
        }

        public static org.semanticwb.transparencia.model.Dependencia createDependencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.transparencia.model.Dependencia.ClassMgr.createDependencia(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.transparencia.model.Dependencia
       * @param id Identifier for org.semanticwb.transparencia.model.Dependencia
       * @param model Model of the org.semanticwb.transparencia.model.Dependencia
       * @return A org.semanticwb.transparencia.model.Dependencia
       */
        public static org.semanticwb.transparencia.model.Dependencia getDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.transparencia.model.Dependencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.transparencia.model.Dependencia
       * @param id Identifier for org.semanticwb.transparencia.model.Dependencia
       * @param model Model of the org.semanticwb.transparencia.model.Dependencia
       * @return A org.semanticwb.transparencia.model.Dependencia
       */
        public static org.semanticwb.transparencia.model.Dependencia createDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.transparencia.model.Dependencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.transparencia.model.Dependencia
       * @param id Identifier for org.semanticwb.transparencia.model.Dependencia
       * @param model Model of the org.semanticwb.transparencia.model.Dependencia
       */
        public static void removeDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.transparencia.model.Dependencia
       * @param id Identifier for org.semanticwb.transparencia.model.Dependencia
       * @param model Model of the org.semanticwb.transparencia.model.Dependencia
       * @return true if the org.semanticwb.transparencia.model.Dependencia exists, false otherwise
       */

        public static boolean hasDependencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDependencia(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Dependencia with a determined Responsable
       * @param value Responsable of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.transparencia.model.Dependencia
       * @return Iterator with all the org.semanticwb.transparencia.model.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Dependencia> listDependenciaByResponsable(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Dependencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(trans_responsable, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.transparencia.model.Dependencia with a determined Responsable
       * @param value Responsable of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.transparencia.model.Dependencia
       */

        public static java.util.Iterator<org.semanticwb.transparencia.model.Dependencia> listDependenciaByResponsable(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.transparencia.model.Dependencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(trans_responsable,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DependenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Dependencia
   */
    public DependenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Tipo property
* @return String with the Tipo
*/
    public String getTipo()
    {
        return getSemanticObject().getProperty(trans_tipo);
    }

/**
* Sets the Tipo property
* @param value long with the Tipo
*/
    public void setTipo(String value)
    {
        getSemanticObject().setProperty(trans_tipo, value);
    }

/**
* Gets the Meta property
* @return String with the Meta
*/
    public String getMeta()
    {
        return getSemanticObject().getProperty(trans_meta);
    }

/**
* Sets the Meta property
* @param value long with the Meta
*/
    public void setMeta(String value)
    {
        getSemanticObject().setProperty(trans_meta, value);
    }

/**
* Gets the Objetivo property
* @return String with the Objetivo
*/
    public String getObjetivo()
    {
        return getSemanticObject().getProperty(trans_objetivo);
    }

/**
* Sets the Objetivo property
* @param value long with the Objetivo
*/
    public void setObjetivo(String value)
    {
        getSemanticObject().setProperty(trans_objetivo, value);
    }
   /**
   * Sets the value for the property Responsable
   * @param value Responsable to set
   */

    public void setResponsable(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(trans_responsable, value.getSemanticObject());
        }else
        {
            removeResponsable();
        }
    }
   /**
   * Remove the value for Responsable property
   */

    public void removeResponsable()
    {
        getSemanticObject().removeProperty(trans_responsable);
    }

   /**
   * Gets the Responsable
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsable()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(trans_responsable);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Vigencia property
* @return java.util.Date with the Vigencia
*/
    public java.util.Date getVigencia()
    {
        return getSemanticObject().getDateProperty(trans_vigencia);
    }

/**
* Sets the Vigencia property
* @param value long with the Vigencia
*/
    public void setVigencia(java.util.Date value)
    {
        getSemanticObject().setDateProperty(trans_vigencia, value);
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
}
