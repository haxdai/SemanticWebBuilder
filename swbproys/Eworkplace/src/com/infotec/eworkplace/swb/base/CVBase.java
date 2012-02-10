package com.infotec.eworkplace.swb.base;


public abstract class CVBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Distinciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Distinciones");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDistincion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDistincion");
    public static final org.semanticwb.platform.SemanticClass intranet_Investigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Investigacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasInvestigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasInvestigacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
    public static final org.semanticwb.platform.SemanticProperty intranet_academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#academia");
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_actualizacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#actualizacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Docencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Docencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDocencia");
    public static final org.semanticwb.platform.SemanticClass intranet_Publicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Publicacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPublicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPublicacion");
    public static final org.semanticwb.platform.SemanticClass intranet_CursoTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CursoTIC");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCursosTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCursosTIC");
    public static final org.semanticwb.platform.SemanticClass intranet_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasIdioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasIdioma");
    public static final org.semanticwb.platform.SemanticClass intranet_AreasTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreasTalento");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasAreaTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasAreaTalento");
    public static final org.semanticwb.platform.SemanticClass intranet_DocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDocumentoProbatorio");
    public static final org.semanticwb.platform.SemanticClass intranet_ExperienciaLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaLaboral");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasExperienciaLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasExperienciaLaboral");
    public static final org.semanticwb.platform.SemanticClass intranet_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDiplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDiplomado");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_propietario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#propietario");
    public static final org.semanticwb.platform.SemanticClass intranet_Persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Persona");
    public static final org.semanticwb.platform.SemanticProperty intranet_persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#persona");
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
       * @return Iterator of com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CV for all models
       * @return Iterator of com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV>(it, true);
        }

        public static com.infotec.eworkplace.swb.CV createCV(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CV.ClassMgr.createCV(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return A com.infotec.eworkplace.swb.CV
       */
        public static com.infotec.eworkplace.swb.CV getCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CV)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return A com.infotec.eworkplace.swb.CV
       */
        public static com.infotec.eworkplace.swb.CV createCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CV)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       */
        public static void removeCV(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return true if the com.infotec.eworkplace.swb.CV exists, false otherwise
       */

        public static boolean hasCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCV(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Distincion
       * @param value Distincion of the type com.infotec.eworkplace.swb.Distinciones
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDistincion(com.infotec.eworkplace.swb.Distinciones value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDistincion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Distincion
       * @param value Distincion of the type com.infotec.eworkplace.swb.Distinciones
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDistincion(com.infotec.eworkplace.swb.Distinciones value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDistincion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Investigacion
       * @param value Investigacion of the type com.infotec.eworkplace.swb.Investigacion
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByInvestigacion(com.infotec.eworkplace.swb.Investigacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasInvestigacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Investigacion
       * @param value Investigacion of the type com.infotec.eworkplace.swb.Investigacion
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByInvestigacion(com.infotec.eworkplace.swb.Investigacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasInvestigacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAcademia(com.infotec.eworkplace.swb.Academia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_academia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAcademia(com.infotec.eworkplace.swb.Academia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_academia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.eworkplace.swb.Competencia
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCompetencia(com.infotec.eworkplace.swb.Competencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_competencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.eworkplace.swb.Competencia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCompetencia(com.infotec.eworkplace.swb.Competencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_competencia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Docencia
       * @param value Docencia of the type com.infotec.eworkplace.swb.Docencia
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDocencia(com.infotec.eworkplace.swb.Docencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDocencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Docencia
       * @param value Docencia of the type com.infotec.eworkplace.swb.Docencia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDocencia(com.infotec.eworkplace.swb.Docencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDocencia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Publicacion
       * @param value Publicacion of the type com.infotec.eworkplace.swb.Publicacion
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPublicacion(com.infotec.eworkplace.swb.Publicacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPublicacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Publicacion
       * @param value Publicacion of the type com.infotec.eworkplace.swb.Publicacion
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPublicacion(com.infotec.eworkplace.swb.Publicacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPublicacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined CursosTIC
       * @param value CursosTIC of the type com.infotec.eworkplace.swb.CursoTIC
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCursosTIC(com.infotec.eworkplace.swb.CursoTIC value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCursosTIC, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined CursosTIC
       * @param value CursosTIC of the type com.infotec.eworkplace.swb.CursoTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCursosTIC,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Idioma
       * @param value Idioma of the type com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByIdioma(com.infotec.eworkplace.swb.Idioma value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasIdioma, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Idioma
       * @param value Idioma of the type com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByIdioma(com.infotec.eworkplace.swb.Idioma value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasIdioma,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined AreaTalento
       * @param value AreaTalento of the type com.infotec.eworkplace.swb.AreasTalento
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAreaTalento(com.infotec.eworkplace.swb.AreasTalento value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasAreaTalento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined AreaTalento
       * @param value AreaTalento of the type com.infotec.eworkplace.swb.AreasTalento
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAreaTalento(com.infotec.eworkplace.swb.AreasTalento value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasAreaTalento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined DocumentoProbatorio
       * @param value DocumentoProbatorio of the type com.infotec.eworkplace.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDocumentoProbatorio(com.infotec.eworkplace.swb.DocumentoProbatorio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDocumentoProbatorio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined DocumentoProbatorio
       * @param value DocumentoProbatorio of the type com.infotec.eworkplace.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDocumentoProbatorio(com.infotec.eworkplace.swb.DocumentoProbatorio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDocumentoProbatorio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ExperienciaLaboral
       * @param value ExperienciaLaboral of the type com.infotec.eworkplace.swb.ExperienciaLaboral
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByExperienciaLaboral(com.infotec.eworkplace.swb.ExperienciaLaboral value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasExperienciaLaboral, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ExperienciaLaboral
       * @param value ExperienciaLaboral of the type com.infotec.eworkplace.swb.ExperienciaLaboral
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByExperienciaLaboral(com.infotec.eworkplace.swb.ExperienciaLaboral value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasExperienciaLaboral,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Diplomado
       * @param value Diplomado of the type com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDiplomado(com.infotec.eworkplace.swb.Diplomado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDiplomado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Diplomado
       * @param value Diplomado of the type com.infotec.eworkplace.swb.Diplomado
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDiplomado(com.infotec.eworkplace.swb.Diplomado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDiplomado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Propietario
       * @param value Propietario of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPropietario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_propietario, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Propietario
       * @param value Propietario of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPropietario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_propietario,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_persona, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_persona,value.getSemanticObject(),sclass));
            return it;
        }
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
   * Gets all the com.infotec.eworkplace.swb.Distinciones
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Distinciones
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Distinciones> listDistincions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Distinciones>(getSemanticObject().listObjectProperties(intranet_hasDistincion));
    }

   /**
   * Gets true if has a Distincion
   * @param value com.infotec.eworkplace.swb.Distinciones to verify
   * @return true if the com.infotec.eworkplace.swb.Distinciones exists, false otherwise
   */
    public boolean hasDistincion(com.infotec.eworkplace.swb.Distinciones value)
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
   * @param value com.infotec.eworkplace.swb.Distinciones to add
   */

    public void addDistincion(com.infotec.eworkplace.swb.Distinciones value)
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
   * @param value com.infotec.eworkplace.swb.Distinciones to remove
   */

    public void removeDistincion(com.infotec.eworkplace.swb.Distinciones value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDistincion,value.getSemanticObject());
    }

   /**
   * Gets the Distincion
   * @return a com.infotec.eworkplace.swb.Distinciones
   */
    public com.infotec.eworkplace.swb.Distinciones getDistincion()
    {
         com.infotec.eworkplace.swb.Distinciones ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDistincion);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Distinciones)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Investigacion
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Investigacion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Investigacion> listInvestigacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Investigacion>(getSemanticObject().listObjectProperties(intranet_hasInvestigacion));
    }

   /**
   * Gets true if has a Investigacion
   * @param value com.infotec.eworkplace.swb.Investigacion to verify
   * @return true if the com.infotec.eworkplace.swb.Investigacion exists, false otherwise
   */
    public boolean hasInvestigacion(com.infotec.eworkplace.swb.Investigacion value)
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
   * @param value com.infotec.eworkplace.swb.Investigacion to add
   */

    public void addInvestigacion(com.infotec.eworkplace.swb.Investigacion value)
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
   * @param value com.infotec.eworkplace.swb.Investigacion to remove
   */

    public void removeInvestigacion(com.infotec.eworkplace.swb.Investigacion value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasInvestigacion,value.getSemanticObject());
    }

   /**
   * Gets the Investigacion
   * @return a com.infotec.eworkplace.swb.Investigacion
   */
    public com.infotec.eworkplace.swb.Investigacion getInvestigacion()
    {
         com.infotec.eworkplace.swb.Investigacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasInvestigacion);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Investigacion)obj.createGenericInstance();
         }
         return ret;
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

    public void setAcademia(com.infotec.eworkplace.swb.Academia value)
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
   * @return a com.infotec.eworkplace.swb.Academia
   */
    public com.infotec.eworkplace.swb.Academia getAcademia()
    {
         com.infotec.eworkplace.swb.Academia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_academia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Academia)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Competencia
   * @param value Competencia to set
   */

    public void setCompetencia(com.infotec.eworkplace.swb.Competencia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_competencia, value.getSemanticObject());
        }else
        {
            removeCompetencia();
        }
    }
   /**
   * Remove the value for Competencia property
   */

    public void removeCompetencia()
    {
        getSemanticObject().removeProperty(intranet_competencia);
    }

   /**
   * Gets the Competencia
   * @return a com.infotec.eworkplace.swb.Competencia
   */
    public com.infotec.eworkplace.swb.Competencia getCompetencia()
    {
         com.infotec.eworkplace.swb.Competencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_competencia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Competencia)obj.createGenericInstance();
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
   * Gets all the com.infotec.eworkplace.swb.Docencia
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Docencia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Docencia> listDocencias()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Docencia>(getSemanticObject().listObjectProperties(intranet_hasDocencia));
    }

   /**
   * Gets true if has a Docencia
   * @param value com.infotec.eworkplace.swb.Docencia to verify
   * @return true if the com.infotec.eworkplace.swb.Docencia exists, false otherwise
   */
    public boolean hasDocencia(com.infotec.eworkplace.swb.Docencia value)
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
   * @param value com.infotec.eworkplace.swb.Docencia to add
   */

    public void addDocencia(com.infotec.eworkplace.swb.Docencia value)
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
   * @param value com.infotec.eworkplace.swb.Docencia to remove
   */

    public void removeDocencia(com.infotec.eworkplace.swb.Docencia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDocencia,value.getSemanticObject());
    }

   /**
   * Gets the Docencia
   * @return a com.infotec.eworkplace.swb.Docencia
   */
    public com.infotec.eworkplace.swb.Docencia getDocencia()
    {
         com.infotec.eworkplace.swb.Docencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDocencia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Docencia)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Publicacion
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Publicacion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Publicacion> listPublicacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Publicacion>(getSemanticObject().listObjectProperties(intranet_hasPublicacion));
    }

   /**
   * Gets true if has a Publicacion
   * @param value com.infotec.eworkplace.swb.Publicacion to verify
   * @return true if the com.infotec.eworkplace.swb.Publicacion exists, false otherwise
   */
    public boolean hasPublicacion(com.infotec.eworkplace.swb.Publicacion value)
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
   * @param value com.infotec.eworkplace.swb.Publicacion to add
   */

    public void addPublicacion(com.infotec.eworkplace.swb.Publicacion value)
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
   * @param value com.infotec.eworkplace.swb.Publicacion to remove
   */

    public void removePublicacion(com.infotec.eworkplace.swb.Publicacion value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPublicacion,value.getSemanticObject());
    }

   /**
   * Gets the Publicacion
   * @return a com.infotec.eworkplace.swb.Publicacion
   */
    public com.infotec.eworkplace.swb.Publicacion getPublicacion()
    {
         com.infotec.eworkplace.swb.Publicacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPublicacion);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Publicacion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.CursoTIC
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.CursoTIC
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CursoTIC> listCursosTICs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CursoTIC>(getSemanticObject().listObjectProperties(intranet_hasCursosTIC));
    }

   /**
   * Gets true if has a CursosTIC
   * @param value com.infotec.eworkplace.swb.CursoTIC to verify
   * @return true if the com.infotec.eworkplace.swb.CursoTIC exists, false otherwise
   */
    public boolean hasCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
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
   * @param value com.infotec.eworkplace.swb.CursoTIC to add
   */

    public void addCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
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
   * @param value com.infotec.eworkplace.swb.CursoTIC to remove
   */

    public void removeCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCursosTIC,value.getSemanticObject());
    }

   /**
   * Gets the CursosTIC
   * @return a com.infotec.eworkplace.swb.CursoTIC
   */
    public com.infotec.eworkplace.swb.CursoTIC getCursosTIC()
    {
         com.infotec.eworkplace.swb.CursoTIC ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCursosTIC);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CursoTIC)obj.createGenericInstance();
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
   * Gets all the com.infotec.eworkplace.swb.Idioma
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Idioma
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> listIdiomas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(getSemanticObject().listObjectProperties(intranet_hasIdioma));
    }

   /**
   * Gets true if has a Idioma
   * @param value com.infotec.eworkplace.swb.Idioma to verify
   * @return true if the com.infotec.eworkplace.swb.Idioma exists, false otherwise
   */
    public boolean hasIdioma(com.infotec.eworkplace.swb.Idioma value)
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
   * @param value com.infotec.eworkplace.swb.Idioma to add
   */

    public void addIdioma(com.infotec.eworkplace.swb.Idioma value)
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
   * @param value com.infotec.eworkplace.swb.Idioma to remove
   */

    public void removeIdioma(com.infotec.eworkplace.swb.Idioma value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasIdioma,value.getSemanticObject());
    }

   /**
   * Gets the Idioma
   * @return a com.infotec.eworkplace.swb.Idioma
   */
    public com.infotec.eworkplace.swb.Idioma getIdioma()
    {
         com.infotec.eworkplace.swb.Idioma ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasIdioma);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Idioma)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.AreasTalento
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.AreasTalento
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AreasTalento> listAreaTalentos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AreasTalento>(getSemanticObject().listObjectProperties(intranet_hasAreaTalento));
    }

   /**
   * Gets true if has a AreaTalento
   * @param value com.infotec.eworkplace.swb.AreasTalento to verify
   * @return true if the com.infotec.eworkplace.swb.AreasTalento exists, false otherwise
   */
    public boolean hasAreaTalento(com.infotec.eworkplace.swb.AreasTalento value)
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
   * @param value com.infotec.eworkplace.swb.AreasTalento to add
   */

    public void addAreaTalento(com.infotec.eworkplace.swb.AreasTalento value)
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
   * @param value com.infotec.eworkplace.swb.AreasTalento to remove
   */

    public void removeAreaTalento(com.infotec.eworkplace.swb.AreasTalento value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasAreaTalento,value.getSemanticObject());
    }

   /**
   * Gets the AreaTalento
   * @return a com.infotec.eworkplace.swb.AreasTalento
   */
    public com.infotec.eworkplace.swb.AreasTalento getAreaTalento()
    {
         com.infotec.eworkplace.swb.AreasTalento ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasAreaTalento);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.AreasTalento)obj.createGenericInstance();
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
   * Gets all the com.infotec.eworkplace.swb.DocumentoProbatorio
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.DocumentoProbatorio
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio> listDocumentoProbatorios()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.DocumentoProbatorio>(getSemanticObject().listObjectProperties(intranet_hasDocumentoProbatorio));
    }

   /**
   * Gets true if has a DocumentoProbatorio
   * @param value com.infotec.eworkplace.swb.DocumentoProbatorio to verify
   * @return true if the com.infotec.eworkplace.swb.DocumentoProbatorio exists, false otherwise
   */
    public boolean hasDocumentoProbatorio(com.infotec.eworkplace.swb.DocumentoProbatorio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDocumentoProbatorio,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DocumentoProbatorio
   * @param value com.infotec.eworkplace.swb.DocumentoProbatorio to add
   */

    public void addDocumentoProbatorio(com.infotec.eworkplace.swb.DocumentoProbatorio value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDocumentoProbatorio, value.getSemanticObject());
    }
   /**
   * Removes all the DocumentoProbatorio
   */

    public void removeAllDocumentoProbatorio()
    {
        getSemanticObject().removeProperty(intranet_hasDocumentoProbatorio);
    }
   /**
   * Removes a DocumentoProbatorio
   * @param value com.infotec.eworkplace.swb.DocumentoProbatorio to remove
   */

    public void removeDocumentoProbatorio(com.infotec.eworkplace.swb.DocumentoProbatorio value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDocumentoProbatorio,value.getSemanticObject());
    }

   /**
   * Gets the DocumentoProbatorio
   * @return a com.infotec.eworkplace.swb.DocumentoProbatorio
   */
    public com.infotec.eworkplace.swb.DocumentoProbatorio getDocumentoProbatorio()
    {
         com.infotec.eworkplace.swb.DocumentoProbatorio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDocumentoProbatorio);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.DocumentoProbatorio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.ExperienciaLaboral
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.ExperienciaLaboral
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral> listExperienciaLaborals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ExperienciaLaboral>(getSemanticObject().listObjectProperties(intranet_hasExperienciaLaboral));
    }

   /**
   * Gets true if has a ExperienciaLaboral
   * @param value com.infotec.eworkplace.swb.ExperienciaLaboral to verify
   * @return true if the com.infotec.eworkplace.swb.ExperienciaLaboral exists, false otherwise
   */
    public boolean hasExperienciaLaboral(com.infotec.eworkplace.swb.ExperienciaLaboral value)
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
   * @param value com.infotec.eworkplace.swb.ExperienciaLaboral to add
   */

    public void addExperienciaLaboral(com.infotec.eworkplace.swb.ExperienciaLaboral value)
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
   * @param value com.infotec.eworkplace.swb.ExperienciaLaboral to remove
   */

    public void removeExperienciaLaboral(com.infotec.eworkplace.swb.ExperienciaLaboral value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasExperienciaLaboral,value.getSemanticObject());
    }

   /**
   * Gets the ExperienciaLaboral
   * @return a com.infotec.eworkplace.swb.ExperienciaLaboral
   */
    public com.infotec.eworkplace.swb.ExperienciaLaboral getExperienciaLaboral()
    {
         com.infotec.eworkplace.swb.ExperienciaLaboral ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasExperienciaLaboral);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.ExperienciaLaboral)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Diplomado
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Diplomado
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(getSemanticObject().listObjectProperties(intranet_hasDiplomado));
    }

   /**
   * Gets true if has a Diplomado
   * @param value com.infotec.eworkplace.swb.Diplomado to verify
   * @return true if the com.infotec.eworkplace.swb.Diplomado exists, false otherwise
   */
    public boolean hasDiplomado(com.infotec.eworkplace.swb.Diplomado value)
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
   * @param value com.infotec.eworkplace.swb.Diplomado to add
   */

    public void addDiplomado(com.infotec.eworkplace.swb.Diplomado value)
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
   * @param value com.infotec.eworkplace.swb.Diplomado to remove
   */

    public void removeDiplomado(com.infotec.eworkplace.swb.Diplomado value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDiplomado,value.getSemanticObject());
    }

   /**
   * Gets the Diplomado
   * @return a com.infotec.eworkplace.swb.Diplomado
   */
    public com.infotec.eworkplace.swb.Diplomado getDiplomado()
    {
         com.infotec.eworkplace.swb.Diplomado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDiplomado);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Diplomado)obj.createGenericInstance();
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
