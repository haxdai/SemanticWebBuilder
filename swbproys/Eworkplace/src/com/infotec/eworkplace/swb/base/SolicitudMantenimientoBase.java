package com.infotec.eworkplace.swb.base;


public abstract class SolicitudMantenimientoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_terceros=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#terceros");
    public static final org.semanticwb.platform.SemanticProperty intranet_descripcionServicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#descripcionServicio");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudMantenimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudMantenimiento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudMantenimiento");

    public static class ClassMgr
    {
       /**
       * Returns a list of SolicitudMantenimiento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SolicitudMantenimiento for all models
       * @return Iterator of com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento>(it, true);
        }

        public static com.infotec.eworkplace.swb.SolicitudMantenimiento createSolicitudMantenimiento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.SolicitudMantenimiento.ClassMgr.createSolicitudMantenimiento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return A com.infotec.eworkplace.swb.SolicitudMantenimiento
       */
        public static com.infotec.eworkplace.swb.SolicitudMantenimiento getSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SolicitudMantenimiento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return A com.infotec.eworkplace.swb.SolicitudMantenimiento
       */
        public static com.infotec.eworkplace.swb.SolicitudMantenimiento createSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SolicitudMantenimiento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       */
        public static void removeSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return true if the com.infotec.eworkplace.swb.SolicitudMantenimiento exists, false otherwise
       */

        public static boolean hasSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSolicitudMantenimiento(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SolicitudMantenimiento with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return Iterator with all the com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientoByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SolicitudMantenimiento with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientoByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SolicitudMantenimiento with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return Iterator with all the com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientoBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SolicitudMantenimiento with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientoBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SolicitudMantenimientoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SolicitudMantenimiento
   */
    public SolicitudMantenimientoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Terceros property
* @return boolean with the Terceros
*/
    public boolean isTerceros()
    {
        return getSemanticObject().getBooleanProperty(intranet_terceros);
    }

/**
* Sets the Terceros property
* @param value long with the Terceros
*/
    public void setTerceros(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_terceros, value);
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
* Gets the DescripcionServicio property
* @return String with the DescripcionServicio
*/
    public String getDescripcionServicio()
    {
        return getSemanticObject().getProperty(intranet_descripcionServicio);
    }

/**
* Sets the DescripcionServicio property
* @param value long with the DescripcionServicio
*/
    public void setDescripcionServicio(String value)
    {
        getSemanticObject().setProperty(intranet_descripcionServicio, value);
    }
}
