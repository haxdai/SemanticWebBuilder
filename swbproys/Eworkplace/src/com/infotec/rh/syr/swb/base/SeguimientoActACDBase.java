package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de seguimiento al proceso ACD de RH 
   */
public abstract class SeguimientoActACDBase extends com.infotec.eworkplace.swb.Seguimiento implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Adminsitra las actividades para CCO; DCP, ACD de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_ActividadesArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ActividadesArea");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCartaDescriptiva=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCartaDescriptiva");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasEvaluacionAutoevaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasEvaluacionAutoevaluacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasMapaFuncional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasMapaFuncional");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDescripcionPerfiles=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDescripcionPerfiles");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasEstrategiasPlanDesarrollo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasEstrategiasPlanDesarrollo");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasEstandarCompetencias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasEstandarCompetencias");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPonderacionCriterios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPonderacionCriterios");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioACD=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioACD");
   /**
   * Encapsula las propiedades de seguimiento al proceso ACD de RH
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SeguimientoActACD=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoActACD");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SeguimientoActACD");

    public static class ClassMgr
    {
       /**
       * Returns a list of SeguimientoActACD for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.SeguimientoActACD for all models
       * @return Iterator of com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD>(it, true);
        }

        public static com.infotec.rh.syr.swb.SeguimientoActACD createSeguimientoActACD(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.SeguimientoActACD.ClassMgr.createSeguimientoActACD(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.SeguimientoActACD
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActACD
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return A com.infotec.rh.syr.swb.SeguimientoActACD
       */
        public static com.infotec.rh.syr.swb.SeguimientoActACD getSeguimientoActACD(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoActACD)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.SeguimientoActACD
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActACD
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return A com.infotec.rh.syr.swb.SeguimientoActACD
       */
        public static com.infotec.rh.syr.swb.SeguimientoActACD createSeguimientoActACD(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.SeguimientoActACD)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.SeguimientoActACD
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActACD
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       */
        public static void removeSeguimientoActACD(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.SeguimientoActACD
       * @param id Identifier for com.infotec.rh.syr.swb.SeguimientoActACD
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return true if the com.infotec.rh.syr.swb.SeguimientoActACD exists, false otherwise
       */

        public static boolean hasSeguimientoActACD(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeguimientoActACD(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined CartaDescriptiva
       * @param value CartaDescriptiva of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByCartaDescriptiva(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCartaDescriptiva, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined CartaDescriptiva
       * @param value CartaDescriptiva of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByCartaDescriptiva(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCartaDescriptiva,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined EvaluacionAutoevaluacion
       * @param value EvaluacionAutoevaluacion of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByEvaluacionAutoevaluacion(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEvaluacionAutoevaluacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined EvaluacionAutoevaluacion
       * @param value EvaluacionAutoevaluacion of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByEvaluacionAutoevaluacion(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEvaluacionAutoevaluacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined MapaFuncional
       * @param value MapaFuncional of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByMapaFuncional(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasMapaFuncional, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined MapaFuncional
       * @param value MapaFuncional of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByMapaFuncional(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasMapaFuncional,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined DescripcionPerfiles
       * @param value DescripcionPerfiles of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByDescripcionPerfiles(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDescripcionPerfiles, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined DescripcionPerfiles
       * @param value DescripcionPerfiles of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByDescripcionPerfiles(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDescripcionPerfiles,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined EstrategiasPlanDesarrollo
       * @param value EstrategiasPlanDesarrollo of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByEstrategiasPlanDesarrollo(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstrategiasPlanDesarrollo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined EstrategiasPlanDesarrollo
       * @param value EstrategiasPlanDesarrollo of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByEstrategiasPlanDesarrollo(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstrategiasPlanDesarrollo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined EstandarCompetencias
       * @param value EstandarCompetencias of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByEstandarCompetencias(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstandarCompetencias, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined EstandarCompetencias
       * @param value EstandarCompetencias of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByEstandarCompetencias(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstandarCompetencias,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined PonderacionCriterios
       * @param value PonderacionCriterios of the type com.infotec.cvi.swb.ActividadesArea
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByPonderacionCriterios(com.infotec.cvi.swb.ActividadesArea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPonderacionCriterios, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined PonderacionCriterios
       * @param value PonderacionCriterios of the type com.infotec.cvi.swb.ActividadesArea
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByPonderacionCriterios(com.infotec.cvi.swb.ActividadesArea value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPonderacionCriterios,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.SeguimientoActACD
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.SeguimientoActACD with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.SeguimientoActACD
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.SeguimientoActACD> listSeguimientoActACDByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.SeguimientoActACD> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static SeguimientoActACDBase.ClassMgr getSeguimientoActACDClassMgr()
    {
        return new SeguimientoActACDBase.ClassMgr();
    }

   /**
   * Constructs a SeguimientoActACDBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SeguimientoActACD
   */
    public SeguimientoActACDBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.cvi.swb.ActividadesArea
   * @return A GenericIterator with all the com.infotec.cvi.swb.ActividadesArea
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listCartaDescriptivas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasCartaDescriptiva));
    }

   /**
   * Gets true if has a CartaDescriptiva
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasCartaDescriptiva(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCartaDescriptiva,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CartaDescriptiva
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addCartaDescriptiva(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCartaDescriptiva, value.getSemanticObject());
    }
   /**
   * Removes all the CartaDescriptiva
   */

    public void removeAllCartaDescriptiva()
    {
        getSemanticObject().removeProperty(intranet_hasCartaDescriptiva);
    }
   /**
   * Removes a CartaDescriptiva
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeCartaDescriptiva(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCartaDescriptiva,value.getSemanticObject());
    }

   /**
   * Gets the CartaDescriptiva
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getCartaDescriptiva()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCartaDescriptiva);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listEvaluacionAutoevaluacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasEvaluacionAutoevaluacion));
    }

   /**
   * Gets true if has a EvaluacionAutoevaluacion
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasEvaluacionAutoevaluacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasEvaluacionAutoevaluacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EvaluacionAutoevaluacion
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addEvaluacionAutoevaluacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasEvaluacionAutoevaluacion, value.getSemanticObject());
    }
   /**
   * Removes all the EvaluacionAutoevaluacion
   */

    public void removeAllEvaluacionAutoevaluacion()
    {
        getSemanticObject().removeProperty(intranet_hasEvaluacionAutoevaluacion);
    }
   /**
   * Removes a EvaluacionAutoevaluacion
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeEvaluacionAutoevaluacion(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasEvaluacionAutoevaluacion,value.getSemanticObject());
    }

   /**
   * Gets the EvaluacionAutoevaluacion
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getEvaluacionAutoevaluacion()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasEvaluacionAutoevaluacion);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listMapaFuncionals()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasMapaFuncional));
    }

   /**
   * Gets true if has a MapaFuncional
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasMapaFuncional(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasMapaFuncional,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MapaFuncional
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addMapaFuncional(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasMapaFuncional, value.getSemanticObject());
    }
   /**
   * Removes all the MapaFuncional
   */

    public void removeAllMapaFuncional()
    {
        getSemanticObject().removeProperty(intranet_hasMapaFuncional);
    }
   /**
   * Removes a MapaFuncional
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeMapaFuncional(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasMapaFuncional,value.getSemanticObject());
    }

   /**
   * Gets the MapaFuncional
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getMapaFuncional()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasMapaFuncional);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listDescripcionPerfileses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasDescripcionPerfiles));
    }

   /**
   * Gets true if has a DescripcionPerfiles
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasDescripcionPerfiles(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasDescripcionPerfiles,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a DescripcionPerfiles
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addDescripcionPerfiles(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDescripcionPerfiles, value.getSemanticObject());
    }
   /**
   * Removes all the DescripcionPerfiles
   */

    public void removeAllDescripcionPerfiles()
    {
        getSemanticObject().removeProperty(intranet_hasDescripcionPerfiles);
    }
   /**
   * Removes a DescripcionPerfiles
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeDescripcionPerfiles(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDescripcionPerfiles,value.getSemanticObject());
    }

   /**
   * Gets the DescripcionPerfiles
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getDescripcionPerfiles()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDescripcionPerfiles);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listEstrategiasPlanDesarrollos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasEstrategiasPlanDesarrollo));
    }

   /**
   * Gets true if has a EstrategiasPlanDesarrollo
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasEstrategiasPlanDesarrollo(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasEstrategiasPlanDesarrollo,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EstrategiasPlanDesarrollo
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addEstrategiasPlanDesarrollo(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasEstrategiasPlanDesarrollo, value.getSemanticObject());
    }
   /**
   * Removes all the EstrategiasPlanDesarrollo
   */

    public void removeAllEstrategiasPlanDesarrollo()
    {
        getSemanticObject().removeProperty(intranet_hasEstrategiasPlanDesarrollo);
    }
   /**
   * Removes a EstrategiasPlanDesarrollo
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeEstrategiasPlanDesarrollo(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasEstrategiasPlanDesarrollo,value.getSemanticObject());
    }

   /**
   * Gets the EstrategiasPlanDesarrollo
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getEstrategiasPlanDesarrollo()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasEstrategiasPlanDesarrollo);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listEstandarCompetenciases()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasEstandarCompetencias));
    }

   /**
   * Gets true if has a EstandarCompetencias
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasEstandarCompetencias(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasEstandarCompetencias,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EstandarCompetencias
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addEstandarCompetencias(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasEstandarCompetencias, value.getSemanticObject());
    }
   /**
   * Removes all the EstandarCompetencias
   */

    public void removeAllEstandarCompetencias()
    {
        getSemanticObject().removeProperty(intranet_hasEstandarCompetencias);
    }
   /**
   * Removes a EstandarCompetencias
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removeEstandarCompetencias(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasEstandarCompetencias,value.getSemanticObject());
    }

   /**
   * Gets the EstandarCompetencias
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getEstandarCompetencias()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasEstandarCompetencias);
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

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea> listPonderacionCriterioses()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ActividadesArea>(getSemanticObject().listObjectProperties(intranet_hasPonderacionCriterios));
    }

   /**
   * Gets true if has a PonderacionCriterios
   * @param value com.infotec.cvi.swb.ActividadesArea to verify
   * @return true if the com.infotec.cvi.swb.ActividadesArea exists, false otherwise
   */
    public boolean hasPonderacionCriterios(com.infotec.cvi.swb.ActividadesArea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPonderacionCriterios,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PonderacionCriterios
   * @param value com.infotec.cvi.swb.ActividadesArea to add
   */

    public void addPonderacionCriterios(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPonderacionCriterios, value.getSemanticObject());
    }
   /**
   * Removes all the PonderacionCriterios
   */

    public void removeAllPonderacionCriterios()
    {
        getSemanticObject().removeProperty(intranet_hasPonderacionCriterios);
    }
   /**
   * Removes a PonderacionCriterios
   * @param value com.infotec.cvi.swb.ActividadesArea to remove
   */

    public void removePonderacionCriterios(com.infotec.cvi.swb.ActividadesArea value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPonderacionCriterios,value.getSemanticObject());
    }

   /**
   * Gets the PonderacionCriterios
   * @return a com.infotec.cvi.swb.ActividadesArea
   */
    public com.infotec.cvi.swb.ActividadesArea getPonderacionCriterios()
    {
         com.infotec.cvi.swb.ActividadesArea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPonderacionCriterios);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.ActividadesArea)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FolioACD property
* @return String with the FolioACD
*/
    public String getFolioACD()
    {
        return getSemanticObject().getProperty(intranet_folioACD);
    }

/**
* Sets the FolioACD property
* @param value long with the FolioACD
*/
    public void setFolioACD(String value)
    {
        getSemanticObject().setProperty(intranet_folioACD, value);
    }
}
