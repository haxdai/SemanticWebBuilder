package org.semanticwb.portal.resources.sem.pressroom;

import org.semanticwb.SWBPortal;

public class Content extends org.semanticwb.portal.resources.sem.pressroom.base.ContentBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Content.class, new ContentParser());
    }
    public Content(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
