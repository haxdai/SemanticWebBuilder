package com.infotec.cvi.swb.base;


   /**
   * Contiene la información del Curriculum Vitae de la persona 
   */
public abstract class CVBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Distincion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Distincion");
   /**
   * Lista de distinciones obtenidas por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDistincion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDistincion");
    public static final org.semanticwb.platform.SemanticClass intranet_Investigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Investigacion");
   /**
   * Lista de todas las investigaciones realizadas por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasInvestigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasInvestigacion");
   /**
   * Elemento que indica si no cuenta la persona con Investigaciones
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinInvestigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinInvestigacion");
   /**
   * Elemento que se utiliza para la generación del CV en un documento PDF
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_documentoCV=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentoCV");
   /**
   * Elemento para agrupar los Estudios como Grado Académico, Estudios Superiores asociados a la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
   /**
   * Elemento para agrupar los Estudios como Grado Académico, Estudios Superiores asociados al CV de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#academia");
   /**
   * Elemento que almacena la actualización del documento del CV
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_actualizacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#actualizacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Docencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Docencia");
   /**
   * Lista de actividades de Docencia que ha impartido el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDocencia");
    public static final org.semanticwb.platform.SemanticClass intranet_Publicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Publicacion");
   /**
   * Lista de todas las publicaciones que ha realizado el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPublicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPublicacion");
   /**
   * Cursos de TIC capturados por el usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CursoTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CursoTIC");
   /**
   * Lista de Cursos TIC capturados por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCursosTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCursosTIC");
   /**
   * Elemento que indica si no tienen diplomados la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinDiplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinDiplomado");
   /**
   * Elemento que almacena la información del Idioma de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");
   /**
   * Lista de todos los idiomas capturado por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasIdioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasIdioma");
    public static final org.semanticwb.platform.SemanticClass intranet_AreaTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaTalento");
   /**
   * Lista de las Áreas de Talento capturadas por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasAreaTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasAreaTalento");
   /**
   * Catálogo utilizado para la lista de las competencias, utilizadas en Autoevaluación de Competencias
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
   /**
   * Lista de las competencias seleccionadas por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCompetencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCompetencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_postSeguimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#postSeguimiento");
   /**
   * Elemento que indica si no cuenta la persona con dominio de otros idiomas
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinIdioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinIdioma");
   /**
   * Elemento que indica si no tienen cursos la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinCurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinCurso");
   /**
   * Elemento que indica si no cuenta la persona con Publicaciones
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinPublicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinPublicacion");
    public static final org.semanticwb.platform.SemanticClass intranet_ExperienciaLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaLaboral");
   /**
   * Lista de todos los trabajos del usuario, su experiencia laboral
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasExperienciaLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasExperienciaLaboral");
   /**
   * Elemento que indica si no se han impartido cursos la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinDocencia");
   /**
   * Elemento que indica si no cuenta la persona con Distinciones
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinDistincion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinDistincion");
   /**
   * Contiene el Diplomado que ha cursado la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");
   /**
   * Lista de Diplomados, cursos o certificaciones que ha tomado el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDiplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDiplomado");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * Elemento que indica que usuario es el propietario del CV
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_propietario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#propietario");
   /**
   * Elemento que indica si no cuenta la persona con Experiencia laboral
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_sinExperiencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sinExperiencia");
   /**
   * Elemento utilizado para guardar los Documentos Probatorios que respalda la información del CV capturada por el usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");
   /**
   * Elemento que contiene los documentos en electrónico que respalda la información capturada en el CV
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_documentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentoProbatorio");
   /**
   * Elemento utilizado para almacenar toda la información del usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Persona");
   /**
   * Elemento que indica la relación del CV con la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#persona");
   /**
   * Contiene la información del Curriculum Vitae de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CV=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CV");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CV");

    public static class ClassMgr
    {
       /**
       * Returns a list of CV for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.CV for all models
       * @return Iterator of com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV>(it, true);
        }

        public static com.infotec.cvi.swb.CV createCV(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.CV.ClassMgr.createCV(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.CV
       * @param id Identifier for com.infotec.cvi.swb.CV
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return A com.infotec.cvi.swb.CV
       */
        public static com.infotec.cvi.swb.CV getCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CV)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.CV
       * @param id Identifier for com.infotec.cvi.swb.CV
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return A com.infotec.cvi.swb.CV
       */
        public static com.infotec.cvi.swb.CV createCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CV)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.CV
       * @param id Identifier for com.infotec.cvi.swb.CV
       * @param model Model of the com.infotec.cvi.swb.CV
       */
        public static void removeCV(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.CV
       * @param id Identifier for com.infotec.cvi.swb.CV
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return true if the com.infotec.cvi.swb.CV exists, false otherwise
       */

        public static boolean hasCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCV(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Distincion
       * @param value Distincion of the type com.infotec.cvi.swb.Distincion
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDistincion(com.infotec.cvi.swb.Distincion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDistincion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Distincion
       * @param value Distincion of the type com.infotec.cvi.swb.Distincion
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDistincion(com.infotec.cvi.swb.Distincion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDistincion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Investigacion
       * @param value Investigacion of the type com.infotec.cvi.swb.Investigacion
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByInvestigacion(com.infotec.cvi.swb.Investigacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasInvestigacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Investigacion
       * @param value Investigacion of the type com.infotec.cvi.swb.Investigacion
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByInvestigacion(com.infotec.cvi.swb.Investigacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasInvestigacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.cvi.swb.Academia
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByAcademia(com.infotec.cvi.swb.Academia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_academia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.cvi.swb.Academia
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByAcademia(com.infotec.cvi.swb.Academia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_academia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Docencia
       * @param value Docencia of the type com.infotec.cvi.swb.Docencia
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDocencia(com.infotec.cvi.swb.Docencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDocencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Docencia
       * @param value Docencia of the type com.infotec.cvi.swb.Docencia
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDocencia(com.infotec.cvi.swb.Docencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDocencia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Publicacion
       * @param value Publicacion of the type com.infotec.cvi.swb.Publicacion
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByPublicacion(com.infotec.cvi.swb.Publicacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPublicacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Publicacion
       * @param value Publicacion of the type com.infotec.cvi.swb.Publicacion
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByPublicacion(com.infotec.cvi.swb.Publicacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPublicacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined CursosTIC
       * @param value CursosTIC of the type com.infotec.cvi.swb.CursoTIC
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByCursosTIC(com.infotec.cvi.swb.CursoTIC value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCursosTIC, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined CursosTIC
       * @param value CursosTIC of the type com.infotec.cvi.swb.CursoTIC
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByCursosTIC(com.infotec.cvi.swb.CursoTIC value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCursosTIC,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Idioma
       * @param value Idioma of the type com.infotec.cvi.swb.Idioma
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByIdioma(com.infotec.cvi.swb.Idioma value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasIdioma, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Idioma
       * @param value Idioma of the type com.infotec.cvi.swb.Idioma
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByIdioma(com.infotec.cvi.swb.Idioma value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasIdioma,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined AreaTalento
       * @param value AreaTalento of the type com.infotec.cvi.swb.AreaTalento
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByAreaTalento(com.infotec.cvi.swb.AreaTalento value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasAreaTalento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined AreaTalento
       * @param value AreaTalento of the type com.infotec.cvi.swb.AreaTalento
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByAreaTalento(com.infotec.cvi.swb.AreaTalento value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasAreaTalento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.cvi.swb.Competencia
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByCompetencia(com.infotec.cvi.swb.Competencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCompetencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.cvi.swb.Competencia
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByCompetencia(com.infotec.cvi.swb.Competencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCompetencia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined ExperienciaLaboral
       * @param value ExperienciaLaboral of the type com.infotec.cvi.swb.ExperienciaLaboral
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByExperienciaLaboral(com.infotec.cvi.swb.ExperienciaLaboral value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasExperienciaLaboral, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined ExperienciaLaboral
       * @param value ExperienciaLaboral of the type com.infotec.cvi.swb.ExperienciaLaboral
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByExperienciaLaboral(com.infotec.cvi.swb.ExperienciaLaboral value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasExperienciaLaboral,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Diplomado
       * @param value Diplomado of the type com.infotec.cvi.swb.Diplomado
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDiplomado(com.infotec.cvi.swb.Diplomado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDiplomado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Diplomado
       * @param value Diplomado of the type com.infotec.cvi.swb.Diplomado
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDiplomado(com.infotec.cvi.swb.Diplomado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDiplomado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Propietario
       * @param value Propietario of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByPropietario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_propietario, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Propietario
       * @param value Propietario of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByPropietario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_propietario,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined DocumentoProbatorio
       * @param value DocumentoProbatorio of the type com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDocumentoProbatorio(com.infotec.cvi.swb.DocumentoProbatorio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_documentoProbatorio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined DocumentoProbatorio
       * @param value DocumentoProbatorio of the type com.infotec.cvi.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByDocumentoProbatorio(com.infotec.cvi.swb.DocumentoProbatorio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_documentoProbatorio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.cvi.swb.CV
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_persona, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.cvi.swb.CV
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_persona,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CVBase.ClassMgr getCVClassMgr()
    {
        return new CVBase.ClassMgr();
    }

   /**
   * Constructs a CVBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CV
   */
    public CVBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Distincion
   * @return A GenericIterator with all the com.infotec.cvi.swb.Distincion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distincion> listDistincions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Distincion>(getSemanticObject().listObjectProperties(intranet_hasDistincion));
    }

   /**
   * Gets true if has a Distincion
   * @param value com.infotec.cvi.swb.Distincion to verify
   * @return true if the com.infotec.cvi.swb.Distincion exists, false otherwise
   */
    public boolean hasDistincion(com.infotec.cvi.swb.Distincion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDistincion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Distincion
   * @param value com.infotec.cvi.swb.Distincion to add
   */

    public void addDistincion(com.infotec.cvi.swb.Distincion value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDistincion, value.getSemanticObject());
    }
   /**
   * Removes all the Distincion
   */

    public void removeAllDistincion()
    {
        getSemanticObject().removeProperty(intranet_hasDistincion);
    }
   /**
   * Removes a Distincion
   * @param value com.infotec.cvi.swb.Distincion to remove
   */

    public void removeDistincion(com.infotec.cvi.swb.Distincion value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDistincion,value.getSemanticObject());
    }

   /**
   * Gets the Distincion
   * @return a com.infotec.cvi.swb.Distincion
   */
    public com.infotec.cvi.swb.Distincion getDistincion()
    {
         com.infotec.cvi.swb.Distincion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDistincion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Distincion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.Investigacion
   * @return A GenericIterator with all the com.infotec.cvi.swb.Investigacion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Investigacion> listInvestigacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Investigacion>(getSemanticObject().listObjectProperties(intranet_hasInvestigacion));
    }

   /**
   * Gets true if has a Investigacion
   * @param value com.infotec.cvi.swb.Investigacion to verify
   * @return true if the com.infotec.cvi.swb.Investigacion exists, false otherwise
   */
    public boolean hasInvestigacion(com.infotec.cvi.swb.Investigacion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasInvestigacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Investigacion
   * @param value com.infotec.cvi.swb.Investigacion to add
   */

    public void addInvestigacion(com.infotec.cvi.swb.Investigacion value)
    {
        getSemanticObject().addObjectProperty(intranet_hasInvestigacion, value.getSemanticObject());
    }
   /**
   * Removes all the Investigacion
   */

    public void removeAllInvestigacion()
    {
        getSemanticObject().removeProperty(intranet_hasInvestigacion);
    }
   /**
   * Removes a Investigacion
   * @param value com.infotec.cvi.swb.Investigacion to remove
   */

    public void removeInvestigacion(com.infotec.cvi.swb.Investigacion value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasInvestigacion,value.getSemanticObject());
    }

   /**
   * Gets the Investigacion
   * @return a com.infotec.cvi.swb.Investigacion
   */
    public com.infotec.cvi.swb.Investigacion getInvestigacion()
    {
         com.infotec.cvi.swb.Investigacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasInvestigacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Investigacion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SinInvestigacion property
* @return boolean with the SinInvestigacion
*/
    public boolean isSinInvestigacion()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinInvestigacion);
    }

/**
* Sets the SinInvestigacion property
* @param value long with the SinInvestigacion
*/
    public void setSinInvestigacion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinInvestigacion, value);
    }

/**
* Gets the DocumentoCV property
* @return String with the DocumentoCV
*/
    public String getDocumentoCV()
    {
        return getSemanticObject().getProperty(intranet_documentoCV);
    }

/**
* Sets the DocumentoCV property
* @param value long with the DocumentoCV
*/
    public void setDocumentoCV(String value)
    {
        getSemanticObject().setProperty(intranet_documentoCV, value);
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
   * Sets the value for the property Academia
   * @param value Academia to set
   */

    public void setAcademia(com.infotec.cvi.swb.Academia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_academia, value.getSemanticObject());
        }else
        {
            removeAcademia();
        }
    }
   /**
   * Remove the value for Academia property
   */

    public void removeAcademia()
    {
        getSemanticObject().removeProperty(intranet_academia);
    }

   /**
   * Gets the Academia
   * @return a com.infotec.cvi.swb.Academia
   */
    public com.infotec.cvi.swb.Academia getAcademia()
    {
         com.infotec.cvi.swb.Academia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_academia);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Academia)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Actualizacion property
* @return java.util.Date with the Actualizacion
*/
    public java.util.Date getActualizacion()
    {
        return getSemanticObject().getDateProperty(intranet_actualizacion);
    }

/**
* Sets the Actualizacion property
* @param value long with the Actualizacion
*/
    public void setActualizacion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_actualizacion, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Docencia
   * @return A GenericIterator with all the com.infotec.cvi.swb.Docencia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Docencia> listDocencias()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Docencia>(getSemanticObject().listObjectProperties(intranet_hasDocencia));
    }

   /**
   * Gets true if has a Docencia
   * @param value com.infotec.cvi.swb.Docencia to verify
   * @return true if the com.infotec.cvi.swb.Docencia exists, false otherwise
   */
    public boolean hasDocencia(com.infotec.cvi.swb.Docencia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDocencia,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Docencia
   * @param value com.infotec.cvi.swb.Docencia to add
   */

    public void addDocencia(com.infotec.cvi.swb.Docencia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDocencia, value.getSemanticObject());
    }
   /**
   * Removes all the Docencia
   */

    public void removeAllDocencia()
    {
        getSemanticObject().removeProperty(intranet_hasDocencia);
    }
   /**
   * Removes a Docencia
   * @param value com.infotec.cvi.swb.Docencia to remove
   */

    public void removeDocencia(com.infotec.cvi.swb.Docencia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDocencia,value.getSemanticObject());
    }

   /**
   * Gets the Docencia
   * @return a com.infotec.cvi.swb.Docencia
   */
    public com.infotec.cvi.swb.Docencia getDocencia()
    {
         com.infotec.cvi.swb.Docencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDocencia);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Docencia)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.Publicacion
   * @return A GenericIterator with all the com.infotec.cvi.swb.Publicacion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Publicacion> listPublicacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Publicacion>(getSemanticObject().listObjectProperties(intranet_hasPublicacion));
    }

   /**
   * Gets true if has a Publicacion
   * @param value com.infotec.cvi.swb.Publicacion to verify
   * @return true if the com.infotec.cvi.swb.Publicacion exists, false otherwise
   */
    public boolean hasPublicacion(com.infotec.cvi.swb.Publicacion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPublicacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Publicacion
   * @param value com.infotec.cvi.swb.Publicacion to add
   */

    public void addPublicacion(com.infotec.cvi.swb.Publicacion value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPublicacion, value.getSemanticObject());
    }
   /**
   * Removes all the Publicacion
   */

    public void removeAllPublicacion()
    {
        getSemanticObject().removeProperty(intranet_hasPublicacion);
    }
   /**
   * Removes a Publicacion
   * @param value com.infotec.cvi.swb.Publicacion to remove
   */

    public void removePublicacion(com.infotec.cvi.swb.Publicacion value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPublicacion,value.getSemanticObject());
    }

   /**
   * Gets the Publicacion
   * @return a com.infotec.cvi.swb.Publicacion
   */
    public com.infotec.cvi.swb.Publicacion getPublicacion()
    {
         com.infotec.cvi.swb.Publicacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPublicacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Publicacion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.CursoTIC
   * @return A GenericIterator with all the com.infotec.cvi.swb.CursoTIC
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CursoTIC> listCursosTICs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CursoTIC>(getSemanticObject().listObjectProperties(intranet_hasCursosTIC));
    }

   /**
   * Gets true if has a CursosTIC
   * @param value com.infotec.cvi.swb.CursoTIC to verify
   * @return true if the com.infotec.cvi.swb.CursoTIC exists, false otherwise
   */
    public boolean hasCursosTIC(com.infotec.cvi.swb.CursoTIC value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCursosTIC,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CursosTIC
   * @param value com.infotec.cvi.swb.CursoTIC to add
   */

    public void addCursosTIC(com.infotec.cvi.swb.CursoTIC value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCursosTIC, value.getSemanticObject());
    }
   /**
   * Removes all the CursosTIC
   */

    public void removeAllCursosTIC()
    {
        getSemanticObject().removeProperty(intranet_hasCursosTIC);
    }
   /**
   * Removes a CursosTIC
   * @param value com.infotec.cvi.swb.CursoTIC to remove
   */

    public void removeCursosTIC(com.infotec.cvi.swb.CursoTIC value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCursosTIC,value.getSemanticObject());
    }

   /**
   * Gets the CursosTIC
   * @return a com.infotec.cvi.swb.CursoTIC
   */
    public com.infotec.cvi.swb.CursoTIC getCursosTIC()
    {
         com.infotec.cvi.swb.CursoTIC ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCursosTIC);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.CursoTIC)obj.createGenericInstance();
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
* Gets the SinDiplomado property
* @return boolean with the SinDiplomado
*/
    public boolean isSinDiplomado()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinDiplomado);
    }

/**
* Sets the SinDiplomado property
* @param value long with the SinDiplomado
*/
    public void setSinDiplomado(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinDiplomado, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Idioma
   * @return A GenericIterator with all the com.infotec.cvi.swb.Idioma
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idioma> listIdiomas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Idioma>(getSemanticObject().listObjectProperties(intranet_hasIdioma));
    }

   /**
   * Gets true if has a Idioma
   * @param value com.infotec.cvi.swb.Idioma to verify
   * @return true if the com.infotec.cvi.swb.Idioma exists, false otherwise
   */
    public boolean hasIdioma(com.infotec.cvi.swb.Idioma value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasIdioma,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Idioma
   * @param value com.infotec.cvi.swb.Idioma to add
   */

    public void addIdioma(com.infotec.cvi.swb.Idioma value)
    {
        getSemanticObject().addObjectProperty(intranet_hasIdioma, value.getSemanticObject());
    }
   /**
   * Removes all the Idioma
   */

    public void removeAllIdioma()
    {
        getSemanticObject().removeProperty(intranet_hasIdioma);
    }
   /**
   * Removes a Idioma
   * @param value com.infotec.cvi.swb.Idioma to remove
   */

    public void removeIdioma(com.infotec.cvi.swb.Idioma value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasIdioma,value.getSemanticObject());
    }

   /**
   * Gets the Idioma
   * @return a com.infotec.cvi.swb.Idioma
   */
    public com.infotec.cvi.swb.Idioma getIdioma()
    {
         com.infotec.cvi.swb.Idioma ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasIdioma);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Idioma)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.AreaTalento
   * @return A GenericIterator with all the com.infotec.cvi.swb.AreaTalento
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento>(getSemanticObject().listObjectProperties(intranet_hasAreaTalento));
    }

   /**
   * Gets true if has a AreaTalento
   * @param value com.infotec.cvi.swb.AreaTalento to verify
   * @return true if the com.infotec.cvi.swb.AreaTalento exists, false otherwise
   */
    public boolean hasAreaTalento(com.infotec.cvi.swb.AreaTalento value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasAreaTalento,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a AreaTalento
   * @param value com.infotec.cvi.swb.AreaTalento to add
   */

    public void addAreaTalento(com.infotec.cvi.swb.AreaTalento value)
    {
        getSemanticObject().addObjectProperty(intranet_hasAreaTalento, value.getSemanticObject());
    }
   /**
   * Removes all the AreaTalento
   */

    public void removeAllAreaTalento()
    {
        getSemanticObject().removeProperty(intranet_hasAreaTalento);
    }
   /**
   * Removes a AreaTalento
   * @param value com.infotec.cvi.swb.AreaTalento to remove
   */

    public void removeAreaTalento(com.infotec.cvi.swb.AreaTalento value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasAreaTalento,value.getSemanticObject());
    }

   /**
   * Gets the AreaTalento
   * @return a com.infotec.cvi.swb.AreaTalento
   */
    public com.infotec.cvi.swb.AreaTalento getAreaTalento()
    {
         com.infotec.cvi.swb.AreaTalento ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasAreaTalento);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.AreaTalento)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.Competencia
   * @return A GenericIterator with all the com.infotec.cvi.swb.Competencia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Competencia> listCompetencias()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Competencia>(getSemanticObject().listObjectProperties(intranet_hasCompetencia));
    }

   /**
   * Gets true if has a Competencia
   * @param value com.infotec.cvi.swb.Competencia to verify
   * @return true if the com.infotec.cvi.swb.Competencia exists, false otherwise
   */
    public boolean hasCompetencia(com.infotec.cvi.swb.Competencia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCompetencia,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Competencia
   * @param value com.infotec.cvi.swb.Competencia to add
   */

    public void addCompetencia(com.infotec.cvi.swb.Competencia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCompetencia, value.getSemanticObject());
    }
   /**
   * Removes all the Competencia
   */

    public void removeAllCompetencia()
    {
        getSemanticObject().removeProperty(intranet_hasCompetencia);
    }
   /**
   * Removes a Competencia
   * @param value com.infotec.cvi.swb.Competencia to remove
   */

    public void removeCompetencia(com.infotec.cvi.swb.Competencia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCompetencia,value.getSemanticObject());
    }

   /**
   * Gets the Competencia
   * @return a com.infotec.cvi.swb.Competencia
   */
    public com.infotec.cvi.swb.Competencia getCompetencia()
    {
         com.infotec.cvi.swb.Competencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCompetencia);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Competencia)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PostSeguimiento property
* @return boolean with the PostSeguimiento
*/
    public boolean isPostSeguimiento()
    {
        return getSemanticObject().getBooleanProperty(intranet_postSeguimiento);
    }

/**
* Sets the PostSeguimiento property
* @param value long with the PostSeguimiento
*/
    public void setPostSeguimiento(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_postSeguimiento, value);
    }

/**
* Gets the SinIdioma property
* @return boolean with the SinIdioma
*/
    public boolean isSinIdioma()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinIdioma);
    }

/**
* Sets the SinIdioma property
* @param value long with the SinIdioma
*/
    public void setSinIdioma(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinIdioma, value);
    }

/**
* Gets the SinCurso property
* @return boolean with the SinCurso
*/
    public boolean isSinCurso()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinCurso);
    }

/**
* Sets the SinCurso property
* @param value long with the SinCurso
*/
    public void setSinCurso(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinCurso, value);
    }

/**
* Gets the SinPublicacion property
* @return boolean with the SinPublicacion
*/
    public boolean isSinPublicacion()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinPublicacion);
    }

/**
* Sets the SinPublicacion property
* @param value long with the SinPublicacion
*/
    public void setSinPublicacion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinPublicacion, value);
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
   * Gets all the com.infotec.cvi.swb.ExperienciaLaboral
   * @return A GenericIterator with all the com.infotec.cvi.swb.ExperienciaLaboral
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaLaboral> listExperienciaLaborals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ExperienciaLaboral>(getSemanticObject().listObjectProperties(intranet_hasExperienciaLaboral));
    }

   /**
   * Gets true if has a ExperienciaLaboral
   * @param value com.infotec.cvi.swb.ExperienciaLaboral to verify
   * @return true if the com.infotec.cvi.swb.ExperienciaLaboral exists, false otherwise
   */
    public boolean hasExperienciaLaboral(com.infotec.cvi.swb.ExperienciaLaboral value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasExperienciaLaboral,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ExperienciaLaboral
   * @param value com.infotec.cvi.swb.ExperienciaLaboral to add
   */

    public void addExperienciaLaboral(com.infotec.cvi.swb.ExperienciaLaboral value)
    {
        getSemanticObject().addObjectProperty(intranet_hasExperienciaLaboral, value.getSemanticObject());
    }
   /**
   * Removes all the ExperienciaLaboral
   */

    public void removeAllExperienciaLaboral()
    {
        getSemanticObject().removeProperty(intranet_hasExperienciaLaboral);
    }
   /**
   * Removes a ExperienciaLaboral
   * @param value com.infotec.cvi.swb.ExperienciaLaboral to remove
   */

    public void removeExperienciaLaboral(com.infotec.cvi.swb.ExperienciaLaboral value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasExperienciaLaboral,value.getSemanticObject());
    }

   /**
   * Gets the ExperienciaLaboral
   * @return a com.infotec.cvi.swb.ExperienciaLaboral
   */
    public com.infotec.cvi.swb.ExperienciaLaboral getExperienciaLaboral()
    {
         com.infotec.cvi.swb.ExperienciaLaboral ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasExperienciaLaboral);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ExperienciaLaboral)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SinDocencia property
* @return boolean with the SinDocencia
*/
    public boolean isSinDocencia()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinDocencia);
    }

/**
* Sets the SinDocencia property
* @param value long with the SinDocencia
*/
    public void setSinDocencia(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinDocencia, value);
    }

/**
* Gets the SinDistincion property
* @return boolean with the SinDistincion
*/
    public boolean isSinDistincion()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinDistincion);
    }

/**
* Sets the SinDistincion property
* @param value long with the SinDistincion
*/
    public void setSinDistincion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinDistincion, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.Diplomado
   * @return A GenericIterator with all the com.infotec.cvi.swb.Diplomado
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Diplomado> listDiplomados()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Diplomado>(getSemanticObject().listObjectProperties(intranet_hasDiplomado));
    }

   /**
   * Gets true if has a Diplomado
   * @param value com.infotec.cvi.swb.Diplomado to verify
   * @return true if the com.infotec.cvi.swb.Diplomado exists, false otherwise
   */
    public boolean hasDiplomado(com.infotec.cvi.swb.Diplomado value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDiplomado,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Diplomado
   * @param value com.infotec.cvi.swb.Diplomado to add
   */

    public void addDiplomado(com.infotec.cvi.swb.Diplomado value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDiplomado, value.getSemanticObject());
    }
   /**
   * Removes all the Diplomado
   */

    public void removeAllDiplomado()
    {
        getSemanticObject().removeProperty(intranet_hasDiplomado);
    }
   /**
   * Removes a Diplomado
   * @param value com.infotec.cvi.swb.Diplomado to remove
   */

    public void removeDiplomado(com.infotec.cvi.swb.Diplomado value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDiplomado,value.getSemanticObject());
    }

   /**
   * Gets the Diplomado
   * @return a com.infotec.cvi.swb.Diplomado
   */
    public com.infotec.cvi.swb.Diplomado getDiplomado()
    {
         com.infotec.cvi.swb.Diplomado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDiplomado);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Diplomado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Propietario
   * @param value Propietario to set
   */

    public void setPropietario(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_propietario, value.getSemanticObject());
        }else
        {
            removePropietario();
        }
    }
   /**
   * Remove the value for Propietario property
   */

    public void removePropietario()
    {
        getSemanticObject().removeProperty(intranet_propietario);
    }

   /**
   * Gets the Propietario
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getPropietario()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_propietario);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SinExperiencia property
* @return boolean with the SinExperiencia
*/
    public boolean isSinExperiencia()
    {
        return getSemanticObject().getBooleanProperty(intranet_sinExperiencia);
    }

/**
* Sets the SinExperiencia property
* @param value long with the SinExperiencia
*/
    public void setSinExperiencia(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_sinExperiencia, value);
    }
   /**
   * Sets the value for the property DocumentoProbatorio
   * @param value DocumentoProbatorio to set
   */

    public void setDocumentoProbatorio(com.infotec.cvi.swb.DocumentoProbatorio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_documentoProbatorio, value.getSemanticObject());
        }else
        {
            removeDocumentoProbatorio();
        }
    }
   /**
   * Remove the value for DocumentoProbatorio property
   */

    public void removeDocumentoProbatorio()
    {
        getSemanticObject().removeProperty(intranet_documentoProbatorio);
    }

   /**
   * Gets the DocumentoProbatorio
   * @return a com.infotec.cvi.swb.DocumentoProbatorio
   */
    public com.infotec.cvi.swb.DocumentoProbatorio getDocumentoProbatorio()
    {
         com.infotec.cvi.swb.DocumentoProbatorio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_documentoProbatorio);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.DocumentoProbatorio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Persona
   * @param value Persona to set
   */

    public void setPersona(com.infotec.eworkplace.swb.Persona value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_persona, value.getSemanticObject());
        }else
        {
            removePersona();
        }
    }
   /**
   * Remove the value for Persona property
   */

    public void removePersona()
    {
        getSemanticObject().removeProperty(intranet_persona);
    }

   /**
   * Gets the Persona
   * @return a com.infotec.eworkplace.swb.Persona
   */
    public com.infotec.eworkplace.swb.Persona getPersona()
    {
         com.infotec.eworkplace.swb.Persona ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_persona);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Persona)obj.createGenericInstance();
         }
         return ret;
    }
}
