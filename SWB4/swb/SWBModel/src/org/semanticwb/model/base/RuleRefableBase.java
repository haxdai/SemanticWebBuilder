package org.semanticwb.model.base;

public interface RuleRefableBase extends org.semanticwb.model.Referensable
{
    public static final org.semanticwb.platform.SemanticClass swb_RuleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RuleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRuleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRuleRef");
    public static final org.semanticwb.platform.SemanticClass swb_RuleRefable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RuleRefable");

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef> listRuleRefs();
    public boolean hasRuleRef(org.semanticwb.model.RuleRef ruleref);
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef> listInheritRuleRefs();

    public void addRuleRef(org.semanticwb.model.RuleRef ruleref);

    public void removeAllRuleRef();

    public void removeRuleRef(org.semanticwb.model.RuleRef ruleref);

    public org.semanticwb.model.RuleRef getRuleRef();
}
