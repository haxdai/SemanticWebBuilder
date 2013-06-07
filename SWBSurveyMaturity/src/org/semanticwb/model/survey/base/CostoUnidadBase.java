package org.semanticwb.model.survey.base;

public interface CostoUnidadBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_del_Portafolio_de_Servicios_Propios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_del_Portafolio_de_Servicios_Propios");
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_del_Portafolio_de_servicios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_del_Portafolio_de_servicios");
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_del_Portafolio_de_Servicios_de_Gestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_del_Portafolio_de_Servicios_de_Gestion");
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_del_Portafolio_de_Servicios_de_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_del_Portafolio_de_Servicios_de_Proyecto");
    public static final org.semanticwb.platform.SemanticProperty cts_Costos_del_Portafolio_de_Servicios_al_Usuario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#Costos_del_Portafolio_de_Servicios_al_Usuario");
    public static final org.semanticwb.platform.SemanticClass cts_CostoUnidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoUnidad");

    public int getCostos_del_Portafolio_de_Servicios_Propios();

    public void setCostos_del_Portafolio_de_Servicios_Propios(int value);

    public int getCostos_del_Portafolio_de_servicios();

    public void setCostos_del_Portafolio_de_servicios(int value);

    public int getCostos_del_Portafolio_de_Servicios_de_Gestion();

    public void setCostos_del_Portafolio_de_Servicios_de_Gestion(int value);

    public int getCostos_del_Portafolio_de_Servicios_de_Proyecto();

    public void setCostos_del_Portafolio_de_Servicios_de_Proyecto(int value);

    public int getCostos_del_Portafolio_de_Servicios_al_Usuario();

    public void setCostos_del_Portafolio_de_Servicios_al_Usuario(int value);
}
