package com.infotec.rh.syr.swb.base;


public abstract class SolicitudBajaRecursoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,com.infotec.eworkplace.swb.Solicitable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaFinContratoBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaFinContratoBaja");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaRecepcionDocumentos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaRecepcionDocumentos");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereConvenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereConvenio");
    public static final org.semanticwb.platform.SemanticProperty intranet_ultimoDiaPresente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ultimoDiaPresente");
    public static final org.semanticwb.platform.SemanticProperty intranet_archivoExpediente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#archivoExpediente");
    public static final org.semanticwb.platform.SemanticProperty intranet_responsableRealizaConvenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#responsableRealizaConvenio");
    public static final org.semanticwb.platform.SemanticClass intranet_TipoBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoBaja");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivoBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivoBaja");
    public static final org.semanticwb.platform.SemanticProperty intranet_archivoCartaRenuncia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#archivoCartaRenuncia");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_empleadoBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#empleadoBaja");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaMemorándum=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaMemorándum");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentosAnexos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentosAnexos");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioMemorandum=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioMemorandum");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioExpediente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioExpediente");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaEntrega=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaEntrega");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaCartaRenuncia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaCartaRenuncia");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaFirmaDocumentos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaFirmaDocumentos");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudBajaRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudBajaRecurso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudBajaRecurso");

    public static class ClassMgr
    {
       /**
       * Returns a list of SolicitudBajaRecurso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SolicitudBajaRecurso for all models
       * @return Iterator of com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso>(it, true);
        }

        public static com.infotec.rh.syr.swb.SolicitudBajaRecurso createSolicitudBajaRecurso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SolicitudBajaRecurso.ClassMgr.createSolicitudBajaRecurso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return A com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */
        public static com.infotec.rh.syr.swb.SolicitudBajaRecurso getSolicitudBajaRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SolicitudBajaRecurso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return A com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */
        public static com.infotec.rh.syr.swb.SolicitudBajaRecurso createSolicitudBajaRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SolicitudBajaRecurso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */
        public static void removeSolicitudBajaRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return true if the com.infotec.rh.syr.swb.SolicitudBajaRecurso exists, false otherwise
       */

        public static boolean hasSolicitudBajaRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSolicitudBajaRecurso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined MotivoBaja
       * @param value MotivoBaja of the type com.infotec.rh.syr.swb.TipoBaja
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoByMotivoBaja(com.infotec.rh.syr.swb.TipoBaja value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_motivoBaja, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined MotivoBaja
       * @param value MotivoBaja of the type com.infotec.rh.syr.swb.TipoBaja
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoByMotivoBaja(com.infotec.rh.syr.swb.TipoBaja value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_motivoBaja,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined EmpleadoBaja
       * @param value EmpleadoBaja of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoByEmpleadoBaja(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_empleadoBaja, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined EmpleadoBaja
       * @param value EmpleadoBaja of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoByEmpleadoBaja(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_empleadoBaja,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudBajaRecurso with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudBajaRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> listSolicitudBajaRecursoByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudBajaRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static SolicitudBajaRecursoBase.ClassMgr getSolicitudBajaRecursoClassMgr()
    {
        return new SolicitudBajaRecursoBase.ClassMgr();
    }

   /**
   * Constructs a SolicitudBajaRecursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SolicitudBajaRecurso
   */
    public SolicitudBajaRecursoBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the FechaFinContratoBaja property
* @return java.util.Date with the FechaFinContratoBaja
*/
    public java.util.Date getFechaFinContratoBaja()
    {
        return getSemanticObject().getDateProperty(intranet_fechaFinContratoBaja);
    }

/**
* Sets the FechaFinContratoBaja property
* @param value long with the FechaFinContratoBaja
*/
    public void setFechaFinContratoBaja(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaFinContratoBaja, value);
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
* Gets the FechaRecepcionDocumentos property
* @return java.util.Date with the FechaRecepcionDocumentos
*/
    public java.util.Date getFechaRecepcionDocumentos()
    {
        return getSemanticObject().getDateProperty(intranet_fechaRecepcionDocumentos);
    }

/**
* Sets the FechaRecepcionDocumentos property
* @param value long with the FechaRecepcionDocumentos
*/
    public void setFechaRecepcionDocumentos(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaRecepcionDocumentos, value);
    }

/**
* Gets the RequiereConvenio property
* @return boolean with the RequiereConvenio
*/
    public boolean isRequiereConvenio()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereConvenio);
    }

/**
* Sets the RequiereConvenio property
* @param value long with the RequiereConvenio
*/
    public void setRequiereConvenio(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereConvenio, value);
    }

/**
* Gets the UltimoDiaPresente property
* @return java.util.Date with the UltimoDiaPresente
*/
    public java.util.Date getUltimoDiaPresente()
    {
        return getSemanticObject().getDateProperty(intranet_ultimoDiaPresente);
    }

/**
* Sets the UltimoDiaPresente property
* @param value long with the UltimoDiaPresente
*/
    public void setUltimoDiaPresente(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_ultimoDiaPresente, value);
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
* Gets the ArchivoExpediente property
* @return String with the ArchivoExpediente
*/
    public String getArchivoExpediente()
    {
        return getSemanticObject().getProperty(intranet_archivoExpediente);
    }

/**
* Sets the ArchivoExpediente property
* @param value long with the ArchivoExpediente
*/
    public void setArchivoExpediente(String value)
    {
        getSemanticObject().setProperty(intranet_archivoExpediente, value);
    }

/**
* Gets the ResponsableRealizaConvenio property
* @return int with the ResponsableRealizaConvenio
*/
    public int getResponsableRealizaConvenio()
    {
        return getSemanticObject().getIntProperty(intranet_responsableRealizaConvenio);
    }

/**
* Sets the ResponsableRealizaConvenio property
* @param value long with the ResponsableRealizaConvenio
*/
    public void setResponsableRealizaConvenio(int value)
    {
        getSemanticObject().setIntProperty(intranet_responsableRealizaConvenio, value);
    }
   /**
   * Sets the value for the property MotivoBaja
   * @param value MotivoBaja to set
   */

    public void setMotivoBaja(com.infotec.rh.syr.swb.TipoBaja value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_motivoBaja, value.getSemanticObject());
        }else
        {
            removeMotivoBaja();
        }
    }
   /**
   * Remove the value for MotivoBaja property
   */

    public void removeMotivoBaja()
    {
        getSemanticObject().removeProperty(intranet_motivoBaja);
    }

   /**
   * Gets the MotivoBaja
   * @return a com.infotec.rh.syr.swb.TipoBaja
   */
    public com.infotec.rh.syr.swb.TipoBaja getMotivoBaja()
    {
         com.infotec.rh.syr.swb.TipoBaja ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_motivoBaja);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.TipoBaja)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ArchivoCartaRenuncia property
* @return String with the ArchivoCartaRenuncia
*/
    public String getArchivoCartaRenuncia()
    {
        return getSemanticObject().getProperty(intranet_archivoCartaRenuncia);
    }

/**
* Sets the ArchivoCartaRenuncia property
* @param value long with the ArchivoCartaRenuncia
*/
    public void setArchivoCartaRenuncia(String value)
    {
        getSemanticObject().setProperty(intranet_archivoCartaRenuncia, value);
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
   * Sets the value for the property EmpleadoBaja
   * @param value EmpleadoBaja to set
   */

    public void setEmpleadoBaja(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_empleadoBaja, value.getSemanticObject());
        }else
        {
            removeEmpleadoBaja();
        }
    }
   /**
   * Remove the value for EmpleadoBaja property
   */

    public void removeEmpleadoBaja()
    {
        getSemanticObject().removeProperty(intranet_empleadoBaja);
    }

   /**
   * Gets the EmpleadoBaja
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEmpleadoBaja()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_empleadoBaja);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NotaSolicitante property
* @return String with the NotaSolicitante
*/
    public String getNotaSolicitante()
    {
        return getSemanticObject().getProperty(intranet_notaSolicitante);
    }

/**
* Sets the NotaSolicitante property
* @param value long with the NotaSolicitante
*/
    public void setNotaSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_notaSolicitante, value);
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
* Gets the FechaMemorándum property
* @return java.util.Date with the FechaMemorándum
*/
    public java.util.Date getFechaMemorándum()
    {
        return getSemanticObject().getDateProperty(intranet_fechaMemorándum);
    }

/**
* Sets the FechaMemorándum property
* @param value long with the FechaMemorándum
*/
    public void setFechaMemorándum(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaMemorándum, value);
    }

/**
* Gets the DocumentosAnexos property
* @return String with the DocumentosAnexos
*/
    public String getDocumentosAnexos()
    {
        return getSemanticObject().getProperty(intranet_documentosAnexos);
    }

/**
* Sets the DocumentosAnexos property
* @param value long with the DocumentosAnexos
*/
    public void setDocumentosAnexos(String value)
    {
        getSemanticObject().setProperty(intranet_documentosAnexos, value);
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
* Gets the FolioMemorandum property
* @return String with the FolioMemorandum
*/
    public String getFolioMemorandum()
    {
        return getSemanticObject().getProperty(intranet_folioMemorandum);
    }

/**
* Sets the FolioMemorandum property
* @param value long with the FolioMemorandum
*/
    public void setFolioMemorandum(String value)
    {
        getSemanticObject().setProperty(intranet_folioMemorandum, value);
    }

/**
* Gets the FolioExpediente property
* @return String with the FolioExpediente
*/
    public String getFolioExpediente()
    {
        return getSemanticObject().getProperty(intranet_folioExpediente);
    }

/**
* Sets the FolioExpediente property
* @param value long with the FolioExpediente
*/
    public void setFolioExpediente(String value)
    {
        getSemanticObject().setProperty(intranet_folioExpediente, value);
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
* Gets the FechaEntrega property
* @return java.util.Date with the FechaEntrega
*/
    public java.util.Date getFechaEntrega()
    {
        return getSemanticObject().getDateProperty(intranet_fechaEntrega);
    }

/**
* Sets the FechaEntrega property
* @param value long with the FechaEntrega
*/
    public void setFechaEntrega(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaEntrega, value);
    }

/**
* Gets the FechaCartaRenuncia property
* @return java.util.Date with the FechaCartaRenuncia
*/
    public java.util.Date getFechaCartaRenuncia()
    {
        return getSemanticObject().getDateProperty(intranet_fechaCartaRenuncia);
    }

/**
* Sets the FechaCartaRenuncia property
* @param value long with the FechaCartaRenuncia
*/
    public void setFechaCartaRenuncia(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaCartaRenuncia, value);
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
* Gets the FechaFirmaDocumentos property
* @return java.util.Date with the FechaFirmaDocumentos
*/
    public java.util.Date getFechaFirmaDocumentos()
    {
        return getSemanticObject().getDateProperty(intranet_fechaFirmaDocumentos);
    }

/**
* Sets the FechaFirmaDocumentos property
* @param value long with the FechaFirmaDocumentos
*/
    public void setFechaFirmaDocumentos(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaFirmaDocumentos, value);
    }
}
