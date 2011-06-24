package mx.gob.stps.portalempleo.swb;

import java.util.Comparator;

/**
 * Event es una WebPage especializada para representar la información de cualquier evento.
 * Permite administrar los datos relevantes como fechas y horarios del evento.
 *
 * @version 1.0.0
 * @author Carlos Ramos
 */

public class Event extends mx.gob.stps.portalempleo.swb.base.EventBase implements Comparable
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


    /**
     * EventSortByStartDate tiene como único propósito comparar las fechas de inicio de dos eventos cualesquiera.
     *
     * @version 1.0.0
     * @author Carlos Ramos
     */
    public static class EventSortByStartDate implements Comparator<Event>{
        public int compare(Event event1, Event event2) {
            return event1.getStart().compareTo( event2.getStart() );
        }
    }

    /**
     * Devuelve una cadena que representa un Evento. Consiste del título, la descripción y la fecha de inicio del evento, separados por coma.
     * @return       Una cadena de caractéres
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(getTitle()+","+getDescription()+","+getStart());
        return res.toString();
    }
}
