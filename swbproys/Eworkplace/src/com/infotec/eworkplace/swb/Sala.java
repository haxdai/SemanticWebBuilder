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
    
    public boolean isReservada(final Calendar begin, final Calendar end) {
        return isReservada(begin.getTime(), end.getTime(), end.getTime().getHours(), end.getTime().getMinutes());
//        boolean isReservada = false;
//        Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
//        reservations = SWBComparator.sortByCreated(reservations, false);
//        while(reservations.hasNext()) {
//            ReservacionSala reservation = reservations.next();
//            if( (reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0)||(reservation.getFechaInicio().compareTo(begin)<0 && reservation.getFechaFinal().compareTo(begin)>0)||(reservation.getFechaInicio().compareTo(end)<0 && reservation.getFechaFinal().compareTo(end)>0) ) {
//                isReservada = true;
//                break;
//            }
//        }
//        return isReservada;
    }
    
    private boolean isReservada(final java.util.Date begin, final java.util.Date end, final int hours, final int minutes) {
        boolean isReservada = false;
        if( begin.getDate()==end.getDate() && begin.getMonth()==end.getMonth() && begin.getYear()==end.getYear() ) {
            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();

            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(Calendar.HOUR, reservation.getFechaFinal().getHours());
                fin.set(Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(end)>=0) ||
                        (inicio.getTime().compareTo(begin)<0 && fin.getTime().compareTo(begin)>0) ||
                        (inicio.getTime().compareTo(end)<0 && fin.getTime().compareTo(end)>0) ) {
                        return true;
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
//            cend.set(Calendar.HOUR, end.getHours());
            cend.set(Calendar.HOUR, hours);
//            cend.set(Calendar.MINUTE, end.getMinutes());
            cend.set(Calendar.MINUTE, minutes);

            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();

            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(Calendar.HOUR, reservation.getFechaFinal().getHours());
                fin.set(Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(cbegin.getTime())<=0 && fin.getTime().compareTo(cend.getTime())>=0) ||
                        (inicio.getTime().compareTo(cbegin.getTime())<0 && fin.getTime().compareTo(cbegin.getTime())>0) ||
                        (inicio.getTime().compareTo(cend.getTime())<0 && fin.getTime().compareTo(cend.getTime())>0) ) {
                        return true;
                    }
                    cbegin.add(Calendar.DATE, 1);
                    cend.add(Calendar.DATE, 1);
                    inicio.add(Calendar.DATE, 1);
                    fin.add(Calendar.DATE, 1);
                }
            }
        }
        return isReservada;
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
        
    private int tn(java.util.Date date){
        int tn = 0;
        tn = date.getHours()*60+date.getMinutes();
        return tn;
    }
}
