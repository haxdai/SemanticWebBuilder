package org.semanticwb.promexico.base;

public interface ProSearchAbleBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty promx_proSearchDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#proSearchDescription");
    public static final org.semanticwb.platform.SemanticClass promx_ProSearchAble=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProSearchAble");

    public String getProSearchDescription();

    public void setProSearchDescription(String value);

    public String getProSearchDescription(String lang);

    public String getDisplayProSearchDescription(String lang);

    public void setProSearchDescription(String proSearchDescription, String lang);
}
