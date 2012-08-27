package com.infotec.eworkplace.swb.base;


public abstract class ReservacionAutoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_horaSalida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#horaSalida");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaSalida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaSalida");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaDeRegreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaDeRegreso");
    public static final org.semanticwb.platform.SemanticProperty intranet_horaRegreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#horaRegreso");
    public static final org.semanticwb.platform.SemanticProperty intranet_destino=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#destino");
    public static final org.semanticwb.platform.SemanticProperty intranet_marcaAsignado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#marcaAsignado");
    public static final org.semanticwb.platform.SemanticProperty intranet_actividadARealizar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#actividadARealizar");
    public static final org.semanticwb.platform.SemanticProperty intranet_placasAsignado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#placasAsignado");
    public static final org.semanticwb.platform.SemanticClass intranet_ReservacionAuto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionAuto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionAuto");

    public static class ClassMgr
    {
       /**
       * Returns a list of ReservacionAuto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ReservacionAuto for all models
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto>(it, true);
        }

        public static com.infotec.eworkplace.swb.ReservacionAuto createReservacionAuto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.ReservacionAuto.ClassMgr.createReservacionAuto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return A com.infotec.eworkplace.swb.ReservacionAuto
       */
        public static com.infotec.eworkplace.swb.ReservacionAuto getReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionAuto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return A com.infotec.eworkplace.swb.ReservacionAuto
       */
        public static com.infotec.eworkplace.swb.ReservacionAuto createReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionAuto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       */
        public static void removeReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ReservacionAuto
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionAuto
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return true if the com.infotec.eworkplace.swb.ReservacionAuto exists, false otherwise
       */

        public static boolean hasReservacionAuto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReservacionAuto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionAuto with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutoBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionAuto with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutoBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionAuto with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionAuto
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutoByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionAuto with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionAuto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionAuto> listReservacionAutoByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionAuto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ReservacionAutoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservacionAuto
   */
    public ReservacionAutoBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the HoraSalida property
* @return java.util.Date with the HoraSalida
*/
    public java.util.Date getHoraSalida()
    {
        return getSemanticObject().getDateProperty(intranet_horaSalida);
    }

/**
* Sets the HoraSalida property
* @param value long with the HoraSalida
*/
    public void setHoraSalida(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_horaSalida, value);
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
* Gets the FechaSalida property
* @return java.util.Date with the FechaSalida
*/
    public java.util.Date getFechaSalida()
    {
        return getSemanticObject().getDateProperty(intranet_fechaSalida);
    }

/**
* Sets the FechaSalida property
* @param value long with the FechaSalida
*/
    public void setFechaSalida(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaSalida, value);
    }

/**
* Gets the FechaDeRegreso property
* @return java.util.Date with the FechaDeRegreso
*/
    public java.util.Date getFechaDeRegreso()
    {
        return getSemanticObject().getDateProperty(intranet_fechaDeRegreso);
    }

/**
* Sets the FechaDeRegreso property
* @param value long with the FechaDeRegreso
*/
    public void setFechaDeRegreso(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaDeRegreso, value);
    }

/**
* Gets the HoraRegreso property
* @return java.util.Date with the HoraRegreso
*/
    public java.util.Date getHoraRegreso()
    {
        return getSemanticObject().getDateProperty(intranet_horaRegreso);
    }

/**
* Sets the HoraRegreso property
* @param value long with the HoraRegreso
*/
    public void setHoraRegreso(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_horaRegreso, value);
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
* Gets the Destino property
* @return String with the Destino
*/
    public String getDestino()
    {
        return getSemanticObject().getProperty(intranet_destino);
    }

/**
* Sets the Destino property
* @param value long with the Destino
*/
    public void setDestino(String value)
    {
        getSemanticObject().setProperty(intranet_destino, value);
    }

/**
* Gets the MarcaAsignado property
* @return String with the MarcaAsignado
*/
    public String getMarcaAsignado()
    {
        return getSemanticObject().getProperty(intranet_marcaAsignado);
    }

/**
* Sets the MarcaAsignado property
* @param value long with the MarcaAsignado
*/
    public void setMarcaAsignado(String value)
    {
        getSemanticObject().setProperty(intranet_marcaAsignado, value);
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
* Gets the ActividadARealizar property
* @return String with the ActividadARealizar
*/
    public String getActividadARealizar()
    {
        return getSemanticObject().getProperty(intranet_actividadARealizar);
    }

/**
* Sets the ActividadARealizar property
* @param value long with the ActividadARealizar
*/
    public void setActividadARealizar(String value)
    {
        getSemanticObject().setProperty(intranet_actividadARealizar, value);
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
* Gets the PlacasAsignado property
* @return String with the PlacasAsignado
*/
    public String getPlacasAsignado()
    {
        return getSemanticObject().getProperty(intranet_placasAsignado);
    }

/**
* Sets the PlacasAsignado property
* @param value long with the PlacasAsignado
*/
    public void setPlacasAsignado(String value)
    {
        getSemanticObject().setProperty(intranet_placasAsignado, value);
    }
}
