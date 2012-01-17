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
//        sb.append("Sala "+getSala());
//        sb.append("; User= "+getResponsable());
        sb.append(" de= "+getDe()+", long="+getDe().getTime());
        sb.append("\n a= "+getA()+", long="+getA().getTime());
        return sb.toString();
    }
}
