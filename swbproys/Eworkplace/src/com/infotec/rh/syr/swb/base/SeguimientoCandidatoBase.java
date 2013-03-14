package com.infotec.rh.syr.swb.base;


public abstract class SeguimientoCandidatoBase extends com.infotec.eworkplace.swb.Seguimiento implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_candidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#candidato");
    public static final org.semanticwb.platform.SemanticProperty intranet_entrevistadorTelefonica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entrevistadorTelefonica");
    public static final org.semanticwb.platform.SemanticProperty intranet_apruebaCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#apruebaCompetencias");
    public static final org.semanticwb.platform.SemanticProperty intranet_notasCompetencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notasCompetencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_observacionesTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#observacionesTecnica");
    public static final org.semanticwb.platform.SemanticProperty intranet_filePsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#filePsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaCompetencias");
    public static final org.semanticwb.platform.SemanticProperty intranet_candidatoGanador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#candidatoGanador");
    public static final org.semanticwb.platform.SemanticProperty intranet_notaExperienciaCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notaExperienciaCompetencias");
   /**
   * Elemento que contiene la información del perfil del usuario requerido
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudCandidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudCandidato");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaTecnica");
    public static final org.semanticwb.platform.SemanticProperty intranet_usuarioBateria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#usuarioBateria");
    public static final org.semanticwb.platform.SemanticProperty intranet_realizoPsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#realizoPsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_passBateria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#passBateria");
    public static final org.semanticwb.platform.SemanticProperty intranet_notasTecnicoCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#notasTecnicoCompetencias");
    public static final org.semanticwb.platform.SemanticProperty intranet_pasaEntrevistaTelefonica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#pasaEntrevistaTelefonica");
    public static final org.semanticwb.platform.SemanticProperty intranet_apruebaTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#apruebaTecnica");
    public static final org.semanticwb.platform.SemanticProperty intranet_archivoPsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#archivoPsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_observacionesEntrevistaTelefonica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#observacionesEntrevistaTelefonica");
    public static final org.semanticwb.platform.SemanticProperty intranet_existenPostulantesPsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#existenPostulantesPsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_porcentajeCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#porcentajeCompetencias");
    public static final org.semanticwb.platform.SemanticProperty intranet_porcentajeTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#porcentajeTecnica");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaEnvioCorreoPsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaEnvioCorreoPsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_existenCandidatosTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#existenCandidatosTecnica");
    public static final org.semanticwb.platform.SemanticProperty intranet_porcentajePsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#porcentajePsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaRealizaEntrevista=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaRealizaEntrevista");
    public static final org.semanticwb.platform.SemanticProperty intranet_viablePsicometrico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#viablePsicometrico");
    public static final org.semanticwb.platform.SemanticProperty intranet_apruebaEntrevistaTelefonica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#apruebaEntrevistaTelefonica");
    public static final org.semanticwb.platform.SemanticProperty intranet_entrevistadorCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entrevistadorCompetencias");
    public static final org.semanticwb.platform.SemanticProperty intranet_pasaEntrevistaTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#pasaEntrevistaTecnica");
    public static final org.semanticwb.platform.SemanticClass intranet_SeguimientoCandidato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoCandidato");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoCandidato");

    public static class ClassMgr
    {
       /**
       * Returns a list of SeguimientoCandidato for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SeguimientoCandidato for all models
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato>(it, true);
        }

        public static com.infotec.rh.syr.swb.SeguimientoCandidato createSeguimientoCandidato(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SeguimientoCandidato.ClassMgr.createSeguimientoCandidato(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return A com.infotec.rh.syr.swb.SeguimientoCandidato
       */
        public static com.infotec.rh.syr.swb.SeguimientoCandidato getSeguimientoCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoCandidato)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return A com.infotec.rh.syr.swb.SeguimientoCandidato
       */
        public static com.infotec.rh.syr.swb.SeguimientoCandidato createSeguimientoCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoCandidato)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       */
        public static void removeSeguimientoCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoCandidato
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return true if the com.infotec.rh.syr.swb.SeguimientoCandidato exists, false otherwise
       */

        public static boolean hasSeguimientoCandidato(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeguimientoCandidato(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined Candidato
       * @param value Candidato of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByCandidato(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_candidato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined Candidato
       * @param value Candidato of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByCandidato(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_candidato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined EntrevistadorTelefonica
       * @param value EntrevistadorTelefonica of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByEntrevistadorTelefonica(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_entrevistadorTelefonica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined EntrevistadorTelefonica
       * @param value EntrevistadorTelefonica of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByEntrevistadorTelefonica(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_entrevistadorTelefonica,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined SolicitudCandidato
       * @param value SolicitudCandidato of the type com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoBySolicitudCandidato(com.infotec.cvi.swb.SolicitudRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudCandidato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined SolicitudCandidato
       * @param value SolicitudCandidato of the type com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoBySolicitudCandidato(com.infotec.cvi.swb.SolicitudRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudCandidato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined EntrevistadorCompetencias
       * @param value EntrevistadorCompetencias of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoCandidato
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByEntrevistadorCompetencias(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_entrevistadorCompetencias, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoCandidato with a determined EntrevistadorCompetencias
       * @param value EntrevistadorCompetencias of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoCandidato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoCandidato> listSeguimientoCandidatoByEntrevistadorCompetencias(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoCandidato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_entrevistadorCompetencias,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static SeguimientoCandidatoBase.ClassMgr getSeguimientoCandidatoClassMgr()
    {
        return new SeguimientoCandidatoBase.ClassMgr();
    }

   /**
   * Constructs a SeguimientoCandidatoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SeguimientoCandidato
   */
    public SeguimientoCandidatoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Candidato
   * @param value Candidato to set
   */

    public void setCandidato(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_candidato, value.getSemanticObject());
        }else
        {
            removeCandidato();
        }
    }
   /**
   * Remove the value for Candidato property
   */

    public void removeCandidato()
    {
        getSemanticObject().removeProperty(intranet_candidato);
    }

   /**
   * Gets the Candidato
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCandidato()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_candidato);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EntrevistadorTelefonica
   * @param value EntrevistadorTelefonica to set
   */

    public void setEntrevistadorTelefonica(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_entrevistadorTelefonica, value.getSemanticObject());
        }else
        {
            removeEntrevistadorTelefonica();
        }
    }
   /**
   * Remove the value for EntrevistadorTelefonica property
   */

    public void removeEntrevistadorTelefonica()
    {
        getSemanticObject().removeProperty(intranet_entrevistadorTelefonica);
    }

   /**
   * Gets the EntrevistadorTelefonica
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEntrevistadorTelefonica()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_entrevistadorTelefonica);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ApruebaCompetencias property
* @return boolean with the ApruebaCompetencias
*/
    public boolean isApruebaCompetencias()
    {
        return getSemanticObject().getBooleanProperty(intranet_apruebaCompetencias);
    }

/**
* Sets the ApruebaCompetencias property
* @param value long with the ApruebaCompetencias
*/
    public void setApruebaCompetencias(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_apruebaCompetencias, value);
    }

/**
* Gets the NotasCompetencia property
* @return String with the NotasCompetencia
*/
    public String getNotasCompetencia()
    {
        return getSemanticObject().getProperty(intranet_notasCompetencia);
    }

/**
* Sets the NotasCompetencia property
* @param value long with the NotasCompetencia
*/
    public void setNotasCompetencia(String value)
    {
        getSemanticObject().setProperty(intranet_notasCompetencia, value);
    }

/**
* Gets the ObservacionesTecnica property
* @return String with the ObservacionesTecnica
*/
    public String getObservacionesTecnica()
    {
        return getSemanticObject().getProperty(intranet_observacionesTecnica);
    }

/**
* Sets the ObservacionesTecnica property
* @param value long with the ObservacionesTecnica
*/
    public void setObservacionesTecnica(String value)
    {
        getSemanticObject().setProperty(intranet_observacionesTecnica, value);
    }

/**
* Gets the FilePsicometrico property
* @return String with the FilePsicometrico
*/
    public String getFilePsicometrico()
    {
        return getSemanticObject().getProperty(intranet_filePsicometrico);
    }

/**
* Sets the FilePsicometrico property
* @param value long with the FilePsicometrico
*/
    public void setFilePsicometrico(String value)
    {
        getSemanticObject().setProperty(intranet_filePsicometrico, value);
    }

/**
* Gets the FechaCompetencias property
* @return java.util.Date with the FechaCompetencias
*/
    public java.util.Date getFechaCompetencias()
    {
        return getSemanticObject().getDateProperty(intranet_fechaCompetencias);
    }

/**
* Sets the FechaCompetencias property
* @param value long with the FechaCompetencias
*/
    public void setFechaCompetencias(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaCompetencias, value);
    }

/**
* Gets the CandidatoGanador property
* @return boolean with the CandidatoGanador
*/
    public boolean isCandidatoGanador()
    {
        return getSemanticObject().getBooleanProperty(intranet_candidatoGanador);
    }

/**
* Sets the CandidatoGanador property
* @param value long with the CandidatoGanador
*/
    public void setCandidatoGanador(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_candidatoGanador, value);
    }

/**
* Gets the NotaExperienciaCompetencias property
* @return String with the NotaExperienciaCompetencias
*/
    public String getNotaExperienciaCompetencias()
    {
        return getSemanticObject().getProperty(intranet_notaExperienciaCompetencias);
    }

/**
* Sets the NotaExperienciaCompetencias property
* @param value long with the NotaExperienciaCompetencias
*/
    public void setNotaExperienciaCompetencias(String value)
    {
        getSemanticObject().setProperty(intranet_notaExperienciaCompetencias, value);
    }
   /**
   * Sets the value for the property SolicitudCandidato
   * @param value SolicitudCandidato to set
   */

    public void setSolicitudCandidato(com.infotec.cvi.swb.SolicitudRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudCandidato, value.getSemanticObject());
        }else
        {
            removeSolicitudCandidato();
        }
    }
   /**
   * Remove the value for SolicitudCandidato property
   */

    public void removeSolicitudCandidato()
    {
        getSemanticObject().removeProperty(intranet_solicitudCandidato);
    }

   /**
   * Gets the SolicitudCandidato
   * @return a com.infotec.cvi.swb.SolicitudRecurso
   */
    public com.infotec.cvi.swb.SolicitudRecurso getSolicitudCandidato()
    {
         com.infotec.cvi.swb.SolicitudRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudCandidato);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SolicitudRecurso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FechaTecnica property
* @return java.util.Date with the FechaTecnica
*/
    public java.util.Date getFechaTecnica()
    {
        return getSemanticObject().getDateProperty(intranet_fechaTecnica);
    }

/**
* Sets the FechaTecnica property
* @param value long with the FechaTecnica
*/
    public void setFechaTecnica(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaTecnica, value);
    }

/**
* Gets the UsuarioBateria property
* @return String with the UsuarioBateria
*/
    public String getUsuarioBateria()
    {
        return getSemanticObject().getProperty(intranet_usuarioBateria);
    }

/**
* Sets the UsuarioBateria property
* @param value long with the UsuarioBateria
*/
    public void setUsuarioBateria(String value)
    {
        getSemanticObject().setProperty(intranet_usuarioBateria, value);
    }

/**
* Gets the RealizoPsicometrico property
* @return boolean with the RealizoPsicometrico
*/
    public boolean isRealizoPsicometrico()
    {
        return getSemanticObject().getBooleanProperty(intranet_realizoPsicometrico);
    }

/**
* Sets the RealizoPsicometrico property
* @param value long with the RealizoPsicometrico
*/
    public void setRealizoPsicometrico(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_realizoPsicometrico, value);
    }

/**
* Gets the PassBateria property
* @return String with the PassBateria
*/
    public String getPassBateria()
    {
        return getSemanticObject().getProperty(intranet_passBateria);
    }

/**
* Sets the PassBateria property
* @param value long with the PassBateria
*/
    public void setPassBateria(String value)
    {
        getSemanticObject().setProperty(intranet_passBateria, value);
    }

/**
* Gets the NotasTecnicoCompetencias property
* @return String with the NotasTecnicoCompetencias
*/
    public String getNotasTecnicoCompetencias()
    {
        return getSemanticObject().getProperty(intranet_notasTecnicoCompetencias);
    }

/**
* Sets the NotasTecnicoCompetencias property
* @param value long with the NotasTecnicoCompetencias
*/
    public void setNotasTecnicoCompetencias(String value)
    {
        getSemanticObject().setProperty(intranet_notasTecnicoCompetencias, value);
    }

/**
* Gets the PasaEntrevistaTelefonica property
* @return boolean with the PasaEntrevistaTelefonica
*/
    public boolean isPasaEntrevistaTelefonica()
    {
        return getSemanticObject().getBooleanProperty(intranet_pasaEntrevistaTelefonica);
    }

/**
* Sets the PasaEntrevistaTelefonica property
* @param value long with the PasaEntrevistaTelefonica
*/
    public void setPasaEntrevistaTelefonica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_pasaEntrevistaTelefonica, value);
    }

/**
* Gets the ApruebaTecnica property
* @return boolean with the ApruebaTecnica
*/
    public boolean isApruebaTecnica()
    {
        return getSemanticObject().getBooleanProperty(intranet_apruebaTecnica);
    }

/**
* Sets the ApruebaTecnica property
* @param value long with the ApruebaTecnica
*/
    public void setApruebaTecnica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_apruebaTecnica, value);
    }

/**
* Gets the ArchivoPsicometrico property
* @return String with the ArchivoPsicometrico
*/
    public String getArchivoPsicometrico()
    {
        return getSemanticObject().getProperty(intranet_archivoPsicometrico);
    }

/**
* Sets the ArchivoPsicometrico property
* @param value long with the ArchivoPsicometrico
*/
    public void setArchivoPsicometrico(String value)
    {
        getSemanticObject().setProperty(intranet_archivoPsicometrico, value);
    }

/**
* Gets the ObservacionesEntrevistaTelefonica property
* @return String with the ObservacionesEntrevistaTelefonica
*/
    public String getObservacionesEntrevistaTelefonica()
    {
        return getSemanticObject().getProperty(intranet_observacionesEntrevistaTelefonica);
    }

/**
* Sets the ObservacionesEntrevistaTelefonica property
* @param value long with the ObservacionesEntrevistaTelefonica
*/
    public void setObservacionesEntrevistaTelefonica(String value)
    {
        getSemanticObject().setProperty(intranet_observacionesEntrevistaTelefonica, value);
    }

/**
* Gets the ExistenPostulantesPsicometrico property
* @return boolean with the ExistenPostulantesPsicometrico
*/
    public boolean isExistenPostulantesPsicometrico()
    {
        return getSemanticObject().getBooleanProperty(intranet_existenPostulantesPsicometrico);
    }

/**
* Sets the ExistenPostulantesPsicometrico property
* @param value long with the ExistenPostulantesPsicometrico
*/
    public void setExistenPostulantesPsicometrico(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_existenPostulantesPsicometrico, value);
    }

/**
* Gets the PorcentajeCompetencias property
* @return float with the PorcentajeCompetencias
*/
    public float getPorcentajeCompetencias()
    {
        return getSemanticObject().getFloatProperty(intranet_porcentajeCompetencias);
    }

/**
* Sets the PorcentajeCompetencias property
* @param value long with the PorcentajeCompetencias
*/
    public void setPorcentajeCompetencias(float value)
    {
        getSemanticObject().setFloatProperty(intranet_porcentajeCompetencias, value);
    }

/**
* Gets the PorcentajeTecnica property
* @return float with the PorcentajeTecnica
*/
    public float getPorcentajeTecnica()
    {
        return getSemanticObject().getFloatProperty(intranet_porcentajeTecnica);
    }

/**
* Sets the PorcentajeTecnica property
* @param value long with the PorcentajeTecnica
*/
    public void setPorcentajeTecnica(float value)
    {
        getSemanticObject().setFloatProperty(intranet_porcentajeTecnica, value);
    }

/**
* Gets the FechaEnvioCorreoPsicometrico property
* @return java.util.Date with the FechaEnvioCorreoPsicometrico
*/
    public java.util.Date getFechaEnvioCorreoPsicometrico()
    {
        return getSemanticObject().getDateProperty(intranet_fechaEnvioCorreoPsicometrico);
    }

/**
* Sets the FechaEnvioCorreoPsicometrico property
* @param value long with the FechaEnvioCorreoPsicometrico
*/
    public void setFechaEnvioCorreoPsicometrico(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaEnvioCorreoPsicometrico, value);
    }

/**
* Gets the ExistenCandidatosTecnica property
* @return boolean with the ExistenCandidatosTecnica
*/
    public boolean isExistenCandidatosTecnica()
    {
        return getSemanticObject().getBooleanProperty(intranet_existenCandidatosTecnica);
    }

/**
* Sets the ExistenCandidatosTecnica property
* @param value long with the ExistenCandidatosTecnica
*/
    public void setExistenCandidatosTecnica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_existenCandidatosTecnica, value);
    }

/**
* Gets the PorcentajePsicometrico property
* @return float with the PorcentajePsicometrico
*/
    public float getPorcentajePsicometrico()
    {
        return getSemanticObject().getFloatProperty(intranet_porcentajePsicometrico);
    }

/**
* Sets the PorcentajePsicometrico property
* @param value long with the PorcentajePsicometrico
*/
    public void setPorcentajePsicometrico(float value)
    {
        getSemanticObject().setFloatProperty(intranet_porcentajePsicometrico, value);
    }

/**
* Gets the FechaRealizaEntrevista property
* @return java.util.Date with the FechaRealizaEntrevista
*/
    public java.util.Date getFechaRealizaEntrevista()
    {
        return getSemanticObject().getDateProperty(intranet_fechaRealizaEntrevista);
    }

/**
* Sets the FechaRealizaEntrevista property
* @param value long with the FechaRealizaEntrevista
*/
    public void setFechaRealizaEntrevista(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaRealizaEntrevista, value);
    }

/**
* Gets the ViablePsicometrico property
* @return boolean with the ViablePsicometrico
*/
    public boolean isViablePsicometrico()
    {
        return getSemanticObject().getBooleanProperty(intranet_viablePsicometrico);
    }

/**
* Sets the ViablePsicometrico property
* @param value long with the ViablePsicometrico
*/
    public void setViablePsicometrico(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_viablePsicometrico, value);
    }

/**
* Gets the ApruebaEntrevistaTelefonica property
* @return boolean with the ApruebaEntrevistaTelefonica
*/
    public boolean isApruebaEntrevistaTelefonica()
    {
        return getSemanticObject().getBooleanProperty(intranet_apruebaEntrevistaTelefonica);
    }

/**
* Sets the ApruebaEntrevistaTelefonica property
* @param value long with the ApruebaEntrevistaTelefonica
*/
    public void setApruebaEntrevistaTelefonica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_apruebaEntrevistaTelefonica, value);
    }
   /**
   * Sets the value for the property EntrevistadorCompetencias
   * @param value EntrevistadorCompetencias to set
   */

    public void setEntrevistadorCompetencias(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_entrevistadorCompetencias, value.getSemanticObject());
        }else
        {
            removeEntrevistadorCompetencias();
        }
    }
   /**
   * Remove the value for EntrevistadorCompetencias property
   */

    public void removeEntrevistadorCompetencias()
    {
        getSemanticObject().removeProperty(intranet_entrevistadorCompetencias);
    }

   /**
   * Gets the EntrevistadorCompetencias
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEntrevistadorCompetencias()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_entrevistadorCompetencias);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PasaEntrevistaTecnica property
* @return boolean with the PasaEntrevistaTecnica
*/
    public boolean isPasaEntrevistaTecnica()
    {
        return getSemanticObject().getBooleanProperty(intranet_pasaEntrevistaTecnica);
    }

/**
* Sets the PasaEntrevistaTecnica property
* @param value long with the PasaEntrevistaTecnica
*/
    public void setPasaEntrevistaTecnica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_pasaEntrevistaTecnica, value);
    }
}
