package com.infotec.eworkplace.swb.base;

public interface PeriodoBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty intranet_periodoYears=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#periodoYears");
    public static final org.semanticwb.platform.SemanticClass intranet_Periodo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Periodo");

    public int getPeriodoYears();

    public void setPeriodoYears(int value);
}
