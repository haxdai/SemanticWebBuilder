package mx.gob.stps.portalempleo.swb;

import java.util.Comparator;


public class Event extends mx.gob.stps.portalempleo.swb.base.EventBase 
{
    public Event(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static class EventSortByExpiration implements Comparator<Event>{
        public int compare(Event event1, Event event2) {
            return event1.getExpiration().compareTo( event2.getExpiration() );
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(getTitle()+","+getDescription()+","+getExpiration());
        return res.toString();
    }
}
