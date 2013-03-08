package mx.gob.inmujeres.swb;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;


   /**
   * Representa una reservación de una sala de juntas 
   */
public class ApartadoSala extends mx.gob.inmujeres.swb.base.ApartadoSalaBase 
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
    
    public ApartadoSala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public String toString()
    {
        String lang = SWBContext.getSessionUser().getLanguage();
        Locale locale = new Locale(lang);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy HH:mm", locale);
        StringBuilder sb = new StringBuilder();
        sb.append(getSala().getDisplayTitle(lang));
        sb.append(", ");
        sb.append(sdf.format(getFechaInicio()));
        sb.append(", ");
        sb.append(sdf.format(getFechaFin()));
        sb.append(", ");
        sb.append(getCreator().getFullName());
        sb.append(", ");
        sb.append(getMotivoReunion());
        sb.append(", ");
        sb.append(getParticipantesInmujeres());
        if(getParticipantesOtros()>0) {
            sb.append(", ").append(getParticipantesOtros());
        }
        if(isRequiereProyector()) {
            sb.append(", ").append(SWBUtils.TEXT.getLocaleString("com.infotec.eworkplace.swb.resources.sem.ReservaSalaManager", "lblRequireProjector", locale));
        }
        return sb.toString();
    }
    
    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSala().getId());
        sb.append(", ");
        sb.append(getFechaInicio());
        sb.append(", ");
        sb.append(getFechaFin());
        sb.append(", ");
        sb.append(getCreator().getFullName());
        sb.append(", ");
//        sb.append(getMotivo());
//        sb.append(", ");
//        sb.append(getAsistentes());
//        sb.append(", ");
//        sb.append(getTipoReunion());
        sb.append(", proyector:"+isRequiereProyector());
//        sb.append(", computo:"+isRequiereComputo());
        return sb.toString();
    }*/
}
