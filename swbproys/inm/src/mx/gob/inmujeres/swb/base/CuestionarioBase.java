package mx.gob.inmujeres.swb.base;


public abstract class CuestionarioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_calificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#calificacion");
    public static final org.semanticwb.platform.SemanticClass inm_TipoRespuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoRespuesta");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r19=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r19");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r18=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r18");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r17=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r17");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r16=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r16");
   /**
   * REspuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r15=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r15");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p20=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p20");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r14=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r14");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p21=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p21");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r13=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r13");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r12=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r12");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r11=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r11");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r10=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r10");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI07=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI07");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p27=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p27");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI08=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI08");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p26=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p26");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI05=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI05");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p29=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p29");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI06=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI06");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p28=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p28");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI03=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI03");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p23=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p23");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI04=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI04");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p22=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p22");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI01=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI01");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p25=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p25");
    public static final org.semanticwb.platform.SemanticProperty inm_rI02=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI02");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p24=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p24");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r29=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r29");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r28=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r28");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r25=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r25");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r24=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r24");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p10=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p10");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r27=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r27");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r26=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r26");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r21=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r21");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI09=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI09");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r20=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r20");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r23=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r23");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r22=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r22");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI16=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI16");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p18=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p18");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI17=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI17");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p17=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p17");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI18=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI18");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p16=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p16");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI19=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI19");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p15=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p15");
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
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r04=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r04");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p09=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p09");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r05=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r05");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r02=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r02");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r03=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r03");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI22=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI22");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI21=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI21");
    public static final org.semanticwb.platform.SemanticProperty inm_r01=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r01");
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
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r08=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r08");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p04=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p04");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI29=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI29");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r09=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r09");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p05=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p05");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI28=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI28");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r06=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r06");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p06=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p06");
   /**
   * Respuesta ideal
   */
    public static final org.semanticwb.platform.SemanticProperty inm_rI27=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rI27");
   /**
   * Respuesta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_r07=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#r07");
   /**
   * Pregunta
   */
    public static final org.semanticwb.platform.SemanticProperty inm_p07=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#p07");
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
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R19
       * @param value R19 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR19(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r19, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R19
       * @param value R19 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR19(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r19,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R18
       * @param value R18 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR18(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r18, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R18
       * @param value R18 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR18(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r18,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R17
       * @param value R17 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR17(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r17, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R17
       * @param value R17 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR17(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r17,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R16
       * @param value R16 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR16(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r16, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R16
       * @param value R16 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR16(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r16,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R15
       * @param value R15 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR15(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r15, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R15
       * @param value R15 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR15(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r15,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R14
       * @param value R14 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR14(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r14, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R14
       * @param value R14 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR14(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r14,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R13
       * @param value R13 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR13(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r13, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R13
       * @param value R13 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR13(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r13,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R12
       * @param value R12 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR12(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r12, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R12
       * @param value R12 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR12(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r12,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R11
       * @param value R11 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR11(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r11, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R11
       * @param value R11 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR11(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r11,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R10
       * @param value R10 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR10(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r10, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R10
       * @param value R10 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR10(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r10,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R29
       * @param value R29 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR29(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r29, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R29
       * @param value R29 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR29(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r29,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R28
       * @param value R28 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR28(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r28, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R28
       * @param value R28 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR28(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r28,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R25
       * @param value R25 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR25(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r25, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R25
       * @param value R25 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR25(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r25,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R24
       * @param value R24 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR24(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r24, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R24
       * @param value R24 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR24(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r24,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R27
       * @param value R27 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR27(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r27, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R27
       * @param value R27 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR27(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r27,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R26
       * @param value R26 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR26(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r26, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R26
       * @param value R26 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR26(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r26,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R21
       * @param value R21 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR21(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r21, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R21
       * @param value R21 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR21(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r21,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R20
       * @param value R20 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR20(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r20, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R20
       * @param value R20 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR20(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r20,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R23
       * @param value R23 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR23(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r23, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R23
       * @param value R23 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR23(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r23,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R22
       * @param value R22 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR22(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r22, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R22
       * @param value R22 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR22(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r22,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R04
       * @param value R04 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR04(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r04, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R04
       * @param value R04 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR04(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r04,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R05
       * @param value R05 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR05(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r05, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R05
       * @param value R05 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR05(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r05,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R02
       * @param value R02 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR02(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r02, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R02
       * @param value R02 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR02(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r02,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R03
       * @param value R03 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR03(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r03, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R03
       * @param value R03 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR03(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r03,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R08
       * @param value R08 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR08(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r08, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R08
       * @param value R08 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR08(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r08,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R09
       * @param value R09 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR09(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r09, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R09
       * @param value R09 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR09(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r09,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R06
       * @param value R06 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR06(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r06, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R06
       * @param value R06 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR06(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r06,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R07
       * @param value R07 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR07(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_r07, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined R07
       * @param value R07 of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByR07(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_r07,value.getSemanticObject(),sclass));
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
   * Sets the value for the property R19
   * @param value R19 to set
   */

    public void setR19(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r19, value.getSemanticObject());
        }else
        {
            removeR19();
        }
    }
   /**
   * Remove the value for R19 property
   */

    public void removeR19()
    {
        getSemanticObject().removeProperty(inm_r19);
    }

   /**
   * Gets the R19
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR19()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r19);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R18
   * @param value R18 to set
   */

    public void setR18(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r18, value.getSemanticObject());
        }else
        {
            removeR18();
        }
    }
   /**
   * Remove the value for R18 property
   */

    public void removeR18()
    {
        getSemanticObject().removeProperty(inm_r18);
    }

   /**
   * Gets the R18
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR18()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r18);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R17
   * @param value R17 to set
   */

    public void setR17(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r17, value.getSemanticObject());
        }else
        {
            removeR17();
        }
    }
   /**
   * Remove the value for R17 property
   */

    public void removeR17()
    {
        getSemanticObject().removeProperty(inm_r17);
    }

   /**
   * Gets the R17
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR17()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r17);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R16
   * @param value R16 to set
   */

    public void setR16(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r16, value.getSemanticObject());
        }else
        {
            removeR16();
        }
    }
   /**
   * Remove the value for R16 property
   */

    public void removeR16()
    {
        getSemanticObject().removeProperty(inm_r16);
    }

   /**
   * Gets the R16
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR16()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r16);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R15
   * @param value R15 to set
   */

    public void setR15(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r15, value.getSemanticObject());
        }else
        {
            removeR15();
        }
    }
   /**
   * Remove the value for R15 property
   */

    public void removeR15()
    {
        getSemanticObject().removeProperty(inm_r15);
    }

   /**
   * Gets the R15
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR15()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r15);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P20 property
* @return String with the P20
*/
    public String getP20()
    {
        return getSemanticObject().getProperty(inm_p20);
    }

/**
* Sets the P20 property
* @param value long with the P20
*/
    public void setP20(String value)
    {
        getSemanticObject().setProperty(inm_p20, value);
    }
   /**
   * Sets the value for the property R14
   * @param value R14 to set
   */

    public void setR14(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r14, value.getSemanticObject());
        }else
        {
            removeR14();
        }
    }
   /**
   * Remove the value for R14 property
   */

    public void removeR14()
    {
        getSemanticObject().removeProperty(inm_r14);
    }

   /**
   * Gets the R14
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR14()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r14);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P21 property
* @return String with the P21
*/
    public String getP21()
    {
        return getSemanticObject().getProperty(inm_p21);
    }

/**
* Sets the P21 property
* @param value long with the P21
*/
    public void setP21(String value)
    {
        getSemanticObject().setProperty(inm_p21, value);
    }
   /**
   * Sets the value for the property R13
   * @param value R13 to set
   */

    public void setR13(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r13, value.getSemanticObject());
        }else
        {
            removeR13();
        }
    }
   /**
   * Remove the value for R13 property
   */

    public void removeR13()
    {
        getSemanticObject().removeProperty(inm_r13);
    }

   /**
   * Gets the R13
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR13()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r13);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R12
   * @param value R12 to set
   */

    public void setR12(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r12, value.getSemanticObject());
        }else
        {
            removeR12();
        }
    }
   /**
   * Remove the value for R12 property
   */

    public void removeR12()
    {
        getSemanticObject().removeProperty(inm_r12);
    }

   /**
   * Gets the R12
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR12()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r12);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R11
   * @param value R11 to set
   */

    public void setR11(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r11, value.getSemanticObject());
        }else
        {
            removeR11();
        }
    }
   /**
   * Remove the value for R11 property
   */

    public void removeR11()
    {
        getSemanticObject().removeProperty(inm_r11);
    }

   /**
   * Gets the R11
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR11()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r11);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R10
   * @param value R10 to set
   */

    public void setR10(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r10, value.getSemanticObject());
        }else
        {
            removeR10();
        }
    }
   /**
   * Remove the value for R10 property
   */

    public void removeR10()
    {
        getSemanticObject().removeProperty(inm_r10);
    }

   /**
   * Gets the R10
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR10()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r10);
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
* Gets the P27 property
* @return String with the P27
*/
    public String getP27()
    {
        return getSemanticObject().getProperty(inm_p27);
    }

/**
* Sets the P27 property
* @param value long with the P27
*/
    public void setP27(String value)
    {
        getSemanticObject().setProperty(inm_p27, value);
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
* Gets the P26 property
* @return String with the P26
*/
    public String getP26()
    {
        return getSemanticObject().getProperty(inm_p26);
    }

/**
* Sets the P26 property
* @param value long with the P26
*/
    public void setP26(String value)
    {
        getSemanticObject().setProperty(inm_p26, value);
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
* Gets the P29 property
* @return String with the P29
*/
    public String getP29()
    {
        return getSemanticObject().getProperty(inm_p29);
    }

/**
* Sets the P29 property
* @param value long with the P29
*/
    public void setP29(String value)
    {
        getSemanticObject().setProperty(inm_p29, value);
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
* Gets the P28 property
* @return String with the P28
*/
    public String getP28()
    {
        return getSemanticObject().getProperty(inm_p28);
    }

/**
* Sets the P28 property
* @param value long with the P28
*/
    public void setP28(String value)
    {
        getSemanticObject().setProperty(inm_p28, value);
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
* Gets the P23 property
* @return String with the P23
*/
    public String getP23()
    {
        return getSemanticObject().getProperty(inm_p23);
    }

/**
* Sets the P23 property
* @param value long with the P23
*/
    public void setP23(String value)
    {
        getSemanticObject().setProperty(inm_p23, value);
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
* Gets the P22 property
* @return String with the P22
*/
    public String getP22()
    {
        return getSemanticObject().getProperty(inm_p22);
    }

/**
* Sets the P22 property
* @param value long with the P22
*/
    public void setP22(String value)
    {
        getSemanticObject().setProperty(inm_p22, value);
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
* Gets the P25 property
* @return String with the P25
*/
    public String getP25()
    {
        return getSemanticObject().getProperty(inm_p25);
    }

/**
* Sets the P25 property
* @param value long with the P25
*/
    public void setP25(String value)
    {
        getSemanticObject().setProperty(inm_p25, value);
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
* Gets the P24 property
* @return String with the P24
*/
    public String getP24()
    {
        return getSemanticObject().getProperty(inm_p24);
    }

/**
* Sets the P24 property
* @param value long with the P24
*/
    public void setP24(String value)
    {
        getSemanticObject().setProperty(inm_p24, value);
    }
   /**
   * Sets the value for the property R29
   * @param value R29 to set
   */

    public void setR29(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r29, value.getSemanticObject());
        }else
        {
            removeR29();
        }
    }
   /**
   * Remove the value for R29 property
   */

    public void removeR29()
    {
        getSemanticObject().removeProperty(inm_r29);
    }

   /**
   * Gets the R29
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR29()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r29);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R28
   * @param value R28 to set
   */

    public void setR28(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r28, value.getSemanticObject());
        }else
        {
            removeR28();
        }
    }
   /**
   * Remove the value for R28 property
   */

    public void removeR28()
    {
        getSemanticObject().removeProperty(inm_r28);
    }

   /**
   * Gets the R28
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR28()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r28);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R25
   * @param value R25 to set
   */

    public void setR25(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r25, value.getSemanticObject());
        }else
        {
            removeR25();
        }
    }
   /**
   * Remove the value for R25 property
   */

    public void removeR25()
    {
        getSemanticObject().removeProperty(inm_r25);
    }

   /**
   * Gets the R25
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR25()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r25);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R24
   * @param value R24 to set
   */

    public void setR24(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r24, value.getSemanticObject());
        }else
        {
            removeR24();
        }
    }
   /**
   * Remove the value for R24 property
   */

    public void removeR24()
    {
        getSemanticObject().removeProperty(inm_r24);
    }

   /**
   * Gets the R24
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR24()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r24);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P10 property
* @return String with the P10
*/
    public String getP10()
    {
        return getSemanticObject().getProperty(inm_p10);
    }

/**
* Sets the P10 property
* @param value long with the P10
*/
    public void setP10(String value)
    {
        getSemanticObject().setProperty(inm_p10, value);
    }
   /**
   * Sets the value for the property R27
   * @param value R27 to set
   */

    public void setR27(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r27, value.getSemanticObject());
        }else
        {
            removeR27();
        }
    }
   /**
   * Remove the value for R27 property
   */

    public void removeR27()
    {
        getSemanticObject().removeProperty(inm_r27);
    }

   /**
   * Gets the R27
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR27()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r27);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R26
   * @param value R26 to set
   */

    public void setR26(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r26, value.getSemanticObject());
        }else
        {
            removeR26();
        }
    }
   /**
   * Remove the value for R26 property
   */

    public void removeR26()
    {
        getSemanticObject().removeProperty(inm_r26);
    }

   /**
   * Gets the R26
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR26()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r26);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R21
   * @param value R21 to set
   */

    public void setR21(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r21, value.getSemanticObject());
        }else
        {
            removeR21();
        }
    }
   /**
   * Remove the value for R21 property
   */

    public void removeR21()
    {
        getSemanticObject().removeProperty(inm_r21);
    }

   /**
   * Gets the R21
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR21()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r21);
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
   * Sets the value for the property R20
   * @param value R20 to set
   */

    public void setR20(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r20, value.getSemanticObject());
        }else
        {
            removeR20();
        }
    }
   /**
   * Remove the value for R20 property
   */

    public void removeR20()
    {
        getSemanticObject().removeProperty(inm_r20);
    }

   /**
   * Gets the R20
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR20()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r20);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R23
   * @param value R23 to set
   */

    public void setR23(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r23, value.getSemanticObject());
        }else
        {
            removeR23();
        }
    }
   /**
   * Remove the value for R23 property
   */

    public void removeR23()
    {
        getSemanticObject().removeProperty(inm_r23);
    }

   /**
   * Gets the R23
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR23()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r23);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R22
   * @param value R22 to set
   */

    public void setR22(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r22, value.getSemanticObject());
        }else
        {
            removeR22();
        }
    }
   /**
   * Remove the value for R22 property
   */

    public void removeR22()
    {
        getSemanticObject().removeProperty(inm_r22);
    }

   /**
   * Gets the R22
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR22()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r22);
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
* Gets the P18 property
* @return String with the P18
*/
    public String getP18()
    {
        return getSemanticObject().getProperty(inm_p18);
    }

/**
* Sets the P18 property
* @param value long with the P18
*/
    public void setP18(String value)
    {
        getSemanticObject().setProperty(inm_p18, value);
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
* Gets the P17 property
* @return String with the P17
*/
    public String getP17()
    {
        return getSemanticObject().getProperty(inm_p17);
    }

/**
* Sets the P17 property
* @param value long with the P17
*/
    public void setP17(String value)
    {
        getSemanticObject().setProperty(inm_p17, value);
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
* Gets the P16 property
* @return String with the P16
*/
    public String getP16()
    {
        return getSemanticObject().getProperty(inm_p16);
    }

/**
* Sets the P16 property
* @param value long with the P16
*/
    public void setP16(String value)
    {
        getSemanticObject().setProperty(inm_p16, value);
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
* Gets the P15 property
* @return String with the P15
*/
    public String getP15()
    {
        return getSemanticObject().getProperty(inm_p15);
    }

/**
* Sets the P15 property
* @param value long with the P15
*/
    public void setP15(String value)
    {
        getSemanticObject().setProperty(inm_p15, value);
    }

/**
* Gets the P14 property
* @return String with the P14
*/
    public String getP14()
    {
        return getSemanticObject().getProperty(inm_p14);
    }

/**
* Sets the P14 property
* @param value long with the P14
*/
    public void setP14(String value)
    {
        getSemanticObject().setProperty(inm_p14, value);
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
* Gets the P13 property
* @return String with the P13
*/
    public String getP13()
    {
        return getSemanticObject().getProperty(inm_p13);
    }

/**
* Sets the P13 property
* @param value long with the P13
*/
    public void setP13(String value)
    {
        getSemanticObject().setProperty(inm_p13, value);
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
* Gets the P12 property
* @return String with the P12
*/
    public String getP12()
    {
        return getSemanticObject().getProperty(inm_p12);
    }

/**
* Sets the P12 property
* @param value long with the P12
*/
    public void setP12(String value)
    {
        getSemanticObject().setProperty(inm_p12, value);
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
* Gets the P11 property
* @return String with the P11
*/
    public String getP11()
    {
        return getSemanticObject().getProperty(inm_p11);
    }

/**
* Sets the P11 property
* @param value long with the P11
*/
    public void setP11(String value)
    {
        getSemanticObject().setProperty(inm_p11, value);
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
* Gets the P19 property
* @return String with the P19
*/
    public String getP19()
    {
        return getSemanticObject().getProperty(inm_p19);
    }

/**
* Sets the P19 property
* @param value long with the P19
*/
    public void setP19(String value)
    {
        getSemanticObject().setProperty(inm_p19, value);
    }

/**
* Gets the P08 property
* @return String with the P08
*/
    public String getP08()
    {
        return getSemanticObject().getProperty(inm_p08);
    }

/**
* Sets the P08 property
* @param value long with the P08
*/
    public void setP08(String value)
    {
        getSemanticObject().setProperty(inm_p08, value);
    }
   /**
   * Sets the value for the property R04
   * @param value R04 to set
   */

    public void setR04(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r04, value.getSemanticObject());
        }else
        {
            removeR04();
        }
    }
   /**
   * Remove the value for R04 property
   */

    public void removeR04()
    {
        getSemanticObject().removeProperty(inm_r04);
    }

   /**
   * Gets the R04
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR04()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r04);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P09 property
* @return String with the P09
*/
    public String getP09()
    {
        return getSemanticObject().getProperty(inm_p09);
    }

/**
* Sets the P09 property
* @param value long with the P09
*/
    public void setP09(String value)
    {
        getSemanticObject().setProperty(inm_p09, value);
    }
   /**
   * Sets the value for the property R05
   * @param value R05 to set
   */

    public void setR05(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r05, value.getSemanticObject());
        }else
        {
            removeR05();
        }
    }
   /**
   * Remove the value for R05 property
   */

    public void removeR05()
    {
        getSemanticObject().removeProperty(inm_r05);
    }

   /**
   * Gets the R05
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR05()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r05);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R02
   * @param value R02 to set
   */

    public void setR02(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r02, value.getSemanticObject());
        }else
        {
            removeR02();
        }
    }
   /**
   * Remove the value for R02 property
   */

    public void removeR02()
    {
        getSemanticObject().removeProperty(inm_r02);
    }

   /**
   * Gets the R02
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR02()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r02);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property R03
   * @param value R03 to set
   */

    public void setR03(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r03, value.getSemanticObject());
        }else
        {
            removeR03();
        }
    }
   /**
   * Remove the value for R03 property
   */

    public void removeR03()
    {
        getSemanticObject().removeProperty(inm_r03);
    }

   /**
   * Gets the R03
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR03()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r03);
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
   * Sets the value for the property R01
   * @param value R01 to set
   */

    public void setR01(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r01, value.getSemanticObject());
        }else
        {
            removeR01();
        }
    }
   /**
   * Remove the value for R01 property
   */

    public void removeR01()
    {
        getSemanticObject().removeProperty(inm_r01);
    }

   /**
   * Gets the R01
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR01()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r01);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
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
* Gets the P01 property
* @return String with the P01
*/
    public String getP01()
    {
        return getSemanticObject().getProperty(inm_p01);
    }

/**
* Sets the P01 property
* @param value long with the P01
*/
    public void setP01(String value)
    {
        getSemanticObject().setProperty(inm_p01, value);
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
* Gets the P02 property
* @return String with the P02
*/
    public String getP02()
    {
        return getSemanticObject().getProperty(inm_p02);
    }

/**
* Sets the P02 property
* @param value long with the P02
*/
    public void setP02(String value)
    {
        getSemanticObject().setProperty(inm_p02, value);
    }

/**
* Gets the P03 property
* @return String with the P03
*/
    public String getP03()
    {
        return getSemanticObject().getProperty(inm_p03);
    }

/**
* Sets the P03 property
* @param value long with the P03
*/
    public void setP03(String value)
    {
        getSemanticObject().setProperty(inm_p03, value);
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
   * Sets the value for the property R08
   * @param value R08 to set
   */

    public void setR08(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r08, value.getSemanticObject());
        }else
        {
            removeR08();
        }
    }
   /**
   * Remove the value for R08 property
   */

    public void removeR08()
    {
        getSemanticObject().removeProperty(inm_r08);
    }

   /**
   * Gets the R08
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR08()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r08);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P04 property
* @return String with the P04
*/
    public String getP04()
    {
        return getSemanticObject().getProperty(inm_p04);
    }

/**
* Sets the P04 property
* @param value long with the P04
*/
    public void setP04(String value)
    {
        getSemanticObject().setProperty(inm_p04, value);
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
   * Sets the value for the property R09
   * @param value R09 to set
   */

    public void setR09(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r09, value.getSemanticObject());
        }else
        {
            removeR09();
        }
    }
   /**
   * Remove the value for R09 property
   */

    public void removeR09()
    {
        getSemanticObject().removeProperty(inm_r09);
    }

   /**
   * Gets the R09
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR09()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r09);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P05 property
* @return String with the P05
*/
    public String getP05()
    {
        return getSemanticObject().getProperty(inm_p05);
    }

/**
* Sets the P05 property
* @param value long with the P05
*/
    public void setP05(String value)
    {
        getSemanticObject().setProperty(inm_p05, value);
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
   * Sets the value for the property R06
   * @param value R06 to set
   */

    public void setR06(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r06, value.getSemanticObject());
        }else
        {
            removeR06();
        }
    }
   /**
   * Remove the value for R06 property
   */

    public void removeR06()
    {
        getSemanticObject().removeProperty(inm_r06);
    }

   /**
   * Gets the R06
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR06()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r06);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P06 property
* @return String with the P06
*/
    public String getP06()
    {
        return getSemanticObject().getProperty(inm_p06);
    }

/**
* Sets the P06 property
* @param value long with the P06
*/
    public void setP06(String value)
    {
        getSemanticObject().setProperty(inm_p06, value);
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
   * Sets the value for the property R07
   * @param value R07 to set
   */

    public void setR07(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_r07, value.getSemanticObject());
        }else
        {
            removeR07();
        }
    }
   /**
   * Remove the value for R07 property
   */

    public void removeR07()
    {
        getSemanticObject().removeProperty(inm_r07);
    }

   /**
   * Gets the R07
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getR07()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_r07);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the P07 property
* @return String with the P07
*/
    public String getP07()
    {
        return getSemanticObject().getProperty(inm_p07);
    }

/**
* Sets the P07 property
* @param value long with the P07
*/
    public void setP07(String value)
    {
        getSemanticObject().setProperty(inm_p07, value);
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
