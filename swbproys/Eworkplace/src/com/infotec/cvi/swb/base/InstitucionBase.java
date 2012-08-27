package com.infotec.cvi.swb.base;

   /**
   * Interfaz que define las propiedades de la institución en donde son impartidos los Cursos, Diplomados y Grados Académicos 
   */
public interface InstitucionBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fin");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentoObtenido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentoObtenido");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreInstitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreInstitucion");
    public static final org.semanticwb.platform.SemanticProperty intranet_inicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#inicio");
   /**
   * Interfaz que define las propiedades de la institución en donde son impartidos los Cursos, Diplomados y Grados Académicos 
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Institucion");

    public int getFin();

    public void setFin(int value);

    public String getDocumentoObtenido();

    public void setDocumentoObtenido(String value);

    public String getNombreInstitucion();

    public void setNombreInstitucion(String value);

    public int getInicio();

    public void setInicio(int value);
}
