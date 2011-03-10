package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos. 
   */
public class Event extends org.semanticwb.cptm.base.EventBase 
{
    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Event.class, new EventParser());
    }


    public Event(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
