package com.infotec.eworkplace.swb;

import java.util.GregorianCalendar;
import java.util.Iterator;

public class Sala extends com.infotec.eworkplace.swb.base.SalaBase 
{
    public Sala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public boolean isReservada(GregorianCalendar ht) {
System.out.println("-----Sala "+getDisplayTitle("es"));
System.out.println("ht="+ht.getTime()+", long="+ht.getTimeInMillis());
        boolean reserved = false;
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalaBySala(this);
        while(!reserved && reservations.hasNext()) {
            ReservacionSala reservation = reservations.next();
System.out.print("**res**"+reservation);
            reserved = reservation.getDe().before(ht.getTime()) && reservation.getA().after(ht.getTime());
System.out.println("....res="+reserved);
        }
        return reserved;
    }
}
