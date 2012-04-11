package com.infotec.eworkplace.swb;

import com.infotec.eworkplace.swb.base.ReservacionSalaBase;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBModel;


public class Sala extends com.infotec.eworkplace.swb.base.SalaBase 
{
    public Sala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public boolean isReservada_(java.util.Date begin, java.util.Date end) {
        boolean isReservada = false;
        Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        reservations = SWBComparator.sortByCreated(reservations, false);
        while(reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
            if( (reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0)||(reservation.getFechaInicio().compareTo(begin)<0 && reservation.getFechaFinal().compareTo(begin)>0)||(reservation.getFechaInicio().compareTo(end)<0 && reservation.getFechaFinal().compareTo(end)>0) ) {
                isReservada = true;
                break;
            }
        }
        return isReservada;
    }
    
    public boolean isReservada(java.util.Date begin, java.util.Date end) {
/*System.out.println("\n\nbegin="+begin+", end="+end);*/
        boolean isReservada = false;
        Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        reservations = SWBComparator.sortByCreated(reservations, false);
        while(reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
/*System.out.println("....reservation inicio="+reservation.getFechaInicio()+", fin="+reservation.getFechaFinal());
System.out.println("....reservation.getFechaInicio().compareTo(begin)="+reservation.getFechaInicio().compareTo(begin));
System.out.println("....reservation.getFechaFinal().compareTo(end)="+reservation.getFechaFinal().compareTo(end));*/
            //if( reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0 ) {
            if( (reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0)||(reservation.getFechaInicio().compareTo(begin)<0 && reservation.getFechaFinal().compareTo(begin)>0)||(reservation.getFechaInicio().compareTo(end)<0 && reservation.getFechaFinal().compareTo(end)>0) ) {
/*System.out.println("......reserv.FechaIni().Hours()="+reservation.getFechaInicio().getHours()+", reserv.FechaIni().Minutes()="+reservation.getFechaInicio().getMinutes());
System.out.println("begin.getHours()="+begin.getHours()+", begin.getMinutes()="+begin.getMinutes());
System.out.println("end.getHours()="+end.getHours()+", end.getMinutes()="+end.getMinutes());*/
                //if( begin.getHours()>=reservation.getFechaInicio().getHours() && begin.getMinutes()>=reservation.getFechaInicio().getMinutes() && end.getHours()<=reservation.getFechaFinal().getHours() && end.getMinutes()<=reservation.getFechaFinal().getMinutes() ) {
                if( tn(begin)>=tn(reservation.getFechaInicio()) && tn(end)<=tn(reservation.getFechaFinal()) ) {
                    isReservada = true;
                    break;
                }
            }
        }
        return isReservada;
    }
    
    public boolean isReservadaPA(java.util.Date begin, java.util.Date end) {
System.out.println("\n\nbegin="+begin+", end="+end);
        boolean isReservada = false;
        Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        reservations = SWBComparator.sortByCreated(reservations, false);
        while(reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
System.out.println("....reservation inicio="+reservation.getFechaInicio()+", fin="+reservation.getFechaFinal());
System.out.println("....reservation.getFechaInicio().compareTo(begin)="+reservation.getFechaInicio().compareTo(begin));
System.out.println("....reservation.getFechaFinal().compareTo(end)="+reservation.getFechaFinal().compareTo(end));
            //if( reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0 ) {
            if( (reservation.getFechaInicio().compareTo(begin)<=0 && reservation.getFechaFinal().compareTo(end)>=0) ||
                (reservation.getFechaInicio().compareTo(begin)<0 && reservation.getFechaFinal().compareTo(begin)>0 && reservation.getFechaFinal().compareTo(end)<0) ||
                (reservation.getFechaInicio().compareTo(begin)>0 && reservation.getFechaInicio().compareTo(end)<0 && reservation.getFechaFinal().compareTo(end)>0) ) {
System.out.println("......reserv.FechaIni().Hours()="+reservation.getFechaInicio().getHours()+", reserv.FechaIni().Minutes()="+reservation.getFechaInicio().getMinutes());
System.out.println("begin.getHours()="+begin.getHours()+", begin.getMinutes()="+begin.getMinutes());
System.out.println("end.getHours()="+end.getHours()+", end.getMinutes()="+end.getMinutes());
                
                if(begin.getDate()==end.getDate() && begin.getMonth()==end.getMonth() && begin.getYear()==end.getYear()) {
                    isReservada = true;
                    break;
                }
                
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

            
    
    /*public boolean isReservada(Calendar cur, int begin, int end) {
        boolean isReservada = false;
        Iterator reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        while((!isReservada) && (reservations.hasNext())) {
            ReservacionSala reservation = (ReservacionSala)reservations.next();
            isReservada = isReservada(reservation, cur, begin, end);
        }
        return isReservada;
    }

    public boolean isReservada(Calendar cur, int begin) {
        boolean isReservada = false;
        Iterator reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(this, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
        while((!isReservada) && (reservations.hasNext())) {
            ReservacionSala reservation = (ReservacionSala)reservations.next();
            isReservada = isReservada(reservation, cur, begin, begin + 30);
        }
        return isReservada;
    }

    public boolean isReservada(ReservacionSala reservation, Calendar current, int begin, int end) {
        if(reservation.getSala() != this)
            return false;
        if(reservation.getFecha() == null)
            return false;
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.setTime(reservation.getFecha().getDate());
        synchronized(this) {
            boolean isReservada = (isReservada()) && (fecha.get(1) == current.get(1)) && (fecha.get(2) == current.get(2)) && (fecha.get(5) == current.get(5));
            return (isReservada) && (begin >= reservation.getDe()) && (reservation.getA() >= end);
        }
    }

  public boolean isReservada(Date date, int begin, int end) {
    if(date == null)
        return false;
    Iterator reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaByFecha(date, (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance());
    while(reservations.hasNext()) {
        ReservacionSala reservation = (ReservacionSala)reservations.next();
        if(!reservation.getSala().equals(this))
            continue;
        if((isReservada()) && (begin >= reservation.getDe()) && (reservation.getA() >= end))
            return true;
    }
    return false;
  }

  public boolean isReservada(ReservacionSala reservation, Date date, int begin, int end) {
    if(!reservation.getSala().equals(this))
        return false;
    return (isReservada()) && (reservation.getSala().equals(this)) && (reservation.getFecha().equals(date)) && (begin >= reservation.getDe()) && (reservation.getA() >= end);
  }*/
}
