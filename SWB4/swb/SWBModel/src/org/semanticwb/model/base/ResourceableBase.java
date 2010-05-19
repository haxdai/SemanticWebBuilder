package org.semanticwb.model.base;

public interface ResourceableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_hasResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasResource");
    public static final org.semanticwb.platform.SemanticClass swb_Resourceable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resourceable");

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources();
    public boolean hasResource(org.semanticwb.model.Resource value);

    public void addResource(org.semanticwb.model.Resource value);

    public void removeAllResource();

    public void removeResource(org.semanticwb.model.Resource value);

    public org.semanticwb.model.Resource getResource();
}
