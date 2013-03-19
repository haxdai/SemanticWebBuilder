package com.infotec.cvi.swb.base;


   /**
   * Elemento que contiene la información del perfil del usuario requerido 
   */
public abstract class SolicitudRecursoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para indicar el grado de avance del Estudio
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Avance");
    public static final org.semanticwb.platform.SemanticProperty intranet_avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#avance");
   /**
   * Catálogo utilizado para las carreras utilizadas para la captura de Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
    public static final org.semanticwb.platform.SemanticProperty intranet_especialidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#especialidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_montoTotal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#montoTotal");
    public static final org.semanticwb.platform.SemanticProperty intranet_personalIndirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#personalIndirecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_sueldoBruto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sueldoBruto");
   /**
   * Catálogo utilizado para indicar el Grado Académico alcanzado.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Grado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Grado");
    public static final org.semanticwb.platform.SemanticProperty intranet_gradoAcademico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#gradoAcademico");
   /**
   * Catálogo utilizado para indicar el Sector en el cual has tenido Experiencia Laboral
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sector");
    public static final org.semanticwb.platform.SemanticProperty intranet_sectorExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sectorExpertise");
   /**
   * Encapsula la información relacionada con una partida presupuestal
   */
    public static final org.semanticwb.platform.SemanticClass intranet_PartidaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PartidaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_partidaSuficiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#partidaSuficiencia");
   /**
   * Catálogo utilizado para indicar el Tipo de contratación
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoContratacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_contratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#contratacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaFinContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaFinContrato");
    public static final org.semanticwb.platform.SemanticClass intranet_Postulante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Postulante");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPostulante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPostulante");
    public static final org.semanticwb.platform.SemanticProperty intranet_funcionPrincipal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#funcionPrincipal");
   /**
   * Catálogo utilizado para indicar las diferentes Habilidades
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Habilidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_habilidadTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#habilidadTalento");
   /**
   * Catálogo utilizado para almacenar los tipos de talentos utilizados en Habilidades
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoTalento");
    public static final org.semanticwb.platform.SemanticProperty intranet_expertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#expertise");
    public static final org.semanticwb.platform.SemanticProperty intranet_salarioMax=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#salarioMax");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCandidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCandidato");
   /**
   * Encapsula las propiedades relacionadas con un proyecto del ProjectServer
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_proyectoAsignado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#proyectoAsignado");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaInicioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaInicioContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_conocimientoTecnico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#conocimientoTecnico");
    public static final org.semanticwb.platform.SemanticProperty intranet_candidatoSeleccionado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#candidatoSeleccionado");
    public static final org.semanticwb.platform.SemanticProperty intranet_salarioMin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#salarioMin");
    public static final org.semanticwb.platform.SemanticProperty intranet_entrevistador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entrevistador");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaDirAd=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaDirAd");
    public static final org.semanticwb.platform.SemanticProperty intranet_periodoContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#periodoContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaSolicitud");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivoContratacion");
    public static final org.semanticwb.platform.SemanticClass intranet_CentroCosto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CentroCosto");
    public static final org.semanticwb.platform.SemanticProperty intranet_centroDeCosto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#centroDeCosto");
   /**
   * Catálogo utilizado para la lista de las competencias, utilizadas en Autoevaluación de Competencias
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCompetenciaReq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCompetenciaReq");
    public static final org.semanticwb.platform.SemanticProperty intranet_certificaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#certificaciones");
    public static final org.semanticwb.platform.SemanticClass intranet_EspecialidadSolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EspecialidadSolicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_especialidadRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#especialidadRecurso");
   /**
   * Encapsula la información relacionada con un capítulo presupuestal
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CapituloPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CapituloPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_capituloSuficiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#capituloSuficiencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_validacionEspecialSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validacionEspecialSolicitud");
    public static final org.semanticwb.platform.SemanticProperty intranet_personalDirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#personalDirecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_aniosExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#aniosExpertise");
   /**
   * Elemento que contiene la información del perfil del usuario requerido
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");

    public static class ClassMgr
    {
       /**
       * Returns a list of SolicitudRecurso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.SolicitudRecurso for all models
       * @return Iterator of com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso>(it, true);
        }

        public static com.infotec.cvi.swb.SolicitudRecurso createSolicitudRecurso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.SolicitudRecurso.ClassMgr.createSolicitudRecurso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.SolicitudRecurso
       * @param id Identifier for com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return A com.infotec.cvi.swb.SolicitudRecurso
       */
        public static com.infotec.cvi.swb.SolicitudRecurso getSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.SolicitudRecurso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.SolicitudRecurso
       * @param id Identifier for com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return A com.infotec.cvi.swb.SolicitudRecurso
       */
        public static com.infotec.cvi.swb.SolicitudRecurso createSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.SolicitudRecurso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.SolicitudRecurso
       * @param id Identifier for com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       */
        public static void removeSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.SolicitudRecurso
       * @param id Identifier for com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return true if the com.infotec.cvi.swb.SolicitudRecurso exists, false otherwise
       */

        public static boolean hasSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSolicitudRecurso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Avance
       * @param value Avance of the type com.infotec.cvi.swb.Avance
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByAvance(com.infotec.cvi.swb.Avance value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_avance, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Avance
       * @param value Avance of the type com.infotec.cvi.swb.Avance
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByAvance(com.infotec.cvi.swb.Avance value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_avance,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Especialidad
       * @param value Especialidad of the type com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByEspecialidad(com.infotec.cvi.swb.Carrera value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_especialidad, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Especialidad
       * @param value Especialidad of the type com.infotec.cvi.swb.Carrera
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByEspecialidad(com.infotec.cvi.swb.Carrera value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_especialidad,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined GradoAcademico
       * @param value GradoAcademico of the type com.infotec.cvi.swb.Grado
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByGradoAcademico(com.infotec.cvi.swb.Grado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_gradoAcademico, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined GradoAcademico
       * @param value GradoAcademico of the type com.infotec.cvi.swb.Grado
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByGradoAcademico(com.infotec.cvi.swb.Grado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_gradoAcademico,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SectorExpertise
       * @param value SectorExpertise of the type com.infotec.cvi.swb.Sector
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySectorExpertise(com.infotec.cvi.swb.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_sectorExpertise, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SectorExpertise
       * @param value SectorExpertise of the type com.infotec.cvi.swb.Sector
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySectorExpertise(com.infotec.cvi.swb.Sector value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_sectorExpertise,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined PartidaSuficiencia
       * @param value PartidaSuficiencia of the type com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByPartidaSuficiencia(com.infotec.rh.syr.swb.PartidaPresupuesto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_partidaSuficiencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined PartidaSuficiencia
       * @param value PartidaSuficiencia of the type com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByPartidaSuficiencia(com.infotec.rh.syr.swb.PartidaPresupuesto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_partidaSuficiencia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Contratacion
       * @param value Contratacion of the type com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByContratacion(com.infotec.cvi.swb.TipoContratacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_contratacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Contratacion
       * @param value Contratacion of the type com.infotec.cvi.swb.TipoContratacion
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByContratacion(com.infotec.cvi.swb.TipoContratacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_contratacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Postulante
       * @param value Postulante of the type com.infotec.rh.syr.swb.Postulante
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByPostulante(com.infotec.rh.syr.swb.Postulante value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPostulante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Postulante
       * @param value Postulante of the type com.infotec.rh.syr.swb.Postulante
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByPostulante(com.infotec.rh.syr.swb.Postulante value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPostulante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined HabilidadTalento
       * @param value HabilidadTalento of the type com.infotec.cvi.swb.Habilidad
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByHabilidadTalento(com.infotec.cvi.swb.Habilidad value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_habilidadTalento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined HabilidadTalento
       * @param value HabilidadTalento of the type com.infotec.cvi.swb.Habilidad
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByHabilidadTalento(com.infotec.cvi.swb.Habilidad value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_habilidadTalento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Expertise
       * @param value Expertise of the type com.infotec.cvi.swb.TipoTalento
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByExpertise(com.infotec.cvi.swb.TipoTalento value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_expertise, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Expertise
       * @param value Expertise of the type com.infotec.cvi.swb.TipoTalento
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByExpertise(com.infotec.cvi.swb.TipoTalento value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_expertise,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Candidato
       * @param value Candidato of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidato(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCandidato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Candidato
       * @param value Candidato of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidato(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCandidato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined ProyectoAsignado
       * @param value ProyectoAsignado of the type com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByProyectoAsignado(com.infotec.eworkplace.swb.Proyecto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_proyectoAsignado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined ProyectoAsignado
       * @param value ProyectoAsignado of the type com.infotec.eworkplace.swb.Proyecto
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByProyectoAsignado(com.infotec.eworkplace.swb.Proyecto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_proyectoAsignado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CandidatoSeleccionado
       * @param value CandidatoSeleccionado of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidatoSeleccionado(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_candidatoSeleccionado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CandidatoSeleccionado
       * @param value CandidatoSeleccionado of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidatoSeleccionado(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_candidatoSeleccionado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Entrevistador
       * @param value Entrevistador of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByEntrevistador(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_entrevistador, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Entrevistador
       * @param value Entrevistador of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByEntrevistador(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_entrevistador,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined AutorizaDirAd
       * @param value AutorizaDirAd of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByAutorizaDirAd(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_autorizaDirAd, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined AutorizaDirAd
       * @param value AutorizaDirAd of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByAutorizaDirAd(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_autorizaDirAd,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CentroDeCosto
       * @param value CentroDeCosto of the type com.infotec.eworkplace.swb.CentroCosto
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCentroDeCosto(com.infotec.eworkplace.swb.CentroCosto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_centroDeCosto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CentroDeCosto
       * @param value CentroDeCosto of the type com.infotec.eworkplace.swb.CentroCosto
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCentroDeCosto(com.infotec.eworkplace.swb.CentroCosto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_centroDeCosto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CompetenciaReq
       * @param value CompetenciaReq of the type com.infotec.cvi.swb.Competencia
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCompetenciaReq(com.infotec.cvi.swb.Competencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCompetenciaReq, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CompetenciaReq
       * @param value CompetenciaReq of the type com.infotec.cvi.swb.Competencia
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCompetenciaReq(com.infotec.cvi.swb.Competencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCompetenciaReq,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined EspecialidadRecurso
       * @param value EspecialidadRecurso of the type com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByEspecialidadRecurso(com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_especialidadRecurso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined EspecialidadRecurso
       * @param value EspecialidadRecurso of the type com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByEspecialidadRecurso(com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_especialidadRecurso,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CapituloSuficiencia
       * @param value CapituloSuficiencia of the type com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCapituloSuficiencia(com.infotec.rh.syr.swb.CapituloPresupuesto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_capituloSuficiencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined CapituloSuficiencia
       * @param value CapituloSuficiencia of the type com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCapituloSuficiencia(com.infotec.rh.syr.swb.CapituloPresupuesto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_capituloSuficiencia,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static SolicitudRecursoBase.ClassMgr getSolicitudRecursoClassMgr()
    {
        return new SolicitudRecursoBase.ClassMgr();
    }

   /**
   * Constructs a SolicitudRecursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SolicitudRecurso
   */
    public SolicitudRecursoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Sets the value for the property Avance
   * @param value Avance to set
   */

    public void setAvance(com.infotec.cvi.swb.Avance value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_avance, value.getSemanticObject());
        }else
        {
            removeAvance();
        }
    }
   /**
   * Remove the value for Avance property
   */

    public void removeAvance()
    {
        getSemanticObject().removeProperty(intranet_avance);
    }

   /**
   * Gets the Avance
   * @return a com.infotec.cvi.swb.Avance
   */
    public com.infotec.cvi.swb.Avance getAvance()
    {
         com.infotec.cvi.swb.Avance ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_avance);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Avance)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Especialidad
   * @param value Especialidad to set
   */

    public void setEspecialidad(com.infotec.cvi.swb.Carrera value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_especialidad, value.getSemanticObject());
        }else
        {
            removeEspecialidad();
        }
    }
   /**
   * Remove the value for Especialidad property
   */

    public void removeEspecialidad()
    {
        getSemanticObject().removeProperty(intranet_especialidad);
    }

   /**
   * Gets the Especialidad
   * @return a com.infotec.cvi.swb.Carrera
   */
    public com.infotec.cvi.swb.Carrera getEspecialidad()
    {
         com.infotec.cvi.swb.Carrera ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_especialidad);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Carrera)obj.createGenericInstance();
         }
         return ret;
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
* Gets the MontoTotal property
* @return float with the MontoTotal
*/
    public float getMontoTotal()
    {
        return getSemanticObject().getFloatProperty(intranet_montoTotal);
    }

/**
* Sets the MontoTotal property
* @param value long with the MontoTotal
*/
    public void setMontoTotal(float value)
    {
        getSemanticObject().setFloatProperty(intranet_montoTotal, value);
    }

/**
* Gets the PersonalIndirecto property
* @return int with the PersonalIndirecto
*/
    public int getPersonalIndirecto()
    {
        return getSemanticObject().getIntProperty(intranet_personalIndirecto);
    }

/**
* Sets the PersonalIndirecto property
* @param value long with the PersonalIndirecto
*/
    public void setPersonalIndirecto(int value)
    {
        getSemanticObject().setIntProperty(intranet_personalIndirecto, value);
    }

/**
* Gets the SueldoBruto property
* @return float with the SueldoBruto
*/
    public float getSueldoBruto()
    {
        return getSemanticObject().getFloatProperty(intranet_sueldoBruto);
    }

/**
* Sets the SueldoBruto property
* @param value long with the SueldoBruto
*/
    public void setSueldoBruto(float value)
    {
        getSemanticObject().setFloatProperty(intranet_sueldoBruto, value);
    }
   /**
   * Sets the value for the property GradoAcademico
   * @param value GradoAcademico to set
   */

    public void setGradoAcademico(com.infotec.cvi.swb.Grado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_gradoAcademico, value.getSemanticObject());
        }else
        {
            removeGradoAcademico();
        }
    }
   /**
   * Remove the value for GradoAcademico property
   */

    public void removeGradoAcademico()
    {
        getSemanticObject().removeProperty(intranet_gradoAcademico);
    }

   /**
   * Gets the GradoAcademico
   * @return a com.infotec.cvi.swb.Grado
   */
    public com.infotec.cvi.swb.Grado getGradoAcademico()
    {
         com.infotec.cvi.swb.Grado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_gradoAcademico);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Grado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property SectorExpertise
   * @param value SectorExpertise to set
   */

    public void setSectorExpertise(com.infotec.cvi.swb.Sector value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_sectorExpertise, value.getSemanticObject());
        }else
        {
            removeSectorExpertise();
        }
    }
   /**
   * Remove the value for SectorExpertise property
   */

    public void removeSectorExpertise()
    {
        getSemanticObject().removeProperty(intranet_sectorExpertise);
    }

   /**
   * Gets the SectorExpertise
   * @return a com.infotec.cvi.swb.Sector
   */
    public com.infotec.cvi.swb.Sector getSectorExpertise()
    {
         com.infotec.cvi.swb.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_sectorExpertise);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Sector)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property PartidaSuficiencia
   * @param value PartidaSuficiencia to set
   */

    public void setPartidaSuficiencia(com.infotec.rh.syr.swb.PartidaPresupuesto value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_partidaSuficiencia, value.getSemanticObject());
        }else
        {
            removePartidaSuficiencia();
        }
    }
   /**
   * Remove the value for PartidaSuficiencia property
   */

    public void removePartidaSuficiencia()
    {
        getSemanticObject().removeProperty(intranet_partidaSuficiencia);
    }

   /**
   * Gets the PartidaSuficiencia
   * @return a com.infotec.rh.syr.swb.PartidaPresupuesto
   */
    public com.infotec.rh.syr.swb.PartidaPresupuesto getPartidaSuficiencia()
    {
         com.infotec.rh.syr.swb.PartidaPresupuesto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_partidaSuficiencia);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.PartidaPresupuesto)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Contratacion
   * @param value Contratacion to set
   */

    public void setContratacion(com.infotec.cvi.swb.TipoContratacion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_contratacion, value.getSemanticObject());
        }else
        {
            removeContratacion();
        }
    }
   /**
   * Remove the value for Contratacion property
   */

    public void removeContratacion()
    {
        getSemanticObject().removeProperty(intranet_contratacion);
    }

   /**
   * Gets the Contratacion
   * @return a com.infotec.cvi.swb.TipoContratacion
   */
    public com.infotec.cvi.swb.TipoContratacion getContratacion()
    {
         com.infotec.cvi.swb.TipoContratacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_contratacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoContratacion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaFinContrato property
* @return java.util.Date with the FechaFinContrato
*/
    public java.util.Date getFechaFinContrato()
    {
        return getSemanticObject().getDateProperty(intranet_fechaFinContrato);
    }

/**
* Sets the FechaFinContrato property
* @param value long with the FechaFinContrato
*/
    public void setFechaFinContrato(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaFinContrato, value);
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
   * Gets all the com.infotec.rh.syr.swb.Postulante
   * @return A GenericIterator with all the com.infotec.rh.syr.swb.Postulante
   */

    public org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante> listPostulantes()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Postulante>(getSemanticObject().listObjectProperties(intranet_hasPostulante));
    }

   /**
   * Gets true if has a Postulante
   * @param value com.infotec.rh.syr.swb.Postulante to verify
   * @return true if the com.infotec.rh.syr.swb.Postulante exists, false otherwise
   */
    public boolean hasPostulante(com.infotec.rh.syr.swb.Postulante value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPostulante,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Postulante
   * @param value com.infotec.rh.syr.swb.Postulante to add
   */

    public void addPostulante(com.infotec.rh.syr.swb.Postulante value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPostulante, value.getSemanticObject());
    }
   /**
   * Removes all the Postulante
   */

    public void removeAllPostulante()
    {
        getSemanticObject().removeProperty(intranet_hasPostulante);
    }
   /**
   * Removes a Postulante
   * @param value com.infotec.rh.syr.swb.Postulante to remove
   */

    public void removePostulante(com.infotec.rh.syr.swb.Postulante value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPostulante,value.getSemanticObject());
    }

   /**
   * Gets the Postulante
   * @return a com.infotec.rh.syr.swb.Postulante
   */
    public com.infotec.rh.syr.swb.Postulante getPostulante()
    {
         com.infotec.rh.syr.swb.Postulante ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPostulante);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.Postulante)obj.createGenericInstance();
         }
         return ret;
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
* Gets the FuncionPrincipal property
* @return String with the FuncionPrincipal
*/
    public String getFuncionPrincipal()
    {
        return getSemanticObject().getProperty(intranet_funcionPrincipal);
    }

/**
* Sets the FuncionPrincipal property
* @param value long with the FuncionPrincipal
*/
    public void setFuncionPrincipal(String value)
    {
        getSemanticObject().setProperty(intranet_funcionPrincipal, value);
    }
   /**
   * Sets the value for the property HabilidadTalento
   * @param value HabilidadTalento to set
   */

    public void setHabilidadTalento(com.infotec.cvi.swb.Habilidad value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_habilidadTalento, value.getSemanticObject());
        }else
        {
            removeHabilidadTalento();
        }
    }
   /**
   * Remove the value for HabilidadTalento property
   */

    public void removeHabilidadTalento()
    {
        getSemanticObject().removeProperty(intranet_habilidadTalento);
    }

   /**
   * Gets the HabilidadTalento
   * @return a com.infotec.cvi.swb.Habilidad
   */
    public com.infotec.cvi.swb.Habilidad getHabilidadTalento()
    {
         com.infotec.cvi.swb.Habilidad ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_habilidadTalento);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Habilidad)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Expertise
   * @param value Expertise to set
   */

    public void setExpertise(com.infotec.cvi.swb.TipoTalento value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_expertise, value.getSemanticObject());
        }else
        {
            removeExpertise();
        }
    }
   /**
   * Remove the value for Expertise property
   */

    public void removeExpertise()
    {
        getSemanticObject().removeProperty(intranet_expertise);
    }

   /**
   * Gets the Expertise
   * @return a com.infotec.cvi.swb.TipoTalento
   */
    public com.infotec.cvi.swb.TipoTalento getExpertise()
    {
         com.infotec.cvi.swb.TipoTalento ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_expertise);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoTalento)obj.createGenericInstance();
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
* Gets the SalarioMax property
* @return float with the SalarioMax
*/
    public float getSalarioMax()
    {
        return getSemanticObject().getFloatProperty(intranet_salarioMax);
    }

/**
* Sets the SalarioMax property
* @param value long with the SalarioMax
*/
    public void setSalarioMax(float value)
    {
        getSemanticObject().setFloatProperty(intranet_salarioMax, value);
    }
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listCandidatos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(intranet_hasCandidato));
    }

   /**
   * Gets true if has a Candidato
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasCandidato(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCandidato,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Candidato
   * @param value org.semanticwb.model.User to add
   */

    public void addCandidato(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCandidato, value.getSemanticObject());
    }
   /**
   * Removes all the Candidato
   */

    public void removeAllCandidato()
    {
        getSemanticObject().removeProperty(intranet_hasCandidato);
    }
   /**
   * Removes a Candidato
   * @param value org.semanticwb.model.User to remove
   */

    public void removeCandidato(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCandidato,value.getSemanticObject());
    }

   /**
   * Gets the Candidato
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCandidato()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCandidato);
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
   * Sets the value for the property ProyectoAsignado
   * @param value ProyectoAsignado to set
   */

    public void setProyectoAsignado(com.infotec.eworkplace.swb.Proyecto value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_proyectoAsignado, value.getSemanticObject());
        }else
        {
            removeProyectoAsignado();
        }
    }
   /**
   * Remove the value for ProyectoAsignado property
   */

    public void removeProyectoAsignado()
    {
        getSemanticObject().removeProperty(intranet_proyectoAsignado);
    }

   /**
   * Gets the ProyectoAsignado
   * @return a com.infotec.eworkplace.swb.Proyecto
   */
    public com.infotec.eworkplace.swb.Proyecto getProyectoAsignado()
    {
         com.infotec.eworkplace.swb.Proyecto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_proyectoAsignado);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Proyecto)obj.createGenericInstance();
         }
         return ret;
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
* Gets the FechaInicioContrato property
* @return java.util.Date with the FechaInicioContrato
*/
    public java.util.Date getFechaInicioContrato()
    {
        return getSemanticObject().getDateProperty(intranet_fechaInicioContrato);
    }

/**
* Sets the FechaInicioContrato property
* @param value long with the FechaInicioContrato
*/
    public void setFechaInicioContrato(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaInicioContrato, value);
    }

/**
* Gets the ConocimientoTecnico property
* @return String with the ConocimientoTecnico
*/
    public String getConocimientoTecnico()
    {
        return getSemanticObject().getProperty(intranet_conocimientoTecnico);
    }

/**
* Sets the ConocimientoTecnico property
* @param value long with the ConocimientoTecnico
*/
    public void setConocimientoTecnico(String value)
    {
        getSemanticObject().setProperty(intranet_conocimientoTecnico, value);
    }
   /**
   * Sets the value for the property CandidatoSeleccionado
   * @param value CandidatoSeleccionado to set
   */

    public void setCandidatoSeleccionado(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_candidatoSeleccionado, value.getSemanticObject());
        }else
        {
            removeCandidatoSeleccionado();
        }
    }
   /**
   * Remove the value for CandidatoSeleccionado property
   */

    public void removeCandidatoSeleccionado()
    {
        getSemanticObject().removeProperty(intranet_candidatoSeleccionado);
    }

   /**
   * Gets the CandidatoSeleccionado
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCandidatoSeleccionado()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_candidatoSeleccionado);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SalarioMin property
* @return float with the SalarioMin
*/
    public float getSalarioMin()
    {
        return getSemanticObject().getFloatProperty(intranet_salarioMin);
    }

/**
* Sets the SalarioMin property
* @param value long with the SalarioMin
*/
    public void setSalarioMin(float value)
    {
        getSemanticObject().setFloatProperty(intranet_salarioMin, value);
    }
   /**
   * Sets the value for the property Entrevistador
   * @param value Entrevistador to set
   */

    public void setEntrevistador(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_entrevistador, value.getSemanticObject());
        }else
        {
            removeEntrevistador();
        }
    }
   /**
   * Remove the value for Entrevistador property
   */

    public void removeEntrevistador()
    {
        getSemanticObject().removeProperty(intranet_entrevistador);
    }

   /**
   * Gets the Entrevistador
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEntrevistador()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_entrevistador);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
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
   * Sets the value for the property AutorizaDirAd
   * @param value AutorizaDirAd to set
   */

    public void setAutorizaDirAd(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_autorizaDirAd, value.getSemanticObject());
        }else
        {
            removeAutorizaDirAd();
        }
    }
   /**
   * Remove the value for AutorizaDirAd property
   */

    public void removeAutorizaDirAd()
    {
        getSemanticObject().removeProperty(intranet_autorizaDirAd);
    }

   /**
   * Gets the AutorizaDirAd
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getAutorizaDirAd()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_autorizaDirAd);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PeriodoContrato property
* @return float with the PeriodoContrato
*/
    public float getPeriodoContrato()
    {
        return getSemanticObject().getFloatProperty(intranet_periodoContrato);
    }

/**
* Sets the PeriodoContrato property
* @param value long with the PeriodoContrato
*/
    public void setPeriodoContrato(float value)
    {
        getSemanticObject().setFloatProperty(intranet_periodoContrato, value);
    }

/**
* Gets the NotaSolicitud property
* @return String with the NotaSolicitud
*/
    public String getNotaSolicitud()
    {
        return getSemanticObject().getProperty(intranet_notaSolicitud);
    }

/**
* Sets the NotaSolicitud property
* @param value long with the NotaSolicitud
*/
    public void setNotaSolicitud(String value)
    {
        getSemanticObject().setProperty(intranet_notaSolicitud, value);
    }

/**
* Gets the MotivoContratacion property
* @return String with the MotivoContratacion
*/
    public String getMotivoContratacion()
    {
        return getSemanticObject().getProperty(intranet_motivoContratacion);
    }

/**
* Sets the MotivoContratacion property
* @param value long with the MotivoContratacion
*/
    public void setMotivoContratacion(String value)
    {
        getSemanticObject().setProperty(intranet_motivoContratacion, value);
    }
   /**
   * Sets the value for the property CentroDeCosto
   * @param value CentroDeCosto to set
   */

    public void setCentroDeCosto(com.infotec.eworkplace.swb.CentroCosto value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_centroDeCosto, value.getSemanticObject());
        }else
        {
            removeCentroDeCosto();
        }
    }
   /**
   * Remove the value for CentroDeCosto property
   */

    public void removeCentroDeCosto()
    {
        getSemanticObject().removeProperty(intranet_centroDeCosto);
    }

   /**
   * Gets the CentroDeCosto
   * @return a com.infotec.eworkplace.swb.CentroCosto
   */
    public com.infotec.eworkplace.swb.CentroCosto getCentroDeCosto()
    {
         com.infotec.eworkplace.swb.CentroCosto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_centroDeCosto);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CentroCosto)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.Competencia
   * @return A GenericIterator with all the com.infotec.cvi.swb.Competencia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Competencia> listCompetenciaReqs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Competencia>(getSemanticObject().listObjectProperties(intranet_hasCompetenciaReq));
    }

   /**
   * Gets true if has a CompetenciaReq
   * @param value com.infotec.cvi.swb.Competencia to verify
   * @return true if the com.infotec.cvi.swb.Competencia exists, false otherwise
   */
    public boolean hasCompetenciaReq(com.infotec.cvi.swb.Competencia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCompetenciaReq,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CompetenciaReq
   * @param value com.infotec.cvi.swb.Competencia to add
   */

    public void addCompetenciaReq(com.infotec.cvi.swb.Competencia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCompetenciaReq, value.getSemanticObject());
    }
   /**
   * Removes all the CompetenciaReq
   */

    public void removeAllCompetenciaReq()
    {
        getSemanticObject().removeProperty(intranet_hasCompetenciaReq);
    }
   /**
   * Removes a CompetenciaReq
   * @param value com.infotec.cvi.swb.Competencia to remove
   */

    public void removeCompetenciaReq(com.infotec.cvi.swb.Competencia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCompetenciaReq,value.getSemanticObject());
    }

   /**
   * Gets the CompetenciaReq
   * @return a com.infotec.cvi.swb.Competencia
   */
    public com.infotec.cvi.swb.Competencia getCompetenciaReq()
    {
         com.infotec.cvi.swb.Competencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCompetenciaReq);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Competencia)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Certificaciones property
* @return String with the Certificaciones
*/
    public String getCertificaciones()
    {
        return getSemanticObject().getProperty(intranet_certificaciones);
    }

/**
* Sets the Certificaciones property
* @param value long with the Certificaciones
*/
    public void setCertificaciones(String value)
    {
        getSemanticObject().setProperty(intranet_certificaciones, value);
    }
   /**
   * Sets the value for the property EspecialidadRecurso
   * @param value EspecialidadRecurso to set
   */

    public void setEspecialidadRecurso(com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_especialidadRecurso, value.getSemanticObject());
        }else
        {
            removeEspecialidadRecurso();
        }
    }
   /**
   * Remove the value for EspecialidadRecurso property
   */

    public void removeEspecialidadRecurso()
    {
        getSemanticObject().removeProperty(intranet_especialidadRecurso);
    }

   /**
   * Gets the EspecialidadRecurso
   * @return a com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
   */
    public com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso getEspecialidadRecurso()
    {
         com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_especialidadRecurso);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property CapituloSuficiencia
   * @param value CapituloSuficiencia to set
   */

    public void setCapituloSuficiencia(com.infotec.rh.syr.swb.CapituloPresupuesto value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_capituloSuficiencia, value.getSemanticObject());
        }else
        {
            removeCapituloSuficiencia();
        }
    }
   /**
   * Remove the value for CapituloSuficiencia property
   */

    public void removeCapituloSuficiencia()
    {
        getSemanticObject().removeProperty(intranet_capituloSuficiencia);
    }

   /**
   * Gets the CapituloSuficiencia
   * @return a com.infotec.rh.syr.swb.CapituloPresupuesto
   */
    public com.infotec.rh.syr.swb.CapituloPresupuesto getCapituloSuficiencia()
    {
         com.infotec.rh.syr.swb.CapituloPresupuesto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_capituloSuficiencia);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.CapituloPresupuesto)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ValidacionEspecialSolicitud property
* @return boolean with the ValidacionEspecialSolicitud
*/
    public boolean isValidacionEspecialSolicitud()
    {
        return getSemanticObject().getBooleanProperty(intranet_validacionEspecialSolicitud);
    }

/**
* Sets the ValidacionEspecialSolicitud property
* @param value long with the ValidacionEspecialSolicitud
*/
    public void setValidacionEspecialSolicitud(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validacionEspecialSolicitud, value);
    }

/**
* Gets the PersonalDirecto property
* @return int with the PersonalDirecto
*/
    public int getPersonalDirecto()
    {
        return getSemanticObject().getIntProperty(intranet_personalDirecto);
    }

/**
* Sets the PersonalDirecto property
* @param value long with the PersonalDirecto
*/
    public void setPersonalDirecto(int value)
    {
        getSemanticObject().setIntProperty(intranet_personalDirecto, value);
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
* Gets the AniosExpertise property
* @return int with the AniosExpertise
*/
    public int getAniosExpertise()
    {
        return getSemanticObject().getIntProperty(intranet_aniosExpertise);
    }

/**
* Sets the AniosExpertise property
* @param value long with the AniosExpertise
*/
    public void setAniosExpertise(int value)
    {
        getSemanticObject().setIntProperty(intranet_aniosExpertise, value);
    }
}
