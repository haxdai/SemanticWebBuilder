package com.infotec.swb.resources.eventcalendar;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Event extends com.infotec.swb.resources.eventcalendar.base.EventBase implements Comparable
{
    public Event(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int compareTo(Object obj) throws ClassCastException {
        if (!(obj instanceof Event))
            throw new ClassCastException("Se esperaba un evento");
        Event event = (Event)obj;
        return this.getStart().compareTo(event.getStart());
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(getTitle()+","+getDescription()+","+getStart());
        return res.toString();
    }

    public static class EventSortByStartDate implements Comparator<Event>{
        @Override
        public int compare(Event event1, Event event2) {
            return event1.getStart().compareTo( event2.getStart() );
        }
    }
    
    
    public static String changeCharacters(String data)
    {
        if (data == null || data.trim().equals(""))
        {
            return data;
        }
        String changeCharacters = data.toLowerCase().trim();
        if (changeCharacters.indexOf("[") != -1)
        {
            changeCharacters = changeCharacters.replace('[', ' ');
        }
        if (changeCharacters.indexOf("]") != -1)
        {
            changeCharacters = changeCharacters.replace(']', ' ');
        }
        if (changeCharacters.indexOf("/") != -1)
        {
            changeCharacters = changeCharacters.replace('/', ' ');
        }
        if (changeCharacters.indexOf(";") != -1)
        {
            changeCharacters = changeCharacters.replace(';', ' ');
        }
        if (changeCharacters.indexOf(":") != -1)
        {
            changeCharacters = changeCharacters.replace(':', ' ');
        }
        if (changeCharacters.indexOf("-") != -1)
        {
            changeCharacters = changeCharacters.replace('-', ' ');
        }
        if (changeCharacters.indexOf(",") != -1)
        {
            changeCharacters = changeCharacters.replace(',', ' ');
        }
        changeCharacters = changeCharacters.replace('á', 'a');
        changeCharacters = changeCharacters.replace('é', 'e');
        changeCharacters = changeCharacters.replace('í', 'i');
        changeCharacters = changeCharacters.replace('ó', 'o');
        changeCharacters = changeCharacters.replace('ú', 'u');
        changeCharacters = changeCharacters.replace('à', 'a');
        changeCharacters = changeCharacters.replace('è', 'e');
        changeCharacters = changeCharacters.replace('ì', 'i');
        changeCharacters = changeCharacters.replace('ò', 'o');
        changeCharacters = changeCharacters.replace('ù', 'u');
        changeCharacters = changeCharacters.replace('ü', 'u');

        StringBuilder sb = new StringBuilder();
        boolean addSpace = true;
        for (char schar : changeCharacters.toCharArray())
        {
            if (schar == ' ')
            {
                if (addSpace)
                {
                    sb.append(schar);
                    addSpace = false;
                }
            }
            else
            {
                sb.append(schar);
                addSpace = true;
            }

        }
        return sb.toString().trim();
    }

    public static String getTitleURL(String title)
    {
        title = changeCharacters(title);

        StringBuilder sb = new StringBuilder();

        for (char s : title.toCharArray())
        {
            if (s == ' ')
            {
                sb.append('-');
            }
            else if (Character.isLetterOrDigit(s))
            {
                sb.append(s);
            }
            else
            {
                sb.append('-');
            }
        }
        return sb.toString();
    }
    
    public static Set<Integer> getMonths(List<com.infotec.swb.resources.eventcalendar.Event> eventos, int year)
    {

        HashSet<Integer> getYears = new HashSet<Integer>();
        for (Event event : eventos)
        {
            if( event.getStart()!=null && event.getStart().getYear()==year && event.isActive())
            {
                getYears.add(event.getStart().getMonth());
            }
        }
        return getYears;

    }

    public static Set<Event> getEvents(List<Event> eventos, int year, int month)
    {

        HashSet<Event> getYears = new HashSet<Event>();
        for (Event event : eventos)
        {
            if( event.isActive() && (event.getStart()!=null && event.getStart().getYear()==year && event.getStart().getMonth()==month || event.getEnd()!=null && event.getEnd().getYear()==year && event.getEnd().getMonth()==month) )
            {
                getYears.add(event);
            }
        }
        return getYears;

    }
}
