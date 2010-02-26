package org.semanticwb.pymtur.base;


public abstract class MiPymesResourceBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymesResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymesResource");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymesResource");

    public MiPymesResourceBase()
    {
    }

    public MiPymesResourceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
