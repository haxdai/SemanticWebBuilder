package mx.gob.inmujeres.swb.base;


public abstract class CuestionarioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_calificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#calificacion");
    public static final org.semanticwb.platform.SemanticClass inm_TipoRespuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoRespuesta");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p20=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p20");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p21=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p21");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p27=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p27");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI07=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI07");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI08=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI08");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p26=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p26");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p29=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p29");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI05=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI05");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p28=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p28");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI06=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI06");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p23=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p23");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI03=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI03");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p22=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p22");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI04=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI04");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p25=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p25");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI01=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI01");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p24=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p24");
    public static final org.semanticwb.platform.SemanticProperty inm_rI02=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI02");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p10=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p10");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI09=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI09");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p18=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p18");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI16=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI16");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p17=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p17");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI17=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI17");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p16=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p16");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI18=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI18");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p15=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p15");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI19=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI19");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p14=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p14");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI12=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI12");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p13=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p13");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI13=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI13");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI14=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI14");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p12=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p12");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI15=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI15");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p11=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p11");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI10=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI10");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI11=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI11");
   /**
   * Comentario
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p19=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p19");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p08=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p08");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p09=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p09");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI22=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI22");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI21=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI21");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI20=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI20");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI26=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI26");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p01=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p01");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI25=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI25");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI24=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI24");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p02=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p02");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p03=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p03");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI23=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI23");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p04=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p04");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI29=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI29");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p05=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p05");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI28=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI28");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p06=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p06");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p07=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p07");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI27=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI27");
    public static final org.semanticwb.platform.SemanticProperty inm_grupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#grupo");
    public static final org.semanticwb.platform.SemanticProperty inm_anioCuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#anioCuestionario");
    public static final org.semanticwb.platform.SemanticProperty inm_subgrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#subgrupo");
    public static final org.semanticwb.platform.SemanticProperty inm_observacionesCuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#observacionesCuestionario");
    public static final org.semanticwb.platform.SemanticClass inm_Cuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");

    public static class ClassMgr
    {
       /**
       * Returns a list of Cuestionario for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Cuestionario for all models
       * @return Iterator of mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario>(it, true);
        }

        public static mx.gob.inmujeres.swb.Cuestionario createCuestionario(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Cuestionario.ClassMgr.createCuestionario(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return A mx.gob.inmujeres.swb.Cuestionario
       */
        public static mx.gob.inmujeres.swb.Cuestionario getCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Cuestionario)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return A mx.gob.inmujeres.swb.Cuestionario
       */
        public static mx.gob.inmujeres.swb.Cuestionario createCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Cuestionario)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       */
        public static void removeCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return true if the mx.gob.inmujeres.swb.Cuestionario exists, false otherwise
       */

        public static boolean hasCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCuestionario(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P20
       * @param value P20 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP20(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p20, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P20
       * @param value P20 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP20(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p20,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P21
       * @param value P21 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP21(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p21, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P21
       * @param value P21 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP21(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p21,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P27
       * @param value P27 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP27(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p27, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P27
       * @param value P27 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP27(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p27,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P26
       * @param value P26 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP26(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p26, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P26
       * @param value P26 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP26(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p26,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P29
       * @param value P29 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP29(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p29, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P29
       * @param value P29 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP29(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p29,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P28
       * @param value P28 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP28(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p28, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P28
       * @param value P28 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP28(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p28,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P23
       * @param value P23 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP23(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p23, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P23
       * @param value P23 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP23(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p23,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P22
       * @param value P22 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP22(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p22, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P22
       * @param value P22 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP22(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p22,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P25
       * @param value P25 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP25(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p25, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P25
       * @param value P25 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP25(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p25,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P24
       * @param value P24 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP24(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p24, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P24
       * @param value P24 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP24(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p24,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P10
       * @param value P10 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP10(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p10, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P10
       * @param value P10 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP10(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p10,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P18
       * @param value P18 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP18(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p18, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P18
       * @param value P18 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP18(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p18,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P17
       * @param value P17 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP17(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p17, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P17
       * @param value P17 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP17(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p17,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P16
       * @param value P16 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP16(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p16, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P16
       * @param value P16 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP16(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p16,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P15
       * @param value P15 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP15(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p15, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P15
       * @param value P15 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP15(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p15,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P14
       * @param value P14 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP14(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p14, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P14
       * @param value P14 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP14(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p14,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P13
       * @param value P13 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP13(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p13, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P13
       * @param value P13 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP13(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p13,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P12
       * @param value P12 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP12(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p12, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P12
       * @param value P12 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP12(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p12,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P11
       * @param value P11 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP11(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p11, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P11
       * @param value P11 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP11(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p11,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P19
       * @param value P19 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP19(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p19, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P19
       * @param value P19 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP19(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p19,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P08
       * @param value P08 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP08(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p08, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P08
       * @param value P08 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP08(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p08,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P09
       * @param value P09 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP09(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p09, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P09
       * @param value P09 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP09(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p09,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P01
       * @param value P01 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP01(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p01, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P01
       * @param value P01 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP01(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p01,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P02
       * @param value P02 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP02(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p02, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P02
       * @param value P02 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP02(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p02,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P03
       * @param value P03 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP03(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p03, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P03
       * @param value P03 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP03(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p03,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P04
       * @param value P04 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP04(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p04, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P04
       * @param value P04 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP04(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p04,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P05
       * @param value P05 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP05(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p05, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P05
       * @param value P05 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP05(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p05,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P06
       * @param value P06 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP06(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p06, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P06
       * @param value P06 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP06(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p06,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P07
       * @param value P07 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP07(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_p07, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined P07
       * @param value P07 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByP07(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_p07,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CuestionarioBase.ClassMgr getCuestionarioClassMgr()
    {
        return new CuestionarioBase.ClassMgr();
    }

   /**
   * Constructs a CuestionarioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Cuestionario
   */
    public CuestionarioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Calificacion property
* @return String with the Calificacion
*/
    public String getCalificacion()
    {
        return getSemanticObject().getProperty(inm_calificacion);
    }

/**
* Sets the Calificacion property
* @param value long with the Calificacion
*/
    public void setCalificacion(String value)
    {
        getSemanticObject().setProperty(inm_calificacion, value);
    }
   /**
   * Sets the value for the property P20
   * @param value P20 to set
   */

    public void setP20(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p20, value.getSemanticObject());
        }else
        {
            removeP20();
        }
    }
   /**
   * Remove the value for P20 property
   */

    public void removeP20()
    {
        getSemanticObject().removeProperty(inm_p20);
    }

   /**
   * Gets the P20
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP20()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p20);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property P21
   * @param value P21 to set
   */

    public void setP21(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p21, value.getSemanticObject());
        }else
        {
            removeP21();
        }
    }
   /**
   * Remove the value for P21 property
   */

    public void removeP21()
    {
        getSemanticObject().removeProperty(inm_p21);
    }

   /**
   * Gets the P21
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP21()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p21);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property P27
   * @param value P27 to set
   */

    public void setP27(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p27, value.getSemanticObject());
        }else
        {
            removeP27();
        }
    }
   /**
   * Remove the value for P27 property
   */

    public void removeP27()
    {
        getSemanticObject().removeProperty(inm_p27);
    }

   /**
   * Gets the P27
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP27()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p27);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI07 property
* @return int with the RI07
*/
    public int getRI07()
    {
        return getSemanticObject().getIntProperty(inm_rI07);
    }

/**
* Sets the RI07 property
* @param value long with the RI07
*/
    public void setRI07(int value)
    {
        getSemanticObject().setIntProperty(inm_rI07, value);
    }

/**
* Gets the RI08 property
* @return int with the RI08
*/
    public int getRI08()
    {
        return getSemanticObject().getIntProperty(inm_rI08);
    }

/**
* Sets the RI08 property
* @param value long with the RI08
*/
    public void setRI08(int value)
    {
        getSemanticObject().setIntProperty(inm_rI08, value);
    }
   /**
   * Sets the value for the property P26
   * @param value P26 to set
   */

    public void setP26(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p26, value.getSemanticObject());
        }else
        {
            removeP26();
        }
    }
   /**
   * Remove the value for P26 property
   */

    public void removeP26()
    {
        getSemanticObject().removeProperty(inm_p26);
    }

   /**
   * Gets the P26
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP26()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p26);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
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
   * Sets the value for the property P29
   * @param value P29 to set
   */

    public void setP29(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p29, value.getSemanticObject());
        }else
        {
            removeP29();
        }
    }
   /**
   * Remove the value for P29 property
   */

    public void removeP29()
    {
        getSemanticObject().removeProperty(inm_p29);
    }

   /**
   * Gets the P29
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP29()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p29);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI05 property
* @return int with the RI05
*/
    public int getRI05()
    {
        return getSemanticObject().getIntProperty(inm_rI05);
    }

/**
* Sets the RI05 property
* @param value long with the RI05
*/
    public void setRI05(int value)
    {
        getSemanticObject().setIntProperty(inm_rI05, value);
    }
   /**
   * Sets the value for the property P28
   * @param value P28 to set
   */

    public void setP28(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p28, value.getSemanticObject());
        }else
        {
            removeP28();
        }
    }
   /**
   * Remove the value for P28 property
   */

    public void removeP28()
    {
        getSemanticObject().removeProperty(inm_p28);
    }

   /**
   * Gets the P28
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP28()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p28);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI06 property
* @return int with the RI06
*/
    public int getRI06()
    {
        return getSemanticObject().getIntProperty(inm_rI06);
    }

/**
* Sets the RI06 property
* @param value long with the RI06
*/
    public void setRI06(int value)
    {
        getSemanticObject().setIntProperty(inm_rI06, value);
    }
   /**
   * Sets the value for the property P23
   * @param value P23 to set
   */

    public void setP23(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p23, value.getSemanticObject());
        }else
        {
            removeP23();
        }
    }
   /**
   * Remove the value for P23 property
   */

    public void removeP23()
    {
        getSemanticObject().removeProperty(inm_p23);
    }

   /**
   * Gets the P23
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP23()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p23);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI03 property
* @return int with the RI03
*/
    public int getRI03()
    {
        return getSemanticObject().getIntProperty(inm_rI03);
    }

/**
* Sets the RI03 property
* @param value long with the RI03
*/
    public void setRI03(int value)
    {
        getSemanticObject().setIntProperty(inm_rI03, value);
    }
   /**
   * Sets the value for the property P22
   * @param value P22 to set
   */

    public void setP22(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p22, value.getSemanticObject());
        }else
        {
            removeP22();
        }
    }
   /**
   * Remove the value for P22 property
   */

    public void removeP22()
    {
        getSemanticObject().removeProperty(inm_p22);
    }

   /**
   * Gets the P22
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP22()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p22);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI04 property
* @return int with the RI04
*/
    public int getRI04()
    {
        return getSemanticObject().getIntProperty(inm_rI04);
    }

/**
* Sets the RI04 property
* @param value long with the RI04
*/
    public void setRI04(int value)
    {
        getSemanticObject().setIntProperty(inm_rI04, value);
    }
   /**
   * Sets the value for the property P25
   * @param value P25 to set
   */

    public void setP25(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p25, value.getSemanticObject());
        }else
        {
            removeP25();
        }
    }
   /**
   * Remove the value for P25 property
   */

    public void removeP25()
    {
        getSemanticObject().removeProperty(inm_p25);
    }

   /**
   * Gets the P25
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP25()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p25);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI01 property
* @return int with the RI01
*/
    public int getRI01()
    {
        return getSemanticObject().getIntProperty(inm_rI01);
    }

/**
* Sets the RI01 property
* @param value long with the RI01
*/
    public void setRI01(int value)
    {
        getSemanticObject().setIntProperty(inm_rI01, value);
    }
   /**
   * Sets the value for the property P24
   * @param value P24 to set
   */

    public void setP24(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p24, value.getSemanticObject());
        }else
        {
            removeP24();
        }
    }
   /**
   * Remove the value for P24 property
   */

    public void removeP24()
    {
        getSemanticObject().removeProperty(inm_p24);
    }

   /**
   * Gets the P24
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP24()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p24);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI02 property
* @return int with the RI02
*/
    public int getRI02()
    {
        return getSemanticObject().getIntProperty(inm_rI02);
    }

/**
* Sets the RI02 property
* @param value long with the RI02
*/
    public void setRI02(int value)
    {
        getSemanticObject().setIntProperty(inm_rI02, value);
    }
   /**
   * Sets the value for the property P10
   * @param value P10 to set
   */

    public void setP10(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p10, value.getSemanticObject());
        }else
        {
            removeP10();
        }
    }
   /**
   * Remove the value for P10 property
   */

    public void removeP10()
    {
        getSemanticObject().removeProperty(inm_p10);
    }

   /**
   * Gets the P10
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP10()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p10);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI09 property
* @return int with the RI09
*/
    public int getRI09()
    {
        return getSemanticObject().getIntProperty(inm_rI09);
    }

/**
* Sets the RI09 property
* @param value long with the RI09
*/
    public void setRI09(int value)
    {
        getSemanticObject().setIntProperty(inm_rI09, value);
    }
   /**
   * Sets the value for the property P18
   * @param value P18 to set
   */

    public void setP18(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p18, value.getSemanticObject());
        }else
        {
            removeP18();
        }
    }
   /**
   * Remove the value for P18 property
   */

    public void removeP18()
    {
        getSemanticObject().removeProperty(inm_p18);
    }

   /**
   * Gets the P18
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP18()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p18);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI16 property
* @return int with the RI16
*/
    public int getRI16()
    {
        return getSemanticObject().getIntProperty(inm_rI16);
    }

/**
* Sets the RI16 property
* @param value long with the RI16
*/
    public void setRI16(int value)
    {
        getSemanticObject().setIntProperty(inm_rI16, value);
    }
   /**
   * Sets the value for the property P17
   * @param value P17 to set
   */

    public void setP17(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p17, value.getSemanticObject());
        }else
        {
            removeP17();
        }
    }
   /**
   * Remove the value for P17 property
   */

    public void removeP17()
    {
        getSemanticObject().removeProperty(inm_p17);
    }

   /**
   * Gets the P17
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP17()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p17);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI17 property
* @return int with the RI17
*/
    public int getRI17()
    {
        return getSemanticObject().getIntProperty(inm_rI17);
    }

/**
* Sets the RI17 property
* @param value long with the RI17
*/
    public void setRI17(int value)
    {
        getSemanticObject().setIntProperty(inm_rI17, value);
    }
   /**
   * Sets the value for the property P16
   * @param value P16 to set
   */

    public void setP16(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p16, value.getSemanticObject());
        }else
        {
            removeP16();
        }
    }
   /**
   * Remove the value for P16 property
   */

    public void removeP16()
    {
        getSemanticObject().removeProperty(inm_p16);
    }

   /**
   * Gets the P16
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP16()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p16);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI18 property
* @return int with the RI18
*/
    public int getRI18()
    {
        return getSemanticObject().getIntProperty(inm_rI18);
    }

/**
* Sets the RI18 property
* @param value long with the RI18
*/
    public void setRI18(int value)
    {
        getSemanticObject().setIntProperty(inm_rI18, value);
    }
   /**
   * Sets the value for the property P15
   * @param value P15 to set
   */

    public void setP15(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p15, value.getSemanticObject());
        }else
        {
            removeP15();
        }
    }
   /**
   * Remove the value for P15 property
   */

    public void removeP15()
    {
        getSemanticObject().removeProperty(inm_p15);
    }

   /**
   * Gets the P15
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP15()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p15);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI19 property
* @return int with the RI19
*/
    public int getRI19()
    {
        return getSemanticObject().getIntProperty(inm_rI19);
    }

/**
* Sets the RI19 property
* @param value long with the RI19
*/
    public void setRI19(int value)
    {
        getSemanticObject().setIntProperty(inm_rI19, value);
    }
   /**
   * Sets the value for the property P14
   * @param value P14 to set
   */

    public void setP14(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p14, value.getSemanticObject());
        }else
        {
            removeP14();
        }
    }
   /**
   * Remove the value for P14 property
   */

    public void removeP14()
    {
        getSemanticObject().removeProperty(inm_p14);
    }

   /**
   * Gets the P14
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP14()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p14);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI12 property
* @return int with the RI12
*/
    public int getRI12()
    {
        return getSemanticObject().getIntProperty(inm_rI12);
    }

/**
* Sets the RI12 property
* @param value long with the RI12
*/
    public void setRI12(int value)
    {
        getSemanticObject().setIntProperty(inm_rI12, value);
    }
   /**
   * Sets the value for the property P13
   * @param value P13 to set
   */

    public void setP13(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p13, value.getSemanticObject());
        }else
        {
            removeP13();
        }
    }
   /**
   * Remove the value for P13 property
   */

    public void removeP13()
    {
        getSemanticObject().removeProperty(inm_p13);
    }

   /**
   * Gets the P13
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP13()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p13);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI13 property
* @return int with the RI13
*/
    public int getRI13()
    {
        return getSemanticObject().getIntProperty(inm_rI13);
    }

/**
* Sets the RI13 property
* @param value long with the RI13
*/
    public void setRI13(int value)
    {
        getSemanticObject().setIntProperty(inm_rI13, value);
    }

/**
* Gets the RI14 property
* @return int with the RI14
*/
    public int getRI14()
    {
        return getSemanticObject().getIntProperty(inm_rI14);
    }

/**
* Sets the RI14 property
* @param value long with the RI14
*/
    public void setRI14(int value)
    {
        getSemanticObject().setIntProperty(inm_rI14, value);
    }
   /**
   * Sets the value for the property P12
   * @param value P12 to set
   */

    public void setP12(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p12, value.getSemanticObject());
        }else
        {
            removeP12();
        }
    }
   /**
   * Remove the value for P12 property
   */

    public void removeP12()
    {
        getSemanticObject().removeProperty(inm_p12);
    }

   /**
   * Gets the P12
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP12()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p12);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI15 property
* @return int with the RI15
*/
    public int getRI15()
    {
        return getSemanticObject().getIntProperty(inm_rI15);
    }

/**
* Sets the RI15 property
* @param value long with the RI15
*/
    public void setRI15(int value)
    {
        getSemanticObject().setIntProperty(inm_rI15, value);
    }
   /**
   * Sets the value for the property P11
   * @param value P11 to set
   */

    public void setP11(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p11, value.getSemanticObject());
        }else
        {
            removeP11();
        }
    }
   /**
   * Remove the value for P11 property
   */

    public void removeP11()
    {
        getSemanticObject().removeProperty(inm_p11);
    }

   /**
   * Gets the P11
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP11()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p11);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI10 property
* @return int with the RI10
*/
    public int getRI10()
    {
        return getSemanticObject().getIntProperty(inm_rI10);
    }

/**
* Sets the RI10 property
* @param value long with the RI10
*/
    public void setRI10(int value)
    {
        getSemanticObject().setIntProperty(inm_rI10, value);
    }

/**
* Gets the RI11 property
* @return int with the RI11
*/
    public int getRI11()
    {
        return getSemanticObject().getIntProperty(inm_rI11);
    }

/**
* Sets the RI11 property
* @param value long with the RI11
*/
    public void setRI11(int value)
    {
        getSemanticObject().setIntProperty(inm_rI11, value);
    }
   /**
   * Sets the value for the property P19
   * @param value P19 to set
   */

    public void setP19(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p19, value.getSemanticObject());
        }else
        {
            removeP19();
        }
    }
   /**
   * Remove the value for P19 property
   */

    public void removeP19()
    {
        getSemanticObject().removeProperty(inm_p19);
    }

   /**
   * Gets the P19
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP19()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p19);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property P08
   * @param value P08 to set
   */

    public void setP08(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p08, value.getSemanticObject());
        }else
        {
            removeP08();
        }
    }
   /**
   * Remove the value for P08 property
   */

    public void removeP08()
    {
        getSemanticObject().removeProperty(inm_p08);
    }

   /**
   * Gets the P08
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP08()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p08);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property P09
   * @param value P09 to set
   */

    public void setP09(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p09, value.getSemanticObject());
        }else
        {
            removeP09();
        }
    }
   /**
   * Remove the value for P09 property
   */

    public void removeP09()
    {
        getSemanticObject().removeProperty(inm_p09);
    }

   /**
   * Gets the P09
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP09()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p09);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI22 property
* @return int with the RI22
*/
    public int getRI22()
    {
        return getSemanticObject().getIntProperty(inm_rI22);
    }

/**
* Sets the RI22 property
* @param value long with the RI22
*/
    public void setRI22(int value)
    {
        getSemanticObject().setIntProperty(inm_rI22, value);
    }

/**
* Gets the RI21 property
* @return int with the RI21
*/
    public int getRI21()
    {
        return getSemanticObject().getIntProperty(inm_rI21);
    }

/**
* Sets the RI21 property
* @param value long with the RI21
*/
    public void setRI21(int value)
    {
        getSemanticObject().setIntProperty(inm_rI21, value);
    }

/**
* Gets the RI20 property
* @return int with the RI20
*/
    public int getRI20()
    {
        return getSemanticObject().getIntProperty(inm_rI20);
    }

/**
* Sets the RI20 property
* @param value long with the RI20
*/
    public void setRI20(int value)
    {
        getSemanticObject().setIntProperty(inm_rI20, value);
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
* Gets the RI26 property
* @return int with the RI26
*/
    public int getRI26()
    {
        return getSemanticObject().getIntProperty(inm_rI26);
    }

/**
* Sets the RI26 property
* @param value long with the RI26
*/
    public void setRI26(int value)
    {
        getSemanticObject().setIntProperty(inm_rI26, value);
    }
   /**
   * Sets the value for the property P01
   * @param value P01 to set
   */

    public void setP01(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p01, value.getSemanticObject());
        }else
        {
            removeP01();
        }
    }
   /**
   * Remove the value for P01 property
   */

    public void removeP01()
    {
        getSemanticObject().removeProperty(inm_p01);
    }

   /**
   * Gets the P01
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP01()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p01);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI25 property
* @return int with the RI25
*/
    public int getRI25()
    {
        return getSemanticObject().getIntProperty(inm_rI25);
    }

/**
* Sets the RI25 property
* @param value long with the RI25
*/
    public void setRI25(int value)
    {
        getSemanticObject().setIntProperty(inm_rI25, value);
    }

/**
* Gets the RI24 property
* @return int with the RI24
*/
    public int getRI24()
    {
        return getSemanticObject().getIntProperty(inm_rI24);
    }

/**
* Sets the RI24 property
* @param value long with the RI24
*/
    public void setRI24(int value)
    {
        getSemanticObject().setIntProperty(inm_rI24, value);
    }
   /**
   * Sets the value for the property P02
   * @param value P02 to set
   */

    public void setP02(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p02, value.getSemanticObject());
        }else
        {
            removeP02();
        }
    }
   /**
   * Remove the value for P02 property
   */

    public void removeP02()
    {
        getSemanticObject().removeProperty(inm_p02);
    }

   /**
   * Gets the P02
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP02()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p02);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property P03
   * @param value P03 to set
   */

    public void setP03(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p03, value.getSemanticObject());
        }else
        {
            removeP03();
        }
    }
   /**
   * Remove the value for P03 property
   */

    public void removeP03()
    {
        getSemanticObject().removeProperty(inm_p03);
    }

   /**
   * Gets the P03
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP03()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p03);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI23 property
* @return int with the RI23
*/
    public int getRI23()
    {
        return getSemanticObject().getIntProperty(inm_rI23);
    }

/**
* Sets the RI23 property
* @param value long with the RI23
*/
    public void setRI23(int value)
    {
        getSemanticObject().setIntProperty(inm_rI23, value);
    }
   /**
   * Sets the value for the property P04
   * @param value P04 to set
   */

    public void setP04(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p04, value.getSemanticObject());
        }else
        {
            removeP04();
        }
    }
   /**
   * Remove the value for P04 property
   */

    public void removeP04()
    {
        getSemanticObject().removeProperty(inm_p04);
    }

   /**
   * Gets the P04
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP04()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p04);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI29 property
* @return int with the RI29
*/
    public int getRI29()
    {
        return getSemanticObject().getIntProperty(inm_rI29);
    }

/**
* Sets the RI29 property
* @param value long with the RI29
*/
    public void setRI29(int value)
    {
        getSemanticObject().setIntProperty(inm_rI29, value);
    }
   /**
   * Sets the value for the property P05
   * @param value P05 to set
   */

    public void setP05(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p05, value.getSemanticObject());
        }else
        {
            removeP05();
        }
    }
   /**
   * Remove the value for P05 property
   */

    public void removeP05()
    {
        getSemanticObject().removeProperty(inm_p05);
    }

   /**
   * Gets the P05
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP05()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p05);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI28 property
* @return int with the RI28
*/
    public int getRI28()
    {
        return getSemanticObject().getIntProperty(inm_rI28);
    }

/**
* Sets the RI28 property
* @param value long with the RI28
*/
    public void setRI28(int value)
    {
        getSemanticObject().setIntProperty(inm_rI28, value);
    }
   /**
   * Sets the value for the property P06
   * @param value P06 to set
   */

    public void setP06(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p06, value.getSemanticObject());
        }else
        {
            removeP06();
        }
    }
   /**
   * Remove the value for P06 property
   */

    public void removeP06()
    {
        getSemanticObject().removeProperty(inm_p06);
    }

   /**
   * Gets the P06
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP06()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p06);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property P07
   * @param value P07 to set
   */

    public void setP07(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_p07, value.getSemanticObject());
        }else
        {
            removeP07();
        }
    }
   /**
   * Remove the value for P07 property
   */

    public void removeP07()
    {
        getSemanticObject().removeProperty(inm_p07);
    }

   /**
   * Gets the P07
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getP07()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_p07);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the RI27 property
* @return int with the RI27
*/
    public int getRI27()
    {
        return getSemanticObject().getIntProperty(inm_rI27);
    }

/**
* Sets the RI27 property
* @param value long with the RI27
*/
    public void setRI27(int value)
    {
        getSemanticObject().setIntProperty(inm_rI27, value);
    }

/**
* Gets the Grupo property
* @return int with the Grupo
*/
    public int getGrupo()
    {
        return getSemanticObject().getIntProperty(inm_grupo);
    }

/**
* Sets the Grupo property
* @param value long with the Grupo
*/
    public void setGrupo(int value)
    {
        getSemanticObject().setIntProperty(inm_grupo, value);
    }

/**
* Gets the AnioCuestionario property
* @return int with the AnioCuestionario
*/
    public int getAnioCuestionario()
    {
        return getSemanticObject().getIntProperty(inm_anioCuestionario);
    }

/**
* Sets the AnioCuestionario property
* @param value long with the AnioCuestionario
*/
    public void setAnioCuestionario(int value)
    {
        getSemanticObject().setIntProperty(inm_anioCuestionario, value);
    }

/**
* Gets the Subgrupo property
* @return int with the Subgrupo
*/
    public int getSubgrupo()
    {
        return getSemanticObject().getIntProperty(inm_subgrupo);
    }

/**
* Sets the Subgrupo property
* @param value long with the Subgrupo
*/
    public void setSubgrupo(int value)
    {
        getSemanticObject().setIntProperty(inm_subgrupo, value);
    }

/**
* Gets the ObservacionesCuestionario property
* @return String with the ObservacionesCuestionario
*/
    public String getObservacionesCuestionario()
    {
        return getSemanticObject().getProperty(inm_observacionesCuestionario);
    }

/**
* Sets the ObservacionesCuestionario property
* @param value long with the ObservacionesCuestionario
*/
    public void setObservacionesCuestionario(String value)
    {
        getSemanticObject().setProperty(inm_observacionesCuestionario, value);
    }
}
