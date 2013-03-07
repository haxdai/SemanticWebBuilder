package com.infotec.eworkplace.swb;

import com.infotec.eworkplace.swb.base.ReservacionSalaBase;
import java.util.Calendar;
import java.util.Iterator;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBModel;


public class Sala extends com.infotec.eworkplace.swb.base.SalaBase 
{
    public Sala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public boolean isReservada(final Calendar begin, final Calendar end)
    {
        return isReservada(begin.getTime(), end.getTime(), end.getTime().getHours(), end.getTime().getMinutes());
    }
    
    private synchronized boolean isReservada(final java.util.Date begin, final java.util.Date end, final int hours, final int minutes)
    {
        if( begin.getDate()==end.getDate() && begin.getMonth()==end.getMonth() && begin.getYear()==end.getYear() )
        {
            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();
            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(end)>=0) ||
                        (inicio.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<0) ||
                        (begin.compareTo(inicio.getTime())<=0 && end.compareTo(inicio.getTime())>0 && end.compareTo(fin.getTime())<=0) ||
                        (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<=0)) {
                        return true;
                    }
                    inicio.add(Calendar.DATE, 1);
                    fin.add(Calendar.DATE, 1);
                }
            }
        }
        else
        {
            Calendar cbegin = Calendar.getInstance();
            cbegin.setTime(begin);
            Calendar cend = Calendar.getInstance();
            cend.setTime(begin);
            cend.set(Calendar.HOUR_OF_DAY, hours);
            cend.set(Calendar.MINUTE, minutes);

            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();
            
            ReservacionSala reservation;
            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext())
            {
                reservation = reservations.next();
                
                if(reservation.getFechaFinal().compareTo(begin)<0 || reservation.getFechaInicio().compareTo(end)>=0) {
                    continue;										
                }
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(java.util.Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(java.util.Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if(inicio.get(java.util.Calendar.HOUR_OF_DAY)<cend.get(java.util.Calendar.HOUR_OF_DAY) && inicio.get(java.util.Calendar.MINUTE)<cend.get(java.util.Calendar.MINUTE))
                    {
                        if(fin.get(java.util.Calendar.HOUR_OF_DAY)>cbegin.get(java.util.Calendar.HOUR_OF_DAY) && fin.get(java.util.Calendar.MINUTE)>cbegin.get(java.util.Calendar.MINUTE)) {
                            return true;
                        }
                    }
                    cbegin.add(java.util.Calendar.DATE, 1);
                    cend.add(java.util.Calendar.DATE, 1);
                    inicio.add(java.util.Calendar.DATE, 1);
                    fin.add(java.util.Calendar.DATE, 1);
                }
                /*inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(end)>=0) ||
                        (inicio.getTime().compareTo(begin)>=0 && fin.getTime().compareTo(end)<=0) ||
                        (begin.compareTo(inicio.getTime())<0 && end.compareTo(inicio.getTime())>0 && end.compareTo(fin.getTime())<0) ||
                        (inicio.getTime().compareTo(begin)<0 && fin.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<0)) {
                        return true;
                    }
                    cbegin.add(Calendar.DATE, 1);
                    cend.add(Calendar.DATE, 1);
                    inicio.add(Calendar.DATE, 1);
                    fin.add(Calendar.DATE, 1);
                }*/
            }
        }
        return false;
    }
    
    public ReservacionSala getReserva(final Calendar begin, final Calendar end)
    {
        return getReserva(begin.getTime(), end.getTime(), end.getTime().getHours(), end.getTime().getMinutes());
    }
    
    private synchronized ReservacionSala getReserva(final java.util.Date begin, final java.util.Date end, final int hours, final int minutes)
    {
        if( begin.getDate()==end.getDate() && begin.getMonth()==end.getMonth() && begin.getYear()==end.getYear() ) {
            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();
            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(end)>=0) ||
                        (inicio.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<0) ||
                        (begin.compareTo(inicio.getTime())<=0 && end.compareTo(inicio.getTime())>0 && end.compareTo(fin.getTime())<=0) ||
                        (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<=0)) {
                        return reservation;
                    }
                    inicio.add(Calendar.DATE, 1);
                    fin.add(Calendar.DATE, 1);
                }
            }
        }else {
            Calendar cbegin = Calendar.getInstance();
            cbegin.setTime(begin);
            Calendar cend = Calendar.getInstance();
            cend.setTime(begin);
            cend.set(Calendar.HOUR_OF_DAY, hours);
            cend.set(Calendar.MINUTE, minutes);

            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();

            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(end)>=0) ||
                        (inicio.getTime().compareTo(begin)>=0 && fin.getTime().compareTo(end)<=0) ||
                        (begin.compareTo(inicio.getTime())<0 && end.compareTo(inicio.getTime())>0 && end.compareTo(fin.getTime())<0) ||
                        (inicio.getTime().compareTo(begin)<0 && fin.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<0)) {
                        return reservation;
                    }
                    cbegin.add(Calendar.DATE, 1);
                    cend.add(Calendar.DATE, 1);
                    inicio.add(Calendar.DATE, 1);
                    fin.add(Calendar.DATE, 1);
                }
            }
        }
        return null;
    }
    
    public boolean isReservada(final java.util.Date begin, final java.util.Date end) {
        boolean isReservada = false;
        Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        reservations = SWBComparator.sortByCreated(reservations, false);
        while(reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
            if( (reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0)||(reservation.getFechaInicio().compareTo(begin)<0 && reservation.getFechaFinal().compareTo(begin)>0)||(reservation.getFechaInicio().compareTo(end)<0 && reservation.getFechaFinal().compareTo(end)>0) ) {
                //if( begin.getHours()>=reservation.getFechaInicio().getHours() && begin.getMinutes()>=reservation.getFechaInicio().getMinutes() && end.getHours()<=reservation.getFechaFinal().getHours() && end.getMinutes()<=reservation.getFechaFinal().getMinutes() ) {
                if( tn(begin)>=tn(reservation.getFechaInicio()) && tn(end)<=tn(reservation.getFechaFinal()) ) {
                    isReservada = true;
                    break;
                }
            }
        }
        return isReservada;
    }
    
    public ReservacionSala getReserva(final java.util.Date begin, final java.util.Date end) {
        ReservacionSala reserva = null;
        Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        reservations = SWBComparator.sortByCreated(reservations, false);
        while(reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
            if( (reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0)||(reservation.getFechaInicio().compareTo(begin)<0 && reservation.getFechaFinal().compareTo(begin)>0)||(reservation.getFechaInicio().compareTo(end)<0 && reservation.getFechaFinal().compareTo(end)>0) ) {
                //if( begin.getHours()>=reservation.getFechaInicio().getHours() && begin.getMinutes()>=reservation.getFechaInicio().getMinutes() && end.getHours()<=reservation.getFechaFinal().getHours() && end.getMinutes()<=reservation.getFechaFinal().getMinutes() ) {
                if( tn(begin)>=tn(reservation.getFechaInicio()) && tn(end)<=tn(reservation.getFechaFinal()) ) {
                    reserva = reservation;
                    break;
                }
            }
        }
        return reserva;
    }
        
    private int tn(java.util.Date date){
        int tn = 0;
        tn = date.getHours()*60+date.getMinutes();
        return tn;
    }
}
