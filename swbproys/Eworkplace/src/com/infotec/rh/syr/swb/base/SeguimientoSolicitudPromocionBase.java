package com.infotec.rh.syr.swb.base;


public abstract class SeguimientoSolicitudPromocionBase extends com.infotec.eworkplace.swb.Seguimiento implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizadoDirectorPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizadoDirectorPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaAltaPresupuestoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaAltaPresupuestoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_recepcionSolicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#recepcionSolicitudPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_presupuestoAutorizadoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#presupuestoAutorizadoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_modificaSolicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#modificaSolicitudPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidaPresupuestoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidaPresupuestoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_validacionEspecial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validacionEspecial");
    public static final org.semanticwb.platform.SemanticProperty intranet_validaAPPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaAPPromocion");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoValidaPresupuestoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoValidaPresupuestoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_validaPresupuestosPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaPresupuestosPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaAnalista=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaAnalista");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidaSuficienciaAPPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidaSuficienciaAPPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoAnalistaValida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoAnalistaValida");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereConsultarSuficiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereConsultarSuficiencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_otraConsultaSuficienciaPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otraConsultaSuficienciaPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_altaPresupuestoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#altaPresupuestoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidaDirectorPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidaDirectorPromocion");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudPromocion");
    public static final org.semanticwb.platform.SemanticClass intranet_SeguimientoSolicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoSolicitudPromocion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoSolicitudPromocion");

    public static class ClassMgr
    {
       /**
       * Returns a list of SeguimientoSolicitudPromocion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion for all models
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion>(it, true);
        }

        public static com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion createSeguimientoSolicitudPromocion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion.ClassMgr.createSeguimientoSolicitudPromocion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return A com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */
        public static com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion getSeguimientoSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return A com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */
        public static com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion createSeguimientoSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */
        public static void removeSeguimientoSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return true if the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion exists, false otherwise
       */

        public static boolean hasSeguimientoSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeguimientoSolicitudPromocion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined EncargadoValidaPresupuestoPromocion
       * @param value EncargadoValidaPresupuestoPromocion of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByEncargadoValidaPresupuestoPromocion(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoValidaPresupuestoPromocion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined EncargadoValidaPresupuestoPromocion
       * @param value EncargadoValidaPresupuestoPromocion of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByEncargadoValidaPresupuestoPromocion(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoValidaPresupuestoPromocion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined EncargadoAnalistaValida
       * @param value EncargadoAnalistaValida of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByEncargadoAnalistaValida(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoAnalistaValida, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined EncargadoAnalistaValida
       * @param value EncargadoAnalistaValida of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionByEncargadoAnalistaValida(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoAnalistaValida,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined SolicitudPromocion
       * @param value SolicitudPromocion of the type com.infotec.rh.syr.swb.SolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionBySolicitudPromocion(com.infotec.rh.syr.swb.SolicitudPromocion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudPromocion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion with a determined SolicitudPromocion
       * @param value SolicitudPromocion of the type com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> listSeguimientoSolicitudPromocionBySolicitudPromocion(com.infotec.rh.syr.swb.SolicitudPromocion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudPromocion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SeguimientoSolicitudPromocionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SeguimientoSolicitudPromocion
   */
    public SeguimientoSolicitudPromocionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the AutorizadoDirectorPromocion property
* @return boolean with the AutorizadoDirectorPromocion
*/
    public boolean isAutorizadoDirectorPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizadoDirectorPromocion);
    }

/**
* Sets the AutorizadoDirectorPromocion property
* @param value long with the AutorizadoDirectorPromocion
*/
    public void setAutorizadoDirectorPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizadoDirectorPromocion, value);
    }

/**
* Gets the FechaAltaPresupuestoPromocion property
* @return java.util.Date with the FechaAltaPresupuestoPromocion
*/
    public java.util.Date getFechaAltaPresupuestoPromocion()
    {
        return getSemanticObject().getDateProperty(intranet_fechaAltaPresupuestoPromocion);
    }

/**
* Sets the FechaAltaPresupuestoPromocion property
* @param value long with the FechaAltaPresupuestoPromocion
*/
    public void setFechaAltaPresupuestoPromocion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaAltaPresupuestoPromocion, value);
    }

/**
* Gets the RecepcionSolicitudPromocion property
* @return boolean with the RecepcionSolicitudPromocion
*/
    public boolean isRecepcionSolicitudPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_recepcionSolicitudPromocion);
    }

/**
* Sets the RecepcionSolicitudPromocion property
* @param value long with the RecepcionSolicitudPromocion
*/
    public void setRecepcionSolicitudPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_recepcionSolicitudPromocion, value);
    }

/**
* Gets the PresupuestoAutorizadoPromocion property
* @return String with the PresupuestoAutorizadoPromocion
*/
    public String getPresupuestoAutorizadoPromocion()
    {
        return getSemanticObject().getProperty(intranet_presupuestoAutorizadoPromocion);
    }

/**
* Sets the PresupuestoAutorizadoPromocion property
* @param value long with the PresupuestoAutorizadoPromocion
*/
    public void setPresupuestoAutorizadoPromocion(String value)
    {
        getSemanticObject().setProperty(intranet_presupuestoAutorizadoPromocion, value);
    }

/**
* Gets the ModificaSolicitudPromocion property
* @return boolean with the ModificaSolicitudPromocion
*/
    public boolean isModificaSolicitudPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_modificaSolicitudPromocion);
    }

/**
* Sets the ModificaSolicitudPromocion property
* @param value long with the ModificaSolicitudPromocion
*/
    public void setModificaSolicitudPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_modificaSolicitudPromocion, value);
    }

/**
* Gets the NotaValidaPresupuestoPromocion property
* @return String with the NotaValidaPresupuestoPromocion
*/
    public String getNotaValidaPresupuestoPromocion()
    {
        return getSemanticObject().getProperty(intranet_notaValidaPresupuestoPromocion);
    }

/**
* Sets the NotaValidaPresupuestoPromocion property
* @param value long with the NotaValidaPresupuestoPromocion
*/
    public void setNotaValidaPresupuestoPromocion(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidaPresupuestoPromocion, value);
    }

/**
* Gets the ValidacionEspecial property
* @return boolean with the ValidacionEspecial
*/
    public boolean isValidacionEspecial()
    {
        return getSemanticObject().getBooleanProperty(intranet_validacionEspecial);
    }

/**
* Sets the ValidacionEspecial property
* @param value long with the ValidacionEspecial
*/
    public void setValidacionEspecial(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validacionEspecial, value);
    }

/**
* Gets the ValidaAPPromocion property
* @return boolean with the ValidaAPPromocion
*/
    public boolean isValidaAPPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaAPPromocion);
    }

/**
* Sets the ValidaAPPromocion property
* @param value long with the ValidaAPPromocion
*/
    public void setValidaAPPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaAPPromocion, value);
    }
   /**
   * Sets the value for the property EncargadoValidaPresupuestoPromocion
   * @param value EncargadoValidaPresupuestoPromocion to set
   */

    public void setEncargadoValidaPresupuestoPromocion(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoValidaPresupuestoPromocion, value.getSemanticObject());
        }else
        {
            removeEncargadoValidaPresupuestoPromocion();
        }
    }
   /**
   * Remove the value for EncargadoValidaPresupuestoPromocion property
   */

    public void removeEncargadoValidaPresupuestoPromocion()
    {
        getSemanticObject().removeProperty(intranet_encargadoValidaPresupuestoPromocion);
    }

   /**
   * Gets the EncargadoValidaPresupuestoPromocion
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoValidaPresupuestoPromocion()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoValidaPresupuestoPromocion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ValidaPresupuestosPromocion property
* @return boolean with the ValidaPresupuestosPromocion
*/
    public boolean isValidaPresupuestosPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaPresupuestosPromocion);
    }

/**
* Sets the ValidaPresupuestosPromocion property
* @param value long with the ValidaPresupuestosPromocion
*/
    public void setValidaPresupuestosPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaPresupuestosPromocion, value);
    }

/**
* Gets the NotaAnalista property
* @return String with the NotaAnalista
*/
    public String getNotaAnalista()
    {
        return getSemanticObject().getProperty(intranet_notaAnalista);
    }

/**
* Sets the NotaAnalista property
* @param value long with the NotaAnalista
*/
    public void setNotaAnalista(String value)
    {
        getSemanticObject().setProperty(intranet_notaAnalista, value);
    }

/**
* Gets the NotaValidaSuficienciaAPPromocion property
* @return String with the NotaValidaSuficienciaAPPromocion
*/
    public String getNotaValidaSuficienciaAPPromocion()
    {
        return getSemanticObject().getProperty(intranet_notaValidaSuficienciaAPPromocion);
    }

/**
* Sets the NotaValidaSuficienciaAPPromocion property
* @param value long with the NotaValidaSuficienciaAPPromocion
*/
    public void setNotaValidaSuficienciaAPPromocion(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidaSuficienciaAPPromocion, value);
    }
   /**
   * Sets the value for the property EncargadoAnalistaValida
   * @param value EncargadoAnalistaValida to set
   */

    public void setEncargadoAnalistaValida(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoAnalistaValida, value.getSemanticObject());
        }else
        {
            removeEncargadoAnalistaValida();
        }
    }
   /**
   * Remove the value for EncargadoAnalistaValida property
   */

    public void removeEncargadoAnalistaValida()
    {
        getSemanticObject().removeProperty(intranet_encargadoAnalistaValida);
    }

   /**
   * Gets the EncargadoAnalistaValida
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoAnalistaValida()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoAnalistaValida);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RequiereConsultarSuficiencia property
* @return boolean with the RequiereConsultarSuficiencia
*/
    public boolean isRequiereConsultarSuficiencia()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereConsultarSuficiencia);
    }

/**
* Sets the RequiereConsultarSuficiencia property
* @param value long with the RequiereConsultarSuficiencia
*/
    public void setRequiereConsultarSuficiencia(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereConsultarSuficiencia, value);
    }

/**
* Gets the OtraConsultaSuficienciaPromocion property
* @return boolean with the OtraConsultaSuficienciaPromocion
*/
    public boolean isOtraConsultaSuficienciaPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_otraConsultaSuficienciaPromocion);
    }

/**
* Sets the OtraConsultaSuficienciaPromocion property
* @param value long with the OtraConsultaSuficienciaPromocion
*/
    public void setOtraConsultaSuficienciaPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_otraConsultaSuficienciaPromocion, value);
    }

/**
* Gets the AltaPresupuestoPromocion property
* @return boolean with the AltaPresupuestoPromocion
*/
    public boolean isAltaPresupuestoPromocion()
    {
        return getSemanticObject().getBooleanProperty(intranet_altaPresupuestoPromocion);
    }

/**
* Sets the AltaPresupuestoPromocion property
* @param value long with the AltaPresupuestoPromocion
*/
    public void setAltaPresupuestoPromocion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_altaPresupuestoPromocion, value);
    }

/**
* Gets the NotaValidaDirectorPromocion property
* @return String with the NotaValidaDirectorPromocion
*/
    public String getNotaValidaDirectorPromocion()
    {
        return getSemanticObject().getProperty(intranet_notaValidaDirectorPromocion);
    }

/**
* Sets the NotaValidaDirectorPromocion property
* @param value long with the NotaValidaDirectorPromocion
*/
    public void setNotaValidaDirectorPromocion(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidaDirectorPromocion, value);
    }
   /**
   * Sets the value for the property SolicitudPromocion
   * @param value SolicitudPromocion to set
   */

    public void setSolicitudPromocion(com.infotec.rh.syr.swb.SolicitudPromocion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudPromocion, value.getSemanticObject());
        }else
        {
            removeSolicitudPromocion();
        }
    }
   /**
   * Remove the value for SolicitudPromocion property
   */

    public void removeSolicitudPromocion()
    {
        getSemanticObject().removeProperty(intranet_solicitudPromocion);
    }

   /**
   * Gets the SolicitudPromocion
   * @return a com.infotec.rh.syr.swb.SolicitudPromocion
   */
    public com.infotec.rh.syr.swb.SolicitudPromocion getSolicitudPromocion()
    {
         com.infotec.rh.syr.swb.SolicitudPromocion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudPromocion);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.SolicitudPromocion)obj.createGenericInstance();
         }
         return ret;
    }
}
