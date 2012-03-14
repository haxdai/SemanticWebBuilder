package com.infotec.cvi.swb.base;


public abstract class SolicitudRecursoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Habilidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasExpertise");
    public static final org.semanticwb.platform.SemanticClass intranet_Avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Avance");
    public static final org.semanticwb.platform.SemanticProperty intranet_avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#avance");
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
    public static final org.semanticwb.platform.SemanticProperty intranet_especialidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#especialidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_autorizaPresupuestal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autorizaPresupuestal");
    public static final org.semanticwb.platform.SemanticProperty intranet_personalIndirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#personalIndirecto");
    public static final org.semanticwb.platform.SemanticClass intranet_SectorExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SectorExpertise");
    public static final org.semanticwb.platform.SemanticProperty intranet_sectorExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sectorExpertise");
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
    public static final org.semanticwb.platform.SemanticClass intranet_Candidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Candidato");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCandidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCandidato");
    public static final org.semanticwb.platform.SemanticClass intranet_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Proyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_proyectoAsignado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#proyectoAsignado");
    public static final org.semanticwb.platform.SemanticProperty intranet_conocimientoTecnico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#conocimientoTecnico");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitanteRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitanteRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_salarioMin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#salarioMin");
    public static final org.semanticwb.platform.SemanticProperty intranet_entrevistador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entrevistador");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivoContratacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCompetenciaReq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCompetenciaReq");
    public static final org.semanticwb.platform.SemanticProperty intranet_numVacantes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numVacantes");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaBaja=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaBaja");
    public static final org.semanticwb.platform.SemanticProperty intranet_certificaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#certificaciones");
    public static final org.semanticwb.platform.SemanticProperty intranet_personalDirecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#personalDirecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_motivoSustitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#motivoSustitucion");
    public static final org.semanticwb.platform.SemanticProperty intranet_aniosExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#aniosExpertise");
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
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SectorExpertise
       * @param value SectorExpertise of the type com.infotec.cvi.swb.SectorExpertise
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySectorExpertise(com.infotec.cvi.swb.SectorExpertise value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_sectorExpertise, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined SectorExpertise
       * @param value SectorExpertise of the type com.infotec.cvi.swb.SectorExpertise
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoBySectorExpertise(com.infotec.cvi.swb.SectorExpertise value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_sectorExpertise,value.getSemanticObject(),sclass));
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
       * @param value Candidato of the type com.infotec.cvi.swb.Candidato
       * @param model Model of the com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidato(com.infotec.cvi.swb.Candidato value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCandidato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SolicitudRecurso with a determined Candidato
       * @param value Candidato of the type com.infotec.cvi.swb.Candidato
       * @return Iterator with all the com.infotec.cvi.swb.SolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SolicitudRecurso> listSolicitudRecursoByCandidato(com.infotec.cvi.swb.Candidato value)
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
   * Sets the value for the property SectorExpertise
   * @param value SectorExpertise to set
   */

    public void setSectorExpertise(com.infotec.cvi.swb.SectorExpertise value)
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
   * @return a com.infotec.cvi.swb.SectorExpertise
   */
    public com.infotec.cvi.swb.SectorExpertise getSectorExpertise()
    {
         com.infotec.cvi.swb.SectorExpertise ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_sectorExpertise);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SectorExpertise)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the com.infotec.cvi.swb.Candidato
   * @return A GenericIterator with all the com.infotec.cvi.swb.Candidato
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Candidato> listCandidatos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Candidato>(getSemanticObject().listObjectProperties(intranet_hasCandidato));
    }

   /**
   * Gets true if has a Candidato
   * @param value com.infotec.cvi.swb.Candidato to verify
   * @return true if the com.infotec.cvi.swb.Candidato exists, false otherwise
   */
    public boolean hasCandidato(com.infotec.cvi.swb.Candidato value)
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
   * @param value com.infotec.cvi.swb.Candidato to add
   */

    public void addCandidato(com.infotec.cvi.swb.Candidato value)
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
   * @param value com.infotec.cvi.swb.Candidato to remove
   */

    public void removeCandidato(com.infotec.cvi.swb.Candidato value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCandidato,value.getSemanticObject());
    }

   /**
   * Gets the Candidato
   * @return a com.infotec.cvi.swb.Candidato
   */
    public com.infotec.cvi.swb.Candidato getCandidato()
    {
         com.infotec.cvi.swb.Candidato ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCandidato);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Candidato)obj.createGenericInstance();
         }
         return ret;
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
