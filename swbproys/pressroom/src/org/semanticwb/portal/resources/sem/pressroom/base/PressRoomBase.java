package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class PressRoomBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass swbpress_PressRoom=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#PressRoom");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#PressRoom");

    public PressRoomBase()
    {
    }

    public PressRoomBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
