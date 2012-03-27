package com.infotec.eworkplace.swb;

import java.util.Iterator;


public class Telefono extends com.infotec.eworkplace.swb.base.TelefonoBase 
{
    public enum TipoTelefono {
        Fijo("lblHomePhone"),
        Trabajo("lblJobPhone"),
        Movil("lblMobilePhone"),
        Recados("lblOtherPhone");
        private String description;
        TipoTelefono(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
    }
    
    public Telefono(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(getLada()).append(",").append(getNumero()).append(",").append(getExtension()).append(",").append(getTipo());
        return s.toString();
    }
}
