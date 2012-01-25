package com.infotec.eworkplace.swb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import org.semanticwb.model.SWBModel;

public class Sala extends com.infotec.eworkplace.swb.base.SalaBase 
{
    public Sala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public boolean isReservada(GregorianCalendar cur, int begin, int end) {
        boolean isReservada = false;
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        while(!isReservada && reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
            isReservada = isReservada(reservation, cur, begin, end);
        }
        return isReservada;
    }

    public boolean isReservada(ReservacionSala reservation, GregorianCalendar current, int begin, int end) {
        if(reservation.getSala()!=this)
            return false;
        if(reservation.getFecha()==null)
            return false;
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.setTime(reservation.getFecha().getDate());
        synchronized(this) {
            boolean isReservada = isReservada() && fecha.get(Calendar.YEAR)==current.get(Calendar.YEAR) && fecha.get(Calendar.MONTH)==current.get(Calendar.MONTH) && fecha.get(Calendar.DATE)==current.get(Calendar.DATE);
            return isReservada && begin>=reservation.getDe() && reservation.getA()>=end;
        }
    }
    
    public boolean isReservada(com.infotec.eworkplace.swb.Date date, int begin, int end) {
        if(date==null)
            return false;
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalaByFecha(date, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        while(reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
            if(!reservation.getSala().equals(this))
                continue;
            if(isReservada() && begin>=reservation.getDe() && reservation.getA()>=end) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isReservada(ReservacionSala reservation, com.infotec.eworkplace.swb.Date date, int begin, int end) {
        if(!reservation.getSala().equals(this))
            return false;
        if(isReservada() && reservation.getSala().equals(this) && reservation.getFecha().equals(date) && begin>=reservation.getDe() && reservation.getA()>=end)
            return true;
        return false;
    } 
}
