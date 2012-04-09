package com.infotec.eworkplace.swb;


public class ReservacionSala extends com.infotec.eworkplace.swb.base.ReservacionSalaBase 
{
    public enum TipoReunion {
        Interna,
        Externa
    }
    
    public enum Cafeteria {
        Sencilla,
        Especial
    }
    
    public enum Horario {
        Durante,
        Receso
    }
    
    public ReservacionSala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSala().getId());
        sb.append(", ");
        sb.append(getFechaInicio());
        sb.append(", ");
        sb.append(getFechaFinal());
        sb.append(", ");
        sb.append(getCreator().getFullName());
        sb.append(", ");
        sb.append(getMotivo());
        sb.append(", ");
        sb.append(getAsistentes());
        sb.append(", ");
        sb.append(getTipoReunion());
        sb.append(", proyector:"+isRequiereProyector());
        sb.append(", computo:"+isRequiereComputo());
        return sb.toString();
    }
}
