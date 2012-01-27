package com.infotec.eworkplace.swb.base;


public abstract class AutoevaluacionBase extends com.infotec.eworkplace.swb.Competencia 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Nivel");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelCompTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelCompTecnica");
    public static final org.semanticwb.platform.SemanticClass intranet_VigenciaCertificado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#VigenciaCertificado");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaCompInstitucional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaCompInstitucional");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaCompComportamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaCompComportamiento");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelCompInstitucional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelCompInstitucional");
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasComportamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasComportamiento");
    public static final org.semanticwb.platform.SemanticProperty intranet_competenciaComportamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competenciaComportamiento");
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasInstitucionales=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasInstitucionales");
    public static final org.semanticwb.platform.SemanticProperty intranet_competenciaInstitucional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competenciaInstitucional");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelCompDesempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelCompDesempenio");
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasDesempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasDesempenio");
    public static final org.semanticwb.platform.SemanticProperty intranet_competenciaDesempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competenciaDesempenio");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaCompDesempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaCompDesempenio");
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasTecnicas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasTecnicas");
    public static final org.semanticwb.platform.SemanticProperty intranet_competenciaTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competenciaTecnica");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelCompComportamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelCompComportamiento");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaCompTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaCompTecnica");
    public static final org.semanticwb.platform.SemanticClass intranet_Autoevaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Autoevaluacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Autoevaluacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Autoevaluacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Autoevaluacion for all models
       * @return Iterator of com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion>(it, true);
        }

        public static com.infotec.eworkplace.swb.Autoevaluacion createAutoevaluacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Autoevaluacion.ClassMgr.createAutoevaluacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Autoevaluacion
       * @param id Identifier for com.infotec.eworkplace.swb.Autoevaluacion
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return A com.infotec.eworkplace.swb.Autoevaluacion
       */
        public static com.infotec.eworkplace.swb.Autoevaluacion getAutoevaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Autoevaluacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Autoevaluacion
       * @param id Identifier for com.infotec.eworkplace.swb.Autoevaluacion
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return A com.infotec.eworkplace.swb.Autoevaluacion
       */
        public static com.infotec.eworkplace.swb.Autoevaluacion createAutoevaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Autoevaluacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Autoevaluacion
       * @param id Identifier for com.infotec.eworkplace.swb.Autoevaluacion
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       */
        public static void removeAutoevaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Autoevaluacion
       * @param id Identifier for com.infotec.eworkplace.swb.Autoevaluacion
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return true if the com.infotec.eworkplace.swb.Autoevaluacion exists, false otherwise
       */

        public static boolean hasAutoevaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAutoevaluacion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompTecnica
       * @param value NivelCompTecnica of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompTecnica(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompTecnica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompTecnica
       * @param value NivelCompTecnica of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompTecnica(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompTecnica,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompInstitucional
       * @param value VigenciaCompInstitucional of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompInstitucional(com.infotec.eworkplace.swb.VigenciaCertificado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompInstitucional, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompInstitucional
       * @param value VigenciaCompInstitucional of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompInstitucional(com.infotec.eworkplace.swb.VigenciaCertificado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompInstitucional,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompComportamiento
       * @param value VigenciaCompComportamiento of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompComportamiento(com.infotec.eworkplace.swb.VigenciaCertificado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompComportamiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompComportamiento
       * @param value VigenciaCompComportamiento of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompComportamiento(com.infotec.eworkplace.swb.VigenciaCertificado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompComportamiento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompInstitucional
       * @param value NivelCompInstitucional of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompInstitucional(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompInstitucional, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompInstitucional
       * @param value NivelCompInstitucional of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompInstitucional(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompInstitucional,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaComportamiento
       * @param value CompetenciaComportamiento of the type com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaComportamiento(com.infotec.eworkplace.swb.CompetenciasComportamiento value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaComportamiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaComportamiento
       * @param value CompetenciaComportamiento of the type com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaComportamiento(com.infotec.eworkplace.swb.CompetenciasComportamiento value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaComportamiento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaInstitucional
       * @param value CompetenciaInstitucional of the type com.infotec.eworkplace.swb.CompetenciasInstitucionales
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaInstitucional(com.infotec.eworkplace.swb.CompetenciasInstitucionales value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaInstitucional, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaInstitucional
       * @param value CompetenciaInstitucional of the type com.infotec.eworkplace.swb.CompetenciasInstitucionales
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaInstitucional(com.infotec.eworkplace.swb.CompetenciasInstitucionales value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaInstitucional,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompDesempenio
       * @param value NivelCompDesempenio of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompDesempenio(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompDesempenio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompDesempenio
       * @param value NivelCompDesempenio of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompDesempenio(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompDesempenio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaDesempenio
       * @param value CompetenciaDesempenio of the type com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaDesempenio(com.infotec.eworkplace.swb.CompetenciasDesempenio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaDesempenio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaDesempenio
       * @param value CompetenciaDesempenio of the type com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaDesempenio(com.infotec.eworkplace.swb.CompetenciasDesempenio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaDesempenio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompDesempenio
       * @param value VigenciaCompDesempenio of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompDesempenio(com.infotec.eworkplace.swb.VigenciaCertificado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompDesempenio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompDesempenio
       * @param value VigenciaCompDesempenio of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompDesempenio(com.infotec.eworkplace.swb.VigenciaCertificado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompDesempenio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaTecnica
       * @param value CompetenciaTecnica of the type com.infotec.eworkplace.swb.CompetenciasTecnicas
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaTecnica(com.infotec.eworkplace.swb.CompetenciasTecnicas value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaTecnica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined CompetenciaTecnica
       * @param value CompetenciaTecnica of the type com.infotec.eworkplace.swb.CompetenciasTecnicas
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByCompetenciaTecnica(com.infotec.eworkplace.swb.CompetenciasTecnicas value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_competenciaTecnica,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompComportamiento
       * @param value NivelCompComportamiento of the type com.infotec.eworkplace.swb.Nivel
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompComportamiento(com.infotec.eworkplace.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompComportamiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined NivelCompComportamiento
       * @param value NivelCompComportamiento of the type com.infotec.eworkplace.swb.Nivel
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByNivelCompComportamiento(com.infotec.eworkplace.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelCompComportamiento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompTecnica
       * @param value VigenciaCompTecnica of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @param model Model of the com.infotec.eworkplace.swb.Autoevaluacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompTecnica(com.infotec.eworkplace.swb.VigenciaCertificado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompTecnica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Autoevaluacion with a determined VigenciaCompTecnica
       * @param value VigenciaCompTecnica of the type com.infotec.eworkplace.swb.VigenciaCertificado
       * @return Iterator with all the com.infotec.eworkplace.swb.Autoevaluacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Autoevaluacion> listAutoevaluacionByVigenciaCompTecnica(com.infotec.eworkplace.swb.VigenciaCertificado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Autoevaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_vigenciaCompTecnica,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AutoevaluacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Autoevaluacion
   */
    public AutoevaluacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property NivelCompTecnica
   * @param value NivelCompTecnica to set
   */

    public void setNivelCompTecnica(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelCompTecnica, value.getSemanticObject());
        }else
        {
            removeNivelCompTecnica();
        }
    }
   /**
   * Remove the value for NivelCompTecnica property
   */

    public void removeNivelCompTecnica()
    {
        getSemanticObject().removeProperty(intranet_nivelCompTecnica);
    }

   /**
   * Gets the NivelCompTecnica
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelCompTecnica()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelCompTecnica);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property VigenciaCompInstitucional
   * @param value VigenciaCompInstitucional to set
   */

    public void setVigenciaCompInstitucional(com.infotec.eworkplace.swb.VigenciaCertificado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_vigenciaCompInstitucional, value.getSemanticObject());
        }else
        {
            removeVigenciaCompInstitucional();
        }
    }
   /**
   * Remove the value for VigenciaCompInstitucional property
   */

    public void removeVigenciaCompInstitucional()
    {
        getSemanticObject().removeProperty(intranet_vigenciaCompInstitucional);
    }

   /**
   * Gets the VigenciaCompInstitucional
   * @return a com.infotec.eworkplace.swb.VigenciaCertificado
   */
    public com.infotec.eworkplace.swb.VigenciaCertificado getVigenciaCompInstitucional()
    {
         com.infotec.eworkplace.swb.VigenciaCertificado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_vigenciaCompInstitucional);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.VigenciaCertificado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property VigenciaCompComportamiento
   * @param value VigenciaCompComportamiento to set
   */

    public void setVigenciaCompComportamiento(com.infotec.eworkplace.swb.VigenciaCertificado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_vigenciaCompComportamiento, value.getSemanticObject());
        }else
        {
            removeVigenciaCompComportamiento();
        }
    }
   /**
   * Remove the value for VigenciaCompComportamiento property
   */

    public void removeVigenciaCompComportamiento()
    {
        getSemanticObject().removeProperty(intranet_vigenciaCompComportamiento);
    }

   /**
   * Gets the VigenciaCompComportamiento
   * @return a com.infotec.eworkplace.swb.VigenciaCertificado
   */
    public com.infotec.eworkplace.swb.VigenciaCertificado getVigenciaCompComportamiento()
    {
         com.infotec.eworkplace.swb.VigenciaCertificado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_vigenciaCompComportamiento);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.VigenciaCertificado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelCompInstitucional
   * @param value NivelCompInstitucional to set
   */

    public void setNivelCompInstitucional(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelCompInstitucional, value.getSemanticObject());
        }else
        {
            removeNivelCompInstitucional();
        }
    }
   /**
   * Remove the value for NivelCompInstitucional property
   */

    public void removeNivelCompInstitucional()
    {
        getSemanticObject().removeProperty(intranet_nivelCompInstitucional);
    }

   /**
   * Gets the NivelCompInstitucional
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelCompInstitucional()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelCompInstitucional);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property CompetenciaComportamiento
   * @param value CompetenciaComportamiento to set
   */

    public void setCompetenciaComportamiento(com.infotec.eworkplace.swb.CompetenciasComportamiento value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_competenciaComportamiento, value.getSemanticObject());
        }else
        {
            removeCompetenciaComportamiento();
        }
    }
   /**
   * Remove the value for CompetenciaComportamiento property
   */

    public void removeCompetenciaComportamiento()
    {
        getSemanticObject().removeProperty(intranet_competenciaComportamiento);
    }

   /**
   * Gets the CompetenciaComportamiento
   * @return a com.infotec.eworkplace.swb.CompetenciasComportamiento
   */
    public com.infotec.eworkplace.swb.CompetenciasComportamiento getCompetenciaComportamiento()
    {
         com.infotec.eworkplace.swb.CompetenciasComportamiento ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_competenciaComportamiento);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CompetenciasComportamiento)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property CompetenciaInstitucional
   * @param value CompetenciaInstitucional to set
   */

    public void setCompetenciaInstitucional(com.infotec.eworkplace.swb.CompetenciasInstitucionales value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_competenciaInstitucional, value.getSemanticObject());
        }else
        {
            removeCompetenciaInstitucional();
        }
    }
   /**
   * Remove the value for CompetenciaInstitucional property
   */

    public void removeCompetenciaInstitucional()
    {
        getSemanticObject().removeProperty(intranet_competenciaInstitucional);
    }

   /**
   * Gets the CompetenciaInstitucional
   * @return a com.infotec.eworkplace.swb.CompetenciasInstitucionales
   */
    public com.infotec.eworkplace.swb.CompetenciasInstitucionales getCompetenciaInstitucional()
    {
         com.infotec.eworkplace.swb.CompetenciasInstitucionales ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_competenciaInstitucional);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CompetenciasInstitucionales)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelCompDesempenio
   * @param value NivelCompDesempenio to set
   */

    public void setNivelCompDesempenio(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelCompDesempenio, value.getSemanticObject());
        }else
        {
            removeNivelCompDesempenio();
        }
    }
   /**
   * Remove the value for NivelCompDesempenio property
   */

    public void removeNivelCompDesempenio()
    {
        getSemanticObject().removeProperty(intranet_nivelCompDesempenio);
    }

   /**
   * Gets the NivelCompDesempenio
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelCompDesempenio()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelCompDesempenio);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property CompetenciaDesempenio
   * @param value CompetenciaDesempenio to set
   */

    public void setCompetenciaDesempenio(com.infotec.eworkplace.swb.CompetenciasDesempenio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_competenciaDesempenio, value.getSemanticObject());
        }else
        {
            removeCompetenciaDesempenio();
        }
    }
   /**
   * Remove the value for CompetenciaDesempenio property
   */

    public void removeCompetenciaDesempenio()
    {
        getSemanticObject().removeProperty(intranet_competenciaDesempenio);
    }

   /**
   * Gets the CompetenciaDesempenio
   * @return a com.infotec.eworkplace.swb.CompetenciasDesempenio
   */
    public com.infotec.eworkplace.swb.CompetenciasDesempenio getCompetenciaDesempenio()
    {
         com.infotec.eworkplace.swb.CompetenciasDesempenio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_competenciaDesempenio);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CompetenciasDesempenio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property VigenciaCompDesempenio
   * @param value VigenciaCompDesempenio to set
   */

    public void setVigenciaCompDesempenio(com.infotec.eworkplace.swb.VigenciaCertificado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_vigenciaCompDesempenio, value.getSemanticObject());
        }else
        {
            removeVigenciaCompDesempenio();
        }
    }
   /**
   * Remove the value for VigenciaCompDesempenio property
   */

    public void removeVigenciaCompDesempenio()
    {
        getSemanticObject().removeProperty(intranet_vigenciaCompDesempenio);
    }

   /**
   * Gets the VigenciaCompDesempenio
   * @return a com.infotec.eworkplace.swb.VigenciaCertificado
   */
    public com.infotec.eworkplace.swb.VigenciaCertificado getVigenciaCompDesempenio()
    {
         com.infotec.eworkplace.swb.VigenciaCertificado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_vigenciaCompDesempenio);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.VigenciaCertificado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property CompetenciaTecnica
   * @param value CompetenciaTecnica to set
   */

    public void setCompetenciaTecnica(com.infotec.eworkplace.swb.CompetenciasTecnicas value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_competenciaTecnica, value.getSemanticObject());
        }else
        {
            removeCompetenciaTecnica();
        }
    }
   /**
   * Remove the value for CompetenciaTecnica property
   */

    public void removeCompetenciaTecnica()
    {
        getSemanticObject().removeProperty(intranet_competenciaTecnica);
    }

   /**
   * Gets the CompetenciaTecnica
   * @return a com.infotec.eworkplace.swb.CompetenciasTecnicas
   */
    public com.infotec.eworkplace.swb.CompetenciasTecnicas getCompetenciaTecnica()
    {
         com.infotec.eworkplace.swb.CompetenciasTecnicas ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_competenciaTecnica);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CompetenciasTecnicas)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelCompComportamiento
   * @param value NivelCompComportamiento to set
   */

    public void setNivelCompComportamiento(com.infotec.eworkplace.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelCompComportamiento, value.getSemanticObject());
        }else
        {
            removeNivelCompComportamiento();
        }
    }
   /**
   * Remove the value for NivelCompComportamiento property
   */

    public void removeNivelCompComportamiento()
    {
        getSemanticObject().removeProperty(intranet_nivelCompComportamiento);
    }

   /**
   * Gets the NivelCompComportamiento
   * @return a com.infotec.eworkplace.swb.Nivel
   */
    public com.infotec.eworkplace.swb.Nivel getNivelCompComportamiento()
    {
         com.infotec.eworkplace.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelCompComportamiento);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property VigenciaCompTecnica
   * @param value VigenciaCompTecnica to set
   */

    public void setVigenciaCompTecnica(com.infotec.eworkplace.swb.VigenciaCertificado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_vigenciaCompTecnica, value.getSemanticObject());
        }else
        {
            removeVigenciaCompTecnica();
        }
    }
   /**
   * Remove the value for VigenciaCompTecnica property
   */

    public void removeVigenciaCompTecnica()
    {
        getSemanticObject().removeProperty(intranet_vigenciaCompTecnica);
    }

   /**
   * Gets the VigenciaCompTecnica
   * @return a com.infotec.eworkplace.swb.VigenciaCertificado
   */
    public com.infotec.eworkplace.swb.VigenciaCertificado getVigenciaCompTecnica()
    {
         com.infotec.eworkplace.swb.VigenciaCertificado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_vigenciaCompTecnica);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.VigenciaCertificado)obj.createGenericInstance();
         }
         return ret;
    }
}
