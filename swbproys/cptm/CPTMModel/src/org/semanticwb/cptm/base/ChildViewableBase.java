package org.semanticwb.cptm.base;

public interface ChildViewableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty cptm_showasChild=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#showasChild");
    public static final org.semanticwb.platform.SemanticClass cptm_ChildViewable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ChildViewable");

    public boolean isShowasChild();

    public void setShowasChild(boolean value);
}
