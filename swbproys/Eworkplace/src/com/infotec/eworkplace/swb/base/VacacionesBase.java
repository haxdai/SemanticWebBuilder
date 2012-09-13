package com.infotec.eworkplace.swb.base;


public abstract class VacacionesBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaInicioVacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaInicioVacaciones");
    public static final org.semanticwb.platform.SemanticProperty intranet_periodo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#periodo");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreTitular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreTitular");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaRegreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaRegreso");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreJefe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreJefe");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaFinVacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaFinVacaciones");
    public static final org.semanticwb.platform.SemanticClass intranet_Vacaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Vacaciones");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Vacaciones");

    public static class ClassMgr
    {
       /**
       * Returns a list of Vacaciones for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacioneses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Vacaciones for all models
       * @return Iterator of com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacioneses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return A com.infotec.eworkplace.swb.Vacaciones
       */
        public static com.infotec.eworkplace.swb.Vacaciones getVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Vacaciones)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return A com.infotec.eworkplace.swb.Vacaciones
       */
        public static com.infotec.eworkplace.swb.Vacaciones createVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Vacaciones)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       */
        public static void removeVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Vacaciones
       * @param id Identifier for com.infotec.eworkplace.swb.Vacaciones
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return true if the com.infotec.eworkplace.swb.Vacaciones exists, false otherwise
       */

        public static boolean hasVacaciones(String id, org.semanticwb.model.SWBModel model)
        {
            return (getVacaciones(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined NombreJefe
       * @param value NombreJefe of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesByNombreJefe(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nombreJefe, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined NombreJefe
       * @param value NombreJefe of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesByNombreJefe(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nombreJefe,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Vacaciones
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Vacaciones with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Vacaciones
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Vacaciones> listVacacionesByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Vacaciones> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a VacacionesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Vacaciones
   */
    public VacacionesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NumeroEmpleado property
* @return int with the NumeroEmpleado
*/
    public int getNumeroEmpleado()
    {
        return getSemanticObject().getIntProperty(intranet_numeroEmpleado);
    }

/**
* Sets the NumeroEmpleado property
* @param value long with the NumeroEmpleado
*/
    public void setNumeroEmpleado(int value)
    {
        getSemanticObject().setIntProperty(intranet_numeroEmpleado, value);
    }
   /**
   * Sets the value for the property Solicitante
   * @param value Solicitante to set
   */

    public void setSolicitante(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitante, value.getSemanticObject());
        }else
        {
            removeSolicitante();
        }
    }
   /**
   * Remove the value for Solicitante property
   */

    public void removeSolicitante()
    {
        getSemanticObject().removeProperty(intranet_solicitante);
    }

   /**
   * Gets the Solicitante
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSolicitante()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitante);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaInicioVacaciones property
* @return java.util.Date with the FechaInicioVacaciones
*/
    public java.util.Date getFechaInicioVacaciones()
    {
        return getSemanticObject().getDateProperty(intranet_fechaInicioVacaciones);
    }

/**
* Sets the FechaInicioVacaciones property
* @param value long with the FechaInicioVacaciones
*/
    public void setFechaInicioVacaciones(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaInicioVacaciones, value);
    }

/**
* Gets the FechaSolicita property
* @return java.util.Date with the FechaSolicita
*/
    public java.util.Date getFechaSolicita()
    {
        return getSemanticObject().getDateProperty(intranet_fechaSolicita);
    }

/**
* Sets the FechaSolicita property
* @param value long with the FechaSolicita
*/
    public void setFechaSolicita(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaSolicita, value);
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
* Gets the Periodo property
* @return int with the Periodo
*/
    public int getPeriodo()
    {
        return getSemanticObject().getIntProperty(intranet_periodo);
    }

/**
* Sets the Periodo property
* @param value long with the Periodo
*/
    public void setPeriodo(int value)
    {
        getSemanticObject().setIntProperty(intranet_periodo, value);
    }

/**
* Gets the NombreTitular property
* @return String with the NombreTitular
*/
    public String getNombreTitular()
    {
        return getSemanticObject().getProperty(intranet_nombreTitular);
    }

/**
* Sets the NombreTitular property
* @param value long with the NombreTitular
*/
    public void setNombreTitular(String value)
    {
        getSemanticObject().setProperty(intranet_nombreTitular, value);
    }

/**
* Gets the FechaRegreso property
* @return java.util.Date with the FechaRegreso
*/
    public java.util.Date getFechaRegreso()
    {
        return getSemanticObject().getDateProperty(intranet_fechaRegreso);
    }

/**
* Sets the FechaRegreso property
* @param value long with the FechaRegreso
*/
    public void setFechaRegreso(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaRegreso, value);
    }

/**
* Gets the CargoSolicitante property
* @return String with the CargoSolicitante
*/
    public String getCargoSolicitante()
    {
        return getSemanticObject().getProperty(intranet_cargoSolicitante);
    }

/**
* Sets the CargoSolicitante property
* @param value long with the CargoSolicitante
*/
    public void setCargoSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_cargoSolicitante, value);
    }

/**
* Gets the AdscripcionSolicitante property
* @return String with the AdscripcionSolicitante
*/
    public String getAdscripcionSolicitante()
    {
        return getSemanticObject().getProperty(intranet_adscripcionSolicitante);
    }

/**
* Sets the AdscripcionSolicitante property
* @param value long with the AdscripcionSolicitante
*/
    public void setAdscripcionSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_adscripcionSolicitante, value);
    }

/**
* Gets the Folio property
* @return String with the Folio
*/
    public String getFolio()
    {
        return getSemanticObject().getProperty(intranet_folio);
    }

/**
* Sets the Folio property
* @param value long with the Folio
*/
    public void setFolio(String value)
    {
        getSemanticObject().setProperty(intranet_folio, value);
    }
   /**
   * Sets the value for the property NombreJefe
   * @param value NombreJefe to set
   */

    public void setNombreJefe(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nombreJefe, value.getSemanticObject());
        }else
        {
            removeNombreJefe();
        }
    }
   /**
   * Remove the value for NombreJefe property
   */

    public void removeNombreJefe()
    {
        getSemanticObject().removeProperty(intranet_nombreJefe);
    }

   /**
   * Gets the NombreJefe
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getNombreJefe()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nombreJefe);
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
* Gets the ExtensionSolicitante property
* @return String with the ExtensionSolicitante
*/
    public String getExtensionSolicitante()
    {
        return getSemanticObject().getProperty(intranet_extensionSolicitante);
    }

/**
* Sets the ExtensionSolicitante property
* @param value long with the ExtensionSolicitante
*/
    public void setExtensionSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_extensionSolicitante, value);
    }
   /**
   * Sets the value for the property UsuarioAutoriza
   * @param value UsuarioAutoriza to set
   */

    public void setUsuarioAutoriza(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_usuarioAutoriza, value.getSemanticObject());
        }else
        {
            removeUsuarioAutoriza();
        }
    }
   /**
   * Remove the value for UsuarioAutoriza property
   */

    public void removeUsuarioAutoriza()
    {
        getSemanticObject().removeProperty(intranet_usuarioAutoriza);
    }

   /**
   * Gets the UsuarioAutoriza
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUsuarioAutoriza()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_usuarioAutoriza);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NombreSolicitante property
* @return String with the NombreSolicitante
*/
    public String getNombreSolicitante()
    {
        return getSemanticObject().getProperty(intranet_nombreSolicitante);
    }

/**
* Sets the NombreSolicitante property
* @param value long with the NombreSolicitante
*/
    public void setNombreSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_nombreSolicitante, value);
    }

/**
* Gets the Autoriza property
* @return String with the Autoriza
*/
    public String getAutoriza()
    {
        return getSemanticObject().getProperty(intranet_autoriza);
    }

/**
* Sets the Autoriza property
* @param value long with the Autoriza
*/
    public void setAutoriza(String value)
    {
        getSemanticObject().setProperty(intranet_autoriza, value);
    }

/**
* Gets the FechaFinVacaciones property
* @return java.util.Date with the FechaFinVacaciones
*/
    public java.util.Date getFechaFinVacaciones()
    {
        return getSemanticObject().getDateProperty(intranet_fechaFinVacaciones);
    }

/**
* Sets the FechaFinVacaciones property
* @param value long with the FechaFinVacaciones
*/
    public void setFechaFinVacaciones(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaFinVacaciones, value);
    }
}
