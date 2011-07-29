package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;


   /**
   * Eventos de ProMéxico 
   */
public class Event extends org.semanticwb.promexico.base.EventBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Event.class, new EventParser());
    }

    public Event(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
