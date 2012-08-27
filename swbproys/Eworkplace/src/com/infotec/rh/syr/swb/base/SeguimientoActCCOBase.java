package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de seguimiento al proceso CCO de RH 
   */
public abstract class SeguimientoActCCOBase extends com.infotec.eworkplace.swb.Seguimiento implements org.semanticwb.model.Traceable
{
   /**
   * Adminsitra las actividades para CCO; DCP, ACD de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_ActividadesArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ActividadesArea");
   /**
   * Reporte general final
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReporteGeneralFinal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReporteGeneralFinal");
   /**
   * Plan de mejora y/o Acción final
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPlanMejoraAccionPrevio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPlanMejoraAccionPrevio");
   /**
   * Bitácora de avances para CCO
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasBitacoraAvances=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasBitacoraAvances");
   /**
   * Reporte final
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReporteFinal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReporteFinal");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioCCO=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioCCO");
   /**
   * Plan de mejora y/o Acción final
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPlanMejoraAccionFinal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPlanMejoraAccionFinal");
   /**
   * Lista de requerimientos  para CCO
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasListaRequirimientos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasListaRequirimientos");
   /**
   * Reporte gráfica de resultados
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReporteGraficaResultados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReporteGraficaResultados");
   /**
   * Encapsula las propiedades de seguimiento al proceso CCO de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SeguimientoActCCO=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoActCCO");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoActCCO");

    public static class ClassMgr
    {
       /**
       * Returns a list of SeguimientoActCCO for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SeguimientoActCCO for all models
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO>(it, true);
        }

        public static com.infotec.rh.syr.swb.SeguimientoActCCO createSeguimientoActCCO(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SeguimientoActCCO.ClassMgr.createSeguimientoActCCO(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return A com.infotec.rh.syr.swb.SeguimientoActCCO
       */
        public static com.infotec.rh.syr.swb.SeguimientoActCCO getSeguimientoActCCO(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoActCCO)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return A com.infotec.rh.syr.swb.SeguimientoActCCO
       */
        public static com.infotec.rh.syr.swb.SeguimientoActCCO createSeguimientoActCCO(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoActCCO)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       */
        public static void removeSeguimientoActCCO(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActCCO
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return true if the com.infotec.rh.syr.swb.SeguimientoActCCO exists, false otherwise
       */

        public static boolean hasSeguimientoActCCO(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeguimientoActCCO(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ReporteGeneralFinal
       * @param value ReporteGeneralFinal of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByReporteGeneralFinal(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteGeneralFinal, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ReporteGeneralFinal
       * @param value ReporteGeneralFinal of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByReporteGeneralFinal(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteGeneralFinal,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined PlanMejoraAccionPrevio
       * @param value PlanMejoraAccionPrevio of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByPlanMejoraAccionPrevio(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanMejoraAccionPrevio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined PlanMejoraAccionPrevio
       * @param value PlanMejoraAccionPrevio of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByPlanMejoraAccionPrevio(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanMejoraAccionPrevio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined BitacoraAvances
       * @param value BitacoraAvances of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByBitacoraAvances(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasBitacoraAvances, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined BitacoraAvances
       * @param value BitacoraAvances of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByBitacoraAvances(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasBitacoraAvances,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ReporteFinal
       * @param value ReporteFinal of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByReporteFinal(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteFinal, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ReporteFinal
       * @param value ReporteFinal of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByReporteFinal(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteFinal,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined PlanMejoraAccionFinal
       * @param value PlanMejoraAccionFinal of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByPlanMejoraAccionFinal(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanMejoraAccionFinal, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined PlanMejoraAccionFinal
       * @param value PlanMejoraAccionFinal of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByPlanMejoraAccionFinal(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPlanMejoraAccionFinal,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ListaRequirimientos
       * @param value ListaRequirimientos of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByListaRequirimientos(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasListaRequirimientos, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ListaRequirimientos
       * @param value ListaRequirimientos of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByListaRequirimientos(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasListaRequirimientos,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ReporteGraficaResultados
       * @param value ReporteGraficaResultados of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActCCO
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByReporteGraficaResultados(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteGraficaResultados, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActCCO with a determined ReporteGraficaResultados
       * @param value ReporteGraficaResultados of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActCCO
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActCCO> listSeguimientoActCCOByReporteGraficaResultados(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActCCO> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasReporteGraficaResultados,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SeguimientoActCCOBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SeguimientoActCCO
   */
    public SeguimientoActCCOBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listReporteGeneralFinals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasReporteGeneralFinal));
    }

   /**
   * Gets true if has a ReporteGeneralFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasReporteGeneralFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReporteGeneralFinal,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReporteGeneralFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addReporteGeneralFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReporteGeneralFinal, value.getSemanticObject());
    }
   /**
   * Removes all the ReporteGeneralFinal
   */

    public void removeAllReporteGeneralFinal()
    {
        getSemanticObject().removeProperty(intranet_hasReporteGeneralFinal);
    }
   /**
   * Removes a ReporteGeneralFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeReporteGeneralFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReporteGeneralFinal,value.getSemanticObject());
    }

   /**
   * Gets the ReporteGeneralFinal
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getReporteGeneralFinal()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReporteGeneralFinal);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listPlanMejoraAccionPrevios()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasPlanMejoraAccionPrevio));
    }

   /**
   * Gets true if has a PlanMejoraAccionPrevio
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasPlanMejoraAccionPrevio(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPlanMejoraAccionPrevio,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PlanMejoraAccionPrevio
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addPlanMejoraAccionPrevio(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPlanMejoraAccionPrevio, value.getSemanticObject());
    }
   /**
   * Removes all the PlanMejoraAccionPrevio
   */

    public void removeAllPlanMejoraAccionPrevio()
    {
        getSemanticObject().removeProperty(intranet_hasPlanMejoraAccionPrevio);
    }
   /**
   * Removes a PlanMejoraAccionPrevio
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removePlanMejoraAccionPrevio(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPlanMejoraAccionPrevio,value.getSemanticObject());
    }

   /**
   * Gets the PlanMejoraAccionPrevio
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getPlanMejoraAccionPrevio()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPlanMejoraAccionPrevio);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listBitacoraAvanceses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasBitacoraAvances));
    }

   /**
   * Gets true if has a BitacoraAvances
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasBitacoraAvances(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasBitacoraAvances,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a BitacoraAvances
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addBitacoraAvances(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasBitacoraAvances, value.getSemanticObject());
    }
   /**
   * Removes all the BitacoraAvances
   */

    public void removeAllBitacoraAvances()
    {
        getSemanticObject().removeProperty(intranet_hasBitacoraAvances);
    }
   /**
   * Removes a BitacoraAvances
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeBitacoraAvances(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasBitacoraAvances,value.getSemanticObject());
    }

   /**
   * Gets the BitacoraAvances
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getBitacoraAvances()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasBitacoraAvances);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listReporteFinals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasReporteFinal));
    }

   /**
   * Gets true if has a ReporteFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasReporteFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReporteFinal,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReporteFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addReporteFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReporteFinal, value.getSemanticObject());
    }
   /**
   * Removes all the ReporteFinal
   */

    public void removeAllReporteFinal()
    {
        getSemanticObject().removeProperty(intranet_hasReporteFinal);
    }
   /**
   * Removes a ReporteFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeReporteFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReporteFinal,value.getSemanticObject());
    }

   /**
   * Gets the ReporteFinal
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getReporteFinal()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReporteFinal);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FolioCCO property
* @return String with the FolioCCO
*/
    public String getFolioCCO()
    {
        return getSemanticObject().getProperty(intranet_folioCCO);
    }

/**
* Sets the FolioCCO property
* @param value long with the FolioCCO
*/
    public void setFolioCCO(String value)
    {
        getSemanticObject().setProperty(intranet_folioCCO, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listPlanMejoraAccionFinals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasPlanMejoraAccionFinal));
    }

   /**
   * Gets true if has a PlanMejoraAccionFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasPlanMejoraAccionFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPlanMejoraAccionFinal,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PlanMejoraAccionFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addPlanMejoraAccionFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPlanMejoraAccionFinal, value.getSemanticObject());
    }
   /**
   * Removes all the PlanMejoraAccionFinal
   */

    public void removeAllPlanMejoraAccionFinal()
    {
        getSemanticObject().removeProperty(intranet_hasPlanMejoraAccionFinal);
    }
   /**
   * Removes a PlanMejoraAccionFinal
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removePlanMejoraAccionFinal(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPlanMejoraAccionFinal,value.getSemanticObject());
    }

   /**
   * Gets the PlanMejoraAccionFinal
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getPlanMejoraAccionFinal()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPlanMejoraAccionFinal);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listListaRequirimientoses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasListaRequirimientos));
    }

   /**
   * Gets true if has a ListaRequirimientos
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasListaRequirimientos(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasListaRequirimientos,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ListaRequirimientos
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addListaRequirimientos(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasListaRequirimientos, value.getSemanticObject());
    }
   /**
   * Removes all the ListaRequirimientos
   */

    public void removeAllListaRequirimientos()
    {
        getSemanticObject().removeProperty(intranet_hasListaRequirimientos);
    }
   /**
   * Removes a ListaRequirimientos
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeListaRequirimientos(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasListaRequirimientos,value.getSemanticObject());
    }

   /**
   * Gets the ListaRequirimientos
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getListaRequirimientos()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasListaRequirimientos);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listReporteGraficaResultadoses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasReporteGraficaResultados));
    }

   /**
   * Gets true if has a ReporteGraficaResultados
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasReporteGraficaResultados(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReporteGraficaResultados,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReporteGraficaResultados
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addReporteGraficaResultados(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReporteGraficaResultados, value.getSemanticObject());
    }
   /**
   * Removes all the ReporteGraficaResultados
   */

    public void removeAllReporteGraficaResultados()
    {
        getSemanticObject().removeProperty(intranet_hasReporteGraficaResultados);
    }
   /**
   * Removes a ReporteGraficaResultados
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeReporteGraficaResultados(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReporteGraficaResultados,value.getSemanticObject());
    }

   /**
   * Gets the ReporteGraficaResultados
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getReporteGraficaResultados()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReporteGraficaResultados);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }
}
