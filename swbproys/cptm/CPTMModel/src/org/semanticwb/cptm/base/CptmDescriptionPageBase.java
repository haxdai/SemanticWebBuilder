package org.semanticwb.cptm.base;

public interface CptmDescriptionPageBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cptm_cptmAbstractDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#cptmAbstractDescription");
    public static final org.semanticwb.platform.SemanticClass cptm_CptmDescriptionPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#cptmDescriptionPage");

    public String getCptmAbstractDescription();

    public void setCptmAbstractDescription(String value);

    public String getCptmAbstractDescription(String lang);

    public String getDisplayCptmAbstractDescription(String lang);

    public void setCptmAbstractDescription(String cptmAbstractDescription, String lang);
}
