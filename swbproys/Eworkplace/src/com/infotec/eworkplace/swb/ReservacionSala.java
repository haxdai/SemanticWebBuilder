package com.infotec.eworkplace.swb;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;


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
        String lang = SWBContext.getSessionUser().getLanguage();
        Locale locale = new Locale(lang);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy HH:mm", locale);
        StringBuilder sb = new StringBuilder();
        sb.append(getSala().getDisplayTitle(lang));
        sb.append(", ");
        sb.append(getFolio());
        sb.append(", ");
        sb.append(sdf.format(getFechaInicio()));
        sb.append(", ");
        sb.append(sdf.format(getFechaFinal()));
        sb.append(", ");
        sb.append(getCreator().getFullName());
        sb.append(", ");
        sb.append(getMotivo());
        sb.append(", ");
        sb.append(getAsistentes());
        sb.append(", ");
        sb.append(getTipoReunion());
        if(isRequiereProyector()) {
            sb.append(", "+SWBUtils.TEXT.getLocaleString("com.infotec.eworkplace.swb.resources.sem.ReservaSalaManager", "lblRequireProjector", locale));
        }
        if(isRequiereComputo()) {
            sb.append(", "+SWBUtils.TEXT.getLocaleString("com.infotec.eworkplace.swb.resources.sem.ReservaSalaManager", "lblRequireComputer", locale));
        }
        return sb.toString();
    }
}
