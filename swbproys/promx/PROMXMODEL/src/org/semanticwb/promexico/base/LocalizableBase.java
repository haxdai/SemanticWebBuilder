package org.semanticwb.promexico.base;

public interface LocalizableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty promx_longitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#longitude");
    public static final org.semanticwb.platform.SemanticProperty promx_latitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#latitude");
    public static final org.semanticwb.platform.SemanticClass promx_Localizable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Localizable");

    public double getLongitude();

    public void setLongitude(double value);

    public double getLatitude();

    public void setLatitude(double value);
}
