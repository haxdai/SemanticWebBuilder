package com.infotec.eworkplace.swb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Sala extends com.infotec.eworkplace.swb.base.SalaBase 
{
    public Sala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public boolean isReservada(GregorianCalendar cur, int begin, int end) {
        boolean reserved = false;
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalaBySala(this);
        while(!reserved && reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
            reserved = this.isReservada(reservation, cur, begin, end);
        }
        return reserved;
    }

    public boolean isReservada(ReservacionSala reservation, GregorianCalendar current, int begin, int end) {
        if(reservation.getSala()!=this)
            return false;
        if(reservation.getFecha()==null)
            return false;
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.setTime(reservation.getFecha());
        boolean reservedOnDate = fecha.get(Calendar.YEAR)==current.get(Calendar.YEAR) && fecha.get(Calendar.MONTH)==current.get(Calendar.MONTH) && fecha.get(Calendar.DATE)==current.get(Calendar.DATE);
        return reservedOnDate && begin>=reservation.getDe() && reservation.getA()>=end;
        
    }
}
