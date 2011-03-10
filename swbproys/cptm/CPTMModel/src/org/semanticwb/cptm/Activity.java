package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;


public class Activity extends org.semanticwb.cptm.base.ActivityBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Activity.class, new ActivityParser());
    }

    public Activity(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
