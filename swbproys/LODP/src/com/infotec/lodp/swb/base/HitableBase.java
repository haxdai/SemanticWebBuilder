package com.infotec.lodp.swb.base;

public interface HitableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty lodp_downloads=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#downloads");
    public static final org.semanticwb.platform.SemanticProperty lodp_lastDownload=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#lastDownload");
    public static final org.semanticwb.platform.SemanticProperty lodp_views=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#views");
    public static final org.semanticwb.platform.SemanticProperty lodp_lastView=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#lastView");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Hitable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Hitable");

    public long getDownloads();

    public void setDownloads(long value);

    public java.util.Date getLastDownload();

    public void setLastDownload(java.util.Date value);

    public long getViews();

    public void setViews(long value);

    public java.util.Date getLastView();

    public void setLastView(java.util.Date value);
}
