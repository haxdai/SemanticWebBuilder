package mx.gob.stps.portalempleo.swb;

import java.util.GregorianCalendar;


public class Month extends mx.gob.stps.portalempleo.swb.base.MonthBase {

    public enum MonthOfYear {
        Enero("Enero"),
        Febrero("Febrero"),
        Marzo("Marzo"),
        Abril("Abril"),
        Mayo("Mayo"),
        Junio("Junio"),
        Julio("Julio"),
        Agosto("Agosto"),
        Septiembre("Septiembre"),
        Octubre("Octubre"),
        Noviembre("Noviembre"),
        Diciembre("Diciembre");
        private String description;
        MonthOfYear(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
        public MonthOfYear next() {
            switch(this) {
                case Enero:
                    return Febrero;
                case Febrero:
                    return Marzo;
                case Marzo:
                    return Abril;
                case Abril:
                    return Mayo;
                case Mayo:
                    return Junio;
                case Junio:
                    return Julio;
                case Julio:
                    return Agosto;
                case Agosto:
                    return Septiembre;
                case Septiembre:
                    return Octubre;
                case Octubre:
                    return Noviembre;
                case Noviembre:
                    return Diciembre;
                default:
                    return null;
            }
        }
        public boolean hasNext() {
            switch(this) {
                case Diciembre:
                    return false;
                default:
                    return true;
            }
        }
    }

    public Month(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
