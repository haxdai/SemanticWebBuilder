package com.infotec.swb.resources.eventcalendar;

import java.util.Comparator;


public class Event extends com.infotec.swb.resources.eventcalendar.base.EventBase 
{
    public Event(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(getTitle()+","+getDescription()+","+getStart());
        return res.toString();
    }

    public static class EventSortByStartDate implements Comparator<Event>{
        public int compare(Event event1, Event event2) {
            return event1.getStart().compareTo( event2.getStart() );
        }
    }
}
