package org.semanticwb.model.base;

public interface RuleableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass swb_Rule=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Rule");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRule=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRule");
    public static final org.semanticwb.platform.SemanticClass swb_Ruleable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Ruleable");

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule> listRules();
    public boolean hasRule(org.semanticwb.model.Rule value);

    public void addRule(org.semanticwb.model.Rule value);

    public void removeAllRule();

    public void removeRule(org.semanticwb.model.Rule value);

    public org.semanticwb.model.Rule getRule();
}
