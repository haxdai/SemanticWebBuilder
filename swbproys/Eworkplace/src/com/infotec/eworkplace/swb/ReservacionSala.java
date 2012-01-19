package com.infotec.eworkplace.swb;

public class ReservacionSala extends com.infotec.eworkplace.swb.base.ReservacionSalaBase 
{
    public ReservacionSala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sala "+getSala().getDisplayTitle("es") +"; "+getSala().isReservada());
        sb.append("; User= "+getResponsable());
        sb.append("; de= "+getDe());
        sb.append("; a= "+getA());
        return sb.toString();
    }
}
