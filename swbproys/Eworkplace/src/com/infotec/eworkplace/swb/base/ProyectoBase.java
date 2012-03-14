package com.infotec.eworkplace.swb.base;


public abstract class ProyectoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreContacto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreContacto");
    public static final org.semanticwb.platform.SemanticProperty intranet_telefonoContacto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#telefonoContacto");
    public static final org.semanticwb.platform.SemanticProperty intranet_domicilioProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#domicilioProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_emailContacto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#emailContacto");
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_ubicacionProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ubicacionProyecto");
    public static final org.semanticwb.platform.SemanticClass intranet_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");

    public static class ClassMgr
    {
       /**
       * Returns a list of Proyecto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Proyecto for all models
       * @return Iterator of com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(it, true);
        }

        public static com.infotec.eworkplace.swb.Proyecto createProyecto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Proyecto.ClassMgr.createProyecto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return A com.infotec.eworkplace.swb.Proyecto
       */
        public static com.infotec.eworkplace.swb.Proyecto getProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Proyecto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return A com.infotec.eworkplace.swb.Proyecto
       */
        public static com.infotec.eworkplace.swb.Proyecto createProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Proyecto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       */
        public static void removeProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return true if the com.infotec.eworkplace.swb.Proyecto exists, false otherwise
       */

        public static boolean hasProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProyecto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProyectoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Proyecto
   */
    public ProyectoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NombreContacto property
* @return String with the NombreContacto
*/
    public String getNombreContacto()
    {
        return getSemanticObject().getProperty(intranet_nombreContacto);
    }

/**
* Sets the NombreContacto property
* @param value long with the NombreContacto
*/
    public void setNombreContacto(String value)
    {
        getSemanticObject().setProperty(intranet_nombreContacto, value);
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
* Gets the TelefonoContacto property
* @return String with the TelefonoContacto
*/
    public String getTelefonoContacto()
    {
        return getSemanticObject().getProperty(intranet_telefonoContacto);
    }

/**
* Sets the TelefonoContacto property
* @param value long with the TelefonoContacto
*/
    public void setTelefonoContacto(String value)
    {
        getSemanticObject().setProperty(intranet_telefonoContacto, value);
    }

/**
* Gets the DomicilioProyecto property
* @return String with the DomicilioProyecto
*/
    public String getDomicilioProyecto()
    {
        return getSemanticObject().getProperty(intranet_domicilioProyecto);
    }

/**
* Sets the DomicilioProyecto property
* @param value long with the DomicilioProyecto
*/
    public void setDomicilioProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_domicilioProyecto, value);
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
* Gets the EmailContacto property
* @return String with the EmailContacto
*/
    public String getEmailContacto()
    {
        return getSemanticObject().getProperty(intranet_emailContacto);
    }

/**
* Sets the EmailContacto property
* @param value long with the EmailContacto
*/
    public void setEmailContacto(String value)
    {
        getSemanticObject().setProperty(intranet_emailContacto, value);
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
* Gets the NumeroProyecto property
* @return String with the NumeroProyecto
*/
    public String getNumeroProyecto()
    {
        return getSemanticObject().getProperty(intranet_numeroProyecto);
    }

/**
* Sets the NumeroProyecto property
* @param value long with the NumeroProyecto
*/
    public void setNumeroProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_numeroProyecto, value);
    }

/**
* Gets the NombreProyecto property
* @return String with the NombreProyecto
*/
    public String getNombreProyecto()
    {
        return getSemanticObject().getProperty(intranet_nombreProyecto);
    }

/**
* Sets the NombreProyecto property
* @param value long with the NombreProyecto
*/
    public void setNombreProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_nombreProyecto, value);
    }

/**
* Gets the UbicacionProyecto property
* @return String with the UbicacionProyecto
*/
    public String getUbicacionProyecto()
    {
        return getSemanticObject().getProperty(intranet_ubicacionProyecto);
    }

/**
* Sets the UbicacionProyecto property
* @param value long with the UbicacionProyecto
*/
    public void setUbicacionProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_ubicacionProyecto, value);
    }
}
