package org.semanticwb.cptm.base;

public interface CptmGeoBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cptm_cptm_latitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#cptm_latitude");
    public static final org.semanticwb.platform.SemanticProperty cptm_cptm_longitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#cptm_longitude");
    public static final org.semanticwb.platform.SemanticClass cptm_CptmGeo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#cptmGeo");

    public float getCptm_latitude();

    public void setCptm_latitude(float value);

    public float getCptm_longitude();

    public void setCptm_longitude(float value);
}
