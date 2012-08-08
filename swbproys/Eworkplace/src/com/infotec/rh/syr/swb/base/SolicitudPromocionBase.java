package com.infotec.rh.syr.swb.base;


public abstract class SolicitudPromocionBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaPromocionDirector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaPromocionDirector");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaRH=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaRH");
    public static final org.semanticwb.platform.SemanticProperty intranet_montoTotalPropuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#montoTotalPropuesto");
   /**
   * Elemento que contiene la información del perfil del usuario requerido
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudRecursoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudRecursoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaInicioNuevoPuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaInicioNuevoPuesto");
   /**
   * Catálogo utilizado para indicar el Tipo de promoción
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoPromocion");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaDirectorPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaDirectorPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_recursoPromocionar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#recursoPromocionar");
   /**
   * Elemento utilizado para guardar los Documentos Probatorios que respalda la información del CV capturada por el usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentosPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentosPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_sueldoBrutoActual=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sueldoBrutoActual");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaTerminoNuevoPuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaTerminoNuevoPuesto");
   /**
   * Catálogo utilizado para indicar los tipos de puesto
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Puesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Puesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_puestoPropuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#puestoPropuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_sueldoBrutoPropuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sueldoBrutoPropuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaPromocion");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudPromocion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudPromocion");

    public static class ClassMgr
    {
       /**
       * Returns a list of SolicitudPromocion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SolicitudPromocion for all models
       * @return Iterator of com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion>(it, true);
        }

        public static com.infotec.rh.syr.swb.SolicitudPromocion createSolicitudPromocion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SolicitudPromocion.ClassMgr.createSolicitudPromocion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return A com.infotec.rh.syr.swb.SolicitudPromocion
       */
        public static com.infotec.rh.syr.swb.SolicitudPromocion getSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SolicitudPromocion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return A com.infotec.rh.syr.swb.SolicitudPromocion
       */
        public static com.infotec.rh.syr.swb.SolicitudPromocion createSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SolicitudPromocion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       */
        public static void removeSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SolicitudPromocion
       * @param id Identifier for com.infotec.rh.syr.swb.SolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return true if the com.infotec.rh.syr.swb.SolicitudPromocion exists, false otherwise
       */

        public static boolean hasSolicitudPromocion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSolicitudPromocion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined SolicitudRecursoPromocion
       * @param value SolicitudRecursoPromocion of the type com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionBySolicitudRecursoPromocion(com.infotec.cvi.swb.SolicitudRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecursoPromocion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined SolicitudRecursoPromocion
       * @param value SolicitudRecursoPromocion of the type com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionBySolicitudRecursoPromocion(com.infotec.cvi.swb.SolicitudRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecursoPromocion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined TipoPromocion
       * @param value TipoPromocion of the type com.infotec.cvi.swb.TipoPromocion
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByTipoPromocion(com.infotec.cvi.swb.TipoPromocion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoPromocion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined TipoPromocion
       * @param value TipoPromocion of the type com.infotec.cvi.swb.TipoPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByTipoPromocion(com.infotec.cvi.swb.TipoPromocion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoPromocion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined AutorizaDirectorPromocion
       * @param value AutorizaDirectorPromocion of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByAutorizaDirectorPromocion(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_autorizaDirectorPromocion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined AutorizaDirectorPromocion
       * @param value AutorizaDirectorPromocion of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByAutorizaDirectorPromocion(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_autorizaDirectorPromocion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined RecursoPromocionar
       * @param value RecursoPromocionar of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByRecursoPromocionar(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_recursoPromocionar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined RecursoPromocionar
       * @param value RecursoPromocionar of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByRecursoPromocionar(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_recursoPromocionar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined DocumentosPromocion
       * @param value DocumentosPromocion of the type com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByDocumentosPromocion(com.infotec.cvi.swb.DocumentoProbatorio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_documentosPromocion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined DocumentosPromocion
       * @param value DocumentosPromocion of the type com.infotec.cvi.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByDocumentosPromocion(com.infotec.cvi.swb.DocumentoProbatorio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_documentosPromocion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined PuestoPropuesto
       * @param value PuestoPropuesto of the type com.infotec.cvi.swb.Puesto
       * @param model Model of the com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByPuestoPropuesto(com.infotec.cvi.swb.Puesto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_puestoPropuesto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SolicitudPromocion with a determined PuestoPropuesto
       * @param value PuestoPropuesto of the type com.infotec.cvi.swb.Puesto
       * @return Iterator with all the com.infotec.rh.syr.swb.SolicitudPromocion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SolicitudPromocion> listSolicitudPromocionByPuestoPropuesto(com.infotec.cvi.swb.Puesto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SolicitudPromocion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_puestoPropuesto,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SolicitudPromocionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SolicitudPromocion
   */
    public SolicitudPromocionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the AutorizaPromocionDirector property
* @return boolean with the AutorizaPromocionDirector
*/
    public boolean isAutorizaPromocionDirector()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizaPromocionDirector);
    }

/**
* Sets the AutorizaPromocionDirector property
* @param value long with the AutorizaPromocionDirector
*/
    public void setAutorizaPromocionDirector(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizaPromocionDirector, value);
    }

/**
* Gets the AutorizaRH property
* @return boolean with the AutorizaRH
*/
    public boolean isAutorizaRH()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizaRH);
    }

/**
* Sets the AutorizaRH property
* @param value long with the AutorizaRH
*/
    public void setAutorizaRH(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizaRH, value);
    }

/**
* Gets the MontoTotalPropuesto property
* @return float with the MontoTotalPropuesto
*/
    public float getMontoTotalPropuesto()
    {
        return getSemanticObject().getFloatProperty(intranet_montoTotalPropuesto);
    }

/**
* Sets the MontoTotalPropuesto property
* @param value long with the MontoTotalPropuesto
*/
    public void setMontoTotalPropuesto(float value)
    {
        getSemanticObject().setFloatProperty(intranet_montoTotalPropuesto, value);
    }
   /**
   * Sets the value for the property SolicitudRecursoPromocion
   * @param value SolicitudRecursoPromocion to set
   */

    public void setSolicitudRecursoPromocion(com.infotec.cvi.swb.SolicitudRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudRecursoPromocion, value.getSemanticObject());
        }else
        {
            removeSolicitudRecursoPromocion();
        }
    }
   /**
   * Remove the value for SolicitudRecursoPromocion property
   */

    public void removeSolicitudRecursoPromocion()
    {
        getSemanticObject().removeProperty(intranet_solicitudRecursoPromocion);
    }

   /**
   * Gets the SolicitudRecursoPromocion
   * @return a com.infotec.cvi.swb.SolicitudRecurso
   */
    public com.infotec.cvi.swb.SolicitudRecurso getSolicitudRecursoPromocion()
    {
         com.infotec.cvi.swb.SolicitudRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudRecursoPromocion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SolicitudRecurso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaInicioNuevoPuesto property
* @return java.util.Date with the FechaInicioNuevoPuesto
*/
    public java.util.Date getFechaInicioNuevoPuesto()
    {
        return getSemanticObject().getDateProperty(intranet_fechaInicioNuevoPuesto);
    }

/**
* Sets the FechaInicioNuevoPuesto property
* @param value long with the FechaInicioNuevoPuesto
*/
    public void setFechaInicioNuevoPuesto(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaInicioNuevoPuesto, value);
    }
   /**
   * Sets the value for the property TipoPromocion
   * @param value TipoPromocion to set
   */

    public void setTipoPromocion(com.infotec.cvi.swb.TipoPromocion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_tipoPromocion, value.getSemanticObject());
        }else
        {
            removeTipoPromocion();
        }
    }
   /**
   * Remove the value for TipoPromocion property
   */

    public void removeTipoPromocion()
    {
        getSemanticObject().removeProperty(intranet_tipoPromocion);
    }

   /**
   * Gets the TipoPromocion
   * @return a com.infotec.cvi.swb.TipoPromocion
   */
    public com.infotec.cvi.swb.TipoPromocion getTipoPromocion()
    {
         com.infotec.cvi.swb.TipoPromocion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_tipoPromocion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoPromocion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property AutorizaDirectorPromocion
   * @param value AutorizaDirectorPromocion to set
   */

    public void setAutorizaDirectorPromocion(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_autorizaDirectorPromocion, value.getSemanticObject());
        }else
        {
            removeAutorizaDirectorPromocion();
        }
    }
   /**
   * Remove the value for AutorizaDirectorPromocion property
   */

    public void removeAutorizaDirectorPromocion()
    {
        getSemanticObject().removeProperty(intranet_autorizaDirectorPromocion);
    }

   /**
   * Gets the AutorizaDirectorPromocion
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getAutorizaDirectorPromocion()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_autorizaDirectorPromocion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property RecursoPromocionar
   * @param value RecursoPromocionar to set
   */

    public void setRecursoPromocionar(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_recursoPromocionar, value.getSemanticObject());
        }else
        {
            removeRecursoPromocionar();
        }
    }
   /**
   * Remove the value for RecursoPromocionar property
   */

    public void removeRecursoPromocionar()
    {
        getSemanticObject().removeProperty(intranet_recursoPromocionar);
    }

   /**
   * Gets the RecursoPromocionar
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getRecursoPromocionar()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_recursoPromocionar);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property DocumentosPromocion
   * @param value DocumentosPromocion to set
   */

    public void setDocumentosPromocion(com.infotec.cvi.swb.DocumentoProbatorio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_documentosPromocion, value.getSemanticObject());
        }else
        {
            removeDocumentosPromocion();
        }
    }
   /**
   * Remove the value for DocumentosPromocion property
   */

    public void removeDocumentosPromocion()
    {
        getSemanticObject().removeProperty(intranet_documentosPromocion);
    }

   /**
   * Gets the DocumentosPromocion
   * @return a com.infotec.cvi.swb.DocumentoProbatorio
   */
    public com.infotec.cvi.swb.DocumentoProbatorio getDocumentosPromocion()
    {
         com.infotec.cvi.swb.DocumentoProbatorio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_documentosPromocion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.DocumentoProbatorio)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SueldoBrutoActual property
* @return float with the SueldoBrutoActual
*/
    public float getSueldoBrutoActual()
    {
        return getSemanticObject().getFloatProperty(intranet_sueldoBrutoActual);
    }

/**
* Sets the SueldoBrutoActual property
* @param value long with the SueldoBrutoActual
*/
    public void setSueldoBrutoActual(float value)
    {
        getSemanticObject().setFloatProperty(intranet_sueldoBrutoActual, value);
    }

/**
* Gets the FechaTerminoNuevoPuesto property
* @return java.util.Date with the FechaTerminoNuevoPuesto
*/
    public java.util.Date getFechaTerminoNuevoPuesto()
    {
        return getSemanticObject().getDateProperty(intranet_fechaTerminoNuevoPuesto);
    }

/**
* Sets the FechaTerminoNuevoPuesto property
* @param value long with the FechaTerminoNuevoPuesto
*/
    public void setFechaTerminoNuevoPuesto(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaTerminoNuevoPuesto, value);
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
   * Sets the value for the property PuestoPropuesto
   * @param value PuestoPropuesto to set
   */

    public void setPuestoPropuesto(com.infotec.cvi.swb.Puesto value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_puestoPropuesto, value.getSemanticObject());
        }else
        {
            removePuestoPropuesto();
        }
    }
   /**
   * Remove the value for PuestoPropuesto property
   */

    public void removePuestoPropuesto()
    {
        getSemanticObject().removeProperty(intranet_puestoPropuesto);
    }

   /**
   * Gets the PuestoPropuesto
   * @return a com.infotec.cvi.swb.Puesto
   */
    public com.infotec.cvi.swb.Puesto getPuestoPropuesto()
    {
         com.infotec.cvi.swb.Puesto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_puestoPropuesto);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Puesto)obj.createGenericInstance();
         }
         return ret;
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
* Gets the SueldoBrutoPropuesto property
* @return float with the SueldoBrutoPropuesto
*/
    public float getSueldoBrutoPropuesto()
    {
        return getSemanticObject().getFloatProperty(intranet_sueldoBrutoPropuesto);
    }

/**
* Sets the SueldoBrutoPropuesto property
* @param value long with the SueldoBrutoPropuesto
*/
    public void setSueldoBrutoPropuesto(float value)
    {
        getSemanticObject().setFloatProperty(intranet_sueldoBrutoPropuesto, value);
    }

/**
* Gets the NotaPromocion property
* @return String with the NotaPromocion
*/
    public String getNotaPromocion()
    {
        return getSemanticObject().getProperty(intranet_notaPromocion);
    }

/**
* Sets the NotaPromocion property
* @param value long with the NotaPromocion
*/
    public void setNotaPromocion(String value)
    {
        getSemanticObject().setProperty(intranet_notaPromocion, value);
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
}
