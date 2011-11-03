package com.infotec.eworkplace.swb.base;

public interface InstitucionBase extends org.semanticwb.model.GenericObject
{
   /**
   * Fecha en la que se concluyó el curso 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_fin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#fin");
   /**
   * Nombre del documentos obtenido 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_documentoObtenido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#documentoObtenido");
   /**
   * Fecha en la que se inició el curso 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_inicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#inicio");
   /**
   * Escuela donde se obtuvo el grado académico 
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#institucion");
    public static final org.semanticwb.platform.SemanticClass ewp_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Institucion");

    public java.util.Date getFin();

    public void setFin(java.util.Date value);

    public String getDocumentoObtenido();

    public void setDocumentoObtenido(String value);

    public java.util.Date getInicio();

    public void setInicio(java.util.Date value);

    public String getInstitucion();

    public void setInstitucion(String value);
}
