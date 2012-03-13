package com.infotec.eworkplace.swb;


public class Telefono extends com.infotec.eworkplace.swb.base.TelefonoBase 
{
    public enum TipoTelefono {
        home("lblHomePhone"),
        job("lblJobPhone"),
        mobile("lblMobilePhone"),
        other("lblOtherPhone");
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
}
