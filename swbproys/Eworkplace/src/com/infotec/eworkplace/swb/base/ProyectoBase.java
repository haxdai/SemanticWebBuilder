package com.infotec.eworkplace.swb.base;


   /**
   * Encapsula la información de los proyectos provenientes del ProjectServer 
   */
public abstract class ProyectoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreContacto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreContacto");
    public static final org.semanticwb.platform.SemanticProperty intranet_telefonoContacto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#telefonoContacto");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_adminsitradorDelProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adminsitradorDelProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_emailContacto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#emailContacto");
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaDelContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaDelContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_domicilioProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#domicilioProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_areaDelProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaDelProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_especialidadDelProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#especialidadDelProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_ubicacionProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ubicacionProyecto");
   /**
   * Encapsula la información de los proyectos provenientes del ProjectServer
   */
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
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined AdminsitradorDelProyecto
       * @param value AdminsitradorDelProyecto of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByAdminsitradorDelProyecto(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_adminsitradorDelProyecto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined AdminsitradorDelProyecto
       * @param value AdminsitradorDelProyecto of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByAdminsitradorDelProyecto(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_adminsitradorDelProyecto,value.getSemanticObject(),sclass));
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
   * Sets the value for the property AdminsitradorDelProyecto
   * @param value AdminsitradorDelProyecto to set
   */

    public void setAdminsitradorDelProyecto(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_adminsitradorDelProyecto, value.getSemanticObject());
        }else
        {
            removeAdminsitradorDelProyecto();
        }
    }
   /**
   * Remove the value for AdminsitradorDelProyecto property
   */

    public void removeAdminsitradorDelProyecto()
    {
        getSemanticObject().removeProperty(intranet_adminsitradorDelProyecto);
    }

   /**
   * Gets the AdminsitradorDelProyecto
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getAdminsitradorDelProyecto()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_adminsitradorDelProyecto);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
* Gets the VigenciaDelContrato property
* @return java.util.Date with the VigenciaDelContrato
*/
    public java.util.Date getVigenciaDelContrato()
    {
        return getSemanticObject().getDateProperty(intranet_vigenciaDelContrato);
    }

/**
* Sets the VigenciaDelContrato property
* @param value long with the VigenciaDelContrato
*/
    public void setVigenciaDelContrato(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_vigenciaDelContrato, value);
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
* Gets the AreaDelProyecto property
* @return String with the AreaDelProyecto
*/
    public String getAreaDelProyecto()
    {
        return getSemanticObject().getProperty(intranet_areaDelProyecto);
    }

/**
* Sets the AreaDelProyecto property
* @param value long with the AreaDelProyecto
*/
    public void setAreaDelProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_areaDelProyecto, value);
    }

/**
* Gets the EspecialidadDelProyecto property
* @return String with the EspecialidadDelProyecto
*/
    public String getEspecialidadDelProyecto()
    {
        return getSemanticObject().getProperty(intranet_especialidadDelProyecto);
    }

/**
* Sets the EspecialidadDelProyecto property
* @param value long with the EspecialidadDelProyecto
*/
    public void setEspecialidadDelProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_especialidadDelProyecto, value);
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
