package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de seguimiento a una solicitud de recursos humanos 
   */
public abstract class SeguimientoSolicitudRecursoBase extends com.infotec.eworkplace.swb.Seguimiento implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_validaRH=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaRH");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaRecepcionSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaRecepcionSolicitud");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidaSuficienciaAP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidaSuficienciaAP");
    public static final org.semanticwb.platform.SemanticProperty intranet_otraConsultaSuficiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otraConsultaSuficiencia");
   /**
   * Elemento que contiene la información del perfil del usuario requerido
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaValidaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaValidaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_altaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#altaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidaDirector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidaDirector");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoValidaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoValidaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_validaAP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaAP");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaDirector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaDirector");
    public static final org.semanticwb.platform.SemanticProperty intranet_archivoSuficiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#archivoSuficiencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaConsultaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaConsultaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaAutorizaFinanzas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaAutorizaFinanzas");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoAutorizaFinanzas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoAutorizaFinanzas");
    public static final org.semanticwb.platform.SemanticProperty intranet_validaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_modificarSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#modificarSolicitud");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaOtraConsulta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaOtraConsulta");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaAltaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaAltaPresupuesto");
   /**
   * Encapsula la información relacionada con una publicación de una vacante en las bolsas de trabajo
   */
    public static final org.semanticwb.platform.SemanticClass intranet_PublicacionVacante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PublicacionVacante");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPublicacionVacante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPublicacionVacante");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaValidaRH=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaValidaRH");
   /**
   * Encapsula las propiedades de seguimiento a una solicitud de recursos humanos
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SeguimientoSolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoSolicitudRecurso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoSolicitudRecurso");

    public static class ClassMgr
    {
       /**
       * Returns a list of SeguimientoSolicitudRecurso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso for all models
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso>(it, true);
        }

        public static com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso createSeguimientoSolicitudRecurso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso.ClassMgr.createSeguimientoSolicitudRecurso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return A com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */
        public static com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso getSeguimientoSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return A com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */
        public static com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso createSeguimientoSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */
        public static void removeSeguimientoSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return true if the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso exists, false otherwise
       */

        public static boolean hasSeguimientoSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeguimientoSolicitudRecurso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined SolicitudRecurso
       * @param value SolicitudRecurso of the type com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoBySolicitudRecurso(com.infotec.cvi.swb.SolicitudRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecurso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined SolicitudRecurso
       * @param value SolicitudRecurso of the type com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoBySolicitudRecurso(com.infotec.cvi.swb.SolicitudRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecurso,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined EncargadoValidaPresupuesto
       * @param value EncargadoValidaPresupuesto of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByEncargadoValidaPresupuesto(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoValidaPresupuesto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined EncargadoValidaPresupuesto
       * @param value EncargadoValidaPresupuesto of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByEncargadoValidaPresupuesto(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoValidaPresupuesto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined EncargadoAutorizaFinanzas
       * @param value EncargadoAutorizaFinanzas of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByEncargadoAutorizaFinanzas(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoAutorizaFinanzas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined EncargadoAutorizaFinanzas
       * @param value EncargadoAutorizaFinanzas of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByEncargadoAutorizaFinanzas(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoAutorizaFinanzas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined PublicacionVacante
       * @param value PublicacionVacante of the type com.infotec.rh.syr.swb.PublicacionVacante
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByPublicacionVacante(com.infotec.rh.syr.swb.PublicacionVacante value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPublicacionVacante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso with a determined PublicacionVacante
       * @param value PublicacionVacante of the type com.infotec.rh.syr.swb.PublicacionVacante
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> listSeguimientoSolicitudRecursoByPublicacionVacante(com.infotec.rh.syr.swb.PublicacionVacante value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPublicacionVacante,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SeguimientoSolicitudRecursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SeguimientoSolicitudRecurso
   */
    public SeguimientoSolicitudRecursoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ValidaRH property
* @return boolean with the ValidaRH
*/
    public boolean isValidaRH()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaRH);
    }

/**
* Sets the ValidaRH property
* @param value long with the ValidaRH
*/
    public void setValidaRH(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaRH, value);
    }

/**
* Gets the FechaRecepcionSolicitud property
* @return java.util.Date with the FechaRecepcionSolicitud
*/
    public java.util.Date getFechaRecepcionSolicitud()
    {
        return getSemanticObject().getDateProperty(intranet_fechaRecepcionSolicitud);
    }

/**
* Sets the FechaRecepcionSolicitud property
* @param value long with the FechaRecepcionSolicitud
*/
    public void setFechaRecepcionSolicitud(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaRecepcionSolicitud, value);
    }

/**
* Gets the NotaValidaSuficienciaAP property
* @return String with the NotaValidaSuficienciaAP
*/
    public String getNotaValidaSuficienciaAP()
    {
        return getSemanticObject().getProperty(intranet_notaValidaSuficienciaAP);
    }

/**
* Sets the NotaValidaSuficienciaAP property
* @param value long with the NotaValidaSuficienciaAP
*/
    public void setNotaValidaSuficienciaAP(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidaSuficienciaAP, value);
    }

/**
* Gets the OtraConsultaSuficiencia property
* @return boolean with the OtraConsultaSuficiencia
*/
    public boolean isOtraConsultaSuficiencia()
    {
        return getSemanticObject().getBooleanProperty(intranet_otraConsultaSuficiencia);
    }

/**
* Sets the OtraConsultaSuficiencia property
* @param value long with the OtraConsultaSuficiencia
*/
    public void setOtraConsultaSuficiencia(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_otraConsultaSuficiencia, value);
    }
   /**
   * Sets the value for the property SolicitudRecurso
   * @param value SolicitudRecurso to set
   */

    public void setSolicitudRecurso(com.infotec.cvi.swb.SolicitudRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudRecurso, value.getSemanticObject());
        }else
        {
            removeSolicitudRecurso();
        }
    }
   /**
   * Remove the value for SolicitudRecurso property
   */

    public void removeSolicitudRecurso()
    {
        getSemanticObject().removeProperty(intranet_solicitudRecurso);
    }

   /**
   * Gets the SolicitudRecurso
   * @return a com.infotec.cvi.swb.SolicitudRecurso
   */
    public com.infotec.cvi.swb.SolicitudRecurso getSolicitudRecurso()
    {
         com.infotec.cvi.swb.SolicitudRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudRecurso);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SolicitudRecurso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaValidaPresupuesto property
* @return java.util.Date with the FechaValidaPresupuesto
*/
    public java.util.Date getFechaValidaPresupuesto()
    {
        return getSemanticObject().getDateProperty(intranet_fechaValidaPresupuesto);
    }

/**
* Sets the FechaValidaPresupuesto property
* @param value long with the FechaValidaPresupuesto
*/
    public void setFechaValidaPresupuesto(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaValidaPresupuesto, value);
    }

/**
* Gets the AltaPresupuesto property
* @return boolean with the AltaPresupuesto
*/
    public boolean isAltaPresupuesto()
    {
        return getSemanticObject().getBooleanProperty(intranet_altaPresupuesto);
    }

/**
* Sets the AltaPresupuesto property
* @param value long with the AltaPresupuesto
*/
    public void setAltaPresupuesto(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_altaPresupuesto, value);
    }

/**
* Gets the NotaValidaDirector property
* @return String with the NotaValidaDirector
*/
    public String getNotaValidaDirector()
    {
        return getSemanticObject().getProperty(intranet_notaValidaDirector);
    }

/**
* Sets the NotaValidaDirector property
* @param value long with the NotaValidaDirector
*/
    public void setNotaValidaDirector(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidaDirector, value);
    }
   /**
   * Sets the value for the property EncargadoValidaPresupuesto
   * @param value EncargadoValidaPresupuesto to set
   */

    public void setEncargadoValidaPresupuesto(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoValidaPresupuesto, value.getSemanticObject());
        }else
        {
            removeEncargadoValidaPresupuesto();
        }
    }
   /**
   * Remove the value for EncargadoValidaPresupuesto property
   */

    public void removeEncargadoValidaPresupuesto()
    {
        getSemanticObject().removeProperty(intranet_encargadoValidaPresupuesto);
    }

   /**
   * Gets the EncargadoValidaPresupuesto
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoValidaPresupuesto()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoValidaPresupuesto);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ValidaAP property
* @return boolean with the ValidaAP
*/
    public boolean isValidaAP()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaAP);
    }

/**
* Sets the ValidaAP property
* @param value long with the ValidaAP
*/
    public void setValidaAP(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaAP, value);
    }

/**
* Gets the AutorizaDirector property
* @return boolean with the AutorizaDirector
*/
    public boolean isAutorizaDirector()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizaDirector);
    }

/**
* Sets the AutorizaDirector property
* @param value long with the AutorizaDirector
*/
    public void setAutorizaDirector(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizaDirector, value);
    }

/**
* Gets the ArchivoSuficiencia property
* @return String with the ArchivoSuficiencia
*/
    public String getArchivoSuficiencia()
    {
        return getSemanticObject().getProperty(intranet_archivoSuficiencia);
    }

/**
* Sets the ArchivoSuficiencia property
* @param value long with the ArchivoSuficiencia
*/
    public void setArchivoSuficiencia(String value)
    {
        getSemanticObject().setProperty(intranet_archivoSuficiencia, value);
    }

/**
* Gets the NotaConsultaPresupuesto property
* @return String with the NotaConsultaPresupuesto
*/
    public String getNotaConsultaPresupuesto()
    {
        return getSemanticObject().getProperty(intranet_notaConsultaPresupuesto);
    }

/**
* Sets the NotaConsultaPresupuesto property
* @param value long with the NotaConsultaPresupuesto
*/
    public void setNotaConsultaPresupuesto(String value)
    {
        getSemanticObject().setProperty(intranet_notaConsultaPresupuesto, value);
    }

/**
* Gets the FechaAutorizaFinanzas property
* @return java.util.Date with the FechaAutorizaFinanzas
*/
    public java.util.Date getFechaAutorizaFinanzas()
    {
        return getSemanticObject().getDateProperty(intranet_fechaAutorizaFinanzas);
    }

/**
* Sets the FechaAutorizaFinanzas property
* @param value long with the FechaAutorizaFinanzas
*/
    public void setFechaAutorizaFinanzas(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaAutorizaFinanzas, value);
    }
   /**
   * Sets the value for the property EncargadoAutorizaFinanzas
   * @param value EncargadoAutorizaFinanzas to set
   */

    public void setEncargadoAutorizaFinanzas(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoAutorizaFinanzas, value.getSemanticObject());
        }else
        {
            removeEncargadoAutorizaFinanzas();
        }
    }
   /**
   * Remove the value for EncargadoAutorizaFinanzas property
   */

    public void removeEncargadoAutorizaFinanzas()
    {
        getSemanticObject().removeProperty(intranet_encargadoAutorizaFinanzas);
    }

   /**
   * Gets the EncargadoAutorizaFinanzas
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoAutorizaFinanzas()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoAutorizaFinanzas);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ValidaPresupuesto property
* @return boolean with the ValidaPresupuesto
*/
    public boolean isValidaPresupuesto()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaPresupuesto);
    }

/**
* Sets the ValidaPresupuesto property
* @param value long with the ValidaPresupuesto
*/
    public void setValidaPresupuesto(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaPresupuesto, value);
    }

/**
* Gets the ModificarSolicitud property
* @return boolean with the ModificarSolicitud
*/
    public boolean isModificarSolicitud()
    {
        return getSemanticObject().getBooleanProperty(intranet_modificarSolicitud);
    }

/**
* Sets the ModificarSolicitud property
* @param value long with the ModificarSolicitud
*/
    public void setModificarSolicitud(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_modificarSolicitud, value);
    }

/**
* Gets the NotaOtraConsulta property
* @return String with the NotaOtraConsulta
*/
    public String getNotaOtraConsulta()
    {
        return getSemanticObject().getProperty(intranet_notaOtraConsulta);
    }

/**
* Sets the NotaOtraConsulta property
* @param value long with the NotaOtraConsulta
*/
    public void setNotaOtraConsulta(String value)
    {
        getSemanticObject().setProperty(intranet_notaOtraConsulta, value);
    }

/**
* Gets the FechaAltaPresupuesto property
* @return java.util.Date with the FechaAltaPresupuesto
*/
    public java.util.Date getFechaAltaPresupuesto()
    {
        return getSemanticObject().getDateProperty(intranet_fechaAltaPresupuesto);
    }

/**
* Sets the FechaAltaPresupuesto property
* @param value long with the FechaAltaPresupuesto
*/
    public void setFechaAltaPresupuesto(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaAltaPresupuesto, value);
    }
   /**
   * Gets all the com.infotec.rh.syr.swb.PublicacionVacante
   * @return A GenericIterator with all the com.infotec.rh.syr.swb.PublicacionVacante
   */

    public org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante> listPublicacionVacantes()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PublicacionVacante>(getSemanticObject().listObjectProperties(intranet_hasPublicacionVacante));
    }

   /**
   * Gets true if has a PublicacionVacante
   * @param value com.infotec.rh.syr.swb.PublicacionVacante to verify
   * @return true if the com.infotec.rh.syr.swb.PublicacionVacante exists, false otherwise
   */
    public boolean hasPublicacionVacante(com.infotec.rh.syr.swb.PublicacionVacante value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPublicacionVacante,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PublicacionVacante
   * @param value com.infotec.rh.syr.swb.PublicacionVacante to add
   */

    public void addPublicacionVacante(com.infotec.rh.syr.swb.PublicacionVacante value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPublicacionVacante, value.getSemanticObject());
    }
   /**
   * Removes all the PublicacionVacante
   */

    public void removeAllPublicacionVacante()
    {
        getSemanticObject().removeProperty(intranet_hasPublicacionVacante);
    }
   /**
   * Removes a PublicacionVacante
   * @param value com.infotec.rh.syr.swb.PublicacionVacante to remove
   */

    public void removePublicacionVacante(com.infotec.rh.syr.swb.PublicacionVacante value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPublicacionVacante,value.getSemanticObject());
    }

   /**
   * Gets the PublicacionVacante
   * @return a com.infotec.rh.syr.swb.PublicacionVacante
   */
    public com.infotec.rh.syr.swb.PublicacionVacante getPublicacionVacante()
    {
         com.infotec.rh.syr.swb.PublicacionVacante ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPublicacionVacante);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.PublicacionVacante)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NotaValidaRH property
* @return String with the NotaValidaRH
*/
    public String getNotaValidaRH()
    {
        return getSemanticObject().getProperty(intranet_notaValidaRH);
    }

/**
* Sets the NotaValidaRH property
* @param value long with the NotaValidaRH
*/
    public void setNotaValidaRH(String value)
    {
        getSemanticObject().setProperty(intranet_notaValidaRH, value);
    }
}
