package com.infotec.cvi.swb.base;


   /**
   * Elemento que contiene la información del perfil del usuario requerido 
   */
public abstract class SolicitudRecursoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para indicar el Sector en el cual has tenido Experiencia Laboral
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sector");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasSectorExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasSectorExpertise");
   /**
   * Catálogo utilizado para indicar las diferentes Habilidades
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Habilidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasExpertise");
    public static final org.semanticwb.platform.SemanticProperty intranet_avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#avance");
   /**
   * Catálogo utilizado para las carreras utilizadas para la captura de Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
    public static final org.semanticwb.platform.SemanticProperty intranet_especialidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#especialidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaPresupuestal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaPresupuestal");
    public static final org.semanticwb.platform.SemanticProperty intranet_personalIndirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#personalIndirecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_contratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#contratacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaSolicitud");
    public static final org.semanticwb.platform.SemanticProperty intranet_funcionPrincipal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#funcionPrincipal");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_sustituyeA=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sustituyeA");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_salarioMax=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#salarioMax");
    public static final org.semanticwb.platform.SemanticClass intranet_Seleccion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Seleccion");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCandidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCandidato");
    public static final org.semanticwb.platform.SemanticClass intranet_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_proyectoAsignado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#proyectoAsignado");
    public static final org.semanticwb.platform.SemanticProperty intranet_conocimientoTecnico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#conocimientoTecnico");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitanteRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitanteRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_salarioMin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#salarioMin");
    public static final org.semanticwb.platform.SemanticProperty intranet_entrevistador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entrevistador");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivoContratacion");
   /**
   * Catálogo utilizado para la lista de las competencias, utilizadas en Autoevaluación de Competencias
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCompetenciaReq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCompetenciaReq");
    public static final org.semanticwb.platform.SemanticProperty intranet_numVacantes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numVacantes");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaBaja");
    public static final org.semanticwb.platform.SemanticProperty intranet_certificaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#certificaciones");
    public static final org.semanticwb.platform.SemanticProperty intranet_personalDirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#personalDirecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivoSustitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivoSustitucion");
    public static final org.semanticwb.platform.SemanticProperty intranet_aniosExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#aniosExpertise");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreVacante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreVacante");
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
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SectorExpertise
       * @param value SectorExpertise of the type com.infotec.cvi.swb.Sector
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySectorExpertise(com.infotec.cvi.swb.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasSectorExpertise, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SectorExpertise
       * @param value SectorExpertise of the type com.infotec.cvi.swb.Sector
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySectorExpertise(com.infotec.cvi.swb.Sector value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasSectorExpertise,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Expertise
       * @param value Expertise of the type com.infotec.cvi.swb.Habilidad
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByExpertise(com.infotec.cvi.swb.Habilidad value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasExpertise, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Expertise
       * @param value Expertise of the type com.infotec.cvi.swb.Habilidad
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByExpertise(com.infotec.cvi.swb.Habilidad value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasExpertise,value.getSemanticObject(),sclass));
            return it;
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
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SustituyeA
       * @param value SustituyeA of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySustituyeA(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_sustituyeA, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SustituyeA
       * @param value SustituyeA of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySustituyeA(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_sustituyeA,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Candidato
       * @param value Candidato of the type com.infotec.rh.syr.swb.Seleccion
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidato(com.infotec.rh.syr.swb.Seleccion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCandidato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Candidato
       * @param value Candidato of the type com.infotec.rh.syr.swb.Seleccion
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidato(com.infotec.rh.syr.swb.Seleccion value)
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
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SolicitanteRecurso
       * @param value SolicitanteRecurso of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySolicitanteRecurso(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitanteRecurso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SolicitanteRecurso
       * @param value SolicitanteRecurso of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySolicitanteRecurso(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitanteRecurso,value.getSemanticObject(),sclass));
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
   * Gets all the com.infotec.cvi.swb.Sector
   * @return A GenericIterator with all the com.infotec.cvi.swb.Sector
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> listSectorExpertises()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector>(getSemanticObject().listObjectProperties(intranet_hasSectorExpertise));
    }

   /**
   * Gets true if has a SectorExpertise
   * @param value com.infotec.cvi.swb.Sector to verify
   * @return true if the com.infotec.cvi.swb.Sector exists, false otherwise
   */
    public boolean hasSectorExpertise(com.infotec.cvi.swb.Sector value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasSectorExpertise,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a SectorExpertise
   * @param value com.infotec.cvi.swb.Sector to add
   */

    public void addSectorExpertise(com.infotec.cvi.swb.Sector value)
    {
        getSemanticObject().addObjectProperty(intranet_hasSectorExpertise, value.getSemanticObject());
    }
   /**
   * Removes all the SectorExpertise
   */

    public void removeAllSectorExpertise()
    {
        getSemanticObject().removeProperty(intranet_hasSectorExpertise);
    }
   /**
   * Removes a SectorExpertise
   * @param value com.infotec.cvi.swb.Sector to remove
   */

    public void removeSectorExpertise(com.infotec.cvi.swb.Sector value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasSectorExpertise,value.getSemanticObject());
    }

   /**
   * Gets the SectorExpertise
   * @return a com.infotec.cvi.swb.Sector
   */
    public com.infotec.cvi.swb.Sector getSectorExpertise()
    {
         com.infotec.cvi.swb.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasSectorExpertise);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Sector)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.Habilidad
   * @return A GenericIterator with all the com.infotec.cvi.swb.Habilidad
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad> listExpertises()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Habilidad>(getSemanticObject().listObjectProperties(intranet_hasExpertise));
    }

   /**
   * Gets true if has a Expertise
   * @param value com.infotec.cvi.swb.Habilidad to verify
   * @return true if the com.infotec.cvi.swb.Habilidad exists, false otherwise
   */
    public boolean hasExpertise(com.infotec.cvi.swb.Habilidad value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasExpertise,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Expertise
   * @param value com.infotec.cvi.swb.Habilidad to add
   */

    public void addExpertise(com.infotec.cvi.swb.Habilidad value)
    {
        getSemanticObject().addObjectProperty(intranet_hasExpertise, value.getSemanticObject());
    }
   /**
   * Removes all the Expertise
   */

    public void removeAllExpertise()
    {
        getSemanticObject().removeProperty(intranet_hasExpertise);
    }
   /**
   * Removes a Expertise
   * @param value com.infotec.cvi.swb.Habilidad to remove
   */

    public void removeExpertise(com.infotec.cvi.swb.Habilidad value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasExpertise,value.getSemanticObject());
    }

   /**
   * Gets the Expertise
   * @return a com.infotec.cvi.swb.Habilidad
   */
    public com.infotec.cvi.swb.Habilidad getExpertise()
    {
         com.infotec.cvi.swb.Habilidad ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasExpertise);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Habilidad)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Avance property
* @return String with the Avance
*/
    public String getAvance()
    {
        return getSemanticObject().getProperty(intranet_avance);
    }

/**
* Sets the Avance property
* @param value long with the Avance
*/
    public void setAvance(String value)
    {
        getSemanticObject().setProperty(intranet_avance, value);
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
* Gets the AutorizaPresupuestal property
* @return boolean with the AutorizaPresupuestal
*/
    public boolean isAutorizaPresupuestal()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizaPresupuestal);
    }

/**
* Sets the AutorizaPresupuestal property
* @param value long with the AutorizaPresupuestal
*/
    public void setAutorizaPresupuestal(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizaPresupuestal, value);
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
* Gets the Contratacion property
* @return String with the Contratacion
*/
    public String getContratacion()
    {
        return getSemanticObject().getProperty(intranet_contratacion);
    }

/**
* Sets the Contratacion property
* @param value long with the Contratacion
*/
    public void setContratacion(String value)
    {
        getSemanticObject().setProperty(intranet_contratacion, value);
    }

/**
* Gets the FechaSolicitud property
* @return java.util.Date with the FechaSolicitud
*/
    public java.util.Date getFechaSolicitud()
    {
        return getSemanticObject().getDateProperty(intranet_fechaSolicitud);
    }

/**
* Sets the FechaSolicitud property
* @param value long with the FechaSolicitud
*/
    public void setFechaSolicitud(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaSolicitud, value);
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
   * Sets the value for the property SustituyeA
   * @param value SustituyeA to set
   */

    public void setSustituyeA(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_sustituyeA, value.getSemanticObject());
        }else
        {
            removeSustituyeA();
        }
    }
   /**
   * Remove the value for SustituyeA property
   */

    public void removeSustituyeA()
    {
        getSemanticObject().removeProperty(intranet_sustituyeA);
    }

   /**
   * Gets the SustituyeA
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSustituyeA()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_sustituyeA);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the AutorizaSolicitante property
* @return boolean with the AutorizaSolicitante
*/
    public boolean isAutorizaSolicitante()
    {
        return getSemanticObject().getBooleanProperty(intranet_autorizaSolicitante);
    }

/**
* Sets the AutorizaSolicitante property
* @param value long with the AutorizaSolicitante
*/
    public void setAutorizaSolicitante(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_autorizaSolicitante, value);
    }

/**
* Gets the SalarioMax property
* @return int with the SalarioMax
*/
    public int getSalarioMax()
    {
        return getSemanticObject().getIntProperty(intranet_salarioMax);
    }

/**
* Sets the SalarioMax property
* @param value long with the SalarioMax
*/
    public void setSalarioMax(int value)
    {
        getSemanticObject().setIntProperty(intranet_salarioMax, value);
    }
   /**
   * Gets all the com.infotec.rh.syr.swb.Seleccion
   * @return A GenericIterator with all the com.infotec.rh.syr.swb.Seleccion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Seleccion> listCandidatos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Seleccion>(getSemanticObject().listObjectProperties(intranet_hasCandidato));
    }

   /**
   * Gets true if has a Candidato
   * @param value com.infotec.rh.syr.swb.Seleccion to verify
   * @return true if the com.infotec.rh.syr.swb.Seleccion exists, false otherwise
   */
    public boolean hasCandidato(com.infotec.rh.syr.swb.Seleccion value)
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
   * @param value com.infotec.rh.syr.swb.Seleccion to add
   */

    public void addCandidato(com.infotec.rh.syr.swb.Seleccion value)
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
   * @param value com.infotec.rh.syr.swb.Seleccion to remove
   */

    public void removeCandidato(com.infotec.rh.syr.swb.Seleccion value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCandidato,value.getSemanticObject());
    }

   /**
   * Gets the Candidato
   * @return a com.infotec.rh.syr.swb.Seleccion
   */
    public com.infotec.rh.syr.swb.Seleccion getCandidato()
    {
         com.infotec.rh.syr.swb.Seleccion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCandidato);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.Seleccion)obj.createGenericInstance();
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
   * Sets the value for the property SolicitanteRecurso
   * @param value SolicitanteRecurso to set
   */

    public void setSolicitanteRecurso(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitanteRecurso, value.getSemanticObject());
        }else
        {
            removeSolicitanteRecurso();
        }
    }
   /**
   * Remove the value for SolicitanteRecurso property
   */

    public void removeSolicitanteRecurso()
    {
        getSemanticObject().removeProperty(intranet_solicitanteRecurso);
    }

   /**
   * Gets the SolicitanteRecurso
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSolicitanteRecurso()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitanteRecurso);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SalarioMin property
* @return int with the SalarioMin
*/
    public int getSalarioMin()
    {
        return getSemanticObject().getIntProperty(intranet_salarioMin);
    }

/**
* Sets the SalarioMin property
* @param value long with the SalarioMin
*/
    public void setSalarioMin(int value)
    {
        getSemanticObject().setIntProperty(intranet_salarioMin, value);
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
* Gets the NumVacantes property
* @return int with the NumVacantes
*/
    public int getNumVacantes()
    {
        return getSemanticObject().getIntProperty(intranet_numVacantes);
    }

/**
* Sets the NumVacantes property
* @param value long with the NumVacantes
*/
    public void setNumVacantes(int value)
    {
        getSemanticObject().setIntProperty(intranet_numVacantes, value);
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
* Gets the FechaBaja property
* @return java.util.Date with the FechaBaja
*/
    public java.util.Date getFechaBaja()
    {
        return getSemanticObject().getDateProperty(intranet_fechaBaja);
    }

/**
* Sets the FechaBaja property
* @param value long with the FechaBaja
*/
    public void setFechaBaja(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaBaja, value);
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
* Gets the MotivoSustitucion property
* @return String with the MotivoSustitucion
*/
    public String getMotivoSustitucion()
    {
        return getSemanticObject().getProperty(intranet_motivoSustitucion);
    }

/**
* Sets the MotivoSustitucion property
* @param value long with the MotivoSustitucion
*/
    public void setMotivoSustitucion(String value)
    {
        getSemanticObject().setProperty(intranet_motivoSustitucion, value);
    }

/**
* Gets the AniosExpertise property
* @return String with the AniosExpertise
*/
    public String getAniosExpertise()
    {
        return getSemanticObject().getProperty(intranet_aniosExpertise);
    }

/**
* Sets the AniosExpertise property
* @param value long with the AniosExpertise
*/
    public void setAniosExpertise(String value)
    {
        getSemanticObject().setProperty(intranet_aniosExpertise, value);
    }

/**
* Gets the NombreVacante property
* @return String with the NombreVacante
*/
    public String getNombreVacante()
    {
        return getSemanticObject().getProperty(intranet_nombreVacante);
    }

/**
* Sets the NombreVacante property
* @param value long with the NombreVacante
*/
    public void setNombreVacante(String value)
    {
        getSemanticObject().setProperty(intranet_nombreVacante, value);
    }
}
