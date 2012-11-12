package mx.gob.inmujeres.swb;


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
    }
}
