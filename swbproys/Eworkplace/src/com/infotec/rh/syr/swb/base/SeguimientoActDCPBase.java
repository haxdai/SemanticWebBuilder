package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de seguimiento al proceso DCP de RH 
   */
public abstract class SeguimientoActDCPBase extends com.infotec.eworkplace.swb.Seguimiento implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Adminsitra las actividades para CCO; DCP, ACD de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_ActividadesArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ActividadesArea");
   /**
   * Reporte de incidencias para DCP
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReporteIncidencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReporteIncidencias");
   /**
   * Justificación técnica
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasJustificacionTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasJustificacionTecnica");
   /**
   * Programa de capacitación
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasProgramaCapacitacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasProgramaCapacitacion");
   /**
   * Necesidades de estrategicas y de capacitación
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasNecesidadesEstrategicasCapacitacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasNecesidadesEstrategicasCapacitacion");
   /**
   * Plan de desarrollo personal
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPlanDesarrolloPersonal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPlanDesarrolloPersonal");
   /**
   * Requisición para DCP
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasRequisicion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasRequisicion");
   /**
   * Cuestionario DNC
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCuestionarioDNC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCuestionarioDNC");
   /**
   * Plan de capacitación
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPlanCapacitacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPlanCapacitacion");
   /**
   * Diagrama de Grantt
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasGantt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasGantt");
   /**
   * Programa anual
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasProgramaAnual=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasProgramaAnual");
   /**
   * Calendario provisional
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCalendarioProvisional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCalendarioProvisional");
   /**
   * Reporte periodico del plan para DCP
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReportePeriodico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReportePeriodico");
   /**
   * Reporte ejecutivo
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReporteEjecutivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReporteEjecutivo");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioDCP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioDCP");
   /**
   * Resultados de evaluación para DCP
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasResultadosEvaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasResultadosEvaluacion");
   /**
   * Solicitud de registro para DCP
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasSolicitudRegistro=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasSolicitudRegistro");
   /**
   * Encapsula las propiedades de seguimiento al proceso DCP de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SeguimientoActDCP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoActDCP");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoActDCP");

    public static class ClassMgr
    {
       /**
       * Returns a list of SeguimientoActDCP for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SeguimientoActDCP for all models
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP>(it, true);
        }

        public static com.infotec.rh.syr.swb.SeguimientoActDCP createSeguimientoActDCP(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SeguimientoActDCP.ClassMgr.createSeguimientoActDCP(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return A com.infotec.rh.syr.swb.SeguimientoActDCP
       */
        public static com.infotec.rh.syr.swb.SeguimientoActDCP getSeguimientoActDCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoActDCP)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return A com.infotec.rh.syr.swb.SeguimientoActDCP
       */
        public static com.infotec.rh.syr.swb.SeguimientoActDCP createSeguimientoActDCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoActDCP)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       */
        public static void removeSeguimientoActDCP(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActDCP
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return true if the com.infotec.rh.syr.swb.SeguimientoActDCP exists, false otherwise
       */

        public static boolean hasSeguimientoActDCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeguimientoActDCP(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ReporteIncidencias
       * @param value ReporteIncidencias of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByReporteIncidencias(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteIncidencias, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ReporteIncidencias
       * @param value ReporteIncidencias of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByReporteIncidencias(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteIncidencias,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined JustificacionTecnica
       * @param value JustificacionTecnica of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByJustificacionTecnica(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasJustificacionTecnica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined JustificacionTecnica
       * @param value JustificacionTecnica of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByJustificacionTecnica(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasJustificacionTecnica,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ProgramaCapacitacion
       * @param value ProgramaCapacitacion of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByProgramaCapacitacion(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasProgramaCapacitacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ProgramaCapacitacion
       * @param value ProgramaCapacitacion of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByProgramaCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasProgramaCapacitacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined NecesidadesEstrategicasCapacitacion
       * @param value NecesidadesEstrategicasCapacitacion of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByNecesidadesEstrategicasCapacitacion(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasNecesidadesEstrategicasCapacitacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined NecesidadesEstrategicasCapacitacion
       * @param value NecesidadesEstrategicasCapacitacion of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByNecesidadesEstrategicasCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasNecesidadesEstrategicasCapacitacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined PlanDesarrolloPersonal
       * @param value PlanDesarrolloPersonal of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByPlanDesarrolloPersonal(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanDesarrolloPersonal, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined PlanDesarrolloPersonal
       * @param value PlanDesarrolloPersonal of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByPlanDesarrolloPersonal(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanDesarrolloPersonal,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined Requisicion
       * @param value Requisicion of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByRequisicion(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasRequisicion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined Requisicion
       * @param value Requisicion of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByRequisicion(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasRequisicion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined CuestionarioDNC
       * @param value CuestionarioDNC of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByCuestionarioDNC(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCuestionarioDNC, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined CuestionarioDNC
       * @param value CuestionarioDNC of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByCuestionarioDNC(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCuestionarioDNC,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined PlanCapacitacion
       * @param value PlanCapacitacion of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByPlanCapacitacion(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanCapacitacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined PlanCapacitacion
       * @param value PlanCapacitacion of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByPlanCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanCapacitacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined Gantt
       * @param value Gantt of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByGantt(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGantt, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined Gantt
       * @param value Gantt of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByGantt(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGantt,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ProgramaAnual
       * @param value ProgramaAnual of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByProgramaAnual(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasProgramaAnual, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ProgramaAnual
       * @param value ProgramaAnual of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByProgramaAnual(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasProgramaAnual,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined CalendarioProvisional
       * @param value CalendarioProvisional of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByCalendarioProvisional(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCalendarioProvisional, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined CalendarioProvisional
       * @param value CalendarioProvisional of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByCalendarioProvisional(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCalendarioProvisional,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ReportePeriodico
       * @param value ReportePeriodico of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByReportePeriodico(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReportePeriodico, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ReportePeriodico
       * @param value ReportePeriodico of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByReportePeriodico(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReportePeriodico,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ReporteEjecutivo
       * @param value ReporteEjecutivo of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByReporteEjecutivo(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteEjecutivo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ReporteEjecutivo
       * @param value ReporteEjecutivo of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByReporteEjecutivo(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteEjecutivo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ResultadosEvaluacion
       * @param value ResultadosEvaluacion of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByResultadosEvaluacion(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasResultadosEvaluacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined ResultadosEvaluacion
       * @param value ResultadosEvaluacion of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPByResultadosEvaluacion(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasResultadosEvaluacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined SolicitudRegistro
       * @param value SolicitudRegistro of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActDCP
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPBySolicitudRegistro(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasSolicitudRegistro, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActDCP with a determined SolicitudRegistro
       * @param value SolicitudRegistro of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActDCP
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActDCP> listSeguimientoActDCPBySolicitudRegistro(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActDCP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasSolicitudRegistro,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SeguimientoActDCPBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SeguimientoActDCP
   */
    public SeguimientoActDCPBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listReporteIncidenciases()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasReporteIncidencias));
    }

   /**
   * Gets true if has a ReporteIncidencias
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasReporteIncidencias(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReporteIncidencias,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReporteIncidencias
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addReporteIncidencias(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReporteIncidencias, value.getSemanticObject());
    }
   /**
   * Removes all the ReporteIncidencias
   */

    public void removeAllReporteIncidencias()
    {
        getSemanticObject().removeProperty(intranet_hasReporteIncidencias);
    }
   /**
   * Removes a ReporteIncidencias
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeReporteIncidencias(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReporteIncidencias,value.getSemanticObject());
    }

   /**
   * Gets the ReporteIncidencias
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getReporteIncidencias()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReporteIncidencias);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listJustificacionTecnicas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasJustificacionTecnica));
    }

   /**
   * Gets true if has a JustificacionTecnica
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasJustificacionTecnica(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasJustificacionTecnica,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a JustificacionTecnica
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addJustificacionTecnica(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasJustificacionTecnica, value.getSemanticObject());
    }
   /**
   * Removes all the JustificacionTecnica
   */

    public void removeAllJustificacionTecnica()
    {
        getSemanticObject().removeProperty(intranet_hasJustificacionTecnica);
    }
   /**
   * Removes a JustificacionTecnica
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeJustificacionTecnica(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasJustificacionTecnica,value.getSemanticObject());
    }

   /**
   * Gets the JustificacionTecnica
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getJustificacionTecnica()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasJustificacionTecnica);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listProgramaCapacitacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasProgramaCapacitacion));
    }

   /**
   * Gets true if has a ProgramaCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasProgramaCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasProgramaCapacitacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ProgramaCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addProgramaCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasProgramaCapacitacion, value.getSemanticObject());
    }
   /**
   * Removes all the ProgramaCapacitacion
   */

    public void removeAllProgramaCapacitacion()
    {
        getSemanticObject().removeProperty(intranet_hasProgramaCapacitacion);
    }
   /**
   * Removes a ProgramaCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeProgramaCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasProgramaCapacitacion,value.getSemanticObject());
    }

   /**
   * Gets the ProgramaCapacitacion
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getProgramaCapacitacion()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasProgramaCapacitacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listNecesidadesEstrategicasCapacitacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasNecesidadesEstrategicasCapacitacion));
    }

   /**
   * Gets true if has a NecesidadesEstrategicasCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasNecesidadesEstrategicasCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasNecesidadesEstrategicasCapacitacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a NecesidadesEstrategicasCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addNecesidadesEstrategicasCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasNecesidadesEstrategicasCapacitacion, value.getSemanticObject());
    }
   /**
   * Removes all the NecesidadesEstrategicasCapacitacion
   */

    public void removeAllNecesidadesEstrategicasCapacitacion()
    {
        getSemanticObject().removeProperty(intranet_hasNecesidadesEstrategicasCapacitacion);
    }
   /**
   * Removes a NecesidadesEstrategicasCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeNecesidadesEstrategicasCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasNecesidadesEstrategicasCapacitacion,value.getSemanticObject());
    }

   /**
   * Gets the NecesidadesEstrategicasCapacitacion
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getNecesidadesEstrategicasCapacitacion()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasNecesidadesEstrategicasCapacitacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listPlanDesarrolloPersonals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasPlanDesarrolloPersonal));
    }

   /**
   * Gets true if has a PlanDesarrolloPersonal
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasPlanDesarrolloPersonal(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPlanDesarrolloPersonal,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PlanDesarrolloPersonal
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addPlanDesarrolloPersonal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPlanDesarrolloPersonal, value.getSemanticObject());
    }
   /**
   * Removes all the PlanDesarrolloPersonal
   */

    public void removeAllPlanDesarrolloPersonal()
    {
        getSemanticObject().removeProperty(intranet_hasPlanDesarrolloPersonal);
    }
   /**
   * Removes a PlanDesarrolloPersonal
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removePlanDesarrolloPersonal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPlanDesarrolloPersonal,value.getSemanticObject());
    }

   /**
   * Gets the PlanDesarrolloPersonal
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getPlanDesarrolloPersonal()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPlanDesarrolloPersonal);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listRequisicions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasRequisicion));
    }

   /**
   * Gets true if has a Requisicion
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasRequisicion(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasRequisicion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Requisicion
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addRequisicion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasRequisicion, value.getSemanticObject());
    }
   /**
   * Removes all the Requisicion
   */

    public void removeAllRequisicion()
    {
        getSemanticObject().removeProperty(intranet_hasRequisicion);
    }
   /**
   * Removes a Requisicion
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeRequisicion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasRequisicion,value.getSemanticObject());
    }

   /**
   * Gets the Requisicion
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getRequisicion()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasRequisicion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listCuestionarioDNCs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasCuestionarioDNC));
    }

   /**
   * Gets true if has a CuestionarioDNC
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasCuestionarioDNC(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCuestionarioDNC,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CuestionarioDNC
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addCuestionarioDNC(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCuestionarioDNC, value.getSemanticObject());
    }
   /**
   * Removes all the CuestionarioDNC
   */

    public void removeAllCuestionarioDNC()
    {
        getSemanticObject().removeProperty(intranet_hasCuestionarioDNC);
    }
   /**
   * Removes a CuestionarioDNC
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeCuestionarioDNC(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCuestionarioDNC,value.getSemanticObject());
    }

   /**
   * Gets the CuestionarioDNC
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getCuestionarioDNC()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCuestionarioDNC);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listPlanCapacitacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasPlanCapacitacion));
    }

   /**
   * Gets true if has a PlanCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasPlanCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPlanCapacitacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PlanCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addPlanCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPlanCapacitacion, value.getSemanticObject());
    }
   /**
   * Removes all the PlanCapacitacion
   */

    public void removeAllPlanCapacitacion()
    {
        getSemanticObject().removeProperty(intranet_hasPlanCapacitacion);
    }
   /**
   * Removes a PlanCapacitacion
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removePlanCapacitacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPlanCapacitacion,value.getSemanticObject());
    }

   /**
   * Gets the PlanCapacitacion
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getPlanCapacitacion()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPlanCapacitacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listGantts()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasGantt));
    }

   /**
   * Gets true if has a Gantt
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasGantt(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasGantt,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Gantt
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addGantt(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasGantt, value.getSemanticObject());
    }
   /**
   * Removes all the Gantt
   */

    public void removeAllGantt()
    {
        getSemanticObject().removeProperty(intranet_hasGantt);
    }
   /**
   * Removes a Gantt
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeGantt(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasGantt,value.getSemanticObject());
    }

   /**
   * Gets the Gantt
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getGantt()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasGantt);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listProgramaAnuals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasProgramaAnual));
    }

   /**
   * Gets true if has a ProgramaAnual
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasProgramaAnual(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasProgramaAnual,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ProgramaAnual
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addProgramaAnual(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasProgramaAnual, value.getSemanticObject());
    }
   /**
   * Removes all the ProgramaAnual
   */

    public void removeAllProgramaAnual()
    {
        getSemanticObject().removeProperty(intranet_hasProgramaAnual);
    }
   /**
   * Removes a ProgramaAnual
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeProgramaAnual(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasProgramaAnual,value.getSemanticObject());
    }

   /**
   * Gets the ProgramaAnual
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getProgramaAnual()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasProgramaAnual);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listCalendarioProvisionals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasCalendarioProvisional));
    }

   /**
   * Gets true if has a CalendarioProvisional
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasCalendarioProvisional(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCalendarioProvisional,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CalendarioProvisional
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addCalendarioProvisional(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCalendarioProvisional, value.getSemanticObject());
    }
   /**
   * Removes all the CalendarioProvisional
   */

    public void removeAllCalendarioProvisional()
    {
        getSemanticObject().removeProperty(intranet_hasCalendarioProvisional);
    }
   /**
   * Removes a CalendarioProvisional
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeCalendarioProvisional(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCalendarioProvisional,value.getSemanticObject());
    }

   /**
   * Gets the CalendarioProvisional
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getCalendarioProvisional()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCalendarioProvisional);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listReportePeriodicos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasReportePeriodico));
    }

   /**
   * Gets true if has a ReportePeriodico
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasReportePeriodico(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReportePeriodico,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReportePeriodico
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addReportePeriodico(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReportePeriodico, value.getSemanticObject());
    }
   /**
   * Removes all the ReportePeriodico
   */

    public void removeAllReportePeriodico()
    {
        getSemanticObject().removeProperty(intranet_hasReportePeriodico);
    }
   /**
   * Removes a ReportePeriodico
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeReportePeriodico(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReportePeriodico,value.getSemanticObject());
    }

   /**
   * Gets the ReportePeriodico
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getReportePeriodico()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReportePeriodico);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listReporteEjecutivos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasReporteEjecutivo));
    }

   /**
   * Gets true if has a ReporteEjecutivo
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasReporteEjecutivo(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReporteEjecutivo,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReporteEjecutivo
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addReporteEjecutivo(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReporteEjecutivo, value.getSemanticObject());
    }
   /**
   * Removes all the ReporteEjecutivo
   */

    public void removeAllReporteEjecutivo()
    {
        getSemanticObject().removeProperty(intranet_hasReporteEjecutivo);
    }
   /**
   * Removes a ReporteEjecutivo
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeReporteEjecutivo(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReporteEjecutivo,value.getSemanticObject());
    }

   /**
   * Gets the ReporteEjecutivo
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getReporteEjecutivo()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReporteEjecutivo);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FolioDCP property
* @return String with the FolioDCP
*/
    public String getFolioDCP()
    {
        return getSemanticObject().getProperty(intranet_folioDCP);
    }

/**
* Sets the FolioDCP property
* @param value long with the FolioDCP
*/
    public void setFolioDCP(String value)
    {
        getSemanticObject().setProperty(intranet_folioDCP, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listResultadosEvaluacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasResultadosEvaluacion));
    }

   /**
   * Gets true if has a ResultadosEvaluacion
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasResultadosEvaluacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasResultadosEvaluacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ResultadosEvaluacion
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addResultadosEvaluacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasResultadosEvaluacion, value.getSemanticObject());
    }
   /**
   * Removes all the ResultadosEvaluacion
   */

    public void removeAllResultadosEvaluacion()
    {
        getSemanticObject().removeProperty(intranet_hasResultadosEvaluacion);
    }
   /**
   * Removes a ResultadosEvaluacion
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeResultadosEvaluacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasResultadosEvaluacion,value.getSemanticObject());
    }

   /**
   * Gets the ResultadosEvaluacion
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getResultadosEvaluacion()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasResultadosEvaluacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listSolicitudRegistros()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasSolicitudRegistro));
    }

   /**
   * Gets true if has a SolicitudRegistro
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasSolicitudRegistro(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasSolicitudRegistro,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a SolicitudRegistro
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addSolicitudRegistro(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasSolicitudRegistro, value.getSemanticObject());
    }
   /**
   * Removes all the SolicitudRegistro
   */

    public void removeAllSolicitudRegistro()
    {
        getSemanticObject().removeProperty(intranet_hasSolicitudRegistro);
    }
   /**
   * Removes a SolicitudRegistro
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeSolicitudRegistro(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasSolicitudRegistro,value.getSemanticObject());
    }

   /**
   * Gets the SolicitudRegistro
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getSolicitudRegistro()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasSolicitudRegistro);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
}
