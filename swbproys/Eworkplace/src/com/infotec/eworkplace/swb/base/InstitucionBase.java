package com.infotec.eworkplace.swb.base;

public interface InstitucionBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fin");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentoObtenido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentoObtenido");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreInstitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreInstitucion");
    public static final org.semanticwb.platform.SemanticProperty intranet_inicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#inicio");
    public static final org.semanticwb.platform.SemanticClass intranet_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Institucion");

    public java.util.Date getFin();

    public void setFin(java.util.Date value);

    public String getDocumentoObtenido();

    public void setDocumentoObtenido(String value);

    public String getNombreInstitucion();

    public void setNombreInstitucion(String value);

    public java.util.Date getInicio();

    public void setInicio(java.util.Date value);
}
